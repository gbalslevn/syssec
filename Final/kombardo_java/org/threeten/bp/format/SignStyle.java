package org.threeten.bp.format;

/* loaded from: classes3.dex */
public enum SignStyle {
    NORMAL,
    ALWAYS,
    NEVER,
    NOT_NEGATIVE,
    EXCEEDS_PAD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean parse(boolean z5, boolean z6, boolean z7) {
        int ordinal = ordinal();
        if (ordinal == 0) {
            return (z5 && z6) ? false : true;
        }
        if (ordinal == 1 || ordinal == 4) {
            return true;
        }
        return (z6 || z7) ? false : true;
    }
}
