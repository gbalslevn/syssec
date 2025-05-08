package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ReflectClassStructure {
    public static final ReflectClassStructure INSTANCE = new ReflectClassStructure();

    private ReflectClassStructure() {
    }

    private final ClassLiteralValue classLiteralValue(Class<?> cls) {
        int i5 = 0;
        while (cls.isArray()) {
            i5++;
            cls = cls.getComponentType();
        }
        if (cls.isPrimitive()) {
            if (Intrinsics.areEqual(cls, Void.TYPE)) {
                return new ClassLiteralValue(ClassId.Companion.topLevel(StandardNames.FqNames.unit.toSafe()), i5);
            }
            PrimitiveType primitiveType = JvmPrimitiveType.get(cls.getName()).getPrimitiveType();
            Intrinsics.checkNotNullExpressionValue(primitiveType, "getPrimitiveType(...)");
            return i5 > 0 ? new ClassLiteralValue(ClassId.Companion.topLevel(primitiveType.getArrayTypeFqName()), i5 - 1) : new ClassLiteralValue(ClassId.Companion.topLevel(primitiveType.getTypeFqName()), i5);
        }
        ClassId classId = ReflectClassUtilKt.getClassId(cls);
        ClassId mapJavaToKotlin = JavaToKotlinClassMap.INSTANCE.mapJavaToKotlin(classId.asSingleFqName());
        if (mapJavaToKotlin != null) {
            classId = mapJavaToKotlin;
        }
        return new ClassLiteralValue(classId, i5);
    }

    private final void loadConstructorAnnotations(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Iterator it = ArrayIteratorKt.iterator(cls.getDeclaredConstructors());
        while (it.hasNext()) {
            Constructor<?> constructor = (Constructor) it.next();
            Name name = SpecialNames.INIT;
            SignatureSerializer signatureSerializer = SignatureSerializer.INSTANCE;
            Intrinsics.checkNotNull(constructor);
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod = memberVisitor.visitMethod(name, signatureSerializer.constructorDesc(constructor));
            if (visitMethod != null) {
                Iterator it2 = ArrayIteratorKt.iterator(constructor.getDeclaredAnnotations());
                while (it2.hasNext()) {
                    Annotation annotation = (Annotation) it2.next();
                    Intrinsics.checkNotNull(annotation);
                    processAnnotation(visitMethod, annotation);
                }
                Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                Intrinsics.checkNotNull(parameterAnnotations);
                if (!(parameterAnnotations.length == 0)) {
                    int length = constructor.getParameterTypes().length - parameterAnnotations.length;
                    int length2 = parameterAnnotations.length;
                    for (int i5 = 0; i5 < length2; i5++) {
                        Iterator it3 = ArrayIteratorKt.iterator(parameterAnnotations[i5]);
                        while (it3.hasNext()) {
                            Annotation annotation2 = (Annotation) it3.next();
                            Class<?> javaClass = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation2));
                            ClassId classId = ReflectClassUtilKt.getClassId(javaClass);
                            Intrinsics.checkNotNull(annotation2);
                            KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation = visitMethod.visitParameterAnnotation(i5 + length, classId, new ReflectAnnotationSource(annotation2));
                            if (visitParameterAnnotation != null) {
                                INSTANCE.processAnnotationArguments(visitParameterAnnotation, annotation2, javaClass);
                            }
                        }
                    }
                }
                visitMethod.visitEnd();
            }
        }
    }

    private final void loadFieldAnnotations(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Iterator it = ArrayIteratorKt.iterator(cls.getDeclaredFields());
        while (it.hasNext()) {
            Field field = (Field) it.next();
            Name identifier = Name.identifier(field.getName());
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
            SignatureSerializer signatureSerializer = SignatureSerializer.INSTANCE;
            Intrinsics.checkNotNull(field);
            KotlinJvmBinaryClass.AnnotationVisitor visitField = memberVisitor.visitField(identifier, signatureSerializer.fieldDesc(field), null);
            if (visitField != null) {
                Iterator it2 = ArrayIteratorKt.iterator(field.getDeclaredAnnotations());
                while (it2.hasNext()) {
                    Annotation annotation = (Annotation) it2.next();
                    Intrinsics.checkNotNull(annotation);
                    processAnnotation(visitField, annotation);
                }
                visitField.visitEnd();
            }
        }
    }

    private final void loadMethodAnnotations(Class<?> cls, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Iterator it = ArrayIteratorKt.iterator(cls.getDeclaredMethods());
        while (it.hasNext()) {
            Method method = (Method) it.next();
            Name identifier = Name.identifier(method.getName());
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
            SignatureSerializer signatureSerializer = SignatureSerializer.INSTANCE;
            Intrinsics.checkNotNull(method);
            KotlinJvmBinaryClass.MethodAnnotationVisitor visitMethod = memberVisitor.visitMethod(identifier, signatureSerializer.methodDesc(method));
            if (visitMethod != null) {
                Iterator it2 = ArrayIteratorKt.iterator(method.getDeclaredAnnotations());
                while (it2.hasNext()) {
                    Annotation annotation = (Annotation) it2.next();
                    Intrinsics.checkNotNull(annotation);
                    processAnnotation(visitMethod, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                Intrinsics.checkNotNullExpressionValue(parameterAnnotations, "getParameterAnnotations(...)");
                Annotation[][] annotationArr = parameterAnnotations;
                int length = annotationArr.length;
                for (int i5 = 0; i5 < length; i5++) {
                    Iterator it3 = ArrayIteratorKt.iterator(annotationArr[i5]);
                    while (it3.hasNext()) {
                        Annotation annotation2 = (Annotation) it3.next();
                        Class<?> javaClass = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation2));
                        ClassId classId = ReflectClassUtilKt.getClassId(javaClass);
                        Intrinsics.checkNotNull(annotation2);
                        KotlinJvmBinaryClass.AnnotationArgumentVisitor visitParameterAnnotation = visitMethod.visitParameterAnnotation(i5, classId, new ReflectAnnotationSource(annotation2));
                        if (visitParameterAnnotation != null) {
                            INSTANCE.processAnnotationArguments(visitParameterAnnotation, annotation2, javaClass);
                        }
                    }
                }
                visitMethod.visitEnd();
            }
        }
    }

    private final void processAnnotation(KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor, Annotation annotation) {
        Class<?> javaClass = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation));
        KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation = annotationVisitor.visitAnnotation(ReflectClassUtilKt.getClassId(javaClass), new ReflectAnnotationSource(annotation));
        if (visitAnnotation != null) {
            INSTANCE.processAnnotationArguments(visitAnnotation, annotation, javaClass);
        }
    }

    private final void processAnnotationArgumentValue(KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, Name name, Object obj) {
        Set set;
        Class<?> cls = obj.getClass();
        if (Intrinsics.areEqual(cls, Class.class)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Class<*>");
            annotationArgumentVisitor.visitClassLiteral(name, classLiteralValue((Class) obj));
            return;
        }
        set = ReflectKotlinClassKt.TYPES_ELIGIBLE_FOR_SIMPLE_VISIT;
        if (set.contains(cls)) {
            annotationArgumentVisitor.visit(name, obj);
            return;
        }
        if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(cls)) {
            if (!cls.isEnum()) {
                cls = cls.getEnclosingClass();
            }
            Intrinsics.checkNotNull(cls);
            ClassId classId = ReflectClassUtilKt.getClassId(cls);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Enum<*>");
            Name identifier = Name.identifier(((Enum) obj).name());
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
            annotationArgumentVisitor.visitEnum(name, classId, identifier);
            return;
        }
        if (Annotation.class.isAssignableFrom(cls)) {
            Class<?>[] interfaces = cls.getInterfaces();
            Intrinsics.checkNotNullExpressionValue(interfaces, "getInterfaces(...)");
            Class<?> cls2 = (Class) ArraysKt.single(interfaces);
            Intrinsics.checkNotNull(cls2);
            KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation = annotationArgumentVisitor.visitAnnotation(name, ReflectClassUtilKt.getClassId(cls2));
            if (visitAnnotation == null) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Annotation");
            processAnnotationArguments(visitAnnotation, (Annotation) obj, cls2);
            return;
        }
        if (!cls.isArray()) {
            throw new UnsupportedOperationException("Unsupported annotation argument value (" + cls + "): " + obj);
        }
        KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor visitArray = annotationArgumentVisitor.visitArray(name);
        if (visitArray == null) {
            return;
        }
        Class<?> componentType = cls.getComponentType();
        int i5 = 0;
        if (componentType.isEnum()) {
            Intrinsics.checkNotNull(componentType);
            ClassId classId2 = ReflectClassUtilKt.getClassId(componentType);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            while (i5 < length) {
                Object obj2 = objArr[i5];
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Enum<*>");
                Name identifier2 = Name.identifier(((Enum) obj2).name());
                Intrinsics.checkNotNullExpressionValue(identifier2, "identifier(...)");
                visitArray.visitEnum(classId2, identifier2);
                i5++;
            }
        } else if (Intrinsics.areEqual(componentType, Class.class)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
            Object[] objArr2 = (Object[]) obj;
            int length2 = objArr2.length;
            while (i5 < length2) {
                Object obj3 = objArr2[i5];
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type java.lang.Class<*>");
                visitArray.visitClassLiteral(classLiteralValue((Class) obj3));
                i5++;
            }
        } else if (Annotation.class.isAssignableFrom(componentType)) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
            Object[] objArr3 = (Object[]) obj;
            int length3 = objArr3.length;
            while (i5 < length3) {
                Object obj4 = objArr3[i5];
                Intrinsics.checkNotNull(componentType);
                KotlinJvmBinaryClass.AnnotationArgumentVisitor visitAnnotation2 = visitArray.visitAnnotation(ReflectClassUtilKt.getClassId(componentType));
                if (visitAnnotation2 != null) {
                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Annotation");
                    processAnnotationArguments(visitAnnotation2, (Annotation) obj4, componentType);
                }
                i5++;
            }
        } else {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<*>");
            Object[] objArr4 = (Object[]) obj;
            int length4 = objArr4.length;
            while (i5 < length4) {
                visitArray.visit(objArr4[i5]);
                i5++;
            }
        }
        visitArray.visitEnd();
    }

    private final void processAnnotationArguments(KotlinJvmBinaryClass.AnnotationArgumentVisitor annotationArgumentVisitor, Annotation annotation, Class<?> cls) {
        Iterator it = ArrayIteratorKt.iterator(cls.getDeclaredMethods());
        while (it.hasNext()) {
            Method method = (Method) it.next();
            try {
                Object invoke = method.invoke(annotation, null);
                Intrinsics.checkNotNull(invoke);
                Name identifier = Name.identifier(method.getName());
                Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
                processAnnotationArgumentValue(annotationArgumentVisitor, identifier, invoke);
            } catch (IllegalAccessException unused) {
            }
        }
        annotationArgumentVisitor.visitEnd();
    }

    public final void loadClassAnnotations(Class<?> klass, KotlinJvmBinaryClass.AnnotationVisitor visitor) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        Iterator it = ArrayIteratorKt.iterator(klass.getDeclaredAnnotations());
        while (it.hasNext()) {
            Annotation annotation = (Annotation) it.next();
            Intrinsics.checkNotNull(annotation);
            processAnnotation(visitor, annotation);
        }
        visitor.visitEnd();
    }

    public final void visitMembers(Class<?> klass, KotlinJvmBinaryClass.MemberVisitor memberVisitor) {
        Intrinsics.checkNotNullParameter(klass, "klass");
        Intrinsics.checkNotNullParameter(memberVisitor, "memberVisitor");
        loadMethodAnnotations(klass, memberVisitor);
        loadConstructorAnnotations(klass, memberVisitor);
        loadFieldAnnotations(klass, memberVisitor);
    }
}
