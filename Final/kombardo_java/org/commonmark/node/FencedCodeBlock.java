package org.commonmark.node;

/* loaded from: classes3.dex */
public class FencedCodeBlock extends Block {
    private char fenceChar;
    private int fenceIndent;
    private int fenceLength;
    private String info;
    private String literal;

    @Override // org.commonmark.node.Node
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public char getFenceChar() {
        return this.fenceChar;
    }

    public int getFenceIndent() {
        return this.fenceIndent;
    }

    public int getFenceLength() {
        return this.fenceLength;
    }

    public String getInfo() {
        return this.info;
    }

    public String getLiteral() {
        return this.literal;
    }

    public void setFenceChar(char c5) {
        this.fenceChar = c5;
    }

    public void setFenceIndent(int i5) {
        this.fenceIndent = i5;
    }

    public void setFenceLength(int i5) {
        this.fenceLength = i5;
    }

    public void setInfo(String str) {
        this.info = str;
    }

    public void setLiteral(String str) {
        this.literal = str;
    }
}
