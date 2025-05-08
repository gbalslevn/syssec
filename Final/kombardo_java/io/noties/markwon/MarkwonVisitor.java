package io.noties.markwon;

import org.commonmark.node.Node;
import org.commonmark.node.Visitor;

/* loaded from: classes2.dex */
public interface MarkwonVisitor extends Visitor {

    /* loaded from: classes2.dex */
    public interface BlockHandler {
        void blockEnd(MarkwonVisitor markwonVisitor, Node node);

        void blockStart(MarkwonVisitor markwonVisitor, Node node);
    }

    /* loaded from: classes2.dex */
    public interface Builder {
        MarkwonVisitor build(MarkwonConfiguration markwonConfiguration, RenderProps renderProps);

        <N extends Node> Builder on(Class<N> cls, NodeVisitor<? super N> nodeVisitor);
    }

    /* loaded from: classes2.dex */
    public interface NodeVisitor<N extends Node> {
        void visit(MarkwonVisitor markwonVisitor, N n5);
    }

    void blockEnd(Node node);

    void blockStart(Node node);

    SpannableBuilder builder();

    MarkwonConfiguration configuration();

    void ensureNewLine();

    void forceNewLine();

    boolean hasNext(Node node);

    int length();

    RenderProps renderProps();

    void setSpans(int i5, Object obj);

    <N extends Node> void setSpansForNodeOptional(N n5, int i5);

    void visitChildren(Node node);
}
