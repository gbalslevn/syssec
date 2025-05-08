package io.noties.markwon.html.jsoup.parser;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public class ParseErrorList extends ArrayList<ParseError> {
    private static final int INITIAL_CAPACITY = 16;
    private final int maxSize;

    ParseErrorList(int i5, int i6) {
        super(i5);
        this.maxSize = i6;
    }

    public static ParseErrorList noTracking() {
        return new ParseErrorList(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean canAddError() {
        return size() < this.maxSize;
    }
}
