package dk.molslinjen.ui.views.reusable.dialog;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.res.StringResources_androidKt;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.dialog.DeleteDialogKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001aY\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {BuildConfig.FLAVOR, Constants.IntentExtra.PushTitle, "description", "deleteButtonTitle", "cancelButtonTitle", BuildConfig.FLAVOR, "isLoading", "Lkotlin/Function0;", BuildConfig.FLAVOR, "deleteCallback", "dismissCallback", "DeleteDialog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DeleteDialogKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DeleteDialog(final String title, String str, final String deleteButtonTitle, String str2, final boolean z5, final Function0<Unit> deleteCallback, final Function0<Unit> dismissCallback, Composer composer, final int i5, final int i6) {
        int i7;
        String str3;
        final String str4;
        int i8;
        String str5;
        String stringResource;
        Composer composer2;
        final String str6;
        int i9;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(deleteButtonTitle, "deleteButtonTitle");
        Intrinsics.checkNotNullParameter(deleteCallback, "deleteCallback");
        Intrinsics.checkNotNullParameter(dismissCallback, "dismissCallback");
        Composer startRestartGroup = composer.startRestartGroup(-1906750663);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(title) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i10 = i6 & 2;
        if (i10 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            str3 = str;
            i7 |= startRestartGroup.changed(str3) ? 32 : 16;
            if ((i6 & 4) == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                i7 |= startRestartGroup.changed(deleteButtonTitle) ? 256 : 128;
            }
            if ((i5 & 3072) != 0) {
                if ((i6 & 8) == 0) {
                    str4 = str2;
                    if (startRestartGroup.changed(str4)) {
                        i9 = 2048;
                        i7 |= i9;
                    }
                } else {
                    str4 = str2;
                }
                i9 = 1024;
                i7 |= i9;
            } else {
                str4 = str2;
            }
            if ((i6 & 16) == 0) {
                i7 |= 24576;
            } else if ((i5 & 24576) == 0) {
                i7 |= startRestartGroup.changed(z5) ? 16384 : 8192;
            }
            if ((i6 & 32) == 0) {
                i7 |= 196608;
            } else if ((i5 & 196608) == 0) {
                i7 |= startRestartGroup.changedInstance(deleteCallback) ? 131072 : 65536;
            }
            if ((i6 & 64) == 0) {
                i7 |= 1572864;
            } else if ((i5 & 1572864) == 0) {
                i7 |= startRestartGroup.changedInstance(dismissCallback) ? 1048576 : 524288;
            }
            if ((599187 & i7) == 599186 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i5 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    String str7 = i10 == 0 ? null : str3;
                    if ((i6 & 8) == 0) {
                        i8 = i7 & (-7169);
                        str5 = str7;
                        stringResource = StringResources_androidKt.stringResource(R.string.button_cancel, startRestartGroup, 6);
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1906750663, i8, -1, "dk.molslinjen.ui.views.reusable.dialog.DeleteDialog (DeleteDialog.kt:16)");
                        }
                        composer2 = startRestartGroup;
                        TextDialogKt.TextDialog(title, str5, null, new SimpleButtonData(deleteButtonTitle, z5, false, deleteCallback, 4, null), new SimpleButtonData(stringResource, false, !z5, dismissCallback, 2, null), false, dismissCallback, startRestartGroup, i8 & 3670142, 36);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str6 = str5;
                        str4 = stringResource;
                    } else {
                        i8 = i7;
                        str5 = str7;
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i6 & 8) != 0) {
                        i7 &= -7169;
                    }
                    i8 = i7;
                    str5 = str3;
                }
                stringResource = str4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                TextDialogKt.TextDialog(title, str5, null, new SimpleButtonData(deleteButtonTitle, z5, false, deleteCallback, 4, null), new SimpleButtonData(stringResource, false, !z5, dismissCallback, 2, null), false, dismissCallback, startRestartGroup, i8 & 3670142, 36);
                if (ComposerKt.isTraceInProgress()) {
                }
                str6 = str5;
                str4 = stringResource;
            } else {
                startRestartGroup.skipToGroupEnd();
                str6 = str3;
                composer2 = startRestartGroup;
            }
            ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new Function2() { // from class: b2.g
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit DeleteDialog$lambda$0;
                        DeleteDialog$lambda$0 = DeleteDialogKt.DeleteDialog$lambda$0(title, str6, deleteButtonTitle, str4, z5, deleteCallback, dismissCallback, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return DeleteDialog$lambda$0;
                    }
                });
                return;
            }
            return;
        }
        str3 = str;
        if ((i6 & 4) == 0) {
        }
        if ((i5 & 3072) != 0) {
        }
        if ((i6 & 16) == 0) {
        }
        if ((i6 & 32) == 0) {
        }
        if ((i6 & 64) == 0) {
        }
        if ((599187 & i7) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) != 0) {
        }
        if (i10 == 0) {
        }
        if ((i6 & 8) == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeleteDialog$lambda$0(String str, String str2, String str3, String str4, boolean z5, Function0 function0, Function0 function02, int i5, int i6, Composer composer, int i7) {
        DeleteDialog(str, str2, str3, str4, z5, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
