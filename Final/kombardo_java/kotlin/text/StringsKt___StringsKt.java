package kotlin.text;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.SlidingWindowKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00004\n\u0002\u0010\r\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\n\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\n\u0010\u0003\u001a\u0011\u0010\u000b\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u000b\u0010\u0003\u001a\u0019\u0010\u000e\u001a\u00020\f*\u00020\f2\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0019\u0010\u0010\u001a\u00020\f*\u00020\f2\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u000f\u001a\u0019\u0010\u0011\u001a\u00020\f*\u00020\f2\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u000f\u001a\u0019\u0010\u0012\u001a\u00020\f*\u00020\f2\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u000f\u001a\u0011\u0010\u0013\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0016*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a5\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u0016*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001aO\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u001e*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\u001fH\u0007¢\u0006\u0004\b\u001c\u0010!¨\u0006\""}, d2 = {BuildConfig.FLAVOR, BuildConfig.FLAVOR, "first", "(Ljava/lang/CharSequence;)C", "firstOrNull", "(Ljava/lang/CharSequence;)Ljava/lang/Character;", BuildConfig.FLAVOR, "index", "getOrNull", "(Ljava/lang/CharSequence;I)Ljava/lang/Character;", "last", "single", BuildConfig.FLAVOR, "n", "drop", "(Ljava/lang/String;I)Ljava/lang/String;", "dropLast", "take", "takeLast", "reversed", "(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "size", BuildConfig.FLAVOR, "chunked", "(Ljava/lang/CharSequence;I)Ljava/util/List;", "step", BuildConfig.FLAVOR, "partialWindows", "windowed", "(Ljava/lang/CharSequence;IIZ)Ljava/util/List;", "R", "Lkotlin/Function1;", "transform", "(Ljava/lang/CharSequence;IIZLkotlin/jvm/functions/Function1;)Ljava/util/List;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes3.dex */
public abstract class StringsKt___StringsKt extends StringsKt___StringsJvmKt {
    public static List<String> chunked(CharSequence charSequence, int i5) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return StringsKt.windowed(charSequence, i5, i5, true);
    }

    public static String drop(String str, int i5) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i5 >= 0) {
            String substring = str.substring(RangesKt.coerceAtMost(i5, str.length()));
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i5 + " is less than zero.").toString());
    }

    public static String dropLast(String str, int i5) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i5 >= 0) {
            return StringsKt.take(str, RangesKt.coerceAtLeast(str.length() - i5, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i5 + " is less than zero.").toString());
    }

    public static char first(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static Character firstOrNull(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(0));
    }

    public static Character getOrNull(CharSequence charSequence, int i5) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i5 < 0 || i5 >= charSequence.length()) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(i5));
    }

    public static char last(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(StringsKt.getLastIndex(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static CharSequence reversed(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return new StringBuilder(charSequence).reverse();
    }

    public static char single(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        if (length == 1) {
            return charSequence.charAt(0);
        }
        throw new IllegalArgumentException("Char sequence has more than one element.");
    }

    public static String take(String str, int i5) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i5 >= 0) {
            String substring = str.substring(0, RangesKt.coerceAtMost(i5, str.length()));
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i5 + " is less than zero.").toString());
    }

    public static String takeLast(String str, int i5) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i5 >= 0) {
            int length = str.length();
            String substring = str.substring(length - RangesKt.coerceAtMost(i5, length));
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i5 + " is less than zero.").toString());
    }

    public static List<String> windowed(CharSequence charSequence, int i5, int i6, boolean z5) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return windowed(charSequence, i5, i6, z5, new Function1() { // from class: kotlin.text.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                String windowed$lambda$23$StringsKt___StringsKt;
                windowed$lambda$23$StringsKt___StringsKt = StringsKt___StringsKt.windowed$lambda$23$StringsKt___StringsKt((CharSequence) obj);
                return windowed$lambda$23$StringsKt___StringsKt;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String windowed$lambda$23$StringsKt___StringsKt(CharSequence it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.toString();
    }

    public static final <R> List<R> windowed(CharSequence charSequence, int i5, int i6, boolean z5, Function1<? super CharSequence, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        SlidingWindowKt.checkWindowSizeStep(i5, i6);
        int length = charSequence.length();
        int i7 = 0;
        ArrayList arrayList = new ArrayList((length / i6) + (length % i6 == 0 ? 0 : 1));
        while (i7 >= 0 && i7 < length) {
            int i8 = i7 + i5;
            if (i8 < 0 || i8 > length) {
                if (!z5) {
                    break;
                }
                i8 = length;
            }
            arrayList.add(transform.invoke(charSequence.subSequence(i7, i8)));
            i7 += i6;
        }
        return arrayList;
    }
}
