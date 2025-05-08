package dk.molslinjen.ui.views.screens.agreements.commuter.oeresund;

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
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImagePainterKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.core.image.ImageHelper;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.model.agreement.commuter.oeresund.OeresundCommuterAgreement;
import dk.molslinjen.domain.model.agreement.commuter.oeresund.OeresundCommuterAgreementType;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.VerticalDividerKt;
import dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.OeresundAgreementInfoViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a!\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t²\u0006\u000e\u0010\b\u001a\u00020\u00078\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreement;", "agreement", BuildConfig.FLAVOR, "OeresundAgreementInfoView", "(Landroidx/compose/ui/Modifier;Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreement;Landroidx/compose/runtime/Composer;II)V", BuildConfig.FLAVOR, "imageLoadingFailed", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class OeresundAgreementInfoViewKt {
    public static final void OeresundAgreementInfoView(Modifier modifier, final OeresundCommuterAgreement agreement, Composer composer, final int i5, final int i6) {
        final Modifier modifier2;
        int i7;
        int i8;
        Modifier modifier3;
        Composer composer2;
        int i9;
        Composer composer3;
        Composer composer4;
        Composer composer5;
        Integer numberOfChargesLeft;
        Intrinsics.checkNotNullParameter(agreement, "agreement");
        Composer startRestartGroup = composer.startRestartGroup(-1351817189);
        int i10 = i6 & 1;
        if (i10 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(agreement) ? 32 : 16;
        }
        if ((i7 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer5 = startRestartGroup;
        } else {
            Modifier modifier4 = i10 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1351817189, i7, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.oeresund.OeresundAgreementInfoView (OeresundAgreementInfoView.kt:43)");
            }
            long m3253getBrandBlack10d7_KjU = agreement.isAvailable() ? AppColor.INSTANCE.m3253getBrandBlack10d7_KjU() : AppColor.INSTANCE.m3266getGrey30d7_KjU();
            long m3264getGrey10d7_KjU = agreement.isAvailable() ? AppColor.INSTANCE.m3264getGrey10d7_KjU() : AppColor.INSTANCE.m3266getGrey30d7_KjU();
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier then = modifier4.then(IntrinsicKt.height(companion, IntrinsicSize.Min));
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion2.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, then);
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
            Modifier weight$default = RowScope.weight$default(RowScopeInstance.INSTANCE, companion, 1.0f, false, 2, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, weight$default);
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
            String title = agreement.getTitle();
            startRestartGroup.startReplaceGroup(2058673096);
            if (title == null) {
                modifier3 = modifier4;
                composer2 = startRestartGroup;
                i8 = 16;
            } else {
                i8 = 16;
                modifier3 = modifier4;
                composer2 = startRestartGroup;
                TextKt.m940Text4IGK_g(title, null, m3253getBrandBlack10d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), composer2, 0, 1572864, 65530);
                Unit unit = Unit.INSTANCE;
            }
            composer2.endReplaceGroup();
            TextKt.m940Text4IGK_g(agreement.getLineName(), null, m3253getBrandBlack10d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer2, 0, 1572864, 65530);
            float f5 = i8;
            Composer composer6 = composer2;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer6, 6);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer6, 0);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer6.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer6, companion);
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            if (composer6.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer6.startReusableNode();
            if (composer6.getInserting()) {
                composer6.createNode(constructor3);
            } else {
                composer6.useNode();
            }
            Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer6);
            Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
            composer6.startReplaceGroup(875447172);
            Object rememberedValue = composer6.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (rememberedValue == companion4.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composer6.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            composer6.endReplaceGroup();
            float f6 = 24;
            String m3193buildImageUrlC8IHX40 = ImageHelper.INSTANCE.m3193buildImageUrlC8IHX40(agreement.getTransportImageUrl(), null, Dp.m2597boximpl(Dp.m2599constructorimpl(f6)), composer6, 3456, 2);
            composer6.startReplaceGroup(875452940);
            if (m3193buildImageUrlC8IHX40 == null || OeresundAgreementInfoView$lambda$13$lambda$10$lambda$7$lambda$2(mutableState)) {
                i9 = 8;
                composer3 = composer6;
            } else {
                composer6.startReplaceGroup(875459323);
                Object rememberedValue2 = composer6.rememberedValue();
                if (rememberedValue2 == companion4.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: u2.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit OeresundAgreementInfoView$lambda$13$lambda$10$lambda$7$lambda$5$lambda$4;
                            OeresundAgreementInfoView$lambda$13$lambda$10$lambda$7$lambda$5$lambda$4 = OeresundAgreementInfoViewKt.OeresundAgreementInfoView$lambda$13$lambda$10$lambda$7$lambda$5$lambda$4(MutableState.this, (AsyncImagePainter.State.Error) obj);
                            return OeresundAgreementInfoView$lambda$13$lambda$10$lambda$7$lambda$5$lambda$4;
                        }
                    };
                    composer6.updateRememberedValue(rememberedValue2);
                }
                composer6.endReplaceGroup();
                i9 = 8;
                ImageKt.Image(SingletonAsyncImagePainterKt.m2745rememberAsyncImagePainterMqRF_0(m3193buildImageUrlC8IHX40, null, null, null, null, null, (Function1) rememberedValue2, null, 0, composer6, 1572864, 446), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(f6)), null, ContentScale.INSTANCE.getFit(), 0.0f, ColorFilter.Companion.m1503tintxETnrds$default(ColorFilter.INSTANCE, AppColor.INSTANCE.m3266getGrey30d7_KjU(), 0, 2, null), composer6, 1597824, 40);
                composer3 = composer6;
                SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(8)), composer3, 6);
            }
            composer3.endReplaceGroup();
            String transportDescription = agreement.getTransportDescription();
            composer3.startReplaceGroup(875476842);
            if (transportDescription == null) {
                composer4 = composer3;
            } else {
                composer4 = composer3;
                TextKt.m940Text4IGK_g(transportDescription, null, m3253getBrandBlack10d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer4, 0, 1572864, 65530);
                Unit unit2 = Unit.INSTANCE;
            }
            composer4.endReplaceGroup();
            composer4.endNode();
            Composer composer7 = composer4;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer7, 6);
            String number = agreement.getNumber();
            composer7.startReplaceGroup(2058721133);
            if (number == null) {
                composer5 = composer7;
            } else {
                composer5 = composer7;
                TextKt.m940Text4IGK_g(number, null, m3264getGrey10d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer5, 0, 1572864, 65530);
                Unit unit3 = Unit.INSTANCE;
            }
            composer5.endReplaceGroup();
            LocalDate validTo = agreement.getValidTo();
            composer5.startReplaceGroup(2058727702);
            if (validTo != null) {
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.agreement_expireDate, new Object[]{LocalDateTimeExtensionsKt.toShortFormat(validTo)}, composer5, 6), null, m3264getGrey10d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), composer5, 0, 1572864, 65530);
                Unit unit4 = Unit.INSTANCE;
            }
            composer5.endReplaceGroup();
            composer5.endNode();
            composer5.startReplaceGroup(-1817736969);
            if (agreement.getAgreementType() == OeresundCommuterAgreementType.Punchcard && (numberOfChargesLeft = agreement.getNumberOfChargesLeft()) != null) {
                int intValue = numberOfChargesLeft.intValue();
                VerticalDividerKt.m3394VerticalDividertZIQpXc(null, 0L, 0.0f, Dp.m2597boximpl(Dp.m2599constructorimpl(2)), composer5, 3072, 7);
                float f7 = i9;
                Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(companion, Dp.m2599constructorimpl(32), Dp.m2599constructorimpl(f7));
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getCenterHorizontally(), composer5, 48);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer5.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer5, m312paddingVpY3zN4);
                Function0<ComposeUiNode> constructor4 = companion3.getConstructor();
                if (composer5.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer5.startReusableNode();
                if (composer5.getInserting()) {
                    composer5.createNode(constructor4);
                } else {
                    composer5.useNode();
                }
                Composer m1226constructorimpl4 = Updater.m1226constructorimpl(composer5);
                Updater.m1227setimpl(m1226constructorimpl4, columnMeasurePolicy2, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion3.getSetModifier());
                Composer composer8 = composer5;
                TextKt.m940Text4IGK_g(String.valueOf(intValue), null, m3253getBrandBlack10d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH1Bold(), composer8, 0, 1572864, 65530);
                TextKt.m940Text4IGK_g(StringResources_androidKt.pluralStringResource(R.plurals.multiRide_charges, intValue, composer5, 6), null, m3253getBrandBlack10d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer8, 0, 1572864, 65530);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f7)), composer5, 6);
                composer5.endNode();
                Unit unit5 = Unit.INSTANCE;
            }
            composer5.endReplaceGroup();
            composer5.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = composer5.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: u2.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit OeresundAgreementInfoView$lambda$14;
                    OeresundAgreementInfoView$lambda$14 = OeresundAgreementInfoViewKt.OeresundAgreementInfoView$lambda$14(Modifier.this, agreement, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return OeresundAgreementInfoView$lambda$14;
                }
            });
        }
    }

    private static final boolean OeresundAgreementInfoView$lambda$13$lambda$10$lambda$7$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void OeresundAgreementInfoView$lambda$13$lambda$10$lambda$7$lambda$3(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OeresundAgreementInfoView$lambda$13$lambda$10$lambda$7$lambda$5$lambda$4(MutableState mutableState, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        OeresundAgreementInfoView$lambda$13$lambda$10$lambda$7$lambda$3(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OeresundAgreementInfoView$lambda$14(Modifier modifier, OeresundCommuterAgreement oeresundCommuterAgreement, int i5, int i6, Composer composer, int i7) {
        OeresundAgreementInfoView(modifier, oeresundCommuterAgreement, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
