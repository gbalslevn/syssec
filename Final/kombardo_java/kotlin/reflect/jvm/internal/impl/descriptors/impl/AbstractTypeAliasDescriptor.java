package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* loaded from: classes3.dex */
public abstract class AbstractTypeAliasDescriptor extends DeclarationDescriptorNonRootImpl implements TypeAliasDescriptor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(AbstractTypeAliasDescriptor.class, "constructors", "getConstructors()Ljava/util/Collection;", 0))};
    private final NotNullLazyValue constructors$delegate;
    private List<? extends TypeParameterDescriptor> declaredTypeParametersImpl;
    private final StorageManager storageManager;
    private final AbstractTypeAliasDescriptor$typeConstructor$1 typeConstructor;
    private final DescriptorVisibility visibilityImpl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$typeConstructor$1] */
    public AbstractTypeAliasDescriptor(StorageManager storageManager, DeclarationDescriptor containingDeclaration, Annotations annotations, Name name, SourceElement sourceElement, DescriptorVisibility visibilityImpl) {
        super(containingDeclaration, annotations, name, sourceElement);
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(sourceElement, "sourceElement");
        Intrinsics.checkNotNullParameter(visibilityImpl, "visibilityImpl");
        this.storageManager = storageManager;
        this.visibilityImpl = visibilityImpl;
        this.constructors$delegate = storageManager.createLazyValue(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$$Lambda$0
            private final AbstractTypeAliasDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                Collection typeAliasConstructors;
                typeAliasConstructors = this.arg$0.getTypeAliasConstructors();
                return typeAliasConstructors;
            }
        });
        this.typeConstructor = new TypeConstructor() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$typeConstructor$1
            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            public KotlinBuiltIns getBuiltIns() {
                return DescriptorUtilsKt.getBuiltIns(mo3718getDeclarationDescriptor());
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            public List<TypeParameterDescriptor> getParameters() {
                return AbstractTypeAliasDescriptor.this.getTypeConstructorTypeParameters();
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            /* renamed from: getSupertypes */
            public Collection<KotlinType> mo3719getSupertypes() {
                Collection<KotlinType> mo3719getSupertypes = mo3718getDeclarationDescriptor().getUnderlyingType().getConstructor().mo3719getSupertypes();
                Intrinsics.checkNotNullExpressionValue(mo3719getSupertypes, "getSupertypes(...)");
                return mo3719getSupertypes;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            public boolean isDenotable() {
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
                Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
                return this;
            }

            public String toString() {
                return "[typealias " + mo3718getDeclarationDescriptor().getName().asString() + ']';
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
            /* renamed from: getDeclarationDescriptor */
            public TypeAliasDescriptor mo3718getDeclarationDescriptor() {
                return AbstractTypeAliasDescriptor.this;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SimpleType computeDefaultType$lambda$4(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor, KotlinTypeRefiner kotlinTypeRefiner) {
        ClassifierDescriptor refineDescriptor = kotlinTypeRefiner.refineDescriptor(abstractTypeAliasDescriptor);
        if (refineDescriptor != null) {
            return refineDescriptor.getDefaultType();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean isInner$lambda$2(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor, UnwrappedType unwrappedType) {
        boolean z5;
        Intrinsics.checkNotNull(unwrappedType);
        if (!KotlinTypeKt.isError(unwrappedType)) {
            ClassifierDescriptor mo3718getDeclarationDescriptor = unwrappedType.getConstructor().mo3718getDeclarationDescriptor();
            if ((mo3718getDeclarationDescriptor instanceof TypeParameterDescriptor) && !Intrinsics.areEqual(((TypeParameterDescriptor) mo3718getDeclarationDescriptor).getContainingDeclaration(), abstractTypeAliasDescriptor)) {
                z5 = true;
                return Boolean.valueOf(z5);
            }
        }
        z5 = false;
        return Boolean.valueOf(z5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> visitor, D d5) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        return visitor.visitTypeAliasDescriptor(this, d5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SimpleType computeDefaultType() {
        MemberScope memberScope;
        ClassDescriptor classDescriptor = getClassDescriptor();
        if (classDescriptor == null || (memberScope = classDescriptor.getUnsubstitutedMemberScope()) == null) {
            memberScope = MemberScope.Empty.INSTANCE;
        }
        SimpleType makeUnsubstitutedType = TypeUtils.makeUnsubstitutedType(this, memberScope, (Function1<KotlinTypeRefiner, SimpleType>) new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$$Lambda$2
            private final AbstractTypeAliasDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                SimpleType computeDefaultType$lambda$4;
                computeDefaultType$lambda$4 = AbstractTypeAliasDescriptor.computeDefaultType$lambda$4(this.arg$0, (KotlinTypeRefiner) obj);
                return computeDefaultType$lambda$4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(makeUnsubstitutedType, "makeUnsubstitutedType(...)");
        return makeUnsubstitutedType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List list = this.declaredTypeParametersImpl;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("declaredTypeParametersImpl");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final StorageManager getStorageManager() {
        return this.storageManager;
    }

    public final Collection<TypeAliasConstructorDescriptor> getTypeAliasConstructors() {
        ClassDescriptor classDescriptor = getClassDescriptor();
        if (classDescriptor == null) {
            return CollectionsKt.emptyList();
        }
        Collection<ClassConstructorDescriptor> constructors = classDescriptor.getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructors, "getConstructors(...)");
        ArrayList arrayList = new ArrayList();
        for (ClassConstructorDescriptor classConstructorDescriptor : constructors) {
            TypeAliasConstructorDescriptorImpl.Companion companion = TypeAliasConstructorDescriptorImpl.Companion;
            StorageManager storageManager = this.storageManager;
            Intrinsics.checkNotNull(classConstructorDescriptor);
            TypeAliasConstructorDescriptor createIfAvailable = companion.createIfAvailable(storageManager, this, classConstructorDescriptor);
            if (createIfAvailable != null) {
                arrayList.add(createIfAvailable);
            }
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract List<TypeParameterDescriptor> getTypeConstructorTypeParameters();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
    public DescriptorVisibility getVisibility() {
        return this.visibilityImpl;
    }

    public final void initialize(List<? extends TypeParameterDescriptor> declaredTypeParameters) {
        Intrinsics.checkNotNullParameter(declaredTypeParameters, "declaredTypeParameters");
        this.declaredTypeParametersImpl = declaredTypeParameters;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return TypeUtils.contains(getUnderlyingType(), new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$$Lambda$1
            private final AbstractTypeAliasDescriptor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Boolean isInner$lambda$2;
                isInner$lambda$2 = AbstractTypeAliasDescriptor.isInner$lambda$2(this.arg$0, (UnwrappedType) obj);
                return isInner$lambda$2;
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public String toString() {
        return "typealias " + getName().asString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public TypeAliasDescriptor getOriginal() {
        DeclarationDescriptorWithSource original = super.getOriginal();
        Intrinsics.checkNotNull(original, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
        return (TypeAliasDescriptor) original;
    }
}
