package kotlin.jvm.internal;

/* loaded from: classes2.dex */
public class MutablePropertyReference1Impl extends MutablePropertyReference1 {
    public MutablePropertyReference1Impl(Class cls, String str, String str2, int i5) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i5);
    }

    @Override // kotlin.reflect.KProperty1
    public Object get(Object obj) {
        return getGetter().call(obj);
    }
}
