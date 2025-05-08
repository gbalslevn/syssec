package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

/* loaded from: classes3.dex */
public final class ClassId {
    public static final Companion Companion = new Companion(null);
    private final boolean isLocal;
    private final FqName packageFqName;
    private final FqName relativeClassName;

    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ClassId fromString$default(Companion companion, String str, boolean z5, int i5, Object obj) {
            if ((i5 & 2) != 0) {
                z5 = false;
            }
            return companion.fromString(str, z5);
        }

        public final ClassId fromString(String string, boolean z5) {
            String replace$default;
            String str;
            Intrinsics.checkNotNullParameter(string, "string");
            int indexOf$default = StringsKt.indexOf$default((CharSequence) string, '`', 0, false, 6, (Object) null);
            if (indexOf$default == -1) {
                indexOf$default = string.length();
            }
            int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) string, "/", indexOf$default, false, 4, (Object) null);
            if (lastIndexOf$default == -1) {
                replace$default = StringsKt.replace$default(string, "`", BuildConfig.FLAVOR, false, 4, (Object) null);
                str = BuildConfig.FLAVOR;
            } else {
                String substring = string.substring(0, lastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                String replace$default2 = StringsKt.replace$default(substring, '/', '.', false, 4, (Object) null);
                String substring2 = string.substring(lastIndexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                replace$default = StringsKt.replace$default(substring2, "`", BuildConfig.FLAVOR, false, 4, (Object) null);
                str = replace$default2;
            }
            return new ClassId(new FqName(str), new FqName(replace$default), z5);
        }

        public final ClassId topLevel(FqName topLevelFqName) {
            Intrinsics.checkNotNullParameter(topLevelFqName, "topLevelFqName");
            return new ClassId(topLevelFqName.parent(), topLevelFqName.shortName());
        }

        private Companion() {
        }
    }

    public ClassId(FqName packageFqName, FqName relativeClassName, boolean z5) {
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(relativeClassName, "relativeClassName");
        this.packageFqName = packageFqName;
        this.relativeClassName = relativeClassName;
        this.isLocal = z5;
        relativeClassName.isRoot();
    }

    private static final String asString$escapeSlashes(FqName fqName) {
        String asString = fqName.asString();
        if (!StringsKt.contains$default((CharSequence) asString, '/', false, 2, (Object) null)) {
            return asString;
        }
        return '`' + asString + '`';
    }

    public static final ClassId topLevel(FqName fqName) {
        return Companion.topLevel(fqName);
    }

    public final FqName asSingleFqName() {
        if (this.packageFqName.isRoot()) {
            return this.relativeClassName;
        }
        return new FqName(this.packageFqName.asString() + '.' + this.relativeClassName.asString());
    }

    public final String asString() {
        if (this.packageFqName.isRoot()) {
            return asString$escapeSlashes(this.relativeClassName);
        }
        return StringsKt.replace$default(this.packageFqName.asString(), '.', '/', false, 4, (Object) null) + "/" + asString$escapeSlashes(this.relativeClassName);
    }

    public final ClassId createNestedClassId(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ClassId(this.packageFqName, this.relativeClassName.child(name), this.isLocal);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassId)) {
            return false;
        }
        ClassId classId = (ClassId) obj;
        return Intrinsics.areEqual(this.packageFqName, classId.packageFqName) && Intrinsics.areEqual(this.relativeClassName, classId.relativeClassName) && this.isLocal == classId.isLocal;
    }

    public final ClassId getOuterClassId() {
        FqName parent = this.relativeClassName.parent();
        if (parent.isRoot()) {
            return null;
        }
        return new ClassId(this.packageFqName, parent, this.isLocal);
    }

    public final FqName getPackageFqName() {
        return this.packageFqName;
    }

    public final FqName getRelativeClassName() {
        return this.relativeClassName;
    }

    public final Name getShortClassName() {
        return this.relativeClassName.shortName();
    }

    public int hashCode() {
        return (((this.packageFqName.hashCode() * 31) + this.relativeClassName.hashCode()) * 31) + Boolean.hashCode(this.isLocal);
    }

    public final boolean isLocal() {
        return this.isLocal;
    }

    public final boolean isNestedClass() {
        return !this.relativeClassName.parent().isRoot();
    }

    public String toString() {
        if (!this.packageFqName.isRoot()) {
            return asString();
        }
        return '/' + asString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ClassId(FqName packageFqName, Name topLevelName) {
        this(packageFqName, FqName.Companion.topLevel(topLevelName), false);
        Intrinsics.checkNotNullParameter(packageFqName, "packageFqName");
        Intrinsics.checkNotNullParameter(topLevelName, "topLevelName");
    }
}
