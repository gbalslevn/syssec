package androidx.compose.ui.text.platform;

import android.text.TextPaint;
import com.sun.jna.Function;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"setAlpha", BuildConfig.FLAVOR, "Landroid/text/TextPaint;", "alpha", BuildConfig.FLAVOR, "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidTextPaint_androidKt {
    public static final void setAlpha(TextPaint textPaint, float f5) {
        if (Float.isNaN(f5)) {
            return;
        }
        if (f5 < 0.0f) {
            f5 = 0.0f;
        }
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        textPaint.setAlpha(Math.round(f5 * Function.USE_VARARGS));
    }
}
