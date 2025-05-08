package dk.molslinjen.ui.views.screens.booking.departures.selectPassengers;

import android.content.Context;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.input.SwitchRowKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorScreenKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorViewModel;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a«\u0001\u0010\u001c\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u00142\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u00142\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u00142\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u001aH\u0003¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/selectPassengers/PassengerCountSelectorViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "PassengerCountSelectorScreen", "(Ldk/molslinjen/ui/views/screens/booking/departures/selectPassengers/PassengerCountSelectorViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/booking/departures/selectPassengers/PassengerCountSelectorViewModel$ViewState;", "viewState", "Ldk/molslinjen/ui/views/screens/booking/departures/selectPassengers/PassengerCountSelectorViewModel$PassengerSelectionState;", "outboundState", "returnState", "Ldk/molslinjen/ui/views/screens/booking/departures/selectPassengers/PassengerCountFormField;", "validationKey", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;", "validator", "Landroidx/compose/foundation/ScrollState;", "scrollState", BuildConfig.FLAVOR, "lockOutbound", "Lkotlin/Function2;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "onAdultsChange", "onChildrenChange", "onInfantsChange", "Lkotlin/Function1;", "onChangedSamePassengerForBothDirections", "PassengerCountSelectorContent", "(Ldk/molslinjen/ui/views/screens/booking/departures/selectPassengers/PassengerCountSelectorViewModel$ViewState;Ldk/molslinjen/ui/views/screens/booking/departures/selectPassengers/PassengerCountSelectorViewModel$PassengerSelectionState;Ldk/molslinjen/ui/views/screens/booking/departures/selectPassengers/PassengerCountSelectorViewModel$PassengerSelectionState;Ldk/molslinjen/ui/views/screens/booking/departures/selectPassengers/PassengerCountFormField;Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator;Landroidx/compose/foundation/ScrollState;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PassengerCountSelectorScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void PassengerCountSelectorContent(final PassengerCountSelectorViewModel.ViewState viewState, final PassengerCountSelectorViewModel.PassengerSelectionState passengerSelectionState, final PassengerCountSelectorViewModel.PassengerSelectionState passengerSelectionState2, final PassengerCountFormField passengerCountFormField, final IFormValidator iFormValidator, final ScrollState scrollState, final boolean z5, final Function2<? super Integer, ? super DepartureDirection, Unit> function2, final Function2<? super Integer, ? super DepartureDirection, Unit> function22, final Function2<? super Integer, ? super DepartureDirection, Unit> function23, final Function1<? super Boolean, Unit> function1, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        BookingType bookingType;
        int i9;
        boolean z6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1748023006);
        if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(passengerSelectionState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(passengerSelectionState2) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changed(passengerCountFormField) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i7 |= (32768 & i5) == 0 ? startRestartGroup.changed(iFormValidator) : startRestartGroup.changedInstance(iFormValidator) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i7 |= startRestartGroup.changed(scrollState) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i7 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ((i5 & 100663296) == 0) {
            i7 |= startRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i7 |= startRestartGroup.changedInstance(function23) ? 536870912 : 268435456;
        }
        if ((i6 & 6) == 0) {
            i8 = i6 | (startRestartGroup.changedInstance(function1) ? 4 : 2);
        } else {
            i8 = i6;
        }
        if ((i7 & 306783379) == 306783378 && (i8 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1748023006, i7, i8, "dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorContent (PassengerCountSelectorScreen.kt:121)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 24;
            int i10 = i7;
            Modifier verticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 2, null), scrollState, false, null, false, 14, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, verticalScroll$default);
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
            startRestartGroup.startReplaceGroup(1999747339);
            BookingType bookingType2 = viewState.getBookingType();
            BookingType bookingType3 = BookingType.TwoWay;
            if (bookingType2 == bookingType3) {
                i9 = i10;
                bookingType = bookingType3;
                SwitchRowKt.SwitchRow(null, StringResources_androidKt.stringResource(R.string.passengers_sameCountOutAndReturn, startRestartGroup, 6), viewState.getSamePassengersForBothDirections(), function1, startRestartGroup, (i8 << 9) & 7168, 1);
                z6 = false;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(viewState.getSamePassengersForBothDirections() ? R.string.departures_return_outAndReturn : R.string.departures_return_outbound, startRestartGroup, 0), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(16), 5, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), startRestartGroup, 48, 1572864, 65532);
            } else {
                bookingType = bookingType3;
                i9 = i10;
                z6 = false;
            }
            startRestartGroup.endReplaceGroup();
            boolean z7 = !z5;
            startRestartGroup.startReplaceGroup(1999779955);
            int i11 = i9 & 29360128;
            boolean z8 = i11 == 8388608 ? true : z6;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: O2.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PassengerCountSelectorContent$lambda$15$lambda$4$lambda$3;
                        PassengerCountSelectorContent$lambda$15$lambda$4$lambda$3 = PassengerCountSelectorScreenKt.PassengerCountSelectorContent$lambda$15$lambda$4$lambda$3(Function2.this, ((Integer) obj).intValue());
                        return PassengerCountSelectorContent$lambda$15$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function1 function12 = (Function1) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1999782645);
            int i12 = i9 & 234881024;
            boolean z9 = i12 == 67108864 ? true : z6;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z9 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: O2.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PassengerCountSelectorContent$lambda$15$lambda$6$lambda$5;
                        PassengerCountSelectorContent$lambda$15$lambda$6$lambda$5 = PassengerCountSelectorScreenKt.PassengerCountSelectorContent$lambda$15$lambda$6$lambda$5(Function2.this, ((Integer) obj).intValue());
                        return PassengerCountSelectorContent$lambda$15$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function1 function13 = (Function1) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(1999785364);
            int i13 = i9 & 1879048192;
            boolean z10 = i13 == 536870912 ? true : z6;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z10 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: O2.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PassengerCountSelectorContent$lambda$15$lambda$8$lambda$7;
                        PassengerCountSelectorContent$lambda$15$lambda$8$lambda$7 = PassengerCountSelectorScreenKt.PassengerCountSelectorContent$lambda$15$lambda$8$lambda$7(Function2.this, ((Integer) obj).intValue());
                        return PassengerCountSelectorContent$lambda$15$lambda$8$lambda$7;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            int i14 = i9 & 14;
            int i15 = i9 >> 3;
            int i16 = i15 & 896;
            int i17 = i15 & 7168;
            WalkingPassengerSelectionViewKt.WalkingPassengerSelectionView(viewState, passengerSelectionState, passengerCountFormField, iFormValidator, z7, function12, function13, (Function1) rememberedValue3, startRestartGroup, (i9 & 126) | i16 | i17, 0);
            startRestartGroup.startReplaceGroup(1999788420);
            if (viewState.getSamePassengersForBothDirections() || passengerSelectionState2 == null || viewState.getBookingType() != bookingType) {
                composer2 = startRestartGroup;
            } else {
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.departures_return_return, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(8), 0.0f, Dp.m2599constructorimpl(16), 5, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), startRestartGroup, 48, 1572864, 65532);
                startRestartGroup.startReplaceGroup(1999806481);
                boolean z11 = i11 == 8388608;
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (z11 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = new Function1() { // from class: O2.f
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit PassengerCountSelectorContent$lambda$15$lambda$10$lambda$9;
                            PassengerCountSelectorContent$lambda$15$lambda$10$lambda$9 = PassengerCountSelectorScreenKt.PassengerCountSelectorContent$lambda$15$lambda$10$lambda$9(Function2.this, ((Integer) obj).intValue());
                            return PassengerCountSelectorContent$lambda$15$lambda$10$lambda$9;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                Function1 function14 = (Function1) rememberedValue4;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1999809235);
                boolean z12 = i12 == 67108864;
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (z12 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue5 = new Function1() { // from class: O2.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit PassengerCountSelectorContent$lambda$15$lambda$12$lambda$11;
                            PassengerCountSelectorContent$lambda$15$lambda$12$lambda$11 = PassengerCountSelectorScreenKt.PassengerCountSelectorContent$lambda$15$lambda$12$lambda$11(Function2.this, ((Integer) obj).intValue());
                            return PassengerCountSelectorContent$lambda$15$lambda$12$lambda$11;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                Function1 function15 = (Function1) rememberedValue5;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(1999812018);
                boolean z13 = i13 == 536870912;
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (z13 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue6 = new Function1() { // from class: O2.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit PassengerCountSelectorContent$lambda$15$lambda$14$lambda$13;
                            PassengerCountSelectorContent$lambda$15$lambda$14$lambda$13 = PassengerCountSelectorScreenKt.PassengerCountSelectorContent$lambda$15$lambda$14$lambda$13(Function2.this, ((Integer) obj).intValue());
                            return PassengerCountSelectorContent$lambda$15$lambda$14$lambda$13;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                startRestartGroup.endReplaceGroup();
                composer2 = startRestartGroup;
                WalkingPassengerSelectionViewKt.WalkingPassengerSelectionView(viewState, passengerSelectionState2, passengerCountFormField, iFormValidator, false, function14, function15, (Function1) rememberedValue6, startRestartGroup, i14 | (i15 & 112) | i16 | i17, 16);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: O2.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PassengerCountSelectorContent$lambda$16;
                    PassengerCountSelectorContent$lambda$16 = PassengerCountSelectorScreenKt.PassengerCountSelectorContent$lambda$16(PassengerCountSelectorViewModel.ViewState.this, passengerSelectionState, passengerSelectionState2, passengerCountFormField, iFormValidator, scrollState, z5, function2, function22, function23, function1, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return PassengerCountSelectorContent$lambda$16;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerCountSelectorContent$lambda$15$lambda$10$lambda$9(Function2 function2, int i5) {
        function2.invoke(Integer.valueOf(i5), DepartureDirection.Return);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerCountSelectorContent$lambda$15$lambda$12$lambda$11(Function2 function2, int i5) {
        function2.invoke(Integer.valueOf(i5), DepartureDirection.Return);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerCountSelectorContent$lambda$15$lambda$14$lambda$13(Function2 function2, int i5) {
        function2.invoke(Integer.valueOf(i5), DepartureDirection.Return);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerCountSelectorContent$lambda$15$lambda$4$lambda$3(Function2 function2, int i5) {
        function2.invoke(Integer.valueOf(i5), DepartureDirection.Outbound);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerCountSelectorContent$lambda$15$lambda$6$lambda$5(Function2 function2, int i5) {
        function2.invoke(Integer.valueOf(i5), DepartureDirection.Outbound);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerCountSelectorContent$lambda$15$lambda$8$lambda$7(Function2 function2, int i5) {
        function2.invoke(Integer.valueOf(i5), DepartureDirection.Outbound);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerCountSelectorContent$lambda$16(PassengerCountSelectorViewModel.ViewState viewState, PassengerCountSelectorViewModel.PassengerSelectionState passengerSelectionState, PassengerCountSelectorViewModel.PassengerSelectionState passengerSelectionState2, PassengerCountFormField passengerCountFormField, IFormValidator iFormValidator, ScrollState scrollState, boolean z5, Function2 function2, Function2 function22, Function2 function23, Function1 function1, int i5, int i6, Composer composer, int i7) {
        PassengerCountSelectorContent(viewState, passengerSelectionState, passengerSelectionState2, passengerCountFormField, iFormValidator, scrollState, z5, function2, function22, function23, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
        return Unit.INSTANCE;
    }

    public static final void PassengerCountSelectorScreen(final PassengerCountSelectorViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-1447998548);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1447998548, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorScreen (PassengerCountSelectorScreen.kt:40)");
            }
            Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            final PassengerCountSelectorViewModel.ViewState viewState = (PassengerCountSelectorViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            final PassengerCountSelectorViewModel.PassengerSelectionState passengerSelectionState = (PassengerCountSelectorViewModel.PassengerSelectionState) SnapshotStateKt.collectAsState(viewModel.getOutboundPassengerState(), null, startRestartGroup, 0, 1).getValue();
            final PassengerCountSelectorViewModel.PassengerSelectionState passengerSelectionState2 = (PassengerCountSelectorViewModel.PassengerSelectionState) SnapshotStateKt.collectAsState(viewModel.getReturnPassengerState(), null, startRestartGroup, 0, 1).getValue();
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.startReplaceGroup(-1615926584);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new FormValidator(MapsKt.mapOf(TuplesKt.to(PassengerCountFormField.PassengerCountFields, PassengerCountValidator.INSTANCE)), coroutineScope);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            final FormValidator formValidator = (FormValidator) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            boolean booleanValue = ((Boolean) SnapshotStateKt.collectAsState(formValidator.isFormValid(), null, startRestartGroup, 0, 1).getValue()).booleanValue();
            final ScrollState rememberScrollState = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
            Modifier closeKeyboardOnClickOutside = ModifierExtensionsKt.closeKeyboardOnClickOutside(Modifier.INSTANCE, (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager()));
            String stringResource = StringResources_androidKt.stringResource(R.string.passengers_headline, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-1615911429);
            boolean z5 = (i6 & 112) == 32;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new PassengerCountSelectorScreenKt$PassengerCountSelectorScreen$1$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(closeKeyboardOnClickOutside, 0.0f, stringResource, null, 0L, null, (Function0) rememberedValue3, rememberScrollState, ComposableLambdaKt.rememberComposableLambda(484629038, true, new PassengerCountSelectorScreenKt$PassengerCountSelectorScreen$2(booleanValue, formValidator, context, viewModel, navigator), startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(975895935, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorScreenKt$PassengerCountSelectorScreen$3

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                /* renamed from: dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorScreenKt$PassengerCountSelectorScreen$3$1, reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
                    final /* synthetic */ PassengerCountSelectorViewModel.PassengerSelectionState $outboundState;
                    final /* synthetic */ PassengerCountSelectorViewModel.PassengerSelectionState $returnState;
                    final /* synthetic */ ScrollState $scrollState;
                    final /* synthetic */ PassengerCountFormField $validationKey;
                    final /* synthetic */ FormValidator $validator;
                    final /* synthetic */ PassengerCountSelectorViewModel $viewModel;
                    final /* synthetic */ PassengerCountSelectorViewModel.ViewState $viewState;

                    AnonymousClass1(PassengerCountSelectorViewModel.ViewState viewState, PassengerCountSelectorViewModel.PassengerSelectionState passengerSelectionState, PassengerCountSelectorViewModel.PassengerSelectionState passengerSelectionState2, PassengerCountFormField passengerCountFormField, FormValidator formValidator, ScrollState scrollState, PassengerCountSelectorViewModel passengerCountSelectorViewModel) {
                        this.$viewState = viewState;
                        this.$outboundState = passengerSelectionState;
                        this.$returnState = passengerSelectionState2;
                        this.$validationKey = passengerCountFormField;
                        this.$validator = formValidator;
                        this.$scrollState = scrollState;
                        this.$viewModel = passengerCountSelectorViewModel;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$1$lambda$0(FormValidator formValidator, PassengerCountFormField passengerCountFormField, PassengerCountSelectorViewModel passengerCountSelectorViewModel, int i5, DepartureDirection scope) {
                        Intrinsics.checkNotNullParameter(scope, "scope");
                        formValidator.submit(passengerCountFormField);
                        passengerCountSelectorViewModel.onAdultsChange(i5, scope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$3$lambda$2(FormValidator formValidator, PassengerCountFormField passengerCountFormField, PassengerCountSelectorViewModel passengerCountSelectorViewModel, int i5, DepartureDirection scope) {
                        Intrinsics.checkNotNullParameter(scope, "scope");
                        formValidator.submit(passengerCountFormField);
                        passengerCountSelectorViewModel.onChildrenChange(i5, scope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$5$lambda$4(FormValidator formValidator, PassengerCountFormField passengerCountFormField, PassengerCountSelectorViewModel passengerCountSelectorViewModel, int i5, DepartureDirection scope) {
                        Intrinsics.checkNotNullParameter(scope, "scope");
                        formValidator.submit(passengerCountFormField);
                        passengerCountSelectorViewModel.onInfantsChange(i5, scope);
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i5) {
                        if ((i5 & 3) == 2 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1762950477, i5, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorScreen.<anonymous>.<anonymous> (PassengerCountSelectorScreen.kt:80)");
                        }
                        PassengerCountSelectorViewModel.ViewState viewState = this.$viewState;
                        if (viewState != null) {
                            PassengerCountSelectorViewModel.PassengerSelectionState passengerSelectionState = this.$outboundState;
                            PassengerCountSelectorViewModel.PassengerSelectionState passengerSelectionState2 = this.$returnState;
                            PassengerCountFormField passengerCountFormField = this.$validationKey;
                            FormValidator formValidator = this.$validator;
                            ScrollState scrollState = this.$scrollState;
                            boolean isAddingReturnFromBookingSummary = viewState.getIsAddingReturnFromBookingSummary();
                            composer.startReplaceGroup(65229056);
                            boolean changedInstance = composer.changedInstance(this.$validator) | composer.changedInstance(this.$viewModel);
                            final FormValidator formValidator2 = this.$validator;
                            final PassengerCountFormField passengerCountFormField2 = this.$validationKey;
                            final PassengerCountSelectorViewModel passengerCountSelectorViewModel = this.$viewModel;
                            Object rememberedValue = composer.rememberedValue();
                            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0061: CONSTRUCTOR (r13v1 'rememberedValue' java.lang.Object) = 
                                      (r9v2 'formValidator2' dk.molslinjen.ui.views.reusable.input.validation.FormValidator A[DONT_INLINE])
                                      (r10v0 'passengerCountFormField2' dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountFormField A[DONT_INLINE])
                                      (r11v0 'passengerCountSelectorViewModel' dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorViewModel A[DONT_INLINE])
                                     A[MD:(dk.molslinjen.ui.views.reusable.input.validation.FormValidator, dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountFormField, dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorViewModel):void (m)] (LINE:14) call: dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.c.<init>(dk.molslinjen.ui.views.reusable.input.validation.FormValidator, dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountFormField, dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorViewModel):void type: CONSTRUCTOR in method: dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorScreenKt$PassengerCountSelectorScreen$3.1.invoke(androidx.compose.runtime.Composer, int):void, file: classes2.dex
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
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.c, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                    	... 31 more
                                    */
                                /*
                                    Method dump skipped, instructions count: 275
                                    To view this dump add '--comments-level debug' option
                                */
                                throw new UnsupportedOperationException("Method not decompiled: dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorScreenKt$PassengerCountSelectorScreen$3.AnonymousClass1.invoke(androidx.compose.runtime.Composer, int):void");
                            }
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                            invoke(columnScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ColumnScope BottomSheetContainer, Composer composer3, int i7) {
                            Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                            if ((i7 & 17) == 16 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(975895935, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorScreen.<anonymous> (PassengerCountSelectorScreen.kt:77)");
                            }
                            PassengerCountFormField passengerCountFormField = PassengerCountFormField.PassengerCountFields;
                            PassengerCountSelectorViewModel.ViewState viewState2 = PassengerCountSelectorViewModel.ViewState.this;
                            LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, viewState2 == null, 0, false, null, ComposableLambdaKt.rememberComposableLambda(-1762950477, true, new AnonymousClass1(viewState2, passengerSelectionState, passengerSelectionState2, passengerCountFormField, formValidator, rememberScrollState, viewModel), composer3, 54), composer3, 1572864, 59);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), composer2, 905969664, 58);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: O2.b
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit PassengerCountSelectorScreen$lambda$2;
                            PassengerCountSelectorScreen$lambda$2 = PassengerCountSelectorScreenKt.PassengerCountSelectorScreen$lambda$2(PassengerCountSelectorViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return PassengerCountSelectorScreen$lambda$2;
                        }
                    });
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit PassengerCountSelectorScreen$lambda$2(PassengerCountSelectorViewModel passengerCountSelectorViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
                PassengerCountSelectorScreen(passengerCountSelectorViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                return Unit.INSTANCE;
            }
        }
