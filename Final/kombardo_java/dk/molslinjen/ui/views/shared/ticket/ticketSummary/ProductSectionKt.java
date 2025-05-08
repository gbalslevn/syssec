package dk.molslinjen.ui.views.shared.ticket.ticketSummary;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.booking.product.CheckoutSeatReservation;
import dk.molslinjen.domain.model.booking.product.ISummaryProduct;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.ProductSectionKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a]\u0010\r\u001a\u00020\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/ISummaryProduct;", "products", "Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;", "seatReservation", BuildConfig.FLAVOR, "showDetails", "Lkotlin/Function0;", BuildConfig.FLAVOR, "addProducts", "focused", "showEditButton", "boldTitle", "ProductSection", "(Ljava/util/List;Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;ZLkotlin/jvm/functions/Function0;ZZZLandroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProductSectionKt {
    /* JADX WARN: Removed duplicated region for block: B:13:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0110 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ProductSection(final List<? extends ISummaryProduct> products, final CheckoutSeatReservation checkoutSeatReservation, final boolean z5, Function0<Unit> function0, final boolean z6, boolean z7, boolean z8, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        Function0<Unit> function02;
        int i9;
        boolean z9;
        int i10;
        boolean z10;
        final Function0<Unit> function03;
        final boolean z11;
        final boolean z12;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(products, "products");
        Composer startRestartGroup = composer.startRestartGroup(-152522938);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(products) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(checkoutSeatReservation) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 256 : 128;
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                function02 = function0;
                i7 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
                if ((i6 & 16) != 0) {
                    i7 |= 24576;
                } else if ((i5 & 24576) == 0) {
                    i7 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                }
                i9 = i6 & 32;
                if (i9 != 0) {
                    i7 |= 196608;
                } else if ((196608 & i5) == 0) {
                    z9 = z7;
                    i7 |= startRestartGroup.changed(z9) ? 131072 : 65536;
                    i10 = i6 & 64;
                    if (i10 == 0) {
                        i7 |= 1572864;
                    } else if ((1572864 & i5) == 0) {
                        z10 = z8;
                        i7 |= startRestartGroup.changed(z10) ? 1048576 : 524288;
                        if ((599187 & i7) == 599186 || !startRestartGroup.getSkipping()) {
                            Function0<Unit> function04 = i8 != 0 ? null : function02;
                            boolean z13 = i9 != 0 ? false : z9;
                            boolean z14 = i10 != 0 ? false : z10;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-152522938, i7, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.ProductSection (ProductSection.kt:22)");
                            }
                            int i11 = ((i7 >> 9) & 112) | 807075840 | (i7 & 896) | ((i7 << 3) & 57344);
                            int i12 = i7 << 6;
                            SectionContainerKt.m3561SectionContainervCe147k(StringResources_androidKt.stringResource(R.string.ticketSummary_productSection_title, startRestartGroup, 6), z6, z5, !products.isEmpty() && checkoutSeatReservation == null, function04, Dp.m2599constructorimpl(0), Dp.m2599constructorimpl(16), z13, z14, ComposableLambdaKt.rememberComposableLambda(-755470700, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.ProductSectionKt$ProductSection$1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i13) {
                                    PriceWithCurrency totalPrice;
                                    CurrencyType currencyType;
                                    PriceWithCurrency price;
                                    PriceWithCurrency totalPrice2;
                                    if ((i13 & 3) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-755470700, i13, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.ProductSection.<anonymous> (ProductSection.kt:34)");
                                    }
                                    Iterator<T> it = products.iterator();
                                    int i14 = 0;
                                    int i15 = 0;
                                    while (it.hasNext()) {
                                        i15 += ((ISummaryProduct) it.next()).getQuantity();
                                    }
                                    int i16 = i15 + (checkoutSeatReservation != null ? 1 : 0);
                                    String quantityString = ((Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources().getQuantityString(R.plurals.ticketSummary_addOns_quantity, i16, Integer.valueOf(i16));
                                    Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
                                    Iterator<T> it2 = products.iterator();
                                    int i17 = 0;
                                    while (it2.hasNext()) {
                                        i17 += ((ISummaryProduct) it2.next()).sum().getValue();
                                    }
                                    CheckoutSeatReservation checkoutSeatReservation2 = checkoutSeatReservation;
                                    if (checkoutSeatReservation2 != null && (totalPrice2 = checkoutSeatReservation2.getTotalPrice()) != null) {
                                        i14 = totalPrice2.getValue();
                                    }
                                    int i18 = i17 + i14;
                                    ISummaryProduct iSummaryProduct = (ISummaryProduct) CollectionsKt.firstOrNull((List) products);
                                    if (iSummaryProduct == null || (price = iSummaryProduct.getPrice()) == null || (currencyType = price.getCurrencyType()) == null) {
                                        CheckoutSeatReservation checkoutSeatReservation3 = checkoutSeatReservation;
                                        if (checkoutSeatReservation3 == null || (totalPrice = checkoutSeatReservation3.getTotalPrice()) == null) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        currencyType = totalPrice.getCurrencyType();
                                    }
                                    SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, quantityString, null, new PriceWithCurrency(i18, currencyType), composer2, 6, 4);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-168742010, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.ProductSectionKt$ProductSection$2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i13) {
                                    if ((i13 & 3) == 2 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-168742010, i13, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.ProductSection.<anonymous> (ProductSection.kt:52)");
                                    }
                                    composer2.startReplaceGroup(1577003679);
                                    for (ISummaryProduct iSummaryProduct : products) {
                                        SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, iSummaryProduct.getName(), iSummaryProduct.showQuantity() ? Integer.valueOf(iSummaryProduct.getQuantity()) : null, iSummaryProduct.sum(), composer2, 6, 0);
                                    }
                                    composer2.endReplaceGroup();
                                    if (checkoutSeatReservation != null) {
                                        SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, StringResources_androidKt.stringResource(R.string.ticketDetails_seatReservation, composer2, 6), null, checkoutSeatReservation.getTotalPrice(), composer2, 6, 4);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), startRestartGroup, i11 | (29360128 & i12) | (i12 & 234881024), 6, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function03 = function04;
                            z11 = z13;
                            z12 = z14;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function03 = function02;
                            z11 = z9;
                            z12 = z10;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: C4.m
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit ProductSection$lambda$0;
                                    ProductSection$lambda$0 = ProductSectionKt.ProductSection$lambda$0(products, checkoutSeatReservation, z5, function03, z6, z11, z12, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                    return ProductSection$lambda$0;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    z10 = z8;
                    if ((599187 & i7) == 599186) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (products.isEmpty()) {
                    }
                    int i112 = ((i7 >> 9) & 112) | 807075840 | (i7 & 896) | ((i7 << 3) & 57344);
                    int i122 = i7 << 6;
                    SectionContainerKt.m3561SectionContainervCe147k(StringResources_androidKt.stringResource(R.string.ticketSummary_productSection_title, startRestartGroup, 6), z6, z5, !products.isEmpty() && checkoutSeatReservation == null, function04, Dp.m2599constructorimpl(0), Dp.m2599constructorimpl(16), z13, z14, ComposableLambdaKt.rememberComposableLambda(-755470700, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.ProductSectionKt$ProductSection$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i13) {
                            PriceWithCurrency totalPrice;
                            CurrencyType currencyType;
                            PriceWithCurrency price;
                            PriceWithCurrency totalPrice2;
                            if ((i13 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-755470700, i13, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.ProductSection.<anonymous> (ProductSection.kt:34)");
                            }
                            Iterator<T> it = products.iterator();
                            int i14 = 0;
                            int i15 = 0;
                            while (it.hasNext()) {
                                i15 += ((ISummaryProduct) it.next()).getQuantity();
                            }
                            int i16 = i15 + (checkoutSeatReservation != null ? 1 : 0);
                            String quantityString = ((Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources().getQuantityString(R.plurals.ticketSummary_addOns_quantity, i16, Integer.valueOf(i16));
                            Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
                            Iterator<T> it2 = products.iterator();
                            int i17 = 0;
                            while (it2.hasNext()) {
                                i17 += ((ISummaryProduct) it2.next()).sum().getValue();
                            }
                            CheckoutSeatReservation checkoutSeatReservation2 = checkoutSeatReservation;
                            if (checkoutSeatReservation2 != null && (totalPrice2 = checkoutSeatReservation2.getTotalPrice()) != null) {
                                i14 = totalPrice2.getValue();
                            }
                            int i18 = i17 + i14;
                            ISummaryProduct iSummaryProduct = (ISummaryProduct) CollectionsKt.firstOrNull((List) products);
                            if (iSummaryProduct == null || (price = iSummaryProduct.getPrice()) == null || (currencyType = price.getCurrencyType()) == null) {
                                CheckoutSeatReservation checkoutSeatReservation3 = checkoutSeatReservation;
                                if (checkoutSeatReservation3 == null || (totalPrice = checkoutSeatReservation3.getTotalPrice()) == null) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                currencyType = totalPrice.getCurrencyType();
                            }
                            SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, quantityString, null, new PriceWithCurrency(i18, currencyType), composer2, 6, 4);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-168742010, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.ProductSectionKt$ProductSection$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i13) {
                            if ((i13 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-168742010, i13, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.ProductSection.<anonymous> (ProductSection.kt:52)");
                            }
                            composer2.startReplaceGroup(1577003679);
                            for (ISummaryProduct iSummaryProduct : products) {
                                SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, iSummaryProduct.getName(), iSummaryProduct.showQuantity() ? Integer.valueOf(iSummaryProduct.getQuantity()) : null, iSummaryProduct.sum(), composer2, 6, 0);
                            }
                            composer2.endReplaceGroup();
                            if (checkoutSeatReservation != null) {
                                SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, StringResources_androidKt.stringResource(R.string.ticketDetails_seatReservation, composer2, 6), null, checkoutSeatReservation.getTotalPrice(), composer2, 6, 4);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, i112 | (29360128 & i122) | (i122 & 234881024), 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function03 = function04;
                    z11 = z13;
                    z12 = z14;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z9 = z7;
                i10 = i6 & 64;
                if (i10 == 0) {
                }
                z10 = z8;
                if ((599187 & i7) == 599186) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                if (products.isEmpty()) {
                }
                int i1122 = ((i7 >> 9) & 112) | 807075840 | (i7 & 896) | ((i7 << 3) & 57344);
                int i1222 = i7 << 6;
                SectionContainerKt.m3561SectionContainervCe147k(StringResources_androidKt.stringResource(R.string.ticketSummary_productSection_title, startRestartGroup, 6), z6, z5, !products.isEmpty() && checkoutSeatReservation == null, function04, Dp.m2599constructorimpl(0), Dp.m2599constructorimpl(16), z13, z14, ComposableLambdaKt.rememberComposableLambda(-755470700, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.ProductSectionKt$ProductSection$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i13) {
                        PriceWithCurrency totalPrice;
                        CurrencyType currencyType;
                        PriceWithCurrency price;
                        PriceWithCurrency totalPrice2;
                        if ((i13 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-755470700, i13, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.ProductSection.<anonymous> (ProductSection.kt:34)");
                        }
                        Iterator<T> it = products.iterator();
                        int i14 = 0;
                        int i15 = 0;
                        while (it.hasNext()) {
                            i15 += ((ISummaryProduct) it.next()).getQuantity();
                        }
                        int i16 = i15 + (checkoutSeatReservation != null ? 1 : 0);
                        String quantityString = ((Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources().getQuantityString(R.plurals.ticketSummary_addOns_quantity, i16, Integer.valueOf(i16));
                        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
                        Iterator<T> it2 = products.iterator();
                        int i17 = 0;
                        while (it2.hasNext()) {
                            i17 += ((ISummaryProduct) it2.next()).sum().getValue();
                        }
                        CheckoutSeatReservation checkoutSeatReservation2 = checkoutSeatReservation;
                        if (checkoutSeatReservation2 != null && (totalPrice2 = checkoutSeatReservation2.getTotalPrice()) != null) {
                            i14 = totalPrice2.getValue();
                        }
                        int i18 = i17 + i14;
                        ISummaryProduct iSummaryProduct = (ISummaryProduct) CollectionsKt.firstOrNull((List) products);
                        if (iSummaryProduct == null || (price = iSummaryProduct.getPrice()) == null || (currencyType = price.getCurrencyType()) == null) {
                            CheckoutSeatReservation checkoutSeatReservation3 = checkoutSeatReservation;
                            if (checkoutSeatReservation3 == null || (totalPrice = checkoutSeatReservation3.getTotalPrice()) == null) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            currencyType = totalPrice.getCurrencyType();
                        }
                        SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, quantityString, null, new PriceWithCurrency(i18, currencyType), composer2, 6, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-168742010, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.ProductSectionKt$ProductSection$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i13) {
                        if ((i13 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-168742010, i13, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.ProductSection.<anonymous> (ProductSection.kt:52)");
                        }
                        composer2.startReplaceGroup(1577003679);
                        for (ISummaryProduct iSummaryProduct : products) {
                            SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, iSummaryProduct.getName(), iSummaryProduct.showQuantity() ? Integer.valueOf(iSummaryProduct.getQuantity()) : null, iSummaryProduct.sum(), composer2, 6, 0);
                        }
                        composer2.endReplaceGroup();
                        if (checkoutSeatReservation != null) {
                            SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, StringResources_androidKt.stringResource(R.string.ticketDetails_seatReservation, composer2, 6), null, checkoutSeatReservation.getTotalPrice(), composer2, 6, 4);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, i1122 | (29360128 & i1222) | (i1222 & 234881024), 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                function03 = function04;
                z11 = z13;
                z12 = z14;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function02 = function0;
            if ((i6 & 16) != 0) {
            }
            i9 = i6 & 32;
            if (i9 != 0) {
            }
            z9 = z7;
            i10 = i6 & 64;
            if (i10 == 0) {
            }
            z10 = z8;
            if ((599187 & i7) == 599186) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            if (products.isEmpty()) {
            }
            int i11222 = ((i7 >> 9) & 112) | 807075840 | (i7 & 896) | ((i7 << 3) & 57344);
            int i12222 = i7 << 6;
            SectionContainerKt.m3561SectionContainervCe147k(StringResources_androidKt.stringResource(R.string.ticketSummary_productSection_title, startRestartGroup, 6), z6, z5, !products.isEmpty() && checkoutSeatReservation == null, function04, Dp.m2599constructorimpl(0), Dp.m2599constructorimpl(16), z13, z14, ComposableLambdaKt.rememberComposableLambda(-755470700, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.ProductSectionKt$ProductSection$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i13) {
                    PriceWithCurrency totalPrice;
                    CurrencyType currencyType;
                    PriceWithCurrency price;
                    PriceWithCurrency totalPrice2;
                    if ((i13 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-755470700, i13, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.ProductSection.<anonymous> (ProductSection.kt:34)");
                    }
                    Iterator<T> it = products.iterator();
                    int i14 = 0;
                    int i15 = 0;
                    while (it.hasNext()) {
                        i15 += ((ISummaryProduct) it.next()).getQuantity();
                    }
                    int i16 = i15 + (checkoutSeatReservation != null ? 1 : 0);
                    String quantityString = ((Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources().getQuantityString(R.plurals.ticketSummary_addOns_quantity, i16, Integer.valueOf(i16));
                    Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
                    Iterator<T> it2 = products.iterator();
                    int i17 = 0;
                    while (it2.hasNext()) {
                        i17 += ((ISummaryProduct) it2.next()).sum().getValue();
                    }
                    CheckoutSeatReservation checkoutSeatReservation2 = checkoutSeatReservation;
                    if (checkoutSeatReservation2 != null && (totalPrice2 = checkoutSeatReservation2.getTotalPrice()) != null) {
                        i14 = totalPrice2.getValue();
                    }
                    int i18 = i17 + i14;
                    ISummaryProduct iSummaryProduct = (ISummaryProduct) CollectionsKt.firstOrNull((List) products);
                    if (iSummaryProduct == null || (price = iSummaryProduct.getPrice()) == null || (currencyType = price.getCurrencyType()) == null) {
                        CheckoutSeatReservation checkoutSeatReservation3 = checkoutSeatReservation;
                        if (checkoutSeatReservation3 == null || (totalPrice = checkoutSeatReservation3.getTotalPrice()) == null) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        currencyType = totalPrice.getCurrencyType();
                    }
                    SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, quantityString, null, new PriceWithCurrency(i18, currencyType), composer2, 6, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-168742010, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.ProductSectionKt$ProductSection$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i13) {
                    if ((i13 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-168742010, i13, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.ProductSection.<anonymous> (ProductSection.kt:52)");
                    }
                    composer2.startReplaceGroup(1577003679);
                    for (ISummaryProduct iSummaryProduct : products) {
                        SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, iSummaryProduct.getName(), iSummaryProduct.showQuantity() ? Integer.valueOf(iSummaryProduct.getQuantity()) : null, iSummaryProduct.sum(), composer2, 6, 0);
                    }
                    composer2.endReplaceGroup();
                    if (checkoutSeatReservation != null) {
                        SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, StringResources_androidKt.stringResource(R.string.ticketDetails_seatReservation, composer2, 6), null, checkoutSeatReservation.getTotalPrice(), composer2, 6, 4);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, i11222 | (29360128 & i12222) | (i12222 & 234881024), 6, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            function03 = function04;
            z11 = z13;
            z12 = z14;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        function02 = function0;
        if ((i6 & 16) != 0) {
        }
        i9 = i6 & 32;
        if (i9 != 0) {
        }
        z9 = z7;
        i10 = i6 & 64;
        if (i10 == 0) {
        }
        z10 = z8;
        if ((599187 & i7) == 599186) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (products.isEmpty()) {
        }
        int i112222 = ((i7 >> 9) & 112) | 807075840 | (i7 & 896) | ((i7 << 3) & 57344);
        int i122222 = i7 << 6;
        SectionContainerKt.m3561SectionContainervCe147k(StringResources_androidKt.stringResource(R.string.ticketSummary_productSection_title, startRestartGroup, 6), z6, z5, !products.isEmpty() && checkoutSeatReservation == null, function04, Dp.m2599constructorimpl(0), Dp.m2599constructorimpl(16), z13, z14, ComposableLambdaKt.rememberComposableLambda(-755470700, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.ProductSectionKt$ProductSection$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i13) {
                PriceWithCurrency totalPrice;
                CurrencyType currencyType;
                PriceWithCurrency price;
                PriceWithCurrency totalPrice2;
                if ((i13 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-755470700, i13, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.ProductSection.<anonymous> (ProductSection.kt:34)");
                }
                Iterator<T> it = products.iterator();
                int i14 = 0;
                int i15 = 0;
                while (it.hasNext()) {
                    i15 += ((ISummaryProduct) it.next()).getQuantity();
                }
                int i16 = i15 + (checkoutSeatReservation != null ? 1 : 0);
                String quantityString = ((Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources().getQuantityString(R.plurals.ticketSummary_addOns_quantity, i16, Integer.valueOf(i16));
                Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
                Iterator<T> it2 = products.iterator();
                int i17 = 0;
                while (it2.hasNext()) {
                    i17 += ((ISummaryProduct) it2.next()).sum().getValue();
                }
                CheckoutSeatReservation checkoutSeatReservation2 = checkoutSeatReservation;
                if (checkoutSeatReservation2 != null && (totalPrice2 = checkoutSeatReservation2.getTotalPrice()) != null) {
                    i14 = totalPrice2.getValue();
                }
                int i18 = i17 + i14;
                ISummaryProduct iSummaryProduct = (ISummaryProduct) CollectionsKt.firstOrNull((List) products);
                if (iSummaryProduct == null || (price = iSummaryProduct.getPrice()) == null || (currencyType = price.getCurrencyType()) == null) {
                    CheckoutSeatReservation checkoutSeatReservation3 = checkoutSeatReservation;
                    if (checkoutSeatReservation3 == null || (totalPrice = checkoutSeatReservation3.getTotalPrice()) == null) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    currencyType = totalPrice.getCurrencyType();
                }
                SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, quantityString, null, new PriceWithCurrency(i18, currencyType), composer2, 6, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-168742010, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.ProductSectionKt$ProductSection$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i13) {
                if ((i13 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-168742010, i13, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.ProductSection.<anonymous> (ProductSection.kt:52)");
                }
                composer2.startReplaceGroup(1577003679);
                for (ISummaryProduct iSummaryProduct : products) {
                    SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, iSummaryProduct.getName(), iSummaryProduct.showQuantity() ? Integer.valueOf(iSummaryProduct.getQuantity()) : null, iSummaryProduct.sum(), composer2, 6, 0);
                }
                composer2.endReplaceGroup();
                if (checkoutSeatReservation != null) {
                    SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, StringResources_androidKt.stringResource(R.string.ticketDetails_seatReservation, composer2, 6), null, checkoutSeatReservation.getTotalPrice(), composer2, 6, 4);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), startRestartGroup, i112222 | (29360128 & i122222) | (i122222 & 234881024), 6, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        function03 = function04;
        z11 = z13;
        z12 = z14;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductSection$lambda$0(List list, CheckoutSeatReservation checkoutSeatReservation, boolean z5, Function0 function0, boolean z6, boolean z7, boolean z8, int i5, int i6, Composer composer, int i7) {
        ProductSection(list, checkoutSeatReservation, z5, function0, z6, z7, z8, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
