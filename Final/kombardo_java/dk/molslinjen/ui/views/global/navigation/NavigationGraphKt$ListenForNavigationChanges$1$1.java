package dk.molslinjen.ui.views.global.navigation;

import androidx.navigation.NavHostController;
import com.ramcosta.composedestinations.spec.TypedDestinationSpec;
import com.ramcosta.composedestinations.utils.NavControllerExtKt;
import dk.molslinjen.ui.views.screens.main.MainViewModel;
import java.util.Iterator;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.global.navigation.NavigationGraphKt$ListenForNavigationChanges$1$1", f = "NavigationGraph.kt", l = {97}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class NavigationGraphKt$ListenForNavigationChanges$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MainViewModel $mainViewModel;
    final /* synthetic */ NavHostController $navController;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u00030\u0003j\u0002`\u0004H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "destination", "Lcom/ramcosta/composedestinations/spec/TypedDestinationSpec;", "Lcom/ramcosta/composedestinations/spec/DestinationSpec;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.global.navigation.NavigationGraphKt$ListenForNavigationChanges$1$1$1", f = "NavigationGraph.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.global.navigation.NavigationGraphKt$ListenForNavigationChanges$1$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<TypedDestinationSpec<?>, Continuation<? super Unit>, Object> {
        final /* synthetic */ MainViewModel $mainViewModel;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MainViewModel mainViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$mainViewModel = mainViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$mainViewModel, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TypedDestinationSpec<?> typedDestinationSpec, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(typedDestinationSpec, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TypedDestinationSpec typedDestinationSpec = (TypedDestinationSpec) this.L$0;
            Iterator<T> it = ScreenConfigurationsKt.getScreenConfigurations().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                if (Intrinsics.areEqual(((SimpleScreenConfig) obj2).getDestination(), typedDestinationSpec)) {
                    break;
                }
            }
            SimpleScreenConfig simpleScreenConfig = (SimpleScreenConfig) obj2;
            if (simpleScreenConfig != null) {
                this.$mainViewModel.onNavigationWithDestinations(simpleScreenConfig);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavigationGraphKt$ListenForNavigationChanges$1$1(NavHostController navHostController, MainViewModel mainViewModel, Continuation<? super NavigationGraphKt$ListenForNavigationChanges$1$1> continuation) {
        super(2, continuation);
        this.$navController = navHostController;
        this.$mainViewModel = mainViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NavigationGraphKt$ListenForNavigationChanges$1$1(this.$navController, this.$mainViewModel, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<TypedDestinationSpec<?>> currentDestinationFlow = NavControllerExtKt.getCurrentDestinationFlow(this.$navController);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$mainViewModel, null);
            this.label = 1;
            if (FlowKt.collectLatest(currentDestinationFlow, anonymousClass1, this) == coroutine_suspended) {
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
        return ((NavigationGraphKt$ListenForNavigationChanges$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
