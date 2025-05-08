package androidx.compose.ui.text.input;

import com.adjust.sdk.Constants;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¨\u0006\u0005"}, d2 = {"isSurrogatePair", BuildConfig.FLAVOR, Constants.HIGH, BuildConfig.FLAVOR, Constants.LOW, "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class EditCommandKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isSurrogatePair(char c5, char c6) {
        return Character.isHighSurrogate(c5) && Character.isLowSurrogate(c6);
    }
}
