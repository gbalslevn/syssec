package io.noties.markwon.utils;

/* loaded from: classes2.dex */
public abstract class ColorUtils {
    public static int applyAlpha(int i5, int i6) {
        return (i5 & 16777215) | (i6 << 24);
    }
}
