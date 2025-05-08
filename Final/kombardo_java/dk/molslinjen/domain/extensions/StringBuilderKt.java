package dk.molslinjen.domain.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"spacedString", BuildConfig.FLAVOR, "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "source", "subStringLength", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class StringBuilderKt {
    public static final String spacedString(StringBuilder sb, String source, int i5) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        int i6 = 0;
        int i7 = 0;
        while (i6 < source.length()) {
            char charAt = source.charAt(i6);
            int i8 = i7 + 1;
            if (i7 > 0) {
                int i9 = i7 % i5;
                if (i9 + ((((i9 ^ i5) & ((-i9) | i9)) >> 31) & i5) == 0) {
                    sb.append(" ");
                }
            }
            sb.append(charAt);
            i6++;
            i7 = i8;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
