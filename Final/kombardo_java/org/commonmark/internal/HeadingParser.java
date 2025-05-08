package org.commonmark.internal;

import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Block;
import org.commonmark.node.Heading;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;
import org.conscrypt.BuildConfig;

/* loaded from: classes3.dex */
public class HeadingParser extends AbstractBlockParser {
    private final Heading block;
    private final String content;

    /* loaded from: classes3.dex */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            CharSequence paragraphContent;
            if (parserState.getIndent() >= Parsing.CODE_BLOCK_INDENT) {
                return BlockStart.none();
            }
            CharSequence line = parserState.getLine();
            int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
            HeadingParser atxHeading = HeadingParser.getAtxHeading(line, nextNonSpaceIndex);
            if (atxHeading != null) {
                return BlockStart.of(atxHeading).atIndex(line.length());
            }
            int setextHeadingLevel = HeadingParser.getSetextHeadingLevel(line, nextNonSpaceIndex);
            return (setextHeadingLevel <= 0 || (paragraphContent = matchedBlockParser.getParagraphContent()) == null) ? BlockStart.none() : BlockStart.of(new HeadingParser(setextHeadingLevel, paragraphContent.toString())).atIndex(line.length()).replaceActiveBlockParser();
        }
    }

    public HeadingParser(int i5, String str) {
        Heading heading = new Heading();
        this.block = heading;
        heading.setLevel(i5);
        this.content = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HeadingParser getAtxHeading(CharSequence charSequence, int i5) {
        int skip = Parsing.skip('#', charSequence, i5, charSequence.length()) - i5;
        if (skip == 0 || skip > 6) {
            return null;
        }
        int i6 = i5 + skip;
        if (i6 >= charSequence.length()) {
            return new HeadingParser(skip, BuildConfig.FLAVOR);
        }
        char charAt = charSequence.charAt(i6);
        if (charAt != ' ' && charAt != '\t') {
            return null;
        }
        int skipSpaceTabBackwards = Parsing.skipSpaceTabBackwards(charSequence, charSequence.length() - 1, i6);
        int skipBackwards = Parsing.skipBackwards('#', charSequence, skipSpaceTabBackwards, i6);
        int skipSpaceTabBackwards2 = Parsing.skipSpaceTabBackwards(charSequence, skipBackwards, i6);
        return skipSpaceTabBackwards2 != skipBackwards ? new HeadingParser(skip, charSequence.subSequence(i6, skipSpaceTabBackwards2 + 1).toString()) : new HeadingParser(skip, charSequence.subSequence(i6, skipSpaceTabBackwards + 1).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getSetextHeadingLevel(CharSequence charSequence, int i5) {
        char charAt = charSequence.charAt(i5);
        if (charAt != '-') {
            if (charAt != '=') {
                return 0;
            }
            if (isSetextHeadingRest(charSequence, i5 + 1, '=')) {
                return 1;
            }
        }
        return isSetextHeadingRest(charSequence, i5 + 1, '-') ? 2 : 0;
    }

    private static boolean isSetextHeadingRest(CharSequence charSequence, int i5, char c5) {
        return Parsing.skipSpaceTab(charSequence, Parsing.skip(c5, charSequence, i5, charSequence.length()), charSequence.length()) >= charSequence.length();
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block getBlock() {
        return this.block;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void parseInlines(InlineParser inlineParser) {
        inlineParser.parse(this.content, this.block);
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState parserState) {
        return BlockContinue.none();
    }
}
