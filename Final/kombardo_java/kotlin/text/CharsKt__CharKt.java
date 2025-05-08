package kotlin.text;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\n\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {BuildConfig.FLAVOR, BuildConfig.FLAVOR, "digitToInt", "(C)I", BuildConfig.FLAVOR, "titlecase", "(C)Ljava/lang/String;", "other", BuildConfig.FLAVOR, "ignoreCase", "equals", "(CCZ)Z", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/text/CharsKt")
/* loaded from: classes3.dex */
public abstract class CharsKt__CharKt extends CharsKt__CharJVMKt {
    public static int digitToInt(char c5) {
        int digitOf = CharsKt__CharJVMKt.digitOf(c5, 10);
        if (digitOf >= 0) {
            return digitOf;
        }
        throw new IllegalArgumentException("Char " + c5 + " is not a decimal digit");
    }

    public static final boolean equals(char c5, char c6, boolean z5) {
        if (c5 == c6) {
            return true;
        }
        if (!z5) {
            return false;
        }
        char upperCase = Character.toUpperCase(c5);
        char upperCase2 = Character.toUpperCase(c6);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static String titlecase(char c5) {
        return _OneToManyTitlecaseMappingsKt.titlecaseImpl(c5);
    }
}
