package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleExceptionKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.platform.TargetPlatform;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* loaded from: classes3.dex */
public final class ModuleDescriptorImpl extends DeclarationDescriptorImpl implements ModuleDescriptor {
    private final KotlinBuiltIns builtIns;
    private final Map<ModuleCapability<?>, Object> capabilities;
    private ModuleDependencies dependencies;
    private boolean isValid;
    private PackageFragmentProvider packageFragmentProviderForModuleContent;
    private final Lazy packageFragmentProviderForWholeModuleWithDependencies$delegate;
    private final PackageViewDescriptorFactory packageViewDescriptorFactory;
    private final MemoizedFunctionToNotNull<FqName, PackageViewDescriptor> packages;
    private final TargetPlatform platform;
    private final Name stableName;
    private final StorageManager storageManager;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModuleDescriptorImpl(Name moduleName, StorageManager storageManager, KotlinBuiltIns builtIns, TargetPlatform targetPlatform) {
        this(moduleName, storageManager, builtIns, targetPlatform, null, null, 48, null);
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
    }

    private final String getId() {
        String name = getName().toString();
        Intrinsics.checkNotNullExpressionValue(name, "toString(...)");
        return name;
    }

    private final CompositePackageFragmentProvider getPackageFragmentProviderForWholeModuleWithDependencies() {
        return (CompositePackageFragmentProvider) this.packageFragmentProviderForWholeModuleWithDependencies$delegate.getValue();
    }

    private final boolean isInitialized() {
        return this.packageFragmentProviderForModuleContent != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompositePackageFragmentProvider packageFragmentProviderForWholeModuleWithDependencies_delegate$lambda$10(ModuleDescriptorImpl moduleDescriptorImpl) {
        ModuleDependencies moduleDependencies = moduleDescriptorImpl.dependencies;
        if (moduleDependencies == null) {
            throw new AssertionError("Dependencies of module " + moduleDescriptorImpl.getId() + " were not set before querying module content");
        }
        List<ModuleDescriptorImpl> allDependencies = moduleDependencies.getAllDependencies();
        moduleDescriptorImpl.assertValid();
        allDependencies.contains(moduleDescriptorImpl);
        List<ModuleDescriptorImpl> list = allDependencies;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((ModuleDescriptorImpl) it.next()).isInitialized();
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            PackageFragmentProvider packageFragmentProvider = ((ModuleDescriptorImpl) it2.next()).packageFragmentProviderForModuleContent;
            Intrinsics.checkNotNull(packageFragmentProvider);
            arrayList.add(packageFragmentProvider);
        }
        return new CompositePackageFragmentProvider(arrayList, "CompositeProvider@ModuleDescriptor for " + moduleDescriptorImpl.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PackageViewDescriptor packages$lambda$0(ModuleDescriptorImpl moduleDescriptorImpl, FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return moduleDescriptorImpl.packageViewDescriptorFactory.compute(moduleDescriptorImpl, fqName, moduleDescriptorImpl.storageManager);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d5) {
        return (R) ModuleDescriptor.DefaultImpls.accept(this, declarationDescriptorVisitor, d5);
    }

    public void assertValid() {
        if (isValid()) {
            return;
        }
        InvalidModuleExceptionKt.moduleInvalidated(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public KotlinBuiltIns getBuiltIns() {
        return this.builtIns;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public <T> T getCapability(ModuleCapability<T> capability) {
        Intrinsics.checkNotNullParameter(capability, "capability");
        T t5 = (T) this.capabilities.get(capability);
        if (t5 == null) {
            return null;
        }
        return t5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        return ModuleDescriptor.DefaultImpls.getContainingDeclaration(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public List<ModuleDescriptor> getExpectedByModules() {
        ModuleDependencies moduleDependencies = this.dependencies;
        if (moduleDependencies != null) {
            return moduleDependencies.getDirectExpectedByDependencies();
        }
        throw new AssertionError("Dependencies of module " + getId() + " were not set");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public PackageViewDescriptor getPackage(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        assertValid();
        return this.packages.invoke(fqName);
    }

    public final PackageFragmentProvider getPackageFragmentProvider() {
        assertValid();
        return getPackageFragmentProviderForWholeModuleWithDependencies();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        assertValid();
        return getPackageFragmentProvider().getSubPackagesOf(fqName, nameFilter);
    }

    public final void initialize(PackageFragmentProvider providerForModuleContent) {
        Intrinsics.checkNotNullParameter(providerForModuleContent, "providerForModuleContent");
        isInitialized();
        this.packageFragmentProviderForModuleContent = providerForModuleContent;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public final void setDependencies(ModuleDependencies dependencies) {
        Intrinsics.checkNotNullParameter(dependencies, "dependencies");
        this.dependencies = dependencies;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor
    public boolean shouldSeeInternalsOf(ModuleDescriptor targetModule) {
        Intrinsics.checkNotNullParameter(targetModule, "targetModule");
        if (Intrinsics.areEqual(this, targetModule)) {
            return true;
        }
        ModuleDependencies moduleDependencies = this.dependencies;
        Intrinsics.checkNotNull(moduleDependencies);
        return CollectionsKt.contains(moduleDependencies.getModulesWhoseInternalsAreVisible(), targetModule) || getExpectedByModules().contains(targetModule) || targetModule.getExpectedByModules().contains(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (!isValid()) {
            sb.append(" !isValid");
        }
        sb.append(" packageFragmentProvider: ");
        PackageFragmentProvider packageFragmentProvider = this.packageFragmentProviderForModuleContent;
        sb.append(packageFragmentProvider != null ? packageFragmentProvider.getClass().getSimpleName() : null);
        return sb.toString();
    }

    public /* synthetic */ ModuleDescriptorImpl(Name name, StorageManager storageManager, KotlinBuiltIns kotlinBuiltIns, TargetPlatform targetPlatform, Map map, Name name2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(name, storageManager, kotlinBuiltIns, (i5 & 8) != 0 ? null : targetPlatform, (i5 & 16) != 0 ? MapsKt.emptyMap() : map, (i5 & 32) != 0 ? null : name2);
    }

    public final void setDependencies(ModuleDescriptorImpl... descriptors) {
        Intrinsics.checkNotNullParameter(descriptors, "descriptors");
        setDependencies(ArraysKt.toList(descriptors));
    }

    public final void setDependencies(List<ModuleDescriptorImpl> descriptors) {
        Intrinsics.checkNotNullParameter(descriptors, "descriptors");
        setDependencies(descriptors, SetsKt.emptySet());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModuleDescriptorImpl(Name moduleName, StorageManager storageManager, KotlinBuiltIns builtIns, TargetPlatform targetPlatform, Map<ModuleCapability<?>, ? extends Object> capabilities, Name name) {
        super(Annotations.Companion.getEMPTY(), moduleName);
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(builtIns, "builtIns");
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        this.storageManager = storageManager;
        this.builtIns = builtIns;
        this.stableName = name;
        if (moduleName.isSpecial()) {
            this.capabilities = capabilities;
            PackageViewDescriptorFactory packageViewDescriptorFactory = (PackageViewDescriptorFactory) getCapability(PackageViewDescriptorFactory.Companion.getCAPABILITY());
            this.packageViewDescriptorFactory = packageViewDescriptorFactory == null ? PackageViewDescriptorFactory.Default.INSTANCE : packageViewDescriptorFactory;
            this.isValid = true;
            this.packages = storageManager.createMemoizedFunction(new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl$$Lambda$0
                private final ModuleDescriptorImpl arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    PackageViewDescriptor packages$lambda$0;
                    packages$lambda$0 = ModuleDescriptorImpl.packages$lambda$0(this.arg$0, (FqName) obj);
                    return packages$lambda$0;
                }
            });
            this.packageFragmentProviderForWholeModuleWithDependencies$delegate = LazyKt.lazy(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl$$Lambda$1
                private final ModuleDescriptorImpl arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    CompositePackageFragmentProvider packageFragmentProviderForWholeModuleWithDependencies_delegate$lambda$10;
                    packageFragmentProviderForWholeModuleWithDependencies_delegate$lambda$10 = ModuleDescriptorImpl.packageFragmentProviderForWholeModuleWithDependencies_delegate$lambda$10(this.arg$0);
                    return packageFragmentProviderForWholeModuleWithDependencies_delegate$lambda$10;
                }
            });
            return;
        }
        throw new IllegalArgumentException("Module name must be special: " + moduleName);
    }

    public final void setDependencies(List<ModuleDescriptorImpl> descriptors, Set<ModuleDescriptorImpl> friends) {
        Intrinsics.checkNotNullParameter(descriptors, "descriptors");
        Intrinsics.checkNotNullParameter(friends, "friends");
        setDependencies(new ModuleDependenciesImpl(descriptors, friends, CollectionsKt.emptyList(), SetsKt.emptySet()));
    }
}
