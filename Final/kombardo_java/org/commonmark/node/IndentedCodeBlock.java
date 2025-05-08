package org.commonmark.node;

/* loaded from: classes3.dex */
public class IndentedCodeBlock extends Block {
    private String literal;

    @Override // org.commonmark.node.Node
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getLiteral() {
        return this.literal;
    }

    public void setLiteral(String str) {
        this.literal = str;
    }
}
