package dk.molslinjen.ui.views.screens.booking.addons.seating.select;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.seating.ISelectSeatingManager;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$onConfirm$2", f = "FerrySectionSeatsViewModel.kt", l = {189, 191}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class FerrySectionSeatsViewModel$onConfirm$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $onSuccessfulReservation;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FerrySectionSeatsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$onConfirm$2$2", f = "FerrySectionSeatsViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$onConfirm$2$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $onSuccessfulReservation;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function1<? super Boolean, Unit> function1, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$onSuccessfulReservation = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$onSuccessfulReservation, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$onSuccessfulReservation.invoke(Boxing.boxBoolean(true));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FerrySectionSeatsViewModel$onConfirm$2(FerrySectionSeatsViewModel ferrySectionSeatsViewModel, Function1<? super Boolean, Unit> function1, Continuation<? super FerrySectionSeatsViewModel$onConfirm$2> continuation) {
        super(2, continuation);
        this.this$0 = ferrySectionSeatsViewModel;
        this.$onSuccessfulReservation = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FerrySectionSeatsViewModel$onConfirm$2 ferrySectionSeatsViewModel$onConfirm$2 = new FerrySectionSeatsViewModel$onConfirm$2(this.this$0, this.$onSuccessfulReservation, continuation);
        ferrySectionSeatsViewModel$onConfirm$2.L$0 = obj;
        return ferrySectionSeatsViewModel$onConfirm$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        ISelectSeatingManager iSelectSeatingManager;
        Object reserve;
        ISnackbarService iSnackbarService;
        MutableStateFlow mutableStateFlow;
        Object value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            iSelectSeatingManager = this.this$0.seatReservationManager;
            this.L$0 = coroutineScope;
            this.label = 1;
            reserve = iSelectSeatingManager.reserve(this);
            if (reserve == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, FerrySectionSeatsViewModel.ViewState.m3453copyBn6Y4c$default((FerrySectionSeatsViewModel.ViewState) value, false, null, null, null, null, false, null, false, false, null, null, 2046, null)));
                return Unit.INSTANCE;
            }
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            reserve = obj;
        }
        CoroutineScope coroutineScope2 = coroutineScope;
        ManagerResult managerResult = (ManagerResult) reserve;
        if (!(managerResult instanceof ManagerResult.Error)) {
            if (!(managerResult instanceof ManagerResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            BuildersKt__Builders_commonKt.launch$default(coroutineScope2, Dispatchers.getMain(), null, new AnonymousClass2(this.$onSuccessfulReservation, null), 2, null);
            return Unit.INSTANCE;
        }
        iSnackbarService = this.this$0.snackbarService;
        this.L$0 = null;
        this.label = 2;
        if (ManagerResultExtensionsKt.handleError((ManagerResult.Error) managerResult, iSnackbarService, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        mutableStateFlow = this.this$0._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, FerrySectionSeatsViewModel.ViewState.m3453copyBn6Y4c$default((FerrySectionSeatsViewModel.ViewState) value, false, null, null, null, null, false, null, false, false, null, null, 2046, null)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FerrySectionSeatsViewModel$onConfirm$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
