package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;

/* loaded from: classes3.dex */
public final class ClassDeserializer {
    private final Function1<ClassKey, ClassDescriptor> classes;
    private final DeserializationComponents components;
    public static final Companion Companion = new Companion(null);
    private static final Set<ClassId> BLACK_LIST = SetsKt.setOf(ClassId.Companion.topLevel(StandardNames.FqNames.cloneable.toSafe()));

    /* loaded from: classes3.dex */
    public static final class ClassKey {
        private final ClassData classData;
        private final ClassId classId;

        public ClassKey(ClassId classId, ClassData classData) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            this.classId = classId;
            this.classData = classData;
        }

        public boolean equals(Object obj) {
            return (obj instanceof ClassKey) && Intrinsics.areEqual(this.classId, ((ClassKey) obj).classId);
        }

        public final ClassData getClassData() {
            return this.classData;
        }

        public final ClassId getClassId() {
            return this.classId;
        }

        public int hashCode() {
            return this.classId.hashCode();
        }
    }

    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set<ClassId> getBLACK_LIST() {
            return ClassDeserializer.BLACK_LIST;
        }

        private Companion() {
        }
    }

    public ClassDeserializer(DeserializationComponents components) {
        Intrinsics.checkNotNullParameter(components, "components");
        this.components = components;
        this.classes = components.getStorageManager().createMemoizedFunctionWithNullableValues(new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer$$Lambda$0
            private final ClassDeserializer arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                ClassDescriptor classes$lambda$0;
                classes$lambda$0 = ClassDeserializer.classes$lambda$0(this.arg$0, (ClassDeserializer.ClassKey) obj);
                return classes$lambda$0;
            }
        });
    }

    public static final ClassDescriptor classes$lambda$0(ClassDeserializer classDeserializer, ClassKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return classDeserializer.createClass(key);
    }

    private final ClassDescriptor createClass(ClassKey classKey) {
        Object obj;
        DeserializationContext createContext;
        ClassId classId = classKey.getClassId();
        Iterator<ClassDescriptorFactory> it = this.components.getFictitiousClassDescriptorFactories().iterator();
        while (it.hasNext()) {
            ClassDescriptor createClass = it.next().createClass(classId);
            if (createClass != null) {
                return createClass;
            }
        }
        if (BLACK_LIST.contains(classId)) {
            return null;
        }
        ClassData classData = classKey.getClassData();
        if (classData == null && (classData = this.components.getClassDataFinder().findClassData(classId)) == null) {
            return null;
        }
        NameResolver component1 = classData.component1();
        ProtoBuf$Class component2 = classData.component2();
        BinaryVersion component3 = classData.component3();
        SourceElement component4 = classData.component4();
        ClassId outerClassId = classId.getOuterClassId();
        if (outerClassId != null) {
            ClassDescriptor deserializeClass$default = deserializeClass$default(this, outerClassId, null, 2, null);
            DeserializedClassDescriptor deserializedClassDescriptor = deserializeClass$default instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) deserializeClass$default : null;
            if (deserializedClassDescriptor == null || !deserializedClassDescriptor.hasNestedClass$deserialization(classId.getShortClassName())) {
                return null;
            }
            createContext = deserializedClassDescriptor.getC();
        } else {
            Iterator<T> it2 = PackageFragmentProviderKt.packageFragments(this.components.getPackageFragmentProvider(), classId.getPackageFqName()).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                PackageFragmentDescriptor packageFragmentDescriptor = (PackageFragmentDescriptor) obj;
                if (!(packageFragmentDescriptor instanceof DeserializedPackageFragment) || ((DeserializedPackageFragment) packageFragmentDescriptor).hasTopLevelClass(classId.getShortClassName())) {
                    break;
                }
            }
            PackageFragmentDescriptor packageFragmentDescriptor2 = (PackageFragmentDescriptor) obj;
            if (packageFragmentDescriptor2 == null) {
                return null;
            }
            DeserializationComponents deserializationComponents = this.components;
            ProtoBuf$TypeTable typeTable = component2.getTypeTable();
            Intrinsics.checkNotNullExpressionValue(typeTable, "getTypeTable(...)");
            TypeTable typeTable2 = new TypeTable(typeTable);
            VersionRequirementTable.Companion companion = VersionRequirementTable.Companion;
            ProtoBuf$VersionRequirementTable versionRequirementTable = component2.getVersionRequirementTable();
            Intrinsics.checkNotNullExpressionValue(versionRequirementTable, "getVersionRequirementTable(...)");
            createContext = deserializationComponents.createContext(packageFragmentDescriptor2, component1, typeTable2, companion.create(versionRequirementTable), component3, null);
        }
        return new DeserializedClassDescriptor(createContext, component2, component1, component3, component4);
    }

    public static /* synthetic */ ClassDescriptor deserializeClass$default(ClassDeserializer classDeserializer, ClassId classId, ClassData classData, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            classData = null;
        }
        return classDeserializer.deserializeClass(classId, classData);
    }

    public final ClassDescriptor deserializeClass(ClassId classId, ClassData classData) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        return this.classes.invoke(new ClassKey(classId, classData));
    }
}
