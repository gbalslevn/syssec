package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.Set;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.RigidTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* loaded from: classes3.dex */
public class TypeCheckerState {
    private final boolean allowedTypeVariable;
    private int argumentsDepth;
    private final boolean isErrorTypeEqualsToAnything;
    private final boolean isStubTypeEqualsToAnything;
    private final AbstractTypePreparator kotlinTypePreparator;
    private final AbstractTypeRefiner kotlinTypeRefiner;
    private ArrayDeque<RigidTypeMarker> supertypesDeque;
    private boolean supertypesLocked;
    private Set<RigidTypeMarker> supertypesSet;
    private final TypeSystemContext typeSystemContext;

    /* loaded from: classes3.dex */
    public interface ForkPointContext {

        /* loaded from: classes3.dex */
        public static final class Default implements ForkPointContext {
            private boolean result;

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.ForkPointContext
            public void fork(Function0<Boolean> block) {
                Intrinsics.checkNotNullParameter(block, "block");
                if (this.result) {
                    return;
                }
                this.result = block.invoke().booleanValue();
            }

            public final boolean getResult() {
                return this.result;
            }
        }

        void fork(Function0<Boolean> function0);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes3.dex */
    public static final class LowerCapturedTypePolicy {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LowerCapturedTypePolicy[] $VALUES;
        public static final LowerCapturedTypePolicy CHECK_ONLY_LOWER = new LowerCapturedTypePolicy("CHECK_ONLY_LOWER", 0);
        public static final LowerCapturedTypePolicy CHECK_SUBTYPE_AND_LOWER = new LowerCapturedTypePolicy("CHECK_SUBTYPE_AND_LOWER", 1);
        public static final LowerCapturedTypePolicy SKIP_LOWER = new LowerCapturedTypePolicy("SKIP_LOWER", 2);

        private static final /* synthetic */ LowerCapturedTypePolicy[] $values() {
            return new LowerCapturedTypePolicy[]{CHECK_ONLY_LOWER, CHECK_SUBTYPE_AND_LOWER, SKIP_LOWER};
        }

        static {
            LowerCapturedTypePolicy[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private LowerCapturedTypePolicy(String str, int i5) {
        }

        public static LowerCapturedTypePolicy valueOf(String str) {
            return (LowerCapturedTypePolicy) Enum.valueOf(LowerCapturedTypePolicy.class, str);
        }

        public static LowerCapturedTypePolicy[] values() {
            return (LowerCapturedTypePolicy[]) $VALUES.clone();
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class SupertypesPolicy {

        /* loaded from: classes3.dex */
        public static abstract class DoCustomTransform extends SupertypesPolicy {
            public DoCustomTransform() {
                super(null);
            }
        }

        /* loaded from: classes3.dex */
        public static final class LowerIfFlexible extends SupertypesPolicy {
            public static final LowerIfFlexible INSTANCE = new LowerIfFlexible();

            private LowerIfFlexible() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy
            /* renamed from: transformType */
            public RigidTypeMarker mo3722transformType(TypeCheckerState state, KotlinTypeMarker type) {
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(type, "type");
                return state.getTypeSystemContext().lowerBoundIfFlexible(type);
            }
        }

        /* loaded from: classes3.dex */
        public static final class None extends SupertypesPolicy {
            public static final None INSTANCE = new None();

            private None() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy
            /* renamed from: transformType, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ RigidTypeMarker mo3722transformType(TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker) {
                return (RigidTypeMarker) transformType(typeCheckerState, kotlinTypeMarker);
            }

            public Void transformType(TypeCheckerState state, KotlinTypeMarker type) {
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(type, "type");
                throw new UnsupportedOperationException("Should not be called");
            }
        }

        /* loaded from: classes3.dex */
        public static final class UpperIfFlexible extends SupertypesPolicy {
            public static final UpperIfFlexible INSTANCE = new UpperIfFlexible();

            private UpperIfFlexible() {
                super(null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.TypeCheckerState.SupertypesPolicy
            /* renamed from: transformType */
            public RigidTypeMarker mo3722transformType(TypeCheckerState state, KotlinTypeMarker type) {
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(type, "type");
                return state.getTypeSystemContext().upperBoundIfFlexible(type);
            }
        }

        public /* synthetic */ SupertypesPolicy(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: transformType */
        public abstract RigidTypeMarker mo3722transformType(TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker);

        private SupertypesPolicy() {
        }
    }

    public TypeCheckerState(boolean z5, boolean z6, boolean z7, TypeSystemContext typeSystemContext, AbstractTypePreparator kotlinTypePreparator, AbstractTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(typeSystemContext, "typeSystemContext");
        Intrinsics.checkNotNullParameter(kotlinTypePreparator, "kotlinTypePreparator");
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        this.isErrorTypeEqualsToAnything = z5;
        this.isStubTypeEqualsToAnything = z6;
        this.allowedTypeVariable = z7;
        this.typeSystemContext = typeSystemContext;
        this.kotlinTypePreparator = kotlinTypePreparator;
        this.kotlinTypeRefiner = kotlinTypeRefiner;
    }

    public static /* synthetic */ Boolean addSubtypeConstraint$default(TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z5, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
        }
        if ((i5 & 4) != 0) {
            z5 = false;
        }
        return typeCheckerState.addSubtypeConstraint(kotlinTypeMarker, kotlinTypeMarker2, z5);
    }

    public Boolean addSubtypeConstraint(KotlinTypeMarker subType, KotlinTypeMarker superType, boolean z5) {
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(superType, "superType");
        return null;
    }

    public final void clear() {
        ArrayDeque<RigidTypeMarker> arrayDeque = this.supertypesDeque;
        Intrinsics.checkNotNull(arrayDeque);
        arrayDeque.clear();
        Set<RigidTypeMarker> set = this.supertypesSet;
        Intrinsics.checkNotNull(set);
        set.clear();
        this.supertypesLocked = false;
    }

    public boolean customIsSubtypeOf(KotlinTypeMarker subType, KotlinTypeMarker superType) {
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(superType, "superType");
        return true;
    }

    public LowerCapturedTypePolicy getLowerCapturedTypePolicy(RigidTypeMarker subType, CapturedTypeMarker superType) {
        Intrinsics.checkNotNullParameter(subType, "subType");
        Intrinsics.checkNotNullParameter(superType, "superType");
        return LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER;
    }

    public final ArrayDeque<RigidTypeMarker> getSupertypesDeque() {
        return this.supertypesDeque;
    }

    public final Set<RigidTypeMarker> getSupertypesSet() {
        return this.supertypesSet;
    }

    public final TypeSystemContext getTypeSystemContext() {
        return this.typeSystemContext;
    }

    public final void initialize() {
        this.supertypesLocked = true;
        if (this.supertypesDeque == null) {
            this.supertypesDeque = new ArrayDeque<>(4);
        }
        if (this.supertypesSet == null) {
            this.supertypesSet = SmartSet.Companion.create();
        }
    }

    public final boolean isAllowedTypeVariable(KotlinTypeMarker type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.allowedTypeVariable && this.typeSystemContext.isTypeVariableType(type);
    }

    public final boolean isErrorTypeEqualsToAnything() {
        return this.isErrorTypeEqualsToAnything;
    }

    public final boolean isStubTypeEqualsToAnything() {
        return this.isStubTypeEqualsToAnything;
    }

    public final KotlinTypeMarker prepareType(KotlinTypeMarker type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.kotlinTypePreparator.prepareType(type);
    }

    public final KotlinTypeMarker refineType(KotlinTypeMarker type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return this.kotlinTypeRefiner.refineType(type);
    }

    public boolean runForkingPoint(Function1<? super ForkPointContext, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ForkPointContext.Default r02 = new ForkPointContext.Default();
        block.invoke(r02);
        return r02.getResult();
    }
}
