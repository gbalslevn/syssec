package dk.molslinjen.ui.views.screens.booking.addons.seating.select;

import android.content.Context;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.extensions.domain.FerrySeatExtenstionsKt;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.extensions.domain.PriceFormatExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.IconTextButtonKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.select.SeatsActionSheetKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerrySeat;

@Metadata(d1 = {"\u00000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a[\u0010\u000b\u001a\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a9\u0010\r\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0003¢\u0006\u0004\b\r\u0010\u000e\u001a3\u0010\u0011\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0003¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0017²\u0006\u000e\u0010\u0014\u001a\u00020\u00138\n@\nX\u008a\u008e\u0002²\u0006\f\u0010\u0016\u001a\u00020\u00158\nX\u008a\u0084\u0002"}, d2 = {BuildConfig.FLAVOR, "maxSeats", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeat;", "selectedSeats", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onToggleSeat", "Lkotlin/Function0;", "onConfirmPressed", "onDeleteReservationPressed", "SeatsActionSheet", "(Ljava/lang/Integer;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SeatsList", "(ILjava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "seat", "onRemoveSeat", "SeatRow", "(Luniffi/molslinjen_shared/FerrySeat;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", BuildConfig.FLAVOR, "showSeatsInfo", BuildConfig.FLAVOR, "iconRotation", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SeatsActionSheetKt {
    /* JADX WARN: Removed duplicated region for block: B:103:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0459  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void SeatRow(FerrySeat ferrySeat, Function1<? super FerrySeat, Unit> function1, Composer composer, final int i5, final int i6) {
        FerrySeat ferrySeat2;
        int i7;
        final Function1<? super FerrySeat, Unit> function12;
        FerrySeat ferrySeat3;
        String stringResource;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        FerrySeat ferrySeat4;
        Object rememberedValue;
        Composer.Companion companion;
        int currentCompositeKeyHash2;
        Composer m1226constructorimpl2;
        int currentCompositeKeyHash3;
        Composer m1226constructorimpl3;
        Object rememberedValue2;
        Composer composer2;
        final FerrySeat ferrySeat5;
        final Function1<? super FerrySeat, Unit> function13;
        Function1<? super FerrySeat, Unit> function14;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1444919326);
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 = i5 | 6;
            ferrySeat2 = ferrySeat;
        } else if ((i5 & 6) == 0) {
            ferrySeat2 = ferrySeat;
            i7 = (startRestartGroup.changedInstance(ferrySeat2) ? 4 : 2) | i5;
        } else {
            ferrySeat2 = ferrySeat;
            i7 = i5;
        }
        int i9 = i6 & 2;
        if (i9 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            function12 = function1;
            i7 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
            if ((i7 & 19) == 18 || !startRestartGroup.getSkipping()) {
                ferrySeat3 = i8 == 0 ? null : ferrySeat2;
                if (i9 != 0) {
                    function12 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1444919326, i7, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.select.SeatRow (SeatsActionSheet.kt:175)");
                }
                if (ferrySeat3 == null) {
                    startRestartGroup.startReplaceGroup(-195172672);
                    stringResource = StringResources_androidKt.stringResource(R.string.selectSeat_seatTitle, new Object[]{ferrySeat3.getName()}, startRestartGroup, 6);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(-195090336);
                    stringResource = StringResources_androidKt.stringResource(R.string.selectSeat_chooseOnMap_singular, startRestartGroup, 6);
                    startRestartGroup.endReplaceGroup();
                }
                long m2298getColor0d7_KjU = ferrySeat3 == null ? TypographyKt.getParagraph().m2298getColor0d7_KjU() : AppColor.INSTANCE.m3265getGrey20d7_KjU();
                Modifier.Companion companion2 = Modifier.INSTANCE;
                float f5 = 16;
                Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion2, Dp.m2599constructorimpl(f5), 0.0f, 2, null);
                Alignment.Companion companion3 = Alignment.INSTANCE;
                Alignment.Vertical centerVertically = companion3.getCenterVertically();
                Arrangement arrangement = Arrangement.INSTANCE;
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
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
                int i10 = i7;
                Function1<? super FerrySeat, Unit> function15 = function12;
                ferrySeat4 = ferrySeat3;
                ImageKt.Image(PainterResources_androidKt.painterResource(ferrySeat3 == null ? R.drawable.seat_selected_checmark_small : R.drawable.seat_not_available, startRestartGroup, 0), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion2, Dp.m2599constructorimpl(24)), null, null, 0.0f, null, startRestartGroup, 384, 120);
                SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion2, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(-1627273553);
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: I2.t
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit SeatRow$lambda$23$lambda$14$lambda$13;
                            SeatRow$lambda$23$lambda$14$lambda$13 = SeatsActionSheetKt.SeatRow$lambda$23$lambda$14$lambda$13((SemanticsPropertyReceiver) obj);
                            return SeatRow$lambda$23$lambda$14$lambda$13;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier semantics$default = SemanticsModifierKt.semantics$default(companion2, false, (Function1) rememberedValue, 1, null);
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), startRestartGroup, 0);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default);
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
                Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                if (!m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getTop(), startRestartGroup, 0);
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
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
                Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy2, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
                if (!m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
                Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null);
                startRestartGroup.startReplaceGroup(1566537899);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: I2.u
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit SeatRow$lambda$23$lambda$22$lambda$19$lambda$16$lambda$15;
                            SeatRow$lambda$23$lambda$22$lambda$19$lambda$16$lambda$15 = SeatsActionSheetKt.SeatRow$lambda$23$lambda$22$lambda$19$lambda$16$lambda$15((SemanticsPropertyReceiver) obj);
                            return SeatRow$lambda$23$lambda$22$lambda$19$lambda$16$lambda$15;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                TextKt.m940Text4IGK_g(stringResource, SemanticsModifierKt.semantics$default(weight$default, false, (Function1) rememberedValue2, 1, null), m2298getColor0d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), composer2, 0, 1572864, 65528);
                composer2.startReplaceGroup(1566544139);
                if (ferrySeat4 == null) {
                    PriceWithCurrency priceWithCurrency = FerrySeatExtenstionsKt.getPriceWithCurrency(ferrySeat4);
                    composer2.startReplaceGroup(1566545905);
                    String formatted = priceWithCurrency == null ? null : PriceFormatExtensionsKt.formatted(priceWithCurrency, (Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext()));
                    composer2.endReplaceGroup();
                    ferrySeat5 = ferrySeat4;
                    TextKt.m940Text4IGK_g(formatted == null ? BuildConfig.FLAVOR : formatted, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmallBold(), composer2, 0, 1572864, 65534);
                    SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion2, Dp.m2599constructorimpl(f5)), composer2, 6);
                    Modifier m331size3ABfNKs = SizeKt.m331size3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 11, null), Dp.m2599constructorimpl(f5));
                    composer2.startReplaceGroup(1566556368);
                    boolean changedInstance = composer2.changedInstance(ferrySeat5) | ((i10 & 112) == 32);
                    Object rememberedValue3 = composer2.rememberedValue();
                    if (changedInstance || rememberedValue3 == companion.getEmpty()) {
                        function13 = function15;
                        rememberedValue3 = new Function0() { // from class: I2.v
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit SeatRow$lambda$23$lambda$22$lambda$19$lambda$18$lambda$17;
                                SeatRow$lambda$23$lambda$22$lambda$19$lambda$18$lambda$17 = SeatsActionSheetKt.SeatRow$lambda$23$lambda$22$lambda$19$lambda$18$lambda$17(Function1.this, ferrySeat5);
                                return SeatRow$lambda$23$lambda$22$lambda$19$lambda$18$lambda$17;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue3);
                    } else {
                        function13 = function15;
                    }
                    composer2.endReplaceGroup();
                    IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_delete, composer2, 6), StringResources_androidKt.stringResource(R.string.accessibilityLabel_remove, composer2, 6), ClickableKt.m122clickableXHw0xAI$default(m331size3ABfNKs, false, null, null, (Function0) rememberedValue3, 7, null), AppColor.INSTANCE.m3264getGrey10d7_KjU(), composer2, 3072, 0);
                } else {
                    ferrySeat5 = ferrySeat4;
                    function13 = function15;
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                composer2.startReplaceGroup(-241066901);
                if (ferrySeat5 == null) {
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(4)), composer2, 6);
                    composer2.startReplaceGroup(-241062388);
                    Object rememberedValue4 = composer2.rememberedValue();
                    if (rememberedValue4 == companion.getEmpty()) {
                        rememberedValue4 = new Function1() { // from class: I2.w
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit SeatRow$lambda$23$lambda$22$lambda$21$lambda$20;
                                SeatRow$lambda$23$lambda$22$lambda$21$lambda$20 = SeatsActionSheetKt.SeatRow$lambda$23$lambda$22$lambda$21$lambda$20((SemanticsPropertyReceiver) obj);
                                return SeatRow$lambda$23$lambda$22$lambda$21$lambda$20;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue4);
                    }
                    composer2.endReplaceGroup();
                    function14 = function13;
                    TextKt.m940Text4IGK_g(ferrySeat5.getSection(), SemanticsModifierKt.semantics$default(companion2, false, (Function1) rememberedValue4, 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 0, 1572864, 65532);
                } else {
                    function14 = function13;
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function12 = function14;
            } else {
                startRestartGroup.skipToGroupEnd();
                ferrySeat5 = ferrySeat2;
                composer2 = startRestartGroup;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: I2.x
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit SeatRow$lambda$24;
                        SeatRow$lambda$24 = SeatsActionSheetKt.SeatRow$lambda$24(FerrySeat.this, function12, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return SeatRow$lambda$24;
                    }
                });
                return;
            }
            return;
        }
        function12 = function1;
        if ((i7 & 19) == 18) {
        }
        if (i8 == 0) {
        }
        if (i9 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (ferrySeat3 == null) {
        }
        long m2298getColor0d7_KjU2 = ferrySeat3 == null ? TypographyKt.getParagraph().m2298getColor0d7_KjU() : AppColor.INSTANCE.m3265getGrey20d7_KjU();
        Modifier.Companion companion22 = Modifier.INSTANCE;
        float f52 = 16;
        Modifier m313paddingVpY3zN4$default2 = PaddingKt.m313paddingVpY3zN4$default(companion22, Dp.m2599constructorimpl(f52), 0.0f, 2, null);
        Alignment.Companion companion32 = Alignment.INSTANCE;
        Alignment.Vertical centerVertically2 = companion32.getCenterVertically();
        Arrangement arrangement2 = Arrangement.INSTANCE;
        MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement2.getStart(), centerVertically2, startRestartGroup, 48);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default2);
        ComposeUiNode.Companion companion42 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor4 = companion42.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy3, companion42.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap4, companion42.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion42.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash4);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier4, companion42.getSetModifier());
        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
        if (ferrySeat3 == null) {
        }
        int i102 = i7;
        Function1<? super FerrySeat, Unit> function152 = function12;
        ferrySeat4 = ferrySeat3;
        ImageKt.Image(PainterResources_androidKt.painterResource(ferrySeat3 == null ? R.drawable.seat_selected_checmark_small : R.drawable.seat_not_available, startRestartGroup, 0), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion22, Dp.m2599constructorimpl(24)), null, null, 0.0f, null, startRestartGroup, 384, 120);
        SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion22, Dp.m2599constructorimpl(f52)), startRestartGroup, 6);
        startRestartGroup.startReplaceGroup(-1627273553);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier semantics$default2 = SemanticsModifierKt.semantics$default(companion22, false, (Function1) rememberedValue, 1, null);
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement2.getTop(), companion32.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics$default2);
        Function0<ComposeUiNode> constructor22 = companion42.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy2, companion42.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22, companion42.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion42.getSetCompositeKeyHash();
        if (!m1226constructorimpl2.getInserting()) {
        }
        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22, companion42.getSetModifier());
        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
        MeasurePolicy rowMeasurePolicy22 = RowKt.rowMeasurePolicy(arrangement2.getStart(), companion32.getTop(), startRestartGroup, 0);
        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap32 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier32 = ComposedModifierKt.materializeModifier(startRestartGroup, companion22);
        Function0<ComposeUiNode> constructor32 = companion42.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
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
        Modifier weight$default2 = RowScope.weight$default(rowScopeInstance2, companion22, 1.0f, false, 2, null);
        startRestartGroup.startReplaceGroup(1566537899);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        composer2 = startRestartGroup;
        TextKt.m940Text4IGK_g(stringResource, SemanticsModifierKt.semantics$default(weight$default2, false, (Function1) rememberedValue2, 1, null), m2298getColor0d7_KjU2, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), composer2, 0, 1572864, 65528);
        composer2.startReplaceGroup(1566544139);
        if (ferrySeat4 == null) {
        }
        composer2.endReplaceGroup();
        composer2.endNode();
        composer2.startReplaceGroup(-241066901);
        if (ferrySeat5 == null) {
        }
        composer2.endReplaceGroup();
        composer2.endNode();
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        function12 = function14;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SeatRow$lambda$23$lambda$14$lambda$13(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setTraversalGroup(semantics, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SeatRow$lambda$23$lambda$22$lambda$19$lambda$16$lambda$15(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setTraversalIndex(semantics, -20.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SeatRow$lambda$23$lambda$22$lambda$19$lambda$18$lambda$17(Function1 function1, FerrySeat ferrySeat) {
        if (function1 != null) {
            function1.invoke(ferrySeat);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SeatRow$lambda$23$lambda$22$lambda$21$lambda$20(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setTraversalIndex(semantics, -10.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SeatRow$lambda$24(FerrySeat ferrySeat, Function1 function1, int i5, int i6, Composer composer, int i7) {
        SeatRow(ferrySeat, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SeatsActionSheet(final Integer num, final List<FerrySeat> selectedSeats, final Function1<? super FerrySeat, Unit> onToggleSeat, final Function0<Unit> onConfirmPressed, Function0<Unit> function0, Composer composer, final int i5, final int i6) {
        int i7;
        Function0<Unit> function02;
        Function0<Unit> function03;
        String stringResource;
        Composer composer2;
        int i8;
        Intrinsics.checkNotNullParameter(selectedSeats, "selectedSeats");
        Intrinsics.checkNotNullParameter(onToggleSeat, "onToggleSeat");
        Intrinsics.checkNotNullParameter(onConfirmPressed, "onConfirmPressed");
        Composer startRestartGroup = composer.startRestartGroup(-1043630550);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(num) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(selectedSeats) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(onToggleSeat) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(onConfirmPressed) ? 2048 : 1024;
        }
        int i9 = i6 & 16;
        if (i9 != 0) {
            i7 |= 24576;
        } else if ((i5 & 24576) == 0) {
            function02 = function0;
            i7 |= startRestartGroup.changedInstance(function02) ? 16384 : 8192;
            if ((i7 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                function03 = i9 == 0 ? null : function02;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1043630550, i7, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.select.SeatsActionSheet (SeatsActionSheet.kt:59)");
                }
                if (num != null) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        final Function0<Unit> function04 = function03;
                        endRestartGroup.updateScope(new Function2() { // from class: I2.p
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit SeatsActionSheet$lambda$0;
                                SeatsActionSheet$lambda$0 = SeatsActionSheetKt.SeatsActionSheet$lambda$0(num, selectedSeats, onToggleSeat, onConfirmPressed, function04, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                return SeatsActionSheet$lambda$0;
                            }
                        });
                        return;
                    }
                    return;
                }
                startRestartGroup.startReplaceGroup(1326393501);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                final MutableState mutableState = (MutableState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(SeatsActionSheet$lambda$2(mutableState) ? 180.0f : 0.0f, null, 0.0f, "iconRotation", null, startRestartGroup, 3072, 22);
                int i10 = SeatsActionSheet$lambda$2(mutableState) ? R.string.button_hideDetails : R.string.button_showDetails;
                Modifier.Companion companion2 = Modifier.INSTANCE;
                Modifier modifier = ModifierExtensionsKt.topShadow(companion2);
                AppColor appColor = AppColor.INSTANCE;
                Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(modifier, appColor.m3281getWhite0d7_KjU(), null, 2, null);
                Alignment.Companion companion3 = Alignment.INSTANCE;
                Alignment.Horizontal centerHorizontally = companion3.getCenterHorizontally();
                Arrangement arrangement = Arrangement.INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), centerHorizontally, startRestartGroup, 48);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default);
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
                startRestartGroup.startReplaceGroup(-1639468996);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: I2.q
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit SeatsActionSheet$lambda$9$lambda$6$lambda$5;
                            SeatsActionSheet$lambda$9$lambda$6$lambda$5 = SeatsActionSheetKt.SeatsActionSheet$lambda$9$lambda$6$lambda$5(MutableState.this);
                            return SeatsActionSheet$lambda$9$lambda$6$lambda$5;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                float f5 = 16;
                Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(ClickableKt.m122clickableXHw0xAI$default(companion2, false, null, null, (Function0) rememberedValue2, 7, null), Dp.m2599constructorimpl(f5));
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getCenterVertically(), startRestartGroup, 48);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
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
                int i11 = i7;
                Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion4.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                int size = selectedSeats.size();
                boolean z5 = size > 0;
                if (z5) {
                    startRestartGroup.startReplaceGroup(-1280093904);
                    stringResource = StringResources_androidKt.stringResource(R.string.selectSeat_xOfYSeatsChosen, new Object[]{Integer.valueOf(size), num}, startRestartGroup, 6);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(-1279963704);
                    if (num.intValue() == 1) {
                        startRestartGroup.startReplaceGroup(-1279931836);
                        stringResource = StringResources_androidKt.stringResource(R.string.selectSeat_chooseOnMap_singular, startRestartGroup, 6);
                        startRestartGroup.endReplaceGroup();
                    } else {
                        startRestartGroup.startReplaceGroup(-1279825754);
                        stringResource = StringResources_androidKt.stringResource(R.string.selectSeat_chooseOnMap_plural, startRestartGroup, 6);
                        startRestartGroup.endReplaceGroup();
                    }
                    startRestartGroup.endReplaceGroup();
                }
                int i12 = z5 ? R.drawable.seat_selected_checmark_small : R.drawable.seat_not_available;
                Modifier m331size3ABfNKs = SizeKt.m331size3ABfNKs(companion2, Dp.m2599constructorimpl(f5));
                Painter painterResource = PainterResources_androidKt.painterResource(i12, startRestartGroup, 0);
                Accessibility accessibility = Accessibility.INSTANCE;
                ImageKt.Image(painterResource, accessibility.getSkip(), m331size3ABfNKs, null, null, 0.0f, null, startRestartGroup, 384, 120);
                float f6 = 8;
                SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion2, Dp.m2599constructorimpl(f6)), startRestartGroup, 6);
                TextKt.m940Text4IGK_g(stringResource, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 0, 1572864, 65534);
                SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), startRestartGroup, 0);
                IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_up_arrow, startRestartGroup, 6), accessibility.getSkip(), RotateKt.rotate(SizeKt.m331size3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 11, null), Dp.m2599constructorimpl(f5)), SeatsActionSheet$lambda$4(animateFloatAsState)), appColor.m3265getGrey20d7_KjU(), startRestartGroup, 3072, 0);
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(i10, startRestartGroup, 0), null, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 384, 1572864, 65530);
                startRestartGroup.endNode();
                AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, SeatsActionSheet$lambda$2(mutableState), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(2038039964, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.addons.seating.select.SeatsActionSheetKt$SeatsActionSheet$2$3
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num2) {
                        invoke(animatedVisibilityScope, composer3, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer3, int i13) {
                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2038039964, i13, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.select.SeatsActionSheet.<anonymous>.<anonymous> (SeatsActionSheet.kt:124)");
                        }
                        HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m313paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m2599constructorimpl(16), 0.0f, 2, null), 0L, 0.0f, null, composer3, 6, 14);
                        SeatsActionSheetKt.SeatsList(num.intValue(), selectedSeats, onToggleSeat, composer3, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, 1572870, 30);
                HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m313paddingVpY3zN4$default(companion2, Dp.m2599constructorimpl(f5), 0.0f, 2, null), 0L, 0.0f, null, startRestartGroup, 6, 14);
                BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI(StringResources_androidKt.stringResource(R.string.button_reserveSeats, startRestartGroup, 6), FerrySeatExtenstionsKt.totalPrice(selectedSeats), num.intValue() == selectedSeats.size(), false, false, 0L, onConfirmPressed, onConfirmPressed, startRestartGroup, ((i11 << 9) & 3670016) | ((i11 << 12) & 29360128), 56);
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(-1639390819);
                if (function03 == null) {
                    i8 = 6;
                } else {
                    i8 = 6;
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(f6)), composer2, 6);
                    IconTextButtonKt.m3404IconTextButtonV9fs2A(null, function03, R.drawable.icon_delete, R.string.button_deleteSeatReservation, false, appColor.m3272getSignalRed0d7_KjU(), composer2, 200064, 17);
                    Unit unit = Unit.INSTANCE;
                }
                composer2.endReplaceGroup();
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(24)), composer2, i8);
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                function03 = function02;
                composer2 = startRestartGroup;
            }
            ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
            if (endRestartGroup2 != null) {
                final Function0<Unit> function05 = function03;
                endRestartGroup2.updateScope(new Function2() { // from class: I2.r
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit SeatsActionSheet$lambda$10;
                        SeatsActionSheet$lambda$10 = SeatsActionSheetKt.SeatsActionSheet$lambda$10(num, selectedSeats, onToggleSeat, onConfirmPressed, function05, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return SeatsActionSheet$lambda$10;
                    }
                });
                return;
            }
            return;
        }
        function02 = function0;
        if ((i7 & 9363) == 9362) {
        }
        if (i9 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (num != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SeatsActionSheet$lambda$0(Integer num, List list, Function1 function1, Function0 function0, Function0 function02, int i5, int i6, Composer composer, int i7) {
        SeatsActionSheet(num, list, function1, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SeatsActionSheet$lambda$10(Integer num, List list, Function1 function1, Function0 function0, Function0 function02, int i5, int i6, Composer composer, int i7) {
        SeatsActionSheet(num, list, function1, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    private static final boolean SeatsActionSheet$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void SeatsActionSheet$lambda$3(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    private static final float SeatsActionSheet$lambda$4(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SeatsActionSheet$lambda$9$lambda$6$lambda$5(MutableState mutableState) {
        SeatsActionSheet$lambda$3(mutableState, !SeatsActionSheet$lambda$2(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SeatsList(final int i5, final List<FerrySeat> list, final Function1<? super FerrySeat, Unit> function1, Composer composer, final int i6) {
        Composer startRestartGroup = composer.startRestartGroup(1669569751);
        int i7 = (i6 & 6) == 0 ? (startRestartGroup.changed(i5) ? 4 : 2) | i6 : i6;
        if ((i6 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(list) ? 32 : 16;
        }
        if ((i6 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1669569751, i7, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.select.SeatsList (SeatsActionSheet.kt:157)");
            }
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m313paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(24), 1, null), ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, null, false, 14, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(16)), Alignment.INSTANCE.getStart(), startRestartGroup, 6);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, verticalScroll$default);
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
            startRestartGroup.startReplaceGroup(-221251991);
            Iterator<FerrySeat> it = list.iterator();
            while (it.hasNext()) {
                SeatRow(it.next(), function1, startRestartGroup, (i7 >> 3) & 112, 0);
            }
            startRestartGroup.endReplaceGroup();
            int size = i5 - list.size();
            startRestartGroup.startReplaceGroup(-221246636);
            for (int i8 = 0; i8 < size; i8++) {
                SeatRow(null, null, startRestartGroup, 0, 3);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: I2.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SeatsList$lambda$12;
                    SeatsList$lambda$12 = SeatsActionSheetKt.SeatsList$lambda$12(i5, list, function1, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return SeatsList$lambda$12;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SeatsList$lambda$12(int i5, List list, Function1 function1, int i6, Composer composer, int i7) {
        SeatsList(i5, list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
        return Unit.INSTANCE;
    }
}
