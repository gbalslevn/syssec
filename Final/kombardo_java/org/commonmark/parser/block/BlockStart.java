package org.commonmark.parser.block;

import org.commonmark.internal.BlockStartImpl;

/* loaded from: classes3.dex */
public abstract class BlockStart {
    public static BlockStart none() {
        return null;
    }

    public static BlockStart of(BlockParser... blockParserArr) {
        return new BlockStartImpl(blockParserArr);
    }

    public abstract BlockStart atColumn(int i5);

    public abstract BlockStart atIndex(int i5);

    public abstract BlockStart replaceActiveBlockParser();
}
