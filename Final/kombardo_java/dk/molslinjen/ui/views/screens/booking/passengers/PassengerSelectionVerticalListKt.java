package dk.molslinjen.ui.views.screens.booking.passengers;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper;
import dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState;
import dk.molslinjen.domain.model.booking.AgeGroup;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.extensions.domain.AgeGroupExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001ak\u0010\u0010\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\u0004\b\u0010\u0010\u0011\u001a'\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListScope;", "Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;", "passengerState", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/booking/BookingPassenger;", BuildConfig.FLAVOR, "toggleSelected", "Ldk/molslinjen/domain/managers/checkout/passengers/ISharedPassengerSelectionViewState;", "state", BuildConfig.FLAVOR, "titleOverSelection", "Landroid/content/Context;", "context", "editPassenger", "Lkotlin/Function0;", "showAgeGroupError", "passengerSelectionVerticalList", "(Landroidx/compose/foundation/lazy/LazyListScope;Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;Lkotlin/jvm/functions/Function1;Ldk/molslinjen/domain/managers/checkout/passengers/ISharedPassengerSelectionViewState;Ljava/lang/String;Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "Ldk/molslinjen/domain/model/booking/AgeGroup;", "ageGroup", BuildConfig.FLAVOR, "showAgeGroup", "isAgeGroupEnabled", "(Ldk/molslinjen/domain/model/booking/AgeGroup;Ldk/molslinjen/domain/managers/checkout/passengers/ISharedPassengerSelectionViewState;Z)Z", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PassengerSelectionVerticalListKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AgeGroup.values().length];
            try {
                iArr[AgeGroup.Infant.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AgeGroup.Child.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AgeGroup.Adult.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isAgeGroupEnabled(AgeGroup ageGroup, ISharedPassengerSelectionViewState iSharedPassengerSelectionViewState, boolean z5) {
        if (!z5) {
            return iSharedPassengerSelectionViewState.getRemainingPassengerCount() > 0;
        }
        int i5 = WhenMappings.$EnumSwitchMapping$0[ageGroup.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (iSharedPassengerSelectionViewState.getRemainingAdultCount() <= 0) {
                    return false;
                }
            } else if (iSharedPassengerSelectionViewState.getRemainingChildCount() <= 0) {
                return false;
            }
        } else if (iSharedPassengerSelectionViewState.getRemainingInfantCount() <= 0) {
            return false;
        }
        return true;
    }

    public static final void passengerSelectionVerticalList(LazyListScope lazyListScope, PassengerSelectionHelper.PassengerState passengerState, final Function1<? super BookingPassenger, Unit> toggleSelected, final ISharedPassengerSelectionViewState state, final String str, final Context context, final Function1<? super String, Unit> editPassenger, final Function0<Unit> showAgeGroupError) {
        boolean z5;
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(passengerState, "passengerState");
        Intrinsics.checkNotNullParameter(toggleSelected, "toggleSelected");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(editPassenger, "editPassenger");
        Intrinsics.checkNotNullParameter(showAgeGroupError, "showAgeGroupError");
        if (str != null) {
            LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(1543372776, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.PassengerSelectionVerticalListKt$passengerSelectionVerticalList$1
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
                        ComposerKt.traceEventStart(1543372776, i5, -1, "dk.molslinjen.ui.views.screens.booking.passengers.passengerSelectionVerticalList.<anonymous> (PassengerSelectionVerticalList.kt:28)");
                    }
                    TextKt.m940Text4IGK_g(str, PaddingKt.m313paddingVpY3zN4$default(PaddingKt.m315paddingqDBjuR0$default(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null), 0.0f, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 13, null), Dp.m2599constructorimpl(16), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer, 48, 1572864, 65532);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
        }
        BookingPassenger currentUser = passengerState.getCurrentUser();
        if (currentUser != null) {
            z5 = true;
            LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(1909430749, true, new PassengerSelectionVerticalListKt$passengerSelectionVerticalList$2$1(passengerState, state, currentUser, context, toggleSelected, editPassenger, showAgeGroupError)), 3, null);
        } else {
            z5 = true;
        }
        final List<BookingPassenger> selectedPassengers = passengerState.getSelectedPassengers();
        final PassengerSelectionVerticalListKt$passengerSelectionVerticalList$$inlined$items$default$1 passengerSelectionVerticalListKt$passengerSelectionVerticalList$$inlined$items$default$1 = new Function1() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.PassengerSelectionVerticalListKt$passengerSelectionVerticalList$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(BookingPassenger bookingPassenger) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((BookingPassenger) obj);
            }
        };
        lazyListScope.items(selectedPassengers.size(), null, new Function1<Integer, Object>() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.PassengerSelectionVerticalListKt$passengerSelectionVerticalList$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i5) {
                return Function1.this.invoke(selectedPassengers.get(i5));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, z5, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.PassengerSelectionVerticalListKt$passengerSelectionVerticalList$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i5, Composer composer, int i6) {
                int i7;
                if ((i6 & 6) == 0) {
                    i7 = (composer.changed(lazyItemScope) ? 4 : 2) | i6;
                } else {
                    i7 = i6;
                }
                if ((i6 & 48) == 0) {
                    i7 |= composer.changed(i5) ? 32 : 16;
                }
                if ((i7 & 147) == 146 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, i7, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                }
                BookingPassenger bookingPassenger = (BookingPassenger) selectedPassengers.get(i5);
                composer.startReplaceGroup(-211402713);
                String name = state.getShowAgeGroup() ? AgeGroupExtensionsKt.name(bookingPassenger.getAgeGroup(), context) : null;
                Function1 function1 = toggleSelected;
                Function1 function12 = editPassenger;
                composer.startReplaceGroup(-1669377425);
                boolean changedInstance = composer.changedInstance(state) | composer.changed(showAgeGroupError);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final ISharedPassengerSelectionViewState iSharedPassengerSelectionViewState = state;
                    final Function0 function0 = showAgeGroupError;
                    rememberedValue = new Function0<Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.PassengerSelectionVerticalListKt$passengerSelectionVerticalList$3$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            if (ISharedPassengerSelectionViewState.this.getShowAgeGroup()) {
                                function0.invoke();
                            }
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                CheckoutPassengerRowKt.CheckoutPassengerRow(bookingPassenger, true, function1, function12, (Function0) rememberedValue, name, true, composer, 1572912);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        final List minus = CollectionsKt.minus((Iterable) passengerState.getPassengers(), (Iterable) CollectionsKt.toSet(passengerState.getSelectedPassengers()));
        final PassengerSelectionVerticalListKt$passengerSelectionVerticalList$$inlined$items$default$5 passengerSelectionVerticalListKt$passengerSelectionVerticalList$$inlined$items$default$5 = new Function1() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.PassengerSelectionVerticalListKt$passengerSelectionVerticalList$$inlined$items$default$5
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(BookingPassenger bookingPassenger) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((BookingPassenger) obj);
            }
        };
        lazyListScope.items(minus.size(), null, new Function1<Integer, Object>() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.PassengerSelectionVerticalListKt$passengerSelectionVerticalList$$inlined$items$default$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i5) {
                return Function1.this.invoke(minus.get(i5));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, z5, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.PassengerSelectionVerticalListKt$passengerSelectionVerticalList$$inlined$items$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i5, Composer composer, int i6) {
                int i7;
                boolean isAgeGroupEnabled;
                if ((i6 & 6) == 0) {
                    i7 = (composer.changed(lazyItemScope) ? 4 : 2) | i6;
                } else {
                    i7 = i6;
                }
                if ((i6 & 48) == 0) {
                    i7 |= composer.changed(i5) ? 32 : 16;
                }
                if ((i7 & 147) == 146 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-632812321, i7, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                }
                BookingPassenger bookingPassenger = (BookingPassenger) minus.get(i5);
                composer.startReplaceGroup(-210899800);
                String name = state.getShowAgeGroup() ? AgeGroupExtensionsKt.name(bookingPassenger.getAgeGroup(), context) : null;
                AgeGroup ageGroup = bookingPassenger.getAgeGroup();
                ISharedPassengerSelectionViewState iSharedPassengerSelectionViewState = state;
                isAgeGroupEnabled = PassengerSelectionVerticalListKt.isAgeGroupEnabled(ageGroup, iSharedPassengerSelectionViewState, iSharedPassengerSelectionViewState.getShowAgeGroup());
                Function1 function1 = toggleSelected;
                Function1 function12 = editPassenger;
                composer.startReplaceGroup(-1669358257);
                boolean changedInstance = composer.changedInstance(state) | composer.changed(showAgeGroupError);
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    final ISharedPassengerSelectionViewState iSharedPassengerSelectionViewState2 = state;
                    final Function0 function0 = showAgeGroupError;
                    rememberedValue = new Function0<Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.PassengerSelectionVerticalListKt$passengerSelectionVerticalList$4$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            if (ISharedPassengerSelectionViewState.this.getShowAgeGroup()) {
                                function0.invoke();
                            }
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                CheckoutPassengerRowKt.CheckoutPassengerRow(bookingPassenger, false, function1, function12, (Function0) rememberedValue, name, isAgeGroupEnabled, composer, 48);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }
}
