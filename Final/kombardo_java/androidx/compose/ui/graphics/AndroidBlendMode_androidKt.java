package androidx.compose.ui.graphics;

import android.graphics.PorterDuff;
import androidx.appcompat.R$styleable;
import androidx.compose.ui.graphics.BlendMode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0016\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0016\u0010\b\u001a\u00020\u0005*\u00020\u0000H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\t\u001a\u00020\u0000*\u00020\u0005H\u0001¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/graphics/BlendMode;", "Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode-s9anfk8", "(I)Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode", "Landroid/graphics/BlendMode;", "toAndroidBlendMode-s9anfk8", "(I)Landroid/graphics/BlendMode;", "toAndroidBlendMode", "toComposeBlendMode", "(Landroid/graphics/BlendMode;)I", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AndroidBlendMode_androidKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            android.graphics.BlendMode[] values;
            android.graphics.BlendMode blendMode;
            int ordinal;
            android.graphics.BlendMode blendMode2;
            int ordinal2;
            android.graphics.BlendMode blendMode3;
            int ordinal3;
            android.graphics.BlendMode blendMode4;
            int ordinal4;
            android.graphics.BlendMode blendMode5;
            int ordinal5;
            android.graphics.BlendMode blendMode6;
            int ordinal6;
            android.graphics.BlendMode blendMode7;
            int ordinal7;
            android.graphics.BlendMode blendMode8;
            int ordinal8;
            android.graphics.BlendMode blendMode9;
            int ordinal9;
            android.graphics.BlendMode blendMode10;
            int ordinal10;
            android.graphics.BlendMode blendMode11;
            int ordinal11;
            android.graphics.BlendMode blendMode12;
            int ordinal12;
            android.graphics.BlendMode blendMode13;
            int ordinal13;
            android.graphics.BlendMode blendMode14;
            int ordinal14;
            android.graphics.BlendMode blendMode15;
            int ordinal15;
            android.graphics.BlendMode blendMode16;
            int ordinal16;
            android.graphics.BlendMode blendMode17;
            int ordinal17;
            android.graphics.BlendMode blendMode18;
            int ordinal18;
            android.graphics.BlendMode blendMode19;
            int ordinal19;
            android.graphics.BlendMode blendMode20;
            int ordinal20;
            android.graphics.BlendMode blendMode21;
            int ordinal21;
            android.graphics.BlendMode blendMode22;
            int ordinal22;
            android.graphics.BlendMode blendMode23;
            int ordinal23;
            android.graphics.BlendMode blendMode24;
            int ordinal24;
            android.graphics.BlendMode blendMode25;
            int ordinal25;
            android.graphics.BlendMode blendMode26;
            int ordinal26;
            android.graphics.BlendMode blendMode27;
            int ordinal27;
            android.graphics.BlendMode blendMode28;
            int ordinal28;
            android.graphics.BlendMode blendMode29;
            int ordinal29;
            values = android.graphics.BlendMode.values();
            int[] iArr = new int[values.length];
            try {
                blendMode29 = android.graphics.BlendMode.CLEAR;
                ordinal29 = blendMode29.ordinal();
                iArr[ordinal29] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                blendMode28 = android.graphics.BlendMode.SRC;
                ordinal28 = blendMode28.ordinal();
                iArr[ordinal28] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                blendMode27 = android.graphics.BlendMode.DST;
                ordinal27 = blendMode27.ordinal();
                iArr[ordinal27] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                blendMode26 = android.graphics.BlendMode.SRC_OVER;
                ordinal26 = blendMode26.ordinal();
                iArr[ordinal26] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                blendMode25 = android.graphics.BlendMode.DST_OVER;
                ordinal25 = blendMode25.ordinal();
                iArr[ordinal25] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                blendMode24 = android.graphics.BlendMode.SRC_IN;
                ordinal24 = blendMode24.ordinal();
                iArr[ordinal24] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                blendMode23 = android.graphics.BlendMode.DST_IN;
                ordinal23 = blendMode23.ordinal();
                iArr[ordinal23] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                blendMode22 = android.graphics.BlendMode.SRC_OUT;
                ordinal22 = blendMode22.ordinal();
                iArr[ordinal22] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                blendMode21 = android.graphics.BlendMode.DST_OUT;
                ordinal21 = blendMode21.ordinal();
                iArr[ordinal21] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                blendMode20 = android.graphics.BlendMode.SRC_ATOP;
                ordinal20 = blendMode20.ordinal();
                iArr[ordinal20] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                blendMode19 = android.graphics.BlendMode.DST_ATOP;
                ordinal19 = blendMode19.ordinal();
                iArr[ordinal19] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                blendMode18 = android.graphics.BlendMode.XOR;
                ordinal18 = blendMode18.ordinal();
                iArr[ordinal18] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                blendMode17 = android.graphics.BlendMode.PLUS;
                ordinal17 = blendMode17.ordinal();
                iArr[ordinal17] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                blendMode16 = android.graphics.BlendMode.MODULATE;
                ordinal16 = blendMode16.ordinal();
                iArr[ordinal16] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                blendMode15 = android.graphics.BlendMode.SCREEN;
                ordinal15 = blendMode15.ordinal();
                iArr[ordinal15] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                blendMode14 = android.graphics.BlendMode.OVERLAY;
                ordinal14 = blendMode14.ordinal();
                iArr[ordinal14] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                blendMode13 = android.graphics.BlendMode.DARKEN;
                ordinal13 = blendMode13.ordinal();
                iArr[ordinal13] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                blendMode12 = android.graphics.BlendMode.LIGHTEN;
                ordinal12 = blendMode12.ordinal();
                iArr[ordinal12] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                blendMode11 = android.graphics.BlendMode.COLOR_DODGE;
                ordinal11 = blendMode11.ordinal();
                iArr[ordinal11] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                blendMode10 = android.graphics.BlendMode.COLOR_BURN;
                ordinal10 = blendMode10.ordinal();
                iArr[ordinal10] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                blendMode9 = android.graphics.BlendMode.HARD_LIGHT;
                ordinal9 = blendMode9.ordinal();
                iArr[ordinal9] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                blendMode8 = android.graphics.BlendMode.SOFT_LIGHT;
                ordinal8 = blendMode8.ordinal();
                iArr[ordinal8] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                blendMode7 = android.graphics.BlendMode.DIFFERENCE;
                ordinal7 = blendMode7.ordinal();
                iArr[ordinal7] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                blendMode6 = android.graphics.BlendMode.EXCLUSION;
                ordinal6 = blendMode6.ordinal();
                iArr[ordinal6] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                blendMode5 = android.graphics.BlendMode.MULTIPLY;
                ordinal5 = blendMode5.ordinal();
                iArr[ordinal5] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                blendMode4 = android.graphics.BlendMode.HUE;
                ordinal4 = blendMode4.ordinal();
                iArr[ordinal4] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                blendMode3 = android.graphics.BlendMode.SATURATION;
                ordinal3 = blendMode3.ordinal();
                iArr[ordinal3] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                blendMode2 = android.graphics.BlendMode.COLOR;
                ordinal2 = blendMode2.ordinal();
                iArr[ordinal2] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                blendMode = android.graphics.BlendMode.LUMINOSITY;
                ordinal = blendMode.ordinal();
                iArr[ordinal] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: toAndroidBlendMode-s9anfk8, reason: not valid java name */
    public static final android.graphics.BlendMode m1387toAndroidBlendModes9anfk8(int i5) {
        android.graphics.BlendMode blendMode;
        android.graphics.BlendMode blendMode2;
        android.graphics.BlendMode blendMode3;
        android.graphics.BlendMode blendMode4;
        android.graphics.BlendMode blendMode5;
        android.graphics.BlendMode blendMode6;
        android.graphics.BlendMode blendMode7;
        android.graphics.BlendMode blendMode8;
        android.graphics.BlendMode blendMode9;
        android.graphics.BlendMode blendMode10;
        android.graphics.BlendMode blendMode11;
        android.graphics.BlendMode blendMode12;
        android.graphics.BlendMode blendMode13;
        android.graphics.BlendMode blendMode14;
        android.graphics.BlendMode blendMode15;
        android.graphics.BlendMode blendMode16;
        android.graphics.BlendMode blendMode17;
        android.graphics.BlendMode blendMode18;
        android.graphics.BlendMode blendMode19;
        android.graphics.BlendMode blendMode20;
        android.graphics.BlendMode blendMode21;
        android.graphics.BlendMode blendMode22;
        android.graphics.BlendMode blendMode23;
        android.graphics.BlendMode blendMode24;
        android.graphics.BlendMode blendMode25;
        android.graphics.BlendMode blendMode26;
        android.graphics.BlendMode blendMode27;
        android.graphics.BlendMode blendMode28;
        android.graphics.BlendMode blendMode29;
        android.graphics.BlendMode blendMode30;
        BlendMode.Companion companion = BlendMode.INSTANCE;
        if (BlendMode.m1429equalsimpl0(i5, companion.m1432getClear0nO6VwU())) {
            blendMode30 = android.graphics.BlendMode.CLEAR;
            return blendMode30;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1455getSrc0nO6VwU())) {
            blendMode29 = android.graphics.BlendMode.SRC;
            return blendMode29;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1438getDst0nO6VwU())) {
            blendMode28 = android.graphics.BlendMode.DST;
            return blendMode28;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1459getSrcOver0nO6VwU())) {
            blendMode27 = android.graphics.BlendMode.SRC_OVER;
            return blendMode27;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1442getDstOver0nO6VwU())) {
            blendMode26 = android.graphics.BlendMode.DST_OVER;
            return blendMode26;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1457getSrcIn0nO6VwU())) {
            blendMode25 = android.graphics.BlendMode.SRC_IN;
            return blendMode25;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1440getDstIn0nO6VwU())) {
            blendMode24 = android.graphics.BlendMode.DST_IN;
            return blendMode24;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1458getSrcOut0nO6VwU())) {
            blendMode23 = android.graphics.BlendMode.SRC_OUT;
            return blendMode23;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1441getDstOut0nO6VwU())) {
            blendMode22 = android.graphics.BlendMode.DST_OUT;
            return blendMode22;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1456getSrcAtop0nO6VwU())) {
            blendMode21 = android.graphics.BlendMode.SRC_ATOP;
            return blendMode21;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1439getDstAtop0nO6VwU())) {
            blendMode20 = android.graphics.BlendMode.DST_ATOP;
            return blendMode20;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1460getXor0nO6VwU())) {
            blendMode19 = android.graphics.BlendMode.XOR;
            return blendMode19;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1451getPlus0nO6VwU())) {
            blendMode18 = android.graphics.BlendMode.PLUS;
            return blendMode18;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1448getModulate0nO6VwU())) {
            blendMode17 = android.graphics.BlendMode.MODULATE;
            return blendMode17;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1453getScreen0nO6VwU())) {
            blendMode16 = android.graphics.BlendMode.SCREEN;
            return blendMode16;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1450getOverlay0nO6VwU())) {
            blendMode15 = android.graphics.BlendMode.OVERLAY;
            return blendMode15;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1436getDarken0nO6VwU())) {
            blendMode14 = android.graphics.BlendMode.DARKEN;
            return blendMode14;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1446getLighten0nO6VwU())) {
            blendMode13 = android.graphics.BlendMode.LIGHTEN;
            return blendMode13;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1435getColorDodge0nO6VwU())) {
            blendMode12 = android.graphics.BlendMode.COLOR_DODGE;
            return blendMode12;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1434getColorBurn0nO6VwU())) {
            blendMode11 = android.graphics.BlendMode.COLOR_BURN;
            return blendMode11;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1444getHardlight0nO6VwU())) {
            blendMode10 = android.graphics.BlendMode.HARD_LIGHT;
            return blendMode10;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1454getSoftlight0nO6VwU())) {
            blendMode9 = android.graphics.BlendMode.SOFT_LIGHT;
            return blendMode9;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1437getDifference0nO6VwU())) {
            blendMode8 = android.graphics.BlendMode.DIFFERENCE;
            return blendMode8;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1443getExclusion0nO6VwU())) {
            blendMode7 = android.graphics.BlendMode.EXCLUSION;
            return blendMode7;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1449getMultiply0nO6VwU())) {
            blendMode6 = android.graphics.BlendMode.MULTIPLY;
            return blendMode6;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1445getHue0nO6VwU())) {
            blendMode5 = android.graphics.BlendMode.HUE;
            return blendMode5;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1452getSaturation0nO6VwU())) {
            blendMode4 = android.graphics.BlendMode.SATURATION;
            return blendMode4;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1433getColor0nO6VwU())) {
            blendMode3 = android.graphics.BlendMode.COLOR;
            return blendMode3;
        }
        if (BlendMode.m1429equalsimpl0(i5, companion.m1447getLuminosity0nO6VwU())) {
            blendMode2 = android.graphics.BlendMode.LUMINOSITY;
            return blendMode2;
        }
        blendMode = android.graphics.BlendMode.SRC_OVER;
        return blendMode;
    }

    public static final int toComposeBlendMode(android.graphics.BlendMode blendMode) {
        int ordinal;
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        ordinal = blendMode.ordinal();
        switch (iArr[ordinal]) {
            case 1:
                return BlendMode.INSTANCE.m1432getClear0nO6VwU();
            case 2:
                return BlendMode.INSTANCE.m1455getSrc0nO6VwU();
            case 3:
                return BlendMode.INSTANCE.m1438getDst0nO6VwU();
            case 4:
                return BlendMode.INSTANCE.m1459getSrcOver0nO6VwU();
            case 5:
                return BlendMode.INSTANCE.m1442getDstOver0nO6VwU();
            case 6:
                return BlendMode.INSTANCE.m1457getSrcIn0nO6VwU();
            case 7:
                return BlendMode.INSTANCE.m1440getDstIn0nO6VwU();
            case 8:
                return BlendMode.INSTANCE.m1458getSrcOut0nO6VwU();
            case 9:
                return BlendMode.INSTANCE.m1441getDstOut0nO6VwU();
            case 10:
                return BlendMode.INSTANCE.m1456getSrcAtop0nO6VwU();
            case 11:
                return BlendMode.INSTANCE.m1439getDstAtop0nO6VwU();
            case 12:
                return BlendMode.INSTANCE.m1460getXor0nO6VwU();
            case 13:
                return BlendMode.INSTANCE.m1451getPlus0nO6VwU();
            case 14:
                return BlendMode.INSTANCE.m1448getModulate0nO6VwU();
            case 15:
                return BlendMode.INSTANCE.m1453getScreen0nO6VwU();
            case 16:
                return BlendMode.INSTANCE.m1450getOverlay0nO6VwU();
            case 17:
                return BlendMode.INSTANCE.m1436getDarken0nO6VwU();
            case 18:
                return BlendMode.INSTANCE.m1446getLighten0nO6VwU();
            case 19:
                return BlendMode.INSTANCE.m1435getColorDodge0nO6VwU();
            case 20:
                return BlendMode.INSTANCE.m1434getColorBurn0nO6VwU();
            case 21:
                return BlendMode.INSTANCE.m1444getHardlight0nO6VwU();
            case 22:
                return BlendMode.INSTANCE.m1454getSoftlight0nO6VwU();
            case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                return BlendMode.INSTANCE.m1437getDifference0nO6VwU();
            case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                return BlendMode.INSTANCE.m1443getExclusion0nO6VwU();
            case 25:
                return BlendMode.INSTANCE.m1449getMultiply0nO6VwU();
            case 26:
                return BlendMode.INSTANCE.m1445getHue0nO6VwU();
            case 27:
                return BlendMode.INSTANCE.m1452getSaturation0nO6VwU();
            case 28:
                return BlendMode.INSTANCE.m1433getColor0nO6VwU();
            case R$styleable.Toolbar_titleTextColor /* 29 */:
                return BlendMode.INSTANCE.m1447getLuminosity0nO6VwU();
            default:
                return BlendMode.INSTANCE.m1459getSrcOver0nO6VwU();
        }
    }

    /* renamed from: toPorterDuffMode-s9anfk8, reason: not valid java name */
    public static final PorterDuff.Mode m1388toPorterDuffModes9anfk8(int i5) {
        BlendMode.Companion companion = BlendMode.INSTANCE;
        return BlendMode.m1429equalsimpl0(i5, companion.m1432getClear0nO6VwU()) ? PorterDuff.Mode.CLEAR : BlendMode.m1429equalsimpl0(i5, companion.m1455getSrc0nO6VwU()) ? PorterDuff.Mode.SRC : BlendMode.m1429equalsimpl0(i5, companion.m1438getDst0nO6VwU()) ? PorterDuff.Mode.DST : BlendMode.m1429equalsimpl0(i5, companion.m1459getSrcOver0nO6VwU()) ? PorterDuff.Mode.SRC_OVER : BlendMode.m1429equalsimpl0(i5, companion.m1442getDstOver0nO6VwU()) ? PorterDuff.Mode.DST_OVER : BlendMode.m1429equalsimpl0(i5, companion.m1457getSrcIn0nO6VwU()) ? PorterDuff.Mode.SRC_IN : BlendMode.m1429equalsimpl0(i5, companion.m1440getDstIn0nO6VwU()) ? PorterDuff.Mode.DST_IN : BlendMode.m1429equalsimpl0(i5, companion.m1458getSrcOut0nO6VwU()) ? PorterDuff.Mode.SRC_OUT : BlendMode.m1429equalsimpl0(i5, companion.m1441getDstOut0nO6VwU()) ? PorterDuff.Mode.DST_OUT : BlendMode.m1429equalsimpl0(i5, companion.m1456getSrcAtop0nO6VwU()) ? PorterDuff.Mode.SRC_ATOP : BlendMode.m1429equalsimpl0(i5, companion.m1439getDstAtop0nO6VwU()) ? PorterDuff.Mode.DST_ATOP : BlendMode.m1429equalsimpl0(i5, companion.m1460getXor0nO6VwU()) ? PorterDuff.Mode.XOR : BlendMode.m1429equalsimpl0(i5, companion.m1451getPlus0nO6VwU()) ? PorterDuff.Mode.ADD : BlendMode.m1429equalsimpl0(i5, companion.m1453getScreen0nO6VwU()) ? PorterDuff.Mode.SCREEN : BlendMode.m1429equalsimpl0(i5, companion.m1450getOverlay0nO6VwU()) ? PorterDuff.Mode.OVERLAY : BlendMode.m1429equalsimpl0(i5, companion.m1436getDarken0nO6VwU()) ? PorterDuff.Mode.DARKEN : BlendMode.m1429equalsimpl0(i5, companion.m1446getLighten0nO6VwU()) ? PorterDuff.Mode.LIGHTEN : BlendMode.m1429equalsimpl0(i5, companion.m1448getModulate0nO6VwU()) ? PorterDuff.Mode.MULTIPLY : PorterDuff.Mode.SRC_OVER;
    }
}
