package androidx.compose.ui.graphics;

import android.graphics.Path;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0011\u0010\u0004\u001a\u00020\u0000*\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0013\u0010\r\u001a\u00020\f*\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/Path;", "Path", "()Landroidx/compose/ui/graphics/Path;", "Landroid/graphics/Path;", "asComposePath", "(Landroid/graphics/Path;)Landroidx/compose/ui/graphics/Path;", BuildConfig.FLAVOR, "message", BuildConfig.FLAVOR, "throwIllegalStateException", "(Ljava/lang/String;)V", "Landroidx/compose/ui/graphics/Path$Direction;", "Landroid/graphics/Path$Direction;", "toPlatformPathDirection", "(Landroidx/compose/ui/graphics/Path$Direction;)Landroid/graphics/Path$Direction;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidPath_androidKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Path.Direction.values().length];
            try {
                iArr[Path.Direction.CounterClockwise.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Path.Direction.Clockwise.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Path Path() {
        return new AndroidPath(null, 1, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ Path.Direction access$toPlatformPathDirection(Path.Direction direction) {
        return toPlatformPathDirection(direction);
    }

    public static final Path asComposePath(android.graphics.Path path) {
        return new AndroidPath(path);
    }

    public static final void throwIllegalStateException(String str) {
        throw new IllegalStateException(str);
    }

    public static final Path.Direction toPlatformPathDirection(Path.Direction direction) {
        int i5 = WhenMappings.$EnumSwitchMapping$0[direction.ordinal()];
        if (i5 == 1) {
            return Path.Direction.CCW;
        }
        if (i5 == 2) {
            return Path.Direction.CW;
        }
        throw new NoWhenBranchMatchedException();
    }
}
