package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0005\u0018\u0000 *2\u00060\u0001j\u0002`\u0002:\u0002+*B\u0011\b\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0086\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0011J!\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0\u001d¢\u0006\u0004\b\u001b\u0010\u001fJ%\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070!2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\u0013¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0007H\u0016¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010&R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "Ljava/util/regex/Pattern;", "nativePattern", "<init>", "(Ljava/util/regex/Pattern;)V", BuildConfig.FLAVOR, "pattern", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "writeReplace", "()Ljava/lang/Object;", BuildConfig.FLAVOR, "input", BuildConfig.FLAVOR, "matches", "(Ljava/lang/CharSequence;)Z", "containsMatchIn", BuildConfig.FLAVOR, "startIndex", "Lkotlin/text/MatchResult;", "find", "(Ljava/lang/CharSequence;I)Lkotlin/text/MatchResult;", "matchEntire", "(Ljava/lang/CharSequence;)Lkotlin/text/MatchResult;", "replacement", "replace", "(Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/Function1;", "transform", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "limit", BuildConfig.FLAVOR, "split", "(Ljava/lang/CharSequence;I)Ljava/util/List;", "toString", "()Ljava/lang/String;", "Ljava/util/regex/Pattern;", BuildConfig.FLAVOR, "_options", "Ljava/util/Set;", "Companion", "Serialized", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Regex implements Serializable {
    private Set<Object> _options;
    private final Pattern nativePattern;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\n\b\u0002\u0018\u0000 \u00122\u00060\u0001j\u0002`\u0002:\u0001\u0012B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", BuildConfig.FLAVOR, "pattern", BuildConfig.FLAVOR, "flags", "<init>", "(Ljava/lang/String;I)V", BuildConfig.FLAVOR, "readResolve", "()Ljava/lang/Object;", "Ljava/lang/String;", "getPattern", "()Ljava/lang/String;", "I", "getFlags", "()I", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Serialized implements Serializable {
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        public Serialized(String pattern, int i5) {
            Intrinsics.checkNotNullParameter(pattern, "pattern");
            this.pattern = pattern;
            this.flags = i5;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
            return new Regex(compile);
        }
    }

    public Regex(Pattern nativePattern) {
        Intrinsics.checkNotNullParameter(nativePattern, "nativePattern");
        this.nativePattern = nativePattern;
    }

    public static /* synthetic */ MatchResult find$default(Regex regex, CharSequence charSequence, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        return regex.find(charSequence, i5);
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(pattern, "pattern(...)");
        return new Serialized(pattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    public final MatchResult find(CharSequence input, int startIndex) {
        MatchResult findNext;
        Intrinsics.checkNotNullParameter(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        findNext = RegexKt.findNext(matcher, startIndex, input);
        return findNext;
    }

    public final MatchResult matchEntire(CharSequence input) {
        MatchResult matchEntire;
        Intrinsics.checkNotNullParameter(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        matchEntire = RegexKt.matchEntire(matcher, input);
        return matchEntire;
    }

    public final boolean matches(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    public final String replace(CharSequence input, String replacement) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        String replaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        Intrinsics.checkNotNullExpressionValue(replaceAll, "replaceAll(...)");
        return replaceAll;
    }

    public final List<String> split(CharSequence input, int limit) {
        Intrinsics.checkNotNullParameter(input, "input");
        StringsKt__StringsKt.requireNonNegativeLimit(limit);
        Matcher matcher = this.nativePattern.matcher(input);
        if (limit == 1 || !matcher.find()) {
            return CollectionsKt.listOf(input.toString());
        }
        ArrayList arrayList = new ArrayList(limit > 0 ? RangesKt.coerceAtMost(limit, 10) : 10);
        int i5 = limit - 1;
        int i6 = 0;
        do {
            arrayList.add(input.subSequence(i6, matcher.start()).toString());
            i6 = matcher.end();
            if (i5 >= 0 && arrayList.size() == i5) {
                break;
            }
        } while (matcher.find());
        arrayList.add(input.subSequence(i6, input.length()).toString());
        return arrayList;
    }

    public String toString() {
        String pattern = this.nativePattern.toString();
        Intrinsics.checkNotNullExpressionValue(pattern, "toString(...)");
        return pattern;
    }

    public final String replace(CharSequence input, Function1<? super MatchResult, ? extends CharSequence> transform) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int i5 = 0;
        MatchResult find$default = find$default(this, input, 0, 2, null);
        if (find$default == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(input, i5, find$default.getRange().getStart().intValue());
            sb.append(transform.invoke(find$default));
            i5 = find$default.getRange().getEndInclusive().intValue() + 1;
            find$default = find$default.next();
            if (i5 >= length) {
                break;
            }
        } while (find$default != null);
        if (i5 < length) {
            sb.append(input, i5, length);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Regex(String pattern) {
        this(r2);
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Pattern compile = Pattern.compile(pattern);
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
    }
}
