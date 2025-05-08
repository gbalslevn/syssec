package org.commonmark.internal;

import org.commonmark.node.Text;

/* loaded from: classes3.dex */
public class Bracket {
    public boolean allowed = true;
    public boolean bracketAfter = false;
    public final boolean image;
    public final int index;
    public final Text node;
    public final Bracket previous;
    public final Delimiter previousDelimiter;

    private Bracket(Text text, int i5, Bracket bracket, Delimiter delimiter, boolean z5) {
        this.node = text;
        this.index = i5;
        this.image = z5;
        this.previous = bracket;
        this.previousDelimiter = delimiter;
    }

    public static Bracket image(Text text, int i5, Bracket bracket, Delimiter delimiter) {
        return new Bracket(text, i5, bracket, delimiter, true);
    }

    public static Bracket link(Text text, int i5, Bracket bracket, Delimiter delimiter) {
        return new Bracket(text, i5, bracket, delimiter, false);
    }
}
