package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0018\u0010\u000e\u001a\u00020\u000f*\u00060\u0010j\u0002`\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0000\u001a\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u0006H\u0000¢\u0006\u0002\u0010\u0015\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"ESCAPE_MARKERS", BuildConfig.FLAVOR, "getESCAPE_MARKERS", "()[B", "ESCAPE_STRINGS", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "getESCAPE_STRINGS", "()[Ljava/lang/String;", "[Ljava/lang/String;", "toHexChar", BuildConfig.FLAVOR, "i", BuildConfig.FLAVOR, "printQuoted", BuildConfig.FLAVOR, "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "value", "toBooleanStrictOrNull", BuildConfig.FLAVOR, "(Ljava/lang/String;)Ljava/lang/Boolean;", "kotlinx-serialization-json"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class StringOpsKt {
    private static final byte[] ESCAPE_MARKERS;
    private static final String[] ESCAPE_STRINGS;

    static {
        String[] strArr = new String[93];
        for (int i5 = 0; i5 < 32; i5++) {
            strArr[i5] = "\\u" + toHexChar(i5 >> 12) + toHexChar(i5 >> 8) + toHexChar(i5 >> 4) + toHexChar(i5);
        }
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        ESCAPE_STRINGS = strArr;
        byte[] bArr = new byte[93];
        for (int i6 = 0; i6 < 32; i6++) {
            bArr[i6] = 1;
        }
        bArr[34] = 34;
        bArr[92] = 92;
        bArr[9] = 116;
        bArr[8] = 98;
        bArr[10] = 110;
        bArr[13] = 114;
        bArr[12] = 102;
        ESCAPE_MARKERS = bArr;
    }

    public static final byte[] getESCAPE_MARKERS() {
        return ESCAPE_MARKERS;
    }

    public static final String[] getESCAPE_STRINGS() {
        return ESCAPE_STRINGS;
    }

    public static final void printQuoted(StringBuilder sb, String value) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        sb.append('\"');
        int length = value.length();
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = value.charAt(i6);
            String[] strArr = ESCAPE_STRINGS;
            if (charAt < strArr.length && strArr[charAt] != null) {
                sb.append((CharSequence) value, i5, i6);
                sb.append(strArr[charAt]);
                i5 = i6 + 1;
            }
        }
        if (i5 != 0) {
            sb.append((CharSequence) value, i5, value.length());
        } else {
            sb.append(value);
        }
        sb.append('\"');
    }

    public static final Boolean toBooleanStrictOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt.equals(str, "true", true)) {
            return Boolean.TRUE;
        }
        if (StringsKt.equals(str, "false", true)) {
            return Boolean.FALSE;
        }
        return null;
    }

    private static final char toHexChar(int i5) {
        int i6 = i5 & 15;
        return (char) (i6 < 10 ? i6 + 48 : i6 + 87);
    }
}
