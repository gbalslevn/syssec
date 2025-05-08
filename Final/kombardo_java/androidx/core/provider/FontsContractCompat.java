package androidx.core.provider;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.List;
import y.g;

/* loaded from: classes.dex */
public abstract class FontsContractCompat {

    /* loaded from: classes.dex */
    public static class FontFamilyResult {
        private final List<FontInfo[]> mFonts;
        private final int mStatusCode;

        @Deprecated
        public FontFamilyResult(int i5, FontInfo[] fontInfoArr) {
            this.mStatusCode = i5;
            this.mFonts = Collections.singletonList(fontInfoArr);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static FontFamilyResult create(int i5, FontInfo[] fontInfoArr) {
            return new FontFamilyResult(i5, fontInfoArr);
        }

        public FontInfo[] getFonts() {
            return this.mFonts.get(0);
        }

        public List<FontInfo[]> getFontsWithFallbacks() {
            return this.mFonts;
        }

        public int getStatusCode() {
            return this.mStatusCode;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean hasFallback() {
            return this.mFonts.size() > 1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static FontFamilyResult create(int i5, List<FontInfo[]> list) {
            return new FontFamilyResult(i5, list);
        }

        FontFamilyResult(int i5, List<FontInfo[]> list) {
            this.mStatusCode = i5;
            this.mFonts = list;
        }
    }

    /* loaded from: classes.dex */
    public static class FontInfo {
        private final boolean mItalic;
        private final int mResultCode;
        private final int mTtcIndex;
        private final Uri mUri;
        private final int mWeight;

        @Deprecated
        public FontInfo(Uri uri, int i5, int i6, boolean z5, int i7) {
            this.mUri = (Uri) Preconditions.checkNotNull(uri);
            this.mTtcIndex = i5;
            this.mWeight = i6;
            this.mItalic = z5;
            this.mResultCode = i7;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static FontInfo create(Uri uri, int i5, int i6, boolean z5, int i7) {
            return new FontInfo(uri, i5, i6, z5, i7);
        }

        public int getResultCode() {
            return this.mResultCode;
        }

        public int getTtcIndex() {
            return this.mTtcIndex;
        }

        public Uri getUri() {
            return this.mUri;
        }

        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }
    }

    /* loaded from: classes.dex */
    public static class FontRequestCallback {
        public abstract void onTypefaceRequestFailed(int i5);

        public abstract void onTypefaceRetrieved(Typeface typeface);
    }

    public static Typeface buildTypeface(Context context, CancellationSignal cancellationSignal, FontInfo[] fontInfoArr) {
        return TypefaceCompat.createFromFontInfo(context, cancellationSignal, fontInfoArr, 0);
    }

    public static FontFamilyResult fetchFonts(Context context, CancellationSignal cancellationSignal, FontRequest fontRequest) {
        List a5;
        a5 = g.a(new Object[]{fontRequest});
        return FontProvider.getFontFamilyResult(context, a5, cancellationSignal);
    }

    public static Typeface requestFont(Context context, List<FontRequest> list, int i5, boolean z5, int i6, Handler handler, FontRequestCallback fontRequestCallback) {
        CallbackWrapper callbackWrapper = new CallbackWrapper(fontRequestCallback, RequestExecutor.createHandlerExecutor(handler));
        if (!z5) {
            return FontRequestWorker.requestFontAsync(context, list, i5, null, callbackWrapper);
        }
        if (list.size() <= 1) {
            return FontRequestWorker.requestFontSync(context, list.get(0), callbackWrapper, i5, i6);
        }
        throw new IllegalArgumentException("Fallbacks with blocking fetches are not supported for performance reasons");
    }
}
