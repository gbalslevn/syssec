package coil.content;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0081@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"Landroidx/lifecycle/Lifecycle;", BuildConfig.FLAVOR, "awaitStarted", "(Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* renamed from: coil.util.-Lifecycles, reason: invalid class name */
/* loaded from: classes.dex */
public abstract class Lifecycles {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, coil.util.-Lifecycles$awaitStarted$2$1, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitStarted(Lifecycle lifecycle, Continuation<? super Unit> continuation) {
        Lifecycles$awaitStarted$1 lifecycles$awaitStarted$1;
        int i5;
        Lifecycle lifecycle2;
        Ref$ObjectRef ref$ObjectRef;
        Throwable th;
        LifecycleObserver lifecycleObserver;
        LifecycleObserver lifecycleObserver2;
        if (continuation instanceof Lifecycles$awaitStarted$1) {
            lifecycles$awaitStarted$1 = (Lifecycles$awaitStarted$1) continuation;
            int i6 = lifecycles$awaitStarted$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                lifecycles$awaitStarted$1.label = i6 - Integer.MIN_VALUE;
                Object obj = lifecycles$awaitStarted$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = lifecycles$awaitStarted$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (lifecycle.getState().isAtLeast(Lifecycle.State.STARTED)) {
                        return Unit.INSTANCE;
                    }
                    Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                    try {
                        lifecycles$awaitStarted$1.L$0 = lifecycle;
                        lifecycles$awaitStarted$1.L$1 = ref$ObjectRef2;
                        lifecycles$awaitStarted$1.label = 1;
                        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(lifecycles$awaitStarted$1), 1);
                        cancellableContinuationImpl.initCancellability();
                        ?? r32 = new DefaultLifecycleObserver() { // from class: coil.util.-Lifecycles$awaitStarted$2$1
                            @Override // androidx.lifecycle.DefaultLifecycleObserver
                            public void onStart(LifecycleOwner owner) {
                                CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl;
                                Result.Companion companion = Result.INSTANCE;
                                cancellableContinuation.resumeWith(Result.m3567constructorimpl(Unit.INSTANCE));
                            }
                        };
                        ref$ObjectRef2.element = r32;
                        Intrinsics.checkNotNull(r32);
                        lifecycle.addObserver((LifecycleObserver) r32);
                        Object result = cancellableContinuationImpl.getResult();
                        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended(lifecycles$awaitStarted$1);
                        }
                        if (result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        lifecycle2 = lifecycle;
                        ref$ObjectRef = ref$ObjectRef2;
                    } catch (Throwable th2) {
                        lifecycle2 = lifecycle;
                        ref$ObjectRef = ref$ObjectRef2;
                        th = th2;
                        lifecycleObserver = (LifecycleObserver) ref$ObjectRef.element;
                        if (lifecycleObserver != null) {
                            lifecycle2.removeObserver(lifecycleObserver);
                        }
                        throw th;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ref$ObjectRef = (Ref$ObjectRef) lifecycles$awaitStarted$1.L$1;
                    lifecycle2 = (Lifecycle) lifecycles$awaitStarted$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        lifecycleObserver = (LifecycleObserver) ref$ObjectRef.element;
                        if (lifecycleObserver != null) {
                        }
                        throw th;
                    }
                }
                lifecycleObserver2 = (LifecycleObserver) ref$ObjectRef.element;
                if (lifecycleObserver2 != null) {
                    lifecycle2.removeObserver(lifecycleObserver2);
                }
                return Unit.INSTANCE;
            }
        }
        lifecycles$awaitStarted$1 = new Lifecycles$awaitStarted$1(continuation);
        Object obj2 = lifecycles$awaitStarted$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = lifecycles$awaitStarted$1.label;
        if (i5 != 0) {
        }
        lifecycleObserver2 = (LifecycleObserver) ref$ObjectRef.element;
        if (lifecycleObserver2 != null) {
        }
        return Unit.INSTANCE;
    }
}
