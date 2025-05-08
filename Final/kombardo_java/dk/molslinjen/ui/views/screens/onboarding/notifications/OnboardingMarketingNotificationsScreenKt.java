package dk.molslinjen.ui.views.screens.onboarding.notifications;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.core.content.res.ResourcesCompat;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.compose.LottieDynamicProperties;
import com.airbnb.lottie.compose.LottieDynamicPropertiesKt;
import com.airbnb.lottie.compose.LottieDynamicProperty;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.core.Environment;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.dialog.SimpleButtonData;
import dk.molslinjen.ui.views.screens.main.MainViewModel;
import dk.molslinjen.ui.views.screens.onboarding.OnboardingBaseScreenKt;
import dk.molslinjen.ui.views.screens.onboarding.notifications.OnboardingMarketingNotificationsScreenKt;
import dk.molslinjen.ui.views.screens.onboarding.notifications.OnboardingMarketingNotificationsViewModel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a5\u0010\r\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u001c\u0010\f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tH\u0003¢\u0006\u0004\b\r\u0010\u000e\u001a\u000f\u0010\u0010\u001a\u00020\u000fH\u0003¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/ui/views/screens/onboarding/notifications/OnboardingMarketingNotificationsViewModel;", "viewModel", "Ldk/molslinjen/ui/views/screens/main/MainViewModel;", "mainViewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "OnboardingMarketingNotificationsScreen", "(Ldk/molslinjen/ui/views/screens/onboarding/notifications/OnboardingMarketingNotificationsViewModel;Ldk/molslinjen/ui/views/screens/main/MainViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "onContinue", "OnboardingMarketingNotificationsContent", "(Ldk/molslinjen/ui/views/screens/onboarding/notifications/OnboardingMarketingNotificationsViewModel;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Lcom/airbnb/lottie/compose/LottieDynamicProperties;", "getDynamicProperties", "(Landroidx/compose/runtime/Composer;I)Lcom/airbnb/lottie/compose/LottieDynamicProperties;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class OnboardingMarketingNotificationsScreenKt {
    private static final void OnboardingMarketingNotificationsContent(final OnboardingMarketingNotificationsViewModel onboardingMarketingNotificationsViewModel, final Function1<? super Continuation<? super Unit>, ? extends Object> function1, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1750625936);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(onboardingMarketingNotificationsViewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1750625936, i6, -1, "dk.molslinjen.ui.views.screens.onboarding.notifications.OnboardingMarketingNotificationsContent (OnboardingMarketingNotificationsScreen.kt:45)");
            }
            int i7 = Environment.INSTANCE.isMolslinjen() ? R.string.onboarding_marketing_notifications_description_ML : R.string.onboarding_marketing_notifications_description_KE;
            LottieDynamicProperties dynamicProperties = getDynamicProperties(startRestartGroup, 0);
            String stringResource = StringResources_androidKt.stringResource(R.string.onboarding_marketing_notifications_title, startRestartGroup, 6);
            String stringResource2 = StringResources_androidKt.stringResource(i7, startRestartGroup, 0);
            String stringResource3 = StringResources_androidKt.stringResource(R.string.button_allow, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(1977921612);
            boolean changedInstance = startRestartGroup.changedInstance(onboardingMarketingNotificationsViewModel) | startRestartGroup.changedInstance(function1);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: t3.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit OnboardingMarketingNotificationsContent$lambda$3$lambda$2;
                        OnboardingMarketingNotificationsContent$lambda$3$lambda$2 = OnboardingMarketingNotificationsScreenKt.OnboardingMarketingNotificationsContent$lambda$3$lambda$2(OnboardingMarketingNotificationsViewModel.this, function1);
                        return OnboardingMarketingNotificationsContent$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            SimpleButtonData simpleButtonData = new SimpleButtonData(stringResource3, false, false, (Function0) rememberedValue, 6, null);
            String stringResource4 = StringResources_androidKt.stringResource(R.string.button_doNotAllow, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(1977928489);
            boolean changedInstance2 = startRestartGroup.changedInstance(onboardingMarketingNotificationsViewModel) | startRestartGroup.changedInstance(function1);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: t3.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit OnboardingMarketingNotificationsContent$lambda$5$lambda$4;
                        OnboardingMarketingNotificationsContent$lambda$5$lambda$4 = OnboardingMarketingNotificationsScreenKt.OnboardingMarketingNotificationsContent$lambda$5$lambda$4(OnboardingMarketingNotificationsViewModel.this, function1);
                        return OnboardingMarketingNotificationsContent$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            OnboardingBaseScreenKt.OnboardingBaseView(R.raw.animation_lottie_onboarding_notification, dynamicProperties, stringResource, stringResource2, simpleButtonData, new SimpleButtonData(stringResource4, false, false, (Function0) rememberedValue2, 6, null), startRestartGroup, (LottieDynamicProperties.$stable << 3) | 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: t3.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit OnboardingMarketingNotificationsContent$lambda$6;
                    OnboardingMarketingNotificationsContent$lambda$6 = OnboardingMarketingNotificationsScreenKt.OnboardingMarketingNotificationsContent$lambda$6(OnboardingMarketingNotificationsViewModel.this, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return OnboardingMarketingNotificationsContent$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingMarketingNotificationsContent$lambda$3$lambda$2(OnboardingMarketingNotificationsViewModel onboardingMarketingNotificationsViewModel, Function1 function1) {
        onboardingMarketingNotificationsViewModel.setMarketingPushEnabled(true, function1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingMarketingNotificationsContent$lambda$5$lambda$4(OnboardingMarketingNotificationsViewModel onboardingMarketingNotificationsViewModel, Function1 function1) {
        onboardingMarketingNotificationsViewModel.setMarketingPushEnabled(false, function1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingMarketingNotificationsContent$lambda$6(OnboardingMarketingNotificationsViewModel onboardingMarketingNotificationsViewModel, Function1 function1, int i5, Composer composer, int i6) {
        OnboardingMarketingNotificationsContent(onboardingMarketingNotificationsViewModel, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void OnboardingMarketingNotificationsScreen(final OnboardingMarketingNotificationsViewModel viewModel, final MainViewModel mainViewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(mainViewModel, "mainViewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-1749499536);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(mainViewModel) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1749499536, i6, -1, "dk.molslinjen.ui.views.screens.onboarding.notifications.OnboardingMarketingNotificationsScreen (OnboardingMarketingNotificationsScreen.kt:32)");
            }
            startRestartGroup.startReplaceGroup(-57527685);
            boolean changedInstance = startRestartGroup.changedInstance(mainViewModel) | ((i6 & 896) == 256);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new OnboardingMarketingNotificationsScreenKt$OnboardingMarketingNotificationsScreen$1$1(mainViewModel, navigator, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            OnboardingMarketingNotificationsContent(viewModel, (Function1) rememberedValue, startRestartGroup, i6 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: t3.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit OnboardingMarketingNotificationsScreen$lambda$1;
                    OnboardingMarketingNotificationsScreen$lambda$1 = OnboardingMarketingNotificationsScreenKt.OnboardingMarketingNotificationsScreen$lambda$1(OnboardingMarketingNotificationsViewModel.this, mainViewModel, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return OnboardingMarketingNotificationsScreen$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingMarketingNotificationsScreen$lambda$1(OnboardingMarketingNotificationsViewModel onboardingMarketingNotificationsViewModel, MainViewModel mainViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        OnboardingMarketingNotificationsScreen(onboardingMarketingNotificationsViewModel, mainViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final LottieDynamicProperties getDynamicProperties(Composer composer, int i5) {
        composer.startReplaceGroup(334203130);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(334203130, i5, -1, "dk.molslinjen.ui.views.screens.onboarding.notifications.getDynamicProperties (OnboardingMarketingNotificationsScreen.kt:71)");
        }
        Environment.Companion companion = Environment.INSTANCE;
        int i6 = companion.isMolslinjen() ? R.string.onboarding_marketing_notifications_lottieTitle_ML : R.string.onboarding_marketing_notifications_lottieTitle_KE;
        int i7 = companion.isMolslinjen() ? R.string.onboarding_marketing_notifications_lottieDescription_ML : R.string.onboarding_marketing_notifications_lottieDescription_KE;
        Typeface font = ResourcesCompat.getFont((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext()), R.font.korolev_medium);
        Typeface font2 = ResourcesCompat.getFont((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext()), R.font.korolev_bold);
        String[] strArr = {"**", ".text-rejse"};
        String[] strArr2 = {"**", ".text-tjek"};
        String[] strArr3 = {"**", ".text-nu"};
        CharSequence charSequence = LottieProperty.TEXT;
        LottieDynamicProperty rememberLottieDynamicProperty = LottieDynamicPropertiesKt.rememberLottieDynamicProperty(charSequence, StringResources_androidKt.stringResource(i6, composer, 0), (String[]) Arrays.copyOf(strArr, 2), composer, 6);
        Typeface typeface = LottieProperty.TYPEFACE;
        LottieDynamicProperties rememberLottieDynamicProperties = LottieDynamicPropertiesKt.rememberLottieDynamicProperties(new LottieDynamicProperty[]{rememberLottieDynamicProperty, LottieDynamicPropertiesKt.rememberLottieDynamicProperty(typeface, font2, (String[]) Arrays.copyOf(strArr, 2), composer, 6), LottieDynamicPropertiesKt.rememberLottieDynamicProperty(charSequence, StringResources_androidKt.stringResource(i7, composer, 0), (String[]) Arrays.copyOf(strArr2, 2), composer, 6), LottieDynamicPropertiesKt.rememberLottieDynamicProperty(typeface, font, (String[]) Arrays.copyOf(strArr2, 2), composer, 6), LottieDynamicPropertiesKt.rememberLottieDynamicProperty(charSequence, StringResources_androidKt.stringResource(R.string.onboarding_notifications_lottieNow, composer, 6), (String[]) Arrays.copyOf(strArr3, 2), composer, 6), LottieDynamicPropertiesKt.rememberLottieDynamicProperty(typeface, font, (String[]) Arrays.copyOf(strArr3, 2), composer, 6)}, composer, LottieDynamicProperty.$stable);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return rememberLottieDynamicProperties;
    }
}
