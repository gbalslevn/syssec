package dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.add;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AutofillType;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BlockedDismissType;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetDismissHandler;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.buttons.ButtonConfig;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import dk.molslinjen.ui.views.reusable.dialog.SimpleButtonData;
import dk.molslinjen.ui.views.reusable.dialog.TextDialogKt;
import dk.molslinjen.ui.views.reusable.input.StyledTextFieldKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.EmailInputValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.NonEmptyStringValidator;
import dk.molslinjen.ui.views.reusable.model.UIUploadState;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.add.BornholmCommuterAddScreenKt;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.add.BornholmCommuterAddViewModel;
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
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a7\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001aM\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\u000f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n0\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0013H\u0003¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/commuter/bornholm/add/BornholmCommuterAddViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Landroidx/navigation/NavController;", "navController", "Landroidx/navigation/NavBackStackEntry;", "navBackStackEntry", "Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetDismissHandler;", "bottomSheetDismissHandler", BuildConfig.FLAVOR, "BornholmCommuterAddScreen", "(Ldk/molslinjen/ui/views/screens/agreements/commuter/bornholm/add/BornholmCommuterAddViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/navigation/NavController;Landroidx/navigation/NavBackStackEntry;Ldk/molslinjen/ui/views/global/navigation/bottomsheet/BottomSheetDismissHandler;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/agreements/commuter/bornholm/add/BornholmCommuterAddViewModel$ViewState;", "viewState", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onEmailChanged", "onPasswordChanged", "Lkotlin/Function0;", "onAddCommuterCard", "AddAgreementContent", "(Ldk/molslinjen/ui/views/screens/agreements/commuter/bornholm/add/BornholmCommuterAddViewModel$ViewState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BornholmCommuterAddScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void AddAgreementContent(final BornholmCommuterAddViewModel.ViewState viewState, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, final Function0<Unit> function0, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(2032849056);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(viewState) ? 4 : 2) | i5;
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
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2032849056, i6, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.add.AddAgreementContent (BornholmCommuterAddScreen.kt:99)");
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.startReplaceGroup(-2119230147);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new FormValidator(MapsKt.mapOf(TuplesKt.to(BornholmCommuterAddFormField.Email, EmailInputValidator.INSTANCE), TuplesKt.to(BornholmCommuterAddFormField.Password, NonEmptyStringValidator.INSTANCE)), coroutineScope);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final FormValidator formValidator = (FormValidator) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            boolean booleanValue = ((Boolean) SnapshotStateKt.collectAsState(formValidator.isFormValid(), null, startRestartGroup, 0, 1).getValue()).booleanValue();
            boolean z5 = viewState.getUploadState() == UIUploadState.Loading;
            final FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            startRestartGroup.startReplaceGroup(-2119215399);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new FocusRequester();
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            FocusRequester focusRequester = (FocusRequester) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(-2119213591);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new BornholmCommuterAddScreenKt$AddAgreementContent$1$1(focusRequester, null);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue4, startRestartGroup, 6);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            float f5 = 16;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), Dp.m2599constructorimpl(f5), 0.0f, 2, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
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
            Modifier focusRequester2 = FocusRequesterModifierKt.focusRequester(companion2, focusRequester);
            BornholmCommuterAddFormField bornholmCommuterAddFormField = BornholmCommuterAddFormField.Email;
            String email = viewState.getEmail();
            KeyboardType.Companion companion4 = KeyboardType.INSTANCE;
            int m2416getEmailPjHm6EE = companion4.m2416getEmailPjHm6EE();
            ImeAction.Companion companion5 = ImeAction.INSTANCE;
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, m2416getEmailPjHm6EE, companion5.m2385getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
            List listOf = CollectionsKt.listOf((Object[]) new AutofillType[]{AutofillType.EmailAddress, AutofillType.Username});
            Integer valueOf = Integer.valueOf(R.string.textField_label_email);
            startRestartGroup.startReplaceGroup(-1520065238);
            boolean changedInstance = startRestartGroup.changedInstance(focusManager);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: r2.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AddAgreementContent$lambda$13$lambda$8$lambda$7;
                        AddAgreementContent$lambda$13$lambda$8$lambda$7 = BornholmCommuterAddScreenKt.AddAgreementContent$lambda$13$lambda$8$lambda$7(FocusManager.this);
                        return AddAgreementContent$lambda$13$lambda$8$lambda$7;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(focusRequester2, false, 0.0f, listOf, valueOf, null, null, function1, (Function0) rememberedValue5, email, false, null, false, false, 0, bornholmCommuterAddFormField, formValidator, keyboardOptions, null, null, 0L, null, false, 0, startRestartGroup, ((i6 << 18) & 29360128) | 27648, 12779520, 0, 16546918);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            BornholmCommuterAddFormField bornholmCommuterAddFormField2 = BornholmCommuterAddFormField.Password;
            String password = viewState.getPassword();
            KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, (Boolean) null, companion4.m2419getPasswordPjHm6EE(), companion5.m2383getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
            List listOf2 = CollectionsKt.listOf(AutofillType.Password);
            Integer valueOf2 = Integer.valueOf(R.string.textField_label_password);
            startRestartGroup.startReplaceGroup(-1520043319);
            boolean changedInstance2 = startRestartGroup.changedInstance(focusManager) | startRestartGroup.changedInstance(formValidator) | ((i6 & 7168) == 2048);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = new Function0() { // from class: r2.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AddAgreementContent$lambda$13$lambda$10$lambda$9;
                        AddAgreementContent$lambda$13$lambda$10$lambda$9 = BornholmCommuterAddScreenKt.AddAgreementContent$lambda$13$lambda$10$lambda$9(FocusManager.this, formValidator, function0);
                        return AddAgreementContent$lambda$13$lambda$10$lambda$9;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceGroup();
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, listOf2, valueOf2, null, null, function12, (Function0) rememberedValue6, password, true, null, false, false, 0, bornholmCommuterAddFormField2, formValidator, keyboardOptions2, null, null, 0L, null, false, 0, startRestartGroup, ((i6 << 15) & 29360128) | 27648, 12779526, 0, 16545895);
            float f6 = 40;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(f6)), startRestartGroup, 6);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null);
            String stringResource = StringResources_androidKt.stringResource(R.string.button_add, startRestartGroup, 6);
            ButtonConfig buttonConfig = ButtonConfig.Large;
            boolean z6 = booleanValue && !z5;
            startRestartGroup.startReplaceGroup(-1520012010);
            boolean changedInstance3 = startRestartGroup.changedInstance(formValidator);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue7 == companion.getEmpty()) {
                rememberedValue7 = new Function0() { // from class: r2.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AddAgreementContent$lambda$13$lambda$12$lambda$11;
                        AddAgreementContent$lambda$13$lambda$12$lambda$11 = BornholmCommuterAddScreenKt.AddAgreementContent$lambda$13$lambda$12$lambda$11(FormValidator.this);
                        return AddAgreementContent$lambda$13$lambda$12$lambda$11;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            PrimaryButtonKt.PrimaryButton(fillMaxWidth$default, stringResource, function0, (Function0) rememberedValue7, buttonConfig, z6, z5, false, startRestartGroup, ((i6 >> 3) & 896) | 24582, 128);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(f6)), composer2, 6);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: r2.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AddAgreementContent$lambda$14;
                    AddAgreementContent$lambda$14 = BornholmCommuterAddScreenKt.AddAgreementContent$lambda$14(BornholmCommuterAddViewModel.ViewState.this, function1, function12, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return AddAgreementContent$lambda$14;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAgreementContent$lambda$13$lambda$10$lambda$9(FocusManager focusManager, FormValidator formValidator, Function0 function0) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1281getExitdhqQ8s());
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        formValidator.submitAllFields();
        if (formValidator.isFormValid().getValue().booleanValue()) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAgreementContent$lambda$13$lambda$12$lambda$11(FormValidator formValidator) {
        formValidator.submitAllFields();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAgreementContent$lambda$13$lambda$8$lambda$7(FocusManager focusManager) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1283getNextdhqQ8s());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAgreementContent$lambda$14(BornholmCommuterAddViewModel.ViewState viewState, Function1 function1, Function1 function12, Function0 function0, int i5, Composer composer, int i6) {
        AddAgreementContent(viewState, function1, function12, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void BornholmCommuterAddScreen(final BornholmCommuterAddViewModel viewModel, final DestinationsNavigator navigator, final NavController navController, final NavBackStackEntry navBackStackEntry, final BottomSheetDismissHandler bottomSheetDismissHandler, Composer composer, final int i5) {
        int i6;
        int i7;
        Composer composer2;
        Function0 function0;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(navBackStackEntry, "navBackStackEntry");
        Intrinsics.checkNotNullParameter(bottomSheetDismissHandler, "bottomSheetDismissHandler");
        Composer startRestartGroup = composer.startRestartGroup(157054181);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(navController) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(navBackStackEntry) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(bottomSheetDismissHandler) ? 16384 : 8192;
        }
        int i8 = i6;
        if ((i8 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(157054181, i8, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.add.BornholmCommuterAddScreen (BornholmCommuterAddScreen.kt:56)");
            }
            bottomSheetDismissHandler.SetupHandling(navBackStackEntry, navController, navigator, BlockedDismissType.DragToDismiss, startRestartGroup, ((i8 >> 9) & 14) | 3072 | ((i8 >> 3) & 112) | ((i8 << 3) & 896) | (57344 & i8));
            BornholmCommuterAddViewModel.ViewState viewState = (BornholmCommuterAddViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(842728420);
            if (viewState.getShowErrorDialog()) {
                String stringResource = StringResources_androidKt.stringResource(R.string.commuter_add_error_title, startRestartGroup, 6);
                String stringResource2 = StringResources_androidKt.stringResource(R.string.commuter_add_error_description, startRestartGroup, 6);
                String stringResource3 = StringResources_androidKt.stringResource(R.string.button_ok, startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(842739274);
                boolean changedInstance = startRestartGroup.changedInstance(viewModel);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new BornholmCommuterAddScreenKt$BornholmCommuterAddScreen$1$1(viewModel);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                SimpleButtonData simpleButtonData = new SimpleButtonData(stringResource3, false, false, (Function0) ((KFunction) rememberedValue), 6, null);
                startRestartGroup.startReplaceGroup(842741610);
                boolean changedInstance2 = startRestartGroup.changedInstance(viewModel);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new BornholmCommuterAddScreenKt$BornholmCommuterAddScreen$2$1(viewModel);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                Function0 function02 = (Function0) ((KFunction) rememberedValue2);
                i7 = 32;
                composer2 = startRestartGroup;
                TextDialogKt.TextDialog(stringResource, stringResource2, simpleButtonData, null, null, false, function02, composer2, 0, 56);
            } else {
                i7 = 32;
                composer2 = startRestartGroup;
            }
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(842744322);
            if (viewState.getUploadState() == UIUploadState.Idle) {
                composer2.startReplaceGroup(842745831);
                boolean z5 = (i8 & 112) == i7;
                Object rememberedValue3 = composer2.rememberedValue();
                if (z5 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new BornholmCommuterAddScreenKt$BornholmCommuterAddScreen$onCloseAction$1$1(navigator);
                    composer2.updateRememberedValue(rememberedValue3);
                }
                composer2.endReplaceGroup();
                function0 = (Function0) rememberedValue3;
            } else {
                function0 = null;
            }
            composer2.endReplaceGroup();
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(ModifierExtensionsKt.closeKeyboardOnClickOutside(Modifier.INSTANCE, (FocusManager) composer2.consume(CompositionLocalsKt.getLocalFocusManager())), 0.0f, StringResources_androidKt.stringResource(R.string.commuter_add_title, composer2, 6), null, 0L, null, function0, null, null, ComposableLambdaKt.rememberComposableLambda(-164237960, true, new BornholmCommuterAddScreenKt$BornholmCommuterAddScreen$3(viewState, viewModel, navigator), composer2, 54), composer2, 805306368, 442);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: r2.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BornholmCommuterAddScreen$lambda$3;
                    BornholmCommuterAddScreen$lambda$3 = BornholmCommuterAddScreenKt.BornholmCommuterAddScreen$lambda$3(BornholmCommuterAddViewModel.this, navigator, navController, navBackStackEntry, bottomSheetDismissHandler, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return BornholmCommuterAddScreen$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BornholmCommuterAddScreen$lambda$3(BornholmCommuterAddViewModel bornholmCommuterAddViewModel, DestinationsNavigator destinationsNavigator, NavController navController, NavBackStackEntry navBackStackEntry, BottomSheetDismissHandler bottomSheetDismissHandler, int i5, Composer composer, int i6) {
        BornholmCommuterAddScreen(bornholmCommuterAddViewModel, destinationsNavigator, navController, navBackStackEntry, bottomSheetDismissHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
