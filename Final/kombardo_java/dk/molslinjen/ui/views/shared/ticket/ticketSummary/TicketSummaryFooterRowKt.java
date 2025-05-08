package dk.molslinjen.ui.views.shared.ticket.ticketSummary;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.managers.checkout.PriceDetails;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.buttons.TertiaryButtonKt;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSummaryFooterRowKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001ae\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "totalPrice", "Ldk/molslinjen/domain/managers/checkout/PriceDetails;", "priceDetails", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "departure", "Landroidx/compose/ui/text/TextStyle;", "titleTextStyle", "Lkotlin/Function1;", BuildConfig.FLAVOR, "addToCalendar", BuildConfig.FLAVOR, "priceTotalText", "TicketSummaryFooterRow", "(Landroidx/compose/ui/Modifier;Ldk/molslinjen/domain/managers/checkout/PriceTotal;Ldk/molslinjen/domain/managers/checkout/PriceDetails;Ldk/molslinjen/domain/model/booking/IDepartureInfo;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TicketSummaryFooterRowKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TicketSummaryFooterRow(Modifier modifier, final PriceTotal totalPrice, PriceDetails priceDetails, IDepartureInfo iDepartureInfo, TextStyle textStyle, final Function1<? super IDepartureInfo, Unit> function1, String str, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        PriceDetails priceDetails2;
        int i8;
        final IDepartureInfo iDepartureInfo2;
        int i9;
        TextStyle textStyle2;
        int i10;
        String str2;
        PriceDetails priceDetails3;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        PriceDetails priceDetails4;
        Object obj;
        TextStyle textStyle3;
        IDepartureInfo iDepartureInfo3;
        Composer composer2;
        final IDepartureInfo iDepartureInfo4;
        final Modifier modifier3;
        final TextStyle textStyle4;
        final PriceDetails priceDetails5;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(totalPrice, "totalPrice");
        Composer startRestartGroup = composer.startRestartGroup(-229660915);
        int i11 = i6 & 1;
        if (i11 != 0) {
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
            i7 |= startRestartGroup.changedInstance(totalPrice) ? 32 : 16;
        }
        int i12 = i6 & 4;
        if (i12 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            priceDetails2 = priceDetails;
            i7 |= startRestartGroup.changedInstance(priceDetails2) ? 256 : 128;
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                iDepartureInfo2 = iDepartureInfo;
                i7 |= startRestartGroup.changedInstance(iDepartureInfo2) ? 2048 : 1024;
                i9 = i6 & 16;
                if (i9 != 0) {
                    i7 |= 24576;
                } else if ((i5 & 24576) == 0) {
                    textStyle2 = textStyle;
                    i7 |= startRestartGroup.changed(textStyle2) ? 16384 : 8192;
                    if ((i6 & 32) == 0) {
                        i7 |= 196608;
                    } else if ((i5 & 196608) == 0) {
                        i7 |= startRestartGroup.changedInstance(function1) ? 131072 : 65536;
                    }
                    i10 = i6 & 64;
                    if (i10 == 0) {
                        i7 |= 1572864;
                        str2 = str;
                    } else {
                        str2 = str;
                        if ((i5 & 1572864) == 0) {
                            i7 |= startRestartGroup.changed(str2) ? 1048576 : 524288;
                        }
                    }
                    if ((i7 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                        Modifier modifier4 = i11 == 0 ? Modifier.INSTANCE : modifier2;
                        priceDetails3 = i12 == 0 ? null : priceDetails2;
                        if (i8 != 0) {
                            iDepartureInfo2 = null;
                        }
                        TextStyle sub = i9 == 0 ? TypographyKt.getSub() : textStyle2;
                        if (i10 != 0) {
                            str2 = null;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-229660915, i7, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSummaryFooterRow (TicketSummaryFooterRow.kt:36)");
                        }
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
                        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor = companion.getConstructor();
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
                        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
                        if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        if (priceDetails3 == null) {
                            startRestartGroup.startReplaceGroup(1252029672);
                            PriceDetailsViewKt.PriceDetailsView(priceDetails3, sub, startRestartGroup, ((i7 >> 6) & 14) | ((i7 >> 9) & 112), 0);
                            startRestartGroup.endReplaceGroup();
                            priceDetails4 = priceDetails3;
                            obj = null;
                        } else {
                            startRestartGroup.startReplaceGroup(1252144186);
                            int i13 = i7 >> 9;
                            priceDetails4 = priceDetails3;
                            obj = null;
                            PriceDetailsViewKt.TotalPriceRow(totalPrice, sub, false, str2, startRestartGroup, ((i7 >> 3) & 14) | (i13 & 112) | (i13 & 7168), 4);
                            startRestartGroup.endReplaceGroup();
                        }
                        startRestartGroup.startReplaceGroup(178946255);
                        if (function1 != null) {
                            textStyle3 = sub;
                            iDepartureInfo3 = iDepartureInfo2;
                            composer2 = startRestartGroup;
                        } else {
                            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(16), 7, null), 0.0f, 1, obj);
                            String stringResource = StringResources_androidKt.stringResource(R.string.common_addToCalendar, startRestartGroup, 6);
                            startRestartGroup.startReplaceGroup(-2145941436);
                            boolean changedInstance = startRestartGroup.changedInstance(iDepartureInfo2) | startRestartGroup.changed(function1);
                            Object rememberedValue = startRestartGroup.rememberedValue();
                            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = new Function0() { // from class: C4.z
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Unit TicketSummaryFooterRow$lambda$4$lambda$3$lambda$2$lambda$1;
                                        TicketSummaryFooterRow$lambda$4$lambda$3$lambda$2$lambda$1 = TicketSummaryFooterRowKt.TicketSummaryFooterRow$lambda$4$lambda$3$lambda$2$lambda$1(IDepartureInfo.this, function1);
                                        return TicketSummaryFooterRow$lambda$4$lambda$3$lambda$2$lambda$1;
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceGroup();
                            textStyle3 = sub;
                            iDepartureInfo3 = iDepartureInfo2;
                            composer2 = startRestartGroup;
                            TertiaryButtonKt.TertiaryButton(fillMaxWidth$default, stringResource, (Function0) rememberedValue, ComposableSingletons$TicketSummaryFooterRowKt.INSTANCE.m3560getLambda1$app_kombardoProd(), null, composer2, 3078, 16);
                        }
                        composer2.endReplaceGroup();
                        composer2.endNode();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        iDepartureInfo4 = iDepartureInfo3;
                        modifier3 = modifier4;
                        textStyle4 = textStyle3;
                        priceDetails5 = priceDetails4;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        priceDetails5 = priceDetails2;
                        modifier3 = modifier2;
                        textStyle4 = textStyle2;
                        iDepartureInfo4 = iDepartureInfo2;
                        composer2 = startRestartGroup;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        final String str3 = str2;
                        endRestartGroup.updateScope(new Function2() { // from class: C4.A
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                Unit TicketSummaryFooterRow$lambda$5;
                                TicketSummaryFooterRow$lambda$5 = TicketSummaryFooterRowKt.TicketSummaryFooterRow$lambda$5(Modifier.this, totalPrice, priceDetails5, iDepartureInfo4, textStyle4, function1, str3, i5, i6, (Composer) obj2, ((Integer) obj3).intValue());
                                return TicketSummaryFooterRow$lambda$5;
                            }
                        });
                        return;
                    }
                    return;
                }
                textStyle2 = textStyle;
                if ((i6 & 32) == 0) {
                }
                i10 = i6 & 64;
                if (i10 == 0) {
                }
                if ((i7 & 599187) == 599186) {
                }
                if (i11 == 0) {
                }
                if (i12 == 0) {
                }
                if (i8 != 0) {
                }
                if (i9 == 0) {
                }
                if (i10 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting()) {
                }
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier2, companion2.getSetModifier());
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                if (priceDetails3 == null) {
                }
                startRestartGroup.startReplaceGroup(178946255);
                if (function1 != null) {
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                }
                iDepartureInfo4 = iDepartureInfo3;
                modifier3 = modifier4;
                textStyle4 = textStyle3;
                priceDetails5 = priceDetails4;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            iDepartureInfo2 = iDepartureInfo;
            i9 = i6 & 16;
            if (i9 != 0) {
            }
            textStyle2 = textStyle;
            if ((i6 & 32) == 0) {
            }
            i10 = i6 & 64;
            if (i10 == 0) {
            }
            if ((i7 & 599187) == 599186) {
            }
            if (i11 == 0) {
            }
            if (i12 == 0) {
            }
            if (i8 != 0) {
            }
            if (i9 == 0) {
            }
            if (i10 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            MeasurePolicy columnMeasurePolicy22 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
            ComposeUiNode.Companion companion22 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor22 = companion22.getConstructor();
            if (startRestartGroup.getApplier() == null) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy22, companion22.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap22, companion22.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion22.getSetCompositeKeyHash();
            if (!m1226constructorimpl.getInserting()) {
            }
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier22, companion22.getSetModifier());
            ColumnScopeInstance columnScopeInstance22 = ColumnScopeInstance.INSTANCE;
            if (priceDetails3 == null) {
            }
            startRestartGroup.startReplaceGroup(178946255);
            if (function1 != null) {
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
            }
            iDepartureInfo4 = iDepartureInfo3;
            modifier3 = modifier4;
            textStyle4 = textStyle3;
            priceDetails5 = priceDetails4;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        priceDetails2 = priceDetails;
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        iDepartureInfo2 = iDepartureInfo;
        i9 = i6 & 16;
        if (i9 != 0) {
        }
        textStyle2 = textStyle;
        if ((i6 & 32) == 0) {
        }
        i10 = i6 & 64;
        if (i10 == 0) {
        }
        if ((i7 & 599187) == 599186) {
        }
        if (i11 == 0) {
        }
        if (i12 == 0) {
        }
        if (i8 != 0) {
        }
        if (i9 == 0) {
        }
        if (i10 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        MeasurePolicy columnMeasurePolicy222 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier222 = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
        ComposeUiNode.Companion companion222 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor222 = companion222.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy222, companion222.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap222, companion222.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash222 = companion222.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier222, companion222.getSetModifier());
        ColumnScopeInstance columnScopeInstance222 = ColumnScopeInstance.INSTANCE;
        if (priceDetails3 == null) {
        }
        startRestartGroup.startReplaceGroup(178946255);
        if (function1 != null) {
        }
        composer2.endReplaceGroup();
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        iDepartureInfo4 = iDepartureInfo3;
        modifier3 = modifier4;
        textStyle4 = textStyle3;
        priceDetails5 = priceDetails4;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketSummaryFooterRow$lambda$4$lambda$3$lambda$2$lambda$1(IDepartureInfo iDepartureInfo, Function1 function1) {
        if (iDepartureInfo != null) {
            function1.invoke(iDepartureInfo);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketSummaryFooterRow$lambda$5(Modifier modifier, PriceTotal priceTotal, PriceDetails priceDetails, IDepartureInfo iDepartureInfo, TextStyle textStyle, Function1 function1, String str, int i5, int i6, Composer composer, int i7) {
        TicketSummaryFooterRow(modifier, priceTotal, priceDetails, iDepartureInfo, textStyle, function1, str, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
