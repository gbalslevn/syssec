package org.commonmark.internal;

import org.commonmark.node.Block;
import org.commonmark.node.ThematicBreak;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: classes3.dex */
public class ThematicBreakParser extends AbstractBlockParser {
    private final ThematicBreak block = new ThematicBreak();

    /* loaded from: classes3.dex */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            if (parserState.getIndent() >= 4) {
                return BlockStart.none();
            }
            int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
            CharSequence line = parserState.getLine();
            return ThematicBreakParser.isThematicBreak(line, nextNonSpaceIndex) ? BlockStart.of(new ThematicBreakParser()).atIndex(line.length()) : BlockStart.none();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isThematicBreak(CharSequence charSequence, int i5) {
        int length = charSequence.length();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i5 < length) {
            char charAt = charSequence.charAt(i5);
            if (charAt != '\t' && charAt != ' ') {
                if (charAt == '*') {
                    i8++;
                } else if (charAt == '-') {
                    i6++;
                } else {
                    if (charAt != '_') {
                        return false;
                    }
                    i7++;
                }
            }
            i5++;
        }
        return (i6 >= 3 && i7 == 0 && i8 == 0) || (i7 >= 3 && i6 == 0 && i8 == 0) || (i8 >= 3 && i6 == 0 && i7 == 0);
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block getBlock() {
        return this.block;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState parserState) {
        return BlockContinue.none();
    }
}
