package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Arrays;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* loaded from: classes3.dex */
public interface JavaClassFinder {
    JavaClass findClass(Request request);

    JavaPackage findPackage(FqName fqName, boolean z5);

    Set<String> knownClassNamesInPackage(FqName fqName);

    /* loaded from: classes3.dex */
    public static final class Request {
        private final ClassId classId;
        private final JavaClass outerClass;
        private final byte[] previouslyFoundClassFileContent;

        public Request(ClassId classId, byte[] bArr, JavaClass javaClass) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            this.classId = classId;
            this.previouslyFoundClassFileContent = bArr;
            this.outerClass = javaClass;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Request)) {
                return false;
            }
            Request request = (Request) obj;
            return Intrinsics.areEqual(this.classId, request.classId) && Intrinsics.areEqual(this.previouslyFoundClassFileContent, request.previouslyFoundClassFileContent) && Intrinsics.areEqual(this.outerClass, request.outerClass);
        }

        public final ClassId getClassId() {
            return this.classId;
        }

        public int hashCode() {
            int hashCode = this.classId.hashCode() * 31;
            byte[] bArr = this.previouslyFoundClassFileContent;
            int hashCode2 = (hashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
            JavaClass javaClass = this.outerClass;
            return hashCode2 + (javaClass != null ? javaClass.hashCode() : 0);
        }

        public String toString() {
            return "Request(classId=" + this.classId + ", previouslyFoundClassFileContent=" + Arrays.toString(this.previouslyFoundClassFileContent) + ", outerClass=" + this.outerClass + ')';
        }

        public /* synthetic */ Request(ClassId classId, byte[] bArr, JavaClass javaClass, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(classId, (i5 & 2) != 0 ? null : bArr, (i5 & 4) != 0 ? null : javaClass);
        }
    }
}
