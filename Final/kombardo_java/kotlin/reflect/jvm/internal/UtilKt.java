package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference;
import kotlin.jvm.internal.RepeatableContainer;
import kotlin.reflect.KCallable;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectAnnotationSource;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeModuleData;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.RuntimeSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotation;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinarySourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.TypedArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a/\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a5\u0010\n\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000f\u001a\u001b\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0001*\u0006\u0012\u0002\b\u00030\u0001H\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0019\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013*\u00020\u0012H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013*\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0014*\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a!\u0010\u001e\u001a\u0004\u0018\u00010\u001d*\u0006\u0012\u0002\b\u00030\u001c2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001d\u0010!\u001a\u0004\u0018\u00010\u001d*\u00020 2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\"\u001a\u0017\u0010$\u001a\u0004\u0018\u00010#*\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0004\b$\u0010%\u001a\u001b\u0010'\u001a\b\u0012\u0002\b\u0003\u0018\u00010&*\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0004\b'\u0010(\u001a\u001b\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010)*\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0004\b*\u0010+\u001a\u0019\u0010.\u001a\u0004\u0018\u00010\u001d2\u0006\u0010-\u001a\u00020,H\u0000¢\u0006\u0004\b.\u0010/\u001a'\u00103\u001a\u00028\u0000\"\u0004\b\u0000\u001002\f\u00102\u001a\b\u0012\u0004\u0012\u00028\u000001H\u0080\bø\u0001\u0000¢\u0006\u0004\b3\u00104\u001ai\u0010D\u001a\u00028\u0001\"\b\b\u0000\u00106*\u000205\"\b\b\u0001\u00108*\u0002072\n\u00109\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010:\u001a\u00028\u00002\u0006\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020=2\u0006\u0010@\u001a\u00020?2\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010AH\u0000¢\u0006\u0004\bD\u0010E\"\u001a\u0010G\u001a\u00020F8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0018\u0010M\u001a\u00020L*\u00020K8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bM\u0010N\"\u0018\u0010P\u001a\u00020L*\u00020K8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bO\u0010N\"\u001a\u0010T\u001a\u0004\u0018\u00010Q*\u0002078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bR\u0010S\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006U"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "Ljava/lang/Class;", "toJavaClass", "(Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;)Ljava/lang/Class;", "Ljava/lang/ClassLoader;", "classLoader", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "kotlinClassId", BuildConfig.FLAVOR, "arrayDimensions", "loadClass", "(Ljava/lang/ClassLoader;Lkotlin/reflect/jvm/internal/impl/name/ClassId;I)Ljava/lang/Class;", BuildConfig.FLAVOR, "packageName", "className", "(Ljava/lang/ClassLoader;Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/Class;", "createArrayType", "(Ljava/lang/Class;)Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "computeAnnotations", "(Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;)Ljava/util/List;", "unwrapRepeatableAnnotations", "(Ljava/util/List;)Ljava/util/List;", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;", "toAnnotationInstance", "(Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;)Ljava/lang/annotation/Annotation;", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;", BuildConfig.FLAVOR, "toRuntimeValue", "(Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;Ljava/lang/ClassLoader;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ArrayValue;", "arrayToRuntimeValue", "(Lkotlin/reflect/jvm/internal/impl/resolve/constants/ArrayValue;Ljava/lang/ClassLoader;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKFunctionImpl", "(Ljava/lang/Object;)Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "asKPropertyImpl", "(Ljava/lang/Object;)Lkotlin/reflect/jvm/internal/KPropertyImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "asKCallableImpl", "(Ljava/lang/Object;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "Ljava/lang/reflect/Type;", "type", "defaultPrimitiveValue", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;", "R", "Lkotlin/Function0;", "block", "reflectionCall", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "M", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "D", "moduleAnchor", "proto", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "metadataVersion", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "createDescriptor", "deserializeToDescriptor", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "Lkotlin/reflect/KType;", BuildConfig.FLAVOR, "isInlineClassType", "(Lkotlin/reflect/KType;)Z", "getNeedsMultiFieldValueClassFlattening", "needsMultiFieldValueClassFlattening", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "instanceReceiverParameter", "kotlin-reflection"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class UtilKt {
    private static final FqName JVM_STATIC = new FqName("kotlin.jvm.JvmStatic");

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PrimitiveType.values().length];
            try {
                iArr[PrimitiveType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrimitiveType.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PrimitiveType.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PrimitiveType.SHORT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PrimitiveType.INT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PrimitiveType.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PrimitiveType.LONG.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PrimitiveType.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Incorrect type for immutable var: ssa=boolean[], code=short[], for r7v12, types: [boolean[]] */
    /* JADX WARN: Incorrect type for immutable var: ssa=byte[], code=short[], for r7v14, types: [byte[]] */
    /* JADX WARN: Incorrect type for immutable var: ssa=char[], code=short[], for r7v13, types: [char[]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.lang.Class[]] */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r7v16, types: [int[]] */
    /* JADX WARN: Type inference failed for: r7v17, types: [float[]] */
    /* JADX WARN: Type inference failed for: r7v18, types: [long[]] */
    /* JADX WARN: Type inference failed for: r7v20, types: [double[]] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final Object arrayToRuntimeValue(ArrayValue arrayValue, ClassLoader classLoader) {
        KotlinType type;
        Class loadClass$default;
        short[] sArr;
        TypedArrayValue typedArrayValue = arrayValue instanceof TypedArrayValue ? (TypedArrayValue) arrayValue : null;
        if (typedArrayValue == null || (type = typedArrayValue.getType()) == null) {
            return null;
        }
        List<? extends ConstantValue<?>> value = arrayValue.getValue();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(value, 10));
        Iterator<T> it = value.iterator();
        while (it.hasNext()) {
            arrayList.add(toRuntimeValue((ConstantValue) it.next(), classLoader));
        }
        PrimitiveType primitiveArrayElementType = KotlinBuiltIns.getPrimitiveArrayElementType(type);
        int i5 = 0;
        switch (primitiveArrayElementType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[primitiveArrayElementType.ordinal()]) {
            case -1:
                if (!KotlinBuiltIns.isArray(type)) {
                    throw new IllegalStateException(("Not an array type: " + type).toString());
                }
                KotlinType type2 = ((TypeProjection) CollectionsKt.single((List) type.getArguments())).getType();
                Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                ClassifierDescriptor mo3718getDeclarationDescriptor = type2.getConstructor().mo3718getDeclarationDescriptor();
                ClassDescriptor classDescriptor = mo3718getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) mo3718getDeclarationDescriptor : null;
                if (classDescriptor == null) {
                    throw new IllegalStateException(("Not a class type: " + type2).toString());
                }
                if (KotlinBuiltIns.isString(type2)) {
                    int size = arrayValue.getValue().size();
                    sArr = new String[size];
                    while (i5 < size) {
                        Object obj = arrayList.get(i5);
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        sArr[i5] = obj;
                        i5++;
                    }
                } else if (KotlinBuiltIns.isKClass(classDescriptor)) {
                    int size2 = arrayValue.getValue().size();
                    sArr = new Class[size2];
                    while (i5 < size2) {
                        Object obj2 = arrayList.get(i5);
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type java.lang.Class<*>");
                        sArr[i5] = obj2;
                        i5++;
                    }
                } else {
                    ClassId classId = DescriptorUtilsKt.getClassId(classDescriptor);
                    if (classId == null || (loadClass$default = loadClass$default(classLoader, classId, 0, 4, null)) == null) {
                        return null;
                    }
                    Object newInstance = Array.newInstance((Class<?>) loadClass$default, arrayValue.getValue().size());
                    Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Array<in kotlin.Any?>");
                    sArr = (Object[]) newInstance;
                    int size3 = arrayList.size();
                    while (i5 < size3) {
                        sArr[i5] = arrayList.get(i5);
                        i5++;
                    }
                }
                return sArr;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                int size4 = arrayValue.getValue().size();
                sArr = new boolean[size4];
                while (i5 < size4) {
                    Object obj3 = arrayList.get(i5);
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                    sArr[i5] = ((Boolean) obj3).booleanValue();
                    i5++;
                }
                return sArr;
            case 2:
                int size5 = arrayValue.getValue().size();
                sArr = new char[size5];
                while (i5 < size5) {
                    Object obj4 = arrayList.get(i5);
                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Char");
                    sArr[i5] = ((Character) obj4).charValue();
                    i5++;
                }
                return sArr;
            case 3:
                int size6 = arrayValue.getValue().size();
                sArr = new byte[size6];
                while (i5 < size6) {
                    Object obj5 = arrayList.get(i5);
                    Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Byte");
                    sArr[i5] = ((Byte) obj5).byteValue();
                    i5++;
                }
                return sArr;
            case 4:
                int size7 = arrayValue.getValue().size();
                sArr = new short[size7];
                while (i5 < size7) {
                    Object obj6 = arrayList.get(i5);
                    Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Short");
                    sArr[i5] = ((Short) obj6).shortValue();
                    i5++;
                }
                return sArr;
            case 5:
                int size8 = arrayValue.getValue().size();
                sArr = new int[size8];
                while (i5 < size8) {
                    Object obj7 = arrayList.get(i5);
                    Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.Int");
                    sArr[i5] = ((Integer) obj7).intValue();
                    i5++;
                }
                return sArr;
            case 6:
                int size9 = arrayValue.getValue().size();
                sArr = new float[size9];
                while (i5 < size9) {
                    Object obj8 = arrayList.get(i5);
                    Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type kotlin.Float");
                    sArr[i5] = ((Float) obj8).floatValue();
                    i5++;
                }
                return sArr;
            case 7:
                int size10 = arrayValue.getValue().size();
                sArr = new long[size10];
                while (i5 < size10) {
                    Object obj9 = arrayList.get(i5);
                    Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type kotlin.Long");
                    sArr[i5] = ((Long) obj9).longValue();
                    i5++;
                }
                return sArr;
            case 8:
                int size11 = arrayValue.getValue().size();
                sArr = new double[size11];
                while (i5 < size11) {
                    Object obj10 = arrayList.get(i5);
                    Intrinsics.checkNotNull(obj10, "null cannot be cast to non-null type kotlin.Double");
                    sArr[i5] = ((Double) obj10).doubleValue();
                    i5++;
                }
                return sArr;
        }
    }

    public static final KCallableImpl<?> asKCallableImpl(Object obj) {
        KCallableImpl<?> kCallableImpl = obj instanceof KCallableImpl ? (KCallableImpl) obj : null;
        if (kCallableImpl != null) {
            return kCallableImpl;
        }
        KFunctionImpl asKFunctionImpl = asKFunctionImpl(obj);
        return asKFunctionImpl != null ? asKFunctionImpl : asKPropertyImpl(obj);
    }

    public static final KFunctionImpl asKFunctionImpl(Object obj) {
        KFunctionImpl kFunctionImpl = obj instanceof KFunctionImpl ? (KFunctionImpl) obj : null;
        if (kFunctionImpl != null) {
            return kFunctionImpl;
        }
        FunctionReference functionReference = obj instanceof FunctionReference ? (FunctionReference) obj : null;
        KCallable compute = functionReference != null ? functionReference.compute() : null;
        if (compute instanceof KFunctionImpl) {
            return (KFunctionImpl) compute;
        }
        return null;
    }

    public static final KPropertyImpl<?> asKPropertyImpl(Object obj) {
        KPropertyImpl<?> kPropertyImpl = obj instanceof KPropertyImpl ? (KPropertyImpl) obj : null;
        if (kPropertyImpl != null) {
            return kPropertyImpl;
        }
        PropertyReference propertyReference = obj instanceof PropertyReference ? (PropertyReference) obj : null;
        KCallable compute = propertyReference != null ? propertyReference.compute() : null;
        if (compute instanceof KPropertyImpl) {
            return (KPropertyImpl) compute;
        }
        return null;
    }

    public static final List<Annotation> computeAnnotations(Annotated annotated) {
        Annotation annotationInstance;
        Intrinsics.checkNotNullParameter(annotated, "<this>");
        Annotations annotations = annotated.getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (AnnotationDescriptor annotationDescriptor : annotations) {
            SourceElement source = annotationDescriptor.getSource();
            if (source instanceof ReflectAnnotationSource) {
                annotationInstance = ((ReflectAnnotationSource) source).getAnnotation();
            } else if (source instanceof RuntimeSourceElementFactory.RuntimeSourceElement) {
                ReflectJavaElement javaElement = ((RuntimeSourceElementFactory.RuntimeSourceElement) source).getJavaElement();
                ReflectJavaAnnotation reflectJavaAnnotation = javaElement instanceof ReflectJavaAnnotation ? (ReflectJavaAnnotation) javaElement : null;
                annotationInstance = reflectJavaAnnotation != null ? reflectJavaAnnotation.getAnnotation() : null;
            } else {
                annotationInstance = toAnnotationInstance(annotationDescriptor);
            }
            if (annotationInstance != null) {
                arrayList.add(annotationInstance);
            }
        }
        return unwrapRepeatableAnnotations(arrayList);
    }

    public static final Class<?> createArrayType(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return Array.newInstance(cls, 0).getClass();
    }

    public static final Object defaultPrimitiveValue(Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isPrimitive()) {
                if (Intrinsics.areEqual(cls, Boolean.TYPE)) {
                    return Boolean.FALSE;
                }
                if (Intrinsics.areEqual(cls, Character.TYPE)) {
                    return (char) 0;
                }
                if (Intrinsics.areEqual(cls, Byte.TYPE)) {
                    return (byte) 0;
                }
                if (Intrinsics.areEqual(cls, Short.TYPE)) {
                    return (short) 0;
                }
                if (Intrinsics.areEqual(cls, Integer.TYPE)) {
                    return 0;
                }
                if (Intrinsics.areEqual(cls, Float.TYPE)) {
                    return Float.valueOf(0.0f);
                }
                if (Intrinsics.areEqual(cls, Long.TYPE)) {
                    return 0L;
                }
                if (Intrinsics.areEqual(cls, Double.TYPE)) {
                    return Double.valueOf(0.0d);
                }
                if (Intrinsics.areEqual(cls, Void.TYPE)) {
                    throw new IllegalStateException("Parameter with void type is illegal");
                }
                throw new UnsupportedOperationException("Unknown primitive: " + type);
            }
        }
        return null;
    }

    public static final <M extends MessageLite, D extends CallableDescriptor> D deserializeToDescriptor(Class<?> moduleAnchor, M proto, NameResolver nameResolver, TypeTable typeTable, BinaryVersion metadataVersion, Function2<? super MemberDeserializer, ? super M, ? extends D> createDescriptor) {
        List<ProtoBuf$TypeParameter> typeParameterList;
        Intrinsics.checkNotNullParameter(moduleAnchor, "moduleAnchor");
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics.checkNotNullParameter(metadataVersion, "metadataVersion");
        Intrinsics.checkNotNullParameter(createDescriptor, "createDescriptor");
        RuntimeModuleData orCreateModule = ModuleByClassLoaderKt.getOrCreateModule(moduleAnchor);
        if (proto instanceof ProtoBuf$Function) {
            typeParameterList = ((ProtoBuf$Function) proto).getTypeParameterList();
        } else {
            if (!(proto instanceof ProtoBuf$Property)) {
                throw new IllegalStateException(("Unsupported message: " + proto).toString());
            }
            typeParameterList = ((ProtoBuf$Property) proto).getTypeParameterList();
        }
        List<ProtoBuf$TypeParameter> list = typeParameterList;
        DeserializationComponents deserialization = orCreateModule.getDeserialization();
        ModuleDescriptor module = orCreateModule.getModule();
        VersionRequirementTable empty = VersionRequirementTable.Companion.getEMPTY();
        Intrinsics.checkNotNull(list);
        return createDescriptor.invoke(new MemberDeserializer(new DeserializationContext(deserialization, nameResolver, module, typeTable, empty, metadataVersion, null, null, list)), proto);
    }

    public static final ReceiverParameterDescriptor getInstanceReceiverParameter(CallableDescriptor callableDescriptor) {
        Intrinsics.checkNotNullParameter(callableDescriptor, "<this>");
        if (callableDescriptor.getDispatchReceiverParameter() == null) {
            return null;
        }
        DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return ((ClassDescriptor) containingDeclaration).getThisAsReceiverParameter();
    }

    public static final FqName getJVM_STATIC() {
        return JVM_STATIC;
    }

    public static final boolean getNeedsMultiFieldValueClassFlattening(KType kType) {
        KotlinType type;
        Intrinsics.checkNotNullParameter(kType, "<this>");
        KTypeImpl kTypeImpl = kType instanceof KTypeImpl ? (KTypeImpl) kType : null;
        return (kTypeImpl == null || (type = kTypeImpl.getType()) == null || !InlineClassesUtilsKt.needsMfvcFlattening(type)) ? false : true;
    }

    public static final boolean isInlineClassType(KType kType) {
        KotlinType type;
        Intrinsics.checkNotNullParameter(kType, "<this>");
        KTypeImpl kTypeImpl = kType instanceof KTypeImpl ? (KTypeImpl) kType : null;
        return (kTypeImpl == null || (type = kTypeImpl.getType()) == null || !InlineClassesUtilsKt.isInlineClassType(type)) ? false : true;
    }

    private static final Class<?> loadClass(ClassLoader classLoader, ClassId classId, int i5) {
        ClassId mapKotlinToJava = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(classId.asSingleFqName().toUnsafe());
        if (mapKotlinToJava != null) {
            classId = mapKotlinToJava;
        }
        return loadClass(classLoader, classId.getPackageFqName().asString(), classId.getRelativeClassName().asString(), i5);
    }

    static /* synthetic */ Class loadClass$default(ClassLoader classLoader, ClassId classId, int i5, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            i5 = 0;
        }
        return loadClass(classLoader, classId, i5);
    }

    private static final Annotation toAnnotationInstance(AnnotationDescriptor annotationDescriptor) {
        ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(annotationDescriptor);
        Class<?> javaClass = annotationClass != null ? toJavaClass(annotationClass) : null;
        if (javaClass == null) {
            javaClass = null;
        }
        if (javaClass == null) {
            return null;
        }
        Set<Map.Entry<Name, ConstantValue<?>>> entrySet = annotationDescriptor.getAllValueArguments().entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Name name = (Name) entry.getKey();
            ConstantValue constantValue = (ConstantValue) entry.getValue();
            ClassLoader classLoader = javaClass.getClassLoader();
            Intrinsics.checkNotNullExpressionValue(classLoader, "getClassLoader(...)");
            Object runtimeValue = toRuntimeValue(constantValue, classLoader);
            Pair pair = runtimeValue != null ? TuplesKt.to(name.asString(), runtimeValue) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return (Annotation) AnnotationConstructorCallerKt.createAnnotationInstance$default(javaClass, MapsKt.toMap(arrayList), null, 4, null);
    }

    public static final Class<?> toJavaClass(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "<this>");
        SourceElement source = classDescriptor.getSource();
        Intrinsics.checkNotNullExpressionValue(source, "getSource(...)");
        if (source instanceof KotlinJvmBinarySourceElement) {
            KotlinJvmBinaryClass binaryClass = ((KotlinJvmBinarySourceElement) source).getBinaryClass();
            Intrinsics.checkNotNull(binaryClass, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
            return ((ReflectKotlinClass) binaryClass).getKlass();
        }
        if (source instanceof RuntimeSourceElementFactory.RuntimeSourceElement) {
            ReflectJavaElement javaElement = ((RuntimeSourceElementFactory.RuntimeSourceElement) source).getJavaElement();
            Intrinsics.checkNotNull(javaElement, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
            return ((ReflectJavaClass) javaElement).getElement();
        }
        ClassId classId = DescriptorUtilsKt.getClassId(classDescriptor);
        if (classId == null) {
            return null;
        }
        return loadClass(ReflectClassUtilKt.getSafeClassLoader(classDescriptor.getClass()), classId, 0);
    }

    private static final Object toRuntimeValue(ConstantValue<?> constantValue, ClassLoader classLoader) {
        if (constantValue instanceof AnnotationValue) {
            return toAnnotationInstance(((AnnotationValue) constantValue).getValue());
        }
        if (constantValue instanceof ArrayValue) {
            return arrayToRuntimeValue((ArrayValue) constantValue, classLoader);
        }
        if (constantValue instanceof EnumValue) {
            Pair<? extends ClassId, ? extends Name> value = ((EnumValue) constantValue).getValue();
            ClassId component1 = value.component1();
            Name component2 = value.component2();
            Class loadClass$default = loadClass$default(classLoader, component1, 0, 4, null);
            if (loadClass$default != null) {
                return Util.getEnumConstantByName(loadClass$default, component2.asString());
            }
        } else if (constantValue instanceof KClassValue) {
            KClassValue.Value value2 = ((KClassValue) constantValue).getValue();
            if (value2 instanceof KClassValue.Value.NormalClass) {
                KClassValue.Value.NormalClass normalClass = (KClassValue.Value.NormalClass) value2;
                return loadClass(classLoader, normalClass.getClassId(), normalClass.getArrayDimensions());
            }
            if (!(value2 instanceof KClassValue.Value.LocalClass)) {
                throw new NoWhenBranchMatchedException();
            }
            ClassifierDescriptor mo3718getDeclarationDescriptor = ((KClassValue.Value.LocalClass) value2).getType().getConstructor().mo3718getDeclarationDescriptor();
            ClassDescriptor classDescriptor = mo3718getDeclarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) mo3718getDeclarationDescriptor : null;
            if (classDescriptor != null) {
                return toJavaClass(classDescriptor);
            }
        } else if (!(constantValue instanceof ErrorValue) && !(constantValue instanceof NullValue)) {
            return constantValue.getValue();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.List<? extends java.lang.annotation.Annotation>] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.Collection, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.List<java.lang.annotation.Annotation>] */
    private static final List<Annotation> unwrapRepeatableAnnotations(List<? extends Annotation> list) {
        List listOf;
        Iterable<Annotation> iterable = (Iterable) list;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (Intrinsics.areEqual(JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass((Annotation) it.next())).getSimpleName(), "Container")) {
                    list = new ArrayList<>();
                    for (Annotation annotation : iterable) {
                        Class javaClass = JvmClassMappingKt.getJavaClass(JvmClassMappingKt.getAnnotationClass(annotation));
                        if (!Intrinsics.areEqual(javaClass.getSimpleName(), "Container") || javaClass.getAnnotation(RepeatableContainer.class) == null) {
                            listOf = CollectionsKt.listOf(annotation);
                        } else {
                            Object invoke = javaClass.getDeclaredMethod("value", null).invoke(annotation, null);
                            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Array<out kotlin.Annotation>");
                            listOf = ArraysKt.asList((Annotation[]) invoke);
                        }
                        CollectionsKt.addAll((Collection) list, listOf);
                    }
                }
            }
        }
        return list;
    }

    private static final Class<?> loadClass(ClassLoader classLoader, String str, String str2, int i5) {
        if (Intrinsics.areEqual(str, "kotlin")) {
            switch (str2.hashCode()) {
                case -901856463:
                    if (str2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (str2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (str2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (str2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (str2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (str2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (str2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (str2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (str2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (i5 > 0) {
            for (int i6 = 0; i6 < i5; i6++) {
                sb.append("[");
            }
            sb.append("L");
        }
        if (str.length() > 0) {
            sb.append(str + '.');
        }
        sb.append(StringsKt.replace$default(str2, '.', '$', false, 4, (Object) null));
        if (i5 > 0) {
            sb.append(";");
        }
        return ReflectJavaClassFinderKt.tryLoadClass(classLoader, sb.toString());
    }
}
