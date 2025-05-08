package org.commonmark.ext.gfm.tables.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.node.Block;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.AbstractBlockParserFactory;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.BlockStart;
import org.commonmark.parser.block.MatchedBlockParser;
import org.commonmark.parser.block.ParserState;
import org.conscrypt.BuildConfig;

/* loaded from: classes3.dex */
public class TableBlockParser extends AbstractBlockParser {
    private final TableBlock block;
    private final List<CharSequence> bodyLines;
    private final List<TableCell.Alignment> columns;
    private final List<String> headerCells;
    private boolean nextIsSeparatorLine;

    /* loaded from: classes3.dex */
    public static class Factory extends AbstractBlockParserFactory {
        @Override // org.commonmark.parser.block.BlockParserFactory
        public BlockStart tryStart(ParserState parserState, MatchedBlockParser matchedBlockParser) {
            List parseSeparator;
            CharSequence line = parserState.getLine();
            CharSequence paragraphContent = matchedBlockParser.getParagraphContent();
            if (paragraphContent != null && paragraphContent.toString().contains("|") && !paragraphContent.toString().contains("\n") && (parseSeparator = TableBlockParser.parseSeparator(line.subSequence(parserState.getIndex(), line.length()))) != null && !parseSeparator.isEmpty()) {
                List split = TableBlockParser.split(paragraphContent);
                if (parseSeparator.size() >= split.size()) {
                    return BlockStart.of(new TableBlockParser(parseSeparator, split)).atIndex(parserState.getIndex()).replaceActiveBlockParser();
                }
            }
            return BlockStart.none();
        }
    }

    private static TableCell.Alignment getAlignment(boolean z5, boolean z6) {
        if (z5 && z6) {
            return TableCell.Alignment.CENTER;
        }
        if (z5) {
            return TableCell.Alignment.LEFT;
        }
        if (z6) {
            return TableCell.Alignment.RIGHT;
        }
        return null;
    }

    private TableCell parseCell(String str, int i5, InlineParser inlineParser) {
        TableCell tableCell = new TableCell();
        if (i5 < this.columns.size()) {
            tableCell.setAlignment(this.columns.get(i5));
        }
        inlineParser.parse(str.trim(), tableCell);
        return tableCell;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<TableCell.Alignment> parseSeparator(CharSequence charSequence) {
        boolean z5;
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        boolean z6 = false;
        int i6 = 0;
        while (i5 < charSequence.length()) {
            char charAt = charSequence.charAt(i5);
            if (charAt == '\t' || charAt == ' ') {
                i5++;
            } else {
                boolean z7 = true;
                if (charAt == '-' || charAt == ':') {
                    if (i6 == 0 && !arrayList.isEmpty()) {
                        return null;
                    }
                    if (charAt == ':') {
                        i5++;
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean z8 = false;
                    while (i5 < charSequence.length() && charSequence.charAt(i5) == '-') {
                        i5++;
                        z8 = true;
                    }
                    if (!z8) {
                        return null;
                    }
                    if (i5 >= charSequence.length() || charSequence.charAt(i5) != ':') {
                        z7 = false;
                    } else {
                        i5++;
                    }
                    arrayList.add(getAlignment(z5, z7));
                    i6 = 0;
                } else {
                    if (charAt != '|') {
                        return null;
                    }
                    i5++;
                    i6++;
                    if (i6 > 1) {
                        return null;
                    }
                    z6 = true;
                }
            }
        }
        if (z6) {
            return arrayList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<String> split(CharSequence charSequence) {
        String trim = charSequence.toString().trim();
        if (trim.startsWith("|")) {
            trim = trim.substring(1);
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int i5 = 0;
        while (i5 < trim.length()) {
            char charAt = trim.charAt(i5);
            if (charAt == '\\') {
                int i6 = i5 + 1;
                if (i6 >= trim.length() || trim.charAt(i6) != '|') {
                    sb.append('\\');
                } else {
                    sb.append('|');
                    i5 = i6;
                }
            } else if (charAt != '|') {
                sb.append(charAt);
            } else {
                arrayList.add(sb.toString());
                sb.setLength(0);
            }
            i5++;
        }
        if (sb.length() > 0) {
            arrayList.add(sb.toString());
        }
        return arrayList;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void addLine(CharSequence charSequence) {
        if (this.nextIsSeparatorLine) {
            this.nextIsSeparatorLine = false;
        } else {
            this.bodyLines.add(charSequence);
        }
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public boolean canHaveLazyContinuationLines() {
        return true;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public Block getBlock() {
        return this.block;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public void parseInlines(InlineParser inlineParser) {
        int size = this.headerCells.size();
        TableHead tableHead = new TableHead();
        this.block.appendChild(tableHead);
        TableRow tableRow = new TableRow();
        tableHead.appendChild(tableRow);
        for (int i5 = 0; i5 < size; i5++) {
            TableCell parseCell = parseCell(this.headerCells.get(i5), i5, inlineParser);
            parseCell.setHeader(true);
            tableRow.appendChild(parseCell);
        }
        Iterator<CharSequence> it = this.bodyLines.iterator();
        TableBody tableBody = null;
        while (it.hasNext()) {
            List<String> split = split(it.next());
            TableRow tableRow2 = new TableRow();
            int i6 = 0;
            while (i6 < size) {
                tableRow2.appendChild(parseCell(i6 < split.size() ? split.get(i6) : BuildConfig.FLAVOR, i6, inlineParser));
                i6++;
            }
            if (tableBody == null) {
                tableBody = new TableBody();
                this.block.appendChild(tableBody);
            }
            tableBody.appendChild(tableRow2);
        }
    }

    @Override // org.commonmark.parser.block.BlockParser
    public BlockContinue tryContinue(ParserState parserState) {
        return parserState.getLine().toString().contains("|") ? BlockContinue.atIndex(parserState.getIndex()) : BlockContinue.none();
    }

    private TableBlockParser(List<TableCell.Alignment> list, List<String> list2) {
        this.block = new TableBlock();
        this.bodyLines = new ArrayList();
        this.nextIsSeparatorLine = true;
        this.columns = list;
        this.headerCells = list2;
    }
}
