package com.google.common.collect;

/* loaded from: classes2.dex */
public abstract class Collections2 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder newStringBuilderForCollection(int i5) {
        CollectPreconditions.checkNonnegative(i5, "size");
        return new StringBuilder((int) Math.min(i5 * 8, 1073741824L));
    }
}
