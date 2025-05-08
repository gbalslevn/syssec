package dk.molslinjen.ui.views.shared.ticket.ticketSummary;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.unit.Dp;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImagePainterKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.core.image.ImageHelper;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.booking.TicketSurcharge;
import dk.molslinjen.domain.model.booking.TicketSurchargeType;
import dk.molslinjen.domain.model.booking.TransportationCargoInfo;
import dk.molslinjen.domain.model.booking.product.ISummaryProduct;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.shared.passengers.PassengersInfoViewKt;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.TransportationInfoViewKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001aW\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a-\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0003¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/domain/model/config/Transportation;", "transportation", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "passengerInfo", "Ldk/molslinjen/domain/model/booking/product/ISummaryProduct;", "trailer", BuildConfig.FLAVOR, "transportProducts", BuildConfig.FLAVOR, "showDetails", "Ldk/molslinjen/domain/model/booking/TransportationCargoInfo;", "cargoInfo", "Ldk/molslinjen/domain/model/booking/TicketSurcharge;", "surcharges", BuildConfig.FLAVOR, "TransportationInfoView", "(Ldk/molslinjen/domain/model/config/Transportation;Ldk/molslinjen/domain/model/booking/PassengerInfo;Ldk/molslinjen/domain/model/booking/product/ISummaryProduct;Ljava/util/List;ZLdk/molslinjen/domain/model/booking/TransportationCargoInfo;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "imageUrl", Constants.IntentExtra.PushTitle, BuildConfig.FLAVOR, "quantity", "InfoView", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TransportationInfoViewKt {
    /* JADX WARN: Removed duplicated region for block: B:18:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void InfoView(final String str, final String str2, Integer num, Composer composer, final int i5, final int i6) {
        int i7;
        Integer num2;
        Integer num3;
        Modifier.Companion companion;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Object rememberedValue;
        Composer.Companion companion2;
        float f5;
        String m3193buildImageUrlC8IHX40;
        String str3;
        Object rememberedValue2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1149494104);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(str) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(str2) ? 32 : 16;
        }
        int i8 = i6 & 4;
        if (i8 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            num2 = num;
            i7 |= startRestartGroup.changed(num2) ? 256 : 128;
            if ((i7 & 147) == 146 || !startRestartGroup.getSkipping()) {
                num3 = i8 == 0 ? null : num2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1149494104, i7, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.InfoView (TransportationInfoView.kt:72)");
                }
                companion = Modifier.INSTANCE;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
                Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                startRestartGroup.startReplaceGroup(842076607);
                rememberedValue = startRestartGroup.rememberedValue();
                companion2 = Composer.INSTANCE;
                if (rememberedValue == companion2.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final MutableState mutableState = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                f5 = 16;
                m3193buildImageUrlC8IHX40 = ImageHelper.INSTANCE.m3193buildImageUrlC8IHX40(str, null, Dp.m2597boximpl(Dp.m2599constructorimpl(f5)), startRestartGroup, (i7 & 14) | 3456, 2);
                startRestartGroup.startReplaceGroup(842081136);
                if (m3193buildImageUrlC8IHX40 != null && !((Boolean) mutableState.getValue()).booleanValue()) {
                    Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), 0.0f, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 11, null);
                    startRestartGroup.startReplaceGroup(842090348);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == companion2.getEmpty()) {
                        rememberedValue2 = new Function1() { // from class: C4.N
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit InfoView$lambda$8$lambda$7$lambda$6;
                                InfoView$lambda$8$lambda$7$lambda$6 = TransportationInfoViewKt.InfoView$lambda$8$lambda$7$lambda$6(MutableState.this, (AsyncImagePainter.State.Error) obj);
                                return InfoView$lambda$8$lambda$7$lambda$6;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceGroup();
                    ImageKt.Image(SingletonAsyncImagePainterKt.m2745rememberAsyncImagePainterMqRF_0(m3193buildImageUrlC8IHX40, null, null, null, null, null, (Function1) rememberedValue2, null, 0, startRestartGroup, 1572864, 446), Accessibility.INSTANCE.getSkip(), m315paddingqDBjuR0$default, null, ContentScale.INSTANCE.getFit(), 0.0f, ColorFilter.Companion.m1503tintxETnrds$default(ColorFilter.INSTANCE, AppColor.INSTANCE.m3266getGrey30d7_KjU(), 0, 2, null), startRestartGroup, 1597824, 40);
                }
                startRestartGroup.endReplaceGroup();
                Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(2), 7, null);
                if (num3 == null) {
                    str3 = num3 + " " + str2;
                } else {
                    str3 = str2;
                }
                TextKt.m940Text4IGK_g(str3, m315paddingqDBjuR0$default2, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 48, 1572864, 65532);
                startRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                num2 = num3;
            } else {
                startRestartGroup.skipToGroupEnd();
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Integer num4 = num2;
                endRestartGroup.updateScope(new Function2() { // from class: C4.O
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit InfoView$lambda$9;
                        InfoView$lambda$9 = TransportationInfoViewKt.InfoView$lambda$9(str, str2, num4, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return InfoView$lambda$9;
                    }
                });
                return;
            }
            return;
        }
        num2 = num;
        if ((i7 & 147) == 146) {
        }
        if (i8 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        companion = Modifier.INSTANCE;
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
        ComposeUiNode.Companion companion32 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2 = companion32.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy2, companion32.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion32.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion32.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion32.getSetModifier());
        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
        startRestartGroup.startReplaceGroup(842076607);
        rememberedValue = startRestartGroup.rememberedValue();
        companion2 = Composer.INSTANCE;
        if (rememberedValue == companion2.getEmpty()) {
        }
        final MutableState mutableState2 = (MutableState) rememberedValue;
        startRestartGroup.endReplaceGroup();
        f5 = 16;
        m3193buildImageUrlC8IHX40 = ImageHelper.INSTANCE.m3193buildImageUrlC8IHX40(str, null, Dp.m2597boximpl(Dp.m2599constructorimpl(f5)), startRestartGroup, (i7 & 14) | 3456, 2);
        startRestartGroup.startReplaceGroup(842081136);
        if (m3193buildImageUrlC8IHX40 != null) {
            Modifier m315paddingqDBjuR0$default3 = PaddingKt.m315paddingqDBjuR0$default(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), 0.0f, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 11, null);
            startRestartGroup.startReplaceGroup(842090348);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion2.getEmpty()) {
            }
            startRestartGroup.endReplaceGroup();
            ImageKt.Image(SingletonAsyncImagePainterKt.m2745rememberAsyncImagePainterMqRF_0(m3193buildImageUrlC8IHX40, null, null, null, null, null, (Function1) rememberedValue2, null, 0, startRestartGroup, 1572864, 446), Accessibility.INSTANCE.getSkip(), m315paddingqDBjuR0$default3, null, ContentScale.INSTANCE.getFit(), 0.0f, ColorFilter.Companion.m1503tintxETnrds$default(ColorFilter.INSTANCE, AppColor.INSTANCE.m3266getGrey30d7_KjU(), 0, 2, null), startRestartGroup, 1597824, 40);
        }
        startRestartGroup.endReplaceGroup();
        Modifier m315paddingqDBjuR0$default22 = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(2), 7, null);
        if (num3 == null) {
        }
        TextKt.m940Text4IGK_g(str3, m315paddingqDBjuR0$default22, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 48, 1572864, 65532);
        startRestartGroup.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        num2 = num3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InfoView$lambda$8$lambda$7$lambda$6(MutableState mutableState, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InfoView$lambda$9(String str, String str2, Integer num, int i5, int i6, Composer composer, int i7) {
        InfoView(str, str2, num, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    public static final void TransportationInfoView(final Transportation transportation, final PassengerInfo passengerInfo, final ISummaryProduct iSummaryProduct, final List<? extends ISummaryProduct> transportProducts, final boolean z5, final TransportationCargoInfo transportationCargoInfo, final List<TicketSurcharge> surcharges, Composer composer, final int i5) {
        Intrinsics.checkNotNullParameter(transportation, "transportation");
        Intrinsics.checkNotNullParameter(passengerInfo, "passengerInfo");
        Intrinsics.checkNotNullParameter(transportProducts, "transportProducts");
        Intrinsics.checkNotNullParameter(surcharges, "surcharges");
        Composer startRestartGroup = composer.startRestartGroup(799491925);
        int i6 = (i5 & 6) == 0 ? (startRestartGroup.changedInstance(transportation) ? 4 : 2) | i5 : i5;
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(passengerInfo) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(iSummaryProduct) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(transportProducts) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(transportationCargoInfo) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(surcharges) ? 1048576 : 524288;
        }
        int i7 = i6;
        if ((599187 & i7) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(799491925, i7, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.TransportationInfoView (TransportationInfoView.kt:39)");
            }
            float f5 = 16;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(f5));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(f5)), Alignment.INSTANCE.getStart(), startRestartGroup, 6);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            if (transportation.isWalking()) {
                startRestartGroup.startReplaceGroup(1728903200);
                PassengersInfoViewKt.PassengersInfoView(null, passengerInfo, startRestartGroup, i7 & 112, 1);
                for (ISummaryProduct iSummaryProduct2 : transportProducts) {
                    InfoView(iSummaryProduct2.getImageUrl(), iSummaryProduct2.getName(), Integer.valueOf(iSummaryProduct2.getQuantity()), startRestartGroup, 0, 0);
                }
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1729135948);
                InfoView(transportation.getImageUrl(), transportation.getName(), null, startRestartGroup, 0, 4);
                startRestartGroup.startReplaceGroup(-914050023);
                if (iSummaryProduct != null) {
                    InfoView(iSummaryProduct.getImageUrl(), iSummaryProduct.getName(), null, startRestartGroup, 0, 4);
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-914043256);
                ArrayList arrayList = new ArrayList();
                for (Object obj : surcharges) {
                    if (((TicketSurcharge) obj).getType() == TicketSurchargeType.Goods) {
                        arrayList.add(obj);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    TicketSurchargeViewKt.TicketSurchargeView((TicketSurcharge) it.next(), startRestartGroup, 0);
                }
                startRestartGroup.endReplaceGroup();
                if ((transportationCargoInfo != null ? transportationCargoInfo.getTotalWeight() : null) != null) {
                    CargoInfoViewKt.CargoInfoView(transportationCargoInfo, z5, startRestartGroup, ((i7 >> 15) & 14) | ((i7 >> 9) & 112));
                }
                startRestartGroup.endReplaceGroup();
            }
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: C4.M
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit TransportationInfoView$lambda$4;
                    TransportationInfoView$lambda$4 = TransportationInfoViewKt.TransportationInfoView$lambda$4(Transportation.this, passengerInfo, iSummaryProduct, transportProducts, z5, transportationCargoInfo, surcharges, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    return TransportationInfoView$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TransportationInfoView$lambda$4(Transportation transportation, PassengerInfo passengerInfo, ISummaryProduct iSummaryProduct, List list, boolean z5, TransportationCargoInfo transportationCargoInfo, List list2, int i5, Composer composer, int i6) {
        TransportationInfoView(transportation, passengerInfo, iSummaryProduct, list, z5, transportationCargoInfo, list2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
