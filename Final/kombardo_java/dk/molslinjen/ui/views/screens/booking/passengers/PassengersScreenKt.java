package dk.molslinjen.ui.views.screens.booking.passengers;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.ramcosta.composedestinations.generated.destinations.CheckoutDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.CheckoutPassengerCreateScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.CheckoutPassengerEditScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.NationalitySelectionScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PassengerHelpScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.EditManager;
import dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.booking.TicketSection;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.screens.booking.passengers.PassengersScreenKt;
import dk.molslinjen.ui.views.screens.booking.passengers.PassengersViewModel;
import dk.molslinjen.ui.views.screens.config.regular.checkout.helpers.ICheckoutExpirationDialogHandler;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a;\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001aý\u0001\u0010&\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u00152\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\n0\u001a2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\n0\u001a2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u00152\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\u00152\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\u00152\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\n0\u001a2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\n0\u001a2\u0006\u0010%\u001a\u00020\"H\u0003¢\u0006\u0004\b&\u0010'¨\u0006("}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/passengers/PassengersViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/NationalitySelectionScreenDestination;", "Ljava/util/Locale;", "nationalityResultRecipient", "Ldk/molslinjen/ui/views/screens/config/regular/checkout/helpers/ICheckoutExpirationDialogHandler;", "checkoutExpirationDialogHandler", BuildConfig.FLAVOR, "PassengersScreen", "(Ldk/molslinjen/ui/views/screens/booking/passengers/PassengersViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/result/ResultRecipient;Ldk/molslinjen/ui/views/screens/config/regular/checkout/helpers/ICheckoutExpirationDialogHandler;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/booking/passengers/PassengersViewModel$ViewState;", "state", "Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;", "passengerState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;", "checkoutState", "Ldk/molslinjen/domain/managers/checkout/EditManager$EditState;", "editState", "Lkotlin/Function0;", "proceed", "showTicketDetails", "createPassenger", "showHelp", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "toggleSelected", BuildConfig.FLAVOR, "editPassenger", "showAgeGroupError", "navigateToNationalitySelection", "onCurrentUserCreatedAsPassenger", BuildConfig.FLAVOR, "changeSameReturnPassengersAsOutbound", "showValidationMessage", "movePassengerInfo", "PassengersContent", "(Ldk/molslinjen/ui/views/screens/booking/passengers/PassengersViewModel$ViewState;Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;Ldk/molslinjen/domain/managers/checkout/EditManager$EditState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PassengersScreenKt {
    private static final void PassengersContent(final PassengersViewModel.ViewState viewState, final PassengerSelectionHelper.PassengerState passengerState, final CheckoutManager.CheckoutState checkoutState, final EditManager.EditState editState, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, final Function1<? super BookingPassenger, Unit> function1, final Function1<? super String, Unit> function12, final Function0<Unit> function05, final ResultRecipient<NationalitySelectionScreenDestination, Locale> resultRecipient, final Function0<Unit> function06, final Function0<Unit> function07, final Function1<? super Boolean, Unit> function13, final Function1<? super String, Unit> function14, final boolean z5, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1030787035);
        if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(passengerState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(checkoutState) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(editState) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((i5 & 196608) == 0) {
            i7 |= startRestartGroup.changedInstance(function02) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i7 |= startRestartGroup.changedInstance(function03) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i7 |= startRestartGroup.changedInstance(function04) ? 8388608 : 4194304;
        }
        if ((i5 & 100663296) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 67108864 : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i7 |= startRestartGroup.changedInstance(function12) ? 536870912 : 268435456;
        }
        if ((i6 & 6) == 0) {
            i8 = (startRestartGroup.changedInstance(function05) ? 4 : 2) | i6;
        } else {
            i8 = i6;
        }
        if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changed(resultRecipient) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i8 |= startRestartGroup.changedInstance(function06) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i8 |= startRestartGroup.changedInstance(function07) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i8 |= startRestartGroup.changedInstance(function13) ? 16384 : 8192;
        }
        if ((i6 & 196608) == 0) {
            i8 |= startRestartGroup.changedInstance(function14) ? 131072 : 65536;
        }
        if ((i6 & 1572864) == 0) {
            i8 |= startRestartGroup.changed(z5) ? 1048576 : 524288;
        }
        if ((i7 & 306783379) == 306783378 && (599187 & i8) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1030787035, i7, i8, "dk.molslinjen.ui.views.screens.booking.passengers.PassengersContent (PassengersScreen.kt:127)");
            }
            Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            PassengerFormField passengerFormField = PassengerFormField.PassengerFields;
            startRestartGroup.startReplaceGroup(-1749604059);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new FormValidator(MapsKt.mapOf(TuplesKt.to(passengerFormField, PassengerValidator.INSTANCE)), coroutineScope);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            FormValidator formValidator = (FormValidator) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            boolean booleanValue = ((Boolean) SnapshotStateKt.collectAsState(formValidator.isFormValid(), null, startRestartGroup, 0, 1).getValue()).booleanValue();
            formValidator.set(passengerFormField, PassengerValidator.INSTANCE.validateInput(viewState.getRemainingAdultCount(), viewState.getRemainingChildCount(), viewState.getRemainingInfantCount(), viewState.getRemainingPassengerCount(), viewState.getShowAgeGroup(), viewState.getPassengerCount(), context));
            startRestartGroup.startReplaceGroup(-1749581360);
            boolean changedInstance = startRestartGroup.changedInstance(formValidator);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new PassengersScreenKt$PassengersContent$1$1(formValidator, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(passengerState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue3, startRestartGroup, (i7 >> 3) & 14);
            composer2 = startRestartGroup;
            LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, viewState.getIsLoading(), 0, false, null, ComposableLambdaKt.rememberComposableLambda(-2009370585, true, new PassengersScreenKt$PassengersContent$2(passengerState, editState, function07, function04, resultRecipient, function06, checkoutState, function1, function03, context, viewState, function12, function05, function13, z5, booleanValue, function02, formValidator, function14, function0), composer2, 54), composer2, 1572864, 59);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: U2.L
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PassengersContent$lambda$21;
                    PassengersContent$lambda$21 = PassengersScreenKt.PassengersContent$lambda$21(PassengersViewModel.ViewState.this, passengerState, checkoutState, editState, function0, function02, function03, function04, function1, function12, function05, resultRecipient, function06, function07, function13, function14, z5, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return PassengersContent$lambda$21;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengersContent$lambda$21(PassengersViewModel.ViewState viewState, PassengerSelectionHelper.PassengerState passengerState, CheckoutManager.CheckoutState checkoutState, EditManager.EditState editState, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function1 function1, Function1 function12, Function0 function05, ResultRecipient resultRecipient, Function0 function06, Function0 function07, Function1 function13, Function1 function14, boolean z5, int i5, int i6, Composer composer, int i7) {
        PassengersContent(viewState, passengerState, checkoutState, editState, function0, function02, function03, function04, function1, function12, function05, resultRecipient, function06, function07, function13, function14, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
        return Unit.INSTANCE;
    }

    public static final void PassengersScreen(final PassengersViewModel viewModel, final DestinationsNavigator navigator, final ResultRecipient<NationalitySelectionScreenDestination, Locale> nationalityResultRecipient, final ICheckoutExpirationDialogHandler checkoutExpirationDialogHandler, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(nationalityResultRecipient, "nationalityResultRecipient");
        Intrinsics.checkNotNullParameter(checkoutExpirationDialogHandler, "checkoutExpirationDialogHandler");
        Composer startRestartGroup = composer.startRestartGroup(731823652);
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
        if ((i5 & 3072) == 0) {
            i6 |= (i5 & 4096) == 0 ? startRestartGroup.changed(checkoutExpirationDialogHandler) : startRestartGroup.changedInstance(checkoutExpirationDialogHandler) ? 2048 : 1024;
        }
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(731823652, i6, -1, "dk.molslinjen.ui.views.screens.booking.passengers.PassengersScreen (PassengersScreen.kt:63)");
            }
            int i7 = i6 & 112;
            int i8 = i6 & 126;
            int i9 = i6 >> 3;
            checkoutExpirationDialogHandler.HandleDepartureExpiration(viewModel, navigator, startRestartGroup, i8 | (i9 & 896));
            final PassengersViewModel.ViewState viewState = (PassengersViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            PassengerSelectionHelper.PassengerState passengerState = (PassengerSelectionHelper.PassengerState) SnapshotStateKt.collectAsState(viewModel.getPassengerState(), null, startRestartGroup, 0, 1).getValue();
            final CheckoutManager.CheckoutState checkoutState = (CheckoutManager.CheckoutState) SnapshotStateKt.collectAsState(viewModel.getCheckoutState(), null, startRestartGroup, 0, 1).getValue();
            if (checkoutState == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: U2.D
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit PassengersScreen$lambda$0;
                            PassengersScreen$lambda$0 = PassengersScreenKt.PassengersScreen$lambda$0(PassengersViewModel.this, navigator, nationalityResultRecipient, checkoutExpirationDialogHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return PassengersScreen$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            EditManager.EditState editState = (EditManager.EditState) SnapshotStateKt.collectAsState(viewModel.getEditState(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(1900505194);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel) | (i7 == 32);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: U2.E
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PassengersScreen$lambda$2$lambda$1;
                        PassengersScreen$lambda$2$lambda$1 = PassengersScreenKt.PassengersScreen$lambda$2$lambda$1(PassengersViewModel.this, navigator);
                        return PassengersScreen$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1900507557);
            boolean z5 = i7 == 32;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: U2.F
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PassengersScreen$lambda$4$lambda$3;
                        PassengersScreen$lambda$4$lambda$3 = PassengersScreenKt.PassengersScreen$lambda$4$lambda$3(DestinationsNavigator.this);
                        return PassengersScreen$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function0 function02 = (Function0) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1900511898);
            boolean changedInstance2 = (i7 == 32) | startRestartGroup.changedInstance(viewState) | startRestartGroup.changedInstance(checkoutState);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: U2.G
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PassengersScreen$lambda$6$lambda$5;
                        PassengersScreen$lambda$6$lambda$5 = PassengersScreenKt.PassengersScreen$lambda$6$lambda$5(DestinationsNavigator.this, viewState, checkoutState);
                        return PassengersScreen$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            Function0 function03 = (Function0) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1900522378);
            boolean z6 = i7 == 32;
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: U2.H
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PassengersScreen$lambda$8$lambda$7;
                        PassengersScreen$lambda$8$lambda$7 = PassengersScreenKt.PassengersScreen$lambda$8$lambda$7(DestinationsNavigator.this);
                        return PassengersScreen$lambda$8$lambda$7;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            Function0 function04 = (Function0) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1900525561);
            boolean changedInstance3 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new PassengersScreenKt$PassengersScreen$5$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            Function1 function1 = (Function1) ((KFunction) rememberedValue5);
            startRestartGroup.startReplaceGroup(1900527300);
            boolean changedInstance4 = (i7 == 32) | startRestartGroup.changedInstance(viewState) | startRestartGroup.changedInstance(checkoutState);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance4 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = new Function1() { // from class: U2.I
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PassengersScreen$lambda$11$lambda$10;
                        PassengersScreen$lambda$11$lambda$10 = PassengersScreenKt.PassengersScreen$lambda$11$lambda$10(DestinationsNavigator.this, viewState, checkoutState, (String) obj);
                        return PassengersScreen$lambda$11$lambda$10;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            Function1 function12 = (Function1) rememberedValue6;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1900532380);
            boolean changedInstance5 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changedInstance5 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = new PassengersScreenKt$PassengersScreen$7$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            startRestartGroup.endReplaceGroup();
            Function0 function05 = (Function0) ((KFunction) rememberedValue7);
            startRestartGroup.startReplaceGroup(1900536785);
            boolean z7 = i7 == 32;
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                rememberedValue8 = new Function0() { // from class: U2.J
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit PassengersScreen$lambda$14$lambda$13;
                        PassengersScreen$lambda$14$lambda$13 = PassengersScreenKt.PassengersScreen$lambda$14$lambda$13(DestinationsNavigator.this);
                        return PassengersScreen$lambda$14$lambda$13;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            Function0 function06 = (Function0) rememberedValue8;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1900540746);
            boolean changedInstance6 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (changedInstance6 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                rememberedValue9 = new PassengersScreenKt$PassengersScreen$9$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            startRestartGroup.endReplaceGroup();
            Function0 function07 = (Function0) ((KFunction) rememberedValue9);
            startRestartGroup.startReplaceGroup(1900543663);
            boolean changedInstance7 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (changedInstance7 || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                rememberedValue10 = new PassengersScreenKt$PassengersScreen$10$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            startRestartGroup.endReplaceGroup();
            Function1 function13 = (Function1) ((KFunction) rememberedValue10);
            startRestartGroup.startReplaceGroup(1900546240);
            boolean changedInstance8 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (changedInstance8 || rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                rememberedValue11 = new PassengersScreenKt$PassengersScreen$11$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            PassengersContent(viewState, passengerState, checkoutState, editState, function0, function02, function03, function04, function1, function12, function05, nationalityResultRecipient, function06, function07, function13, (Function1) ((KFunction) rememberedValue11), viewModel.getMovePassengerInfo(), composer2, 0, i9 & 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: U2.K
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PassengersScreen$lambda$18;
                    PassengersScreen$lambda$18 = PassengersScreenKt.PassengersScreen$lambda$18(PassengersViewModel.this, navigator, nationalityResultRecipient, checkoutExpirationDialogHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return PassengersScreen$lambda$18;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengersScreen$lambda$0(PassengersViewModel passengersViewModel, DestinationsNavigator destinationsNavigator, ResultRecipient resultRecipient, ICheckoutExpirationDialogHandler iCheckoutExpirationDialogHandler, int i5, Composer composer, int i6) {
        PassengersScreen(passengersViewModel, destinationsNavigator, resultRecipient, iCheckoutExpirationDialogHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengersScreen$lambda$11$lambda$10(DestinationsNavigator destinationsNavigator, PassengersViewModel.ViewState viewState, CheckoutManager.CheckoutState checkoutState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, CheckoutPassengerEditScreenDestination.INSTANCE.invoke(it, viewState.getDepartureDirection(), checkoutState.getSite()), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengersScreen$lambda$14$lambda$13(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, NationalitySelectionScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengersScreen$lambda$18(PassengersViewModel passengersViewModel, DestinationsNavigator destinationsNavigator, ResultRecipient resultRecipient, ICheckoutExpirationDialogHandler iCheckoutExpirationDialogHandler, int i5, Composer composer, int i6) {
        PassengersScreen(passengersViewModel, destinationsNavigator, resultRecipient, iCheckoutExpirationDialogHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengersScreen$lambda$2$lambda$1(PassengersViewModel passengersViewModel, DestinationsNavigator destinationsNavigator) {
        passengersViewModel.proceed(new PassengersScreenKt$PassengersScreen$1$1$1(destinationsNavigator));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengersScreen$lambda$4$lambda$3(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, CheckoutDetailsScreenDestination.INSTANCE.invoke(TicketSection.Passenger), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengersScreen$lambda$6$lambda$5(DestinationsNavigator destinationsNavigator, PassengersViewModel.ViewState viewState, CheckoutManager.CheckoutState checkoutState) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, CheckoutPassengerCreateScreenDestination.INSTANCE.invoke(viewState.getDepartureDirection(), viewState.getRemainingPassengerCount() > 0, checkoutState.getSite()), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengersScreen$lambda$8$lambda$7(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, PassengerHelpScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }
}
