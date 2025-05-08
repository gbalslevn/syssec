package org.commonmark.ext.gfm.strikethrough.internal;

import org.commonmark.ext.gfm.strikethrough.Strikethrough;
import org.commonmark.node.Node;
import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterProcessor;
import org.commonmark.parser.delimiter.DelimiterRun;

/* loaded from: classes3.dex */
public class StrikethroughDelimiterProcessor implements DelimiterProcessor {
    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getClosingCharacter() {
        return '~';
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int getDelimiterUse(DelimiterRun delimiterRun, DelimiterRun delimiterRun2) {
        return (delimiterRun.length() < 2 || delimiterRun2.length() < 2) ? 0 : 2;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public int getMinLength() {
        return 2;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public char getOpeningCharacter() {
        return '~';
    }

    @Override // org.commonmark.parser.delimiter.DelimiterProcessor
    public void process(Text text, Text text2, int i5) {
        Strikethrough strikethrough = new Strikethrough();
        Node next = text.getNext();
        while (next != null && next != text2) {
            Node next2 = next.getNext();
            strikethrough.appendChild(next);
            next = next2;
        }
        text.insertAfter(strikethrough);
    }
}
