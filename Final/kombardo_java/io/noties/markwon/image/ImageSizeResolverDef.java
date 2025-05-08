package io.noties.markwon.image;

import android.graphics.Rect;
import io.noties.markwon.image.ImageSize;

/* loaded from: classes2.dex */
public class ImageSizeResolverDef extends ImageSizeResolver {
    protected int resolveAbsolute(ImageSize.Dimension dimension, int i5, float f5) {
        return (int) (("em".equals(dimension.unit) ? dimension.value * f5 : dimension.value) + 0.5f);
    }

    @Override // io.noties.markwon.image.ImageSizeResolver
    public Rect resolveImageSize(AsyncDrawable asyncDrawable) {
        return resolveImageSize(asyncDrawable.getImageSize(), asyncDrawable.getResult().getBounds(), asyncDrawable.getLastKnownCanvasWidth(), asyncDrawable.getLastKnowTextSize());
    }

    protected Rect resolveImageSize(ImageSize imageSize, Rect rect, int i5, float f5) {
        Rect rect2;
        int resolveAbsolute;
        if (imageSize == null) {
            int width = rect.width();
            if (width > i5) {
                return new Rect(0, 0, i5, (int) ((rect.height() / (width / i5)) + 0.5f));
            }
            return rect;
        }
        ImageSize.Dimension dimension = imageSize.width;
        ImageSize.Dimension dimension2 = imageSize.height;
        int width2 = rect.width();
        int height = rect.height();
        float f6 = width2 / height;
        if (dimension != null) {
            if ("%".equals(dimension.unit)) {
                resolveAbsolute = (int) ((i5 * (dimension.value / 100.0f)) + 0.5f);
            } else {
                resolveAbsolute = resolveAbsolute(dimension, width2, f5);
            }
            rect2 = new Rect(0, 0, resolveAbsolute, (dimension2 == null || "%".equals(dimension2.unit)) ? (int) ((resolveAbsolute / f6) + 0.5f) : resolveAbsolute(dimension2, height, f5));
        } else {
            if (dimension2 == null || "%".equals(dimension2.unit)) {
                return rect;
            }
            int resolveAbsolute2 = resolveAbsolute(dimension2, height, f5);
            rect2 = new Rect(0, 0, (int) ((resolveAbsolute2 * f6) + 0.5f), resolveAbsolute2);
        }
        return rect2;
    }
}
