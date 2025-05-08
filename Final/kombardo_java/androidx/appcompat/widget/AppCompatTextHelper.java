package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.TypedValueCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.widget.TextViewCompat;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class AppCompatTextHelper {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int TEXT_FONT_WEIGHT_UNSPECIFIED = -1;
    private boolean mAsyncFontPending;
    private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    private TintInfo mDrawableBottomTint;
    private TintInfo mDrawableEndTint;
    private TintInfo mDrawableLeftTint;
    private TintInfo mDrawableRightTint;
    private TintInfo mDrawableStartTint;
    private TintInfo mDrawableTint;
    private TintInfo mDrawableTopTint;
    private Typeface mFontTypeface;
    private final TextView mView;
    private int mStyle = 0;
    private int mFontWeight = -1;

    /* loaded from: classes.dex */
    static class Api24Impl {
        static LocaleList forLanguageTags(String str) {
            return LocaleList.forLanguageTags(str);
        }

        static void setTextLocales(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    /* loaded from: classes.dex */
    static class Api26Impl {
        static int getAutoSizeStepGranularity(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        static void setAutoSizeTextTypeUniformWithConfiguration(TextView textView, int i5, int i6, int i7, int i8) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i5, i6, i7, i8);
        }

        static void setAutoSizeTextTypeUniformWithPresetSizes(TextView textView, int[] iArr, int i5) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i5);
        }

        static boolean setFontVariationSettings(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api28Impl {
        static Typeface create(Typeface typeface, int i5, boolean z5) {
            return Typeface.create(typeface, i5, z5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatTextHelper(TextView textView) {
        this.mView = textView;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(textView);
    }

    private void applyCompoundDrawableTint(Drawable drawable, TintInfo tintInfo) {
        if (drawable == null || tintInfo == null) {
            return;
        }
        AppCompatDrawableManager.tintDrawable(drawable, tintInfo, this.mView.getDrawableState());
    }

    private static TintInfo createTintInfo(Context context, AppCompatDrawableManager appCompatDrawableManager, int i5) {
        ColorStateList tintList = appCompatDrawableManager.getTintList(context, i5);
        if (tintList == null) {
            return null;
        }
        TintInfo tintInfo = new TintInfo();
        tintInfo.mHasTintList = true;
        tintInfo.mTintList = tintList;
        return tintInfo;
    }

    private void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = this.mView.getCompoundDrawablesRelative();
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            TextView textView = this.mView;
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative2 = this.mView.getCompoundDrawablesRelative();
        Drawable drawable7 = compoundDrawablesRelative2[0];
        if (drawable7 != null || compoundDrawablesRelative2[2] != null) {
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative2[1];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative2[3];
            }
            this.mView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative2[2], drawable4);
            return;
        }
        Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
        TextView textView2 = this.mView;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void setCompoundTints() {
        TintInfo tintInfo = this.mDrawableTint;
        this.mDrawableLeftTint = tintInfo;
        this.mDrawableTopTint = tintInfo;
        this.mDrawableRightTint = tintInfo;
        this.mDrawableBottomTint = tintInfo;
        this.mDrawableStartTint = tintInfo;
        this.mDrawableEndTint = tintInfo;
    }

    private void setTextSizeInternal(int i5, float f5) {
        this.mAutoSizeTextHelper.setTextSizeInternal(i5, f5);
    }

    private void updateTypefaceAndStyle(Context context, TintTypedArray tintTypedArray) {
        String string;
        this.mStyle = tintTypedArray.getInt(R$styleable.TextAppearance_android_textStyle, this.mStyle);
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 28) {
            int i6 = tintTypedArray.getInt(R$styleable.TextAppearance_android_textFontWeight, -1);
            this.mFontWeight = i6;
            if (i6 != -1) {
                this.mStyle &= 2;
            }
        }
        int i7 = R$styleable.TextAppearance_android_fontFamily;
        if (!tintTypedArray.hasValue(i7) && !tintTypedArray.hasValue(R$styleable.TextAppearance_fontFamily)) {
            int i8 = R$styleable.TextAppearance_android_typeface;
            if (tintTypedArray.hasValue(i8)) {
                this.mAsyncFontPending = false;
                int i9 = tintTypedArray.getInt(i8, 1);
                if (i9 == 1) {
                    this.mFontTypeface = Typeface.SANS_SERIF;
                    return;
                } else if (i9 == 2) {
                    this.mFontTypeface = Typeface.SERIF;
                    return;
                } else {
                    if (i9 != 3) {
                        return;
                    }
                    this.mFontTypeface = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.mFontTypeface = null;
        int i10 = R$styleable.TextAppearance_fontFamily;
        if (tintTypedArray.hasValue(i10)) {
            i7 = i10;
        }
        final int i11 = this.mFontWeight;
        final int i12 = this.mStyle;
        if (!context.isRestricted()) {
            final WeakReference weakReference = new WeakReference(this.mView);
            try {
                Typeface font = tintTypedArray.getFont(i7, this.mStyle, new ResourcesCompat.FontCallback() { // from class: androidx.appcompat.widget.AppCompatTextHelper.1
                    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                    /* renamed from: onFontRetrievalFailed */
                    public void lambda$callbackFailAsync$1(int i13) {
                    }

                    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                    /* renamed from: onFontRetrieved */
                    public void lambda$callbackSuccessAsync$0(Typeface typeface) {
                        int i13;
                        if (Build.VERSION.SDK_INT >= 28 && (i13 = i11) != -1) {
                            typeface = Api28Impl.create(typeface, i13, (i12 & 2) != 0);
                        }
                        AppCompatTextHelper.this.onAsyncTypefaceReceived(weakReference, typeface);
                    }
                });
                if (font != null) {
                    if (i5 < 28 || this.mFontWeight == -1) {
                        this.mFontTypeface = font;
                    } else {
                        this.mFontTypeface = Api28Impl.create(Typeface.create(font, 0), this.mFontWeight, (this.mStyle & 2) != 0);
                    }
                }
                this.mAsyncFontPending = this.mFontTypeface == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.mFontTypeface != null || (string = tintTypedArray.getString(i7)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.mFontWeight == -1) {
            this.mFontTypeface = Typeface.create(string, this.mStyle);
        } else {
            this.mFontTypeface = Api28Impl.create(Typeface.create(string, 0), this.mFontWeight, (this.mStyle & 2) != 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void applyCompoundDrawablesTints() {
        if (this.mDrawableLeftTint != null || this.mDrawableTopTint != null || this.mDrawableRightTint != null || this.mDrawableBottomTint != null) {
            Drawable[] compoundDrawables = this.mView.getCompoundDrawables();
            applyCompoundDrawableTint(compoundDrawables[0], this.mDrawableLeftTint);
            applyCompoundDrawableTint(compoundDrawables[1], this.mDrawableTopTint);
            applyCompoundDrawableTint(compoundDrawables[2], this.mDrawableRightTint);
            applyCompoundDrawableTint(compoundDrawables[3], this.mDrawableBottomTint);
        }
        if (this.mDrawableStartTint == null && this.mDrawableEndTint == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.mView.getCompoundDrawablesRelative();
        applyCompoundDrawableTint(compoundDrawablesRelative[0], this.mDrawableStartTint);
        applyCompoundDrawableTint(compoundDrawablesRelative[2], this.mDrawableEndTint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void autoSizeText() {
        this.mAutoSizeTextHelper.autoSizeText();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAutoSizeMaxTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAutoSizeMinTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAutoSizeStepGranularity() {
        return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAutoSizeTextType() {
        return this.mAutoSizeTextHelper.getAutoSizeTextType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList getCompoundDrawableTintList() {
        TintInfo tintInfo = this.mDrawableTint;
        if (tintInfo != null) {
            return tintInfo.mTintList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode getCompoundDrawableTintMode() {
        TintInfo tintInfo = this.mDrawableTint;
        if (tintInfo != null) {
            return tintInfo.mTintMode;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAutoSizeEnabled() {
        return this.mAutoSizeTextHelper.isAutoSizeEnabled();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0228  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadFromAttributes(AttributeSet attributeSet, int i5) {
        boolean z5;
        boolean z6;
        String str;
        String str2;
        int i6;
        int i7;
        int i8;
        Typeface typeface;
        TintTypedArray obtainStyledAttributes;
        int i9;
        int i10;
        int dimensionPixelSize;
        int dimensionPixelSize2;
        int i11;
        float f5;
        int i12;
        int[] autoSizeTextAvailableSizes;
        Context context = this.mView.getContext();
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        int[] iArr = R$styleable.AppCompatTextHelper;
        TintTypedArray obtainStyledAttributes2 = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i5, 0);
        TextView textView = this.mView;
        ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), iArr, attributeSet, obtainStyledAttributes2.getWrappedTypeArray(), i5, 0);
        int resourceId = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextHelper_android_textAppearance, -1);
        int i13 = R$styleable.AppCompatTextHelper_android_drawableLeft;
        if (obtainStyledAttributes2.hasValue(i13)) {
            this.mDrawableLeftTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(i13, 0));
        }
        int i14 = R$styleable.AppCompatTextHelper_android_drawableTop;
        if (obtainStyledAttributes2.hasValue(i14)) {
            this.mDrawableTopTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(i14, 0));
        }
        int i15 = R$styleable.AppCompatTextHelper_android_drawableRight;
        if (obtainStyledAttributes2.hasValue(i15)) {
            this.mDrawableRightTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(i15, 0));
        }
        int i16 = R$styleable.AppCompatTextHelper_android_drawableBottom;
        if (obtainStyledAttributes2.hasValue(i16)) {
            this.mDrawableBottomTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(i16, 0));
        }
        int i17 = R$styleable.AppCompatTextHelper_android_drawableStart;
        if (obtainStyledAttributes2.hasValue(i17)) {
            this.mDrawableStartTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(i17, 0));
        }
        int i18 = R$styleable.AppCompatTextHelper_android_drawableEnd;
        if (obtainStyledAttributes2.hasValue(i18)) {
            this.mDrawableEndTint = createTintInfo(context, appCompatDrawableManager, obtainStyledAttributes2.getResourceId(i18, 0));
        }
        obtainStyledAttributes2.recycle();
        boolean z7 = this.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z8 = true;
        if (resourceId != -1) {
            TintTypedArray obtainStyledAttributes3 = TintTypedArray.obtainStyledAttributes(context, resourceId, R$styleable.TextAppearance);
            if (!z7) {
                int i19 = R$styleable.TextAppearance_textAllCaps;
                if (obtainStyledAttributes3.hasValue(i19)) {
                    z5 = obtainStyledAttributes3.getBoolean(i19, false);
                    z6 = true;
                    updateTypefaceAndStyle(context, obtainStyledAttributes3);
                    int i20 = R$styleable.TextAppearance_textLocale;
                    str = !obtainStyledAttributes3.hasValue(i20) ? obtainStyledAttributes3.getString(i20) : null;
                    int i21 = R$styleable.TextAppearance_fontVariationSettings;
                    str2 = !obtainStyledAttributes3.hasValue(i21) ? obtainStyledAttributes3.getString(i21) : null;
                    obtainStyledAttributes3.recycle();
                }
            }
            z5 = false;
            z6 = false;
            updateTypefaceAndStyle(context, obtainStyledAttributes3);
            int i202 = R$styleable.TextAppearance_textLocale;
            if (!obtainStyledAttributes3.hasValue(i202)) {
            }
            int i212 = R$styleable.TextAppearance_fontVariationSettings;
            if (!obtainStyledAttributes3.hasValue(i212)) {
            }
            obtainStyledAttributes3.recycle();
        } else {
            z5 = false;
            z6 = false;
            str = null;
            str2 = null;
        }
        TintTypedArray obtainStyledAttributes4 = TintTypedArray.obtainStyledAttributes(context, attributeSet, R$styleable.TextAppearance, i5, 0);
        if (!z7) {
            int i22 = R$styleable.TextAppearance_textAllCaps;
            if (obtainStyledAttributes4.hasValue(i22)) {
                z5 = obtainStyledAttributes4.getBoolean(i22, false);
                i6 = Build.VERSION.SDK_INT;
                i7 = R$styleable.TextAppearance_textLocale;
                if (obtainStyledAttributes4.hasValue(i7)) {
                    str = obtainStyledAttributes4.getString(i7);
                }
                i8 = R$styleable.TextAppearance_fontVariationSettings;
                if (obtainStyledAttributes4.hasValue(i8)) {
                    str2 = obtainStyledAttributes4.getString(i8);
                }
                if (i6 >= 28) {
                    int i23 = R$styleable.TextAppearance_android_textSize;
                    if (obtainStyledAttributes4.hasValue(i23) && obtainStyledAttributes4.getDimensionPixelSize(i23, -1) == 0) {
                        this.mView.setTextSize(0, 0.0f);
                    }
                }
                updateTypefaceAndStyle(context, obtainStyledAttributes4);
                obtainStyledAttributes4.recycle();
                if (!z7 && z8) {
                    setAllCaps(z5);
                }
                typeface = this.mFontTypeface;
                if (typeface != null) {
                    if (this.mFontWeight == -1) {
                        this.mView.setTypeface(typeface, this.mStyle);
                    } else {
                        this.mView.setTypeface(typeface);
                    }
                }
                if (str2 != null) {
                    Api26Impl.setFontVariationSettings(this.mView, str2);
                }
                if (str != null) {
                    Api24Impl.setTextLocales(this.mView, Api24Impl.forLanguageTags(str));
                }
                this.mAutoSizeTextHelper.loadFromAttributes(attributeSet, i5);
                if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE && this.mAutoSizeTextHelper.getAutoSizeTextType() != 0) {
                    autoSizeTextAvailableSizes = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
                    if (autoSizeTextAvailableSizes.length > 0) {
                        if (Api26Impl.getAutoSizeStepGranularity(this.mView) != -1.0f) {
                            Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(this.mView, this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
                        } else {
                            Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(this.mView, autoSizeTextAvailableSizes, 0);
                        }
                    }
                }
                obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R$styleable.AppCompatTextView);
                int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextView_drawableLeftCompat, -1);
                Drawable drawable = resourceId2 == -1 ? appCompatDrawableManager.getDrawable(context, resourceId2) : null;
                int resourceId3 = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextView_drawableTopCompat, -1);
                Drawable drawable2 = resourceId3 == -1 ? appCompatDrawableManager.getDrawable(context, resourceId3) : null;
                int resourceId4 = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextView_drawableRightCompat, -1);
                Drawable drawable3 = resourceId4 == -1 ? appCompatDrawableManager.getDrawable(context, resourceId4) : null;
                int resourceId5 = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextView_drawableBottomCompat, -1);
                Drawable drawable4 = resourceId5 == -1 ? appCompatDrawableManager.getDrawable(context, resourceId5) : null;
                int resourceId6 = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextView_drawableStartCompat, -1);
                Drawable drawable5 = resourceId6 == -1 ? appCompatDrawableManager.getDrawable(context, resourceId6) : null;
                int resourceId7 = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextView_drawableEndCompat, -1);
                setCompoundDrawables(drawable, drawable2, drawable3, drawable4, drawable5, resourceId7 == -1 ? appCompatDrawableManager.getDrawable(context, resourceId7) : null);
                i9 = R$styleable.AppCompatTextView_drawableTint;
                if (obtainStyledAttributes.hasValue(i9)) {
                    TextViewCompat.setCompoundDrawableTintList(this.mView, obtainStyledAttributes.getColorStateList(i9));
                }
                i10 = R$styleable.AppCompatTextView_drawableTintMode;
                if (obtainStyledAttributes.hasValue(i10)) {
                    TextViewCompat.setCompoundDrawableTintMode(this.mView, DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i10, -1), null));
                }
                dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
                dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
                i11 = R$styleable.AppCompatTextView_lineHeight;
                if (obtainStyledAttributes.hasValue(i11)) {
                    f5 = -1.0f;
                } else {
                    TypedValue peekValue = obtainStyledAttributes.peekValue(i11);
                    if (peekValue != null && peekValue.type == 5) {
                        i12 = TypedValueCompat.getUnitFromComplexDimension(peekValue.data);
                        f5 = TypedValue.complexToFloat(peekValue.data);
                        obtainStyledAttributes.recycle();
                        if (dimensionPixelSize != -1) {
                            TextViewCompat.setFirstBaselineToTopHeight(this.mView, dimensionPixelSize);
                        }
                        if (dimensionPixelSize2 != -1) {
                            TextViewCompat.setLastBaselineToBottomHeight(this.mView, dimensionPixelSize2);
                        }
                        if (f5 != -1.0f) {
                            if (i12 == -1) {
                                TextViewCompat.setLineHeight(this.mView, (int) f5);
                                return;
                            } else {
                                TextViewCompat.setLineHeight(this.mView, i12, f5);
                                return;
                            }
                        }
                        return;
                    }
                    f5 = obtainStyledAttributes.getDimensionPixelSize(i11, -1);
                }
                i12 = -1;
                obtainStyledAttributes.recycle();
                if (dimensionPixelSize != -1) {
                }
                if (dimensionPixelSize2 != -1) {
                }
                if (f5 != -1.0f) {
                }
            }
        }
        z8 = z6;
        i6 = Build.VERSION.SDK_INT;
        i7 = R$styleable.TextAppearance_textLocale;
        if (obtainStyledAttributes4.hasValue(i7)) {
        }
        i8 = R$styleable.TextAppearance_fontVariationSettings;
        if (obtainStyledAttributes4.hasValue(i8)) {
        }
        if (i6 >= 28) {
        }
        updateTypefaceAndStyle(context, obtainStyledAttributes4);
        obtainStyledAttributes4.recycle();
        if (!z7) {
            setAllCaps(z5);
        }
        typeface = this.mFontTypeface;
        if (typeface != null) {
        }
        if (str2 != null) {
        }
        if (str != null) {
        }
        this.mAutoSizeTextHelper.loadFromAttributes(attributeSet, i5);
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            autoSizeTextAvailableSizes = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
            if (autoSizeTextAvailableSizes.length > 0) {
            }
        }
        obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R$styleable.AppCompatTextView);
        int resourceId22 = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextView_drawableLeftCompat, -1);
        if (resourceId22 == -1) {
        }
        int resourceId32 = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextView_drawableTopCompat, -1);
        if (resourceId32 == -1) {
        }
        int resourceId42 = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextView_drawableRightCompat, -1);
        if (resourceId42 == -1) {
        }
        int resourceId52 = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextView_drawableBottomCompat, -1);
        if (resourceId52 == -1) {
        }
        int resourceId62 = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextView_drawableStartCompat, -1);
        if (resourceId62 == -1) {
        }
        int resourceId72 = obtainStyledAttributes.getResourceId(R$styleable.AppCompatTextView_drawableEndCompat, -1);
        setCompoundDrawables(drawable, drawable2, drawable3, drawable4, drawable5, resourceId72 == -1 ? appCompatDrawableManager.getDrawable(context, resourceId72) : null);
        i9 = R$styleable.AppCompatTextView_drawableTint;
        if (obtainStyledAttributes.hasValue(i9)) {
        }
        i10 = R$styleable.AppCompatTextView_drawableTintMode;
        if (obtainStyledAttributes.hasValue(i10)) {
        }
        dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
        dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R$styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
        i11 = R$styleable.AppCompatTextView_lineHeight;
        if (obtainStyledAttributes.hasValue(i11)) {
        }
        i12 = -1;
        obtainStyledAttributes.recycle();
        if (dimensionPixelSize != -1) {
        }
        if (dimensionPixelSize2 != -1) {
        }
        if (f5 != -1.0f) {
        }
    }

    void onAsyncTypefaceReceived(WeakReference<TextView> weakReference, final Typeface typeface) {
        if (this.mAsyncFontPending) {
            this.mFontTypeface = typeface;
            final TextView textView = weakReference.get();
            if (textView != null) {
                if (!textView.isAttachedToWindow()) {
                    textView.setTypeface(typeface, this.mStyle);
                } else {
                    final int i5 = this.mStyle;
                    textView.post(new Runnable() { // from class: androidx.appcompat.widget.AppCompatTextHelper.2
                        @Override // java.lang.Runnable
                        public void run() {
                            textView.setTypeface(typeface, i5);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE) {
            return;
        }
        autoSizeText();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSetCompoundDrawables() {
        applyCompoundDrawablesTints();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSetTextAppearance(Context context, int i5) {
        String string;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i5, R$styleable.TextAppearance);
        int i6 = R$styleable.TextAppearance_textAllCaps;
        if (obtainStyledAttributes.hasValue(i6)) {
            setAllCaps(obtainStyledAttributes.getBoolean(i6, false));
        }
        int i7 = R$styleable.TextAppearance_android_textSize;
        if (obtainStyledAttributes.hasValue(i7) && obtainStyledAttributes.getDimensionPixelSize(i7, -1) == 0) {
            this.mView.setTextSize(0, 0.0f);
        }
        updateTypefaceAndStyle(context, obtainStyledAttributes);
        int i8 = R$styleable.TextAppearance_fontVariationSettings;
        if (obtainStyledAttributes.hasValue(i8) && (string = obtainStyledAttributes.getString(i8)) != null) {
            Api26Impl.setFontVariationSettings(this.mView, string);
        }
        obtainStyledAttributes.recycle();
        Typeface typeface = this.mFontTypeface;
        if (typeface != null) {
            this.mView.setTypeface(typeface, this.mStyle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void populateSurroundingTextIfNeeded(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textView.getText());
    }

    void setAllCaps(boolean z5) {
        this.mView.setAllCaps(z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAutoSizeTextTypeUniformWithConfiguration(int i5, int i6, int i7, int i8) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(i5, i6, i7, i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i5) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAutoSizeTextTypeWithDefaults(int i5) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCompoundDrawableTintList(ColorStateList colorStateList) {
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        TintInfo tintInfo = this.mDrawableTint;
        tintInfo.mTintList = colorStateList;
        tintInfo.mHasTintList = colorStateList != null;
        setCompoundTints();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCompoundDrawableTintMode(PorterDuff.Mode mode) {
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new TintInfo();
        }
        TintInfo tintInfo = this.mDrawableTint;
        tintInfo.mTintMode = mode;
        tintInfo.mHasTintMode = mode != null;
        setCompoundTints();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTextSize(int i5, float f5) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE || isAutoSizeEnabled()) {
            return;
        }
        setTextSizeInternal(i5, f5);
    }
}
