package kotlin.text;

import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\b\u0004\u001a'\u0010\u0004\u001a\u00020\u0002*\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a+\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\n\u001a+\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\r\u001a+\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\r\u001a\u0013\u0010\u0010\u001a\u00020\u0000*\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a'\u0010\u0010\u001a\u00020\u0000*\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0010\u0010\u0015\u001a\u0013\u0010\u0017\u001a\u00020\u0000*\u00020\u0016H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0013\u0010\u0019\u001a\u00020\u0016*\u00020\u0000H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a#\u0010\u001c\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u0005\u001a+\u0010\u001c\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a#\u0010\u001f\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010\u0005\u001a;\u0010#\u001a\u00020\u0002*\u00020\u00002\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$\u001a\u0019\u0010'\u001a\u00020\u0000*\u00020%2\u0006\u0010&\u001a\u00020\u0012¢\u0006\u0004\b'\u0010(¨\u0006)"}, d2 = {BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "ignoreCase", "equals", "(Ljava/lang/String;Ljava/lang/String;Z)Z", BuildConfig.FLAVOR, "oldChar", "newChar", "replace", "(Ljava/lang/String;CCZ)Ljava/lang/String;", "oldValue", "newValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;", "replaceFirst", BuildConfig.FLAVOR, "concatToString", "([C)Ljava/lang/String;", BuildConfig.FLAVOR, "startIndex", "endIndex", "([CII)Ljava/lang/String;", BuildConfig.FLAVOR, "decodeToString", "([B)Ljava/lang/String;", "encodeToByteArray", "(Ljava/lang/String;)[B", "prefix", "startsWith", "(Ljava/lang/String;Ljava/lang/String;IZ)Z", "suffix", "endsWith", "thisOffset", "otherOffset", "length", "regionMatches", "(Ljava/lang/String;ILjava/lang/String;IIZ)Z", BuildConfig.FLAVOR, "n", "repeat", "(Ljava/lang/CharSequence;I)Ljava/lang/String;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes3.dex */
public abstract class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    public static String concatToString(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return new String(cArr);
    }

    public static String decodeToString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new String(bArr, Charsets.UTF_8);
    }

    public static byte[] encodeToByteArray(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    public static boolean endsWith(String str, String suffix, boolean z5) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return !z5 ? str.endsWith(suffix) : StringsKt.regionMatches(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean endsWith$default(String str, String str2, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        return StringsKt.endsWith(str, str2, z5);
    }

    public static boolean equals(String str, String str2, boolean z5) {
        return str == null ? str2 == null : !z5 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ boolean equals$default(String str, String str2, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        return StringsKt.equals(str, str2, z5);
    }

    public static boolean regionMatches(String str, int i5, String other, int i6, int i7, boolean z5) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return !z5 ? str.regionMatches(i5, other, i6, i7) : str.regionMatches(z5, i5, other, i6, i7);
    }

    public static /* synthetic */ boolean regionMatches$default(String str, int i5, String str2, int i6, int i7, boolean z5, int i8, Object obj) {
        if ((i8 & 16) != 0) {
            z5 = false;
        }
        return StringsKt.regionMatches(str, i5, str2, i6, i7, z5);
    }

    public static String repeat(CharSequence charSequence, int i5) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i5 + '.').toString());
        }
        if (i5 == 0) {
            return BuildConfig.FLAVOR;
        }
        int i6 = 1;
        if (i5 == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return BuildConfig.FLAVOR;
        }
        if (length == 1) {
            char charAt = charSequence.charAt(0);
            char[] cArr = new char[i5];
            for (int i7 = 0; i7 < i5; i7++) {
                cArr[i7] = charAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(charSequence.length() * i5);
        if (1 <= i5) {
            while (true) {
                sb.append(charSequence);
                if (i6 == i5) {
                    break;
                }
                i6++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNull(sb2);
        return sb2;
    }

    public static final String replace(String str, char c5, char c6, boolean z5) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (!z5) {
            String replace = str.replace(c5, c6);
            Intrinsics.checkNotNullExpressionValue(replace, "replace(...)");
            return replace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i5 = 0; i5 < str.length(); i5++) {
            char charAt = str.charAt(i5);
            if (CharsKt__CharKt.equals(charAt, c5, z5)) {
                charAt = c6;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static /* synthetic */ String replace$default(String str, char c5, char c6, boolean z5, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            z5 = false;
        }
        return replace(str, c5, c6, z5);
    }

    public static final String replaceFirst(String str, String oldValue, String newValue, boolean z5) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        int indexOf$default = StringsKt.indexOf$default(str, oldValue, 0, z5, 2, (Object) null);
        return indexOf$default < 0 ? str : StringsKt.replaceRange(str, indexOf$default, oldValue.length() + indexOf$default, newValue).toString();
    }

    public static /* synthetic */ String replaceFirst$default(String str, String str2, String str3, boolean z5, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            z5 = false;
        }
        return replaceFirst(str, str2, str3, z5);
    }

    public static boolean startsWith(String str, String prefix, boolean z5) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!z5) {
            return str.startsWith(prefix);
        }
        return StringsKt.regionMatches(str, 0, prefix, 0, prefix.length(), z5);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        return StringsKt.startsWith(str, str2, z5);
    }

    public static String concatToString(char[] cArr, int i5, int i6) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i5, i6, cArr.length);
        return new String(cArr, i5, i6 - i5);
    }

    public static /* synthetic */ String replace$default(String str, String str2, String str3, boolean z5, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            z5 = false;
        }
        return replace(str, str2, str3, z5);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, int i5, boolean z5, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            z5 = false;
        }
        return StringsKt.startsWith(str, str2, i5, z5);
    }

    public static boolean startsWith(String str, String prefix, int i5, boolean z5) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!z5) {
            return str.startsWith(prefix, i5);
        }
        return StringsKt.regionMatches(str, i5, prefix, 0, prefix.length(), z5);
    }

    public static final String replace(String str, String oldValue, String newValue, boolean z5) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        int i5 = 0;
        int indexOf = StringsKt__StringsKt.indexOf(str, oldValue, 0, z5);
        if (indexOf < 0) {
            return str;
        }
        int length = oldValue.length();
        int coerceAtLeast = RangesKt.coerceAtLeast(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append((CharSequence) str, i5, indexOf);
                sb.append(newValue);
                i5 = indexOf + length;
                if (indexOf >= str.length()) {
                    break;
                }
                indexOf = StringsKt__StringsKt.indexOf(str, oldValue, indexOf + coerceAtLeast, z5);
            } while (indexOf > 0);
            sb.append((CharSequence) str, i5, str.length());
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }
        throw new OutOfMemoryError();
    }
}
