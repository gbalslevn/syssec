package dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.details;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.ramcosta.composedestinations.generated.destinations.CommuterTicketHistoryScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeparturesCommuterScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.TicketDetailsScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.managers.agreement.commuter.bornholm.BornholmCommuterManager;
import dk.molslinjen.domain.model.agreement.commuter.bornholm.BornholmCommuterAgreement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BornholmCommuterDetailsScreenKt$BornholmCommuterDetailsScreen$1$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ BornholmCommuterAgreement $commuterAgreement;
    final /* synthetic */ DestinationsNavigator $navigator;
    final /* synthetic */ BornholmCommuterDetailsViewModel $viewModel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BornholmCommuterDetailsScreenKt$BornholmCommuterDetailsScreen$1$1(BornholmCommuterAgreement bornholmCommuterAgreement, BornholmCommuterDetailsViewModel bornholmCommuterDetailsViewModel, DestinationsNavigator destinationsNavigator) {
        this.$commuterAgreement = bornholmCommuterAgreement;
        this.$viewModel = bornholmCommuterDetailsViewModel;
        this.$navigator = destinationsNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$7$lambda$2$lambda$1(BornholmCommuterDetailsViewModel bornholmCommuterDetailsViewModel, final DestinationsNavigator destinationsNavigator, BornholmCommuterAgreement agreement) {
        Intrinsics.checkNotNullParameter(agreement, "agreement");
        bornholmCommuterDetailsViewModel.startCommuterBooking(agreement, new Function0() { // from class: dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.details.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit invoke$lambda$7$lambda$2$lambda$1$lambda$0;
                invoke$lambda$7$lambda$2$lambda$1$lambda$0 = BornholmCommuterDetailsScreenKt$BornholmCommuterDetailsScreen$1$1.invoke$lambda$7$lambda$2$lambda$1$lambda$0(DestinationsNavigator.this);
                return invoke$lambda$7$lambda$2$lambda$1$lambda$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$7$lambda$2$lambda$1$lambda$0(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, DeparturesCommuterScreenDestination.invoke$default(DeparturesCommuterScreenDestination.INSTANCE, false, 1, null), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$7$lambda$4$lambda$3(DestinationsNavigator destinationsNavigator, String reservationId, String phone) {
        Intrinsics.checkNotNullParameter(reservationId, "reservationId");
        Intrinsics.checkNotNullParameter(phone, "phone");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, TicketDetailsScreenDestination.INSTANCE.invoke(reservationId, phone, BornholmCommuterManager.INSTANCE.getForceBornholm(), false), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$7$lambda$6$lambda$5(DestinationsNavigator destinationsNavigator, BornholmCommuterAgreement commuterAgreement) {
        Intrinsics.checkNotNullParameter(commuterAgreement, "commuterAgreement");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, CommuterTicketHistoryScreenDestination.INSTANCE.invoke(commuterAgreement.getCommuterId(), commuterAgreement.getCommuterAgreementId()), null, null, 6, null);
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
            ComposerKt.traceEventStart(-451786588, i5, -1, "dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.details.BornholmCommuterDetailsScreen.<anonymous>.<anonymous> (BornholmCommuterDetailsScreen.kt:49)");
        }
        BornholmCommuterAgreement bornholmCommuterAgreement = this.$commuterAgreement;
        if (bornholmCommuterAgreement != null) {
            final BornholmCommuterDetailsViewModel bornholmCommuterDetailsViewModel = this.$viewModel;
            final DestinationsNavigator destinationsNavigator = this.$navigator;
            composer.startReplaceGroup(1539305384);
            boolean changedInstance = composer.changedInstance(bornholmCommuterDetailsViewModel) | composer.changed(destinationsNavigator);
            Object rememberedValue = composer.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.details.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit invoke$lambda$7$lambda$2$lambda$1;
                        invoke$lambda$7$lambda$2$lambda$1 = BornholmCommuterDetailsScreenKt$BornholmCommuterDetailsScreen$1$1.invoke$lambda$7$lambda$2$lambda$1(BornholmCommuterDetailsViewModel.this, destinationsNavigator, (BornholmCommuterAgreement) obj);
                        return invoke$lambda$7$lambda$2$lambda$1;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function1 function1 = (Function1) rememberedValue;
            composer.endReplaceGroup();
            composer.startReplaceGroup(1539314081);
            boolean changed = composer.changed(destinationsNavigator);
            Object rememberedValue2 = composer.rememberedValue();
            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function2() { // from class: dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.details.b
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit invoke$lambda$7$lambda$4$lambda$3;
                        invoke$lambda$7$lambda$4$lambda$3 = BornholmCommuterDetailsScreenKt$BornholmCommuterDetailsScreen$1$1.invoke$lambda$7$lambda$4$lambda$3(DestinationsNavigator.this, (String) obj, (String) obj2);
                        return invoke$lambda$7$lambda$4$lambda$3;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            Function2 function2 = (Function2) rememberedValue2;
            composer.endReplaceGroup();
            composer.startReplaceGroup(1539329450);
            boolean changed2 = composer.changed(destinationsNavigator);
            Object rememberedValue3 = composer.rememberedValue();
            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: dk.molslinjen.ui.views.screens.agreements.commuter.bornholm.details.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit invoke$lambda$7$lambda$6$lambda$5;
                        invoke$lambda$7$lambda$6$lambda$5 = BornholmCommuterDetailsScreenKt$BornholmCommuterDetailsScreen$1$1.invoke$lambda$7$lambda$6$lambda$5(DestinationsNavigator.this, (BornholmCommuterAgreement) obj);
                        return invoke$lambda$7$lambda$6$lambda$5;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            composer.endReplaceGroup();
            BornholmCommuterDetailsScreenKt.Content(bornholmCommuterAgreement, function1, function2, (Function1) rememberedValue3, composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
