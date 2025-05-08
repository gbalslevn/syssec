package dk.molslinjen.ui.views.reusable.bottomsheet;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.ui.views.reusable.buttons.NavigationButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.NavigationButtonType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BottomSheetHeaderKt$BottomSheetHeader$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ float $iconSize;
    final /* synthetic */ float $iconToTextPadding;
    final /* synthetic */ Function0<Unit> $onBackAction;
    final /* synthetic */ Function0<Unit> $onCloseAction;
    final /* synthetic */ AnnotatedString $title;
    final /* synthetic */ BottomSheetTitleStyle $titleStyle;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BottomSheetHeaderKt$BottomSheetHeader$2(long j5, float f5, Function0<Unit> function0, Function0<Unit> function02, float f6, AnnotatedString annotatedString, BottomSheetTitleStyle bottomSheetTitleStyle) {
        this.$backgroundColor = j5;
        this.$iconSize = f5;
        this.$onBackAction = function0;
        this.$onCloseAction = function02;
        this.$iconToTextPadding = f6;
        this.$title = annotatedString;
        this.$titleStyle = bottomSheetTitleStyle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$6$lambda$1$lambda$0(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$6$lambda$3$lambda$2(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.heading(semantics);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$6$lambda$5$lambda$4(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void invoke(Composer composer, int i5) {
        float f5;
        float f6;
        BottomSheetTitleStyle bottomSheetTitleStyle;
        AnnotatedString annotatedString;
        int i6;
        Function0<Unit> function0;
        Modifier.Companion companion;
        final Function0<Unit> function02;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(702065755, i5, -1, "dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetHeader.<anonymous> (BottomSheetHeader.kt:58)");
        }
        Modifier.Companion companion2 = Modifier.INSTANCE;
        Modifier m327heightInVpY3zN4$default = SizeKt.m327heightInVpY3zN4$default(PaddingKt.m312paddingVpY3zN4(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), this.$backgroundColor, null, 2, null), Dp.m2599constructorimpl(24), Dp.m2599constructorimpl(32)), this.$iconSize, 0.0f, 2, null);
        Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
        final Function0<Unit> function03 = this.$onBackAction;
        Function0<Unit> function04 = this.$onCloseAction;
        float f7 = this.$iconToTextPadding;
        AnnotatedString annotatedString2 = this.$title;
        BottomSheetTitleStyle bottomSheetTitleStyle2 = this.$titleStyle;
        float f8 = this.$iconSize;
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer, 54);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m327heightInVpY3zN4$default);
        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        boolean z5 = function03 != null;
        boolean z6 = function04 != null;
        composer.startReplaceGroup(-1000591728);
        if (z5) {
            f6 = f8;
            bottomSheetTitleStyle = bottomSheetTitleStyle2;
            annotatedString = annotatedString2;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, 0.0f, f7, 0.0f, 11, null);
            NavigationButtonType navigationButtonType = NavigationButtonType.Back;
            composer.startReplaceGroup(-1000585126);
            boolean changed = composer.changed(function03);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.reusable.bottomsheet.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$6$lambda$1$lambda$0;
                        invoke$lambda$6$lambda$1$lambda$0 = BottomSheetHeaderKt$BottomSheetHeader$2.invoke$lambda$6$lambda$1$lambda$0(Function0.this);
                        return invoke$lambda$6$lambda$1$lambda$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            i6 = 0;
            f5 = f7;
            function0 = function04;
            NavigationButtonKt.NavigationButton(navigationButtonType, m315paddingqDBjuR0$default, (Function0) rememberedValue, composer, 54, 0);
        } else {
            f5 = f7;
            f6 = f8;
            bottomSheetTitleStyle = bottomSheetTitleStyle2;
            annotatedString = annotatedString2;
            i6 = 0;
            function0 = function04;
        }
        composer.endReplaceGroup();
        if (annotatedString != null) {
            composer.startReplaceGroup(-953265439);
            Function0<Unit> function05 = function0;
            boolean z7 = i6;
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null);
            composer.startReplaceGroup(-1000577779);
            Object rememberedValue2 = composer.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: dk.molslinjen.ui.views.reusable.bottomsheet.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit invoke$lambda$6$lambda$3$lambda$2;
                        invoke$lambda$6$lambda$3$lambda$2 = BottomSheetHeaderKt$BottomSheetHeader$2.invoke$lambda$6$lambda$3$lambda$2((SemanticsPropertyReceiver) obj);
                        return invoke$lambda$6$lambda$3$lambda$2;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            companion = companion2;
            BottomSheetHeaderKt.m3401TitleViewWHejsw(rowScopeInstance, SemanticsModifierKt.semantics$default(weight$default, z7, (Function1) rememberedValue2, 1, null), annotatedString, bottomSheetTitleStyle, Dp.m2599constructorimpl(f6 + f5), z5, z6, composer, 24582);
            composer.endReplaceGroup();
            function02 = function05;
        } else {
            companion = companion2;
            composer.startReplaceGroup(-952825828);
            function02 = function0;
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), composer, i6);
            composer.endReplaceGroup();
        }
        composer.startReplaceGroup(-1000564747);
        if (z6) {
            Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(companion, f5, 0.0f, 0.0f, 0.0f, 14, null);
            NavigationButtonType navigationButtonType2 = NavigationButtonType.Close;
            composer.startReplaceGroup(-1000558021);
            boolean changed2 = composer.changed(function02);
            Object rememberedValue3 = composer.rememberedValue();
            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: dk.molslinjen.ui.views.reusable.bottomsheet.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$6$lambda$5$lambda$4;
                        invoke$lambda$6$lambda$5$lambda$4 = BottomSheetHeaderKt$BottomSheetHeader$2.invoke$lambda$6$lambda$5$lambda$4(Function0.this);
                        return invoke$lambda$6$lambda$5$lambda$4;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            composer.endReplaceGroup();
            NavigationButtonKt.NavigationButton(navigationButtonType2, m315paddingqDBjuR0$default2, (Function0) rememberedValue3, composer, 54, 0);
        }
        composer.endReplaceGroup();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
