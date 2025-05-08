package dk.molslinjen.ui.views.screens.booking.passengers;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import com.ramcosta.composedestinations.generated.destinations.NationalitySelectionScreenDestination;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.managers.checkout.EditManager;
import dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.screens.booking.passengers.PassengersViewModel;
import dk.molslinjen.ui.views.screens.booking.shared.CheckoutButtonSheetBottomBarKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class PassengersScreenKt$PassengersContent$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $changeSameReturnPassengersAsOutbound;
    final /* synthetic */ CheckoutManager.CheckoutState $checkoutState;
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0<Unit> $createPassenger;
    final /* synthetic */ Function1<String, Unit> $editPassenger;
    final /* synthetic */ EditManager.EditState $editState;
    final /* synthetic */ boolean $isFormValid;
    final /* synthetic */ boolean $movePassengerInfo;
    final /* synthetic */ ResultRecipient<NationalitySelectionScreenDestination, Locale> $nationalityResultRecipient;
    final /* synthetic */ Function0<Unit> $navigateToNationalitySelection;
    final /* synthetic */ Function0<Unit> $onCurrentUserCreatedAsPassenger;
    final /* synthetic */ PassengerSelectionHelper.PassengerState $passengerState;
    final /* synthetic */ Function0<Unit> $proceed;
    final /* synthetic */ Function0<Unit> $showAgeGroupError;
    final /* synthetic */ Function0<Unit> $showHelp;
    final /* synthetic */ Function0<Unit> $showTicketDetails;
    final /* synthetic */ Function1<String, Unit> $showValidationMessage;
    final /* synthetic */ PassengersViewModel.ViewState $state;
    final /* synthetic */ Function1<BookingPassenger, Unit> $toggleSelected;
    final /* synthetic */ FormValidator $validator;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public PassengersScreenKt$PassengersContent$2(PassengerSelectionHelper.PassengerState passengerState, EditManager.EditState editState, Function0<Unit> function0, Function0<Unit> function02, ResultRecipient<NationalitySelectionScreenDestination, Locale> resultRecipient, Function0<Unit> function03, CheckoutManager.CheckoutState checkoutState, Function1<? super BookingPassenger, Unit> function1, Function0<Unit> function04, Context context, PassengersViewModel.ViewState viewState, Function1<? super String, Unit> function12, Function0<Unit> function05, Function1<? super Boolean, Unit> function13, boolean z5, boolean z6, Function0<Unit> function06, FormValidator formValidator, Function1<? super String, Unit> function14, Function0<Unit> function07) {
        this.$passengerState = passengerState;
        this.$editState = editState;
        this.$onCurrentUserCreatedAsPassenger = function0;
        this.$showHelp = function02;
        this.$nationalityResultRecipient = resultRecipient;
        this.$navigateToNationalitySelection = function03;
        this.$checkoutState = checkoutState;
        this.$toggleSelected = function1;
        this.$createPassenger = function04;
        this.$context = context;
        this.$state = viewState;
        this.$editPassenger = function12;
        this.$showAgeGroupError = function05;
        this.$changeSameReturnPassengersAsOutbound = function13;
        this.$movePassengerInfo = z5;
        this.$isFormValid = z6;
        this.$showTicketDetails = function06;
        this.$validator = formValidator;
        this.$showValidationMessage = function14;
        this.$proceed = function07;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2$lambda$1(FormValidator formValidator, Context context, Function1 function1) {
        formValidator.submitAllFields();
        String anyError = formValidator.getAnyError(context);
        if (anyError != null) {
            function1.invoke(anyError);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        String stringResource;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2009370585, i5, -1, "dk.molslinjen.ui.views.screens.booking.passengers.PassengersContent.<anonymous> (PassengersScreen.kt:158)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null);
        PassengerSelectionHelper.PassengerState passengerState = this.$passengerState;
        EditManager.EditState editState = this.$editState;
        Function0<Unit> function0 = this.$onCurrentUserCreatedAsPassenger;
        Function0<Unit> function02 = this.$showHelp;
        ResultRecipient<NationalitySelectionScreenDestination, Locale> resultRecipient = this.$nationalityResultRecipient;
        Function0<Unit> function03 = this.$navigateToNationalitySelection;
        CheckoutManager.CheckoutState checkoutState = this.$checkoutState;
        Function1<BookingPassenger, Unit> function1 = this.$toggleSelected;
        Function0<Unit> function04 = this.$createPassenger;
        final Context context = this.$context;
        PassengersViewModel.ViewState viewState = this.$state;
        Function1<String, Unit> function12 = this.$editPassenger;
        Function0<Unit> function05 = this.$showAgeGroupError;
        Function1<Boolean, Unit> function13 = this.$changeSameReturnPassengersAsOutbound;
        boolean z5 = this.$movePassengerInfo;
        boolean z6 = this.$isFormValid;
        Function0<Unit> function06 = this.$showTicketDetails;
        final FormValidator formValidator = this.$validator;
        final Function1<String, Unit> function14 = this.$showValidationMessage;
        Function0<Unit> function07 = this.$proceed;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m104backgroundbw27NRU$default);
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion2.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
        NameRegistrationSectionKt.NameRegistrationSection(ColumnScopeInstance.INSTANCE, passengerState, editState.getIsEditing(), function0, function02, resultRecipient, function03, checkoutState, function1, function04, context, viewState, function12, function05, function13, z5, composer, 6, 0);
        composer.startReplaceGroup(1146516032);
        if (passengerState.getCurrentUser() != null || editState.getIsEditing()) {
            Modifier modifier = ModifierExtensionsKt.topShadow(companion);
            if (z6) {
                composer.startReplaceGroup(1182444626);
                stringResource = StringResources_androidKt.pluralStringResource(R.plurals.passengers_proceedButton_validCount, viewState.getPassengerCount(), new Object[]{Integer.valueOf(viewState.getPassengerCount())}, composer, 6);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1182712497);
                stringResource = StringResources_androidKt.stringResource(R.string.passengers_proceedButton_invalidCount, composer, 6);
                composer.endReplaceGroup();
            }
            PriceTotal totalPrice = checkoutState.getPriceDetails().getTotalPrice();
            boolean isEditing = editState.getIsEditing();
            composer.startReplaceGroup(1146536828);
            boolean changedInstance = composer.changedInstance(formValidator) | composer.changedInstance(context) | composer.changed(function14);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$3$lambda$2$lambda$1;
                        invoke$lambda$3$lambda$2$lambda$1 = PassengersScreenKt$PassengersContent$2.invoke$lambda$3$lambda$2$lambda$1(FormValidator.this, context, function14);
                        return invoke$lambda$3$lambda$2$lambda$1;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            CheckoutButtonSheetBottomBarKt.CheckoutButtonSheetBottomBar(modifier, stringResource, totalPrice, isEditing, null, z6, function06, (Function0) rememberedValue, function07, composer, 0, 16);
        }
        composer.endReplaceGroup();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
