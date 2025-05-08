package dk.molslinjen.ui.views.reusable.buttons;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import dk.molslinjen.ui.views.reusable.buttons.ButtonStyle;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001ai\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "text", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onClick", "onClickDisabled", "Ldk/molslinjen/ui/views/reusable/buttons/ButtonConfig;", "buttonConfig", BuildConfig.FLAVOR, "enabled", "isLoading", "autoShrinkText", "PrimaryButton", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ldk/molslinjen/ui/views/reusable/buttons/ButtonConfig;ZZZLandroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PrimaryButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PrimaryButton(Modifier modifier, final String text, final Function0<Unit> onClick, Function0<Unit> function0, ButtonConfig buttonConfig, boolean z5, boolean z6, boolean z7, Composer composer, final int i5, final int i6) {
        int i7;
        Function0<Unit> function02;
        int i8;
        ButtonConfig buttonConfig2;
        int i9;
        boolean z8;
        int i10;
        int i11;
        Composer composer2;
        final Modifier modifier2;
        final Function0<Unit> function03;
        final ButtonConfig buttonConfig3;
        final boolean z9;
        final boolean z10;
        final boolean z11;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(1480445158);
        int i12 = i6 & 1;
        if (i12 != 0) {
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
        int i13 = i6 & 8;
        if (i13 != 0) {
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
                    z8 = z5;
                    i7 |= startRestartGroup.changed(z8) ? 131072 : 65536;
                    i10 = i6 & 64;
                    if (i10 == 0) {
                        i7 |= 1572864;
                    } else if ((i5 & 1572864) == 0) {
                        i7 |= startRestartGroup.changed(z6) ? 1048576 : 524288;
                    }
                    i11 = i6 & 128;
                    if (i11 == 0) {
                        i7 |= 12582912;
                    } else if ((i5 & 12582912) == 0) {
                        i7 |= startRestartGroup.changed(z7) ? 8388608 : 4194304;
                    }
                    if ((i7 & 4793491) == 4793490 || !startRestartGroup.getSkipping()) {
                        Modifier modifier3 = i12 == 0 ? Modifier.INSTANCE : modifier;
                        Function0<Unit> function04 = i13 == 0 ? null : function02;
                        ButtonConfig buttonConfig4 = i8 == 0 ? ButtonConfig.Regular : buttonConfig2;
                        boolean z12 = i9 == 0 ? true : z8;
                        boolean z13 = i10 == 0 ? false : z6;
                        boolean z14 = i11 == 0 ? true : z7;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1480445158, i7, -1, "dk.molslinjen.ui.views.reusable.buttons.PrimaryButton (PrimaryButton.kt:18)");
                        }
                        composer2 = startRestartGroup;
                        BaseButtonKt.BaseButton(modifier3, text, onClick, function04, ButtonStyle.Primary.INSTANCE, buttonConfig4, z13, z12, null, null, null, null, false, z14, composer2, (i7 & 14) | 24576 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | ((i7 << 3) & 458752) | (3670016 & i7) | (29360128 & (i7 << 6)), (i7 >> 12) & 7168, 7936);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        function03 = function04;
                        buttonConfig3 = buttonConfig4;
                        z9 = z12;
                        z10 = z13;
                        z11 = z14;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        z10 = z6;
                        composer2 = startRestartGroup;
                        function03 = function02;
                        buttonConfig3 = buttonConfig2;
                        z9 = z8;
                        z11 = z7;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: Z1.j
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit PrimaryButton$lambda$0;
                                PrimaryButton$lambda$0 = PrimaryButtonKt.PrimaryButton$lambda$0(Modifier.this, text, onClick, function03, buttonConfig3, z9, z10, z11, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                return PrimaryButton$lambda$0;
                            }
                        });
                        return;
                    }
                    return;
                }
                z8 = z5;
                i10 = i6 & 64;
                if (i10 == 0) {
                }
                i11 = i6 & 128;
                if (i11 == 0) {
                }
                if ((i7 & 4793491) == 4793490) {
                }
                if (i12 == 0) {
                }
                if (i13 == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if (i10 == 0) {
                }
                if (i11 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                BaseButtonKt.BaseButton(modifier3, text, onClick, function04, ButtonStyle.Primary.INSTANCE, buttonConfig4, z13, z12, null, null, null, null, false, z14, composer2, (i7 & 14) | 24576 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | ((i7 << 3) & 458752) | (3670016 & i7) | (29360128 & (i7 << 6)), (i7 >> 12) & 7168, 7936);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = modifier3;
                function03 = function04;
                buttonConfig3 = buttonConfig4;
                z9 = z12;
                z10 = z13;
                z11 = z14;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            buttonConfig2 = buttonConfig;
            i9 = i6 & 32;
            if (i9 != 0) {
            }
            z8 = z5;
            i10 = i6 & 64;
            if (i10 == 0) {
            }
            i11 = i6 & 128;
            if (i11 == 0) {
            }
            if ((i7 & 4793491) == 4793490) {
            }
            if (i12 == 0) {
            }
            if (i13 == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 == 0) {
            }
            if (i10 == 0) {
            }
            if (i11 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            BaseButtonKt.BaseButton(modifier3, text, onClick, function04, ButtonStyle.Primary.INSTANCE, buttonConfig4, z13, z12, null, null, null, null, false, z14, composer2, (i7 & 14) | 24576 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | ((i7 << 3) & 458752) | (3670016 & i7) | (29360128 & (i7 << 6)), (i7 >> 12) & 7168, 7936);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier3;
            function03 = function04;
            buttonConfig3 = buttonConfig4;
            z9 = z12;
            z10 = z13;
            z11 = z14;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
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
        z8 = z5;
        i10 = i6 & 64;
        if (i10 == 0) {
        }
        i11 = i6 & 128;
        if (i11 == 0) {
        }
        if ((i7 & 4793491) == 4793490) {
        }
        if (i12 == 0) {
        }
        if (i13 == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        BaseButtonKt.BaseButton(modifier3, text, onClick, function04, ButtonStyle.Primary.INSTANCE, buttonConfig4, z13, z12, null, null, null, null, false, z14, composer2, (i7 & 14) | 24576 | (i7 & 112) | (i7 & 896) | (i7 & 7168) | ((i7 << 3) & 458752) | (3670016 & i7) | (29360128 & (i7 << 6)), (i7 >> 12) & 7168, 7936);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier3;
        function03 = function04;
        buttonConfig3 = buttonConfig4;
        z9 = z12;
        z10 = z13;
        z11 = z14;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrimaryButton$lambda$0(Modifier modifier, String str, Function0 function0, Function0 function02, ButtonConfig buttonConfig, boolean z5, boolean z6, boolean z7, int i5, int i6, Composer composer, int i7) {
        PrimaryButton(modifier, str, function0, function02, buttonConfig, z5, z6, z7, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
