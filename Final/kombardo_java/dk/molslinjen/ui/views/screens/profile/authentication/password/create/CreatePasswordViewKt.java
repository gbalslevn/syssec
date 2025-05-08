package dk.molslinjen.ui.views.screens.profile.authentication.password.create;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AutofillType;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.input.StyledTextFieldKt;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.PasswordInputValidator;
import dk.molslinjen.ui.views.screens.profile.authentication.password.create.CreatePasswordViewKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a[\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001b\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "label", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", "validationKey", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", BuildConfig.FLAVOR, "password", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onPasswordChange", BuildConfig.FLAVOR, "enabled", "CreatePasswordView", "(Landroidx/compose/ui/Modifier;ILdk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Ljava/lang/String;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)V", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator$StringValidator;", "labelAndValidators", "()Ljava/util/Map;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CreatePasswordViewKt {
    /* JADX WARN: Removed duplicated region for block: B:30:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CreatePasswordView(Modifier modifier, int i5, final IFormValidator.ValidationKey validationKey, final IFormValidator iFormValidator, final String password, final Function1<? super String, Unit> onPasswordChange, boolean z5, Composer composer, final int i6, final int i7) {
        Modifier modifier2;
        int i8;
        int i9;
        boolean z6;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        boolean changedInstance;
        Object rememberedValue;
        Composer composer2;
        final int i10;
        final boolean z7;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(validationKey, "validationKey");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(onPasswordChange, "onPasswordChange");
        Composer startRestartGroup = composer.startRestartGroup(330466048);
        int i11 = i7 & 1;
        if (i11 != 0) {
            i8 = i6 | 6;
            modifier2 = modifier;
        } else if ((i6 & 6) == 0) {
            modifier2 = modifier;
            i8 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i6;
        } else {
            modifier2 = modifier;
            i8 = i6;
        }
        int i12 = i7 & 2;
        if (i12 != 0) {
            i8 |= 48;
            i9 = i5;
        } else {
            i9 = i5;
            if ((i6 & 48) == 0) {
                i8 |= startRestartGroup.changed(i9) ? 32 : 16;
            }
        }
        if ((i7 & 4) != 0) {
            i8 |= 384;
        } else if ((i6 & 384) == 0) {
            i8 |= (i6 & 512) == 0 ? startRestartGroup.changed(validationKey) : startRestartGroup.changedInstance(validationKey) ? 256 : 128;
        }
        if ((i7 & 8) != 0) {
            i8 |= 3072;
        } else if ((i6 & 3072) == 0) {
            i8 |= (i6 & 4096) == 0 ? startRestartGroup.changed(iFormValidator) : startRestartGroup.changedInstance(iFormValidator) ? 2048 : 1024;
        }
        if ((i7 & 16) != 0) {
            i8 |= 24576;
        } else if ((i6 & 24576) == 0) {
            i8 |= startRestartGroup.changed(password) ? 16384 : 8192;
        }
        if ((i7 & 32) != 0) {
            i8 |= 196608;
        } else if ((i6 & 196608) == 0) {
            i8 |= startRestartGroup.changedInstance(onPasswordChange) ? 131072 : 65536;
        }
        int i13 = i7 & 64;
        if (i13 != 0) {
            i8 |= 1572864;
        } else if ((1572864 & i6) == 0) {
            z6 = z5;
            i8 |= startRestartGroup.changed(z6) ? 1048576 : 524288;
            if ((599187 & i8) == 599186 || !startRestartGroup.getSkipping()) {
                Modifier modifier4 = i11 == 0 ? Modifier.INSTANCE : modifier2;
                int i14 = i12 == 0 ? R.string.textField_label_password : i9;
                boolean z8 = i13 == 0 ? true : z6;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(330466048, i8, -1, "dk.molslinjen.ui.views.screens.profile.authentication.password.create.CreatePasswordView (CreatePasswordView.kt:33)");
                }
                final FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
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
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m2419getPasswordPjHm6EE(), ImeAction.INSTANCE.m2383getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
                List listOf = CollectionsKt.listOf(AutofillType.NewPassword);
                Integer valueOf = Integer.valueOf(i14);
                startRestartGroup.startReplaceGroup(-859885537);
                changedInstance = startRestartGroup.changedInstance(focusManager);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: z3.b
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CreatePasswordView$lambda$2$lambda$1$lambda$0;
                            CreatePasswordView$lambda$2$lambda$1$lambda$0 = CreatePasswordViewKt.CreatePasswordView$lambda$2$lambda$1$lambda$0(FocusManager.this);
                            return CreatePasswordView$lambda$2$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                int i15 = i8 << 9;
                composer2 = startRestartGroup;
                Modifier modifier5 = modifier4;
                StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, listOf, valueOf, null, null, onPasswordChange, (Function0) rememberedValue, password, true, null, z8, false, 0, validationKey, iFormValidator, keyboardOptions, null, null, 0L, null, false, 0, composer2, (57344 & i15) | 3072 | ((i8 << 6) & 29360128) | ((i8 << 15) & 1879048192), ((i8 >> 12) & 896) | 12582918 | (458752 & i15) | (i15 & 3670016), 384, 12347495);
                CreatePasswordValidationViewKt.SignupPasswordValidationView(PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(12), 0.0f, 0.0f, 13, null), password, labelAndValidators(), composer2, ((i8 >> 9) & 112) | 6, 0);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i10 = i14;
                z7 = z8;
                modifier3 = modifier5;
            } else {
                startRestartGroup.skipToGroupEnd();
                z7 = z6;
                i10 = i9;
                modifier3 = modifier2;
                composer2 = startRestartGroup;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: z3.c
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit CreatePasswordView$lambda$3;
                        CreatePasswordView$lambda$3 = CreatePasswordViewKt.CreatePasswordView$lambda$3(Modifier.this, i10, validationKey, iFormValidator, password, onPasswordChange, z7, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                        return CreatePasswordView$lambda$3;
                    }
                });
                return;
            }
            return;
        }
        z6 = z5;
        if ((599187 & i8) == 599186) {
        }
        if (i11 == 0) {
        }
        if (i12 == 0) {
        }
        if (i13 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        final FocusManager focusManager2 = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
        ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2, companion2.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion2.getSetModifier());
        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
        KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m2419getPasswordPjHm6EE(), ImeAction.INSTANCE.m2383getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
        List listOf2 = CollectionsKt.listOf(AutofillType.NewPassword);
        Integer valueOf2 = Integer.valueOf(i14);
        startRestartGroup.startReplaceGroup(-859885537);
        changedInstance = startRestartGroup.changedInstance(focusManager2);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue = new Function0() { // from class: z3.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit CreatePasswordView$lambda$2$lambda$1$lambda$0;
                CreatePasswordView$lambda$2$lambda$1$lambda$0 = CreatePasswordViewKt.CreatePasswordView$lambda$2$lambda$1$lambda$0(FocusManager.this);
                return CreatePasswordView$lambda$2$lambda$1$lambda$0;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        int i152 = i8 << 9;
        composer2 = startRestartGroup;
        Modifier modifier52 = modifier4;
        StyledTextFieldKt.m3412StyledTextFieldqgfaCVY(null, false, 0.0f, listOf2, valueOf2, null, null, onPasswordChange, (Function0) rememberedValue, password, true, null, z8, false, 0, validationKey, iFormValidator, keyboardOptions2, null, null, 0L, null, false, 0, composer2, (57344 & i152) | 3072 | ((i8 << 6) & 29360128) | ((i8 << 15) & 1879048192), ((i8 >> 12) & 896) | 12582918 | (458752 & i152) | (i152 & 3670016), 384, 12347495);
        CreatePasswordValidationViewKt.SignupPasswordValidationView(PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(12), 0.0f, 0.0f, 13, null), password, labelAndValidators(), composer2, ((i8 >> 9) & 112) | 6, 0);
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        i10 = i14;
        z7 = z8;
        modifier3 = modifier52;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreatePasswordView$lambda$2$lambda$1$lambda$0(FocusManager focusManager) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreatePasswordView$lambda$3(Modifier modifier, int i5, IFormValidator.ValidationKey validationKey, IFormValidator iFormValidator, String str, Function1 function1, boolean z5, int i6, int i7, Composer composer, int i8) {
        CreatePasswordView(modifier, i5, validationKey, iFormValidator, str, function1, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }

    private static final Map<Integer, IInputValidator.StringValidator> labelAndValidators() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(R.string.signup_passwordScreen_hint_length), PasswordInputValidator.LengthValidator.INSTANCE), TuplesKt.to(Integer.valueOf(R.string.signup_passwordScreen_hint_lowerCase), PasswordInputValidator.LowercaseValidator.INSTANCE), TuplesKt.to(Integer.valueOf(R.string.signup_passwordScreen_hint_upperCase), PasswordInputValidator.UppercaseValidator.INSTANCE), TuplesKt.to(Integer.valueOf(R.string.signup_passwordScreen_hint_numberOrSymbol), PasswordInputValidator.NumberOrSpecialCharacterValidator.INSTANCE));
    }
}
