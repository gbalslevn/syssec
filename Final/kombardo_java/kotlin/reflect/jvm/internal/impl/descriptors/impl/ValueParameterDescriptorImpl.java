package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* loaded from: classes3.dex */
public class ValueParameterDescriptorImpl extends VariableDescriptorImpl implements ValueParameterDescriptor {
    public static final Companion Companion = new Companion(null);
    private final boolean declaresDefaultValue;
    private final int index;
    private final boolean isCrossinline;
    private final boolean isNoinline;
    private final ValueParameterDescriptor original;
    private final KotlinType varargElementType;

    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ValueParameterDescriptorImpl createWithDestructuringDeclarations(CallableDescriptor containingDeclaration, ValueParameterDescriptor valueParameterDescriptor, int i5, Annotations annotations, Name name, KotlinType outType, boolean z5, boolean z6, boolean z7, KotlinType kotlinType, SourceElement source, Function0<? extends List<? extends VariableDescriptor>> function0) {
            Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
            Intrinsics.checkNotNullParameter(annotations, "annotations");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(outType, "outType");
            Intrinsics.checkNotNullParameter(source, "source");
            return function0 == null ? new ValueParameterDescriptorImpl(containingDeclaration, valueParameterDescriptor, i5, annotations, name, outType, z5, z6, z7, kotlinType, source) : new WithDestructuringDeclaration(containingDeclaration, valueParameterDescriptor, i5, annotations, name, outType, z5, z6, z7, kotlinType, source, function0);
        }

        private Companion() {
        }
    }

    /* loaded from: classes3.dex */
    public static final class WithDestructuringDeclaration extends ValueParameterDescriptorImpl {
        private final Lazy destructuringVariables$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WithDestructuringDeclaration(CallableDescriptor containingDeclaration, ValueParameterDescriptor valueParameterDescriptor, int i5, Annotations annotations, Name name, KotlinType outType, boolean z5, boolean z6, boolean z7, KotlinType kotlinType, SourceElement source, Function0<? extends List<? extends VariableDescriptor>> destructuringVariables) {
            super(containingDeclaration, valueParameterDescriptor, i5, annotations, name, outType, z5, z6, z7, kotlinType, source);
            Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
            Intrinsics.checkNotNullParameter(annotations, "annotations");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(outType, "outType");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(destructuringVariables, "destructuringVariables");
            this.destructuringVariables$delegate = LazyKt.lazy(destructuringVariables);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
        public ValueParameterDescriptor copy(CallableDescriptor newOwner, Name newName, int i5) {
            Intrinsics.checkNotNullParameter(newOwner, "newOwner");
            Intrinsics.checkNotNullParameter(newName, "newName");
            Annotations annotations = getAnnotations();
            Intrinsics.checkNotNullExpressionValue(annotations, "<get-annotations>(...)");
            KotlinType type = getType();
            Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            boolean declaresDefaultValue = declaresDefaultValue();
            boolean isCrossinline = isCrossinline();
            boolean isNoinline = isNoinline();
            KotlinType varargElementType = getVarargElementType();
            SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
            return new WithDestructuringDeclaration(newOwner, null, i5, annotations, newName, type, declaresDefaultValue, isCrossinline, isNoinline, varargElementType, NO_SOURCE, new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl$WithDestructuringDeclaration$$Lambda$0
                private final ValueParameterDescriptorImpl.WithDestructuringDeclaration arg$0;

                {
                    this.arg$0 = this;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List destructuringVariables;
                    destructuringVariables = this.arg$0.getDestructuringVariables();
                    return destructuringVariables;
                }
            });
        }

        public final List<VariableDescriptor> getDestructuringVariables() {
            return (List) this.destructuringVariables$delegate.getValue();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ValueParameterDescriptorImpl(CallableDescriptor containingDeclaration, ValueParameterDescriptor valueParameterDescriptor, int i5, Annotations annotations, Name name, KotlinType outType, boolean z5, boolean z6, boolean z7, KotlinType kotlinType, SourceElement source) {
        super(containingDeclaration, annotations, name, outType, source);
        Intrinsics.checkNotNullParameter(containingDeclaration, "containingDeclaration");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(outType, "outType");
        Intrinsics.checkNotNullParameter(source, "source");
        this.index = i5;
        this.declaresDefaultValue = z5;
        this.isCrossinline = z6;
        this.isNoinline = z7;
        this.varargElementType = kotlinType;
        this.original = valueParameterDescriptor == null ? this : valueParameterDescriptor;
    }

    public static final ValueParameterDescriptorImpl createWithDestructuringDeclarations(CallableDescriptor callableDescriptor, ValueParameterDescriptor valueParameterDescriptor, int i5, Annotations annotations, Name name, KotlinType kotlinType, boolean z5, boolean z6, boolean z7, KotlinType kotlinType2, SourceElement sourceElement, Function0<? extends List<? extends VariableDescriptor>> function0) {
        return Companion.createWithDestructuringDeclarations(callableDescriptor, valueParameterDescriptor, i5, annotations, name, kotlinType, z5, z6, z7, kotlinType2, sourceElement, function0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> visitor, D d5) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        return visitor.visitValueParameterDescriptor(this, d5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public ValueParameterDescriptor copy(CallableDescriptor newOwner, Name newName, int i5) {
        Intrinsics.checkNotNullParameter(newOwner, "newOwner");
        Intrinsics.checkNotNullParameter(newName, "newName");
        Annotations annotations = getAnnotations();
        Intrinsics.checkNotNullExpressionValue(annotations, "<get-annotations>(...)");
        KotlinType type = getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        boolean declaresDefaultValue = declaresDefaultValue();
        boolean isCrossinline = isCrossinline();
        boolean isNoinline = isNoinline();
        KotlinType varargElementType = getVarargElementType();
        SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
        return new ValueParameterDescriptorImpl(newOwner, null, i5, annotations, newName, type, declaresDefaultValue, isCrossinline, isNoinline, varargElementType, NO_SOURCE);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public boolean declaresDefaultValue() {
        if (this.declaresDefaultValue) {
            CallableDescriptor containingDeclaration = getContainingDeclaration();
            Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
            if (((CallableMemberDescriptor) containingDeclaration).getKind().isReal()) {
                return true;
            }
        }
        return false;
    }

    public Void getCompileTimeInitializer() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public int getIndex() {
        return this.index;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    public Collection<ValueParameterDescriptor> getOverriddenDescriptors() {
        Collection<? extends CallableDescriptor> overriddenDescriptors = getContainingDeclaration().getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "getOverriddenDescriptors(...)");
        Collection<? extends CallableDescriptor> collection = overriddenDescriptors;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((CallableDescriptor) it.next()).getValueParameters().get(getIndex()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public KotlinType getVarargElementType() {
        return this.varargElementType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility
    public DescriptorVisibility getVisibility() {
        DescriptorVisibility LOCAL = DescriptorVisibilities.LOCAL;
        Intrinsics.checkNotNullExpressionValue(LOCAL, "LOCAL");
        return LOCAL;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public boolean isCrossinline() {
        return this.isCrossinline;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor
    public boolean isNoinline() {
        return this.isNoinline;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    public boolean isVar() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor
    /* renamed from: getCompileTimeInitializer, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ ConstantValue mo3686getCompileTimeInitializer() {
        return (ConstantValue) getCompileTimeInitializer();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public CallableDescriptor getContainingDeclaration() {
        DeclarationDescriptor containingDeclaration = super.getContainingDeclaration();
        Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        return (CallableDescriptor) containingDeclaration;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public ValueParameterDescriptor substitute(TypeSubstitutor substitutor) {
        Intrinsics.checkNotNullParameter(substitutor, "substitutor");
        if (substitutor.isEmpty()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public ValueParameterDescriptor getOriginal() {
        ValueParameterDescriptor valueParameterDescriptor = this.original;
        return valueParameterDescriptor == this ? this : valueParameterDescriptor.getOriginal();
    }
}
