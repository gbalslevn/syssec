package io.noties.markwon.linkify;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import androidx.core.text.util.LinkifyCompat;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonPlugin;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.core.CorePlugin;
import io.noties.markwon.core.CoreProps;
import org.commonmark.node.Link;

/* loaded from: classes2.dex */
public class LinkifyPlugin extends AbstractMarkwonPlugin {
    private final int mask;
    private final boolean useCompat;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class LinkifyCompatTextAddedListener extends LinkifyTextAddedListener {
        LinkifyCompatTextAddedListener(int i5) {
            super(i5);
        }

        @Override // io.noties.markwon.linkify.LinkifyPlugin.LinkifyTextAddedListener
        protected boolean addLinks(Spannable spannable, int i5) {
            return LinkifyCompat.addLinks(spannable, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class LinkifyTextAddedListener implements CorePlugin.OnTextAddedListener {
        private final int mask;

        LinkifyTextAddedListener(int i5) {
            this.mask = i5;
        }

        protected boolean addLinks(Spannable spannable, int i5) {
            return Linkify.addLinks(spannable, i5);
        }

        @Override // io.noties.markwon.core.CorePlugin.OnTextAddedListener
        public void onTextAdded(MarkwonVisitor markwonVisitor, String str, int i5) {
            SpanFactory spanFactory = markwonVisitor.configuration().spansFactory().get(Link.class);
            if (spanFactory == null) {
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            if (addLinks(spannableStringBuilder, this.mask)) {
                URLSpan[] uRLSpanArr = (URLSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), URLSpan.class);
                if (uRLSpanArr == null || uRLSpanArr.length <= 0) {
                    return;
                }
                RenderProps renderProps = markwonVisitor.renderProps();
                SpannableBuilder builder = markwonVisitor.builder();
                for (URLSpan uRLSpan : uRLSpanArr) {
                    CoreProps.LINK_DESTINATION.set(renderProps, uRLSpan.getURL());
                    SpannableBuilder.setSpans(builder, spanFactory.getSpans(markwonVisitor.configuration(), renderProps), spannableStringBuilder.getSpanStart(uRLSpan) + i5, spannableStringBuilder.getSpanEnd(uRLSpan) + i5);
                }
            }
        }
    }

    LinkifyPlugin(int i5, boolean z5) {
        this.mask = i5;
        this.useCompat = z5;
    }

    public static LinkifyPlugin create() {
        return create(false);
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configure(MarkwonPlugin.Registry registry) {
        registry.require(CorePlugin.class, new MarkwonPlugin.Action<CorePlugin>() { // from class: io.noties.markwon.linkify.LinkifyPlugin.1
            @Override // io.noties.markwon.MarkwonPlugin.Action
            public void apply(CorePlugin corePlugin) {
                CorePlugin.OnTextAddedListener linkifyTextAddedListener;
                if (LinkifyPlugin.this.useCompat) {
                    linkifyTextAddedListener = new LinkifyCompatTextAddedListener(LinkifyPlugin.this.mask);
                } else {
                    linkifyTextAddedListener = new LinkifyTextAddedListener(LinkifyPlugin.this.mask);
                }
                corePlugin.addOnTextAddedListener(linkifyTextAddedListener);
            }
        });
    }

    public static LinkifyPlugin create(boolean z5) {
        return create(7, z5);
    }

    public static LinkifyPlugin create(int i5, boolean z5) {
        return new LinkifyPlugin(i5, z5);
    }
}
