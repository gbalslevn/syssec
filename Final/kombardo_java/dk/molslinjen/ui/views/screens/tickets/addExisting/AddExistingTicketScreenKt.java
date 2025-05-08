package dk.molslinjen.ui.views.screens.tickets.addExisting;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.generated.destinations.PhoneNumberCodeSelectionScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.OpenResultRecipientKt;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.buttons.ButtonConfig;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import dk.molslinjen.ui.views.reusable.input.PhoneNumberInputKt;
import dk.molslinjen.ui.views.reusable.input.StyledTextFieldKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.PhoneNumberInputValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.ReservationNumberValidator;
import dk.molslinjen.ui.views.screens.tickets.addExisting.AddExistingTicketScreenKt;
import dk.molslinjen.ui.views.screens.tickets.addExisting.AddExistingTicketViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a3\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\t\u0010\n\u001ao\u0010\u0015\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0003¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/addExisting/AddExistingTicketViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/PhoneNumberCodeSelectionScreenDestination;", BuildConfig.FLAVOR, "resultRecipient", BuildConfig.FLAVOR, "AddExistingTicketScreen", "(Ldk/molslinjen/ui/views/screens/tickets/addExisting/AddExistingTicketViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/result/ResultRecipient;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/tickets/addExisting/AddExistingTicketViewModel$ViewState;", "state", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "onPhoneNumberChange", "onReservationNumberChange", "Lkotlin/Function0;", "onAddTicketClick", "showValidationMessage", "showPhoneNumberCodeSelector", "AddExistingTicketContent", "(Ldk/molslinjen/ui/views/screens/tickets/addExisting/AddExistingTicketViewModel$ViewState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AddExistingTicketScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void AddExistingTicketContent(final AddExistingTicketViewModel.ViewState viewState, final Function1<? super PhoneNumber, Unit> function1, final Function1<? super String, Unit> function12, final Function0<Unit> function0, final Function1<? super String, Unit> function13, final Function0<Unit> function02, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1650079350);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function13) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1650079350, i6, -1, "dk.molslinjen.ui.views.screens.tickets.addExisting.AddExistingTicketContent (AddExistingTicketScreen.kt:77)");
            }
            final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.startReplaceGroup(-1195217417);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new FormValidator(MapsKt.mapOf(TuplesKt.to(AddExistingTicketFormField.CountryCode, PhoneNumberInputValidator.CountryCode.INSTANCE), TuplesKt.to(AddExistingTicketFormField.NationalNumber, PhoneNumberInputValidator.NationalNumber.INSTANCE), TuplesKt.to(AddExistingTicketFormField.ReservationNumber, ReservationNumberValidator.INSTANCE)), coroutineScope);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final FormValidator formValidator = (FormValidator) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            boolean booleanValue = ((Boolean) SnapshotStateKt.collectAsState(formValidator.isFormValid(), null, startRestartGroup, 0, 1).getValue()).booleanValue();
            final FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            startRestartGroup.startReplaceGroup(-1195200660);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new FocusRequester();
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            FocusRequester focusRequester = (FocusRequester) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(-1195198852);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new AddExistingTicketScreenKt$AddExistingTicketContent$1$1(focusRequester, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue4, startRestartGroup, 6);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            float f5 = 16;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m311padding3ABfNKs(companion2, Dp.m2599constructorimpl(f5)), 0.0f, 1, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            PhoneNumberInputKt.PhoneNumberInput(FocusRequesterModifierKt.focusRequester(companion2, focusRequester), viewState.getPhoneNumber(), function1, function02, AddExistingTicketFormField.NationalNumber, AddExistingTicketFormField.CountryCode, formValidator, false, startRestartGroup, ((i6 << 3) & 896) | 221184 | ((i6 >> 6) & 7168), 128);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            AddExistingTicketFormField addExistingTicketFormField = AddExistingTicketFormField.ReservationNumber;
            String reservationNumber = viewState.getReservationNumber();
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m2417getNumberPjHm6EE(), ImeAction.INSTANCE.m2383getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
            List emptyList = CollectionsKt.emptyList();
            Integer valueOf = Integer.valueOf(R.string.tickets_addExistingTicket_reservationNumber);
            startRestartGroup.startReplaceGroup(908131727);
            boolean z5 = (i6 & 896) == 256;
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: n4.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit AddExistingTicketContent$lambda$14$lambda$8$lambda$7;
                        AddExistingTicketContent$lambda$14$lambda$8$lambda$7 = AddExistingTicketScreenKt.AddExistingTicketContent$lambda$14$lambda$8$lambda$7(Function1.this, (String) obj);
                        return AddExistingTicketContent$lambda$14$lambda$8$lambda$7;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            Function1 function14 = (Function1) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(908133799);
            boolean changedInstance = startRestartGroup.changedInstance(focusManager);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = new Function0() { // from class: n4.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AddExistingTicketContent$lambda$14$lambda$10$lambda$9;
                        AddExistingTicketContent$lambda$14$lambda$10$lambda$9 = AddExistingTicketScreenKt.AddExistingTicketContent$lambda$14$lambda$10$lambda$9(FocusManager.this);
                        return AddExistingTicketContent$lambda$14$lambda$10$lambda$9;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceGroup();
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, emptyList, valueOf, null, null, function14, (Function0) rememberedValue6, reservationNumber, false, null, false, false, 1, addExistingTicketFormField, formValidator, keyboardOptions, null, null, 0L, null, false, 0, startRestartGroup, 27648, 12804096, 0, 16530535);
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, companion2, 1.0f, false, 2, null), startRestartGroup, 0);
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
            String stringResource = StringResources_androidKt.stringResource(R.string.tickets_addExistingTicket_addTicket, startRestartGroup, 6);
            ButtonConfig buttonConfig = ButtonConfig.Large;
            boolean isLoading = viewState.getIsLoading();
            startRestartGroup.startReplaceGroup(908159615);
            boolean changedInstance2 = startRestartGroup.changedInstance(formValidator) | startRestartGroup.changedInstance(context) | ((57344 & i6) == 16384);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue7 == companion.getEmpty()) {
                rememberedValue7 = new Function0() { // from class: n4.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AddExistingTicketContent$lambda$14$lambda$13$lambda$12;
                        AddExistingTicketContent$lambda$14$lambda$13$lambda$12 = AddExistingTicketScreenKt.AddExistingTicketContent$lambda$14$lambda$13$lambda$12(FormValidator.this, context, function13);
                        return AddExistingTicketContent$lambda$14$lambda$13$lambda$12;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            startRestartGroup.endReplaceGroup();
            PrimaryButtonKt.PrimaryButton(fillMaxWidth$default2, stringResource, function0, (Function0) rememberedValue7, buttonConfig, booleanValue, isLoading, false, startRestartGroup, ((i6 >> 3) & 896) | 24582, 128);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(32)), startRestartGroup, 6);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: n4.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AddExistingTicketContent$lambda$15;
                    AddExistingTicketContent$lambda$15 = AddExistingTicketScreenKt.AddExistingTicketContent$lambda$15(AddExistingTicketViewModel.ViewState.this, function1, function12, function0, function13, function02, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return AddExistingTicketContent$lambda$15;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddExistingTicketContent$lambda$14$lambda$10$lambda$9(FocusManager focusManager) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddExistingTicketContent$lambda$14$lambda$13$lambda$12(FormValidator formValidator, Context context, Function1 function1) {
        formValidator.submitAllFields();
        String anyError = formValidator.getAnyError(context);
        if (anyError != null) {
            function1.invoke(anyError);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddExistingTicketContent$lambda$14$lambda$8$lambda$7(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddExistingTicketContent$lambda$15(AddExistingTicketViewModel.ViewState viewState, Function1 function1, Function1 function12, Function0 function0, Function1 function13, Function0 function02, int i5, Composer composer, int i6) {
        AddExistingTicketContent(viewState, function1, function12, function0, function13, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void AddExistingTicketScreen(final AddExistingTicketViewModel viewModel, final DestinationsNavigator navigator, final ResultRecipient<PhoneNumberCodeSelectionScreenDestination, String> resultRecipient, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(resultRecipient, "resultRecipient");
        Composer startRestartGroup = composer.startRestartGroup(1519808524);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(resultRecipient) ? 256 : 128;
        }
        int i7 = i6;
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1519808524, i7, -1, "dk.molslinjen.ui.views.screens.tickets.addExisting.AddExistingTicketScreen (AddExistingTicketScreen.kt:43)");
            }
            startRestartGroup.startReplaceGroup(2056888681);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: n4.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit AddExistingTicketScreen$lambda$1$lambda$0;
                        AddExistingTicketScreen$lambda$1$lambda$0 = AddExistingTicketScreenKt.AddExistingTicketScreen$lambda$1$lambda$0(AddExistingTicketViewModel.this, (String) obj);
                        return AddExistingTicketScreen$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            OpenResultRecipientKt.onResult(resultRecipient, null, (Function1) rememberedValue, startRestartGroup, (i7 >> 6) & 14, 1);
            AddExistingTicketViewModel.ViewState viewState = (AddExistingTicketViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            Modifier closeKeyboardOnClickOutside = ModifierExtensionsKt.closeKeyboardOnClickOutside(Modifier.INSTANCE, (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager()));
            String stringResource = StringResources_androidKt.stringResource(R.string.tickets_addExistingTicket, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(2056898893);
            boolean z5 = (i7 & 112) == 32;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new AddExistingTicketScreenKt$AddExistingTicketScreen$2$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1568165223, true, new AddExistingTicketScreenKt$AddExistingTicketScreen$3(viewState, viewModel, navigator), startRestartGroup, 54);
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(closeKeyboardOnClickOutside, 0.0f, stringResource, null, 0L, null, (Function0) rememberedValue2, null, null, rememberComposableLambda, composer2, 805306368, 442);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: n4.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AddExistingTicketScreen$lambda$3;
                    AddExistingTicketScreen$lambda$3 = AddExistingTicketScreenKt.AddExistingTicketScreen$lambda$3(AddExistingTicketViewModel.this, navigator, resultRecipient, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return AddExistingTicketScreen$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddExistingTicketScreen$lambda$1$lambda$0(AddExistingTicketViewModel addExistingTicketViewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        addExistingTicketViewModel.updatePhoneNumberCode(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddExistingTicketScreen$lambda$3(AddExistingTicketViewModel addExistingTicketViewModel, DestinationsNavigator destinationsNavigator, ResultRecipient resultRecipient, int i5, Composer composer, int i6) {
        AddExistingTicketScreen(addExistingTicketViewModel, destinationsNavigator, resultRecipient, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
