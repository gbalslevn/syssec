package io.noties.markwon.utils;

import android.content.Context;

/* loaded from: classes2.dex */
public class Dip {
    private final float density;

    public Dip(float f5) {
        this.density = f5;
    }

    public static Dip create(Context context) {
        return new Dip(context.getResources().getDisplayMetrics().density);
    }

    public int toPx(int i5) {
        return (int) ((i5 * this.density) + 0.5f);
    }
}
