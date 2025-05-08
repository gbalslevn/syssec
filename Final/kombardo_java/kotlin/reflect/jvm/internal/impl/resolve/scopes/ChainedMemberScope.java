package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* loaded from: classes3.dex */
public final class ChainedMemberScope implements MemberScope {
    public static final Companion Companion = new Companion(null);
    private final String debugName;
    private final MemberScope[] scopes;

    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MemberScope create(String debugName, Iterable<? extends MemberScope> scopes) {
            Intrinsics.checkNotNullParameter(debugName, "debugName");
            Intrinsics.checkNotNullParameter(scopes, "scopes");
            SmartList smartList = new SmartList();
            for (MemberScope memberScope : scopes) {
                if (memberScope != MemberScope.Empty.INSTANCE) {
                    if (memberScope instanceof ChainedMemberScope) {
                        CollectionsKt.addAll(smartList, ((ChainedMemberScope) memberScope).scopes);
                    } else {
                        smartList.add(memberScope);
                    }
                }
            }
            return createOrSingle$descriptors(debugName, smartList);
        }

        public final MemberScope createOrSingle$descriptors(String debugName, List<? extends MemberScope> scopes) {
            Intrinsics.checkNotNullParameter(debugName, "debugName");
            Intrinsics.checkNotNullParameter(scopes, "scopes");
            int size = scopes.size();
            return size != 0 ? size != 1 ? new ChainedMemberScope(debugName, (MemberScope[]) scopes.toArray(new MemberScope[0]), null) : scopes.get(0) : MemberScope.Empty.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ ChainedMemberScope(String str, MemberScope[] memberScopeArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, memberScopeArr);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getClassifierNames() {
        return MemberScopeKt.flatMapClassifierNamesOrNull(ArraysKt.asIterable(this.scopes));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    /* renamed from: getContributedClassifier */
    public ClassifierDescriptor mo3720getContributedClassifier(Name name, LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        ClassifierDescriptor classifierDescriptor = null;
        for (MemberScope memberScope : this.scopes) {
            ClassifierDescriptor mo3720getContributedClassifier = memberScope.mo3720getContributedClassifier(name, location);
            if (mo3720getContributedClassifier != null) {
                if (!(mo3720getContributedClassifier instanceof ClassifierDescriptorWithTypeParameters) || !((MemberDescriptor) mo3720getContributedClassifier).isExpect()) {
                    return mo3720getContributedClassifier;
                }
                if (classifierDescriptor == null) {
                    classifierDescriptor = mo3720getContributedClassifier;
                }
            }
        }
        return classifierDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope
    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkNotNullParameter(kindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(nameFilter, "nameFilter");
        MemberScope[] memberScopeArr = this.scopes;
        int length = memberScopeArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length == 1) {
            return memberScopeArr[0].getContributedDescriptors(kindFilter, nameFilter);
        }
        Collection<DeclarationDescriptor> collection = null;
        for (MemberScope memberScope : memberScopeArr) {
            collection = ScopeUtilsKt.concat(collection, memberScope.getContributedDescriptors(kindFilter, nameFilter));
        }
        return collection == null ? SetsKt.emptySet() : collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        MemberScope[] memberScopeArr = this.scopes;
        int length = memberScopeArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length == 1) {
            return memberScopeArr[0].getContributedFunctions(name, location);
        }
        Collection<SimpleFunctionDescriptor> collection = null;
        for (MemberScope memberScope : memberScopeArr) {
            collection = ScopeUtilsKt.concat(collection, memberScope.getContributedFunctions(name, location));
        }
        return collection == null ? SetsKt.emptySet() : collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation location) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(location, "location");
        MemberScope[] memberScopeArr = this.scopes;
        int length = memberScopeArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length == 1) {
            return memberScopeArr[0].getContributedVariables(name, location);
        }
        Collection<PropertyDescriptor> collection = null;
        for (MemberScope memberScope : memberScopeArr) {
            collection = ScopeUtilsKt.concat(collection, memberScope.getContributedVariables(name, location));
        }
        return collection == null ? SetsKt.emptySet() : collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getFunctionNames() {
        MemberScope[] memberScopeArr = this.scopes;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : memberScopeArr) {
            CollectionsKt.addAll(linkedHashSet, memberScope.getFunctionNames());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    public Set<Name> getVariableNames() {
        MemberScope[] memberScopeArr = this.scopes;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : memberScopeArr) {
            CollectionsKt.addAll(linkedHashSet, memberScope.getVariableNames());
        }
        return linkedHashSet;
    }

    public String toString() {
        return this.debugName;
    }

    private ChainedMemberScope(String str, MemberScope[] memberScopeArr) {
        this.debugName = str;
        this.scopes = memberScopeArr;
    }
}
