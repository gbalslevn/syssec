package dk.molslinjen.ui.views.screens.profile.vehicles.shared;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.res.StringResources_androidKt;
import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.dialog.DeleteDialogKt;
import dk.molslinjen.ui.views.screens.profile.vehicles.shared.VehicleDeleteDialogKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a;\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/account/UserVehicle;", "vehicle", BuildConfig.FLAVOR, "isLoading", "Lkotlin/Function0;", BuildConfig.FLAVOR, "deleteCallback", "dismissCallback", "VehicleDeleteDialog", "(Ldk/molslinjen/domain/model/account/UserVehicle;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class VehicleDeleteDialogKt {
    public static final void VehicleDeleteDialog(final UserVehicle vehicle, final boolean z5, final Function0<Unit> deleteCallback, final Function0<Unit> dismissCallback, Composer composer, final int i5) {
        int i6;
        String str;
        Intrinsics.checkNotNullParameter(vehicle, "vehicle");
        Intrinsics.checkNotNullParameter(deleteCallback, "deleteCallback");
        Intrinsics.checkNotNullParameter(dismissCallback, "dismissCallback");
        Composer startRestartGroup = composer.startRestartGroup(1432062269);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(vehicle) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(deleteCallback) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(dismissCallback) ? 2048 : 1024;
        }
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1432062269, i6, -1, "dk.molslinjen.ui.views.screens.profile.vehicles.shared.VehicleDeleteDialog (VehicleDeleteDialog.kt:15)");
            }
            startRestartGroup.startReplaceGroup(192057871);
            if (StringsKt.isBlank(vehicle.getManufacturer()) && StringsKt.isBlank(vehicle.getModel())) {
                str = StringResources_androidKt.stringResource(R.string.profile_vehicle_deleteDialog_vehiclePlaceholder, startRestartGroup, 6);
            } else {
                str = vehicle.getManufacturer() + " " + vehicle.getModel();
            }
            startRestartGroup.endReplaceGroup();
            DeleteDialogKt.DeleteDialog(StringResources_androidKt.stringResource(R.string.profile_vehicle_deleteDialog_title, new Object[]{str, vehicle.getLicensePlate()}, startRestartGroup, 6), null, StringResources_androidKt.stringResource(R.string.profile_vehicle_delete, startRestartGroup, 6), null, z5, deleteCallback, dismissCallback, startRestartGroup, (i6 << 9) & 4186112, 10);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: d4.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit VehicleDeleteDialog$lambda$0;
                    VehicleDeleteDialog$lambda$0 = VehicleDeleteDialogKt.VehicleDeleteDialog$lambda$0(UserVehicle.this, z5, deleteCallback, dismissCallback, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return VehicleDeleteDialog$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VehicleDeleteDialog$lambda$0(UserVehicle userVehicle, boolean z5, Function0 function0, Function0 function02, int i5, Composer composer, int i6) {
        VehicleDeleteDialog(userVehicle, z5, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
