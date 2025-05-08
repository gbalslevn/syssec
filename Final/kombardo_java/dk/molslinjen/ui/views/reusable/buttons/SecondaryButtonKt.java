package dk.molslinjen.ui.views.reusable.buttons;

import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.buttons.ButtonStyle;
import dk.molslinjen.ui.views.reusable.buttons.SecondaryButtonKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u008b\u0001\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\b2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "text", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onClick", "onClickDisabled", BuildConfig.FLAVOR, "enabled", "Ldk/molslinjen/ui/views/reusable/buttons/ButtonConfig;", "buttonConfig", "isLoading", BuildConfig.FLAVOR, "leftIcon", "rightIcon", "Landroidx/compose/ui/graphics/Color;", "background", "autoShrinkText", "SecondaryButton-bZJ3-2A", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLdk/molslinjen/ui/views/reusable/buttons/ButtonConfig;ZLjava/lang/Integer;Ljava/lang/Integer;JZLandroidx/compose/runtime/Composer;III)V", "SecondaryButton", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SecondaryButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:105:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0120  */
    /* renamed from: SecondaryButton-bZJ3-2A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3406SecondaryButtonbZJ32A(Modifier modifier, final String text, final Function0<Unit> onClick, Function0<Unit> function0, boolean z5, ButtonConfig buttonConfig, boolean z6, Integer num, Integer num2, long j5, boolean z7, Composer composer, final int i5, final int i6, final int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        long j6;
        int i15;
        int i16;
        int i17;
        Composer composer2;
        final Modifier modifier2;
        final Function0<Unit> function02;
        final boolean z8;
        final ButtonConfig buttonConfig2;
        final boolean z9;
        final Integer num3;
        final Integer num4;
        final boolean z10;
        final long j7;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-1318687135);
        int i18 = i7 & 1;
        if (i18 != 0) {
            i8 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i8 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i8 = i5;
        }
        if ((i7 & 2) != 0) {
            i8 |= 48;
        } else if ((i5 & 48) == 0) {
            i8 |= startRestartGroup.changed(text) ? 32 : 16;
        }
        if ((i7 & 4) != 0) {
            i8 |= 384;
        } else if ((i5 & 384) == 0) {
            i8 |= startRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        int i19 = i7 & 8;
        if (i19 != 0) {
            i8 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i8 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
            i9 = i7 & 16;
            if (i9 == 0) {
                i8 |= 24576;
            } else if ((i5 & 24576) == 0) {
                i8 |= startRestartGroup.changed(z5) ? 16384 : 8192;
                i10 = i7 & 32;
                if (i10 != 0) {
                    i8 |= 196608;
                } else if ((i5 & 196608) == 0) {
                    i8 |= startRestartGroup.changed(buttonConfig) ? 131072 : 65536;
                }
                i11 = i7 & 64;
                if (i11 != 0) {
                    i8 |= 1572864;
                } else if ((i5 & 1572864) == 0) {
                    i8 |= startRestartGroup.changed(z6) ? 1048576 : 524288;
                }
                i12 = i7 & 128;
                if (i12 != 0) {
                    i8 |= 12582912;
                } else if ((i5 & 12582912) == 0) {
                    i8 |= startRestartGroup.changed(num) ? 8388608 : 4194304;
                }
                i13 = i7 & 256;
                if (i13 != 0) {
                    i8 |= 100663296;
                } else if ((i5 & 100663296) == 0) {
                    i8 |= startRestartGroup.changed(num2) ? 67108864 : 33554432;
                }
                i14 = i7 & 512;
                if (i14 != 0) {
                    i8 |= 805306368;
                    j6 = j5;
                } else {
                    j6 = j5;
                    if ((i5 & 805306368) == 0) {
                        i8 |= startRestartGroup.changed(j6) ? 536870912 : 268435456;
                    }
                }
                i15 = i7 & 1024;
                if (i15 != 0) {
                    i17 = i6 | 6;
                } else {
                    if ((i6 & 6) != 0) {
                        i16 = i6;
                        if ((i8 & 306783379) != 306783378 && (i16 & 3) == 2 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            function02 = function0;
                            buttonConfig2 = buttonConfig;
                            z9 = z6;
                            num3 = num;
                            num4 = num2;
                            composer2 = startRestartGroup;
                            j7 = j6;
                            z8 = z5;
                            z10 = z7;
                        } else {
                            Modifier modifier3 = i18 == 0 ? Modifier.INSTANCE : modifier;
                            Function0<Unit> function03 = i19 == 0 ? null : function0;
                            boolean z11 = i9 == 0 ? true : z5;
                            ButtonConfig buttonConfig3 = i10 == 0 ? ButtonConfig.Regular : buttonConfig;
                            boolean z12 = i11 == 0 ? false : z6;
                            Integer num5 = i12 == 0 ? null : num;
                            Integer num6 = i13 == 0 ? null : num2;
                            long m3281getWhite0d7_KjU = i14 == 0 ? AppColor.INSTANCE.m3281getWhite0d7_KjU() : j6;
                            boolean z13 = i15 == 0 ? true : z7;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1318687135, i8, i16, "dk.molslinjen.ui.views.reusable.buttons.SecondaryButton (SecondaryButton.kt:27)");
                            }
                            float m2599constructorimpl = Dp.m2599constructorimpl(2);
                            AppColor appColor = AppColor.INSTANCE;
                            int i20 = i8;
                            long j8 = m3281getWhite0d7_KjU;
                            composer2 = startRestartGroup;
                            BaseButtonKt.BaseButton(modifier3, text, onClick, function03, new ButtonStyle.Secondary(m3281getWhite0d7_KjU, null), buttonConfig3, z12, z11, BorderStrokeKt.m117BorderStrokecXLIe8U(m2599constructorimpl, !z11 ? appColor.m3253getBrandBlack10d7_KjU() : appColor.m3268getGrey50d7_KjU()), null, BaseButtonKt.getBaseButtonIconComposable(num5), BaseButtonKt.getBaseButtonIconComposable(num6), false, z13, composer2, (4136958 & i20) | (29360128 & (i20 << 9)), (i16 << 9) & 7168, 4608);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier3;
                            function02 = function03;
                            z8 = z11;
                            buttonConfig2 = buttonConfig3;
                            z9 = z12;
                            num3 = num5;
                            num4 = num6;
                            z10 = z13;
                            j7 = j8;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                            endRestartGroup.updateScope(new Function2() { // from class: Z1.k
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit SecondaryButton_bZJ3_2A$lambda$0;
                                    SecondaryButton_bZJ3_2A$lambda$0 = SecondaryButtonKt.SecondaryButton_bZJ3_2A$lambda$0(Modifier.this, text, onClick, function02, z8, buttonConfig2, z9, num3, num4, j7, z10, i5, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                                    return SecondaryButton_bZJ3_2A$lambda$0;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i17 = i6 | (startRestartGroup.changed(z7) ? 4 : 2);
                }
                i16 = i17;
                if ((i8 & 306783379) != 306783378) {
                }
                if (i18 == 0) {
                }
                if (i19 == 0) {
                }
                if (i9 == 0) {
                }
                if (i10 == 0) {
                }
                if (i11 == 0) {
                }
                if (i12 == 0) {
                }
                if (i13 == 0) {
                }
                if (i14 == 0) {
                }
                if (i15 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                float m2599constructorimpl2 = Dp.m2599constructorimpl(2);
                AppColor appColor2 = AppColor.INSTANCE;
                int i202 = i8;
                long j82 = m3281getWhite0d7_KjU;
                composer2 = startRestartGroup;
                BaseButtonKt.BaseButton(modifier3, text, onClick, function03, new ButtonStyle.Secondary(m3281getWhite0d7_KjU, null), buttonConfig3, z12, z11, BorderStrokeKt.m117BorderStrokecXLIe8U(m2599constructorimpl2, !z11 ? appColor2.m3253getBrandBlack10d7_KjU() : appColor2.m3268getGrey50d7_KjU()), null, BaseButtonKt.getBaseButtonIconComposable(num5), BaseButtonKt.getBaseButtonIconComposable(num6), false, z13, composer2, (4136958 & i202) | (29360128 & (i202 << 9)), (i16 << 9) & 7168, 4608);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = modifier3;
                function02 = function03;
                z8 = z11;
                buttonConfig2 = buttonConfig3;
                z9 = z12;
                num3 = num5;
                num4 = num6;
                z10 = z13;
                j7 = j82;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i10 = i7 & 32;
            if (i10 != 0) {
            }
            i11 = i7 & 64;
            if (i11 != 0) {
            }
            i12 = i7 & 128;
            if (i12 != 0) {
            }
            i13 = i7 & 256;
            if (i13 != 0) {
            }
            i14 = i7 & 512;
            if (i14 != 0) {
            }
            i15 = i7 & 1024;
            if (i15 != 0) {
            }
            i16 = i17;
            if ((i8 & 306783379) != 306783378) {
            }
            if (i18 == 0) {
            }
            if (i19 == 0) {
            }
            if (i9 == 0) {
            }
            if (i10 == 0) {
            }
            if (i11 == 0) {
            }
            if (i12 == 0) {
            }
            if (i13 == 0) {
            }
            if (i14 == 0) {
            }
            if (i15 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            float m2599constructorimpl22 = Dp.m2599constructorimpl(2);
            AppColor appColor22 = AppColor.INSTANCE;
            int i2022 = i8;
            long j822 = m3281getWhite0d7_KjU;
            composer2 = startRestartGroup;
            BaseButtonKt.BaseButton(modifier3, text, onClick, function03, new ButtonStyle.Secondary(m3281getWhite0d7_KjU, null), buttonConfig3, z12, z11, BorderStrokeKt.m117BorderStrokecXLIe8U(m2599constructorimpl22, !z11 ? appColor22.m3253getBrandBlack10d7_KjU() : appColor22.m3268getGrey50d7_KjU()), null, BaseButtonKt.getBaseButtonIconComposable(num5), BaseButtonKt.getBaseButtonIconComposable(num6), false, z13, composer2, (4136958 & i2022) | (29360128 & (i2022 << 9)), (i16 << 9) & 7168, 4608);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier3;
            function02 = function03;
            z8 = z11;
            buttonConfig2 = buttonConfig3;
            z9 = z12;
            num3 = num5;
            num4 = num6;
            z10 = z13;
            j7 = j822;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i9 = i7 & 16;
        if (i9 == 0) {
        }
        i10 = i7 & 32;
        if (i10 != 0) {
        }
        i11 = i7 & 64;
        if (i11 != 0) {
        }
        i12 = i7 & 128;
        if (i12 != 0) {
        }
        i13 = i7 & 256;
        if (i13 != 0) {
        }
        i14 = i7 & 512;
        if (i14 != 0) {
        }
        i15 = i7 & 1024;
        if (i15 != 0) {
        }
        i16 = i17;
        if ((i8 & 306783379) != 306783378) {
        }
        if (i18 == 0) {
        }
        if (i19 == 0) {
        }
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if (i12 == 0) {
        }
        if (i13 == 0) {
        }
        if (i14 == 0) {
        }
        if (i15 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        float m2599constructorimpl222 = Dp.m2599constructorimpl(2);
        AppColor appColor222 = AppColor.INSTANCE;
        int i20222 = i8;
        long j8222 = m3281getWhite0d7_KjU;
        composer2 = startRestartGroup;
        BaseButtonKt.BaseButton(modifier3, text, onClick, function03, new ButtonStyle.Secondary(m3281getWhite0d7_KjU, null), buttonConfig3, z12, z11, BorderStrokeKt.m117BorderStrokecXLIe8U(m2599constructorimpl222, !z11 ? appColor222.m3253getBrandBlack10d7_KjU() : appColor222.m3268getGrey50d7_KjU()), null, BaseButtonKt.getBaseButtonIconComposable(num5), BaseButtonKt.getBaseButtonIconComposable(num6), false, z13, composer2, (4136958 & i20222) | (29360128 & (i20222 << 9)), (i16 << 9) & 7168, 4608);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier3;
        function02 = function03;
        z8 = z11;
        buttonConfig2 = buttonConfig3;
        z9 = z12;
        num3 = num5;
        num4 = num6;
        z10 = z13;
        j7 = j8222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SecondaryButton_bZJ3_2A$lambda$0(Modifier modifier, String str, Function0 function0, Function0 function02, boolean z5, ButtonConfig buttonConfig, boolean z6, Integer num, Integer num2, long j5, boolean z7, int i5, int i6, int i7, Composer composer, int i8) {
        m3406SecondaryButtonbZJ32A(modifier, str, function0, function02, z5, buttonConfig, z6, num, num2, j5, z7, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6), i7);
        return Unit.INSTANCE;
    }
}
