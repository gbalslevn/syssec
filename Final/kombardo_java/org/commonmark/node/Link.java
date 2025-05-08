package org.commonmark.node;

/* loaded from: classes3.dex */
public class Link extends Node {
    private String destination;
    private String title;

    public Link(String str, String str2) {
        this.destination = str;
        this.title = str2;
    }

    @Override // org.commonmark.node.Node
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getDestination() {
        return this.destination;
    }

    @Override // org.commonmark.node.Node
    protected String toStringAttributes() {
        return "destination=" + this.destination + ", title=" + this.title;
    }
}
