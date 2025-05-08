package dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProductAddOn;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProductAddOnOption;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AddonsSectionKt$addonsSection$1 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ SaleOnBoardProductAddOn $addon;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ int $index;
    final /* synthetic */ Function2<SaleOnBoardProductAddOn, SaleOnBoardProductAddOnOption, Unit> $selectOption;
    final /* synthetic */ List<SaleOnBoardProductAddOnOption> $selectedAddonOptions;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public AddonsSectionKt$addonsSection$1(int i5, SaleOnBoardProductAddOn saleOnBoardProductAddOn, List<SaleOnBoardProductAddOnOption> list, Function2<? super SaleOnBoardProductAddOn, ? super SaleOnBoardProductAddOnOption, Unit> function2, boolean z5) {
        this.$index = i5;
        this.$addon = saleOnBoardProductAddOn;
        this.$selectedAddonOptions = list;
        this.$selectOption = function2;
        this.$enabled = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2$lambda$1(Function2 function2, SaleOnBoardProductAddOn saleOnBoardProductAddOn, SaleOnBoardProductAddOnOption saleOnBoardProductAddOnOption) {
        function2.invoke(saleOnBoardProductAddOn, saleOnBoardProductAddOnOption);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
        invoke(lazyItemScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope item, Composer composer, int i5) {
        boolean z5;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(717510426, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.addonsSection.<anonymous> (AddonsSection.kt:54)");
        }
        composer.startReplaceGroup(1347137395);
        if (this.$index > 0) {
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(24)), composer, 6);
        }
        composer.endReplaceGroup();
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m2599constructorimpl(24), 0.0f, 2, null);
        float m2599constructorimpl = Dp.m2599constructorimpl(1);
        AppColor appColor = AppColor.INSTANCE;
        Modifier clip = ClipKt.clip(BorderKt.m108borderxT4_qwU(m313paddingVpY3zN4$default, m2599constructorimpl, appColor.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), ThemeShapesKt.getThemeShapes().getMedium());
        SaleOnBoardProductAddOn saleOnBoardProductAddOn = this.$addon;
        List<SaleOnBoardProductAddOnOption> list = this.$selectedAddonOptions;
        Function2<SaleOnBoardProductAddOn, SaleOnBoardProductAddOnOption, Unit> function2 = this.$selectOption;
        boolean z6 = this.$enabled;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, clip);
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
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        Function2<SaleOnBoardProductAddOn, SaleOnBoardProductAddOnOption, Unit> function22 = function2;
        SaleOnBoardProductAddOn saleOnBoardProductAddOn2 = saleOnBoardProductAddOn;
        TextKt.m940Text4IGK_g(saleOnBoardProductAddOn.getTitle(), PaddingKt.m312paddingVpY3zN4(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), appColor.m3269getGrey60d7_KjU(), null, 2, null), Dp.m2599constructorimpl(16), Dp.m2599constructorimpl(8)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer, 48, 1572864, 65532);
        composer.startReplaceGroup(2025589000);
        for (SaleOnBoardProductAddOnOption saleOnBoardProductAddOnOption : saleOnBoardProductAddOn2.getOptions()) {
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer, 0, 15);
            List<SaleOnBoardProductAddOnOption> list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((SaleOnBoardProductAddOnOption) it.next()).getId(), saleOnBoardProductAddOnOption.getId())) {
                        z5 = true;
                        break;
                    }
                }
            }
            z5 = false;
            composer.startReplaceGroup(2025598601);
            final Function2<SaleOnBoardProductAddOn, SaleOnBoardProductAddOnOption, Unit> function23 = function22;
            final SaleOnBoardProductAddOn saleOnBoardProductAddOn3 = saleOnBoardProductAddOn2;
            boolean changed = composer.changed(function23) | composer.changedInstance(saleOnBoardProductAddOn3);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit invoke$lambda$3$lambda$2$lambda$1;
                        invoke$lambda$3$lambda$2$lambda$1 = AddonsSectionKt$addonsSection$1.invoke$lambda$3$lambda$2$lambda$1(Function2.this, saleOnBoardProductAddOn3, (SaleOnBoardProductAddOnOption) obj);
                        return invoke$lambda$3$lambda$2$lambda$1;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceGroup();
            AddonsSectionKt.AddonRow(saleOnBoardProductAddOnOption, z5, (Function1) rememberedValue, z6, composer, 0);
            function22 = function23;
            saleOnBoardProductAddOn2 = saleOnBoardProductAddOn3;
        }
        composer.endReplaceGroup();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
