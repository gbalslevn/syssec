package com.airbnb.lottie.animation;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import com.airbnb.lottie.utils.MiscUtils;
import com.sun.jna.Function;

/* loaded from: classes.dex */
public class LPaint extends Paint {
    public LPaint() {
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i5) {
        if (Build.VERSION.SDK_INT >= 30) {
            super.setAlpha(MiscUtils.clamp(i5, 0, Function.USE_VARARGS));
        } else {
            setColor((MiscUtils.clamp(i5, 0, Function.USE_VARARGS) << 24) | (getColor() & 16777215));
        }
    }

    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList localeList) {
    }

    public LPaint(int i5) {
        super(i5);
    }

    public LPaint(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public LPaint(int i5, PorterDuff.Mode mode) {
        super(i5);
        setXfermode(new PorterDuffXfermode(mode));
    }
}
