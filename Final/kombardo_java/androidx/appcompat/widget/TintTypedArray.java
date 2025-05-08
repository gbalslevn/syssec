package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;

/* loaded from: classes.dex */
public class TintTypedArray {
    private final Context mContext;
    private TypedValue mTypedValue;
    private final TypedArray mWrapped;

    private TintTypedArray(Context context, TypedArray typedArray) {
        this.mContext = context;
        this.mWrapped = typedArray;
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public boolean getBoolean(int i5, boolean z5) {
        return this.mWrapped.getBoolean(i5, z5);
    }

    public int getColor(int i5, int i6) {
        return this.mWrapped.getColor(i5, i6);
    }

    public ColorStateList getColorStateList(int i5) {
        int resourceId;
        ColorStateList colorStateList;
        return (!this.mWrapped.hasValue(i5) || (resourceId = this.mWrapped.getResourceId(i5, 0)) == 0 || (colorStateList = AppCompatResources.getColorStateList(this.mContext, resourceId)) == null) ? this.mWrapped.getColorStateList(i5) : colorStateList;
    }

    public int getDimensionPixelOffset(int i5, int i6) {
        return this.mWrapped.getDimensionPixelOffset(i5, i6);
    }

    public int getDimensionPixelSize(int i5, int i6) {
        return this.mWrapped.getDimensionPixelSize(i5, i6);
    }

    public Drawable getDrawable(int i5) {
        int resourceId;
        return (!this.mWrapped.hasValue(i5) || (resourceId = this.mWrapped.getResourceId(i5, 0)) == 0) ? this.mWrapped.getDrawable(i5) : AppCompatResources.getDrawable(this.mContext, resourceId);
    }

    public float getFloat(int i5, float f5) {
        return this.mWrapped.getFloat(i5, f5);
    }

    public Typeface getFont(int i5, int i6, ResourcesCompat.FontCallback fontCallback) {
        int resourceId = this.mWrapped.getResourceId(i5, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        return ResourcesCompat.getFont(this.mContext, resourceId, this.mTypedValue, i6, fontCallback);
    }

    public int getInt(int i5, int i6) {
        return this.mWrapped.getInt(i5, i6);
    }

    public int getInteger(int i5, int i6) {
        return this.mWrapped.getInteger(i5, i6);
    }

    public int getLayoutDimension(int i5, int i6) {
        return this.mWrapped.getLayoutDimension(i5, i6);
    }

    public int getResourceId(int i5, int i6) {
        return this.mWrapped.getResourceId(i5, i6);
    }

    public String getString(int i5) {
        return this.mWrapped.getString(i5);
    }

    public CharSequence getText(int i5) {
        return this.mWrapped.getText(i5);
    }

    public TypedArray getWrappedTypeArray() {
        return this.mWrapped;
    }

    public boolean hasValue(int i5) {
        return this.mWrapped.hasValue(i5);
    }

    public TypedValue peekValue(int i5) {
        return this.mWrapped.peekValue(i5);
    }

    public void recycle() {
        this.mWrapped.recycle();
    }

    public static TintTypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i5, int i6) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i5, i6));
    }

    public static TintTypedArray obtainStyledAttributes(Context context, int i5, int[] iArr) {
        return new TintTypedArray(context, context.obtainStyledAttributes(i5, iArr));
    }
}
