package dk.molslinjen.ui.views.screens.booking.passengers;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.booking.passengers.CheckoutPassengerPortraitTemplateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {BuildConfig.FLAVOR, "ageGroup", BuildConfig.FLAVOR, "CheckoutPassengerPortraitTemplate", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CheckoutPassengerPortraitTemplateKt {
    public static final void CheckoutPassengerPortraitTemplate(final String str, Composer composer, final int i5) {
        int i6;
        float f5;
        Composer composer2;
        Modifier.Companion companion;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(-1692126174);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1692126174, i6, -1, "dk.molslinjen.ui.views.screens.booking.passengers.CheckoutPassengerPortraitTemplate (CheckoutPassengerPortraitTemplate.kt:25)");
            }
            float dpToPx = ComposeExtensionsKt.dpToPx(6, startRestartGroup, 6);
            final float dpToPx2 = ComposeExtensionsKt.dpToPx(4, startRestartGroup, 6);
            final Stroke stroke = new Stroke(ComposeExtensionsKt.dpToPx(2, startRestartGroup, 6), 0.0f, StrokeCap.INSTANCE.m1608getRoundKaPHkGw(), 0, PathEffect.Companion.dashPathEffect$default(PathEffect.INSTANCE, new float[]{dpToPx, dpToPx}, 0.0f, 2, null), 10, null);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            float f6 = 5;
            float f7 = 16;
            Modifier m333sizeVpY3zN4 = SizeKt.m333sizeVpY3zN4(ClipKt.clip(PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m312paddingVpY3zN4(companion2, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(9)), 0.0f, Dp.m2599constructorimpl(f7), 0.0f, Dp.m2599constructorimpl(f6), 5, null), RoundedCornerShapeKt.RoundedCornerShape(dpToPx2)), Dp.m2599constructorimpl(74), Dp.m2599constructorimpl(104));
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m333sizeVpY3zN4);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion4.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null);
            startRestartGroup.startReplaceGroup(480838033);
            boolean changed = startRestartGroup.changed(dpToPx2) | startRestartGroup.changedInstance(stroke);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: U2.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit CheckoutPassengerPortraitTemplate$lambda$5$lambda$1$lambda$0;
                        CheckoutPassengerPortraitTemplate$lambda$5$lambda$1$lambda$0 = CheckoutPassengerPortraitTemplateKt.CheckoutPassengerPortraitTemplate$lambda$5$lambda$1$lambda$0(dpToPx2, stroke, (DrawScope) obj);
                        return CheckoutPassengerPortraitTemplate$lambda$5$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            CanvasKt.Canvas(fillMaxSize$default, (Function1) rememberedValue, startRestartGroup, 6);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion3.getCenterHorizontally(), startRestartGroup, 48);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
            Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            if (str != null) {
                startRestartGroup.startReplaceGroup(1001423493);
                f5 = f7;
                TextKt.m940Text4IGK_g(str, PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), 0.0f, Dp.m2599constructorimpl(4), 0.0f, Dp.m2599constructorimpl(8), 5, null), AppColor.INSTANCE.m3267getGrey40d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubSmallBold(), startRestartGroup, (i6 & 14) | 432, 1572864, 65016);
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                companion = companion2;
                i7 = 6;
            } else {
                f5 = f7;
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(1001786317);
                companion = companion2;
                i7 = 6;
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(12)), composer2, 6);
                composer2.endReplaceGroup();
            }
            Modifier m331size3ABfNKs = SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(32));
            Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.icon_profile, composer2, i7);
            String skip = Accessibility.INSTANCE.getSkip();
            AppColor appColor = AppColor.INSTANCE;
            IconKt.m857Iconww6aTOc(painterResource, skip, m331size3ABfNKs, appColor.m3267getGrey40d7_KjU(), composer2, 3456, 0);
            float f8 = 8;
            Modifier m103backgroundbw27NRU = BackgroundKt.m103backgroundbw27NRU(PaddingKt.m313paddingVpY3zN4$default(SizeKt.m325height3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f8), 0.0f, 0.0f, 13, null), 0.0f, 1, null), Dp.m2599constructorimpl(f8)), Dp.m2599constructorimpl(f5), 0.0f, 2, null), appColor.m3267getGrey40d7_KjU(), ThemeShapesKt.getThemeShapes().getSmall());
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, m103backgroundbw27NRU);
            Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor3);
            } else {
                composer2.useNode();
            }
            Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer2);
            Updater.m1227setimpl(m1226constructorimpl3, maybeCachedBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
            composer2.endNode();
            Modifier m103backgroundbw27NRU2 = BackgroundKt.m103backgroundbw27NRU(PaddingKt.m313paddingVpY3zN4$default(SizeKt.m325height3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f8), 0.0f, 0.0f, 13, null), 0.0f, 1, null), Dp.m2599constructorimpl(f8)), Dp.m2599constructorimpl(10), 0.0f, 2, null), appColor.m3267getGrey40d7_KjU(), ThemeShapesKt.getThemeShapes().getSmall());
            MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, m103backgroundbw27NRU2);
            Function0<ComposeUiNode> constructor4 = companion4.getConstructor();
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor4);
            } else {
                composer2.useNode();
            }
            Composer m1226constructorimpl4 = Updater.m1226constructorimpl(composer2);
            Updater.m1227setimpl(m1226constructorimpl4, maybeCachedBoxMeasurePolicy3, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion4.getSetModifier());
            composer2.endNode();
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, companion, 1.0f, false, 2, null), composer2, 0);
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: U2.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CheckoutPassengerPortraitTemplate$lambda$6;
                    CheckoutPassengerPortraitTemplate$lambda$6 = CheckoutPassengerPortraitTemplateKt.CheckoutPassengerPortraitTemplate$lambda$6(str, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CheckoutPassengerPortraitTemplate$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutPassengerPortraitTemplate$lambda$5$lambda$1$lambda$0(float f5, Stroke stroke, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        DrawScope.m1700drawRoundRectuAw5IA$default(Canvas, AppColor.INSTANCE.m3267getGrey40d7_KjU(), 0L, 0L, CornerRadiusKt.CornerRadius(f5, f5), stroke, 0.0f, null, 0, 230, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutPassengerPortraitTemplate$lambda$6(String str, int i5, Composer composer, int i6) {
        CheckoutPassengerPortraitTemplate(str, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
