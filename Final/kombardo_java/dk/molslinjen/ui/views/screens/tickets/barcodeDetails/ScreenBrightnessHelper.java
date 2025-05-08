package dk.molslinjen.ui.views.screens.tickets.barcodeDetails;

import android.view.Window;
import android.view.WindowManager;
import dk.molslinjen.ui.views.global.navigation.MainActivity;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/ScreenBrightnessHelper;", BuildConfig.FLAVOR, "<init>", "()V", "originalScreenBrightness", BuildConfig.FLAVOR, "Ljava/lang/Float;", "changeBrightness", BuildConfig.FLAVOR, "fullLight", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ScreenBrightnessHelper {
    private static Float originalScreenBrightness;
    public static final ScreenBrightnessHelper INSTANCE = new ScreenBrightnessHelper();
    public static final int $stable = 8;

    private ScreenBrightnessHelper() {
    }

    public final void changeBrightness(boolean fullLight) {
        Window window;
        Float f5;
        MainActivity shared = MainActivity.INSTANCE.getShared();
        if (shared == null || (window = shared.getWindow()) == null) {
            return;
        }
        if (originalScreenBrightness == null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            originalScreenBrightness = attributes != null ? Float.valueOf(attributes.screenBrightness) : null;
        }
        WindowManager.LayoutParams attributes2 = window.getAttributes();
        float f6 = 1.0f;
        if (!fullLight && (f5 = originalScreenBrightness) != null) {
            f6 = f5.floatValue();
        }
        attributes2.screenBrightness = f6;
        window.setAttributes(attributes2);
        if (fullLight) {
            return;
        }
        originalScreenBrightness = null;
    }
}
