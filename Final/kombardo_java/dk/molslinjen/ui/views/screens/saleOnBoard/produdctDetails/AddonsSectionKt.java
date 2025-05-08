package dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProductAddOn;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProductAddOnOption;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.extensions.domain.PriceFormatExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.LabeledSelectionControlKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlStyle;
import dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.AddonsSectionKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aJ\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010\n\u001a\u00020\u000b\u001a;\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000b2\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"addonsSection", BuildConfig.FLAVOR, "Landroidx/compose/foundation/lazy/LazyListScope;", "addons", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProductAddOn;", "selectedAddonOptions", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProductAddOnOption;", "selectOption", "Lkotlin/Function2;", "enabled", BuildConfig.FLAVOR, "AddonRow", "option", "isSelected", "Lkotlin/Function1;", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProductAddOnOption;ZLkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AddonsSectionKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void AddonRow(final SaleOnBoardProductAddOnOption saleOnBoardProductAddOnOption, final boolean z5, final Function1<? super SaleOnBoardProductAddOnOption, Unit> function1, final boolean z6, Composer composer, final int i5) {
        int i6;
        String stringResource;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1814456467);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(saleOnBoardProductAddOnOption) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(z6) ? 2048 : 1024;
        }
        int i7 = i6;
        if ((i7 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1814456467, i7, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.AddonRow (AddonsSection.kt:98)");
            }
            if (saleOnBoardProductAddOnOption.getPrice().getValue() > 0) {
                startRestartGroup.startReplaceGroup(698982115);
                stringResource = "+ " + PriceWithCurrency.formattedValue$default(saleOnBoardProductAddOnOption.getPrice(), false, 1, null) + " " + PriceFormatExtensionsKt.getCurrencyFormatted(saleOnBoardProductAddOnOption.getPrice(), (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()));
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(699096350);
                stringResource = StringResources_androidKt.stringResource(R.string.common_free, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            }
            final String str = stringResource;
            Modifier.Companion companion = Modifier.INSTANCE;
            startRestartGroup.startReplaceGroup(992388742);
            int i8 = i7 & 896;
            boolean changedInstance = (i8 == 256) | ((i7 & 112) == 32) | startRestartGroup.changedInstance(saleOnBoardProductAddOnOption);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: j4.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit AddonRow$lambda$1$lambda$0;
                        AddonRow$lambda$1$lambda$0 = AddonsSectionKt.AddonRow$lambda$1$lambda$0(Function1.this, z5, saleOnBoardProductAddOnOption, ((Boolean) obj).booleanValue());
                        return AddonRow$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m455toggleableXHw0xAI$default = ToggleableKt.m455toggleableXHw0xAI$default(companion, z5, false, null, (Function1) rememberedValue, 6, null);
            startRestartGroup.startReplaceGroup(992393028);
            boolean changedInstance2 = startRestartGroup.changedInstance(saleOnBoardProductAddOnOption) | startRestartGroup.changed(str);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: j4.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit AddonRow$lambda$3$lambda$2;
                        AddonRow$lambda$3$lambda$2 = AddonsSectionKt.AddonRow$lambda$3$lambda$2(SaleOnBoardProductAddOnOption.this, str, (SemanticsPropertyReceiver) obj);
                        return AddonRow$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            float f5 = 16;
            Modifier m314paddingqDBjuR0 = PaddingKt.m314paddingqDBjuR0(SemanticsModifierKt.clearAndSetSemantics(m455toggleableXHw0xAI$default, (Function1) rememberedValue2), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(24), Dp.m2599constructorimpl(f5));
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m314paddingqDBjuR0);
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
            Modifier weight$default = RowScope.weight$default(RowScopeInstance.INSTANCE, companion, 1.0f, false, 2, null);
            String name = saleOnBoardProductAddOnOption.getName();
            SelectionControlStyle selectionControlStyle = SelectionControlStyle.RadioButton;
            startRestartGroup.startReplaceGroup(-678199417);
            boolean changedInstance3 = startRestartGroup.changedInstance(saleOnBoardProductAddOnOption) | (i8 == 256);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: j4.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit AddonRow$lambda$6$lambda$5$lambda$4;
                        AddonRow$lambda$6$lambda$5$lambda$4 = AddonsSectionKt.AddonRow$lambda$6$lambda$5$lambda$4(Function1.this, saleOnBoardProductAddOnOption, ((Boolean) obj).booleanValue());
                        return AddonRow$lambda$6$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            LabeledSelectionControlKt.LabeledSelectionControl(weight$default, name, z5, (Function1) rememberedValue3, null, z6, null, selectionControlStyle, false, startRestartGroup, ((i7 << 3) & 896) | 12582912 | (458752 & (i7 << 6)), 336);
            TextKt.m940Text4IGK_g(str, PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null), AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 432, 1572864, 65528);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: j4.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AddonRow$lambda$7;
                    AddonRow$lambda$7 = AddonsSectionKt.AddonRow$lambda$7(SaleOnBoardProductAddOnOption.this, z5, function1, z6, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return AddonRow$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddonRow$lambda$1$lambda$0(Function1 function1, boolean z5, SaleOnBoardProductAddOnOption saleOnBoardProductAddOnOption, boolean z6) {
        if (z5) {
            saleOnBoardProductAddOnOption = null;
        }
        function1.invoke(saleOnBoardProductAddOnOption);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddonRow$lambda$3$lambda$2(SaleOnBoardProductAddOnOption saleOnBoardProductAddOnOption, String str, SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, saleOnBoardProductAddOnOption.getName() + " " + str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddonRow$lambda$6$lambda$5$lambda$4(Function1 function1, SaleOnBoardProductAddOnOption saleOnBoardProductAddOnOption, boolean z5) {
        if (!z5) {
            saleOnBoardProductAddOnOption = null;
        }
        function1.invoke(saleOnBoardProductAddOnOption);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddonRow$lambda$7(SaleOnBoardProductAddOnOption saleOnBoardProductAddOnOption, boolean z5, Function1 function1, boolean z6, int i5, Composer composer, int i6) {
        AddonRow(saleOnBoardProductAddOnOption, z5, function1, z6, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void addonsSection(LazyListScope lazyListScope, List<SaleOnBoardProductAddOn> addons, List<SaleOnBoardProductAddOnOption> selectedAddonOptions, Function2<? super SaleOnBoardProductAddOn, ? super SaleOnBoardProductAddOnOption, Unit> selectOption, boolean z5) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(addons, "addons");
        Intrinsics.checkNotNullParameter(selectedAddonOptions, "selectedAddonOptions");
        Intrinsics.checkNotNullParameter(selectOption, "selectOption");
        if (addons.isEmpty()) {
            return;
        }
        LazyListScope.item$default(lazyListScope, null, null, ComposableSingletons$AddonsSectionKt.INSTANCE.m3535getLambda1$app_kombardoProd(), 3, null);
        Iterator<T> it = addons.iterator();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (!it.hasNext()) {
                return;
            }
            i5 = i6 + 1;
            LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(1149239710, true, new AddonsSectionKt$addonsSection$1(i6, (SaleOnBoardProductAddOn) it.next(), selectedAddonOptions, selectOption, z5)), 3, null);
        }
    }
}
