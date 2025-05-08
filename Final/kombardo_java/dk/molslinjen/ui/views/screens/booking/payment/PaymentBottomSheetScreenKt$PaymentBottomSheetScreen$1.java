package dk.molslinjen.ui.views.screens.booking.payment;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.navigation.NavOptions;
import com.ramcosta.composedestinations.generated.destinations.AgreementsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.EarlyCheckInScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.MultiRideDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.MultiRidePurchaseReceiptScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.PaymentScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.SimpleChangeReceiptScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TicketDetailsScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.spec.RouteOrDirection;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.global.navigation.bottomsheet.BottomSheetDismissHandler;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PaymentBottomSheetScreenKt$PaymentBottomSheetScreen$1 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ BottomSheetDismissHandler $bottomSheetDismissHandler;
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ ScrollState $scrollState;
    final /* synthetic */ PaymentViewModel $viewModel;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaymentOrigin.values().length];
            try {
                iArr[PaymentOrigin.SimpleChangeOrEarlyCheckInTicket.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PaymentOrigin.MultiRideCardFromDetails.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PaymentOrigin.MultiRideCardFromAgreements.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PaymentOrigin.Ticket.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PaymentOrigin.TicketChange.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PaymentOrigin.MultiRideTicketFromAgreements.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PaymentOrigin.CommuterTicketFromAgreements.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PaymentOrigin.MultiRideTicketFromDetails.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PaymentOrigin.CommuterTicketFromDetails.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[PaymentOrigin.SaleOnBoard.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PaymentBottomSheetScreenKt$PaymentBottomSheetScreen$1(ScrollState scrollState, PaymentViewModel paymentViewModel, BottomSheetDismissHandler bottomSheetDismissHandler, DestinationsNavigator destinationsNavigator) {
        this.$scrollState = scrollState;
        this.$viewModel = paymentViewModel;
        this.$bottomSheetDismissHandler = bottomSheetDismissHandler;
        this.$navigator = destinationsNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$1$lambda$0(BottomSheetDismissHandler bottomSheetDismissHandler, DestinationsNavigator destinationsNavigator, PaymentOrigin paymentOrigin, boolean z5) {
        RouteOrDirection routeOrDirection;
        Intrinsics.checkNotNullParameter(paymentOrigin, "paymentOrigin");
        switch (WhenMappings.$EnumSwitchMapping$0[paymentOrigin.ordinal()]) {
            case 1:
                bottomSheetDismissHandler.navigatePopBlockingSheets(destinationsNavigator, SimpleChangeReceiptScreenDestination.INSTANCE, NavOptions.Builder.setPopUpTo$default(new NavOptions.Builder(), z5 ? EarlyCheckInScreenDestination.INSTANCE.getRoute() : TicketDetailsScreenDestination.INSTANCE.getRoute(), false, false, 4, (Object) null).build());
                return Unit.INSTANCE;
            case 2:
                routeOrDirection = MultiRideDetailsScreenDestination.INSTANCE;
                break;
            case 3:
                routeOrDirection = AgreementsScreenDestination.INSTANCE;
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                Logger.INSTANCE.logCriticalThenFatalError(new CriticalLog("Should be using " + Reflection.getOrCreateKotlinClass(PaymentScreenDestination.class).getSimpleName() + " for " + paymentOrigin + " origin, and not PaymentBottomSheetScreenDestination"));
                return Unit.INSTANCE;
            default:
                throw new NoWhenBranchMatchedException();
        }
        bottomSheetDismissHandler.navigatePopBlockingSheets(destinationsNavigator, MultiRidePurchaseReceiptScreenDestination.INSTANCE, NavOptions.Builder.setPopUpTo$default(new NavOptions.Builder(), routeOrDirection.getRoute(), false, false, 4, (Object) null).build());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope BottomSheetContainer, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1221403282, i5, -1, "dk.molslinjen.ui.views.screens.booking.payment.PaymentBottomSheetScreen.<anonymous> (PaymentBottomSheetScreen.kt:63)");
        }
        Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), this.$scrollState, false, null, false, 14, null), AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null);
        Alignment center = Alignment.INSTANCE.getCenter();
        PaymentViewModel paymentViewModel = this.$viewModel;
        final BottomSheetDismissHandler bottomSheetDismissHandler = this.$bottomSheetDismissHandler;
        final DestinationsNavigator destinationsNavigator = this.$navigator;
        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m104backgroundbw27NRU$default);
        ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        composer.startReplaceGroup(-995740489);
        boolean changedInstance = composer.changedInstance(bottomSheetDismissHandler) | composer.changed(destinationsNavigator);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function2() { // from class: dk.molslinjen.ui.views.screens.booking.payment.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit invoke$lambda$3$lambda$1$lambda$0;
                    invoke$lambda$3$lambda$1$lambda$0 = PaymentBottomSheetScreenKt$PaymentBottomSheetScreen$1.invoke$lambda$3$lambda$1$lambda$0(BottomSheetDismissHandler.this, destinationsNavigator, (PaymentOrigin) obj, ((Boolean) obj2).booleanValue());
                    return invoke$lambda$3$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        Function2 function2 = (Function2) rememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-995666255);
        boolean changed = composer.changed(destinationsNavigator);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new PaymentBottomSheetScreenKt$PaymentBottomSheetScreen$1$1$2$1(destinationsNavigator);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        PaymentScreenKt.PaymentScreenShared(paymentViewModel, function2, (Function0) rememberedValue2, composer, 0);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
