package io.noties.markwon.html.jsoup.parser;

import io.noties.markwon.html.jsoup.helper.Normalizer;
import io.noties.markwon.html.jsoup.helper.Validate;
import io.noties.markwon.html.jsoup.nodes.Attributes;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public abstract class Token {
    public final TokenType type;

    /* loaded from: classes2.dex */
    public static final class CData extends Character {
        /* JADX INFO: Access modifiers changed from: package-private */
        public CData(String str) {
            data(str);
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token.Character
        public String toString() {
            return "<![CDATA[" + getData() + "]]>";
        }
    }

    /* loaded from: classes2.dex */
    public static class Character extends Token {
        private String data;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Character() {
            super(TokenType.Character);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Character data(String str) {
            this.data = str;
            return this;
        }

        public String getData() {
            return this.data;
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token
        public Token reset() {
            this.data = null;
            return this;
        }

        public String toString() {
            return getData();
        }
    }

    /* loaded from: classes2.dex */
    public static final class Comment extends Token {
        boolean bogus;
        final StringBuilder data;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Comment() {
            super(TokenType.Comment);
            this.data = new StringBuilder();
            this.bogus = false;
        }

        String getData() {
            return this.data.toString();
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token
        public Token reset() {
            Token.reset(this.data);
            this.bogus = false;
            return this;
        }

        public String toString() {
            return "<!--" + getData() + "-->";
        }
    }

    /* loaded from: classes2.dex */
    public static final class Doctype extends Token {
        boolean forceQuirks;
        final StringBuilder name;
        String pubSysKey;
        final StringBuilder publicIdentifier;
        final StringBuilder systemIdentifier;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Doctype() {
            super(TokenType.Doctype);
            this.name = new StringBuilder();
            this.pubSysKey = null;
            this.publicIdentifier = new StringBuilder();
            this.systemIdentifier = new StringBuilder();
            this.forceQuirks = false;
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token
        public Token reset() {
            Token.reset(this.name);
            this.pubSysKey = null;
            Token.reset(this.publicIdentifier);
            Token.reset(this.systemIdentifier);
            this.forceQuirks = false;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class EOF extends Token {
        /* JADX INFO: Access modifiers changed from: package-private */
        public EOF() {
            super(TokenType.EOF);
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token
        public Token reset() {
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class EndTag extends Tag {
        /* JADX INFO: Access modifiers changed from: package-private */
        public EndTag() {
            super(TokenType.EndTag);
        }

        public String toString() {
            return "</" + name() + ">";
        }
    }

    /* loaded from: classes2.dex */
    public static final class StartTag extends Tag {
        public StartTag() {
            super(TokenType.StartTag);
            this.attributes = new Attributes();
        }

        public String toString() {
            Attributes attributes = this.attributes;
            if (attributes == null || attributes.size() <= 0) {
                return "<" + name() + ">";
            }
            return "<" + name() + " " + this.attributes.toString() + ">";
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token.Tag, io.noties.markwon.html.jsoup.parser.Token
        public Tag reset() {
            super.reset();
            this.attributes = new Attributes();
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Tag extends Token {
        public Attributes attributes;
        private boolean hasEmptyAttributeValue;
        private boolean hasPendingAttributeValue;
        public String normalName;
        private String pendingAttributeName;
        private StringBuilder pendingAttributeValue;
        private String pendingAttributeValueS;
        public boolean selfClosing;
        public String tagName;

        protected Tag(TokenType tokenType) {
            super(tokenType);
            this.pendingAttributeValue = new StringBuilder();
            this.hasEmptyAttributeValue = false;
            this.hasPendingAttributeValue = false;
            this.selfClosing = false;
        }

        private void ensureAttributeValue() {
            this.hasPendingAttributeValue = true;
            String str = this.pendingAttributeValueS;
            if (str != null) {
                this.pendingAttributeValue.append(str);
                this.pendingAttributeValueS = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendAttributeName(String str) {
            String str2 = this.pendingAttributeName;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.pendingAttributeName = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendAttributeValue(String str) {
            ensureAttributeValue();
            if (this.pendingAttributeValue.length() == 0) {
                this.pendingAttributeValueS = str;
            } else {
                this.pendingAttributeValue.append(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendTagName(String str) {
            String str2 = this.tagName;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.tagName = str;
            this.normalName = Normalizer.lowerCase(str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void finaliseTag() {
            if (this.pendingAttributeName != null) {
                newAttribute();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final String name() {
            String str = this.tagName;
            Validate.isFalse(str == null || str.length() == 0);
            return this.tagName;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void newAttribute() {
            if (this.attributes == null) {
                this.attributes = new Attributes();
            }
            String str = this.pendingAttributeName;
            if (str != null) {
                String trim = str.trim();
                this.pendingAttributeName = trim;
                if (trim.length() > 0) {
                    this.attributes.put(this.pendingAttributeName, this.hasPendingAttributeValue ? this.pendingAttributeValue.length() > 0 ? this.pendingAttributeValue.toString() : this.pendingAttributeValueS : this.hasEmptyAttributeValue ? BuildConfig.FLAVOR : null);
                }
            }
            this.pendingAttributeName = null;
            this.hasEmptyAttributeValue = false;
            this.hasPendingAttributeValue = false;
            Token.reset(this.pendingAttributeValue);
            this.pendingAttributeValueS = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void setEmptyAttributeValue() {
            this.hasEmptyAttributeValue = true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendAttributeName(char c5) {
            appendAttributeName(String.valueOf(c5));
        }

        @Override // io.noties.markwon.html.jsoup.parser.Token
        public Tag reset() {
            this.tagName = null;
            this.normalName = null;
            this.pendingAttributeName = null;
            Token.reset(this.pendingAttributeValue);
            this.pendingAttributeValueS = null;
            this.hasEmptyAttributeValue = false;
            this.hasPendingAttributeValue = false;
            this.selfClosing = false;
            this.attributes = null;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendTagName(char c5) {
            appendTagName(String.valueOf(c5));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final Tag name(String str) {
            this.tagName = str;
            this.normalName = Normalizer.lowerCase(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendAttributeValue(char c5) {
            ensureAttributeValue();
            this.pendingAttributeValue.append(c5);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void appendAttributeValue(int[] iArr) {
            ensureAttributeValue();
            for (int i5 : iArr) {
                this.pendingAttributeValue.appendCodePoint(i5);
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum TokenType {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    protected Token(TokenType tokenType) {
        this.type = tokenType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void reset(StringBuilder sb) {
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    public abstract Token reset();
}
