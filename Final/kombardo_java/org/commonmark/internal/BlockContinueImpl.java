package org.commonmark.internal;

import org.commonmark.parser.block.BlockContinue;

/* loaded from: classes3.dex */
public class BlockContinueImpl extends BlockContinue {
    private final boolean finalize;
    private final int newColumn;
    private final int newIndex;

    public BlockContinueImpl(int i5, int i6, boolean z5) {
        this.newIndex = i5;
        this.newColumn = i6;
        this.finalize = z5;
    }

    public int getNewColumn() {
        return this.newColumn;
    }

    public int getNewIndex() {
        return this.newIndex;
    }

    public boolean isFinalize() {
        return this.finalize;
    }
}
