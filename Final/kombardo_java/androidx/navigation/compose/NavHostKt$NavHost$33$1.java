package androidx.navigation.compose;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavHostController;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.navigation.compose.NavHostKt$NavHost$33$1", f = "NavHost.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class NavHostKt$NavHost$33$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ComposeNavigator $composeNavigator;
    final /* synthetic */ NavHostController $navController;
    final /* synthetic */ Transition<NavBackStackEntry> $transition;
    final /* synthetic */ State<List<NavBackStackEntry>> $visibleEntries$delegate;
    final /* synthetic */ Map<String, Float> $zIndices;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavHostKt$NavHost$33$1(Transition<NavBackStackEntry> transition, NavHostController navHostController, Map<String, Float> map, State<? extends List<NavBackStackEntry>> state, ComposeNavigator composeNavigator, Continuation<? super NavHostKt$NavHost$33$1> continuation) {
        super(2, continuation);
        this.$transition = transition;
        this.$navController = navHostController;
        this.$zIndices = map;
        this.$visibleEntries$delegate = state;
        this.$composeNavigator = composeNavigator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NavHostKt$NavHost$33$1(this.$transition, this.$navController, this.$zIndices, this.$visibleEntries$delegate, this.$composeNavigator, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List NavHost$lambda$17;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (Intrinsics.areEqual(this.$transition.getCurrentState(), this.$transition.getTargetState()) && (this.$navController.getCurrentBackStackEntry() == null || Intrinsics.areEqual(this.$transition.getTargetState(), this.$navController.getCurrentBackStackEntry()))) {
            NavHost$lambda$17 = NavHostKt.NavHost$lambda$17(this.$visibleEntries$delegate);
            ComposeNavigator composeNavigator = this.$composeNavigator;
            Iterator it = NavHost$lambda$17.iterator();
            while (it.hasNext()) {
                composeNavigator.onTransitionComplete((NavBackStackEntry) it.next());
            }
            Map<String, Float> map = this.$zIndices;
            Transition<NavBackStackEntry> transition = this.$transition;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, Float> entry : map.entrySet()) {
                if (!Intrinsics.areEqual(entry.getKey(), transition.getTargetState().getId())) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Map<String, Float> map2 = this.$zIndices;
            Iterator it2 = linkedHashMap.entrySet().iterator();
            while (it2.hasNext()) {
                map2.remove(((Map.Entry) it2.next()).getKey());
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NavHostKt$NavHost$33$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
