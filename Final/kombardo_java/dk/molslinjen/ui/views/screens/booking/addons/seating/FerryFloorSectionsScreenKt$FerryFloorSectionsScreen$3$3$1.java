package dk.molslinjen.ui.views.screens.booking.addons.seating;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import uniffi.molslinjen_shared.FerrySeatingSectionOverview;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class FerryFloorSectionsScreenKt$FerryFloorSectionsScreen$3$3$1 extends FunctionReferenceImpl implements Function1<FerrySeatingSectionOverview, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FerryFloorSectionsScreenKt$FerryFloorSectionsScreen$3$3$1(Object obj) {
        super(1, obj, FerryFloorSectionViewModel.class, "isSectionEnabled", "isSectionEnabled(Luniffi/molslinjen_shared/FerrySeatingSectionOverview;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(FerrySeatingSectionOverview p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        return Boolean.valueOf(((FerryFloorSectionViewModel) this.receiver).isSectionEnabled(p02));
    }
}
