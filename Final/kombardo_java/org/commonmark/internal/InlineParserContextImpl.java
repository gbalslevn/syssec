package org.commonmark.internal;

import java.util.List;
import java.util.Map;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.parser.InlineParserContext;
import org.commonmark.parser.delimiter.DelimiterProcessor;

/* loaded from: classes3.dex */
public class InlineParserContextImpl implements InlineParserContext {
    private final List<DelimiterProcessor> delimiterProcessors;
    private final Map<String, LinkReferenceDefinition> linkReferenceDefinitions;

    public InlineParserContextImpl(List<DelimiterProcessor> list, Map<String, LinkReferenceDefinition> map) {
        this.delimiterProcessors = list;
        this.linkReferenceDefinitions = map;
    }

    @Override // org.commonmark.parser.InlineParserContext
    public List<DelimiterProcessor> getCustomDelimiterProcessors() {
        return this.delimiterProcessors;
    }

    @Override // org.commonmark.parser.InlineParserContext
    public LinkReferenceDefinition getLinkReferenceDefinition(String str) {
        return this.linkReferenceDefinitions.get(str);
    }
}
