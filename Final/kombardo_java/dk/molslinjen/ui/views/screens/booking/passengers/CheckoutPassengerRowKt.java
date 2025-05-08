package dk.molslinjen.ui.views.screens.booking.passengers;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.ToggleableKt;
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
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.InitialsViewKt;
import dk.molslinjen.ui.views.reusable.InitialsViewSize;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlStyle;
import dk.molslinjen.ui.views.screens.booking.passengers.CheckoutPassengerRowKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001ag\u0010\r\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/domain/model/booking/BookingPassenger;", "passenger", BuildConfig.FLAVOR, "selected", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onToggleSelected", BuildConfig.FLAVOR, "editPassenger", "Lkotlin/Function0;", "disabledClick", "ageGroup", "enabled", "CheckoutPassengerRow", "(Ldk/molslinjen/domain/model/booking/BookingPassenger;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Ljava/lang/String;ZLandroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CheckoutPassengerRowKt {
    public static final void CheckoutPassengerRow(final BookingPassenger passenger, final boolean z5, final Function1<? super BookingPassenger, Unit> onToggleSelected, final Function1<? super String, Unit> editPassenger, final Function0<Unit> disabledClick, final String str, final boolean z6, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        boolean z7;
        Modifier.Companion companion;
        Intrinsics.checkNotNullParameter(passenger, "passenger");
        Intrinsics.checkNotNullParameter(onToggleSelected, "onToggleSelected");
        Intrinsics.checkNotNullParameter(editPassenger, "editPassenger");
        Intrinsics.checkNotNullParameter(disabledClick, "disabledClick");
        Composer startRestartGroup = composer.startRestartGroup(904560705);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(passenger) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(onToggleSelected) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(editPassenger) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(disabledClick) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(str) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i6 |= startRestartGroup.changed(z6) ? 1048576 : 524288;
        }
        int i7 = i6;
        if ((599187 & i7) == 599186 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(904560705, i7, -1, "dk.molslinjen.ui.views.screens.booking.passengers.CheckoutPassengerRow (CheckoutPassengerRow.kt:40)");
            }
            Modifier.Companion companion2 = Modifier.INSTANCE;
            AppColor appColor = AppColor.INSTANCE;
            Modifier clip = ClipKt.clip(BackgroundKt.m104backgroundbw27NRU$default(companion2, appColor.m3281getWhite0d7_KjU(), null, 2, null), ThemeShapesKt.getThemeShapes().getSmall());
            startRestartGroup.startReplaceGroup(1409512814);
            int i8 = i7 & 896;
            boolean changedInstance = ((3670016 & i7) == 1048576) | (i8 == 256) | startRestartGroup.changedInstance(passenger) | ((i7 & 57344) == 16384);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: U2.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit CheckoutPassengerRow$lambda$1$lambda$0;
                        CheckoutPassengerRow$lambda$1$lambda$0 = CheckoutPassengerRowKt.CheckoutPassengerRow$lambda$1$lambda$0(z6, onToggleSelected, passenger, disabledClick, ((Boolean) obj).booleanValue());
                        return CheckoutPassengerRow$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            float f5 = 16;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(ToggleableKt.m455toggleableXHw0xAI$default(clip, z5, false, null, (Function1) rememberedValue, 6, null), Dp.m2599constructorimpl(f5));
            Alignment.Companion companion3 = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion3.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            boolean z8 = !passenger.isCurrentUser();
            startRestartGroup.startReplaceGroup(465409860);
            boolean changedInstance2 = ((i7 & 7168) == 2048) | startRestartGroup.changedInstance(passenger);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: U2.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CheckoutPassengerRow$lambda$12$lambda$3$lambda$2;
                        CheckoutPassengerRow$lambda$12$lambda$3$lambda$2 = CheckoutPassengerRowKt.CheckoutPassengerRow$lambda$12$lambda$3$lambda$2(Function1.this, passenger);
                        return CheckoutPassengerRow$lambda$12$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m122clickableXHw0xAI$default = ClickableKt.m122clickableXHw0xAI$default(companion2, z8, null, null, (Function0) rememberedValue2, 6, null);
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m122clickableXHw0xAI$default);
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
            Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            InitialsViewKt.m3389InitialsViewgPmlwdY(null, InitialsViewSize.Small, null, null, passenger.getInitials(), false, !passenger.isCurrentUser(), true, startRestartGroup, 12582960, 45);
            startRestartGroup.endNode();
            SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion2, Dp.m2599constructorimpl(12)), startRestartGroup, 6);
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion3.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, weight$default);
            Function0<ComposeUiNode> constructor3 = companion4.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion4.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(passenger.fullName(), null, z6 ? appColor.m3253getBrandBlack10d7_KjU() : appColor.m3266getGrey30d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), composer2, 0, 1572864, 65530);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion3.getTop(), composer2, 0);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, companion2);
            Function0<ComposeUiNode> constructor4 = companion4.getConstructor();
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor4);
            } else {
                composer2.useNode();
            }
            Composer m1226constructorimpl4 = Updater.m1226constructorimpl(composer2);
            Updater.m1227setimpl(m1226constructorimpl4, rowMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion4.getSetModifier());
            composer2.startReplaceGroup(579617344);
            if (str == null) {
                companion = companion2;
                z7 = false;
            } else {
                z7 = false;
                companion = companion2;
                TextKt.m940Text4IGK_g(str, null, z6 ? appColor.m3264getGrey10d7_KjU() : appColor.m3266getGrey30d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, (i7 >> 15) & 14, 1572864, 65530);
                SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer2, 6);
                Unit unit = Unit.INSTANCE;
            }
            composer2.endReplaceGroup();
            TextKt.m940Text4IGK_g(LocalDateTimeExtensionsKt.toFormatWithFullMonth(passenger.getBirthDate()), null, z6 ? appColor.m3264getGrey10d7_KjU() : appColor.m3266getGrey30d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 0, 1572864, 65530);
            composer2.endNode();
            composer2.endNode();
            composer2.startReplaceGroup(465447214);
            if (passenger.isCurrentUser()) {
                float f6 = 8;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.passengers_me, composer2, 6), PaddingKt.m312paddingVpY3zN4(BackgroundKt.m103backgroundbw27NRU(PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f6), 0.0f, 2, null), appColor.m3274getTagBlue0d7_KjU(), ThemeShapesKt.getThemeShapes().getSmall()), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(4)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 0, 1572864, 65532);
            }
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(465462139);
            Object rememberedValue3 = composer2.rememberedValue();
            Composer.Companion companion5 = Composer.INSTANCE;
            if (rememberedValue3 == companion5.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: U2.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit CheckoutPassengerRow$lambda$12$lambda$9$lambda$8;
                        CheckoutPassengerRow$lambda$12$lambda$9$lambda$8 = CheckoutPassengerRowKt.CheckoutPassengerRow$lambda$12$lambda$9$lambda$8((SemanticsPropertyReceiver) obj);
                        return CheckoutPassengerRow$lambda$12$lambda$9$lambda$8;
                    }
                };
                composer2.updateRememberedValue(rememberedValue3);
            }
            composer2.endReplaceGroup();
            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) rememberedValue3);
            SelectionControlStyle selectionControlStyle = SelectionControlStyle.Checkbox;
            composer2.startReplaceGroup(465465083);
            boolean changedInstance3 = (i8 != 256 ? z7 : true) | composer2.changedInstance(passenger);
            Object rememberedValue4 = composer2.rememberedValue();
            if (changedInstance3 || rememberedValue4 == companion5.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: U2.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit CheckoutPassengerRow$lambda$12$lambda$11$lambda$10;
                        CheckoutPassengerRow$lambda$12$lambda$11$lambda$10 = CheckoutPassengerRowKt.CheckoutPassengerRow$lambda$12$lambda$11$lambda$10(Function1.this, passenger, ((Boolean) obj).booleanValue());
                        return CheckoutPassengerRow$lambda$12$lambda$11$lambda$10;
                    }
                };
                composer2.updateRememberedValue(rememberedValue4);
            }
            composer2.endReplaceGroup();
            SelectionControlKt.SelectionControl(clearAndSetSemantics, z5, (Function1) rememberedValue4, disabledClick, z6, null, selectionControlStyle, false, composer2, (i7 & 112) | 1572864 | ((i7 >> 3) & 7168) | ((i7 >> 6) & 57344), 160);
            composer2.endNode();
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer2, 0, 15);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: U2.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CheckoutPassengerRow$lambda$13;
                    CheckoutPassengerRow$lambda$13 = CheckoutPassengerRowKt.CheckoutPassengerRow$lambda$13(BookingPassenger.this, z5, onToggleSelected, editPassenger, disabledClick, str, z6, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CheckoutPassengerRow$lambda$13;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutPassengerRow$lambda$1$lambda$0(boolean z5, Function1 function1, BookingPassenger bookingPassenger, Function0 function0, boolean z6) {
        if (z5) {
            function1.invoke(bookingPassenger);
        } else {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutPassengerRow$lambda$12$lambda$11$lambda$10(Function1 function1, BookingPassenger bookingPassenger, boolean z5) {
        function1.invoke(bookingPassenger);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutPassengerRow$lambda$12$lambda$3$lambda$2(Function1 function1, BookingPassenger bookingPassenger) {
        function1.invoke(bookingPassenger.getLocalId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutPassengerRow$lambda$12$lambda$9$lambda$8(SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, BuildConfig.FLAVOR);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutPassengerRow$lambda$13(BookingPassenger bookingPassenger, boolean z5, Function1 function1, Function1 function12, Function0 function0, String str, boolean z6, int i5, Composer composer, int i6) {
        CheckoutPassengerRow(bookingPassenger, z5, function1, function12, function0, str, z6, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
