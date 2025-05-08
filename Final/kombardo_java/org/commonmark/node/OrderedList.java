package org.commonmark.node;

/* loaded from: classes3.dex */
public class OrderedList extends ListBlock {
    private char delimiter;
    private int startNumber;

    @Override // org.commonmark.node.Node
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public char getDelimiter() {
        return this.delimiter;
    }

    public int getStartNumber() {
        return this.startNumber;
    }

    public void setDelimiter(char c5) {
        this.delimiter = c5;
    }

    public void setStartNumber(int i5) {
        this.startNumber = i5;
    }
}
