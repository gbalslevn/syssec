package dk.molslinjen.ui.views.screens.profile.passengers;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import dk.molslinjen.domain.model.account.UserPassenger;
import dk.molslinjen.ui.views.reusable.swipe.SwipeToDeleteKt;
import dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengerRowKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a?\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ldk/molslinjen/domain/model/account/UserPassenger;", "passenger", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "navigateToEdit", "triggerDeleteFlow", "ProfilePassengerRow", "(Ldk/molslinjen/domain/model/account/UserPassenger;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProfilePassengerRowKt {
    public static final void ProfilePassengerRow(final UserPassenger passenger, final Function1<? super String, Unit> navigateToEdit, final Function1<? super UserPassenger, Unit> triggerDeleteFlow, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(passenger, "passenger");
        Intrinsics.checkNotNullParameter(navigateToEdit, "navigateToEdit");
        Intrinsics.checkNotNullParameter(triggerDeleteFlow, "triggerDeleteFlow");
        Composer startRestartGroup = composer.startRestartGroup(1422396852);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(passenger) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(navigateToEdit) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(triggerDeleteFlow) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1422396852, i6, -1, "dk.molslinjen.ui.views.screens.profile.passengers.ProfilePassengerRow (ProfilePassengerRow.kt:28)");
            }
            startRestartGroup.startReplaceGroup(-1410127382);
            boolean changedInstance = ((i6 & 896) == 256) | startRestartGroup.changedInstance(passenger);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: Q3.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfilePassengerRow$lambda$1$lambda$0;
                        ProfilePassengerRow$lambda$1$lambda$0 = ProfilePassengerRowKt.ProfilePassengerRow$lambda$1$lambda$0(Function1.this, passenger);
                        return ProfilePassengerRow$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            SwipeToDeleteKt.SwipeToDelete((Function0) rememberedValue, false, ComposableLambdaKt.rememberComposableLambda(-1644611127, true, new ProfilePassengerRowKt$ProfilePassengerRow$2(passenger, navigateToEdit), startRestartGroup, 54), startRestartGroup, 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: Q3.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfilePassengerRow$lambda$2;
                    ProfilePassengerRow$lambda$2 = ProfilePassengerRowKt.ProfilePassengerRow$lambda$2(UserPassenger.this, navigateToEdit, triggerDeleteFlow, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfilePassengerRow$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfilePassengerRow$lambda$1$lambda$0(Function1 function1, UserPassenger userPassenger) {
        function1.invoke(userPassenger);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfilePassengerRow$lambda$2(UserPassenger userPassenger, Function1 function1, Function1 function12, int i5, Composer composer, int i6) {
        ProfilePassengerRow(userPassenger, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
