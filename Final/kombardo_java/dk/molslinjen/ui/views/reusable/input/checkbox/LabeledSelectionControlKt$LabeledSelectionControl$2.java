package dk.molslinjen.ui.views.reusable.input.checkbox;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class LabeledSelectionControlKt$LabeledSelectionControl$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ boolean $allowOnClicks;
    final /* synthetic */ SelectionControlSize $checkboxSize;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ boolean $isChecked;
    final /* synthetic */ AnnotatedString $label;
    final /* synthetic */ Modifier $labelModifier;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Boolean, Unit> $onCheckChange;
    final /* synthetic */ Function0<Unit> $onClickDisabled;
    final /* synthetic */ boolean $showError;
    final /* synthetic */ SelectionControlStyle $style;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public LabeledSelectionControlKt$LabeledSelectionControl$2(Modifier modifier, boolean z5, boolean z6, boolean z7, Function1<? super Boolean, Unit> function1, Function0<Unit> function0, SelectionControlSize selectionControlSize, SelectionControlStyle selectionControlStyle, boolean z8, Modifier modifier2, AnnotatedString annotatedString) {
        this.$modifier = modifier;
        this.$isChecked = z5;
        this.$allowOnClicks = z6;
        this.$enabled = z7;
        this.$onCheckChange = function1;
        this.$onClickDisabled = function0;
        this.$checkboxSize = selectionControlSize;
        this.$style = selectionControlStyle;
        this.$showError = z8;
        this.$labelModifier = modifier2;
        this.$label = annotatedString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(boolean z5, Function1 function1, Function0 function0, boolean z6) {
        if (z5) {
            function1.invoke(Boolean.valueOf(z6));
        } else if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$6$lambda$5$lambda$4(SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
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
            ComposerKt.traceEventStart(1907283659, i5, -1, "dk.molslinjen.ui.views.reusable.input.checkbox.LabeledSelectionControl.<anonymous> (LabeledSelectionControl.kt:59)");
        }
        Modifier modifier = this.$modifier;
        boolean z5 = this.$isChecked;
        boolean z6 = this.$allowOnClicks;
        composer.startReplaceGroup(2001336318);
        boolean changed = composer.changed(this.$enabled) | composer.changed(this.$onCheckChange) | composer.changed(this.$onClickDisabled);
        final boolean z7 = this.$enabled;
        final Function1<Boolean, Unit> function1 = this.$onCheckChange;
        final Function0<Unit> function0 = this.$onClickDisabled;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.reusable.input.checkbox.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = LabeledSelectionControlKt$LabeledSelectionControl$2.invoke$lambda$1$lambda$0(z7, function1, function0, ((Boolean) obj).booleanValue());
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        Modifier m454toggleableXHw0xAI = ToggleableKt.m454toggleableXHw0xAI(modifier, z5, z6, null, (Function1) rememberedValue);
        composer.startReplaceGroup(2001347940);
        Object rememberedValue2 = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: dk.molslinjen.ui.views.reusable.input.checkbox.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$3$lambda$2;
                    invoke$lambda$3$lambda$2 = LabeledSelectionControlKt$LabeledSelectionControl$2.invoke$lambda$3$lambda$2((SemanticsPropertyReceiver) obj);
                    return invoke$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        Modifier semantics = SemanticsModifierKt.semantics(m454toggleableXHw0xAI, true, (Function1) rememberedValue2);
        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
        boolean z8 = this.$isChecked;
        Function1<Boolean, Unit> function12 = this.$onCheckChange;
        Function0<Unit> function02 = this.$onClickDisabled;
        boolean z9 = this.$enabled;
        SelectionControlSize selectionControlSize = this.$checkboxSize;
        SelectionControlStyle selectionControlStyle = this.$style;
        boolean z10 = this.$showError;
        Modifier modifier2 = this.$labelModifier;
        AnnotatedString annotatedString = this.$label;
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, semantics);
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
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        Modifier.Companion companion3 = Modifier.INSTANCE;
        composer.startReplaceGroup(619172419);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = new Function1() { // from class: dk.molslinjen.ui.views.reusable.input.checkbox.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$6$lambda$5$lambda$4;
                    invoke$lambda$6$lambda$5$lambda$4 = LabeledSelectionControlKt$LabeledSelectionControl$2.invoke$lambda$6$lambda$5$lambda$4((SemanticsPropertyReceiver) obj);
                    return invoke$lambda$6$lambda$5$lambda$4;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        SelectionControlKt.SelectionControl(SemanticsModifierKt.clearAndSetSemantics(companion3, (Function1) rememberedValue3), z8, function12, function02, z9, selectionControlSize, selectionControlStyle, z10, composer, 0, 0);
        Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(modifier2, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null);
        AppColor appColor = AppColor.INSTANCE;
        TextKt.m941TextIbK3jfQ(annotatedString, m315paddingqDBjuR0$default, z9 ? appColor.m3253getBrandBlack10d7_KjU() : appColor.m3265getGrey20d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, TypographyKt.getParagraphSmall(), composer, 0, 12582912, 131064);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
