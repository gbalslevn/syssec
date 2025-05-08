package io.noties.markwon.html.tag;

import android.text.TextUtils;
import io.noties.markwon.html.CssInlineStyleParser;
import io.noties.markwon.html.CssProperty;
import io.noties.markwon.html.tag.ImageHandler;
import io.noties.markwon.image.ImageSize;
import java.util.Map;

/* loaded from: classes2.dex */
class ImageSizeParserImpl implements ImageHandler.ImageSizeParser {
    private final CssInlineStyleParser inlineStyleParser;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageSizeParserImpl(CssInlineStyleParser cssInlineStyleParser) {
        this.inlineStyleParser = cssInlineStyleParser;
    }

    ImageSize.Dimension dimension(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int length = str.length();
        int i5 = length - 1;
        int i6 = i5;
        while (i6 > -1) {
            if (Character.isDigit(str.charAt(i6))) {
                int i7 = i6 + 1;
                try {
                    return new ImageSize.Dimension(Float.parseFloat(str.substring(0, i7)), i6 == i5 ? null : str.substring(i7, length));
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
            i6--;
        }
        return null;
    }

    @Override // io.noties.markwon.html.tag.ImageHandler.ImageSizeParser
    public ImageSize parse(Map<String, String> map) {
        ImageSize.Dimension dimension;
        ImageSize.Dimension dimension2;
        String str = map.get("style");
        if (!TextUtils.isEmpty(str)) {
            dimension = null;
            dimension2 = null;
            for (CssProperty cssProperty : this.inlineStyleParser.parse(str)) {
                String key = cssProperty.key();
                if ("width".equals(key)) {
                    dimension = dimension(cssProperty.value());
                } else if ("height".equals(key)) {
                    dimension2 = dimension(cssProperty.value());
                }
                if (dimension != null && dimension2 != null) {
                    break;
                }
            }
        } else {
            dimension = null;
            dimension2 = null;
        }
        if (dimension != null && dimension2 != null) {
            return new ImageSize(dimension, dimension2);
        }
        if (dimension == null) {
            dimension = dimension(map.get("width"));
        }
        if (dimension2 == null) {
            dimension2 = dimension(map.get("height"));
        }
        if (dimension == null && dimension2 == null) {
            return null;
        }
        return new ImageSize(dimension, dimension2);
    }
}
