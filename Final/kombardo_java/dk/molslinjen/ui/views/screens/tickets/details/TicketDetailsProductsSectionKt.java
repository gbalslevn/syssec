package dk.molslinjen.ui.views.screens.tickets.details;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
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
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImagePainterKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.booking.Barcode;
import dk.molslinjen.domain.model.booking.BarcodeType;
import dk.molslinjen.domain.model.booking.BookingSeatReservation;
import dk.molslinjen.domain.model.booking.BookingTicket;
import dk.molslinjen.domain.model.booking.LineItem;
import dk.molslinjen.domain.model.booking.ProductType;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsProductsSectionKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerrySeat;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001au\u0010\u000e\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00062\u001e\u0010\u000b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0004\b\u000e\u0010\u000f\u001a5\u0010\u0010\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a]\u0010\u0012\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u001e\u0010\u000b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001d\u0010\u0016\u001a\u00020\t*\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a+\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\b2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\t0\fH\u0003¢\u0006\u0004\b\u001b\u0010\u001c\u001aG\u0010#\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0!H\u0003¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListScope;", "Ldk/molslinjen/domain/model/booking/BookingTicket;", "ticket", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "saleOnBoardOrders", "Lkotlin/Function2;", "Ldk/molslinjen/domain/model/booking/LineItem;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "showLoungeAccessBarcode", "showFoodBarcode", "Lkotlin/Function1;", "showSaleOnBoardDetails", "ticketDetailsProductsSection", "(Landroidx/compose/foundation/lazy/LazyListScope;Ldk/molslinjen/domain/model/booking/BookingTicket;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "loungeAccess", "(Landroidx/compose/foundation/lazy/LazyListScope;Ldk/molslinjen/domain/model/booking/BookingTicket;Lkotlin/jvm/functions/Function2;)V", "foodAndSaleOnBoard", "(Landroidx/compose/foundation/lazy/LazyListScope;Ldk/molslinjen/domain/model/booking/BookingTicket;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "Ldk/molslinjen/domain/model/booking/BookingSeatReservation;", "seatReservation", "seatReservations", "(Landroidx/compose/foundation/lazy/LazyListScope;Ldk/molslinjen/domain/model/booking/BookingSeatReservation;)V", Constants.IntentExtra.PushTitle, "Landroidx/compose/foundation/layout/ColumnScope;", "rows", "AddonWrapper", "(Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "icon", "iconUrl", "subTitle", "Lkotlin/Function0;", "showBarcode", "AddonWithBarcodeRow", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TicketDetailsProductsSectionKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x054c  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0380 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x042e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AddonWithBarcodeRow(final Integer num, String str, final String str2, String str3, final Function0<Unit> function0, Composer composer, final int i5, final int i6) {
        int i7;
        String str4;
        int i8;
        String str5;
        int i9;
        String str6;
        String str7;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        int currentCompositeKeyHash2;
        Composer m1226constructorimpl2;
        int i10;
        int currentCompositeKeyHash3;
        Composer m1226constructorimpl3;
        Object rememberedValue;
        Composer.Companion companion;
        int i11;
        int i12;
        Composer composer2;
        Composer composer3;
        boolean z5;
        Object rememberedValue2;
        int currentCompositeKeyHash4;
        Composer m1226constructorimpl4;
        final String str8;
        final String str9;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1356232511);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(num) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i13 = i6 & 2;
        if (i13 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            str4 = str;
            i7 |= startRestartGroup.changed(str4) ? 32 : 16;
            if ((i6 & 4) == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                i7 |= startRestartGroup.changed(str2) ? 256 : 128;
                i8 = i6 & 8;
                if (i8 != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    str5 = str3;
                    i7 |= startRestartGroup.changed(str5) ? 2048 : 1024;
                    if ((i6 & 16) == 0) {
                        i7 |= 24576;
                    } else if ((i5 & 24576) == 0) {
                        i7 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
                    }
                    i9 = i7;
                    if ((i9 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                        str6 = i13 == 0 ? null : str4;
                        str7 = i8 == 0 ? null : str5;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1356232511, i9, -1, "dk.molslinjen.ui.views.screens.tickets.details.AddonWithBarcodeRow (TicketDetailsProductsSection.kt:195)");
                        }
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        float f5 = 8;
                        Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(companion2, Dp.m2599constructorimpl(16), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 7, null);
                        Alignment.Companion companion3 = Alignment.INSTANCE;
                        Alignment.Vertical bottom = companion3.getBottom();
                        Arrangement arrangement = Arrangement.INSTANCE;
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), bottom, startRestartGroup, 48);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
                        ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion4.getConstructor();
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
                        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion4.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                        if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getCenterVertically(), startRestartGroup, 48);
                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
                        Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                        if (startRestartGroup.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                            startRestartGroup.useNode();
                        } else {
                            startRestartGroup.createNode(constructor2);
                        }
                        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                        Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2, companion4.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                        if (!m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
                        startRestartGroup.startReplaceGroup(1557662169);
                        if (num != null) {
                            i10 = 0;
                        } else {
                            i10 = 0;
                            ImageKt.Image(PainterResources_androidKt.painterResource(num.intValue(), startRestartGroup, i9 & 14), Accessibility.INSTANCE.getSkip(), rowScopeInstance.align(SizeKt.m331size3ABfNKs(companion2, Dp.m2599constructorimpl(32)), companion3.getCenterVertically()), null, null, 0.0f, null, startRestartGroup, 0, 120);
                            SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion2, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                            Unit unit = Unit.INSTANCE;
                        }
                        startRestartGroup.endReplaceGroup();
                        Modifier align = rowScopeInstance.align(companion2, companion3.getCenterVertically());
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), startRestartGroup, i10);
                        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, i10);
                        CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, align);
                        Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
                        if (startRestartGroup.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                            startRestartGroup.useNode();
                        } else {
                            startRestartGroup.createNode(constructor3);
                        }
                        m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
                        Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy, companion4.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
                        if (!m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        startRestartGroup.startReplaceGroup(-1964650841);
                        rememberedValue = startRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (rememberedValue != companion.getEmpty()) {
                            i11 = 2;
                            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        } else {
                            i11 = 2;
                        }
                        final MutableState mutableState = (MutableState) rememberedValue;
                        startRestartGroup.endReplaceGroup();
                        startRestartGroup.startReplaceGroup(-1964648617);
                        if (str6 != null || ((Boolean) mutableState.getValue()).booleanValue()) {
                            i12 = i11;
                            composer2 = startRestartGroup;
                        } else {
                            Modifier m325height3ABfNKs = SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(30));
                            startRestartGroup.startReplaceGroup(-1964640124);
                            Object rememberedValue3 = startRestartGroup.rememberedValue();
                            if (rememberedValue3 == companion.getEmpty()) {
                                rememberedValue3 = new Function1() { // from class: p4.h
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Unit AddonWithBarcodeRow$lambda$14$lambda$10$lambda$9$lambda$7$lambda$6;
                                        AddonWithBarcodeRow$lambda$14$lambda$10$lambda$9$lambda$7$lambda$6 = TicketDetailsProductsSectionKt.AddonWithBarcodeRow$lambda$14$lambda$10$lambda$9$lambda$7$lambda$6(MutableState.this, (AsyncImagePainter.State.Error) obj);
                                        return AddonWithBarcodeRow$lambda$14$lambda$10$lambda$9$lambda$7$lambda$6;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            startRestartGroup.endReplaceGroup();
                            i12 = i11;
                            ImageKt.Image(SingletonAsyncImagePainterKt.m2745rememberAsyncImagePainterMqRF_0(str6, null, null, null, null, null, (Function1) rememberedValue3, null, 0, startRestartGroup, ((i9 >> 3) & 14) | 1572864, 446), Accessibility.INSTANCE.getSkip(), m325height3ABfNKs, null, ContentScale.INSTANCE.getFit(), 0.0f, null, startRestartGroup, 24960, 104);
                            composer2 = startRestartGroup;
                            SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion2, Dp.m2599constructorimpl(f5)), composer2, 6);
                        }
                        composer2.endReplaceGroup();
                        Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(i12), 5, null);
                        composer3 = composer2;
                        TextKt.m940Text4IGK_g(str2, m315paddingqDBjuR0$default2, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, (num == null || str6 != null) ? TypographyKt.getParagraphSmallBold() : TypographyKt.getSub(), composer3, ((i9 >> 6) & 14) | 48, 0, 65532);
                        composer3.startReplaceGroup(-1964620390);
                        if (str7 != null) {
                            TextKt.m940Text4IGK_g(str7, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer3, (i9 >> 9) & 14, 1572864, 65534);
                            Unit unit2 = Unit.INSTANCE;
                        }
                        composer3.endReplaceGroup();
                        composer3.endNode();
                        composer3.endNode();
                        SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), composer3, 0);
                        composer3.startReplaceGroup(-611512456);
                        z5 = (57344 & i9) == 16384;
                        rememberedValue2 = composer3.rememberedValue();
                        if (!z5 || rememberedValue2 == companion.getEmpty()) {
                            rememberedValue2 = new Function0() { // from class: p4.i
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit AddonWithBarcodeRow$lambda$14$lambda$12$lambda$11;
                                    AddonWithBarcodeRow$lambda$14$lambda$12$lambda$11 = TicketDetailsProductsSectionKt.AddonWithBarcodeRow$lambda$14$lambda$12$lambda$11(Function0.this);
                                    return AddonWithBarcodeRow$lambda$14$lambda$12$lambda$11;
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceGroup();
                        Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(companion2, false, null, null, (Function0) rememberedValue2, 7, null);
                        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getCenterHorizontally(), composer3, 48);
                        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = composer3.getCurrentCompositionLocalMap();
                        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer3, m122clickableXHw0xAI$default);
                        Function0<ComposeUiNode> constructor4 = companion4.getConstructor();
                        if (composer3.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.useNode();
                        } else {
                            composer3.createNode(constructor4);
                        }
                        m1226constructorimpl4 = Updater.m1226constructorimpl(composer3);
                        Updater.m1227setimpl(m1226constructorimpl4, columnMeasurePolicy2, companion4.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion4.getSetCompositeKeyHash();
                        if (!m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                            m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                            m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                        }
                        Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion4.getSetModifier());
                        ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_barcode, composer3, 6), StringResources_androidKt.stringResource(R.string.accessibilityLabel_barcode, composer3, 6), SizeKt.m331size3ABfNKs(companion2, Dp.m2599constructorimpl(32)), null, null, 0.0f, null, composer3, 384, 120);
                        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(4)), composer3, 6);
                        TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.ticketDetails_products_showOrder, composer3, 6), null, AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer3, 384, 1572864, 65530);
                        composer3.endNode();
                        composer3.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str8 = str6;
                        str9 = str7;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        str8 = str4;
                        str9 = str5;
                        composer3 = startRestartGroup;
                    }
                    endRestartGroup = composer3.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: p4.j
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit AddonWithBarcodeRow$lambda$15;
                                AddonWithBarcodeRow$lambda$15 = TicketDetailsProductsSectionKt.AddonWithBarcodeRow$lambda$15(num, str8, str2, str9, function0, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                return AddonWithBarcodeRow$lambda$15;
                            }
                        });
                        return;
                    }
                    return;
                }
                str5 = str3;
                if ((i6 & 16) == 0) {
                }
                i9 = i7;
                if ((i9 & 9363) == 9362) {
                }
                if (i13 == 0) {
                }
                if (i8 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                Modifier.Companion companion22 = Modifier.INSTANCE;
                float f52 = 8;
                Modifier m315paddingqDBjuR0$default3 = PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(companion22, Dp.m2599constructorimpl(16), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f52), 7, null);
                Alignment.Companion companion32 = Alignment.INSTANCE;
                Alignment.Vertical bottom2 = companion32.getBottom();
                Arrangement arrangement2 = Arrangement.INSTANCE;
                MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement2.getStart(), bottom2, startRestartGroup, 48);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default3);
                ComposeUiNode.Companion companion42 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor5 = companion42.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy3, companion42.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap5, companion42.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = companion42.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting()) {
                }
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash5);
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier5, companion42.getSetModifier());
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                MeasurePolicy rowMeasurePolicy22 = RowKt.rowMeasurePolicy(arrangement2.getStart(), companion32.getCenterVertically(), startRestartGroup, 48);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, companion22);
                Function0<ComposeUiNode> constructor22 = companion42.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy22, companion42.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22, companion42.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion42.getSetCompositeKeyHash();
                if (!m1226constructorimpl2.getInserting()) {
                }
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22, companion42.getSetModifier());
                startRestartGroup.startReplaceGroup(1557662169);
                if (num != null) {
                }
                startRestartGroup.endReplaceGroup();
                Modifier align2 = rowScopeInstance2.align(companion22, companion32.getCenterVertically());
                MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(arrangement2.getTop(), companion32.getStart(), startRestartGroup, i10);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, i10);
                CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(startRestartGroup, align2);
                Function0<ComposeUiNode> constructor32 = companion42.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy3, companion42.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap32, companion42.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = companion42.getSetCompositeKeyHash();
                if (!m1226constructorimpl3.getInserting()) {
                }
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash32);
                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier32, companion42.getSetModifier());
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                startRestartGroup.startReplaceGroup(-1964650841);
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue != companion.getEmpty()) {
                }
                final MutableState mutableState2 = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1964648617);
                if (str6 != null) {
                }
                i12 = i11;
                composer2 = startRestartGroup;
                composer2.endReplaceGroup();
                Modifier m315paddingqDBjuR0$default22 = PaddingKt.m315paddingqDBjuR0$default(companion22, 0.0f, Dp.m2599constructorimpl(f52), 0.0f, Dp.m2599constructorimpl(i12), 5, null);
                composer3 = composer2;
                TextKt.m940Text4IGK_g(str2, m315paddingqDBjuR0$default22, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, (num == null || str6 != null) ? TypographyKt.getParagraphSmallBold() : TypographyKt.getSub(), composer3, ((i9 >> 6) & 14) | 48, 0, 65532);
                composer3.startReplaceGroup(-1964620390);
                if (str7 != null) {
                }
                composer3.endReplaceGroup();
                composer3.endNode();
                composer3.endNode();
                SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance2, companion22, 1.0f, false, 2, null), composer3, 0);
                composer3.startReplaceGroup(-611512456);
                if ((57344 & i9) == 16384) {
                }
                rememberedValue2 = composer3.rememberedValue();
                if (!z5) {
                }
                rememberedValue2 = new Function0() { // from class: p4.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AddonWithBarcodeRow$lambda$14$lambda$12$lambda$11;
                        AddonWithBarcodeRow$lambda$14$lambda$12$lambda$11 = TicketDetailsProductsSectionKt.AddonWithBarcodeRow$lambda$14$lambda$12$lambda$11(Function0.this);
                        return AddonWithBarcodeRow$lambda$14$lambda$12$lambda$11;
                    }
                };
                composer3.updateRememberedValue(rememberedValue2);
                composer3.endReplaceGroup();
                Modifier m122clickableXHw0xAI$default2 = ClickableKt.m122clickableXHw0xAI$default(companion22, false, null, null, (Function0) rememberedValue2, 7, null);
                MeasurePolicy columnMeasurePolicy22 = ColumnKt.columnMeasurePolicy(arrangement2.getTop(), companion32.getCenterHorizontally(), composer3, 48);
                currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                CompositionLocalMap currentCompositionLocalMap42 = composer3.getCurrentCompositionLocalMap();
                Modifier materializeModifier42 = ComposedModifierKt.materializeModifier(composer3, m122clickableXHw0xAI$default2);
                Function0<ComposeUiNode> constructor42 = companion42.getConstructor();
                if (composer3.getApplier() == null) {
                }
                composer3.startReusableNode();
                if (composer3.getInserting()) {
                }
                m1226constructorimpl4 = Updater.m1226constructorimpl(composer3);
                Updater.m1227setimpl(m1226constructorimpl4, columnMeasurePolicy22, companion42.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap42, companion42.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash42 = companion42.getSetCompositeKeyHash();
                if (!m1226constructorimpl4.getInserting()) {
                }
                m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash42);
                Updater.m1227setimpl(m1226constructorimpl4, materializeModifier42, companion42.getSetModifier());
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_barcode, composer3, 6), StringResources_androidKt.stringResource(R.string.accessibilityLabel_barcode, composer3, 6), SizeKt.m331size3ABfNKs(companion22, Dp.m2599constructorimpl(32)), null, null, 0.0f, null, composer3, 384, 120);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion22, Dp.m2599constructorimpl(4)), composer3, 6);
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.ticketDetails_products_showOrder, composer3, 6), null, AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer3, 384, 1572864, 65530);
                composer3.endNode();
                composer3.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                str8 = str6;
                str9 = str7;
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i8 = i6 & 8;
            if (i8 != 0) {
            }
            str5 = str3;
            if ((i6 & 16) == 0) {
            }
            i9 = i7;
            if ((i9 & 9363) == 9362) {
            }
            if (i13 == 0) {
            }
            if (i8 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            Modifier.Companion companion222 = Modifier.INSTANCE;
            float f522 = 8;
            Modifier m315paddingqDBjuR0$default32 = PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(companion222, Dp.m2599constructorimpl(16), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f522), 7, null);
            Alignment.Companion companion322 = Alignment.INSTANCE;
            Alignment.Vertical bottom22 = companion322.getBottom();
            Arrangement arrangement22 = Arrangement.INSTANCE;
            MeasurePolicy rowMeasurePolicy32 = RowKt.rowMeasurePolicy(arrangement22.getStart(), bottom22, startRestartGroup, 48);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap52 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier52 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default32);
            ComposeUiNode.Companion companion422 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor52 = companion422.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy32, companion422.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap52, companion422.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash52 = companion422.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash52);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier52, companion422.getSetModifier());
            RowScopeInstance rowScopeInstance22 = RowScopeInstance.INSTANCE;
            MeasurePolicy rowMeasurePolicy222 = RowKt.rowMeasurePolicy(arrangement22.getStart(), companion322.getCenterVertically(), startRestartGroup, 48);
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, companion222);
            Function0<ComposeUiNode> constructor222 = companion422.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy222, companion422.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap222, companion422.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion422.getSetCompositeKeyHash();
            if (!m1226constructorimpl2.getInserting()) {
            }
            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222);
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier222, companion422.getSetModifier());
            startRestartGroup.startReplaceGroup(1557662169);
            if (num != null) {
            }
            startRestartGroup.endReplaceGroup();
            Modifier align22 = rowScopeInstance22.align(companion222, companion322.getCenterVertically());
            MeasurePolicy columnMeasurePolicy32 = ColumnKt.columnMeasurePolicy(arrangement22.getTop(), companion322.getStart(), startRestartGroup, i10);
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, i10);
            CompositionLocalMap currentCompositionLocalMap322 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier322 = ComposedModifierKt.materializeModifier(startRestartGroup, align22);
            Function0<ComposeUiNode> constructor322 = companion422.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy32, companion422.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap322, companion422.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash322 = companion422.getSetCompositeKeyHash();
            if (!m1226constructorimpl3.getInserting()) {
            }
            m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash322);
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier322, companion422.getSetModifier());
            ColumnScopeInstance columnScopeInstance22 = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-1964650841);
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue != companion.getEmpty()) {
            }
            final MutableState mutableState22 = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1964648617);
            if (str6 != null) {
            }
            i12 = i11;
            composer2 = startRestartGroup;
            composer2.endReplaceGroup();
            Modifier m315paddingqDBjuR0$default222 = PaddingKt.m315paddingqDBjuR0$default(companion222, 0.0f, Dp.m2599constructorimpl(f522), 0.0f, Dp.m2599constructorimpl(i12), 5, null);
            composer3 = composer2;
            TextKt.m940Text4IGK_g(str2, m315paddingqDBjuR0$default222, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, (num == null || str6 != null) ? TypographyKt.getParagraphSmallBold() : TypographyKt.getSub(), composer3, ((i9 >> 6) & 14) | 48, 0, 65532);
            composer3.startReplaceGroup(-1964620390);
            if (str7 != null) {
            }
            composer3.endReplaceGroup();
            composer3.endNode();
            composer3.endNode();
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance22, companion222, 1.0f, false, 2, null), composer3, 0);
            composer3.startReplaceGroup(-611512456);
            if ((57344 & i9) == 16384) {
            }
            rememberedValue2 = composer3.rememberedValue();
            if (!z5) {
            }
            rememberedValue2 = new Function0() { // from class: p4.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit AddonWithBarcodeRow$lambda$14$lambda$12$lambda$11;
                    AddonWithBarcodeRow$lambda$14$lambda$12$lambda$11 = TicketDetailsProductsSectionKt.AddonWithBarcodeRow$lambda$14$lambda$12$lambda$11(Function0.this);
                    return AddonWithBarcodeRow$lambda$14$lambda$12$lambda$11;
                }
            };
            composer3.updateRememberedValue(rememberedValue2);
            composer3.endReplaceGroup();
            Modifier m122clickableXHw0xAI$default22 = ClickableKt.m122clickableXHw0xAI$default(companion222, false, null, null, (Function0) rememberedValue2, 7, null);
            MeasurePolicy columnMeasurePolicy222 = ColumnKt.columnMeasurePolicy(arrangement22.getTop(), companion322.getCenterHorizontally(), composer3, 48);
            currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
            CompositionLocalMap currentCompositionLocalMap422 = composer3.getCurrentCompositionLocalMap();
            Modifier materializeModifier422 = ComposedModifierKt.materializeModifier(composer3, m122clickableXHw0xAI$default22);
            Function0<ComposeUiNode> constructor422 = companion422.getConstructor();
            if (composer3.getApplier() == null) {
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
            }
            m1226constructorimpl4 = Updater.m1226constructorimpl(composer3);
            Updater.m1227setimpl(m1226constructorimpl4, columnMeasurePolicy222, companion422.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap422, companion422.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash422 = companion422.getSetCompositeKeyHash();
            if (!m1226constructorimpl4.getInserting()) {
            }
            m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
            m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash422);
            Updater.m1227setimpl(m1226constructorimpl4, materializeModifier422, companion422.getSetModifier());
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_barcode, composer3, 6), StringResources_androidKt.stringResource(R.string.accessibilityLabel_barcode, composer3, 6), SizeKt.m331size3ABfNKs(companion222, Dp.m2599constructorimpl(32)), null, null, 0.0f, null, composer3, 384, 120);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion222, Dp.m2599constructorimpl(4)), composer3, 6);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.ticketDetails_products_showOrder, composer3, 6), null, AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer3, 384, 1572864, 65530);
            composer3.endNode();
            composer3.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            str8 = str6;
            str9 = str7;
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        str4 = str;
        if ((i6 & 4) == 0) {
        }
        i8 = i6 & 8;
        if (i8 != 0) {
        }
        str5 = str3;
        if ((i6 & 16) == 0) {
        }
        i9 = i7;
        if ((i9 & 9363) == 9362) {
        }
        if (i13 == 0) {
        }
        if (i8 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier.Companion companion2222 = Modifier.INSTANCE;
        float f5222 = 8;
        Modifier m315paddingqDBjuR0$default322 = PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(companion2222, Dp.m2599constructorimpl(16), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f5222), 7, null);
        Alignment.Companion companion3222 = Alignment.INSTANCE;
        Alignment.Vertical bottom222 = companion3222.getBottom();
        Arrangement arrangement222 = Arrangement.INSTANCE;
        MeasurePolicy rowMeasurePolicy322 = RowKt.rowMeasurePolicy(arrangement222.getStart(), bottom222, startRestartGroup, 48);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap522 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier522 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default322);
        ComposeUiNode.Companion companion4222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor522 = companion4222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy322, companion4222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap522, companion4222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash522 = companion4222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash522);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier522, companion4222.getSetModifier());
        RowScopeInstance rowScopeInstance222 = RowScopeInstance.INSTANCE;
        MeasurePolicy rowMeasurePolicy2222 = RowKt.rowMeasurePolicy(arrangement222.getStart(), companion3222.getCenterVertically(), startRestartGroup, 48);
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2222 = ComposedModifierKt.materializeModifier(startRestartGroup, companion2222);
        Function0<ComposeUiNode> constructor2222 = companion4222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2222, companion4222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2222, companion4222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2222 = companion4222.getSetCompositeKeyHash();
        if (!m1226constructorimpl2.getInserting()) {
        }
        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2222);
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2222, companion4222.getSetModifier());
        startRestartGroup.startReplaceGroup(1557662169);
        if (num != null) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier align222 = rowScopeInstance222.align(companion2222, companion3222.getCenterVertically());
        MeasurePolicy columnMeasurePolicy322 = ColumnKt.columnMeasurePolicy(arrangement222.getTop(), companion3222.getStart(), startRestartGroup, i10);
        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, i10);
        CompositionLocalMap currentCompositionLocalMap3222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier3222 = ComposedModifierKt.materializeModifier(startRestartGroup, align222);
        Function0<ComposeUiNode> constructor3222 = companion4222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy322, companion4222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3222, companion4222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3222 = companion4222.getSetCompositeKeyHash();
        if (!m1226constructorimpl3.getInserting()) {
        }
        m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
        m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3222);
        Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3222, companion4222.getSetModifier());
        ColumnScopeInstance columnScopeInstance222 = ColumnScopeInstance.INSTANCE;
        startRestartGroup.startReplaceGroup(-1964650841);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue != companion.getEmpty()) {
        }
        final MutableState mutableState222 = (MutableState) rememberedValue;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(-1964648617);
        if (str6 != null) {
        }
        i12 = i11;
        composer2 = startRestartGroup;
        composer2.endReplaceGroup();
        Modifier m315paddingqDBjuR0$default2222 = PaddingKt.m315paddingqDBjuR0$default(companion2222, 0.0f, Dp.m2599constructorimpl(f5222), 0.0f, Dp.m2599constructorimpl(i12), 5, null);
        composer3 = composer2;
        TextKt.m940Text4IGK_g(str2, m315paddingqDBjuR0$default2222, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, (num == null || str6 != null) ? TypographyKt.getParagraphSmallBold() : TypographyKt.getSub(), composer3, ((i9 >> 6) & 14) | 48, 0, 65532);
        composer3.startReplaceGroup(-1964620390);
        if (str7 != null) {
        }
        composer3.endReplaceGroup();
        composer3.endNode();
        composer3.endNode();
        SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance222, companion2222, 1.0f, false, 2, null), composer3, 0);
        composer3.startReplaceGroup(-611512456);
        if ((57344 & i9) == 16384) {
        }
        rememberedValue2 = composer3.rememberedValue();
        if (!z5) {
        }
        rememberedValue2 = new Function0() { // from class: p4.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit AddonWithBarcodeRow$lambda$14$lambda$12$lambda$11;
                AddonWithBarcodeRow$lambda$14$lambda$12$lambda$11 = TicketDetailsProductsSectionKt.AddonWithBarcodeRow$lambda$14$lambda$12$lambda$11(Function0.this);
                return AddonWithBarcodeRow$lambda$14$lambda$12$lambda$11;
            }
        };
        composer3.updateRememberedValue(rememberedValue2);
        composer3.endReplaceGroup();
        Modifier m122clickableXHw0xAI$default222 = ClickableKt.m122clickableXHw0xAI$default(companion2222, false, null, null, (Function0) rememberedValue2, 7, null);
        MeasurePolicy columnMeasurePolicy2222 = ColumnKt.columnMeasurePolicy(arrangement222.getTop(), companion3222.getCenterHorizontally(), composer3, 48);
        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
        CompositionLocalMap currentCompositionLocalMap4222 = composer3.getCurrentCompositionLocalMap();
        Modifier materializeModifier4222 = ComposedModifierKt.materializeModifier(composer3, m122clickableXHw0xAI$default222);
        Function0<ComposeUiNode> constructor4222 = companion4222.getConstructor();
        if (composer3.getApplier() == null) {
        }
        composer3.startReusableNode();
        if (composer3.getInserting()) {
        }
        m1226constructorimpl4 = Updater.m1226constructorimpl(composer3);
        Updater.m1227setimpl(m1226constructorimpl4, columnMeasurePolicy2222, companion4222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4222, companion4222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4222 = companion4222.getSetCompositeKeyHash();
        if (!m1226constructorimpl4.getInserting()) {
        }
        m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
        m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4222);
        Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4222, companion4222.getSetModifier());
        ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_barcode, composer3, 6), StringResources_androidKt.stringResource(R.string.accessibilityLabel_barcode, composer3, 6), SizeKt.m331size3ABfNKs(companion2222, Dp.m2599constructorimpl(32)), null, null, 0.0f, null, composer3, 384, 120);
        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2222, Dp.m2599constructorimpl(4)), composer3, 6);
        TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.ticketDetails_products_showOrder, composer3, 6), null, AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer3, 384, 1572864, 65530);
        composer3.endNode();
        composer3.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        str8 = str6;
        str9 = str7;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddonWithBarcodeRow$lambda$14$lambda$10$lambda$9$lambda$7$lambda$6(MutableState mutableState, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddonWithBarcodeRow$lambda$14$lambda$12$lambda$11(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddonWithBarcodeRow$lambda$15(Integer num, String str, String str2, String str3, Function0 function0, int i5, int i6, Composer composer, int i7) {
        AddonWithBarcodeRow(num, str, str2, str3, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AddonWrapper(final String str, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i5) {
        int i6;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(512825177);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        int i7 = i6;
        if ((i7 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
            function32 = function3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(512825177, i7, -1, "dk.molslinjen.ui.views.screens.tickets.details.AddonWrapper (TicketDetailsProductsSection.kt:171)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 16;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(BackgroundKt.m104backgroundbw27NRU$default(ModifierExtensionsKt.defaultShadow$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), null, 1, null), AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null), 0.0f, Dp.m2599constructorimpl(f5), 1, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
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
            TextKt.m940Text4IGK_g(str, PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, (i7 & 14) | 48, 1572864, 65532);
            function32 = function3;
            composer2 = startRestartGroup;
            function32.invoke(columnScopeInstance, composer2, Integer.valueOf((i7 & 112) | 6));
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: p4.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AddonWrapper$lambda$3;
                    AddonWrapper$lambda$3 = TicketDetailsProductsSectionKt.AddonWrapper$lambda$3(str, function32, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return AddonWrapper$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddonWrapper$lambda$3(String str, Function3 function3, int i5, Composer composer, int i6) {
        AddonWrapper(str, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void foodAndSaleOnBoard(LazyListScope lazyListScope, final BookingTicket bookingTicket, final List<SaleOnBoardOrder> list, final Function2<? super List<LineItem>, ? super String, Unit> function2, final Function1<? super SaleOnBoardOrder, Unit> function1) {
        List<LineItem> products = bookingTicket.getProducts();
        final ArrayList arrayList = new ArrayList();
        for (Object obj : products) {
            if (((LineItem) obj).getProductType() == ProductType.Catering) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty() && list.isEmpty()) {
            return;
        }
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(132469390, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsProductsSectionKt$foodAndSaleOnBoard$1

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            /* renamed from: dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsProductsSectionKt$foodAndSaleOnBoard$1$1, reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass1 implements Function3<ColumnScope, Composer, Integer, Unit> {
                final /* synthetic */ List<LineItem> $food;
                final /* synthetic */ List<SaleOnBoardOrder> $saleOnBoardOrders;
                final /* synthetic */ Function2<List<LineItem>, String, Unit> $showFoodBarcode;
                final /* synthetic */ Function1<SaleOnBoardOrder, Unit> $showSaleOnBoardDetails;
                final /* synthetic */ BookingTicket $ticket;

                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass1(List<LineItem> list, BookingTicket bookingTicket, Function2<? super List<LineItem>, ? super String, Unit> function2, List<SaleOnBoardOrder> list2, Function1<? super SaleOnBoardOrder, Unit> function1) {
                    this.$food = list;
                    this.$ticket = bookingTicket;
                    this.$showFoodBarcode = function2;
                    this.$saleOnBoardOrders = list2;
                    this.$showSaleOnBoardDetails = function1;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit invoke$lambda$3$lambda$2(Function2 function2, List list, String str) {
                    function2.invoke(list, str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit invoke$lambda$6$lambda$5(Function1 function1, SaleOnBoardOrder saleOnBoardOrder) {
                    function1.invoke(saleOnBoardOrder);
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                    invoke(columnScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope AddonWrapper, Composer composer, int i5) {
                    SaleOnBoardOrder saleOnBoardOrder;
                    Object obj;
                    final String str;
                    Intrinsics.checkNotNullParameter(AddonWrapper, "$this$AddonWrapper");
                    if ((i5 & 17) == 16 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(261803101, i5, -1, "dk.molslinjen.ui.views.screens.tickets.details.foodAndSaleOnBoard.<anonymous>.<anonymous> (TicketDetailsProductsSection.kt:101)");
                    }
                    composer.startReplaceGroup(1577407072);
                    if (!this.$food.isEmpty()) {
                        Iterator<T> it = this.$food.iterator();
                        int i6 = 0;
                        while (it.hasNext()) {
                            i6 += ((LineItem) it.next()).getQuantity();
                        }
                        Iterator<T> it2 = this.$ticket.getBarcodes().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                obj = it2.next();
                                if (((Barcode) obj).getType() == BarcodeType.Catering) {
                                    break;
                                }
                            } else {
                                obj = null;
                                break;
                            }
                        }
                        Barcode barcode = (Barcode) obj;
                        if (barcode == null || (str = barcode.getId()) == null) {
                            str = BuildConfig.FLAVOR;
                        }
                        String pluralStringResource = StringResources_androidKt.pluralStringResource(R.plurals.ticketDetails_pickupPreorders, i6, new Object[]{Integer.valueOf(i6)}, composer, 6);
                        composer.startReplaceGroup(1577421563);
                        boolean changed = composer.changed(this.$showFoodBarcode) | composer.changedInstance(this.$food) | composer.changed(str);
                        final Function2<List<LineItem>, String, Unit> function2 = this.$showFoodBarcode;
                        final List<LineItem> list = this.$food;
                        Object rememberedValue = composer.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00c6: CONSTRUCTOR (r6v7 'rememberedValue' java.lang.Object) = 
                                  (r4v7 'function2' kotlin.jvm.functions.Function2<java.util.List<dk.molslinjen.domain.model.booking.LineItem>, java.lang.String, kotlin.Unit> A[DONT_INLINE])
                                  (r5v6 'list' java.util.List<dk.molslinjen.domain.model.booking.LineItem> A[DONT_INLINE])
                                  (r1v38 'str' java.lang.String A[DONT_INLINE])
                                 A[MD:(kotlin.jvm.functions.Function2, java.util.List, java.lang.String):void (m)] (LINE:13) call: dk.molslinjen.ui.views.screens.tickets.details.a.<init>(kotlin.jvm.functions.Function2, java.util.List, java.lang.String):void type: CONSTRUCTOR in method: dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsProductsSectionKt$foodAndSaleOnBoard$1.1.invoke(androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):void, file: classes2.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.screens.tickets.details.a, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 31 more
                                */
                            /*
                                Method dump skipped, instructions count: 485
                                To view this dump add '--comments-level debug' option
                            */
                            throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsProductsSectionKt$foodAndSaleOnBoard$1.AnonymousClass1.invoke(androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):void");
                        }
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                        invoke(lazyItemScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope item, Composer composer, int i5) {
                        Intrinsics.checkNotNullParameter(item, "$this$item");
                        if ((i5 & 17) == 16 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(132469390, i5, -1, "dk.molslinjen.ui.views.screens.tickets.details.foodAndSaleOnBoard.<anonymous> (TicketDetailsProductsSection.kt:98)");
                        }
                        TicketDetailsProductsSectionKt.AddonWrapper(StringResources_androidKt.stringResource(R.string.ticketDetails_foodFromBooking, composer, 6), ComposableLambdaKt.rememberComposableLambda(261803101, true, new AnonymousClass1(arrayList, bookingTicket, function2, list, function1), composer, 54), composer, 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), 3, null);
            }

            private static final void loungeAccess(LazyListScope lazyListScope, final BookingTicket bookingTicket, final Function2<? super LineItem, ? super String, Unit> function2) {
                Object obj;
                Iterator<T> it = bookingTicket.getProducts().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (Intrinsics.areEqual(((LineItem) obj).getId(), LineItem.loungeAccessId)) {
                            break;
                        }
                    }
                }
                final LineItem lineItem = (LineItem) obj;
                if (lineItem != null) {
                    LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-1180662742, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsProductsSectionKt$loungeAccess$1

                        /* JADX INFO: Access modifiers changed from: package-private */
                        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                        /* renamed from: dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsProductsSectionKt$loungeAccess$1$1, reason: invalid class name */
                        /* loaded from: classes2.dex */
                        public static final class AnonymousClass1 implements Function3<ColumnScope, Composer, Integer, Unit> {
                            final /* synthetic */ String $barcode;
                            final /* synthetic */ LineItem $loungeAccess;
                            final /* synthetic */ Function2<LineItem, String, Unit> $showLoungeAccessBarcode;

                            /* JADX WARN: Multi-variable type inference failed */
                            AnonymousClass1(LineItem lineItem, Function2<? super LineItem, ? super String, Unit> function2, String str) {
                                this.$loungeAccess = lineItem;
                                this.$showLoungeAccessBarcode = function2;
                                this.$barcode = str;
                            }

                            /* JADX INFO: Access modifiers changed from: private */
                            public static final Unit invoke$lambda$1$lambda$0(Function2 function2, LineItem lineItem, String str) {
                                function2.invoke(lineItem, str);
                                return Unit.INSTANCE;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                                invoke(columnScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ColumnScope AddonWrapper, Composer composer, int i5) {
                                Intrinsics.checkNotNullParameter(AddonWrapper, "$this$AddonWrapper");
                                if ((i5 & 17) == 16 && composer.getSkipping()) {
                                    composer.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-830363909, i5, -1, "dk.molslinjen.ui.views.screens.tickets.details.loungeAccess.<anonymous>.<anonymous> (TicketDetailsProductsSection.kt:76)");
                                }
                                Integer valueOf = Integer.valueOf(R.drawable.icon_lounge_access);
                                String pluralStringResource = StringResources_androidKt.pluralStringResource(R.plurals.ticketDetails_loungeAccess_persons, this.$loungeAccess.getQuantity(), new Object[]{Integer.valueOf(this.$loungeAccess.getQuantity())}, composer, 6);
                                composer.startReplaceGroup(-1328061126);
                                boolean changed = composer.changed(this.$showLoungeAccessBarcode) | composer.changedInstance(this.$loungeAccess) | composer.changed(this.$barcode);
                                final Function2<LineItem, String, Unit> function2 = this.$showLoungeAccessBarcode;
                                final LineItem lineItem = this.$loungeAccess;
                                final String str = this.$barcode;
                                Object rememberedValue = composer.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = 
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0079: CONSTRUCTOR (r4v1 'rememberedValue' java.lang.Object) = 
                                          (r11v9 'function2' kotlin.jvm.functions.Function2<dk.molslinjen.domain.model.booking.LineItem, java.lang.String, kotlin.Unit> A[DONT_INLINE])
                                          (r1v1 'lineItem' dk.molslinjen.domain.model.booking.LineItem A[DONT_INLINE])
                                          (r3v0 'str' java.lang.String A[DONT_INLINE])
                                         A[MD:(kotlin.jvm.functions.Function2, dk.molslinjen.domain.model.booking.LineItem, java.lang.String):void (m)] (LINE:10) call: dk.molslinjen.ui.views.screens.tickets.details.c.<init>(kotlin.jvm.functions.Function2, dk.molslinjen.domain.model.booking.LineItem, java.lang.String):void type: CONSTRUCTOR in method: dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsProductsSectionKt$loungeAccess$1.1.invoke(androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):void, file: classes2.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.screens.tickets.details.c, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                        	... 25 more
                                        */
                                    /*
                                        this = this;
                                        java.lang.String r0 = "$this$AddonWrapper"
                                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                                        r9 = r11 & 17
                                        r0 = 16
                                        if (r9 != r0) goto L17
                                        boolean r9 = r10.getSkipping()
                                        if (r9 != 0) goto L12
                                        goto L17
                                    L12:
                                        r10.skipToGroupEnd()
                                        goto L96
                                    L17:
                                        boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                        if (r9 == 0) goto L26
                                        r9 = -1
                                        java.lang.String r0 = "dk.molslinjen.ui.views.screens.tickets.details.loungeAccess.<anonymous>.<anonymous> (TicketDetailsProductsSection.kt:76)"
                                        r1 = -830363909(0xffffffffce81a6fb, float:-1.087602E9)
                                        androidx.compose.runtime.ComposerKt.traceEventStart(r1, r11, r9, r0)
                                    L26:
                                        r9 = 2131165390(0x7f0700ce, float:1.7944996E38)
                                        java.lang.Integer r0 = java.lang.Integer.valueOf(r9)
                                        dk.molslinjen.domain.model.booking.LineItem r9 = r8.$loungeAccess
                                        int r9 = r9.getQuantity()
                                        dk.molslinjen.domain.model.booking.LineItem r11 = r8.$loungeAccess
                                        int r11 = r11.getQuantity()
                                        java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
                                        java.lang.Object[] r11 = new java.lang.Object[]{r11}
                                        r1 = 6
                                        r2 = 2131623953(0x7f0e0011, float:1.8875072E38)
                                        java.lang.String r2 = androidx.compose.ui.res.StringResources_androidKt.pluralStringResource(r2, r9, r11, r10, r1)
                                        r9 = -1328061126(0xffffffffb0d7653a, float:-1.5672079E-9)
                                        r10.startReplaceGroup(r9)
                                        kotlin.jvm.functions.Function2<dk.molslinjen.domain.model.booking.LineItem, java.lang.String, kotlin.Unit> r9 = r8.$showLoungeAccessBarcode
                                        boolean r9 = r10.changed(r9)
                                        dk.molslinjen.domain.model.booking.LineItem r11 = r8.$loungeAccess
                                        boolean r11 = r10.changedInstance(r11)
                                        r9 = r9 | r11
                                        java.lang.String r11 = r8.$barcode
                                        boolean r11 = r10.changed(r11)
                                        r9 = r9 | r11
                                        kotlin.jvm.functions.Function2<dk.molslinjen.domain.model.booking.LineItem, java.lang.String, kotlin.Unit> r11 = r8.$showLoungeAccessBarcode
                                        dk.molslinjen.domain.model.booking.LineItem r1 = r8.$loungeAccess
                                        java.lang.String r3 = r8.$barcode
                                        java.lang.Object r4 = r10.rememberedValue()
                                        if (r9 != 0) goto L77
                                        androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.INSTANCE
                                        java.lang.Object r9 = r9.getEmpty()
                                        if (r4 != r9) goto L7f
                                    L77:
                                        dk.molslinjen.ui.views.screens.tickets.details.c r4 = new dk.molslinjen.ui.views.screens.tickets.details.c
                                        r4.<init>(r11, r1, r3)
                                        r10.updateRememberedValue(r4)
                                    L7f:
                                        kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
                                        r10.endReplaceGroup()
                                        r6 = 6
                                        r7 = 10
                                        r1 = 0
                                        r3 = 0
                                        r5 = r10
                                        dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsProductsSectionKt.access$AddonWithBarcodeRow(r0, r1, r2, r3, r4, r5, r6, r7)
                                        boolean r9 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                        if (r9 == 0) goto L96
                                        androidx.compose.runtime.ComposerKt.traceEventEnd()
                                    L96:
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsProductsSectionKt$loungeAccess$1.AnonymousClass1.invoke(androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):void");
                                }
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                invoke(lazyItemScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(LazyItemScope item, Composer composer, int i5) {
                                Object obj2;
                                String str;
                                Intrinsics.checkNotNullParameter(item, "$this$item");
                                if ((i5 & 17) == 16 && composer.getSkipping()) {
                                    composer.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1180662742, i5, -1, "dk.molslinjen.ui.views.screens.tickets.details.loungeAccess.<anonymous> (TicketDetailsProductsSection.kt:72)");
                                }
                                Iterator<T> it2 = BookingTicket.this.getBarcodes().iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        obj2 = null;
                                        break;
                                    } else {
                                        obj2 = it2.next();
                                        if (((Barcode) obj2).getType() == BarcodeType.Lounge) {
                                            break;
                                        }
                                    }
                                }
                                Barcode barcode = (Barcode) obj2;
                                if (barcode == null || (str = barcode.getId()) == null) {
                                    str = BuildConfig.FLAVOR;
                                }
                                TicketDetailsProductsSectionKt.AddonWrapper(StringResources_androidKt.stringResource(R.string.ticketDetails_loungeAccess, composer, 6), ComposableLambdaKt.rememberComposableLambda(-830363909, true, new AnonymousClass1(lineItem, function2, str), composer, 54), composer, 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), 3, null);
                    }
                }

                private static final void seatReservations(LazyListScope lazyListScope, final BookingSeatReservation bookingSeatReservation) {
                    if (bookingSeatReservation != null) {
                        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-754373403, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsProductsSectionKt$seatReservations$1

                            /* JADX INFO: Access modifiers changed from: package-private */
                            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                            /* renamed from: dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsProductsSectionKt$seatReservations$1$1, reason: invalid class name */
                            /* loaded from: classes2.dex */
                            public static final class AnonymousClass1 implements Function3<ColumnScope, Composer, Integer, Unit> {
                                final /* synthetic */ BookingSeatReservation $seatReservation;

                                AnonymousClass1(BookingSeatReservation bookingSeatReservation) {
                                    this.$seatReservation = bookingSeatReservation;
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final CharSequence invoke$lambda$5$lambda$4$lambda$2$lambda$1(String it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    return it;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                                    invoke(columnScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ColumnScope AddonWrapper, Composer composer, int i5) {
                                    Intrinsics.checkNotNullParameter(AddonWrapper, "$this$AddonWrapper");
                                    if ((i5 & 17) == 16 && composer.getSkipping()) {
                                        composer.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1772368780, i5, -1, "dk.molslinjen.ui.views.screens.tickets.details.seatReservations.<anonymous>.<anonymous> (TicketDetailsProductsSection.kt:140)");
                                    }
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    float f5 = 16;
                                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer, 6);
                                    Alignment.Companion companion2 = Alignment.INSTANCE;
                                    Alignment.Vertical centerVertically = companion2.getCenterVertically();
                                    BookingSeatReservation bookingSeatReservation = this.$seatReservation;
                                    Arrangement arrangement = Arrangement.INSTANCE;
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composer, 48);
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
                                    ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
                                    Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion3.getSetMeasurePolicy());
                                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer, 6);
                                    ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_selected_seat, composer, 6), Accessibility.INSTANCE.getSkip(), null, null, null, 0.0f, null, composer, 0, 124);
                                    Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 2, null);
                                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer, 0);
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, m313paddingVpY3zN4$default);
                                    Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                                    if (composer.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer.startReusableNode();
                                    if (composer.getInserting()) {
                                        composer.createNode(constructor2);
                                    } else {
                                        composer.useNode();
                                    }
                                    Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer);
                                    Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                                    Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                                    if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                    List<FerrySeat> seats = bookingSeatReservation.getSeats();
                                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(seats, 10));
                                    Iterator<T> it = seats.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((FerrySeat) it.next()).getName());
                                    }
                                    List sorted = CollectionsKt.sorted(arrayList);
                                    composer.startReplaceGroup(1094845478);
                                    Object rememberedValue = composer.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = 
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01b1: CONSTRUCTOR (r0v34 'rememberedValue' java.lang.Object) =  A[MD:():void (m)] (LINE:66) call: dk.molslinjen.ui.views.screens.tickets.details.d.<init>():void type: CONSTRUCTOR in method: dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsProductsSectionKt$seatReservations$1.1.invoke(androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):void, file: classes2.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.screens.tickets.details.d, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                            	... 25 more
                                            */
                                        /*
                                            Method dump skipped, instructions count: 613
                                            To view this dump add '--comments-level debug' option
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsProductsSectionKt$seatReservations$1.AnonymousClass1.invoke(androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):void");
                                    }
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                                    invoke(lazyItemScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer composer, int i5) {
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    if ((i5 & 17) == 16 && composer.getSkipping()) {
                                        composer.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-754373403, i5, -1, "dk.molslinjen.ui.views.screens.tickets.details.seatReservations.<anonymous> (TicketDetailsProductsSection.kt:139)");
                                    }
                                    TicketDetailsProductsSectionKt.AddonWrapper(StringResources_androidKt.stringResource(R.string.ticketDetails_seatReservation, composer, 6), ComposableLambdaKt.rememberComposableLambda(-1772368780, true, new AnonymousClass1(BookingSeatReservation.this), composer, 54), composer, 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), 3, null);
                        }
                    }

                    public static final void ticketDetailsProductsSection(LazyListScope lazyListScope, BookingTicket ticket, List<SaleOnBoardOrder> saleOnBoardOrders, Function2<? super LineItem, ? super String, Unit> showLoungeAccessBarcode, Function2<? super List<LineItem>, ? super String, Unit> showFoodBarcode, Function1<? super SaleOnBoardOrder, Unit> showSaleOnBoardDetails) {
                        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
                        Intrinsics.checkNotNullParameter(ticket, "ticket");
                        Intrinsics.checkNotNullParameter(saleOnBoardOrders, "saleOnBoardOrders");
                        Intrinsics.checkNotNullParameter(showLoungeAccessBarcode, "showLoungeAccessBarcode");
                        Intrinsics.checkNotNullParameter(showFoodBarcode, "showFoodBarcode");
                        Intrinsics.checkNotNullParameter(showSaleOnBoardDetails, "showSaleOnBoardDetails");
                        loungeAccess(lazyListScope, ticket, showLoungeAccessBarcode);
                        foodAndSaleOnBoard(lazyListScope, ticket, saleOnBoardOrders, showFoodBarcode, showSaleOnBoardDetails);
                        seatReservations(lazyListScope, ticket.getSeatReservation());
                    }
                }
