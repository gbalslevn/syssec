package io.noties.markwon.ext.tables;

import android.content.Context;
import android.text.Spanned;
import android.widget.TextView;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.ext.tables.TableRowSpan;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TableRow;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;

/* loaded from: classes2.dex */
public class TablePlugin extends AbstractMarkwonPlugin {
    private final TableTheme theme;
    private final TableVisitor visitor;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.noties.markwon.ext.tables.TablePlugin$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$commonmark$ext$gfm$tables$TableCell$Alignment;

        static {
            int[] iArr = new int[TableCell.Alignment.values().length];
            $SwitchMap$org$commonmark$ext$gfm$tables$TableCell$Alignment = iArr;
            try {
                iArr[TableCell.Alignment.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$commonmark$ext$gfm$tables$TableCell$Alignment[TableCell.Alignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class TableVisitor {
        private List<TableRowSpan.Cell> pendingTableRow;
        private boolean tableRowIsHeader;
        private int tableRows;
        private final TableTheme tableTheme;

        TableVisitor(TableTheme tableTheme) {
            this.tableTheme = tableTheme;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int tableCellAlignment(TableCell.Alignment alignment) {
            if (alignment == null) {
                return 0;
            }
            int i5 = AnonymousClass1.$SwitchMap$org$commonmark$ext$gfm$tables$TableCell$Alignment[alignment.ordinal()];
            int i6 = 1;
            if (i5 != 1) {
                i6 = 2;
                if (i5 != 2) {
                    return 0;
                }
            }
            return i6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void visitRow(MarkwonVisitor markwonVisitor, Node node) {
            int length = markwonVisitor.length();
            markwonVisitor.visitChildren(node);
            if (this.pendingTableRow != null) {
                SpannableBuilder builder = markwonVisitor.builder();
                int length2 = builder.length();
                boolean z5 = length2 > 0 && '\n' != builder.charAt(length2 - 1);
                if (z5) {
                    markwonVisitor.forceNewLine();
                }
                builder.append((char) 160);
                TableRowSpan tableRowSpan = new TableRowSpan(this.tableTheme, this.pendingTableRow, this.tableRowIsHeader, this.tableRows % 2 == 1);
                this.tableRows = this.tableRowIsHeader ? 0 : this.tableRows + 1;
                if (z5) {
                    length++;
                }
                markwonVisitor.setSpans(length, tableRowSpan);
                this.pendingTableRow = null;
            }
        }

        void clear() {
            this.pendingTableRow = null;
            this.tableRowIsHeader = false;
            this.tableRows = 0;
        }

        void configure(MarkwonVisitor.Builder builder) {
            builder.on(TableBlock.class, new MarkwonVisitor.NodeVisitor<TableBlock>() { // from class: io.noties.markwon.ext.tables.TablePlugin.TableVisitor.5
                @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
                public void visit(MarkwonVisitor markwonVisitor, TableBlock tableBlock) {
                    markwonVisitor.blockStart(tableBlock);
                    int length = markwonVisitor.length();
                    markwonVisitor.visitChildren(tableBlock);
                    markwonVisitor.setSpans(length, new TableSpan());
                    markwonVisitor.blockEnd(tableBlock);
                }
            }).on(TableBody.class, new MarkwonVisitor.NodeVisitor<TableBody>() { // from class: io.noties.markwon.ext.tables.TablePlugin.TableVisitor.4
                @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
                public void visit(MarkwonVisitor markwonVisitor, TableBody tableBody) {
                    markwonVisitor.visitChildren(tableBody);
                    TableVisitor.this.tableRows = 0;
                }
            }).on(TableRow.class, new MarkwonVisitor.NodeVisitor<TableRow>() { // from class: io.noties.markwon.ext.tables.TablePlugin.TableVisitor.3
                @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
                public void visit(MarkwonVisitor markwonVisitor, TableRow tableRow) {
                    TableVisitor.this.visitRow(markwonVisitor, tableRow);
                }
            }).on(TableHead.class, new MarkwonVisitor.NodeVisitor<TableHead>() { // from class: io.noties.markwon.ext.tables.TablePlugin.TableVisitor.2
                @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
                public void visit(MarkwonVisitor markwonVisitor, TableHead tableHead) {
                    TableVisitor.this.visitRow(markwonVisitor, tableHead);
                }
            }).on(TableCell.class, new MarkwonVisitor.NodeVisitor<TableCell>() { // from class: io.noties.markwon.ext.tables.TablePlugin.TableVisitor.1
                @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
                public void visit(MarkwonVisitor markwonVisitor, TableCell tableCell) {
                    int length = markwonVisitor.length();
                    markwonVisitor.visitChildren(tableCell);
                    if (TableVisitor.this.pendingTableRow == null) {
                        TableVisitor.this.pendingTableRow = new ArrayList(2);
                    }
                    TableVisitor.this.pendingTableRow.add(new TableRowSpan.Cell(TableVisitor.tableCellAlignment(tableCell.getAlignment()), markwonVisitor.builder().removeFromEnd(length)));
                    TableVisitor.this.tableRowIsHeader = tableCell.isHeader();
                }
            });
        }
    }

    TablePlugin(TableTheme tableTheme) {
        this.theme = tableTheme;
        this.visitor = new TableVisitor(tableTheme);
    }

    public static TablePlugin create(Context context) {
        return new TablePlugin(TableTheme.create(context));
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void afterSetText(TextView textView) {
        TableRowsScheduler.schedule(textView);
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void beforeRender(Node node) {
        this.visitor.clear();
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void beforeSetText(TextView textView, Spanned spanned) {
        TableRowsScheduler.unschedule(textView);
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureParser(Parser.Builder builder) {
        builder.extensions(Collections.singleton(TablesExtension.create()));
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configureVisitor(MarkwonVisitor.Builder builder) {
        this.visitor.configure(builder);
    }
}
