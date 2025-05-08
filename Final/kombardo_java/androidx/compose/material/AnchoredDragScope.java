package androidx.compose.material;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/compose/material/AnchoredDragScope;", BuildConfig.FLAVOR, "dragTo", BuildConfig.FLAVOR, "newOffset", BuildConfig.FLAVOR, "lastKnownVelocity", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface AnchoredDragScope {
    static /* synthetic */ void dragTo$default(AnchoredDragScope anchoredDragScope, float f5, float f6, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dragTo");
        }
        if ((i5 & 2) != 0) {
            f6 = 0.0f;
        }
        anchoredDragScope.dragTo(f5, f6);
    }

    void dragTo(float newOffset, float lastKnownVelocity);
}
