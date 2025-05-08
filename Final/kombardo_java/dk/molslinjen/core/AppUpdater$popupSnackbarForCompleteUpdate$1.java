package dk.molslinjen.core;

import com.google.android.play.core.appupdate.AppUpdateManager;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.core.snackbar.SnackbarAction;
import dk.molslinjen.core.snackbar.SnackbarEvent;
import dk.molslinjen.core.snackbar.SnackbarText;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.core.AppUpdater$popupSnackbarForCompleteUpdate$1", f = "AppUpdater.kt", l = {179}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class AppUpdater$popupSnackbarForCompleteUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ISnackbarService $snackbarService;
    int label;
    final /* synthetic */ AppUpdater this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.core.AppUpdater$popupSnackbarForCompleteUpdate$1$1", f = "AppUpdater.kt", l = {180}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.core.AppUpdater$popupSnackbarForCompleteUpdate$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ISnackbarService $snackbarService;
        int label;
        final /* synthetic */ AppUpdater this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.core.AppUpdater$popupSnackbarForCompleteUpdate$1$1$1", f = "AppUpdater.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.core.AppUpdater$popupSnackbarForCompleteUpdate$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C00321 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AppUpdater this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00321(AppUpdater appUpdater, Continuation<? super C00321> continuation) {
                super(1, continuation);
                this.this$0 = appUpdater;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> continuation) {
                return new C00321(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                AppUpdateManager appUpdateManager;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                appUpdateManager = this.this$0.appUpdateManager;
                if (appUpdateManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("appUpdateManager");
                    appUpdateManager = null;
                }
                appUpdateManager.completeUpdate();
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Continuation<? super Unit> continuation) {
                return ((C00321) create(continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ISnackbarService iSnackbarService, AppUpdater appUpdater, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$snackbarService = iSnackbarService;
            this.this$0 = appUpdater;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$snackbarService, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                ISnackbarService iSnackbarService = this.$snackbarService;
                SnackbarEvent.CompleteUpdate completeUpdate = new SnackbarEvent.CompleteUpdate(new SnackbarAction(new SnackbarText.ResourceText(R.string.forceUpdate_restart), new C00321(this.this$0, null)));
                this.label = 1;
                if (iSnackbarService.publishEvent(completeUpdate, this) == coroutine_suspended) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppUpdater$popupSnackbarForCompleteUpdate$1(ISnackbarService iSnackbarService, AppUpdater appUpdater, Continuation<? super AppUpdater$popupSnackbarForCompleteUpdate$1> continuation) {
        super(2, continuation);
        this.$snackbarService = iSnackbarService;
        this.this$0 = appUpdater;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppUpdater$popupSnackbarForCompleteUpdate$1(this.$snackbarService, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$snackbarService, this.this$0, null);
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(anonymousClass1, this) == coroutine_suspended) {
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
        return ((AppUpdater$popupSnackbarForCompleteUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
