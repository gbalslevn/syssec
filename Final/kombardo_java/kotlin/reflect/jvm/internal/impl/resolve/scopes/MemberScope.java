package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public interface MemberScope extends ResolutionScope {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Function1<Name, Boolean> ALL_NAME_FILTER = new Function1() { // from class: kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope$Companion$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                boolean ALL_NAME_FILTER$lambda$0;
                ALL_NAME_FILTER$lambda$0 = MemberScope.Companion.ALL_NAME_FILTER$lambda$0((Name) obj);
                return Boolean.valueOf(ALL_NAME_FILTER$lambda$0);
            }
        };

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean ALL_NAME_FILTER$lambda$0(Name it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return true;
        }

        public final Function1<Name, Boolean> getALL_NAME_FILTER() {
            return ALL_NAME_FILTER;
        }
    }

    /* loaded from: classes3.dex */
    public static final class Empty extends MemberScopeImpl {
        public static final Empty INSTANCE = new Empty();

        private Empty() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set<Name> getClassifierNames() {
            return SetsKt.emptySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set<Name> getFunctionNames() {
            return SetsKt.emptySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        public Set<Name> getVariableNames() {
            return SetsKt.emptySet();
        }
    }

    Set<Name> getClassifierNames();

    Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation);

    Collection<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation);

    Set<Name> getFunctionNames();

    Set<Name> getVariableNames();
}
