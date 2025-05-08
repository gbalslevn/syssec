package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\n\n\u0002\u0010\u0001\n\u0002\b%\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010\u0003J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004H&¢\u0006\u0004\b$\u0010\u0014J\u000f\u0010%\u001a\u00020\u000fH&¢\u0006\u0004\b%\u0010\u0011J\u000f\u0010&\u001a\u00020\u000fH&¢\u0006\u0004\b&\u0010\u0011J\u000f\u0010(\u001a\u00020'H&¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020*H\u0004¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\u001f¢\u0006\u0004\b.\u0010\u0003J\u0015\u0010(\u001a\u00020'2\u0006\u0010/\u001a\u00020'¢\u0006\u0004\b(\u00100J\u0017\u0010(\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020*H\u0016¢\u0006\u0004\b(\u00101J\u0017\u00102\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020*H\u0004¢\u0006\u0004\b2\u00101J!\u00108\u001a\u0002052\u0006\u00103\u001a\u00020'2\b\b\u0002\u00104\u001a\u00020\u000fH\u0000¢\u0006\u0004\b6\u00107J\r\u00109\u001a\u00020'¢\u0006\u0004\b9\u0010)J\u0017\u0010;\u001a\u00020\u000f2\b\b\u0002\u0010:\u001a\u00020\u000f¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0004H\u0016¢\u0006\u0004\b=\u0010>J!\u0010A\u001a\u0004\u0018\u00010\n2\u0006\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u00020\u000fH&¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u0004\u0018\u00010\n2\u0006\u0010@\u001a\u00020\u000f¢\u0006\u0004\bC\u0010DJ\r\u0010E\u001a\u00020\u001f¢\u0006\u0004\bE\u0010\u0003J\u001f\u0010G\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0004H\u0016¢\u0006\u0004\bG\u0010\fJ\u000f\u0010H\u001a\u00020\nH&¢\u0006\u0004\bH\u0010\u000eJ\r\u0010I\u001a\u00020\n¢\u0006\u0004\bI\u0010\u000eJ'\u0010I\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0005¢\u0006\u0004\bI\u0010JJ\r\u0010K\u001a\u00020\n¢\u0006\u0004\bK\u0010\u000eJ\r\u0010L\u001a\u00020\n¢\u0006\u0004\bL\u0010\u000eJ\u001f\u0010O\u001a\u00020\u001f2\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u0004H\u0014¢\u0006\u0004\bO\u0010PJ\u0015\u0010R\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020\u000f¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020\nH\u0016¢\u0006\u0004\bT\u0010\u000eJ\u0015\u0010V\u001a\u00020\u001f2\u0006\u0010U\u001a\u00020\n¢\u0006\u0004\bV\u0010WJ)\u00108\u001a\u0002052\u0006\u0010X\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010Y\u001a\u00020\n¢\u0006\u0004\b8\u0010ZJ\r\u0010\\\u001a\u00020[¢\u0006\u0004\b\\\u0010]J\r\u0010^\u001a\u00020\u000f¢\u0006\u0004\b^\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00048\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\t\u0010_R\u0014\u0010a\u001a\u00020`8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010c\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR&\u0010g\u001a\u00060ej\u0002`f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u0014\u0010\u0016\u001a\u00020\u00158$X¤\u0004¢\u0006\u0006\u001a\u0004\bm\u0010n¨\u0006o"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonLexer;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "lastPosition", "current", "appendEscape", "(II)I", "currentPosition", BuildConfig.FLAVOR, "decodedString", "(II)Ljava/lang/String;", "takePeeked", "()Ljava/lang/String;", BuildConfig.FLAVOR, "wasUnquotedString", "()Z", "startPosition", "appendEsc", "(I)I", BuildConfig.FLAVOR, "source", "startPos", "appendHex", "(Ljava/lang/CharSequence;I)I", "fromHexChar", "start", "consumeBoolean", "(I)Z", "literalSuffix", BuildConfig.FLAVOR, "consumeBooleanLiteral", "(Ljava/lang/String;I)V", "ensureHaveChars", "position", "prefetchOrEof", "tryConsumeComma", "canConsumeValue", BuildConfig.FLAVOR, "consumeNextToken", "()B", BuildConfig.FLAVOR, "c", "isValidValueStart", "(C)Z", "expectEof", "expected", "(B)B", "(C)V", "unexpectedToken", "expectedToken", "wasConsumed", BuildConfig.FLAVOR, "fail$kotlinx_serialization_json", "(BZ)Ljava/lang/Void;", "fail", "peekNextToken", "doConsume", "tryConsumeNull", "(Z)Z", "skipWhitespaces", "()I", "keyToMatch", "isLenient", "peekLeadingMatchingValue", "(Ljava/lang/String;Z)Ljava/lang/String;", "peekString", "(Z)Ljava/lang/String;", "discardPeeked", "endPos", "substring", "consumeKeyString", "consumeString", "(Ljava/lang/CharSequence;II)Ljava/lang/String;", "consumeStringLenientNotNull", "consumeStringLenient", "fromIndex", "toIndex", "appendRange", "(II)V", "allowLenientStrings", "skipElement", "(Z)V", "toString", "key", "failOnUnknownKey", "(Ljava/lang/String;)V", "message", "hint", "(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/Void;", BuildConfig.FLAVOR, "consumeNumericLiteral", "()J", "consumeBooleanLenient", "I", "Lkotlinx/serialization/json/internal/JsonPath;", "path", "Lkotlinx/serialization/json/internal/JsonPath;", "peekedString", "Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "escapedString", "Ljava/lang/StringBuilder;", "getEscapedString", "()Ljava/lang/StringBuilder;", "setEscapedString", "(Ljava/lang/StringBuilder;)V", "getSource", "()Ljava/lang/CharSequence;", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* renamed from: kotlinx.serialization.json.internal.AbstractJsonLexer, reason: from toString */
/* loaded from: classes3.dex */
public abstract class JsonReader {
    public int currentPosition;
    private String peekedString;
    public final JsonPath path = new JsonPath();
    private StringBuilder escapedString = new StringBuilder();

    private final int appendEsc(int startPosition) {
        int prefetchOrEof = prefetchOrEof(startPosition);
        if (prefetchOrEof == -1) {
            fail$default(this, "Expected escape sequence to continue, got EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i5 = prefetchOrEof + 1;
        char charAt = getSource().charAt(prefetchOrEof);
        if (charAt == 'u') {
            return appendHex(getSource(), i5);
        }
        char escapeToChar = AbstractJsonLexerKt.escapeToChar(charAt);
        if (escapeToChar != 0) {
            this.escapedString.append(escapeToChar);
            return i5;
        }
        fail$default(this, "Invalid escaped char '" + charAt + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final int appendEscape(int lastPosition, int current) {
        appendRange(lastPosition, current);
        return appendEsc(current + 1);
    }

    private final int appendHex(CharSequence source, int startPos) {
        int i5 = startPos + 4;
        if (i5 < source.length()) {
            this.escapedString.append((char) ((fromHexChar(source, startPos) << 12) + (fromHexChar(source, startPos + 1) << 8) + (fromHexChar(source, startPos + 2) << 4) + fromHexChar(source, startPos + 3)));
            return i5;
        }
        this.currentPosition = startPos;
        ensureHaveChars();
        if (this.currentPosition + 4 < source.length()) {
            return appendHex(source, this.currentPosition);
        }
        fail$default(this, "Unexpected EOF during unicode escape", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final boolean consumeBoolean(int start) {
        int prefetchOrEof = prefetchOrEof(start);
        if (prefetchOrEof >= getSource().length() || prefetchOrEof == -1) {
            fail$default(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i5 = prefetchOrEof + 1;
        int charAt = getSource().charAt(prefetchOrEof) | ' ';
        if (charAt == 102) {
            consumeBooleanLiteral("alse", i5);
            return false;
        }
        if (charAt == 116) {
            consumeBooleanLiteral("rue", i5);
            return true;
        }
        fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final void consumeBooleanLiteral(String literalSuffix, int current) {
        if (getSource().length() - current < literalSuffix.length()) {
            fail$default(this, "Unexpected end of boolean literal", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int length = literalSuffix.length();
        for (int i5 = 0; i5 < length; i5++) {
            if (literalSuffix.charAt(i5) != (getSource().charAt(current + i5) | ' ')) {
                fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
        }
        this.currentPosition = current + literalSuffix.length();
    }

    private static final double consumeNumericLiteral$calculateExponent(long j5, boolean z5) {
        if (!z5) {
            return Math.pow(10.0d, -j5);
        }
        if (z5) {
            return Math.pow(10.0d, j5);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String decodedString(int lastPosition, int currentPosition) {
        appendRange(lastPosition, currentPosition);
        String sb = this.escapedString.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        this.escapedString.setLength(0);
        return sb;
    }

    public static /* synthetic */ Void fail$default(JsonReader jsonReader, String str, int i5, String str2, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i6 & 2) != 0) {
            i5 = jsonReader.currentPosition;
        }
        if ((i6 & 4) != 0) {
            str2 = BuildConfig.FLAVOR;
        }
        return jsonReader.fail(str, i5, str2);
    }

    public static /* synthetic */ Void fail$kotlinx_serialization_json$default(JsonReader jsonReader, byte b5, boolean z5, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i5 & 2) != 0) {
            z5 = true;
        }
        return jsonReader.fail$kotlinx_serialization_json(b5, z5);
    }

    private final int fromHexChar(CharSequence source, int currentPosition) {
        char charAt = source.charAt(currentPosition);
        if ('0' <= charAt && charAt < ':') {
            return charAt - '0';
        }
        if ('a' <= charAt && charAt < 'g') {
            return charAt - 'W';
        }
        if ('A' <= charAt && charAt < 'G') {
            return charAt - '7';
        }
        fail$default(this, "Invalid toHexChar char '" + charAt + "' in unicode escape", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final String takePeeked() {
        String str = this.peekedString;
        Intrinsics.checkNotNull(str);
        this.peekedString = null;
        return str;
    }

    public static /* synthetic */ boolean tryConsumeNull$default(JsonReader jsonReader, boolean z5, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryConsumeNull");
        }
        if ((i5 & 1) != 0) {
            z5 = true;
        }
        return jsonReader.tryConsumeNull(z5);
    }

    private final boolean wasUnquotedString() {
        return getSource().charAt(this.currentPosition - 1) != '\"';
    }

    protected void appendRange(int fromIndex, int toIndex) {
        this.escapedString.append(getSource(), fromIndex, toIndex);
    }

    public abstract boolean canConsumeValue();

    public final boolean consumeBooleanLenient() {
        boolean z5;
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces == getSource().length()) {
            fail$default(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (getSource().charAt(skipWhitespaces) == '\"') {
            skipWhitespaces++;
            z5 = true;
        } else {
            z5 = false;
        }
        boolean consumeBoolean = consumeBoolean(skipWhitespaces);
        if (z5) {
            if (this.currentPosition == getSource().length()) {
                fail$default(this, "EOF", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            if (getSource().charAt(this.currentPosition) != '\"') {
                fail$default(this, "Expected closing quotation mark", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            this.currentPosition++;
        }
        return consumeBoolean;
    }

    public abstract String consumeKeyString();

    public abstract byte consumeNextToken();

    public final byte consumeNextToken(byte expected) {
        byte consumeNextToken = consumeNextToken();
        if (consumeNextToken == expected) {
            return consumeNextToken;
        }
        fail$kotlinx_serialization_json$default(this, expected, false, 2, null);
        throw new KotlinNothingValueException();
    }

    public abstract void consumeNextToken(char expected);

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0142, code lost:
    
        if (r5 == r0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0144, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0147, code lost:
    
        if (r0 == r5) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0149, code lost:
    
        if (r10 == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x014d, code lost:
    
        if (r0 == (r5 - 1)) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x014f, code lost:
    
        if (r1 == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0151, code lost:
    
        if (r3 == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x015d, code lost:
    
        if (getSource().charAt(r5) != '\"') goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x015f, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0162, code lost:
    
        fail$default(r17, "Expected closing quotation mark", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0172, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0173, code lost:
    
        fail$default(r17, "EOF", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0183, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0184, code lost:
    
        r17.currentPosition = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0186, code lost:
    
        if (r9 == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0188, code lost:
    
        r0 = r11 * consumeNumericLiteral$calculateExponent(r13, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0192, code lost:
    
        if (r0 > 9.223372036854776E18d) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0198, code lost:
    
        if (r0 < (-9.223372036854776E18d)) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01a0, code lost:
    
        if (java.lang.Math.floor(r0) != r0) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01a2, code lost:
    
        r11 = (long) r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01a4, code lost:
    
        fail$default(r17, "Can't convert " + r0 + " to Long", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01c8, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01c9, code lost:
    
        fail$default(r17, "Numeric value overflow", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01d9, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01da, code lost:
    
        if (r10 == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01e1, code lost:
    
        if (r11 == Long.MIN_VALUE) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01e4, code lost:
    
        return -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01e5, code lost:
    
        fail$default(r17, "Numeric value overflow", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01f5, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:?, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01f6, code lost:
    
        fail$default(r17, "Expected numeric literal", 0, null, 6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0206, code lost:
    
        throw new kotlin.KotlinNothingValueException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0146, code lost:
    
        r3 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long consumeNumericLiteral() {
        boolean z5;
        char charAt;
        int prefetchOrEof = prefetchOrEof(skipWhitespaces());
        if (prefetchOrEof >= getSource().length() || prefetchOrEof == -1) {
            fail$default(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (getSource().charAt(prefetchOrEof) == '\"') {
            prefetchOrEof++;
            if (prefetchOrEof == getSource().length()) {
                fail$default(this, "EOF", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            z5 = true;
        } else {
            z5 = false;
        }
        int i5 = prefetchOrEof;
        long j5 = 0;
        long j6 = 0;
        boolean z6 = false;
        boolean z7 = false;
        loop0: while (true) {
            boolean z8 = false;
            while (i5 != getSource().length()) {
                charAt = getSource().charAt(i5);
                if ((charAt == 'e' || charAt == 'E') && !z6) {
                    if (i5 == prefetchOrEof) {
                        fail$default(this, "Unexpected symbol " + charAt + " in numeric literal", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    }
                    i5++;
                    z6 = true;
                } else if (charAt == '-' && z6) {
                    if (i5 == prefetchOrEof) {
                        fail$default(this, "Unexpected symbol '-' in numeric literal", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    }
                    i5++;
                } else if (charAt != '+' || !z6) {
                    if (charAt != '-') {
                        if (AbstractJsonLexerKt.charToTokenClass(charAt) != 0) {
                            break loop0;
                        }
                        i5++;
                        int i6 = charAt - '0';
                        if (i6 < 0 || i6 >= 10) {
                            break loop0;
                        }
                        if (z6) {
                            j6 = (j6 * 10) + i6;
                        } else {
                            j5 = (j5 * 10) - i6;
                            if (j5 > 0) {
                                fail$default(this, "Numeric value overflow", 0, null, 6, null);
                                throw new KotlinNothingValueException();
                            }
                        }
                    } else {
                        if (i5 != prefetchOrEof) {
                            fail$default(this, "Unexpected symbol '-' in numeric literal", 0, null, 6, null);
                            throw new KotlinNothingValueException();
                        }
                        i5++;
                        z7 = true;
                    }
                } else {
                    if (i5 == prefetchOrEof) {
                        fail$default(this, "Unexpected symbol '+' in numeric literal", 0, null, 6, null);
                        throw new KotlinNothingValueException();
                    }
                    i5++;
                }
                z8 = true;
            }
            break loop0;
        }
        fail$default(this, "Unexpected symbol '" + charAt + "' in numeric literal", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final String consumeString() {
        if (this.peekedString != null) {
            return takePeeked();
        }
        return consumeKeyString();
    }

    public final String consumeStringLenient() {
        if (this.peekedString != null) {
            return takePeeked();
        }
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces >= getSource().length() || skipWhitespaces == -1) {
            fail$default(this, "EOF", skipWhitespaces, null, 4, null);
            throw new KotlinNothingValueException();
        }
        byte charToTokenClass = AbstractJsonLexerKt.charToTokenClass(getSource().charAt(skipWhitespaces));
        if (charToTokenClass == 1) {
            return consumeString();
        }
        if (charToTokenClass != 0) {
            fail$default(this, "Expected beginning of the string, but got " + getSource().charAt(skipWhitespaces), 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        boolean z5 = false;
        while (AbstractJsonLexerKt.charToTokenClass(getSource().charAt(skipWhitespaces)) == 0) {
            skipWhitespaces++;
            if (skipWhitespaces >= getSource().length()) {
                appendRange(this.currentPosition, skipWhitespaces);
                int prefetchOrEof = prefetchOrEof(skipWhitespaces);
                if (prefetchOrEof == -1) {
                    this.currentPosition = skipWhitespaces;
                    return decodedString(0, 0);
                }
                skipWhitespaces = prefetchOrEof;
                z5 = true;
            }
        }
        String substring = !z5 ? substring(this.currentPosition, skipWhitespaces) : decodedString(this.currentPosition, skipWhitespaces);
        this.currentPosition = skipWhitespaces;
        return substring;
    }

    public final String consumeStringLenientNotNull() {
        String consumeStringLenient = consumeStringLenient();
        if (!Intrinsics.areEqual(consumeStringLenient, "null") || !wasUnquotedString()) {
            return consumeStringLenient;
        }
        fail$default(this, "Unexpected 'null' value instead of string literal", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final void discardPeeked() {
        this.peekedString = null;
    }

    public void ensureHaveChars() {
    }

    public final void expectEof() {
        if (consumeNextToken() == 10) {
            return;
        }
        fail$default(this, "Expected EOF after parsing, but had " + getSource().charAt(this.currentPosition - 1) + " instead", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final Void fail(String message, int position, String hint) {
        String str;
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(hint, "hint");
        if (hint.length() == 0) {
            str = BuildConfig.FLAVOR;
        } else {
            str = '\n' + hint;
        }
        throw JsonExceptionsKt.JsonDecodingException(position, message + " at path: " + this.path.getPath() + str, getSource());
    }

    public final Void fail$kotlinx_serialization_json(byte expectedToken, boolean wasConsumed) {
        String str = AbstractJsonLexerKt.tokenDescription(expectedToken);
        int i5 = wasConsumed ? this.currentPosition - 1 : this.currentPosition;
        fail$default(this, "Expected " + str + ", but had '" + ((this.currentPosition == getSource().length() || i5 < 0) ? "EOF" : String.valueOf(getSource().charAt(i5))) + "' instead", i5, null, 4, null);
        throw new KotlinNothingValueException();
    }

    public final void failOnUnknownKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        fail("Encountered an unknown key '" + key + '\'', StringsKt.lastIndexOf$default((CharSequence) substring(0, this.currentPosition), key, 0, false, 6, (Object) null), "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
        throw new KotlinNothingValueException();
    }

    protected abstract CharSequence getSource();

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isValidValueStart(char c5) {
        return !(c5 == '}' || c5 == ']' || c5 == ':' || c5 == ',');
    }

    public abstract String peekLeadingMatchingValue(String keyToMatch, boolean isLenient);

    public final byte peekNextToken() {
        CharSequence source = getSource();
        int i5 = this.currentPosition;
        while (true) {
            int prefetchOrEof = prefetchOrEof(i5);
            if (prefetchOrEof == -1) {
                this.currentPosition = prefetchOrEof;
                return (byte) 10;
            }
            char charAt = source.charAt(prefetchOrEof);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                this.currentPosition = prefetchOrEof;
                return AbstractJsonLexerKt.charToTokenClass(charAt);
            }
            i5 = prefetchOrEof + 1;
        }
    }

    public final String peekString(boolean isLenient) {
        String consumeString;
        byte peekNextToken = peekNextToken();
        if (isLenient) {
            if (peekNextToken != 1 && peekNextToken != 0) {
                return null;
            }
            consumeString = consumeStringLenient();
        } else {
            if (peekNextToken != 1) {
                return null;
            }
            consumeString = consumeString();
        }
        this.peekedString = consumeString;
        return consumeString;
    }

    public abstract int prefetchOrEof(int position);

    public final void skipElement(boolean allowLenientStrings) {
        ArrayList arrayList = new ArrayList();
        byte peekNextToken = peekNextToken();
        if (peekNextToken != 8 && peekNextToken != 6) {
            consumeStringLenient();
            return;
        }
        while (true) {
            byte peekNextToken2 = peekNextToken();
            if (peekNextToken2 != 1) {
                if (peekNextToken2 == 8 || peekNextToken2 == 6) {
                    arrayList.add(Byte.valueOf(peekNextToken2));
                } else if (peekNextToken2 == 9) {
                    if (((Number) CollectionsKt.last((List) arrayList)).byteValue() != 8) {
                        throw JsonExceptionsKt.JsonDecodingException(this.currentPosition, "found ] instead of } at path: " + this.path, getSource());
                    }
                    CollectionsKt.removeLast(arrayList);
                } else if (peekNextToken2 == 7) {
                    if (((Number) CollectionsKt.last((List) arrayList)).byteValue() != 6) {
                        throw JsonExceptionsKt.JsonDecodingException(this.currentPosition, "found } instead of ] at path: " + this.path, getSource());
                    }
                    CollectionsKt.removeLast(arrayList);
                } else if (peekNextToken2 == 10) {
                    fail$default(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
                consumeNextToken();
                if (arrayList.size() == 0) {
                    return;
                }
            } else if (allowLenientStrings) {
                consumeStringLenient();
            } else {
                consumeKeyString();
            }
        }
    }

    public abstract int skipWhitespaces();

    public String substring(int startPos, int endPos) {
        return getSource().subSequence(startPos, endPos).toString();
    }

    public String toString() {
        return "JsonReader(source='" + ((Object) getSource()) + "', currentPosition=" + this.currentPosition + ')';
    }

    public abstract boolean tryConsumeComma();

    public final boolean tryConsumeNull(boolean doConsume) {
        int prefetchOrEof = prefetchOrEof(skipWhitespaces());
        int length = getSource().length() - prefetchOrEof;
        if (length < 4 || prefetchOrEof == -1) {
            return false;
        }
        for (int i5 = 0; i5 < 4; i5++) {
            if ("null".charAt(i5) != getSource().charAt(prefetchOrEof + i5)) {
                return false;
            }
        }
        if (length > 4 && AbstractJsonLexerKt.charToTokenClass(getSource().charAt(prefetchOrEof + 4)) == 0) {
            return false;
        }
        if (!doConsume) {
            return true;
        }
        this.currentPosition = prefetchOrEof + 4;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void unexpectedToken(char expected) {
        int i5 = this.currentPosition;
        if (i5 > 0 && expected == '\"') {
            try {
                this.currentPosition = i5 - 1;
                String consumeStringLenient = consumeStringLenient();
                this.currentPosition = i5;
                if (Intrinsics.areEqual(consumeStringLenient, "null")) {
                    fail("Expected string literal but 'null' literal was found", this.currentPosition - 1, "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
                    throw new KotlinNothingValueException();
                }
            } catch (Throwable th) {
                this.currentPosition = i5;
                throw th;
            }
        }
        fail$kotlinx_serialization_json$default(this, AbstractJsonLexerKt.charToTokenClass(expected), false, 2, null);
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String consumeString(CharSequence source, int startPosition, int current) {
        String decodedString;
        int prefetchOrEof;
        Intrinsics.checkNotNullParameter(source, "source");
        char charAt = source.charAt(current);
        boolean z5 = false;
        while (charAt != '\"') {
            if (charAt == '\\') {
                prefetchOrEof = prefetchOrEof(appendEscape(startPosition, current));
                if (prefetchOrEof == -1) {
                    fail$default(this, "Unexpected EOF", prefetchOrEof, null, 4, null);
                    throw new KotlinNothingValueException();
                }
            } else {
                current++;
                if (current >= source.length()) {
                    appendRange(startPosition, current);
                    prefetchOrEof = prefetchOrEof(current);
                    if (prefetchOrEof == -1) {
                        fail$default(this, "Unexpected EOF", prefetchOrEof, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    continue;
                    charAt = source.charAt(current);
                }
            }
            z5 = true;
            startPosition = prefetchOrEof;
            current = startPosition;
            charAt = source.charAt(current);
        }
        if (!z5) {
            decodedString = substring(startPosition, current);
        } else {
            decodedString = decodedString(startPosition, current);
        }
        this.currentPosition = current + 1;
        return decodedString;
    }
}
