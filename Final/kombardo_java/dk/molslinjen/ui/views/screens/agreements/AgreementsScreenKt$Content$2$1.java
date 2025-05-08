package dk.molslinjen.ui.views.screens.agreements;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.agreement.commuter.bornholm.BornholmCommuterAgreement;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.SegmentedControlKt;
import dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewScreenKt;
import dk.molslinjen.ui.views.screens.agreements.commuter.CommuterOverviewViewModel;
import dk.molslinjen.ui.views.screens.agreements.multiride.overview.MultiRideOverviewViewModel;
import dk.molslinjen.ui.views.screens.agreements.multiride.overview.MultiRideScreenKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgreementsScreenKt$Content$2$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ CommuterOverviewViewModel $commuterViewModel;
    final /* synthetic */ MultiRideOverviewViewModel $multiRideViewModel;
    final /* synthetic */ Function0<Unit> $navigateToAddCommuterAgreement;
    final /* synthetic */ Function0<Unit> $navigateToAddExistingMultiRide;
    final /* synthetic */ Function1<String, Unit> $navigateToBornholmCommuterDetails;
    final /* synthetic */ Function0<Unit> $navigateToLogin;
    final /* synthetic */ Function1<String, Unit> $navigateToMultiRideDetails;
    final /* synthetic */ Function1<String, Unit> $navigateToOeresundCommuterDetails;
    final /* synthetic */ Function0<Unit> $navigateToPurchaseMultiRide;
    final /* synthetic */ Function1<String, Unit> $navigateToRefillMultiRide;
    final /* synthetic */ AgreementTab $selectedTab;
    final /* synthetic */ Function1<BornholmCommuterAgreement, Unit> $startCommuterBooking;
    final /* synthetic */ Function1<MultiRideCard, Unit> $startMultiRideBooking;
    final /* synthetic */ Function1<AgreementTab, Unit> $updateSelectedTab;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AgreementTab.values().length];
            try {
                iArr[AgreementTab.MultiRide.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AgreementTab.Commuter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public AgreementsScreenKt$Content$2$1(AgreementTab agreementTab, Function1<? super AgreementTab, Unit> function1, MultiRideOverviewViewModel multiRideOverviewViewModel, Function1<? super String, Unit> function12, Function0<Unit> function0, Function0<Unit> function02, Function1<? super String, Unit> function13, Function1<? super MultiRideCard, Unit> function14, CommuterOverviewViewModel commuterOverviewViewModel, Function0<Unit> function03, Function1<? super String, Unit> function15, Function1<? super String, Unit> function16, Function1<? super BornholmCommuterAgreement, Unit> function17, Function0<Unit> function04) {
        this.$selectedTab = agreementTab;
        this.$updateSelectedTab = function1;
        this.$multiRideViewModel = multiRideOverviewViewModel;
        this.$navigateToMultiRideDetails = function12;
        this.$navigateToPurchaseMultiRide = function0;
        this.$navigateToAddExistingMultiRide = function02;
        this.$navigateToRefillMultiRide = function13;
        this.$startMultiRideBooking = function14;
        this.$commuterViewModel = commuterOverviewViewModel;
        this.$navigateToAddCommuterAgreement = function03;
        this.$navigateToBornholmCommuterDetails = function15;
        this.$navigateToOeresundCommuterDetails = function16;
        this.$startCommuterBooking = function17;
        this.$navigateToLogin = function04;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1(Function1 function1, int i5) {
        AgreementTab agreementTab = i5 != 0 ? i5 != 1 ? null : AgreementTab.Commuter : AgreementTab.MultiRide;
        if (agreementTab != null) {
            function1.invoke(agreementTab);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        int i6;
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(189840665, i5, -1, "dk.molslinjen.ui.views.screens.agreements.Content.<anonymous>.<anonymous> (AgreementsScreen.kt:132)");
        }
        if (this.$selectedTab == null) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        List listOf = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.string.agreements_tab_multiride), Integer.valueOf(R.string.agreements_tab_commuter)});
        Modifier.Companion companion = Modifier.INSTANCE;
        float f5 = 24;
        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer, 6);
        AgreementTab agreementTab = this.$selectedTab;
        int i7 = agreementTab == null ? -1 : WhenMappings.$EnumSwitchMapping$0[agreementTab.ordinal()];
        if (i7 == 1) {
            i6 = 0;
        } else {
            if (i7 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i6 = 1;
        }
        composer.startReplaceGroup(2022962515);
        boolean changed = composer.changed(this.$updateSelectedTab);
        final Function1<AgreementTab, Unit> function1 = this.$updateSelectedTab;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.agreements.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$2$lambda$1;
                    invoke$lambda$2$lambda$1 = AgreementsScreenKt$Content$2$1.invoke$lambda$2$lambda$1(Function1.this, ((Integer) obj).intValue());
                    return invoke$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        SegmentedControlKt.SegmentedControlStringRes(null, listOf, i6, (Function1) rememberedValue, composer, 48, 1);
        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer, 6);
        AgreementTab agreementTab2 = this.$selectedTab;
        int i8 = agreementTab2 != null ? WhenMappings.$EnumSwitchMapping$0[agreementTab2.ordinal()] : -1;
        if (i8 == 1) {
            composer.startReplaceGroup(2022982786);
            MultiRideScreenKt.MultiRideScreen(this.$multiRideViewModel, this.$navigateToMultiRideDetails, this.$navigateToPurchaseMultiRide, this.$navigateToAddExistingMultiRide, this.$navigateToRefillMultiRide, this.$startMultiRideBooking, composer, 0);
            composer.endReplaceGroup();
        } else if (i8 == 2) {
            composer.startReplaceGroup(2022998870);
            CommuterOverviewScreenKt.CommuterOverviewScreen(this.$commuterViewModel, this.$navigateToAddCommuterAgreement, this.$navigateToBornholmCommuterDetails, this.$navigateToOeresundCommuterDetails, this.$startCommuterBooking, this.$navigateToLogin, composer, 0);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(2022981369);
            composer.endReplaceGroup();
            throw new NoWhenBranchMatchedException();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
