package dk.molslinjen.ui.views.reusable.snackbar;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.core.snackbar.SnackbarStyle;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.TypographyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class StyledSnackbarKt$StyledSnackbar$2 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ String $actionLabel;
    final /* synthetic */ Function0<Unit> $dismiss;
    final /* synthetic */ String $message;
    final /* synthetic */ Function0<Unit> $performAction;
    final /* synthetic */ boolean $showDismiss;
    final /* synthetic */ CornerBasedShape $snackbarShape;
    final /* synthetic */ SnackbarStyle $snackbarStyle;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StyledSnackbarKt$StyledSnackbar$2(SnackbarStyle snackbarStyle, CornerBasedShape cornerBasedShape, String str, String str2, Function0<Unit> function0, Function0<Unit> function02, boolean z5) {
        this.$snackbarStyle = snackbarStyle;
        this.$snackbarShape = cornerBasedShape;
        this.$message = str;
        this.$actionLabel = str2;
        this.$performAction = function0;
        this.$dismiss = function02;
        this.$showDismiss = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2$lambda$1(Function0 function0, Function0 function02) {
        function0.invoke();
        function02.invoke();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        boolean z5;
        Function0<Unit> function0;
        Function0<Unit> function02;
        int i6;
        String str;
        String str2;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-45810579, i5, -1, "dk.molslinjen.ui.views.reusable.snackbar.StyledSnackbar.<anonymous> (StyledSnackbar.kt:51)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier m324defaultMinSizeVpY3zN4$default = SizeKt.m324defaultMinSizeVpY3zN4$default(BackgroundKt.m103backgroundbw27NRU(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), this.$snackbarStyle.getContainerColor(), this.$snackbarShape), 0.0f, Dp.m2599constructorimpl(56), 1, null);
        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
        final SnackbarStyle snackbarStyle = this.$snackbarStyle;
        String str3 = this.$message;
        String str4 = this.$actionLabel;
        Function0<Unit> function03 = this.$performAction;
        Function0<Unit> function04 = this.$dismiss;
        boolean z6 = this.$showDismiss;
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m324defaultMinSizeVpY3zN4$default);
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
        float f5 = 16;
        SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer, 6);
        Integer leftIcon = snackbarStyle.getLeftIcon();
        composer.startReplaceGroup(-1446725916);
        if (leftIcon == null) {
            str = str4;
            str2 = str3;
            z5 = z6;
            function0 = function04;
            function02 = function03;
            i6 = 8;
        } else {
            z5 = z6;
            function0 = function04;
            function02 = function03;
            i6 = 8;
            str = str4;
            str2 = str3;
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(leftIcon.intValue(), composer, 0), Accessibility.INSTANCE.getSkip(), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 11, null), snackbarStyle.getIconsTint(), composer, 384, 0);
        }
        composer.endReplaceGroup();
        TextKt.m940Text4IGK_g(str2, RowScope.weight$default(rowScopeInstance, PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(i6), Dp.m2599constructorimpl(f5), 1, null), 1.0f, false, 2, null), snackbarStyle.getTextColor(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer, 0, 1572864, 65528);
        composer.startReplaceGroup(-1446706798);
        if (str != null) {
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 11, null);
            composer.startReplaceGroup(-1446701753);
            final Function0<Unit> function05 = function02;
            final Function0<Unit> function06 = function0;
            boolean changed = composer.changed(function05) | composer.changed(function06);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.reusable.snackbar.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$3$lambda$2$lambda$1;
                        invoke$lambda$3$lambda$2$lambda$1 = StyledSnackbarKt$StyledSnackbar$2.invoke$lambda$3$lambda$2$lambda$1(Function0.this, function06);
                        return invoke$lambda$3$lambda$2$lambda$1;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            function0 = function06;
            TextKt.m940Text4IGK_g(str, ClickableKt.m122clickableXHw0xAI$default(m315paddingqDBjuR0$default, false, null, null, (Function0) rememberedValue, 7, null), snackbarStyle.getTextColor(), 0L, null, null, null, 0L, TextDecoration.INSTANCE.getUnderline(), null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer, 100663296, 1572864, 65272);
        }
        composer.endReplaceGroup();
        composer.startReplaceGroup(-1446690413);
        if (z5) {
            IconButtonKt.IconButton(function0, null, false, null, null, ComposableLambdaKt.rememberComposableLambda(1007405754, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.snackbar.StyledSnackbarKt$StyledSnackbar$2$1$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    if ((i7 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1007405754, i7, -1, "dk.molslinjen.ui.views.reusable.snackbar.StyledSnackbar.<anonymous>.<anonymous>.<anonymous> (StyledSnackbar.kt:94)");
                    }
                    IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_close, composer2, 6), Accessibility.INSTANCE.getSkip(), (Modifier) null, SnackbarStyle.this.getIconsTint(), composer2, 0, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer, 54), composer, 196608, 30);
        }
        composer.endReplaceGroup();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
