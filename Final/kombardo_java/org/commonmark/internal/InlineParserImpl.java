package org.commonmark.internal;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.internal.inline.AsteriskDelimiterProcessor;
import org.commonmark.internal.inline.UnderscoreDelimiterProcessor;
import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.Html5Entities;
import org.commonmark.internal.util.LinkScanner;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.Code;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.Node;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.Text;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.InlineParserContext;
import org.commonmark.parser.delimiter.DelimiterProcessor;

/* loaded from: classes3.dex */
public class InlineParserImpl implements InlineParser {
    private static final String ASCII_PUNCTUATION = "!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~";
    private static final String CDATA = "<!\\[CDATA\\[[\\s\\S]*?\\]\\]>";
    private static final String DECLARATION = "<![A-Z]+\\s+[^>]*>";
    private static final String HTMLCOMMENT = "<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->";
    private static final String HTMLTAG = "(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>]|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->|[<][?].*?[?][>]|<![A-Z]+\\s+[^>]*>|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>)";
    private static final String PROCESSINGINSTRUCTION = "[<][?].*?[?][>]";
    private final InlineParserContext context;
    private final BitSet delimiterCharacters;
    private final Map<Character, DelimiterProcessor> delimiterProcessors;
    private int index;
    private String input;
    private Bracket lastBracket;
    private Delimiter lastDelimiter;
    private final BitSet specialCharacters;
    private static final Pattern PUNCTUATION = Pattern.compile("^[!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]");
    private static final Pattern HTML_TAG = Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>]|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->|[<][?].*?[?][>]|<![A-Z]+\\s+[^>]*>|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>)", 2);
    private static final Pattern ESCAPABLE = Pattern.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");
    private static final Pattern ENTITY_HERE = Pattern.compile("^&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);
    private static final Pattern TICKS = Pattern.compile("`+");
    private static final Pattern TICKS_HERE = Pattern.compile("^`+");
    private static final Pattern EMAIL_AUTOLINK = Pattern.compile("^<([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)>");
    private static final Pattern AUTOLINK = Pattern.compile("^<[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*>");
    private static final Pattern SPNL = Pattern.compile("^ *(?:\n *)?");
    private static final Pattern UNICODE_WHITESPACE_CHAR = Pattern.compile("^[\\p{Zs}\t\r\n\f]");
    private static final Pattern WHITESPACE = Pattern.compile("\\s+");
    private static final Pattern FINAL_SPACE = Pattern.compile(" *$");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class DelimiterData {
        final boolean canClose;
        final boolean canOpen;
        final int count;

        DelimiterData(int i5, boolean z5, boolean z6) {
            this.count = i5;
            this.canOpen = z5;
            this.canClose = z6;
        }
    }

    public InlineParserImpl(InlineParserContext inlineParserContext) {
        Map<Character, DelimiterProcessor> calculateDelimiterProcessors = calculateDelimiterProcessors(inlineParserContext.getCustomDelimiterProcessors());
        this.delimiterProcessors = calculateDelimiterProcessors;
        BitSet calculateDelimiterCharacters = calculateDelimiterCharacters(calculateDelimiterProcessors.keySet());
        this.delimiterCharacters = calculateDelimiterCharacters;
        this.specialCharacters = calculateSpecialCharacters(calculateDelimiterCharacters);
        this.context = inlineParserContext;
    }

    private void addBracket(Bracket bracket) {
        Bracket bracket2 = this.lastBracket;
        if (bracket2 != null) {
            bracket2.bracketAfter = true;
        }
        this.lastBracket = bracket;
    }

    private static void addDelimiterProcessorForChar(char c5, DelimiterProcessor delimiterProcessor, Map<Character, DelimiterProcessor> map) {
        if (map.put(Character.valueOf(c5), delimiterProcessor) == null) {
            return;
        }
        throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + c5 + "'");
    }

    private static void addDelimiterProcessors(Iterable<DelimiterProcessor> iterable, Map<Character, DelimiterProcessor> map) {
        StaggeredDelimiterProcessor staggeredDelimiterProcessor;
        for (DelimiterProcessor delimiterProcessor : iterable) {
            char openingCharacter = delimiterProcessor.getOpeningCharacter();
            char closingCharacter = delimiterProcessor.getClosingCharacter();
            if (openingCharacter == closingCharacter) {
                DelimiterProcessor delimiterProcessor2 = map.get(Character.valueOf(openingCharacter));
                if (delimiterProcessor2 == null || delimiterProcessor2.getOpeningCharacter() != delimiterProcessor2.getClosingCharacter()) {
                    addDelimiterProcessorForChar(openingCharacter, delimiterProcessor, map);
                } else {
                    if (delimiterProcessor2 instanceof StaggeredDelimiterProcessor) {
                        staggeredDelimiterProcessor = (StaggeredDelimiterProcessor) delimiterProcessor2;
                    } else {
                        StaggeredDelimiterProcessor staggeredDelimiterProcessor2 = new StaggeredDelimiterProcessor(openingCharacter);
                        staggeredDelimiterProcessor2.add(delimiterProcessor2);
                        staggeredDelimiterProcessor = staggeredDelimiterProcessor2;
                    }
                    staggeredDelimiterProcessor.add(delimiterProcessor);
                    map.put(Character.valueOf(openingCharacter), staggeredDelimiterProcessor);
                }
            } else {
                addDelimiterProcessorForChar(openingCharacter, delimiterProcessor, map);
                addDelimiterProcessorForChar(closingCharacter, delimiterProcessor, map);
            }
        }
    }

    public static BitSet calculateDelimiterCharacters(Set<Character> set) {
        BitSet bitSet = new BitSet();
        Iterator<Character> it = set.iterator();
        while (it.hasNext()) {
            bitSet.set(it.next().charValue());
        }
        return bitSet;
    }

    public static Map<Character, DelimiterProcessor> calculateDelimiterProcessors(List<DelimiterProcessor> list) {
        HashMap hashMap = new HashMap();
        addDelimiterProcessors(Arrays.asList(new AsteriskDelimiterProcessor(), new UnderscoreDelimiterProcessor()), hashMap);
        addDelimiterProcessors(list, hashMap);
        return hashMap;
    }

    public static BitSet calculateSpecialCharacters(BitSet bitSet) {
        BitSet bitSet2 = new BitSet();
        bitSet2.or(bitSet);
        bitSet2.set(10);
        bitSet2.set(96);
        bitSet2.set(91);
        bitSet2.set(93);
        bitSet2.set(92);
        bitSet2.set(33);
        bitSet2.set(60);
        bitSet2.set(38);
        return bitSet2;
    }

    private String match(Pattern pattern) {
        if (this.index >= this.input.length()) {
            return null;
        }
        Matcher matcher = pattern.matcher(this.input);
        matcher.region(this.index, this.input.length());
        if (!matcher.find()) {
            return null;
        }
        this.index = matcher.end();
        return matcher.group();
    }

    private void mergeChildTextNodes(Node node) {
        if (node.getFirstChild() == node.getLastChild()) {
            return;
        }
        mergeTextNodesInclusive(node.getFirstChild(), node.getLastChild());
    }

    private void mergeIfNeeded(Text text, Text text2, int i5) {
        if (text == null || text2 == null || text == text2) {
            return;
        }
        StringBuilder sb = new StringBuilder(i5);
        sb.append(text.getLiteral());
        Node next = text.getNext();
        Node next2 = text2.getNext();
        while (next != next2) {
            sb.append(((Text) next).getLiteral());
            Node next3 = next.getNext();
            next.unlink();
            next = next3;
        }
        text.setLiteral(sb.toString());
    }

    private void mergeTextNodesBetweenExclusive(Node node, Node node2) {
        if (node == node2 || node.getNext() == node2) {
            return;
        }
        mergeTextNodesInclusive(node.getNext(), node2.getPrevious());
    }

    private void mergeTextNodesInclusive(Node node, Node node2) {
        Text text = null;
        Text text2 = null;
        int i5 = 0;
        while (node != null) {
            if (node instanceof Text) {
                text2 = (Text) node;
                if (text == null) {
                    text = text2;
                }
                i5 += text2.getLiteral().length();
            } else {
                mergeIfNeeded(text, text2, i5);
                text = null;
                text2 = null;
                i5 = 0;
            }
            if (node == node2) {
                break;
            } else {
                node = node.getNext();
            }
        }
        mergeIfNeeded(text, text2, i5);
    }

    private Node parseAutolink() {
        String match = match(EMAIL_AUTOLINK);
        if (match != null) {
            String substring = match.substring(1, match.length() - 1);
            Link link = new Link("mailto:" + substring, null);
            link.appendChild(new Text(substring));
            return link;
        }
        String match2 = match(AUTOLINK);
        if (match2 == null) {
            return null;
        }
        String substring2 = match2.substring(1, match2.length() - 1);
        Link link2 = new Link(substring2, null);
        link2.appendChild(new Text(substring2));
        return link2;
    }

    private Node parseBackslash() {
        this.index++;
        if (peek() == '\n') {
            HardLineBreak hardLineBreak = new HardLineBreak();
            this.index++;
            return hardLineBreak;
        }
        if (this.index < this.input.length()) {
            Pattern pattern = ESCAPABLE;
            String str = this.input;
            int i5 = this.index;
            if (pattern.matcher(str.substring(i5, i5 + 1)).matches()) {
                String str2 = this.input;
                int i6 = this.index;
                Text text = text(str2, i6, i6 + 1);
                this.index++;
                return text;
            }
        }
        return text("\\");
    }

    private Node parseBackticks() {
        String match;
        String match2 = match(TICKS_HERE);
        if (match2 == null) {
            return null;
        }
        int i5 = this.index;
        do {
            match = match(TICKS);
            if (match == null) {
                this.index = i5;
                return text(match2);
            }
        } while (!match.equals(match2));
        Code code = new Code();
        String replace = this.input.substring(i5, this.index - match2.length()).replace('\n', ' ');
        if (replace.length() >= 3 && replace.charAt(0) == ' ' && replace.charAt(replace.length() - 1) == ' ' && Parsing.hasNonSpace(replace)) {
            replace = replace.substring(1, replace.length() - 1);
        }
        code.setLiteral(replace);
        return code;
    }

    private Node parseBang() {
        int i5 = this.index;
        this.index = i5 + 1;
        if (peek() != '[') {
            return text("!");
        }
        this.index++;
        Text text = text("![");
        addBracket(Bracket.image(text, i5 + 1, this.lastBracket, this.lastDelimiter));
        return text;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Node parseCloseBracket() {
        boolean z5;
        String str;
        String str2;
        boolean z6 = true;
        int i5 = this.index + 1;
        this.index = i5;
        Bracket bracket = this.lastBracket;
        if (bracket == null) {
            return text("]");
        }
        if (!bracket.allowed) {
            removeLastBracket();
            return text("]");
        }
        String str3 = null;
        if (peek() == '(') {
            this.index++;
            spnl();
            str = parseLinkDestination();
            if (str != null) {
                spnl();
                Pattern pattern = WHITESPACE;
                String str4 = this.input;
                int i6 = this.index;
                if (pattern.matcher(str4.substring(i6 - 1, i6)).matches()) {
                    str2 = parseLinkTitle();
                    spnl();
                } else {
                    str2 = null;
                }
                if (peek() == ')') {
                    this.index++;
                    z5 = true;
                } else {
                    this.index = i5;
                    z5 = false;
                }
            } else {
                z5 = false;
                str2 = null;
            }
        } else {
            z5 = false;
            str = null;
            str2 = null;
        }
        if (!z5) {
            int i7 = this.index;
            parseLinkLabel();
            int i8 = this.index - i7;
            if (i8 > 2) {
                str3 = this.input.substring(i7, i8 + i7);
            } else if (!bracket.bracketAfter) {
                str3 = this.input.substring(bracket.index, i5);
            }
            if (str3 != null) {
                LinkReferenceDefinition linkReferenceDefinition = this.context.getLinkReferenceDefinition(Escaping.normalizeReference(str3));
                if (linkReferenceDefinition != null) {
                    str = linkReferenceDefinition.getDestination();
                    str2 = linkReferenceDefinition.getTitle();
                    if (z6) {
                        this.index = i5;
                        removeLastBracket();
                        return text("]");
                    }
                    Node image = bracket.image ? new Image(str, str2) : new Link(str, str2);
                    Node next = bracket.node.getNext();
                    while (next != null) {
                        Node next2 = next.getNext();
                        image.appendChild(next);
                        next = next2;
                    }
                    processDelimiters(bracket.previousDelimiter);
                    mergeChildTextNodes(image);
                    bracket.node.unlink();
                    removeLastBracket();
                    if (!bracket.image) {
                        for (Bracket bracket2 = this.lastBracket; bracket2 != null; bracket2 = bracket2.previous) {
                            if (!bracket2.image) {
                                bracket2.allowed = false;
                            }
                        }
                    }
                    return image;
                }
            }
        }
        z6 = z5;
        if (z6) {
        }
    }

    private Node parseDelimiters(DelimiterProcessor delimiterProcessor, char c5) {
        DelimiterData scanDelimiters = scanDelimiters(delimiterProcessor, c5);
        if (scanDelimiters == null) {
            return null;
        }
        int i5 = scanDelimiters.count;
        int i6 = this.index;
        int i7 = i6 + i5;
        this.index = i7;
        Text text = text(this.input, i6, i7);
        Delimiter delimiter = new Delimiter(text, c5, scanDelimiters.canOpen, scanDelimiters.canClose, this.lastDelimiter);
        this.lastDelimiter = delimiter;
        delimiter.length = i5;
        delimiter.originalLength = i5;
        Delimiter delimiter2 = delimiter.previous;
        if (delimiter2 != null) {
            delimiter2.next = delimiter;
        }
        return text;
    }

    private Node parseEntity() {
        String match = match(ENTITY_HERE);
        if (match != null) {
            return text(Html5Entities.entityToString(match));
        }
        return null;
    }

    private Node parseHtmlInline() {
        String match = match(HTML_TAG);
        if (match == null) {
            return null;
        }
        HtmlInline htmlInline = new HtmlInline();
        htmlInline.setLiteral(match);
        return htmlInline;
    }

    private Node parseInline(Node node) {
        Node parseNewline;
        char peek = peek();
        if (peek == 0) {
            return null;
        }
        if (peek == '\n') {
            parseNewline = parseNewline(node);
        } else if (peek == '!') {
            parseNewline = parseBang();
        } else if (peek == '&') {
            parseNewline = parseEntity();
        } else if (peek == '<') {
            parseNewline = parseAutolink();
            if (parseNewline == null) {
                parseNewline = parseHtmlInline();
            }
        } else if (peek != '`') {
            switch (peek) {
                case '[':
                    parseNewline = parseOpenBracket();
                    break;
                case '\\':
                    parseNewline = parseBackslash();
                    break;
                case ']':
                    parseNewline = parseCloseBracket();
                    break;
                default:
                    if (!this.delimiterCharacters.get(peek)) {
                        parseNewline = parseString();
                        break;
                    } else {
                        parseNewline = parseDelimiters(this.delimiterProcessors.get(Character.valueOf(peek)), peek);
                        break;
                    }
            }
        } else {
            parseNewline = parseBackticks();
        }
        if (parseNewline != null) {
            return parseNewline;
        }
        this.index++;
        return text(String.valueOf(peek));
    }

    private String parseLinkDestination() {
        int scanLinkDestination = LinkScanner.scanLinkDestination(this.input, this.index);
        if (scanLinkDestination == -1) {
            return null;
        }
        String substring = peek() == '<' ? this.input.substring(this.index + 1, scanLinkDestination - 1) : this.input.substring(this.index, scanLinkDestination);
        this.index = scanLinkDestination;
        return Escaping.unescapeString(substring);
    }

    private String parseLinkTitle() {
        int scanLinkTitle = LinkScanner.scanLinkTitle(this.input, this.index);
        if (scanLinkTitle == -1) {
            return null;
        }
        String substring = this.input.substring(this.index + 1, scanLinkTitle - 1);
        this.index = scanLinkTitle;
        return Escaping.unescapeString(substring);
    }

    private Node parseNewline(Node node) {
        this.index++;
        if (node instanceof Text) {
            Text text = (Text) node;
            if (text.getLiteral().endsWith(" ")) {
                String literal = text.getLiteral();
                Matcher matcher = FINAL_SPACE.matcher(literal);
                int end = matcher.find() ? matcher.end() - matcher.start() : 0;
                if (end > 0) {
                    text.setLiteral(literal.substring(0, literal.length() - end));
                }
                return end >= 2 ? new HardLineBreak() : new SoftLineBreak();
            }
        }
        return new SoftLineBreak();
    }

    private Node parseOpenBracket() {
        int i5 = this.index;
        this.index = i5 + 1;
        Text text = text("[");
        addBracket(Bracket.link(text, i5, this.lastBracket, this.lastDelimiter));
        return text;
    }

    private Node parseString() {
        int i5 = this.index;
        int length = this.input.length();
        while (true) {
            int i6 = this.index;
            if (i6 == length || this.specialCharacters.get(this.input.charAt(i6))) {
                break;
            }
            this.index++;
        }
        int i7 = this.index;
        if (i5 != i7) {
            return text(this.input, i5, i7);
        }
        return null;
    }

    private char peek() {
        if (this.index < this.input.length()) {
            return this.input.charAt(this.index);
        }
        return (char) 0;
    }

    private void processDelimiters(Delimiter delimiter) {
        boolean z5;
        HashMap hashMap = new HashMap();
        Delimiter delimiter2 = this.lastDelimiter;
        while (delimiter2 != null) {
            Delimiter delimiter3 = delimiter2.previous;
            if (delimiter3 == delimiter) {
                break;
            } else {
                delimiter2 = delimiter3;
            }
        }
        while (delimiter2 != null) {
            char c5 = delimiter2.delimiterChar;
            DelimiterProcessor delimiterProcessor = this.delimiterProcessors.get(Character.valueOf(c5));
            if (!delimiter2.canClose || delimiterProcessor == null) {
                delimiter2 = delimiter2.next;
            } else {
                char openingCharacter = delimiterProcessor.getOpeningCharacter();
                Delimiter delimiter4 = delimiter2.previous;
                int i5 = 0;
                boolean z6 = false;
                while (delimiter4 != null && delimiter4 != delimiter && delimiter4 != hashMap.get(Character.valueOf(c5))) {
                    if (delimiter4.canOpen && delimiter4.delimiterChar == openingCharacter) {
                        i5 = delimiterProcessor.getDelimiterUse(delimiter4, delimiter2);
                        z6 = true;
                        if (i5 > 0) {
                            z5 = true;
                            break;
                        }
                    }
                    delimiter4 = delimiter4.previous;
                }
                z5 = z6;
                z6 = false;
                if (z6) {
                    Text text = delimiter4.node;
                    Text text2 = delimiter2.node;
                    delimiter4.length -= i5;
                    delimiter2.length -= i5;
                    text.setLiteral(text.getLiteral().substring(0, text.getLiteral().length() - i5));
                    text2.setLiteral(text2.getLiteral().substring(0, text2.getLiteral().length() - i5));
                    removeDelimitersBetween(delimiter4, delimiter2);
                    mergeTextNodesBetweenExclusive(text, text2);
                    delimiterProcessor.process(text, text2, i5);
                    if (delimiter4.length == 0) {
                        removeDelimiterAndNode(delimiter4);
                    }
                    if (delimiter2.length == 0) {
                        Delimiter delimiter5 = delimiter2.next;
                        removeDelimiterAndNode(delimiter2);
                        delimiter2 = delimiter5;
                    }
                } else {
                    if (!z5) {
                        hashMap.put(Character.valueOf(c5), delimiter2.previous);
                        if (!delimiter2.canOpen) {
                            removeDelimiterKeepNode(delimiter2);
                        }
                    }
                    delimiter2 = delimiter2.next;
                }
            }
        }
        while (true) {
            Delimiter delimiter6 = this.lastDelimiter;
            if (delimiter6 == null || delimiter6 == delimiter) {
                return;
            } else {
                removeDelimiterKeepNode(delimiter6);
            }
        }
    }

    private void removeDelimiter(Delimiter delimiter) {
        Delimiter delimiter2 = delimiter.previous;
        if (delimiter2 != null) {
            delimiter2.next = delimiter.next;
        }
        Delimiter delimiter3 = delimiter.next;
        if (delimiter3 == null) {
            this.lastDelimiter = delimiter2;
        } else {
            delimiter3.previous = delimiter2;
        }
    }

    private void removeDelimiterAndNode(Delimiter delimiter) {
        delimiter.node.unlink();
        removeDelimiter(delimiter);
    }

    private void removeDelimiterKeepNode(Delimiter delimiter) {
        removeDelimiter(delimiter);
    }

    private void removeDelimitersBetween(Delimiter delimiter, Delimiter delimiter2) {
        Delimiter delimiter3 = delimiter2.previous;
        while (delimiter3 != null && delimiter3 != delimiter) {
            Delimiter delimiter4 = delimiter3.previous;
            removeDelimiterKeepNode(delimiter3);
            delimiter3 = delimiter4;
        }
    }

    private void removeLastBracket() {
        this.lastBracket = this.lastBracket.previous;
    }

    private DelimiterData scanDelimiters(DelimiterProcessor delimiterProcessor, char c5) {
        boolean z5;
        int i5 = this.index;
        boolean z6 = false;
        int i6 = 0;
        while (peek() == c5) {
            i6++;
            this.index++;
        }
        if (i6 < delimiterProcessor.getMinLength()) {
            this.index = i5;
            return null;
        }
        String substring = i5 == 0 ? "\n" : this.input.substring(i5 - 1, i5);
        char peek = peek();
        String valueOf = peek != 0 ? String.valueOf(peek) : "\n";
        Pattern pattern = PUNCTUATION;
        boolean matches = pattern.matcher(substring).matches();
        Pattern pattern2 = UNICODE_WHITESPACE_CHAR;
        boolean matches2 = pattern2.matcher(substring).matches();
        boolean matches3 = pattern.matcher(valueOf).matches();
        boolean matches4 = pattern2.matcher(valueOf).matches();
        boolean z7 = !matches4 && (!matches3 || matches2 || matches);
        boolean z8 = !matches2 && (!matches || matches4 || matches3);
        if (c5 == '_') {
            z5 = z7 && (!z8 || matches);
            if (z8 && (!z7 || matches3)) {
                z6 = true;
            }
        } else {
            boolean z9 = z7 && c5 == delimiterProcessor.getOpeningCharacter();
            if (z8 && c5 == delimiterProcessor.getClosingCharacter()) {
                z6 = true;
            }
            z5 = z9;
        }
        this.index = i5;
        return new DelimiterData(i6, z5, z6);
    }

    private void spnl() {
        match(SPNL);
    }

    private Text text(String str, int i5, int i6) {
        return new Text(str.substring(i5, i6));
    }

    @Override // org.commonmark.parser.InlineParser
    public void parse(String str, Node node) {
        reset(str.trim());
        Node node2 = null;
        while (true) {
            node2 = parseInline(node2);
            if (node2 == null) {
                processDelimiters(null);
                mergeChildTextNodes(node);
                return;
            }
            node.appendChild(node2);
        }
    }

    int parseLinkLabel() {
        if (this.index < this.input.length() && this.input.charAt(this.index) == '[') {
            int i5 = this.index + 1;
            int scanLinkLabelContent = LinkScanner.scanLinkLabelContent(this.input, i5);
            int i6 = scanLinkLabelContent - i5;
            if (scanLinkLabelContent != -1 && i6 <= 999 && scanLinkLabelContent < this.input.length() && this.input.charAt(scanLinkLabelContent) == ']') {
                this.index = scanLinkLabelContent + 1;
                return i6 + 2;
            }
        }
        return 0;
    }

    void reset(String str) {
        this.input = str;
        this.index = 0;
        this.lastDelimiter = null;
        this.lastBracket = null;
    }

    private Text text(String str) {
        return new Text(str);
    }
}
