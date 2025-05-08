package dk.molslinjen.ui.views.screens.profile.passengers.shared;

import android.annotation.SuppressLint;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AutofillType;
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
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.input.BirthdateInputKt;
import dk.molslinjen.ui.views.reusable.input.StyledTextFieldKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.GenderPickerKt;
import dk.molslinjen.ui.views.reusable.input.nationality.NationalityPickerKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.NonEmptyNameValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.NonNullCustomValidator;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.ProfilePassengerInputContentKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a_\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u000f\u0010\u0011\u001a\u00020\u0010H\u0003¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler;", "inputHandler", BuildConfig.FLAVOR, "isLoading", "submitFieldsTrigger", "Landroidx/compose/foundation/ScrollState;", "scrollState", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onFormValidationChange", "Lkotlin/Function0;", "navigateToNationalitySelection", "ProfilePassengerInputContent", "(Landroidx/compose/ui/Modifier;Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler;ZZLandroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "rememberPassengerFormValidator", "(Landroidx/compose/runtime/Composer;I)Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProfilePassengerInputContentKt {
    /* JADX WARN: Removed duplicated region for block: B:138:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0251  */
    @SuppressLint({"ModifierParameter"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ProfilePassengerInputContent(Modifier modifier, final IPassengerInputHandler inputHandler, final boolean z5, final boolean z6, ScrollState scrollState, final Function1<? super Boolean, Unit> onFormValidationChange, final Function0<Unit> navigateToNationalitySelection, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        ScrollState scrollState2;
        final ScrollState rememberScrollState;
        boolean changed;
        Object rememberedValue;
        CoroutineContext coroutineContext;
        boolean z7;
        Object rememberedValue2;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        boolean z8;
        Object rememberedValue3;
        boolean changedInstance;
        Object rememberedValue4;
        boolean z9;
        Object rememberedValue5;
        boolean changedInstance2;
        Object rememberedValue6;
        boolean z10;
        Object rememberedValue7;
        boolean z11;
        Object rememberedValue8;
        Composer composer2;
        final Modifier modifier3;
        int i8;
        Intrinsics.checkNotNullParameter(inputHandler, "inputHandler");
        Intrinsics.checkNotNullParameter(onFormValidationChange, "onFormValidationChange");
        Intrinsics.checkNotNullParameter(navigateToNationalitySelection, "navigateToNationalitySelection");
        Composer startRestartGroup = composer.startRestartGroup(27830861);
        int i9 = i6 & 1;
        if (i9 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else {
            modifier2 = modifier;
            if ((i5 & 6) == 0) {
                i7 = i5 | (startRestartGroup.changed(modifier2) ? 4 : 2);
            } else {
                i7 = i5;
            }
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= (i5 & 64) == 0 ? startRestartGroup.changed(inputHandler) : startRestartGroup.changedInstance(inputHandler) ? 32 : 16;
        }
        int i10 = i7;
        if ((i6 & 4) != 0) {
            i10 |= 384;
        } else if ((i5 & 384) == 0) {
            i10 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i10 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i10 |= startRestartGroup.changed(z6) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            if ((i6 & 16) == 0) {
                scrollState2 = scrollState;
                if (startRestartGroup.changed(scrollState2)) {
                    i8 = 16384;
                    i10 |= i8;
                }
            } else {
                scrollState2 = scrollState;
            }
            i8 = 8192;
            i10 |= i8;
        } else {
            scrollState2 = scrollState;
        }
        if ((i6 & 32) != 0) {
            i10 |= 196608;
        } else if ((i5 & 196608) == 0) {
            i10 |= startRestartGroup.changedInstance(onFormValidationChange) ? 131072 : 65536;
        }
        if ((i6 & 64) != 0) {
            i10 |= 1572864;
        } else if ((i5 & 1572864) == 0) {
            i10 |= startRestartGroup.changedInstance(navigateToNationalitySelection) ? 1048576 : 524288;
        }
        if ((i10 & 599187) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
            modifier3 = modifier2;
        } else {
            startRestartGroup.startDefaults();
            if ((i5 & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if (i9 != 0) {
                    modifier2 = PaddingKt.m313paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m2599constructorimpl(24), 0.0f, 2, null);
                }
                if ((i6 & 16) != 0) {
                    rememberScrollState = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                    i10 &= -57345;
                    Modifier modifier4 = modifier2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(27830861, i10, -1, "dk.molslinjen.ui.views.screens.profile.passengers.shared.ProfilePassengerInputContent (ProfilePassengerInputContent.kt:50)");
                    }
                    IFormValidator rememberPassengerFormValidator = rememberPassengerFormValidator(startRestartGroup, 0);
                    if (z6) {
                        rememberPassengerFormValidator.submitAllFields();
                    }
                    Boolean bool = (Boolean) SnapshotStateKt.collectAsState(rememberPassengerFormValidator.isFormValid(), null, startRestartGroup, 0, 1).getValue();
                    boolean booleanValue = bool.booleanValue();
                    startRestartGroup.startReplaceGroup(47010033);
                    changed = ((458752 & i10) != 131072) | startRestartGroup.changed(booleanValue);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        coroutineContext = null;
                        rememberedValue = new ProfilePassengerInputContentKt$ProfilePassengerInputContent$1$1(onFormValidationChange, booleanValue, null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    } else {
                        coroutineContext = null;
                    }
                    startRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(bool, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, 0);
                    boolean z12 = !z5;
                    IPassengerInputHandler.InputState inputState = (IPassengerInputHandler.InputState) SnapshotStateKt.collectAsState(inputHandler.getPassengerInput(), coroutineContext, startRestartGroup, 0, 1).getValue();
                    final FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                    Modifier closeKeyboardOnClickOutside = ModifierExtensionsKt.closeKeyboardOnClickOutside(modifier4, (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager()));
                    boolean z13 = rememberScrollState != null;
                    startRestartGroup.startReplaceGroup(47021594);
                    z7 = (((57344 & i10) ^ 24576) <= 16384 && startRestartGroup.changed(rememberScrollState)) || (i10 & 24576) == 16384;
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!z7 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new Function1() { // from class: T3.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Modifier ProfilePassengerInputContent$lambda$3$lambda$2;
                                ProfilePassengerInputContent$lambda$3$lambda$2 = ProfilePassengerInputContentKt.ProfilePassengerInputContent$lambda$3$lambda$2(ScrollState.this, (Modifier) obj);
                                return ProfilePassengerInputContent$lambda$3$lambda$2;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier applyIf = ModifierExtensionsKt.applyIf(closeKeyboardOnClickOutside, z13, (Function1) rememberedValue2);
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(16)), Alignment.INSTANCE.getStart(), startRestartGroup, 6);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, applyIf);
                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion.getConstructor();
                    if (startRestartGroup.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.getInserting()) {
                        startRestartGroup.useNode();
                    } else {
                        startRestartGroup.createNode(constructor);
                    }
                    m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                    ScrollState scrollState3 = rememberScrollState;
                    Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                    if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    PassengerInputFormField passengerInputFormField = PassengerInputFormField.FirstName;
                    String firstName = inputState.getFirstName();
                    KeyboardCapitalization.Companion companion2 = KeyboardCapitalization.INSTANCE;
                    int m2406getWordsIUNYP9k = companion2.m2406getWordsIUNYP9k();
                    ImeAction.Companion companion3 = ImeAction.INSTANCE;
                    KeyboardOptions keyboardOptions = new KeyboardOptions(m2406getWordsIUNYP9k, (Boolean) null, 0, companion3.m2385getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 118, (DefaultConstructorMarker) null);
                    startRestartGroup.startReplaceGroup(-570491174);
                    int i11 = i10 & 112;
                    z8 = i11 != 32 || ((i10 & 64) != 0 && startRestartGroup.changedInstance(inputHandler));
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (!z8 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = new ProfilePassengerInputContentKt$ProfilePassengerInputContent$3$1$1(inputHandler);
                        startRestartGroup.updateRememberedValue(rememberedValue3);
                    }
                    startRestartGroup.endReplaceGroup();
                    List listOf = CollectionsKt.listOf(AutofillType.PersonFirstName);
                    Integer valueOf = Integer.valueOf(R.string.textField_label_firstName);
                    Function1 function1 = (Function1) ((KFunction) rememberedValue3);
                    startRestartGroup.startReplaceGroup(-570488084);
                    changedInstance = startRestartGroup.changedInstance(focusManager);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (!changedInstance || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = new Function0() { // from class: T3.c
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit ProfilePassengerInputContent$lambda$12$lambda$6$lambda$5;
                                ProfilePassengerInputContent$lambda$12$lambda$6$lambda$5 = ProfilePassengerInputContentKt.ProfilePassengerInputContent$lambda$12$lambda$6$lambda$5(FocusManager.this);
                                return ProfilePassengerInputContent$lambda$12$lambda$6$lambda$5;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                    }
                    startRestartGroup.endReplaceGroup();
                    StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, listOf, valueOf, null, null, function1, (Function0) rememberedValue4, firstName, false, null, z12, false, 0, passengerInputFormField, rememberPassengerFormValidator, keyboardOptions, null, null, 0L, null, false, 0, startRestartGroup, 27648, 12779520, 0, 16542823);
                    PassengerInputFormField passengerInputFormField2 = PassengerInputFormField.LastName;
                    String lastName = inputState.getLastName();
                    KeyboardOptions keyboardOptions2 = new KeyboardOptions(companion2.m2406getWordsIUNYP9k(), (Boolean) null, 0, companion3.m2385getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 118, (DefaultConstructorMarker) null);
                    startRestartGroup.startReplaceGroup(-570470887);
                    z9 = i11 != 32 || ((i10 & 64) != 0 && startRestartGroup.changedInstance(inputHandler));
                    rememberedValue5 = startRestartGroup.rememberedValue();
                    if (!z9 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue5 = new ProfilePassengerInputContentKt$ProfilePassengerInputContent$3$3$1(inputHandler);
                        startRestartGroup.updateRememberedValue(rememberedValue5);
                    }
                    startRestartGroup.endReplaceGroup();
                    List listOf2 = CollectionsKt.listOf(AutofillType.PersonLastName);
                    Integer valueOf2 = Integer.valueOf(R.string.textField_label_lastName);
                    Function1 function12 = (Function1) ((KFunction) rememberedValue5);
                    startRestartGroup.startReplaceGroup(-570467846);
                    changedInstance2 = startRestartGroup.changedInstance(focusManager);
                    rememberedValue6 = startRestartGroup.rememberedValue();
                    if (!changedInstance2 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue6 = new Function0() { // from class: T3.d
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit ProfilePassengerInputContent$lambda$12$lambda$9$lambda$8;
                                ProfilePassengerInputContent$lambda$12$lambda$9$lambda$8 = ProfilePassengerInputContentKt.ProfilePassengerInputContent$lambda$12$lambda$9$lambda$8(FocusManager.this);
                                return ProfilePassengerInputContent$lambda$12$lambda$9$lambda$8;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue6);
                    }
                    startRestartGroup.endReplaceGroup();
                    StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, listOf2, valueOf2, null, null, function12, (Function0) rememberedValue6, lastName, false, null, z12, false, 0, passengerInputFormField2, rememberPassengerFormValidator, keyboardOptions2, null, null, 0L, null, false, 0, startRestartGroup, 27648, 12779520, 0, 16542823);
                    Gender gender = inputState.getGender();
                    startRestartGroup.startReplaceGroup(-570461289);
                    z10 = i11 != 32 || ((i10 & 64) != 0 && startRestartGroup.changedInstance(inputHandler));
                    rememberedValue7 = startRestartGroup.rememberedValue();
                    if (!z10 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue7 = new ProfilePassengerInputContentKt$ProfilePassengerInputContent$3$5$1(inputHandler);
                        startRestartGroup.updateRememberedValue(rememberedValue7);
                    }
                    startRestartGroup.endReplaceGroup();
                    GenderPickerKt.GenderPicker(null, gender, (Function1) ((KFunction) rememberedValue7), z12, PassengerInputFormField.Gender, rememberPassengerFormValidator, startRestartGroup, 24576, 1);
                    LocalDate birthdate = inputState.getBirthdate();
                    startRestartGroup.startReplaceGroup(-570452454);
                    z11 = i11 != 32 || ((i10 & 64) != 0 && startRestartGroup.changedInstance(inputHandler));
                    rememberedValue8 = startRestartGroup.rememberedValue();
                    if (!z11 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue8 = new ProfilePassengerInputContentKt$ProfilePassengerInputContent$3$6$1(inputHandler);
                        startRestartGroup.updateRememberedValue(rememberedValue8);
                    }
                    startRestartGroup.endReplaceGroup();
                    BirthdateInputKt.BirthdateInput(null, birthdate, LocalDate.now().minusYears(18L), null, null, (Function1) ((KFunction) rememberedValue8), z12, false, PassengerInputFormField.BirthDate, rememberPassengerFormValidator, startRestartGroup, 100663296, 153);
                    composer2 = startRestartGroup;
                    NationalityPickerKt.NationalityPicker(null, inputState.getNationality(), navigateToNationalitySelection, null, z12, startRestartGroup, (i10 >> 12) & 896, 9);
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(8)), composer2, 6);
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    scrollState2 = scrollState3;
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i6 & 16) != 0) {
                    i10 &= -57345;
                }
            }
            rememberScrollState = scrollState2;
            Modifier modifier42 = modifier2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            IFormValidator rememberPassengerFormValidator2 = rememberPassengerFormValidator(startRestartGroup, 0);
            if (z6) {
            }
            Boolean bool2 = (Boolean) SnapshotStateKt.collectAsState(rememberPassengerFormValidator2.isFormValid(), null, startRestartGroup, 0, 1).getValue();
            boolean booleanValue2 = bool2.booleanValue();
            startRestartGroup.startReplaceGroup(47010033);
            changed = ((458752 & i10) != 131072) | startRestartGroup.changed(booleanValue2);
            rememberedValue = startRestartGroup.rememberedValue();
            if (changed) {
            }
            coroutineContext = null;
            rememberedValue = new ProfilePassengerInputContentKt$ProfilePassengerInputContent$1$1(onFormValidationChange, booleanValue2, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(bool2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, 0);
            boolean z122 = !z5;
            IPassengerInputHandler.InputState inputState2 = (IPassengerInputHandler.InputState) SnapshotStateKt.collectAsState(inputHandler.getPassengerInput(), coroutineContext, startRestartGroup, 0, 1).getValue();
            final FocusManager focusManager2 = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            Modifier closeKeyboardOnClickOutside2 = ModifierExtensionsKt.closeKeyboardOnClickOutside(modifier42, (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager()));
            if (rememberScrollState != null) {
            }
            startRestartGroup.startReplaceGroup(47021594);
            if (((57344 & i10) ^ 24576) <= 16384) {
            }
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z7) {
            }
            rememberedValue2 = new Function1() { // from class: T3.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Modifier ProfilePassengerInputContent$lambda$3$lambda$2;
                    ProfilePassengerInputContent$lambda$3$lambda$2 = ProfilePassengerInputContentKt.ProfilePassengerInputContent$lambda$3$lambda$2(ScrollState.this, (Modifier) obj);
                    return ProfilePassengerInputContent$lambda$3$lambda$2;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceGroup();
            Modifier applyIf2 = ModifierExtensionsKt.applyIf(closeKeyboardOnClickOutside2, z13, (Function1) rememberedValue2);
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(16)), Alignment.INSTANCE.getStart(), startRestartGroup, 6);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, applyIf2);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            ScrollState scrollState32 = rememberScrollState;
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion4.getSetModifier());
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            PassengerInputFormField passengerInputFormField3 = PassengerInputFormField.FirstName;
            String firstName2 = inputState2.getFirstName();
            KeyboardCapitalization.Companion companion22 = KeyboardCapitalization.INSTANCE;
            int m2406getWordsIUNYP9k2 = companion22.m2406getWordsIUNYP9k();
            ImeAction.Companion companion32 = ImeAction.INSTANCE;
            KeyboardOptions keyboardOptions3 = new KeyboardOptions(m2406getWordsIUNYP9k2, (Boolean) null, 0, companion32.m2385getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 118, (DefaultConstructorMarker) null);
            startRestartGroup.startReplaceGroup(-570491174);
            int i112 = i10 & 112;
            if (i112 != 32) {
            }
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!z8) {
            }
            rememberedValue3 = new ProfilePassengerInputContentKt$ProfilePassengerInputContent$3$1$1(inputHandler);
            startRestartGroup.updateRememberedValue(rememberedValue3);
            startRestartGroup.endReplaceGroup();
            List listOf3 = CollectionsKt.listOf(AutofillType.PersonFirstName);
            Integer valueOf3 = Integer.valueOf(R.string.textField_label_firstName);
            Function1 function13 = (Function1) ((KFunction) rememberedValue3);
            startRestartGroup.startReplaceGroup(-570488084);
            changedInstance = startRestartGroup.changedInstance(focusManager2);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (!changedInstance) {
            }
            rememberedValue4 = new Function0() { // from class: T3.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit ProfilePassengerInputContent$lambda$12$lambda$6$lambda$5;
                    ProfilePassengerInputContent$lambda$12$lambda$6$lambda$5 = ProfilePassengerInputContentKt.ProfilePassengerInputContent$lambda$12$lambda$6$lambda$5(FocusManager.this);
                    return ProfilePassengerInputContent$lambda$12$lambda$6$lambda$5;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue4);
            startRestartGroup.endReplaceGroup();
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, listOf3, valueOf3, null, null, function13, (Function0) rememberedValue4, firstName2, false, null, z122, false, 0, passengerInputFormField3, rememberPassengerFormValidator2, keyboardOptions3, null, null, 0L, null, false, 0, startRestartGroup, 27648, 12779520, 0, 16542823);
            PassengerInputFormField passengerInputFormField22 = PassengerInputFormField.LastName;
            String lastName2 = inputState2.getLastName();
            KeyboardOptions keyboardOptions22 = new KeyboardOptions(companion22.m2406getWordsIUNYP9k(), (Boolean) null, 0, companion32.m2385getNexteUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 118, (DefaultConstructorMarker) null);
            startRestartGroup.startReplaceGroup(-570470887);
            if (i112 != 32) {
            }
            rememberedValue5 = startRestartGroup.rememberedValue();
            if (!z9) {
            }
            rememberedValue5 = new ProfilePassengerInputContentKt$ProfilePassengerInputContent$3$3$1(inputHandler);
            startRestartGroup.updateRememberedValue(rememberedValue5);
            startRestartGroup.endReplaceGroup();
            List listOf22 = CollectionsKt.listOf(AutofillType.PersonLastName);
            Integer valueOf22 = Integer.valueOf(R.string.textField_label_lastName);
            Function1 function122 = (Function1) ((KFunction) rememberedValue5);
            startRestartGroup.startReplaceGroup(-570467846);
            changedInstance2 = startRestartGroup.changedInstance(focusManager2);
            rememberedValue6 = startRestartGroup.rememberedValue();
            if (!changedInstance2) {
            }
            rememberedValue6 = new Function0() { // from class: T3.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit ProfilePassengerInputContent$lambda$12$lambda$9$lambda$8;
                    ProfilePassengerInputContent$lambda$12$lambda$9$lambda$8 = ProfilePassengerInputContentKt.ProfilePassengerInputContent$lambda$12$lambda$9$lambda$8(FocusManager.this);
                    return ProfilePassengerInputContent$lambda$12$lambda$9$lambda$8;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue6);
            startRestartGroup.endReplaceGroup();
            StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, listOf22, valueOf22, null, null, function122, (Function0) rememberedValue6, lastName2, false, null, z122, false, 0, passengerInputFormField22, rememberPassengerFormValidator2, keyboardOptions22, null, null, 0L, null, false, 0, startRestartGroup, 27648, 12779520, 0, 16542823);
            Gender gender2 = inputState2.getGender();
            startRestartGroup.startReplaceGroup(-570461289);
            if (i112 != 32) {
            }
            rememberedValue7 = startRestartGroup.rememberedValue();
            if (!z10) {
            }
            rememberedValue7 = new ProfilePassengerInputContentKt$ProfilePassengerInputContent$3$5$1(inputHandler);
            startRestartGroup.updateRememberedValue(rememberedValue7);
            startRestartGroup.endReplaceGroup();
            GenderPickerKt.GenderPicker(null, gender2, (Function1) ((KFunction) rememberedValue7), z122, PassengerInputFormField.Gender, rememberPassengerFormValidator2, startRestartGroup, 24576, 1);
            LocalDate birthdate2 = inputState2.getBirthdate();
            startRestartGroup.startReplaceGroup(-570452454);
            if (i112 != 32) {
            }
            rememberedValue8 = startRestartGroup.rememberedValue();
            if (!z11) {
            }
            rememberedValue8 = new ProfilePassengerInputContentKt$ProfilePassengerInputContent$3$6$1(inputHandler);
            startRestartGroup.updateRememberedValue(rememberedValue8);
            startRestartGroup.endReplaceGroup();
            BirthdateInputKt.BirthdateInput(null, birthdate2, LocalDate.now().minusYears(18L), null, null, (Function1) ((KFunction) rememberedValue8), z122, false, PassengerInputFormField.BirthDate, rememberPassengerFormValidator2, startRestartGroup, 100663296, 153);
            composer2 = startRestartGroup;
            NationalityPickerKt.NationalityPicker(null, inputState2.getNationality(), navigateToNationalitySelection, null, z122, startRestartGroup, (i10 >> 12) & 896, 9);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(8)), composer2, 6);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier42;
            scrollState2 = scrollState32;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final ScrollState scrollState4 = scrollState2;
            endRestartGroup.updateScope(new Function2() { // from class: T3.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfilePassengerInputContent$lambda$13;
                    ProfilePassengerInputContent$lambda$13 = ProfilePassengerInputContentKt.ProfilePassengerInputContent$lambda$13(Modifier.this, inputHandler, z5, z6, scrollState4, onFormValidationChange, navigateToNationalitySelection, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfilePassengerInputContent$lambda$13;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfilePassengerInputContent$lambda$12$lambda$6$lambda$5(FocusManager focusManager) {
        focusManager.mo1288moveFocus3ESFkO8(FocusDirection.INSTANCE.m1283getNextdhqQ8s());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfilePassengerInputContent$lambda$12$lambda$9$lambda$8(FocusManager focusManager) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfilePassengerInputContent$lambda$13(Modifier modifier, IPassengerInputHandler iPassengerInputHandler, boolean z5, boolean z6, ScrollState scrollState, Function1 function1, Function0 function0, int i5, int i6, Composer composer, int i7) {
        ProfilePassengerInputContent(modifier, iPassengerInputHandler, z5, z6, scrollState, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier ProfilePassengerInputContent$lambda$3$lambda$2(ScrollState scrollState, Modifier applyIf) {
        Modifier verticalScroll$default;
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return (scrollState == null || (verticalScroll$default = ScrollKt.verticalScroll$default(applyIf, scrollState, false, null, false, 14, null)) == null) ? applyIf : verticalScroll$default;
    }

    private static final IFormValidator rememberPassengerFormValidator(Composer composer, int i5) {
        composer.startReplaceGroup(-614168374);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-614168374, i5, -1, "dk.molslinjen.ui.views.screens.profile.passengers.shared.rememberPassengerFormValidator (ProfilePassengerInputContent.kt:133)");
        }
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        composer.startReplaceGroup(308146952);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            PassengerInputFormField passengerInputFormField = PassengerInputFormField.FirstName;
            NonEmptyNameValidator nonEmptyNameValidator = NonEmptyNameValidator.INSTANCE;
            rememberedValue2 = new FormValidator(MapsKt.mapOf(TuplesKt.to(passengerInputFormField, nonEmptyNameValidator), TuplesKt.to(PassengerInputFormField.LastName, nonEmptyNameValidator), TuplesKt.to(PassengerInputFormField.Gender, NonNullCustomValidator.Gender.INSTANCE), TuplesKt.to(PassengerInputFormField.BirthDate, NonNullCustomValidator.Birthdate.INSTANCE)), coroutineScope);
            composer.updateRememberedValue(rememberedValue2);
        }
        FormValidator formValidator = (FormValidator) rememberedValue2;
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return formValidator;
    }
}
