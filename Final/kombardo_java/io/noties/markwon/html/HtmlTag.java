package io.noties.markwon.html;

import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public interface HtmlTag {

    /* loaded from: classes2.dex */
    public interface Block extends HtmlTag {
        List<Block> children();

        Block parent();
    }

    /* loaded from: classes2.dex */
    public interface Inline extends HtmlTag {
    }

    Map<String, String> attributes();

    int end();

    Block getAsBlock();

    boolean isBlock();

    boolean isClosed();

    String name();

    int start();
}
