package androidx.compose.ui.graphics;

import android.graphics.Shader;
import android.os.Build;
import androidx.compose.ui.graphics.TileMode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/graphics/TileMode;", "Landroid/graphics/Shader$TileMode;", "toAndroidTileMode-0vamqd0", "(I)Landroid/graphics/Shader$TileMode;", "toAndroidTileMode", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidTileMode_androidKt {
    /* renamed from: toAndroidTileMode-0vamqd0, reason: not valid java name */
    public static final Shader.TileMode m1426toAndroidTileMode0vamqd0(int i5) {
        TileMode.Companion companion = TileMode.INSTANCE;
        if (TileMode.m1618equalsimpl0(i5, companion.m1621getClamp3opZhB0())) {
            return Shader.TileMode.CLAMP;
        }
        if (TileMode.m1618equalsimpl0(i5, companion.m1624getRepeated3opZhB0())) {
            return Shader.TileMode.REPEAT;
        }
        if (TileMode.m1618equalsimpl0(i5, companion.m1623getMirror3opZhB0())) {
            return Shader.TileMode.MIRROR;
        }
        if (TileMode.m1618equalsimpl0(i5, companion.m1622getDecal3opZhB0()) && Build.VERSION.SDK_INT >= 31) {
            return TileModeVerificationHelper.INSTANCE.getFrameworkTileModeDecal();
        }
        return Shader.TileMode.CLAMP;
    }
}
