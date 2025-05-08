package dk.molslinjen.ui.views.reusable.input.licensePlate;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.extensions.ColorExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.input.licensePlate.LicensePlateIndicatorViewKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/unit/Dp;", "height", BuildConfig.FLAVOR, "LicensePlateIndicatorView-rCkNIVA", "(Landroidx/compose/ui/unit/Dp;Landroidx/compose/runtime/Composer;I)V", "LicensePlateIndicatorView", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class LicensePlateIndicatorViewKt {
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
    
        if (r2 == null) goto L22;
     */
    /* renamed from: LicensePlateIndicatorView-rCkNIVA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3418LicensePlateIndicatorViewrCkNIVA(final Dp dp, Composer composer, final int i5) {
        int i6;
        Modifier height;
        Composer startRestartGroup = composer.startRestartGroup(-637374882);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(dp) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-637374882, i6, -1, "dk.molslinjen.ui.views.reusable.input.licensePlate.LicensePlateIndicatorView (LicensePlateIndicatorView.kt:19)");
            }
            if (dp != null) {
                height = SizeKt.m325height3ABfNKs(Modifier.INSTANCE, dp.getValue());
            }
            height = IntrinsicKt.height(Modifier.INSTANCE, IntrinsicSize.Min);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Horizontal start = arrangement.getStart();
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, height);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
            AppColor appColor = AppColor.INSTANCE;
            Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(SizeKt.fillMaxHeight$default(BackgroundKt.m104backgroundbw27NRU$default(companion3, appColor.m3256getBrandBlue30d7_KjU(), null, 2, null), 0.0f, 1, null), Dp.m2599constructorimpl(16), Dp.m2599constructorimpl(8));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getCenter(), companion.getStart(), startRestartGroup, 6);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            float f5 = 4;
            float f6 = 18;
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_european_stars, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(companion3, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 7, null), Dp.m2599constructorimpl(f6)), null, null, 0.0f, null, startRestartGroup, 384, 120);
            BoxKt.Box(BackgroundKt.m103backgroundbw27NRU(SizeKt.m333sizeVpY3zN4(companion3, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(7)), ColorExtensionsKt.m3249withAlphaDxMtmZc(appColor.m3281getWhite0d7_KjU(), 0.15f), RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(2))), startRestartGroup, 0);
            startRestartGroup.endNode();
            BoxKt.Box(BackgroundKt.background$default(SizeKt.fillMaxHeight$default(SizeKt.m336width3ABfNKs(companion3, Dp.m2599constructorimpl(f5)), 0.0f, 1, null), Brush.Companion.m1466verticalGradient8A3gB4$default(Brush.INSTANCE, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.m1481boximpl(appColor.m3267getGrey40d7_KjU())), TuplesKt.to(Float.valueOf(1.0f), Color.m1481boximpl(appColor.m3268getGrey50d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), startRestartGroup, 6);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: f2.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit LicensePlateIndicatorView_rCkNIVA$lambda$3;
                    LicensePlateIndicatorView_rCkNIVA$lambda$3 = LicensePlateIndicatorViewKt.LicensePlateIndicatorView_rCkNIVA$lambda$3(Dp.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return LicensePlateIndicatorView_rCkNIVA$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LicensePlateIndicatorView_rCkNIVA$lambda$3(Dp dp, int i5, Composer composer, int i6) {
        m3418LicensePlateIndicatorViewrCkNIVA(dp, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
