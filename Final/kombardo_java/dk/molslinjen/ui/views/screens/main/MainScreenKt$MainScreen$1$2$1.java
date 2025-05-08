package dk.molslinjen.ui.views.screens.main;

import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.SnackbarResult;
import androidx.compose.runtime.MutableState;
import dk.molslinjen.core.snackbar.SnackbarMessageEvent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.main.MainScreenKt$MainScreen$1$2$1", f = "MainScreen.kt", l = {76}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class MainScreenKt$MainScreen$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<SnackbarMessageEvent> $latestSnackbarMessageEvent$delegate;
    final /* synthetic */ MainViewModel $mainViewModel;
    final /* synthetic */ SnackbarHostState $snackbarHostState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/core/snackbar/SnackbarMessageEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.main.MainScreenKt$MainScreen$1$2$1$1", f = "MainScreen.kt", l = {78, 87}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.main.MainScreenKt$MainScreen$1$2$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<SnackbarMessageEvent, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableState<SnackbarMessageEvent> $latestSnackbarMessageEvent$delegate;
        final /* synthetic */ SnackbarHostState $snackbarHostState;
        /* synthetic */ Object L$0;
        int label;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* renamed from: dk.molslinjen.ui.views.screens.main.MainScreenKt$MainScreen$1$2$1$1$WhenMappings */
        /* loaded from: classes2.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[SnackbarResult.values().length];
                try {
                    iArr[SnackbarResult.Dismissed.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[SnackbarResult.ActionPerformed.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SnackbarHostState snackbarHostState, MutableState<SnackbarMessageEvent> mutableState, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$snackbarHostState = snackbarHostState;
            this.$latestSnackbarMessageEvent$delegate = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$snackbarHostState, this.$latestSnackbarMessageEvent$delegate, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SnackbarMessageEvent snackbarMessageEvent, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(snackbarMessageEvent, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SnackbarMessageEvent snackbarMessageEvent;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                snackbarMessageEvent = (SnackbarMessageEvent) this.L$0;
                this.$latestSnackbarMessageEvent$delegate.setValue(snackbarMessageEvent);
                String message = snackbarMessageEvent.getMessage();
                String actionLabel = snackbarMessageEvent.getActionLabel();
                SnackbarDuration duration = snackbarMessageEvent.getDuration();
                SnackbarHostState snackbarHostState = this.$snackbarHostState;
                this.L$0 = snackbarMessageEvent;
                this.label = 1;
                obj = snackbarHostState.showSnackbar(message, actionLabel, true, duration, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                snackbarMessageEvent = (SnackbarMessageEvent) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            int i6 = WhenMappings.$EnumSwitchMapping$0[((SnackbarResult) obj).ordinal()];
            if (i6 == 1) {
                return Unit.INSTANCE;
            }
            if (i6 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            Function1<Continuation<? super Unit>, Object> action = snackbarMessageEvent.getAction();
            if (action != null) {
                this.L$0 = null;
                this.label = 2;
                if (action.invoke(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainScreenKt$MainScreen$1$2$1(MainViewModel mainViewModel, SnackbarHostState snackbarHostState, MutableState<SnackbarMessageEvent> mutableState, Continuation<? super MainScreenKt$MainScreen$1$2$1> continuation) {
        super(2, continuation);
        this.$mainViewModel = mainViewModel;
        this.$snackbarHostState = snackbarHostState;
        this.$latestSnackbarMessageEvent$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainScreenKt$MainScreen$1$2$1(this.$mainViewModel, this.$snackbarHostState, this.$latestSnackbarMessageEvent$delegate, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow<SnackbarMessageEvent> events = this.$mainViewModel.getEvents();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$snackbarHostState, this.$latestSnackbarMessageEvent$delegate, null);
            this.label = 1;
            if (FlowKt.collectLatest(events, anonymousClass1, this) == coroutine_suspended) {
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainScreenKt$MainScreen$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
