package org.commonmark.internal;

import java.util.regex.Pattern;
import org.commonmark.node.Block;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.Paragraph;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;

/* loaded from: classes3.dex */
public class HtmlBlockParser extends AbstractBlockParser {
    private static final Pattern[][] BLOCK_PATTERNS = {new Pattern[]{null, null}, new Pattern[]{Pattern.compile("^<(?:script|pre|style)(?:\\s|>|$)", 2), Pattern.compile("</(?:script|pre|style)>", 2)}, new Pattern[]{Pattern.compile("^<!--"), Pattern.compile("-->")}, new Pattern[]{Pattern.compile("^<[?]"), Pattern.compile("\\?>")}, new Pattern[]{Pattern.compile("^<![A-Z]"), Pattern.compile(">")}, new Pattern[]{Pattern.compile("^<!\\[CDATA\\["), Pattern.compile("\\]\\]>")}, new Pattern[]{Pattern.compile("^</?(?:address|article|aside|base|basefont|blockquote|body|caption|center|col|colgroup|dd|details|dialog|dir|div|dl|dt|fieldset|figcaption|figure|footer|form|frame|frameset|h1|h2|h3|h4|h5|h6|head|header|hr|html|iframe|legend|li|link|main|menu|menuitem|nav|noframes|ol|optgroup|option|p|param|section|source|summary|table|tbody|td|tfoot|th|thead|title|tr|track|ul)(?:\\s|[/]?[>]|$)", 2), null}, new Pattern[]{Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>])\\s*$", 2), null}};
    private final HtmlBlock block;
    private final Pattern closingPattern;
    private BlockContent content;
    private boolean finished;

    /* loaded from: classes3.dex */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            int nextNonSpaceIndex = parserState.getNextNonSpaceIndex();
            CharSequence line = parserState.getLine();
            if (parserState.getIndent() < 4 && line.charAt(nextNonSpaceIndex) == '<') {
                for (int i5 = 1; i5 <= 7; i5++) {
                    if (i5 != 7 || !(matchedBlockParser.getMatchedBlockParser().getBlock() instanceof Paragraph)) {
                        Pattern pattern = HtmlBlockParser.BLOCK_PATTERNS[i5][0];
                        Pattern pattern2 = HtmlBlockParser.BLOCK_PATTERNS[i5][1];
                        if (pattern.matcher(line.subSequence(nextNonSpaceIndex, line.length())).find()) {
                            return BlockStart.of(new HtmlBlockParser(pattern2)).atIndex(parserState.getIndex());
                        }
                    }
                }
            }
            return BlockStart.none();
        }
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void addLine(CharSequence charSequence) {
        this.content.add(charSequence);
        Pattern pattern = this.closingPattern;
        if (pattern == null || !pattern.matcher(charSequence).find()) {
            return;
        }
        this.finished = true;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void closeBlock() {
        this.block.setLiteral(this.content.getString());
        this.content = null;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block getBlock() {
        return this.block;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState parserState) {
        return this.finished ? BlockContinue.none() : (parserState.isBlank() && this.closingPattern == null) ? BlockContinue.none() : BlockContinue.atIndex(parserState.getIndex());
    }

    private HtmlBlockParser(Pattern pattern) {
        this.block = new HtmlBlock();
        this.finished = false;
        this.content = new BlockContent();
        this.closingPattern = pattern;
    }
}
