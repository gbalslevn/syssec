package androidx.compose.ui.node;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"DistanceAndInLayer", "Landroidx/compose/ui/node/DistanceAndInLayer;", "distance", BuildConfig.FLAVOR, "isInLayer", BuildConfig.FLAVOR, "(FZ)J", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class HitTestResultKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final long DistanceAndInLayer(float f5, boolean z5) {
        return DistanceAndInLayer.m1992constructorimpl(((z5 ? 1L : 0L) & 4294967295L) | (Float.floatToIntBits(f5) << 32));
    }
}
