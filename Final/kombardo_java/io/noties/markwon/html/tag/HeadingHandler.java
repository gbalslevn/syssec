package io.noties.markwon.html.tag;

import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.html.HtmlTag;
import java.util.Arrays;
import java.util.Collection;
import org.commonmark.node.Heading;

/* loaded from: classes2.dex */
public class HeadingHandler extends SimpleTagHandler {
    @Override // io.noties.markwon.html.tag.SimpleTagHandler
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps, HtmlTag htmlTag) {
        int i5;
        SpanFactory spanFactory = markwonConfiguration.spansFactory().get(Heading.class);
        if (spanFactory == null) {
            return null;
        }
        try {
            i5 = Integer.parseInt(htmlTag.name().substring(1));
        } catch (NumberFormatException e5) {
            e5.printStackTrace();
            i5 = 0;
        }
        if (i5 < 1 || i5 > 6) {
            return null;
        }
        CoreProps.HEADING_LEVEL.set(renderProps, Integer.valueOf(i5));
        return spanFactory.getSpans(markwonConfiguration, renderProps);
    }

    @Override // io.noties.markwon.html.TagHandler
    public Collection<String> supportedTags() {
        return Arrays.asList("h1", "h2", "h3", "h4", "h5", "h6");
    }
}
