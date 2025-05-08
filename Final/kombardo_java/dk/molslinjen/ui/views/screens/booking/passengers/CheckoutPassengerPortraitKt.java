package dk.molslinjen.ui.views.screens.booking.passengers;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.extensions.ColorExtensionsKt;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.extensions.domain.AgeGroupExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.InitialsViewKt;
import dk.molslinjen.ui.views.reusable.InitialsViewSize;
import dk.molslinjen.ui.views.screens.booking.passengers.CheckoutPassengerPortraitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001aE\u0010\t\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/domain/model/booking/BookingPassenger;", "passenger", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onToggleSelected", BuildConfig.FLAVOR, "showAgeGroup", "enabled", "selectable", "CheckoutPassengerPortrait", "(Ldk/molslinjen/domain/model/booking/BookingPassenger;Lkotlin/jvm/functions/Function1;ZZZLandroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CheckoutPassengerPortraitKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x03cd  */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v33, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r6v41 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CheckoutPassengerPortrait(final BookingPassenger passenger, final Function1<? super BookingPassenger, Unit> onToggleSelected, final boolean z5, final boolean z6, boolean z7, Composer composer, final int i5, final int i6) {
        int i7;
        boolean z8;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        Object rememberedValue;
        Composer.Companion companion;
        Object rememberedValue2;
        boolean changedInstance;
        Object rememberedValue3;
        boolean z9;
        boolean changedInstance2;
        Object rememberedValue4;
        int currentCompositeKeyHash2;
        Composer m1226constructorimpl2;
        BoxScopeInstance boxScopeInstance;
        int i8;
        Modifier.Companion companion2;
        float f5;
        Composer composer2;
        final boolean z10;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(passenger, "passenger");
        Intrinsics.checkNotNullParameter(onToggleSelected, "onToggleSelected");
        Composer startRestartGroup = composer.startRestartGroup(-913224463);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(passenger) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(onToggleSelected) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i6 & 8) != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changed(z6) ? 2048 : 1024;
        }
        int i9 = i6 & 16;
        if (i9 != 0) {
            i7 |= 24576;
        } else if ((i5 & 24576) == 0) {
            z8 = z7;
            i7 |= startRestartGroup.changed(z8) ? 16384 : 8192;
            if ((i7 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                boolean z11 = i9 == 0 ? true : z8;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-913224463, i7, -1, "dk.molslinjen.ui.views.screens.booking.passengers.CheckoutPassengerPortrait (CheckoutPassengerPortrait.kt:41)");
                }
                Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                Modifier.Companion companion3 = Modifier.INSTANCE;
                float f6 = 5;
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion3, 0.0f, Dp.m2599constructorimpl(8), 0.0f, Dp.m2599constructorimpl(f6), 5, null);
                IntrinsicSize intrinsicSize = IntrinsicSize.Min;
                Modifier width = IntrinsicKt.width(IntrinsicKt.height(m315paddingqDBjuR0$default, intrinsicSize), intrinsicSize);
                Alignment.Companion companion4 = Alignment.INSTANCE;
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, width);
                ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion5.getConstructor();
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
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion5.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion5.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion5.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion5.getSetModifier());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                float f7 = 9;
                Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(companion3, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f7));
                startRestartGroup.startReplaceGroup(488966470);
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: U2.a
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Modifier CheckoutPassengerPortrait$lambda$12$lambda$1$lambda$0;
                            CheckoutPassengerPortrait$lambda$12$lambda$1$lambda$0 = CheckoutPassengerPortraitKt.CheckoutPassengerPortrait$lambda$12$lambda$1$lambda$0((Modifier) obj);
                            return CheckoutPassengerPortrait$lambda$12$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier applyIf = ModifierExtensionsKt.applyIf(m312paddingVpY3zN4, z11, (Function1) rememberedValue);
                boolean z12 = !z11;
                startRestartGroup.startReplaceGroup(488968358);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: U2.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Modifier CheckoutPassengerPortrait$lambda$12$lambda$3$lambda$2;
                            CheckoutPassengerPortrait$lambda$12$lambda$3$lambda$2 = CheckoutPassengerPortraitKt.CheckoutPassengerPortrait$lambda$12$lambda$3$lambda$2((Modifier) obj);
                            return CheckoutPassengerPortrait$lambda$12$lambda$3$lambda$2;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                Modifier applyIf2 = ModifierExtensionsKt.applyIf(applyIf, z12, (Function1) rememberedValue2);
                AppColor appColor = AppColor.INSTANCE;
                Modifier m333sizeVpY3zN4 = SizeKt.m333sizeVpY3zN4(BackgroundKt.m103backgroundbw27NRU(applyIf2, appColor.m3281getWhite0d7_KjU(), ThemeShapesKt.getThemeShapes().getSmall()), Dp.m2599constructorimpl(74), Dp.m2599constructorimpl(104));
                startRestartGroup.startReplaceGroup(488975218);
                int i10 = i7 & 112;
                changedInstance = (i10 != 32) | startRestartGroup.changedInstance(passenger);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changedInstance || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: U2.c
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit CheckoutPassengerPortrait$lambda$12$lambda$5$lambda$4;
                            CheckoutPassengerPortrait$lambda$12$lambda$5$lambda$4 = CheckoutPassengerPortraitKt.CheckoutPassengerPortrait$lambda$12$lambda$5$lambda$4(Function1.this, passenger);
                            return CheckoutPassengerPortrait$lambda$12$lambda$5$lambda$4;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                z9 = z11;
                Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(m333sizeVpY3zN4, z6, null, null, (Function0) rememberedValue3, 6, null);
                startRestartGroup.startReplaceGroup(488977472);
                changedInstance2 = startRestartGroup.changedInstance(passenger);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!changedInstance2 || rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: U2.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit CheckoutPassengerPortrait$lambda$12$lambda$7$lambda$6;
                            CheckoutPassengerPortrait$lambda$12$lambda$7$lambda$6 = CheckoutPassengerPortraitKt.CheckoutPassengerPortrait$lambda$12$lambda$7$lambda$6(BookingPassenger.this, (SemanticsPropertyReceiver) obj);
                            return CheckoutPassengerPortrait$lambda$12$lambda$7$lambda$6;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(m122clickableXHw0xAI$default, (Function1) rememberedValue4);
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion4.getCenterHorizontally(), startRestartGroup, 48);
                ?? r6 = 0;
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics);
                Function0<ComposeUiNode> constructor2 = companion5.getConstructor();
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
                Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion5.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion5.getSetCompositeKeyHash();
                if (!m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion5.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                if (z5) {
                    boxScopeInstance = boxScopeInstance2;
                    i8 = 32;
                    companion2 = companion3;
                    f5 = f7;
                    startRestartGroup.startReplaceGroup(713353703);
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion2, Dp.m2599constructorimpl(12)), startRestartGroup, 6);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(712978386);
                    companion2 = companion3;
                    f5 = f7;
                    i8 = 32;
                    boxScopeInstance = boxScopeInstance2;
                    r6 = 0;
                    TextKt.m940Text4IGK_g(AgeGroupExtensionsKt.name(passenger.getAgeGroup(), context), PaddingKt.m313paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), 0.0f, Dp.m2599constructorimpl(4), 1, null), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubSmallBold(), startRestartGroup, 432, 1572864, 65016);
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup = startRestartGroup;
                }
                Composer composer3 = startRestartGroup;
                InitialsViewKt.m3389InitialsViewgPmlwdY(null, InitialsViewSize.Small, null, null, passenger.getInitials(), true, false, false, composer3, 196656, 205);
                TextKt.m940Text4IGK_g(passenger.fullName(), null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), composer3, 0, 1572864, 65022);
                Modifier weight$default = ColumnScope.weight$default(columnScopeInstance, companion2, 1.0f, false, 2, null);
                composer2 = composer3;
                SpacerKt.Spacer(weight$default, composer2, r6);
                composer2.endNode();
                composer2.startReplaceGroup(489008599);
                if (z9) {
                    if (z6) {
                        composer2.startReplaceGroup(-2020570869);
                        Modifier align = boxScopeInstance.align(PaddingKt.m311padding3ABfNKs(BackgroundKt.m103backgroundbw27NRU(SizeKt.m331size3ABfNKs(companion2, Dp.m2599constructorimpl(18)), appColor.m3253getBrandBlack10d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.m2599constructorimpl(1)), companion4.getTopEnd());
                        composer2.startReplaceGroup(489018514);
                        boolean changedInstance3 = composer2.changedInstance(passenger) | (i10 == i8 ? true : r6);
                        Object rememberedValue5 = composer2.rememberedValue();
                        if (changedInstance3 || rememberedValue5 == companion.getEmpty()) {
                            rememberedValue5 = new Function0() { // from class: U2.e
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit CheckoutPassengerPortrait$lambda$12$lambda$10$lambda$9;
                                    CheckoutPassengerPortrait$lambda$12$lambda$10$lambda$9 = CheckoutPassengerPortraitKt.CheckoutPassengerPortrait$lambda$12$lambda$10$lambda$9(Function1.this, passenger);
                                    return CheckoutPassengerPortrait$lambda$12$lambda$10$lambda$9;
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue5);
                        }
                        composer2.endReplaceGroup();
                        IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_close, composer2, 6), StringResources_androidKt.stringResource(R.string.accessibilityLabel_unselectPassenger, composer2, 6), ClickableKt.m122clickableXHw0xAI$default(align, false, null, null, (Function0) rememberedValue5, 7, null), appColor.m3281getWhite0d7_KjU(), composer2, 3072, 0);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-2019998454);
                        Modifier m103backgroundbw27NRU = BackgroundKt.m103backgroundbw27NRU(SizeKt.fillMaxSize$default(PaddingKt.m312paddingVpY3zN4(companion2, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f5)), 0.0f, 1, null), ColorExtensionsKt.m3249withAlphaDxMtmZc(appColor.m3268getGrey50d7_KjU(), 0.3f), ThemeShapesKt.getThemeShapes().getSmall());
                        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), r6);
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, r6);
                        CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, m103backgroundbw27NRU);
                        Function0<ComposeUiNode> constructor3 = companion5.getConstructor();
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
                        Updater.m1227setimpl(m1226constructorimpl3, maybeCachedBoxMeasurePolicy2, companion5.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion5.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion5.getSetCompositeKeyHash();
                        if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion5.getSetModifier());
                        composer2.endNode();
                        composer2.endReplaceGroup();
                    }
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z10 = z9;
            } else {
                startRestartGroup.skipToGroupEnd();
                z10 = z8;
                composer2 = startRestartGroup;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: U2.f
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit CheckoutPassengerPortrait$lambda$13;
                        CheckoutPassengerPortrait$lambda$13 = CheckoutPassengerPortraitKt.CheckoutPassengerPortrait$lambda$13(BookingPassenger.this, onToggleSelected, z5, z6, z10, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return CheckoutPassengerPortrait$lambda$13;
                    }
                });
                return;
            }
            return;
        }
        z8 = z7;
        if ((i7 & 9363) == 9362) {
        }
        if (i9 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Context context2 = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Modifier.Companion companion32 = Modifier.INSTANCE;
        float f62 = 5;
        Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(companion32, 0.0f, Dp.m2599constructorimpl(8), 0.0f, Dp.m2599constructorimpl(f62), 5, null);
        IntrinsicSize intrinsicSize2 = IntrinsicSize.Min;
        Modifier width2 = IntrinsicKt.width(IntrinsicKt.height(m315paddingqDBjuR0$default2, intrinsicSize2), intrinsicSize2);
        Alignment.Companion companion42 = Alignment.INSTANCE;
        MeasurePolicy maybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(companion42.getTopStart(), false);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, width2);
        ComposeUiNode.Companion companion52 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor4 = companion52.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy3, companion52.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap4, companion52.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion52.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash4);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier4, companion52.getSetModifier());
        BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
        float f72 = 9;
        Modifier m312paddingVpY3zN42 = PaddingKt.m312paddingVpY3zN4(companion32, Dp.m2599constructorimpl(f62), Dp.m2599constructorimpl(f72));
        startRestartGroup.startReplaceGroup(488966470);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier applyIf3 = ModifierExtensionsKt.applyIf(m312paddingVpY3zN42, z11, (Function1) rememberedValue);
        boolean z122 = !z11;
        startRestartGroup.startReplaceGroup(488968358);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        Modifier applyIf22 = ModifierExtensionsKt.applyIf(applyIf3, z122, (Function1) rememberedValue2);
        AppColor appColor2 = AppColor.INSTANCE;
        Modifier m333sizeVpY3zN42 = SizeKt.m333sizeVpY3zN4(BackgroundKt.m103backgroundbw27NRU(applyIf22, appColor2.m3281getWhite0d7_KjU(), ThemeShapesKt.getThemeShapes().getSmall()), Dp.m2599constructorimpl(74), Dp.m2599constructorimpl(104));
        startRestartGroup.startReplaceGroup(488975218);
        int i102 = i7 & 112;
        changedInstance = (i102 != 32) | startRestartGroup.changedInstance(passenger);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue3 = new Function0() { // from class: U2.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit CheckoutPassengerPortrait$lambda$12$lambda$5$lambda$4;
                CheckoutPassengerPortrait$lambda$12$lambda$5$lambda$4 = CheckoutPassengerPortraitKt.CheckoutPassengerPortrait$lambda$12$lambda$5$lambda$4(Function1.this, passenger);
                return CheckoutPassengerPortrait$lambda$12$lambda$5$lambda$4;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceGroup();
        z9 = z11;
        Modifier m122clickableXHw0xAI$default2 = ClickableKt.m122clickableXHw0xAI$default(m333sizeVpY3zN42, z6, null, null, (Function0) rememberedValue3, 6, null);
        startRestartGroup.startReplaceGroup(488977472);
        changedInstance2 = startRestartGroup.changedInstance(passenger);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changedInstance2) {
        }
        rememberedValue4 = new Function1() { // from class: U2.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit CheckoutPassengerPortrait$lambda$12$lambda$7$lambda$6;
                CheckoutPassengerPortrait$lambda$12$lambda$7$lambda$6 = CheckoutPassengerPortraitKt.CheckoutPassengerPortrait$lambda$12$lambda$7$lambda$6(BookingPassenger.this, (SemanticsPropertyReceiver) obj);
                return CheckoutPassengerPortrait$lambda$12$lambda$7$lambda$6;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue4);
        startRestartGroup.endReplaceGroup();
        Modifier clearAndSetSemantics2 = SemanticsModifierKt.clearAndSetSemantics(m122clickableXHw0xAI$default2, (Function1) rememberedValue4);
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion42.getCenterHorizontally(), startRestartGroup, 48);
        ?? r62 = 0;
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics2);
        Function0<ComposeUiNode> constructor22 = companion52.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy2, companion52.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22, companion52.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion52.getSetCompositeKeyHash();
        if (!m1226constructorimpl2.getInserting()) {
        }
        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22, companion52.getSetModifier());
        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
        if (z5) {
        }
        Composer composer32 = startRestartGroup;
        InitialsViewKt.m3389InitialsViewgPmlwdY(null, InitialsViewSize.Small, null, null, passenger.getInitials(), true, false, false, composer32, 196656, 205);
        TextKt.m940Text4IGK_g(passenger.fullName(), null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), composer32, 0, 1572864, 65022);
        Modifier weight$default2 = ColumnScope.weight$default(columnScopeInstance2, companion2, 1.0f, false, 2, null);
        composer2 = composer32;
        SpacerKt.Spacer(weight$default2, composer2, r62);
        composer2.endNode();
        composer2.startReplaceGroup(489008599);
        if (z9) {
        }
        composer2.endReplaceGroup();
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        z10 = z9;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier CheckoutPassengerPortrait$lambda$12$lambda$1$lambda$0(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return ModifierExtensionsKt.defaultShadow$default(applyIf, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutPassengerPortrait$lambda$12$lambda$10$lambda$9(Function1 function1, BookingPassenger bookingPassenger) {
        function1.invoke(bookingPassenger);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier CheckoutPassengerPortrait$lambda$12$lambda$3$lambda$2(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return BorderKt.m108borderxT4_qwU(applyIf, Dp.m2599constructorimpl(1), AppColor.INSTANCE.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getSmall());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutPassengerPortrait$lambda$12$lambda$5$lambda$4(Function1 function1, BookingPassenger bookingPassenger) {
        function1.invoke(bookingPassenger);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutPassengerPortrait$lambda$12$lambda$7$lambda$6(BookingPassenger bookingPassenger, SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, bookingPassenger.fullName());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutPassengerPortrait$lambda$13(BookingPassenger bookingPassenger, Function1 function1, boolean z5, boolean z6, boolean z7, int i5, int i6, Composer composer, int i7) {
        CheckoutPassengerPortrait(bookingPassenger, function1, z5, z6, z7, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
