package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0000¨\u0006\t"}, d2 = {"toCharArray", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "destination", BuildConfig.FLAVOR, "destinationOffset", BuildConfig.FLAVOR, "startIndex", "endIndex", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class GapBuffer_jvmKt {
    public static final void toCharArray(String str, char[] cArr, int i5, int i6, int i7) {
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        str.getChars(i6, i7, cArr, i5);
    }
}
