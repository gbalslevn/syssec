package org.commonmark.node;

/* loaded from: classes3.dex */
public class LinkReferenceDefinition extends Node {
    private String destination;
    private String label;
    private String title;

    public LinkReferenceDefinition(String str, String str2, String str3) {
        this.label = str;
        this.destination = str2;
        this.title = str3;
    }

    @Override // org.commonmark.node.Node
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getDestination() {
        return this.destination;
    }

    public String getLabel() {
        return this.label;
    }

    public String getTitle() {
        return this.title;
    }
}
