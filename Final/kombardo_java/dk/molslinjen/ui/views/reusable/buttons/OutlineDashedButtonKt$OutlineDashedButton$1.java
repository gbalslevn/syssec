package dk.molslinjen.ui.views.reusable.buttons;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.ui.theme.TypographyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class OutlineDashedButtonKt$OutlineDashedButton$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ long $borderColor;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ float $cornerRadius;
    final /* synthetic */ int $icon;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ Stroke $stroke;
    final /* synthetic */ String $title;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OutlineDashedButtonKt$OutlineDashedButton$1(Modifier modifier, float f5, Function0<Unit> function0, long j5, long j6, Stroke stroke, int i5, long j7, String str) {
        this.$modifier = modifier;
        this.$cornerRadius = f5;
        this.$onClick = function0;
        this.$containerColor = j5;
        this.$borderColor = j6;
        this.$stroke = stroke;
        this.$icon = i5;
        this.$contentColor = j7;
        this.$title = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$5$lambda$3$lambda$2(float f5, long j5, Stroke stroke, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        DrawScope.m1700drawRoundRectuAw5IA$default(Canvas, j5, 0L, 0L, CornerRadiusKt.CornerRadius(f5, f5), stroke, 0.0f, null, 0, 230, null);
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
            ComposerKt.traceEventStart(-292004572, i5, -1, "dk.molslinjen.ui.views.reusable.buttons.OutlineDashedButton.<anonymous> (OutlineDashedButton.kt:64)");
        }
        Modifier clip = ClipKt.clip(IntrinsicKt.height(this.$modifier, IntrinsicSize.Max), RoundedCornerShapeKt.RoundedCornerShape(this.$cornerRadius));
        composer.startReplaceGroup(88548063);
        boolean changed = composer.changed(this.$onClick);
        final Function0<Unit> function0 = this.$onClick;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.reusable.buttons.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = OutlineDashedButtonKt$OutlineDashedButton$1.invoke$lambda$1$lambda$0(Function0.this);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(ClickableKt.m122clickableXHw0xAI$default(clip, false, null, null, (Function0) rememberedValue, 7, null), this.$containerColor, null, 2, null);
        Alignment.Companion companion = Alignment.INSTANCE;
        Alignment center = companion.getCenter();
        final float f5 = this.$cornerRadius;
        final long j5 = this.$borderColor;
        final Stroke stroke = this.$stroke;
        int i6 = this.$icon;
        long j6 = this.$contentColor;
        String str = this.$title;
        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m104backgroundbw27NRU$default);
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
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        Modifier.Companion companion3 = Modifier.INSTANCE;
        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null);
        composer.startReplaceGroup(175962026);
        boolean changed2 = composer.changed(f5) | composer.changed(j5) | composer.changedInstance(stroke);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: dk.molslinjen.ui.views.reusable.buttons.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$5$lambda$3$lambda$2;
                    invoke$lambda$5$lambda$3$lambda$2 = OutlineDashedButtonKt$OutlineDashedButton$1.invoke$lambda$5$lambda$3$lambda$2(f5, j5, stroke, (DrawScope) obj);
                    return invoke$lambda$5$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        CanvasKt.Canvas(fillMaxSize$default, (Function1) rememberedValue2, composer, 6);
        float f6 = 16;
        Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion3, 0.0f, Dp.m2599constructorimpl(f6), 1, null);
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), companion.getCenterVertically(), composer, 54);
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, m313paddingVpY3zN4$default);
        Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
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
        Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
        if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion2.getSetModifier());
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(i6, composer, 0), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion3, Dp.m2599constructorimpl(f6)), j6, composer, 384, 0);
        TextKt.m940Text4IGK_g(str, PaddingKt.m315paddingqDBjuR0$default(companion3, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null), j6, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer, 48, 1572864, 65528);
        composer.endNode();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
