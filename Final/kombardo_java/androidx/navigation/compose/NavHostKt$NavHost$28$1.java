package androidx.navigation.compose;

import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.State;
import androidx.navigation.NavBackStackEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.navigation.compose.NavHostKt$NavHost$28$1", f = "NavHost.kt", l = {621}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class NavHostKt$NavHost$28$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<List<NavBackStackEntry>> $currentBackStack$delegate;
    final /* synthetic */ MutableFloatState $progress$delegate;
    final /* synthetic */ SeekableTransitionState<NavBackStackEntry> $transitionState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavHostKt$NavHost$28$1(SeekableTransitionState<NavBackStackEntry> seekableTransitionState, State<? extends List<NavBackStackEntry>> state, MutableFloatState mutableFloatState, Continuation<? super NavHostKt$NavHost$28$1> continuation) {
        super(2, continuation);
        this.$transitionState = seekableTransitionState;
        this.$currentBackStack$delegate = state;
        this.$progress$delegate = mutableFloatState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NavHostKt$NavHost$28$1(this.$transitionState, this.$currentBackStack$delegate, this.$progress$delegate, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List NavHost$lambda$6;
        List NavHost$lambda$62;
        float floatValue;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            NavHost$lambda$6 = NavHostKt.NavHost$lambda$6(this.$currentBackStack$delegate);
            NavHost$lambda$62 = NavHostKt.NavHost$lambda$6(this.$currentBackStack$delegate);
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) NavHost$lambda$6.get(NavHost$lambda$62.size() - 2);
            SeekableTransitionState<NavBackStackEntry> seekableTransitionState = this.$transitionState;
            floatValue = this.$progress$delegate.getFloatValue();
            this.label = 1;
            if (seekableTransitionState.seekTo(floatValue, navBackStackEntry, this) == coroutine_suspended) {
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
        return ((NavHostKt$NavHost$28$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
