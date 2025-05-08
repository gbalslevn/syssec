package dk.molslinjen.ui.views.shared;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.clickableText.ClickableTextData;
import dk.molslinjen.ui.views.reusable.clickableText.ClickableTextKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlStyle;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.RequiredBooleanCustomValidator;
import dk.molslinjen.ui.views.shared.TermsAndLicenseCheckboxKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ac\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "isChecked", BuildConfig.FLAVOR, "privacyPolicyUrl", "termsAndConditionsUrl", "enabled", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onTermsAndLicenseAcceptChange", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", "validationKey", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", "TermsAndLicenseCheckbox", "(Landroidx/compose/ui/Modifier;ZLjava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TermsAndLicenseCheckboxKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x03b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TermsAndLicenseCheckbox(Modifier modifier, final boolean z5, final String str, final String str2, boolean z6, final Function1<? super Boolean, Unit> onTermsAndLicenseAcceptChange, final IFormValidator.ValidationKey validationKey, final IFormValidator validator, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        int i8;
        boolean changedInstance;
        Object rememberedValue;
        boolean changedInstance2;
        Object rememberedValue2;
        boolean changedInstance3;
        Object rememberedValue3;
        Composer composer2;
        boolean changed;
        Object rememberedValue4;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Object rememberedValue5;
        Composer.Companion companion;
        boolean changedInstance4;
        Object rememberedValue6;
        boolean changedInstance5;
        Object rememberedValue7;
        final Modifier modifier3;
        final boolean z7;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(onTermsAndLicenseAcceptChange, "onTermsAndLicenseAcceptChange");
        Intrinsics.checkNotNullParameter(validationKey, "validationKey");
        Intrinsics.checkNotNullParameter(validator, "validator");
        Composer startRestartGroup = composer.startRestartGroup(-690868180);
        int i9 = i6 & 1;
        if (i9 != 0) {
            modifier2 = modifier;
            i7 = i5 | 6;
        } else {
            modifier2 = modifier;
            if ((i5 & 6) == 0) {
                i7 = i5 | (startRestartGroup.changed(modifier2) ? 4 : 2);
            } else {
                i7 = i5;
            }
        }
        if ((2 & i6) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        int i10 = i7;
        if ((4 & i6) != 0) {
            i10 |= 384;
        } else if ((i5 & 384) == 0) {
            i10 |= startRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i10 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i10 |= startRestartGroup.changed(str2) ? 2048 : 1024;
        }
        int i11 = i6 & 16;
        if (i11 != 0) {
            i10 |= 24576;
        } else if ((i5 & 24576) == 0) {
            i10 |= startRestartGroup.changed(z6) ? 16384 : 8192;
            if ((i6 & 32) == 0) {
                i10 |= 196608;
            } else if ((i5 & 196608) == 0) {
                i10 |= startRestartGroup.changedInstance(onTermsAndLicenseAcceptChange) ? 131072 : 65536;
            }
            if ((i6 & 64) == 0) {
                i10 |= 1572864;
            } else if ((i5 & 1572864) == 0) {
                i10 |= (i5 & 2097152) == 0 ? startRestartGroup.changed(validationKey) : startRestartGroup.changedInstance(validationKey) ? 1048576 : 524288;
            }
            if ((128 & i6) == 0) {
                i10 |= 12582912;
            } else if ((i5 & 12582912) == 0) {
                i10 |= (16777216 & i5) == 0 ? startRestartGroup.changed(validator) : startRestartGroup.changedInstance(validator) ? 8388608 : 4194304;
            }
            i8 = i10;
            if ((4793491 & i8) == 4793490 || !startRestartGroup.getSkipping()) {
                Modifier modifier4 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                boolean z8 = i11 == 0 ? true : z6;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-690868180, i8, -1, "dk.molslinjen.ui.views.shared.TermsAndLicenseCheckbox (TermsAndLicenseCheckbox.kt:43)");
                }
                validator.set(validationKey, RequiredBooleanCustomValidator.INSTANCE.validate(Boolean.valueOf(z5)));
                final FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                boolean z9 = ((Map) SnapshotStateKt.collectAsState(validator.getSubmittedErrors(), null, startRestartGroup, 0, 1).getValue()).get(validationKey) == null;
                String stringResource = StringResources_androidKt.stringResource(R.string.termsAndAgreement_personalDataPolicy, startRestartGroup, 6);
                String stringResource2 = StringResources_androidKt.stringResource(R.string.termsAndAgreement_termsAndConditions, startRestartGroup, 6);
                final UriHandler uriHandler = (UriHandler) startRestartGroup.consume(CompositionLocalsKt.getLocalUriHandler());
                startRestartGroup.startReplaceGroup(-230603331);
                changedInstance = ((i8 & 896) != 256) | startRestartGroup.changedInstance(uriHandler);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: v4.a
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit TermsAndLicenseCheckbox$lambda$2$lambda$1;
                            TermsAndLicenseCheckbox$lambda$2$lambda$1 = TermsAndLicenseCheckboxKt.TermsAndLicenseCheckbox$lambda$2$lambda$1(str, uriHandler);
                            return TermsAndLicenseCheckbox$lambda$2$lambda$1;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                ClickableTextData clickableTextData = new ClickableTextData(stringResource, (Function0) rememberedValue, null, null, null, 28, null);
                startRestartGroup.startReplaceGroup(-230598398);
                changedInstance2 = ((i8 & 7168) != 2048) | startRestartGroup.changedInstance(uriHandler);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: v4.b
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit TermsAndLicenseCheckbox$lambda$5$lambda$4;
                            TermsAndLicenseCheckbox$lambda$5$lambda$4 = TermsAndLicenseCheckboxKt.TermsAndLicenseCheckbox$lambda$5$lambda$4(str2, uriHandler);
                            return TermsAndLicenseCheckbox$lambda$5$lambda$4;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                final List listOf = CollectionsKt.listOf((Object[]) new ClickableTextData[]{clickableTextData, new ClickableTextData(stringResource2, (Function0) rememberedValue2, null, null, null, 28, null)});
                Modifier clip = ClipKt.clip(modifier4, ThemeShapesKt.getThemeShapes().getMedium());
                AppColor appColor = AppColor.INSTANCE;
                Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(clip, appColor.m3268getGrey50d7_KjU(), null, 2, null);
                startRestartGroup.startReplaceGroup(-230590884);
                int i12 = 458752 & i8;
                Modifier modifier5 = modifier4;
                int i13 = i8 & 112;
                changedInstance3 = startRestartGroup.changedInstance(focusManager) | (i12 != 131072) | (i13 != 32);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: v4.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit TermsAndLicenseCheckbox$lambda$7$lambda$6;
                            TermsAndLicenseCheckbox$lambda$7$lambda$6 = TermsAndLicenseCheckboxKt.TermsAndLicenseCheckbox$lambda$7$lambda$6(FocusManager.this, onTermsAndLicenseAcceptChange, z5, ((Boolean) obj).booleanValue());
                            return TermsAndLicenseCheckbox$lambda$7$lambda$6;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                Modifier m455toggleableXHw0xAI$default = ToggleableKt.m455toggleableXHw0xAI$default(m104backgroundbw27NRU$default, z5, false, null, (Function1) rememberedValue3, 6, null);
                float f5 = 16;
                Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(m455toggleableXHw0xAI$default, Dp.m2599constructorimpl(f5));
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(-230585311);
                changed = composer2.changed(listOf);
                rememberedValue4 = composer2.rememberedValue();
                if (!changed || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: v4.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit TermsAndLicenseCheckbox$lambda$11$lambda$10;
                            TermsAndLicenseCheckbox$lambda$11$lambda$10 = TermsAndLicenseCheckboxKt.TermsAndLicenseCheckbox$lambda$11$lambda$10(listOf, (SemanticsPropertyReceiver) obj);
                            return TermsAndLicenseCheckbox$lambda$11$lambda$10;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue4);
                }
                composer2.endReplaceGroup();
                Modifier semantics$default = SemanticsModifierKt.semantics$default(m311padding3ABfNKs, false, (Function1) rememberedValue4, 1, null);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composer2, 48);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, semantics$default);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.useNode();
                } else {
                    composer2.createNode(constructor);
                }
                m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                Modifier.Companion companion3 = Modifier.INSTANCE;
                composer2.startReplaceGroup(1522943619);
                rememberedValue5 = composer2.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue5 == companion.getEmpty()) {
                    rememberedValue5 = new Function1() { // from class: v4.e
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit TermsAndLicenseCheckbox$lambda$18$lambda$13$lambda$12;
                            TermsAndLicenseCheckbox$lambda$18$lambda$13$lambda$12 = TermsAndLicenseCheckboxKt.TermsAndLicenseCheckbox$lambda$18$lambda$13$lambda$12((SemanticsPropertyReceiver) obj);
                            return TermsAndLicenseCheckbox$lambda$18$lambda$13$lambda$12;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue5);
                }
                composer2.endReplaceGroup();
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(SemanticsModifierKt.clearAndSetSemantics(companion3, (Function1) rememberedValue5), 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 11, null);
                SelectionControlStyle selectionControlStyle = SelectionControlStyle.Checkbox;
                composer2.startReplaceGroup(1522947859);
                changedInstance4 = composer2.changedInstance(focusManager) | (i12 != 131072);
                rememberedValue6 = composer2.rememberedValue();
                if (!changedInstance4 || rememberedValue6 == companion.getEmpty()) {
                    rememberedValue6 = new Function1() { // from class: v4.f
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit TermsAndLicenseCheckbox$lambda$18$lambda$15$lambda$14;
                            TermsAndLicenseCheckbox$lambda$18$lambda$15$lambda$14 = TermsAndLicenseCheckboxKt.TermsAndLicenseCheckbox$lambda$18$lambda$15$lambda$14(FocusManager.this, onTermsAndLicenseAcceptChange, ((Boolean) obj).booleanValue());
                            return TermsAndLicenseCheckbox$lambda$18$lambda$15$lambda$14;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue6);
                }
                composer2.endReplaceGroup();
                SelectionControlKt.SelectionControl(m315paddingqDBjuR0$default, z5, (Function1) rememberedValue6, null, z8, null, selectionControlStyle, z9, composer2, i13 | 1572864 | (i8 & 57344), 40);
                String stringResource3 = StringResources_androidKt.stringResource(R.string.termsAndAgreement_base, new Object[]{stringResource, stringResource2}, composer2, 6);
                TextStyle paragraphSmall = TypographyKt.getParagraphSmall();
                long m3272getSignalRed0d7_KjU = !z9 ? appColor.m3272getSignalRed0d7_KjU() : appColor.m3253getBrandBlack10d7_KjU();
                composer2.startReplaceGroup(1522967611);
                changedInstance5 = composer2.changedInstance(focusManager) | (i12 != 131072) | (i13 == 32);
                rememberedValue7 = composer2.rememberedValue();
                if (!changedInstance5 || rememberedValue7 == companion.getEmpty()) {
                    rememberedValue7 = new Function0() { // from class: v4.g
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit TermsAndLicenseCheckbox$lambda$18$lambda$17$lambda$16;
                            TermsAndLicenseCheckbox$lambda$18$lambda$17$lambda$16 = TermsAndLicenseCheckboxKt.TermsAndLicenseCheckbox$lambda$18$lambda$17$lambda$16(FocusManager.this, onTermsAndLicenseAcceptChange, z5);
                            return TermsAndLicenseCheckbox$lambda$18$lambda$17$lambda$16;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue7);
                }
                composer2.endReplaceGroup();
                ClickableTextKt.m3408ClickableTextFHprtrg(null, stringResource3, listOf, paragraphSmall, m3272getSignalRed0d7_KjU, (Function0) rememberedValue7, composer2, 3072, 1);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
                z7 = z8;
            } else {
                startRestartGroup.skipToGroupEnd();
                z7 = z6;
                composer2 = startRestartGroup;
                modifier3 = modifier2;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: v4.h
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit TermsAndLicenseCheckbox$lambda$19;
                        TermsAndLicenseCheckbox$lambda$19 = TermsAndLicenseCheckboxKt.TermsAndLicenseCheckbox$lambda$19(Modifier.this, z5, str, str2, z7, onTermsAndLicenseAcceptChange, validationKey, validator, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return TermsAndLicenseCheckbox$lambda$19;
                    }
                });
                return;
            }
            return;
        }
        if ((i6 & 32) == 0) {
        }
        if ((i6 & 64) == 0) {
        }
        if ((128 & i6) == 0) {
        }
        i8 = i10;
        if ((4793491 & i8) == 4793490) {
        }
        if (i9 == 0) {
        }
        if (i11 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        validator.set(validationKey, RequiredBooleanCustomValidator.INSTANCE.validate(Boolean.valueOf(z5)));
        final FocusManager focusManager2 = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
        if (((Map) SnapshotStateKt.collectAsState(validator.getSubmittedErrors(), null, startRestartGroup, 0, 1).getValue()).get(validationKey) == null) {
        }
        String stringResource4 = StringResources_androidKt.stringResource(R.string.termsAndAgreement_personalDataPolicy, startRestartGroup, 6);
        String stringResource22 = StringResources_androidKt.stringResource(R.string.termsAndAgreement_termsAndConditions, startRestartGroup, 6);
        final UriHandler uriHandler2 = (UriHandler) startRestartGroup.consume(CompositionLocalsKt.getLocalUriHandler());
        startRestartGroup.startReplaceGroup(-230603331);
        changedInstance = ((i8 & 896) != 256) | startRestartGroup.changedInstance(uriHandler2);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue = new Function0() { // from class: v4.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit TermsAndLicenseCheckbox$lambda$2$lambda$1;
                TermsAndLicenseCheckbox$lambda$2$lambda$1 = TermsAndLicenseCheckboxKt.TermsAndLicenseCheckbox$lambda$2$lambda$1(str, uriHandler2);
                return TermsAndLicenseCheckbox$lambda$2$lambda$1;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        ClickableTextData clickableTextData2 = new ClickableTextData(stringResource4, (Function0) rememberedValue, null, null, null, 28, null);
        startRestartGroup.startReplaceGroup(-230598398);
        changedInstance2 = ((i8 & 7168) != 2048) | startRestartGroup.changedInstance(uriHandler2);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changedInstance2) {
        }
        rememberedValue2 = new Function0() { // from class: v4.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit TermsAndLicenseCheckbox$lambda$5$lambda$4;
                TermsAndLicenseCheckbox$lambda$5$lambda$4 = TermsAndLicenseCheckboxKt.TermsAndLicenseCheckbox$lambda$5$lambda$4(str2, uriHandler2);
                return TermsAndLicenseCheckbox$lambda$5$lambda$4;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceGroup();
        final List listOf2 = CollectionsKt.listOf((Object[]) new ClickableTextData[]{clickableTextData2, new ClickableTextData(stringResource22, (Function0) rememberedValue2, null, null, null, 28, null)});
        Modifier clip2 = ClipKt.clip(modifier4, ThemeShapesKt.getThemeShapes().getMedium());
        AppColor appColor2 = AppColor.INSTANCE;
        Modifier m104backgroundbw27NRU$default2 = BackgroundKt.m104backgroundbw27NRU$default(clip2, appColor2.m3268getGrey50d7_KjU(), null, 2, null);
        startRestartGroup.startReplaceGroup(-230590884);
        int i122 = 458752 & i8;
        Modifier modifier52 = modifier4;
        int i132 = i8 & 112;
        changedInstance3 = startRestartGroup.changedInstance(focusManager2) | (i122 != 131072) | (i132 != 32);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changedInstance3) {
        }
        rememberedValue3 = new Function1() { // from class: v4.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit TermsAndLicenseCheckbox$lambda$7$lambda$6;
                TermsAndLicenseCheckbox$lambda$7$lambda$6 = TermsAndLicenseCheckboxKt.TermsAndLicenseCheckbox$lambda$7$lambda$6(FocusManager.this, onTermsAndLicenseAcceptChange, z5, ((Boolean) obj).booleanValue());
                return TermsAndLicenseCheckbox$lambda$7$lambda$6;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceGroup();
        Modifier m455toggleableXHw0xAI$default2 = ToggleableKt.m455toggleableXHw0xAI$default(m104backgroundbw27NRU$default2, z5, false, null, (Function1) rememberedValue3, 6, null);
        float f52 = 16;
        Modifier m311padding3ABfNKs2 = PaddingKt.m311padding3ABfNKs(m455toggleableXHw0xAI$default2, Dp.m2599constructorimpl(f52));
        composer2 = startRestartGroup;
        composer2.startReplaceGroup(-230585311);
        changed = composer2.changed(listOf2);
        rememberedValue4 = composer2.rememberedValue();
        if (!changed) {
        }
        rememberedValue4 = new Function1() { // from class: v4.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit TermsAndLicenseCheckbox$lambda$11$lambda$10;
                TermsAndLicenseCheckbox$lambda$11$lambda$10 = TermsAndLicenseCheckboxKt.TermsAndLicenseCheckbox$lambda$11$lambda$10(listOf2, (SemanticsPropertyReceiver) obj);
                return TermsAndLicenseCheckbox$lambda$11$lambda$10;
            }
        };
        composer2.updateRememberedValue(rememberedValue4);
        composer2.endReplaceGroup();
        Modifier semantics$default2 = SemanticsModifierKt.semantics$default(m311padding3ABfNKs2, false, (Function1) rememberedValue4, 1, null);
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composer2, 48);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, semantics$default2);
        ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2 = companion22.getConstructor();
        if (composer2.getApplier() == null) {
        }
        composer2.startReusableNode();
        if (composer2.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(composer2);
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy2, companion22.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion22.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion22.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion22.getSetModifier());
        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
        Modifier.Companion companion32 = Modifier.INSTANCE;
        composer2.startReplaceGroup(1522943619);
        rememberedValue5 = composer2.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue5 == companion.getEmpty()) {
        }
        composer2.endReplaceGroup();
        Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(SemanticsModifierKt.clearAndSetSemantics(companion32, (Function1) rememberedValue5), 0.0f, 0.0f, Dp.m2599constructorimpl(f52), 0.0f, 11, null);
        SelectionControlStyle selectionControlStyle2 = SelectionControlStyle.Checkbox;
        composer2.startReplaceGroup(1522947859);
        changedInstance4 = composer2.changedInstance(focusManager2) | (i122 != 131072);
        rememberedValue6 = composer2.rememberedValue();
        if (!changedInstance4) {
        }
        rememberedValue6 = new Function1() { // from class: v4.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit TermsAndLicenseCheckbox$lambda$18$lambda$15$lambda$14;
                TermsAndLicenseCheckbox$lambda$18$lambda$15$lambda$14 = TermsAndLicenseCheckboxKt.TermsAndLicenseCheckbox$lambda$18$lambda$15$lambda$14(FocusManager.this, onTermsAndLicenseAcceptChange, ((Boolean) obj).booleanValue());
                return TermsAndLicenseCheckbox$lambda$18$lambda$15$lambda$14;
            }
        };
        composer2.updateRememberedValue(rememberedValue6);
        composer2.endReplaceGroup();
        SelectionControlKt.SelectionControl(m315paddingqDBjuR0$default2, z5, (Function1) rememberedValue6, null, z8, null, selectionControlStyle2, z9, composer2, i132 | 1572864 | (i8 & 57344), 40);
        String stringResource32 = StringResources_androidKt.stringResource(R.string.termsAndAgreement_base, new Object[]{stringResource4, stringResource22}, composer2, 6);
        TextStyle paragraphSmall2 = TypographyKt.getParagraphSmall();
        if (!z9) {
        }
        composer2.startReplaceGroup(1522967611);
        changedInstance5 = composer2.changedInstance(focusManager2) | (i122 != 131072) | (i132 == 32);
        rememberedValue7 = composer2.rememberedValue();
        if (!changedInstance5) {
        }
        rememberedValue7 = new Function0() { // from class: v4.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit TermsAndLicenseCheckbox$lambda$18$lambda$17$lambda$16;
                TermsAndLicenseCheckbox$lambda$18$lambda$17$lambda$16 = TermsAndLicenseCheckboxKt.TermsAndLicenseCheckbox$lambda$18$lambda$17$lambda$16(FocusManager.this, onTermsAndLicenseAcceptChange, z5);
                return TermsAndLicenseCheckbox$lambda$18$lambda$17$lambda$16;
            }
        };
        composer2.updateRememberedValue(rememberedValue7);
        composer2.endReplaceGroup();
        ClickableTextKt.m3408ClickableTextFHprtrg(null, stringResource32, listOf2, paragraphSmall2, m3272getSignalRed0d7_KjU, (Function0) rememberedValue7, composer2, 3072, 1);
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier52;
        z7 = z8;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TermsAndLicenseCheckbox$lambda$11$lambda$10(List list, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        List<ClickableTextData> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (final ClickableTextData clickableTextData : list2) {
            arrayList.add(new CustomAccessibilityAction(clickableTextData.getText(), new Function0() { // from class: v4.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean TermsAndLicenseCheckbox$lambda$11$lambda$10$lambda$9$lambda$8;
                    TermsAndLicenseCheckbox$lambda$11$lambda$10$lambda$9$lambda$8 = TermsAndLicenseCheckboxKt.TermsAndLicenseCheckbox$lambda$11$lambda$10$lambda$9$lambda$8(ClickableTextData.this);
                    return Boolean.valueOf(TermsAndLicenseCheckbox$lambda$11$lambda$10$lambda$9$lambda$8);
                }
            }));
        }
        SemanticsPropertiesKt.setCustomActions(semantics, arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TermsAndLicenseCheckbox$lambda$11$lambda$10$lambda$9$lambda$8(ClickableTextData clickableTextData) {
        clickableTextData.getCallback().invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TermsAndLicenseCheckbox$lambda$18$lambda$13$lambda$12(SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, BuildConfig.FLAVOR);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TermsAndLicenseCheckbox$lambda$18$lambda$15$lambda$14(FocusManager focusManager, Function1 function1, boolean z5) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        function1.invoke(Boolean.valueOf(z5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TermsAndLicenseCheckbox$lambda$18$lambda$17$lambda$16(FocusManager focusManager, Function1 function1, boolean z5) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        function1.invoke(Boolean.valueOf(!z5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TermsAndLicenseCheckbox$lambda$19(Modifier modifier, boolean z5, String str, String str2, boolean z6, Function1 function1, IFormValidator.ValidationKey validationKey, IFormValidator iFormValidator, int i5, int i6, Composer composer, int i7) {
        TermsAndLicenseCheckbox(modifier, z5, str, str2, z6, function1, validationKey, iFormValidator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TermsAndLicenseCheckbox$lambda$2$lambda$1(String str, UriHandler uriHandler) {
        if (str != null) {
            uriHandler.openUri(str);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TermsAndLicenseCheckbox$lambda$5$lambda$4(String str, UriHandler uriHandler) {
        if (str != null) {
            uriHandler.openUri(str);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TermsAndLicenseCheckbox$lambda$7$lambda$6(FocusManager focusManager, Function1 function1, boolean z5, boolean z6) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        function1.invoke(Boolean.valueOf(!z5));
        return Unit.INSTANCE;
    }
}
