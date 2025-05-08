package org.threeten.bp.format;

/* loaded from: classes3.dex */
public enum TextStyle {
    FULL,
    FULL_STANDALONE,
    SHORT,
    SHORT_STANDALONE,
    NARROW,
    NARROW_STANDALONE;

    public TextStyle asNormal() {
        return values()[ordinal() & (-2)];
    }
}
