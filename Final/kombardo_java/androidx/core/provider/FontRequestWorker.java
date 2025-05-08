package androidx.core.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Consumer;
import androidx.tracing.Trace;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import y.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class FontRequestWorker {
    static final LruCache<String, Typeface> sTypefaceCache = new LruCache<>(16);
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE = RequestExecutor.createDefaultExecutor("fonts-androidx", 10, 10000);
    static final Object LOCK = new Object();
    static final SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> PENDING_REPLIES = new SimpleArrayMap<>();

    private static String createCacheId(List<FontRequest> list, int i5) {
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < list.size(); i6++) {
            sb.append(list.get(i6).getId());
            sb.append("-");
            sb.append(i5);
            if (i6 < list.size() - 1) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    @SuppressLint({"WrongConstant"})
    private static int getFontFamilyResultStatus(FontsContractCompat.FontFamilyResult fontFamilyResult) {
        int i5 = 1;
        if (fontFamilyResult.getStatusCode() != 0) {
            return fontFamilyResult.getStatusCode() != 1 ? -3 : -2;
        }
        FontsContractCompat.FontInfo[] fonts = fontFamilyResult.getFonts();
        if (fonts != null && fonts.length != 0) {
            i5 = 0;
            for (FontsContractCompat.FontInfo fontInfo : fonts) {
                int resultCode = fontInfo.getResultCode();
                if (resultCode != 0) {
                    if (resultCode < 0) {
                        return -3;
                    }
                    return resultCode;
                }
            }
        }
        return i5;
    }

    static TypefaceResult getFontSync(String str, Context context, List<FontRequest> list, int i5) {
        Trace.beginSection("getFontSync");
        try {
            LruCache<String, Typeface> lruCache = sTypefaceCache;
            Typeface typeface = lruCache.get(str);
            if (typeface != null) {
                return new TypefaceResult(typeface);
            }
            FontsContractCompat.FontFamilyResult fontFamilyResult = FontProvider.getFontFamilyResult(context, list, null);
            int fontFamilyResultStatus = getFontFamilyResultStatus(fontFamilyResult);
            if (fontFamilyResultStatus != 0) {
                return new TypefaceResult(fontFamilyResultStatus);
            }
            Typeface createFromFontInfo = (!fontFamilyResult.hasFallback() || Build.VERSION.SDK_INT < 29) ? TypefaceCompat.createFromFontInfo(context, null, fontFamilyResult.getFonts(), i5) : TypefaceCompat.createFromFontInfoWithFallback(context, null, fontFamilyResult.getFontsWithFallbacks(), i5);
            if (createFromFontInfo == null) {
                return new TypefaceResult(-3);
            }
            lruCache.put(str, createFromFontInfo);
            return new TypefaceResult(createFromFontInfo);
        } catch (PackageManager.NameNotFoundException unused) {
            return new TypefaceResult(-1);
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface requestFontAsync(final Context context, final List<FontRequest> list, final int i5, Executor executor, final CallbackWrapper callbackWrapper) {
        final String createCacheId = createCacheId(list, i5);
        Typeface typeface = sTypefaceCache.get(createCacheId);
        if (typeface != null) {
            callbackWrapper.onTypefaceResult(new TypefaceResult(typeface));
            return typeface;
        }
        Consumer<TypefaceResult> consumer = new Consumer<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.2
            @Override // androidx.core.util.Consumer
            public void accept(TypefaceResult typefaceResult) {
                if (typefaceResult == null) {
                    typefaceResult = new TypefaceResult(-3);
                }
                CallbackWrapper.this.onTypefaceResult(typefaceResult);
            }
        };
        synchronized (LOCK) {
            try {
                SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> simpleArrayMap = PENDING_REPLIES;
                ArrayList<Consumer<TypefaceResult>> arrayList = simpleArrayMap.get(createCacheId);
                if (arrayList != null) {
                    arrayList.add(consumer);
                    return null;
                }
                ArrayList<Consumer<TypefaceResult>> arrayList2 = new ArrayList<>();
                arrayList2.add(consumer);
                simpleArrayMap.put(createCacheId, arrayList2);
                Callable<TypefaceResult> callable = new Callable<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.3
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public TypefaceResult call() {
                        try {
                            return FontRequestWorker.getFontSync(createCacheId, context, list, i5);
                        } catch (Throwable unused) {
                            return new TypefaceResult(-3);
                        }
                    }
                };
                if (executor == null) {
                    executor = DEFAULT_EXECUTOR_SERVICE;
                }
                RequestExecutor.execute(executor, callable, new Consumer<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.4
                    @Override // androidx.core.util.Consumer
                    public void accept(TypefaceResult typefaceResult) {
                        synchronized (FontRequestWorker.LOCK) {
                            try {
                                SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> simpleArrayMap2 = FontRequestWorker.PENDING_REPLIES;
                                ArrayList<Consumer<TypefaceResult>> arrayList3 = simpleArrayMap2.get(createCacheId);
                                if (arrayList3 == null) {
                                    return;
                                }
                                simpleArrayMap2.remove(createCacheId);
                                for (int i6 = 0; i6 < arrayList3.size(); i6++) {
                                    arrayList3.get(i6).accept(typefaceResult);
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                });
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface requestFontSync(final Context context, final FontRequest fontRequest, CallbackWrapper callbackWrapper, final int i5, int i6) {
        List a5;
        List a6;
        a5 = g.a(new Object[]{fontRequest});
        final String createCacheId = createCacheId(a5, i5);
        Typeface typeface = sTypefaceCache.get(createCacheId);
        if (typeface != null) {
            callbackWrapper.onTypefaceResult(new TypefaceResult(typeface));
            return typeface;
        }
        if (i6 == -1) {
            a6 = g.a(new Object[]{fontRequest});
            TypefaceResult fontSync = getFontSync(createCacheId, context, a6, i5);
            callbackWrapper.onTypefaceResult(fontSync);
            return fontSync.mTypeface;
        }
        try {
            TypefaceResult typefaceResult = (TypefaceResult) RequestExecutor.submit(DEFAULT_EXECUTOR_SERVICE, new Callable<TypefaceResult>() { // from class: androidx.core.provider.FontRequestWorker.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public TypefaceResult call() {
                    List a7;
                    String str = createCacheId;
                    Context context2 = context;
                    a7 = g.a(new Object[]{fontRequest});
                    return FontRequestWorker.getFontSync(str, context2, a7, i5);
                }
            }, i6);
            callbackWrapper.onTypefaceResult(typefaceResult);
            return typefaceResult.mTypeface;
        } catch (InterruptedException unused) {
            callbackWrapper.onTypefaceResult(new TypefaceResult(-3));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class TypefaceResult {
        final int mResult;
        final Typeface mTypeface;

        TypefaceResult(int i5) {
            this.mTypeface = null;
            this.mResult = i5;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @SuppressLint({"WrongConstant"})
        public boolean isSuccess() {
            return this.mResult == 0;
        }

        @SuppressLint({"WrongConstant"})
        TypefaceResult(Typeface typeface) {
            this.mTypeface = typeface;
            this.mResult = 0;
        }
    }
}
