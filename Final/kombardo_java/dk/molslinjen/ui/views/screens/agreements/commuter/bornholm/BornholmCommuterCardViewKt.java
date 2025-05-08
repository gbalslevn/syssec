package dk.molslinjen.ui.views.screens.agreements.commuter.bornholm;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImagePainterKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.core.extensions.AccessibilityKt;
import dk.molslinjen.core.image.ImageHelper;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.model.agreement.commuter.bornholm.BornholmCommuterAgreement;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.InfoBoxViewKt;
import dk.molslinjen.ui.views.reusable.VerticalDividerKt;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.BornholmCommuterCardViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\u001aA\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterAgreement;", "agreement", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "navigateToCommuterDetails", "navigateToOrderTicket", "BornholmCommuterCardView", "(Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterAgreement;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BornholmCommuterCardViewKt {
    public static final void BornholmCommuterCardView(final BornholmCommuterAgreement agreement, final Function1<? super String, Unit> function1, final Function1<? super BornholmCommuterAgreement, Unit> navigateToOrderTicket, Composer composer, final int i5) {
        int i6;
        String str;
        char c5;
        Modifier.Companion companion;
        Composer composer2;
        int i7;
        Composer composer3;
        float f5;
        Object obj;
        String stringResource;
        Intrinsics.checkNotNullParameter(agreement, "agreement");
        Intrinsics.checkNotNullParameter(navigateToOrderTicket, "navigateToOrderTicket");
        Composer startRestartGroup = composer.startRestartGroup(-518004174);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(agreement) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(navigateToOrderTicket) ? 256 : 128;
        }
        int i8 = i6;
        if ((i8 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer3 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-518004174, i8, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.BornholmCommuterCardView (BornholmCommuterCardView.kt:55)");
            }
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier m103backgroundbw27NRU = BackgroundKt.m103backgroundbw27NRU(SizeKt.fillMaxWidth$default(ModifierExtensionsKt.defaultShadow(companion2, ThemeShapesKt.getThemeShapes().getMedium()), 0.0f, 1, null), agreement.isExpired() ? AppColor.INSTANCE.m3269getGrey60d7_KjU() : AppColor.INSTANCE.m3281getWhite0d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium());
            boolean z5 = function1 != null;
            startRestartGroup.startReplaceGroup(376670565);
            boolean changedInstance = ((i8 & 112) == 32) | startRestartGroup.changedInstance(agreement);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: q2.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit BornholmCommuterCardView$lambda$1$lambda$0;
                        BornholmCommuterCardView$lambda$1$lambda$0 = BornholmCommuterCardViewKt.BornholmCommuterCardView$lambda$1$lambda$0(Function1.this, agreement);
                        return BornholmCommuterCardView$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            float f6 = 16;
            float f7 = 24;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(ClickableKt.m122clickableXHw0xAI$default(m103backgroundbw27NRU, z5, null, null, (Function0) rememberedValue, 6, null), Dp.m2599constructorimpl(f6), 0.0f, 2, null), 0.0f, Dp.m2599constructorimpl(f7), 0.0f, Dp.m2599constructorimpl(f6), 5, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion3.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
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
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(IntrinsicKt.height(companion2, IntrinsicSize.Min), 0.0f, 1, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
            Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(RowScope.weight$default(RowScopeInstance.INSTANCE, companion2, 1.0f, false, 2, null), 0.0f, 0.0f, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f6), 3, null);
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default2);
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
            Alignment.Vertical centerVertically = companion3.getCenterVertically();
            Modifier m315paddingqDBjuR0$default3 = PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(4), 7, null);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default3);
            Function0<ComposeUiNode> constructor4 = companion4.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor4);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl4 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl4, rowMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion4.getSetModifier());
            startRestartGroup.startReplaceGroup(-218938141);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            Composer.Companion companion5 = Composer.INSTANCE;
            if (rememberedValue2 == companion5.getEmpty()) {
                str = null;
                c5 = 2;
                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            } else {
                str = null;
                c5 = 2;
            }
            final MutableState mutableState = (MutableState) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            ImageHelper imageHelper = ImageHelper.INSTANCE;
            Transportation transportation = agreement.getTransportation();
            String m3193buildImageUrlC8IHX40 = imageHelper.m3193buildImageUrlC8IHX40(transportation != null ? transportation.getImageUrl() : str, null, Dp.m2597boximpl(Dp.m2599constructorimpl(f7)), startRestartGroup, 3456, 2);
            startRestartGroup.startReplaceGroup(-218931830);
            if (m3193buildImageUrlC8IHX40 == null || ((Boolean) mutableState.getValue()).booleanValue()) {
                companion = companion2;
                composer2 = startRestartGroup;
                i7 = 6;
            } else {
                startRestartGroup.startReplaceGroup(-218924792);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion5.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: q2.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit BornholmCommuterCardView$lambda$16$lambda$13$lambda$12$lambda$6$lambda$4$lambda$3;
                            BornholmCommuterCardView$lambda$16$lambda$13$lambda$12$lambda$6$lambda$4$lambda$3 = BornholmCommuterCardViewKt.BornholmCommuterCardView$lambda$16$lambda$13$lambda$12$lambda$6$lambda$4$lambda$3(MutableState.this, (AsyncImagePainter.State.Error) obj2);
                            return BornholmCommuterCardView$lambda$16$lambda$13$lambda$12$lambda$6$lambda$4$lambda$3;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                companion = companion2;
                i7 = 6;
                composer2 = startRestartGroup;
                ImageKt.Image(SingletonAsyncImagePainterKt.m2745rememberAsyncImagePainterMqRF_0(m3193buildImageUrlC8IHX40, null, null, null, null, null, (Function1) rememberedValue3, null, 0, startRestartGroup, 1572864, 446), Accessibility.INSTANCE.getSkip(), SizeKt.m325height3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 11, null), Dp.m2599constructorimpl(f7)), null, ContentScale.INSTANCE.getFit(), 0.0f, ColorFilter.Companion.m1503tintxETnrds$default(ColorFilter.INSTANCE, AppColor.INSTANCE.m3266getGrey30d7_KjU(), 0, 2, null), composer2, 1597824, 40);
            }
            composer2.endReplaceGroup();
            Transportation transportation2 = agreement.getTransportation();
            String name = transportation2 != null ? transportation2.getName() : null;
            Composer composer4 = composer2;
            composer4.startReplaceGroup(-218905875);
            if (name == null) {
                composer3 = composer4;
            } else {
                composer3 = composer4;
                TextKt.m940Text4IGK_g(name, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), composer3, 0, 1572864, 65534);
                Unit unit = Unit.INSTANCE;
            }
            composer3.endReplaceGroup();
            composer3.endNode();
            TextKt.m940Text4IGK_g(agreement.getLineName(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer3, 0, 1572864, 65534);
            final String stringResource2 = StringResources_androidKt.stringResource(R.string.commuter_licensePlate, new Object[]{AccessibilityKt.splitNumberForAccessibility(agreement.getText())}, composer3, i7);
            composer3.startReplaceGroup(1750914590);
            boolean changed = composer3.changed(stringResource2);
            Object rememberedValue4 = composer3.rememberedValue();
            if (changed || rememberedValue4 == companion5.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: q2.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit BornholmCommuterCardView$lambda$16$lambda$13$lambda$12$lambda$8$lambda$7;
                        BornholmCommuterCardView$lambda$16$lambda$13$lambda$12$lambda$8$lambda$7 = BornholmCommuterCardViewKt.BornholmCommuterCardView$lambda$16$lambda$13$lambda$12$lambda$8$lambda$7(stringResource2, (SemanticsPropertyReceiver) obj2);
                        return BornholmCommuterCardView$lambda$16$lambda$13$lambda$12$lambda$8$lambda$7;
                    }
                };
                composer3.updateRememberedValue(rememberedValue4);
            }
            composer3.endReplaceGroup();
            Modifier.Companion companion6 = companion;
            float f8 = 8;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.commuter_licensePlate, new Object[]{agreement.getText()}, composer3, i7), PaddingKt.m315paddingqDBjuR0$default(SemanticsModifierKt.semantics$default(companion6, false, (Function1) rememberedValue4, 1, null), 0.0f, Dp.m2599constructorimpl(f8), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer3, 0, 1572864, 65532);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion6, Dp.m2599constructorimpl(f6)), composer3, 6);
            final String stringResource3 = StringResources_androidKt.stringResource(R.string.commuter_number, new Object[]{AccessibilityKt.splitNumberForAccessibility(agreement.getCommuterAgreementId())}, composer3, 6);
            composer3.startReplaceGroup(1750932594);
            boolean changed2 = composer3.changed(stringResource3);
            Object rememberedValue5 = composer3.rememberedValue();
            if (changed2 || rememberedValue5 == companion5.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: q2.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit BornholmCommuterCardView$lambda$16$lambda$13$lambda$12$lambda$10$lambda$9;
                        BornholmCommuterCardView$lambda$16$lambda$13$lambda$12$lambda$10$lambda$9 = BornholmCommuterCardViewKt.BornholmCommuterCardView$lambda$16$lambda$13$lambda$12$lambda$10$lambda$9(stringResource3, (SemanticsPropertyReceiver) obj2);
                        return BornholmCommuterCardView$lambda$16$lambda$13$lambda$12$lambda$10$lambda$9;
                    }
                };
                composer3.updateRememberedValue(rememberedValue5);
            }
            composer3.endReplaceGroup();
            Modifier semantics$default = SemanticsModifierKt.semantics$default(companion6, false, (Function1) rememberedValue5, 1, null);
            String stringResource4 = StringResources_androidKt.stringResource(R.string.commuter_number, new Object[]{agreement.getCommuterAgreementId()}, composer3, 6);
            TextStyle sub = TypographyKt.getSub();
            AppColor appColor = AppColor.INSTANCE;
            TextKt.m940Text4IGK_g(stringResource4, semantics$default, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, sub, composer3, 384, 1572864, 65528);
            LocalDate validUntil = agreement.getValidUntil();
            composer3.startReplaceGroup(1750942262);
            if (validUntil != null) {
                String shortFormat = LocalDateTimeExtensionsKt.toShortFormat(validUntil);
                if (agreement.isExpired()) {
                    composer3.startReplaceGroup(1805339570);
                    stringResource = StringResources_androidKt.stringResource(R.string.agreement_expiredDate, new Object[]{shortFormat}, composer3, 6);
                    composer3.endReplaceGroup();
                } else {
                    composer3.startReplaceGroup(1805455603);
                    stringResource = StringResources_androidKt.stringResource(R.string.agreement_expireDate, new Object[]{shortFormat}, composer3, 6);
                    composer3.endReplaceGroup();
                }
                TextKt.m940Text4IGK_g(stringResource, null, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer3, 384, 1572864, 65530);
                Unit unit2 = Unit.INSTANCE;
            }
            composer3.endReplaceGroup();
            composer3.endNode();
            composer3.startReplaceGroup(364843685);
            if (function1 != null) {
                f5 = 0.0f;
                obj = null;
                Composer composer5 = composer3;
                VerticalDividerKt.m3394VerticalDividertZIQpXc(SizeKt.fillMaxHeight$default(companion6, 0.0f, 1, null), 0L, 0.0f, Dp.m2597boximpl(Dp.m2599constructorimpl(2)), composer5, 3078, 6);
                SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion6, Dp.m2599constructorimpl(f6)), composer3, 6);
                IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_chevron_right, composer3, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion6, Dp.m2599constructorimpl(f6)), appColor.m3253getBrandBlack10d7_KjU(), composer5, 3456, 0);
            } else {
                f5 = 0.0f;
                obj = null;
            }
            composer3.endReplaceGroup();
            composer3.endNode();
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion6, Dp.m2599constructorimpl(f8)), composer3, 6);
            if (agreement.isExpired()) {
                composer3.startReplaceGroup(-46367215);
                InfoBoxViewKt.InfoBoxView(SizeKt.fillMaxWidth$default(companion6, f5, 1, obj), 0, StringResources_androidKt.stringResource(R.string.multiRide_expired, composer3, 6), false, composer3, 6, 10);
                composer3.endReplaceGroup();
            } else {
                composer3.startReplaceGroup(-46609170);
                Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion6, f5, 1, obj);
                String stringResource5 = StringResources_androidKt.stringResource(R.string.button_orderTicket, composer3, 6);
                composer3.startReplaceGroup(1799617352);
                boolean changedInstance2 = composer3.changedInstance(agreement) | ((i8 & 896) == 256);
                Object rememberedValue6 = composer3.rememberedValue();
                if (changedInstance2 || rememberedValue6 == companion5.getEmpty()) {
                    rememberedValue6 = new Function0() { // from class: q2.e
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit BornholmCommuterCardView$lambda$16$lambda$15$lambda$14;
                            BornholmCommuterCardView$lambda$16$lambda$15$lambda$14 = BornholmCommuterCardViewKt.BornholmCommuterCardView$lambda$16$lambda$15$lambda$14(Function1.this, agreement);
                            return BornholmCommuterCardView$lambda$16$lambda$15$lambda$14;
                        }
                    };
                    composer3.updateRememberedValue(rememberedValue6);
                }
                composer3.endReplaceGroup();
                PrimaryButtonKt.PrimaryButton(fillMaxWidth$default2, stringResource5, (Function0) rememberedValue6, null, null, false, false, false, composer3, 6, 248);
                composer3.endReplaceGroup();
            }
            composer3.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: q2.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit BornholmCommuterCardView$lambda$17;
                    BornholmCommuterCardView$lambda$17 = BornholmCommuterCardViewKt.BornholmCommuterCardView$lambda$17(BornholmCommuterAgreement.this, function1, navigateToOrderTicket, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    return BornholmCommuterCardView$lambda$17;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BornholmCommuterCardView$lambda$1$lambda$0(Function1 function1, BornholmCommuterAgreement bornholmCommuterAgreement) {
        if (function1 != null) {
            function1.invoke(bornholmCommuterAgreement.getCommuterAgreementId());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BornholmCommuterCardView$lambda$16$lambda$13$lambda$12$lambda$10$lambda$9(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BornholmCommuterCardView$lambda$16$lambda$13$lambda$12$lambda$6$lambda$4$lambda$3(MutableState mutableState, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BornholmCommuterCardView$lambda$16$lambda$13$lambda$12$lambda$8$lambda$7(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BornholmCommuterCardView$lambda$16$lambda$15$lambda$14(Function1 function1, BornholmCommuterAgreement bornholmCommuterAgreement) {
        function1.invoke(bornholmCommuterAgreement);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BornholmCommuterCardView$lambda$17(BornholmCommuterAgreement bornholmCommuterAgreement, Function1 function1, Function1 function12, int i5, Composer composer, int i6) {
        BornholmCommuterCardView(bornholmCommuterAgreement, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
