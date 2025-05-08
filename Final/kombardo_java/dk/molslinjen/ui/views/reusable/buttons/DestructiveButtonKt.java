package dk.molslinjen.ui.views.reusable.buttons;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import dk.molslinjen.ui.views.reusable.buttons.ButtonStyle;
import dk.molslinjen.ui.views.reusable.buttons.DestructiveButtonKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a_\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "text", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onClick", "onClickDisabled", "Ldk/molslinjen/ui/views/reusable/buttons/ButtonConfig;", "buttonConfig", BuildConfig.FLAVOR, "enabled", "isLoading", "DestructiveButton", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ldk/molslinjen/ui/views/reusable/buttons/ButtonConfig;ZZLandroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DestructiveButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DestructiveButton(Modifier modifier, final String text, final Function0<Unit> onClick, Function0<Unit> function0, ButtonConfig buttonConfig, boolean z5, boolean z6, Composer composer, final int i5, final int i6) {
        int i7;
        Function0<Unit> function02;
        int i8;
        ButtonConfig buttonConfig2;
        int i9;
        boolean z7;
        int i10;
        boolean z8;
        Composer composer2;
        final Modifier modifier2;
        final Function0<Unit> function03;
        final ButtonConfig buttonConfig3;
        final boolean z9;
        final boolean z10;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-1903007166);
        int i11 = i6 & 1;
        if (i11 != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(text) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        int i12 = i6 & 8;
        if (i12 != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            function02 = function0;
            i7 |= startRestartGroup.changedInstance(function02) ? 2048 : 1024;
            i8 = i6 & 16;
            if (i8 == 0) {
                i7 |= 24576;
            } else if ((i5 & 24576) == 0) {
                buttonConfig2 = buttonConfig;
                i7 |= startRestartGroup.changed(buttonConfig2) ? 16384 : 8192;
                i9 = i6 & 32;
                if (i9 != 0) {
                    i7 |= 196608;
                } else if ((196608 & i5) == 0) {
                    z7 = z5;
                    i7 |= startRestartGroup.changed(z7) ? 131072 : 65536;
                    i10 = i6 & 64;
                    if (i10 == 0) {
                        i7 |= 1572864;
                    } else if ((1572864 & i5) == 0) {
                        z8 = z6;
                        i7 |= startRestartGroup.changed(z8) ? 1048576 : 524288;
                        if ((i7 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                            Modifier modifier3 = i11 != 0 ? Modifier.INSTANCE : modifier;
                            Function0<Unit> function04 = i12 != 0 ? null : function02;
                            ButtonConfig buttonConfig4 = i8 != 0 ? ButtonConfig.Regular : buttonConfig2;
                            boolean z11 = i9 != 0 ? true : z7;
                            boolean z12 = i10 != 0 ? false : z8;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1903007166, i7, -1, "dk.molslinjen.ui.views.reusable.buttons.DestructiveButton (DestructiveButton.kt:17)");
                            }
                            composer2 = startRestartGroup;
                            BaseButtonKt.BaseButton(modifier3, text, onClick, function04, ButtonStyle.Destructive.INSTANCE, buttonConfig4, z12, z11, null, null, null, null, false, false, composer2, (i7 & 14) | 24576 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | ((i7 << 3) & 458752) | (3670016 & i7) | (29360128 & (i7 << 6)), 0, 16128);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier3;
                            function03 = function04;
                            buttonConfig3 = buttonConfig4;
                            z9 = z11;
                            z10 = z12;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            composer2 = startRestartGroup;
                            function03 = function02;
                            buttonConfig3 = buttonConfig2;
                            z9 = z7;
                            z10 = z8;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: Z1.e
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit DestructiveButton$lambda$0;
                                    DestructiveButton$lambda$0 = DestructiveButtonKt.DestructiveButton$lambda$0(Modifier.this, text, onClick, function03, buttonConfig3, z9, z10, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                    return DestructiveButton$lambda$0;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    z8 = z6;
                    if ((i7 & 599187) == 599186) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    BaseButtonKt.BaseButton(modifier3, text, onClick, function04, ButtonStyle.Destructive.INSTANCE, buttonConfig4, z12, z11, null, null, null, null, false, false, composer2, (i7 & 14) | 24576 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | ((i7 << 3) & 458752) | (3670016 & i7) | (29360128 & (i7 << 6)), 0, 16128);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier2 = modifier3;
                    function03 = function04;
                    buttonConfig3 = buttonConfig4;
                    z9 = z11;
                    z10 = z12;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z7 = z5;
                i10 = i6 & 64;
                if (i10 == 0) {
                }
                z8 = z6;
                if ((i7 & 599187) == 599186) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                BaseButtonKt.BaseButton(modifier3, text, onClick, function04, ButtonStyle.Destructive.INSTANCE, buttonConfig4, z12, z11, null, null, null, null, false, false, composer2, (i7 & 14) | 24576 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | ((i7 << 3) & 458752) | (3670016 & i7) | (29360128 & (i7 << 6)), 0, 16128);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = modifier3;
                function03 = function04;
                buttonConfig3 = buttonConfig4;
                z9 = z11;
                z10 = z12;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            buttonConfig2 = buttonConfig;
            i9 = i6 & 32;
            if (i9 != 0) {
            }
            z7 = z5;
            i10 = i6 & 64;
            if (i10 == 0) {
            }
            z8 = z6;
            if ((i7 & 599187) == 599186) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            BaseButtonKt.BaseButton(modifier3, text, onClick, function04, ButtonStyle.Destructive.INSTANCE, buttonConfig4, z12, z11, null, null, null, null, false, false, composer2, (i7 & 14) | 24576 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | ((i7 << 3) & 458752) | (3670016 & i7) | (29360128 & (i7 << 6)), 0, 16128);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier3;
            function03 = function04;
            buttonConfig3 = buttonConfig4;
            z9 = z11;
            z10 = z12;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function02 = function0;
        i8 = i6 & 16;
        if (i8 == 0) {
        }
        buttonConfig2 = buttonConfig;
        i9 = i6 & 32;
        if (i9 != 0) {
        }
        z7 = z5;
        i10 = i6 & 64;
        if (i10 == 0) {
        }
        z8 = z6;
        if ((i7 & 599187) == 599186) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        BaseButtonKt.BaseButton(modifier3, text, onClick, function04, ButtonStyle.Destructive.INSTANCE, buttonConfig4, z12, z11, null, null, null, null, false, false, composer2, (i7 & 14) | 24576 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | ((i7 << 3) & 458752) | (3670016 & i7) | (29360128 & (i7 << 6)), 0, 16128);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier3;
        function03 = function04;
        buttonConfig3 = buttonConfig4;
        z9 = z11;
        z10 = z12;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DestructiveButton$lambda$0(Modifier modifier, String str, Function0 function0, Function0 function02, ButtonConfig buttonConfig, boolean z5, boolean z6, int i5, int i6, Composer composer, int i7) {
        DestructiveButton(modifier, str, function0, function02, buttonConfig, z5, z6, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
