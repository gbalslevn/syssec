package dk.molslinjen.ui.views.reusable.input;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class StyledTextFieldKt$StyledTextField$2$1$8 implements Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit> {
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ RoundedCornerShape $cornerShape;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ String $errorMessage;
    final /* synthetic */ String $input;
    final /* synthetic */ MutableState<Boolean> $isFocused$delegate;
    final /* synthetic */ boolean $isPasswordField;
    final /* synthetic */ Function3<Dp, Composer, Integer, Unit> $leadingContent;
    final /* synthetic */ Integer $placeholder;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ MutableState<Integer> $textFieldHeight$delegate;
    final /* synthetic */ String $textPrefix;
    final /* synthetic */ TextStyle $textStyle;
    final /* synthetic */ MutableState<Boolean> $textVisible$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public StyledTextFieldKt$StyledTextField$2$1$8(boolean z5, boolean z6, long j5, RoundedCornerShape roundedCornerShape, String str, String str2, MutableState<Boolean> mutableState, Function3<? super Dp, ? super Composer, ? super Integer, Unit> function3, boolean z7, MutableState<Boolean> mutableState2, MutableState<Integer> mutableState3, Integer num, String str3, TextStyle textStyle) {
        this.$enabled = z5;
        this.$readOnly = z6;
        this.$backgroundColor = j5;
        this.$cornerShape = roundedCornerShape;
        this.$errorMessage = str;
        this.$input = str2;
        this.$isFocused$delegate = mutableState;
        this.$leadingContent = function3;
        this.$isPasswordField = z7;
        this.$textVisible$delegate = mutableState2;
        this.$textFieldHeight$delegate = mutableState3;
        this.$placeholder = num;
        this.$textPrefix = str3;
        this.$textStyle = textStyle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2$lambda$1(MutableState mutableState) {
        boolean StyledTextField_qgfaCVY$lambda$4;
        StyledTextField_qgfaCVY$lambda$4 = StyledTextFieldKt.StyledTextField_qgfaCVY$lambda$4(mutableState);
        StyledTextFieldKt.StyledTextField_qgfaCVY$lambda$5(mutableState, !StyledTextField_qgfaCVY$lambda$4);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function2, Composer composer, Integer num) {
        invoke((Function2<? super Composer, ? super Integer, Unit>) function2, composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer, int i5) {
        int i6;
        boolean StyledTextField_qgfaCVY$lambda$7;
        long m3267getGrey40d7_KjU;
        String str;
        Modifier.Companion companion;
        int i7;
        MutableState<Boolean> mutableState;
        boolean z5;
        Composer composer2;
        boolean StyledTextField_qgfaCVY$lambda$4;
        boolean changed;
        Object rememberedValue;
        boolean StyledTextField_qgfaCVY$lambda$72;
        TextStyle m2295copyp1EtxEg;
        Integer invoke$lambda$17$lambda$1;
        int i8;
        Dp m2597boximpl;
        boolean StyledTextField_qgfaCVY$lambda$73;
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        if ((i5 & 6) == 0) {
            i6 = i5 | (composer.changedInstance(innerTextField) ? 4 : 2);
        } else {
            i6 = i5;
        }
        if ((i6 & 19) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(804139303, i6, -1, "dk.molslinjen.ui.views.reusable.input.StyledTextField.<anonymous>.<anonymous>.<anonymous> (StyledTextField.kt:193)");
        }
        Modifier.Companion companion2 = Modifier.INSTANCE;
        Modifier m327heightInVpY3zN4$default = SizeKt.m327heightInVpY3zN4$default(BackgroundKt.m103backgroundbw27NRU(companion2, (!this.$enabled || this.$readOnly) ? AppColor.INSTANCE.m3269getGrey60d7_KjU() : this.$backgroundColor, this.$cornerShape), Dp.m2599constructorimpl(45), 0.0f, 2, null);
        StyledTextField_qgfaCVY$lambda$7 = StyledTextFieldKt.StyledTextField_qgfaCVY$lambda$7(this.$isFocused$delegate);
        float m2599constructorimpl = Dp.m2599constructorimpl(StyledTextField_qgfaCVY$lambda$7 ? 2 : 1);
        if (!this.$readOnly && this.$enabled) {
            if (this.$errorMessage != null) {
                m3267getGrey40d7_KjU = AppColor.INSTANCE.m3272getSignalRed0d7_KjU();
            } else {
                StyledTextField_qgfaCVY$lambda$73 = StyledTextFieldKt.StyledTextField_qgfaCVY$lambda$7(this.$isFocused$delegate);
                if (!StyledTextField_qgfaCVY$lambda$73 && StringsKt.isBlank(this.$input)) {
                    m3267getGrey40d7_KjU = AppColor.INSTANCE.m3267getGrey40d7_KjU();
                } else {
                    m3267getGrey40d7_KjU = AppColor.INSTANCE.m3253getBrandBlack10d7_KjU();
                }
            }
        } else {
            m3267getGrey40d7_KjU = AppColor.INSTANCE.m3267getGrey40d7_KjU();
        }
        Modifier border = BorderKt.border(m327heightInVpY3zN4$default, BorderStrokeKt.m117BorderStrokecXLIe8U(m2599constructorimpl, m3267getGrey40d7_KjU), this.$cornerShape);
        Alignment.Companion companion3 = Alignment.INSTANCE;
        Alignment.Vertical centerVertically = companion3.getCenterVertically();
        Function3<Dp, Composer, Integer, Unit> function3 = this.$leadingContent;
        boolean z6 = this.$isPasswordField;
        String str2 = this.$input;
        MutableState<Boolean> mutableState2 = this.$textVisible$delegate;
        MutableState<Integer> mutableState3 = this.$textFieldHeight$delegate;
        Integer num = this.$placeholder;
        String str3 = this.$textPrefix;
        int i9 = i6;
        TextStyle textStyle = this.$textStyle;
        MutableState<Boolean> mutableState4 = this.$isFocused$delegate;
        Arrangement arrangement = Arrangement.INSTANCE;
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composer, 48);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, border);
        ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion4.getConstructor();
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
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion4.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        composer.startReplaceGroup(1040037294);
        if (function3 != null) {
            invoke$lambda$17$lambda$1 = StyledTextFieldKt$StyledTextField$2.invoke$lambda$17$lambda$1(mutableState3);
            composer.startReplaceGroup(1040038037);
            if (invoke$lambda$17$lambda$1 == null) {
                m2597boximpl = null;
                i8 = 0;
            } else {
                i8 = 0;
                m2597boximpl = Dp.m2597boximpl(ComposeExtensionsKt.pxToDp(invoke$lambda$17$lambda$1.intValue(), composer, 0));
            }
            composer.endReplaceGroup();
            function3.invoke(m2597boximpl, composer, Integer.valueOf(i8));
            Unit unit = Unit.INSTANCE;
        }
        composer.endReplaceGroup();
        Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(companion2, Dp.m2599constructorimpl(16), Dp.m2599constructorimpl(9));
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getTop(), composer, 0);
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, m312paddingVpY3zN4);
        Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor2);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2, companion4.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
        if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
        if (num != null && str2.length() == 0) {
            StyledTextField_qgfaCVY$lambda$72 = StyledTextFieldKt.StyledTextField_qgfaCVY$lambda$7(mutableState4);
            if (!StyledTextField_qgfaCVY$lambda$72) {
                composer.startReplaceGroup(956725682);
                String stringResource = StringResources_androidKt.stringResource(num.intValue(), composer, 0);
                m2295copyp1EtxEg = r24.m2295copyp1EtxEg((r48 & 1) != 0 ? r24.spanStyle.m2255getColor0d7_KjU() : AppColor.INSTANCE.m3264getGrey10d7_KjU(), (r48 & 2) != 0 ? r24.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r24.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r24.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r24.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r24.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r24.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r24.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r24.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r24.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r24.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r24.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r24.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r24.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r24.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r24.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r24.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r24.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r24.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r24.platformStyle : null, (r48 & 1048576) != 0 ? r24.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r24.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r24.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? TypographyKt.getParagraphSmall().paragraphStyle.getTextMotion() : null);
                str = str2;
                z5 = z6;
                companion = companion2;
                i7 = i9;
                mutableState = mutableState2;
                TextKt.m940Text4IGK_g(stringResource, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, m2295copyp1EtxEg, composer, 0, 0, 65534);
                composer.endReplaceGroup();
                composer2 = composer;
                innerTextField.invoke(composer2, Integer.valueOf(i7 & 14));
                composer.endNode();
                composer2.startReplaceGroup(1040070454);
                if (z5 && str.length() > 0) {
                    StyledTextField_qgfaCVY$lambda$4 = StyledTextFieldKt.StyledTextField_qgfaCVY$lambda$4(mutableState);
                    final int i10 = !StyledTextField_qgfaCVY$lambda$4 ? R.drawable.icon_password_hidden : R.drawable.icon_password_shown;
                    SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), composer2, 0);
                    composer2.startReplaceGroup(1040079723);
                    final MutableState<Boolean> mutableState5 = mutableState;
                    changed = composer2.changed(mutableState5);
                    rememberedValue = composer.rememberedValue();
                    if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.reusable.input.k
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit invoke$lambda$3$lambda$2$lambda$1;
                                invoke$lambda$3$lambda$2$lambda$1 = StyledTextFieldKt$StyledTextField$2$1$8.invoke$lambda$3$lambda$2$lambda$1(MutableState.this);
                                return invoke$lambda$3$lambda$2$lambda$1;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceGroup();
                    IconButtonKt.IconButton((Function0) rememberedValue, null, false, null, null, ComposableLambdaKt.rememberComposableLambda(-1233768573, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.input.StyledTextFieldKt$StyledTextField$2$1$8$1$3
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num2) {
                            invoke(composer3, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i11) {
                            if ((i11 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1233768573, i11, -1, "dk.molslinjen.ui.views.reusable.input.StyledTextField.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StyledTextField.kt:241)");
                            }
                            float f5 = 24;
                            ImageKt.Image(PainterResources_androidKt.painterResource(i10, composer3, 0), StringResources_androidKt.stringResource(R.string.accessibilityLabel_toggleShowPassword, composer3, 6), SizeKt.m331size3ABfNKs(SizeKt.m335sizeInqDBjuR0$default(Modifier.INSTANCE, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null), Dp.m2599constructorimpl(f5)), null, null, 0.0f, null, composer3, 384, 120);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer, 196608, 30);
                    SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(12)), composer2, 6);
                }
                composer.endReplaceGroup();
                composer.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
        }
        str = str2;
        companion = companion2;
        i7 = i9;
        mutableState = mutableState2;
        z5 = z6;
        if (str3 != null) {
            composer.startReplaceGroup(957011874);
            TextKt.m940Text4IGK_g(str3, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle, composer, 0, 1572864, 65534);
            composer.endReplaceGroup();
            composer2 = composer;
            innerTextField.invoke(composer2, Integer.valueOf(i7 & 14));
            composer.endNode();
            composer2.startReplaceGroup(1040070454);
            if (z5) {
                StyledTextField_qgfaCVY$lambda$4 = StyledTextFieldKt.StyledTextField_qgfaCVY$lambda$4(mutableState);
                if (!StyledTextField_qgfaCVY$lambda$4) {
                }
                SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), composer2, 0);
                composer2.startReplaceGroup(1040079723);
                final MutableState mutableState52 = mutableState;
                changed = composer2.changed(mutableState52);
                rememberedValue = composer.rememberedValue();
                if (!changed) {
                }
                rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.reusable.input.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$3$lambda$2$lambda$1;
                        invoke$lambda$3$lambda$2$lambda$1 = StyledTextFieldKt$StyledTextField$2$1$8.invoke$lambda$3$lambda$2$lambda$1(MutableState.this);
                        return invoke$lambda$3$lambda$2$lambda$1;
                    }
                };
                composer2.updateRememberedValue(rememberedValue);
                composer.endReplaceGroup();
                IconButtonKt.IconButton((Function0) rememberedValue, null, false, null, null, ComposableLambdaKt.rememberComposableLambda(-1233768573, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.input.StyledTextFieldKt$StyledTextField$2$1$8$1$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num2) {
                        invoke(composer3, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i11) {
                        if ((i11 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1233768573, i11, -1, "dk.molslinjen.ui.views.reusable.input.StyledTextField.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StyledTextField.kt:241)");
                        }
                        float f5 = 24;
                        ImageKt.Image(PainterResources_androidKt.painterResource(i10, composer3, 0), StringResources_androidKt.stringResource(R.string.accessibilityLabel_toggleShowPassword, composer3, 6), SizeKt.m331size3ABfNKs(SizeKt.m335sizeInqDBjuR0$default(Modifier.INSTANCE, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null), Dp.m2599constructorimpl(f5)), null, null, 0.0f, null, composer3, 384, 120);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer, 196608, 30);
                SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(12)), composer2, 6);
            }
            composer.endReplaceGroup();
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            composer2 = composer;
            composer2.startReplaceGroup(957215606);
            composer.endReplaceGroup();
            innerTextField.invoke(composer2, Integer.valueOf(i7 & 14));
            composer.endNode();
            composer2.startReplaceGroup(1040070454);
            if (z5) {
            }
            composer.endReplaceGroup();
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
        }
    }
}
