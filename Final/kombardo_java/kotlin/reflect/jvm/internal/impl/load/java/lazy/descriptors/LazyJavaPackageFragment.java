package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryPackageSourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.utils.DeserializationHelpersKt;

/* loaded from: classes3.dex */
public final class LazyJavaPackageFragment extends PackageFragmentDescriptorImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(LazyJavaPackageFragment.class, "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;", 0)), Reflection.property1(new PropertyReference1Impl(LazyJavaPackageFragment.class, "partToFacade", "getPartToFacade()Ljava/util/HashMap;", 0))};
    private final Annotations annotations;
    private final NotNullLazyValue binaryClasses$delegate;

    /* renamed from: c, reason: collision with root package name */
    private final LazyJavaResolverContext f6164c;
    private final JavaPackage jPackage;
    private final JvmMetadataVersion jvmMetadataVersion;
    private final NotNullLazyValue partToFacade$delegate;
    private final JvmPackageScope scope;
    private final NotNullLazyValue<List<FqName>> subPackages;

    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            try {
                iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaPackageFragment(LazyJavaResolverContext outerContext, JavaPackage jPackage) {
        super(outerContext.getModule(), jPackage.getFqName());
        Intrinsics.checkNotNullParameter(outerContext, "outerContext");
        Intrinsics.checkNotNullParameter(jPackage, "jPackage");
        this.jPackage = jPackage;
        LazyJavaResolverContext childForClassOrPackage$default = ContextKt.childForClassOrPackage$default(outerContext, this, null, 0, 6, null);
        this.f6164c = childForClassOrPackage$default;
        this.jvmMetadataVersion = DeserializationHelpersKt.jvmMetadataVersionOrDefault(outerContext.getComponents().getDeserializedDescriptorResolver().getComponents().getConfiguration());
        this.binaryClasses$delegate = childForClassOrPackage$default.getStorageManager().createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment$$Lambda$0
            private final LazyJavaPackageFragment arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Map binaryClasses_delegate$lambda$2;
                binaryClasses_delegate$lambda$2 = LazyJavaPackageFragment.binaryClasses_delegate$lambda$2(this.arg$0);
                return binaryClasses_delegate$lambda$2;
            }
        });
        this.scope = new JvmPackageScope(childForClassOrPackage$default, jPackage, this);
        this.subPackages = childForClassOrPackage$default.getStorageManager().createRecursionTolerantLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment$$Lambda$1
            private final LazyJavaPackageFragment arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                List subPackages$lambda$3;
                subPackages$lambda$3 = LazyJavaPackageFragment.subPackages$lambda$3(this.arg$0);
                return subPackages$lambda$3;
            }
        }, CollectionsKt.emptyList());
        this.annotations = childForClassOrPackage$default.getComponents().getJavaTypeEnhancementState().getDisabledDefaultAnnotations() ? Annotations.Companion.getEMPTY() : LazyJavaAnnotationsKt.resolveAnnotations(childForClassOrPackage$default, jPackage);
        this.partToFacade$delegate = childForClassOrPackage$default.getStorageManager().createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment$$Lambda$2
            private final LazyJavaPackageFragment arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                HashMap partToFacade_delegate$lambda$4;
                partToFacade_delegate$lambda$4 = LazyJavaPackageFragment.partToFacade_delegate$lambda$4(this.arg$0);
                return partToFacade_delegate$lambda$4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map binaryClasses_delegate$lambda$2(LazyJavaPackageFragment lazyJavaPackageFragment) {
        List<String> findPackageParts = lazyJavaPackageFragment.f6164c.getComponents().getPackagePartProvider().findPackageParts(lazyJavaPackageFragment.getFqName().asString());
        ArrayList arrayList = new ArrayList();
        for (String str : findPackageParts) {
            ClassId.Companion companion = ClassId.Companion;
            FqName fqNameForTopLevelClassMaybeWithDollars = JvmClassName.byInternalName(str).getFqNameForTopLevelClassMaybeWithDollars();
            Intrinsics.checkNotNullExpressionValue(fqNameForTopLevelClassMaybeWithDollars, "getFqNameForTopLevelClassMaybeWithDollars(...)");
            KotlinJvmBinaryClass findKotlinClass = KotlinClassFinderKt.findKotlinClass(lazyJavaPackageFragment.f6164c.getComponents().getKotlinClassFinder(), companion.topLevel(fqNameForTopLevelClassMaybeWithDollars), lazyJavaPackageFragment.jvmMetadataVersion);
            Pair pair = findKotlinClass != null ? TuplesKt.to(str, findKotlinClass) : null;
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashMap partToFacade_delegate$lambda$4(LazyJavaPackageFragment lazyJavaPackageFragment) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, KotlinJvmBinaryClass> entry : lazyJavaPackageFragment.getBinaryClasses$descriptors_jvm().entrySet()) {
            String key = entry.getKey();
            KotlinJvmBinaryClass value = entry.getValue();
            JvmClassName byInternalName = JvmClassName.byInternalName(key);
            Intrinsics.checkNotNullExpressionValue(byInternalName, "byInternalName(...)");
            KotlinClassHeader classHeader = value.getClassHeader();
            int i5 = WhenMappings.$EnumSwitchMapping$0[classHeader.getKind().ordinal()];
            if (i5 == 1) {
                String multifileClassName = classHeader.getMultifileClassName();
                if (multifileClassName != null) {
                    hashMap.put(byInternalName, JvmClassName.byInternalName(multifileClassName));
                }
            } else if (i5 == 2) {
                hashMap.put(byInternalName, byInternalName);
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List subPackages$lambda$3(LazyJavaPackageFragment lazyJavaPackageFragment) {
        Collection<JavaPackage> subPackages = lazyJavaPackageFragment.jPackage.getSubPackages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(subPackages, 10));
        Iterator<T> it = subPackages.iterator();
        while (it.hasNext()) {
            arrayList.add(((JavaPackage) it.next()).getFqName());
        }
        return arrayList;
    }

    public final ClassDescriptor findClassifierByJavaClass$descriptors_jvm(JavaClass jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        return this.scope.getJavaScope$descriptors_jvm().findClassifierByJavaClass$descriptors_jvm(jClass);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        return this.annotations;
    }

    public final Map<String, KotlinJvmBinaryClass> getBinaryClasses$descriptors_jvm() {
        return (Map) StorageKt.getValue(this.binaryClasses$delegate, this, (KProperty<?>) $$delegatedProperties[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        return new KotlinJvmBinaryPackageSourceElement(this);
    }

    public final List<FqName> getSubPackageFqNames$descriptors_jvm() {
        return this.subPackages.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public String toString() {
        return "Lazy Java package fragment: " + getFqName() + " of module " + this.f6164c.getComponents().getModule();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    public JvmPackageScope getMemberScope() {
        return this.scope;
    }
}
