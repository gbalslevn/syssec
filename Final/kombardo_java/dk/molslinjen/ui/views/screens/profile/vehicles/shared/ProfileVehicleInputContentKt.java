package dk.molslinjen.ui.views.screens.profile.vehicles.shared;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import defpackage.LicensePlateInputFieldKt;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.input.StyledTextFieldKt;
import dk.molslinjen.ui.views.reusable.input.licensePlate.LicensePlateInputValidator;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.screens.profile.vehicles.shared.ProfileVehicleInputContentKt;
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

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ay\u0010\r\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {BuildConfig.FLAVOR, "licensePlateInput", "nameInput", BuildConfig.FLAVOR, "isLoading", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onLicensePlateChange", "onNameChange", "submitFieldsTrigger", "onFormValidationChange", "Lkotlin/Function0;", "onKeyboardSubmit", "ProfileVehicleInputContent", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProfileVehicleInputContentKt {
    public static final void ProfileVehicleInputContent(final String licensePlateInput, final String nameInput, final boolean z5, final Function1<? super String, Unit> onLicensePlateChange, final Function1<? super String, Unit> onNameChange, final boolean z6, final Function1<? super Boolean, Unit> onFormValidationChange, final Function0<Unit> onKeyboardSubmit, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(licensePlateInput, "licensePlateInput");
        Intrinsics.checkNotNullParameter(nameInput, "nameInput");
        Intrinsics.checkNotNullParameter(onLicensePlateChange, "onLicensePlateChange");
        Intrinsics.checkNotNullParameter(onNameChange, "onNameChange");
        Intrinsics.checkNotNullParameter(onFormValidationChange, "onFormValidationChange");
        Intrinsics.checkNotNullParameter(onKeyboardSubmit, "onKeyboardSubmit");
        Composer startRestartGroup = composer.startRestartGroup(1035308623);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(licensePlateInput) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(nameInput) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(onLicensePlateChange) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(onNameChange) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(z6) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(onFormValidationChange) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(onKeyboardSubmit) ? 8388608 : 4194304;
        }
        int i7 = i6;
        if ((4793491 & i7) == 4793490 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1035308623, i7, -1, "dk.molslinjen.ui.views.screens.profile.vehicles.shared.ProfileVehicleInputContent (ProfileVehicleInputContent.kt:39)");
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.startReplaceGroup(-1207742689);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new FormValidator(MapsKt.mapOf(TuplesKt.to(VehicleInputFormField.LicensePlate, LicensePlateInputValidator.INSTANCE)), coroutineScope);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            FormValidator formValidator = (FormValidator) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            if (z6) {
                formValidator.submitAllFields();
            }
            Boolean bool = (Boolean) SnapshotStateKt.collectAsState(formValidator.isFormValid(), null, startRestartGroup, 0, 1).getValue();
            boolean booleanValue = bool.booleanValue();
            final FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            startRestartGroup.startReplaceGroup(-1207730223);
            boolean changed = ((3670016 & i7) == 1048576) | startRestartGroup.changed(booleanValue);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new ProfileVehicleInputContentKt$ProfileVehicleInputContent$1$1(onFormValidationChange, booleanValue, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(bool, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue3, startRestartGroup, 0);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m313paddingVpY3zN4$default(ModifierExtensionsKt.closeKeyboardOnClickOutside(companion2, focusManager), Dp.m2599constructorimpl(24), 0.0f, 2, null), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, null, false, 14, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, verticalScroll$default);
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
            boolean z7 = !z5;
            startRestartGroup.startReplaceGroup(1800774745);
            boolean z8 = (i7 & 7168) == 2048;
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: d4.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ProfileVehicleInputContent$lambda$10$lambda$3$lambda$2;
                        ProfileVehicleInputContent$lambda$10$lambda$3$lambda$2 = ProfileVehicleInputContentKt.ProfileVehicleInputContent$lambda$10$lambda$3$lambda$2(Function1.this, (String) obj);
                        return ProfileVehicleInputContent$lambda$10$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            Function1 function1 = (Function1) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1800776652);
            boolean changedInstance = startRestartGroup.changedInstance(focusManager);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: d4.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileVehicleInputContent$lambda$10$lambda$5$lambda$4;
                        ProfileVehicleInputContent$lambda$10$lambda$5$lambda$4 = ProfileVehicleInputContentKt.ProfileVehicleInputContent$lambda$10$lambda$5$lambda$4(FocusManager.this);
                        return ProfileVehicleInputContent$lambda$10$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            LicensePlateInputFieldKt.LicensePlateInputField(licensePlateInput, z7, function1, (Function0) rememberedValue5, VehicleInputFormField.LicensePlate, formValidator, startRestartGroup, (i7 & 14) | 24576);
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 13, null);
            boolean z9 = !z5;
            KeyboardOptions keyboardOptions = new KeyboardOptions(KeyboardCapitalization.INSTANCE.m2404getSentencesIUNYP9k(), (Boolean) null, 0, ImeAction.INSTANCE.m2383getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 118, (DefaultConstructorMarker) null);
            List emptyList = CollectionsKt.emptyList();
            Integer valueOf = Integer.valueOf(R.string.profile_vehicle_register_name_label);
            Integer valueOf2 = Integer.valueOf(R.string.profile_vehicle_register_name_placeholder);
            composer2 = startRestartGroup;
            composer2.startReplaceGroup(1800788913);
            boolean z10 = (i7 & 57344) == 16384;
            Object rememberedValue6 = composer2.rememberedValue();
            if (z10 || rememberedValue6 == companion.getEmpty()) {
                rememberedValue6 = new Function1() { // from class: d4.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit ProfileVehicleInputContent$lambda$10$lambda$7$lambda$6;
                        ProfileVehicleInputContent$lambda$10$lambda$7$lambda$6 = ProfileVehicleInputContentKt.ProfileVehicleInputContent$lambda$10$lambda$7$lambda$6(Function1.this, (String) obj);
                        return ProfileVehicleInputContent$lambda$10$lambda$7$lambda$6;
                    }
                };
                composer2.updateRememberedValue(rememberedValue6);
            }
            Function1 function12 = (Function1) rememberedValue6;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(1800798617);
            boolean changedInstance2 = composer2.changedInstance(focusManager) | ((i7 & 29360128) == 8388608);
            Object rememberedValue7 = composer2.rememberedValue();
            if (changedInstance2 || rememberedValue7 == companion.getEmpty()) {
                rememberedValue7 = new Function0() { // from class: d4.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileVehicleInputContent$lambda$10$lambda$9$lambda$8;
                        ProfileVehicleInputContent$lambda$10$lambda$9$lambda$8 = ProfileVehicleInputContentKt.ProfileVehicleInputContent$lambda$10$lambda$9$lambda$8(FocusManager.this, onKeyboardSubmit);
                        return ProfileVehicleInputContent$lambda$10$lambda$9$lambda$8;
                    }
                };
                composer2.updateRememberedValue(rememberedValue7);
            }
            composer2.endReplaceGroup();
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(m315paddingqDBjuR0$default, false, 0.0f, emptyList, valueOf, valueOf2, null, function12, (Function0) rememberedValue7, nameInput, false, null, z9, false, 0, null, null, keyboardOptions, null, null, 0L, null, false, 0, composer2, (1879048192 & (i7 << 24)) | 224262, 12582912, 0, 16641094);
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, companion2, 1.0f, false, 2, null), composer2, 0);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: d4.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfileVehicleInputContent$lambda$11;
                    ProfileVehicleInputContent$lambda$11 = ProfileVehicleInputContentKt.ProfileVehicleInputContent$lambda$11(licensePlateInput, nameInput, z5, onLicensePlateChange, onNameChange, z6, onFormValidationChange, onKeyboardSubmit, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfileVehicleInputContent$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehicleInputContent$lambda$10$lambda$3$lambda$2(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehicleInputContent$lambda$10$lambda$5$lambda$4(FocusManager focusManager) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1283getNextdhqQ8s());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehicleInputContent$lambda$10$lambda$7$lambda$6(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehicleInputContent$lambda$10$lambda$9$lambda$8(FocusManager focusManager, Function0 function0) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehicleInputContent$lambda$11(String str, String str2, boolean z5, Function1 function1, Function1 function12, boolean z6, Function1 function13, Function0 function0, int i5, Composer composer, int i6) {
        ProfileVehicleInputContent(str, str2, z5, function1, function12, z6, function13, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
