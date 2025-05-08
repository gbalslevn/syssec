package com.airbnb.lottie.model;

import android.graphics.PointF;

/* loaded from: classes.dex */
public class DocumentData {
    public float baselineShift;
    public PointF boxPosition;
    public PointF boxSize;
    public int color;
    public String fontName;
    public Justification justification;
    public float lineHeight;
    public float size;
    public int strokeColor;
    public boolean strokeOverFill;
    public float strokeWidth;
    public String text;
    public int tracking;

    /* loaded from: classes.dex */
    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f5, Justification justification, int i5, float f6, float f7, int i6, int i7, float f8, boolean z5, PointF pointF, PointF pointF2) {
        set(str, str2, f5, justification, i5, f6, f7, i6, i7, f8, z5, pointF, pointF2);
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31) + this.size)) * 31) + this.justification.ordinal()) * 31) + this.tracking;
        long floatToRawIntBits = Float.floatToRawIntBits(this.lineHeight);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.color;
    }

    public void set(String str, String str2, float f5, Justification justification, int i5, float f6, float f7, int i6, int i7, float f8, boolean z5, PointF pointF, PointF pointF2) {
        this.text = str;
        this.fontName = str2;
        this.size = f5;
        this.justification = justification;
        this.tracking = i5;
        this.lineHeight = f6;
        this.baselineShift = f7;
        this.color = i6;
        this.strokeColor = i7;
        this.strokeWidth = f8;
        this.strokeOverFill = z5;
        this.boxPosition = pointF;
        this.boxSize = pointF2;
    }

    public DocumentData() {
    }
}
