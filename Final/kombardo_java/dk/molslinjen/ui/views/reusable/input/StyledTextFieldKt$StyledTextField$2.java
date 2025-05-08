package dk.molslinjen.ui.views.reusable.input;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardActionsKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillNode;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusEventModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.InputErrorTextKt;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class StyledTextFieldKt$StyledTextField$2 implements Function3<AutofillNode, Composer, Integer, Unit> {
    final /* synthetic */ boolean $allowShowErrorMessage;
    final /* synthetic */ Autofill $autofill;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
    final /* synthetic */ RoundedCornerShape $cornerShape;
    final /* synthetic */ String $description;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ String $errorMessage;
    final /* synthetic */ boolean $fillMaxWidth;
    final /* synthetic */ String $input;
    final /* synthetic */ MutableState<Boolean> $isFocused$delegate;
    final /* synthetic */ boolean $isPasswordField;
    final /* synthetic */ KeyboardOptions $keyboardOptions;
    final /* synthetic */ Integer $label;
    final /* synthetic */ Function3<Dp, Composer, Integer, Unit> $leadingContent;
    final /* synthetic */ int $maxLines;
    final /* synthetic */ float $minWidth;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Boolean, Unit> $onFocusChange;
    final /* synthetic */ Function0<Unit> $onImeKeyAction;
    final /* synthetic */ Function1<String, Unit> $onValueChange;
    final /* synthetic */ Integer $placeholder;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ int $textAlign;
    final /* synthetic */ String $textPrefix;
    final /* synthetic */ TextStyle $textStyle;
    final /* synthetic */ MutableState<Boolean> $textVisible$delegate;
    final /* synthetic */ IFormValidator.ValidationKey $validationKey;
    final /* synthetic */ IFormValidator $validator;
    final /* synthetic */ VisualTransformation $visualTransformation;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public StyledTextFieldKt$StyledTextField$2(Modifier modifier, BringIntoViewRequester bringIntoViewRequester, Integer num, boolean z5, float f5, RoundedCornerShape roundedCornerShape, Function0<Unit> function0, CoroutineScope coroutineScope, Autofill autofill, IFormValidator.ValidationKey validationKey, IFormValidator iFormValidator, String str, Function1<? super String, Unit> function1, Function1<? super Boolean, Unit> function12, boolean z6, boolean z7, TextStyle textStyle, int i5, int i6, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, boolean z8, String str2, String str3, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, long j5, Function3<? super Dp, ? super Composer, ? super Integer, Unit> function3, boolean z9, Integer num2, String str4) {
        this.$modifier = modifier;
        this.$bringIntoViewRequester = bringIntoViewRequester;
        this.$label = num;
        this.$fillMaxWidth = z5;
        this.$minWidth = f5;
        this.$cornerShape = roundedCornerShape;
        this.$onImeKeyAction = function0;
        this.$scope = coroutineScope;
        this.$autofill = autofill;
        this.$validationKey = validationKey;
        this.$validator = iFormValidator;
        this.$input = str;
        this.$onValueChange = function1;
        this.$onFocusChange = function12;
        this.$enabled = z6;
        this.$readOnly = z7;
        this.$textStyle = textStyle;
        this.$textAlign = i5;
        this.$maxLines = i6;
        this.$visualTransformation = visualTransformation;
        this.$keyboardOptions = keyboardOptions;
        this.$allowShowErrorMessage = z8;
        this.$errorMessage = str2;
        this.$description = str3;
        this.$isFocused$delegate = mutableState;
        this.$textVisible$delegate = mutableState2;
        this.$backgroundColor = j5;
        this.$leadingContent = function3;
        this.$isPasswordField = z9;
        this.$placeholder = num2;
        this.$textPrefix = str4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer invoke$lambda$17$lambda$1(MutableState<Integer> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$17$lambda$11$lambda$10(CoroutineScope coroutineScope, BringIntoViewRequester bringIntoViewRequester, FocusState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isFocused()) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new StyledTextFieldKt$StyledTextField$2$1$5$1$1(bringIntoViewRequester, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$17$lambda$13$lambda$12(Autofill autofill, AutofillNode autofillNode, IFormValidator.ValidationKey validationKey, IFormValidator iFormValidator, String str, Function1 function1, Function1 function12, MutableState mutableState, FocusState newFocusState) {
        boolean StyledTextField_qgfaCVY$lambda$7;
        Intrinsics.checkNotNullParameter(newFocusState, "newFocusState");
        if (autofill != null && autofillNode != null) {
            try {
                if (newFocusState.isFocused()) {
                    autofill.requestAutofillForNode(autofillNode);
                } else {
                    autofill.cancelAutofillForNode(autofillNode);
                }
            } catch (Exception e5) {
                Logger.INSTANCE.logError(e5);
            }
        }
        StyledTextField_qgfaCVY$lambda$7 = StyledTextFieldKt.StyledTextField_qgfaCVY$lambda$7(mutableState);
        if (StyledTextField_qgfaCVY$lambda$7 && !newFocusState.isFocused() && validationKey != null && iFormValidator != null) {
            iFormValidator.submit(validationKey);
        }
        if (!newFocusState.isFocused()) {
            String obj = StringsKt.trimEnd(str).toString();
            if (!Intrinsics.areEqual(str, obj)) {
                function1.invoke(obj);
            }
        }
        StyledTextFieldKt.StyledTextField_qgfaCVY$lambda$8(mutableState, newFocusState.isFocused());
        if (function12 != null) {
            function12.invoke(Boolean.valueOf(newFocusState.isFocused()));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$17$lambda$15$lambda$14(Function0 function0, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier invoke$lambda$17$lambda$4$lambda$3(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return SizeKt.fillMaxWidth$default(applyIf, 0.0f, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier invoke$lambda$17$lambda$6$lambda$5(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return IntrinsicKt.width(applyIf, IntrinsicSize.Min);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$17$lambda$8$lambda$7(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Integer.valueOf(IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g())));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(AutofillNode autofillNode, Composer composer, Integer num) {
        invoke(autofillNode, composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0525  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke(final AutofillNode autofillNode, Composer composer, int i5) {
        int i6;
        RoundedCornerShape roundedCornerShape;
        Function0<Unit> function0;
        float f5;
        boolean z5;
        long j5;
        Autofill autofill;
        IFormValidator.ValidationKey validationKey;
        IFormValidator iFormValidator;
        String str;
        Function1<String, Unit> function1;
        Function1<Boolean, Unit> function12;
        boolean z6;
        boolean z7;
        TextStyle textStyle;
        int i7;
        VisualTransformation visualTransformation;
        KeyboardOptions keyboardOptions;
        boolean z8;
        String str2;
        String str3;
        MutableState<Boolean> mutableState;
        MutableState<Boolean> mutableState2;
        Function3<Dp, Composer, Integer, Unit> function3;
        boolean z9;
        Integer num;
        String str4;
        final CoroutineScope coroutineScope;
        BringIntoViewRequester bringIntoViewRequester;
        int i8;
        int i9;
        int i10;
        boolean z10;
        final Function1<String, Unit> function13;
        boolean changedInstance;
        Object rememberedValue;
        ColumnScopeInstance columnScopeInstance;
        Composer composer2;
        MutableState mutableState3;
        Function1<String, Unit> function14;
        Modifier modifier;
        final Function0<Unit> function02;
        long m3264getGrey10d7_KjU;
        TextStyle m2295copyp1EtxEg;
        boolean changed;
        Object rememberedValue2;
        boolean StyledTextField_qgfaCVY$lambda$4;
        boolean z11;
        long m3264getGrey10d7_KjU2;
        TextStyle m2295copyp1EtxEg2;
        if ((i5 & 6) == 0) {
            i6 = i5 | ((i5 & 8) == 0 ? composer.changed(autofillNode) : composer.changedInstance(autofillNode) ? 4 : 2);
        } else {
            i6 = i5;
        }
        if ((i6 & 19) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-617688140, i6, -1, "dk.molslinjen.ui.views.reusable.input.StyledTextField.<anonymous> (StyledTextField.kt:109)");
        }
        Modifier bringIntoViewRequester2 = BringIntoViewRequesterKt.bringIntoViewRequester(this.$modifier, this.$bringIntoViewRequester);
        Integer num2 = this.$label;
        boolean z12 = this.$fillMaxWidth;
        float f6 = this.$minWidth;
        RoundedCornerShape roundedCornerShape2 = this.$cornerShape;
        Function0<Unit> function03 = this.$onImeKeyAction;
        CoroutineScope coroutineScope2 = this.$scope;
        BringIntoViewRequester bringIntoViewRequester3 = this.$bringIntoViewRequester;
        Autofill autofill2 = this.$autofill;
        IFormValidator.ValidationKey validationKey2 = this.$validationKey;
        IFormValidator iFormValidator2 = this.$validator;
        String str5 = this.$input;
        Function1<String, Unit> function15 = this.$onValueChange;
        Function1<Boolean, Unit> function16 = this.$onFocusChange;
        boolean z13 = this.$enabled;
        boolean z14 = this.$readOnly;
        TextStyle textStyle2 = this.$textStyle;
        int i11 = this.$textAlign;
        int i12 = this.$maxLines;
        VisualTransformation visualTransformation2 = this.$visualTransformation;
        KeyboardOptions keyboardOptions2 = this.$keyboardOptions;
        boolean z15 = this.$allowShowErrorMessage;
        String str6 = this.$errorMessage;
        String str7 = this.$description;
        MutableState<Boolean> mutableState4 = this.$isFocused$delegate;
        MutableState<Boolean> mutableState5 = this.$textVisible$delegate;
        long j6 = this.$backgroundColor;
        Function3<Dp, Composer, Integer, Unit> function32 = this.$leadingContent;
        boolean z16 = this.$isPasswordField;
        Integer num3 = this.$placeholder;
        String str8 = this.$textPrefix;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, bringIntoViewRequester2);
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
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
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
        composer.startReplaceGroup(-11617968);
        if (num2 != null) {
            coroutineScope = coroutineScope2;
            bringIntoViewRequester = bringIntoViewRequester3;
            roundedCornerShape = roundedCornerShape2;
            function0 = function03;
            f5 = f6;
            z5 = z12;
            i8 = i6;
            j5 = j6;
            autofill = autofill2;
            validationKey = validationKey2;
            iFormValidator = iFormValidator2;
            str = str5;
            function1 = function15;
            function12 = function16;
            z6 = z13;
            z7 = z14;
            textStyle = textStyle2;
            i7 = i12;
            visualTransformation = visualTransformation2;
            keyboardOptions = keyboardOptions2;
            z8 = z15;
            str2 = str6;
            str3 = str7;
            mutableState = mutableState4;
            mutableState2 = mutableState5;
            function3 = function32;
            z9 = z16;
            num = num3;
            str4 = str8;
            i9 = i11;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(num2.intValue(), composer, 0), PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(8), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer, 48, 1572864, 65532);
        } else {
            roundedCornerShape = roundedCornerShape2;
            function0 = function03;
            f5 = f6;
            z5 = z12;
            j5 = j6;
            autofill = autofill2;
            validationKey = validationKey2;
            iFormValidator = iFormValidator2;
            str = str5;
            function1 = function15;
            function12 = function16;
            z6 = z13;
            z7 = z14;
            textStyle = textStyle2;
            i7 = i12;
            visualTransformation = visualTransformation2;
            keyboardOptions = keyboardOptions2;
            z8 = z15;
            str2 = str6;
            str3 = str7;
            mutableState = mutableState4;
            mutableState2 = mutableState5;
            function3 = function32;
            z9 = z16;
            num = num3;
            str4 = str8;
            coroutineScope = coroutineScope2;
            bringIntoViewRequester = bringIntoViewRequester3;
            i8 = i6;
            i9 = i11;
        }
        composer.endReplaceGroup();
        composer.startReplaceGroup(-11609616);
        Object rememberedValue3 = composer.rememberedValue();
        Composer.Companion companion2 = Composer.INSTANCE;
        if (rememberedValue3 == companion2.getEmpty()) {
            i10 = 2;
            rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            composer.updateRememberedValue(rememberedValue3);
        } else {
            i10 = 2;
        }
        final MutableState mutableState6 = (MutableState) rememberedValue3;
        composer.endReplaceGroup();
        Modifier.Companion companion3 = Modifier.INSTANCE;
        composer.startReplaceGroup(-11605119);
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == companion2.getEmpty()) {
            rememberedValue4 = new Function1() { // from class: dk.molslinjen.ui.views.reusable.input.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Modifier invoke$lambda$17$lambda$4$lambda$3;
                    invoke$lambda$17$lambda$4$lambda$3 = StyledTextFieldKt$StyledTextField$2.invoke$lambda$17$lambda$4$lambda$3((Modifier) obj);
                    return invoke$lambda$17$lambda$4$lambda$3;
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceGroup();
        boolean z17 = z5;
        Modifier applyIf = ModifierExtensionsKt.applyIf(companion3, z17, (Function1) rememberedValue4);
        boolean z18 = !z17;
        composer.startReplaceGroup(-11603093);
        Object rememberedValue5 = composer.rememberedValue();
        if (rememberedValue5 == companion2.getEmpty()) {
            rememberedValue5 = new Function1() { // from class: dk.molslinjen.ui.views.reusable.input.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Modifier invoke$lambda$17$lambda$6$lambda$5;
                    invoke$lambda$17$lambda$6$lambda$5 = StyledTextFieldKt$StyledTextField$2.invoke$lambda$17$lambda$6$lambda$5((Modifier) obj);
                    return invoke$lambda$17$lambda$6$lambda$5;
                }
            };
            composer.updateRememberedValue(rememberedValue5);
        }
        composer.endReplaceGroup();
        Modifier m338widthInVpY3zN4$default = SizeKt.m338widthInVpY3zN4$default(ModifierExtensionsKt.applyIf(applyIf, z18, (Function1) rememberedValue5), f5, 0.0f, i10, null);
        composer.startReplaceGroup(-11599329);
        Object rememberedValue6 = composer.rememberedValue();
        if (rememberedValue6 == companion2.getEmpty()) {
            rememberedValue6 = new Function1() { // from class: dk.molslinjen.ui.views.reusable.input.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$17$lambda$8$lambda$7;
                    invoke$lambda$17$lambda$8$lambda$7 = StyledTextFieldKt$StyledTextField$2.invoke$lambda$17$lambda$8$lambda$7(MutableState.this, (LayoutCoordinates) obj);
                    return invoke$lambda$17$lambda$8$lambda$7;
                }
            };
            composer.updateRememberedValue(rememberedValue6);
        }
        composer.endReplaceGroup();
        RoundedCornerShape roundedCornerShape3 = roundedCornerShape;
        Modifier clip = ClipKt.clip(OnGloballyPositionedModifierKt.onGloballyPositioned(m338widthInVpY3zN4$default, (Function1) rememberedValue6), roundedCornerShape3);
        composer.startReplaceGroup(-11594268);
        final Function0<Unit> function04 = function0;
        boolean changed2 = composer.changed(function04);
        Object rememberedValue7 = composer.rememberedValue();
        if (changed2 || rememberedValue7 == companion2.getEmpty()) {
            rememberedValue7 = new Function1<KeyEvent, Boolean>() { // from class: dk.molslinjen.ui.views.reusable.input.StyledTextFieldKt$StyledTextField$2$1$4$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                    return m3413invokeZmokQxo(keyEvent.getNativeKeyEvent());
                }

                /* renamed from: invoke-ZmokQxo, reason: not valid java name */
                public final Boolean m3413invokeZmokQxo(android.view.KeyEvent it) {
                    boolean z19;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it.getKeyCode() == 66) {
                        function04.invoke();
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    return Boolean.valueOf(z19);
                }
            };
            composer.updateRememberedValue(rememberedValue7);
        }
        composer.endReplaceGroup();
        Modifier onKeyEvent = KeyInputModifierKt.onKeyEvent(clip, (Function1) rememberedValue7);
        composer.startReplaceGroup(-11584281);
        final BringIntoViewRequester bringIntoViewRequester4 = bringIntoViewRequester;
        boolean changedInstance2 = composer.changedInstance(coroutineScope) | composer.changedInstance(bringIntoViewRequester4);
        Object rememberedValue8 = composer.rememberedValue();
        if (changedInstance2 || rememberedValue8 == companion2.getEmpty()) {
            rememberedValue8 = new Function1() { // from class: dk.molslinjen.ui.views.reusable.input.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$17$lambda$11$lambda$10;
                    invoke$lambda$17$lambda$11$lambda$10 = StyledTextFieldKt$StyledTextField$2.invoke$lambda$17$lambda$11$lambda$10(CoroutineScope.this, bringIntoViewRequester4, (FocusState) obj);
                    return invoke$lambda$17$lambda$11$lambda$10;
                }
            };
            composer.updateRememberedValue(rememberedValue8);
        }
        composer.endReplaceGroup();
        Modifier onFocusEvent = FocusEventModifierKt.onFocusEvent(onKeyEvent, (Function1) rememberedValue8);
        composer.startReplaceGroup(-11573029);
        final Autofill autofill3 = autofill;
        boolean changedInstance3 = composer.changedInstance(autofill3);
        if ((i8 & 14) != 4 && ((i8 & 8) == 0 || !composer.changedInstance(autofillNode))) {
            z10 = false;
            boolean z19 = changedInstance3 | z10;
            final IFormValidator.ValidationKey validationKey3 = validationKey;
            final IFormValidator iFormValidator3 = iFormValidator;
            final String str9 = str;
            function13 = function1;
            final Function1<Boolean, Unit> function17 = function12;
            changedInstance = z19 | composer.changedInstance(validationKey3) | composer.changedInstance(iFormValidator3) | composer.changed(str9) | composer.changed(function13) | composer.changed(function17);
            rememberedValue = composer.rememberedValue();
            if (!changedInstance || rememberedValue == companion2.getEmpty()) {
                columnScopeInstance = columnScopeInstance2;
                composer2 = composer;
                mutableState3 = mutableState6;
                function14 = function13;
                modifier = onFocusEvent;
                function02 = function04;
                final MutableState<Boolean> mutableState7 = mutableState;
                Function1 function18 = new Function1() { // from class: dk.molslinjen.ui.views.reusable.input.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit invoke$lambda$17$lambda$13$lambda$12;
                        invoke$lambda$17$lambda$13$lambda$12 = StyledTextFieldKt$StyledTextField$2.invoke$lambda$17$lambda$13$lambda$12(Autofill.this, autofillNode, validationKey3, iFormValidator3, str9, function13, function17, mutableState7, (FocusState) obj);
                        return invoke$lambda$17$lambda$13$lambda$12;
                    }
                };
                composer2.updateRememberedValue(function18);
                rememberedValue = function18;
            } else {
                columnScopeInstance = columnScopeInstance2;
                composer2 = composer;
                function02 = function04;
                function14 = function13;
                mutableState3 = mutableState6;
                modifier = onFocusEvent;
            }
            composer.endReplaceGroup();
            Modifier onFocusChanged = FocusChangedModifierKt.onFocusChanged(modifier, (Function1) rememberedValue);
            if (!z6 && !z7) {
                m3264getGrey10d7_KjU = textStyle.m2298getColor0d7_KjU();
            } else {
                m3264getGrey10d7_KjU = AppColor.INSTANCE.m3264getGrey10d7_KjU();
            }
            m2295copyp1EtxEg = r24.m2295copyp1EtxEg((r48 & 1) != 0 ? r24.spanStyle.m2255getColor0d7_KjU() : m3264getGrey10d7_KjU, (r48 & 2) != 0 ? r24.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r24.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r24.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r24.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r24.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r24.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r24.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r24.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r24.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r24.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r24.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r24.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r24.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r24.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r24.paragraphStyle.getTextAlign() : i9, (r48 & 65536) != 0 ? r24.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r24.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r24.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r24.platformStyle : null, (r48 & 1048576) != 0 ? r24.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r24.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r24.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? textStyle.paragraphStyle.getTextMotion() : null);
            int i13 = i7;
            boolean z20 = i13 != 1;
            composer2.startReplaceGroup(-11510269);
            changed = composer2.changed(function02);
            rememberedValue2 = composer.rememberedValue();
            if (!changed || rememberedValue2 == companion2.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: dk.molslinjen.ui.views.reusable.input.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit invoke$lambda$17$lambda$15$lambda$14;
                        invoke$lambda$17$lambda$15$lambda$14 = StyledTextFieldKt$StyledTextField$2.invoke$lambda$17$lambda$15$lambda$14(Function0.this, (KeyboardActionScope) obj);
                        return invoke$lambda$17$lambda$15$lambda$14;
                    }
                };
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            KeyboardActions KeyboardActions = KeyboardActionsKt.KeyboardActions((Function1) rememberedValue2);
            StyledTextField_qgfaCVY$lambda$4 = StyledTextFieldKt.StyledTextField_qgfaCVY$lambda$4(mutableState2);
            if (StyledTextField_qgfaCVY$lambda$4) {
                z11 = false;
                visualTransformation = new PasswordVisualTransformation((char) 0, 1, null);
            } else {
                if (visualTransformation == null) {
                    visualTransformation = VisualTransformation.INSTANCE.getNone();
                }
                z11 = false;
            }
            boolean z21 = z11;
            BasicTextFieldKt.BasicTextField(str9, function14, onFocusChanged, z6, z7, m2295copyp1EtxEg, keyboardOptions, KeyboardActions, z20, i13, 0, visualTransformation, null, null, null, ComposableLambdaKt.rememberComposableLambda(804139303, true, new StyledTextFieldKt$StyledTextField$2$1$8(z6, z7, j5, roundedCornerShape3, str2, str9, mutableState, function3, z9, mutableState2, mutableState3, num, str4, textStyle), composer2, 54), composer, 0, 196608, 29696);
            String str10 = str2;
            InputErrorTextKt.InputErrorText(columnScopeInstance, (z8 || str10 == null) ? z21 : true, str10, composer2, 6);
            composer2.startReplaceGroup(-11392893);
            if (str3 != null) {
                TextStyle sub = TypographyKt.getSub();
                if (!z8 && str10 != null) {
                    m3264getGrey10d7_KjU2 = AppColor.INSTANCE.m3272getSignalRed0d7_KjU();
                } else {
                    m3264getGrey10d7_KjU2 = AppColor.INSTANCE.m3264getGrey10d7_KjU();
                }
                m2295copyp1EtxEg2 = sub.m2295copyp1EtxEg((r48 & 1) != 0 ? sub.spanStyle.m2255getColor0d7_KjU() : m3264getGrey10d7_KjU2, (r48 & 2) != 0 ? sub.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? sub.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? sub.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? sub.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? sub.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? sub.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? sub.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? sub.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? sub.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? sub.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? sub.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? sub.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? sub.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? sub.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? sub.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? sub.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? sub.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? sub.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? sub.platformStyle : null, (r48 & 1048576) != 0 ? sub.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? sub.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? sub.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? sub.paragraphStyle.getTextMotion() : null);
                TextKt.m940Text4IGK_g(str3, PaddingKt.m315paddingqDBjuR0$default(companion3, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, m2295copyp1EtxEg2, composer, 48, 0, 65532);
                Unit unit = Unit.INSTANCE;
            }
            composer.endReplaceGroup();
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                return;
            }
            ComposerKt.traceEventEnd();
            return;
        }
        z10 = true;
        boolean z192 = changedInstance3 | z10;
        final IFormValidator.ValidationKey validationKey32 = validationKey;
        final IFormValidator iFormValidator32 = iFormValidator;
        final String str92 = str;
        function13 = function1;
        final Function1 function172 = function12;
        changedInstance = z192 | composer.changedInstance(validationKey32) | composer.changedInstance(iFormValidator32) | composer.changed(str92) | composer.changed(function13) | composer.changed(function172);
        rememberedValue = composer.rememberedValue();
        if (changedInstance) {
        }
        columnScopeInstance = columnScopeInstance2;
        composer2 = composer;
        mutableState3 = mutableState6;
        function14 = function13;
        modifier = onFocusEvent;
        function02 = function04;
        final MutableState mutableState72 = mutableState;
        Function1 function182 = new Function1() { // from class: dk.molslinjen.ui.views.reusable.input.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit invoke$lambda$17$lambda$13$lambda$12;
                invoke$lambda$17$lambda$13$lambda$12 = StyledTextFieldKt$StyledTextField$2.invoke$lambda$17$lambda$13$lambda$12(Autofill.this, autofillNode, validationKey32, iFormValidator32, str92, function13, function172, mutableState72, (FocusState) obj);
                return invoke$lambda$17$lambda$13$lambda$12;
            }
        };
        composer2.updateRememberedValue(function182);
        rememberedValue = function182;
        composer.endReplaceGroup();
        Modifier onFocusChanged2 = FocusChangedModifierKt.onFocusChanged(modifier, (Function1) rememberedValue);
        if (!z6) {
        }
        m3264getGrey10d7_KjU = AppColor.INSTANCE.m3264getGrey10d7_KjU();
        m2295copyp1EtxEg = r24.m2295copyp1EtxEg((r48 & 1) != 0 ? r24.spanStyle.m2255getColor0d7_KjU() : m3264getGrey10d7_KjU, (r48 & 2) != 0 ? r24.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r24.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r24.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r24.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r24.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r24.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r24.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r24.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r24.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r24.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r24.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r24.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r24.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r24.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r24.paragraphStyle.getTextAlign() : i9, (r48 & 65536) != 0 ? r24.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r24.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r24.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r24.platformStyle : null, (r48 & 1048576) != 0 ? r24.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r24.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r24.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? textStyle.paragraphStyle.getTextMotion() : null);
        int i132 = i7;
        if (i132 != 1) {
        }
        composer2.startReplaceGroup(-11510269);
        changed = composer2.changed(function02);
        rememberedValue2 = composer.rememberedValue();
        if (!changed) {
        }
        rememberedValue2 = new Function1() { // from class: dk.molslinjen.ui.views.reusable.input.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit invoke$lambda$17$lambda$15$lambda$14;
                invoke$lambda$17$lambda$15$lambda$14 = StyledTextFieldKt$StyledTextField$2.invoke$lambda$17$lambda$15$lambda$14(Function0.this, (KeyboardActionScope) obj);
                return invoke$lambda$17$lambda$15$lambda$14;
            }
        };
        composer2.updateRememberedValue(rememberedValue2);
        composer.endReplaceGroup();
        KeyboardActions KeyboardActions2 = KeyboardActionsKt.KeyboardActions((Function1) rememberedValue2);
        StyledTextField_qgfaCVY$lambda$4 = StyledTextFieldKt.StyledTextField_qgfaCVY$lambda$4(mutableState2);
        if (StyledTextField_qgfaCVY$lambda$4) {
        }
        boolean z212 = z11;
        BasicTextFieldKt.BasicTextField(str92, function14, onFocusChanged2, z6, z7, m2295copyp1EtxEg, keyboardOptions, KeyboardActions2, z20, i132, 0, visualTransformation, null, null, null, ComposableLambdaKt.rememberComposableLambda(804139303, true, new StyledTextFieldKt$StyledTextField$2$1$8(z6, z7, j5, roundedCornerShape3, str2, str92, mutableState, function3, z9, mutableState2, mutableState3, num, str4, textStyle), composer2, 54), composer, 0, 196608, 29696);
        String str102 = str2;
        InputErrorTextKt.InputErrorText(columnScopeInstance, (z8 || str102 == null) ? z212 : true, str102, composer2, 6);
        composer2.startReplaceGroup(-11392893);
        if (str3 != null) {
        }
        composer.endReplaceGroup();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
    }
}
