package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0000¨\u0006\u0007"}, d2 = {"charCount", BuildConfig.FLAVOR, "codePoint", "codePointAt", BuildConfig.FLAVOR, "index", "codePointBefore", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class CodepointHelpers_jvmKt {
    public static final int charCount(int i5) {
        return Character.charCount(i5);
    }

    public static final int codePointAt(CharSequence charSequence, int i5) {
        return Character.codePointAt(charSequence, i5);
    }

    public static final int codePointBefore(CharSequence charSequence, int i5) {
        return Character.codePointBefore(charSequence, i5);
    }
}
