package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Member;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
/* synthetic */ class ReflectJavaClass$fields$1 extends FunctionReferenceImpl implements Function1<Member, Boolean> {
    public static final ReflectJavaClass$fields$1 INSTANCE = new ReflectJavaClass$fields$1();

    ReflectJavaClass$fields$1() {
        super(1, Member.class, "isSynthetic", "isSynthetic()Z", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(Member p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        return Boolean.valueOf(p02.isSynthetic());
    }
}
