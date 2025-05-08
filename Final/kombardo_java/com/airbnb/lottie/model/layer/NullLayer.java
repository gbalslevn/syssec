package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;

/* loaded from: classes.dex */
public class NullLayer extends BaseLayer {
    /* JADX INFO: Access modifiers changed from: package-private */
    public NullLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    void drawLayer(Canvas canvas, Matrix matrix, int i5) {
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public void getBounds(RectF rectF, Matrix matrix, boolean z5) {
        super.getBounds(rectF, matrix, z5);
        rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
