package dk.molslinjen.ui.views.screens.agreements;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.LifecycleEffectKt;
import androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult;
import androidx.lifecycle.compose.LifecycleResumePauseEffectScope;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.ramcosta.composedestinations.generated.destinations.BornholmCommuterAddScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.BornholmCommuterDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeparturesCommuterScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeparturesMultiRideScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.LoginScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.MultiRideAddCardScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.MultiRideDetailsScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.MultiRidePurchaseScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.MultiRideRefillScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.OeresundCommuterDetailsScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager;
import dk.molslinjen.domain.model.agreement.commuter.bornholm.BornholmCommuterAgreement;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import dk.molslinjen.domain.model.payment.PaymentOrigin;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.screens.agreements.AgreementsScreenKt;
import dk.molslinjen.ui.views.screens.agreements.AgreementsViewModel;
import dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewViewModel;
import dk.molslinjen.ui.views.screens.agreements.multiride.overview.MultiRideOverviewViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001aß\u0001\u0010\u001b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t2\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u00020\u00040\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\t2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\t2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\t2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00040\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0003¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/AgreementsViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "AgreementsScreen", "(Ldk/molslinjen/ui/views/screens/agreements/AgreementsViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/agreements/AgreementsViewModel$ViewState;", "viewState", "Lkotlin/Function1;", "Ldk/molslinjen/ui/views/screens/agreements/AgreementTab;", "updateSelectedTab", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCardNumber;", "navigateToMultiRideDetails", "Lkotlin/Function0;", "navigateToPurchaseMultiRide", "navigateToAddExistingMultiRide", "navigateToRefillMultiRide", "navigateToAddCommuterAgreement", "navigateToBornholmCommuterDetails", "navigateToOeresundCommuterDetails", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "startMultiRideBooking", "Ldk/molslinjen/domain/model/agreement/commuter/bornholm/BornholmCommuterAgreement;", "startCommuterBooking", "navigateToLogin", "Content", "(Ldk/molslinjen/ui/views/screens/agreements/AgreementsViewModel$ViewState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AgreementsScreenKt {
    public static final void AgreementsScreen(final AgreementsViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(-611075695);
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
                ComposerKt.traceEventStart(-611075695, i6, -1, "dk.molslinjen.ui.views.screens.agreements.AgreementsScreen (AgreementsScreen.kt:43)");
            }
            AgreementsViewModel.ViewState viewState = (AgreementsViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(-713814575);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new AgreementsScreenKt$AgreementsScreen$1$1(viewModel);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Function1 function1 = (Function1) ((KFunction) rememberedValue);
            startRestartGroup.startReplaceGroup(-713812354);
            int i7 = i6 & 112;
            boolean z5 = i7 == 32;
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: n2.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit AgreementsScreen$lambda$2$lambda$1;
                        AgreementsScreen$lambda$2$lambda$1 = AgreementsScreenKt.AgreementsScreen$lambda$2$lambda$1(DestinationsNavigator.this, (String) obj);
                        return AgreementsScreen$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function1 function12 = (Function1) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-713807555);
            boolean z6 = i7 == 32;
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function0() { // from class: n2.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AgreementsScreen$lambda$4$lambda$3;
                        AgreementsScreen$lambda$4$lambda$3 = AgreementsScreenKt.AgreementsScreen$lambda$4$lambda$3(DestinationsNavigator.this);
                        return AgreementsScreen$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            Function0 function0 = (Function0) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-713797918);
            boolean z7 = i7 == 32;
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: n2.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AgreementsScreen$lambda$6$lambda$5;
                        AgreementsScreen$lambda$6$lambda$5 = AgreementsScreenKt.AgreementsScreen$lambda$6$lambda$5(DestinationsNavigator.this);
                        return AgreementsScreen$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            Function0 function02 = (Function0) rememberedValue4;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-713793991);
            boolean z8 = i7 == 32;
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (z8 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new Function1() { // from class: n2.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit AgreementsScreen$lambda$8$lambda$7;
                        AgreementsScreen$lambda$8$lambda$7 = AgreementsScreenKt.AgreementsScreen$lambda$8$lambda$7(DestinationsNavigator.this, (String) obj);
                        return AgreementsScreen$lambda$8$lambda$7;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            Function1 function13 = (Function1) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-713782491);
            boolean z9 = i7 == 32;
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (z9 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = new Function0() { // from class: n2.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AgreementsScreen$lambda$10$lambda$9;
                        AgreementsScreen$lambda$10$lambda$9 = AgreementsScreenKt.AgreementsScreen$lambda$10$lambda$9(DestinationsNavigator.this);
                        return AgreementsScreen$lambda$10$lambda$9;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            Function0 function03 = (Function0) rememberedValue6;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-713778411);
            boolean z10 = i7 == 32;
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (z10 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                rememberedValue7 = new Function1() { // from class: n2.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit AgreementsScreen$lambda$12$lambda$11;
                        AgreementsScreen$lambda$12$lambda$11 = AgreementsScreenKt.AgreementsScreen$lambda$12$lambda$11(DestinationsNavigator.this, (String) obj);
                        return AgreementsScreen$lambda$12$lambda$11;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            Function1 function14 = (Function1) rememberedValue7;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-713772843);
            boolean z11 = i7 == 32;
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (z11 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                rememberedValue8 = new Function1() { // from class: n2.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit AgreementsScreen$lambda$14$lambda$13;
                        AgreementsScreen$lambda$14$lambda$13 = AgreementsScreenKt.AgreementsScreen$lambda$14$lambda$13(DestinationsNavigator.this, (String) obj);
                        return AgreementsScreen$lambda$14$lambda$13;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            Function1 function15 = (Function1) rememberedValue8;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-713767564);
            boolean changedInstance2 = startRestartGroup.changedInstance(viewModel) | (i7 == 32);
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                rememberedValue9 = new Function1() { // from class: n2.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit AgreementsScreen$lambda$17$lambda$16;
                        AgreementsScreen$lambda$17$lambda$16 = AgreementsScreenKt.AgreementsScreen$lambda$17$lambda$16(AgreementsViewModel.this, navigator, (MultiRideCard) obj);
                        return AgreementsScreen$lambda$17$lambda$16;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue9);
            }
            Function1 function16 = (Function1) rememberedValue9;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-713759354);
            boolean changedInstance3 = startRestartGroup.changedInstance(viewModel) | (i7 == 32);
            Object rememberedValue10 = startRestartGroup.rememberedValue();
            if (changedInstance3 || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                rememberedValue10 = new Function1() { // from class: n2.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit AgreementsScreen$lambda$20$lambda$19;
                        AgreementsScreen$lambda$20$lambda$19 = AgreementsScreenKt.AgreementsScreen$lambda$20$lambda$19(AgreementsViewModel.this, navigator, (BornholmCommuterAgreement) obj);
                        return AgreementsScreen$lambda$20$lambda$19;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue10);
            }
            Function1 function17 = (Function1) rememberedValue10;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-713750921);
            boolean z12 = i7 == 32;
            Object rememberedValue11 = startRestartGroup.rememberedValue();
            if (z12 || rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                rememberedValue11 = new Function0() { // from class: n2.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit AgreementsScreen$lambda$22$lambda$21;
                        AgreementsScreen$lambda$22$lambda$21 = AgreementsScreenKt.AgreementsScreen$lambda$22$lambda$21(DestinationsNavigator.this);
                        return AgreementsScreen$lambda$22$lambda$21;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue11);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            Content(viewState, function1, function12, function0, function02, function13, function03, function14, function15, function16, function17, (Function0) rememberedValue11, composer2, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: n2.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AgreementsScreen$lambda$23;
                    AgreementsScreen$lambda$23 = AgreementsScreenKt.AgreementsScreen$lambda$23(AgreementsViewModel.this, navigator, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return AgreementsScreen$lambda$23;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AgreementsScreen$lambda$10$lambda$9(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, BornholmCommuterAddScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AgreementsScreen$lambda$12$lambda$11(DestinationsNavigator destinationsNavigator, String commuterAgreementId) {
        Intrinsics.checkNotNullParameter(commuterAgreementId, "commuterAgreementId");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, BornholmCommuterDetailsScreenDestination.INSTANCE.invoke(commuterAgreementId), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AgreementsScreen$lambda$14$lambda$13(DestinationsNavigator destinationsNavigator, String commuterAgreementId) {
        Intrinsics.checkNotNullParameter(commuterAgreementId, "commuterAgreementId");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, OeresundCommuterDetailsScreenDestination.INSTANCE.invoke(commuterAgreementId), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AgreementsScreen$lambda$17$lambda$16(AgreementsViewModel agreementsViewModel, final DestinationsNavigator destinationsNavigator, MultiRideCard multiRideCard) {
        Intrinsics.checkNotNullParameter(multiRideCard, "multiRideCard");
        agreementsViewModel.startMultiRideBooking(multiRideCard, new Function0() { // from class: n2.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit AgreementsScreen$lambda$17$lambda$16$lambda$15;
                AgreementsScreen$lambda$17$lambda$16$lambda$15 = AgreementsScreenKt.AgreementsScreen$lambda$17$lambda$16$lambda$15(DestinationsNavigator.this);
                return AgreementsScreen$lambda$17$lambda$16$lambda$15;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AgreementsScreen$lambda$17$lambda$16$lambda$15(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, DeparturesMultiRideScreenDestination.invoke$default(DeparturesMultiRideScreenDestination.INSTANCE, false, 1, null), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AgreementsScreen$lambda$2$lambda$1(DestinationsNavigator destinationsNavigator, String multiRideId) {
        Intrinsics.checkNotNullParameter(multiRideId, "multiRideId");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, MultiRideDetailsScreenDestination.INSTANCE.invoke(multiRideId), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AgreementsScreen$lambda$20$lambda$19(AgreementsViewModel agreementsViewModel, final DestinationsNavigator destinationsNavigator, BornholmCommuterAgreement commuterAgreement) {
        Intrinsics.checkNotNullParameter(commuterAgreement, "commuterAgreement");
        agreementsViewModel.startCommuterBooking(commuterAgreement, new Function0() { // from class: n2.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit AgreementsScreen$lambda$20$lambda$19$lambda$18;
                AgreementsScreen$lambda$20$lambda$19$lambda$18 = AgreementsScreenKt.AgreementsScreen$lambda$20$lambda$19$lambda$18(DestinationsNavigator.this);
                return AgreementsScreen$lambda$20$lambda$19$lambda$18;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AgreementsScreen$lambda$20$lambda$19$lambda$18(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, DeparturesCommuterScreenDestination.invoke$default(DeparturesCommuterScreenDestination.INSTANCE, false, 1, null), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AgreementsScreen$lambda$22$lambda$21(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, LoginScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AgreementsScreen$lambda$23(AgreementsViewModel agreementsViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        AgreementsScreen(agreementsViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AgreementsScreen$lambda$4$lambda$3(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, MultiRidePurchaseScreenDestination.INSTANCE.invoke(PaymentOrigin.MultiRideCardFromAgreements, MultiRideManager.INSTANCE.getForceMolsSite()), null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AgreementsScreen$lambda$6$lambda$5(DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, MultiRideAddCardScreenDestination.INSTANCE, null, null, 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AgreementsScreen$lambda$8$lambda$7(DestinationsNavigator destinationsNavigator, String multiRideId) {
        Intrinsics.checkNotNullParameter(multiRideId, "multiRideId");
        DestinationsNavigator.DefaultImpls.navigate$default(destinationsNavigator, MultiRideRefillScreenDestination.INSTANCE.invoke(multiRideId, PaymentOrigin.MultiRideCardFromAgreements, MultiRideManager.INSTANCE.getForceMolsSite()), null, null, 6, null);
        return Unit.INSTANCE;
    }

    private static final void Content(final AgreementsViewModel.ViewState viewState, final Function1<? super AgreementTab, Unit> function1, final Function1<? super String, Unit> function12, final Function0<Unit> function0, final Function0<Unit> function02, final Function1<? super String, Unit> function13, final Function0<Unit> function03, final Function1<? super String, Unit> function14, final Function1<? super String, Unit> function15, final Function1<? super MultiRideCard, Unit> function16, final Function1<? super BornholmCommuterAgreement, Unit> function17, final Function0<Unit> function04, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-633480209);
        if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(viewState) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(function02) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(function13) ? 131072 : 65536;
        }
        if ((1572864 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(function03) ? 1048576 : 524288;
        }
        if ((12582912 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(function14) ? 8388608 : 4194304;
        }
        if ((i5 & 100663296) == 0) {
            i7 |= startRestartGroup.changedInstance(function15) ? 67108864 : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i7 |= startRestartGroup.changedInstance(function16) ? 536870912 : 268435456;
        }
        if ((i6 & 6) == 0) {
            i8 = i6 | (startRestartGroup.changedInstance(function17) ? 4 : 2);
        } else {
            i8 = i6;
        }
        if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changedInstance(function04) ? 32 : 16;
        }
        if ((306783379 & i7) == 306783378 && (i8 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-633480209, i7, i8, "dk.molslinjen.ui.views.screens.agreements.Content (AgreementsScreen.kt:112)");
            }
            startRestartGroup.startReplaceableGroup(1890788296);
            LocalViewModelStoreOwner localViewModelStoreOwner = LocalViewModelStoreOwner.INSTANCE;
            int i9 = LocalViewModelStoreOwner.$stable;
            ViewModelStoreOwner current = localViewModelStoreOwner.getCurrent(startRestartGroup, i9);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            ViewModelProvider.Factory createHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1729797275);
            ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) MultiRideOverviewViewModel.class, current, (String) null, createHiltViewModelFactory, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, startRestartGroup, 36936, 0);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            final MultiRideOverviewViewModel multiRideOverviewViewModel = (MultiRideOverviewViewModel) viewModel;
            startRestartGroup.startReplaceableGroup(1890788296);
            ViewModelStoreOwner current2 = localViewModelStoreOwner.getCurrent(startRestartGroup, i9);
            if (current2 == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            ViewModelProvider.Factory createHiltViewModelFactory2 = HiltViewModelKt.createHiltViewModelFactory(current2, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1729797275);
            ViewModel viewModel2 = ViewModelKt.viewModel((Class<ViewModel>) CommuterOverviewViewModel.class, current2, (String) null, createHiltViewModelFactory2, current2 instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current2).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, startRestartGroup, 36936, 0);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            final CommuterOverviewViewModel commuterOverviewViewModel = (CommuterOverviewViewModel) viewModel2;
            AgreementTab selectedTab = viewState.getSelectedTab();
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(1057117507);
            boolean changedInstance = startRestartGroup.changedInstance(multiRideOverviewViewModel) | startRestartGroup.changedInstance(commuterOverviewViewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: n2.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        LifecyclePauseOrDisposeEffectResult Content$lambda$26$lambda$25;
                        Content$lambda$26$lambda$25 = AgreementsScreenKt.Content$lambda$26$lambda$25(MultiRideOverviewViewModel.this, commuterOverviewViewModel, (LifecycleResumePauseEffectScope) obj);
                        return Content$lambda$26$lambda$25;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            LifecycleEffectKt.LifecycleResumeEffect(unit, null, (Function1) rememberedValue, startRestartGroup, 6, 2);
            Modifier.Companion companion = Modifier.INSTANCE;
            AppColor appColor = AppColor.INSTANCE;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(BackgroundKt.m104backgroundbw27NRU$default(companion, appColor.m3269getGrey60d7_KjU(), null, 2, null), Dp.m2599constructorimpl(16), 0.0f, 2, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
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
            LoadingComponentKt.m3392LoadingComponentjfnsLPA(BackgroundKt.m104backgroundbw27NRU$default(companion, appColor.m3269getGrey60d7_KjU(), null, 2, null), 0.0f, selectedTab == null, 0, false, null, ComposableLambdaKt.rememberComposableLambda(189840665, true, new AgreementsScreenKt$Content$2$1(selectedTab, function1, multiRideOverviewViewModel, function12, function0, function02, function13, function16, commuterOverviewViewModel, function03, function14, function15, function17, function04), startRestartGroup, 54), startRestartGroup, 1572870, 58);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: n2.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$28;
                    Content$lambda$28 = AgreementsScreenKt.Content$lambda$28(AgreementsViewModel.ViewState.this, function1, function12, function0, function02, function13, function03, function14, function15, function16, function17, function04, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$28;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecyclePauseOrDisposeEffectResult Content$lambda$26$lambda$25(MultiRideOverviewViewModel multiRideOverviewViewModel, CommuterOverviewViewModel commuterOverviewViewModel, final LifecycleResumePauseEffectScope LifecycleResumeEffect) {
        Intrinsics.checkNotNullParameter(LifecycleResumeEffect, "$this$LifecycleResumeEffect");
        multiRideOverviewViewModel.reload();
        commuterOverviewViewModel.reload();
        return new LifecyclePauseOrDisposeEffectResult() { // from class: dk.molslinjen.ui.views.screens.agreements.AgreementsScreenKt$Content$lambda$26$lambda$25$$inlined$onPauseOrDispose$1
            @Override // androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult
            public void runPauseOrOnDisposeEffect() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$28(AgreementsViewModel.ViewState viewState, Function1 function1, Function1 function12, Function0 function0, Function0 function02, Function1 function13, Function0 function03, Function1 function14, Function1 function15, Function1 function16, Function1 function17, Function0 function04, int i5, int i6, Composer composer, int i7) {
        Content(viewState, function1, function12, function0, function02, function13, function03, function14, function15, function16, function17, function04, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
        return Unit.INSTANCE;
    }
}
