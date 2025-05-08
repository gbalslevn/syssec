package androidx.appcompat.widget;

/* loaded from: classes.dex */
class RtlSpacingHelper {
    private int mLeft = 0;
    private int mRight = 0;
    private int mStart = Integer.MIN_VALUE;
    private int mEnd = Integer.MIN_VALUE;
    private int mExplicitLeft = 0;
    private int mExplicitRight = 0;
    private boolean mIsRtl = false;
    private boolean mIsRelative = false;

    public int getEnd() {
        return this.mIsRtl ? this.mLeft : this.mRight;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getRight() {
        return this.mRight;
    }

    public int getStart() {
        return this.mIsRtl ? this.mRight : this.mLeft;
    }

    public void setAbsolute(int i5, int i6) {
        this.mIsRelative = false;
        if (i5 != Integer.MIN_VALUE) {
            this.mExplicitLeft = i5;
            this.mLeft = i5;
        }
        if (i6 != Integer.MIN_VALUE) {
            this.mExplicitRight = i6;
            this.mRight = i6;
        }
    }

    public void setDirection(boolean z5) {
        if (z5 == this.mIsRtl) {
            return;
        }
        this.mIsRtl = z5;
        if (!this.mIsRelative) {
            this.mLeft = this.mExplicitLeft;
            this.mRight = this.mExplicitRight;
            return;
        }
        if (z5) {
            int i5 = this.mEnd;
            if (i5 == Integer.MIN_VALUE) {
                i5 = this.mExplicitLeft;
            }
            this.mLeft = i5;
            int i6 = this.mStart;
            if (i6 == Integer.MIN_VALUE) {
                i6 = this.mExplicitRight;
            }
            this.mRight = i6;
            return;
        }
        int i7 = this.mStart;
        if (i7 == Integer.MIN_VALUE) {
            i7 = this.mExplicitLeft;
        }
        this.mLeft = i7;
        int i8 = this.mEnd;
        if (i8 == Integer.MIN_VALUE) {
            i8 = this.mExplicitRight;
        }
        this.mRight = i8;
    }

    public void setRelative(int i5, int i6) {
        this.mStart = i5;
        this.mEnd = i6;
        this.mIsRelative = true;
        if (this.mIsRtl) {
            if (i6 != Integer.MIN_VALUE) {
                this.mLeft = i6;
            }
            if (i5 != Integer.MIN_VALUE) {
                this.mRight = i5;
                return;
            }
            return;
        }
        if (i5 != Integer.MIN_VALUE) {
            this.mLeft = i5;
        }
        if (i6 != Integer.MIN_VALUE) {
            this.mRight = i6;
        }
    }
}
