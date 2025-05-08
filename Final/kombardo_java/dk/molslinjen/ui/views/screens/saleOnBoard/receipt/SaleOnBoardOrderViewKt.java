package dk.molslinjen.ui.views.screens.saleOnBoard.receipt;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImagePainterKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.domain.model.booking.SaleOnBoardContactInfo;
import dk.molslinjen.domain.model.saleOnBoard.NotificationType;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.extensions.ColorExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HighlightedTextKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardDepartureInfoSectionKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardLineItemViewKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.receipt.SaleOnBoardOrderViewKt;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.PriceDetailsViewKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u001a{\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001aA\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u000fH\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001f\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019H\u0003¢\u0006\u0004\b\u001b\u0010\u001c\u001a%\u0010\u001d\u001a\u00020\u00122\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0017\u0010\u001f\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {BuildConfig.FLAVOR, "shopLocation", "shopImageUrl", "pickupTime", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "lineItems", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "totalPrice", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "departure", "Ldk/molslinjen/domain/model/booking/SaleOnBoardContactInfo;", "contactInfo", "Ldk/molslinjen/domain/model/saleOnBoard/NotificationType;", "notificationType", BuildConfig.FLAVOR, "isActive", "Lkotlin/Function0;", BuildConfig.FLAVOR, "showOrder", "orderReadyForPickup", "SaleOnBoardOrderView", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Ldk/molslinjen/domain/model/booking/IDepartureInfo;Ldk/molslinjen/domain/model/booking/SaleOnBoardContactInfo;Ldk/molslinjen/domain/model/saleOnBoard/NotificationType;ZLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;III)V", "PickupInfo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "phoneNumber", "NotificationInfo", "(Ldk/molslinjen/domain/model/saleOnBoard/NotificationType;Ldk/molslinjen/domain/model/shared/PhoneNumber;Landroidx/compose/runtime/Composer;I)V", "LineItems", "(Ljava/util/List;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Landroidx/compose/runtime/Composer;I)V", "ContactInfo", "(Ldk/molslinjen/domain/model/booking/SaleOnBoardContactInfo;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SaleOnBoardOrderViewKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NotificationType.values().length];
            try {
                iArr[NotificationType.Sms.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NotificationType.Push.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final void ContactInfo(final SaleOnBoardContactInfo saleOnBoardContactInfo, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1062529884);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(saleOnBoardContactInfo) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1062529884, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.receipt.ContactInfo (SaleOnBoardOrderView.kt:236)");
            }
            String stringResource = StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_contactInfo, startRestartGroup, 6);
            TextStyle paragraphBold = TypographyKt.getParagraphBold();
            Modifier.Companion companion = Modifier.INSTANCE;
            TextKt.m940Text4IGK_g(stringResource, PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(16), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, paragraphBold, startRestartGroup, 48, 1572864, 65532);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            AppColor appColor = AppColor.INSTANCE;
            float f5 = 24;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BorderKt.m108borderxT4_qwU(BackgroundKt.m103backgroundbw27NRU(fillMaxWidth$default, appColor.m3281getWhite0d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(1), appColor.m3267getGrey40d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(f5));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
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
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.textField_label_name, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), startRestartGroup, 0, 1572864, 65534);
            float f6 = 4;
            TextKt.m940Text4IGK_g(saleOnBoardContactInfo.getName(), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 48, 1572864, 65532);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.textField_label_email, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), startRestartGroup, 0, 1572864, 65534);
            TextKt.m940Text4IGK_g(saleOnBoardContactInfo.getEmail(), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 48, 1572864, 65532);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.textField_label_phoneNumber, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer2, 0, 1572864, 65534);
            TextKt.m940Text4IGK_g(saleOnBoardContactInfo.getPhoneNumber().toFormattedString(), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer2, 48, 1572864, 65532);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: k4.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ContactInfo$lambda$17;
                    ContactInfo$lambda$17 = SaleOnBoardOrderViewKt.ContactInfo$lambda$17(SaleOnBoardContactInfo.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ContactInfo$lambda$17;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ContactInfo$lambda$17(SaleOnBoardContactInfo saleOnBoardContactInfo, int i5, Composer composer, int i6) {
        ContactInfo(saleOnBoardContactInfo, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void LineItems(final List<SaleOnBoardLineItem> list, final PriceWithCurrency priceWithCurrency, Composer composer, final int i5) {
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-690889090);
        int i6 = (i5 & 6) == 0 ? (startRestartGroup.changedInstance(list) ? 4 : 2) | i5 : i5;
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(priceWithCurrency) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-690889090, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.receipt.LineItems (SaleOnBoardOrderView.kt:210)");
            }
            String stringResource = StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_yourOrder, startRestartGroup, 6);
            TextStyle paragraphBold = TypographyKt.getParagraphBold();
            Modifier.Companion companion = Modifier.INSTANCE;
            TextKt.m940Text4IGK_g(stringResource, PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(16), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, paragraphBold, startRestartGroup, 48, 1572864, 65532);
            Modifier clip = ClipKt.clip(BorderKt.m108borderxT4_qwU(companion, Dp.m2599constructorimpl(1), AppColor.INSTANCE.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), ThemeShapesKt.getThemeShapes().getMedium());
            composer2 = startRestartGroup;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, clip);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composer2.startReplaceGroup(-2103165382);
            for (SaleOnBoardLineItem saleOnBoardLineItem : list) {
                composer2.startReplaceGroup(-2103161564);
                Object rememberedValue = composer2.rememberedValue();
                Composer.Companion companion3 = Composer.INSTANCE;
                if (rememberedValue == companion3.getEmpty()) {
                    rememberedValue = new Function1() { // from class: k4.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit LineItems$lambda$14$lambda$11$lambda$10;
                            LineItems$lambda$14$lambda$11$lambda$10 = SaleOnBoardOrderViewKt.LineItems$lambda$14$lambda$11$lambda$10((SaleOnBoardLineItem) obj);
                            return LineItems$lambda$14$lambda$11$lambda$10;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                Function1 function1 = (Function1) rememberedValue;
                composer2.endReplaceGroup();
                composer2.startReplaceGroup(-2103160636);
                Object rememberedValue2 = composer2.rememberedValue();
                if (rememberedValue2 == companion3.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: k4.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit LineItems$lambda$14$lambda$13$lambda$12;
                            LineItems$lambda$14$lambda$13$lambda$12 = SaleOnBoardOrderViewKt.LineItems$lambda$14$lambda$13$lambda$12((String) obj);
                            return LineItems$lambda$14$lambda$13$lambda$12;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue2);
                }
                composer2.endReplaceGroup();
                SaleOnBoardLineItemViewKt.SaleOnBoardLineItemView(saleOnBoardLineItem, function1, (Function1) rememberedValue2, false, composer2, 3504, 0);
                HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer2, 0, 15);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            PriceDetailsViewKt.TotalPriceRow(new PriceTotal(priceWithCurrency), null, false, null, composer2, 0, 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: k4.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit LineItems$lambda$15;
                    LineItems$lambda$15 = SaleOnBoardOrderViewKt.LineItems$lambda$15(list, priceWithCurrency, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return LineItems$lambda$15;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LineItems$lambda$14$lambda$11$lambda$10(SaleOnBoardLineItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LineItems$lambda$14$lambda$13$lambda$12(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LineItems$lambda$15(List list, PriceWithCurrency priceWithCurrency, int i5, Composer composer, int i6) {
        LineItems(list, priceWithCurrency, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void NotificationInfo(final NotificationType notificationType, final PhoneNumber phoneNumber, Composer composer, final int i5) {
        int i6;
        Painter painterResource;
        String str;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1213128713);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(notificationType) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(phoneNumber) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1213128713, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.receipt.NotificationInfo (SaleOnBoardOrderView.kt:174)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 16;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m103backgroundbw27NRU(companion, AppColor.INSTANCE.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(f5));
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
            int[] iArr = WhenMappings.$EnumSwitchMapping$0;
            int i7 = iArr[notificationType.ordinal()];
            if (i7 == 1) {
                startRestartGroup.startReplaceGroup(-1388152718);
                painterResource = PainterResources_androidKt.painterResource(R.drawable.icon_notification_sms, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            } else {
                if (i7 != 2) {
                    startRestartGroup.startReplaceGroup(-1388154658);
                    startRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                startRestartGroup.startReplaceGroup(-1388149805);
                painterResource = PainterResources_androidKt.painterResource(R.drawable.icon_notification_bell, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            }
            IconKt.m857Iconww6aTOc(painterResource, Accessibility.INSTANCE.getSkip(), PaddingKt.m315paddingqDBjuR0$default(SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(f5)), 0.0f, Dp.m2599constructorimpl(4), 0.0f, 0.0f, 13, null), Color.INSTANCE.m1501getUnspecified0d7_KjU(), startRestartGroup, 3456, 0);
            float f6 = 8;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 0.0f, 14, null);
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
            int i8 = iArr[notificationType.ordinal()];
            if (i8 == 1) {
                startRestartGroup.startReplaceGroup(177840890);
                String stringResource = StringResources_androidKt.stringResource(R.string.saleOnBoard_receipt_smsInfo, new Object[]{phoneNumber.toFormattedString()}, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
                str = stringResource;
            } else {
                if (i8 != 2) {
                    startRestartGroup.startReplaceGroup(177838842);
                    startRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                startRestartGroup.startReplaceGroup(177845210);
                String stringResource2 = StringResources_androidKt.stringResource(R.string.saleOnBoard_receipt_pushInfo, startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
                str = stringResource2;
            }
            TextKt.m940Text4IGK_g(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), startRestartGroup, 0, 1572864, 65534);
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.saleOnBoard_receipt_notificationDisclaimer, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 48, 1572864, 65532);
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: k4.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit NotificationInfo$lambda$9;
                    NotificationInfo$lambda$9 = SaleOnBoardOrderViewKt.NotificationInfo$lambda$9(NotificationType.this, phoneNumber, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return NotificationInfo$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotificationInfo$lambda$9(NotificationType notificationType, PhoneNumber phoneNumber, int i5, Composer composer, int i6) {
        NotificationInfo(notificationType, phoneNumber, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void PickupInfo(final String str, final String str2, final String str3, final Function0<Unit> function0, final boolean z5, Composer composer, final int i5) {
        int i6;
        Object obj;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-140195215);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(str3) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-140195215, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.receipt.PickupInfo (SaleOnBoardOrderView.kt:107)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            AppColor appColor = AppColor.INSTANCE;
            Modifier.Companion companion2 = companion;
            float f5 = 16;
            float f6 = 24;
            Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(BorderKt.m108borderxT4_qwU(BackgroundKt.m103backgroundbw27NRU(fillMaxWidth$default, appColor.m3281getWhite0d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(1), appColor.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f6));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getCenterHorizontally(), startRestartGroup, 48);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(1065730772);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (rememberedValue == companion4.getEmpty()) {
                obj = null;
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            } else {
                obj = null;
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1065732542);
            if (!((Boolean) mutableState.getValue()).booleanValue()) {
                Modifier m325height3ABfNKs = SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(100));
                startRestartGroup.startReplaceGroup(1065740193);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion4.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: k4.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit PickupInfo$lambda$5$lambda$4$lambda$3;
                            PickupInfo$lambda$5$lambda$4$lambda$3 = SaleOnBoardOrderViewKt.PickupInfo$lambda$5$lambda$4$lambda$3(MutableState.this, (AsyncImagePainter.State.Error) obj2);
                            return PickupInfo$lambda$5$lambda$4$lambda$3;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                companion2 = companion2;
                ImageKt.Image(SingletonAsyncImagePainterKt.m2745rememberAsyncImagePainterMqRF_0(str2, null, null, null, null, null, (Function1) rememberedValue2, null, 0, startRestartGroup, ((i6 >> 3) & 14) | 1572864, 446), Accessibility.INSTANCE.getSkip(), m325height3ABfNKs, null, null, 0.0f, null, startRestartGroup, 384, 120);
            }
            startRestartGroup.endReplaceGroup();
            if (z5) {
                startRestartGroup.startReplaceGroup(-1321562735);
                long m3262getContrastGreen10d7_KjU = appColor.m3262getContrastGreen10d7_KjU();
                HighlightedTextKt.m3387HighlightedTextRuGn9fw(null, false, m3262getContrastGreen10d7_KjU, Color.m1481boximpl(ColorExtensionsKt.m3249withAlphaDxMtmZc(m3262getContrastGreen10d7_KjU, 0.4f)), null, ComposableSingletons$SaleOnBoardOrderViewKt.INSTANCE.m3537getLambda1$app_kombardoProd(), startRestartGroup, 196992, 19);
                TextKt.m940Text4IGK_g(str, PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(8), 5, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH1Bold(), startRestartGroup, (i6 & 14) | 48, 1572864, 65532);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-1320868862);
                float f7 = 8;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.saleOnBoard_receipt_pickupAt, new Object[]{str}, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(f7), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 48, 1572864, 65532);
                TextKt.m940Text4IGK_g(str3, PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(f7), 5, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH1Bold(), startRestartGroup, ((i6 >> 6) & 14) | 48, 1572864, 65532);
                startRestartGroup.endReplaceGroup();
            }
            startRestartGroup.startReplaceGroup(1065782951);
            if (function0 != null) {
                composer2 = startRestartGroup;
                PrimaryButtonKt.PrimaryButton(PaddingKt.m315paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, obj), 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 13, null), StringResources_androidKt.stringResource(R.string.saleOnBoard_receipt_toOrder, startRestartGroup, 6), function0, null, null, false, false, false, startRestartGroup, ((i6 >> 3) & 896) | 6, 248);
            } else {
                composer2 = startRestartGroup;
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: k4.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit PickupInfo$lambda$6;
                    PickupInfo$lambda$6 = SaleOnBoardOrderViewKt.PickupInfo$lambda$6(str, str2, str3, function0, z5, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    return PickupInfo$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PickupInfo$lambda$5$lambda$4$lambda$3(MutableState mutableState, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PickupInfo$lambda$6(String str, String str2, String str3, Function0 function0, boolean z5, int i5, Composer composer, int i6) {
        PickupInfo(str, str2, str3, function0, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SaleOnBoardOrderView(final String shopLocation, final String str, final String pickupTime, final List<SaleOnBoardLineItem> lineItems, final PriceWithCurrency totalPrice, final IDepartureInfo departure, final SaleOnBoardContactInfo contactInfo, final NotificationType notificationType, boolean z5, final Function0<Unit> function0, boolean z6, Composer composer, final int i5, final int i6, final int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z7;
        boolean z8;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Modifier.Companion companion;
        Composer composer2;
        int i12;
        int i13;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(shopLocation, "shopLocation");
        Intrinsics.checkNotNullParameter(pickupTime, "pickupTime");
        Intrinsics.checkNotNullParameter(lineItems, "lineItems");
        Intrinsics.checkNotNullParameter(totalPrice, "totalPrice");
        Intrinsics.checkNotNullParameter(departure, "departure");
        Intrinsics.checkNotNullParameter(contactInfo, "contactInfo");
        Intrinsics.checkNotNullParameter(notificationType, "notificationType");
        Composer startRestartGroup = composer.startRestartGroup(829131744);
        if ((i7 & 1) != 0) {
            i8 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i8 = i5 | (startRestartGroup.changed(shopLocation) ? 4 : 2);
        } else {
            i8 = i5;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i5 & 48) == 0) {
            i8 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        int i14 = i8;
        if ((i7 & 4) != 0) {
            i14 |= 384;
        } else if ((i5 & 384) == 0) {
            i14 |= startRestartGroup.changed(pickupTime) ? 256 : 128;
        }
        if ((i7 & 8) != 0) {
            i14 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i14 |= startRestartGroup.changedInstance(lineItems) ? 2048 : 1024;
        }
        if ((i7 & 16) != 0) {
            i14 |= 24576;
        } else if ((i5 & 24576) == 0) {
            i14 |= startRestartGroup.changedInstance(totalPrice) ? 16384 : 8192;
        }
        if ((i7 & 32) != 0) {
            i14 |= 196608;
        } else if ((i5 & 196608) == 0) {
            i14 |= startRestartGroup.changedInstance(departure) ? 131072 : 65536;
        }
        if ((i7 & 64) != 0) {
            i14 |= 1572864;
        } else if ((i5 & 1572864) == 0) {
            i14 |= startRestartGroup.changedInstance(contactInfo) ? 1048576 : 524288;
        }
        if ((128 & i7) != 0) {
            i14 |= 12582912;
        } else if ((i5 & 12582912) == 0) {
            i14 |= startRestartGroup.changed(notificationType) ? 8388608 : 4194304;
        }
        int i15 = 256 & i7;
        if (i15 != 0) {
            i14 |= 100663296;
        } else if ((100663296 & i5) == 0) {
            i14 |= startRestartGroup.changed(z5) ? 67108864 : 33554432;
            if ((i7 & 512) == 0) {
                i14 |= 805306368;
            } else if ((i5 & 805306368) == 0) {
                i14 |= startRestartGroup.changedInstance(function0) ? 536870912 : 268435456;
                i9 = 1024 & i7;
                if (i9 != 0) {
                    i11 = i6 | 6;
                } else {
                    if ((i6 & 6) != 0) {
                        i10 = i6;
                        if ((i14 & 306783379) != 306783378 && (i10 & 3) == 2 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            z7 = z5;
                            z8 = z6;
                            composer2 = startRestartGroup;
                        } else {
                            z7 = i15 == 0 ? true : z5;
                            z8 = i9 == 0 ? false : z6;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(829131744, i14, i10, "dk.molslinjen.ui.views.screens.saleOnBoard.receipt.SaleOnBoardOrderView (SaleOnBoardOrderView.kt:67)");
                            }
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
                            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                            Function0<ComposeUiNode> constructor = companion3.getConstructor();
                            if (startRestartGroup.getApplier() == null) {
                                ComposablesKt.invalidApplier();
                            }
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.getInserting()) {
                                startRestartGroup.useNode();
                            } else {
                                startRestartGroup.createNode(constructor);
                            }
                            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                            if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            startRestartGroup.startReplaceGroup(-1762429983);
                            if (z7) {
                                companion = companion2;
                                composer2 = startRestartGroup;
                                i12 = i14;
                                i13 = 32;
                            } else {
                                composer2 = startRestartGroup;
                                i12 = i14;
                                companion = companion2;
                                i13 = 32;
                                PickupInfo(shopLocation, str, pickupTime, function0, z8, composer2, (i14 & 1022) | ((i14 >> 18) & 7168) | ((i10 << 12) & 57344));
                                float f5 = 32;
                                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer2, 6);
                                NotificationInfo(notificationType, contactInfo.getPhoneNumber(), composer2, (i12 >> 21) & 14);
                                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer2, 6);
                            }
                            composer2.endReplaceGroup();
                            LineItems(lineItems, totalPrice, composer2, (i12 >> 9) & 126);
                            float f6 = 40;
                            Modifier.Companion companion4 = companion;
                            Composer composer3 = composer2;
                            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m315paddingqDBjuR0$default(companion4, 0.0f, Dp.m2599constructorimpl(16), 0.0f, Dp.m2599constructorimpl(f6), 5, null), 0L, 0.0f, null, composer3, 6, 14);
                            SaleOnBoardDepartureInfoSectionKt.SaleOnBoardDepartureInfoSection(departure, StringResources_androidKt.stringResource(R.string.saleOnBoard_receipt_orderedForThisDeparture, composer2, 6), composer2, (i12 >> 15) & 14);
                            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m315paddingqDBjuR0$default(companion4, 0.0f, Dp.m2599constructorimpl(i13), 0.0f, Dp.m2599constructorimpl(f6), 5, null), 0L, 0.0f, null, composer3, 6, 14);
                            ContactInfo(contactInfo, composer2, (i12 >> 18) & 14);
                            composer2.endNode();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                            final boolean z9 = z7;
                            final boolean z10 = z8;
                            endRestartGroup.updateScope(new Function2() { // from class: k4.a
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit SaleOnBoardOrderView$lambda$1;
                                    SaleOnBoardOrderView$lambda$1 = SaleOnBoardOrderViewKt.SaleOnBoardOrderView$lambda$1(shopLocation, str, pickupTime, lineItems, totalPrice, departure, contactInfo, notificationType, z9, function0, z10, i5, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                                    return SaleOnBoardOrderView$lambda$1;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i11 = i6 | (startRestartGroup.changed(z6) ? 4 : 2);
                }
                i10 = i11;
                if ((i14 & 306783379) != 306783378) {
                }
                if (i15 == 0) {
                }
                if (i9 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                Modifier.Companion companion22 = Modifier.INSTANCE;
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion22);
                ComposeUiNode.Companion companion32 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor2 = companion32.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2, companion32.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion32.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion32.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting()) {
                }
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion32.getSetModifier());
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                startRestartGroup.startReplaceGroup(-1762429983);
                if (z7) {
                }
                composer2.endReplaceGroup();
                LineItems(lineItems, totalPrice, composer2, (i12 >> 9) & 126);
                float f62 = 40;
                Modifier.Companion companion42 = companion;
                Composer composer32 = composer2;
                HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m315paddingqDBjuR0$default(companion42, 0.0f, Dp.m2599constructorimpl(16), 0.0f, Dp.m2599constructorimpl(f62), 5, null), 0L, 0.0f, null, composer32, 6, 14);
                SaleOnBoardDepartureInfoSectionKt.SaleOnBoardDepartureInfoSection(departure, StringResources_androidKt.stringResource(R.string.saleOnBoard_receipt_orderedForThisDeparture, composer2, 6), composer2, (i12 >> 15) & 14);
                HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m315paddingqDBjuR0$default(companion42, 0.0f, Dp.m2599constructorimpl(i13), 0.0f, Dp.m2599constructorimpl(f62), 5, null), 0L, 0.0f, null, composer32, 6, 14);
                ContactInfo(contactInfo, composer2, (i12 >> 18) & 14);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i9 = 1024 & i7;
            if (i9 != 0) {
            }
            i10 = i11;
            if ((i14 & 306783379) != 306783378) {
            }
            if (i15 == 0) {
            }
            if (i9 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier.Companion companion222 = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy22 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, companion222);
            ComposeUiNode.Companion companion322 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor22 = companion322.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy22, companion322.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion322.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion322.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion322.getSetModifier());
            ColumnScopeInstance columnScopeInstance22 = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-1762429983);
            if (z7) {
            }
            composer2.endReplaceGroup();
            LineItems(lineItems, totalPrice, composer2, (i12 >> 9) & 126);
            float f622 = 40;
            Modifier.Companion companion422 = companion;
            Composer composer322 = composer2;
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m315paddingqDBjuR0$default(companion422, 0.0f, Dp.m2599constructorimpl(16), 0.0f, Dp.m2599constructorimpl(f622), 5, null), 0L, 0.0f, null, composer322, 6, 14);
            SaleOnBoardDepartureInfoSectionKt.SaleOnBoardDepartureInfoSection(departure, StringResources_androidKt.stringResource(R.string.saleOnBoard_receipt_orderedForThisDeparture, composer2, 6), composer2, (i12 >> 15) & 14);
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m315paddingqDBjuR0$default(companion422, 0.0f, Dp.m2599constructorimpl(i13), 0.0f, Dp.m2599constructorimpl(f622), 5, null), 0L, 0.0f, null, composer322, 6, 14);
            ContactInfo(contactInfo, composer2, (i12 >> 18) & 14);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i7 & 512) == 0) {
        }
        i9 = 1024 & i7;
        if (i9 != 0) {
        }
        i10 = i11;
        if ((i14 & 306783379) != 306783378) {
        }
        if (i15 == 0) {
        }
        if (i9 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier.Companion companion2222 = Modifier.INSTANCE;
        MeasurePolicy columnMeasurePolicy222 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, companion2222);
        ComposeUiNode.Companion companion3222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor222 = companion3222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy222, companion3222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap222, companion3222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion3222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier222, companion3222.getSetModifier());
        ColumnScopeInstance columnScopeInstance222 = ColumnScopeInstance.INSTANCE;
        startRestartGroup.startReplaceGroup(-1762429983);
        if (z7) {
        }
        composer2.endReplaceGroup();
        LineItems(lineItems, totalPrice, composer2, (i12 >> 9) & 126);
        float f6222 = 40;
        Modifier.Companion companion4222 = companion;
        Composer composer3222 = composer2;
        HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m315paddingqDBjuR0$default(companion4222, 0.0f, Dp.m2599constructorimpl(16), 0.0f, Dp.m2599constructorimpl(f6222), 5, null), 0L, 0.0f, null, composer3222, 6, 14);
        SaleOnBoardDepartureInfoSectionKt.SaleOnBoardDepartureInfoSection(departure, StringResources_androidKt.stringResource(R.string.saleOnBoard_receipt_orderedForThisDeparture, composer2, 6), composer2, (i12 >> 15) & 14);
        HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m315paddingqDBjuR0$default(companion4222, 0.0f, Dp.m2599constructorimpl(i13), 0.0f, Dp.m2599constructorimpl(f6222), 5, null), 0L, 0.0f, null, composer3222, 6, 14);
        ContactInfo(contactInfo, composer2, (i12 >> 18) & 14);
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardOrderView$lambda$1(String str, String str2, String str3, List list, PriceWithCurrency priceWithCurrency, IDepartureInfo iDepartureInfo, SaleOnBoardContactInfo saleOnBoardContactInfo, NotificationType notificationType, boolean z5, Function0 function0, boolean z6, int i5, int i6, int i7, Composer composer, int i8) {
        SaleOnBoardOrderView(str, str2, str3, list, priceWithCurrency, iDepartureInfo, saleOnBoardContactInfo, notificationType, z5, function0, z6, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6), i7);
        return Unit.INSTANCE;
    }
}
