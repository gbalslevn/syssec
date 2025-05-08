package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import com.adjust.sdk.Constants;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class TypefaceCompatBaseImpl {
    private static final int INVALID_KEY = 0;
    private static final String TAG = "TypefaceCompatBaseImpl";

    @SuppressLint({"BanConcurrentHashMap"})
    private ConcurrentHashMap<Long, FontResourcesParserCompat.FontFamilyFilesResourceEntry> mFontFamilies = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface StyleExtractor<T> {
        int getWeight(T t5);

        boolean isItalic(T t5);
    }

    private static <T> T findBestFont(T[] tArr, int i5, StyleExtractor<T> styleExtractor) {
        return (T) findBestFont(tArr, (i5 & 1) == 0 ? Constants.MINIMAL_ERROR_STATUS_CODE : 700, (i5 & 2) != 0, styleExtractor);
    }

    public abstract Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i5);

    public abstract Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i5);

    public Typeface createFromFontInfoWithFallback(Context context, CancellationSignal cancellationSignal, List<FontsContractCompat.FontInfo[]> list, int i5) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i5, String str, int i6) {
        File tempFile = TypefaceCompatUtil.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (TypefaceCompatUtil.copyToFile(tempFile, resources, i5)) {
                return Typeface.createFromFile(tempFile.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] fontInfoArr, int i5) {
        return (FontsContractCompat.FontInfo) findBestFont(fontInfoArr, i5, new StyleExtractor<FontsContractCompat.FontInfo>() { // from class: androidx.core.graphics.TypefaceCompatBaseImpl.1
            @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
            public int getWeight(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.getWeight();
            }

            @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
            public boolean isItalic(FontsContractCompat.FontInfo fontInfo) {
                return fontInfo.isItalic();
            }
        });
    }

    private static <T> T findBestFont(T[] tArr, int i5, boolean z5, StyleExtractor<T> styleExtractor) {
        T t5 = null;
        int i6 = Integer.MAX_VALUE;
        for (T t6 : tArr) {
            int abs = (Math.abs(styleExtractor.getWeight(t6) - i5) * 2) + (styleExtractor.isItalic(t6) == z5 ? 0 : 1);
            if (t5 == null || i6 > abs) {
                t5 = t6;
                i6 = abs;
            }
        }
        return t5;
    }
}
