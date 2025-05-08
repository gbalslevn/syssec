package kotlin.jvm.internal;

/* loaded from: classes2.dex */
public class PropertyReference2Impl extends PropertyReference2 {
    public PropertyReference2Impl(Class cls, String str, String str2, int i5) {
        super(cls, str, str2, i5);
    }

    @Override // kotlin.reflect.KProperty2
    public Object get(Object obj, Object obj2) {
        return getGetter().call(obj, obj2);
    }
}
