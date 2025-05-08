package org.commonmark.parser;

import android.support.v4.media.session.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.commonmark.Extension;
import org.commonmark.internal.DocumentParser;
import org.commonmark.internal.InlineParserContextImpl;
import org.commonmark.internal.InlineParserImpl;
import org.commonmark.node.Block;
import org.commonmark.node.Node;
import org.commonmark.parser.block.BlockParserFactory;
import org.commonmark.parser.delimiter.DelimiterProcessor;

/* loaded from: classes3.dex */
public class Parser {
    private final List<BlockParserFactory> blockParserFactories;
    private final List<DelimiterProcessor> delimiterProcessors;
    private final InlineParserFactory inlineParserFactory;
    private final List<Object> postProcessors;

    /* loaded from: classes3.dex */
    public static class Builder {
        private InlineParserFactory inlineParserFactory;
        private final List<BlockParserFactory> blockParserFactories = new ArrayList();
        private final List<DelimiterProcessor> delimiterProcessors = new ArrayList();
        private final List<Object> postProcessors = new ArrayList();
        private Set<Class<? extends Block>> enabledBlockTypes = DocumentParser.getDefaultBlockParserTypes();

        /* JADX INFO: Access modifiers changed from: private */
        public InlineParserFactory getInlineParserFactory() {
            InlineParserFactory inlineParserFactory = this.inlineParserFactory;
            return inlineParserFactory != null ? inlineParserFactory : new InlineParserFactory() { // from class: org.commonmark.parser.Parser.Builder.1
                @Override // org.commonmark.parser.InlineParserFactory
                public InlineParser create(InlineParserContext inlineParserContext) {
                    return new InlineParserImpl(inlineParserContext);
                }
            };
        }

        public Parser build() {
            return new Parser(this);
        }

        public Builder customBlockParserFactory(BlockParserFactory blockParserFactory) {
            if (blockParserFactory == null) {
                throw new NullPointerException("blockParserFactory must not be null");
            }
            this.blockParserFactories.add(blockParserFactory);
            return this;
        }

        public Builder customDelimiterProcessor(DelimiterProcessor delimiterProcessor) {
            if (delimiterProcessor == null) {
                throw new NullPointerException("delimiterProcessor must not be null");
            }
            this.delimiterProcessors.add(delimiterProcessor);
            return this;
        }

        public Builder extensions(Iterable<? extends Extension> iterable) {
            if (iterable == null) {
                throw new NullPointerException("extensions must not be null");
            }
            for (Extension extension : iterable) {
                if (extension instanceof ParserExtension) {
                    ((ParserExtension) extension).extend(this);
                }
            }
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public interface ParserExtension extends Extension {
        void extend(Builder builder);
    }

    private DocumentParser createDocumentParser() {
        return new DocumentParser(this.blockParserFactories, this.inlineParserFactory, this.delimiterProcessors);
    }

    private Node postProcess(Node node) {
        Iterator<Object> it = this.postProcessors.iterator();
        if (!it.hasNext()) {
            return node;
        }
        a.a(it.next());
        throw null;
    }

    public Node parse(String str) {
        if (str != null) {
            return postProcess(createDocumentParser().parse(str));
        }
        throw new NullPointerException("input must not be null");
    }

    private Parser(Builder builder) {
        this.blockParserFactories = DocumentParser.calculateBlockParserFactories(builder.blockParserFactories, builder.enabledBlockTypes);
        InlineParserFactory inlineParserFactory = builder.getInlineParserFactory();
        this.inlineParserFactory = inlineParserFactory;
        this.postProcessors = builder.postProcessors;
        List<DelimiterProcessor> list = builder.delimiterProcessors;
        this.delimiterProcessors = list;
        inlineParserFactory.create(new InlineParserContextImpl(list, Collections.emptyMap()));
    }
}
