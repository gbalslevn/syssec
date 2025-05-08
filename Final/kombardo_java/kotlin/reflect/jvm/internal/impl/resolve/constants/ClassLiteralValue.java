package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* loaded from: classes3.dex */
public final class ClassLiteralValue {
    private final int arrayNestedness;
    private final ClassId classId;

    public ClassLiteralValue(ClassId classId, int i5) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        this.classId = classId;
        this.arrayNestedness = i5;
    }

    public final ClassId component1() {
        return this.classId;
    }

    public final int component2() {
        return this.arrayNestedness;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassLiteralValue)) {
            return false;
        }
        ClassLiteralValue classLiteralValue = (ClassLiteralValue) obj;
        return Intrinsics.areEqual(this.classId, classLiteralValue.classId) && this.arrayNestedness == classLiteralValue.arrayNestedness;
    }

    public final int getArrayNestedness() {
        return this.arrayNestedness;
    }

    public final ClassId getClassId() {
        return this.classId;
    }

    public int hashCode() {
        return (this.classId.hashCode() * 31) + Integer.hashCode(this.arrayNestedness);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i5 = this.arrayNestedness;
        for (int i6 = 0; i6 < i5; i6++) {
            sb.append("kotlin/Array<");
        }
        sb.append(this.classId);
        int i7 = this.arrayNestedness;
        for (int i8 = 0; i8 < i7; i8++) {
            sb.append(">");
        }
        return sb.toString();
    }
}
