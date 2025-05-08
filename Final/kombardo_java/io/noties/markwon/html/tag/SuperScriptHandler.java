package io.noties.markwon.html.tag;

import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.html.HtmlTag;
import io.noties.markwon.html.span.SuperScriptSpan;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes2.dex */
public class SuperScriptHandler extends SimpleTagHandler {
    @Override // io.noties.markwon.html.tag.SimpleTagHandler
    public Object getSpans(MarkwonConfiguration markwonConfiguration, RenderProps renderProps, HtmlTag htmlTag) {
        return new SuperScriptSpan();
    }

    @Override // io.noties.markwon.html.TagHandler
    public Collection<String> supportedTags() {
        return Collections.singleton("sup");
    }
}
