package dk.molslinjen.ui.views.screens.agreements.multiride.common;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideChargesExpiry;
import dk.molslinjen.domain.model.booking.TicketCategoryType;
import dk.molslinjen.extensions.domain.TicketCategoryExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.VerticalDividerKt;
import dk.molslinjen.ui.views.reusable.modifiers.SkeletonKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.common.MultiRideCardInfoViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001ae\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a!\u0010\u0018\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0003¢\u0006\u0004\b\u0016\u0010\u0017\u001a!\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u0011\u0010\u001b\u001a'\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0003¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "multiRideId", "Lorg/threeten/bp/LocalDate;", "expirationDate", "Ldk/molslinjen/domain/model/booking/TicketCategoryType;", "ticketCategoryType", "ticketTypeName", BuildConfig.FLAVOR, "numberOfCharges", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideChargesExpiry;", "chargesExpiringSoon", BuildConfig.FLAVOR, "showAsExpired", "skeletonForMultiRideId", BuildConfig.FLAVOR, "MultiRideCardInfoView", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ldk/molslinjen/domain/model/booking/TicketCategoryType;Ljava/lang/String;ILdk/molslinjen/domain/model/agreement/multiRide/MultiRideChargesExpiry;ZZLandroidx/compose/runtime/Composer;II)V", "text", "Landroidx/compose/ui/graphics/Color;", "textColor", "MultiRideIdText-RPmYEkk", "(Ljava/lang/String;JLandroidx/compose/runtime/Composer;I)V", "MultiRideIdText", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "multiRideCard", "(Landroidx/compose/ui/Modifier;Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;Landroidx/compose/runtime/Composer;II)V", "LabelStamp-XO-JAsU", "(Ldk/molslinjen/domain/model/booking/TicketCategoryType;Ljava/lang/String;JLandroidx/compose/runtime/Composer;I)V", "LabelStamp", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class MultiRideCardInfoViewKt {
    /* renamed from: LabelStamp-XO-JAsU, reason: not valid java name */
    private static final void m3431LabelStampXOJAsU(final TicketCategoryType ticketCategoryType, final String str, final long j5, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(1808157685);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(ticketCategoryType) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(j5) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1808157685, i6, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.common.LabelStamp (MultiRideCardInfoView.kt:165)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 4;
            Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(BackgroundKt.m103backgroundbw27NRU(companion, AppColor.INSTANCE.m3268getGrey50d7_KjU(), RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(48))), Dp.m2599constructorimpl(8), Dp.m2599constructorimpl(f5));
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            BoxKt.Box(BackgroundKt.m104backgroundbw27NRU$default(ClipKt.clip(SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(10)), RoundedCornerShapeKt.getCircleShape()), TicketCategoryExtensionsKt.getColor(ticketCategoryType), null, 2, null), startRestartGroup, 0);
            SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            TextKt.m940Text4IGK_g(str, null, j5, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubSmallBold(), startRestartGroup, ((i6 >> 3) & 14) | (i6 & 896), 1572864, 65530);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: x2.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit LabelStamp_XO_JAsU$lambda$15;
                    LabelStamp_XO_JAsU$lambda$15 = MultiRideCardInfoViewKt.LabelStamp_XO_JAsU$lambda$15(TicketCategoryType.this, str, j5, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return LabelStamp_XO_JAsU$lambda$15;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LabelStamp_XO_JAsU$lambda$15(TicketCategoryType ticketCategoryType, String str, long j5, int i5, Composer composer, int i6) {
        m3431LabelStampXOJAsU(ticketCategoryType, str, j5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x04fd  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x050d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x05b1  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MultiRideCardInfoView(Modifier modifier, final String str, final LocalDate localDate, final TicketCategoryType ticketCategoryType, final String ticketTypeName, final int i5, MultiRideChargesExpiry multiRideChargesExpiry, boolean z5, boolean z6, Composer composer, final int i6, final int i7) {
        Modifier modifier2;
        int i8;
        int i9;
        int i10;
        boolean z7;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        long m3266getGrey30d7_KjU;
        Object rememberedValue;
        Composer.Companion companion;
        int currentCompositeKeyHash2;
        Composer m1226constructorimpl2;
        int currentCompositeKeyHash3;
        Composer m1226constructorimpl3;
        Composer composer2;
        Modifier.Companion companion2;
        String stringResource;
        Object rememberedValue2;
        int currentCompositeKeyHash4;
        Composer m1226constructorimpl4;
        final boolean z8;
        final boolean z9;
        final Modifier modifier3;
        final MultiRideChargesExpiry multiRideChargesExpiry2;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(ticketCategoryType, "ticketCategoryType");
        Intrinsics.checkNotNullParameter(ticketTypeName, "ticketTypeName");
        Composer startRestartGroup = composer.startRestartGroup(472422132);
        int i11 = i7 & 1;
        if (i11 != 0) {
            i8 = i6 | 6;
            modifier2 = modifier;
        } else {
            modifier2 = modifier;
            if ((i6 & 6) == 0) {
                i8 = i6 | (startRestartGroup.changed(modifier2) ? 4 : 2);
            } else {
                i8 = i6;
            }
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        int i12 = i8;
        if ((i7 & 4) != 0) {
            i12 |= 384;
        } else if ((i6 & 384) == 0) {
            i12 |= startRestartGroup.changedInstance(localDate) ? 256 : 128;
        }
        if ((i7 & 8) != 0) {
            i12 |= 3072;
        } else if ((i6 & 3072) == 0) {
            i12 |= startRestartGroup.changed(ticketCategoryType) ? 2048 : 1024;
        }
        if ((i7 & 16) != 0) {
            i12 |= 24576;
        } else if ((i6 & 24576) == 0) {
            i12 |= startRestartGroup.changed(ticketTypeName) ? 16384 : 8192;
        }
        if ((i7 & 32) != 0) {
            i12 |= 196608;
        } else if ((i6 & 196608) == 0) {
            i12 |= startRestartGroup.changed(i5) ? 131072 : 65536;
        }
        int i13 = i7 & 64;
        if (i13 != 0) {
            i12 |= 1572864;
        } else if ((1572864 & i6) == 0) {
            i12 |= startRestartGroup.changedInstance(multiRideChargesExpiry) ? 1048576 : 524288;
            i9 = 128 & i7;
            if (i9 == 0) {
                i12 |= 12582912;
            } else if ((i6 & 12582912) == 0) {
                i12 |= startRestartGroup.changed(z5) ? 8388608 : 4194304;
            }
            i10 = 256 & i7;
            if (i10 == 0) {
                i12 |= 100663296;
                z7 = z6;
            } else {
                z7 = z6;
                if ((i6 & 100663296) == 0) {
                    i12 |= startRestartGroup.changed(z7) ? 67108864 : 33554432;
                }
            }
            if ((i12 & 38347923) != 38347922 && startRestartGroup.getSkipping()) {
                startRestartGroup.skipToGroupEnd();
                multiRideChargesExpiry2 = multiRideChargesExpiry;
                composer2 = startRestartGroup;
                modifier3 = modifier2;
                z9 = z7;
                z8 = z5;
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                MultiRideChargesExpiry multiRideChargesExpiry3 = i13 == 0 ? null : multiRideChargesExpiry;
                boolean z10 = i9 == 0 ? false : z5;
                if (i10 != 0) {
                    z7 = false;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(472422132, i12, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.common.MultiRideCardInfoView (MultiRideCardInfoView.kt:60)");
                }
                Modifier height = IntrinsicKt.height(modifier2, IntrinsicSize.Min);
                Alignment.Companion companion3 = Alignment.INSTANCE;
                Alignment.Vertical centerVertically = companion3.getCenterVertically();
                Arrangement arrangement = Arrangement.INSTANCE;
                Modifier modifier4 = modifier2;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, height);
                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion4.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor);
                } else {
                    startRestartGroup.useNode();
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
                AppColor appColor = AppColor.INSTANCE;
                long m3266getGrey30d7_KjU2 = !z10 ? appColor.m3266getGrey30d7_KjU() : appColor.m3253getBrandBlack10d7_KjU();
                AppColor appColor2 = AppColor.INSTANCE;
                m3266getGrey30d7_KjU = !z10 ? appColor2.m3266getGrey30d7_KjU() : appColor2.m3264getGrey10d7_KjU();
                Modifier.Companion companion5 = Modifier.INSTANCE;
                Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion5, 0.7f, false, 2, null);
                startRestartGroup.startReplaceGroup(-328884952);
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: x2.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit MultiRideCardInfoView$lambda$8$lambda$1$lambda$0;
                            MultiRideCardInfoView$lambda$8$lambda$1$lambda$0 = MultiRideCardInfoViewKt.MultiRideCardInfoView$lambda$8$lambda$1$lambda$0((SemanticsPropertyReceiver) obj);
                            return MultiRideCardInfoView$lambda$8$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier semantics$default = SemanticsModifierKt.semantics$default(weight$default, false, (Function1) rememberedValue, 1, null);
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getCenter(), companion3.getStart(), startRestartGroup, 6);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default);
                Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                if (!m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                float f5 = 8;
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion5, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getCenterVertically(), startRestartGroup, 48);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, companion5);
                Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy2, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
                if (!m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.multiRide, startRestartGroup, 6), null, m3266getGrey30d7_KjU2, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), startRestartGroup, 0, 1572864, 65530);
                SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion5, Dp.m2599constructorimpl(16)), startRestartGroup, 6);
                int i14 = i12;
                m3431LabelStampXOJAsU(ticketCategoryType, ticketTypeName, m3266getGrey30d7_KjU2, startRestartGroup, (i12 >> 9) & 126);
                startRestartGroup.endNode();
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(-1892697316);
                if (str == null || z7) {
                    m3432MultiRideIdTextRPmYEkk(str, m3266getGrey30d7_KjU, composer2, (i14 >> 3) & 14);
                }
                composer2.endReplaceGroup();
                composer2.startReplaceGroup(-1892691011);
                if (localDate != null) {
                    companion2 = companion5;
                } else {
                    companion2 = companion5;
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(4)), composer2, 6);
                    if (multiRideChargesExpiry3 != null) {
                        composer2.startReplaceGroup(652801295);
                        stringResource = StringResources_androidKt.stringResource(R.string.multiRide_chargesExpiresByDate, new Object[]{StringResources_androidKt.pluralStringResource(R.plurals.multiRide_numberOfCharges, multiRideChargesExpiry3.getCharges(), new Object[]{Integer.valueOf(multiRideChargesExpiry3.getCharges())}, composer2, 6), LocalDateTimeExtensionsKt.toShortFormat(multiRideChargesExpiry3.getExpiryDate())}, composer2, 6);
                        composer2.endReplaceGroup();
                    } else if (z10) {
                        composer2.startReplaceGroup(652812658);
                        stringResource = StringResources_androidKt.stringResource(R.string.agreement_expiredDate, new Object[]{LocalDateTimeExtensionsKt.toShortFormat(localDate)}, composer2, 6);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(652815857);
                        stringResource = StringResources_androidKt.stringResource(R.string.agreement_expireDate, new Object[]{LocalDateTimeExtensionsKt.toShortFormat(localDate)}, composer2, 6);
                        composer2.endReplaceGroup();
                    }
                    TextKt.m940Text4IGK_g(stringResource, null, m3266getGrey30d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), composer2, 0, 1572864, 65530);
                    Unit unit = Unit.INSTANCE;
                }
                composer2.endReplaceGroup();
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(f5)), composer2, 6);
                composer2.endNode();
                VerticalDividerKt.m3394VerticalDividertZIQpXc(SizeKt.fillMaxHeight$default(companion2, 0.0f, 1, null), 0L, 0.0f, Dp.m2597boximpl(Dp.m2599constructorimpl(2)), composer2, 3078, 6);
                Modifier weight$default2 = RowScope.weight$default(rowScopeInstance, PaddingKt.m313paddingVpY3zN4$default(companion2, 0.0f, Dp.m2599constructorimpl(f5), 1, null), 0.3f, false, 2, null);
                composer2.startReplaceGroup(-328821912);
                rememberedValue2 = composer2.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: x2.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit MultiRideCardInfoView$lambda$8$lambda$6$lambda$5;
                            MultiRideCardInfoView$lambda$8$lambda$6$lambda$5 = MultiRideCardInfoViewKt.MultiRideCardInfoView$lambda$8$lambda$6$lambda$5((SemanticsPropertyReceiver) obj);
                            return MultiRideCardInfoView$lambda$8$lambda$6$lambda$5;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue2);
                }
                composer2.endReplaceGroup();
                Modifier semantics$default2 = SemanticsModifierKt.semantics$default(weight$default2, false, (Function1) rememberedValue2, 1, null);
                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getCenterHorizontally(), composer2, 48);
                currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, semantics$default2);
                Function0<ComposeUiNode> constructor4 = companion4.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (!composer2.getInserting()) {
                    composer2.createNode(constructor4);
                } else {
                    composer2.useNode();
                }
                m1226constructorimpl4 = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl4, columnMeasurePolicy2, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion4.getSetCompositeKeyHash();
                if (!m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion4.getSetModifier());
                TextKt.m940Text4IGK_g(String.valueOf(i5), null, m3266getGrey30d7_KjU2, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH1Bold(), composer2, 0, 1572864, 65530);
                TextKt.m940Text4IGK_g(StringResources_androidKt.pluralStringResource(R.plurals.multiRide_charges, i5, composer2, ((i14 >> 12) & 112) | 6), null, m3266getGrey30d7_KjU2, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer2, 0, 1572864, 65530);
                composer2.endNode();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z8 = z10;
                z9 = z7;
                modifier3 = modifier4;
                multiRideChargesExpiry2 = multiRideChargesExpiry3;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: x2.d
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit MultiRideCardInfoView$lambda$9;
                        MultiRideCardInfoView$lambda$9 = MultiRideCardInfoViewKt.MultiRideCardInfoView$lambda$9(Modifier.this, str, localDate, ticketCategoryType, ticketTypeName, i5, multiRideChargesExpiry2, z8, z9, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                        return MultiRideCardInfoView$lambda$9;
                    }
                });
                return;
            }
            return;
        }
        i9 = 128 & i7;
        if (i9 == 0) {
        }
        i10 = 256 & i7;
        if (i10 == 0) {
        }
        if ((i12 & 38347923) != 38347922) {
        }
        if (i11 != 0) {
        }
        if (i13 == 0) {
        }
        if (i9 == 0) {
        }
        if (i10 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier height2 = IntrinsicKt.height(modifier2, IntrinsicSize.Min);
        Alignment.Companion companion32 = Alignment.INSTANCE;
        Alignment.Vertical centerVertically2 = companion32.getCenterVertically();
        Arrangement arrangement2 = Arrangement.INSTANCE;
        Modifier modifier42 = modifier2;
        MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement2.getStart(), centerVertically2, startRestartGroup, 48);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(startRestartGroup, height2);
        ComposeUiNode.Companion companion42 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor5 = companion42.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (!startRestartGroup.getInserting()) {
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
        AppColor appColor3 = AppColor.INSTANCE;
        long m3266getGrey30d7_KjU22 = !z10 ? appColor3.m3266getGrey30d7_KjU() : appColor3.m3253getBrandBlack10d7_KjU();
        AppColor appColor22 = AppColor.INSTANCE;
        m3266getGrey30d7_KjU = !z10 ? appColor22.m3266getGrey30d7_KjU() : appColor22.m3264getGrey10d7_KjU();
        Modifier.Companion companion52 = Modifier.INSTANCE;
        Modifier weight$default3 = RowScope.weight$default(rowScopeInstance2, companion52, 0.7f, false, 2, null);
        startRestartGroup.startReplaceGroup(-328884952);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier semantics$default3 = SemanticsModifierKt.semantics$default(weight$default3, false, (Function1) rememberedValue, 1, null);
        MeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(arrangement2.getCenter(), companion32.getStart(), startRestartGroup, 6);
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default3);
        Function0<ComposeUiNode> constructor22 = companion42.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (!startRestartGroup.getInserting()) {
        }
        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy3, companion42.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22, companion42.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion42.getSetCompositeKeyHash();
        if (!m1226constructorimpl2.getInserting()) {
        }
        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22, companion42.getSetModifier());
        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
        float f52 = 8;
        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion52, Dp.m2599constructorimpl(f52)), startRestartGroup, 6);
        MeasurePolicy rowMeasurePolicy22 = RowKt.rowMeasurePolicy(arrangement2.getStart(), companion32.getCenterVertically(), startRestartGroup, 48);
        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(startRestartGroup, companion52);
        Function0<ComposeUiNode> constructor32 = companion42.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (!startRestartGroup.getInserting()) {
        }
        m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy22, companion42.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap32, companion42.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash32 = companion42.getSetCompositeKeyHash();
        if (!m1226constructorimpl3.getInserting()) {
        }
        m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
        m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash32);
        Updater.m1227setimpl(m1226constructorimpl3, materializeModifier32, companion42.getSetModifier());
        TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.multiRide, startRestartGroup, 6), null, m3266getGrey30d7_KjU22, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), startRestartGroup, 0, 1572864, 65530);
        SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion52, Dp.m2599constructorimpl(16)), startRestartGroup, 6);
        int i142 = i12;
        m3431LabelStampXOJAsU(ticketCategoryType, ticketTypeName, m3266getGrey30d7_KjU22, startRestartGroup, (i12 >> 9) & 126);
        startRestartGroup.endNode();
        composer2 = startRestartGroup;
        composer2.startReplaceGroup(-1892697316);
        if (str == null) {
        }
        m3432MultiRideIdTextRPmYEkk(str, m3266getGrey30d7_KjU, composer2, (i142 >> 3) & 14);
        composer2.endReplaceGroup();
        composer2.startReplaceGroup(-1892691011);
        if (localDate != null) {
        }
        composer2.endReplaceGroup();
        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(f52)), composer2, 6);
        composer2.endNode();
        VerticalDividerKt.m3394VerticalDividertZIQpXc(SizeKt.fillMaxHeight$default(companion2, 0.0f, 1, null), 0L, 0.0f, Dp.m2597boximpl(Dp.m2599constructorimpl(2)), composer2, 3078, 6);
        Modifier weight$default22 = RowScope.weight$default(rowScopeInstance2, PaddingKt.m313paddingVpY3zN4$default(companion2, 0.0f, Dp.m2599constructorimpl(f52), 1, null), 0.3f, false, 2, null);
        composer2.startReplaceGroup(-328821912);
        rememberedValue2 = composer2.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        composer2.endReplaceGroup();
        Modifier semantics$default22 = SemanticsModifierKt.semantics$default(weight$default22, false, (Function1) rememberedValue2, 1, null);
        MeasurePolicy columnMeasurePolicy22 = ColumnKt.columnMeasurePolicy(arrangement2.getTop(), companion32.getCenterHorizontally(), composer2, 48);
        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
        CompositionLocalMap currentCompositionLocalMap42 = composer2.getCurrentCompositionLocalMap();
        Modifier materializeModifier42 = ComposedModifierKt.materializeModifier(composer2, semantics$default22);
        Function0<ComposeUiNode> constructor42 = companion42.getConstructor();
        if (composer2.getApplier() == null) {
        }
        composer2.startReusableNode();
        if (!composer2.getInserting()) {
        }
        m1226constructorimpl4 = Updater.m1226constructorimpl(composer2);
        Updater.m1227setimpl(m1226constructorimpl4, columnMeasurePolicy22, companion42.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap42, companion42.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash42 = companion42.getSetCompositeKeyHash();
        if (!m1226constructorimpl4.getInserting()) {
        }
        m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
        m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash42);
        Updater.m1227setimpl(m1226constructorimpl4, materializeModifier42, companion42.getSetModifier());
        TextKt.m940Text4IGK_g(String.valueOf(i5), null, m3266getGrey30d7_KjU22, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH1Bold(), composer2, 0, 1572864, 65530);
        TextKt.m940Text4IGK_g(StringResources_androidKt.pluralStringResource(R.plurals.multiRide_charges, i5, composer2, ((i142 >> 12) & 112) | 6), null, m3266getGrey30d7_KjU22, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer2, 0, 1572864, 65530);
        composer2.endNode();
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        z8 = z10;
        z9 = z7;
        modifier3 = modifier42;
        multiRideChargesExpiry2 = multiRideChargesExpiry3;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideCardInfoView$lambda$13(Modifier modifier, MultiRideCard multiRideCard, int i5, int i6, Composer composer, int i7) {
        MultiRideCardInfoView(modifier, multiRideCard, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideCardInfoView$lambda$8$lambda$1$lambda$0(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setTraversalGroup(semantics, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideCardInfoView$lambda$8$lambda$6$lambda$5(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setTraversalGroup(semantics, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideCardInfoView$lambda$9(Modifier modifier, String str, LocalDate localDate, TicketCategoryType ticketCategoryType, String str2, int i5, MultiRideChargesExpiry multiRideChargesExpiry, boolean z5, boolean z6, int i6, int i7, Composer composer, int i8) {
        MultiRideCardInfoView(modifier, str, localDate, ticketCategoryType, str2, i5, multiRideChargesExpiry, z5, z6, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }

    /* renamed from: MultiRideIdText-RPmYEkk, reason: not valid java name */
    private static final void m3432MultiRideIdTextRPmYEkk(final String str, final long j5, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(2130677013);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(j5) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2130677013, i6, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.common.MultiRideIdText (MultiRideCardInfoView.kt:137)");
            }
            final String stringResource = StringResources_androidKt.stringResource(R.string.accessibilityLabel_number, new Object[]{str == null ? BuildConfig.FLAVOR : str}, startRestartGroup, 6);
            Modifier.Companion companion = Modifier.INSTANCE;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(16)), startRestartGroup, 6);
            Modifier m3425skeletont9lfQc4$default = SkeletonKt.m3425skeletont9lfQc4$default(companion, str == null, null, 2, null);
            startRestartGroup.startReplaceGroup(-127672352);
            boolean changed = startRestartGroup.changed(stringResource);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: x2.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit MultiRideIdText_RPmYEkk$lambda$11$lambda$10;
                        MultiRideIdText_RPmYEkk$lambda$11$lambda$10 = MultiRideCardInfoViewKt.MultiRideIdText_RPmYEkk$lambda$11$lambda$10(stringResource, (SemanticsPropertyReceiver) obj);
                        return MultiRideIdText_RPmYEkk$lambda$11$lambda$10;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(str == null ? "XXX000000000000XXXX" : str, SemanticsModifierKt.semantics$default(m3425skeletont9lfQc4$default, false, (Function1) rememberedValue, 1, null), j5, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, (i6 << 3) & 896, 1572864, 65528);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: x2.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MultiRideIdText_RPmYEkk$lambda$12;
                    MultiRideIdText_RPmYEkk$lambda$12 = MultiRideCardInfoViewKt.MultiRideIdText_RPmYEkk$lambda$12(str, j5, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return MultiRideIdText_RPmYEkk$lambda$12;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideIdText_RPmYEkk$lambda$11$lambda$10(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideIdText_RPmYEkk$lambda$12(String str, long j5, int i5, Composer composer, int i6) {
        m3432MultiRideIdTextRPmYEkk(str, j5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void MultiRideCardInfoView(Modifier modifier, final MultiRideCard multiRideCard, Composer composer, final int i5, final int i6) {
        final Modifier modifier2;
        int i7;
        Composer composer2;
        Intrinsics.checkNotNullParameter(multiRideCard, "multiRideCard");
        Composer startRestartGroup = composer.startRestartGroup(430455838);
        int i8 = i6 & 1;
        if (i8 != 0) {
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
            i7 |= startRestartGroup.changedInstance(multiRideCard) ? 32 : 16;
        }
        if ((i7 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            Modifier modifier3 = i8 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(430455838, i7, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.common.MultiRideCardInfoView (MultiRideCardInfoView.kt:151)");
            }
            composer2 = startRestartGroup;
            MultiRideCardInfoView(modifier3, multiRideCard.getId(), multiRideCard.getValidUntil(), multiRideCard.getTicketType(), multiRideCard.getTicketTypeName(), multiRideCard.getRemainingCharges(), multiRideCard.getChargesExpirySoon(), multiRideCard.isExpired(), false, startRestartGroup, i7 & 14, 256);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: x2.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MultiRideCardInfoView$lambda$13;
                    MultiRideCardInfoView$lambda$13 = MultiRideCardInfoViewKt.MultiRideCardInfoView$lambda$13(Modifier.this, multiRideCard, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return MultiRideCardInfoView$lambda$13;
                }
            });
        }
    }
}
