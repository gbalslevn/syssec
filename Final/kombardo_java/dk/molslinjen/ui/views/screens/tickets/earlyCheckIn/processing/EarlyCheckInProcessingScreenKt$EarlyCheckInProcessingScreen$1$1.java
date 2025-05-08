package dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing;

import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetDismissHandler;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing.EarlyCheckInProcessingScreenKt$EarlyCheckInProcessingScreen$1$1", f = "EarlyCheckInProcessingScreen.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class EarlyCheckInProcessingScreenKt$EarlyCheckInProcessingScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BottomSheetDismissHandler $bottomSheetDismissHandler;
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ float $screenHeight;
    final /* synthetic */ float $screenWith;
    final /* synthetic */ EarlyCheckInProcessingViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarlyCheckInProcessingScreenKt$EarlyCheckInProcessingScreen$1$1(EarlyCheckInProcessingViewModel earlyCheckInProcessingViewModel, float f5, float f6, BottomSheetDismissHandler bottomSheetDismissHandler, DestinationsNavigator destinationsNavigator, Continuation<? super EarlyCheckInProcessingScreenKt$EarlyCheckInProcessingScreen$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = earlyCheckInProcessingViewModel;
        this.$screenWith = f5;
        this.$screenHeight = f6;
        this.$bottomSheetDismissHandler = bottomSheetDismissHandler;
        this.$navigator = destinationsNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(BottomSheetDismissHandler bottomSheetDismissHandler, DestinationsNavigator destinationsNavigator) {
        BottomSheetDismissHandler.dismissPopBlockingSheets$default(bottomSheetDismissHandler, destinationsNavigator, null, false, 6, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EarlyCheckInProcessingScreenKt$EarlyCheckInProcessingScreen$1$1(this.$viewModel, this.$screenWith, this.$screenHeight, this.$bottomSheetDismissHandler, this.$navigator, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        EarlyCheckInProcessingViewModel earlyCheckInProcessingViewModel = this.$viewModel;
        final BottomSheetDismissHandler bottomSheetDismissHandler = this.$bottomSheetDismissHandler;
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        earlyCheckInProcessingViewModel.startEarlyCheckIn(new Function0() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit invokeSuspend$lambda$0;
                invokeSuspend$lambda$0 = EarlyCheckInProcessingScreenKt$EarlyCheckInProcessingScreen$1$1.invokeSuspend$lambda$0(BottomSheetDismissHandler.this, destinationsNavigator);
                return invokeSuspend$lambda$0;
            }
        }, this.$screenWith, this.$screenHeight);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EarlyCheckInProcessingScreenKt$EarlyCheckInProcessingScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
