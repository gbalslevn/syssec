package dk.molslinjen.ui.views.screens.booking.addons.seating;

import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class FerryFloorSectionsScreenKt$FerryFloorSectionsScreen$3$4$1 extends FunctionReferenceImpl implements Function1<IntSize, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FerryFloorSectionsScreenKt$FerryFloorSectionsScreen$3$4$1(Object obj) {
        super(1, obj, FerryFloorSectionViewModel.class, "updateForImageSize", "updateForImageSize-ozmzZPI(J)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
        m3440invokeozmzZPI(intSize.getPackedValue());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-ozmzZPI, reason: not valid java name */
    public final void m3440invokeozmzZPI(long j5) {
        ((FerryFloorSectionViewModel) this.receiver).m3438updateForImageSizeozmzZPI(j5);
    }
}
