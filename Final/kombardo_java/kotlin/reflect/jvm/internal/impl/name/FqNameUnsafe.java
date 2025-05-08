package kotlin.reflect.jvm.internal.impl.name;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public final class FqNameUnsafe {
    public static final Companion Companion = new Companion(null);
    private static final Name ROOT_NAME;
    private static final Pattern SPLIT_BY_DOTS;
    private final String fqName;
    private transient FqNameUnsafe parent;
    private transient FqName safe;
    private transient Name shortName;

    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FqNameUnsafe topLevel(Name shortName) {
            Intrinsics.checkNotNullParameter(shortName, "shortName");
            String asString = shortName.asString();
            Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
            return new FqNameUnsafe(asString, FqName.ROOT.toUnsafe(), shortName, null);
        }

        private Companion() {
        }
    }

    static {
        Name special = Name.special("<root>");
        Intrinsics.checkNotNullExpressionValue(special, "special(...)");
        ROOT_NAME = special;
        Pattern compile = Pattern.compile("\\.");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        SPLIT_BY_DOTS = compile;
    }

    public /* synthetic */ FqNameUnsafe(String str, FqNameUnsafe fqNameUnsafe, Name name, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, fqNameUnsafe, name);
    }

    private final void compute() {
        int indexOfLastDotWithBackticksSupport = indexOfLastDotWithBackticksSupport(this.fqName);
        if (indexOfLastDotWithBackticksSupport < 0) {
            this.shortName = Name.guessByFirstCharacter(this.fqName);
            this.parent = FqName.ROOT.toUnsafe();
            return;
        }
        String substring = this.fqName.substring(indexOfLastDotWithBackticksSupport + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        this.shortName = Name.guessByFirstCharacter(substring);
        String substring2 = this.fqName.substring(0, indexOfLastDotWithBackticksSupport);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        this.parent = new FqNameUnsafe(substring2);
    }

    private final int indexOfLastDotWithBackticksSupport(String str) {
        int length = str.length() - 1;
        boolean z5 = false;
        while (length >= 0) {
            char charAt = str.charAt(length);
            if (charAt == '.' && !z5) {
                return length;
            }
            if (charAt == '`') {
                z5 = !z5;
            } else if (charAt == '\\') {
                length--;
            }
            length--;
        }
        return -1;
    }

    private static final List<Name> pathSegments$collectSegmentsOf(FqNameUnsafe fqNameUnsafe) {
        if (fqNameUnsafe.isRoot()) {
            return new ArrayList();
        }
        List<Name> pathSegments$collectSegmentsOf = pathSegments$collectSegmentsOf(fqNameUnsafe.parent());
        pathSegments$collectSegmentsOf.add(fqNameUnsafe.shortName());
        return pathSegments$collectSegmentsOf;
    }

    public final String asString() {
        return this.fqName;
    }

    public final FqNameUnsafe child(Name name) {
        String str;
        Intrinsics.checkNotNullParameter(name, "name");
        if (isRoot()) {
            str = name.asString();
        } else {
            str = this.fqName + '.' + name.asString();
        }
        Intrinsics.checkNotNull(str);
        return new FqNameUnsafe(str, this, name);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FqNameUnsafe) && Intrinsics.areEqual(this.fqName, ((FqNameUnsafe) obj).fqName);
    }

    public int hashCode() {
        return this.fqName.hashCode();
    }

    public final boolean isRoot() {
        return this.fqName.length() == 0;
    }

    public final boolean isSafe() {
        return this.safe != null || StringsKt.indexOf$default((CharSequence) asString(), '<', 0, false, 6, (Object) null) < 0;
    }

    public final FqNameUnsafe parent() {
        FqNameUnsafe fqNameUnsafe = this.parent;
        if (fqNameUnsafe != null) {
            return fqNameUnsafe;
        }
        if (isRoot()) {
            throw new IllegalStateException("root");
        }
        compute();
        FqNameUnsafe fqNameUnsafe2 = this.parent;
        Intrinsics.checkNotNull(fqNameUnsafe2);
        return fqNameUnsafe2;
    }

    public final List<Name> pathSegments() {
        return pathSegments$collectSegmentsOf(this);
    }

    public final Name shortName() {
        Name name = this.shortName;
        if (name != null) {
            return name;
        }
        if (isRoot()) {
            throw new IllegalStateException("root");
        }
        compute();
        Name name2 = this.shortName;
        Intrinsics.checkNotNull(name2);
        return name2;
    }

    public final Name shortNameOrSpecial() {
        return isRoot() ? ROOT_NAME : shortName();
    }

    public final boolean startsWith(Name segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        if (isRoot()) {
            return false;
        }
        int indexOf$default = StringsKt.indexOf$default((CharSequence) this.fqName, '.', 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            indexOf$default = this.fqName.length();
        }
        int i5 = indexOf$default;
        String asString = segment.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        return i5 == asString.length() && StringsKt.regionMatches$default(this.fqName, 0, asString, 0, i5, false, 16, null);
    }

    public final FqName toSafe() {
        FqName fqName = this.safe;
        if (fqName != null) {
            return fqName;
        }
        FqName fqName2 = new FqName(this);
        this.safe = fqName2;
        return fqName2;
    }

    public String toString() {
        if (!isRoot()) {
            return this.fqName;
        }
        String asString = ROOT_NAME.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        return asString;
    }

    public FqNameUnsafe(String fqName, FqName safe) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(safe, "safe");
        this.fqName = fqName;
        this.safe = safe;
    }

    public FqNameUnsafe(String fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        this.fqName = fqName;
    }

    private FqNameUnsafe(String str, FqNameUnsafe fqNameUnsafe, Name name) {
        this.fqName = str;
        this.parent = fqNameUnsafe;
        this.shortName = name;
    }
}
