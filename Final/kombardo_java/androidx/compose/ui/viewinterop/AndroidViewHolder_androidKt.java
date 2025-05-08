package androidx.compose.ui.viewinterop;

import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0001\u001a\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\b\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0004H\u0002\u001a\f\u0010\u0010\u001a\u00020\u000f*\u00020\u000fH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"NoOpScrollConnection", "androidx/compose/ui/viewinterop/AndroidViewHolder_androidKt$NoOpScrollConnection$1", "Landroidx/compose/ui/viewinterop/AndroidViewHolder_androidKt$NoOpScrollConnection$1;", "Unmeasured", BuildConfig.FLAVOR, "toNestedScrollSource", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "type", "(I)I", "layoutAccordingTo", BuildConfig.FLAVOR, "Landroid/view/View;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "toComposeOffset", BuildConfig.FLAVOR, "toComposeVelocity", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidViewHolder_androidKt {
    private static final AndroidViewHolder_androidKt$NoOpScrollConnection$1 NoOpScrollConnection = new NestedScrollConnection() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder_androidKt$NoOpScrollConnection$1
    };
    private static final int Unmeasured = Integer.MIN_VALUE;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void layoutAccordingTo(View view, LayoutNode layoutNode) {
        long positionInRoot = LayoutCoordinatesKt.positionInRoot(layoutNode.getCoordinates());
        int round = Math.round(Offset.m1337getXimpl(positionInRoot));
        int round2 = Math.round(Offset.m1338getYimpl(positionInRoot));
        view.layout(round, round2, view.getMeasuredWidth() + round, view.getMeasuredHeight() + round2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float toComposeOffset(int i5) {
        return i5 * (-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float toComposeVelocity(float f5) {
        return f5 * (-1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int toNestedScrollSource(int i5) {
        return i5 == 0 ? NestedScrollSource.INSTANCE.m1842getUserInputWNlRxjI() : NestedScrollSource.INSTANCE.m1841getSideEffectWNlRxjI();
    }
}
