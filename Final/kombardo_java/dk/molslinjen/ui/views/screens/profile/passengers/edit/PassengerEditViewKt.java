package dk.molslinjen.ui.views.screens.profile.passengers.edit;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.buttons.IconTextButtonKt;
import dk.molslinjen.ui.views.screens.profile.passengers.edit.PassengerEditViewKt;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.IPassengerInputHandler;
import dk.molslinjen.ui.views.screens.profile.passengers.shared.ProfilePassengerInputContentKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001ae\u0010\u000e\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/layout/ColumnScope;", "Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler;", "inputHandler", BuildConfig.FLAVOR, "deleteTitle", BuildConfig.FLAVOR, "isLoading", "submitFieldsTrigger", "Lkotlin/Function0;", BuildConfig.FLAVOR, "triggerDeleteFlow", "Lkotlin/Function1;", "onFormValidationChange", "navigateToNationalitySelection", "PassengerEditView", "(Landroidx/compose/foundation/layout/ColumnScope;Ldk/molslinjen/ui/views/screens/profile/passengers/shared/IPassengerInputHandler;IZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PassengerEditViewKt {
    public static final void PassengerEditView(final ColumnScope columnScope, final IPassengerInputHandler inputHandler, final int i5, final boolean z5, final boolean z6, final Function0<Unit> triggerDeleteFlow, final Function1<? super Boolean, Unit> onFormValidationChange, final Function0<Unit> navigateToNationalitySelection, Composer composer, final int i6) {
        int i7;
        Composer composer2;
        Intrinsics.checkNotNullParameter(columnScope, "<this>");
        Intrinsics.checkNotNullParameter(inputHandler, "inputHandler");
        Intrinsics.checkNotNullParameter(triggerDeleteFlow, "triggerDeleteFlow");
        Intrinsics.checkNotNullParameter(onFormValidationChange, "onFormValidationChange");
        Intrinsics.checkNotNullParameter(navigateToNationalitySelection, "navigateToNationalitySelection");
        Composer startRestartGroup = composer.startRestartGroup(-506846378);
        if ((i6 & 48) == 0) {
            i7 = ((i6 & 64) == 0 ? startRestartGroup.changed(inputHandler) : startRestartGroup.changedInstance(inputHandler) ? 32 : 16) | i6;
        } else {
            i7 = i6;
        }
        if ((i6 & 384) == 0) {
            i7 |= startRestartGroup.changed(i5) ? 256 : 128;
        }
        if ((i6 & 3072) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 2048 : 1024;
        }
        if ((i6 & 24576) == 0) {
            i7 |= startRestartGroup.changed(z6) ? 16384 : 8192;
        }
        if ((196608 & i6) == 0) {
            i7 |= startRestartGroup.changedInstance(triggerDeleteFlow) ? 131072 : 65536;
        }
        if ((1572864 & i6) == 0) {
            i7 |= startRestartGroup.changedInstance(onFormValidationChange) ? 1048576 : 524288;
        }
        if ((12582912 & i6) == 0) {
            i7 |= startRestartGroup.changedInstance(navigateToNationalitySelection) ? 8388608 : 4194304;
        }
        int i8 = i7;
        if ((4793489 & i8) == 4793488 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-506846378, i8, -1, "dk.molslinjen.ui.views.screens.profile.passengers.edit.PassengerEditView (PassengerEditView.kt:26)");
            }
            float f5 = 24;
            composer2 = startRestartGroup;
            IconTextButtonKt.m3404IconTextButtonV9fs2A(PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), 2, null), triggerDeleteFlow, R.drawable.icon_delete, i5, !z5, AppColor.INSTANCE.m3272getSignalRed0d7_KjU(), startRestartGroup, ((i8 >> 12) & 112) | 196998 | ((i8 << 3) & 7168), 0);
            int i9 = i8 >> 3;
            ProfilePassengerInputContentKt.ProfilePassengerInputContent(null, inputHandler, z5, z6, null, onFormValidationChange, navigateToNationalitySelection, composer2, (i8 & 112) | (i9 & 896) | (i9 & 7168) | (458752 & i9) | (i9 & 3670016), 17);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: R3.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PassengerEditView$lambda$0;
                    PassengerEditView$lambda$0 = PassengerEditViewKt.PassengerEditView$lambda$0(ColumnScope.this, inputHandler, i5, z5, z6, triggerDeleteFlow, onFormValidationChange, navigateToNationalitySelection, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return PassengerEditView$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PassengerEditView$lambda$0(ColumnScope columnScope, IPassengerInputHandler iPassengerInputHandler, int i5, boolean z5, boolean z6, Function0 function0, Function1 function1, Function0 function02, int i6, Composer composer, int i7) {
        PassengerEditView(columnScope, iPassengerInputHandler, i5, z5, z6, function0, function1, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1));
        return Unit.INSTANCE;
    }
}
