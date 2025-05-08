package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* loaded from: classes3.dex */
/* synthetic */ class LazyJavaClassMemberScope$computeNonDeclaredFunctions$4 extends FunctionReferenceImpl implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LazyJavaClassMemberScope$computeNonDeclaredFunctions$4(Object obj) {
        super(1, obj, LazyJavaClassMemberScope.class, "searchMethodsInSupertypesWithoutBuiltinMagic", "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Collection<SimpleFunctionDescriptor> invoke(Name p02) {
        Collection<SimpleFunctionDescriptor> searchMethodsInSupertypesWithoutBuiltinMagic;
        Intrinsics.checkNotNullParameter(p02, "p0");
        searchMethodsInSupertypesWithoutBuiltinMagic = ((LazyJavaClassMemberScope) this.receiver).searchMethodsInSupertypesWithoutBuiltinMagic(p02);
        return searchMethodsInSupertypesWithoutBuiltinMagic;
    }
}
