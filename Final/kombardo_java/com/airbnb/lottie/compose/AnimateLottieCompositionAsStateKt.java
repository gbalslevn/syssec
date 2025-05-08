package com.airbnb.lottie.compose;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001as\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"animateLottieCompositionAsState", "Lcom/airbnb/lottie/compose/LottieAnimationState;", "composition", "Lcom/airbnb/lottie/LottieComposition;", "isPlaying", BuildConfig.FLAVOR, "restartOnPlay", "reverseOnRepeat", "clipSpec", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "speed", BuildConfig.FLAVOR, "iterations", BuildConfig.FLAVOR, "cancellationBehavior", "Lcom/airbnb/lottie/compose/LottieCancellationBehavior;", "ignoreSystemAnimatorScale", "useCompositionFrameRate", "(Lcom/airbnb/lottie/LottieComposition;ZZZLcom/airbnb/lottie/compose/LottieClipSpec;FILcom/airbnb/lottie/compose/LottieCancellationBehavior;ZZLandroidx/compose/runtime/Composer;II)Lcom/airbnb/lottie/compose/LottieAnimationState;", "lottie-compose_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AnimateLottieCompositionAsStateKt {
    public static final LottieAnimationState animateLottieCompositionAsState(LottieComposition lottieComposition, boolean z5, boolean z6, boolean z7, LottieClipSpec lottieClipSpec, float f5, int i5, LottieCancellationBehavior lottieCancellationBehavior, boolean z8, boolean z9, Composer composer, int i6, int i7) {
        composer.startReplaceableGroup(-180607681);
        boolean z10 = (i7 & 2) != 0 ? true : z5;
        boolean z11 = (i7 & 4) != 0 ? true : z6;
        boolean z12 = (i7 & 8) != 0 ? false : z7;
        LottieClipSpec lottieClipSpec2 = (i7 & 16) != 0 ? null : lottieClipSpec;
        float f6 = (i7 & 32) != 0 ? 1.0f : f5;
        int i8 = (i7 & 64) != 0 ? 1 : i5;
        LottieCancellationBehavior lottieCancellationBehavior2 = (i7 & 128) != 0 ? LottieCancellationBehavior.Immediately : lottieCancellationBehavior;
        boolean z13 = (i7 & 256) != 0 ? false : z8;
        boolean z14 = (i7 & 512) != 0 ? false : z9;
        if (i8 <= 0) {
            throw new IllegalArgumentException(("Iterations must be a positive number (" + i8 + ").").toString());
        }
        if (Float.isInfinite(f6) || Float.isNaN(f6)) {
            throw new IllegalArgumentException(("Speed must be a finite number. It is " + f6 + '.').toString());
        }
        LottieAnimatable rememberLottieAnimatable = LottieAnimatableKt.rememberLottieAnimatable(composer, 0);
        composer.startReplaceableGroup(-3687241);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z10), null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        composer.startReplaceableGroup(-180606834);
        if (!z13) {
            f6 /= Utils.getAnimationScale((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext()));
        }
        float f7 = f6;
        composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect(new Object[]{lottieComposition, Boolean.valueOf(z10), lottieClipSpec2, Float.valueOf(f7), Integer.valueOf(i8)}, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3(z10, z11, rememberLottieAnimatable, lottieComposition, i8, z12, f7, lottieClipSpec2, lottieCancellationBehavior2, z14, mutableState, null), composer, 8);
        composer.endReplaceableGroup();
        return rememberLottieAnimatable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: animateLottieCompositionAsState$lambda-3, reason: not valid java name */
    public static final boolean m2751animateLottieCompositionAsState$lambda3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: animateLottieCompositionAsState$lambda-4, reason: not valid java name */
    public static final void m2752animateLottieCompositionAsState$lambda4(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }
}
