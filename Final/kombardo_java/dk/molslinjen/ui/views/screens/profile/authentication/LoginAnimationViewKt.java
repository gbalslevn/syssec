package dk.molslinjen.ui.views.screens.profile.authentication;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.core.content.res.ResourcesCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.compose.LottieAnimatable;
import com.airbnb.lottie.compose.LottieAnimatableKt;
import com.airbnb.lottie.compose.LottieClipSpec;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.compose.LottieDynamicProperties;
import com.airbnb.lottie.compose.LottieDynamicPropertiesKt;
import com.airbnb.lottie.compose.LottieDynamicProperty;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import com.airbnb.lottie.model.KeyPath;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.lottie.FixedSizeLottieAnimationKt;
import dk.molslinjen.ui.views.screens.profile.authentication.LoginAnimationState;
import dk.molslinjen.ui.views.screens.profile.authentication.LoginAnimationViewKt;
import dk.molslinjen.ui.views.screens.profile.authentication.register.LoginAnimationMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t²\u0006\f\u0010\n\u001a\u0004\u0018\u00010\u000bX\u008a\u0084\u0002"}, d2 = {"LoginAnimationView", BuildConfig.FLAVOR, "mode", "Ldk/molslinjen/ui/views/screens/profile/authentication/register/LoginAnimationMode;", "state", "Ldk/molslinjen/ui/views/screens/profile/authentication/LoginAnimationState;", "onCompletion", "Lkotlin/Function0;", "(Ldk/molslinjen/ui/views/screens/profile/authentication/register/LoginAnimationMode;Ldk/molslinjen/ui/views/screens/profile/authentication/LoginAnimationState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd", "composition", "Lcom/airbnb/lottie/LottieComposition;"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class LoginAnimationViewKt {
    /* JADX WARN: Removed duplicated region for block: B:19:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LoginAnimationView(final LoginAnimationMode mode, final LoginAnimationState state, Function0<Unit> function0, Composer composer, final int i5, final int i6) {
        int i7;
        Function0<Unit> function02;
        int i8;
        Function0<Unit> function03;
        Function0<Unit> function04;
        boolean changed;
        Object rememberedValue;
        boolean changed2;
        Object rememberedValue2;
        Function0<Unit> function05;
        Object rememberedValue3;
        Composer.Companion companion;
        boolean changed3;
        Object rememberedValue4;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(state, "state");
        Composer startRestartGroup = composer.startRestartGroup(-1508183164);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(mode) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(state) ? 32 : 16;
        }
        int i9 = i6 & 4;
        if (i9 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            function02 = function0;
            i7 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
            i8 = i7;
            if ((i8 & 147) == 146 || !startRestartGroup.getSkipping()) {
                if (i9 == 0) {
                    startRestartGroup.startReplaceGroup(-655882034);
                    Object rememberedValue5 = startRestartGroup.rememberedValue();
                    if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue5 = new Function0() { // from class: w3.a
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue5);
                    }
                    startRestartGroup.endReplaceGroup();
                    function03 = (Function0) rememberedValue5;
                } else {
                    function03 = function02;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1508183164, i8, -1, "dk.molslinjen.ui.views.screens.profile.authentication.LoginAnimationView (LoginAnimationView.kt:21)");
                }
                Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                function04 = function03;
                LottieCompositionResult rememberLottieComposition = RememberLottieCompositionKt.rememberLottieComposition(LottieCompositionSpec.RawRes.m2761boximpl(LottieCompositionSpec.RawRes.m2762constructorimpl(state.getAnimationRes())), null, null, null, null, null, startRestartGroup, 0, 62);
                final LottieAnimatable rememberLottieAnimatable = LottieAnimatableKt.rememberLottieAnimatable(startRestartGroup, 0);
                LottieClipSpec clipSpec = state.getClipSpec();
                LottieComposition LoginAnimationView$lambda$2 = LoginAnimationView$lambda$2(rememberLottieComposition);
                startRestartGroup.startReplaceGroup(-655872903);
                changed = startRestartGroup.changed(rememberLottieComposition) | ((i8 & 112) != 32) | startRestartGroup.changed(rememberLottieAnimatable);
                rememberedValue = startRestartGroup.rememberedValue();
                LottieDynamicProperties lottieDynamicProperties = null;
                if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new LoginAnimationViewKt$LoginAnimationView$2$1(state, rememberLottieAnimatable, rememberLottieComposition, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(clipSpec, LoginAnimationView$lambda$2, (Function2) rememberedValue, startRestartGroup, LottieClipSpec.$stable);
                Boolean valueOf = Boolean.valueOf(rememberLottieAnimatable.isAtEnd());
                Float valueOf2 = Float.valueOf(rememberLottieAnimatable.getProgress());
                startRestartGroup.startReplaceGroup(-655863017);
                changed2 = startRestartGroup.changed(rememberLottieAnimatable) | ((i8 & 896) == 256);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    function05 = function04;
                    rememberedValue2 = new LoginAnimationViewKt$LoginAnimationView$3$1(rememberLottieAnimatable, function05, null);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                } else {
                    function05 = function04;
                }
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(valueOf, valueOf2, (Function2) rememberedValue2, startRestartGroup, 0);
                KeyPath keyPath = new KeyPath("**", ".text-main");
                KeyPath keyPath2 = new KeyPath("**", ".text-name");
                startRestartGroup.startReplaceGroup(-655855600);
                rememberedValue3 = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = ResourcesCompat.getFont(context, R.font.korolev_medium);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                Typeface typeface = (Typeface) rememberedValue3;
                startRestartGroup.endReplaceGroup();
                LottieComposition LoginAnimationView$lambda$22 = LoginAnimationView$lambda$2(rememberLottieComposition);
                String stringResource = StringResources_androidKt.stringResource(mode.getMainText(), startRestartGroup, 0);
                startRestartGroup.startReplaceGroup(-655845985);
                if (!Intrinsics.areEqual(state, LoginAnimationState.Loading.INSTANCE)) {
                    if (!(state instanceof LoginAnimationState.Success)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    CharSequence charSequence = LottieProperty.TEXT;
                    LottieDynamicProperty lottieDynamicProperty = new LottieDynamicProperty((String) charSequence, keyPath, StringResources_androidKt.stringResource(mode.getMainText(), startRestartGroup, 0));
                    Typeface typeface2 = LottieProperty.TYPEFACE;
                    LottieDynamicProperty lottieDynamicProperty2 = new LottieDynamicProperty(typeface2, keyPath, typeface);
                    String initials = state.getInitials();
                    if (initials == null) {
                        initials = BuildConfig.FLAVOR;
                    }
                    lottieDynamicProperties = LottieDynamicPropertiesKt.rememberLottieDynamicProperties(new LottieDynamicProperty[]{lottieDynamicProperty, lottieDynamicProperty2, new LottieDynamicProperty((String) charSequence, keyPath2, initials), new LottieDynamicProperty(typeface2, keyPath2, typeface)}, startRestartGroup, LottieDynamicProperty.$stable);
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-655850717);
                changed3 = startRestartGroup.changed(rememberLottieAnimatable);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!changed3 || rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: w3.b
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            float progress;
                            progress = LottieAnimatable.this.getProgress();
                            return Float.valueOf(progress);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                FixedSizeLottieAnimationKt.FixedSizeLottieAnimation(LoginAnimationView$lambda$22, (Function0) rememberedValue4, lottieDynamicProperties, stringResource, startRestartGroup, LottieDynamicProperties.$stable << 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                function05 = function02;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Function0<Unit> function06 = function05;
                endRestartGroup.updateScope(new Function2() { // from class: w3.c
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit LoginAnimationView$lambda$8;
                        LoginAnimationView$lambda$8 = LoginAnimationViewKt.LoginAnimationView$lambda$8(LoginAnimationMode.this, state, function06, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return LoginAnimationView$lambda$8;
                    }
                });
                return;
            }
            return;
        }
        function02 = function0;
        i8 = i7;
        if ((i8 & 147) == 146) {
        }
        if (i9 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Context context2 = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        function04 = function03;
        LottieCompositionResult rememberLottieComposition2 = RememberLottieCompositionKt.rememberLottieComposition(LottieCompositionSpec.RawRes.m2761boximpl(LottieCompositionSpec.RawRes.m2762constructorimpl(state.getAnimationRes())), null, null, null, null, null, startRestartGroup, 0, 62);
        final LottieAnimatable rememberLottieAnimatable2 = LottieAnimatableKt.rememberLottieAnimatable(startRestartGroup, 0);
        LottieClipSpec clipSpec2 = state.getClipSpec();
        LottieComposition LoginAnimationView$lambda$23 = LoginAnimationView$lambda$2(rememberLottieComposition2);
        startRestartGroup.startReplaceGroup(-655872903);
        changed = startRestartGroup.changed(rememberLottieComposition2) | ((i8 & 112) != 32) | startRestartGroup.changed(rememberLottieAnimatable2);
        rememberedValue = startRestartGroup.rememberedValue();
        LottieDynamicProperties lottieDynamicProperties2 = null;
        if (!changed) {
        }
        rememberedValue = new LoginAnimationViewKt$LoginAnimationView$2$1(state, rememberLottieAnimatable2, rememberLottieComposition2, null);
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        EffectsKt.LaunchedEffect(clipSpec2, LoginAnimationView$lambda$23, (Function2) rememberedValue, startRestartGroup, LottieClipSpec.$stable);
        Boolean valueOf3 = Boolean.valueOf(rememberLottieAnimatable2.isAtEnd());
        Float valueOf22 = Float.valueOf(rememberLottieAnimatable2.getProgress());
        startRestartGroup.startReplaceGroup(-655863017);
        changed2 = startRestartGroup.changed(rememberLottieAnimatable2) | ((i8 & 896) == 256);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (changed2) {
        }
        function05 = function04;
        rememberedValue2 = new LoginAnimationViewKt$LoginAnimationView$3$1(rememberLottieAnimatable2, function05, null);
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceGroup();
        EffectsKt.LaunchedEffect(valueOf3, valueOf22, (Function2) rememberedValue2, startRestartGroup, 0);
        KeyPath keyPath3 = new KeyPath("**", ".text-main");
        KeyPath keyPath22 = new KeyPath("**", ".text-name");
        startRestartGroup.startReplaceGroup(-655855600);
        rememberedValue3 = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue3 == companion.getEmpty()) {
        }
        Typeface typeface3 = (Typeface) rememberedValue3;
        startRestartGroup.endReplaceGroup();
        LottieComposition LoginAnimationView$lambda$222 = LoginAnimationView$lambda$2(rememberLottieComposition2);
        String stringResource2 = StringResources_androidKt.stringResource(mode.getMainText(), startRestartGroup, 0);
        startRestartGroup.startReplaceGroup(-655845985);
        if (!Intrinsics.areEqual(state, LoginAnimationState.Loading.INSTANCE)) {
        }
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(-655850717);
        changed3 = startRestartGroup.changed(rememberLottieAnimatable2);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changed3) {
        }
        rememberedValue4 = new Function0() { // from class: w3.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                float progress;
                progress = LottieAnimatable.this.getProgress();
                return Float.valueOf(progress);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue4);
        startRestartGroup.endReplaceGroup();
        FixedSizeLottieAnimationKt.FixedSizeLottieAnimation(LoginAnimationView$lambda$222, (Function0) rememberedValue4, lottieDynamicProperties2, stringResource2, startRestartGroup, LottieDynamicProperties.$stable << 6, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LottieComposition LoginAnimationView$lambda$2(LottieCompositionResult lottieCompositionResult) {
        return lottieCompositionResult.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginAnimationView$lambda$8(LoginAnimationMode loginAnimationMode, LoginAnimationState loginAnimationState, Function0 function0, int i5, int i6, Composer composer, int i7) {
        LoginAnimationView(loginAnimationMode, loginAnimationState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
