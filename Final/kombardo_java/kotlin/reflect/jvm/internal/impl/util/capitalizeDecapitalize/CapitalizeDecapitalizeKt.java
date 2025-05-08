package kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize;

import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public abstract class CapitalizeDecapitalizeKt {
    public static final String capitalizeAsciiOnly(String str) {
        char charAt;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() == 0 || 'a' > (charAt = str.charAt(0)) || charAt >= '{') {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        sb.append(Character.toUpperCase(charAt));
        sb.append((CharSequence) str, 1, str.length());
        return sb.toString();
    }

    public static final String decapitalizeAsciiOnly(String str) {
        char charAt;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() == 0 || 'A' > (charAt = str.charAt(0)) || charAt >= '[') {
            return str;
        }
        char lowerCase = Character.toLowerCase(charAt);
        String substring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return lowerCase + substring;
    }

    public static final String decapitalizeSmartForCompiler(String str, boolean z5) {
        Integer num;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() == 0 || !isUpperCaseCharAt(str, 0, z5)) {
            return str;
        }
        if (str.length() == 1 || !isUpperCaseCharAt(str, 1, z5)) {
            if (z5) {
                return decapitalizeAsciiOnly(str);
            }
            if (str.length() <= 0) {
                return str;
            }
            char lowerCase = Character.toLowerCase(str.charAt(0));
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return lowerCase + substring;
        }
        Iterator<Integer> it = StringsKt.getIndices(str).iterator();
        while (true) {
            if (!it.hasNext()) {
                num = null;
                break;
            }
            num = it.next();
            if (!isUpperCaseCharAt(str, num.intValue(), z5)) {
                break;
            }
        }
        Integer num2 = num;
        if (num2 == null) {
            return toLowerCase(str, z5);
        }
        int intValue = num2.intValue() - 1;
        StringBuilder sb = new StringBuilder();
        String substring2 = str.substring(0, intValue);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        sb.append(toLowerCase(substring2, z5));
        String substring3 = str.substring(intValue);
        Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
        sb.append(substring3);
        return sb.toString();
    }

    private static final boolean isUpperCaseCharAt(String str, int i5, boolean z5) {
        char charAt = str.charAt(i5);
        return z5 ? 'A' <= charAt && charAt < '[' : Character.isUpperCase(charAt);
    }

    private static final String toLowerCase(String str, boolean z5) {
        if (z5) {
            return toLowerCaseAsciiOnly(str);
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public static final String toLowerCaseAsciiOnly(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            char charAt = str.charAt(i5);
            if ('A' <= charAt && charAt < '[') {
                charAt = Character.toLowerCase(charAt);
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
