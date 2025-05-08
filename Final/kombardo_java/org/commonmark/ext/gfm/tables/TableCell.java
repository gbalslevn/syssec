package org.commonmark.ext.gfm.tables;

import org.commonmark.node.CustomNode;

/* loaded from: classes3.dex */
public class TableCell extends CustomNode {
    private Alignment alignment;
    private boolean header;

    /* loaded from: classes3.dex */
    public enum Alignment {
        LEFT,
        CENTER,
        RIGHT
    }

    public Alignment getAlignment() {
        return this.alignment;
    }

    public boolean isHeader() {
        return this.header;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public void setHeader(boolean z5) {
        this.header = z5;
    }
}
