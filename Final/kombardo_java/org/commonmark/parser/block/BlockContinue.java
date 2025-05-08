package org.commonmark.parser.block;

import org.commonmark.internal.BlockContinueImpl;

/* loaded from: classes3.dex */
public abstract class BlockContinue {
    public static BlockContinue atColumn(int i5) {
        return new BlockContinueImpl(-1, i5, false);
    }

    public static BlockContinue atIndex(int i5) {
        return new BlockContinueImpl(i5, -1, false);
    }

    public static BlockContinue finished() {
        return new BlockContinueImpl(-1, -1, true);
    }

    public static BlockContinue none() {
        return null;
    }
}
