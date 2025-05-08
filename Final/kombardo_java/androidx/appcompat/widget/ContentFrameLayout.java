package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {
    private OnAttachListener mAttachListener;
    private final Rect mDecorPadding;
    private TypedValue mFixedHeightMajor;
    private TypedValue mFixedHeightMinor;
    private TypedValue mFixedWidthMajor;
    private TypedValue mFixedWidthMinor;
    private TypedValue mMinWidthMajor;
    private TypedValue mMinWidthMinor;

    /* loaded from: classes.dex */
    public interface OnAttachListener {
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.mFixedHeightMajor == null) {
            this.mFixedHeightMajor = new TypedValue();
        }
        return this.mFixedHeightMajor;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.mFixedHeightMinor == null) {
            this.mFixedHeightMinor = new TypedValue();
        }
        return this.mFixedHeightMinor;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.mFixedWidthMajor == null) {
            this.mFixedWidthMajor = new TypedValue();
        }
        return this.mFixedWidthMajor;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.mFixedWidthMinor == null) {
            this.mFixedWidthMinor = new TypedValue();
        }
        return this.mFixedWidthMinor;
    }

    public TypedValue getMinWidthMajor() {
        if (this.mMinWidthMajor == null) {
            this.mMinWidthMajor = new TypedValue();
        }
        return this.mMinWidthMajor;
    }

    public TypedValue getMinWidthMinor() {
        if (this.mMinWidthMinor == null) {
            this.mMinWidthMinor = new TypedValue();
        }
        return this.mMinWidthMinor;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ae  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i5, int i6) {
        boolean z5;
        int measuredWidth;
        TypedValue typedValue;
        int i7;
        int i8;
        float fraction;
        int i9;
        int i10;
        float fraction2;
        int i11;
        int i12;
        float fraction3;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z6 = true;
        boolean z7 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        if (mode == Integer.MIN_VALUE) {
            TypedValue typedValue2 = z7 ? this.mFixedWidthMinor : this.mFixedWidthMajor;
            if (typedValue2 != null && (i11 = typedValue2.type) != 0) {
                if (i11 == 5) {
                    fraction3 = typedValue2.getDimension(displayMetrics);
                } else if (i11 == 6) {
                    int i13 = displayMetrics.widthPixels;
                    fraction3 = typedValue2.getFraction(i13, i13);
                } else {
                    i12 = 0;
                    if (i12 > 0) {
                        Rect rect = this.mDecorPadding;
                        i5 = View.MeasureSpec.makeMeasureSpec(Math.min(i12 - (rect.left + rect.right), View.MeasureSpec.getSize(i5)), 1073741824);
                        z5 = true;
                        if (mode2 == Integer.MIN_VALUE) {
                            TypedValue typedValue3 = z7 ? this.mFixedHeightMajor : this.mFixedHeightMinor;
                            if (typedValue3 != null && (i9 = typedValue3.type) != 0) {
                                if (i9 == 5) {
                                    fraction2 = typedValue3.getDimension(displayMetrics);
                                } else if (i9 == 6) {
                                    int i14 = displayMetrics.heightPixels;
                                    fraction2 = typedValue3.getFraction(i14, i14);
                                } else {
                                    i10 = 0;
                                    if (i10 > 0) {
                                        Rect rect2 = this.mDecorPadding;
                                        i6 = View.MeasureSpec.makeMeasureSpec(Math.min(i10 - (rect2.top + rect2.bottom), View.MeasureSpec.getSize(i6)), 1073741824);
                                    }
                                }
                                i10 = (int) fraction2;
                                if (i10 > 0) {
                                }
                            }
                        }
                        super.onMeasure(i5, i6);
                        measuredWidth = getMeasuredWidth();
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                        if (!z5 && mode == Integer.MIN_VALUE) {
                            typedValue = !z7 ? this.mMinWidthMinor : this.mMinWidthMajor;
                            if (typedValue != null && (i7 = typedValue.type) != 0) {
                                if (i7 != 5) {
                                    fraction = typedValue.getDimension(displayMetrics);
                                } else if (i7 == 6) {
                                    int i15 = displayMetrics.widthPixels;
                                    fraction = typedValue.getFraction(i15, i15);
                                } else {
                                    i8 = 0;
                                    if (i8 > 0) {
                                        Rect rect3 = this.mDecorPadding;
                                        i8 -= rect3.left + rect3.right;
                                    }
                                    if (measuredWidth < i8) {
                                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
                                        if (z6) {
                                            super.onMeasure(makeMeasureSpec, i6);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                i8 = (int) fraction;
                                if (i8 > 0) {
                                }
                                if (measuredWidth < i8) {
                                }
                            }
                        }
                        z6 = false;
                        if (z6) {
                        }
                    }
                }
                i12 = (int) fraction3;
                if (i12 > 0) {
                }
            }
        }
        z5 = false;
        if (mode2 == Integer.MIN_VALUE) {
        }
        super.onMeasure(i5, i6);
        measuredWidth = getMeasuredWidth();
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        if (!z5) {
            if (!z7) {
            }
            if (typedValue != null) {
                if (i7 != 5) {
                }
                i8 = (int) fraction;
                if (i8 > 0) {
                }
                if (measuredWidth < i8) {
                }
            }
        }
        z6 = false;
        if (z6) {
        }
    }

    public void setAttachListener(OnAttachListener onAttachListener) {
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mDecorPadding = new Rect();
    }
}
