package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.FontWeight;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/text/font/FontMatcher;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/font/Font;", "fontList", "Landroidx/compose/ui/text/font/FontWeight;", "fontWeight", "Landroidx/compose/ui/text/font/FontStyle;", "fontStyle", "matchFont-RetOiIg", "(Ljava/util/List;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "matchFont", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FontMatcher {
    /* renamed from: matchFont-RetOiIg, reason: not valid java name */
    public final List<Font> m2335matchFontRetOiIg(List<? extends Font> fontList, FontWeight fontWeight, int fontStyle) {
        ArrayList arrayList = new ArrayList(fontList.size());
        int size = fontList.size();
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            Font font = fontList.get(i6);
            Font font2 = font;
            if (Intrinsics.areEqual(font2.getWeight(), fontWeight) && FontStyle.m2339equalsimpl0(font2.mo2323getStyle_LCdwA(), fontStyle)) {
                arrayList.add(font);
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(fontList.size());
        int size2 = fontList.size();
        for (int i7 = 0; i7 < size2; i7++) {
            Font font3 = fontList.get(i7);
            if (FontStyle.m2339equalsimpl0(font3.mo2323getStyle_LCdwA(), fontStyle)) {
                arrayList2.add(font3);
            }
        }
        if (!arrayList2.isEmpty()) {
            fontList = arrayList2;
        }
        List<? extends Font> list = fontList;
        FontWeight.Companion companion = FontWeight.INSTANCE;
        FontWeight fontWeight2 = null;
        if (fontWeight.compareTo(companion.getW400()) < 0) {
            int size3 = list.size();
            FontWeight fontWeight3 = null;
            int i8 = 0;
            while (true) {
                if (i8 >= size3) {
                    break;
                }
                FontWeight weight = list.get(i8).getWeight();
                if (weight.compareTo(fontWeight) >= 0) {
                    if (weight.compareTo(fontWeight) <= 0) {
                        fontWeight3 = weight;
                        fontWeight2 = fontWeight3;
                        break;
                    }
                    if (fontWeight3 == null || weight.compareTo(fontWeight3) < 0) {
                        fontWeight3 = weight;
                    }
                } else if (fontWeight2 == null || weight.compareTo(fontWeight2) > 0) {
                    fontWeight2 = weight;
                }
                i8++;
            }
            if (fontWeight2 != null) {
                fontWeight3 = fontWeight2;
            }
            ArrayList arrayList3 = new ArrayList(list.size());
            int size4 = list.size();
            while (i5 < size4) {
                Font font4 = list.get(i5);
                if (Intrinsics.areEqual(font4.getWeight(), fontWeight3)) {
                    arrayList3.add(font4);
                }
                i5++;
            }
            return arrayList3;
        }
        if (fontWeight.compareTo(companion.getW500()) > 0) {
            int size5 = list.size();
            FontWeight fontWeight4 = null;
            int i9 = 0;
            while (true) {
                if (i9 >= size5) {
                    break;
                }
                FontWeight weight2 = list.get(i9).getWeight();
                if (weight2.compareTo(fontWeight) >= 0) {
                    if (weight2.compareTo(fontWeight) <= 0) {
                        fontWeight4 = weight2;
                        fontWeight2 = fontWeight4;
                        break;
                    }
                    if (fontWeight4 == null || weight2.compareTo(fontWeight4) < 0) {
                        fontWeight4 = weight2;
                    }
                } else if (fontWeight2 == null || weight2.compareTo(fontWeight2) > 0) {
                    fontWeight2 = weight2;
                }
                i9++;
            }
            if (fontWeight4 == null) {
                fontWeight4 = fontWeight2;
            }
            ArrayList arrayList4 = new ArrayList(list.size());
            int size6 = list.size();
            while (i5 < size6) {
                Font font5 = list.get(i5);
                if (Intrinsics.areEqual(font5.getWeight(), fontWeight4)) {
                    arrayList4.add(font5);
                }
                i5++;
            }
            return arrayList4;
        }
        FontWeight w500 = companion.getW500();
        int size7 = list.size();
        FontWeight fontWeight5 = null;
        FontWeight fontWeight6 = null;
        int i10 = 0;
        while (true) {
            if (i10 >= size7) {
                break;
            }
            FontWeight weight3 = list.get(i10).getWeight();
            if (w500 == null || weight3.compareTo(w500) <= 0) {
                if (weight3.compareTo(fontWeight) >= 0) {
                    if (weight3.compareTo(fontWeight) <= 0) {
                        fontWeight5 = weight3;
                        fontWeight6 = fontWeight5;
                        break;
                    }
                    if (fontWeight6 == null || weight3.compareTo(fontWeight6) < 0) {
                        fontWeight6 = weight3;
                    }
                } else if (fontWeight5 == null || weight3.compareTo(fontWeight5) > 0) {
                    fontWeight5 = weight3;
                }
            }
            i10++;
        }
        if (fontWeight6 != null) {
            fontWeight5 = fontWeight6;
        }
        ArrayList arrayList5 = new ArrayList(list.size());
        int size8 = list.size();
        for (int i11 = 0; i11 < size8; i11++) {
            Font font6 = list.get(i11);
            if (Intrinsics.areEqual(font6.getWeight(), fontWeight5)) {
                arrayList5.add(font6);
            }
        }
        if (!arrayList5.isEmpty()) {
            return arrayList5;
        }
        FontWeight w5002 = FontWeight.INSTANCE.getW500();
        int size9 = list.size();
        FontWeight fontWeight7 = null;
        int i12 = 0;
        while (true) {
            if (i12 >= size9) {
                break;
            }
            FontWeight weight4 = list.get(i12).getWeight();
            if (w5002 == null || weight4.compareTo(w5002) >= 0) {
                if (weight4.compareTo(fontWeight) >= 0) {
                    if (weight4.compareTo(fontWeight) <= 0) {
                        fontWeight2 = weight4;
                        fontWeight7 = fontWeight2;
                        break;
                    }
                    if (fontWeight7 == null || weight4.compareTo(fontWeight7) < 0) {
                        fontWeight7 = weight4;
                    }
                } else if (fontWeight2 == null || weight4.compareTo(fontWeight2) > 0) {
                    fontWeight2 = weight4;
                }
            }
            i12++;
        }
        if (fontWeight7 != null) {
            fontWeight2 = fontWeight7;
        }
        ArrayList arrayList6 = new ArrayList(list.size());
        int size10 = list.size();
        while (i5 < size10) {
            Font font7 = list.get(i5);
            if (Intrinsics.areEqual(font7.getWeight(), fontWeight2)) {
                arrayList6.add(font7);
            }
            i5++;
        }
        return arrayList6;
    }
}
