package com.airbnb.lottie;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class LottieImageAsset {
    private Bitmap bitmap;
    private final String dirName;
    private final String fileName;
    private final int height;
    private final String id;
    private final int width;

    public LottieImageAsset(int i5, int i6, String str, String str2, String str3) {
        this.width = i5;
        this.height = i6;
        this.id = str;
        this.fileName = str2;
        this.dirName = str3;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.id;
    }

    public int getWidth() {
        return this.width;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
