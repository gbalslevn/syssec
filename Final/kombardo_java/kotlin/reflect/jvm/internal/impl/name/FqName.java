package kotlin.reflect.jvm.internal.impl.name;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* loaded from: classes3.dex */
public final class FqName {
    public static final Companion Companion = new Companion(null);
    public static final FqName ROOT = new FqName(BuildConfig.FLAVOR);
    private final FqNameUnsafe fqName;
    private transient FqName parent;

    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FqName topLevel(Name shortName) {
            Intrinsics.checkNotNullParameter(shortName, "shortName");
            return new FqName(FqNameUnsafe.Companion.topLevel(shortName));
        }

        private Companion() {
        }
    }

    public FqName(String fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        this.fqName = new FqNameUnsafe(fqName, this);
    }

    public final String asString() {
        return this.fqName.asString();
    }

    public final FqName child(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new FqName(this.fqName.child(name), this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FqName) && Intrinsics.areEqual(this.fqName, ((FqName) obj).fqName);
    }

    public int hashCode() {
        return this.fqName.hashCode();
    }

    public final boolean isRoot() {
        return this.fqName.isRoot();
    }

    public final FqName parent() {
        FqName fqName = this.parent;
        if (fqName != null) {
            return fqName;
        }
        if (isRoot()) {
            throw new IllegalStateException("root");
        }
        FqName fqName2 = new FqName(this.fqName.parent());
        this.parent = fqName2;
        return fqName2;
    }

    public final List<Name> pathSegments() {
        return this.fqName.pathSegments();
    }

    public final Name shortName() {
        return this.fqName.shortName();
    }

    public final Name shortNameOrSpecial() {
        return this.fqName.shortNameOrSpecial();
    }

    public final boolean startsWith(Name segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        return this.fqName.startsWith(segment);
    }

    public String toString() {
        return this.fqName.toString();
    }

    public final FqNameUnsafe toUnsafe() {
        return this.fqName;
    }

    public FqName(FqNameUnsafe fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        this.fqName = fqName;
    }

    private FqName(FqNameUnsafe fqNameUnsafe, FqName fqName) {
        this.fqName = fqNameUnsafe;
        this.parent = fqName;
    }
}
