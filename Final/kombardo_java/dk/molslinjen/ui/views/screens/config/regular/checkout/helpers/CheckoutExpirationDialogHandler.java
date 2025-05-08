package dk.molslinjen.ui.views.screens.config.regular.checkout.helpers;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.lifecycle.compose.LifecycleEffectKt;
import androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult;
import androidx.lifecycle.compose.LifecycleResumePauseEffectScope;
import com.ramcosta.composedestinations.generated.destinations.DeparturesCommuterScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeparturesEditScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeparturesMultiRideScreenDestination;
import com.ramcosta.composedestinations.generated.destinations.DeparturesScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.ui.views.screens.booking.shared.expiration.ExpirationDialogKt;
import dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout;
import dk.molslinjen.ui.views.screens.config.regular.checkout.helpers.CheckoutExpirationDialogHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017¢\u0006\u0002\u0010\n¨\u0006\u000b²\u0006\f\u0010\f\u001a\u0004\u0018\u00010\rX\u008a\u008e\u0002"}, d2 = {"Ldk/molslinjen/ui/views/screens/config/regular/checkout/helpers/CheckoutExpirationDialogHandler;", "Ldk/molslinjen/ui/views/screens/config/regular/checkout/helpers/ICheckoutExpirationDialogHandler;", "<init>", "()V", "HandleDepartureExpiration", BuildConfig.FLAVOR, "expirableDepartures", "Ldk/molslinjen/ui/views/screens/booking/shared/expiration/IExpirableCheckout;", "navigator", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "(Ldk/molslinjen/ui/views/screens/booking/shared/expiration/IExpirableCheckout;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd", "job", "Lkotlinx/coroutines/Job;"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CheckoutExpirationDialogHandler implements ICheckoutExpirationDialogHandler {
    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState HandleDepartureExpiration$lambda$1$lambda$0() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        return mutableStateOf$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Job HandleDepartureExpiration$lambda$3(MutableState<Job> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecyclePauseOrDisposeEffectResult HandleDepartureExpiration$lambda$7$lambda$6(MutableState mutableState, IExpirableCheckout iExpirableCheckout, final MutableState mutableState2, final LifecycleResumePauseEffectScope LifecycleResumeEffect) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(LifecycleResumeEffect, "$this$LifecycleResumeEffect");
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CheckoutExpirationDialogHandler$HandleDepartureExpiration$1$1$1(mutableState, iExpirableCheckout, null), 3, null);
        mutableState2.setValue(launch$default);
        return new LifecyclePauseOrDisposeEffectResult() { // from class: dk.molslinjen.ui.views.screens.config.regular.checkout.helpers.CheckoutExpirationDialogHandler$HandleDepartureExpiration$lambda$7$lambda$6$$inlined$onPauseOrDispose$1
            @Override // androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult
            public void runPauseOrOnDisposeEffect() {
                Job HandleDepartureExpiration$lambda$3;
                HandleDepartureExpiration$lambda$3 = CheckoutExpirationDialogHandler.HandleDepartureExpiration$lambda$3(mutableState2);
                if (HandleDepartureExpiration$lambda$3 != null) {
                    Job.DefaultImpls.cancel$default(HandleDepartureExpiration$lambda$3, null, 1, null);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HandleDepartureExpiration$lambda$9$lambda$8(IExpirableCheckout iExpirableCheckout, DestinationsNavigator destinationsNavigator) {
        DestinationsNavigator.DefaultImpls.popBackStack$default(destinationsNavigator, iExpirableCheckout.isEditing() ? DeparturesEditScreenDestination.INSTANCE : iExpirableCheckout.isMultiRide() ? DeparturesMultiRideScreenDestination.INSTANCE : iExpirableCheckout.isCommuter() ? DeparturesCommuterScreenDestination.INSTANCE : DeparturesScreenDestination.INSTANCE, false, false, 4, null);
        iExpirableCheckout.resetCheckoutAfterExpiredDepartures();
        return Unit.INSTANCE;
    }

    @Override // dk.molslinjen.ui.views.screens.config.regular.checkout.helpers.ICheckoutExpirationDialogHandler
    public void HandleDepartureExpiration(final IExpirableCheckout expirableDepartures, final DestinationsNavigator navigator, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(expirableDepartures, "expirableDepartures");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        composer.startReplaceGroup(726306554);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(726306554, i5, -1, "dk.molslinjen.ui.views.screens.config.regular.checkout.helpers.CheckoutExpirationDialogHandler.HandleDepartureExpiration (CheckoutExpirationDialogHandler.kt:26)");
        }
        Object[] objArr = new Object[0];
        composer.startReplaceGroup(1097682107);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = new Function0() { // from class: j3.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    MutableState HandleDepartureExpiration$lambda$1$lambda$0;
                    HandleDepartureExpiration$lambda$1$lambda$0 = CheckoutExpirationDialogHandler.HandleDepartureExpiration$lambda$1$lambda$0();
                    return HandleDepartureExpiration$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, null, null, (Function0) rememberedValue, composer, 3072, 6);
        composer.startReplaceGroup(1097683593);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        final MutableState mutableState2 = (MutableState) rememberedValue2;
        composer.endReplaceGroup();
        Unit unit = Unit.INSTANCE;
        composer.startReplaceGroup(1097686731);
        int i6 = (i5 & 14) ^ 6;
        boolean z5 = true;
        boolean changed = composer.changed(mutableState) | ((i6 > 4 && composer.changedInstance(expirableDepartures)) || (i5 & 6) == 4);
        Object rememberedValue3 = composer.rememberedValue();
        if (changed || rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = new Function1() { // from class: j3.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    LifecyclePauseOrDisposeEffectResult HandleDepartureExpiration$lambda$7$lambda$6;
                    HandleDepartureExpiration$lambda$7$lambda$6 = CheckoutExpirationDialogHandler.HandleDepartureExpiration$lambda$7$lambda$6(MutableState.this, expirableDepartures, mutableState2, (LifecycleResumePauseEffectScope) obj);
                    return HandleDepartureExpiration$lambda$7$lambda$6;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        LifecycleEffectKt.LifecycleResumeEffect(unit, null, (Function1) rememberedValue3, composer, 6, 2);
        if (((Boolean) mutableState.getValue()).booleanValue()) {
            if (expirableDepartures.showReloadDialog()) {
                boolean isInCheckoutFlow = expirableDepartures.isInCheckoutFlow();
                composer.startReplaceGroup(1097711929);
                boolean z6 = (i6 > 4 && composer.changedInstance(expirableDepartures)) || (i5 & 6) == 4;
                if ((((i5 & 112) ^ 48) <= 32 || !composer.changed(navigator)) && (i5 & 48) != 32) {
                    z5 = false;
                }
                boolean z7 = z6 | z5;
                Object rememberedValue4 = composer.rememberedValue();
                if (z7 || rememberedValue4 == companion.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: j3.c
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit HandleDepartureExpiration$lambda$9$lambda$8;
                            HandleDepartureExpiration$lambda$9$lambda$8 = CheckoutExpirationDialogHandler.HandleDepartureExpiration$lambda$9$lambda$8(IExpirableCheckout.this, navigator);
                            return HandleDepartureExpiration$lambda$9$lambda$8;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue4);
                }
                composer.endReplaceGroup();
                ExpirationDialogKt.ExpirationDialog(isInCheckoutFlow, (Function0) rememberedValue4, composer, 0);
            } else {
                expirableDepartures.resetCheckoutAfterExpiredDepartures();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }
}
