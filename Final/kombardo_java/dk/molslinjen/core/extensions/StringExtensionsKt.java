package dk.molslinjen.core.extensions;

import dk.molslinjen.core.extensions.StringExtensionsKt;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\b\u0010\u0007\u001a\u0011\u0010\t\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\t\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\n\u0010\u0007\u001a\u0011\u0010\u000b\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\u000b\u0010\u0007\u001a\u0011\u0010\f\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0011\u0010\u000e\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u000e\u0010\r\u001a\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u000f\u0010\r\u001a\u0011\u0010\u0010\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0010\u0010\r\u001a\u0011\u0010\u0011\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0011\u0010\r\u001a\u0011\u0010\u0012\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0012\u0010\r¨\u0006\u0013"}, d2 = {BuildConfig.FLAVOR, BuildConfig.FLAVOR, "segmentSize", "toFormattedPhoneNumber", "(Ljava/lang/String;I)Ljava/lang/String;", BuildConfig.FLAVOR, "isEmail", "(Ljava/lang/String;)Z", "containsLowerCaseLetters", "containsUpperCaseLetters", "containsNumber", "containsSpecialCharacter", "md5", "(Ljava/lang/String;)Ljava/lang/String;", "toFormattedCountryCode", "nullIfEmpty", "uppercaseFirstLetter", "lowercaseFirstLetter", "takeFirstSentence", "core_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class StringExtensionsKt {
    public static final boolean containsLowerCaseLetters(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new Regex("[a-z]+").containsMatchIn(str);
    }

    public static final boolean containsNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new Regex("[0-9]+").containsMatchIn(str);
    }

    public static final boolean containsSpecialCharacter(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new Regex("[!\"#$%&'()*+,-./:;\\\\<=>?@\\[\\]^_`{|}~]").containsMatchIn(str);
    }

    public static final boolean containsUpperCaseLetters(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new Regex("[A-Z]+").containsMatchIn(str);
    }

    public static final boolean isEmail(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return new Regex("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+").matches(str);
    }

    public static final String lowercaseFirstLetter(String str) {
        String valueOf;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            valueOf = CharsKt.lowercase(charAt, locale);
        } else {
            valueOf = String.valueOf(charAt);
        }
        sb.append((Object) valueOf);
        String substring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        sb.append(substring);
        return sb.toString();
    }

    public static final String md5(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String bigInteger = new BigInteger(1, messageDigest.digest(bytes)).toString(16);
        Intrinsics.checkNotNullExpressionValue(bigInteger, "toString(...)");
        return StringsKt.padStart(bigInteger, 32, '0');
    }

    public static final String nullIfEmpty(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return str;
    }

    public static final String takeFirstSentence(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, ".", 0, false, 6, (Object) null);
        int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str, "\n", 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            indexOf$default = indexOf$default2;
        }
        if (indexOf$default == -1) {
            return str;
        }
        String substring = str.substring(0, indexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static final String toFormattedCountryCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt.startsWith$default(str, "00", false, 2, (Object) null)) {
            String substring = str.substring(2);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return "+" + substring;
        }
        if (StringsKt.startsWith$default(str, "+", false, 2, (Object) null)) {
            return str;
        }
        return "+" + str;
    }

    public static final String toFormattedPhoneNumber(String str, int i5) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.replace$default(StringsKt.reversed(CollectionsKt.joinToString$default(StringsKt.windowed(StringsKt.reversed(StringsKt.replace$default(str, " ", BuildConfig.FLAVOR, false, 4, (Object) null)).toString(), i5, i5, true), " ", null, null, 0, null, new Function1() { // from class: u1.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence formattedPhoneNumber$lambda$0;
                formattedPhoneNumber$lambda$0 = StringExtensionsKt.toFormattedPhoneNumber$lambda$0((String) obj);
                return formattedPhoneNumber$lambda$0;
            }
        }, 30, null)).toString(), "+ ", "+", false, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toFormattedPhoneNumber$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    public static final String uppercaseFirstLetter(String str) {
        String valueOf;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char charAt = str.charAt(0);
        if (Character.isLowerCase(charAt)) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            valueOf = CharsKt.titlecase(charAt, locale);
        } else {
            valueOf = String.valueOf(charAt);
        }
        sb.append((Object) valueOf);
        String substring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        sb.append(substring);
        return sb.toString();
    }
}
