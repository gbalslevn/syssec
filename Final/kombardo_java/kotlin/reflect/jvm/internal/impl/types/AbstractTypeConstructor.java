package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefinerKt;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* loaded from: classes3.dex */
public abstract class AbstractTypeConstructor extends ClassifierBasedTypeConstructor {
    private final boolean shouldReportCyclicScopeWithCompanionWarning;
    private final NotNullLazyValue<Supertypes> supertypes;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class ModuleViewTypeConstructor implements TypeConstructor {
        private final KotlinTypeRefiner kotlinTypeRefiner;
        private final Lazy refinedSupertypes$delegate;
        final /* synthetic */ AbstractTypeConstructor this$0;

        public ModuleViewTypeConstructor(final AbstractTypeConstructor abstractTypeConstructor, KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            this.this$0 = abstractTypeConstructor;
            this.kotlinTypeRefiner = kotlinTypeRefiner;
            this.refinedSupertypes$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0(this, abstractTypeConstructor) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$ModuleViewTypeConstructor$$Lambda$0
                private final AbstractTypeConstructor.ModuleViewTypeConstructor arg$0;
                private final AbstractTypeConstructor arg$1;

                {
                    this.arg$0 = this;
                    this.arg$1 = abstractTypeConstructor;
                }

                @Override // kotlin.jvm.functions.Function0
                public Object invoke() {
                    List refinedSupertypes_delegate$lambda$0;
                    refinedSupertypes_delegate$lambda$0 = AbstractTypeConstructor.ModuleViewTypeConstructor.refinedSupertypes_delegate$lambda$0(this.arg$0, this.arg$1);
                    return refinedSupertypes_delegate$lambda$0;
                }
            });
        }

        private final List<KotlinType> getRefinedSupertypes() {
            return (List) this.refinedSupertypes$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List refinedSupertypes_delegate$lambda$0(ModuleViewTypeConstructor moduleViewTypeConstructor, AbstractTypeConstructor abstractTypeConstructor) {
            return KotlinTypeRefinerKt.refineTypes(moduleViewTypeConstructor.kotlinTypeRefiner, abstractTypeConstructor.mo3719getSupertypes());
        }

        public boolean equals(Object obj) {
            return this.this$0.equals(obj);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns builtIns = this.this$0.getBuiltIns();
            Intrinsics.checkNotNullExpressionValue(builtIns, "getBuiltIns(...)");
            return builtIns;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* renamed from: getDeclarationDescriptor */
        public ClassifierDescriptor mo3718getDeclarationDescriptor() {
            return this.this$0.mo3718getDeclarationDescriptor();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> parameters = this.this$0.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
            return parameters;
        }

        public int hashCode() {
            return this.this$0.hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public boolean isDenotable() {
            return this.this$0.isDenotable();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
            return this.this$0.refine(kotlinTypeRefiner);
        }

        public String toString() {
            return this.this$0.toString();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
        /* renamed from: getSupertypes */
        public List<KotlinType> mo3719getSupertypes() {
            return getRefinedSupertypes();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Supertypes {
        private final Collection<KotlinType> allSupertypes;
        private List<? extends KotlinType> supertypesWithoutCycles;

        /* JADX WARN: Multi-variable type inference failed */
        public Supertypes(Collection<? extends KotlinType> allSupertypes) {
            Intrinsics.checkNotNullParameter(allSupertypes, "allSupertypes");
            this.allSupertypes = allSupertypes;
            this.supertypesWithoutCycles = CollectionsKt.listOf(ErrorUtils.INSTANCE.getErrorTypeForLoopInSupertypes());
        }

        public final Collection<KotlinType> getAllSupertypes() {
            return this.allSupertypes;
        }

        public final List<KotlinType> getSupertypesWithoutCycles() {
            return this.supertypesWithoutCycles;
        }

        public final void setSupertypesWithoutCycles(List<? extends KotlinType> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.supertypesWithoutCycles = list;
        }
    }

    public AbstractTypeConstructor(StorageManager storageManager) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        this.supertypes = storageManager.createLazyValueWithPostCompute(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$0
            private final AbstractTypeConstructor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                AbstractTypeConstructor.Supertypes supertypes$lambda$0;
                supertypes$lambda$0 = AbstractTypeConstructor.supertypes$lambda$0(this.arg$0);
                return supertypes$lambda$0;
            }
        }, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$1
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                AbstractTypeConstructor.Supertypes supertypes$lambda$1;
                supertypes$lambda$1 = AbstractTypeConstructor.supertypes$lambda$1(((Boolean) obj).booleanValue());
                return supertypes$lambda$1;
            }
        }, new Function1(this) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$2
            private final AbstractTypeConstructor arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit supertypes$lambda$7;
                supertypes$lambda$7 = AbstractTypeConstructor.supertypes$lambda$7(this.arg$0, (AbstractTypeConstructor.Supertypes) obj);
                return supertypes$lambda$7;
            }
        });
    }

    private final Collection<KotlinType> computeNeighbours(TypeConstructor typeConstructor, boolean z5) {
        List plus;
        AbstractTypeConstructor abstractTypeConstructor = typeConstructor instanceof AbstractTypeConstructor ? (AbstractTypeConstructor) typeConstructor : null;
        if (abstractTypeConstructor != null && (plus = CollectionsKt.plus((Collection) abstractTypeConstructor.supertypes.invoke().getAllSupertypes(), (Iterable) abstractTypeConstructor.getAdditionalNeighboursInSupertypeGraph(z5))) != null) {
            return plus;
        }
        Collection<KotlinType> mo3719getSupertypes = typeConstructor.mo3719getSupertypes();
        Intrinsics.checkNotNullExpressionValue(mo3719getSupertypes, "getSupertypes(...)");
        return mo3719getSupertypes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Supertypes supertypes$lambda$0(AbstractTypeConstructor abstractTypeConstructor) {
        return new Supertypes(abstractTypeConstructor.computeSupertypes());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Supertypes supertypes$lambda$1(boolean z5) {
        return new Supertypes(CollectionsKt.listOf(ErrorUtils.INSTANCE.getErrorTypeForLoopInSupertypes()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit supertypes$lambda$7(final AbstractTypeConstructor abstractTypeConstructor, Supertypes supertypes) {
        Intrinsics.checkNotNullParameter(supertypes, "supertypes");
        List findLoopsInSupertypesAndDisconnect = abstractTypeConstructor.getSupertypeLoopChecker().findLoopsInSupertypesAndDisconnect(abstractTypeConstructor, supertypes.getAllSupertypes(), new Function1(abstractTypeConstructor) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$3
            private final AbstractTypeConstructor arg$0;

            {
                this.arg$0 = abstractTypeConstructor;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Iterable supertypes$lambda$7$lambda$2;
                supertypes$lambda$7$lambda$2 = AbstractTypeConstructor.supertypes$lambda$7$lambda$2(this.arg$0, (TypeConstructor) obj);
                return supertypes$lambda$7$lambda$2;
            }
        }, new Function1(abstractTypeConstructor) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$4
            private final AbstractTypeConstructor arg$0;

            {
                this.arg$0 = abstractTypeConstructor;
            }

            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                Unit supertypes$lambda$7$lambda$3;
                supertypes$lambda$7$lambda$3 = AbstractTypeConstructor.supertypes$lambda$7$lambda$3(this.arg$0, (KotlinType) obj);
                return supertypes$lambda$7$lambda$3;
            }
        });
        if (findLoopsInSupertypesAndDisconnect.isEmpty()) {
            KotlinType defaultSupertypeIfEmpty = abstractTypeConstructor.defaultSupertypeIfEmpty();
            List listOf = defaultSupertypeIfEmpty != null ? CollectionsKt.listOf(defaultSupertypeIfEmpty) : null;
            if (listOf == null) {
                listOf = CollectionsKt.emptyList();
            }
            findLoopsInSupertypesAndDisconnect = listOf;
        }
        if (abstractTypeConstructor.getShouldReportCyclicScopeWithCompanionWarning()) {
            abstractTypeConstructor.getSupertypeLoopChecker().findLoopsInSupertypesAndDisconnect(abstractTypeConstructor, findLoopsInSupertypesAndDisconnect, new Function1(abstractTypeConstructor) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$5
                private final AbstractTypeConstructor arg$0;

                {
                    this.arg$0 = abstractTypeConstructor;
                }

                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    Iterable supertypes$lambda$7$lambda$5;
                    supertypes$lambda$7$lambda$5 = AbstractTypeConstructor.supertypes$lambda$7$lambda$5(this.arg$0, (TypeConstructor) obj);
                    return supertypes$lambda$7$lambda$5;
                }
            }, new Function1(abstractTypeConstructor) { // from class: kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor$$Lambda$6
                private final AbstractTypeConstructor arg$0;

                {
                    this.arg$0 = abstractTypeConstructor;
                }

                @Override // kotlin.jvm.functions.Function1
                public Object invoke(Object obj) {
                    Unit supertypes$lambda$7$lambda$6;
                    supertypes$lambda$7$lambda$6 = AbstractTypeConstructor.supertypes$lambda$7$lambda$6(this.arg$0, (KotlinType) obj);
                    return supertypes$lambda$7$lambda$6;
                }
            });
        }
        List<KotlinType> list = findLoopsInSupertypesAndDisconnect instanceof List ? (List) findLoopsInSupertypesAndDisconnect : null;
        if (list == null) {
            list = CollectionsKt.toList(findLoopsInSupertypesAndDisconnect);
        }
        supertypes.setSupertypesWithoutCycles(abstractTypeConstructor.processSupertypesWithoutCycles(list));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable supertypes$lambda$7$lambda$2(AbstractTypeConstructor abstractTypeConstructor, TypeConstructor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return abstractTypeConstructor.computeNeighbours(it, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit supertypes$lambda$7$lambda$3(AbstractTypeConstructor abstractTypeConstructor, KotlinType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        abstractTypeConstructor.reportSupertypeLoopError(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Iterable supertypes$lambda$7$lambda$5(AbstractTypeConstructor abstractTypeConstructor, TypeConstructor it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return abstractTypeConstructor.computeNeighbours(it, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit supertypes$lambda$7$lambda$6(AbstractTypeConstructor abstractTypeConstructor, KotlinType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        abstractTypeConstructor.reportScopesLoopError(it);
        return Unit.INSTANCE;
    }

    protected abstract Collection<KotlinType> computeSupertypes();

    protected abstract KotlinType defaultSupertypeIfEmpty();

    protected Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean z5) {
        return CollectionsKt.emptyList();
    }

    protected boolean getShouldReportCyclicScopeWithCompanionWarning() {
        return this.shouldReportCyclicScopeWithCompanionWarning;
    }

    protected abstract SupertypeLoopChecker getSupertypeLoopChecker();

    protected List<KotlinType> processSupertypesWithoutCycles(List<KotlinType> supertypes) {
        Intrinsics.checkNotNullParameter(supertypes, "supertypes");
        return supertypes;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new ModuleViewTypeConstructor(this, kotlinTypeRefiner);
    }

    protected void reportScopesLoopError(KotlinType type) {
        Intrinsics.checkNotNullParameter(type, "type");
    }

    protected void reportSupertypeLoopError(KotlinType type) {
        Intrinsics.checkNotNullParameter(type, "type");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getSupertypes */
    public List<KotlinType> mo3719getSupertypes() {
        return this.supertypes.invoke().getSupertypesWithoutCycles();
    }
}
