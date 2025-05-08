package dk.molslinjen.ui.views.screens.booking.passengers;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.UriHandler;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.generated.destinations.NationalitySelectionScreenDestination;
import com.ramcosta.composedestinations.result.OpenResultRecipientKt;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.buttons.ButtonConfig;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import dk.molslinjen.ui.views.reusable.clickableText.ClickableTextData;
import dk.molslinjen.ui.views.reusable.clickableText.ClickableTextKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlStyle;
import dk.molslinjen.ui.views.screens.booking.passengers.CreateYourSelfAsPassengerViewKt;
import dk.molslinjen.ui.views.screens.booking.passengers.CreateYourSelfAsPassengerViewModel;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.ProfilePassengerInputContentKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aU\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001ay\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014H\u0003¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/passengers/CreateYourSelfAsPassengerViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/NationalitySelectionScreenDestination;", "Ljava/util/Locale;", "nationalityResultRecipient", "Lkotlin/Function0;", BuildConfig.FLAVOR, "navigateToNationalitySelection", "proceed", "showHelp", "CreateYourSelfAsPassengerView", "(Ldk/molslinjen/ui/views/screens/booking/passengers/CreateYourSelfAsPassengerViewModel;Lcom/ramcosta/composedestinations/result/ResultRecipient;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler;", "inputHandler", "Ldk/molslinjen/ui/views/screens/booking/passengers/CreateYourSelfAsPassengerViewModel$ViewState;", "viewState", "Lkotlin/Function1;", BuildConfig.FLAVOR, "updateSaveInfoToAccount", "Landroidx/compose/runtime/MutableState;", "isFormValid", "submitFieldsTrigger", "CreateYourSelfAsPassengerContent", "(Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler;Ldk/molslinjen/ui/views/screens/booking/passengers/CreateYourSelfAsPassengerViewModel$ViewState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CreateYourSelfAsPassengerViewKt {
    private static final void CreateYourSelfAsPassengerContent(final IPassengerInputHandler iPassengerInputHandler, final CreateYourSelfAsPassengerViewModel.ViewState viewState, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function1<? super Boolean, Unit> function1, final MutableState<Boolean> mutableState, final MutableState<Boolean> mutableState2, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Modifier.Companion companion;
        float f5;
        Object obj;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(405321799);
        if ((i5 & 6) == 0) {
            i6 = ((i5 & 8) == 0 ? startRestartGroup.changed(iPassengerInputHandler) : startRestartGroup.changedInstance(iPassengerInputHandler) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(viewState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function03) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changed(mutableState) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i6 |= startRestartGroup.changed(mutableState2) ? 8388608 : 4194304;
        }
        if ((4793491 & i6) == 4793490 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(405321799, i6, -1, "dk.molslinjen.ui.views.screens.booking.passengers.CreateYourSelfAsPassengerContent (CreateYourSelfAsPassengerView.kt:88)");
            }
            Modifier.Companion companion2 = Modifier.INSTANCE;
            float f6 = 16;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(companion2, 0.0f, 1, null), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, null, false, 14, null), Dp.m2599constructorimpl(f6), 0.0f, 2, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion3.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            float f7 = 24;
            Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(companion2, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f7));
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
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
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.passengers_createYourself_title, startRestartGroup, 6), RowScope.weight$default(RowScopeInstance.INSTANCE, companion2, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH2Bold(), startRestartGroup, 0, 1572864, 65532);
            int i9 = i6;
            IconButtonKt.IconButton(function03, SizeKt.m331size3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(companion2, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null), Dp.m2599constructorimpl(f7)), false, null, null, ComposableSingletons$CreateYourSelfAsPassengerViewKt.INSTANCE.m3462getLambda1$app_kombardoProd(), startRestartGroup, ((i6 >> 12) & 14) | 196656, 28);
            startRestartGroup.endNode();
            Modifier m313paddingVpY3zN4$default2 = PaddingKt.m313paddingVpY3zN4$default(BackgroundKt.m103backgroundbw27NRU(ModifierExtensionsKt.defaultShadow$default(companion2, null, 1, null), AppColor.INSTANCE.m3281getWhite0d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), 0.0f, Dp.m2599constructorimpl(f6), 1, null);
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default2);
            Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
            Modifier m313paddingVpY3zN4$default3 = PaddingKt.m313paddingVpY3zN4$default(companion2, Dp.m2599constructorimpl(f6), 0.0f, 2, null);
            boolean isLoading = viewState.getIsLoading();
            boolean booleanValue = mutableState2.getValue().booleanValue();
            startRestartGroup.startReplaceGroup(-290865281);
            boolean z5 = (i9 & 3670016) == 1048576;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: U2.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit CreateYourSelfAsPassengerContent$lambda$18$lambda$15$lambda$10$lambda$9;
                        CreateYourSelfAsPassengerContent$lambda$18$lambda$15$lambda$10$lambda$9 = CreateYourSelfAsPassengerViewKt.CreateYourSelfAsPassengerContent$lambda$18$lambda$15$lambda$10$lambda$9(MutableState.this, ((Boolean) obj2).booleanValue());
                        return CreateYourSelfAsPassengerContent$lambda$18$lambda$15$lambda$10$lambda$9;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            ProfilePassengerInputContentKt.ProfilePassengerInputContent(m313paddingVpY3zN4$default3, iPassengerInputHandler, isLoading, booleanValue, null, (Function1) rememberedValue, function0, startRestartGroup, ((i9 << 3) & 112) | 24582 | ((i9 << 12) & 3670016), 0);
            composer2 = startRestartGroup;
            composer2.startReplaceGroup(-290859808);
            if (viewState.getHasPartialAccountData()) {
                float m2599constructorimpl = Dp.m2599constructorimpl(f6);
                companion = companion2;
                f5 = 0.0f;
                obj = null;
                Modifier m313paddingVpY3zN4$default4 = PaddingKt.m313paddingVpY3zN4$default(companion, m2599constructorimpl, 0.0f, 2, null);
                i7 = 0;
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getTop(), composer2, 0);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, m313paddingVpY3zN4$default4);
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
                Updater.m1227setimpl(m1226constructorimpl4, rowMeasurePolicy2, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion4.getSetCompositeKeyHash();
                if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion4.getSetModifier());
                SelectionControlKt.SelectionControl(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 11, null), viewState.getSaveInfoToAccount(), function1, null, false, null, SelectionControlStyle.Checkbox, false, composer2, ((i9 >> 9) & 896) | 1572870, 184);
                final UriHandler uriHandler = (UriHandler) composer2.consume(CompositionLocalsKt.getLocalUriHandler());
                i8 = 6;
                String stringResource = StringResources_androidKt.stringResource(R.string.passengers_createYourself_personalDataPolicy, composer2, 6);
                TextStyle paragraphSmall = TypographyKt.getParagraphSmall();
                String stringResource2 = StringResources_androidKt.stringResource(R.string.passengers_createYourself_saveInfo, new Object[]{stringResource}, composer2, 6);
                composer2.startReplaceGroup(1610380450);
                boolean changedInstance = composer2.changedInstance(uriHandler) | ((i9 & 112) == 32);
                Object rememberedValue2 = composer2.rememberedValue();
                if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: U2.s
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CreateYourSelfAsPassengerContent$lambda$18$lambda$15$lambda$14$lambda$13$lambda$12;
                            CreateYourSelfAsPassengerContent$lambda$18$lambda$15$lambda$14$lambda$13$lambda$12 = CreateYourSelfAsPassengerViewKt.CreateYourSelfAsPassengerContent$lambda$18$lambda$15$lambda$14$lambda$13$lambda$12(CreateYourSelfAsPassengerViewModel.ViewState.this, uriHandler);
                            return CreateYourSelfAsPassengerContent$lambda$18$lambda$15$lambda$14$lambda$13$lambda$12;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue2);
                }
                composer2.endReplaceGroup();
                ClickableTextKt.m3408ClickableTextFHprtrg(null, stringResource2, CollectionsKt.listOf(new ClickableTextData(stringResource, (Function0) rememberedValue2, null, null, null, 28, null)), paragraphSmall, 0L, null, composer2, 3072, 49);
                composer2.endNode();
            } else {
                companion = companion2;
                f5 = 0.0f;
                obj = null;
                i7 = 0;
                i8 = 6;
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, companion, 1.0f, false, 2, null), composer2, i7);
            Modifier m313paddingVpY3zN4$default5 = PaddingKt.m313paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, f5, 1, obj), f5, Dp.m2599constructorimpl(f6), 1, obj);
            String stringResource3 = StringResources_androidKt.stringResource(R.string.passengers_createYourself_button, composer2, i8);
            boolean booleanValue2 = mutableState.getValue().booleanValue();
            boolean isLoading2 = viewState.getIsLoading();
            ButtonConfig buttonConfig = ButtonConfig.Large;
            composer2.startReplaceGroup(253751942);
            if ((i9 & 29360128) == 8388608) {
                i7 = 1;
            }
            Object rememberedValue3 = composer2.rememberedValue();
            if (i7 != 0 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: U2.t
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CreateYourSelfAsPassengerContent$lambda$18$lambda$17$lambda$16;
                        CreateYourSelfAsPassengerContent$lambda$18$lambda$17$lambda$16 = CreateYourSelfAsPassengerViewKt.CreateYourSelfAsPassengerContent$lambda$18$lambda$17$lambda$16(MutableState.this);
                        return CreateYourSelfAsPassengerContent$lambda$18$lambda$17$lambda$16;
                    }
                };
                composer2.updateRememberedValue(rememberedValue3);
            }
            composer2.endReplaceGroup();
            PrimaryButtonKt.PrimaryButton(m313paddingVpY3zN4$default5, stringResource3, function02, (Function0) rememberedValue3, buttonConfig, booleanValue2, isLoading2, false, composer2, ((i9 >> 3) & 896) | 24582, 128);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: U2.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit CreateYourSelfAsPassengerContent$lambda$19;
                    CreateYourSelfAsPassengerContent$lambda$19 = CreateYourSelfAsPassengerViewKt.CreateYourSelfAsPassengerContent$lambda$19(IPassengerInputHandler.this, viewState, function0, function02, function03, function1, mutableState, mutableState2, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    return CreateYourSelfAsPassengerContent$lambda$19;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateYourSelfAsPassengerContent$lambda$18$lambda$15$lambda$10$lambda$9(MutableState mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateYourSelfAsPassengerContent$lambda$18$lambda$15$lambda$14$lambda$13$lambda$12(CreateYourSelfAsPassengerViewModel.ViewState viewState, UriHandler uriHandler) {
        String privacyPolicyUrl = viewState.getPrivacyPolicyUrl();
        if (privacyPolicyUrl != null) {
            uriHandler.openUri(privacyPolicyUrl);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateYourSelfAsPassengerContent$lambda$18$lambda$17$lambda$16(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateYourSelfAsPassengerContent$lambda$19(IPassengerInputHandler iPassengerInputHandler, CreateYourSelfAsPassengerViewModel.ViewState viewState, Function0 function0, Function0 function02, Function0 function03, Function1 function1, MutableState mutableState, MutableState mutableState2, int i5, Composer composer, int i6) {
        CreateYourSelfAsPassengerContent(iPassengerInputHandler, viewState, function0, function02, function03, function1, mutableState, mutableState2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void CreateYourSelfAsPassengerView(final CreateYourSelfAsPassengerViewModel viewModel, final ResultRecipient<NationalitySelectionScreenDestination, Locale> nationalityResultRecipient, final Function0<Unit> navigateToNationalitySelection, final Function0<Unit> proceed, final Function0<Unit> showHelp, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(nationalityResultRecipient, "nationalityResultRecipient");
        Intrinsics.checkNotNullParameter(navigateToNationalitySelection, "navigateToNationalitySelection");
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        Intrinsics.checkNotNullParameter(showHelp, "showHelp");
        Composer startRestartGroup = composer.startRestartGroup(1106025736);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(nationalityResultRecipient) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(navigateToNationalitySelection) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(proceed) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(showHelp) ? 16384 : 8192;
        }
        int i7 = i6;
        if ((i7 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1106025736, i7, -1, "dk.molslinjen.ui.views.screens.booking.passengers.CreateYourSelfAsPassengerView (CreateYourSelfAsPassengerView.kt:57)");
            }
            startRestartGroup.startReplaceGroup(1913527046);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: U2.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit CreateYourSelfAsPassengerView$lambda$1$lambda$0;
                        CreateYourSelfAsPassengerView$lambda$1$lambda$0 = CreateYourSelfAsPassengerViewKt.CreateYourSelfAsPassengerView$lambda$1$lambda$0(CreateYourSelfAsPassengerViewModel.this, (Locale) obj);
                        return CreateYourSelfAsPassengerView$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            OpenResultRecipientKt.onResult(nationalityResultRecipient, null, (Function1) rememberedValue, startRestartGroup, (i7 >> 3) & 14, 1);
            CreateYourSelfAsPassengerViewModel.ViewState viewState = (CreateYourSelfAsPassengerViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(1913531321);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            MutableState mutableState = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1913533401);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            MutableState mutableState2 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1913544121);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new CreateYourSelfAsPassengerViewKt$CreateYourSelfAsPassengerView$2$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            KFunction kFunction = (KFunction) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1913539775);
            boolean changedInstance3 = startRestartGroup.changedInstance(viewModel) | ((i7 & 7168) == 2048);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = new Function0() { // from class: U2.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CreateYourSelfAsPassengerView$lambda$6$lambda$5;
                        CreateYourSelfAsPassengerView$lambda$6$lambda$5 = CreateYourSelfAsPassengerViewKt.CreateYourSelfAsPassengerView$lambda$6$lambda$5(CreateYourSelfAsPassengerViewModel.this, proceed);
                        return CreateYourSelfAsPassengerView$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            CreateYourSelfAsPassengerContent(viewModel, viewState, navigateToNationalitySelection, (Function0) rememberedValue5, showHelp, (Function1) kFunction, mutableState, mutableState2, startRestartGroup, (i7 & 14) | 14155776 | (i7 & 896) | (57344 & i7));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: U2.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CreateYourSelfAsPassengerView$lambda$7;
                    CreateYourSelfAsPassengerView$lambda$7 = CreateYourSelfAsPassengerViewKt.CreateYourSelfAsPassengerView$lambda$7(CreateYourSelfAsPassengerViewModel.this, nationalityResultRecipient, navigateToNationalitySelection, proceed, showHelp, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CreateYourSelfAsPassengerView$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateYourSelfAsPassengerView$lambda$1$lambda$0(CreateYourSelfAsPassengerViewModel createYourSelfAsPassengerViewModel, Locale it) {
        Intrinsics.checkNotNullParameter(it, "it");
        createYourSelfAsPassengerViewModel.updateNationality(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateYourSelfAsPassengerView$lambda$6$lambda$5(CreateYourSelfAsPassengerViewModel createYourSelfAsPassengerViewModel, Function0 function0) {
        createYourSelfAsPassengerViewModel.registerPassenger(function0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateYourSelfAsPassengerView$lambda$7(CreateYourSelfAsPassengerViewModel createYourSelfAsPassengerViewModel, ResultRecipient resultRecipient, Function0 function0, Function0 function02, Function0 function03, int i5, Composer composer, int i6) {
        CreateYourSelfAsPassengerView(createYourSelfAsPassengerViewModel, resultRecipient, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
