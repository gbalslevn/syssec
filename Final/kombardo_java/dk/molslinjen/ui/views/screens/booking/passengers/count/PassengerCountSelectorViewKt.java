package dk.molslinjen.ui.views.screens.booking.passengers.count;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.input.NumberSelectorHeight;
import dk.molslinjen.ui.views.reusable.input.NumberSelectorKt;
import dk.molslinjen.ui.views.reusable.input.PluralText;
import dk.molslinjen.ui.views.reusable.input.SwitchRowKt;
import dk.molslinjen.ui.views.screens.booking.passengers.count.PassengerCountSelectorViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ao\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\r2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"PassengerCountSelectorView", BuildConfig.FLAVOR, "Landroidx/compose/foundation/layout/ColumnScope;", "outboundPassengerCount", BuildConfig.FLAVOR, "returnPassengerCount", "maxPassengers", "bookingType", "Ldk/molslinjen/domain/model/booking/BookingType;", "sameReturnPassengersAsOutbound", BuildConfig.FLAVOR, "lockOutbound", "changeSameReturnPassengersAsOutbound", "Lkotlin/Function1;", "onCountChanged", "Lkotlin/Function2;", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "(Landroidx/compose/foundation/layout/ColumnScope;IIILdk/molslinjen/domain/model/booking/BookingType;ZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PassengerCountSelectorViewKt {
    public static final void PassengerCountSelectorView(final ColumnScope columnScope, final int i5, final int i6, final int i7, final BookingType bookingType, final boolean z5, final boolean z6, final Function1<? super Boolean, Unit> changeSameReturnPassengersAsOutbound, final Function2<? super Integer, ? super DepartureDirection, Unit> onCountChanged, Composer composer, final int i8) {
        int i9;
        BookingType bookingType2;
        int i10;
        Object obj;
        int i11;
        Composer composer2;
        Intrinsics.checkNotNullParameter(columnScope, "<this>");
        Intrinsics.checkNotNullParameter(bookingType, "bookingType");
        Intrinsics.checkNotNullParameter(changeSameReturnPassengersAsOutbound, "changeSameReturnPassengersAsOutbound");
        Intrinsics.checkNotNullParameter(onCountChanged, "onCountChanged");
        Composer startRestartGroup = composer.startRestartGroup(990071209);
        if ((i8 & 6) == 0) {
            i9 = (startRestartGroup.changed(columnScope) ? 4 : 2) | i8;
        } else {
            i9 = i8;
        }
        if ((i8 & 48) == 0) {
            i9 |= startRestartGroup.changed(i5) ? 32 : 16;
        }
        if ((i8 & 384) == 0) {
            i9 |= startRestartGroup.changed(i6) ? 256 : 128;
        }
        if ((i8 & 3072) == 0) {
            i9 |= startRestartGroup.changed(i7) ? 2048 : 1024;
        }
        if ((i8 & 24576) == 0) {
            i9 |= startRestartGroup.changed(bookingType) ? 16384 : 8192;
        }
        if ((196608 & i8) == 0) {
            i9 |= startRestartGroup.changed(z5) ? 131072 : 65536;
        }
        if ((1572864 & i8) == 0) {
            i9 |= startRestartGroup.changed(z6) ? 1048576 : 524288;
        }
        if ((12582912 & i8) == 0) {
            i9 |= startRestartGroup.changedInstance(changeSameReturnPassengersAsOutbound) ? 8388608 : 4194304;
        }
        if ((100663296 & i8) == 0) {
            i9 |= startRestartGroup.changedInstance(onCountChanged) ? 67108864 : 33554432;
        }
        if ((38347923 & i9) == 38347922 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(990071209, i9, -1, "dk.molslinjen.ui.views.screens.booking.passengers.count.PassengerCountSelectorView (PassengerCountSelectorView.kt:31)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 16;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            BookingType bookingType3 = BookingType.TwoWay;
            if (bookingType == bookingType3) {
                startRestartGroup.startReplaceGroup(628431172);
                bookingType2 = bookingType3;
                i10 = 6;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.departures_return_outbound, startRestartGroup, 6), PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmallBold(), startRestartGroup, 48, 1572864, 65532);
                startRestartGroup.endReplaceGroup();
                i11 = 8;
                obj = null;
            } else {
                bookingType2 = bookingType3;
                i10 = 6;
                startRestartGroup.startReplaceGroup(628639647);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(8)), startRestartGroup, 6);
                obj = null;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.passengers_numberOfPassengers, startRestartGroup, 6), PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 48, 1572864, 65532);
                startRestartGroup.endReplaceGroup();
                i11 = 8;
            }
            float f6 = i11;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), startRestartGroup, i10);
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 2, obj);
            PluralText.Resource resource = new PluralText.Resource(R.plurals.passengers);
            NumberSelectorHeight numberSelectorHeight = NumberSelectorHeight.Large;
            boolean z7 = !z6;
            startRestartGroup.startReplaceGroup(851582490);
            int i12 = 234881024 & i9;
            boolean z8 = i12 == 67108864;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: V2.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit PassengerCountSelectorView$lambda$1$lambda$0;
                        PassengerCountSelectorView$lambda$1$lambda$0 = PassengerCountSelectorViewKt.PassengerCountSelectorView$lambda$1$lambda$0(Function2.this, ((Integer) obj2).intValue());
                        return PassengerCountSelectorView$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function1 function1 = (Function1) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(851585658);
            boolean z9 = i12 == 67108864;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z9 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: V2.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit PassengerCountSelectorView$lambda$3$lambda$2;
                        PassengerCountSelectorView$lambda$3$lambda$2 = PassengerCountSelectorViewKt.PassengerCountSelectorView$lambda$3$lambda$2(Function2.this, ((Integer) obj2).intValue());
                        return PassengerCountSelectorView$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function1 function12 = (Function1) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            int i13 = (i9 << 3) & 57344;
            NumberSelectorKt.NumberSelector(m313paddingVpY3zN4$default, i5, 0, 1, i7, resource, null, null, function1, function12, numberSelectorHeight, true, false, z7, false, startRestartGroup, (i9 & 112) | 3078 | i13, 54, 20676);
            startRestartGroup.startReplaceGroup(851590707);
            if (bookingType == bookingType2) {
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                Modifier m313paddingVpY3zN4$default2 = PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 2, null);
                String stringResource = StringResources_androidKt.stringResource(R.string.passengers_count_differentOnReturnThanOutbound, startRestartGroup, 6);
                boolean z10 = !z5;
                startRestartGroup.startReplaceGroup(851600508);
                boolean z11 = (29360128 & i9) == 8388608;
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (z11 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: V2.i
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit PassengerCountSelectorView$lambda$5$lambda$4;
                            PassengerCountSelectorView$lambda$5$lambda$4 = PassengerCountSelectorViewKt.PassengerCountSelectorView$lambda$5$lambda$4(Function1.this, ((Boolean) obj2).booleanValue());
                            return PassengerCountSelectorView$lambda$5$lambda$4;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                SwitchRowKt.SwitchRow(m313paddingVpY3zN4$default2, stringResource, z10, (Function1) rememberedValue3, startRestartGroup, 6, 0);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
                if (!z5) {
                    TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.departures_return_return, startRestartGroup, 6), PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmallBold(), startRestartGroup, 48, 1572864, 65532);
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f6)), startRestartGroup, 6);
                    Modifier m313paddingVpY3zN4$default3 = PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 2, null);
                    PluralText.Resource resource2 = new PluralText.Resource(R.plurals.passengers);
                    startRestartGroup.startReplaceGroup(851627880);
                    boolean z12 = i12 == 67108864;
                    Object rememberedValue4 = startRestartGroup.rememberedValue();
                    if (z12 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = new Function1() { // from class: V2.j
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                Unit PassengerCountSelectorView$lambda$7$lambda$6;
                                PassengerCountSelectorView$lambda$7$lambda$6 = PassengerCountSelectorViewKt.PassengerCountSelectorView$lambda$7$lambda$6(Function2.this, ((Integer) obj2).intValue());
                                return PassengerCountSelectorView$lambda$7$lambda$6;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                    }
                    Function1 function13 = (Function1) rememberedValue4;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(851631752);
                    boolean z13 = i12 == 67108864;
                    Object rememberedValue5 = startRestartGroup.rememberedValue();
                    if (z13 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue5 = new Function1() { // from class: V2.k
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                Unit PassengerCountSelectorView$lambda$9$lambda$8;
                                PassengerCountSelectorView$lambda$9$lambda$8 = PassengerCountSelectorViewKt.PassengerCountSelectorView$lambda$9$lambda$8(Function2.this, ((Integer) obj2).intValue());
                                return PassengerCountSelectorView$lambda$9$lambda$8;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue5);
                    }
                    startRestartGroup.endReplaceGroup();
                    NumberSelectorKt.NumberSelector(m313paddingVpY3zN4$default3, i6, 0, 1, i7, resource2, null, null, function13, (Function1) rememberedValue5, numberSelectorHeight, true, false, false, false, startRestartGroup, ((i9 >> 3) & 112) | 3078 | i13, 54, 28868);
                }
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            SpacerKt.Spacer(ColumnScope.weight$default(columnScope, companion, 1.0f, false, 2, null), composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: V2.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit PassengerCountSelectorView$lambda$10;
                    PassengerCountSelectorView$lambda$10 = PassengerCountSelectorViewKt.PassengerCountSelectorView$lambda$10(ColumnScope.this, i5, i6, i7, bookingType, z5, z6, changeSameReturnPassengersAsOutbound, onCountChanged, i8, (Composer) obj2, ((Integer) obj3).intValue());
                    return PassengerCountSelectorView$lambda$10;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerCountSelectorView$lambda$1$lambda$0(Function2 function2, int i5) {
        function2.invoke(Integer.valueOf(i5), DepartureDirection.Outbound);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerCountSelectorView$lambda$10(ColumnScope columnScope, int i5, int i6, int i7, BookingType bookingType, boolean z5, boolean z6, Function1 function1, Function2 function2, int i8, Composer composer, int i9) {
        PassengerCountSelectorView(columnScope, i5, i6, i7, bookingType, z5, z6, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i8 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerCountSelectorView$lambda$3$lambda$2(Function2 function2, int i5) {
        function2.invoke(Integer.valueOf(i5), DepartureDirection.Outbound);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerCountSelectorView$lambda$5$lambda$4(Function1 function1, boolean z5) {
        function1.invoke(Boolean.valueOf(!z5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerCountSelectorView$lambda$7$lambda$6(Function2 function2, int i5) {
        function2.invoke(Integer.valueOf(i5), DepartureDirection.Return);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerCountSelectorView$lambda$9$lambda$8(Function2 function2, int i5) {
        function2.invoke(Integer.valueOf(i5), DepartureDirection.Return);
        return Unit.INSTANCE;
    }
}
