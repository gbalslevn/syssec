package dk.molslinjen.ui.views.screens.booking.passengers.edit;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.generated.destinations.NationalitySelectionScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.OpenResultRecipientKt;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.domain.model.account.UserPassenger;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.booking.passengers.edit.CheckoutPassengerEditScreenKt;
import dk.molslinjen.ui.views.screens.booking.passengers.edit.CheckoutPassengerEditViewModel;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.ProfilePassengerDeleteDialogKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a3\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u0087\u0001\u0010\u0016\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001b²\u0006\u000e\u0010\u0019\u001a\u00020\u00188\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001a\u001a\u00020\u00188\n@\nX\u008a\u008e\u0002"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/passengers/edit/CheckoutPassengerEditViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/NationalitySelectionScreenDestination;", "Ljava/util/Locale;", "nationalityResultRecipient", BuildConfig.FLAVOR, "CheckoutPassengerEditScreen", "(Ldk/molslinjen/ui/views/screens/booking/passengers/edit/CheckoutPassengerEditViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/result/ResultRecipient;Landroidx/compose/runtime/Composer;I)V", "Lkotlin/Function1;", "updateNationality", "Ldk/molslinjen/ui/views/screens/booking/passengers/edit/PassengerEditViewState;", "viewState", "Lkotlin/Function0;", "deletePassenger", "startDeleteFlow", "cancelDeleteFlow", "updatePassenger", "Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler;", "inputHandler", "PassengerEdit", "(Lcom/ramcosta/composedestinations/result/ResultRecipient;Lkotlin/jvm/functions/Function1;Ldk/molslinjen/ui/views/screens/booking/passengers/edit/PassengerEditViewState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "isFormValid", "submitFieldsTrigger", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CheckoutPassengerEditScreenKt {
    public static final void CheckoutPassengerEditScreen(final CheckoutPassengerEditViewModel viewModel, final DestinationsNavigator navigator, final ResultRecipient<NationalitySelectionScreenDestination, Locale> nationalityResultRecipient, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(nationalityResultRecipient, "nationalityResultRecipient");
        Composer startRestartGroup = composer.startRestartGroup(-1699585089);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(nationalityResultRecipient) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1699585089, i6, -1, "dk.molslinjen.ui.views.screens.booking.passengers.edit.CheckoutPassengerEditScreen (CheckoutPassengerEditScreen.kt:48)");
            }
            startRestartGroup.startReplaceGroup(-807398403);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new CheckoutPassengerEditScreenKt$CheckoutPassengerEditScreen$1$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Function1 function1 = (Function1) ((KFunction) rememberedValue);
            PassengerEditViewState passengerEditViewState = (PassengerEditViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(-807394537);
            int i7 = i6 & 112;
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel) | (i7 == 32);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: X2.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CheckoutPassengerEditScreen$lambda$2$lambda$1;
                        CheckoutPassengerEditScreen$lambda$2$lambda$1 = CheckoutPassengerEditScreenKt.CheckoutPassengerEditScreen$lambda$2$lambda$1(CheckoutPassengerEditViewModel.this, navigator);
                        return CheckoutPassengerEditScreen$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function0 function0 = (Function0) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-807391941);
            boolean changedInstance3 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new CheckoutPassengerEditScreenKt$CheckoutPassengerEditScreen$3$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            Function0 function02 = (Function0) ((KFunction) rememberedValue3);
            startRestartGroup.startReplaceGroup(-807390180);
            boolean changedInstance4 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new CheckoutPassengerEditScreenKt$CheckoutPassengerEditScreen$4$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            Function0 function03 = (Function0) ((KFunction) rememberedValue4);
            startRestartGroup.startReplaceGroup(-807388393);
            boolean changedInstance5 = startRestartGroup.changedInstance(viewModel) | (i7 == 32);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance5 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: X2.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CheckoutPassengerEditScreen$lambda$7$lambda$6;
                        CheckoutPassengerEditScreen$lambda$7$lambda$6 = CheckoutPassengerEditScreenKt.CheckoutPassengerEditScreen$lambda$7$lambda$6(CheckoutPassengerEditViewModel.this, navigator);
                        return CheckoutPassengerEditScreen$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            int i8 = (i6 >> 6) & 14;
            int i9 = i6 << 21;
            PassengerEdit(nationalityResultRecipient, function1, passengerEditViewState, function0, function02, function03, (Function0) rememberedValue5, viewModel, navigator, startRestartGroup, i8 | (29360128 & i9) | (i9 & 234881024));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: X2.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CheckoutPassengerEditScreen$lambda$8;
                    CheckoutPassengerEditScreen$lambda$8 = CheckoutPassengerEditScreenKt.CheckoutPassengerEditScreen$lambda$8(CheckoutPassengerEditViewModel.this, navigator, nationalityResultRecipient, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CheckoutPassengerEditScreen$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutPassengerEditScreen$lambda$2$lambda$1(CheckoutPassengerEditViewModel checkoutPassengerEditViewModel, DestinationsNavigator destinationsNavigator) {
        checkoutPassengerEditViewModel.deletePassenger(new CheckoutPassengerEditScreenKt$CheckoutPassengerEditScreen$2$1$1(destinationsNavigator));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutPassengerEditScreen$lambda$7$lambda$6(CheckoutPassengerEditViewModel checkoutPassengerEditViewModel, DestinationsNavigator destinationsNavigator) {
        checkoutPassengerEditViewModel.updatePassenger(new CheckoutPassengerEditScreenKt$CheckoutPassengerEditScreen$5$1$1(destinationsNavigator));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutPassengerEditScreen$lambda$8(CheckoutPassengerEditViewModel checkoutPassengerEditViewModel, DestinationsNavigator destinationsNavigator, ResultRecipient resultRecipient, int i5, Composer composer, int i6) {
        CheckoutPassengerEditScreen(checkoutPassengerEditViewModel, destinationsNavigator, resultRecipient, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void PassengerEdit(final ResultRecipient<NationalitySelectionScreenDestination, Locale> nationalityResultRecipient, final Function1<? super Locale, Unit> updateNationality, final PassengerEditViewState viewState, final Function0<Unit> deletePassenger, final Function0<Unit> startDeleteFlow, final Function0<Unit> cancelDeleteFlow, final Function0<Unit> updatePassenger, final IPassengerInputHandler inputHandler, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(nationalityResultRecipient, "nationalityResultRecipient");
        Intrinsics.checkNotNullParameter(updateNationality, "updateNationality");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(deletePassenger, "deletePassenger");
        Intrinsics.checkNotNullParameter(startDeleteFlow, "startDeleteFlow");
        Intrinsics.checkNotNullParameter(cancelDeleteFlow, "cancelDeleteFlow");
        Intrinsics.checkNotNullParameter(updatePassenger, "updatePassenger");
        Intrinsics.checkNotNullParameter(inputHandler, "inputHandler");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-1396093683);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(nationalityResultRecipient) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(updateNationality) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(viewState) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(deletePassenger) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(startDeleteFlow) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(cancelDeleteFlow) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(updatePassenger) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= (16777216 & i5) == 0 ? startRestartGroup.changed(inputHandler) : startRestartGroup.changedInstance(inputHandler) ? 8388608 : 4194304;
        }
        if ((100663296 & i5) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 67108864 : 33554432;
        }
        int i7 = i6;
        if ((38347923 & i7) == 38347922 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1396093683, i7, -1, "dk.molslinjen.ui.views.screens.booking.passengers.edit.PassengerEdit (CheckoutPassengerEditScreen.kt:73)");
            }
            startRestartGroup.startReplaceGroup(779685984);
            boolean z5 = (i7 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: X2.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PassengerEdit$lambda$10$lambda$9;
                        PassengerEdit$lambda$10$lambda$9 = CheckoutPassengerEditScreenKt.PassengerEdit$lambda$10$lambda$9(Function1.this, (Locale) obj);
                        return PassengerEdit$lambda$10$lambda$9;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            OpenResultRecipientKt.onResult(nationalityResultRecipient, null, (Function1) rememberedValue, startRestartGroup, i7 & 14, 1);
            boolean showDeleteDialog = viewState.getShowDeleteDialog();
            UserPassenger userPassenger = viewState.getUserPassenger();
            composer2.startReplaceGroup(779691028);
            if (showDeleteDialog && userPassenger != null) {
                ProfilePassengerDeleteDialogKt.ProfilePassengerDeleteDialog(userPassenger, viewState.getIsDeleteLoading(), deletePassenger, cancelDeleteFlow, composer2, ((i7 >> 3) & 896) | ((i7 >> 6) & 7168));
            }
            composer2.endReplaceGroup();
            boolean isLoading = viewState.getIsLoading();
            composer2.startReplaceGroup(779701853);
            Object rememberedValue2 = composer2.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState = (MutableState) rememberedValue2;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(779703965);
            Object rememberedValue3 = composer2.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer2.updateRememberedValue(rememberedValue3);
            }
            MutableState mutableState2 = (MutableState) rememberedValue3;
            composer2.endReplaceGroup();
            String stringResource = StringResources_androidKt.stringResource(R.string.passengers_edit_title, composer2, 6);
            composer2.startReplaceGroup(779708914);
            boolean z6 = (i7 & 234881024) == 67108864;
            Object rememberedValue4 = composer2.rememberedValue();
            if (z6 || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new CheckoutPassengerEditScreenKt$PassengerEdit$2$1(navigator);
                composer2.updateRememberedValue(rememberedValue4);
            }
            composer2.endReplaceGroup();
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(null, 0.0f, stringResource, null, 0L, null, (Function0) rememberedValue4, null, ComposableLambdaKt.rememberComposableLambda(-541196657, true, new CheckoutPassengerEditScreenKt$PassengerEdit$3(viewState, updatePassenger, mutableState, mutableState2), composer2, 54), ComposableLambdaKt.rememberComposableLambda(517786464, true, new CheckoutPassengerEditScreenKt$PassengerEdit$4(inputHandler, isLoading, startDeleteFlow, navigator, mutableState2, mutableState), composer2, 54), composer2, 905969664, 187);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: X2.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PassengerEdit$lambda$19;
                    PassengerEdit$lambda$19 = CheckoutPassengerEditScreenKt.PassengerEdit$lambda$19(ResultRecipient.this, updateNationality, viewState, deletePassenger, startDeleteFlow, cancelDeleteFlow, updatePassenger, inputHandler, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return PassengerEdit$lambda$19;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerEdit$lambda$10$lambda$9(Function1 function1, Locale it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PassengerEdit$lambda$12(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PassengerEdit$lambda$13(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PassengerEdit$lambda$15(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PassengerEdit$lambda$16(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerEdit$lambda$19(ResultRecipient resultRecipient, Function1 function1, PassengerEditViewState passengerEditViewState, Function0 function0, Function0 function02, Function0 function03, Function0 function04, IPassengerInputHandler iPassengerInputHandler, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        PassengerEdit(resultRecipient, function1, passengerEditViewState, function0, function02, function03, function04, iPassengerInputHandler, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
