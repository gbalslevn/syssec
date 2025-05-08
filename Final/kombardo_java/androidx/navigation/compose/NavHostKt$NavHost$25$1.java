package androidx.navigation.compose;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.navigation.NavBackStackEntry;
import androidx.view.BackEventCompat;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/flow/Flow;", "Landroidx/activity/BackEventCompat;", "backEvent", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/flow/Flow;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.navigation.compose.NavHostKt$NavHost$25$1", f = "NavHost.kt", l = {524}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class NavHostKt$NavHost$25$1 extends SuspendLambda implements Function2<Flow<BackEventCompat>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ComposeNavigator $composeNavigator;
    final /* synthetic */ State<List<NavBackStackEntry>> $currentBackStack$delegate;
    final /* synthetic */ MutableState<Boolean> $inPredictiveBack$delegate;
    final /* synthetic */ MutableFloatState $progress$delegate;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavHostKt$NavHost$25$1(ComposeNavigator composeNavigator, State<? extends List<NavBackStackEntry>> state, MutableFloatState mutableFloatState, MutableState<Boolean> mutableState, Continuation<? super NavHostKt$NavHost$25$1> continuation) {
        super(2, continuation);
        this.$composeNavigator = composeNavigator;
        this.$currentBackStack$delegate = state;
        this.$progress$delegate = mutableFloatState;
        this.$inPredictiveBack$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NavHostKt$NavHost$25$1 navHostKt$NavHost$25$1 = new NavHostKt$NavHost$25$1(this.$composeNavigator, this.$currentBackStack$delegate, this.$progress$delegate, this.$inPredictiveBack$delegate, continuation);
        navHostKt$NavHost$25$1.L$0 = obj;
        return navHostKt$NavHost$25$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List NavHost$lambda$6;
        List NavHost$lambda$62;
        NavBackStackEntry navBackStackEntry;
        NavBackStackEntry navBackStackEntry2;
        List NavHost$lambda$63;
        List NavHost$lambda$64;
        List NavHost$lambda$65;
        List NavHost$lambda$66;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        try {
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                Flow flow = (Flow) this.L$0;
                NavHost$lambda$62 = NavHostKt.NavHost$lambda$6(this.$currentBackStack$delegate);
                if (NavHost$lambda$62.size() > 1) {
                    this.$progress$delegate.setFloatValue(0.0f);
                    NavHost$lambda$63 = NavHostKt.NavHost$lambda$6(this.$currentBackStack$delegate);
                    navBackStackEntry = (NavBackStackEntry) CollectionsKt.lastOrNull(NavHost$lambda$63);
                    ComposeNavigator composeNavigator = this.$composeNavigator;
                    Intrinsics.checkNotNull(navBackStackEntry);
                    composeNavigator.prepareForTransition(navBackStackEntry);
                    NavHost$lambda$64 = NavHostKt.NavHost$lambda$6(this.$currentBackStack$delegate);
                    NavHost$lambda$65 = NavHostKt.NavHost$lambda$6(this.$currentBackStack$delegate);
                    this.$composeNavigator.prepareForTransition((NavBackStackEntry) NavHost$lambda$64.get(NavHost$lambda$65.size() - 2));
                } else {
                    navBackStackEntry = null;
                }
                final State<List<NavBackStackEntry>> state = this.$currentBackStack$delegate;
                final MutableState<Boolean> mutableState = this.$inPredictiveBack$delegate;
                final MutableFloatState mutableFloatState = this.$progress$delegate;
                FlowCollector flowCollector = new FlowCollector() { // from class: androidx.navigation.compose.NavHostKt$NavHost$25$1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((BackEventCompat) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(BackEventCompat backEventCompat, Continuation<? super Unit> continuation) {
                        List NavHost$lambda$67;
                        NavHost$lambda$67 = NavHostKt.NavHost$lambda$6(state);
                        if (NavHost$lambda$67.size() > 1) {
                            NavHostKt.NavHost$lambda$12(mutableState, true);
                            mutableFloatState.setFloatValue(backEventCompat.getProgress());
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.L$0 = navBackStackEntry;
                this.label = 1;
                if (flow.collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                navBackStackEntry2 = navBackStackEntry;
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                navBackStackEntry2 = (NavBackStackEntry) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            NavHost$lambda$66 = NavHostKt.NavHost$lambda$6(this.$currentBackStack$delegate);
            if (NavHost$lambda$66.size() > 1) {
                NavHostKt.NavHost$lambda$12(this.$inPredictiveBack$delegate, false);
                ComposeNavigator composeNavigator2 = this.$composeNavigator;
                Intrinsics.checkNotNull(navBackStackEntry2);
                composeNavigator2.popBackStack(navBackStackEntry2, false);
            }
        } catch (CancellationException unused) {
            NavHost$lambda$6 = NavHostKt.NavHost$lambda$6(this.$currentBackStack$delegate);
            if (NavHost$lambda$6.size() > 1) {
                NavHostKt.NavHost$lambda$12(this.$inPredictiveBack$delegate, false);
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Flow<BackEventCompat> flow, Continuation<? super Unit> continuation) {
        return ((NavHostKt$NavHost$25$1) create(flow, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
