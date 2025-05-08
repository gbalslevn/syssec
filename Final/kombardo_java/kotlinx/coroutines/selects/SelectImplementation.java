package kotlinx.coroutines.selects;

import androidx.concurrent.futures.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.Symbol;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004:\u0001LB\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00028\u0000H\u0091@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ5\u0010\u0010\u001a\u00020\u000f*\u00020\u000b2\u001c\u0010\u000e\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00010\u00040\fH\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011JG\u0010\u0010\u001a\u00020\u000f\"\u0004\b\u0001\u0010\u0012*\b\u0012\u0004\u0012\u00028\u00010\u00132\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0015J'\u0010\u0019\u001a\u00020\u000f*\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010#\u001a\u00020\u000f2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030\u001f2\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010&\u001a\u00020\u000f2\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b&\u0010'J!\u0010*\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b*\u0010+J\u001f\u0010-\u001a\u00020,2\u0006\u0010(\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b-\u0010.J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u00100\u001a\u0004\u0018\u00010/H\u0096\u0002¢\u0006\u0004\b\u0010\u00101J\u0013\u00102\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b2\u0010\nJ\u0017\u00103\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u0004H\u0002¢\u0006\u0004\b3\u0010'J\u0013\u00104\u001a\u00020\u000fH\u0082@ø\u0001\u0000¢\u0006\u0004\b4\u0010\nJ\u0017\u00105\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u0004H\u0002¢\u0006\u0004\b5\u0010'J!\u00106\u001a\u00020!2\u0006\u0010(\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b6\u00107J#\u00108\u001a\u000e\u0018\u00010\u0016R\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010(\u001a\u00020\u0004H\u0002¢\u0006\u0004\b8\u00109J\u0013\u0010:\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b:\u0010\nJ!\u0010<\u001a\u00020\u000f2\u0010\u0010;\u001a\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002¢\u0006\u0004\b<\u0010=R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010>\u001a\u0004\b?\u0010@R(\u0010B\u001a\u0014\u0012\u000e\u0012\f0\u0016R\b\u0012\u0004\u0012\u00028\u00000\u0000\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010D\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010%\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010ER\u0014\u0010H\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0011\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00040J8\u0002X\u0082\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006M"}, d2 = {"Lkotlinx/coroutines/selects/SelectImplementation;", "R", "Lkotlinx/coroutines/CancelHandler;", "Lkotlinx/coroutines/selects/SelectBuilder;", BuildConfig.FLAVOR, "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "doSelect", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectClause0;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "block", BuildConfig.FLAVOR, "invoke", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", BuildConfig.FLAVOR, "reregister", "register", "(Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;Z)V", "Lkotlinx/coroutines/DisposableHandle;", "disposableHandle", "disposeOnCompletion", "(Lkotlinx/coroutines/DisposableHandle;)V", "Lkotlinx/coroutines/internal/Segment;", "segment", BuildConfig.FLAVOR, "index", "invokeOnCancellation", "(Lkotlinx/coroutines/internal/Segment;I)V", "internalResult", "selectInRegistrationPhase", "(Ljava/lang/Object;)V", "clauseObject", "result", "trySelect", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "trySelectDetailed", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlinx/coroutines/selects/TrySelectDetailedResult;", BuildConfig.FLAVOR, "cause", "(Ljava/lang/Throwable;)V", "doSelectSuspend", "checkClauseObject", "waitUntilSelected", "reregisterClause", "trySelectInternal", "(Ljava/lang/Object;Ljava/lang/Object;)I", "findClause", "(Ljava/lang/Object;)Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", "complete", "selectedClause", "cleanup", "(Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;)V", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", BuildConfig.FLAVOR, "clauses", "Ljava/util/List;", "disposableHandleOrSegment", "Ljava/lang/Object;", "indexInSegment", "I", "isSelected", "()Z", "Lkotlinx/atomicfu/AtomicRef;", "state", "ClauseData", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public class SelectImplementation<R> extends CancelHandler implements SelectBuilder<R>, SelectInstance, Waiter {
    private static final AtomicReferenceFieldUpdater state$FU = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state");
    private List<SelectImplementation<R>.ClauseData> clauses;
    private final CoroutineContext context;
    private Object disposableHandleOrSegment;
    private int indexInSegment;
    private Object internalResult;
    private volatile Object state;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B±\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012(\u0010\u0007\u001a$\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0006\u0012(\u0010\t\u001a$\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003j\u0002`\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000b\u001a\u00020\u0001\u0012:\u0010\u000f\u001a6\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\f\u0018\u00010\u0003j\u0004\u0018\u0001`\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0015\u001a\u00020\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001b\u001a\u00028\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ1\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b \u0010!R\u0014\u0010\u0002\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\"R6\u0010\u0007\u001a$\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010#R6\u0010\t\u001a$\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003j\u0002`\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010#R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\"R\u0014\u0010\u000b\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\"RH\u0010\u000f\u001a6\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\f\u0018\u00010\u0003j\u0004\u0018\u0001`\u000e8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010&\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b&\u0010'\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lkotlinx/coroutines/selects/SelectImplementation$ClauseData;", BuildConfig.FLAVOR, "clauseObject", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/selects/RegistrationFunction;", "regFunc", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "processResFunc", "param", "block", "Lkotlin/Function1;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "onCancellationConstructor", "<init>", "(Lkotlinx/coroutines/selects/SelectImplementation;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "Lkotlinx/coroutines/selects/SelectImplementation;", "select", BuildConfig.FLAVOR, "tryRegisterAsWaiter", "(Lkotlinx/coroutines/selects/SelectImplementation;)Z", "result", "processResult", "(Ljava/lang/Object;)Ljava/lang/Object;", "argument", "invokeBlock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispose", "()V", "internalResult", "createOnCancellationAction", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "Ljava/lang/Object;", "Lkotlin/jvm/functions/Function3;", "disposableHandleOrSegment", BuildConfig.FLAVOR, "indexInSegment", "I", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class ClauseData {
        private final Object block;
        public final Object clauseObject;
        public Object disposableHandleOrSegment;
        public int indexInSegment = -1;
        public final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onCancellationConstructor;
        private final Object param;
        private final Function3<Object, Object, Object, Object> processResFunc;
        private final Function3<Object, SelectInstance<?>, Object, Unit> regFunc;

        /* JADX WARN: Multi-variable type inference failed */
        public ClauseData(Object obj, Function3<Object, ? super SelectInstance<?>, Object, Unit> function3, Function3<Object, Object, Object, ? extends Object> function32, Object obj2, Object obj3, Function3<? super SelectInstance<?>, Object, Object, ? extends Function1<? super Throwable, Unit>> function33) {
            this.clauseObject = obj;
            this.regFunc = function3;
            this.processResFunc = function32;
            this.param = obj2;
            this.block = obj3;
            this.onCancellationConstructor = function33;
        }

        public final Function1<Throwable, Unit> createOnCancellationAction(SelectInstance<?> select, Object internalResult) {
            Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> function3 = this.onCancellationConstructor;
            if (function3 != null) {
                return function3.invoke(select, this.param, internalResult);
            }
            return null;
        }

        public final void dispose() {
            Object obj = this.disposableHandleOrSegment;
            SelectImplementation<R> selectImplementation = SelectImplementation.this;
            if (obj instanceof Segment) {
                ((Segment) obj).onCancellation(this.indexInSegment, null, selectImplementation.getContext());
                return;
            }
            DisposableHandle disposableHandle = obj instanceof DisposableHandle ? (DisposableHandle) obj : null;
            if (disposableHandle != null) {
                disposableHandle.dispose();
            }
        }

        public final Object invokeBlock(Object obj, Continuation<? super R> continuation) {
            Object obj2 = this.block;
            if (this.param == SelectKt.getPARAM_CLAUSE_0()) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction0<R of kotlinx.coroutines.selects.SelectImplementation>");
                return ((Function1) obj2).invoke(continuation);
            }
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.coroutines.SuspendFunction1<kotlin.Any?, R of kotlinx.coroutines.selects.SelectImplementation>");
            return ((Function2) obj2).invoke(obj, continuation);
        }

        public final Object processResult(Object result) {
            return this.processResFunc.invoke(this.clauseObject, this.param, result);
        }

        public final boolean tryRegisterAsWaiter(SelectImplementation<R> select) {
            Symbol symbol;
            this.regFunc.invoke(this.clauseObject, select, this.param);
            Object obj = ((SelectImplementation) select).internalResult;
            symbol = SelectKt.NO_RESULT;
            return obj == symbol;
        }
    }

    public SelectImplementation(CoroutineContext coroutineContext) {
        Symbol symbol;
        Symbol symbol2;
        this.context = coroutineContext;
        symbol = SelectKt.STATE_REG;
        this.state = symbol;
        this.clauses = new ArrayList(2);
        this.indexInSegment = -1;
        symbol2 = SelectKt.NO_RESULT;
        this.internalResult = symbol2;
    }

    private final void checkClauseObject(Object clauseObject) {
        List<SelectImplementation<R>.ClauseData> list = this.clauses;
        Intrinsics.checkNotNull(list);
        List<SelectImplementation<R>.ClauseData> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return;
        }
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            if (((ClauseData) it.next()).clauseObject == clauseObject) {
                throw new IllegalStateException(("Cannot use select clauses on the same object: " + clauseObject).toString());
            }
        }
    }

    private final void cleanup(SelectImplementation<R>.ClauseData selectedClause) {
        Symbol symbol;
        Symbol symbol2;
        List<SelectImplementation<R>.ClauseData> list = this.clauses;
        if (list == null) {
            return;
        }
        for (SelectImplementation<R>.ClauseData clauseData : list) {
            if (clauseData != selectedClause) {
                clauseData.dispose();
            }
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$FU;
        symbol = SelectKt.STATE_COMPLETED;
        atomicReferenceFieldUpdater.set(this, symbol);
        symbol2 = SelectKt.NO_RESULT;
        this.internalResult = symbol2;
        this.clauses = null;
    }

    private final Object complete(Continuation<? super R> continuation) {
        Object obj = state$FU.get(this);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation.ClauseData<R of kotlinx.coroutines.selects.SelectImplementation>");
        SelectImplementation<R>.ClauseData clauseData = (ClauseData) obj;
        Object obj2 = this.internalResult;
        cleanup(clauseData);
        return clauseData.invokeBlock(clauseData.processResult(obj2), continuation);
    }

    static /* synthetic */ <R> Object doSelect$suspendImpl(SelectImplementation<R> selectImplementation, Continuation<? super R> continuation) {
        return selectImplementation.isSelected() ? selectImplementation.complete(continuation) : selectImplementation.doSelectSuspend(continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0057 A[PHI: r6
      0x0057: PHI (r6v5 java.lang.Object) = (r6v4 java.lang.Object), (r6v1 java.lang.Object) binds: [B:17:0x0054, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object doSelectSuspend(Continuation<? super R> continuation) {
        SelectImplementation$doSelectSuspend$1 selectImplementation$doSelectSuspend$1;
        int i5;
        SelectImplementation<R> selectImplementation;
        if (continuation instanceof SelectImplementation$doSelectSuspend$1) {
            selectImplementation$doSelectSuspend$1 = (SelectImplementation$doSelectSuspend$1) continuation;
            int i6 = selectImplementation$doSelectSuspend$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                selectImplementation$doSelectSuspend$1.label = i6 - Integer.MIN_VALUE;
                Object obj = selectImplementation$doSelectSuspend$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = selectImplementation$doSelectSuspend$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    selectImplementation$doSelectSuspend$1.L$0 = this;
                    selectImplementation$doSelectSuspend$1.label = 1;
                    if (waitUntilSelected(selectImplementation$doSelectSuspend$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    selectImplementation = this;
                } else {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    selectImplementation = (SelectImplementation) selectImplementation$doSelectSuspend$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                selectImplementation$doSelectSuspend$1.L$0 = null;
                selectImplementation$doSelectSuspend$1.label = 2;
                obj = selectImplementation.complete(selectImplementation$doSelectSuspend$1);
                return obj != coroutine_suspended ? coroutine_suspended : obj;
            }
        }
        selectImplementation$doSelectSuspend$1 = new SelectImplementation$doSelectSuspend$1(this, continuation);
        Object obj2 = selectImplementation$doSelectSuspend$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = selectImplementation$doSelectSuspend$1.label;
        if (i5 != 0) {
        }
        selectImplementation$doSelectSuspend$1.L$0 = null;
        selectImplementation$doSelectSuspend$1.label = 2;
        obj2 = selectImplementation.complete(selectImplementation$doSelectSuspend$1);
        if (obj2 != coroutine_suspended2) {
        }
    }

    private final SelectImplementation<R>.ClauseData findClause(Object clauseObject) {
        List<SelectImplementation<R>.ClauseData> list = this.clauses;
        Object obj = null;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((ClauseData) next).clauseObject == clauseObject) {
                obj = next;
                break;
            }
        }
        SelectImplementation<R>.ClauseData clauseData = (ClauseData) obj;
        if (clauseData != null) {
            return clauseData;
        }
        throw new IllegalStateException(("Clause with object " + clauseObject + " is not found").toString());
    }

    private final boolean isSelected() {
        return state$FU.get(this) instanceof ClauseData;
    }

    public static /* synthetic */ void register$default(SelectImplementation selectImplementation, ClauseData clauseData, boolean z5, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
        }
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        selectImplementation.register(clauseData, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reregisterClause(Object clauseObject) {
        SelectImplementation<R>.ClauseData findClause = findClause(clauseObject);
        Intrinsics.checkNotNull(findClause);
        findClause.disposableHandleOrSegment = null;
        findClause.indexInSegment = -1;
        register(findClause, true);
    }

    private final int trySelectInternal(Object clauseObject, Object internalResult) {
        boolean tryResume;
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$FU;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof CancellableContinuation) {
                SelectImplementation<R>.ClauseData findClause = findClause(clauseObject);
                if (findClause == null) {
                    continue;
                } else {
                    Function1<Throwable, Unit> createOnCancellationAction = findClause.createOnCancellationAction(this, internalResult);
                    if (a.a(atomicReferenceFieldUpdater, this, obj, findClause)) {
                        this.internalResult = internalResult;
                        tryResume = SelectKt.tryResume((CancellableContinuation) obj, createOnCancellationAction);
                        if (tryResume) {
                            return 0;
                        }
                        this.internalResult = null;
                        return 2;
                    }
                }
            } else {
                symbol = SelectKt.STATE_COMPLETED;
                if (Intrinsics.areEqual(obj, symbol) ? true : obj instanceof ClauseData) {
                    return 3;
                }
                symbol2 = SelectKt.STATE_CANCELLED;
                if (Intrinsics.areEqual(obj, symbol2)) {
                    return 2;
                }
                symbol3 = SelectKt.STATE_REG;
                if (Intrinsics.areEqual(obj, symbol3)) {
                    if (a.a(atomicReferenceFieldUpdater, this, obj, CollectionsKt.listOf(clauseObject))) {
                        return 1;
                    }
                } else {
                    if (!(obj instanceof List)) {
                        throw new IllegalStateException(("Unexpected state: " + obj).toString());
                    }
                    if (a.a(atomicReferenceFieldUpdater, this, obj, CollectionsKt.plus((Collection<? extends Object>) obj, clauseObject))) {
                        return 1;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0062, code lost:
    
        r0 = r0.getResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
    
        if (r0 != kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
    
        kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0073, code lost:
    
        if (r0 != kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0078, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Object waitUntilSelected(Continuation<? super Unit> continuation) {
        Symbol symbol;
        Symbol symbol2;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$FU;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            symbol = SelectKt.STATE_REG;
            if (obj == symbol) {
                if (a.a(state$FU, this, obj, cancellableContinuationImpl)) {
                    cancellableContinuationImpl.invokeOnCancellation(this);
                    break;
                }
            } else if (obj instanceof List) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = state$FU;
                symbol2 = SelectKt.STATE_REG;
                if (a.a(atomicReferenceFieldUpdater2, this, obj, symbol2)) {
                    Iterator it = ((Iterable) obj).iterator();
                    while (it.hasNext()) {
                        reregisterClause(it.next());
                    }
                }
            } else {
                if (!(obj instanceof ClauseData)) {
                    throw new IllegalStateException(("unexpected state: " + obj).toString());
                }
                cancellableContinuationImpl.resume(Unit.INSTANCE, ((ClauseData) obj).createOnCancellationAction(this, this.internalResult));
            }
        }
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void disposeOnCompletion(DisposableHandle disposableHandle) {
        this.disposableHandleOrSegment = disposableHandle;
    }

    public Object doSelect(Continuation<? super R> continuation) {
        return doSelect$suspendImpl(this, continuation);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public CoroutineContext getContext() {
        return this.context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.Waiter
    public void invokeOnCancellation(Segment<?> segment, int index) {
        this.disposableHandleOrSegment = segment;
        this.indexInSegment = index;
    }

    public final void register(SelectImplementation<R>.ClauseData clauseData, boolean z5) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$FU;
        if (atomicReferenceFieldUpdater.get(this) instanceof ClauseData) {
            return;
        }
        if (!z5) {
            checkClauseObject(clauseData.clauseObject);
        }
        if (!clauseData.tryRegisterAsWaiter(this)) {
            atomicReferenceFieldUpdater.set(this, clauseData);
            return;
        }
        if (!z5) {
            List<SelectImplementation<R>.ClauseData> list = this.clauses;
            Intrinsics.checkNotNull(list);
            list.add(clauseData);
        }
        clauseData.disposableHandleOrSegment = this.disposableHandleOrSegment;
        clauseData.indexInSegment = this.indexInSegment;
        this.disposableHandleOrSegment = null;
        this.indexInSegment = -1;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void selectInRegistrationPhase(Object internalResult) {
        this.internalResult = internalResult;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean trySelect(Object clauseObject, Object result) {
        return trySelectInternal(clauseObject, result) == 0;
    }

    public final TrySelectDetailedResult trySelectDetailed(Object clauseObject, Object result) {
        TrySelectDetailedResult TrySelectDetailedResult;
        TrySelectDetailedResult = SelectKt.TrySelectDetailedResult(trySelectInternal(clauseObject, result));
        return TrySelectDetailedResult;
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(SelectClause0 selectClause0, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        register$default(this, new ClauseData(selectClause0.getClauseObject(), selectClause0.getRegFunc(), selectClause0.getProcessResFunc(), SelectKt.getPARAM_CLAUSE_0(), function1, selectClause0.getOnCancellationConstructor()), false, 1, null);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <Q> void invoke(SelectClause1<? extends Q> selectClause1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        register$default(this, new ClauseData(selectClause1.getClauseObject(), selectClause1.getRegFunc(), selectClause1.getProcessResFunc(), null, function2, selectClause1.getOnCancellationConstructor()), false, 1, null);
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(Throwable cause) {
        Object obj;
        Symbol symbol;
        Symbol symbol2;
        Symbol symbol3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = state$FU;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            symbol = SelectKt.STATE_COMPLETED;
            if (obj == symbol) {
                return;
            } else {
                symbol2 = SelectKt.STATE_CANCELLED;
            }
        } while (!a.a(atomicReferenceFieldUpdater, this, obj, symbol2));
        List<SelectImplementation<R>.ClauseData> list = this.clauses;
        if (list == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((ClauseData) it.next()).dispose();
        }
        symbol3 = SelectKt.NO_RESULT;
        this.internalResult = symbol3;
        this.clauses = null;
    }
}
