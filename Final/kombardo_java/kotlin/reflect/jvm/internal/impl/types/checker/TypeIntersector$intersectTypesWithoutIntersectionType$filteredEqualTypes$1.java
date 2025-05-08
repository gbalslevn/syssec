package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public /* synthetic */ class TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1 extends FunctionReferenceImpl implements Function2<KotlinType, KotlinType, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1(Object obj) {
        super(2, obj, TypeIntersector.class, "isStrictSupertype", "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Boolean invoke(KotlinType p02, KotlinType p12) {
        boolean isStrictSupertype;
        Intrinsics.checkNotNullParameter(p02, "p0");
        Intrinsics.checkNotNullParameter(p12, "p1");
        isStrictSupertype = ((TypeIntersector) this.receiver).isStrictSupertype(p02, p12);
        return Boolean.valueOf(isStrictSupertype);
    }
}
