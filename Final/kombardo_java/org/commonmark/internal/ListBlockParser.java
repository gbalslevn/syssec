package org.commonmark.internal;

import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.BulletList;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.OrderedList;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: classes3.dex */
public class ListBlockParser extends AbstractBlockParser {
    private final ListBlock block;
    private boolean hadBlankLine;
    private int linesAfterBlank;

    /* loaded from: classes3.dex */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            BlockParser matchedBlockParser2 = matchedBlockParser.getMatchedBlockParser();
            if (parserState.getIndent() >= Parsing.CODE_BLOCK_INDENT) {
                return BlockStart.none();
            }
            ListData parseList = ListBlockParser.parseList(parserState.getLine(), parserState.getNextNonSpaceIndex(), parserState.getColumn() + parserState.getIndent(), matchedBlockParser.getParagraphContent() != null);
            if (parseList == null) {
                return BlockStart.none();
            }
            int i5 = parseList.contentColumn;
            ListItemParser listItemParser = new ListItemParser(i5 - parserState.getColumn());
            if ((matchedBlockParser2 instanceof ListBlockParser) && ListBlockParser.listsMatch((ListBlock) matchedBlockParser2.getBlock(), parseList.listBlock)) {
                return BlockStart.of(listItemParser).atColumn(i5);
            }
            ListBlockParser listBlockParser = new ListBlockParser(parseList.listBlock);
            parseList.listBlock.setTight(true);
            return BlockStart.of(listBlockParser, listItemParser).atColumn(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class ListData {
        final int contentColumn;
        final ListBlock listBlock;

        ListData(ListBlock listBlock, int i5) {
            this.listBlock = listBlock;
            this.contentColumn = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class ListMarkerData {
        final int indexAfterMarker;
        final ListBlock listBlock;

        ListMarkerData(ListBlock listBlock, int i5) {
            this.listBlock = listBlock;
            this.indexAfterMarker = i5;
        }
    }

    public ListBlockParser(ListBlock listBlock) {
        this.block = listBlock;
    }

    private static boolean equals(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private static boolean isSpaceTabOrEnd(CharSequence charSequence, int i5) {
        char charAt;
        return i5 >= charSequence.length() || (charAt = charSequence.charAt(i5)) == '\t' || charAt == ' ';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean listsMatch(ListBlock listBlock, ListBlock listBlock2) {
        if ((listBlock instanceof BulletList) && (listBlock2 instanceof BulletList)) {
            return equals(Character.valueOf(((BulletList) listBlock).getBulletMarker()), Character.valueOf(((BulletList) listBlock2).getBulletMarker()));
        }
        if ((listBlock instanceof OrderedList) && (listBlock2 instanceof OrderedList)) {
            return equals(Character.valueOf(((OrderedList) listBlock).getDelimiter()), Character.valueOf(((OrderedList) listBlock2).getDelimiter()));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ListData parseList(CharSequence charSequence, int i5, int i6, boolean z5) {
        boolean z6;
        ListMarkerData parseListMarker = parseListMarker(charSequence, i5);
        if (parseListMarker == null) {
            return null;
        }
        ListBlock listBlock = parseListMarker.listBlock;
        int i7 = parseListMarker.indexAfterMarker;
        int i8 = i6 + (i7 - i5);
        int length = charSequence.length();
        int i9 = i8;
        while (true) {
            if (i7 >= length) {
                z6 = false;
                break;
            }
            char charAt = charSequence.charAt(i7);
            if (charAt != '\t') {
                if (charAt != ' ') {
                    z6 = true;
                    break;
                }
                i9++;
            } else {
                i9 += Parsing.columnsToNextTabStop(i9);
            }
            i7++;
        }
        if (z5 && (((listBlock instanceof OrderedList) && ((OrderedList) listBlock).getStartNumber() != 1) || !z6)) {
            return null;
        }
        if (!z6 || i9 - i8 > Parsing.CODE_BLOCK_INDENT) {
            i9 = i8 + 1;
        }
        return new ListData(listBlock, i9);
    }

    private static ListMarkerData parseListMarker(CharSequence charSequence, int i5) {
        char charAt = charSequence.charAt(i5);
        if (charAt != '*' && charAt != '+' && charAt != '-') {
            return parseOrderedList(charSequence, i5);
        }
        int i6 = i5 + 1;
        if (!isSpaceTabOrEnd(charSequence, i6)) {
            return null;
        }
        BulletList bulletList = new BulletList();
        bulletList.setBulletMarker(charAt);
        return new ListMarkerData(bulletList, i6);
    }

    private static ListMarkerData parseOrderedList(CharSequence charSequence, int i5) {
        int length = charSequence.length();
        int i6 = 0;
        for (int i7 = i5; i7 < length; i7++) {
            char charAt = charSequence.charAt(i7);
            if (charAt == ')' || charAt == '.') {
                if (i6 >= 1) {
                    int i8 = i7 + 1;
                    if (isSpaceTabOrEnd(charSequence, i8)) {
                        String charSequence2 = charSequence.subSequence(i5, i7).toString();
                        OrderedList orderedList = new OrderedList();
                        orderedList.setStartNumber(Integer.parseInt(charSequence2));
                        orderedList.setDelimiter(charAt);
                        return new ListMarkerData(orderedList, i8);
                    }
                }
                return null;
            }
            switch (charAt) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    i6++;
                    if (i6 > 9) {
                        return null;
                    }
                default:
                    return null;
            }
        }
        return null;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean canContain(Block block) {
        if (!(block instanceof ListItem)) {
            return false;
        }
        if (this.hadBlankLine && this.linesAfterBlank == 1) {
            this.block.setTight(false);
            this.hadBlankLine = false;
        }
        return true;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block getBlock() {
        return this.block;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean isContainer() {
        return true;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState parserState) {
        if (parserState.isBlank()) {
            this.hadBlankLine = true;
            this.linesAfterBlank = 0;
        } else if (this.hadBlankLine) {
            this.linesAfterBlank++;
        }
        return BlockContinue.atIndex(parserState.getIndex());
    }
}
