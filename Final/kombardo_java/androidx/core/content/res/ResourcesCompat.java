package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.io.IOException;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public abstract class ResourcesCompat {
    private static final String TAG = "ResourcesCompat";
    private static final ThreadLocal<TypedValue> sTempTypedValue = new ThreadLocal<>();
    private static final WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> sColorStateCaches = new WeakHashMap<>(0);
    private static final Object sColorStateCacheLock = new Object();

    /* loaded from: classes.dex */
    static class Api21Impl {
        static Drawable getDrawable(Resources resources, int i5, Resources.Theme theme) {
            return resources.getDrawable(i5, theme);
        }

        static Drawable getDrawableForDensity(Resources resources, int i5, int i6, Resources.Theme theme) {
            return resources.getDrawableForDensity(i5, i6, theme);
        }
    }

    /* loaded from: classes.dex */
    static class Api23Impl {
        static ColorStateList getColorStateList(Resources resources, int i5, Resources.Theme theme) {
            return resources.getColorStateList(i5, theme);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ColorStateListCacheEntry {
        final Configuration mConfiguration;
        final int mThemeHash;
        final ColorStateList mValue;

        ColorStateListCacheEntry(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.mValue = colorStateList;
            this.mConfiguration = configuration;
            this.mThemeHash = theme == null ? 0 : theme.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class ColorStateListCacheKey {
        final Resources mResources;
        final Resources.Theme mTheme;

        ColorStateListCacheKey(Resources resources, Resources.Theme theme) {
            this.mResources = resources;
            this.mTheme = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ColorStateListCacheKey.class != obj.getClass()) {
                return false;
            }
            ColorStateListCacheKey colorStateListCacheKey = (ColorStateListCacheKey) obj;
            return this.mResources.equals(colorStateListCacheKey.mResources) && ObjectsCompat.equals(this.mTheme, colorStateListCacheKey.mTheme);
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.mResources, this.mTheme);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class FontCallback {
        public static Handler getHandler(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void callbackFailAsync(final int i5, Handler handler) {
            getHandler(handler).post(new Runnable() { // from class: x.b
                @Override // java.lang.Runnable
                public final void run() {
                    ResourcesCompat.FontCallback.this.lambda$callbackFailAsync$1(i5);
                }
            });
        }

        public final void callbackSuccessAsync(final Typeface typeface, Handler handler) {
            getHandler(handler).post(new Runnable() { // from class: x.a
                @Override // java.lang.Runnable
                public final void run() {
                    ResourcesCompat.FontCallback.this.lambda$callbackSuccessAsync$0(typeface);
                }
            });
        }

        /* renamed from: onFontRetrievalFailed, reason: merged with bridge method [inline-methods] */
        public abstract void lambda$callbackFailAsync$1(int i5);

        /* renamed from: onFontRetrieved, reason: merged with bridge method [inline-methods] */
        public abstract void lambda$callbackSuccessAsync$0(Typeface typeface);
    }

    private static void addColorStateListToCache(ColorStateListCacheKey colorStateListCacheKey, int i5, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (sColorStateCacheLock) {
            try {
                WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> weakHashMap = sColorStateCaches;
                SparseArray<ColorStateListCacheEntry> sparseArray = weakHashMap.get(colorStateListCacheKey);
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                    weakHashMap.put(colorStateListCacheKey, sparseArray);
                }
                sparseArray.append(i5, new ColorStateListCacheEntry(colorStateList, colorStateListCacheKey.mResources.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
    
        if (r2.mThemeHash == r5.hashCode()) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ColorStateList getCachedColorStateList(ColorStateListCacheKey colorStateListCacheKey, int i5) {
        ColorStateListCacheEntry colorStateListCacheEntry;
        synchronized (sColorStateCacheLock) {
            try {
                SparseArray<ColorStateListCacheEntry> sparseArray = sColorStateCaches.get(colorStateListCacheKey);
                if (sparseArray != null && sparseArray.size() > 0 && (colorStateListCacheEntry = sparseArray.get(i5)) != null) {
                    if (colorStateListCacheEntry.mConfiguration.equals(colorStateListCacheKey.mResources.getConfiguration())) {
                        Resources.Theme theme = colorStateListCacheKey.mTheme;
                        if (theme == null) {
                            if (colorStateListCacheEntry.mThemeHash != 0) {
                            }
                            return colorStateListCacheEntry.mValue;
                        }
                        if (theme != null) {
                        }
                    }
                    sparseArray.remove(i5);
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ColorStateList getColorStateList(Resources resources, int i5, Resources.Theme theme) {
        ColorStateListCacheKey colorStateListCacheKey = new ColorStateListCacheKey(resources, theme);
        ColorStateList cachedColorStateList = getCachedColorStateList(colorStateListCacheKey, i5);
        if (cachedColorStateList != null) {
            return cachedColorStateList;
        }
        ColorStateList inflateColorStateList = inflateColorStateList(resources, i5, theme);
        if (inflateColorStateList == null) {
            return Api23Impl.getColorStateList(resources, i5, theme);
        }
        addColorStateListToCache(colorStateListCacheKey, i5, inflateColorStateList, theme);
        return inflateColorStateList;
    }

    public static Drawable getDrawable(Resources resources, int i5, Resources.Theme theme) {
        return Api21Impl.getDrawable(resources, i5, theme);
    }

    public static Drawable getDrawableForDensity(Resources resources, int i5, int i6, Resources.Theme theme) {
        return Api21Impl.getDrawableForDensity(resources, i5, i6, theme);
    }

    public static Typeface getFont(Context context, int i5) {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i5, new TypedValue(), 0, null, null, false, false);
    }

    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> threadLocal = sTempTypedValue;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static ColorStateList inflateColorStateList(Resources resources, int i5, Resources.Theme theme) {
        if (isColorInt(resources, i5)) {
            return null;
        }
        try {
            return ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i5), theme);
        } catch (Exception e5) {
            Log.w(TAG, "Failed to inflate ColorStateList, leaving it to the framework", e5);
            return null;
        }
    }

    private static boolean isColorInt(Resources resources, int i5) {
        TypedValue typedValue = getTypedValue();
        resources.getValue(i5, typedValue, true);
        int i6 = typedValue.type;
        return i6 >= 28 && i6 <= 31;
    }

    private static Typeface loadFont(Context context, int i5, TypedValue typedValue, int i6, FontCallback fontCallback, Handler handler, boolean z5, boolean z6) {
        Resources resources = context.getResources();
        resources.getValue(i5, typedValue, true);
        Typeface loadFont = loadFont(context, resources, typedValue, i5, i6, fontCallback, handler, z5, z6);
        if (loadFont != null || fontCallback != null || z6) {
            return loadFont;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i5) + " could not be retrieved.");
    }

    public static void getFont(Context context, int i5, FontCallback fontCallback, Handler handler) {
        Preconditions.checkNotNull(fontCallback);
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
        } else {
            loadFont(context, i5, new TypedValue(), 0, fontCallback, handler, false, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Typeface loadFont(Context context, Resources resources, TypedValue typedValue, int i5, int i6, FontCallback fontCallback, Handler handler, boolean z5, boolean z6) {
        CharSequence charSequence = typedValue.string;
        if (charSequence != null) {
            String charSequence2 = charSequence.toString();
            int i7 = 0;
            if (!charSequence2.startsWith("res/")) {
                if (fontCallback != null) {
                    fontCallback.callbackFailAsync(-3, handler);
                }
                return null;
            }
            Typeface findFromCache = TypefaceCompat.findFromCache(resources, i5, charSequence2, typedValue.assetCookie, i6);
            if (findFromCache != null) {
                if (fontCallback != null) {
                    fontCallback.callbackSuccessAsync(findFromCache, handler);
                }
                return findFromCache;
            }
            if (z6) {
                return null;
            }
            try {
            } catch (IOException e5) {
                e = e5;
                i7 = -3;
            } catch (XmlPullParserException e6) {
                e = e6;
                i7 = -3;
            }
            try {
                if (charSequence2.toLowerCase().endsWith(".xml")) {
                    FontResourcesParserCompat.FamilyResourceEntry parse = FontResourcesParserCompat.parse(resources.getXml(i5), resources);
                    if (parse == null) {
                        Log.e(TAG, "Failed to find font-family tag");
                        if (fontCallback != null) {
                            fontCallback.callbackFailAsync(-3, handler);
                        }
                        return null;
                    }
                    return TypefaceCompat.createFromResourcesFamilyXml(context, parse, resources, i5, charSequence2, typedValue.assetCookie, i6, fontCallback, handler, z5);
                }
                Typeface createFromResourcesFontFile = TypefaceCompat.createFromResourcesFontFile(context, resources, i5, charSequence2, typedValue.assetCookie, i6);
                if (fontCallback != null) {
                    if (createFromResourcesFontFile != null) {
                        fontCallback.callbackSuccessAsync(createFromResourcesFontFile, handler);
                    } else {
                        fontCallback.callbackFailAsync(-3, handler);
                    }
                }
                return createFromResourcesFontFile;
            } catch (IOException e7) {
                e = e7;
                Log.e(TAG, "Failed to read xml resource " + charSequence2, e);
                if (fontCallback != null) {
                    return null;
                }
                fontCallback.callbackFailAsync(i7, handler);
                return null;
            } catch (XmlPullParserException e8) {
                e = e8;
                Log.e(TAG, "Failed to parse xml resource " + charSequence2, e);
                if (fontCallback != null) {
                }
            }
        } else {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i5) + "\" (" + Integer.toHexString(i5) + ") is not a Font: " + typedValue);
        }
    }

    public static Typeface getFont(Context context, int i5, TypedValue typedValue, int i6, FontCallback fontCallback) {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i5, typedValue, i6, fontCallback, null, true, false);
    }
}
