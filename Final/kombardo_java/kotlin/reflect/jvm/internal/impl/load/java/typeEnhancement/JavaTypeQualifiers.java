package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes3.dex */
public final class JavaTypeQualifiers {
    public static final Companion Companion = new Companion(null);
    private static final JavaTypeQualifiers NONE = new JavaTypeQualifiers(null, null, false, false, 8, null);
    private final boolean definitelyNotNull;
    private final boolean isNullabilityQualifierForWarning;
    private final MutabilityQualifier mutability;
    private final NullabilityQualifier nullability;

    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final JavaTypeQualifiers getNONE() {
            return JavaTypeQualifiers.NONE;
        }

        private Companion() {
        }
    }

    public JavaTypeQualifiers(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z5, boolean z6) {
        this.nullability = nullabilityQualifier;
        this.mutability = mutabilityQualifier;
        this.definitelyNotNull = z5;
        this.isNullabilityQualifierForWarning = z6;
    }

    public static /* synthetic */ JavaTypeQualifiers copy$default(JavaTypeQualifiers javaTypeQualifiers, NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z5, boolean z6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            nullabilityQualifier = javaTypeQualifiers.nullability;
        }
        if ((i5 & 2) != 0) {
            mutabilityQualifier = javaTypeQualifiers.mutability;
        }
        if ((i5 & 4) != 0) {
            z5 = javaTypeQualifiers.definitelyNotNull;
        }
        if ((i5 & 8) != 0) {
            z6 = javaTypeQualifiers.isNullabilityQualifierForWarning;
        }
        return javaTypeQualifiers.copy(nullabilityQualifier, mutabilityQualifier, z5, z6);
    }

    public final JavaTypeQualifiers copy(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z5, boolean z6) {
        return new JavaTypeQualifiers(nullabilityQualifier, mutabilityQualifier, z5, z6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JavaTypeQualifiers)) {
            return false;
        }
        JavaTypeQualifiers javaTypeQualifiers = (JavaTypeQualifiers) obj;
        return this.nullability == javaTypeQualifiers.nullability && this.mutability == javaTypeQualifiers.mutability && this.definitelyNotNull == javaTypeQualifiers.definitelyNotNull && this.isNullabilityQualifierForWarning == javaTypeQualifiers.isNullabilityQualifierForWarning;
    }

    public final boolean getDefinitelyNotNull() {
        return this.definitelyNotNull;
    }

    public final MutabilityQualifier getMutability() {
        return this.mutability;
    }

    public final NullabilityQualifier getNullability() {
        return this.nullability;
    }

    public int hashCode() {
        NullabilityQualifier nullabilityQualifier = this.nullability;
        int hashCode = (nullabilityQualifier == null ? 0 : nullabilityQualifier.hashCode()) * 31;
        MutabilityQualifier mutabilityQualifier = this.mutability;
        return ((((hashCode + (mutabilityQualifier != null ? mutabilityQualifier.hashCode() : 0)) * 31) + Boolean.hashCode(this.definitelyNotNull)) * 31) + Boolean.hashCode(this.isNullabilityQualifierForWarning);
    }

    public final boolean isNullabilityQualifierForWarning() {
        return this.isNullabilityQualifierForWarning;
    }

    public String toString() {
        return "JavaTypeQualifiers(nullability=" + this.nullability + ", mutability=" + this.mutability + ", definitelyNotNull=" + this.definitelyNotNull + ", isNullabilityQualifierForWarning=" + this.isNullabilityQualifierForWarning + ')';
    }

    public /* synthetic */ JavaTypeQualifiers(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z5, boolean z6, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(nullabilityQualifier, mutabilityQualifier, z5, (i5 & 8) != 0 ? false : z6);
    }
}
