package dk.molslinjen.ui.views.reusable.lottie;

import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import com.adjust.sdk.Constants;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimationKt;
import com.airbnb.lottie.compose.LottieDynamicProperties;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.ui.views.reusable.lottie.FixedSizeLottieAnimationKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"FixedSizeLottieAnimation", BuildConfig.FLAVOR, "composition", "Lcom/airbnb/lottie/LottieComposition;", "progress", "Lkotlin/Function0;", BuildConfig.FLAVOR, "dynamicProperties", "Lcom/airbnb/lottie/compose/LottieDynamicProperties;", "contentDescription", BuildConfig.FLAVOR, "(Lcom/airbnb/lottie/LottieComposition;Lkotlin/jvm/functions/Function0;Lcom/airbnb/lottie/compose/LottieDynamicProperties;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FixedSizeLottieAnimationKt {
    public static final void FixedSizeLottieAnimation(final LottieComposition lottieComposition, final Function0<Float> progress, LottieDynamicProperties lottieDynamicProperties, final String str, Composer composer, final int i5, final int i6) {
        int i7;
        Composer composer2;
        final LottieDynamicProperties lottieDynamicProperties2;
        Intrinsics.checkNotNullParameter(progress, "progress");
        Composer startRestartGroup = composer.startRestartGroup(-1692485579);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(lottieComposition) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(progress) ? 32 : 16;
        }
        int i8 = i6 & 4;
        if (i8 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= (i5 & 512) == 0 ? startRestartGroup.changed(lottieDynamicProperties) : startRestartGroup.changedInstance(lottieDynamicProperties) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changed(str) ? 2048 : 1024;
        }
        if ((i7 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            lottieDynamicProperties2 = lottieDynamicProperties;
            composer2 = startRestartGroup;
        } else {
            LottieDynamicProperties lottieDynamicProperties3 = i8 != 0 ? null : lottieDynamicProperties;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1692485579, i7, -1, "dk.molslinjen.ui.views.reusable.lottie.FixedSizeLottieAnimation (FixedSizeLottieAnimation.kt:22)");
            }
            Modifier aspectRatio$default = AspectRatioKt.aspectRatio$default(SizeKt.m331size3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(Constants.MINIMAL_ERROR_STATUS_CODE)), 1.0f, false, 2, null);
            boolean z5 = str != null;
            startRestartGroup.startReplaceGroup(-232353736);
            boolean z6 = (i7 & 7168) == 2048;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: i2.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Modifier FixedSizeLottieAnimation$lambda$2$lambda$1;
                        FixedSizeLottieAnimation$lambda$2$lambda$1 = FixedSizeLottieAnimationKt.FixedSizeLottieAnimation$lambda$2$lambda$1(str, (Modifier) obj);
                        return FixedSizeLottieAnimation$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            LottieAnimationKt.LottieAnimation(lottieComposition, progress, ModifierExtensionsKt.applyIf(aspectRatio$default, z5, (Function1) rememberedValue), false, false, false, null, false, lottieDynamicProperties3, null, null, false, null, composer2, (i7 & 126) | (LottieDynamicProperties.$stable << 24) | ((i7 << 18) & 234881024), 0, 7928);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            lottieDynamicProperties2 = lottieDynamicProperties3;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: i2.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FixedSizeLottieAnimation$lambda$3;
                    FixedSizeLottieAnimation$lambda$3 = FixedSizeLottieAnimationKt.FixedSizeLottieAnimation$lambda$3(LottieComposition.this, progress, lottieDynamicProperties2, str, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return FixedSizeLottieAnimation$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier FixedSizeLottieAnimation$lambda$2$lambda$1(final String str, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return SemanticsModifierKt.semantics$default(applyIf, false, new Function1() { // from class: i2.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit FixedSizeLottieAnimation$lambda$2$lambda$1$lambda$0;
                FixedSizeLottieAnimation$lambda$2$lambda$1$lambda$0 = FixedSizeLottieAnimationKt.FixedSizeLottieAnimation$lambda$2$lambda$1$lambda$0(str, (SemanticsPropertyReceiver) obj);
                return FixedSizeLottieAnimation$lambda$2$lambda$1$lambda$0;
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FixedSizeLottieAnimation$lambda$2$lambda$1$lambda$0(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        if (str == null) {
            str = BuildConfig.FLAVOR;
        }
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        SemanticsPropertiesKt.m2183setLiveRegionhR3wRGc(semantics, LiveRegionMode.INSTANCE.m2161getAssertive0phEisY());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FixedSizeLottieAnimation$lambda$3(LottieComposition lottieComposition, Function0 function0, LottieDynamicProperties lottieDynamicProperties, String str, int i5, int i6, Composer composer, int i7) {
        FixedSizeLottieAnimation(lottieComposition, function0, lottieDynamicProperties, str, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
