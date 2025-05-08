package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

/* loaded from: classes3.dex */
public abstract class RenderingUtilsKt {
    public static final String render(Name name) {
        Intrinsics.checkNotNullParameter(name, "<this>");
        if (!shouldBeEscaped(name)) {
            String asString = name.asString();
            Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
            return asString;
        }
        StringBuilder sb = new StringBuilder();
        String asString2 = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString2, "asString(...)");
        sb.append('`' + asString2);
        sb.append('`');
        return sb.toString();
    }

    public static final String renderFqName(List<Name> pathSegments) {
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        StringBuilder sb = new StringBuilder();
        for (Name name : pathSegments) {
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(render(name));
        }
        return sb.toString();
    }

    public static final String replacePrefixesInTypeRepresentations(String lowerRendered, String lowerPrefix, String upperRendered, String upperPrefix, String foldedPrefix) {
        Intrinsics.checkNotNullParameter(lowerRendered, "lowerRendered");
        Intrinsics.checkNotNullParameter(lowerPrefix, "lowerPrefix");
        Intrinsics.checkNotNullParameter(upperRendered, "upperRendered");
        Intrinsics.checkNotNullParameter(upperPrefix, "upperPrefix");
        Intrinsics.checkNotNullParameter(foldedPrefix, "foldedPrefix");
        if (StringsKt.startsWith$default(lowerRendered, lowerPrefix, false, 2, (Object) null) && StringsKt.startsWith$default(upperRendered, upperPrefix, false, 2, (Object) null)) {
            String substring = lowerRendered.substring(lowerPrefix.length());
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            String substring2 = upperRendered.substring(upperPrefix.length());
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            String str = foldedPrefix + substring;
            if (Intrinsics.areEqual(substring, substring2)) {
                return str;
            }
            if (typeStringsDifferOnlyInNullability(substring, substring2)) {
                return str + '!';
            }
        }
        return null;
    }

    private static final boolean shouldBeEscaped(Name name) {
        String asString = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        if (!KeywordStringsGenerated.KEYWORDS.contains(asString)) {
            int i5 = 0;
            while (true) {
                if (i5 < asString.length()) {
                    char charAt = asString.charAt(i5);
                    if (!Character.isLetterOrDigit(charAt) && charAt != '_') {
                        break;
                    }
                    i5++;
                } else if (asString.length() != 0 && Character.isJavaIdentifierStart(asString.codePointAt(0))) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x003c, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r7 + '?', r8) == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean typeStringsDifferOnlyInNullability(String lower, String upper) {
        Intrinsics.checkNotNullParameter(lower, "lower");
        Intrinsics.checkNotNullParameter(upper, "upper");
        if (!Intrinsics.areEqual(lower, StringsKt.replace$default(upper, "?", BuildConfig.FLAVOR, false, 4, (Object) null))) {
            if (StringsKt.endsWith$default(upper, "?", false, 2, (Object) null)) {
            }
            if (!Intrinsics.areEqual('(' + lower + ")?", upper)) {
                return false;
            }
        }
        return true;
    }

    public static final String render(FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "<this>");
        return renderFqName(fqNameUnsafe.pathSegments());
    }
}
