package io.noties.markwon;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.TextView;
import io.noties.markwon.Markwon;
import java.util.Iterator;
import java.util.List;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;

/* loaded from: classes2.dex */
class MarkwonImpl extends Markwon {
    private final TextView.BufferType bufferType;
    private final MarkwonConfiguration configuration;
    private final boolean fallbackToRawInputWhenEmpty;
    private final Parser parser;
    private final List<MarkwonPlugin> plugins;
    private final Markwon.TextSetter textSetter;
    private final MarkwonVisitorFactory visitorFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MarkwonImpl(TextView.BufferType bufferType, Markwon.TextSetter textSetter, Parser parser, MarkwonVisitorFactory markwonVisitorFactory, MarkwonConfiguration markwonConfiguration, List<MarkwonPlugin> list, boolean z5) {
        this.bufferType = bufferType;
        this.parser = parser;
        this.visitorFactory = markwonVisitorFactory;
        this.configuration = markwonConfiguration;
        this.plugins = list;
        this.fallbackToRawInputWhenEmpty = z5;
    }

    public Node parse(String str) {
        Iterator<MarkwonPlugin> it = this.plugins.iterator();
        while (it.hasNext()) {
            str = it.next().processMarkdown(str);
        }
        return this.parser.parse(str);
    }

    public Spanned render(Node node) {
        Iterator<MarkwonPlugin> it = this.plugins.iterator();
        while (it.hasNext()) {
            it.next().beforeRender(node);
        }
        MarkwonVisitor create = this.visitorFactory.create();
        node.accept(create);
        Iterator<MarkwonPlugin> it2 = this.plugins.iterator();
        while (it2.hasNext()) {
            it2.next().afterRender(node, create);
        }
        return create.builder().spannableStringBuilder();
    }

    @Override // io.noties.markwon.Markwon
    public void setMarkdown(TextView textView, String str) {
        setParsedMarkdown(textView, toMarkdown(str));
    }

    public void setParsedMarkdown(TextView textView, Spanned spanned) {
        Iterator<MarkwonPlugin> it = this.plugins.iterator();
        while (it.hasNext()) {
            it.next().beforeSetText(textView, spanned);
        }
        textView.setText(spanned, this.bufferType);
        Iterator<MarkwonPlugin> it2 = this.plugins.iterator();
        while (it2.hasNext()) {
            it2.next().afterSetText(textView);
        }
    }

    public Spanned toMarkdown(String str) {
        Spanned render = render(parse(str));
        return (TextUtils.isEmpty(render) && this.fallbackToRawInputWhenEmpty && !TextUtils.isEmpty(str)) ? new SpannableStringBuilder(str) : render;
    }
}
