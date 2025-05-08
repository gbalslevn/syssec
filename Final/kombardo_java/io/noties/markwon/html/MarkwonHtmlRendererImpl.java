package io.noties.markwon.html;

import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.html.HtmlTag;
import io.noties.markwon.html.MarkwonHtmlParser;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
class MarkwonHtmlRendererImpl extends MarkwonHtmlRenderer {
    private final boolean allowNonClosedTags;
    private final Map<String, TagHandler> tagHandlers;

    /* loaded from: classes2.dex */
    static class Builder {
        private boolean allowNonClosedTags;
        private boolean excludeDefaults;
        private boolean isBuilt;
        private final Map<String, TagHandler> tagHandlers = new HashMap(2);

        private void checkState() {
            if (this.isBuilt) {
                throw new IllegalStateException("Builder has been already built");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void addDefaultTagHandler(TagHandler tagHandler) {
            for (String str : tagHandler.supportedTags()) {
                if (!this.tagHandlers.containsKey(str)) {
                    this.tagHandlers.put(str, tagHandler);
                }
            }
        }

        public MarkwonHtmlRenderer build() {
            checkState();
            this.isBuilt = true;
            return this.tagHandlers.size() > 0 ? new MarkwonHtmlRendererImpl(this.allowNonClosedTags, Collections.unmodifiableMap(this.tagHandlers)) : new MarkwonHtmlRendererNoOp();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean excludeDefaults() {
            return this.excludeDefaults;
        }
    }

    MarkwonHtmlRendererImpl(boolean z5, Map<String, TagHandler> map) {
        this.allowNonClosedTags = z5;
        this.tagHandlers = map;
    }

    @Override // io.noties.markwon.html.MarkwonHtmlRenderer
    public void render(final MarkwonVisitor markwonVisitor, MarkwonHtmlParser markwonHtmlParser) {
        int length = !this.allowNonClosedTags ? -1 : markwonVisitor.length();
        markwonHtmlParser.flushInlineTags(length, new MarkwonHtmlParser.FlushAction<HtmlTag.Inline>() { // from class: io.noties.markwon.html.MarkwonHtmlRendererImpl.1
            @Override // io.noties.markwon.html.MarkwonHtmlParser.FlushAction
            public void apply(List<HtmlTag.Inline> list) {
                TagHandler tagHandler;
                for (HtmlTag.Inline inline : list) {
                    if (inline.isClosed() && (tagHandler = MarkwonHtmlRendererImpl.this.tagHandler(inline.name())) != null) {
                        tagHandler.handle(markwonVisitor, MarkwonHtmlRendererImpl.this, inline);
                    }
                }
            }
        });
        markwonHtmlParser.flushBlockTags(length, new MarkwonHtmlParser.FlushAction<HtmlTag.Block>() { // from class: io.noties.markwon.html.MarkwonHtmlRendererImpl.2
            @Override // io.noties.markwon.html.MarkwonHtmlParser.FlushAction
            public void apply(List<HtmlTag.Block> list) {
                for (HtmlTag.Block block : list) {
                    if (block.isClosed()) {
                        TagHandler tagHandler = MarkwonHtmlRendererImpl.this.tagHandler(block.name());
                        if (tagHandler != null) {
                            tagHandler.handle(markwonVisitor, MarkwonHtmlRendererImpl.this, block);
                        } else {
                            apply(block.children());
                        }
                    }
                }
            }
        });
        markwonHtmlParser.reset();
    }

    @Override // io.noties.markwon.html.MarkwonHtmlRenderer
    public TagHandler tagHandler(String str) {
        return this.tagHandlers.get(str);
    }
}
