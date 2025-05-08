package androidx.compose.material.navigation;

import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.navigation.SheetContentHostKt$SheetContentHost$1$1", f = "SheetContentHost.kt", l = {61}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SheetContentHostKt$SheetContentHost$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NavBackStackEntry $backStackEntry;
    final /* synthetic */ State<Function1<NavBackStackEntry, Unit>> $currentOnSheetDismissed$delegate;
    final /* synthetic */ State<Function1<NavBackStackEntry, Unit>> $currentOnSheetShown$delegate;
    final /* synthetic */ ModalBottomSheetState $sheetState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SheetContentHostKt$SheetContentHost$1$1(ModalBottomSheetState modalBottomSheetState, NavBackStackEntry navBackStackEntry, State<? extends Function1<? super NavBackStackEntry, Unit>> state, State<? extends Function1<? super NavBackStackEntry, Unit>> state2, Continuation<? super SheetContentHostKt$SheetContentHost$1$1> continuation) {
        super(2, continuation);
        this.$sheetState = modalBottomSheetState;
        this.$backStackEntry = navBackStackEntry;
        this.$currentOnSheetShown$delegate = state;
        this.$currentOnSheetDismissed$delegate = state2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SheetContentHostKt$SheetContentHost$1$1(this.$sheetState, this.$backStackEntry, this.$currentOnSheetShown$delegate, this.$currentOnSheetDismissed$delegate, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            final ModalBottomSheetState modalBottomSheetState = this.$sheetState;
            Flow drop = FlowKt.drop(FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0<Boolean>() { // from class: androidx.compose.material.navigation.SheetContentHostKt$SheetContentHost$1$1.1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(ModalBottomSheetState.this.isVisible());
                }
            })), 1);
            final NavBackStackEntry navBackStackEntry = this.$backStackEntry;
            final State<Function1<NavBackStackEntry, Unit>> state = this.$currentOnSheetShown$delegate;
            final State<Function1<NavBackStackEntry, Unit>> state2 = this.$currentOnSheetDismissed$delegate;
            FlowCollector flowCollector = new FlowCollector() { // from class: androidx.compose.material.navigation.SheetContentHostKt$SheetContentHost$1$1.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                }

                public final Object emit(boolean z5, Continuation<? super Unit> continuation) {
                    Function1 SheetContentHost$lambda$1;
                    Function1 SheetContentHost$lambda$0;
                    if (z5) {
                        SheetContentHost$lambda$0 = SheetContentHostKt.SheetContentHost$lambda$0(state);
                        SheetContentHost$lambda$0.invoke(NavBackStackEntry.this);
                    } else {
                        SheetContentHost$lambda$1 = SheetContentHostKt.SheetContentHost$lambda$1(state2);
                        SheetContentHost$lambda$1.invoke(NavBackStackEntry.this);
                    }
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (drop.collect(flowCollector, this) == coroutine_suspended) {
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
        return ((SheetContentHostKt$SheetContentHost$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
