package dk.molslinjen.ui.views.screens.onboarding.location;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.core.content.res.ResourcesCompat;
import androidx.view.compose.ActivityResultRegistryKt;
import androidx.view.compose.ManagedActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts$RequestPermission;
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
import dk.molslinjen.ui.views.screens.onboarding.location.OnboardingLocationScreenKt;
import dk.molslinjen.ui.views.screens.onboarding.location.OnboardingLocationViewModel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\r\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a\u000f\u0010\u0010\u001a\u00020\u000fH\u0003¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/ui/views/screens/onboarding/location/OnboardingLocationViewModel;", "viewModel", "Ldk/molslinjen/ui/views/screens/main/MainViewModel;", "mainViewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "OnboardingLocationScreen", "(Ldk/molslinjen/ui/views/screens/onboarding/location/OnboardingLocationViewModel;Ldk/molslinjen/ui/views/screens/main/MainViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Landroidx/activity/compose/ManagedActivityResultLauncher;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "permissionLauncher", "OnboardingLocationContent", "(Landroidx/activity/compose/ManagedActivityResultLauncher;Landroidx/compose/runtime/Composer;I)V", "Lcom/airbnb/lottie/compose/LottieDynamicProperties;", "getDynamicProperties", "(Landroidx/compose/runtime/Composer;I)Lcom/airbnb/lottie/compose/LottieDynamicProperties;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class OnboardingLocationScreenKt {
    public static final void OnboardingLocationContent(final ManagedActivityResultLauncher<String, Boolean> permissionLauncher, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(permissionLauncher, "permissionLauncher");
        Composer startRestartGroup = composer.startRestartGroup(-1008196171);
        if ((i5 & 6) == 0) {
            i6 = ((i5 & 8) == 0 ? startRestartGroup.changed(permissionLauncher) : startRestartGroup.changedInstance(permissionLauncher) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1008196171, i6, -1, "dk.molslinjen.ui.views.screens.onboarding.location.OnboardingLocationContent (OnboardingLocationScreen.kt:50)");
            }
            Environment.Companion companion = Environment.INSTANCE;
            int i7 = companion.isKombardo() ? R.string.onboarding_location_description_KE : R.string.onboarding_location_description_ML;
            int i8 = companion.isKombardo() ? R.raw.animation_lottie_onboarding_location_ke : R.raw.animation_lottie_onboarding_location_ml;
            boolean z5 = false;
            LottieDynamicProperties dynamicProperties = getDynamicProperties(startRestartGroup, 0);
            String stringResource = StringResources_androidKt.stringResource(R.string.onboarding_location_title, startRestartGroup, 6);
            String stringResource2 = StringResources_androidKt.stringResource(i7, startRestartGroup, 0);
            String stringResource3 = StringResources_androidKt.stringResource(R.string.button_continue, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-675139679);
            if ((i6 & 14) == 4 || ((i6 & 8) != 0 && startRestartGroup.changedInstance(permissionLauncher))) {
                z5 = true;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: r3.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit OnboardingLocationContent$lambda$4$lambda$3;
                        OnboardingLocationContent$lambda$4$lambda$3 = OnboardingLocationScreenKt.OnboardingLocationContent$lambda$4$lambda$3(ManagedActivityResultLauncher.this);
                        return OnboardingLocationContent$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            OnboardingBaseScreenKt.OnboardingBaseView(i8, dynamicProperties, stringResource, stringResource2, new SimpleButtonData(stringResource3, false, false, (Function0) rememberedValue, 6, null), null, startRestartGroup, LottieDynamicProperties.$stable << 3, 32);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: r3.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit OnboardingLocationContent$lambda$5;
                    OnboardingLocationContent$lambda$5 = OnboardingLocationScreenKt.OnboardingLocationContent$lambda$5(ManagedActivityResultLauncher.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return OnboardingLocationContent$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLocationContent$lambda$4$lambda$3(ManagedActivityResultLauncher managedActivityResultLauncher) {
        managedActivityResultLauncher.launch("android.permission.ACCESS_FINE_LOCATION");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLocationContent$lambda$5(ManagedActivityResultLauncher managedActivityResultLauncher, int i5, Composer composer, int i6) {
        OnboardingLocationContent(managedActivityResultLauncher, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void OnboardingLocationScreen(final OnboardingLocationViewModel viewModel, final MainViewModel mainViewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(mainViewModel, "mainViewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-1662633704);
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
                ComposerKt.traceEventStart(-1662633704, i6, -1, "dk.molslinjen.ui.views.screens.onboarding.location.OnboardingLocationScreen (OnboardingLocationScreen.kt:31)");
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            ActivityResultContracts$RequestPermission activityResultContracts$RequestPermission = new ActivityResultContracts$RequestPermission();
            startRestartGroup.startReplaceGroup(-4557909);
            boolean changedInstance = ((i6 & 896) == 256) | startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(mainViewModel) | startRestartGroup.changedInstance(viewModel);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: r3.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit OnboardingLocationScreen$lambda$1$lambda$0;
                        OnboardingLocationScreen$lambda$1$lambda$0 = OnboardingLocationScreenKt.OnboardingLocationScreen$lambda$1$lambda$0(CoroutineScope.this, navigator, mainViewModel, viewModel, ((Boolean) obj).booleanValue());
                        return OnboardingLocationScreen$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            OnboardingLocationContent(ActivityResultRegistryKt.rememberLauncherForActivityResult(activityResultContracts$RequestPermission, (Function1) rememberedValue2, startRestartGroup, 0), startRestartGroup, ManagedActivityResultLauncher.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: r3.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit OnboardingLocationScreen$lambda$2;
                    OnboardingLocationScreen$lambda$2 = OnboardingLocationScreenKt.OnboardingLocationScreen$lambda$2(OnboardingLocationViewModel.this, mainViewModel, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return OnboardingLocationScreen$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLocationScreen$lambda$1$lambda$0(CoroutineScope coroutineScope, DestinationsNavigator destinationsNavigator, MainViewModel mainViewModel, OnboardingLocationViewModel onboardingLocationViewModel, boolean z5) {
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new OnboardingLocationScreenKt$OnboardingLocationScreen$permissionLauncher$1$1$1(destinationsNavigator, mainViewModel, onboardingLocationViewModel, z5, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnboardingLocationScreen$lambda$2(OnboardingLocationViewModel onboardingLocationViewModel, MainViewModel mainViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        OnboardingLocationScreen(onboardingLocationViewModel, mainViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final LottieDynamicProperties getDynamicProperties(Composer composer, int i5) {
        composer.startReplaceGroup(-765252306);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-765252306, i5, -1, "dk.molslinjen.ui.views.screens.onboarding.location.getDynamicProperties (OnboardingLocationScreen.kt:78)");
        }
        String[] strArr = {"**", ".hvis-text"};
        LottieDynamicProperties rememberLottieDynamicProperties = LottieDynamicPropertiesKt.rememberLottieDynamicProperties(new LottieDynamicProperty[]{LottieDynamicPropertiesKt.rememberLottieDynamicProperty(LottieProperty.TEXT, StringResources_androidKt.stringResource(R.string.onboarding_location_lottieText, composer, 6), (String[]) Arrays.copyOf(strArr, 2), composer, 6), LottieDynamicPropertiesKt.rememberLottieDynamicProperty(LottieProperty.TYPEFACE, ResourcesCompat.getFont((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext()), R.font.korolev_medium), (String[]) Arrays.copyOf(strArr, 2), composer, 6)}, composer, LottieDynamicProperty.$stable);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return rememberLottieDynamicProperties;
    }
}
