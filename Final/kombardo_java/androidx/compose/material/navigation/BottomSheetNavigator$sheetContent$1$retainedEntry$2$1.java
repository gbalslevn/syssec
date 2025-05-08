package androidx.compose.material.navigation;

import androidx.compose.runtime.ProduceStateScope;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Landroidx/compose/runtime/ProduceStateScope;", "Landroidx/navigation/NavBackStackEntry;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.navigation.BottomSheetNavigator$sheetContent$1$retainedEntry$2$1", f = "BottomSheetNavigator.kt", l = {171}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class BottomSheetNavigator$sheetContent$1$retainedEntry$2$1 extends SuspendLambda implements Function2<ProduceStateScope<NavBackStackEntry>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BottomSheetNavigator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetNavigator$sheetContent$1$retainedEntry$2$1(BottomSheetNavigator bottomSheetNavigator, Continuation<? super BottomSheetNavigator$sheetContent$1$retainedEntry$2$1> continuation) {
        super(2, continuation);
        this.this$0 = bottomSheetNavigator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BottomSheetNavigator$sheetContent$1$retainedEntry$2$1 bottomSheetNavigator$sheetContent$1$retainedEntry$2$1 = new BottomSheetNavigator$sheetContent$1$retainedEntry$2$1(this.this$0, continuation);
        bottomSheetNavigator$sheetContent$1$retainedEntry$2$1.L$0 = obj;
        return bottomSheetNavigator$sheetContent$1$retainedEntry$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProduceStateScope<NavBackStackEntry> produceStateScope, Continuation<? super Unit> continuation) {
        return ((BottomSheetNavigator$sheetContent$1$retainedEntry$2$1) create(produceStateScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        StateFlow backStack;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            final ProduceStateScope produceStateScope = (ProduceStateScope) this.L$0;
            backStack = this.this$0.getBackStack();
            Flow flow = FlowKt.flow(new BottomSheetNavigator$sheetContent$1$retainedEntry$2$1$invokeSuspend$$inlined$transform$1(backStack, null, this.this$0));
            FlowCollector flowCollector = new FlowCollector() { // from class: androidx.compose.material.navigation.BottomSheetNavigator$sheetContent$1$retainedEntry$2$1.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((NavBackStackEntry) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(NavBackStackEntry navBackStackEntry, Continuation<? super Unit> continuation) {
                    produceStateScope.setValue(navBackStackEntry);
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (flow.collect(flowCollector, this) == coroutine_suspended) {
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
}
