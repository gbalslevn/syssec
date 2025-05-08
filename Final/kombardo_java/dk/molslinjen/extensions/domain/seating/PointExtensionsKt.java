package dk.molslinjen.extensions.domain.seating;

import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uniffi.molslinjen_shared.Point;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"toOffset", "Landroidx/compose/ui/geometry/Offset;", "Luniffi/molslinjen_shared/Point;", "(Luniffi/molslinjen_shared/Point;)J", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PointExtensionsKt {
    public static final long toOffset(Point point) {
        Intrinsics.checkNotNullParameter(point, "<this>");
        return OffsetKt.Offset((float) point.getX(), (float) point.getY());
    }
}
