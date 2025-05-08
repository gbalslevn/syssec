package org.commonmark.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.commonmark.internal.BlockQuoteParser;
import org.commonmark.internal.FencedCodeBlockParser;
import org.commonmark.internal.HeadingParser;
import org.commonmark.internal.HtmlBlockParser;
import org.commonmark.internal.IndentedCodeBlockParser;
import org.commonmark.internal.ListBlockParser;
import org.commonmark.internal.ThematicBreakParser;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.Document;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.ListBlock;
import org.commonmark.node.Paragraph;
import org.commonmark.node.ThematicBreak;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.InlineParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockParserFactory;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;
import org.commonmark.parser.delimiter.DelimiterProcessor;

/* loaded from: classes3.dex */
public class DocumentParser implements ParserState {
    private static final Set<Class<? extends Block>> CORE_FACTORY_TYPES = new LinkedHashSet(Arrays.asList(BlockQuote.class, Heading.class, FencedCodeBlock.class, HtmlBlock.class, ThematicBreak.class, ListBlock.class, IndentedCodeBlock.class));
    private static final Map<Class<? extends Block>, BlockParserFactory> NODES_TO_CORE_FACTORIES;
    private boolean blank;
    private final List<BlockParserFactory> blockParserFactories;
    private boolean columnIsInTab;
    private final List<DelimiterProcessor> delimiterProcessors;
    private final DocumentBlockParser documentBlockParser;
    private final InlineParserFactory inlineParserFactory;
    private CharSequence line;
    private int index = 0;
    private int column = 0;
    private int nextNonSpace = 0;
    private int nextNonSpaceColumn = 0;
    private int indent = 0;
    private final Map<String, LinkReferenceDefinition> definitions = new LinkedHashMap();
    private List<BlockParser> activeBlockParsers = new ArrayList();
    private Set<BlockParser> allBlockParsers = new LinkedHashSet();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class MatchedBlockParserImpl implements MatchedBlockParser {
        private final BlockParser matchedBlockParser;

        public MatchedBlockParserImpl(BlockParser blockParser) {
            this.matchedBlockParser = blockParser;
        }

        @Override // org.commonmark.parser.block.MatchedBlockParser
        public BlockParser getMatchedBlockParser() {
            return this.matchedBlockParser;
        }

        @Override // org.commonmark.parser.block.MatchedBlockParser
        public CharSequence getParagraphContent() {
            BlockParser blockParser = this.matchedBlockParser;
            if (!(blockParser instanceof ParagraphParser)) {
                return null;
            }
            CharSequence contentString = ((ParagraphParser) blockParser).getContentString();
            if (contentString.length() == 0) {
                return null;
            }
            return contentString;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(BlockQuote.class, new BlockQuoteParser.Factory());
        hashMap.put(Heading.class, new HeadingParser.Factory());
        hashMap.put(FencedCodeBlock.class, new FencedCodeBlockParser.Factory());
        hashMap.put(HtmlBlock.class, new HtmlBlockParser.Factory());
        hashMap.put(ThematicBreak.class, new ThematicBreakParser.Factory());
        hashMap.put(ListBlock.class, new ListBlockParser.Factory());
        hashMap.put(IndentedCodeBlock.class, new IndentedCodeBlockParser.Factory());
        NODES_TO_CORE_FACTORIES = Collections.unmodifiableMap(hashMap);
    }

    public DocumentParser(List<BlockParserFactory> list, InlineParserFactory inlineParserFactory, List<DelimiterProcessor> list2) {
        this.blockParserFactories = list;
        this.inlineParserFactory = inlineParserFactory;
        this.delimiterProcessors = list2;
        DocumentBlockParser documentBlockParser = new DocumentBlockParser();
        this.documentBlockParser = documentBlockParser;
        activateBlockParser(documentBlockParser);
    }

    private void activateBlockParser(BlockParser blockParser) {
        this.activeBlockParsers.add(blockParser);
        this.allBlockParsers.add(blockParser);
    }

    private <T extends BlockParser> T addChild(T t5) {
        while (!getActiveBlockParser().canContain(t5.getBlock())) {
            finalize(getActiveBlockParser());
        }
        getActiveBlockParser().getBlock().appendChild(t5.getBlock());
        activateBlockParser(t5);
        return t5;
    }

    private void addDefinitionsFrom(ParagraphParser paragraphParser) {
        for (LinkReferenceDefinition linkReferenceDefinition : paragraphParser.getDefinitions()) {
            paragraphParser.getBlock().insertBefore(linkReferenceDefinition);
            String label = linkReferenceDefinition.getLabel();
            if (!this.definitions.containsKey(label)) {
                this.definitions.put(label, linkReferenceDefinition);
            }
        }
    }

    private void addLine() {
        CharSequence subSequence;
        if (this.columnIsInTab) {
            int i5 = this.index + 1;
            CharSequence charSequence = this.line;
            CharSequence subSequence2 = charSequence.subSequence(i5, charSequence.length());
            int columnsToNextTabStop = Parsing.columnsToNextTabStop(this.column);
            StringBuilder sb = new StringBuilder(subSequence2.length() + columnsToNextTabStop);
            for (int i6 = 0; i6 < columnsToNextTabStop; i6++) {
                sb.append(' ');
            }
            sb.append(subSequence2);
            subSequence = sb.toString();
        } else {
            CharSequence charSequence2 = this.line;
            subSequence = charSequence2.subSequence(this.index, charSequence2.length());
        }
        getActiveBlockParser().addLine(subSequence);
    }

    private void advance() {
        if (this.line.charAt(this.index) != '\t') {
            this.index++;
            this.column++;
        } else {
            this.index++;
            int i5 = this.column;
            this.column = i5 + Parsing.columnsToNextTabStop(i5);
        }
    }

    public static List<BlockParserFactory> calculateBlockParserFactories(List<BlockParserFactory> list, Set<Class<? extends Block>> set) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Iterator<Class<? extends Block>> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(NODES_TO_CORE_FACTORIES.get(it.next()));
        }
        return arrayList;
    }

    private void deactivateBlockParser() {
        this.activeBlockParsers.remove(r0.size() - 1);
    }

    private void finalize(BlockParser blockParser) {
        if (getActiveBlockParser() == blockParser) {
            deactivateBlockParser();
        }
        if (blockParser instanceof ParagraphParser) {
            addDefinitionsFrom((ParagraphParser) blockParser);
        }
        blockParser.closeBlock();
    }

    private Document finalizeAndProcess() {
        finalizeBlocks(this.activeBlockParsers);
        processInlines();
        return this.documentBlockParser.getBlock();
    }

    private void finalizeBlocks(List<BlockParser> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            finalize(list.get(size));
        }
    }

    private BlockStartImpl findBlockStart(BlockParser blockParser) {
        MatchedBlockParserImpl matchedBlockParserImpl = new MatchedBlockParserImpl(blockParser);
        Iterator<BlockParserFactory> it = this.blockParserFactories.iterator();
        while (it.hasNext()) {
            BlockStart tryStart = it.next().tryStart(this, matchedBlockParserImpl);
            if (tryStart instanceof BlockStartImpl) {
                return (BlockStartImpl) tryStart;
            }
        }
        return null;
    }

    private void findNextNonSpace() {
        int i5 = this.index;
        int i6 = this.column;
        this.blank = true;
        int length = this.line.length();
        while (true) {
            if (i5 >= length) {
                break;
            }
            char charAt = this.line.charAt(i5);
            if (charAt == '\t') {
                i5++;
                i6 += 4 - (i6 % 4);
            } else if (charAt != ' ') {
                this.blank = false;
                break;
            } else {
                i5++;
                i6++;
            }
        }
        this.nextNonSpace = i5;
        this.nextNonSpaceColumn = i6;
        this.indent = i6 - this.column;
    }

    public static Set<Class<? extends Block>> getDefaultBlockParserTypes() {
        return CORE_FACTORY_TYPES;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00f7, code lost:
    
        setNewIndex(r10.nextNonSpace);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void incorporateLine(CharSequence charSequence) {
        this.line = Parsing.prepareLine(charSequence);
        this.index = 0;
        this.column = 0;
        this.columnIsInTab = false;
        List<BlockParser> list = this.activeBlockParsers;
        int i5 = 1;
        for (BlockParser blockParser : list.subList(1, list.size())) {
            findNextNonSpace();
            BlockContinue tryContinue = blockParser.tryContinue(this);
            if (!(tryContinue instanceof BlockContinueImpl)) {
                break;
            }
            BlockContinueImpl blockContinueImpl = (BlockContinueImpl) tryContinue;
            if (blockContinueImpl.isFinalize()) {
                finalize(blockParser);
                return;
            }
            if (blockContinueImpl.getNewIndex() != -1) {
                setNewIndex(blockContinueImpl.getNewIndex());
            } else if (blockContinueImpl.getNewColumn() != -1) {
                setNewColumn(blockContinueImpl.getNewColumn());
            }
            i5++;
        }
        List<BlockParser> list2 = this.activeBlockParsers;
        ArrayList arrayList = new ArrayList(list2.subList(i5, list2.size()));
        BlockParser blockParser2 = this.activeBlockParsers.get(i5 - 1);
        boolean isEmpty = arrayList.isEmpty();
        boolean z5 = (blockParser2.getBlock() instanceof Paragraph) || blockParser2.isContainer();
        while (true) {
            if (!z5) {
                break;
            }
            findNextNonSpace();
            if (isBlank() || (this.indent < Parsing.CODE_BLOCK_INDENT && Parsing.isLetter(this.line, this.nextNonSpace))) {
                break;
            }
            BlockStartImpl findBlockStart = findBlockStart(blockParser2);
            if (findBlockStart == null) {
                setNewIndex(this.nextNonSpace);
                break;
            }
            if (!isEmpty) {
                finalizeBlocks(arrayList);
                isEmpty = true;
            }
            if (findBlockStart.getNewIndex() != -1) {
                setNewIndex(findBlockStart.getNewIndex());
            } else if (findBlockStart.getNewColumn() != -1) {
                setNewColumn(findBlockStart.getNewColumn());
            }
            if (findBlockStart.isReplaceActiveBlockParser()) {
                prepareActiveBlockParserForReplacement();
            }
            BlockParser[] blockParsers = findBlockStart.getBlockParsers();
            int length = blockParsers.length;
            int i6 = 0;
            while (i6 < length) {
                BlockParser blockParser3 = blockParsers[i6];
                BlockParser addChild = addChild(blockParser3);
                i6++;
                z5 = blockParser3.isContainer();
                blockParser2 = addChild;
            }
        }
        if (!isEmpty && !isBlank() && getActiveBlockParser().canHaveLazyContinuationLines()) {
            addLine();
            return;
        }
        if (!isEmpty) {
            finalizeBlocks(arrayList);
        }
        if (!blockParser2.isContainer()) {
            addLine();
        } else {
            if (isBlank()) {
                return;
            }
            addChild(new ParagraphParser());
            addLine();
        }
    }

    private void prepareActiveBlockParserForReplacement() {
        BlockParser activeBlockParser = getActiveBlockParser();
        deactivateBlockParser();
        this.allBlockParsers.remove(activeBlockParser);
        if (activeBlockParser instanceof ParagraphParser) {
            addDefinitionsFrom((ParagraphParser) activeBlockParser);
        }
        activeBlockParser.getBlock().unlink();
    }

    private void processInlines() {
        InlineParser create = this.inlineParserFactory.create(new InlineParserContextImpl(this.delimiterProcessors, this.definitions));
        Iterator<BlockParser> it = this.allBlockParsers.iterator();
        while (it.hasNext()) {
            it.next().parseInlines(create);
        }
    }

    private void setNewColumn(int i5) {
        int i6;
        int i7 = this.nextNonSpaceColumn;
        if (i5 >= i7) {
            this.index = this.nextNonSpace;
            this.column = i7;
        }
        int length = this.line.length();
        while (true) {
            i6 = this.column;
            if (i6 >= i5 || this.index == length) {
                break;
            } else {
                advance();
            }
        }
        if (i6 <= i5) {
            this.columnIsInTab = false;
            return;
        }
        this.index--;
        this.column = i5;
        this.columnIsInTab = true;
    }

    private void setNewIndex(int i5) {
        int i6 = this.nextNonSpace;
        if (i5 >= i6) {
            this.index = i6;
            this.column = this.nextNonSpaceColumn;
        }
        int length = this.line.length();
        while (true) {
            int i7 = this.index;
            if (i7 >= i5 || i7 == length) {
                break;
            } else {
                advance();
            }
        }
        this.columnIsInTab = false;
    }

    @Override // org.commonmark.parser.block.ParserState
    public BlockParser getActiveBlockParser() {
        return this.activeBlockParsers.get(r0.size() - 1);
    }

    @Override // org.commonmark.parser.block.ParserState
    public int getColumn() {
        return this.column;
    }

    @Override // org.commonmark.parser.block.ParserState
    public int getIndent() {
        return this.indent;
    }

    @Override // org.commonmark.parser.block.ParserState
    public int getIndex() {
        return this.index;
    }

    @Override // org.commonmark.parser.block.ParserState
    public CharSequence getLine() {
        return this.line;
    }

    @Override // org.commonmark.parser.block.ParserState
    public int getNextNonSpaceIndex() {
        return this.nextNonSpace;
    }

    @Override // org.commonmark.parser.block.ParserState
    public boolean isBlank() {
        return this.blank;
    }

    public Document parse(String str) {
        int i5 = 0;
        while (true) {
            int findLineBreak = Parsing.findLineBreak(str, i5);
            if (findLineBreak == -1) {
                break;
            }
            incorporateLine(str.substring(i5, findLineBreak));
            i5 = findLineBreak + 1;
            if (i5 < str.length() && str.charAt(findLineBreak) == '\r' && str.charAt(i5) == '\n') {
                i5 = findLineBreak + 2;
            }
        }
        if (str.length() > 0 && (i5 == 0 || i5 < str.length())) {
            incorporateLine(str.substring(i5));
        }
        return finalizeAndProcess();
    }
}
