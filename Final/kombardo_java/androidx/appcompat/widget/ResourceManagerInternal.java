package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.resources.R$drawable;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class ResourceManagerInternal {
    private static final boolean DEBUG = false;
    private static ResourceManagerInternal INSTANCE = null;
    private static final String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
    private static final String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
    private static final String TAG = "ResourceManagerInternal";
    private SimpleArrayMap<String, InflateDelegate> mDelegates;
    private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> mDrawableCaches = new WeakHashMap<>(0);
    private boolean mHasCheckedVectorDrawableSetup;
    private ResourceManagerHooks mHooks;
    private SparseArrayCompat<String> mKnownDrawableIdTags;
    private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> mTintLists;
    private TypedValue mTypedValue;
    private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    private static final ColorFilterLruCache COLOR_FILTER_CACHE = new ColorFilterLruCache(6);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int i5) {
            super(i5);
        }

        private static int generateCacheKey(int i5, PorterDuff.Mode mode) {
            return ((i5 + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter get(int i5, PorterDuff.Mode mode) {
            return get(Integer.valueOf(generateCacheKey(i5, mode)));
        }

        PorterDuffColorFilter put(int i5, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return put(Integer.valueOf(generateCacheKey(i5, mode)), porterDuffColorFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface InflateDelegate {
        Drawable createFromXmlInner(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* loaded from: classes.dex */
    public interface ResourceManagerHooks {
        Drawable createDrawableFor(ResourceManagerInternal resourceManagerInternal, Context context, int i5);

        ColorStateList getTintListForDrawableRes(Context context, int i5);

        PorterDuff.Mode getTintModeForDrawableRes(int i5);

        boolean tintDrawable(Context context, int i5, Drawable drawable);

        boolean tintDrawableUsingColorFilter(Context context, int i5, Drawable drawable);
    }

    private synchronized boolean addDrawableToCache(Context context, long j5, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) {
                return false;
            }
            LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.mDrawableCaches.get(context);
            if (longSparseArray == null) {
                longSparseArray = new LongSparseArray<>();
                this.mDrawableCaches.put(context, longSparseArray);
            }
            longSparseArray.put(j5, new WeakReference<>(constantState));
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    private void addTintListToCache(Context context, int i5, ColorStateList colorStateList) {
        if (this.mTintLists == null) {
            this.mTintLists = new WeakHashMap<>();
        }
        SparseArrayCompat<ColorStateList> sparseArrayCompat = this.mTintLists.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new SparseArrayCompat<>();
            this.mTintLists.put(context, sparseArrayCompat);
        }
        sparseArrayCompat.append(i5, colorStateList);
    }

    private void checkVectorDrawableSetup(Context context) {
        if (this.mHasCheckedVectorDrawableSetup) {
            return;
        }
        this.mHasCheckedVectorDrawableSetup = true;
        Drawable drawable = getDrawable(context, R$drawable.abc_vector_test);
        if (drawable == null || !isVectorDrawable(drawable)) {
            this.mHasCheckedVectorDrawableSetup = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static long createCacheKey(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private Drawable createDrawableIfNeeded(Context context, int i5) {
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        TypedValue typedValue = this.mTypedValue;
        context.getResources().getValue(i5, typedValue, true);
        long createCacheKey = createCacheKey(typedValue);
        Drawable cachedDrawable = getCachedDrawable(context, createCacheKey);
        if (cachedDrawable != null) {
            return cachedDrawable;
        }
        ResourceManagerHooks resourceManagerHooks = this.mHooks;
        Drawable createDrawableFor = resourceManagerHooks == null ? null : resourceManagerHooks.createDrawableFor(this, context, i5);
        if (createDrawableFor != null) {
            createDrawableFor.setChangingConfigurations(typedValue.changingConfigurations);
            addDrawableToCache(context, createCacheKey, createDrawableFor);
        }
        return createDrawableFor;
    }

    private static PorterDuffColorFilter createTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return getPorterDuffColorFilter(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized ResourceManagerInternal get() {
        ResourceManagerInternal resourceManagerInternal;
        synchronized (ResourceManagerInternal.class) {
            try {
                if (INSTANCE == null) {
                    ResourceManagerInternal resourceManagerInternal2 = new ResourceManagerInternal();
                    INSTANCE = resourceManagerInternal2;
                    installDefaultInflateDelegates(resourceManagerInternal2);
                }
                resourceManagerInternal = INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        return resourceManagerInternal;
    }

    private synchronized Drawable getCachedDrawable(Context context, long j5) {
        LongSparseArray<WeakReference<Drawable.ConstantState>> longSparseArray = this.mDrawableCaches.get(context);
        if (longSparseArray == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReference = longSparseArray.get(j5);
        if (weakReference != null) {
            Drawable.ConstantState constantState = weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            longSparseArray.remove(j5);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i5, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (ResourceManagerInternal.class) {
            ColorFilterLruCache colorFilterLruCache = COLOR_FILTER_CACHE;
            porterDuffColorFilter = colorFilterLruCache.get(i5, mode);
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i5, mode);
                colorFilterLruCache.put(i5, mode, porterDuffColorFilter);
            }
        }
        return porterDuffColorFilter;
    }

    private ColorStateList getTintListFromCache(Context context, int i5) {
        SparseArrayCompat<ColorStateList> sparseArrayCompat;
        WeakHashMap<Context, SparseArrayCompat<ColorStateList>> weakHashMap = this.mTintLists;
        if (weakHashMap == null || (sparseArrayCompat = weakHashMap.get(context)) == null) {
            return null;
        }
        return sparseArrayCompat.get(i5);
    }

    private static void installDefaultInflateDelegates(ResourceManagerInternal resourceManagerInternal) {
    }

    private static boolean isVectorDrawable(Drawable drawable) {
        return (drawable instanceof VectorDrawableCompat) || PLATFORM_VD_CLAZZ.equals(drawable.getClass().getName());
    }

    private Drawable loadDrawableFromDelegates(Context context, int i5) {
        int next;
        SimpleArrayMap<String, InflateDelegate> simpleArrayMap = this.mDelegates;
        if (simpleArrayMap == null || simpleArrayMap.isEmpty()) {
            return null;
        }
        SparseArrayCompat<String> sparseArrayCompat = this.mKnownDrawableIdTags;
        if (sparseArrayCompat != null) {
            String str = sparseArrayCompat.get(i5);
            if (SKIP_DRAWABLE_TAG.equals(str) || (str != null && this.mDelegates.get(str) == null)) {
                return null;
            }
        } else {
            this.mKnownDrawableIdTags = new SparseArrayCompat<>();
        }
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        TypedValue typedValue = this.mTypedValue;
        Resources resources = context.getResources();
        resources.getValue(i5, typedValue, true);
        long createCacheKey = createCacheKey(typedValue);
        Drawable cachedDrawable = getCachedDrawable(context, createCacheKey);
        if (cachedDrawable != null) {
            return cachedDrawable;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i5);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.mKnownDrawableIdTags.append(i5, name);
                InflateDelegate inflateDelegate = this.mDelegates.get(name);
                if (inflateDelegate != null) {
                    cachedDrawable = inflateDelegate.createFromXmlInner(context, xml, asAttributeSet, context.getTheme());
                }
                if (cachedDrawable != null) {
                    cachedDrawable.setChangingConfigurations(typedValue.changingConfigurations);
                    addDrawableToCache(context, createCacheKey, cachedDrawable);
                }
            } catch (Exception e5) {
                Log.e(TAG, "Exception while inflating drawable", e5);
            }
        }
        if (cachedDrawable == null) {
            this.mKnownDrawableIdTags.append(i5, SKIP_DRAWABLE_TAG);
        }
        return cachedDrawable;
    }

    private Drawable tintDrawable(Context context, int i5, boolean z5, Drawable drawable) {
        ColorStateList tintList = getTintList(context, i5);
        if (tintList != null) {
            Drawable wrap = DrawableCompat.wrap(drawable.mutate());
            DrawableCompat.setTintList(wrap, tintList);
            PorterDuff.Mode tintMode = getTintMode(i5);
            if (tintMode == null) {
                return wrap;
            }
            DrawableCompat.setTintMode(wrap, tintMode);
            return wrap;
        }
        ResourceManagerHooks resourceManagerHooks = this.mHooks;
        if ((resourceManagerHooks == null || !resourceManagerHooks.tintDrawable(context, i5, drawable)) && !tintDrawableUsingColorFilter(context, i5, drawable) && z5) {
            return null;
        }
        return drawable;
    }

    public synchronized Drawable getDrawable(Context context, int i5) {
        return getDrawable(context, i5, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList getTintList(Context context, int i5) {
        ColorStateList tintListFromCache;
        tintListFromCache = getTintListFromCache(context, i5);
        if (tintListFromCache == null) {
            ResourceManagerHooks resourceManagerHooks = this.mHooks;
            tintListFromCache = resourceManagerHooks == null ? null : resourceManagerHooks.getTintListForDrawableRes(context, i5);
            if (tintListFromCache != null) {
                addTintListToCache(context, i5, tintListFromCache);
            }
        }
        return tintListFromCache;
    }

    PorterDuff.Mode getTintMode(int i5) {
        ResourceManagerHooks resourceManagerHooks = this.mHooks;
        if (resourceManagerHooks == null) {
            return null;
        }
        return resourceManagerHooks.getTintModeForDrawableRes(i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable onDrawableLoadedFromResources(Context context, VectorEnabledTintResources vectorEnabledTintResources, int i5) {
        try {
            Drawable loadDrawableFromDelegates = loadDrawableFromDelegates(context, i5);
            if (loadDrawableFromDelegates == null) {
                loadDrawableFromDelegates = vectorEnabledTintResources.getDrawableCanonical(i5);
            }
            if (loadDrawableFromDelegates == null) {
                return null;
            }
            return tintDrawable(context, i5, false, loadDrawableFromDelegates);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setHooks(ResourceManagerHooks resourceManagerHooks) {
        this.mHooks = resourceManagerHooks;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean tintDrawableUsingColorFilter(Context context, int i5, Drawable drawable) {
        ResourceManagerHooks resourceManagerHooks = this.mHooks;
        return resourceManagerHooks != null && resourceManagerHooks.tintDrawableUsingColorFilter(context, i5, drawable);
    }

    synchronized Drawable getDrawable(Context context, int i5, boolean z5) {
        Drawable loadDrawableFromDelegates;
        try {
            checkVectorDrawableSetup(context);
            loadDrawableFromDelegates = loadDrawableFromDelegates(context, i5);
            if (loadDrawableFromDelegates == null) {
                loadDrawableFromDelegates = createDrawableIfNeeded(context, i5);
            }
            if (loadDrawableFromDelegates == null) {
                loadDrawableFromDelegates = ContextCompat.getDrawable(context, i5);
            }
            if (loadDrawableFromDelegates != null) {
                loadDrawableFromDelegates = tintDrawable(context, i5, z5, loadDrawableFromDelegates);
            }
            if (loadDrawableFromDelegates != null) {
                DrawableUtils.fixDrawable(loadDrawableFromDelegates);
            }
        } catch (Throwable th) {
            throw th;
        }
        return loadDrawableFromDelegates;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void tintDrawable(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        int[] state = drawable.getState();
        if (drawable.mutate() == drawable) {
            if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
                drawable.setState(new int[0]);
                drawable.setState(state);
            }
            boolean z5 = tintInfo.mHasTintList;
            if (!z5 && !tintInfo.mHasTintMode) {
                drawable.clearColorFilter();
                return;
            } else {
                drawable.setColorFilter(createTintFilter(z5 ? tintInfo.mTintList : null, tintInfo.mHasTintMode ? tintInfo.mTintMode : DEFAULT_MODE, iArr));
                return;
            }
        }
        Log.d(TAG, "Mutated drawable is not the same instance as the input.");
    }
}
