package dk.molslinjen.ui.views.screens.booking.addons.seating;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.seating.FerryFloorSectionsScreenKt$Content$1$1$1", f = "FerryFloorSectionsScreen.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class FerryFloorSectionsScreenKt$Content$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<IntSize> $imageSize$delegate;
    final /* synthetic */ Function1<IntSize, Unit> $updateDataForImageSize;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FerryFloorSectionsScreenKt$Content$1$1$1(MutableState<IntSize> mutableState, Function1<? super IntSize, Unit> function1, Continuation<? super FerryFloorSectionsScreenKt$Content$1$1$1> continuation) {
        super(2, continuation);
        this.$imageSize$delegate = mutableState;
        this.$updateDataForImageSize = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FerryFloorSectionsScreenKt$Content$1$1$1(this.$imageSize$delegate, this.$updateDataForImageSize, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntSize invoke$lambda$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        invoke$lambda$1 = FerryFloorSectionsScreenKt$Content$1.invoke$lambda$1(this.$imageSize$delegate);
        if (invoke$lambda$1 != null) {
            this.$updateDataForImageSize.invoke(IntSize.m2656boximpl(invoke$lambda$1.getPackedValue()));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FerryFloorSectionsScreenKt$Content$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
