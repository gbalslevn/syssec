package dk.molslinjen.ui.views.reusable.buttons;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.InteractiveComponentSizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.RippleKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.buttons.ButtonStyle;
import dk.molslinjen.ui.views.reusable.buttons.ButtonWithPriceKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aw\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001aw\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0010\u0010\u0014\u001a!\u0010\u0015\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0003¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onClick", BuildConfig.FLAVOR, "text", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "price", "quantityText", BuildConfig.FLAVOR, "enabled", "onClickDisabled", "Ldk/molslinjen/ui/views/reusable/buttons/ButtonConfig;", "buttonConfig", "clearFocusOnClick", "ButtonWithPrice", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Ldk/molslinjen/ui/views/reusable/buttons/ButtonConfig;ZLandroidx/compose/runtime/Composer;II)V", "Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "priceTotal", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Ldk/molslinjen/domain/managers/checkout/PriceTotal;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Ldk/molslinjen/ui/views/reusable/buttons/ButtonConfig;ZLandroidx/compose/runtime/Composer;II)V", "TextAreaInButton", "(Ljava/lang/String;ZLandroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ButtonWithPriceKt {
    /* JADX WARN: Removed duplicated region for block: B:103:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ButtonWithPrice(Modifier modifier, final Function0<Unit> onClick, final String text, PriceWithCurrency priceWithCurrency, String str, boolean z5, Function0<Unit> function0, ButtonConfig buttonConfig, boolean z6, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        int i9;
        boolean z7;
        int i10;
        int i11;
        int i12;
        Composer composer2;
        final Modifier modifier2;
        final String str2;
        final boolean z8;
        final Function0<Unit> function02;
        final ButtonConfig buttonConfig2;
        final boolean z9;
        final PriceWithCurrency priceWithCurrency2;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(text, "text");
        Composer startRestartGroup = composer.startRestartGroup(-1190865279);
        int i13 = i6 & 1;
        if (i13 != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(text) ? 256 : 128;
        }
        int i14 = i6 & 8;
        if (i14 != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(priceWithCurrency) ? 2048 : 1024;
            i8 = i6 & 16;
            if (i8 == 0) {
                i7 |= 24576;
            } else if ((i5 & 24576) == 0) {
                i7 |= startRestartGroup.changed(str) ? 16384 : 8192;
                i9 = i6 & 32;
                if (i9 != 0) {
                    i7 |= 196608;
                } else if ((196608 & i5) == 0) {
                    z7 = z5;
                    i7 |= startRestartGroup.changed(z7) ? 131072 : 65536;
                    i10 = i6 & 64;
                    if (i10 == 0) {
                        i7 |= 1572864;
                    } else if ((i5 & 1572864) == 0) {
                        i7 |= startRestartGroup.changedInstance(function0) ? 1048576 : 524288;
                    }
                    i11 = i6 & 128;
                    if (i11 == 0) {
                        i7 |= 12582912;
                    } else if ((i5 & 12582912) == 0) {
                        i7 |= startRestartGroup.changed(buttonConfig) ? 8388608 : 4194304;
                    }
                    i12 = i6 & 256;
                    if (i12 == 0) {
                        i7 |= 100663296;
                    } else if ((i5 & 100663296) == 0) {
                        i7 |= startRestartGroup.changed(z6) ? 67108864 : 33554432;
                    }
                    if ((i7 & 38347923) != 38347922 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        priceWithCurrency2 = priceWithCurrency;
                        str2 = str;
                        function02 = function0;
                        buttonConfig2 = buttonConfig;
                        z8 = z7;
                        composer2 = startRestartGroup;
                        z9 = z6;
                    } else {
                        Modifier modifier3 = i13 == 0 ? Modifier.INSTANCE : modifier;
                        PriceWithCurrency priceWithCurrency3 = i14 == 0 ? null : priceWithCurrency;
                        String str3 = i8 == 0 ? null : str;
                        boolean z10 = i9 == 0 ? true : z7;
                        Function0<Unit> function03 = i10 == 0 ? null : function0;
                        ButtonConfig buttonConfig3 = i11 == 0 ? ButtonConfig.Large : buttonConfig;
                        boolean z11 = i12 == 0 ? true : z6;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1190865279, i7, -1, "dk.molslinjen.ui.views.reusable.buttons.ButtonWithPrice (ButtonWithPrice.kt:42)");
                        }
                        PriceWithCurrency priceWithCurrency4 = priceWithCurrency3;
                        composer2 = startRestartGroup;
                        ButtonWithPrice(modifier3, onClick, text, priceWithCurrency3 == null ? new PriceTotal(priceWithCurrency3) : null, str3, z10, function03, buttonConfig3, z11, startRestartGroup, i7 & 268428286, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        str2 = str3;
                        z8 = z10;
                        function02 = function03;
                        buttonConfig2 = buttonConfig3;
                        z9 = z11;
                        priceWithCurrency2 = priceWithCurrency4;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: Z1.d
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit ButtonWithPrice$lambda$1;
                                ButtonWithPrice$lambda$1 = ButtonWithPriceKt.ButtonWithPrice$lambda$1(Modifier.this, onClick, text, priceWithCurrency2, str2, z8, function02, buttonConfig2, z9, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                return ButtonWithPrice$lambda$1;
                            }
                        });
                        return;
                    }
                    return;
                }
                z7 = z5;
                i10 = i6 & 64;
                if (i10 == 0) {
                }
                i11 = i6 & 128;
                if (i11 == 0) {
                }
                i12 = i6 & 256;
                if (i12 == 0) {
                }
                if ((i7 & 38347923) != 38347922) {
                }
                if (i13 == 0) {
                }
                if (i14 == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if (i10 == 0) {
                }
                if (i11 == 0) {
                }
                if (i12 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                PriceWithCurrency priceWithCurrency42 = priceWithCurrency3;
                composer2 = startRestartGroup;
                ButtonWithPrice(modifier3, onClick, text, priceWithCurrency3 == null ? new PriceTotal(priceWithCurrency3) : null, str3, z10, function03, buttonConfig3, z11, startRestartGroup, i7 & 268428286, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = modifier3;
                str2 = str3;
                z8 = z10;
                function02 = function03;
                buttonConfig2 = buttonConfig3;
                z9 = z11;
                priceWithCurrency2 = priceWithCurrency42;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i9 = i6 & 32;
            if (i9 != 0) {
            }
            z7 = z5;
            i10 = i6 & 64;
            if (i10 == 0) {
            }
            i11 = i6 & 128;
            if (i11 == 0) {
            }
            i12 = i6 & 256;
            if (i12 == 0) {
            }
            if ((i7 & 38347923) != 38347922) {
            }
            if (i13 == 0) {
            }
            if (i14 == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 == 0) {
            }
            if (i10 == 0) {
            }
            if (i11 == 0) {
            }
            if (i12 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            PriceWithCurrency priceWithCurrency422 = priceWithCurrency3;
            composer2 = startRestartGroup;
            ButtonWithPrice(modifier3, onClick, text, priceWithCurrency3 == null ? new PriceTotal(priceWithCurrency3) : null, str3, z10, function03, buttonConfig3, z11, startRestartGroup, i7 & 268428286, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier3;
            str2 = str3;
            z8 = z10;
            function02 = function03;
            buttonConfig2 = buttonConfig3;
            z9 = z11;
            priceWithCurrency2 = priceWithCurrency422;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i8 = i6 & 16;
        if (i8 == 0) {
        }
        i9 = i6 & 32;
        if (i9 != 0) {
        }
        z7 = z5;
        i10 = i6 & 64;
        if (i10 == 0) {
        }
        i11 = i6 & 128;
        if (i11 == 0) {
        }
        i12 = i6 & 256;
        if (i12 == 0) {
        }
        if ((i7 & 38347923) != 38347922) {
        }
        if (i13 == 0) {
        }
        if (i14 == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if (i12 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        PriceWithCurrency priceWithCurrency4222 = priceWithCurrency3;
        composer2 = startRestartGroup;
        ButtonWithPrice(modifier3, onClick, text, priceWithCurrency3 == null ? new PriceTotal(priceWithCurrency3) : null, str3, z10, function03, buttonConfig3, z11, startRestartGroup, i7 & 268428286, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier3;
        str2 = str3;
        z8 = z10;
        function02 = function03;
        buttonConfig2 = buttonConfig3;
        z9 = z11;
        priceWithCurrency2 = priceWithCurrency4222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ButtonWithPrice$lambda$1(Modifier modifier, Function0 function0, String str, PriceWithCurrency priceWithCurrency, String str2, boolean z5, Function0 function02, ButtonConfig buttonConfig, boolean z6, int i5, int i6, Composer composer, int i7) {
        ButtonWithPrice(modifier, (Function0<Unit>) function0, str, priceWithCurrency, str2, z5, (Function0<Unit>) function02, buttonConfig, z6, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ButtonWithPrice$lambda$2(Modifier modifier, Function0 function0, String str, PriceTotal priceTotal, String str2, boolean z5, Function0 function02, ButtonConfig buttonConfig, boolean z6, int i5, int i6, Composer composer, int i7) {
        ButtonWithPrice(modifier, (Function0<Unit>) function0, str, priceTotal, str2, z5, (Function0<Unit>) function02, buttonConfig, z6, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextAreaInButton(final String str, final boolean z5, Composer composer, final int i5) {
        int i6;
        TextStyle m2295copyp1EtxEg;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(331855659);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(331855659, i6, -1, "dk.molslinjen.ui.views.reusable.buttons.TextAreaInButton (ButtonWithPrice.kt:131)");
            }
            String nullIfEmpty = StringExtensionsKt.nullIfEmpty(str);
            if (nullIfEmpty == null) {
                composer2 = startRestartGroup;
            } else {
                TextStyle subBold = TypographyKt.getSubBold();
                AppColor appColor = AppColor.INSTANCE;
                m2295copyp1EtxEg = subBold.m2295copyp1EtxEg((r48 & 1) != 0 ? subBold.spanStyle.m2255getColor0d7_KjU() : z5 ? appColor.m3253getBrandBlack10d7_KjU() : appColor.m3265getGrey20d7_KjU(), (r48 & 2) != 0 ? subBold.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? subBold.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? subBold.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? subBold.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? subBold.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? subBold.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? subBold.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? subBold.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? subBold.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? subBold.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? subBold.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? subBold.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? subBold.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? subBold.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? subBold.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? subBold.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? subBold.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? subBold.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? subBold.platformStyle : null, (r48 & 1048576) != 0 ? subBold.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? subBold.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? subBold.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? subBold.paragraphStyle.getTextMotion() : null);
                float f5 = 8;
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null);
                AppColor appColor2 = AppColor.INSTANCE;
                composer2 = startRestartGroup;
                TextKt.m940Text4IGK_g(nullIfEmpty, PaddingKt.m312paddingVpY3zN4(BackgroundKt.m103backgroundbw27NRU(m315paddingqDBjuR0$default, z5 ? appColor2.m3263getContrastGreen20d7_KjU() : appColor2.m3267getGrey40d7_KjU(), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getMedium()), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(4)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, m2295copyp1EtxEg, composer2, 0, 0, 65532);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: Z1.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TextAreaInButton$lambda$4;
                    TextAreaInButton$lambda$4 = ButtonWithPriceKt.TextAreaInButton$lambda$4(str, z5, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TextAreaInButton$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextAreaInButton$lambda$4(String str, boolean z5, int i5, Composer composer, int i6) {
        TextAreaInButton(str, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ButtonWithPrice(Modifier modifier, final Function0<Unit> onClick, final String text, PriceTotal priceTotal, String str, boolean z5, Function0<Unit> function0, ButtonConfig buttonConfig, boolean z6, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        int i9;
        boolean z7;
        int i10;
        int i11;
        int i12;
        Composer composer2;
        final Modifier modifier2;
        final PriceTotal priceTotal2;
        final String str2;
        final boolean z8;
        final Function0<Unit> function02;
        final ButtonConfig buttonConfig2;
        final boolean z9;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(text, "text");
        Composer startRestartGroup = composer.startRestartGroup(1733925240);
        int i13 = i6 & 1;
        if (i13 != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(text) ? 256 : 128;
        }
        int i14 = i6 & 8;
        if (i14 != 0) {
            i7 |= 3072;
        } else if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(priceTotal) ? 2048 : 1024;
            i8 = i6 & 16;
            if (i8 == 0) {
                i7 |= 24576;
            } else if ((i5 & 24576) == 0) {
                i7 |= startRestartGroup.changed(str) ? 16384 : 8192;
                i9 = i6 & 32;
                if (i9 != 0) {
                    i7 |= 196608;
                } else if ((196608 & i5) == 0) {
                    z7 = z5;
                    i7 |= startRestartGroup.changed(z7) ? 131072 : 65536;
                    i10 = i6 & 64;
                    if (i10 == 0) {
                        i7 |= 1572864;
                    } else if ((i5 & 1572864) == 0) {
                        i7 |= startRestartGroup.changedInstance(function0) ? 1048576 : 524288;
                    }
                    i11 = i6 & 128;
                    if (i11 == 0) {
                        i7 |= 12582912;
                    } else if ((i5 & 12582912) == 0) {
                        i7 |= startRestartGroup.changed(buttonConfig) ? 8388608 : 4194304;
                    }
                    i12 = i6 & 256;
                    if (i12 == 0) {
                        i7 |= 100663296;
                    } else if ((i5 & 100663296) == 0) {
                        i7 |= startRestartGroup.changed(z6) ? 67108864 : 33554432;
                    }
                    if ((i7 & 38347923) != 38347922 && startRestartGroup.getSkipping()) {
                        startRestartGroup.skipToGroupEnd();
                        modifier2 = modifier;
                        priceTotal2 = priceTotal;
                        str2 = str;
                        function02 = function0;
                        buttonConfig2 = buttonConfig;
                        z8 = z7;
                        composer2 = startRestartGroup;
                        z9 = z6;
                    } else {
                        Modifier modifier3 = i13 == 0 ? Modifier.INSTANCE : modifier;
                        PriceTotal priceTotal3 = i14 == 0 ? null : priceTotal;
                        String str3 = i8 == 0 ? null : str;
                        boolean z10 = i9 == 0 ? true : z7;
                        Function0<Unit> function03 = i10 == 0 ? null : function0;
                        ButtonConfig buttonConfig3 = i11 == 0 ? ButtonConfig.Large : buttonConfig;
                        boolean z11 = i12 == 0 ? true : z6;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1733925240, i7, -1, "dk.molslinjen.ui.views.reusable.buttons.ButtonWithPrice (ButtonWithPrice.kt:78)");
                        }
                        FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                        ButtonStyle.Primary primary = ButtonStyle.Primary.INSTANCE;
                        composer2 = startRestartGroup;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentEnforcement().provides(Boolean.FALSE), RippleKt.getLocalRippleConfiguration().provides(primary.getRipple())}, ComposableLambdaKt.rememberComposableLambda(554401336, true, new ButtonWithPriceKt$ButtonWithPrice$3(z11, focusManager, z10, onClick, function03, modifier3, buttonConfig3, primary, priceTotal3, str3, text), composer2, 54), composer2, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        priceTotal2 = priceTotal3;
                        str2 = str3;
                        z8 = z10;
                        function02 = function03;
                        buttonConfig2 = buttonConfig3;
                        z9 = z11;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: Z1.b
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit ButtonWithPrice$lambda$2;
                                ButtonWithPrice$lambda$2 = ButtonWithPriceKt.ButtonWithPrice$lambda$2(Modifier.this, onClick, text, priceTotal2, str2, z8, function02, buttonConfig2, z9, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                return ButtonWithPrice$lambda$2;
                            }
                        });
                        return;
                    }
                    return;
                }
                z7 = z5;
                i10 = i6 & 64;
                if (i10 == 0) {
                }
                i11 = i6 & 128;
                if (i11 == 0) {
                }
                i12 = i6 & 256;
                if (i12 == 0) {
                }
                if ((i7 & 38347923) != 38347922) {
                }
                if (i13 == 0) {
                }
                if (i14 == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if (i10 == 0) {
                }
                if (i11 == 0) {
                }
                if (i12 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                FocusManager focusManager2 = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                ButtonStyle.Primary primary2 = ButtonStyle.Primary.INSTANCE;
                composer2 = startRestartGroup;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentEnforcement().provides(Boolean.FALSE), RippleKt.getLocalRippleConfiguration().provides(primary2.getRipple())}, ComposableLambdaKt.rememberComposableLambda(554401336, true, new ButtonWithPriceKt$ButtonWithPrice$3(z11, focusManager2, z10, onClick, function03, modifier3, buttonConfig3, primary2, priceTotal3, str3, text), composer2, 54), composer2, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = modifier3;
                priceTotal2 = priceTotal3;
                str2 = str3;
                z8 = z10;
                function02 = function03;
                buttonConfig2 = buttonConfig3;
                z9 = z11;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i9 = i6 & 32;
            if (i9 != 0) {
            }
            z7 = z5;
            i10 = i6 & 64;
            if (i10 == 0) {
            }
            i11 = i6 & 128;
            if (i11 == 0) {
            }
            i12 = i6 & 256;
            if (i12 == 0) {
            }
            if ((i7 & 38347923) != 38347922) {
            }
            if (i13 == 0) {
            }
            if (i14 == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 == 0) {
            }
            if (i10 == 0) {
            }
            if (i11 == 0) {
            }
            if (i12 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            FocusManager focusManager22 = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            ButtonStyle.Primary primary22 = ButtonStyle.Primary.INSTANCE;
            composer2 = startRestartGroup;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentEnforcement().provides(Boolean.FALSE), RippleKt.getLocalRippleConfiguration().provides(primary22.getRipple())}, ComposableLambdaKt.rememberComposableLambda(554401336, true, new ButtonWithPriceKt$ButtonWithPrice$3(z11, focusManager22, z10, onClick, function03, modifier3, buttonConfig3, primary22, priceTotal3, str3, text), composer2, 54), composer2, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier3;
            priceTotal2 = priceTotal3;
            str2 = str3;
            z8 = z10;
            function02 = function03;
            buttonConfig2 = buttonConfig3;
            z9 = z11;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i8 = i6 & 16;
        if (i8 == 0) {
        }
        i9 = i6 & 32;
        if (i9 != 0) {
        }
        z7 = z5;
        i10 = i6 & 64;
        if (i10 == 0) {
        }
        i11 = i6 & 128;
        if (i11 == 0) {
        }
        i12 = i6 & 256;
        if (i12 == 0) {
        }
        if ((i7 & 38347923) != 38347922) {
        }
        if (i13 == 0) {
        }
        if (i14 == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if (i12 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        FocusManager focusManager222 = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
        ButtonStyle.Primary primary222 = ButtonStyle.Primary.INSTANCE;
        composer2 = startRestartGroup;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentEnforcement().provides(Boolean.FALSE), RippleKt.getLocalRippleConfiguration().provides(primary222.getRipple())}, ComposableLambdaKt.rememberComposableLambda(554401336, true, new ButtonWithPriceKt$ButtonWithPrice$3(z11, focusManager222, z10, onClick, function03, modifier3, buttonConfig3, primary222, priceTotal3, str3, text), composer2, 54), composer2, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier3;
        priceTotal2 = priceTotal3;
        str2 = str3;
        z8 = z10;
        function02 = function03;
        buttonConfig2 = buttonConfig3;
        z9 = z11;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
