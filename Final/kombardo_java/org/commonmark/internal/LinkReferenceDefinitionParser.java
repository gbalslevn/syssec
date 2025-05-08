package org.commonmark.internal;

import java.util.ArrayList;
import java.util.List;
import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.LinkScanner;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.LinkReferenceDefinition;

/* loaded from: classes3.dex */
public class LinkReferenceDefinitionParser {
    private String destination;
    private StringBuilder label;
    private String normalizedLabel;
    private StringBuilder title;
    private char titleDelimiter;
    private State state = State.START_DEFINITION;
    private final StringBuilder paragraph = new StringBuilder();
    private final List<LinkReferenceDefinition> definitions = new ArrayList();
    private boolean referenceValid = false;

    /* renamed from: org.commonmark.internal.LinkReferenceDefinitionParser$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State = iArr;
            try {
                iArr[State.PARAGRAPH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State[State.START_DEFINITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State[State.LABEL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State[State.DESTINATION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State[State.START_TITLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State[State.TITLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum State {
        START_DEFINITION,
        LABEL,
        DESTINATION,
        START_TITLE,
        TITLE,
        PARAGRAPH
    }

    private int destination(CharSequence charSequence, int i5) {
        int skipSpaceTab = Parsing.skipSpaceTab(charSequence, i5, charSequence.length());
        int scanLinkDestination = LinkScanner.scanLinkDestination(charSequence, skipSpaceTab);
        if (scanLinkDestination == -1) {
            return -1;
        }
        this.destination = charSequence.charAt(skipSpaceTab) == '<' ? charSequence.subSequence(skipSpaceTab + 1, scanLinkDestination - 1).toString() : charSequence.subSequence(skipSpaceTab, scanLinkDestination).toString();
        int skipSpaceTab2 = Parsing.skipSpaceTab(charSequence, scanLinkDestination, charSequence.length());
        if (skipSpaceTab2 >= charSequence.length()) {
            this.referenceValid = true;
            this.paragraph.setLength(0);
        } else if (skipSpaceTab2 == scanLinkDestination) {
            return -1;
        }
        this.state = State.START_TITLE;
        return skipSpaceTab2;
    }

    private void finishReference() {
        if (this.referenceValid) {
            String unescapeString = Escaping.unescapeString(this.destination);
            StringBuilder sb = this.title;
            this.definitions.add(new LinkReferenceDefinition(this.normalizedLabel, unescapeString, sb != null ? Escaping.unescapeString(sb.toString()) : null));
            this.label = null;
            this.referenceValid = false;
            this.normalizedLabel = null;
            this.destination = null;
            this.title = null;
        }
    }

    private int label(CharSequence charSequence, int i5) {
        int i6;
        int scanLinkLabelContent = LinkScanner.scanLinkLabelContent(charSequence, i5);
        if (scanLinkLabelContent == -1) {
            return -1;
        }
        this.label.append(charSequence, i5, scanLinkLabelContent);
        if (scanLinkLabelContent >= charSequence.length()) {
            this.label.append('\n');
            return scanLinkLabelContent;
        }
        if (charSequence.charAt(scanLinkLabelContent) != ']' || (i6 = scanLinkLabelContent + 1) >= charSequence.length() || charSequence.charAt(i6) != ':' || this.label.length() > 999) {
            return -1;
        }
        String normalizeLabelContent = Escaping.normalizeLabelContent(this.label.toString());
        if (normalizeLabelContent.isEmpty()) {
            return -1;
        }
        this.normalizedLabel = normalizeLabelContent;
        this.state = State.DESTINATION;
        return Parsing.skipSpaceTab(charSequence, scanLinkLabelContent + 2, charSequence.length());
    }

    private int startDefinition(CharSequence charSequence, int i5) {
        int skipSpaceTab = Parsing.skipSpaceTab(charSequence, i5, charSequence.length());
        if (skipSpaceTab >= charSequence.length() || charSequence.charAt(skipSpaceTab) != '[') {
            return -1;
        }
        this.state = State.LABEL;
        this.label = new StringBuilder();
        int i6 = skipSpaceTab + 1;
        if (i6 >= charSequence.length()) {
            this.label.append('\n');
        }
        return i6;
    }

    private int startTitle(CharSequence charSequence, int i5) {
        int skipSpaceTab = Parsing.skipSpaceTab(charSequence, i5, charSequence.length());
        if (skipSpaceTab >= charSequence.length()) {
            this.state = State.START_DEFINITION;
            return skipSpaceTab;
        }
        this.titleDelimiter = (char) 0;
        char charAt = charSequence.charAt(skipSpaceTab);
        if (charAt == '\"' || charAt == '\'') {
            this.titleDelimiter = charAt;
        } else if (charAt == '(') {
            this.titleDelimiter = ')';
        }
        if (this.titleDelimiter != 0) {
            this.state = State.TITLE;
            this.title = new StringBuilder();
            skipSpaceTab++;
            if (skipSpaceTab == charSequence.length()) {
                this.title.append('\n');
            }
        } else {
            finishReference();
            this.state = State.START_DEFINITION;
        }
        return skipSpaceTab;
    }

    private int title(CharSequence charSequence, int i5) {
        int scanLinkTitleContent = LinkScanner.scanLinkTitleContent(charSequence, i5, this.titleDelimiter);
        if (scanLinkTitleContent == -1) {
            return -1;
        }
        this.title.append(charSequence.subSequence(i5, scanLinkTitleContent));
        if (scanLinkTitleContent >= charSequence.length()) {
            this.title.append('\n');
            return scanLinkTitleContent;
        }
        int skipSpaceTab = Parsing.skipSpaceTab(charSequence, scanLinkTitleContent + 1, charSequence.length());
        if (skipSpaceTab != charSequence.length()) {
            return -1;
        }
        this.referenceValid = true;
        finishReference();
        this.paragraph.setLength(0);
        this.state = State.START_DEFINITION;
        return skipSpaceTab;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<LinkReferenceDefinition> getDefinitions() {
        finishReference();
        return this.definitions;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence getParagraphContent() {
        return this.paragraph;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[LOOP:0: B:5:0x0015->B:20:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parse(CharSequence charSequence) {
        if (this.paragraph.length() != 0) {
            this.paragraph.append('\n');
        }
        this.paragraph.append(charSequence);
        int i5 = 0;
        while (i5 < charSequence.length()) {
            switch (AnonymousClass1.$SwitchMap$org$commonmark$internal$LinkReferenceDefinitionParser$State[this.state.ordinal()]) {
                case 1:
                    return;
                case 2:
                    i5 = startDefinition(charSequence, i5);
                    if (i5 != -1) {
                        this.state = State.PARAGRAPH;
                        return;
                    }
                case 3:
                    i5 = label(charSequence, i5);
                    if (i5 != -1) {
                    }
                    break;
                case 4:
                    i5 = destination(charSequence, i5);
                    if (i5 != -1) {
                    }
                    break;
                case 5:
                    i5 = startTitle(charSequence, i5);
                    if (i5 != -1) {
                    }
                    break;
                case 6:
                    i5 = title(charSequence, i5);
                    if (i5 != -1) {
                    }
                    break;
                default:
                    if (i5 != -1) {
                    }
                    break;
            }
        }
    }
}
