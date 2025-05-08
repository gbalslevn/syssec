package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* loaded from: classes3.dex */
/* synthetic */ class LazyJavaClassMemberScope$computeNonDeclaredFunctions$3 extends FunctionReferenceImpl implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LazyJavaClassMemberScope$computeNonDeclaredFunctions$3(Object obj) {
        super(1, obj, LazyJavaClassMemberScope.class, "searchMethodsByNameWithoutBuiltinMagic", "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Collection<SimpleFunctionDescriptor> invoke(Name p02) {
        Collection<SimpleFunctionDescriptor> searchMethodsByNameWithoutBuiltinMagic;
        Intrinsics.checkNotNullParameter(p02, "p0");
        searchMethodsByNameWithoutBuiltinMagic = ((LazyJavaClassMemberScope) this.receiver).searchMethodsByNameWithoutBuiltinMagic(p02);
        return searchMethodsByNameWithoutBuiltinMagic;
    }
}
