package dk.molslinjen.ui.views.shared.components;

import android.content.Context;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.extensions.domain.PriceFormatExtensionsKt;
import dk.molslinjen.ui.views.shared.components.PriceTextKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a_\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a_\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0016¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/domain/model/shared/Price;", "price", "Landroidx/compose/ui/Modifier;", "modifier", "Ldk/molslinjen/ui/views/shared/components/PriceViewType;", "priceViewType", BuildConfig.FLAVOR, "absoluteValue", "Landroidx/compose/ui/text/TextStyle;", "style", "Landroidx/compose/ui/text/style/TextAlign;", "textAlign", BuildConfig.FLAVOR, "maxLines", "Landroidx/compose/ui/graphics/Color;", "color", BuildConfig.FLAVOR, "PriceText-1y9Plug", "(Ldk/molslinjen/domain/model/shared/Price;Landroidx/compose/ui/Modifier;Ldk/molslinjen/ui/views/shared/components/PriceViewType;ZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/style/TextAlign;IJLandroidx/compose/runtime/Composer;II)V", "PriceText", "Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "priceTotal", "(Ldk/molslinjen/domain/managers/checkout/PriceTotal;Landroidx/compose/ui/Modifier;Ldk/molslinjen/ui/views/shared/components/PriceViewType;ZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/style/TextAlign;IJLandroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PriceTextKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PriceViewType.values().length];
            try {
                iArr[PriceViewType.PriceAndCurrency.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PriceViewType.PriceOnly.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PriceViewType.CurrencyOnly.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00a1  */
    /* renamed from: PriceText-1y9Plug, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3557PriceText1y9Plug(final Price price, Modifier modifier, PriceViewType priceViewType, boolean z5, TextStyle textStyle, TextAlign textAlign, int i5, long j5, Composer composer, final int i6, final int i7) {
        int i8;
        Modifier modifier2;
        int i9;
        PriceViewType priceViewType2;
        int i10;
        boolean z6;
        TextStyle textStyle2;
        int i11;
        TextAlign textAlign2;
        int i12;
        int i13;
        int i14;
        long j6;
        int i15;
        TextAlign textAlign3;
        int i16;
        TextStyle textStyle3;
        final boolean z7;
        final long j7;
        final int i17;
        final PriceViewType priceViewType3;
        ScopeUpdateScope endRestartGroup;
        int i18;
        Intrinsics.checkNotNullParameter(price, "price");
        Composer startRestartGroup = composer.startRestartGroup(85132215);
        if ((i7 & 1) != 0) {
            i8 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i8 = (startRestartGroup.changedInstance(price) ? 4 : 2) | i6;
        } else {
            i8 = i6;
        }
        int i19 = i7 & 2;
        if (i19 != 0) {
            i8 |= 48;
        } else if ((i6 & 48) == 0) {
            modifier2 = modifier;
            i8 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i9 = i7 & 4;
            if (i9 == 0) {
                i8 |= 384;
            } else if ((i6 & 384) == 0) {
                priceViewType2 = priceViewType;
                i8 |= startRestartGroup.changed(priceViewType2) ? 256 : 128;
                i10 = i7 & 8;
                if (i10 != 0) {
                    i8 |= 3072;
                } else if ((i6 & 3072) == 0) {
                    z6 = z5;
                    i8 |= startRestartGroup.changed(z6) ? 2048 : 1024;
                    if ((i6 & 24576) != 0) {
                        if ((i7 & 16) == 0) {
                            textStyle2 = textStyle;
                            if (startRestartGroup.changed(textStyle2)) {
                                i18 = 16384;
                                i8 |= i18;
                            }
                        } else {
                            textStyle2 = textStyle;
                        }
                        i18 = 8192;
                        i8 |= i18;
                    } else {
                        textStyle2 = textStyle;
                    }
                    i11 = i7 & 32;
                    if (i11 == 0) {
                        i8 |= 196608;
                    } else if ((196608 & i6) == 0) {
                        textAlign2 = textAlign;
                        i8 |= startRestartGroup.changed(textAlign2) ? 131072 : 65536;
                        i12 = i7 & 64;
                        if (i12 != 0) {
                            i8 |= 1572864;
                        } else if ((i6 & 1572864) == 0) {
                            i8 |= startRestartGroup.changed(i5) ? 1048576 : 524288;
                        }
                        i13 = i7 & 128;
                        if (i13 != 0) {
                            i8 |= 12582912;
                        } else if ((i6 & 12582912) == 0) {
                            i14 = i13;
                            i8 |= startRestartGroup.changed(j5) ? 8388608 : 4194304;
                            if ((i8 & 4793491) != 4793490 && startRestartGroup.getSkipping()) {
                                startRestartGroup.skipToGroupEnd();
                                priceViewType3 = priceViewType2;
                                z7 = z6;
                                i17 = i5;
                                j7 = j5;
                            } else {
                                startRestartGroup.startDefaults();
                                if ((i6 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i19 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i9 != 0) {
                                        priceViewType2 = PriceViewType.PriceAndCurrency;
                                    }
                                    if (i10 != 0) {
                                        z6 = false;
                                    }
                                    if ((i7 & 16) != 0) {
                                        i8 &= -57345;
                                        textStyle2 = (TextStyle) startRestartGroup.consume(TextKt.getLocalTextStyle());
                                    }
                                    if (i11 != 0) {
                                        textAlign2 = null;
                                    }
                                    int i20 = i12 == 0 ? Integer.MAX_VALUE : i5;
                                    if (i14 == 0) {
                                        i15 = i8;
                                        textAlign3 = textAlign2;
                                        j6 = Color.INSTANCE.m1501getUnspecified0d7_KjU();
                                    } else {
                                        j6 = j5;
                                        i15 = i8;
                                        textAlign3 = textAlign2;
                                    }
                                    i16 = i20;
                                    textStyle3 = textStyle2;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i7 & 16) != 0) {
                                        i8 &= -57345;
                                    }
                                    j6 = j5;
                                    i15 = i8;
                                    textStyle3 = textStyle2;
                                    textAlign3 = textAlign2;
                                    i16 = i5;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(85132215, i15, -1, "dk.molslinjen.ui.views.shared.components.PriceText (PriceText.kt:29)");
                                }
                                m3556PriceText1y9Plug(new PriceTotal(price), modifier2, priceViewType2, z6, textStyle3, textAlign3, i16, j6, startRestartGroup, i15 & 33554416, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                textStyle2 = textStyle3;
                                textAlign2 = textAlign3;
                                z7 = z6;
                                j7 = j6;
                                PriceViewType priceViewType4 = priceViewType2;
                                i17 = i16;
                                priceViewType3 = priceViewType4;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                final Modifier modifier3 = modifier2;
                                final TextStyle textStyle4 = textStyle2;
                                final TextAlign textAlign4 = textAlign2;
                                endRestartGroup.updateScope(new Function2() { // from class: w4.k
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit PriceText_1y9Plug$lambda$0;
                                        PriceText_1y9Plug$lambda$0 = PriceTextKt.PriceText_1y9Plug$lambda$0(Price.this, modifier3, priceViewType3, z7, textStyle4, textAlign4, i17, j7, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                                        return PriceText_1y9Plug$lambda$0;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i14 = i13;
                        if ((i8 & 4793491) != 4793490) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i6 & 1) != 0) {
                        }
                        if (i19 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if ((i7 & 16) != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i12 == 0) {
                        }
                        if (i14 == 0) {
                        }
                        i16 = i20;
                        textStyle3 = textStyle2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        m3556PriceText1y9Plug(new PriceTotal(price), modifier2, priceViewType2, z6, textStyle3, textAlign3, i16, j6, startRestartGroup, i15 & 33554416, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        textStyle2 = textStyle3;
                        textAlign2 = textAlign3;
                        z7 = z6;
                        j7 = j6;
                        PriceViewType priceViewType42 = priceViewType2;
                        i17 = i16;
                        priceViewType3 = priceViewType42;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    textAlign2 = textAlign;
                    i12 = i7 & 64;
                    if (i12 != 0) {
                    }
                    i13 = i7 & 128;
                    if (i13 != 0) {
                    }
                    i14 = i13;
                    if ((i8 & 4793491) != 4793490) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i6 & 1) != 0) {
                    }
                    if (i19 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if ((i7 & 16) != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 == 0) {
                    }
                    if (i14 == 0) {
                    }
                    i16 = i20;
                    textStyle3 = textStyle2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    m3556PriceText1y9Plug(new PriceTotal(price), modifier2, priceViewType2, z6, textStyle3, textAlign3, i16, j6, startRestartGroup, i15 & 33554416, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    textStyle2 = textStyle3;
                    textAlign2 = textAlign3;
                    z7 = z6;
                    j7 = j6;
                    PriceViewType priceViewType422 = priceViewType2;
                    i17 = i16;
                    priceViewType3 = priceViewType422;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z6 = z5;
                if ((i6 & 24576) != 0) {
                }
                i11 = i7 & 32;
                if (i11 == 0) {
                }
                textAlign2 = textAlign;
                i12 = i7 & 64;
                if (i12 != 0) {
                }
                i13 = i7 & 128;
                if (i13 != 0) {
                }
                i14 = i13;
                if ((i8 & 4793491) != 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i6 & 1) != 0) {
                }
                if (i19 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if ((i7 & 16) != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 == 0) {
                }
                if (i14 == 0) {
                }
                i16 = i20;
                textStyle3 = textStyle2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                m3556PriceText1y9Plug(new PriceTotal(price), modifier2, priceViewType2, z6, textStyle3, textAlign3, i16, j6, startRestartGroup, i15 & 33554416, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                textStyle2 = textStyle3;
                textAlign2 = textAlign3;
                z7 = z6;
                j7 = j6;
                PriceViewType priceViewType4222 = priceViewType2;
                i17 = i16;
                priceViewType3 = priceViewType4222;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            priceViewType2 = priceViewType;
            i10 = i7 & 8;
            if (i10 != 0) {
            }
            z6 = z5;
            if ((i6 & 24576) != 0) {
            }
            i11 = i7 & 32;
            if (i11 == 0) {
            }
            textAlign2 = textAlign;
            i12 = i7 & 64;
            if (i12 != 0) {
            }
            i13 = i7 & 128;
            if (i13 != 0) {
            }
            i14 = i13;
            if ((i8 & 4793491) != 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i6 & 1) != 0) {
            }
            if (i19 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if ((i7 & 16) != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 == 0) {
            }
            if (i14 == 0) {
            }
            i16 = i20;
            textStyle3 = textStyle2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            m3556PriceText1y9Plug(new PriceTotal(price), modifier2, priceViewType2, z6, textStyle3, textAlign3, i16, j6, startRestartGroup, i15 & 33554416, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            textStyle2 = textStyle3;
            textAlign2 = textAlign3;
            z7 = z6;
            j7 = j6;
            PriceViewType priceViewType42222 = priceViewType2;
            i17 = i16;
            priceViewType3 = priceViewType42222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i9 = i7 & 4;
        if (i9 == 0) {
        }
        priceViewType2 = priceViewType;
        i10 = i7 & 8;
        if (i10 != 0) {
        }
        z6 = z5;
        if ((i6 & 24576) != 0) {
        }
        i11 = i7 & 32;
        if (i11 == 0) {
        }
        textAlign2 = textAlign;
        i12 = i7 & 64;
        if (i12 != 0) {
        }
        i13 = i7 & 128;
        if (i13 != 0) {
        }
        i14 = i13;
        if ((i8 & 4793491) != 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i6 & 1) != 0) {
        }
        if (i19 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if ((i7 & 16) != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 == 0) {
        }
        if (i14 == 0) {
        }
        i16 = i20;
        textStyle3 = textStyle2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        m3556PriceText1y9Plug(new PriceTotal(price), modifier2, priceViewType2, z6, textStyle3, textAlign3, i16, j6, startRestartGroup, i15 & 33554416, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        textStyle2 = textStyle3;
        textAlign2 = textAlign3;
        z7 = z6;
        j7 = j6;
        PriceViewType priceViewType422222 = priceViewType2;
        i17 = i16;
        priceViewType3 = priceViewType422222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PriceText_1y9Plug$lambda$0(Price price, Modifier modifier, PriceViewType priceViewType, boolean z5, TextStyle textStyle, TextAlign textAlign, int i5, long j5, int i6, int i7, Composer composer, int i8) {
        m3557PriceText1y9Plug(price, modifier, priceViewType, z5, textStyle, textAlign, i5, j5, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PriceText_1y9Plug$lambda$1(PriceTotal priceTotal, Modifier modifier, PriceViewType priceViewType, boolean z5, TextStyle textStyle, TextAlign textAlign, int i5, long j5, int i6, int i7, Composer composer, int i8) {
        m3556PriceText1y9Plug(priceTotal, modifier, priceViewType, z5, textStyle, textAlign, i5, j5, composer, RecomposeScopeImplKt.updateChangedFlags(i6 | 1), i7);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00dc  */
    /* renamed from: PriceText-1y9Plug, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3556PriceText1y9Plug(final PriceTotal priceTotal, Modifier modifier, PriceViewType priceViewType, boolean z5, TextStyle textStyle, TextAlign textAlign, int i5, long j5, Composer composer, final int i6, final int i7) {
        int i8;
        int i9;
        PriceViewType priceViewType2;
        int i10;
        int i11;
        TextAlign textAlign2;
        int i12;
        int i13;
        long j6;
        Modifier modifier2;
        PriceViewType priceViewType3;
        boolean z6;
        TextStyle textStyle2;
        final TextAlign textAlign3;
        int i14;
        long j7;
        int i15;
        String formatted$default;
        final PriceViewType priceViewType4;
        final TextStyle textStyle3;
        ScopeUpdateScope endRestartGroup;
        int i16;
        Intrinsics.checkNotNullParameter(priceTotal, "priceTotal");
        Composer startRestartGroup = composer.startRestartGroup(-2112527483);
        if ((i7 & 1) != 0) {
            i8 = i6 | 6;
        } else if ((i6 & 6) == 0) {
            i8 = (startRestartGroup.changedInstance(priceTotal) ? 4 : 2) | i6;
        } else {
            i8 = i6;
        }
        int i17 = i7 & 2;
        if (i17 != 0) {
            i8 |= 48;
        } else if ((i6 & 48) == 0) {
            i8 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i9 = i7 & 4;
            if (i9 == 0) {
                i8 |= 384;
            } else if ((i6 & 384) == 0) {
                priceViewType2 = priceViewType;
                i8 |= startRestartGroup.changed(priceViewType2) ? 256 : 128;
                i10 = i7 & 8;
                if (i10 != 0) {
                    i8 |= 3072;
                } else if ((i6 & 3072) == 0) {
                    i8 |= startRestartGroup.changed(z5) ? 2048 : 1024;
                    if ((i6 & 24576) == 0) {
                        if ((i7 & 16) == 0 && startRestartGroup.changed(textStyle)) {
                            i16 = 16384;
                            i8 |= i16;
                        }
                        i16 = 8192;
                        i8 |= i16;
                    }
                    i11 = i7 & 32;
                    if (i11 == 0) {
                        i8 |= 196608;
                    } else if ((196608 & i6) == 0) {
                        textAlign2 = textAlign;
                        i8 |= startRestartGroup.changed(textAlign2) ? 131072 : 65536;
                        i12 = i7 & 64;
                        if (i12 != 0) {
                            i8 |= 1572864;
                        } else if ((i6 & 1572864) == 0) {
                            i8 |= startRestartGroup.changed(i5) ? 1048576 : 524288;
                        }
                        i13 = i7 & 128;
                        if (i13 != 0) {
                            i8 |= 12582912;
                            j6 = j5;
                        } else {
                            j6 = j5;
                            if ((i6 & 12582912) == 0) {
                                i8 |= startRestartGroup.changed(j6) ? 8388608 : 4194304;
                            }
                        }
                        if ((i8 & 4793491) != 4793490 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            z6 = z5;
                            textStyle3 = textStyle;
                            i14 = i5;
                            priceViewType4 = priceViewType2;
                            j7 = j6;
                            textAlign3 = textAlign2;
                        } else {
                            startRestartGroup.startDefaults();
                            if ((i6 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i7 & 16) != 0) {
                                    i8 &= -57345;
                                }
                                modifier2 = modifier;
                                z6 = z5;
                                i14 = i5;
                                priceViewType3 = priceViewType2;
                                j7 = j6;
                                textAlign3 = textAlign2;
                                textStyle2 = textStyle;
                            } else {
                                modifier2 = i17 != 0 ? Modifier.INSTANCE : modifier;
                                priceViewType3 = i9 != 0 ? PriceViewType.PriceAndCurrency : priceViewType2;
                                z6 = i10 != 0 ? false : z5;
                                if ((i7 & 16) != 0) {
                                    textStyle2 = (TextStyle) startRestartGroup.consume(TextKt.getLocalTextStyle());
                                    i8 &= -57345;
                                } else {
                                    textStyle2 = textStyle;
                                }
                                textAlign3 = i11 != 0 ? null : textAlign2;
                                i14 = i12 != 0 ? Integer.MAX_VALUE : i5;
                                if (i13 != 0) {
                                    j6 = Color.INSTANCE.m1501getUnspecified0d7_KjU();
                                }
                                j7 = j6;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2112527483, i8, -1, "dk.molslinjen.ui.views.shared.components.PriceText (PriceText.kt:52)");
                            }
                            i15 = WhenMappings.$EnumSwitchMapping$0[priceViewType3.ordinal()];
                            if (i15 == 1) {
                                startRestartGroup.startReplaceGroup(-2047091073);
                                formatted$default = PriceFormatExtensionsKt.formatted$default(priceTotal, (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()), false, z6, 2, null);
                                startRestartGroup.endReplaceGroup();
                            } else if (i15 == 2) {
                                startRestartGroup.startReplaceGroup(964856059);
                                formatted$default = PriceFormatExtensionsKt.formatted(priceTotal, (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()), true, z6);
                                startRestartGroup.endReplaceGroup();
                            } else if (i15 == 3) {
                                startRestartGroup.startReplaceGroup(-2047078890);
                                formatted$default = PriceFormatExtensionsKt.firstCurrency(priceTotal, (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()));
                                startRestartGroup.endReplaceGroup();
                            } else {
                                startRestartGroup.startReplaceGroup(-2047093233);
                                startRestartGroup.endReplaceGroup();
                                throw new NoWhenBranchMatchedException();
                            }
                            TextKt.m940Text4IGK_g(formatted$default, modifier2, j7, 0L, null, null, null, 0L, null, textAlign3, 0L, 0, false, i14, 0, null, textStyle2, startRestartGroup, (i8 & 112) | ((i8 >> 15) & 896) | ((i8 << 12) & 1879048192), ((i8 >> 9) & 7168) | ((i8 << 6) & 3670016), 56824);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            priceViewType4 = priceViewType3;
                            textStyle3 = textStyle2;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            final boolean z7 = z6;
                            final int i18 = i14;
                            final long j8 = j7;
                            endRestartGroup.updateScope(new Function2() { // from class: w4.l
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit PriceText_1y9Plug$lambda$1;
                                    PriceText_1y9Plug$lambda$1 = PriceTextKt.PriceText_1y9Plug$lambda$1(PriceTotal.this, modifier3, priceViewType4, z7, textStyle3, textAlign3, i18, j8, i6, i7, (Composer) obj, ((Integer) obj2).intValue());
                                    return PriceText_1y9Plug$lambda$1;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    textAlign2 = textAlign;
                    i12 = i7 & 64;
                    if (i12 != 0) {
                    }
                    i13 = i7 & 128;
                    if (i13 != 0) {
                    }
                    if ((i8 & 4793491) != 4793490) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i6 & 1) == 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if ((i7 & 16) != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    j7 = j6;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    i15 = WhenMappings.$EnumSwitchMapping$0[priceViewType3.ordinal()];
                    if (i15 == 1) {
                    }
                    TextKt.m940Text4IGK_g(formatted$default, modifier2, j7, 0L, null, null, null, 0L, null, textAlign3, 0L, 0, false, i14, 0, null, textStyle2, startRestartGroup, (i8 & 112) | ((i8 >> 15) & 896) | ((i8 << 12) & 1879048192), ((i8 >> 9) & 7168) | ((i8 << 6) & 3670016), 56824);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    priceViewType4 = priceViewType3;
                    textStyle3 = textStyle2;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                if ((i6 & 24576) == 0) {
                }
                i11 = i7 & 32;
                if (i11 == 0) {
                }
                textAlign2 = textAlign;
                i12 = i7 & 64;
                if (i12 != 0) {
                }
                i13 = i7 & 128;
                if (i13 != 0) {
                }
                if ((i8 & 4793491) != 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i6 & 1) == 0) {
                }
                if (i17 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if ((i7 & 16) != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i13 != 0) {
                }
                j7 = j6;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                i15 = WhenMappings.$EnumSwitchMapping$0[priceViewType3.ordinal()];
                if (i15 == 1) {
                }
                TextKt.m940Text4IGK_g(formatted$default, modifier2, j7, 0L, null, null, null, 0L, null, textAlign3, 0L, 0, false, i14, 0, null, textStyle2, startRestartGroup, (i8 & 112) | ((i8 >> 15) & 896) | ((i8 << 12) & 1879048192), ((i8 >> 9) & 7168) | ((i8 << 6) & 3670016), 56824);
                if (ComposerKt.isTraceInProgress()) {
                }
                priceViewType4 = priceViewType3;
                textStyle3 = textStyle2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            priceViewType2 = priceViewType;
            i10 = i7 & 8;
            if (i10 != 0) {
            }
            if ((i6 & 24576) == 0) {
            }
            i11 = i7 & 32;
            if (i11 == 0) {
            }
            textAlign2 = textAlign;
            i12 = i7 & 64;
            if (i12 != 0) {
            }
            i13 = i7 & 128;
            if (i13 != 0) {
            }
            if ((i8 & 4793491) != 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i6 & 1) == 0) {
            }
            if (i17 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if ((i7 & 16) != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i13 != 0) {
            }
            j7 = j6;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            i15 = WhenMappings.$EnumSwitchMapping$0[priceViewType3.ordinal()];
            if (i15 == 1) {
            }
            TextKt.m940Text4IGK_g(formatted$default, modifier2, j7, 0L, null, null, null, 0L, null, textAlign3, 0L, 0, false, i14, 0, null, textStyle2, startRestartGroup, (i8 & 112) | ((i8 >> 15) & 896) | ((i8 << 12) & 1879048192), ((i8 >> 9) & 7168) | ((i8 << 6) & 3670016), 56824);
            if (ComposerKt.isTraceInProgress()) {
            }
            priceViewType4 = priceViewType3;
            textStyle3 = textStyle2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i9 = i7 & 4;
        if (i9 == 0) {
        }
        priceViewType2 = priceViewType;
        i10 = i7 & 8;
        if (i10 != 0) {
        }
        if ((i6 & 24576) == 0) {
        }
        i11 = i7 & 32;
        if (i11 == 0) {
        }
        textAlign2 = textAlign;
        i12 = i7 & 64;
        if (i12 != 0) {
        }
        i13 = i7 & 128;
        if (i13 != 0) {
        }
        if ((i8 & 4793491) != 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i6 & 1) == 0) {
        }
        if (i17 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if ((i7 & 16) != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i13 != 0) {
        }
        j7 = j6;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        i15 = WhenMappings.$EnumSwitchMapping$0[priceViewType3.ordinal()];
        if (i15 == 1) {
        }
        TextKt.m940Text4IGK_g(formatted$default, modifier2, j7, 0L, null, null, null, 0L, null, textAlign3, 0L, 0, false, i14, 0, null, textStyle2, startRestartGroup, (i8 & 112) | ((i8 >> 15) & 896) | ((i8 << 12) & 1879048192), ((i8 >> 9) & 7168) | ((i8 << 6) & 3670016), 56824);
        if (ComposerKt.isTraceInProgress()) {
        }
        priceViewType4 = priceViewType3;
        textStyle3 = textStyle2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
