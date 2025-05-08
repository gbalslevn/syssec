package androidx.compose.ui;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0087@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0017B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B1\b\u0002\u0012&\u0010\b\u001a\"\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u0005j\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006`\u0007¢\u0006\u0004\b\u0003\u0010\tJN\u0010\u0013\u001a\u00028\u0001\"\u0004\b\u0001\u0010\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\u000b2\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000eH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0016\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0088\u0001\b\u0092\u0001\"\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00060\u0005j\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006`\u0007¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/SessionMutex;", "T", BuildConfig.FLAVOR, "constructor-impl", "()Ljava/util/concurrent/atomic/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/ui/SessionMutex$Session;", "Landroidx/compose/ui/AtomicReference;", "currentSessionHolder", "(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/util/concurrent/atomic/AtomicReference;", "R", "Lkotlin/Function1;", "Lkotlinx/coroutines/CoroutineScope;", "sessionInitializer", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "session", "withSessionCancellingPrevious-impl", "(Ljava/util/concurrent/atomic/AtomicReference;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withSessionCancellingPrevious", "getCurrentSession-impl", "(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/lang/Object;", "currentSession", "Session", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SessionMutex<T> {

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Landroidx/compose/ui/SessionMutex$Session;", "T", BuildConfig.FLAVOR, "job", "Lkotlinx/coroutines/Job;", "value", "(Lkotlinx/coroutines/Job;Ljava/lang/Object;)V", "getJob", "()Lkotlinx/coroutines/Job;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Session<T> {
        private final Job job;
        private final T value;

        public Session(Job job, T t5) {
            this.job = job;
            this.value = t5;
        }

        public final Job getJob() {
            return this.job;
        }

        public final T getValue() {
            return this.value;
        }
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static <T> AtomicReference<Session<T>> m1253constructorimpl(AtomicReference<Session<T>> atomicReference) {
        return atomicReference;
    }

    /* renamed from: getCurrentSession-impl, reason: not valid java name */
    public static final T m1254getCurrentSessionimpl(AtomicReference<Session<T>> atomicReference) {
        Session<T> session = atomicReference.get();
        if (session != null) {
            return session.getValue();
        }
        return null;
    }

    /* renamed from: withSessionCancellingPrevious-impl, reason: not valid java name */
    public static final <R> Object m1255withSessionCancellingPreviousimpl(AtomicReference<Session<T>> atomicReference, Function1<? super CoroutineScope, ? extends T> function1, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        return CoroutineScopeKt.coroutineScope(new SessionMutex$withSessionCancellingPrevious$2(function1, atomicReference, function2, null), continuation);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> AtomicReference<Session<T>> m1252constructorimpl() {
        return m1253constructorimpl(new AtomicReference(null));
    }
}
