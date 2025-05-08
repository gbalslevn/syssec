package com.airbnb.lottie.compose;

import com.airbnb.lottie.LottieComposition;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonCancellable;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2", f = "LottieAnimatable.kt", l = {269}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class LottieAnimatableImpl$animate$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ LottieCancellationBehavior $cancellationBehavior;
    final /* synthetic */ LottieClipSpec $clipSpec;
    final /* synthetic */ LottieComposition $composition;
    final /* synthetic */ boolean $continueFromPreviousAnimate;
    final /* synthetic */ float $initialProgress;
    final /* synthetic */ int $iteration;
    final /* synthetic */ int $iterations;
    final /* synthetic */ boolean $reverseOnRepeat;
    final /* synthetic */ float $speed;
    final /* synthetic */ boolean $useCompositionFrameRate;
    int label;
    final /* synthetic */ LottieAnimatableImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2$1", f = "LottieAnimatable.kt", l = {277}, m = "invokeSuspend")
    /* renamed from: com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LottieCancellationBehavior $cancellationBehavior;
        final /* synthetic */ int $iteration;
        final /* synthetic */ int $iterations;
        final /* synthetic */ Job $parentJob;
        int label;
        final /* synthetic */ LottieAnimatableImpl this$0;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2$1$WhenMappings */
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[LottieCancellationBehavior.values().length];
                iArr[LottieCancellationBehavior.OnIterationFinish.ordinal()] = 1;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LottieCancellationBehavior lottieCancellationBehavior, Job job, int i5, int i6, LottieAnimatableImpl lottieAnimatableImpl, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$cancellationBehavior = lottieCancellationBehavior;
            this.$parentJob = job;
            this.$iterations = i5;
            this.$iteration = i6;
            this.this$0 = lottieAnimatableImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$cancellationBehavior, this.$parentJob, this.$iterations, this.$iteration, this.this$0, continuation);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0040 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003e -> B:5:0x0041). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r3.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                kotlin.ResultKt.throwOnFailure(r4)
                goto L41
            Lf:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
            L17:
                kotlin.ResultKt.throwOnFailure(r4)
            L1a:
                com.airbnb.lottie.compose.LottieCancellationBehavior r4 = r3.$cancellationBehavior
                int[] r1 = com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2.AnonymousClass1.WhenMappings.$EnumSwitchMapping$0
                int r4 = r4.ordinal()
                r4 = r1[r4]
                if (r4 != r2) goto L34
                kotlinx.coroutines.Job r4 = r3.$parentJob
                boolean r4 = r4.isActive()
                if (r4 == 0) goto L31
                int r4 = r3.$iterations
                goto L36
            L31:
                int r4 = r3.$iteration
                goto L36
            L34:
                int r4 = r3.$iterations
            L36:
                com.airbnb.lottie.compose.LottieAnimatableImpl r1 = r3.this$0
                r3.label = r2
                java.lang.Object r4 = com.airbnb.lottie.compose.LottieAnimatableImpl.access$doFrame(r1, r4, r3)
                if (r4 != r0) goto L41
                return r0
            L41:
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                boolean r4 = r4.booleanValue()
                if (r4 != 0) goto L1a
                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.compose.LottieAnimatableImpl$animate$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LottieCancellationBehavior.values().length];
            iArr[LottieCancellationBehavior.OnIterationFinish.ordinal()] = 1;
            iArr[LottieCancellationBehavior.Immediately.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LottieAnimatableImpl$animate$2(LottieAnimatableImpl lottieAnimatableImpl, int i5, int i6, boolean z5, float f5, LottieClipSpec lottieClipSpec, LottieComposition lottieComposition, float f6, boolean z6, boolean z7, LottieCancellationBehavior lottieCancellationBehavior, Continuation<? super LottieAnimatableImpl$animate$2> continuation) {
        super(1, continuation);
        this.this$0 = lottieAnimatableImpl;
        this.$iteration = i5;
        this.$iterations = i6;
        this.$reverseOnRepeat = z5;
        this.$speed = f5;
        this.$clipSpec = lottieClipSpec;
        this.$composition = lottieComposition;
        this.$initialProgress = f6;
        this.$useCompositionFrameRate = z6;
        this.$continueFromPreviousAnimate = z7;
        this.$cancellationBehavior = lottieCancellationBehavior;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new LottieAnimatableImpl$animate$2(this.this$0, this.$iteration, this.$iterations, this.$reverseOnRepeat, this.$speed, this.$clipSpec, this.$composition, this.$initialProgress, this.$useCompositionFrameRate, this.$continueFromPreviousAnimate, this.$cancellationBehavior, continuation);
    }

    /* JADX WARN: Finally extract failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineContext coroutineContext;
        float endProgress;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        try {
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.setIteration(this.$iteration);
                this.this$0.setIterations(this.$iterations);
                this.this$0.setReverseOnRepeat(this.$reverseOnRepeat);
                this.this$0.setSpeed(this.$speed);
                this.this$0.setClipSpec(this.$clipSpec);
                this.this$0.setComposition(this.$composition);
                this.this$0.updateProgress(this.$initialProgress);
                this.this$0.setUseCompositionFrameRate(this.$useCompositionFrameRate);
                if (!this.$continueFromPreviousAnimate) {
                    this.this$0.setLastFrameNanos(Long.MIN_VALUE);
                }
                if (this.$composition == null) {
                    this.this$0.setPlaying(false);
                    return Unit.INSTANCE;
                }
                if (Float.isInfinite(this.$speed)) {
                    LottieAnimatableImpl lottieAnimatableImpl = this.this$0;
                    endProgress = lottieAnimatableImpl.getEndProgress();
                    lottieAnimatableImpl.updateProgress(endProgress);
                    this.this$0.setPlaying(false);
                    this.this$0.setIteration(this.$iterations);
                    return Unit.INSTANCE;
                }
                this.this$0.setPlaying(true);
                int i6 = WhenMappings.$EnumSwitchMapping$0[this.$cancellationBehavior.ordinal()];
                if (i6 == 1) {
                    coroutineContext = NonCancellable.INSTANCE;
                } else {
                    if (i6 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    coroutineContext = EmptyCoroutineContext.INSTANCE;
                }
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$cancellationBehavior, JobKt.getJob(getContext()), this.$iterations, this.$iteration, this.this$0, null);
                this.label = 1;
                if (BuildersKt.withContext(coroutineContext, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            JobKt.ensureActive(getContext());
            this.this$0.setPlaying(false);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            this.this$0.setPlaying(false);
            throw th;
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((LottieAnimatableImpl$animate$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
