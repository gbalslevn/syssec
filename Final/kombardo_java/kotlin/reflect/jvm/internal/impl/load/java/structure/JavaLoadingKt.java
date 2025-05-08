package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* loaded from: classes3.dex */
public abstract class JavaLoadingKt {
    private static final boolean isMethodWithOneObjectParameter(JavaMethod javaMethod) {
        FqName fqName;
        JavaValueParameter javaValueParameter = (JavaValueParameter) CollectionsKt.singleOrNull((List) javaMethod.getValueParameters());
        JavaType type = javaValueParameter != null ? javaValueParameter.getType() : null;
        JavaClassifierType javaClassifierType = type instanceof JavaClassifierType ? (JavaClassifierType) type : null;
        if (javaClassifierType == null) {
            return false;
        }
        JavaClassifier classifier = javaClassifierType.getClassifier();
        return (classifier instanceof JavaClass) && (fqName = ((JavaClass) classifier).getFqName()) != null && Intrinsics.areEqual(fqName.asString(), "java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
    
        return r3.getValueParameters().isEmpty();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if (r0.equals("toString") != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        if (r0.equals("hashCode") == false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final boolean isObjectMethod(JavaMethod javaMethod) {
        String asString = javaMethod.getName().asString();
        int hashCode = asString.hashCode();
        if (hashCode != -1776922004) {
            if (hashCode != -1295482945) {
                if (hashCode == 147696667) {
                }
            } else if (asString.equals("equals")) {
                return isMethodWithOneObjectParameter(javaMethod);
            }
            return false;
        }
    }

    public static final boolean isObjectMethodInInterface(JavaMember javaMember) {
        Intrinsics.checkNotNullParameter(javaMember, "<this>");
        return javaMember.getContainingClass().isInterface() && (javaMember instanceof JavaMethod) && isObjectMethod((JavaMethod) javaMember);
    }
}
