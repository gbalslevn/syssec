package dk.molslinjen.ui.views.reusable.dialog;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.ui.views.reusable.dialog.TextDialogKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a_\u0010\f\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {BuildConfig.FLAVOR, Constants.IntentExtra.PushTitle, "description", "Ldk/molslinjen/ui/views/reusable/dialog/SimpleButtonData;", "primaryButton", "destructiveButton", "secondaryButton", BuildConfig.FLAVOR, "dismissible", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onDismissRequest", "TextDialog", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/ui/views/reusable/dialog/SimpleButtonData;Ldk/molslinjen/ui/views/reusable/dialog/SimpleButtonData;Ldk/molslinjen/ui/views/reusable/dialog/SimpleButtonData;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TextDialogKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextDialog(final String title, String str, SimpleButtonData simpleButtonData, SimpleButtonData simpleButtonData2, SimpleButtonData simpleButtonData3, boolean z5, final Function0<Unit> onDismissRequest, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        SimpleButtonData simpleButtonData4;
        int i9;
        SimpleButtonData simpleButtonData5;
        int i10;
        SimpleButtonData simpleButtonData6;
        int i11;
        boolean z6;
        final SimpleButtonData simpleButtonData7;
        final String str2;
        final boolean z7;
        final SimpleButtonData simpleButtonData8;
        final SimpleButtonData simpleButtonData9;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer startRestartGroup = composer.startRestartGroup(-262270283);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(title) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i12 = i6 & 2;
        if (i12 != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(str) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 384) == 0) {
                simpleButtonData4 = simpleButtonData;
                i7 |= startRestartGroup.changed(simpleButtonData4) ? 256 : 128;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i5 & 3072) == 0) {
                    simpleButtonData5 = simpleButtonData2;
                    i7 |= startRestartGroup.changed(simpleButtonData5) ? 2048 : 1024;
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 24576;
                    } else if ((i5 & 24576) == 0) {
                        simpleButtonData6 = simpleButtonData3;
                        i7 |= startRestartGroup.changed(simpleButtonData6) ? 16384 : 8192;
                        i11 = i6 & 32;
                        if (i11 != 0) {
                            i7 |= 196608;
                            z6 = z5;
                        } else {
                            z6 = z5;
                            if ((i5 & 196608) == 0) {
                                i7 |= startRestartGroup.changed(z6) ? 131072 : 65536;
                            }
                        }
                        if ((i6 & 64) != 0) {
                            i7 |= 1572864;
                        } else if ((i5 & 1572864) == 0) {
                            i7 |= startRestartGroup.changedInstance(onDismissRequest) ? 1048576 : 524288;
                        }
                        if ((i7 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                            String str3 = i12 != 0 ? null : str;
                            SimpleButtonData simpleButtonData10 = i8 != 0 ? null : simpleButtonData4;
                            SimpleButtonData simpleButtonData11 = i9 != 0 ? null : simpleButtonData5;
                            SimpleButtonData simpleButtonData12 = i10 == 0 ? simpleButtonData6 : null;
                            if (i11 != 0) {
                                z6 = true;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-262270283, i7, -1, "dk.molslinjen.ui.views.reusable.dialog.TextDialog (TextDialog.kt:25)");
                            }
                            int i13 = i7 >> 6;
                            String str4 = str3;
                            CustomDialogKt.CustomDialog(simpleButtonData10, simpleButtonData11, simpleButtonData12, onDismissRequest, z6, ComposableLambdaKt.rememberComposableLambda(1043973530, true, new TextDialogKt$TextDialog$1(title, str3), startRestartGroup, 54), startRestartGroup, (i13 & 896) | (i13 & 14) | 196608 | (i13 & 112) | ((i7 >> 9) & 7168) | ((i7 >> 3) & 57344), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            simpleButtonData7 = simpleButtonData12;
                            str2 = str4;
                            z7 = z6;
                            simpleButtonData8 = simpleButtonData10;
                            simpleButtonData9 = simpleButtonData11;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            str2 = str;
                            simpleButtonData8 = simpleButtonData4;
                            simpleButtonData9 = simpleButtonData5;
                            simpleButtonData7 = simpleButtonData6;
                            z7 = z6;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: b2.j
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit TextDialog$lambda$0;
                                    TextDialog$lambda$0 = TextDialogKt.TextDialog$lambda$0(title, str2, simpleButtonData8, simpleButtonData9, simpleButtonData7, z7, onDismissRequest, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                    return TextDialog$lambda$0;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    simpleButtonData6 = simpleButtonData3;
                    i11 = i6 & 32;
                    if (i11 != 0) {
                    }
                    if ((i6 & 64) != 0) {
                    }
                    if ((i7 & 599187) == 599186) {
                    }
                    if (i12 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 == 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i132 = i7 >> 6;
                    String str42 = str3;
                    CustomDialogKt.CustomDialog(simpleButtonData10, simpleButtonData11, simpleButtonData12, onDismissRequest, z6, ComposableLambdaKt.rememberComposableLambda(1043973530, true, new TextDialogKt$TextDialog$1(title, str3), startRestartGroup, 54), startRestartGroup, (i132 & 896) | (i132 & 14) | 196608 | (i132 & 112) | ((i7 >> 9) & 7168) | ((i7 >> 3) & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    simpleButtonData7 = simpleButtonData12;
                    str2 = str42;
                    z7 = z6;
                    simpleButtonData8 = simpleButtonData10;
                    simpleButtonData9 = simpleButtonData11;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                simpleButtonData5 = simpleButtonData2;
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                simpleButtonData6 = simpleButtonData3;
                i11 = i6 & 32;
                if (i11 != 0) {
                }
                if ((i6 & 64) != 0) {
                }
                if ((i7 & 599187) == 599186) {
                }
                if (i12 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 == 0) {
                }
                if (i11 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1322 = i7 >> 6;
                String str422 = str3;
                CustomDialogKt.CustomDialog(simpleButtonData10, simpleButtonData11, simpleButtonData12, onDismissRequest, z6, ComposableLambdaKt.rememberComposableLambda(1043973530, true, new TextDialogKt$TextDialog$1(title, str3), startRestartGroup, 54), startRestartGroup, (i1322 & 896) | (i1322 & 14) | 196608 | (i1322 & 112) | ((i7 >> 9) & 7168) | ((i7 >> 3) & 57344), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                simpleButtonData7 = simpleButtonData12;
                str2 = str422;
                z7 = z6;
                simpleButtonData8 = simpleButtonData10;
                simpleButtonData9 = simpleButtonData11;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            simpleButtonData4 = simpleButtonData;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            simpleButtonData5 = simpleButtonData2;
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            simpleButtonData6 = simpleButtonData3;
            i11 = i6 & 32;
            if (i11 != 0) {
            }
            if ((i6 & 64) != 0) {
            }
            if ((i7 & 599187) == 599186) {
            }
            if (i12 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 == 0) {
            }
            if (i11 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i13222 = i7 >> 6;
            String str4222 = str3;
            CustomDialogKt.CustomDialog(simpleButtonData10, simpleButtonData11, simpleButtonData12, onDismissRequest, z6, ComposableLambdaKt.rememberComposableLambda(1043973530, true, new TextDialogKt$TextDialog$1(title, str3), startRestartGroup, 54), startRestartGroup, (i13222 & 896) | (i13222 & 14) | 196608 | (i13222 & 112) | ((i7 >> 9) & 7168) | ((i7 >> 3) & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            simpleButtonData7 = simpleButtonData12;
            str2 = str4222;
            z7 = z6;
            simpleButtonData8 = simpleButtonData10;
            simpleButtonData9 = simpleButtonData11;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        simpleButtonData4 = simpleButtonData;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        simpleButtonData5 = simpleButtonData2;
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        simpleButtonData6 = simpleButtonData3;
        i11 = i6 & 32;
        if (i11 != 0) {
        }
        if ((i6 & 64) != 0) {
        }
        if ((i7 & 599187) == 599186) {
        }
        if (i12 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 == 0) {
        }
        if (i11 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        int i132222 = i7 >> 6;
        String str42222 = str3;
        CustomDialogKt.CustomDialog(simpleButtonData10, simpleButtonData11, simpleButtonData12, onDismissRequest, z6, ComposableLambdaKt.rememberComposableLambda(1043973530, true, new TextDialogKt$TextDialog$1(title, str3), startRestartGroup, 54), startRestartGroup, (i132222 & 896) | (i132222 & 14) | 196608 | (i132222 & 112) | ((i7 >> 9) & 7168) | ((i7 >> 3) & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        simpleButtonData7 = simpleButtonData12;
        str2 = str42222;
        z7 = z6;
        simpleButtonData8 = simpleButtonData10;
        simpleButtonData9 = simpleButtonData11;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextDialog$lambda$0(String str, String str2, SimpleButtonData simpleButtonData, SimpleButtonData simpleButtonData2, SimpleButtonData simpleButtonData3, boolean z5, Function0 function0, int i5, int i6, Composer composer, int i7) {
        TextDialog(str, str2, simpleButtonData, simpleButtonData2, simpleButtonData3, z5, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
