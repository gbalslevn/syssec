package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Field;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
/* synthetic */ class ReflectJavaClass$fields$2 extends FunctionReferenceImpl implements Function1<Field, ReflectJavaField> {
    public static final ReflectJavaClass$fields$2 INSTANCE = new ReflectJavaClass$fields$2();

    ReflectJavaClass$fields$2() {
        super(1, ReflectJavaField.class, "<init>", "<init>(Ljava/lang/reflect/Field;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ReflectJavaField invoke(Field p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        return new ReflectJavaField(p02);
    }
}
