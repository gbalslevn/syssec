package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.core.R$styleable;
import androidx.core.provider.FontRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public abstract class FontResourcesParserCompat {
    private static final int DEFAULT_TIMEOUT_MILLIS = 500;
    private static final int ITALIC = 1;
    private static final int NORMAL_WEIGHT = 400;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api21Impl {
        static int getType(TypedArray typedArray, int i5) {
            return typedArray.getType(i5);
        }
    }

    /* loaded from: classes.dex */
    public interface FamilyResourceEntry {
    }

    /* loaded from: classes.dex */
    public static final class FontFamilyFilesResourceEntry implements FamilyResourceEntry {
        private final FontFileResourceEntry[] mEntries;

        public FontFamilyFilesResourceEntry(FontFileResourceEntry[] fontFileResourceEntryArr) {
            this.mEntries = fontFileResourceEntryArr;
        }

        public FontFileResourceEntry[] getEntries() {
            return this.mEntries;
        }
    }

    /* loaded from: classes.dex */
    public static final class FontFileResourceEntry {
        private final String mFileName;
        private final boolean mItalic;
        private final int mResourceId;
        private final int mTtcIndex;
        private final String mVariationSettings;
        private final int mWeight;

        public FontFileResourceEntry(String str, int i5, boolean z5, String str2, int i6, int i7) {
            this.mFileName = str;
            this.mWeight = i5;
            this.mItalic = z5;
            this.mVariationSettings = str2;
            this.mTtcIndex = i6;
            this.mResourceId = i7;
        }

        public String getFileName() {
            return this.mFileName;
        }

        public int getResourceId() {
            return this.mResourceId;
        }

        public int getTtcIndex() {
            return this.mTtcIndex;
        }

        public String getVariationSettings() {
            return this.mVariationSettings;
        }

        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }
    }

    /* loaded from: classes.dex */
    public static final class ProviderResourceEntry implements FamilyResourceEntry {
        private final FontRequest mFallbackRequest;
        private final FontRequest mRequest;
        private final int mStrategy;
        private final String mSystemFontFamilyName;
        private final int mTimeoutMs;

        public ProviderResourceEntry(FontRequest fontRequest, FontRequest fontRequest2, int i5, int i6, String str) {
            this.mRequest = fontRequest;
            this.mFallbackRequest = fontRequest2;
            this.mStrategy = i5;
            this.mTimeoutMs = i6;
            this.mSystemFontFamilyName = str;
        }

        public FontRequest getFallbackRequest() {
            return this.mFallbackRequest;
        }

        public int getFetchStrategy() {
            return this.mStrategy;
        }

        public FontRequest getRequest() {
            return this.mRequest;
        }

        public String getSystemFontFamilyName() {
            return this.mSystemFontFamilyName;
        }

        public int getTimeout() {
            return this.mTimeoutMs;
        }
    }

    private static int getType(TypedArray typedArray, int i5) {
        return Api21Impl.getType(typedArray, i5);
    }

    public static FamilyResourceEntry parse(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return readFamilies(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> readCerts(Resources resources, int i5) {
        if (i5 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i5);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (getType(obtainTypedArray, 0) == 1) {
                for (int i6 = 0; i6 < obtainTypedArray.length(); i6++) {
                    int resourceId = obtainTypedArray.getResourceId(i6, 0);
                    if (resourceId != 0) {
                        arrayList.add(toByteArrayList(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(toByteArrayList(resources.getStringArray(i5)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static FamilyResourceEntry readFamilies(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return readFamily(xmlPullParser, resources);
        }
        skip(xmlPullParser);
        return null;
    }

    private static FamilyResourceEntry readFamily(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamily);
        String string = obtainAttributes.getString(R$styleable.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderQuery);
        String string4 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderFallbackQuery);
        int resourceId = obtainAttributes.getResourceId(R$styleable.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchTimeout, DEFAULT_TIMEOUT_MILLIS);
        String string5 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderSystemFontFamily);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                skip(xmlPullParser);
            }
            List<List<byte[]>> readCerts = readCerts(resources, resourceId);
            return new ProviderResourceEntry(new FontRequest(string, string2, string3, readCerts), string4 != null ? new FontRequest(string, string2, string4, readCerts) : null, integer, integer2, string5);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(readFont(xmlPullParser, resources));
                } else {
                    skip(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new FontFamilyFilesResourceEntry((FontFileResourceEntry[]) arrayList.toArray(new FontFileResourceEntry[0]));
    }

    private static FontFileResourceEntry readFont(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.FontFamilyFont);
        int i5 = R$styleable.FontFamilyFont_fontWeight;
        if (!obtainAttributes.hasValue(i5)) {
            i5 = R$styleable.FontFamilyFont_android_fontWeight;
        }
        int i6 = obtainAttributes.getInt(i5, 400);
        int i7 = R$styleable.FontFamilyFont_fontStyle;
        if (!obtainAttributes.hasValue(i7)) {
            i7 = R$styleable.FontFamilyFont_android_fontStyle;
        }
        boolean z5 = 1 == obtainAttributes.getInt(i7, 0);
        int i8 = R$styleable.FontFamilyFont_ttcIndex;
        if (!obtainAttributes.hasValue(i8)) {
            i8 = R$styleable.FontFamilyFont_android_ttcIndex;
        }
        int i9 = R$styleable.FontFamilyFont_fontVariationSettings;
        if (!obtainAttributes.hasValue(i9)) {
            i9 = R$styleable.FontFamilyFont_android_fontVariationSettings;
        }
        String string = obtainAttributes.getString(i9);
        int i10 = obtainAttributes.getInt(i8, 0);
        int i11 = R$styleable.FontFamilyFont_font;
        if (!obtainAttributes.hasValue(i11)) {
            i11 = R$styleable.FontFamilyFont_android_font;
        }
        int resourceId = obtainAttributes.getResourceId(i11, 0);
        String string2 = obtainAttributes.getString(i11);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            skip(xmlPullParser);
        }
        return new FontFileResourceEntry(string2, i6, z5, string, i10, resourceId);
    }

    private static void skip(XmlPullParser xmlPullParser) {
        int i5 = 1;
        while (i5 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i5++;
            } else if (next == 3) {
                i5--;
            }
        }
    }

    private static List<byte[]> toByteArrayList(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
