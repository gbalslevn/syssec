package androidx.compose.ui.text.font;

import android.content.Context;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/text/font/FontWeightAdjustmentHelperApi31;", BuildConfig.FLAVOR, "()V", "fontWeightAdjustment", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FontWeightAdjustmentHelperApi31 {
    public static final FontWeightAdjustmentHelperApi31 INSTANCE = new FontWeightAdjustmentHelperApi31();

    private FontWeightAdjustmentHelperApi31() {
    }

    public final int fontWeightAdjustment(Context context) {
        int i5;
        i5 = context.getResources().getConfiguration().fontWeightAdjustment;
        return i5;
    }
}
