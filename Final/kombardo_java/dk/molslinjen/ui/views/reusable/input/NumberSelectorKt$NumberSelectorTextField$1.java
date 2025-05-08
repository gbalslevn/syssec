package dk.molslinjen.ui.views.reusable.input;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.intl.LocaleList;
import dk.molslinjen.ui.theme.AppColor;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NumberSelectorKt$NumberSelectorTextField$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Boolean, Unit> $onFocusChanged;
    final /* synthetic */ Function0<Unit> $onImeKeyAction;
    final /* synthetic */ Function1<Integer, Unit> $onQuantityChanged;
    final /* synthetic */ String $postfix;
    final /* synthetic */ TextStyle $textStyle;
    final /* synthetic */ MutableState<NumberSelectorTextFocusedState> $textThatJustGotFocus$delegate;
    final /* synthetic */ int $value;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public NumberSelectorKt$NumberSelectorTextField$1(Modifier modifier, Function0<Unit> function0, int i5, Function1<? super Boolean, Unit> function1, Function1<? super Integer, Unit> function12, boolean z5, MutableState<NumberSelectorTextFocusedState> mutableState, TextStyle textStyle, String str) {
        this.$modifier = modifier;
        this.$onImeKeyAction = function0;
        this.$value = i5;
        this.$onFocusChanged = function1;
        this.$onQuantityChanged = function12;
        this.$enabled = z5;
        this.$textThatJustGotFocus$delegate = mutableState;
        this.$textStyle = textStyle;
        this.$postfix = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1(int i5, Function1 function1, MutableState mutableState, FocusState newFocusState) {
        Intrinsics.checkNotNullParameter(newFocusState, "newFocusState");
        mutableState.setValue(new NumberSelectorTextFocusedState(newFocusState.isFocused() ? String.valueOf(i5) : BuildConfig.FLAVOR, null, 2, null));
        function1.invoke(Boolean.valueOf(newFocusState.isFocused()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$3(Function0 function0, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$8$lambda$7(Function1 function1, MutableState mutableState, String it) {
        NumberSelectorTextFocusedState NumberSelectorTextField$lambda$21;
        NumberSelectorTextFocusedState NumberSelectorTextField$lambda$212;
        NumberSelectorTextFocusedState NumberSelectorTextField$lambda$213;
        Intrinsics.checkNotNullParameter(it, "it");
        NumberSelectorTextField$lambda$21 = NumberSelectorKt.NumberSelectorTextField$lambda$21(mutableState);
        boolean hasNotHappenedJustNow = NumberSelectorTextField$lambda$21.hasNotHappenedJustNow();
        String obj = StringsKt.trimEnd(it).toString();
        if (hasNotHappenedJustNow) {
            NumberSelectorTextField$lambda$213 = NumberSelectorKt.NumberSelectorTextField$lambda$21(mutableState);
            obj = StringsKt.replaceFirst$default(obj, NumberSelectorTextField$lambda$213.getText(), BuildConfig.FLAVOR, false, 4, null);
        }
        if (obj.length() == 0) {
            obj = "0";
        }
        UInt uIntOrNull = UStringsKt.toUIntOrNull(obj);
        if (uIntOrNull == null) {
            return Unit.INSTANCE;
        }
        int data = uIntOrNull.getData();
        if (hasNotHappenedJustNow) {
            NumberSelectorTextField$lambda$212 = NumberSelectorKt.NumberSelectorTextField$lambda$21(mutableState);
            mutableState.setValue(NumberSelectorTextFocusedState.copy$default(NumberSelectorTextField$lambda$212, BuildConfig.FLAVOR, null, 2, null));
        }
        function1.invoke(Integer.valueOf(data));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-782250537, i5, -1, "dk.molslinjen.ui.views.reusable.input.NumberSelectorTextField.<anonymous> (NumberSelector.kt:216)");
        }
        Modifier modifier = this.$modifier;
        composer.startReplaceGroup(646100692);
        boolean changed = composer.changed(this.$onImeKeyAction);
        final Function0<Unit> function0 = this.$onImeKeyAction;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1<KeyEvent, Boolean>() { // from class: dk.molslinjen.ui.views.reusable.input.NumberSelectorKt$NumberSelectorTextField$1$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                    return m3411invokeZmokQxo(keyEvent.getNativeKeyEvent());
                }

                /* renamed from: invoke-ZmokQxo, reason: not valid java name */
                public final Boolean m3411invokeZmokQxo(android.view.KeyEvent it) {
                    boolean z5;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it.getKeyCode() == 66) {
                        function0.invoke();
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    return Boolean.valueOf(z5);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        Modifier onKeyEvent = KeyInputModifierKt.onKeyEvent(modifier, (Function1) rememberedValue);
        composer.startReplaceGroup(646109857);
        boolean changed2 = composer.changed(this.$value) | composer.changed(this.$onFocusChanged);
        final int i6 = this.$value;
        final Function1<Boolean, Unit> function1 = this.$onFocusChanged;
        final MutableState<NumberSelectorTextFocusedState> mutableState = this.$textThatJustGotFocus$delegate;
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: dk.molslinjen.ui.views.reusable.input.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$2$lambda$1;
                    invoke$lambda$2$lambda$1 = NumberSelectorKt$NumberSelectorTextField$1.invoke$lambda$2$lambda$1(i6, function1, mutableState, (FocusState) obj);
                    return invoke$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        Modifier onFocusChanged = FocusChangedModifierKt.onFocusChanged(onKeyEvent, (Function1) rememberedValue2);
        String valueOf = String.valueOf(this.$value);
        SolidColor solidColor = new SolidColor(AppColor.INSTANCE.m3280getTransparent0d7_KjU(), null);
        composer.startReplaceGroup(646183979);
        boolean changed3 = composer.changed(this.$onImeKeyAction);
        final Function0<Unit> function02 = this.$onImeKeyAction;
        Object rememberedValue3 = composer.rememberedValue();
        if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = new Function1() { // from class: dk.molslinjen.ui.views.reusable.input.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$4$lambda$3;
                    invoke$lambda$4$lambda$3 = NumberSelectorKt$NumberSelectorTextField$1.invoke$lambda$4$lambda$3(Function0.this, (KeyboardActionScope) obj);
                    return invoke$lambda$4$lambda$3;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        KeyboardActions KeyboardActions = KeyboardActionsKt.KeyboardActions((Function1) rememberedValue3);
        KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m2420getPhonePjHm6EE(), ImeAction.INSTANCE.m2383getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 115, (DefaultConstructorMarker) null);
        composer.startReplaceGroup(646125883);
        boolean changed4 = composer.changed(this.$onQuantityChanged);
        final Function1<Integer, Unit> function12 = this.$onQuantityChanged;
        final MutableState<NumberSelectorTextFocusedState> mutableState2 = this.$textThatJustGotFocus$delegate;
        Object rememberedValue4 = composer.rememberedValue();
        if (changed4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
            rememberedValue4 = new Function1() { // from class: dk.molslinjen.ui.views.reusable.input.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$8$lambda$7;
                    invoke$lambda$8$lambda$7 = NumberSelectorKt$NumberSelectorTextField$1.invoke$lambda$8$lambda$7(Function1.this, mutableState2, (String) obj);
                    return invoke$lambda$8$lambda$7;
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceGroup();
        final boolean z5 = this.$enabled;
        final int i7 = this.$value;
        final TextStyle textStyle = this.$textStyle;
        final String str = this.$postfix;
        final MutableState<NumberSelectorTextFocusedState> mutableState3 = this.$textThatJustGotFocus$delegate;
        BasicTextFieldKt.BasicTextField(valueOf, (Function1) rememberedValue4, onFocusChanged, z5, false, null, keyboardOptions, KeyboardActions, false, 0, 0, null, null, null, solidColor, ComposableLambdaKt.rememberComposableLambda(-1963156076, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.input.NumberSelectorKt$NumberSelectorTextField$1.5
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function2, Composer composer2, Integer num) {
                invoke((Function2<? super Composer, ? super Integer, Unit>) function2, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Function2<? super Composer, ? super Integer, Unit> it, Composer composer2, int i8) {
                NumberSelectorTextFocusedState NumberSelectorTextField$lambda$21;
                long m3266getGrey30d7_KjU;
                Intrinsics.checkNotNullParameter(it, "it");
                if ((i8 & 17) == 16 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1963156076, i8, -1, "dk.molslinjen.ui.views.reusable.input.NumberSelectorTextField.<anonymous>.<anonymous> (NumberSelector.kt:253)");
                }
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                int i9 = i7;
                boolean z6 = z5;
                TextStyle textStyle2 = textStyle;
                String str2 = str;
                MutableState<NumberSelectorTextFocusedState> mutableState4 = mutableState3;
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer2, 54);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, companion);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                String valueOf2 = String.valueOf(i9);
                if (!z6) {
                    m3266getGrey30d7_KjU = AppColor.INSTANCE.m3264getGrey10d7_KjU();
                } else {
                    String valueOf3 = String.valueOf(i9);
                    NumberSelectorTextField$lambda$21 = NumberSelectorKt.NumberSelectorTextField$lambda$21(mutableState4);
                    m3266getGrey30d7_KjU = Intrinsics.areEqual(valueOf3, NumberSelectorTextField$lambda$21.getText()) ? AppColor.INSTANCE.m3266getGrey30d7_KjU() : textStyle2.m2298getColor0d7_KjU();
                }
                TextKt.m940Text4IGK_g(valueOf2, null, m3266getGrey30d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle2, composer2, 0, 0, 65530);
                composer2.startReplaceGroup(-26446217);
                if (str2 != null) {
                    TextKt.m940Text4IGK_g(str2, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyle2, composer2, 0, 0, 65534);
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer, 54), composer, 1572864, 221184, 16176);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
