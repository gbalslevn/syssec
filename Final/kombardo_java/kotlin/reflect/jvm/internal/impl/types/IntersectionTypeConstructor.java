package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;

/* loaded from: classes3.dex */
public final class IntersectionTypeConstructor implements TypeConstructor, IntersectionTypeConstructorMarker {
    private KotlinType alternative;
    private final int hashCode;
    private final LinkedHashSet<KotlinType> intersectedTypes;

    public IntersectionTypeConstructor(Collection<? extends KotlinType> typesToIntersect) {
        Intrinsics.checkNotNullParameter(typesToIntersect, "typesToIntersect");
        typesToIntersect.isEmpty();
        LinkedHashSet<KotlinType> linkedHashSet = new LinkedHashSet<>(typesToIntersect);
        this.intersectedTypes = linkedHashSet;
        this.hashCode = linkedHashSet.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SimpleType createType$lambda$4(IntersectionTypeConstructor intersectionTypeConstructor, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return intersectionTypeConstructor.refine(kotlinTypeRefiner).createType();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String makeDebugNameForIntersectionType$default(IntersectionTypeConstructor intersectionTypeConstructor, Function1 function1, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            function1 = new Function1() { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$$Lambda$1
                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj2) {
                    String makeDebugNameForIntersectionType$lambda$1;
                    makeDebugNameForIntersectionType$lambda$1 = IntersectionTypeConstructor.makeDebugNameForIntersectionType$lambda$1((KotlinType) obj2);
                    return makeDebugNameForIntersectionType$lambda$1;
                }
            };
        }
        return intersectionTypeConstructor.makeDebugNameForIntersectionType(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String makeDebugNameForIntersectionType$lambda$1(KotlinType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence makeDebugNameForIntersectionType$lambda$3(Function1 function1, KotlinType kotlinType) {
        Intrinsics.checkNotNull(kotlinType);
        return function1.invoke(kotlinType).toString();
    }

    public final MemberScope createScopeForKotlinType() {
        return TypeIntersectionScope.Companion.create("member scope for intersection type", this.intersectedTypes);
    }

    public final SimpleType createType() {
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(TypeAttributes.Companion.getEmpty(), this, CollectionsKt.emptyList(), false, createScopeForKotlinType(), new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$$Lambda$2
            private final IntersectionTypeConstructor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                SimpleType createType$lambda$4;
                createType$lambda$4 = IntersectionTypeConstructor.createType$lambda$4(this.arg$0, (KotlinTypeRefiner) obj);
                return createType$lambda$4;
            }
        });
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IntersectionTypeConstructor) {
            return Intrinsics.areEqual(this.intersectedTypes, ((IntersectionTypeConstructor) obj).intersectedTypes);
        }
        return false;
    }

    public final KotlinType getAlternativeType() {
        return this.alternative;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns builtIns = this.intersectedTypes.iterator().next().getConstructor().getBuiltIns();
        Intrinsics.checkNotNullExpressionValue(builtIns, "getBuiltIns(...)");
        return builtIns;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getDeclarationDescriptor */
    public ClassifierDescriptor mo3718getDeclarationDescriptor() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getSupertypes */
    public Collection<KotlinType> mo3719getSupertypes() {
        return this.intersectedTypes;
    }

    public int hashCode() {
        return this.hashCode;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    public final String makeDebugNameForIntersectionType(final Function1<? super KotlinType, ? extends Object> getProperTypeRelatedToStringify) {
        Intrinsics.checkNotNullParameter(getProperTypeRelatedToStringify, "getProperTypeRelatedToStringify");
        return CollectionsKt.joinToString$default(CollectionsKt.sortedWith(this.intersectedTypes, new Comparator() { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$makeDebugNameForIntersectionType$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t5, T t6) {
                KotlinType kotlinType = (KotlinType) t5;
                Function1 function1 = Function1.this;
                Intrinsics.checkNotNull(kotlinType);
                String obj = function1.invoke(kotlinType).toString();
                KotlinType kotlinType2 = (KotlinType) t6;
                Function1 function12 = Function1.this;
                Intrinsics.checkNotNull(kotlinType2);
                return ComparisonsKt.compareValues(obj, function12.invoke(kotlinType2).toString());
            }
        }), " & ", "{", "}", 0, null, new Function1(getProperTypeRelatedToStringify) { // from class: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor$$Lambda$0
            private final Function1 arg$0;

            {
                this.arg$0 = getProperTypeRelatedToStringify;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                CharSequence makeDebugNameForIntersectionType$lambda$3;
                makeDebugNameForIntersectionType$lambda$3 = IntersectionTypeConstructor.makeDebugNameForIntersectionType$lambda$3(this.arg$0, (KotlinType) obj);
                return makeDebugNameForIntersectionType$lambda$3;
            }
        }, 24, null);
    }

    public final IntersectionTypeConstructor setAlternative(KotlinType kotlinType) {
        return new IntersectionTypeConstructor(this.intersectedTypes, kotlinType);
    }

    public String toString() {
        return makeDebugNameForIntersectionType$default(this, null, 1, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public IntersectionTypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        Collection<KotlinType> mo3719getSupertypes = mo3719getSupertypes();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(mo3719getSupertypes, 10));
        Iterator<T> it = mo3719getSupertypes.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            arrayList.add(((KotlinType) it.next()).refine(kotlinTypeRefiner));
            z5 = true;
        }
        IntersectionTypeConstructor intersectionTypeConstructor = null;
        if (z5) {
            KotlinType alternativeType = getAlternativeType();
            intersectionTypeConstructor = new IntersectionTypeConstructor(arrayList).setAlternative(alternativeType != null ? alternativeType.refine(kotlinTypeRefiner) : null);
        }
        return intersectionTypeConstructor == null ? this : intersectionTypeConstructor;
    }

    private IntersectionTypeConstructor(Collection<? extends KotlinType> collection, KotlinType kotlinType) {
        this(collection);
        this.alternative = kotlinType;
    }
}
