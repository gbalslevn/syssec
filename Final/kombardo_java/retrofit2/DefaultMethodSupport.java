package retrofit2;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* loaded from: classes3.dex */
abstract class DefaultMethodSupport {
    private static Constructor<MethodHandles.Lookup> lookupConstructor;

    /* JADX INFO: Access modifiers changed from: package-private */
    @IgnoreJRERequirement
    public static Object invoke(Method method, Class<?> cls, Object obj, Object[] objArr) {
        Constructor<MethodHandles.Lookup> constructor = lookupConstructor;
        if (constructor == null) {
            constructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            constructor.setAccessible(true);
            lookupConstructor = constructor;
        }
        return constructor.newInstance(cls, -1).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }
}
