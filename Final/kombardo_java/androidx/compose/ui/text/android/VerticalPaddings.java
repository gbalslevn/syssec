package androidx.compose.ui.text.android;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0081@\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u000b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\b\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\f"}, d2 = {"Landroidx/compose/ui/text/android/VerticalPaddings;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "packedValue", "constructor-impl", "(J)J", BuildConfig.FLAVOR, "getTopPadding-impl", "(J)I", "topPadding", "getBottomPadding-impl", "bottomPadding", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class VerticalPaddings {
    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2310constructorimpl(long j5) {
        return j5;
    }

    /* renamed from: getBottomPadding-impl, reason: not valid java name */
    public static final int m2311getBottomPaddingimpl(long j5) {
        return (int) (j5 & 4294967295L);
    }

    /* renamed from: getTopPadding-impl, reason: not valid java name */
    public static final int m2312getTopPaddingimpl(long j5) {
        return (int) (j5 >> 32);
    }
}
