package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0000¢\u0006\u0004\b\n\u0010\u000b\"\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u000f"}, d2 = {BuildConfig.FLAVOR, "token", BuildConfig.FLAVOR, "tokenDescription", "(B)Ljava/lang/String;", BuildConfig.FLAVOR, "c", "charToTokenClass", "(C)B", BuildConfig.FLAVOR, "escapeToChar", "(I)C", "CTC_MAX", "I", "ESC2C_MAX", "kotlinx-serialization-json"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AbstractJsonLexerKt {
    private static final int CTC_MAX = 126;
    private static final int ESC2C_MAX = 117;

    public static final byte charToTokenClass(char c5) {
        if (c5 < CTC_MAX) {
            return CharMappings.CHAR_TO_TOKEN[c5];
        }
        return (byte) 0;
    }

    public static final char escapeToChar(int i5) {
        if (i5 < 117) {
            return CharMappings.ESCAPE_2_CHAR[i5];
        }
        return (char) 0;
    }

    public static final String tokenDescription(byte b5) {
        return b5 == 1 ? "quotation mark '\"'" : b5 == 2 ? "string escape sequence '\\'" : b5 == 4 ? "comma ','" : b5 == 5 ? "colon ':'" : b5 == 6 ? "start of the object '{'" : b5 == 7 ? "end of the object '}'" : b5 == 8 ? "start of the array '['" : b5 == 9 ? "end of the array ']'" : b5 == 10 ? "end of the input" : b5 == Byte.MAX_VALUE ? "invalid token" : "valid token";
    }
}
