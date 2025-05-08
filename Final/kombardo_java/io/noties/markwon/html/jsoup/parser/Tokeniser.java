package io.noties.markwon.html.jsoup.parser;

import io.noties.markwon.html.jsoup.helper.Validate;
import io.noties.markwon.html.jsoup.nodes.CommonMarkEntities;
import io.noties.markwon.html.jsoup.parser.Token;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class Tokeniser {
    private static final char[] notCharRefCharsSorted;
    static final int[] win1252Extensions = {8364, 129, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 381, 143, 144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 157, 382, 376};
    private Token emitPending;
    private final ParseErrorList errors;
    private String lastStartTag;
    private final CharacterReader reader;
    Token.Tag tagPending;
    private TokeniserState state = TokeniserState.Data;
    private boolean isEmitPending = false;
    private String charsString = null;
    private StringBuilder charsBuilder = new StringBuilder(1024);
    StringBuilder dataBuffer = new StringBuilder(1024);
    Token.StartTag startPending = new Token.StartTag();
    Token.EndTag endPending = new Token.EndTag();
    Token.Character charPending = new Token.Character();
    Token.Doctype doctypePending = new Token.Doctype();
    Token.Comment commentPending = new Token.Comment();
    private final int[] codepointHolder = new int[1];
    private final int[] multipointHolder = new int[2];

    static {
        char[] cArr = {'\t', '\n', '\r', '\f', ' ', '<', '&'};
        notCharRefCharsSorted = cArr;
        Arrays.sort(cArr);
    }

    public Tokeniser(CharacterReader characterReader, ParseErrorList parseErrorList) {
        this.reader = characterReader;
        this.errors = parseErrorList;
    }

    private void characterReferenceError(String str) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Invalid character reference: %s", str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void advanceTransition(TokeniserState tokeniserState) {
        this.reader.advance();
        this.state = tokeniserState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String appropriateEndTagName() {
        return this.lastStartTag;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] consumeCharacterReference(Character ch, boolean z5) {
        int i5;
        if (this.reader.isEmpty()) {
            return null;
        }
        if ((ch != null && ch.charValue() == this.reader.current()) || this.reader.matchesAnySorted(notCharRefCharsSorted)) {
            return null;
        }
        int[] iArr = this.codepointHolder;
        this.reader.mark();
        if (this.reader.matchConsume("#")) {
            boolean matchConsumeIgnoreCase = this.reader.matchConsumeIgnoreCase("X");
            CharacterReader characterReader = this.reader;
            String consumeHexSequence = matchConsumeIgnoreCase ? characterReader.consumeHexSequence() : characterReader.consumeDigitSequence();
            if (consumeHexSequence.length() == 0) {
                characterReferenceError("numeric reference with no numerals");
                this.reader.rewindToMark();
                return null;
            }
            if (!this.reader.matchConsume(";")) {
                characterReferenceError("missing semicolon");
            }
            try {
                i5 = Integer.valueOf(consumeHexSequence, matchConsumeIgnoreCase ? 16 : 10).intValue();
            } catch (NumberFormatException unused) {
                i5 = -1;
            }
            if (i5 == -1 || ((i5 >= 55296 && i5 <= 57343) || i5 > 1114111)) {
                characterReferenceError("character outside of valid range");
                iArr[0] = 65533;
                return iArr;
            }
            if (i5 >= 128) {
                int[] iArr2 = win1252Extensions;
                if (i5 < iArr2.length + 128) {
                    characterReferenceError("character is not a valid unicode code point");
                    i5 = iArr2[i5 - 128];
                }
            }
            iArr[0] = i5;
            return iArr;
        }
        String consumeLetterThenDigitSequence = this.reader.consumeLetterThenDigitSequence();
        boolean matches = this.reader.matches(';');
        if (!CommonMarkEntities.isNamedEntity(consumeLetterThenDigitSequence) || !matches) {
            this.reader.rewindToMark();
            if (matches) {
                characterReferenceError(String.format("invalid named referenece '%s'", consumeLetterThenDigitSequence));
            }
            return null;
        }
        if (z5 && (this.reader.matchesLetter() || this.reader.matchesDigit() || this.reader.matchesAny('=', '-', '_'))) {
            this.reader.rewindToMark();
            return null;
        }
        if (!this.reader.matchConsume(";")) {
            characterReferenceError("missing semicolon");
        }
        int codepointsForName = CommonMarkEntities.codepointsForName(consumeLetterThenDigitSequence, this.multipointHolder);
        if (codepointsForName == 1) {
            iArr[0] = this.multipointHolder[0];
            return iArr;
        }
        if (codepointsForName == 2) {
            return this.multipointHolder;
        }
        Validate.fail("Unexpected characters returned for " + consumeLetterThenDigitSequence);
        return this.multipointHolder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void createCommentPending() {
        this.commentPending.reset();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void createDoctypePending() {
        this.doctypePending.reset();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Token.Tag createTagPending(boolean z5) {
        Token.Tag reset = z5 ? this.startPending.reset() : this.endPending.reset();
        this.tagPending = reset;
        return reset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void createTempBuffer() {
        Token.reset(this.dataBuffer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emit(Token token) {
        Validate.isFalse(this.isEmitPending, "There is an unread token pending!");
        this.emitPending = token;
        this.isEmitPending = true;
        Token.TokenType tokenType = token.type;
        if (tokenType == Token.TokenType.StartTag) {
            this.lastStartTag = ((Token.StartTag) token).tagName;
        } else {
            if (tokenType != Token.TokenType.EndTag || ((Token.EndTag) token).attributes == null) {
                return;
            }
            error("Attributes incorrectly present on end tag");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emitCommentPending() {
        emit(this.commentPending);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emitDoctypePending() {
        emit(this.doctypePending);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emitTagPending() {
        this.tagPending.finaliseTag();
        emit(this.tagPending);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eofError(TokeniserState tokeniserState) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Unexpectedly reached end of file (EOF) in input state [%s]", tokeniserState));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void error(TokeniserState tokeniserState) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), "Unexpected character '%s' in input state [%s]", Character.valueOf(this.reader.current()), tokeniserState));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAppropriateEndTagToken() {
        return this.lastStartTag != null && this.tagPending.name().equalsIgnoreCase(this.lastStartTag);
    }

    public Token read() {
        while (!this.isEmitPending) {
            this.state.read(this, this.reader);
        }
        if (this.charsBuilder.length() > 0) {
            String sb = this.charsBuilder.toString();
            StringBuilder sb2 = this.charsBuilder;
            sb2.delete(0, sb2.length());
            this.charsString = null;
            return this.charPending.data(sb);
        }
        String str = this.charsString;
        if (str == null) {
            this.isEmitPending = false;
            return this.emitPending;
        }
        Token.Character data = this.charPending.data(str);
        this.charsString = null;
        return data;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void transition(TokeniserState tokeniserState) {
        this.state = tokeniserState;
    }

    void error(String str) {
        if (this.errors.canAddError()) {
            this.errors.add(new ParseError(this.reader.pos(), str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emit(String str) {
        if (this.charsString == null) {
            this.charsString = str;
            return;
        }
        if (this.charsBuilder.length() == 0) {
            this.charsBuilder.append(this.charsString);
        }
        this.charsBuilder.append(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emit(int[] iArr) {
        emit(new String(iArr, 0, iArr.length));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void emit(char c5) {
        emit(String.valueOf(c5));
    }
}
