package kotlin.reflect.jvm.internal;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001-B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010!\u001a\f\u0012\b\u0012\u00060 R\u00020\u00000\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0006\u0012\u0002\b\u00030\u00028TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001eR\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020%0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006."}, d2 = {"Lkotlin/reflect/jvm/internal/KPackageImpl;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Ljava/lang/Class;", "jClass", "<init>", "(Ljava/lang/Class;)V", "Lkotlin/reflect/jvm/internal/impl/name/Name;", "name", BuildConfig.FLAVOR, "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "getProperties", "(Lkotlin/reflect/jvm/internal/impl/name/Name;)Ljava/util/Collection;", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "getFunctions", BuildConfig.FLAVOR, "index", "getLocalProperty", "(I)Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "Lkotlin/Lazy;", "Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "data", "Lkotlin/Lazy;", "getMethodOwner", "methodOwner", "Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;", "getConstructorDescriptors", "()Ljava/util/Collection;", "constructorDescriptors", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "scope", "Data", "kotlin-reflection"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KPackageImpl extends KDeclarationContainerImpl {
    private final Lazy<Data> data;
    private final Class<?> jClass;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u001d\u0010\n\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\u000f\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\u000eR!\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R/\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u001cR%\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001f0\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0007\u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lkotlin/reflect/jvm/internal/KPackageImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "<init>", "(Lkotlin/reflect/jvm/internal/KPackageImpl;)V", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/ReflectKotlinClass;", "kotlinClass$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getKotlinClass", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;", "kotlinClass", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;", "scope$delegate", "getScope", "()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", "scope", "Ljava/lang/Class;", "multifileFacade$delegate", "Lkotlin/Lazy;", "getMultifileFacade", "()Ljava/lang/Class;", "multifileFacade", "Lkotlin/Triple;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmNameResolver;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMetadataVersion;", "metadata$delegate", "getMetadata", "()Lkotlin/Triple;", "metadata", BuildConfig.FLAVOR, "Lkotlin/reflect/jvm/internal/KCallableImpl;", "members$delegate", "getMembers", "()Ljava/util/Collection;", "members", "kotlin-reflection"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class Data extends KDeclarationContainerImpl.Data {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Data.class, "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", 0)), Reflection.property1(new PropertyReference1Impl(Data.class, "members", "getMembers()Ljava/util/Collection;", 0))};

        /* renamed from: kotlinClass$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal kotlinClass;

        /* renamed from: members$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal members;

        /* renamed from: metadata$delegate, reason: from kotlin metadata */
        private final Lazy metadata;

        /* renamed from: multifileFacade$delegate, reason: from kotlin metadata */
        private final Lazy multifileFacade;

        /* renamed from: scope$delegate, reason: from kotlin metadata */
        private final ReflectProperties.LazySoftVal scope;

        public Data() {
            super();
            this.kotlinClass = ReflectProperties.lazySoft(new Function0(KPackageImpl.this) { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$$Lambda$0
                private final KPackageImpl arg$0;

                {
                    this.arg$0 = r1;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    ReflectKotlinClass kotlinClass_delegate$lambda$0;
                    kotlinClass_delegate$lambda$0 = KPackageImpl.Data.kotlinClass_delegate$lambda$0(this.arg$0);
                    return kotlinClass_delegate$lambda$0;
                }
            });
            this.scope = ReflectProperties.lazySoft(new Function0(this) { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$$Lambda$1
                private final KPackageImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    MemberScope scope_delegate$lambda$1;
                    scope_delegate$lambda$1 = KPackageImpl.Data.scope_delegate$lambda$1(this.arg$0);
                    return scope_delegate$lambda$1;
                }
            });
            LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
            this.multifileFacade = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this, KPackageImpl.this) { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$$Lambda$2
                private final KPackageImpl.Data arg$0;
                private final KPackageImpl arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = r2;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    Class multifileFacade_delegate$lambda$2;
                    multifileFacade_delegate$lambda$2 = KPackageImpl.Data.multifileFacade_delegate$lambda$2(this.arg$0, this.arg$1);
                    return multifileFacade_delegate$lambda$2;
                }
            });
            this.metadata = LazyKt.lazy(lazyThreadSafetyMode, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$$Lambda$3
                private final KPackageImpl.Data arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    Triple metadata_delegate$lambda$4;
                    metadata_delegate$lambda$4 = KPackageImpl.Data.metadata_delegate$lambda$4(this.arg$0);
                    return metadata_delegate$lambda$4;
                }
            });
            this.members = ReflectProperties.lazySoft(new Function0(KPackageImpl.this, this) { // from class: kotlin.reflect.jvm.internal.KPackageImpl$Data$$Lambda$4
                private final KPackageImpl arg$0;
                private final KPackageImpl.Data arg$1;

                {
                    this.arg$0 = r1;
                    this.arg$1 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    Collection members_delegate$lambda$5;
                    members_delegate$lambda$5 = KPackageImpl.Data.members_delegate$lambda$5(this.arg$0, this.arg$1);
                    return members_delegate$lambda$5;
                }
            });
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final ReflectKotlinClass getKotlinClass() {
            return (ReflectKotlinClass) this.kotlinClass.getValue(this, $$delegatedProperties[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ReflectKotlinClass kotlinClass_delegate$lambda$0(KPackageImpl kPackageImpl) {
            return ReflectKotlinClass.Factory.create(kPackageImpl.getJClass());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Collection members_delegate$lambda$5(KPackageImpl kPackageImpl, Data data) {
            return kPackageImpl.getMembers(data.getScope(), KDeclarationContainerImpl.MemberBelonginess.DECLARED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Triple metadata_delegate$lambda$4(Data data) {
            KotlinClassHeader classHeader;
            ReflectKotlinClass kotlinClass = data.getKotlinClass();
            if (kotlinClass == null || (classHeader = kotlinClass.getClassHeader()) == null) {
                return null;
            }
            String[] data2 = classHeader.getData();
            String[] strings = classHeader.getStrings();
            if (data2 == null || strings == null) {
                return null;
            }
            Pair<JvmNameResolver, ProtoBuf$Package> readPackageDataFrom = JvmProtoBufUtil.readPackageDataFrom(data2, strings);
            return new Triple(readPackageDataFrom.component1(), readPackageDataFrom.component2(), classHeader.getMetadataVersion());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Class multifileFacade_delegate$lambda$2(Data data, KPackageImpl kPackageImpl) {
            KotlinClassHeader classHeader;
            ReflectKotlinClass kotlinClass = data.getKotlinClass();
            String multifileClassName = (kotlinClass == null || (classHeader = kotlinClass.getClassHeader()) == null) ? null : classHeader.getMultifileClassName();
            if (multifileClassName == null || multifileClassName.length() <= 0) {
                return null;
            }
            return kPackageImpl.getJClass().getClassLoader().loadClass(StringsKt.replace$default(multifileClassName, '/', '.', false, 4, (Object) null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final MemberScope scope_delegate$lambda$1(Data data) {
            ReflectKotlinClass kotlinClass = data.getKotlinClass();
            return kotlinClass != null ? data.getModuleData().getPackagePartScopeCache().getPackagePartScope(kotlinClass) : MemberScope.Empty.INSTANCE;
        }

        public final Triple<JvmNameResolver, ProtoBuf$Package, JvmMetadataVersion> getMetadata() {
            return (Triple) this.metadata.getValue();
        }

        public final Class<?> getMultifileFacade() {
            return (Class) this.multifileFacade.getValue();
        }

        public final MemberScope getScope() {
            T value = this.scope.getValue(this, $$delegatedProperties[1]);
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return (MemberScope) value;
        }
    }

    public KPackageImpl(Class<?> jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        this.jClass = jClass;
        this.data = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0(this) { // from class: kotlin.reflect.jvm.internal.KPackageImpl$$Lambda$0
            private final KPackageImpl arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                KPackageImpl.Data data$lambda$0;
                data$lambda$0 = KPackageImpl.data$lambda$0(this.arg$0);
                return data$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Data data$lambda$0(KPackageImpl kPackageImpl) {
        return new Data();
    }

    private final MemberScope getScope() {
        return this.data.getValue().getScope();
    }

    public boolean equals(Object other) {
        return (other instanceof KPackageImpl) && Intrinsics.areEqual(getJClass(), ((KPackageImpl) other).getJClass());
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<ConstructorDescriptor> getConstructorDescriptors() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<FunctionDescriptor> getFunctions(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getScope().getContributedFunctions(name, NoLookupLocation.FROM_REFLECTION);
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public Class<?> getJClass() {
        return this.jClass;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public PropertyDescriptor getLocalProperty(int index) {
        Triple<JvmNameResolver, ProtoBuf$Package, JvmMetadataVersion> metadata = this.data.getValue().getMetadata();
        if (metadata == null) {
            return null;
        }
        JvmNameResolver component1 = metadata.component1();
        ProtoBuf$Package component2 = metadata.component2();
        JvmMetadataVersion component3 = metadata.component3();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Package, List<ProtoBuf$Property>> packageLocalVariable = JvmProtoBuf.packageLocalVariable;
        Intrinsics.checkNotNullExpressionValue(packageLocalVariable, "packageLocalVariable");
        ProtoBuf$Property protoBuf$Property = (ProtoBuf$Property) ProtoBufUtilKt.getExtensionOrNull(component2, packageLocalVariable, index);
        if (protoBuf$Property == null) {
            return null;
        }
        Class<?> jClass = getJClass();
        ProtoBuf$TypeTable typeTable = component2.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(typeTable, "getTypeTable(...)");
        return (PropertyDescriptor) UtilKt.deserializeToDescriptor(jClass, protoBuf$Property, component1, new TypeTable(typeTable), component3, KPackageImpl$getLocalProperty$1$1$1.INSTANCE);
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    protected Class<?> getMethodOwner() {
        Class<?> multifileFacade = this.data.getValue().getMultifileFacade();
        return multifileFacade == null ? getJClass() : multifileFacade;
    }

    @Override // kotlin.reflect.jvm.internal.KDeclarationContainerImpl
    public Collection<PropertyDescriptor> getProperties(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getScope().getContributedVariables(name, NoLookupLocation.FROM_REFLECTION);
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    public String toString() {
        return "file class " + ReflectClassUtilKt.getClassId(getJClass()).asSingleFqName();
    }
}
