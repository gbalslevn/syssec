package kotlin.text;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001b\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\t\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\b\u001a\u001b\u0010\n\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\b\u001a\u001f\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isWhitespace", "(C)Z", "Ljava/util/Locale;", "locale", BuildConfig.FLAVOR, "uppercase", "(CLjava/util/Locale;)Ljava/lang/String;", "lowercase", "titlecase", "char", BuildConfig.FLAVOR, "radix", "digitOf", "(CI)I", "checkRadix", "(I)I", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/text/CharsKt")
/* loaded from: classes3.dex */
public abstract class CharsKt__CharJVMKt {
    public static int checkRadix(int i5) {
        if (2 <= i5 && i5 < 37) {
            return i5;
        }
        throw new IllegalArgumentException("radix " + i5 + " was not in valid range " + new IntRange(2, 36));
    }

    public static final int digitOf(char c5, int i5) {
        return Character.digit((int) c5, i5);
    }

    public static boolean isWhitespace(char c5) {
        return Character.isWhitespace(c5) || Character.isSpaceChar(c5);
    }

    public static String lowercase(char c5, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String valueOf = String.valueOf(c5);
        Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = valueOf.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public static String titlecase(char c5, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String uppercase = uppercase(c5, locale);
        if (uppercase.length() <= 1) {
            String valueOf = String.valueOf(c5);
            Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = valueOf.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return !Intrinsics.areEqual(uppercase, upperCase) ? uppercase : String.valueOf(Character.toTitleCase(c5));
        }
        if (c5 == 329) {
            return uppercase;
        }
        char charAt = uppercase.charAt(0);
        Intrinsics.checkNotNull(uppercase, "null cannot be cast to non-null type java.lang.String");
        String substring = uppercase.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = substring.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return charAt + lowerCase;
    }

    public static final String uppercase(char c5, Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        String valueOf = String.valueOf(c5);
        Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }
}
