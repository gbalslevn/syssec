package io.noties.markwon.html.tag;

import android.text.TextUtils;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.html.CssInlineStyleParser;
import io.noties.markwon.html.HtmlTag;
import io.noties.markwon.image.ImageProps;
import io.noties.markwon.image.ImageSize;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.commonmark.node.Image;

/* loaded from: classes2.dex */
public class ImageHandler extends SimpleTagHandler {
    private final ImageSizeParser imageSizeParser;

    /* loaded from: classes2.dex */
    interface ImageSizeParser {
        ImageSize parse(Map<String, String> map);
    }

    ImageHandler(ImageSizeParser imageSizeParser) {
        this.imageSizeParser = imageSizeParser;
    }

    public static ImageHandler create() {
        return new ImageHandler(new ImageSizeParserImpl(CssInlineStyleParser.create()));
    }

    @Override // io.noties.markwon.html.tag.SimpleTagHandler
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps, HtmlTag htmlTag) {
        SpanFactory spanFactory;
        String str = htmlTag.attributes().get("src");
        if (TextUtils.isEmpty(str) || (spanFactory = markwonConfiguration.spansFactory().get(Image.class)) == null) {
            return null;
        }
        String process = markwonConfiguration.imageDestinationProcessor().process(str);
        ImageSize parse = this.imageSizeParser.parse(htmlTag.attributes());
        ImageProps.DESTINATION.set(renderProps, process);
        ImageProps.IMAGE_SIZE.set(renderProps, parse);
        ImageProps.REPLACEMENT_TEXT_IS_LINK.set(renderProps, Boolean.FALSE);
        return spanFactory.getSpans(markwonConfiguration, renderProps);
    }

    @Override // io.noties.markwon.html.TagHandler
    public Collection<String> supportedTags() {
        return Collections.singleton("img");
    }
}
