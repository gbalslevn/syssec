package dk.molslinjen.ui.views.screens.profile.brobizz.register;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.screens.profile.brobizz.register.ProfileBrobizzRegisterScreenKt;
import dk.molslinjen.ui.views.screens.profile.brobizz.register.ProfileBrobizzRegisterViewModel;
import dk.molslinjen.ui.views.screens.profile.brobizz.shared.InputState;
import dk.molslinjen.ui.views.screens.profile.brobizz.shared.ProfileBrobizzInputContentKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"ProfileBrobizzRegisterScreen", BuildConfig.FLAVOR, "viewModel", "Ldk/molslinjen/ui/views/screens/profile/brobizz/register/ProfileBrobizzRegisterViewModel;", "navigator", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "(Ldk/molslinjen/ui/views/screens/profile/brobizz/register/ProfileBrobizzRegisterViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProfileBrobizzRegisterScreenKt {
    public static final void ProfileBrobizzRegisterScreen(final ProfileBrobizzRegisterViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-1161585357);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1161585357, i6, -1, "dk.molslinjen.ui.views.screens.profile.brobizz.register.ProfileBrobizzRegisterScreen (ProfileBrobizzRegisterScreen.kt:24)");
            }
            final InputState inputState = (InputState) SnapshotStateKt.collectAsState(viewModel.getInputState(), null, startRestartGroup, 0, 1).getValue();
            final ProfileBrobizzRegisterViewModel.ViewState viewState = (ProfileBrobizzRegisterViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.startReplaceGroup(-123775492);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new FormValidator(MapsKt.mapOf(TuplesKt.to(BrobizzInputFormField.BrobizzNumber, BrobizzInputValidator.INSTANCE)), coroutineScope);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final FormValidator formValidator = (FormValidator) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            boolean booleanValue = ((Boolean) SnapshotStateKt.collectAsState(formValidator.isFormValid(), null, startRestartGroup, 0, 1).getValue()).booleanValue();
            Modifier closeKeyboardOnClickOutside = ModifierExtensionsKt.closeKeyboardOnClickOutside(Modifier.INSTANCE, (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager()));
            String stringResource = StringResources_androidKt.stringResource(R.string.profile_brobizz_register, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-123760964);
            boolean z5 = (i6 & 112) == 32;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new ProfileBrobizzRegisterScreenKt$ProfileBrobizzRegisterScreen$1$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(closeKeyboardOnClickOutside, 0.0f, stringResource, null, 0L, null, (Function0) rememberedValue3, null, ComposableLambdaKt.rememberComposableLambda(-1665528847, true, new ProfileBrobizzRegisterScreenKt$ProfileBrobizzRegisterScreen$2(formValidator, booleanValue, viewState, viewModel, navigator), startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(1275515200, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.brobizz.register.ProfileBrobizzRegisterScreenKt$ProfileBrobizzRegisterScreen$3
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope BottomSheetContainer, Composer composer3, int i7) {
                    Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                    if ((i7 & 6) == 0) {
                        i7 |= composer3.changed(BottomSheetContainer) ? 4 : 2;
                    }
                    if ((i7 & 19) == 18 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1275515200, i7, -1, "dk.molslinjen.ui.views.screens.profile.brobizz.register.ProfileBrobizzRegisterScreen.<anonymous> (ProfileBrobizzRegisterScreen.kt:52)");
                    }
                    String brobizzNumber = InputState.this.getBrobizzNumber();
                    ProfileBrobizzRegisterViewModel profileBrobizzRegisterViewModel = viewModel;
                    composer3.startReplaceGroup(1395697378);
                    boolean changedInstance = composer3.changedInstance(profileBrobizzRegisterViewModel);
                    Object rememberedValue4 = composer3.rememberedValue();
                    if (changedInstance || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = new ProfileBrobizzRegisterScreenKt$ProfileBrobizzRegisterScreen$3$1$1(profileBrobizzRegisterViewModel);
                        composer3.updateRememberedValue(rememberedValue4);
                    }
                    composer3.endReplaceGroup();
                    ProfileBrobizzInputContentKt.ProfileBrobizzInputContent(BottomSheetContainer, brobizzNumber, (Function1) ((KFunction) rememberedValue4), viewState.getIsLoading(), formValidator, composer3, i7 & 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), composer2, 905969664, 186);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: E3.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfileBrobizzRegisterScreen$lambda$2;
                    ProfileBrobizzRegisterScreen$lambda$2 = ProfileBrobizzRegisterScreenKt.ProfileBrobizzRegisterScreen$lambda$2(ProfileBrobizzRegisterViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfileBrobizzRegisterScreen$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileBrobizzRegisterScreen$lambda$2(ProfileBrobizzRegisterViewModel profileBrobizzRegisterViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        ProfileBrobizzRegisterScreen(profileBrobizzRegisterViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
