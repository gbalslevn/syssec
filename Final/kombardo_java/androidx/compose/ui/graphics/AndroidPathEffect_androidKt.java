package androidx.compose.ui.graphics;

import android.graphics.DashPathEffect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001f\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/ui/graphics/PathEffect;", "Landroid/graphics/PathEffect;", "asAndroidPathEffect", "(Landroidx/compose/ui/graphics/PathEffect;)Landroid/graphics/PathEffect;", BuildConfig.FLAVOR, "intervals", BuildConfig.FLAVOR, "phase", "actualDashPathEffect", "([FF)Landroidx/compose/ui/graphics/PathEffect;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidPathEffect_androidKt {
    public static final PathEffect actualDashPathEffect(float[] fArr, float f5) {
        return new AndroidPathEffect(new DashPathEffect(fArr, f5));
    }

    public static final android.graphics.PathEffect asAndroidPathEffect(PathEffect pathEffect) {
        Intrinsics.checkNotNull(pathEffect, "null cannot be cast to non-null type androidx.compose.ui.graphics.AndroidPathEffect");
        return ((AndroidPathEffect) pathEffect).getNativePathEffect();
    }
}
