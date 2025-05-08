package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import androidx.appcompat.R$styleable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.DefaultTypeAttributeTranslator;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* loaded from: classes3.dex */
public class LazySubstitutingClassDescriptor extends ModuleAwareClassDescriptor {
    private List<TypeParameterDescriptor> declaredTypeParameters;
    private TypeSubstitutor newSubstitutor;
    private final ModuleAwareClassDescriptor original;
    private final TypeSubstitutor originalSubstitutor;
    private TypeConstructor typeConstructor;
    private List<TypeParameterDescriptor> typeConstructorParameters;

    /* JADX WARN: Removed duplicated region for block: B:32:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void $$$reportNull$$$0(int i5) {
        String format;
        String str = (i5 == 2 || i5 == 3 || i5 == 5 || i5 == 6 || i5 == 8 || i5 == 10 || i5 == 13 || i5 == 23) ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i5 == 2 || i5 == 3 || i5 == 5 || i5 == 6 || i5 == 8 || i5 == 10 || i5 == 13 || i5 == 23) ? 3 : 2];
        if (i5 != 2) {
            if (i5 != 3) {
                if (i5 != 5) {
                    if (i5 != 6) {
                        if (i5 != 8) {
                            if (i5 != 10) {
                                if (i5 != 13) {
                                    if (i5 != 23) {
                                        objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
                                    } else {
                                        objArr[0] = "substitutor";
                                    }
                                    switch (i5) {
                                        case 2:
                                        case 3:
                                        case 5:
                                        case 6:
                                        case 8:
                                        case 10:
                                        case 13:
                                        case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
                                            break;
                                        case 4:
                                        case 7:
                                        case 9:
                                        case 11:
                                            objArr[1] = "getMemberScope";
                                            break;
                                        case 12:
                                        case 14:
                                            objArr[1] = "getUnsubstitutedMemberScope";
                                            break;
                                        case 15:
                                            objArr[1] = "getStaticScope";
                                            break;
                                        case 16:
                                            objArr[1] = "getDefaultType";
                                            break;
                                        case 17:
                                            objArr[1] = "getContextReceivers";
                                            break;
                                        case 18:
                                            objArr[1] = "getConstructors";
                                            break;
                                        case 19:
                                            objArr[1] = "getAnnotations";
                                            break;
                                        case 20:
                                            objArr[1] = "getName";
                                            break;
                                        case 21:
                                            objArr[1] = "getOriginal";
                                            break;
                                        case 22:
                                            objArr[1] = "getContainingDeclaration";
                                            break;
                                        case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                                            objArr[1] = "substitute";
                                            break;
                                        case 25:
                                            objArr[1] = "getKind";
                                            break;
                                        case 26:
                                            objArr[1] = "getModality";
                                            break;
                                        case 27:
                                            objArr[1] = "getVisibility";
                                            break;
                                        case 28:
                                            objArr[1] = "getUnsubstitutedInnerClassesScope";
                                            break;
                                        case R$styleable.Toolbar_titleTextColor /* 29 */:
                                            objArr[1] = "getSource";
                                            break;
                                        case 30:
                                            objArr[1] = "getDeclaredTypeParameters";
                                            break;
                                        case 31:
                                            objArr[1] = "getSealedSubclasses";
                                            break;
                                        default:
                                            objArr[1] = "getTypeConstructor";
                                            break;
                                    }
                                    if (i5 != 2 || i5 == 3 || i5 == 5 || i5 == 6 || i5 == 8 || i5 == 10) {
                                        objArr[2] = "getMemberScope";
                                    } else if (i5 == 13) {
                                        objArr[2] = "getUnsubstitutedMemberScope";
                                    } else if (i5 == 23) {
                                        objArr[2] = "substitute";
                                    }
                                    format = String.format(str, objArr);
                                    if (i5 == 2 && i5 != 3 && i5 != 5 && i5 != 6 && i5 != 8 && i5 != 10 && i5 != 13 && i5 != 23) {
                                        throw new IllegalStateException(format);
                                    }
                                    throw new IllegalArgumentException(format);
                                }
                            }
                        }
                    }
                }
                objArr[0] = "typeSubstitution";
                switch (i5) {
                }
                if (i5 != 2) {
                }
                objArr[2] = "getMemberScope";
                format = String.format(str, objArr);
                if (i5 == 2) {
                }
                throw new IllegalArgumentException(format);
            }
            objArr[0] = "kotlinTypeRefiner";
            switch (i5) {
            }
            if (i5 != 2) {
            }
            objArr[2] = "getMemberScope";
            format = String.format(str, objArr);
            if (i5 == 2) {
            }
            throw new IllegalArgumentException(format);
        }
        objArr[0] = "typeArguments";
        switch (i5) {
        }
        if (i5 != 2) {
        }
        objArr[2] = "getMemberScope";
        format = String.format(str, objArr);
        if (i5 == 2) {
        }
        throw new IllegalArgumentException(format);
    }

    public LazySubstitutingClassDescriptor(ModuleAwareClassDescriptor moduleAwareClassDescriptor, TypeSubstitutor typeSubstitutor) {
        this.original = moduleAwareClassDescriptor;
        this.originalSubstitutor = typeSubstitutor;
    }

    private TypeSubstitutor getSubstitutor() {
        if (this.newSubstitutor == null) {
            if (this.originalSubstitutor.isEmpty()) {
                this.newSubstitutor = this.originalSubstitutor;
            } else {
                List<TypeParameterDescriptor> parameters = this.original.getTypeConstructor().getParameters();
                this.typeConstructorParameters = new ArrayList(parameters.size());
                this.newSubstitutor = DescriptorSubstitutor.substituteTypeParameters(parameters, this.originalSubstitutor.getSubstitution(), this, this.typeConstructorParameters);
                this.declaredTypeParameters = CollectionsKt.filter(this.typeConstructorParameters, new Function1<TypeParameterDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.LazySubstitutingClassDescriptor.1
                    @Override // kotlin.jvm.functions.Function1
                    public Boolean invoke(TypeParameterDescriptor typeParameterDescriptor) {
                        return Boolean.valueOf(!typeParameterDescriptor.isCapturedFromOuterDeclaration());
                    }
                });
            }
        }
        return this.newSubstitutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SimpleType substituteSimpleType(SimpleType simpleType) {
        return (simpleType == null || this.originalSubstitutor.isEmpty()) ? simpleType : (SimpleType) getSubstitutor().substitute(simpleType, Variance.INVARIANT);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d5) {
        return declarationDescriptorVisitor.visitClassDescriptor(this, d5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    public Annotations getAnnotations() {
        Annotations annotations = this.original.getAnnotations();
        if (annotations == null) {
            $$$reportNull$$$0(19);
        }
        return annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* renamed from: getCompanionObjectDescriptor */
    public ClassDescriptor mo3683getCompanionObjectDescriptor() {
        return this.original.mo3683getCompanionObjectDescriptor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Collection<ClassConstructorDescriptor> getConstructors() {
        Collection<ClassConstructorDescriptor> constructors = this.original.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.size());
        for (ClassConstructorDescriptor classConstructorDescriptor : constructors) {
            arrayList.add(((ClassConstructorDescriptor) classConstructorDescriptor.newCopyBuilder().setOriginal(classConstructorDescriptor.getOriginal()).setModality(classConstructorDescriptor.getModality()).setVisibility(classConstructorDescriptor.getVisibility()).setKind(classConstructorDescriptor.getKind()).setCopyOverrides(false).build()).substitute(getSubstitutor()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        DeclarationDescriptor containingDeclaration = this.original.getContainingDeclaration();
        if (containingDeclaration == null) {
            $$$reportNull$$$0(22);
        }
        return containingDeclaration;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public List<ReceiverParameterDescriptor> getContextReceivers() {
        List<ReceiverParameterDescriptor> emptyList = Collections.emptyList();
        if (emptyList == null) {
            $$$reportNull$$$0(17);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        getSubstitutor();
        List<TypeParameterDescriptor> list = this.declaredTypeParameters;
        if (list == null) {
            $$$reportNull$$$0(30);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public SimpleType getDefaultType() {
        SimpleType simpleTypeWithNonTrivialMemberScope = KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(DefaultTypeAttributeTranslator.INSTANCE.toAttributes(getAnnotations(), null, null), getTypeConstructor(), TypeUtils.getDefaultTypeProjections(getTypeConstructor().getParameters()), false, getUnsubstitutedMemberScope());
        if (simpleTypeWithNonTrivialMemberScope == null) {
            $$$reportNull$$$0(16);
        }
        return simpleTypeWithNonTrivialMemberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ClassKind getKind() {
        ClassKind kind = this.original.getKind();
        if (kind == null) {
            $$$reportNull$$$0(25);
        }
        return kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public MemberScope getMemberScope(TypeSubstitution typeSubstitution, KotlinTypeRefiner kotlinTypeRefiner) {
        if (typeSubstitution == null) {
            $$$reportNull$$$0(5);
        }
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(6);
        }
        MemberScope memberScope = this.original.getMemberScope(typeSubstitution, kotlinTypeRefiner);
        if (!this.originalSubstitutor.isEmpty()) {
            return new SubstitutingScope(memberScope, getSubstitutor());
        }
        if (memberScope == null) {
            $$$reportNull$$$0(7);
        }
        return memberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public Modality getModality() {
        Modality modality = this.original.getModality();
        if (modality == null) {
            $$$reportNull$$$0(26);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Named
    public Name getName() {
        Name name = this.original.getName();
        if (name == null) {
            $$$reportNull$$$0(20);
        }
        return name;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public Collection<ClassDescriptor> getSealedSubclasses() {
        Collection<ClassDescriptor> sealedSubclasses = this.original.getSealedSubclasses();
        if (sealedSubclasses == null) {
            $$$reportNull$$$0(31);
        }
        return sealedSubclasses;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource
    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        if (sourceElement == null) {
            $$$reportNull$$$0(29);
        }
        return sourceElement;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getStaticScope() {
        MemberScope staticScope = this.original.getStaticScope();
        if (staticScope == null) {
            $$$reportNull$$$0(15);
        }
        return staticScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ReceiverParameterDescriptor getThisAsReceiverParameter() {
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor = this.original.getTypeConstructor();
        if (this.originalSubstitutor.isEmpty()) {
            if (typeConstructor == null) {
                $$$reportNull$$$0(0);
            }
            return typeConstructor;
        }
        if (this.typeConstructor == null) {
            TypeSubstitutor substitutor = getSubstitutor();
            Collection<KotlinType> mo3719getSupertypes = typeConstructor.mo3719getSupertypes();
            ArrayList arrayList = new ArrayList(mo3719getSupertypes.size());
            Iterator<KotlinType> it = mo3719getSupertypes.iterator();
            while (it.hasNext()) {
                arrayList.add(substitutor.substitute(it.next(), Variance.INVARIANT));
            }
            this.typeConstructor = new ClassTypeConstructorImpl(this, this.typeConstructorParameters, arrayList, LockBasedStorageManager.NO_LOCKS);
        }
        TypeConstructor typeConstructor2 = this.typeConstructor;
        if (typeConstructor2 == null) {
            $$$reportNull$$$0(1);
        }
        return typeConstructor2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getUnsubstitutedInnerClassesScope() {
        MemberScope unsubstitutedInnerClassesScope = this.original.getUnsubstitutedInnerClassesScope();
        if (unsubstitutedInnerClassesScope == null) {
            $$$reportNull$$$0(28);
        }
        return unsubstitutedInnerClassesScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getUnsubstitutedMemberScope() {
        MemberScope unsubstitutedMemberScope = getUnsubstitutedMemberScope(DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this.original)));
        if (unsubstitutedMemberScope == null) {
            $$$reportNull$$$0(12);
        }
        return unsubstitutedMemberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    /* renamed from: getUnsubstitutedPrimaryConstructor */
    public ClassConstructorDescriptor mo3684getUnsubstitutedPrimaryConstructor() {
        return this.original.mo3684getUnsubstitutedPrimaryConstructor();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public ValueClassRepresentation<SimpleType> getValueClassRepresentation() {
        ValueClassRepresentation<SimpleType> valueClassRepresentation = this.original.getValueClassRepresentation();
        if (valueClassRepresentation == null) {
            return null;
        }
        return valueClassRepresentation.mapUnderlyingType(new Function1<SimpleType, SimpleType>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.LazySubstitutingClassDescriptor.2
            @Override // kotlin.jvm.functions.Function1
            public SimpleType invoke(SimpleType simpleType) {
                return LazySubstitutingClassDescriptor.this.substituteSimpleType(simpleType);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility visibility = this.original.getVisibility();
        if (visibility == null) {
            $$$reportNull$$$0(27);
        }
        return visibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isActual() {
        return this.original.isActual();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isCompanionObject() {
        return this.original.isCompanionObject();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isData() {
        return this.original.isData();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExpect() {
        return this.original.isExpect();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return this.original.isExternal();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isFun() {
        return this.original.isFun();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isInline() {
        return this.original.isInline();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return this.original.isInner();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public boolean isValue() {
        return this.original.isValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public MemberScope getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            $$$reportNull$$$0(13);
        }
        MemberScope unsubstitutedMemberScope = this.original.getUnsubstitutedMemberScope(kotlinTypeRefiner);
        if (!this.originalSubstitutor.isEmpty()) {
            return new SubstitutingScope(unsubstitutedMemberScope, getSubstitutor());
        }
        if (unsubstitutedMemberScope == null) {
            $$$reportNull$$$0(14);
        }
        return unsubstitutedMemberScope;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public ClassDescriptor substitute(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(23);
        }
        return typeSubstitutor.isEmpty() ? this : new LazySubstitutingClassDescriptor(this, TypeSubstitutor.createChainedSubstitutor(typeSubstitutor.getSubstitution(), getSubstitutor().getSubstitution()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public ClassDescriptor getOriginal() {
        ClassDescriptor original = this.original.getOriginal();
        if (original == null) {
            $$$reportNull$$$0(21);
        }
        return original;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
    public MemberScope getMemberScope(TypeSubstitution typeSubstitution) {
        if (typeSubstitution == null) {
            $$$reportNull$$$0(10);
        }
        MemberScope memberScope = getMemberScope(typeSubstitution, DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
        if (memberScope == null) {
            $$$reportNull$$$0(11);
        }
        return memberScope;
    }
}
