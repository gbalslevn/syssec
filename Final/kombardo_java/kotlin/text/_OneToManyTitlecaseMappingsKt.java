package kotlin.text;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\f\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"titlecaseImpl", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class _OneToManyTitlecaseMappingsKt {
    public static final String titlecaseImpl(char c5) {
        String valueOf = String.valueOf(c5);
        Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        Locale locale = Locale.ROOT;
        String upperCase = valueOf.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        if (upperCase.length() <= 1) {
            return String.valueOf(Character.toTitleCase(c5));
        }
        if (c5 == 329) {
            return upperCase;
        }
        char charAt = upperCase.charAt(0);
        Intrinsics.checkNotNull(upperCase, "null cannot be cast to non-null type java.lang.String");
        String substring = upperCase.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = substring.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return charAt + lowerCase;
    }
}
