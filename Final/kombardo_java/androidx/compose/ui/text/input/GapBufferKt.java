package androidx.compose.ui.text.input;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"toCharArray", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "destination", BuildConfig.FLAVOR, "destinationOffset", BuildConfig.FLAVOR, "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class GapBufferKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void toCharArray(String str, char[] cArr, int i5) {
        GapBuffer_jvmKt.toCharArray(str, cArr, i5, 0, str.length());
    }
}
