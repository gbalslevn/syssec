package org.commonmark.internal;

import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: classes3.dex */
public class FencedCodeBlockParser extends AbstractBlockParser {
    private final FencedCodeBlock block;
    private String firstLine;
    private StringBuilder otherLines;

    /* loaded from: classes3.dex */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            int indent = parserState.getIndent();
            if (indent >= Parsing.CODE_BLOCK_INDENT) {
                return BlockStart.none();
            }
            int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
            FencedCodeBlockParser checkOpener = FencedCodeBlockParser.checkOpener(parserState.getLine(), nextNonSpaceIndex, indent);
            return checkOpener != null ? BlockStart.of(checkOpener).atIndex(nextNonSpaceIndex + checkOpener.block.getFenceLength()) : BlockStart.none();
        }
    }

    public FencedCodeBlockParser(char c5, int i5, int i6) {
        FencedCodeBlock fencedCodeBlock = new FencedCodeBlock();
        this.block = fencedCodeBlock;
        this.otherLines = new StringBuilder();
        fencedCodeBlock.setFenceChar(c5);
        fencedCodeBlock.setFenceLength(i5);
        fencedCodeBlock.setFenceIndent(i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static FencedCodeBlockParser checkOpener(CharSequence charSequence, int i5, int i6) {
        int length = charSequence.length();
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i5; i9 < length; i9++) {
            char charAt = charSequence.charAt(i9);
            if (charAt == '`') {
                i7++;
            } else {
                if (charAt != '~') {
                    break;
                }
                i8++;
            }
        }
        if (i7 >= 3 && i8 == 0) {
            if (Parsing.find('`', charSequence, i5 + i7) != -1) {
                return null;
            }
            return new FencedCodeBlockParser('`', i7, i6);
        }
        if (i8 < 3 || i7 != 0) {
            return null;
        }
        return new FencedCodeBlockParser('~', i8, i6);
    }

    private boolean isClosing(CharSequence charSequence, int i5) {
        char fenceChar = this.block.getFenceChar();
        int fenceLength = this.block.getFenceLength();
        int skip = Parsing.skip(fenceChar, charSequence, i5, charSequence.length()) - i5;
        return skip >= fenceLength && Parsing.skipSpaceTab(charSequence, i5 + skip, charSequence.length()) == charSequence.length();
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void addLine(CharSequence charSequence) {
        if (this.firstLine == null) {
            this.firstLine = charSequence.toString();
        } else {
            this.otherLines.append(charSequence);
            this.otherLines.append('\n');
        }
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void closeBlock() {
        this.block.setInfo(Escaping.unescapeString(this.firstLine.trim()));
        this.block.setLiteral(this.otherLines.toString());
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block getBlock() {
        return this.block;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState parserState) {
        int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
        int index = parserState.getIndex();
        CharSequence line = parserState.getLine();
        if (parserState.getIndent() < Parsing.CODE_BLOCK_INDENT && isClosing(line, nextNonSpaceIndex)) {
            return BlockContinue.finished();
        }
        int length = line.length();
        for (int fenceIndent = this.block.getFenceIndent(); fenceIndent > 0 && index < length && line.charAt(index) == ' '; fenceIndent--) {
            index++;
        }
        return BlockContinue.atIndex(index);
    }
}
