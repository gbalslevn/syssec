package dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.extensions.domain.PassengerInfoExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.buttons.OutlineDashedButtonKt;
import dk.molslinjen.ui.views.reusable.input.validation.FormValidator;
import dk.molslinjen.ui.views.screens.booking.passengers.PassengerFormField;
import dk.molslinjen.ui.views.screens.booking.passengers.PassengerSelectionVerticalListKt;
import dk.molslinjen.ui.views.screens.booking.passengers.PassengerValidator;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.EarlyCheckInPassengerSelectorScreenKt;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.EarlyCheckInPassengerSelectorViewModel;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001ac\u0010\u0013\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u000bH\u0003¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/passengerSelector/EarlyCheckInPassengerSelectorViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "EarlyCheckInPassengerSelectorScreen", "(Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/passengerSelector/EarlyCheckInPassengerSelectorViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/passengerSelector/EarlyCheckInPassengerSelectorViewModel$ViewState;", "state", "Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;", "passengerState", "Lkotlin/Function1;", BuildConfig.FLAVOR, "editPassenger", "Lkotlin/Function0;", "createPassenger", "showAgeGroupError", "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "toggleSelected", "PassengerSelectorContent", "(Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/passengerSelector/EarlyCheckInPassengerSelectorViewModel$ViewState;Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class EarlyCheckInPassengerSelectorScreenKt {
    public static final void EarlyCheckInPassengerSelectorScreen(final EarlyCheckInPassengerSelectorViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-620127226);
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
                ComposerKt.traceEventStart(-620127226, i6, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.EarlyCheckInPassengerSelectorScreen (EarlyCheckInPassengerSelectorScreen.kt:45)");
            }
            EarlyCheckInPassengerSelectorViewModel.ViewState viewState = (EarlyCheckInPassengerSelectorViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            PassengerSelectionHelper.PassengerState passengerState = (PassengerSelectionHelper.PassengerState) SnapshotStateKt.collectAsState(viewModel.getPassengerState(), null, startRestartGroup, 0, 1).getValue();
            Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            PassengerFormField passengerFormField = PassengerFormField.PassengerFields;
            startRestartGroup.startReplaceGroup(751803630);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new FormValidator(MapsKt.mapOf(TuplesKt.to(passengerFormField, PassengerValidator.INSTANCE)), coroutineScope);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            FormValidator formValidator = (FormValidator) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            boolean booleanValue = ((Boolean) SnapshotStateKt.collectAsState(formValidator.isFormValid(), null, startRestartGroup, 0, 1).getValue()).booleanValue();
            formValidator.set(passengerFormField, PassengerValidator.INSTANCE.validateInput(viewState.getRemainingAdultCount(), viewState.getRemainingChildCount(), viewState.getRemainingInfantCount(), viewState.getRemainingPassengerCount(), viewState.getShowAgeGroup(), viewState.getPassengerCount(), context));
            startRestartGroup.startReplaceGroup(751826329);
            boolean changedInstance = startRestartGroup.changedInstance(formValidator);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new EarlyCheckInPassengerSelectorScreenKt$EarlyCheckInPassengerSelectorScreen$1$1(formValidator, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(passengerState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue3, startRestartGroup, 0);
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3398BottomSheetContainer8Un_QVk(null, 0.0f, 0L, new AnnotatedString(StringResources_androidKt.stringResource(R.string.earlyCheckIn_selectPassengers, startRestartGroup, 6), null, null, 6, null), null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-159890296, true, new EarlyCheckInPassengerSelectorScreenKt$EarlyCheckInPassengerSelectorScreen$2(navigator, viewState, booleanValue, formValidator, context, viewModel), startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(697287897, true, new EarlyCheckInPassengerSelectorScreenKt$EarlyCheckInPassengerSelectorScreen$3(viewState, passengerState, navigator, viewModel), startRestartGroup, 54), composer2, 905969664, 247);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: r4.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit EarlyCheckInPassengerSelectorScreen$lambda$2;
                    EarlyCheckInPassengerSelectorScreen$lambda$2 = EarlyCheckInPassengerSelectorScreenKt.EarlyCheckInPassengerSelectorScreen$lambda$2(EarlyCheckInPassengerSelectorViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return EarlyCheckInPassengerSelectorScreen$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EarlyCheckInPassengerSelectorScreen$lambda$2(EarlyCheckInPassengerSelectorViewModel earlyCheckInPassengerSelectorViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        EarlyCheckInPassengerSelectorScreen(earlyCheckInPassengerSelectorViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PassengerSelectorContent(final EarlyCheckInPassengerSelectorViewModel.ViewState viewState, final PassengerSelectionHelper.PassengerState passengerState, final Function1<? super String, Unit> function1, final Function0<Unit> function0, final Function0<Unit> function02, final Function1<? super BookingPassenger, Unit> function12, Composer composer, final int i5) {
        int i6;
        int i7;
        int i8;
        Composer composer2;
        Composer composer3;
        Composer startRestartGroup = composer.startRestartGroup(1903134233);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(passengerState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function12) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer3 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1903134233, i6, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.PassengerSelectorContent (EarlyCheckInPassengerSelectorScreen.kt:126)");
            }
            final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            startRestartGroup.startReplaceGroup(-296488473);
            if (viewState.getBooking() != null) {
                int maxPassengers = viewState.getBooking().getTicket().getTransport().getMaxPassengers();
                boolean isWalking = viewState.getBooking().getTicket().getTransport().isWalking();
                String pluralStringResource = StringResources_androidKt.pluralStringResource(R.plurals.passengers_maxPassengers, maxPassengers, new Object[]{Integer.valueOf(maxPassengers)}, startRestartGroup, 6);
                String formatted = PassengerInfoExtensionsKt.formatted(viewState.getBooking().getTicket().getPassengerInfo().toPassengerInfo(), (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()));
                if (isWalking) {
                    pluralStringResource = formatted;
                }
                i7 = 131072;
                i8 = 16384;
                TextKt.m940Text4IGK_g(pluralStringResource, PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m2599constructorimpl(16), 0.0f, 0.0f, Dp.m2599constructorimpl(8), 6, null), AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 384, 1572864, 65528);
            } else {
                i7 = 131072;
                i8 = 16384;
            }
            startRestartGroup.endReplaceGroup();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            PaddingValues m310PaddingValuesa9UjIt4$default = PaddingKt.m310PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(24), 7, null);
            startRestartGroup.startReplaceGroup(-296461581);
            boolean changedInstance = ((458752 & i6) == i7) | startRestartGroup.changedInstance(viewState) | ((i6 & 7168) == 2048) | startRestartGroup.changedInstance(passengerState) | startRestartGroup.changedInstance(context) | ((i6 & 896) == 256) | ((i6 & 57344) == i8);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                composer2 = startRestartGroup;
                Function1 function13 = new Function1() { // from class: r4.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PassengerSelectorContent$lambda$4$lambda$3;
                        PassengerSelectorContent$lambda$4$lambda$3 = EarlyCheckInPassengerSelectorScreenKt.PassengerSelectorContent$lambda$4$lambda$3(EarlyCheckInPassengerSelectorViewModel.ViewState.this, passengerState, function12, context, function1, function02, function0, (LazyListScope) obj);
                        return PassengerSelectorContent$lambda$4$lambda$3;
                    }
                };
                composer2.updateRememberedValue(function13);
                rememberedValue = function13;
            } else {
                composer2 = startRestartGroup;
            }
            composer2.endReplaceGroup();
            composer3 = composer2;
            LazyDslKt.LazyColumn(fillMaxSize$default, null, m310PaddingValuesa9UjIt4$default, false, null, null, null, false, (Function1) rememberedValue, composer3, 390, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: r4.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PassengerSelectorContent$lambda$5;
                    PassengerSelectorContent$lambda$5 = EarlyCheckInPassengerSelectorScreenKt.PassengerSelectorContent$lambda$5(EarlyCheckInPassengerSelectorViewModel.ViewState.this, passengerState, function1, function0, function02, function12, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return PassengerSelectorContent$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerSelectorContent$lambda$4$lambda$3(EarlyCheckInPassengerSelectorViewModel.ViewState viewState, PassengerSelectionHelper.PassengerState passengerState, Function1 function1, Context context, Function1 function12, Function0 function0, final Function0 function02, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        if (viewState.getIsLoading() || viewState.getBooking() == null) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$EarlyCheckInPassengerSelectorScreenKt.INSTANCE.m3552getLambda2$app_kombardoProd(), 3, null);
        } else {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1612289567, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.EarlyCheckInPassengerSelectorScreenKt$PassengerSelectorContent$1$1$1
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
                        ComposerKt.traceEventStart(-1612289567, i5, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.PassengerSelectorContent.<anonymous>.<anonymous>.<anonymous> (EarlyCheckInPassengerSelectorScreen.kt:154)");
                    }
                    OutlineDashedButtonKt.m3405OutlineDashedButtonEMNEwkI(PaddingKt.m311padding3ABfNKs(BackgroundKt.m104backgroundbw27NRU$default(Modifier.INSTANCE, AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null), Dp.m2599constructorimpl(16)), StringResources_androidKt.stringResource(R.string.passengers_create, composer, 6), R.drawable.icon_plus_circled, 0L, 0L, 0L, function02, composer, 390, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
            PassengerSelectionVerticalListKt.passengerSelectionVerticalList(LazyColumn, passengerState, function1, viewState, (r17 & 8) != 0 ? null : null, context, function12, function0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerSelectorContent$lambda$5(EarlyCheckInPassengerSelectorViewModel.ViewState viewState, PassengerSelectionHelper.PassengerState passengerState, Function1 function1, Function0 function0, Function0 function02, Function1 function12, int i5, Composer composer, int i6) {
        PassengerSelectorContent(viewState, passengerState, function1, function0, function02, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
