package androidx.navigation.compose;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TweenSpec;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.navigation.compose.NavHostKt$NavHost$29$1", f = "NavHost.kt", l = {628, 635}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class NavHostKt$NavHost$29$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NavBackStackEntry $backStackEntry;
    final /* synthetic */ Transition<NavBackStackEntry> $transition;
    final /* synthetic */ SeekableTransitionState<NavBackStackEntry> $transitionState;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavHostKt$NavHost$29$1(SeekableTransitionState<NavBackStackEntry> seekableTransitionState, NavBackStackEntry navBackStackEntry, Transition<NavBackStackEntry> transition, Continuation<? super NavHostKt$NavHost$29$1> continuation) {
        super(2, continuation);
        this.$transitionState = seekableTransitionState;
        this.$backStackEntry = navBackStackEntry;
        this.$transition = transition;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        NavHostKt$NavHost$29$1 navHostKt$NavHost$29$1 = new NavHostKt$NavHost$29$1(this.$transitionState, this.$backStackEntry, this.$transition, continuation);
        navHostKt$NavHost$29$1.L$0 = obj;
        return navHostKt$NavHost$29$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (Intrinsics.areEqual(this.$transitionState.getCurrentState(), this.$backStackEntry)) {
                long totalDurationNanos = this.$transition.getTotalDurationNanos() / 1000000;
                float fraction = this.$transitionState.getFraction();
                TweenSpec tween$default = AnimationSpecKt.tween$default((int) (this.$transitionState.getFraction() * ((float) totalDurationNanos)), 0, null, 6, null);
                final SeekableTransitionState<NavBackStackEntry> seekableTransitionState = this.$transitionState;
                final NavBackStackEntry navBackStackEntry = this.$backStackEntry;
                Function2<Float, Float, Unit> function2 = new Function2<Float, Float, Unit>() { // from class: androidx.navigation.compose.NavHostKt$NavHost$29$1.1

                    /* JADX INFO: Access modifiers changed from: package-private */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.navigation.compose.NavHostKt$NavHost$29$1$1$1", f = "NavHost.kt", l = {643, 647}, m = "invokeSuspend")
                    /* renamed from: androidx.navigation.compose.NavHostKt$NavHost$29$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* loaded from: classes.dex */
                    public static final class C00241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ NavBackStackEntry $backStackEntry;
                        final /* synthetic */ SeekableTransitionState<NavBackStackEntry> $transitionState;
                        final /* synthetic */ float $value;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C00241(float f5, SeekableTransitionState<NavBackStackEntry> seekableTransitionState, NavBackStackEntry navBackStackEntry, Continuation<? super C00241> continuation) {
                            super(2, continuation);
                            this.$value = f5;
                            this.$transitionState = seekableTransitionState;
                            this.$backStackEntry = navBackStackEntry;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C00241(this.$value, this.$transitionState, this.$backStackEntry, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i5 = this.label;
                            if (i5 == 0) {
                                ResultKt.throwOnFailure(obj);
                                float f5 = this.$value;
                                if (f5 > 0.0f) {
                                    SeekableTransitionState<NavBackStackEntry> seekableTransitionState = this.$transitionState;
                                    this.label = 1;
                                    if (SeekableTransitionState.seekTo$default(seekableTransitionState, f5, null, this, 2, null) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            } else {
                                if (i5 != 1) {
                                    if (i5 != 2) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                    return Unit.INSTANCE;
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            if (this.$value == 0.0f) {
                                SeekableTransitionState<NavBackStackEntry> seekableTransitionState2 = this.$transitionState;
                                NavBackStackEntry navBackStackEntry = this.$backStackEntry;
                                this.label = 2;
                                if (seekableTransitionState2.snapTo(navBackStackEntry, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.INSTANCE;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C00241) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Float f5, Float f6) {
                        invoke(f5.floatValue(), f6.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f5, float f6) {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScope.this, null, null, new C00241(f5, seekableTransitionState, navBackStackEntry, null), 3, null);
                    }
                };
                this.label = 2;
                if (SuspendAnimationKt.animate$default(fraction, 0.0f, 0.0f, tween$default, function2, this, 4, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                SeekableTransitionState<NavBackStackEntry> seekableTransitionState2 = this.$transitionState;
                NavBackStackEntry navBackStackEntry2 = this.$backStackEntry;
                this.label = 1;
                if (SeekableTransitionState.animateTo$default(seekableTransitionState2, navBackStackEntry2, null, this, 2, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i5 != 1 && i5 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NavHostKt$NavHost$29$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
