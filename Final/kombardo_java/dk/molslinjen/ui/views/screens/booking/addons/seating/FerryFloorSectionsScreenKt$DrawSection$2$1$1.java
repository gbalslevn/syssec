package dk.molslinjen.ui.views.screens.booking.addons.seating;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerrySeatingSectionId;
import uniffi.molslinjen_shared.FerrySeatingSectionOverview;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionsScreenKt$DrawSection$2$1$1", f = "FerryFloorSectionsScreen.kt", l = {220}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class FerryFloorSectionsScreenKt$DrawSection$2$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function0<Unit> $onDisabledSectionSelected;
    final /* synthetic */ Function2<FerrySeatingSectionId, Offset, Unit> $onSectionSelected;
    final /* synthetic */ FerrySeatingSectionOverview $section;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FerryFloorSectionsScreenKt$DrawSection$2$1$1(boolean z5, Function2<? super FerrySeatingSectionId, ? super Offset, Unit> function2, FerrySeatingSectionOverview ferrySeatingSectionOverview, Function0<Unit> function0, Continuation<? super FerryFloorSectionsScreenKt$DrawSection$2$1$1> continuation) {
        super(2, continuation);
        this.$enabled = z5;
        this.$onSectionSelected = function2;
        this.$section = ferrySeatingSectionOverview;
        this.$onDisabledSectionSelected = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(boolean z5, Function2 function2, FerrySeatingSectionOverview ferrySeatingSectionOverview, Function0 function0, Offset offset) {
        if (z5) {
            function2.invoke(ferrySeatingSectionOverview.getId(), Offset.m1328boximpl(OffsetKt.Offset(Offset.m1337getXimpl(offset.getPackedValue()) / ((float) ferrySeatingSectionOverview.getSize().getWidth()), Offset.m1338getYimpl(offset.getPackedValue()) / ((float) ferrySeatingSectionOverview.getSize().getHeight()))));
        } else {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FerryFloorSectionsScreenKt$DrawSection$2$1$1 ferryFloorSectionsScreenKt$DrawSection$2$1$1 = new FerryFloorSectionsScreenKt$DrawSection$2$1$1(this.$enabled, this.$onSectionSelected, this.$section, this.$onDisabledSectionSelected, continuation);
        ferryFloorSectionsScreenKt$DrawSection$2$1$1.L$0 = obj;
        return ferryFloorSectionsScreenKt$DrawSection$2$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((FerryFloorSectionsScreenKt$DrawSection$2$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            final boolean z5 = this.$enabled;
            final Function2<FerrySeatingSectionId, Offset, Unit> function2 = this.$onSectionSelected;
            final FerrySeatingSectionOverview ferrySeatingSectionOverview = this.$section;
            final Function0<Unit> function0 = this.$onDisabledSectionSelected;
            Function1 function1 = new Function1() { // from class: dk.molslinjen.ui.views.screens.booking.addons.seating.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    Unit invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = FerryFloorSectionsScreenKt$DrawSection$2$1$1.invokeSuspend$lambda$0(z5, function2, ferrySeatingSectionOverview, function0, (Offset) obj2);
                    return invokeSuspend$lambda$0;
                }
            };
            this.label = 1;
            if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, null, function1, this, 7, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
