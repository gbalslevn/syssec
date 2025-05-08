package com.airbnb.lottie.compose;

import androidx.compose.animation.core.InfiniteAnimationPolicyKt;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import com.airbnb.lottie.LottieComposition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b>\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\r*\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J5\u0010\u0018\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019Jo\u0010$\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b$\u0010%R+\u0010)\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00068V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R+\u0010\u0016\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00048V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010(\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00048V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b2\u0010(\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R+\u0010\u001a\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00068V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b5\u0010(\u001a\u0004\b6\u0010*\"\u0004\b7\u0010,R/\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010&\u001a\u0004\u0018\u00010\u001c8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b8\u0010(\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R+\u0010\u001b\u001a\u00020\r2\u0006\u0010&\u001a\u00020\r8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b=\u0010(\u001a\u0004\b>\u0010?\"\u0004\b@\u0010\u0015R+\u0010#\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00068V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bA\u0010(\u001a\u0004\bB\u0010*\"\u0004\bC\u0010,R\u001b\u0010G\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010?R/\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010&\u001a\u0004\u0018\u00010\u000e8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010(\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR+\u0010P\u001a\u00020\r2\u0006\u0010&\u001a\u00020\r8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bM\u0010(\u001a\u0004\bN\u0010?\"\u0004\bO\u0010\u0015R+\u0010\u0012\u001a\u00020\r2\u0006\u0010&\u001a\u00020\r8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bQ\u0010(\u001a\u0004\bR\u0010?\"\u0004\bS\u0010\u0015R+\u0010Y\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bT\u0010(\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001b\u0010\\\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010E\u001a\u0004\b[\u0010?R\u001b\u0010^\u001a\u00020\u00068VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b]\u0010E\u001a\u0004\b^\u0010*R\u0014\u0010`\u001a\u00020_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010d\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bb\u0010c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006e"}, d2 = {"Lcom/airbnb/lottie/compose/LottieAnimatableImpl;", "Lcom/airbnb/lottie/compose/LottieAnimatable;", "<init>", "()V", BuildConfig.FLAVOR, "iterations", BuildConfig.FLAVOR, "doFrame", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.FLAVOR, "frameNanos", "onFrame", "(IJ)Z", BuildConfig.FLAVOR, "Lcom/airbnb/lottie/LottieComposition;", "composition", "roundToCompositionFrameRate", "(FLcom/airbnb/lottie/LottieComposition;)F", "progress", BuildConfig.FLAVOR, "updateProgress", "(F)V", "iteration", "resetLastFrameNanos", "snapTo", "(Lcom/airbnb/lottie/LottieComposition;FIZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reverseOnRepeat", "speed", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "clipSpec", "initialProgress", "continueFromPreviousAnimate", "Lcom/airbnb/lottie/compose/LottieCancellationBehavior;", "cancellationBehavior", "ignoreSystemAnimationsDisabled", "useCompositionFrameRate", "animate", "(Lcom/airbnb/lottie/LottieComposition;IIZFLcom/airbnb/lottie/compose/LottieClipSpec;FZLcom/airbnb/lottie/compose/LottieCancellationBehavior;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<set-?>", "isPlaying$delegate", "Landroidx/compose/runtime/MutableState;", "isPlaying", "()Z", "setPlaying", "(Z)V", "iteration$delegate", "getIteration", "()I", "setIteration", "(I)V", "iterations$delegate", "getIterations", "setIterations", "reverseOnRepeat$delegate", "getReverseOnRepeat", "setReverseOnRepeat", "clipSpec$delegate", "getClipSpec", "()Lcom/airbnb/lottie/compose/LottieClipSpec;", "setClipSpec", "(Lcom/airbnb/lottie/compose/LottieClipSpec;)V", "speed$delegate", "getSpeed", "()F", "setSpeed", "useCompositionFrameRate$delegate", "getUseCompositionFrameRate", "setUseCompositionFrameRate", "frameSpeed$delegate", "Landroidx/compose/runtime/State;", "getFrameSpeed", "frameSpeed", "composition$delegate", "getComposition", "()Lcom/airbnb/lottie/LottieComposition;", "setComposition", "(Lcom/airbnb/lottie/LottieComposition;)V", "progressRaw$delegate", "getProgressRaw", "setProgressRaw", "progressRaw", "progress$delegate", "getProgress", "setProgress", "lastFrameNanos$delegate", "getLastFrameNanos", "()J", "setLastFrameNanos", "(J)V", "lastFrameNanos", "endProgress$delegate", "getEndProgress", "endProgress", "isAtEnd$delegate", "isAtEnd", "Landroidx/compose/foundation/MutatorMutex;", "mutex", "Landroidx/compose/foundation/MutatorMutex;", "getValue", "()Ljava/lang/Float;", "value", "lottie-compose_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LottieAnimatableImpl implements LottieAnimatable {

    /* renamed from: clipSpec$delegate, reason: from kotlin metadata */
    private final MutableState clipSpec;

    /* renamed from: composition$delegate, reason: from kotlin metadata */
    private final MutableState composition;

    /* renamed from: endProgress$delegate, reason: from kotlin metadata */
    private final State endProgress;

    /* renamed from: frameSpeed$delegate, reason: from kotlin metadata */
    private final State frameSpeed;

    /* renamed from: isAtEnd$delegate, reason: from kotlin metadata */
    private final State isAtEnd;

    /* renamed from: isPlaying$delegate, reason: from kotlin metadata */
    private final MutableState isPlaying;

    /* renamed from: iteration$delegate, reason: from kotlin metadata */
    private final MutableState iteration;

    /* renamed from: iterations$delegate, reason: from kotlin metadata */
    private final MutableState iterations;

    /* renamed from: lastFrameNanos$delegate, reason: from kotlin metadata */
    private final MutableState lastFrameNanos;
    private final MutatorMutex mutex;

    /* renamed from: progress$delegate, reason: from kotlin metadata */
    private final MutableState progress;

    /* renamed from: progressRaw$delegate, reason: from kotlin metadata */
    private final MutableState progressRaw;

    /* renamed from: reverseOnRepeat$delegate, reason: from kotlin metadata */
    private final MutableState reverseOnRepeat;

    /* renamed from: speed$delegate, reason: from kotlin metadata */
    private final MutableState speed;

    /* renamed from: useCompositionFrameRate$delegate, reason: from kotlin metadata */
    private final MutableState useCompositionFrameRate;

    public LottieAnimatableImpl() {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        MutableState mutableStateOf$default6;
        MutableState mutableStateOf$default7;
        MutableState mutableStateOf$default8;
        MutableState mutableStateOf$default9;
        MutableState mutableStateOf$default10;
        MutableState mutableStateOf$default11;
        Boolean bool = Boolean.FALSE;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isPlaying = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(1, null, 2, null);
        this.iteration = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(1, null, 2, null);
        this.iterations = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.reverseOnRepeat = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.clipSpec = mutableStateOf$default5;
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(1.0f), null, 2, null);
        this.speed = mutableStateOf$default6;
        mutableStateOf$default7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.useCompositionFrameRate = mutableStateOf$default7;
        this.frameSpeed = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: com.airbnb.lottie.compose.LottieAnimatableImpl$frameSpeed$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf((LottieAnimatableImpl.this.getReverseOnRepeat() && LottieAnimatableImpl.this.getIteration() % 2 == 0) ? -LottieAnimatableImpl.this.getSpeed() : LottieAnimatableImpl.this.getSpeed());
            }
        });
        mutableStateOf$default8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.composition = mutableStateOf$default8;
        Float valueOf = Float.valueOf(0.0f);
        mutableStateOf$default9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, null, 2, null);
        this.progressRaw = mutableStateOf$default9;
        mutableStateOf$default10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(valueOf, null, 2, null);
        this.progress = mutableStateOf$default10;
        mutableStateOf$default11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Long.MIN_VALUE, null, 2, null);
        this.lastFrameNanos = mutableStateOf$default11;
        this.endProgress = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: com.airbnb.lottie.compose.LottieAnimatableImpl$endProgress$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                LottieComposition composition = LottieAnimatableImpl.this.getComposition();
                float f5 = 0.0f;
                if (composition != null) {
                    if (LottieAnimatableImpl.this.getSpeed() < 0.0f) {
                        LottieClipSpec clipSpec = LottieAnimatableImpl.this.getClipSpec();
                        if (clipSpec != null) {
                            f5 = clipSpec.getMinProgress$lottie_compose_release(composition);
                        }
                    } else {
                        LottieClipSpec clipSpec2 = LottieAnimatableImpl.this.getClipSpec();
                        f5 = clipSpec2 == null ? 1.0f : clipSpec2.getMaxProgress$lottie_compose_release(composition);
                    }
                }
                return Float.valueOf(f5);
            }
        });
        this.isAtEnd = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.airbnb.lottie.compose.LottieAnimatableImpl$isAtEnd$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z5;
                float endProgress;
                if (LottieAnimatableImpl.this.getIteration() == LottieAnimatableImpl.this.getIterations()) {
                    float progress = LottieAnimatableImpl.this.getProgress();
                    endProgress = LottieAnimatableImpl.this.getEndProgress();
                    if (progress == endProgress) {
                        z5 = true;
                        return Boolean.valueOf(z5);
                    }
                }
                z5 = false;
                return Boolean.valueOf(z5);
            }
        });
        this.mutex = new MutatorMutex();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doFrame(final int i5, Continuation<? super Boolean> continuation) {
        return i5 == Integer.MAX_VALUE ? InfiniteAnimationPolicyKt.withInfiniteAnimationFrameNanos(new Function1<Long, Boolean>() { // from class: com.airbnb.lottie.compose.LottieAnimatableImpl$doFrame$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Long l5) {
                return invoke(l5.longValue());
            }

            public final Boolean invoke(long j5) {
                boolean onFrame;
                onFrame = LottieAnimatableImpl.this.onFrame(i5, j5);
                return Boolean.valueOf(onFrame);
            }
        }, continuation) : MonotonicFrameClockKt.withFrameNanos(new Function1<Long, Boolean>() { // from class: com.airbnb.lottie.compose.LottieAnimatableImpl$doFrame$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Long l5) {
                return invoke(l5.longValue());
            }

            public final Boolean invoke(long j5) {
                boolean onFrame;
                onFrame = LottieAnimatableImpl.this.onFrame(i5, j5);
                return Boolean.valueOf(onFrame);
            }
        }, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getEndProgress() {
        return ((Number) this.endProgress.getValue()).floatValue();
    }

    private final float getFrameSpeed() {
        return ((Number) this.frameSpeed.getValue()).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final float getProgressRaw() {
        return ((Number) this.progressRaw.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean onFrame(int iterations, long frameNanos) {
        LottieComposition composition = getComposition();
        if (composition == null) {
            return true;
        }
        long lastFrameNanos = getLastFrameNanos() == Long.MIN_VALUE ? 0L : frameNanos - getLastFrameNanos();
        setLastFrameNanos(frameNanos);
        LottieClipSpec clipSpec = getClipSpec();
        float minProgress$lottie_compose_release = clipSpec == null ? 0.0f : clipSpec.getMinProgress$lottie_compose_release(composition);
        LottieClipSpec clipSpec2 = getClipSpec();
        float maxProgress$lottie_compose_release = clipSpec2 == null ? 1.0f : clipSpec2.getMaxProgress$lottie_compose_release(composition);
        float duration = (((float) (lastFrameNanos / 1000000)) / composition.getDuration()) * getFrameSpeed();
        float progressRaw = getFrameSpeed() < 0.0f ? minProgress$lottie_compose_release - (getProgressRaw() + duration) : (getProgressRaw() + duration) - maxProgress$lottie_compose_release;
        if (progressRaw < 0.0f) {
            updateProgress(RangesKt.coerceIn(getProgressRaw(), minProgress$lottie_compose_release, maxProgress$lottie_compose_release) + duration);
        } else {
            float f5 = maxProgress$lottie_compose_release - minProgress$lottie_compose_release;
            int i5 = (int) (progressRaw / f5);
            int i6 = i5 + 1;
            if (getIteration() + i6 > iterations) {
                updateProgress(getEndProgress());
                setIteration(iterations);
                return false;
            }
            setIteration(getIteration() + i6);
            float f6 = progressRaw - (i5 * f5);
            updateProgress(getFrameSpeed() < 0.0f ? maxProgress$lottie_compose_release - f6 : minProgress$lottie_compose_release + f6);
        }
        return true;
    }

    private final float roundToCompositionFrameRate(float f5, LottieComposition lottieComposition) {
        if (lottieComposition == null) {
            return f5;
        }
        return f5 - (f5 % (1 / lottieComposition.getFrameRate()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClipSpec(LottieClipSpec lottieClipSpec) {
        this.clipSpec.setValue(lottieClipSpec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setComposition(LottieComposition lottieComposition) {
        this.composition.setValue(lottieComposition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIteration(int i5) {
        this.iteration.setValue(Integer.valueOf(i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIterations(int i5) {
        this.iterations.setValue(Integer.valueOf(i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLastFrameNanos(long j5) {
        this.lastFrameNanos.setValue(Long.valueOf(j5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaying(boolean z5) {
        this.isPlaying.setValue(Boolean.valueOf(z5));
    }

    private void setProgress(float f5) {
        this.progress.setValue(Float.valueOf(f5));
    }

    private final void setProgressRaw(float f5) {
        this.progressRaw.setValue(Float.valueOf(f5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReverseOnRepeat(boolean z5) {
        this.reverseOnRepeat.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpeed(float f5) {
        this.speed.setValue(Float.valueOf(f5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUseCompositionFrameRate(boolean z5) {
        this.useCompositionFrameRate.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateProgress(float progress) {
        setProgressRaw(progress);
        if (getUseCompositionFrameRate()) {
            progress = roundToCompositionFrameRate(progress, getComposition());
        }
        setProgress(progress);
    }

    @Override // com.airbnb.lottie.compose.LottieAnimatable
    public Object animate(LottieComposition lottieComposition, int i5, int i6, boolean z5, float f5, LottieClipSpec lottieClipSpec, float f6, boolean z6, LottieCancellationBehavior lottieCancellationBehavior, boolean z7, boolean z8, Continuation<? super Unit> continuation) {
        Object mutate$default = MutatorMutex.mutate$default(this.mutex, null, new LottieAnimatableImpl$animate$2(this, i5, i6, z5, f5, lottieClipSpec, lottieComposition, f6, z8, z6, lottieCancellationBehavior, null), continuation, 1, null);
        return mutate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mutate$default : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public LottieClipSpec getClipSpec() {
        return (LottieClipSpec) this.clipSpec.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public LottieComposition getComposition() {
        return (LottieComposition) this.composition.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public int getIteration() {
        return ((Number) this.iteration.getValue()).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public int getIterations() {
        return ((Number) this.iterations.getValue()).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public long getLastFrameNanos() {
        return ((Number) this.lastFrameNanos.getValue()).longValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public float getProgress() {
        return ((Number) this.progress.getValue()).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public boolean getReverseOnRepeat() {
        return ((Boolean) this.reverseOnRepeat.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public float getSpeed() {
        return ((Number) this.speed.getValue()).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean getUseCompositionFrameRate() {
        return ((Boolean) this.useCompositionFrameRate.getValue()).booleanValue();
    }

    @Override // com.airbnb.lottie.compose.LottieAnimationState
    public boolean isAtEnd() {
        return ((Boolean) this.isAtEnd.getValue()).booleanValue();
    }

    @Override // com.airbnb.lottie.compose.LottieAnimatable
    public Object snapTo(LottieComposition lottieComposition, float f5, int i5, boolean z5, Continuation<? super Unit> continuation) {
        Object mutate$default = MutatorMutex.mutate$default(this.mutex, null, new LottieAnimatableImpl$snapTo$2(this, lottieComposition, f5, i5, z5, null), continuation, 1, null);
        return mutate$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mutate$default : Unit.INSTANCE;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.State
    public Float getValue() {
        return Float.valueOf(getProgress());
    }
}
