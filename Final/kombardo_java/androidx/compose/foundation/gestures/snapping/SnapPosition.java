package androidx.compose.foundation.gestures.snapping;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\bg\u0018\u00002\u00020\u0001:\u0001\u000bJ?\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/gestures/snapping/SnapPosition;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "layoutSize", "itemSize", "beforeContentPadding", "afterContentPadding", "itemIndex", "itemCount", "position", "(IIIIII)I", "Start", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface SnapPosition {

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/gestures/snapping/SnapPosition$Start;", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "()V", "position", BuildConfig.FLAVOR, "layoutSize", "itemSize", "beforeContentPadding", "afterContentPadding", "itemIndex", "itemCount", "toString", BuildConfig.FLAVOR, "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Start implements SnapPosition {
        public static final Start INSTANCE = new Start();

        private Start() {
        }

        @Override // androidx.compose.foundation.gestures.snapping.SnapPosition
        public int position(int layoutSize, int itemSize, int beforeContentPadding, int afterContentPadding, int itemIndex, int itemCount) {
            return 0;
        }

        public String toString() {
            return "Start";
        }
    }

    int position(int layoutSize, int itemSize, int beforeContentPadding, int afterContentPadding, int itemIndex, int itemCount);
}
