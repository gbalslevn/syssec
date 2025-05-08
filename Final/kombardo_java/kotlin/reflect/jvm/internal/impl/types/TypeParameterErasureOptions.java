package kotlin.reflect.jvm.internal.impl.types;

/* loaded from: classes3.dex */
public final class TypeParameterErasureOptions {
    private final boolean intersectUpperBounds;
    private final boolean leaveNonTypeParameterTypes;

    public TypeParameterErasureOptions(boolean z5, boolean z6) {
        this.leaveNonTypeParameterTypes = z5;
        this.intersectUpperBounds = z6;
    }

    public final boolean getIntersectUpperBounds() {
        return this.intersectUpperBounds;
    }

    public final boolean getLeaveNonTypeParameterTypes() {
        return this.leaveNonTypeParameterTypes;
    }
}
