package dk.molslinjen.ui.views.screens.agreements.multiride.details;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.generated.destinations.BarcodeDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeparturesMultiRideScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.MultiRideRefillScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.MultiRideTicketHistoryScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TicketDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.VehicleSelectorScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.OpenResultRecipientKt;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideAssociatedVehicle;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideTransport;
import dk.molslinjen.domain.model.booking.TicketCategoryType;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.barcode.BarcodeViewType;
import dk.molslinjen.ui.views.reusable.buttons.OutlineDashedButtonKt;
import dk.molslinjen.ui.views.reusable.dialog.DeleteDialogKt;
import dk.molslinjen.ui.views.screens.agreements.common.AgreementActiveTicketSectionKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsScreenKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel;
import dk.molslinjen.ui.views.screens.tickets.barcodeDetails.BarcodeValidity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u001a3\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\t\u0010\n\u001a»\u0001\u0010\u001e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\b0\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\r2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\u00172*\u0010\u001d\u001a&\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\b0\u0019j\u0002`\u001cH\u0003¢\u0006\u0004\b\u001e\u0010\u001f\u001aM\u0010%\u001a\u00020\b*\u00020 2\u0006\u0010\"\u001a\u00020!2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010#2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\b0\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0015H\u0002¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/multiride/details/MultiRideDetailsViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/VehicleSelectorScreenDestination;", "Ldk/molslinjen/domain/model/account/UserVehicle;", "vehicleSelectorResultRecipient", BuildConfig.FLAVOR, "MultiRideDetailsScreen", "(Ldk/molslinjen/ui/views/screens/agreements/multiride/details/MultiRideDetailsViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/result/ResultRecipient;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/agreements/multiride/details/MultiRideDetailsViewModel$ViewState;", "viewState", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "navigateToOrderTicket", BuildConfig.FLAVOR, "navigateToRefillMultiRide", "showMultiRideTravelHistory", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideAssociatedVehicle;", "removeVehicleAssociation", "Lkotlin/Function0;", "associateNewVehicle", "Lkotlin/Function2;", "showTicketDetails", "Lkotlin/Function4;", "Ldk/molslinjen/ui/views/reusable/barcode/BarcodeViewType;", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeValidity;", "Ldk/molslinjen/ui/views/shared/components/ExpandBarcodeCallback;", "expandBarCode", "DetailsContent", "(Ldk/molslinjen/ui/views/screens/agreements/multiride/details/MultiRideDetailsViewModel$ViewState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/lazy/LazyListScope;", BuildConfig.FLAVOR, "isLoadingVehicles", BuildConfig.FLAVOR, "associatedVehicles", "associatedVehiclesSection", "(Landroidx/compose/foundation/lazy/LazyListScope;ZLjava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class MultiRideDetailsScreenKt {
    private static final void DetailsContent(final MultiRideDetailsViewModel.ViewState viewState, final Function1<? super MultiRideCard, Unit> function1, final Function1<? super String, Unit> function12, final Function1<? super String, Unit> function13, final Function1<? super MultiRideAssociatedVehicle, Unit> function14, final Function0<Unit> function0, final Function2<? super String, ? super String, Unit> function2, final Function4<? super String, ? super String, ? super BarcodeViewType, ? super BarcodeValidity, Unit> function4, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(931372413);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function13) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function14) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i6 |= startRestartGroup.changedInstance(function4) ? 8388608 : 4194304;
        }
        if ((i6 & 4793491) == 4793490 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(931372413, i6, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.details.DetailsContent (MultiRideDetailsScreen.kt:136)");
            }
            final MultiRideCard multiRideCard = viewState.getMultiRideCard();
            if (multiRideCard == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: y2.s
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit DetailsContent$lambda$23;
                            DetailsContent$lambda$23 = MultiRideDetailsScreenKt.DetailsContent$lambda$23(MultiRideDetailsViewModel.ViewState.this, function1, function12, function13, function14, function0, function2, function4, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return DetailsContent$lambda$23;
                        }
                    });
                    return;
                }
                return;
            }
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null);
            float f5 = 16;
            PaddingValues m309PaddingValuesa9UjIt4 = PaddingKt.m309PaddingValuesa9UjIt4(Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(24), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(64));
            startRestartGroup.startReplaceGroup(-26506234);
            boolean changedInstance = startRestartGroup.changedInstance(multiRideCard) | ((i6 & 112) == 32) | ((i6 & 896) == 256) | ((29360128 & i6) == 8388608) | startRestartGroup.changedInstance(viewState) | ((57344 & i6) == 16384) | ((458752 & i6) == 131072) | ((3670016 & i6) == 1048576) | ((i6 & 7168) == 2048);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                Function1 function15 = new Function1() { // from class: y2.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DetailsContent$lambda$26$lambda$25;
                        DetailsContent$lambda$26$lambda$25 = MultiRideDetailsScreenKt.DetailsContent$lambda$26$lambda$25(MultiRideCard.this, viewState, function14, function0, function2, function1, function12, function4, function13, (LazyListScope) obj);
                        return DetailsContent$lambda$26$lambda$25;
                    }
                };
                startRestartGroup.updateRememberedValue(function15);
                rememberedValue = function15;
            }
            Function1 function16 = (Function1) rememberedValue;
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            LazyDslKt.LazyColumn(m104backgroundbw27NRU$default, null, m309PaddingValuesa9UjIt4, false, null, null, null, false, function16, composer2, 6, 250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: y2.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DetailsContent$lambda$27;
                    DetailsContent$lambda$27 = MultiRideDetailsScreenKt.DetailsContent$lambda$27(MultiRideDetailsViewModel.ViewState.this, function1, function12, function13, function14, function0, function2, function4, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DetailsContent$lambda$27;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetailsContent$lambda$23(MultiRideDetailsViewModel.ViewState viewState, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function0 function0, Function2 function2, Function4 function4, int i5, Composer composer, int i6) {
        DetailsContent(viewState, function1, function12, function13, function14, function0, function2, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetailsContent$lambda$26$lambda$25(final MultiRideCard multiRideCard, MultiRideDetailsViewModel.ViewState viewState, Function1 function1, Function0 function0, Function2 function2, final Function1 function12, final Function1 function13, final Function4 function4, final Function1 function14, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-303590039, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsScreenKt$DetailsContent$1$1$1
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
                    ComposerKt.traceEventStart(-303590039, i5, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.details.DetailsContent.<anonymous>.<anonymous>.<anonymous> (MultiRideDetailsScreen.kt:151)");
                }
                MultiRideDetailsCardKt.MultiRideDetailsCard(MultiRideCard.this, function12, function13, function4, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
        if (multiRideCard.getTicketType() == TicketCategoryType.BlueClass) {
            associatedVehiclesSection(LazyColumn, viewState.getIsLoadingVehicles(), viewState.getAssociatedVehicles(), function1, function0);
        }
        AgreementActiveTicketSectionKt.agreementActiveTicketsSection(LazyColumn, R.string.multiRide_activeTickets_header, R.string.multiRide_activeTickets_emptyDescription, viewState.getIsLoadingTickets(), multiRideCard.getTicketType(), viewState.getActiveTickets(), function2, new Function0() { // from class: y2.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit DetailsContent$lambda$26$lambda$25$lambda$24;
                DetailsContent$lambda$26$lambda$25$lambda$24 = MultiRideDetailsScreenKt.DetailsContent$lambda$26$lambda$25$lambda$24(Function1.this, multiRideCard);
                return DetailsContent$lambda$26$lambda$25$lambda$24;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetailsContent$lambda$26$lambda$25$lambda$24(Function1 function1, MultiRideCard multiRideCard) {
        function1.invoke(multiRideCard.getId());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetailsContent$lambda$27(MultiRideDetailsViewModel.ViewState viewState, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function0 function0, Function2 function2, Function4 function4, int i5, Composer composer, int i6) {
        DetailsContent(viewState, function1, function12, function13, function14, function0, function2, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void MultiRideDetailsScreen(final MultiRideDetailsViewModel viewModel, final DestinationsNavigator navigator, final ResultRecipient<VehicleSelectorScreenDestination, UserVehicle> vehicleSelectorResultRecipient, Composer composer, final int i5) {
        int i6;
        int i7;
        int i8;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(vehicleSelectorResultRecipient, "vehicleSelectorResultRecipient");
        Composer startRestartGroup = composer.startRestartGroup(2133011714);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(vehicleSelectorResultRecipient) ? 256 : 128;
        }
        int i9 = i6;
        if ((i9 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2133011714, i9, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsScreen (MultiRideDetailsScreen.kt:62)");
            }
            startRestartGroup.startReplaceGroup(-1864653388);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: y2.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit MultiRideDetailsScreen$lambda$1$lambda$0;
                        MultiRideDetailsScreen$lambda$1$lambda$0 = MultiRideDetailsScreenKt.MultiRideDetailsScreen$lambda$1$lambda$0(MultiRideDetailsViewModel.this, (UserVehicle) obj);
                        return MultiRideDetailsScreen$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            OpenResultRecipientKt.onResult(vehicleSelectorResultRecipient, null, (Function1) rememberedValue, startRestartGroup, (i9 >> 6) & 14, 1);
            final MultiRideDetailsViewModel.ViewState viewState = (MultiRideDetailsViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            final MultiRideAssociatedVehicle vehicleToRemove = viewState.getVehicleToRemove();
            startRestartGroup.startReplaceGroup(-1864648309);
            if (vehicleToRemove == null) {
                i7 = i9;
                i8 = 32;
                composer2 = startRestartGroup;
            } else {
                String stringResource = StringResources_androidKt.stringResource(R.string.multiride_removeVehicle_title, startRestartGroup, 6);
                String stringResource2 = StringResources_androidKt.stringResource(R.string.multiride_removeVehicle_description, new Object[]{vehicleToRemove.getName(), vehicleToRemove.getLicensePlate()}, startRestartGroup, 6);
                String stringResource3 = StringResources_androidKt.stringResource(R.string.button_removeVehicle, startRestartGroup, 6);
                boolean isRemoveVehicleLoading = viewState.getIsRemoveVehicleLoading();
                startRestartGroup.startReplaceGroup(-1709128428);
                boolean changedInstance2 = startRestartGroup.changedInstance(viewModel) | startRestartGroup.changedInstance(vehicleToRemove);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: y2.k
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit MultiRideDetailsScreen$lambda$5$lambda$3$lambda$2;
                            MultiRideDetailsScreen$lambda$5$lambda$3$lambda$2 = MultiRideDetailsScreenKt.MultiRideDetailsScreen$lambda$5$lambda$3$lambda$2(MultiRideDetailsViewModel.this, vehicleToRemove);
                            return MultiRideDetailsScreen$lambda$5$lambda$3$lambda$2;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                Function0 function0 = (Function0) rememberedValue2;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1709125913);
                boolean changedInstance3 = startRestartGroup.changedInstance(viewModel);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new MultiRideDetailsScreenKt$MultiRideDetailsScreen$2$2$1(viewModel);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                i7 = i9;
                i8 = 32;
                composer2 = startRestartGroup;
                DeleteDialogKt.DeleteDialog(stringResource, stringResource2, stringResource3, null, isRemoveVehicleLoading, function0, (Function0) ((KFunction) rememberedValue3), composer2, 0, 8);
                Unit unit = Unit.INSTANCE;
            }
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1864628447);
            int i10 = i7 & 112;
            boolean changedInstance4 = composer2.changedInstance(viewModel) | (i10 == i8);
            Object rememberedValue4 = composer2.rememberedValue();
            if (changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: y2.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit MultiRideDetailsScreen$lambda$8$lambda$7;
                        MultiRideDetailsScreen$lambda$8$lambda$7 = MultiRideDetailsScreenKt.MultiRideDetailsScreen$lambda$8$lambda$7(MultiRideDetailsViewModel.this, navigator, (MultiRideCard) obj);
                        return MultiRideDetailsScreen$lambda$8$lambda$7;
                    }
                };
                composer2.updateRememberedValue(rememberedValue4);
            }
            Function1 function1 = (Function1) rememberedValue4;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1864623113);
            boolean changedInstance5 = (i10 == i8) | composer2.changedInstance(viewState);
            Object rememberedValue5 = composer2.rememberedValue();
            if (changedInstance5 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: y2.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit MultiRideDetailsScreen$lambda$10$lambda$9;
                        MultiRideDetailsScreen$lambda$10$lambda$9 = MultiRideDetailsScreenKt.MultiRideDetailsScreen$lambda$10$lambda$9(DestinationsNavigator.this, viewState, (String) obj);
                        return MultiRideDetailsScreen$lambda$10$lambda$9;
                    }
                };
                composer2.updateRememberedValue(rememberedValue5);
            }
            Function1 function12 = (Function1) rememberedValue5;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1864612299);
            boolean z5 = i10 == i8;
            Object rememberedValue6 = composer2.rememberedValue();
            if (z5 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = new Function1() { // from class: y2.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit MultiRideDetailsScreen$lambda$12$lambda$11;
                        MultiRideDetailsScreen$lambda$12$lambda$11 = MultiRideDetailsScreenKt.MultiRideDetailsScreen$lambda$12$lambda$11(DestinationsNavigator.this, (String) obj);
                        return MultiRideDetailsScreen$lambda$12$lambda$11;
                    }
                };
                composer2.updateRememberedValue(rememberedValue6);
            }
            Function1 function13 = (Function1) rememberedValue6;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1864607639);
            boolean changedInstance6 = composer2.changedInstance(viewModel);
            Object rememberedValue7 = composer2.rememberedValue();
            if (changedInstance6 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = new MultiRideDetailsScreenKt$MultiRideDetailsScreen$6$1(viewModel);
                composer2.updateRememberedValue(rememberedValue7);
            }
            composer2.endReplaceGroup();
            Function1 function14 = (Function1) ((KFunction) rememberedValue7);
            composer2.startReplaceGroup(-1864604950);
            boolean changedInstance7 = composer2.changedInstance(viewState) | (i10 == i8);
            Object rememberedValue8 = composer2.rememberedValue();
            if (changedInstance7 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                rememberedValue8 = new Function0() { // from class: y2.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit MultiRideDetailsScreen$lambda$17$lambda$16;
                        MultiRideDetailsScreen$lambda$17$lambda$16 = MultiRideDetailsScreenKt.MultiRideDetailsScreen$lambda$17$lambda$16(MultiRideDetailsViewModel.ViewState.this, navigator);
                        return MultiRideDetailsScreen$lambda$17$lambda$16;
                    }
                };
                composer2.updateRememberedValue(rememberedValue8);
            }
            Function0 function02 = (Function0) rememberedValue8;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1864585691);
            boolean z6 = i10 == i8;
            Object rememberedValue9 = composer2.rememberedValue();
            if (z6 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                rememberedValue9 = new Function2() { // from class: y2.p
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit MultiRideDetailsScreen$lambda$19$lambda$18;
                        MultiRideDetailsScreen$lambda$19$lambda$18 = MultiRideDetailsScreenKt.MultiRideDetailsScreen$lambda$19$lambda$18(DestinationsNavigator.this, (String) obj, (String) obj2);
                        return MultiRideDetailsScreen$lambda$19$lambda$18;
                    }
                };
                composer2.updateRememberedValue(rememberedValue9);
            }
            Function2 function2 = (Function2) rememberedValue9;
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(-1864574817);
            boolean z7 = i10 == i8;
            Object rememberedValue10 = composer2.rememberedValue();
            if (z7 || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                rememberedValue10 = new Function4() { // from class: y2.q
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        Unit MultiRideDetailsScreen$lambda$21$lambda$20;
                        MultiRideDetailsScreen$lambda$21$lambda$20 = MultiRideDetailsScreenKt.MultiRideDetailsScreen$lambda$21$lambda$20(DestinationsNavigator.this, (String) obj, (String) obj2, (BarcodeViewType) obj3, (BarcodeValidity) obj4);
                        return MultiRideDetailsScreen$lambda$21$lambda$20;
                    }
                };
                composer2.updateRememberedValue(rememberedValue10);
            }
            composer2.endReplaceGroup();
            DetailsContent(viewState, function1, function12, function13, function14, function02, function2, (Function4) rememberedValue10, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: y2.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MultiRideDetailsScreen$lambda$22;
                    MultiRideDetailsScreen$lambda$22 = MultiRideDetailsScreenKt.MultiRideDetailsScreen$lambda$22(MultiRideDetailsViewModel.this, navigator, vehicleSelectorResultRecipient, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return MultiRideDetailsScreen$lambda$22;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideDetailsScreen$lambda$1$lambda$0(MultiRideDetailsViewModel multiRideDetailsViewModel, UserVehicle it) {
        Intrinsics.checkNotNullParameter(it, "it");
        multiRideDetailsViewModel.associateVehicle(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideDetailsScreen$lambda$10$lambda$9(DestinationsNavigator destinationsNavigator, MultiRideDetailsViewModel.ViewState viewState, String multiRideId) {
        Intrinsics.checkNotNullParameter(multiRideId, "multiRideId");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, MultiRideRefillScreenDestination.INSTANCE.invoke(multiRideId, PaymentOrigin.MultiRideCardFromDetails, viewState.getSite()), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideDetailsScreen$lambda$12$lambda$11(DestinationsNavigator destinationsNavigator, String multiRideId) {
        Intrinsics.checkNotNullParameter(multiRideId, "multiRideId");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, MultiRideTicketHistoryScreenDestination.INSTANCE.invoke(multiRideId), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideDetailsScreen$lambda$17$lambda$16(MultiRideDetailsViewModel.ViewState viewState, DestinationsNavigator destinationsNavigator) {
        List<MultiRideTransport> enabledTransportations;
        MultiRideCard multiRideCard = viewState.getMultiRideCard();
        if (multiRideCard != null && (enabledTransportations = multiRideCard.getEnabledTransportations()) != null) {
            VehicleSelectorScreenDestination vehicleSelectorScreenDestination = VehicleSelectorScreenDestination.INSTANCE;
            ArrayList<String> arrayList = new ArrayList<>();
            List<MultiRideTransport> list = enabledTransportations;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(((MultiRideTransport) it.next()).getTransportId());
            }
            String[] strArr = (String[]) arrayList2.toArray(new String[0]);
            DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, vehicleSelectorScreenDestination.invoke(arrayList, CollectionsKt.arrayListOf(Arrays.copyOf(strArr, strArr.length)), viewState.getSite()), null, null, 6, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideDetailsScreen$lambda$19$lambda$18(DestinationsNavigator destinationsNavigator, String reservationId, String phone) {
        Intrinsics.checkNotNullParameter(reservationId, "reservationId");
        Intrinsics.checkNotNullParameter(phone, "phone");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, TicketDetailsScreenDestination.INSTANCE.invoke(reservationId, phone, MultiRideManager.INSTANCE.getForceMolsSite(), false), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideDetailsScreen$lambda$21$lambda$20(DestinationsNavigator destinationsNavigator, String barcode, String str, BarcodeViewType barcodeType, BarcodeValidity validity) {
        Intrinsics.checkNotNullParameter(barcode, "barcode");
        Intrinsics.checkNotNullParameter(barcodeType, "barcodeType");
        Intrinsics.checkNotNullParameter(validity, "validity");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, BarcodeDetailsScreenDestination.INSTANCE.invoke(barcode, str, barcodeType, validity), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideDetailsScreen$lambda$22(MultiRideDetailsViewModel multiRideDetailsViewModel, DestinationsNavigator destinationsNavigator, ResultRecipient resultRecipient, int i5, Composer composer, int i6) {
        MultiRideDetailsScreen(multiRideDetailsViewModel, destinationsNavigator, resultRecipient, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideDetailsScreen$lambda$5$lambda$3$lambda$2(MultiRideDetailsViewModel multiRideDetailsViewModel, MultiRideAssociatedVehicle multiRideAssociatedVehicle) {
        multiRideDetailsViewModel.removeVehicleAssociation(multiRideAssociatedVehicle);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideDetailsScreen$lambda$8$lambda$7(MultiRideDetailsViewModel multiRideDetailsViewModel, final DestinationsNavigator destinationsNavigator, MultiRideCard it) {
        Intrinsics.checkNotNullParameter(it, "it");
        multiRideDetailsViewModel.startMultiRideBooking(it, new Function0() { // from class: y2.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit MultiRideDetailsScreen$lambda$8$lambda$7$lambda$6;
                MultiRideDetailsScreen$lambda$8$lambda$7$lambda$6 = MultiRideDetailsScreenKt.MultiRideDetailsScreen$lambda$8$lambda$7$lambda$6(DestinationsNavigator.this);
                return MultiRideDetailsScreen$lambda$8$lambda$7$lambda$6;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideDetailsScreen$lambda$8$lambda$7$lambda$6(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, DeparturesMultiRideScreenDestination.invoke$default(DeparturesMultiRideScreenDestination.INSTANCE, false, 1, null), null, null, 6, null);
        return Unit.INSTANCE;
    }

    private static final void associatedVehiclesSection(LazyListScope lazyListScope, boolean z5, final List<MultiRideAssociatedVehicle> list, final Function1<? super MultiRideAssociatedVehicle, Unit> function1, final Function0<Unit> function0) {
        ComposableSingletons$MultiRideDetailsScreenKt composableSingletons$MultiRideDetailsScreenKt = ComposableSingletons$MultiRideDetailsScreenKt.INSTANCE;
        LazyListScope.item$default(lazyListScope, null, null, composableSingletons$MultiRideDetailsScreenKt.m3433getLambda1$app_kombardoProd(), 3, null);
        if (!z5 && list != null) {
            if (list.isEmpty()) {
                LazyListScope.item$default(lazyListScope, null, null, composableSingletons$MultiRideDetailsScreenKt.m3434getLambda2$app_kombardoProd(), 3, null);
            } else {
                lazyListScope.items(list.size(), null, new Function1<Integer, Object>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsScreenKt$associatedVehiclesSection$$inlined$itemsIndexed$default$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int i5) {
                        list.get(i5);
                        return null;
                    }
                }, ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsScreenKt$associatedVehiclesSection$$inlined$itemsIndexed$default$3
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
                        MultiRideAssociatedVehicleRowStyle multiRideAssociatedVehicleRowStyle;
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
                            ComposerKt.traceEventStart(-1091073711, i7, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:188)");
                        }
                        final MultiRideAssociatedVehicle multiRideAssociatedVehicle = (MultiRideAssociatedVehicle) list.get(i5);
                        composer.startReplaceGroup(-1203241019);
                        composer.startReplaceGroup(515378611);
                        boolean changed = composer.changed(function1) | composer.changedInstance(multiRideAssociatedVehicle);
                        Object rememberedValue = composer.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            final Function1 function12 = function1;
                            rememberedValue = new Function0<Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsScreenKt$associatedVehiclesSection$1$1$1
                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function12.invoke(multiRideAssociatedVehicle);
                                }
                            };
                            composer.updateRememberedValue(rememberedValue);
                        }
                        Function0 function02 = (Function0) rememberedValue;
                        composer.endReplaceGroup();
                        if (list.size() == 1) {
                            multiRideAssociatedVehicleRowStyle = MultiRideAssociatedVehicleRowStyle.SingleItem;
                        } else if (i5 == 0) {
                            multiRideAssociatedVehicleRowStyle = MultiRideAssociatedVehicleRowStyle.First;
                        } else {
                            multiRideAssociatedVehicleRowStyle = CollectionsKt.getLastIndex(list) == i5 ? MultiRideAssociatedVehicleRowStyle.Last : MultiRideAssociatedVehicleRowStyle.Middle;
                        }
                        MultiRideAssociatedVehicleRowKt.MultiRideAssociatedVehicleRow(multiRideAssociatedVehicle, function02, multiRideAssociatedVehicleRowStyle, composer, 0);
                        composer.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
                LazyListScope.item$default(lazyListScope, null, null, composableSingletons$MultiRideDetailsScreenKt.m3435getLambda3$app_kombardoProd(), 3, null);
            }
        }
        if (z5) {
            return;
        }
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(68745471, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsScreenKt$associatedVehiclesSection$2
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
                    ComposerKt.traceEventStart(68745471, i5, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.details.associatedVehiclesSection.<anonymous> (MultiRideDetailsScreen.kt:227)");
                }
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(16)), composer, 6);
                OutlineDashedButtonKt.m3405OutlineDashedButtonEMNEwkI(null, StringResources_androidKt.stringResource(R.string.button_associateVehicle, composer, 6), R.drawable.icon_plus_circled, AppColor.INSTANCE.m3269getGrey60d7_KjU(), 0L, 0L, function0, composer, 3456, 49);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 3, null);
    }
}
