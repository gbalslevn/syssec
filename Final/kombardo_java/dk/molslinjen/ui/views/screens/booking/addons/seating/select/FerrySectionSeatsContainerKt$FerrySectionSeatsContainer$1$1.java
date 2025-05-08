package dk.molslinjen.ui.views.screens.booking.addons.seating.select;

import androidx.compose.foundation.gestures.TransformableState;
import androidx.compose.foundation.gestures.TransformableStateKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsContainerKt$FerrySectionSeatsContainer$1$1", f = "FerrySectionSeatsContainer.kt", l = {85}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class FerrySectionSeatsContainerKt$FerrySectionSeatsContainer$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $bottomEndMax;
    final /* synthetic */ MutableState<Size> $containerSize$delegate;
    final /* synthetic */ Offset $initialFocusOffset;
    final /* synthetic */ MutableState<Offset> $panOffset$delegate;
    final /* synthetic */ long $topStartMax;
    final /* synthetic */ TransformableState $transformableState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FerrySectionSeatsContainerKt$FerrySectionSeatsContainer$1$1(Offset offset, long j5, long j6, TransformableState transformableState, MutableState<Offset> mutableState, MutableState<Size> mutableState2, Continuation<? super FerrySectionSeatsContainerKt$FerrySectionSeatsContainer$1$1> continuation) {
        super(2, continuation);
        this.$initialFocusOffset = offset;
        this.$topStartMax = j5;
        this.$bottomEndMax = j6;
        this.$transformableState = transformableState;
        this.$panOffset$delegate = mutableState;
        this.$containerSize$delegate = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FerrySectionSeatsContainerKt$FerrySectionSeatsContainer$1$1(this.$initialFocusOffset, this.$topStartMax, this.$bottomEndMax, this.$transformableState, this.$panOffset$delegate, this.$containerSize$delegate, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long FerrySectionSeatsContainer_cliRtBg$lambda$9;
        long FerrySectionSeatsContainer_cliRtBg$lambda$3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$initialFocusOffset != null) {
                FerrySectionSeatsContainer_cliRtBg$lambda$9 = FerrySectionSeatsContainerKt.FerrySectionSeatsContainer_cliRtBg$lambda$9(this.$panOffset$delegate);
                Offset.Companion companion = Offset.INSTANCE;
                if (Offset.m1334equalsimpl0(FerrySectionSeatsContainer_cliRtBg$lambda$9, companion.m1349getZeroF1C5BW0()) && !Offset.m1334equalsimpl0(this.$topStartMax, companion.m1349getZeroF1C5BW0()) && !Offset.m1334equalsimpl0(this.$bottomEndMax, companion.m1349getZeroF1C5BW0())) {
                    FerrySectionSeatsContainer_cliRtBg$lambda$3 = FerrySectionSeatsContainerKt.FerrySectionSeatsContainer_cliRtBg$lambda$3(this.$containerSize$delegate);
                    long m1380times7Ah8Wj8 = Size.m1380times7Ah8Wj8(FerrySectionSeatsContainer_cliRtBg$lambda$3, 0.5f);
                    TransformableState transformableState = this.$transformableState;
                    long m1345unaryMinusF1C5BW0 = Offset.m1345unaryMinusF1C5BW0(OffsetKt.Offset(Offset.m1337getXimpl(this.$initialFocusOffset.getPackedValue()) - Size.m1377getWidthimpl(m1380times7Ah8Wj8), Offset.m1338getYimpl(this.$initialFocusOffset.getPackedValue()) - Size.m1375getHeightimpl(m1380times7Ah8Wj8)));
                    this.label = 1;
                    if (TransformableStateKt.m249animatePanByubNVwUQ$default(transformableState, m1345unaryMinusF1C5BW0, null, this, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FerrySectionSeatsContainerKt$FerrySectionSeatsContainer$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
