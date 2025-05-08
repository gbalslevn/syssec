package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u000b\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u000b\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0003\u001a\u00020\u00028\u0014X\u0094\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u0018¨\u0006\u001f"}, d2 = {"Lkotlinx/serialization/json/internal/StringJsonLexer;", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", BuildConfig.FLAVOR, "source", "<init>", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "position", "prefetchOrEof", "(I)I", BuildConfig.FLAVOR, "consumeNextToken", "()B", BuildConfig.FLAVOR, "tryConsumeComma", "()Z", "canConsumeValue", "skipWhitespaces", "()I", BuildConfig.FLAVOR, "expected", BuildConfig.FLAVOR, "(C)V", "consumeKeyString", "()Ljava/lang/String;", "keyToMatch", "isLenient", "peekLeadingMatchingValue", "(Ljava/lang/String;Z)Ljava/lang/String;", "Ljava/lang/String;", "getSource", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StringJsonLexer extends JsonReader {
    private final String source;

    public StringJsonLexer(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
    }

    @Override // kotlinx.serialization.json.internal.JsonReader
    public boolean canConsumeValue() {
        int i5 = this.currentPosition;
        if (i5 == -1) {
            return false;
        }
        while (i5 < getSource().length()) {
            char charAt = getSource().charAt(i5);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                this.currentPosition = i5;
                return isValidValueStart(charAt);
            }
            i5++;
        }
        this.currentPosition = i5;
        return false;
    }

    @Override // kotlinx.serialization.json.internal.JsonReader
    public String consumeKeyString() {
        consumeNextToken('\"');
        int i5 = this.currentPosition;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) getSource(), '\"', i5, false, 4, (Object) null);
        if (indexOf$default == -1) {
            consumeStringLenient();
            fail$kotlinx_serialization_json((byte) 1, false);
            throw new KotlinNothingValueException();
        }
        for (int i6 = i5; i6 < indexOf$default; i6++) {
            if (getSource().charAt(i6) == '\\') {
                return consumeString(getSource(), this.currentPosition, i6);
            }
        }
        this.currentPosition = indexOf$default + 1;
        String substring = getSource().substring(i5, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    @Override // kotlinx.serialization.json.internal.JsonReader
    public byte consumeNextToken() {
        byte charToTokenClass;
        String source = getSource();
        do {
            int i5 = this.currentPosition;
            if (i5 == -1 || i5 >= source.length()) {
                return (byte) 10;
            }
            int i6 = this.currentPosition;
            this.currentPosition = i6 + 1;
            charToTokenClass = AbstractJsonLexerKt.charToTokenClass(source.charAt(i6));
        } while (charToTokenClass == 3);
        return charToTokenClass;
    }

    @Override // kotlinx.serialization.json.internal.JsonReader
    public String peekLeadingMatchingValue(String keyToMatch, boolean isLenient) {
        Intrinsics.checkNotNullParameter(keyToMatch, "keyToMatch");
        int i5 = this.currentPosition;
        try {
            if (consumeNextToken() == 6 && Intrinsics.areEqual(peekString(isLenient), keyToMatch)) {
                discardPeeked();
                if (consumeNextToken() == 5) {
                    return peekString(isLenient);
                }
            }
            return null;
        } finally {
            this.currentPosition = i5;
            discardPeeked();
        }
    }

    @Override // kotlinx.serialization.json.internal.JsonReader
    public int prefetchOrEof(int position) {
        if (position < getSource().length()) {
            return position;
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.JsonReader
    public int skipWhitespaces() {
        char charAt;
        int i5 = this.currentPosition;
        if (i5 == -1) {
            return i5;
        }
        while (i5 < getSource().length() && ((charAt = getSource().charAt(i5)) == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t')) {
            i5++;
        }
        this.currentPosition = i5;
        return i5;
    }

    @Override // kotlinx.serialization.json.internal.JsonReader
    public boolean tryConsumeComma() {
        int skipWhitespaces = skipWhitespaces();
        if (skipWhitespaces == getSource().length() || skipWhitespaces == -1 || getSource().charAt(skipWhitespaces) != ',') {
            return false;
        }
        this.currentPosition++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.json.internal.JsonReader
    public String getSource() {
        return this.source;
    }

    @Override // kotlinx.serialization.json.internal.JsonReader
    public void consumeNextToken(char expected) {
        if (this.currentPosition == -1) {
            unexpectedToken(expected);
        }
        String source = getSource();
        while (this.currentPosition < source.length()) {
            int i5 = this.currentPosition;
            this.currentPosition = i5 + 1;
            char charAt = source.charAt(i5);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                if (charAt == expected) {
                    return;
                } else {
                    unexpectedToken(expected);
                }
            }
        }
        this.currentPosition = -1;
        unexpectedToken(expected);
    }
}
