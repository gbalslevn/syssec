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
import dk.molslinjen.domain.model.booking.product.ISummaryProduct;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.FoodSectionKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u001aS\u0010\u000b\u001a\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/ISummaryProduct;", "products", BuildConfig.FLAVOR, "showDetails", "Lkotlin/Function0;", BuildConfig.FLAVOR, "addProducts", "focused", "showEditButton", "boldTitle", "FoodSection", "(Ljava/util/List;ZLkotlin/jvm/functions/Function0;ZZZLandroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FoodSectionKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FoodSection(final List<? extends ISummaryProduct> products, final boolean z5, Function0<Unit> function0, final boolean z6, boolean z7, boolean z8, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        Function0<Unit> function02;
        int i9;
        boolean z9;
        int i10;
        boolean z10;
        final boolean z11;
        final Function0<Unit> function03;
        final boolean z12;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(products, "products");
        Composer startRestartGroup = composer.startRestartGroup(419287361);
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
            i7 |= startRestartGroup.changed(z5) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                function02 = function0;
                i7 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
                if ((i6 & 8) != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    i7 |= startRestartGroup.changed(z6) ? 2048 : 1024;
                }
                i9 = i6 & 16;
                if (i9 != 0) {
                    i7 |= 24576;
                } else if ((i5 & 24576) == 0) {
                    z9 = z7;
                    i7 |= startRestartGroup.changed(z9) ? 16384 : 8192;
                    i10 = i6 & 32;
                    if (i10 == 0) {
                        i7 |= 196608;
                    } else if ((196608 & i5) == 0) {
                        z10 = z8;
                        i7 |= startRestartGroup.changed(z10) ? 131072 : 65536;
                        if ((74899 & i7) == 74898 || !startRestartGroup.getSkipping()) {
                            Function0<Unit> function04 = i8 != 0 ? null : function02;
                            boolean z13 = i9 != 0 ? false : z9;
                            z11 = i10 == 0 ? z10 : false;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(419287361, i7, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.FoodSection (FoodSection.kt:20)");
                            }
                            int i11 = ((i7 >> 6) & 112) | 807075840 | ((i7 << 3) & 896) | ((i7 << 6) & 57344);
                            int i12 = i7 << 9;
                            SectionContainerKt.m3561SectionContainervCe147k(StringResources_androidKt.stringResource(R.string.ticketSummary_foodSection_title, startRestartGroup, 6), z6, z5, products.isEmpty(), function04, Dp.m2599constructorimpl(8), Dp.m2599constructorimpl(24), z13, z11, ComposableLambdaKt.rememberComposableLambda(-626152177, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.FoodSectionKt$FoodSection$1
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
                                        ComposerKt.traceEventStart(-626152177, i13, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.FoodSection.<anonymous> (FoodSection.kt:32)");
                                    }
                                    Iterator<T> it = products.iterator();
                                    int i14 = 0;
                                    int i15 = 0;
                                    while (it.hasNext()) {
                                        i15 += ((ISummaryProduct) it.next()).getQuantity();
                                    }
                                    String quantityString = ((Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources().getQuantityString(R.plurals.ticketSummary_foodAndDrinks_quantity, i15, Integer.valueOf(i15));
                                    Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
                                    ISummaryProduct iSummaryProduct = (ISummaryProduct) CollectionsKt.firstOrNull((List) products);
                                    if (iSummaryProduct == null) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    CurrencyType currencyType = iSummaryProduct.getPrice().getCurrencyType();
                                    Iterator<T> it2 = products.iterator();
                                    while (it2.hasNext()) {
                                        i14 += ((ISummaryProduct) it2.next()).sum().getValue();
                                    }
                                    SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, quantityString, null, new PriceWithCurrency(i14, currencyType), composer2, 6, 4);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-455654015, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.FoodSectionKt$FoodSection$2
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
                                        ComposerKt.traceEventStart(-455654015, i13, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.FoodSection.<anonymous> (FoodSection.kt:47)");
                                    }
                                    for (ISummaryProduct iSummaryProduct : products) {
                                        SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, iSummaryProduct.getName(), Integer.valueOf(iSummaryProduct.getQuantity()), iSummaryProduct.sum(), composer2, 6, 0);
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
                            z12 = z13;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            function03 = function02;
                            z12 = z9;
                            z11 = z10;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: C4.d
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit FoodSection$lambda$0;
                                    FoodSection$lambda$0 = FoodSectionKt.FoodSection$lambda$0(products, z5, function03, z6, z12, z11, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                    return FoodSection$lambda$0;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    z10 = z8;
                    if ((74899 & i7) == 74898) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i112 = ((i7 >> 6) & 112) | 807075840 | ((i7 << 3) & 896) | ((i7 << 6) & 57344);
                    int i122 = i7 << 9;
                    SectionContainerKt.m3561SectionContainervCe147k(StringResources_androidKt.stringResource(R.string.ticketSummary_foodSection_title, startRestartGroup, 6), z6, z5, products.isEmpty(), function04, Dp.m2599constructorimpl(8), Dp.m2599constructorimpl(24), z13, z11, ComposableLambdaKt.rememberComposableLambda(-626152177, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.FoodSectionKt$FoodSection$1
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
                                ComposerKt.traceEventStart(-626152177, i13, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.FoodSection.<anonymous> (FoodSection.kt:32)");
                            }
                            Iterator<T> it = products.iterator();
                            int i14 = 0;
                            int i15 = 0;
                            while (it.hasNext()) {
                                i15 += ((ISummaryProduct) it.next()).getQuantity();
                            }
                            String quantityString = ((Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources().getQuantityString(R.plurals.ticketSummary_foodAndDrinks_quantity, i15, Integer.valueOf(i15));
                            Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
                            ISummaryProduct iSummaryProduct = (ISummaryProduct) CollectionsKt.firstOrNull((List) products);
                            if (iSummaryProduct == null) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            CurrencyType currencyType = iSummaryProduct.getPrice().getCurrencyType();
                            Iterator<T> it2 = products.iterator();
                            while (it2.hasNext()) {
                                i14 += ((ISummaryProduct) it2.next()).sum().getValue();
                            }
                            SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, quantityString, null, new PriceWithCurrency(i14, currencyType), composer2, 6, 4);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-455654015, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.FoodSectionKt$FoodSection$2
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
                                ComposerKt.traceEventStart(-455654015, i13, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.FoodSection.<anonymous> (FoodSection.kt:47)");
                            }
                            for (ISummaryProduct iSummaryProduct : products) {
                                SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, iSummaryProduct.getName(), Integer.valueOf(iSummaryProduct.getQuantity()), iSummaryProduct.sum(), composer2, 6, 0);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, i112 | (29360128 & i122) | (i122 & 234881024), 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function03 = function04;
                    z12 = z13;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z9 = z7;
                i10 = i6 & 32;
                if (i10 == 0) {
                }
                z10 = z8;
                if ((74899 & i7) == 74898) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1122 = ((i7 >> 6) & 112) | 807075840 | ((i7 << 3) & 896) | ((i7 << 6) & 57344);
                int i1222 = i7 << 9;
                SectionContainerKt.m3561SectionContainervCe147k(StringResources_androidKt.stringResource(R.string.ticketSummary_foodSection_title, startRestartGroup, 6), z6, z5, products.isEmpty(), function04, Dp.m2599constructorimpl(8), Dp.m2599constructorimpl(24), z13, z11, ComposableLambdaKt.rememberComposableLambda(-626152177, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.FoodSectionKt$FoodSection$1
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
                            ComposerKt.traceEventStart(-626152177, i13, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.FoodSection.<anonymous> (FoodSection.kt:32)");
                        }
                        Iterator<T> it = products.iterator();
                        int i14 = 0;
                        int i15 = 0;
                        while (it.hasNext()) {
                            i15 += ((ISummaryProduct) it.next()).getQuantity();
                        }
                        String quantityString = ((Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources().getQuantityString(R.plurals.ticketSummary_foodAndDrinks_quantity, i15, Integer.valueOf(i15));
                        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
                        ISummaryProduct iSummaryProduct = (ISummaryProduct) CollectionsKt.firstOrNull((List) products);
                        if (iSummaryProduct == null) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        CurrencyType currencyType = iSummaryProduct.getPrice().getCurrencyType();
                        Iterator<T> it2 = products.iterator();
                        while (it2.hasNext()) {
                            i14 += ((ISummaryProduct) it2.next()).sum().getValue();
                        }
                        SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, quantityString, null, new PriceWithCurrency(i14, currencyType), composer2, 6, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-455654015, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.FoodSectionKt$FoodSection$2
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
                            ComposerKt.traceEventStart(-455654015, i13, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.FoodSection.<anonymous> (FoodSection.kt:47)");
                        }
                        for (ISummaryProduct iSummaryProduct : products) {
                            SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, iSummaryProduct.getName(), Integer.valueOf(iSummaryProduct.getQuantity()), iSummaryProduct.sum(), composer2, 6, 0);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, i1122 | (29360128 & i1222) | (i1222 & 234881024), 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                function03 = function04;
                z12 = z13;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function02 = function0;
            if ((i6 & 8) != 0) {
            }
            i9 = i6 & 16;
            if (i9 != 0) {
            }
            z9 = z7;
            i10 = i6 & 32;
            if (i10 == 0) {
            }
            z10 = z8;
            if ((74899 & i7) == 74898) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i11222 = ((i7 >> 6) & 112) | 807075840 | ((i7 << 3) & 896) | ((i7 << 6) & 57344);
            int i12222 = i7 << 9;
            SectionContainerKt.m3561SectionContainervCe147k(StringResources_androidKt.stringResource(R.string.ticketSummary_foodSection_title, startRestartGroup, 6), z6, z5, products.isEmpty(), function04, Dp.m2599constructorimpl(8), Dp.m2599constructorimpl(24), z13, z11, ComposableLambdaKt.rememberComposableLambda(-626152177, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.FoodSectionKt$FoodSection$1
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
                        ComposerKt.traceEventStart(-626152177, i13, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.FoodSection.<anonymous> (FoodSection.kt:32)");
                    }
                    Iterator<T> it = products.iterator();
                    int i14 = 0;
                    int i15 = 0;
                    while (it.hasNext()) {
                        i15 += ((ISummaryProduct) it.next()).getQuantity();
                    }
                    String quantityString = ((Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources().getQuantityString(R.plurals.ticketSummary_foodAndDrinks_quantity, i15, Integer.valueOf(i15));
                    Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
                    ISummaryProduct iSummaryProduct = (ISummaryProduct) CollectionsKt.firstOrNull((List) products);
                    if (iSummaryProduct == null) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    CurrencyType currencyType = iSummaryProduct.getPrice().getCurrencyType();
                    Iterator<T> it2 = products.iterator();
                    while (it2.hasNext()) {
                        i14 += ((ISummaryProduct) it2.next()).sum().getValue();
                    }
                    SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, quantityString, null, new PriceWithCurrency(i14, currencyType), composer2, 6, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-455654015, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.FoodSectionKt$FoodSection$2
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
                        ComposerKt.traceEventStart(-455654015, i13, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.FoodSection.<anonymous> (FoodSection.kt:47)");
                    }
                    for (ISummaryProduct iSummaryProduct : products) {
                        SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, iSummaryProduct.getName(), Integer.valueOf(iSummaryProduct.getQuantity()), iSummaryProduct.sum(), composer2, 6, 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, i11222 | (29360128 & i12222) | (i12222 & 234881024), 6, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            function03 = function04;
            z12 = z13;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        function02 = function0;
        if ((i6 & 8) != 0) {
        }
        i9 = i6 & 16;
        if (i9 != 0) {
        }
        z9 = z7;
        i10 = i6 & 32;
        if (i10 == 0) {
        }
        z10 = z8;
        if ((74899 & i7) == 74898) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i112222 = ((i7 >> 6) & 112) | 807075840 | ((i7 << 3) & 896) | ((i7 << 6) & 57344);
        int i122222 = i7 << 9;
        SectionContainerKt.m3561SectionContainervCe147k(StringResources_androidKt.stringResource(R.string.ticketSummary_foodSection_title, startRestartGroup, 6), z6, z5, products.isEmpty(), function04, Dp.m2599constructorimpl(8), Dp.m2599constructorimpl(24), z13, z11, ComposableLambdaKt.rememberComposableLambda(-626152177, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.FoodSectionKt$FoodSection$1
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
                    ComposerKt.traceEventStart(-626152177, i13, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.FoodSection.<anonymous> (FoodSection.kt:32)");
                }
                Iterator<T> it = products.iterator();
                int i14 = 0;
                int i15 = 0;
                while (it.hasNext()) {
                    i15 += ((ISummaryProduct) it.next()).getQuantity();
                }
                String quantityString = ((Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getResources().getQuantityString(R.plurals.ticketSummary_foodAndDrinks_quantity, i15, Integer.valueOf(i15));
                Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
                ISummaryProduct iSummaryProduct = (ISummaryProduct) CollectionsKt.firstOrNull((List) products);
                if (iSummaryProduct == null) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                CurrencyType currencyType = iSummaryProduct.getPrice().getCurrencyType();
                Iterator<T> it2 = products.iterator();
                while (it2.hasNext()) {
                    i14 += ((ISummaryProduct) it2.next()).sum().getValue();
                }
                SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, quantityString, null, new PriceWithCurrency(i14, currencyType), composer2, 6, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-455654015, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.FoodSectionKt$FoodSection$2
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
                    ComposerKt.traceEventStart(-455654015, i13, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.FoodSection.<anonymous> (FoodSection.kt:47)");
                }
                for (ISummaryProduct iSummaryProduct : products) {
                    SummaryRowKt.SummaryRow(R.drawable.icon_checkmark_circle, iSummaryProduct.getName(), Integer.valueOf(iSummaryProduct.getQuantity()), iSummaryProduct.sum(), composer2, 6, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), startRestartGroup, i112222 | (29360128 & i122222) | (i122222 & 234881024), 6, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        function03 = function04;
        z12 = z13;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FoodSection$lambda$0(List list, boolean z5, Function0 function0, boolean z6, boolean z7, boolean z8, int i5, int i6, Composer composer, int i7) {
        FoodSection(list, z5, function0, z6, z7, z8, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
