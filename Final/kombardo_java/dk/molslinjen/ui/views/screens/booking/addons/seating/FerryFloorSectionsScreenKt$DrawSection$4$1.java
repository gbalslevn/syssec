package dk.molslinjen.ui.views.screens.booking.addons.seating;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import uniffi.molslinjen_shared.FerrySeatingSectionOverview;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class FerryFloorSectionsScreenKt$DrawSection$4$1 implements MeasurePolicy {
    final /* synthetic */ FerrySeatingSectionOverview $section;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FerryFloorSectionsScreenKt$DrawSection$4$1(FerrySeatingSectionOverview ferrySeatingSectionOverview) {
        this.$section = ferrySeatingSectionOverview;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, FerrySeatingSectionOverview ferrySeatingSectionOverview, Placeable.PlacementScope layout) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        Placeable.PlacementScope.placeRelative$default(layout, placeable, (int) ((ferrySeatingSectionOverview.getOrigin().getX() + ferrySeatingSectionOverview.getCenter().getX()) - (placeable.getWidth() * 0.5d)), (int) ((ferrySeatingSectionOverview.getOrigin().getY() + ferrySeatingSectionOverview.getCenter().getY()) - (placeable.getHeight() * 0.5d)), 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo19measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long j5) {
        Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        final Placeable mo1946measureBRTryo0 = measurables.get(0).mo1946measureBRTryo0(j5);
        int width = mo1946measureBRTryo0.getWidth();
        int height = mo1946measureBRTryo0.getHeight();
        final FerrySeatingSectionOverview ferrySeatingSectionOverview = this.$section;
        return MeasureScope.layout$default(Layout, width, height, null, new Function1() { // from class: dk.molslinjen.ui.views.screens.booking.addons.seating.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$0;
                measure_3p2s80s$lambda$0 = FerryFloorSectionsScreenKt$DrawSection$4$1.measure_3p2s80s$lambda$0(Placeable.this, ferrySeatingSectionOverview, (Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$0;
            }
        }, 4, null);
    }
}
