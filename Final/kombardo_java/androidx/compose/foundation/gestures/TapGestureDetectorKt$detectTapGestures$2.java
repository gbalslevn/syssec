package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2", f = "TapGestureDetector.kt", l = {99}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class TapGestureDetectorKt$detectTapGestures$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
    final /* synthetic */ Function1<Offset, Unit> $onLongPress;
    final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
    final /* synthetic */ Function1<Offset, Unit> $onTap;
    final /* synthetic */ PointerInputScope $this_detectTapGestures;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1", f = "TapGestureDetector.kt", l = {100, 114, 129, 141, 156, 178}, m = "invokeSuspend")
    /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $$this$coroutineScope;
        final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
        final /* synthetic */ Function1<Offset, Unit> $onLongPress;
        final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
        final /* synthetic */ Function1<Offset, Unit> $onTap;
        final /* synthetic */ PressGestureScopeImpl $pressScope;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1", f = "TapGestureDetector.kt", l = {103}, m = "invokeSuspend")
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C00041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00041(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C00041> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00041(this.$pressScope, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                    this.label = 1;
                    if (pressGestureScopeImpl.reset(this) == coroutine_suspended) {
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
                return ((C00041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$10", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$10, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass10(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass10> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass10(this.$pressScope, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$pressScope.release();
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass10) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2", f = "TapGestureDetector.kt", l = {106}, m = "invokeSuspend")
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$2, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PointerInputChange $down;
            final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$onPress = function3;
                this.$pressScope = pressGestureScopeImpl;
                this.$down = pointerInputChange;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$onPress, this.$pressScope, this.$down, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
                    PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                    Offset m1328boximpl = Offset.m1328boximpl(this.$down.getPosition());
                    this.label = 1;
                    if (function3.invoke(pressGestureScopeImpl, m1328boximpl, this) == coroutine_suspended) {
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
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3", f = "TapGestureDetector.kt", l = {115}, m = "invokeSuspend")
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$3, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass3 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
            private /* synthetic */ Object L$0;
            int label;

            AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
                return ((AnonymousClass3) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    this.label = 1;
                    obj = TapGestureDetectorKt.waitForUpOrCancellation$default(awaitPointerEventScope, null, this, 1, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return obj;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$4, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass4(this.$pressScope, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$pressScope.cancel();
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$5, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass5(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass5> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass5(this.$pressScope, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$pressScope.release();
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$6, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass6(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass6> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass6(this.$pressScope, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$pressScope.release();
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7", f = "TapGestureDetector.kt", l = {148}, m = "invokeSuspend")
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$7, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass7(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass7> continuation) {
                super(2, continuation);
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass7(this.$pressScope, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                    this.label = 1;
                    if (pressGestureScopeImpl.reset(this) == coroutine_suspended) {
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
                return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8", f = "TapGestureDetector.kt", l = {151}, m = "invokeSuspend")
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$8, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> $onPress;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            final /* synthetic */ PointerInputChange $secondDown;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass8(Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, PressGestureScopeImpl pressGestureScopeImpl, PointerInputChange pointerInputChange, Continuation<? super AnonymousClass8> continuation) {
                super(2, continuation);
                this.$onPress = function3;
                this.$pressScope = pressGestureScopeImpl;
                this.$secondDown = pointerInputChange;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass8(this.$onPress, this.$pressScope, this.$secondDown, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.$onPress;
                    PressGestureScopeImpl pressGestureScopeImpl = this.$pressScope;
                    Offset m1328boximpl = Offset.m1328boximpl(this.$secondDown.getPosition());
                    this.label = 1;
                    if (function3.invoke(pressGestureScopeImpl, m1328boximpl, this) == coroutine_suspended) {
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
                return ((AnonymousClass8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9", f = "TapGestureDetector.kt", l = {157}, m = "invokeSuspend")
        /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9, reason: invalid class name */
        /* loaded from: classes.dex */
        public static final class AnonymousClass9 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function1<Offset, Unit> $onDoubleTap;
            final /* synthetic */ Function1<Offset, Unit> $onTap;
            final /* synthetic */ PressGestureScopeImpl $pressScope;
            final /* synthetic */ Ref$ObjectRef<PointerInputChange> $upOrCancel;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9$1", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
            /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9$1, reason: invalid class name and collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C00051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00051(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super C00051> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C00051(this.$pressScope, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.$pressScope.release();
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9$2", f = "TapGestureDetector.kt", l = {}, m = "invokeSuspend")
            /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1$9$2, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PressGestureScopeImpl $pressScope;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$pressScope = pressGestureScopeImpl;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.$pressScope, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.$pressScope.cancel();
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass9(CoroutineScope coroutineScope, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Ref$ObjectRef<PointerInputChange> ref$ObjectRef, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass9> continuation) {
                super(2, continuation);
                this.$$this$coroutineScope = coroutineScope;
                this.$onDoubleTap = function1;
                this.$onTap = function12;
                this.$upOrCancel = ref$ObjectRef;
                this.$pressScope = pressGestureScopeImpl;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass9 anonymousClass9 = new AnonymousClass9(this.$$this$coroutineScope, this.$onDoubleTap, this.$onTap, this.$upOrCancel, this.$pressScope, continuation);
                anonymousClass9.L$0 = obj;
                return anonymousClass9;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass9) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    AwaitPointerEventScope awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    this.label = 1;
                    obj = TapGestureDetectorKt.waitForUpOrCancellation$default(awaitPointerEventScope, null, this, 1, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                PointerInputChange pointerInputChange = (PointerInputChange) obj;
                if (pointerInputChange != null) {
                    pointerInputChange.consume();
                    BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new C00051(this.$pressScope, null), 3, null);
                    this.$onDoubleTap.invoke(Offset.m1328boximpl(pointerInputChange.getPosition()));
                    return Unit.INSTANCE;
                }
                BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$pressScope, null), 3, null);
                Function1<Offset, Unit> function1 = this.$onTap;
                if (function1 == null) {
                    return null;
                }
                function1.invoke(Offset.m1328boximpl(this.$upOrCancel.element.getPosition()));
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(CoroutineScope coroutineScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Function1<? super Offset, Unit> function13, PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$$this$coroutineScope = coroutineScope;
            this.$onPress = function3;
            this.$onLongPress = function1;
            this.$onDoubleTap = function12;
            this.$onTap = function13;
            this.$pressScope = pressGestureScopeImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$coroutineScope, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, this.$pressScope, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0009. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:17:0x01f7  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x020a  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0224 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0191  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x01a6  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x015f  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00fb A[Catch: PointerEventTimeoutCancellationException -> 0x010c, TryCatch #4 {PointerEventTimeoutCancellationException -> 0x010c, blocks: (B:57:0x00f5, B:59:0x00fb, B:62:0x0110), top: B:56:0x00f5 }] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0110 A[Catch: PointerEventTimeoutCancellationException -> 0x010c, TRY_LEAVE, TryCatch #4 {PointerEventTimeoutCancellationException -> 0x010c, blocks: (B:57:0x00f5, B:59:0x00fb, B:62:0x0110), top: B:56:0x00f5 }] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x012a  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0148 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:76:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x00f1 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:85:0x00f2  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x00cf  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object awaitFirstDown$default;
            AwaitPointerEventScope awaitPointerEventScope;
            PointerInputChange pointerInputChange;
            Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3;
            Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function32;
            long longPressTimeoutMillis;
            Ref$ObjectRef ref$ObjectRef;
            Object withTimeout;
            AwaitPointerEventScope awaitPointerEventScope2;
            PointerInputChange pointerInputChange2;
            Ref$ObjectRef ref$ObjectRef2;
            AwaitPointerEventScope awaitPointerEventScope3;
            Function1<Offset, Unit> function1;
            Object consumeUntilUp;
            T t5;
            T t6;
            T t7;
            Object awaitSecondDown;
            AwaitPointerEventScope awaitPointerEventScope4;
            PointerInputChange pointerInputChange3;
            Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function33;
            PointerInputChange pointerInputChange4;
            AwaitPointerEventScope awaitPointerEventScope5;
            Ref$ObjectRef ref$ObjectRef3;
            Function1<Offset, Unit> function12;
            Function1<Offset, Unit> function13;
            Object consumeUntilUp2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    AwaitPointerEventScope awaitPointerEventScope6 = (AwaitPointerEventScope) this.L$0;
                    this.L$0 = awaitPointerEventScope6;
                    this.label = 1;
                    awaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope6, false, null, this, 3, null);
                    if (awaitFirstDown$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    awaitPointerEventScope = awaitPointerEventScope6;
                    pointerInputChange = (PointerInputChange) awaitFirstDown$default;
                    pointerInputChange.consume();
                    BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new C00041(this.$pressScope, null), 3, null);
                    function3 = this.$onPress;
                    function32 = TapGestureDetectorKt.NoPressGesture;
                    if (function3 != function32) {
                        BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$onPress, this.$pressScope, pointerInputChange, null), 3, null);
                    }
                    longPressTimeoutMillis = this.$onLongPress == null ? awaitPointerEventScope.getViewConfiguration().getLongPressTimeoutMillis() : 4611686018427387903L;
                    ref$ObjectRef = new Ref$ObjectRef();
                    try {
                        AnonymousClass3 anonymousClass3 = new AnonymousClass3(null);
                        this.L$0 = awaitPointerEventScope;
                        this.L$1 = pointerInputChange;
                        this.L$2 = ref$ObjectRef;
                        this.L$3 = ref$ObjectRef;
                        this.J$0 = longPressTimeoutMillis;
                        this.label = 2;
                        withTimeout = awaitPointerEventScope.withTimeout(longPressTimeoutMillis, anonymousClass3, this);
                    } catch (PointerEventTimeoutCancellationException unused) {
                        awaitPointerEventScope3 = awaitPointerEventScope;
                        function1 = this.$onLongPress;
                        if (function1 != null) {
                            function1.invoke(Offset.m1328boximpl(pointerInputChange.getPosition()));
                        }
                        this.L$0 = awaitPointerEventScope3;
                        this.L$1 = ref$ObjectRef;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.J$0 = longPressTimeoutMillis;
                        this.label = 3;
                        consumeUntilUp = TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope3, this);
                        if (consumeUntilUp == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass6(this.$pressScope, null), 3, null);
                        ref$ObjectRef2 = ref$ObjectRef;
                        awaitPointerEventScope2 = awaitPointerEventScope3;
                        t7 = ref$ObjectRef2.element;
                        if (t7 != 0) {
                        }
                        return Unit.INSTANCE;
                    }
                    if (withTimeout != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    pointerInputChange2 = pointerInputChange;
                    ref$ObjectRef2 = ref$ObjectRef;
                    t5 = withTimeout;
                    try {
                        ref$ObjectRef.element = t5;
                        t6 = ref$ObjectRef2.element;
                        if (t6 != 0) {
                            BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass4(this.$pressScope, null), 3, null);
                        } else {
                            ((PointerInputChange) t6).consume();
                            BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass5(this.$pressScope, null), 3, null);
                        }
                    } catch (PointerEventTimeoutCancellationException unused2) {
                        ref$ObjectRef = ref$ObjectRef2;
                        pointerInputChange = pointerInputChange2;
                        awaitPointerEventScope3 = awaitPointerEventScope2;
                        function1 = this.$onLongPress;
                        if (function1 != null) {
                        }
                        this.L$0 = awaitPointerEventScope3;
                        this.L$1 = ref$ObjectRef;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.J$0 = longPressTimeoutMillis;
                        this.label = 3;
                        consumeUntilUp = TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope3, this);
                        if (consumeUntilUp == coroutine_suspended) {
                        }
                        BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass6(this.$pressScope, null), 3, null);
                        ref$ObjectRef2 = ref$ObjectRef;
                        awaitPointerEventScope2 = awaitPointerEventScope3;
                        t7 = ref$ObjectRef2.element;
                        if (t7 != 0) {
                        }
                        return Unit.INSTANCE;
                    }
                    t7 = ref$ObjectRef2.element;
                    if (t7 != 0) {
                        if (this.$onDoubleTap == null) {
                            Function1<Offset, Unit> function14 = this.$onTap;
                            if (function14 != null) {
                                function14.invoke(Offset.m1328boximpl(((PointerInputChange) t7).getPosition()));
                            }
                        } else {
                            this.L$0 = awaitPointerEventScope2;
                            this.L$1 = ref$ObjectRef2;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.J$0 = longPressTimeoutMillis;
                            this.label = 4;
                            awaitSecondDown = TapGestureDetectorKt.awaitSecondDown(awaitPointerEventScope2, (PointerInputChange) t7, this);
                            if (awaitSecondDown == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            awaitPointerEventScope4 = awaitPointerEventScope2;
                            pointerInputChange3 = (PointerInputChange) awaitSecondDown;
                            if (pointerInputChange3 != null) {
                                Function1<Offset, Unit> function15 = this.$onTap;
                                if (function15 != null) {
                                    function15.invoke(Offset.m1328boximpl(((PointerInputChange) ref$ObjectRef2.element).getPosition()));
                                }
                            } else {
                                BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass7(this.$pressScope, null), 3, null);
                                Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function34 = this.$onPress;
                                function33 = TapGestureDetectorKt.NoPressGesture;
                                if (function34 != function33) {
                                    BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass8(this.$onPress, this.$pressScope, pointerInputChange3, null), 3, null);
                                }
                                try {
                                    AnonymousClass9 anonymousClass9 = new AnonymousClass9(this.$$this$coroutineScope, this.$onDoubleTap, this.$onTap, ref$ObjectRef2, this.$pressScope, null);
                                    this.L$0 = awaitPointerEventScope4;
                                    this.L$1 = ref$ObjectRef2;
                                    this.L$2 = pointerInputChange3;
                                    this.label = 5;
                                    if (awaitPointerEventScope4.withTimeout(longPressTimeoutMillis, anonymousClass9, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } catch (PointerEventTimeoutCancellationException unused3) {
                                    pointerInputChange4 = pointerInputChange3;
                                    awaitPointerEventScope5 = awaitPointerEventScope4;
                                    ref$ObjectRef3 = ref$ObjectRef2;
                                    function12 = this.$onTap;
                                    if (function12 != null) {
                                    }
                                    function13 = this.$onLongPress;
                                    if (function13 != null) {
                                    }
                                    this.L$0 = null;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.label = 6;
                                    consumeUntilUp2 = TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope5, this);
                                    if (consumeUntilUp2 == coroutine_suspended) {
                                    }
                                    BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass10(this.$pressScope, null), 3, null);
                                    return Unit.INSTANCE;
                                }
                            }
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    AwaitPointerEventScope awaitPointerEventScope7 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    awaitPointerEventScope = awaitPointerEventScope7;
                    awaitFirstDown$default = obj;
                    pointerInputChange = (PointerInputChange) awaitFirstDown$default;
                    pointerInputChange.consume();
                    BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new C00041(this.$pressScope, null), 3, null);
                    function3 = this.$onPress;
                    function32 = TapGestureDetectorKt.NoPressGesture;
                    if (function3 != function32) {
                    }
                    if (this.$onLongPress == null) {
                    }
                    ref$ObjectRef = new Ref$ObjectRef();
                    AnonymousClass3 anonymousClass32 = new AnonymousClass3(null);
                    this.L$0 = awaitPointerEventScope;
                    this.L$1 = pointerInputChange;
                    this.L$2 = ref$ObjectRef;
                    this.L$3 = ref$ObjectRef;
                    this.J$0 = longPressTimeoutMillis;
                    this.label = 2;
                    withTimeout = awaitPointerEventScope.withTimeout(longPressTimeoutMillis, anonymousClass32, this);
                    if (withTimeout != coroutine_suspended) {
                    }
                    break;
                case 2:
                    longPressTimeoutMillis = this.J$0;
                    ref$ObjectRef = (Ref$ObjectRef) this.L$3;
                    Ref$ObjectRef ref$ObjectRef4 = (Ref$ObjectRef) this.L$2;
                    pointerInputChange = (PointerInputChange) this.L$1;
                    awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        awaitPointerEventScope2 = awaitPointerEventScope;
                        pointerInputChange2 = pointerInputChange;
                        ref$ObjectRef2 = ref$ObjectRef4;
                        t5 = obj;
                        ref$ObjectRef.element = t5;
                        t6 = ref$ObjectRef2.element;
                        if (t6 != 0) {
                        }
                    } catch (PointerEventTimeoutCancellationException unused4) {
                        ref$ObjectRef = ref$ObjectRef4;
                        awaitPointerEventScope3 = awaitPointerEventScope;
                        function1 = this.$onLongPress;
                        if (function1 != null) {
                        }
                        this.L$0 = awaitPointerEventScope3;
                        this.L$1 = ref$ObjectRef;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.J$0 = longPressTimeoutMillis;
                        this.label = 3;
                        consumeUntilUp = TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope3, this);
                        if (consumeUntilUp == coroutine_suspended) {
                        }
                        BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass6(this.$pressScope, null), 3, null);
                        ref$ObjectRef2 = ref$ObjectRef;
                        awaitPointerEventScope2 = awaitPointerEventScope3;
                        t7 = ref$ObjectRef2.element;
                        if (t7 != 0) {
                        }
                        return Unit.INSTANCE;
                    }
                    t7 = ref$ObjectRef2.element;
                    if (t7 != 0) {
                    }
                    return Unit.INSTANCE;
                case 3:
                    longPressTimeoutMillis = this.J$0;
                    ref$ObjectRef = (Ref$ObjectRef) this.L$1;
                    awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass6(this.$pressScope, null), 3, null);
                    ref$ObjectRef2 = ref$ObjectRef;
                    awaitPointerEventScope2 = awaitPointerEventScope3;
                    t7 = ref$ObjectRef2.element;
                    if (t7 != 0) {
                    }
                    return Unit.INSTANCE;
                case 4:
                    longPressTimeoutMillis = this.J$0;
                    Ref$ObjectRef ref$ObjectRef5 = (Ref$ObjectRef) this.L$1;
                    awaitPointerEventScope4 = (AwaitPointerEventScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    ref$ObjectRef2 = ref$ObjectRef5;
                    awaitSecondDown = obj;
                    pointerInputChange3 = (PointerInputChange) awaitSecondDown;
                    if (pointerInputChange3 != null) {
                    }
                    return Unit.INSTANCE;
                case 5:
                    pointerInputChange4 = (PointerInputChange) this.L$2;
                    ref$ObjectRef3 = (Ref$ObjectRef) this.L$1;
                    awaitPointerEventScope5 = (AwaitPointerEventScope) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (PointerEventTimeoutCancellationException unused5) {
                        function12 = this.$onTap;
                        if (function12 != null) {
                            function12.invoke(Offset.m1328boximpl(((PointerInputChange) ref$ObjectRef3.element).getPosition()));
                        }
                        function13 = this.$onLongPress;
                        if (function13 != null) {
                            function13.invoke(Offset.m1328boximpl(pointerInputChange4.getPosition()));
                        }
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 6;
                        consumeUntilUp2 = TapGestureDetectorKt.consumeUntilUp(awaitPointerEventScope5, this);
                        if (consumeUntilUp2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass10(this.$pressScope, null), 3, null);
                        return Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                case 6:
                    ResultKt.throwOnFailure(obj);
                    BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass10(this.$pressScope, null), 3, null);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TapGestureDetectorKt$detectTapGestures$2(PointerInputScope pointerInputScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Function1<? super Offset, Unit> function13, Continuation<? super TapGestureDetectorKt$detectTapGestures$2> continuation) {
        super(2, continuation);
        this.$this_detectTapGestures = pointerInputScope;
        this.$onPress = function3;
        this.$onLongPress = function1;
        this.$onDoubleTap = function12;
        this.$onTap = function13;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TapGestureDetectorKt$detectTapGestures$2 tapGestureDetectorKt$detectTapGestures$2 = new TapGestureDetectorKt$detectTapGestures$2(this.$this_detectTapGestures, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, continuation);
        tapGestureDetectorKt$detectTapGestures$2.L$0 = obj;
        return tapGestureDetectorKt$detectTapGestures$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            PressGestureScopeImpl pressGestureScopeImpl = new PressGestureScopeImpl(this.$this_detectTapGestures);
            PointerInputScope pointerInputScope = this.$this_detectTapGestures;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(coroutineScope, this.$onPress, this.$onLongPress, this.$onDoubleTap, this.$onTap, pressGestureScopeImpl, null);
            this.label = 1;
            if (ForEachGestureKt.awaitEachGesture(pointerInputScope, anonymousClass1, this) == coroutine_suspended) {
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
        return ((TapGestureDetectorKt$detectTapGestures$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
