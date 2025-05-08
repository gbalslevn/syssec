package io.noties.markwon.html;

import com.adjust.sdk.Constants;
import io.noties.markwon.html.HtmlTag;
import io.noties.markwon.html.HtmlTagImpl;
import io.noties.markwon.html.MarkwonHtmlParser;
import io.noties.markwon.html.jsoup.nodes.Attribute;
import io.noties.markwon.html.jsoup.nodes.Attributes;
import io.noties.markwon.html.jsoup.parser.CharacterReader;
import io.noties.markwon.html.jsoup.parser.ParseErrorList;
import io.noties.markwon.html.jsoup.parser.Token;
import io.noties.markwon.html.jsoup.parser.Tokeniser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class MarkwonHtmlParserImpl extends MarkwonHtmlParser {
    private final HtmlEmptyTagReplacement emptyTagReplacement;
    private boolean isInsidePreTag;
    private boolean previousIsBlock;
    private final TrimmingAppender trimmingAppender;
    static final Set<String> INLINE_TAGS = Collections.unmodifiableSet(new HashSet(Arrays.asList("a", "abbr", "acronym", "b", "bdo", "big", "br", "button", "cite", "code", "dfn", "em", "i", "img", "input", "kbd", "label", "map", "object", "q", "samp", "script", "select", Constants.SMALL, "span", "strong", "sub", "sup", "textarea", "time", "tt", "var")));
    private static final Set<String> VOID_TAGS = Collections.unmodifiableSet(new HashSet(Arrays.asList("area", "base", "br", "col", "embed", "hr", "img", "input", "keygen", "link", "meta", "param", "source", "track", "wbr")));
    private static final String TAG_LIST_ITEM = "li";
    private static final String TAG_PARAGRAPH = "p";
    private static final Set<String> BLOCK_TAGS = Collections.unmodifiableSet(new HashSet(Arrays.asList("address", "article", "aside", "blockquote", "canvas", "dd", "div", "dl", "dt", "fieldset", "figcaption", "figure", "footer", "form", "h1", "h2", "h3", "h4", "h5", "h6", "header", "hgroup", "hr", TAG_LIST_ITEM, "main", "nav", "noscript", "ol", "output", TAG_PARAGRAPH, "pre", "section", "table", "tfoot", "ul", "video")));
    private final List<HtmlTagImpl.InlineImpl> inlineTags = new ArrayList(0);
    private HtmlTagImpl.BlockImpl currentBlock = HtmlTagImpl.BlockImpl.root();

    /* renamed from: io.noties.markwon.html.MarkwonHtmlParserImpl$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$noties$markwon$html$jsoup$parser$Token$TokenType;

        static {
            int[] iArr = new int[Token.TokenType.values().length];
            $SwitchMap$io$noties$markwon$html$jsoup$parser$Token$TokenType = iArr;
            try {
                iArr[Token.TokenType.StartTag.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$noties$markwon$html$jsoup$parser$Token$TokenType[Token.TokenType.EndTag.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$noties$markwon$html$jsoup$parser$Token$TokenType[Token.TokenType.Character.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    MarkwonHtmlParserImpl(HtmlEmptyTagReplacement htmlEmptyTagReplacement, TrimmingAppender trimmingAppender) {
        this.emptyTagReplacement = htmlEmptyTagReplacement;
        this.trimmingAppender = trimmingAppender;
    }

    public static MarkwonHtmlParserImpl create(HtmlEmptyTagReplacement htmlEmptyTagReplacement) {
        return new MarkwonHtmlParserImpl(htmlEmptyTagReplacement, TrimmingAppender.create());
    }

    protected static <T extends Appendable & CharSequence> void ensureNewLine(T t5) {
        T t6 = t5;
        int length = t6.length();
        if (length <= 0 || '\n' == t6.charAt(length - 1)) {
            return;
        }
        AppendableUtils.appendQuietly((Appendable) t5, '\n');
    }

    protected static Map<String, String> extractAttributes(Token.StartTag startTag) {
        Attributes attributes = startTag.attributes;
        int size = attributes.size();
        if (size <= 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(size);
        Iterator<Attribute> it = attributes.iterator();
        while (it.hasNext()) {
            Attribute next = it.next();
            hashMap.put(next.getKey().toLowerCase(Locale.US), next.getValue());
        }
        return Collections.unmodifiableMap(hashMap);
    }

    protected static boolean isBlockTag(String str) {
        return BLOCK_TAGS.contains(str);
    }

    protected static <T extends Appendable & CharSequence> boolean isEmpty(T t5, HtmlTagImpl htmlTagImpl) {
        return htmlTagImpl.start == t5.length();
    }

    protected static boolean isInlineTag(String str) {
        return INLINE_TAGS.contains(str);
    }

    protected static boolean isVoidTag(String str) {
        return VOID_TAGS.contains(str);
    }

    protected void appendBlockChild(HtmlTagImpl.BlockImpl blockImpl, HtmlTagImpl.BlockImpl blockImpl2) {
        List list = blockImpl.children;
        if (list == null) {
            list = new ArrayList(2);
            blockImpl.children = list;
        }
        list.add(blockImpl2);
    }

    protected <T extends Appendable & CharSequence> void appendEmptyTagReplacement(T t5, HtmlTagImpl htmlTagImpl) {
        String replace = this.emptyTagReplacement.replace(htmlTagImpl);
        if (replace != null) {
            AppendableUtils.appendQuietly(t5, replace);
        }
    }

    protected <T extends Appendable & CharSequence> void ensureNewLineIfPreviousWasBlock(T t5) {
        if (this.previousIsBlock) {
            ensureNewLine(t5);
            this.previousIsBlock = false;
        }
    }

    protected HtmlTagImpl.BlockImpl findOpenBlockTag(String str) {
        HtmlTagImpl.BlockImpl blockImpl = this.currentBlock;
        while (blockImpl != null && !str.equals(blockImpl.name) && !blockImpl.isClosed()) {
            blockImpl = blockImpl.parent;
        }
        return blockImpl;
    }

    protected HtmlTagImpl.InlineImpl findOpenInlineTag(String str) {
        int size = this.inlineTags.size();
        while (true) {
            size--;
            if (size <= -1) {
                return null;
            }
            HtmlTagImpl.InlineImpl inlineImpl = this.inlineTags.get(size);
            if (str.equals(inlineImpl.name) && inlineImpl.end < 0) {
                return inlineImpl;
            }
        }
    }

    @Override // io.noties.markwon.html.MarkwonHtmlParser
    public void flushBlockTags(int i5, MarkwonHtmlParser.FlushAction<HtmlTag.Block> flushAction) {
        HtmlTagImpl.BlockImpl blockImpl = this.currentBlock;
        while (true) {
            HtmlTagImpl.BlockImpl blockImpl2 = blockImpl.parent;
            if (blockImpl2 == null) {
                break;
            } else {
                blockImpl = blockImpl2;
            }
        }
        if (i5 > -1) {
            blockImpl.closeAt(i5);
        }
        List<HtmlTag.Block> children = blockImpl.children();
        if (children.size() > 0) {
            flushAction.apply(children);
        } else {
            flushAction.apply(Collections.emptyList());
        }
        this.currentBlock = HtmlTagImpl.BlockImpl.root();
    }

    @Override // io.noties.markwon.html.MarkwonHtmlParser
    public void flushInlineTags(int i5, MarkwonHtmlParser.FlushAction<HtmlTag.Inline> flushAction) {
        if (this.inlineTags.size() <= 0) {
            flushAction.apply(Collections.emptyList());
            return;
        }
        if (i5 > -1) {
            Iterator<HtmlTagImpl.InlineImpl> it = this.inlineTags.iterator();
            while (it.hasNext()) {
                it.next().closeAt(i5);
            }
        }
        flushAction.apply(Collections.unmodifiableList(this.inlineTags));
        this.inlineTags.clear();
    }

    protected <T extends Appendable & CharSequence> void processBlockTagEnd(T t5, Token.EndTag endTag) {
        String str = endTag.normalName;
        HtmlTagImpl.BlockImpl findOpenBlockTag = findOpenBlockTag(str);
        if (findOpenBlockTag != null) {
            if ("pre".equals(str)) {
                this.isInsidePreTag = false;
            }
            if (isEmpty(t5, findOpenBlockTag)) {
                appendEmptyTagReplacement(t5, findOpenBlockTag);
            }
            findOpenBlockTag.closeAt(t5.length());
            if (!findOpenBlockTag.isEmpty()) {
                this.previousIsBlock = isBlockTag(findOpenBlockTag.name);
            }
            if (TAG_PARAGRAPH.equals(str)) {
                AppendableUtils.appendQuietly((Appendable) t5, '\n');
            }
            this.currentBlock = findOpenBlockTag.parent;
        }
    }

    protected <T extends Appendable & CharSequence> void processBlockTagStart(T t5, Token.StartTag startTag) {
        String str = startTag.normalName;
        if (TAG_PARAGRAPH.equals(this.currentBlock.name)) {
            this.currentBlock.closeAt(t5.length());
            AppendableUtils.appendQuietly((Appendable) t5, '\n');
            this.currentBlock = this.currentBlock.parent;
        } else if (TAG_LIST_ITEM.equals(str) && TAG_LIST_ITEM.equals(this.currentBlock.name)) {
            this.currentBlock.closeAt(t5.length());
            this.currentBlock = this.currentBlock.parent;
        }
        if (isBlockTag(str)) {
            this.isInsidePreTag = "pre".equals(str);
            ensureNewLine(t5);
        } else {
            ensureNewLineIfPreviousWasBlock(t5);
        }
        T t6 = t5;
        HtmlTagImpl.BlockImpl create = HtmlTagImpl.BlockImpl.create(str, t6.length(), extractAttributes(startTag), this.currentBlock);
        boolean z5 = isVoidTag(str) || startTag.selfClosing;
        if (z5) {
            String replace = this.emptyTagReplacement.replace(create);
            if (replace != null && replace.length() > 0) {
                AppendableUtils.appendQuietly(t5, replace);
            }
            create.closeAt(t6.length());
        }
        appendBlockChild(create.parent, create);
        if (z5) {
            return;
        }
        this.currentBlock = create;
    }

    protected <T extends Appendable & CharSequence> void processCharacter(T t5, Token.Character character) {
        if (this.isInsidePreTag) {
            AppendableUtils.appendQuietly(t5, character.getData());
        } else {
            ensureNewLineIfPreviousWasBlock(t5);
            this.trimmingAppender.append(t5, character.getData());
        }
    }

    @Override // io.noties.markwon.html.MarkwonHtmlParser
    public <T extends Appendable & CharSequence> void processFragment(T t5, String str) {
        Tokeniser tokeniser = new Tokeniser(new CharacterReader(str), ParseErrorList.noTracking());
        while (true) {
            Token read = tokeniser.read();
            Token.TokenType tokenType = read.type;
            if (Token.TokenType.EOF == tokenType) {
                return;
            }
            int i5 = AnonymousClass1.$SwitchMap$io$noties$markwon$html$jsoup$parser$Token$TokenType[tokenType.ordinal()];
            if (i5 == 1) {
                Token.StartTag startTag = (Token.StartTag) read;
                if (isInlineTag(startTag.normalName)) {
                    processInlineTagStart(t5, startTag);
                } else {
                    processBlockTagStart(t5, startTag);
                }
            } else if (i5 == 2) {
                Token.EndTag endTag = (Token.EndTag) read;
                if (isInlineTag(endTag.normalName)) {
                    processInlineTagEnd(t5, endTag);
                } else {
                    processBlockTagEnd(t5, endTag);
                }
            } else if (i5 == 3) {
                processCharacter(t5, (Token.Character) read);
            }
            read.reset();
        }
    }

    protected <T extends Appendable & CharSequence> void processInlineTagEnd(T t5, Token.EndTag endTag) {
        HtmlTagImpl.InlineImpl findOpenInlineTag = findOpenInlineTag(endTag.normalName);
        if (findOpenInlineTag != null) {
            if (isEmpty(t5, findOpenInlineTag)) {
                appendEmptyTagReplacement(t5, findOpenInlineTag);
            }
            findOpenInlineTag.closeAt(t5.length());
        }
    }

    protected <T extends Appendable & CharSequence> void processInlineTagStart(T t5, Token.StartTag startTag) {
        String str = startTag.normalName;
        T t6 = t5;
        HtmlTagImpl.InlineImpl inlineImpl = new HtmlTagImpl.InlineImpl(str, t6.length(), extractAttributes(startTag));
        ensureNewLineIfPreviousWasBlock(t5);
        if (isVoidTag(str) || startTag.selfClosing) {
            String replace = this.emptyTagReplacement.replace(inlineImpl);
            if (replace != null && replace.length() > 0) {
                AppendableUtils.appendQuietly(t5, replace);
            }
            inlineImpl.closeAt(t6.length());
        }
        this.inlineTags.add(inlineImpl);
    }

    @Override // io.noties.markwon.html.MarkwonHtmlParser
    public void reset() {
        this.inlineTags.clear();
        this.currentBlock = HtmlTagImpl.BlockImpl.root();
    }
}
