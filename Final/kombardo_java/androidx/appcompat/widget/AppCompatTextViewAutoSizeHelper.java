package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AppCompatTextViewAutoSizeHelper {
    private static final int DEFAULT_AUTO_SIZE_GRANULARITY_IN_PX = 1;
    private static final int DEFAULT_AUTO_SIZE_MAX_TEXT_SIZE_IN_SP = 112;
    private static final int DEFAULT_AUTO_SIZE_MIN_TEXT_SIZE_IN_SP = 12;
    private static final String TAG = "ACTVAutoSizeHelper";
    private static final int VERY_WIDE = 1048576;
    private final Context mContext;
    private final Impl mImpl;
    private TextPaint mTempTextPaint;
    private final TextView mTextView;
    private static final RectF TEMP_RECTF = new RectF();

    @SuppressLint({"BanConcurrentHashMap"})
    private static ConcurrentHashMap<String, Method> sTextViewMethodByNameCache = new ConcurrentHashMap<>();
    private int mAutoSizeTextType = 0;
    private boolean mNeedsAutoSizeText = false;
    private float mAutoSizeStepGranularityInPx = -1.0f;
    private float mAutoSizeMinTextSizeInPx = -1.0f;
    private float mAutoSizeMaxTextSizeInPx = -1.0f;
    private int[] mAutoSizeTextSizesInPx = new int[0];
    private boolean mHasPresetAutoSizeValues = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Api23Impl {
        static StaticLayout createStaticLayoutForMeasuring(CharSequence charSequence, Layout.Alignment alignment, int i5, int i6, TextView textView, TextPaint textPaint, Impl impl) {
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i5);
            StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i6 == -1) {
                i6 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i6);
            try {
                impl.computeAndSetTextDirection(obtain, textView);
            } catch (ClassCastException unused) {
                Log.w(AppCompatTextViewAutoSizeHelper.TAG, "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return obtain.build();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Impl {
        Impl() {
        }

        abstract void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView);

        boolean isHorizontallyScrollable(TextView textView) {
            return ((Boolean) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    /* loaded from: classes.dex */
    private static class Impl23 extends Impl {
        Impl23() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* loaded from: classes.dex */
    private static class Impl29 extends Impl23 {
        Impl29() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl23, androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
            TextDirectionHeuristic textDirectionHeuristic;
            textDirectionHeuristic = textView.getTextDirectionHeuristic();
            builder.setTextDirection(textDirectionHeuristic);
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        boolean isHorizontallyScrollable(TextView textView) {
            boolean isHorizontallyScrollable;
            isHorizontallyScrollable = textView.isHorizontallyScrollable();
            return isHorizontallyScrollable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatTextViewAutoSizeHelper(TextView textView) {
        this.mTextView = textView;
        this.mContext = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.mImpl = new Impl29();
        } else {
            this.mImpl = new Impl23();
        }
    }

    private int[] cleanupAutoSizePresetSizes(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i5 : iArr) {
            if (i5 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i5)) < 0) {
                arrayList.add(Integer.valueOf(i5));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i6 = 0; i6 < size; i6++) {
            iArr2[i6] = ((Integer) arrayList.get(i6)).intValue();
        }
        return iArr2;
    }

    private void clearAutoSizeConfiguration() {
        this.mAutoSizeTextType = 0;
        this.mAutoSizeMinTextSizeInPx = -1.0f;
        this.mAutoSizeMaxTextSizeInPx = -1.0f;
        this.mAutoSizeStepGranularityInPx = -1.0f;
        this.mAutoSizeTextSizesInPx = new int[0];
        this.mNeedsAutoSizeText = false;
    }

    private int findLargestTextSizeWhichFits(RectF rectF) {
        int length = this.mAutoSizeTextSizesInPx.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i5 = 1;
        int i6 = length - 1;
        int i7 = 0;
        while (i5 <= i6) {
            int i8 = (i5 + i6) / 2;
            if (suggestedSizeFitsInSpace(this.mAutoSizeTextSizesInPx[i8], rectF)) {
                int i9 = i8 + 1;
                i7 = i5;
                i5 = i9;
            } else {
                i7 = i8 - 1;
                i6 = i7;
            }
        }
        return this.mAutoSizeTextSizesInPx[i7];
    }

    private static Method getTextViewMethod(String str) {
        try {
            Method method = sTextViewMethodByNameCache.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, null)) != null) {
                method.setAccessible(true);
                sTextViewMethodByNameCache.put(str, method);
            }
            return method;
        } catch (Exception e5) {
            Log.w(TAG, "Failed to retrieve TextView#" + str + "() method", e5);
            return null;
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    static <T> T invokeAndReturnWithDefault(Object obj, String str, T t5) {
        try {
            return (T) getTextViewMethod(str).invoke(obj, null);
        } catch (Exception e5) {
            Log.w(TAG, "Failed to invoke TextView#" + str + "() method", e5);
            return t5;
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    private void setRawTextSize(float f5) {
        if (f5 != this.mTextView.getPaint().getTextSize()) {
            this.mTextView.getPaint().setTextSize(f5);
            boolean isInLayout = this.mTextView.isInLayout();
            if (this.mTextView.getLayout() != null) {
                this.mNeedsAutoSizeText = false;
                try {
                    Method textViewMethod = getTextViewMethod("nullLayouts");
                    if (textViewMethod != null) {
                        textViewMethod.invoke(this.mTextView, null);
                    }
                } catch (Exception e5) {
                    Log.w(TAG, "Failed to invoke TextView#nullLayouts() method", e5);
                }
                if (isInLayout) {
                    this.mTextView.forceLayout();
                } else {
                    this.mTextView.requestLayout();
                }
                this.mTextView.invalidate();
            }
        }
    }

    private boolean setupAutoSizeText() {
        if (supportsAutoSizeText() && this.mAutoSizeTextType == 1) {
            if (!this.mHasPresetAutoSizeValues || this.mAutoSizeTextSizesInPx.length == 0) {
                int floor = ((int) Math.floor((this.mAutoSizeMaxTextSizeInPx - this.mAutoSizeMinTextSizeInPx) / this.mAutoSizeStepGranularityInPx)) + 1;
                int[] iArr = new int[floor];
                for (int i5 = 0; i5 < floor; i5++) {
                    iArr[i5] = Math.round(this.mAutoSizeMinTextSizeInPx + (i5 * this.mAutoSizeStepGranularityInPx));
                }
                this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(iArr);
            }
            this.mNeedsAutoSizeText = true;
        } else {
            this.mNeedsAutoSizeText = false;
        }
        return this.mNeedsAutoSizeText;
    }

    private void setupAutoSizeUniformPresetSizes(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i5 = 0; i5 < length; i5++) {
                iArr[i5] = typedArray.getDimensionPixelSize(i5, -1);
            }
            this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(iArr);
            setupAutoSizeUniformPresetSizesConfiguration();
        }
    }

    private boolean setupAutoSizeUniformPresetSizesConfiguration() {
        boolean z5 = this.mAutoSizeTextSizesInPx.length > 0;
        this.mHasPresetAutoSizeValues = z5;
        if (z5) {
            this.mAutoSizeTextType = 1;
            this.mAutoSizeMinTextSizeInPx = r0[0];
            this.mAutoSizeMaxTextSizeInPx = r0[r1 - 1];
            this.mAutoSizeStepGranularityInPx = -1.0f;
        }
        return z5;
    }

    private boolean suggestedSizeFitsInSpace(int i5, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.mTextView.getText();
        TransformationMethod transformationMethod = this.mTextView.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.mTextView)) != null) {
            text = transformation;
        }
        int maxLines = this.mTextView.getMaxLines();
        initTempTextPaint(i5);
        StaticLayout createLayout = createLayout(text, (Layout.Alignment) invokeAndReturnWithDefault(this.mTextView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (createLayout.getLineCount() <= maxLines && createLayout.getLineEnd(createLayout.getLineCount() - 1) == text.length())) && ((float) createLayout.getHeight()) <= rectF.bottom;
    }

    private boolean supportsAutoSizeText() {
        return true;
    }

    private void validateAndSetAutoSizeTextTypeUniformConfiguration(float f5, float f6, float f7) {
        if (f5 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f5 + "px) is less or equal to (0px)");
        }
        if (f6 <= f5) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f6 + "px) is less or equal to minimum auto-size text size (" + f5 + "px)");
        }
        if (f7 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f7 + "px) is less or equal to (0px)");
        }
        this.mAutoSizeTextType = 1;
        this.mAutoSizeMinTextSizeInPx = f5;
        this.mAutoSizeMaxTextSizeInPx = f6;
        this.mAutoSizeStepGranularityInPx = f7;
        this.mHasPresetAutoSizeValues = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void autoSizeText() {
        if (isAutoSizeEnabled()) {
            if (this.mNeedsAutoSizeText) {
                if (this.mTextView.getMeasuredHeight() <= 0 || this.mTextView.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.mImpl.isHorizontallyScrollable(this.mTextView) ? VERY_WIDE : (this.mTextView.getMeasuredWidth() - this.mTextView.getTotalPaddingLeft()) - this.mTextView.getTotalPaddingRight();
                int height = (this.mTextView.getHeight() - this.mTextView.getCompoundPaddingBottom()) - this.mTextView.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = TEMP_RECTF;
                synchronized (rectF) {
                    try {
                        rectF.setEmpty();
                        rectF.right = measuredWidth;
                        rectF.bottom = height;
                        float findLargestTextSizeWhichFits = findLargestTextSizeWhichFits(rectF);
                        if (findLargestTextSizeWhichFits != this.mTextView.getTextSize()) {
                            setTextSizeInternal(0, findLargestTextSizeWhichFits);
                        }
                    } finally {
                    }
                }
            }
            this.mNeedsAutoSizeText = true;
        }
    }

    StaticLayout createLayout(CharSequence charSequence, Layout.Alignment alignment, int i5, int i6) {
        return Api23Impl.createStaticLayoutForMeasuring(charSequence, alignment, i5, i6, this.mTextView, this.mTempTextPaint, this.mImpl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAutoSizeMaxTextSize() {
        return Math.round(this.mAutoSizeMaxTextSizeInPx);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAutoSizeMinTextSize() {
        return Math.round(this.mAutoSizeMinTextSizeInPx);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAutoSizeStepGranularity() {
        return Math.round(this.mAutoSizeStepGranularityInPx);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextSizesInPx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAutoSizeTextType() {
        return this.mAutoSizeTextType;
    }

    void initTempTextPaint(int i5) {
        TextPaint textPaint = this.mTempTextPaint;
        if (textPaint == null) {
            this.mTempTextPaint = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.mTempTextPaint.set(this.mTextView.getPaint());
        this.mTempTextPaint.setTextSize(i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAutoSizeEnabled() {
        return supportsAutoSizeText() && this.mAutoSizeTextType != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadFromAttributes(AttributeSet attributeSet, int i5) {
        int resourceId;
        Context context = this.mContext;
        int[] iArr = R$styleable.AppCompatTextView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i5, 0);
        TextView textView = this.mTextView;
        ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), iArr, attributeSet, obtainStyledAttributes, i5, 0);
        int i6 = R$styleable.AppCompatTextView_autoSizeTextType;
        if (obtainStyledAttributes.hasValue(i6)) {
            this.mAutoSizeTextType = obtainStyledAttributes.getInt(i6, 0);
        }
        int i7 = R$styleable.AppCompatTextView_autoSizeStepGranularity;
        float dimension = obtainStyledAttributes.hasValue(i7) ? obtainStyledAttributes.getDimension(i7, -1.0f) : -1.0f;
        int i8 = R$styleable.AppCompatTextView_autoSizeMinTextSize;
        float dimension2 = obtainStyledAttributes.hasValue(i8) ? obtainStyledAttributes.getDimension(i8, -1.0f) : -1.0f;
        int i9 = R$styleable.AppCompatTextView_autoSizeMaxTextSize;
        float dimension3 = obtainStyledAttributes.hasValue(i9) ? obtainStyledAttributes.getDimension(i9, -1.0f) : -1.0f;
        int i10 = R$styleable.AppCompatTextView_autoSizePresetSizes;
        if (obtainStyledAttributes.hasValue(i10) && (resourceId = obtainStyledAttributes.getResourceId(i10, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            setupAutoSizeUniformPresetSizes(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!supportsAutoSizeText()) {
            this.mAutoSizeTextType = 0;
            return;
        }
        if (this.mAutoSizeTextType == 1) {
            if (!this.mHasPresetAutoSizeValues) {
                DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                validateAndSetAutoSizeTextTypeUniformConfiguration(dimension2, dimension3, dimension);
            }
            setupAutoSizeText();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAutoSizeTextTypeUniformWithConfiguration(int i5, int i6, int i7, int i8) {
        if (supportsAutoSizeText()) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(i8, i5, displayMetrics), TypedValue.applyDimension(i8, i6, displayMetrics), TypedValue.applyDimension(i8, i7, displayMetrics));
            if (setupAutoSizeText()) {
                autoSizeText();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i5) {
        if (supportsAutoSizeText()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i5 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
                    for (int i6 = 0; i6 < length; i6++) {
                        iArr2[i6] = Math.round(TypedValue.applyDimension(i5, iArr[i6], displayMetrics));
                    }
                }
                this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(iArr2);
                if (!setupAutoSizeUniformPresetSizesConfiguration()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.mHasPresetAutoSizeValues = false;
            }
            if (setupAutoSizeText()) {
                autoSizeText();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAutoSizeTextTypeWithDefaults(int i5) {
        if (supportsAutoSizeText()) {
            if (i5 == 0) {
                clearAutoSizeConfiguration();
                return;
            }
            if (i5 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i5);
            }
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (setupAutoSizeText()) {
                autoSizeText();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTextSizeInternal(int i5, float f5) {
        Context context = this.mContext;
        setRawTextSize(TypedValue.applyDimension(i5, f5, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }
}
