package org.commonmark.node;

/* loaded from: classes3.dex */
public abstract class ListBlock extends Block {
    private boolean tight;

    public boolean isTight() {
        return this.tight;
    }

    public void setTight(boolean z5) {
        this.tight = z5;
    }
}
