package dk.molslinjen.ui.views.screens.profile.currencies;

import android.content.Context;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlStyle;
import dk.molslinjen.ui.views.screens.profile.currencies.CurrenciesScreenKt;
import dk.molslinjen.ui.views.screens.profile.currencies.CurrenciesViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a9\u0010\r\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\n\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/currencies/CurrenciesViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "CurrenciesScreen", "(Ldk/molslinjen/ui/views/screens/profile/currencies/CurrenciesViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/shared/CurrencyType;", "currencies", "selectedCurrency", "Lkotlin/Function1;", "selectCurrency", "CurrenciesContent", "(Ljava/util/List;Ldk/molslinjen/domain/model/shared/CurrencyType;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CurrenciesScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void CurrenciesContent(final List<? extends CurrencyType> list, final CurrencyType currencyType, final Function1<? super CurrencyType, Unit> function1, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-2067886946);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(list) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(currencyType) ? 32 : 16;
        }
        int i7 = 256;
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        int i8 = i6;
        if ((i8 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2067886946, i8, -1, "dk.molslinjen.ui.views.screens.profile.currencies.CurrenciesContent (CurrenciesScreen.kt:59)");
            }
            startRestartGroup.startReplaceGroup(248699551);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final CurrencyType currencyType2 = (CurrencyType) it.next();
                int i9 = i8;
                Iterator it2 = it;
                int i10 = i7;
                HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, startRestartGroup, 0, 15);
                Modifier.Companion companion = Modifier.INSTANCE;
                startRestartGroup.startReplaceGroup(-1469755184);
                int i11 = i9 & 896;
                boolean changed = (i11 == i10) | startRestartGroup.changed(currencyType2);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: J3.b
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CurrenciesContent$lambda$10$lambda$5$lambda$4;
                            CurrenciesContent$lambda$10$lambda$5$lambda$4 = CurrenciesScreenKt.CurrenciesContent$lambda$10$lambda$5$lambda$4(Function1.this, currencyType2);
                            return CurrenciesContent$lambda$10$lambda$5$lambda$4;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(ClickableKt.m122clickableXHw0xAI$default(companion, false, null, null, (Function0) rememberedValue, 7, null), Dp.m2599constructorimpl(24), Dp.m2599constructorimpl(16));
                Alignment.Companion companion2 = Alignment.INSTANCE;
                Alignment.Vertical centerVertically = companion2.getCenterVertically();
                Arrangement arrangement = Arrangement.INSTANCE;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), startRestartGroup, 0);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
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
                Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                Composer composer3 = startRestartGroup;
                TextKt.m940Text4IGK_g(currencyType2.name(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), composer3, 0, 1572864, 65534);
                TextKt.m940Text4IGK_g(currencyType2.name(), null, AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer3, 384, 1572864, 65530);
                composer3.endNode();
                SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), composer3, 0);
                boolean z5 = currencyType == currencyType2;
                composer3.startReplaceGroup(178866131);
                boolean changed2 = (i11 == 256) | composer3.changed(currencyType2);
                Object rememberedValue2 = composer3.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: J3.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit CurrenciesContent$lambda$10$lambda$9$lambda$8$lambda$7;
                            CurrenciesContent$lambda$10$lambda$9$lambda$8$lambda$7 = CurrenciesScreenKt.CurrenciesContent$lambda$10$lambda$9$lambda$8$lambda$7(Function1.this, currencyType2, ((Boolean) obj).booleanValue());
                            return CurrenciesContent$lambda$10$lambda$9$lambda$8$lambda$7;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue2);
                }
                composer3.endReplaceGroup();
                SelectionControlKt.SelectionControl(null, z5, (Function1) rememberedValue2, null, false, null, SelectionControlStyle.RadioButton, false, composer3, 1572864, 185);
                composer3.endNode();
                i7 = 256;
                startRestartGroup = composer3;
                it = it2;
                i8 = i9;
            }
            composer2 = startRestartGroup;
            composer2.endReplaceGroup();
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer2, 0, 15);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: J3.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CurrenciesContent$lambda$11;
                    CurrenciesContent$lambda$11 = CurrenciesScreenKt.CurrenciesContent$lambda$11(list, currencyType, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CurrenciesContent$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CurrenciesContent$lambda$10$lambda$5$lambda$4(Function1 function1, CurrencyType currencyType) {
        function1.invoke(currencyType);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CurrenciesContent$lambda$10$lambda$9$lambda$8$lambda$7(Function1 function1, CurrencyType currencyType, boolean z5) {
        function1.invoke(currencyType);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CurrenciesContent$lambda$11(List list, CurrencyType currencyType, Function1 function1, int i5, Composer composer, int i6) {
        CurrenciesContent(list, currencyType, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void CurrenciesScreen(final CurrenciesViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(459445504);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(459445504, i6, -1, "dk.molslinjen.ui.views.screens.profile.currencies.CurrenciesScreen (CurrenciesScreen.kt:33)");
            }
            CurrenciesViewModel.ViewState viewState = (CurrenciesViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            CurrencyType currencyType = (CurrencyType) SnapshotStateKt.collectAsState(viewModel.getSelectedCurrencyState(), null, startRestartGroup, 0, 1).getValue();
            ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
            Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), rememberScrollState, false, null, false, 14, null);
            String stringResource = StringResources_androidKt.stringResource(R.string.profile_currenciesTitle, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(579440039);
            int i7 = i6 & 112;
            boolean z5 = i7 == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new CurrenciesScreenKt$CurrenciesScreen$1$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(579441607);
            boolean z6 = i7 == 32;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new CurrenciesScreenKt$CurrenciesScreen$2$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-23824051, true, new CurrenciesScreenKt$CurrenciesScreen$3(viewState, currencyType, viewModel, context), startRestartGroup, 54);
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(verticalScroll$default, 0.0f, stringResource, null, 0L, function0, (Function0) rememberedValue2, rememberScrollState, null, rememberComposableLambda, startRestartGroup, 805306368, 282);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: J3.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CurrenciesScreen$lambda$3;
                    CurrenciesScreen$lambda$3 = CurrenciesScreenKt.CurrenciesScreen$lambda$3(CurrenciesViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CurrenciesScreen$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CurrenciesScreen$lambda$3(CurrenciesViewModel currenciesViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        CurrenciesScreen(currenciesViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
