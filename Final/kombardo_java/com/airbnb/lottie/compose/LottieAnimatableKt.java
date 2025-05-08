package com.airbnb.lottie.compose;

import androidx.compose.runtime.Composer;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimatable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0002\u001a\r\u0010\t\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\n\u001a\u0015\u0010\u000b\u001a\u00020\f*\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"LottieAnimatable", "Lcom/airbnb/lottie/compose/LottieAnimatable;", "defaultProgress", BuildConfig.FLAVOR, "composition", "Lcom/airbnb/lottie/LottieComposition;", "clipSpec", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "speed", "rememberLottieAnimatable", "(Landroidx/compose/runtime/Composer;I)Lcom/airbnb/lottie/compose/LottieAnimatable;", "resetToBeginning", BuildConfig.FLAVOR, "(Lcom/airbnb/lottie/compose/LottieAnimatable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lottie-compose_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LottieAnimatableKt {
    public static final LottieAnimatable LottieAnimatable() {
        return new LottieAnimatableImpl();
    }

    public static final float defaultProgress(LottieComposition lottieComposition, LottieClipSpec lottieClipSpec, float f5) {
        if (f5 >= 0.0f || lottieComposition != null) {
            if (lottieComposition == null) {
                return 0.0f;
            }
            if (f5 >= 0.0f) {
                if (lottieClipSpec == null) {
                    return 0.0f;
                }
                return lottieClipSpec.getMinProgress$lottie_compose_release(lottieComposition);
            }
            if (lottieClipSpec != null) {
                return lottieClipSpec.getMaxProgress$lottie_compose_release(lottieComposition);
            }
        }
        return 1.0f;
    }

    public static final LottieAnimatable rememberLottieAnimatable(Composer composer, int i5) {
        composer.startReplaceableGroup(-610207901);
        composer.startReplaceableGroup(-3687241);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = LottieAnimatable();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        LottieAnimatable lottieAnimatable = (LottieAnimatable) rememberedValue;
        composer.endReplaceableGroup();
        return lottieAnimatable;
    }

    public static final Object resetToBeginning(LottieAnimatable lottieAnimatable, Continuation<? super Unit> continuation) {
        Object snapTo$default = LottieAnimatable.DefaultImpls.snapTo$default(lottieAnimatable, null, defaultProgress(lottieAnimatable.getComposition(), lottieAnimatable.getClipSpec(), lottieAnimatable.getSpeed()), 1, false, continuation, 9, null);
        return snapTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? snapTo$default : Unit.INSTANCE;
    }
}
