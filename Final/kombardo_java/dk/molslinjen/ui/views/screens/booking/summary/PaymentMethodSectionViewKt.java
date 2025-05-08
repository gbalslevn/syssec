package dk.molslinjen.ui.views.screens.booking.summary;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSize;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.material3.MaterialTheme;
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
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.account.CreditCardType;
import dk.molslinjen.domain.model.payment.PaymentType;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.extensions.domain.CreditCardTypeExtensionsKt;
import dk.molslinjen.extensions.domain.PaymentTypeExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlStyle;
import dk.molslinjen.ui.views.screens.booking.summary.PaymentMethodSectionViewKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a[\u0010\n\u001a\u00020\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001ac\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00002\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u0003¢\u0006\u0004\b\u0011\u0010\u0012\u001a7\u0010\u0015\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0014\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\b0\u0014H\u0003¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/payment/PaymentType;", "paymentTypes", "Ldk/molslinjen/domain/model/account/CreditCard;", "savedCreditCards", "selectedPaymentType", "selectedCreditCard", "Lkotlin/Function2;", BuildConfig.FLAVOR, "onSelection", "PaymentMethodSectionView", "(Ljava/util/List;Ljava/util/List;Ldk/molslinjen/domain/model/payment/PaymentType;Ldk/molslinjen/domain/model/account/CreditCard;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "paymentType", BuildConfig.FLAVOR, "isSelected", "isFirst", "isLast", "PaymentTypeRow", "(Ldk/molslinjen/domain/model/payment/PaymentType;Ljava/util/List;ZLdk/molslinjen/domain/model/account/CreditCard;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "creditCard", "Lkotlin/Function1;", "CreditCardRow", "(Ldk/molslinjen/domain/model/account/CreditCard;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PaymentMethodSectionViewKt {
    private static final void CreditCardRow(final CreditCard creditCard, final boolean z5, final Function1<? super CreditCard, Unit> function1, Composer composer, final int i5) {
        int i6;
        CreditCardType creditCardType;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-736168116);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(creditCard) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-736168116, i6, -1, "dk.molslinjen.ui.views.screens.booking.summary.CreditCardRow (PaymentMethodSectionView.kt:164)");
            }
            if (creditCard == null || (creditCardType = creditCard.getCardType()) == null) {
                creditCardType = CreditCardType.Other;
            }
            CreditCardType creditCardType2 = creditCardType;
            Modifier.Companion companion = Modifier.INSTANCE;
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i7 = MaterialTheme.$stable;
            Modifier clip = ClipKt.clip(companion, materialTheme.getShapes(startRestartGroup, i7).getMedium());
            startRestartGroup.startReplaceGroup(-300382934);
            boolean changedInstance = ((i6 & 896) == 256) | startRestartGroup.changedInstance(creditCard);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: h3.N
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit CreditCardRow$lambda$16$lambda$15;
                        CreditCardRow$lambda$16$lambda$15 = PaymentMethodSectionViewKt.CreditCardRow$lambda$16$lambda$15(Function1.this, creditCard, ((Boolean) obj).booleanValue());
                        return CreditCardRow$lambda$16$lambda$15;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m455toggleableXHw0xAI$default = ToggleableKt.m455toggleableXHw0xAI$default(clip, z5, false, null, (Function1) rememberedValue, 6, null);
            float m2599constructorimpl = Dp.m2599constructorimpl(2);
            AppColor appColor = AppColor.INSTANCE;
            Modifier m108borderxT4_qwU = BorderKt.m108borderxT4_qwU(m455toggleableXHw0xAI$default, m2599constructorimpl, z5 ? appColor.m3255getBrandBlue10d7_KjU() : appColor.m3268getGrey50d7_KjU(), materialTheme.getShapes(startRestartGroup, i7).getMedium());
            float f5 = 16;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(m108borderxT4_qwU, Dp.m2599constructorimpl(f5));
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Horizontal start = arrangement.getStart();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion2.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
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
            float f6 = 4;
            ImageKt.Image(PainterResources_androidKt.painterResource(CreditCardTypeExtensionsKt.getIcon(creditCardType2), startRestartGroup, 0), Accessibility.INSTANCE.getSkip(), PaddingKt.m315paddingqDBjuR0$default(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(38)), 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 13, null), null, null, 0.0f, null, startRestartGroup, 384, 120);
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
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
            Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f6), 7, null);
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(ComposeExtensionsKt.stringResourceWithDefault(Integer.valueOf(creditCard != null ? CreditCardTypeExtensionsKt.getTitle(creditCardType2) : R.string.payment_useDifferentPaymentCard), null, startRestartGroup, 0, 2), m315paddingqDBjuR0$default2, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer2, 48, 1572864, 65532);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer2, 0);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, companion);
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
            String adjustedMaskedNumber = creditCard != null ? creditCard.getAdjustedMaskedNumber() : null;
            composer2.startReplaceGroup(410282645);
            String stringResource = adjustedMaskedNumber == null ? StringResources_androidKt.stringResource(R.string.payment_useDifferentPaymentCard_details, composer2, 6) : adjustedMaskedNumber;
            composer2.endReplaceGroup();
            TextStyle subSmall = TypographyKt.getSubSmall();
            AppColor appColor2 = AppColor.INSTANCE;
            TextKt.m940Text4IGK_g(stringResource, companion, appColor2.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, subSmall, composer2, 432, 1572864, 65528);
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), composer2, 0);
            composer2.startReplaceGroup(410291766);
            if (creditCard != null) {
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.payment_savedCreditCard, composer2, 6), PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null), appColor2.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), composer2, 432, 1572864, 65528);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: h3.O
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CreditCardRow$lambda$20;
                    CreditCardRow$lambda$20 = PaymentMethodSectionViewKt.CreditCardRow$lambda$20(CreditCard.this, z5, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CreditCardRow$lambda$20;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreditCardRow$lambda$16$lambda$15(Function1 function1, CreditCard creditCard, boolean z5) {
        function1.invoke(creditCard);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreditCardRow$lambda$20(CreditCard creditCard, boolean z5, Function1 function1, int i5, Composer composer, int i6) {
        CreditCardRow(creditCard, z5, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void PaymentMethodSectionView(final List<? extends PaymentType> paymentTypes, final List<CreditCard> savedCreditCards, final PaymentType paymentType, final CreditCard creditCard, final Function2<? super PaymentType, ? super CreditCard, Unit> onSelection, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(paymentTypes, "paymentTypes");
        Intrinsics.checkNotNullParameter(savedCreditCards, "savedCreditCards");
        Intrinsics.checkNotNullParameter(onSelection, "onSelection");
        Composer startRestartGroup = composer.startRestartGroup(-787496151);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(paymentTypes) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(savedCreditCards) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(paymentType) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(creditCard) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(onSelection) ? 16384 : 8192;
        }
        int i7 = i6;
        if ((i7 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-787496151, i7, -1, "dk.molslinjen.ui.views.screens.booking.summary.PaymentMethodSectionView (PaymentMethodSectionView.kt:52)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 16;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.bookingSummary_paymentMethods, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), startRestartGroup, 48, 1572864, 65532);
            AppColor appColor = AppColor.INSTANCE;
            long m3281getWhite0d7_KjU = appColor.m3281getWhite0d7_KjU();
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            int i8 = MaterialTheme.$stable;
            Modifier m108borderxT4_qwU = BorderKt.m108borderxT4_qwU(BackgroundKt.m103backgroundbw27NRU(companion, m3281getWhite0d7_KjU, materialTheme.getShapes(startRestartGroup, i8).getMedium()), Dp.m2599constructorimpl(1), appColor.m3268getGrey50d7_KjU(), materialTheme.getShapes(startRestartGroup, i8).getMedium());
            boolean z5 = false;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m108borderxT4_qwU);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(1940700644);
            Iterator<? extends PaymentType> it = paymentTypes.iterator();
            while (it.hasNext()) {
                PaymentType next = it.next();
                boolean z6 = paymentType == next ? true : z5;
                boolean z7 = CollectionsKt.first((List) paymentTypes) == next ? true : z5;
                boolean z8 = CollectionsKt.last((List) paymentTypes) == next ? true : z5;
                float f6 = f5;
                int i9 = i7;
                Composer composer3 = startRestartGroup;
                PaymentTypeRow(next, savedCreditCards, z6, creditCard, z7, z8, onSelection, startRestartGroup, (i7 & 7280) | (3670016 & (i7 << 6)));
                composer3.startReplaceGroup(1940715359);
                if (next != CollectionsKt.last((List) paymentTypes)) {
                    HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer3, 0, 15);
                }
                composer3.endReplaceGroup();
                startRestartGroup = composer3;
                f5 = f6;
                i7 = i9;
                z5 = false;
            }
            Composer composer4 = startRestartGroup;
            composer4.endReplaceGroup();
            composer4.endNode();
            composer2 = composer4;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.bookingSummary_paymentAuthorizeReservation, composer4, 6), PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(40), 0.0f, 9, null), AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 432, 1572864, 65528);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: h3.P
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PaymentMethodSectionView$lambda$1;
                    PaymentMethodSectionView$lambda$1 = PaymentMethodSectionViewKt.PaymentMethodSectionView$lambda$1(paymentTypes, savedCreditCards, paymentType, creditCard, onSelection, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return PaymentMethodSectionView$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaymentMethodSectionView$lambda$1(List list, List list2, PaymentType paymentType, CreditCard creditCard, Function2 function2, int i5, Composer composer, int i6) {
        PaymentMethodSectionView(list, list2, paymentType, creditCard, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v25 */
    private static final void PaymentTypeRow(final PaymentType paymentType, final List<CreditCard> list, final boolean z5, final CreditCard creditCard, final boolean z6, final boolean z7, final Function2<? super PaymentType, ? super CreditCard, Unit> function2, Composer composer, final int i5) {
        CornerSize m459CornerSize0680j_4;
        CornerSize m459CornerSize0680j_42;
        ?? r02;
        boolean z8;
        CornerSize m459CornerSize0680j_43;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1331914990);
        int i6 = (i5 & 6) == 0 ? (startRestartGroup.changed(paymentType) ? 4 : 2) | i5 : i5;
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(list) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(creditCard) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(z6) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(z7) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 1048576 : 524288;
        }
        int i7 = i6;
        if ((599187 & i7) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1331914990, i7, -1, "dk.molslinjen.ui.views.screens.booking.summary.PaymentTypeRow (PaymentMethodSectionView.kt:95)");
            }
            final FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            Modifier.Companion companion = Modifier.INSTANCE;
            CornerBasedShape medium = MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getMedium();
            int i8 = 0;
            CornerSize m459CornerSize0680j_44 = CornerSizeKt.m459CornerSize0680j_4(Dp.m2599constructorimpl(z6 ? 8 : 0));
            if (z6) {
                m459CornerSize0680j_4 = CornerSizeKt.m459CornerSize0680j_4(Dp.m2599constructorimpl(8));
                i8 = 0;
            } else {
                m459CornerSize0680j_4 = CornerSizeKt.m459CornerSize0680j_4(Dp.m2599constructorimpl(0));
            }
            if (z7) {
                m459CornerSize0680j_42 = CornerSizeKt.m459CornerSize0680j_4(Dp.m2599constructorimpl(8));
                r02 = 0;
            } else {
                int i9 = i8;
                m459CornerSize0680j_42 = CornerSizeKt.m459CornerSize0680j_4(Dp.m2599constructorimpl(i9));
                r02 = i9;
            }
            if (z7) {
                m459CornerSize0680j_43 = CornerSizeKt.m459CornerSize0680j_4(Dp.m2599constructorimpl(8));
                z8 = false;
            } else {
                z8 = r02;
                m459CornerSize0680j_43 = CornerSizeKt.m459CornerSize0680j_4(Dp.m2599constructorimpl(z8 ? 1.0f : 0.0f));
            }
            Modifier clip = ClipKt.clip(companion, medium.copy(m459CornerSize0680j_44, m459CornerSize0680j_4, m459CornerSize0680j_43, m459CornerSize0680j_42));
            startRestartGroup.startReplaceGroup(1754455108);
            int i10 = i7 & 3670016;
            int i11 = i7 & 14;
            boolean changedInstance = startRestartGroup.changedInstance(focusManager) | (i10 == 1048576 ? true : z8) | (i11 == 4 ? true : z8);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: h3.H
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PaymentTypeRow$lambda$3$lambda$2;
                        PaymentTypeRow$lambda$3$lambda$2 = PaymentMethodSectionViewKt.PaymentTypeRow$lambda$3$lambda$2(FocusManager.this, function2, paymentType, ((Boolean) obj).booleanValue());
                        return PaymentTypeRow$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            float f5 = 16;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(ToggleableKt.m455toggleableXHw0xAI$default(clip, z5, false, null, (Function1) rememberedValue, 6, null), Dp.m2599constructorimpl(f5));
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion2.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composer2, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m311padding3ABfNKs);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor);
            } else {
                composer2.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            composer2.startReplaceGroup(2118755958);
            Object rememberedValue2 = composer2.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (rememberedValue2 == companion4.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: h3.I
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PaymentTypeRow$lambda$8$lambda$5$lambda$4;
                        PaymentTypeRow$lambda$8$lambda$5$lambda$4 = PaymentMethodSectionViewKt.PaymentTypeRow$lambda$8$lambda$5$lambda$4((SemanticsPropertyReceiver) obj);
                        return PaymentTypeRow$lambda$8$lambda$5$lambda$4;
                    }
                };
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer2.endReplaceGroup();
            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) rememberedValue2);
            composer2.startReplaceGroup(2118759063);
            boolean changedInstance2 = composer2.changedInstance(focusManager) | (i10 == 1048576) | (i11 == 4);
            Object rememberedValue3 = composer2.rememberedValue();
            if (changedInstance2 || rememberedValue3 == companion4.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: h3.J
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PaymentTypeRow$lambda$8$lambda$7$lambda$6;
                        PaymentTypeRow$lambda$8$lambda$7$lambda$6 = PaymentMethodSectionViewKt.PaymentTypeRow$lambda$8$lambda$7$lambda$6(FocusManager.this, function2, paymentType, ((Boolean) obj).booleanValue());
                        return PaymentTypeRow$lambda$8$lambda$7$lambda$6;
                    }
                };
                composer2.updateRememberedValue(rememberedValue3);
            }
            composer2.endReplaceGroup();
            FocusManager focusManager2 = focusManager;
            int i12 = i10;
            int i13 = i11;
            SelectionControlKt.SelectionControl(clearAndSetSemantics, z5, (Function1) rememberedValue3, null, false, null, SelectionControlStyle.RadioButton, false, composer2, ((i7 >> 3) & 112) | 1572864, 184);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(PaymentTypeExtensionsKt.getTitle(paymentType), composer2, 0), RowScope.weight$default(rowScopeInstance, PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer2, 0, 1572864, 65532);
            ImageKt.Image(PainterResources_androidKt.painterResource(PaymentTypeExtensionsKt.getIcon(paymentType), composer2, 0), Accessibility.INSTANCE.getSkip(), SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(20)), null, null, 0.0f, null, composer2, 384, 120);
            composer2.endNode();
            if (z5 && paymentType == PaymentType.Card && !list.isEmpty()) {
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), 2, null);
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer2, 0);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, m315paddingqDBjuR0$default);
                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor2);
                } else {
                    composer2.useNode();
                }
                Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                composer2.startReplaceGroup(2118785642);
                for (CreditCard creditCard2 : list) {
                    boolean areEqual = Intrinsics.areEqual(creditCard, creditCard2);
                    composer2.startReplaceGroup(2118792249);
                    final FocusManager focusManager3 = focusManager2;
                    int i14 = i12;
                    int i15 = i13;
                    boolean changedInstance3 = composer2.changedInstance(focusManager3) | (i14 == 1048576) | (i15 == 4);
                    Object rememberedValue4 = composer2.rememberedValue();
                    if (changedInstance3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = new Function1() { // from class: h3.K
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit PaymentTypeRow$lambda$13$lambda$10$lambda$9;
                                PaymentTypeRow$lambda$13$lambda$10$lambda$9 = PaymentMethodSectionViewKt.PaymentTypeRow$lambda$13$lambda$10$lambda$9(FocusManager.this, function2, paymentType, (CreditCard) obj);
                                return PaymentTypeRow$lambda$13$lambda$10$lambda$9;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue4);
                    }
                    composer2.endReplaceGroup();
                    CreditCardRow(creditCard2, areEqual, (Function1) rememberedValue4, composer2, 0);
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(8)), composer2, 6);
                    focusManager2 = focusManager3;
                    i12 = i14;
                    i13 = i15;
                }
                final FocusManager focusManager4 = focusManager2;
                int i16 = i12;
                int i17 = i13;
                composer2.endReplaceGroup();
                boolean z9 = creditCard == null;
                composer2.startReplaceGroup(2118803917);
                boolean changedInstance4 = composer2.changedInstance(focusManager4) | (i16 == 1048576) | (i17 == 4);
                Object rememberedValue5 = composer2.rememberedValue();
                if (changedInstance4 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue5 = new Function1() { // from class: h3.L
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit PaymentTypeRow$lambda$13$lambda$12$lambda$11;
                            PaymentTypeRow$lambda$13$lambda$12$lambda$11 = PaymentMethodSectionViewKt.PaymentTypeRow$lambda$13$lambda$12$lambda$11(FocusManager.this, function2, paymentType, (CreditCard) obj);
                            return PaymentTypeRow$lambda$13$lambda$12$lambda$11;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue5);
                }
                composer2.endReplaceGroup();
                CreditCardRow(null, z9, (Function1) rememberedValue5, composer2, 6);
                composer2.endNode();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: h3.M
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PaymentTypeRow$lambda$14;
                    PaymentTypeRow$lambda$14 = PaymentMethodSectionViewKt.PaymentTypeRow$lambda$14(PaymentType.this, list, z5, creditCard, z6, z7, function2, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return PaymentTypeRow$lambda$14;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaymentTypeRow$lambda$13$lambda$10$lambda$9(FocusManager focusManager, Function2 function2, PaymentType paymentType, CreditCard creditCard) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        function2.invoke(paymentType, creditCard);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaymentTypeRow$lambda$13$lambda$12$lambda$11(FocusManager focusManager, Function2 function2, PaymentType paymentType, CreditCard creditCard) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        function2.invoke(paymentType, creditCard);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaymentTypeRow$lambda$14(PaymentType paymentType, List list, boolean z5, CreditCard creditCard, boolean z6, boolean z7, Function2 function2, int i5, Composer composer, int i6) {
        PaymentTypeRow(paymentType, list, z5, creditCard, z6, z7, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaymentTypeRow$lambda$3$lambda$2(FocusManager focusManager, Function2 function2, PaymentType paymentType, boolean z5) {
        FocusManager.clearFocus$default(focusManager, false, 1, null);
        function2.invoke(paymentType, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaymentTypeRow$lambda$8$lambda$5$lambda$4(SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, BuildConfig.FLAVOR);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaymentTypeRow$lambda$8$lambda$7$lambda$6(FocusManager focusManager, Function2 function2, PaymentType paymentType, boolean z5) {
        if (z5) {
            FocusManager.clearFocus$default(focusManager, false, 1, null);
            function2.invoke(paymentType, null);
        }
        return Unit.INSTANCE;
    }
}
