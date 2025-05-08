package dk.molslinjen.ui.views.reusable;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimationKt;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.LoadingViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n²\u0006\u000e\u0010\t\u001a\u0004\u0018\u00010\b8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/unit/Dp;", "animationSize", BuildConfig.FLAVOR, "loadingResource", BuildConfig.FLAVOR, "LoadingView--orJrPs", "(FILandroidx/compose/runtime/Composer;II)V", "LoadingView", "Lcom/airbnb/lottie/LottieComposition;", "lottieComposition", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class LoadingViewKt {
    /* JADX WARN: Removed duplicated region for block: B:15:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0065  */
    /* renamed from: LoadingView--orJrPs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3393LoadingVieworJrPs(float f5, int i5, Composer composer, final int i6, final int i7) {
        final float f6;
        int i8;
        final int i9;
        Composer composer2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(899819354);
        int i10 = i7 & 1;
        if (i10 != 0) {
            i8 = i6 | 6;
            f6 = f5;
        } else if ((i6 & 6) == 0) {
            f6 = f5;
            i8 = (startRestartGroup.changed(f6) ? 4 : 2) | i6;
        } else {
            f6 = f5;
            i8 = i6;
        }
        int i11 = i7 & 2;
        if (i11 != 0) {
            i8 |= 48;
        } else if ((i6 & 48) == 0) {
            i9 = i5;
            i8 |= startRestartGroup.changed(i9) ? 32 : 16;
            if ((i8 & 19) == 18 || !startRestartGroup.getSkipping()) {
                float m2599constructorimpl = i10 == 0 ? Dp.m2599constructorimpl(64) : f6;
                int i12 = i11 == 0 ? R.raw.animation_lottie_loading_throbber : i9;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(899819354, i8, -1, "dk.molslinjen.ui.views.reusable.LoadingView (LoadingView.kt:16)");
                }
                float f7 = m2599constructorimpl;
                composer2 = startRestartGroup;
                LottieAnimationKt.LottieAnimation(LoadingView__orJrPs$lambda$0(RememberLottieCompositionKt.rememberLottieComposition(LottieCompositionSpec.RawRes.m2761boximpl(LottieCompositionSpec.RawRes.m2762constructorimpl(i12)), null, null, null, null, null, startRestartGroup, 0, 62)), SizeKt.m331size3ABfNKs(Modifier.INSTANCE, m2599constructorimpl), false, false, null, 0.0f, Integer.MAX_VALUE, false, false, false, null, false, false, null, null, null, false, null, composer2, 1572864, 0, 262076);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i9 = i12;
                f6 = f7;
            } else {
                startRestartGroup.skipToGroupEnd();
                composer2 = startRestartGroup;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: W1.A
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit LoadingView__orJrPs$lambda$1;
                        LoadingView__orJrPs$lambda$1 = LoadingViewKt.LoadingView__orJrPs$lambda$1(f6, i9, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                        return LoadingView__orJrPs$lambda$1;
                    }
                });
                return;
            }
            return;
        }
        i9 = i5;
        if ((i8 & 19) == 18) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        float f72 = m2599constructorimpl;
        composer2 = startRestartGroup;
        LottieAnimationKt.LottieAnimation(LoadingView__orJrPs$lambda$0(RememberLottieCompositionKt.rememberLottieComposition(LottieCompositionSpec.RawRes.m2761boximpl(LottieCompositionSpec.RawRes.m2762constructorimpl(i12)), null, null, null, null, null, startRestartGroup, 0, 62)), SizeKt.m331size3ABfNKs(Modifier.INSTANCE, m2599constructorimpl), false, false, null, 0.0f, Integer.MAX_VALUE, false, false, false, null, false, false, null, null, null, false, null, composer2, 1572864, 0, 262076);
        if (ComposerKt.isTraceInProgress()) {
        }
        i9 = i12;
        f6 = f72;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final LottieComposition LoadingView__orJrPs$lambda$0(LottieCompositionResult lottieCompositionResult) {
        return lottieCompositionResult.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingView__orJrPs$lambda$1(float f5, int i5, int i6, int i7, Composer composer, int i8) {
        m3393LoadingVieworJrPs(f5, i5, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }
}
