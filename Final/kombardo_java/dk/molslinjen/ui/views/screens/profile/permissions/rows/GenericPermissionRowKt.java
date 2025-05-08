package dk.molslinjen.ui.views.screens.profile.permissions.rows;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import com.google.accompanist.permissions.MultiplePermissionsState;
import com.google.accompanist.permissions.MultiplePermissionsStateKt;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.ui.views.screens.profile.permissions.AppPermission;
import dk.molslinjen.ui.views.screens.profile.permissions.rows.GenericPermissionRowKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ao\u0010\t\u001a\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00002\u0006\u0010\u0005\u001a\u00020\u00012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062$\u0010\b\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0004\u0012\u00020\u00030\u0000H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r²\u0006\u0010\u0010\f\u001a\u0004\u0018\u00010\u000b8\n@\nX\u008a\u008e\u0002"}, d2 = {"Lkotlin/Function2;", "Ldk/molslinjen/ui/views/screens/profile/permissions/AppPermission;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "showDialog", "permission", "Lkotlin/Function1;", "permissionChanged", "content", "GenericPermissionRow", "(Lkotlin/jvm/functions/Function2;Ldk/molslinjen/ui/views/screens/profile/permissions/AppPermission;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "Lorg/threeten/bp/LocalTime;", "lastPermissionRequestTime", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class GenericPermissionRowKt {
    /* JADX WARN: Removed duplicated region for block: B:13:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void GenericPermissionRow(final Function2<? super AppPermission, ? super Boolean, Unit> showDialog, final AppPermission permission, Function1<? super Boolean, Unit> function1, final Function4<? super Boolean, ? super Function1<? super Boolean, Unit>, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i5, final int i6) {
        int i7;
        Function1<? super Boolean, Unit> function12;
        int i8;
        Object rememberedValue;
        Composer.Companion companion;
        boolean changed;
        Object rememberedValue2;
        boolean changed2;
        Object rememberedValue3;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(showDialog, "showDialog");
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(2088373053);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(showDialog) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(permission) ? 32 : 16;
        }
        int i9 = i6 & 4;
        if (i9 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            function12 = function1;
            i7 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
            if ((i6 & 8) == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                i7 |= startRestartGroup.changedInstance(content) ? 2048 : 1024;
            }
            i8 = i7;
            if ((i8 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                Function1<? super Boolean, Unit> function13 = i9 == 0 ? null : function12;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2088373053, i8, -1, "dk.molslinjen.ui.views.screens.profile.permissions.rows.GenericPermissionRow (GenericPermissionRow.kt:20)");
                }
                Object[] objArr = new Object[0];
                startRestartGroup.startReplaceGroup(1611877017);
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: V3.b
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            MutableState GenericPermissionRow$lambda$1$lambda$0;
                            GenericPermissionRow$lambda$1$lambda$0 = GenericPermissionRowKt.GenericPermissionRow$lambda$1$lambda$0();
                            return GenericPermissionRow$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                final Function1<? super Boolean, Unit> function14 = function13;
                final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, null, null, (Function0) rememberedValue, startRestartGroup, 3072, 6);
                List<String> permissions = permission.getPermissions();
                startRestartGroup.startReplaceGroup(1611881736);
                int i10 = i8 & 14;
                int i11 = i8 & 112;
                changed = startRestartGroup.changed(mutableState) | (i10 != 4) | (i11 != 32) | ((i8 & 896) != 256);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed || rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: V3.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit GenericPermissionRow$lambda$6$lambda$5;
                            GenericPermissionRow$lambda$6$lambda$5 = GenericPermissionRowKt.GenericPermissionRow$lambda$6$lambda$5(Function2.this, permission, function14, mutableState, (Map) obj);
                            return GenericPermissionRow$lambda$6$lambda$5;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                final MultiplePermissionsState rememberMultiplePermissionsState = MultiplePermissionsStateKt.rememberMultiplePermissionsState(permissions, (Function1) rememberedValue2, startRestartGroup, 0, 0);
                Boolean valueOf = Boolean.valueOf(rememberMultiplePermissionsState.getAllPermissionsGranted());
                startRestartGroup.startReplaceGroup(1611896414);
                changed2 = (i10 != 4) | startRestartGroup.changed(mutableState) | startRestartGroup.changed(rememberMultiplePermissionsState) | (i11 != 32);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed2 || rememberedValue3 == companion.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: V3.d
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit GenericPermissionRow$lambda$8$lambda$7;
                            GenericPermissionRow$lambda$8$lambda$7 = GenericPermissionRowKt.GenericPermissionRow$lambda$8$lambda$7(MultiplePermissionsState.this, showDialog, permission, mutableState, ((Boolean) obj).booleanValue());
                            return GenericPermissionRow$lambda$8$lambda$7;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                content.invoke(valueOf, (Function1) rememberedValue3, startRestartGroup, Integer.valueOf((i8 >> 3) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function12 = function14;
            } else {
                startRestartGroup.skipToGroupEnd();
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Function1<? super Boolean, Unit> function15 = function12;
                endRestartGroup.updateScope(new Function2() { // from class: V3.e
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit GenericPermissionRow$lambda$9;
                        GenericPermissionRow$lambda$9 = GenericPermissionRowKt.GenericPermissionRow$lambda$9(Function2.this, permission, function15, content, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return GenericPermissionRow$lambda$9;
                    }
                });
                return;
            }
            return;
        }
        function12 = function1;
        if ((i6 & 8) == 0) {
        }
        i8 = i7;
        if ((i8 & 1171) == 1170) {
        }
        if (i9 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Object[] objArr2 = new Object[0];
        startRestartGroup.startReplaceGroup(1611877017);
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        startRestartGroup.endReplaceGroup();
        final Function1 function142 = function13;
        final MutableState mutableState2 = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, null, null, (Function0) rememberedValue, startRestartGroup, 3072, 6);
        List<String> permissions2 = permission.getPermissions();
        startRestartGroup.startReplaceGroup(1611881736);
        int i102 = i8 & 14;
        int i112 = i8 & 112;
        changed = startRestartGroup.changed(mutableState2) | (i102 != 4) | (i112 != 32) | ((i8 & 896) != 256);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue2 = new Function1() { // from class: V3.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit GenericPermissionRow$lambda$6$lambda$5;
                GenericPermissionRow$lambda$6$lambda$5 = GenericPermissionRowKt.GenericPermissionRow$lambda$6$lambda$5(Function2.this, permission, function142, mutableState2, (Map) obj);
                return GenericPermissionRow$lambda$6$lambda$5;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceGroup();
        final MultiplePermissionsState rememberMultiplePermissionsState2 = MultiplePermissionsStateKt.rememberMultiplePermissionsState(permissions2, (Function1) rememberedValue2, startRestartGroup, 0, 0);
        Boolean valueOf2 = Boolean.valueOf(rememberMultiplePermissionsState2.getAllPermissionsGranted());
        startRestartGroup.startReplaceGroup(1611896414);
        changed2 = (i102 != 4) | startRestartGroup.changed(mutableState2) | startRestartGroup.changed(rememberMultiplePermissionsState2) | (i112 != 32);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue3 = new Function1() { // from class: V3.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit GenericPermissionRow$lambda$8$lambda$7;
                GenericPermissionRow$lambda$8$lambda$7 = GenericPermissionRowKt.GenericPermissionRow$lambda$8$lambda$7(MultiplePermissionsState.this, showDialog, permission, mutableState2, ((Boolean) obj).booleanValue());
                return GenericPermissionRow$lambda$8$lambda$7;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceGroup();
        content.invoke(valueOf2, (Function1) rememberedValue3, startRestartGroup, Integer.valueOf((i8 >> 3) & 896));
        if (ComposerKt.isTraceInProgress()) {
        }
        function12 = function142;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState GenericPermissionRow$lambda$1$lambda$0() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        return mutableStateOf$default;
    }

    private static final LocalTime GenericPermissionRow$lambda$2(MutableState<LocalTime> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GenericPermissionRow$lambda$6$lambda$5(Function2 function2, AppPermission appPermission, Function1 function1, MutableState mutableState, Map isGrantedMap) {
        Intrinsics.checkNotNullParameter(isGrantedMap, "isGrantedMap");
        LocalTime GenericPermissionRow$lambda$2 = GenericPermissionRow$lambda$2(mutableState);
        boolean z5 = true;
        if (!isGrantedMap.isEmpty()) {
            Iterator it = isGrantedMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (!((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                    z5 = false;
                    break;
                }
            }
        }
        if (!z5 && GenericPermissionRow$lambda$2 != null && GenericPermissionRow$lambda$2.isAfter(Constants.Permissions.INSTANCE.getMaxResponseCheckupTimePermanentlyDeclined())) {
            function2.invoke(appPermission, Boolean.FALSE);
        }
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z5));
        }
        mutableState.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GenericPermissionRow$lambda$8$lambda$7(MultiplePermissionsState multiplePermissionsState, Function2 function2, AppPermission appPermission, MutableState mutableState, boolean z5) {
        boolean z6 = (GenericPermissionRow$lambda$2(mutableState) == null || multiplePermissionsState.getShouldShowRationale()) ? false : true;
        if (multiplePermissionsState.getAllPermissionsGranted()) {
            function2.invoke(appPermission, Boolean.TRUE);
        } else if (z6) {
            function2.invoke(appPermission, Boolean.FALSE);
        } else {
            mutableState.setValue(LocalTime.now());
            multiplePermissionsState.launchMultiplePermissionRequest();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GenericPermissionRow$lambda$9(Function2 function2, AppPermission appPermission, Function1 function1, Function4 function4, int i5, int i6, Composer composer, int i7) {
        GenericPermissionRow(function2, appPermission, function1, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
