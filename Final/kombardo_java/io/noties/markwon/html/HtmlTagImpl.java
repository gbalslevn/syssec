package io.noties.markwon.html;

import io.noties.markwon.html.HtmlTag;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class HtmlTagImpl implements HtmlTag {
    final Map<String, String> attributes;
    int end = -1;
    final String name;
    final int start;

    /* loaded from: classes2.dex */
    static class BlockImpl extends HtmlTagImpl implements HtmlTag.Block {
        List<BlockImpl> children;
        final BlockImpl parent;

        BlockImpl(String str, int i5, Map<String, String> map, BlockImpl blockImpl) {
            super(str, i5, map);
            this.parent = blockImpl;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static BlockImpl create(String str, int i5, Map<String, String> map, BlockImpl blockImpl) {
            return new BlockImpl(str, i5, map, blockImpl);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static BlockImpl root() {
            return new BlockImpl(BuildConfig.FLAVOR, 0, Collections.emptyMap(), null);
        }

        @Override // io.noties.markwon.html.HtmlTagImpl, io.noties.markwon.html.HtmlTag
        public Map<String, String> attributes() {
            return this.attributes;
        }

        @Override // io.noties.markwon.html.HtmlTag.Block
        public List<HtmlTag.Block> children() {
            List<BlockImpl> list = this.children;
            return list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void closeAt(int i5) {
            if (isClosed()) {
                return;
            }
            this.end = i5;
            List<BlockImpl> list = this.children;
            if (list != null) {
                Iterator<BlockImpl> it = list.iterator();
                while (it.hasNext()) {
                    it.next().closeAt(i5);
                }
            }
        }

        @Override // io.noties.markwon.html.HtmlTag
        public HtmlTag.Block getAsBlock() {
            return this;
        }

        @Override // io.noties.markwon.html.HtmlTag
        public boolean isBlock() {
            return true;
        }

        @Override // io.noties.markwon.html.HtmlTag.Block
        public HtmlTag.Block parent() {
            return this.parent;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BlockImpl{name='");
            sb.append(this.name);
            sb.append('\'');
            sb.append(", start=");
            sb.append(this.start);
            sb.append(", end=");
            sb.append(this.end);
            sb.append(", attributes=");
            sb.append(this.attributes);
            sb.append(", parent=");
            BlockImpl blockImpl = this.parent;
            sb.append(blockImpl != null ? blockImpl.name : null);
            sb.append(", children=");
            sb.append(this.children);
            sb.append('}');
            return sb.toString();
        }
    }

    /* loaded from: classes2.dex */
    static class InlineImpl extends HtmlTagImpl implements HtmlTag.Inline {
        /* JADX INFO: Access modifiers changed from: package-private */
        public InlineImpl(String str, int i5, Map<String, String> map) {
            super(str, i5, map);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void closeAt(int i5) {
            if (isClosed()) {
                return;
            }
            this.end = i5;
        }

        @Override // io.noties.markwon.html.HtmlTag
        public HtmlTag.Block getAsBlock() {
            throw new ClassCastException("Cannot cast Inline instance to Block");
        }

        @Override // io.noties.markwon.html.HtmlTag
        public boolean isBlock() {
            return false;
        }

        public String toString() {
            return "InlineImpl{name='" + this.name + "', start=" + this.start + ", end=" + this.end + ", attributes=" + this.attributes + '}';
        }
    }

    protected HtmlTagImpl(String str, int i5, Map<String, String> map) {
        this.name = str;
        this.start = i5;
        this.attributes = map;
    }

    @Override // io.noties.markwon.html.HtmlTag
    public Map<String, String> attributes() {
        return this.attributes;
    }

    @Override // io.noties.markwon.html.HtmlTag
    public int end() {
        return this.end;
    }

    @Override // io.noties.markwon.html.HtmlTag
    public boolean isClosed() {
        return this.end > -1;
    }

    public boolean isEmpty() {
        return this.start == this.end;
    }

    @Override // io.noties.markwon.html.HtmlTag
    public String name() {
        return this.name;
    }

    @Override // io.noties.markwon.html.HtmlTag
    public int start() {
        return this.start;
    }
}
