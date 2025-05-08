package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
abstract class ServiceMethod<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> ServiceMethod<T> parseAnnotations(Retrofit retrofit, Class<?> cls, Method method) {
        RequestFactory parseAnnotations = RequestFactory.parseAnnotations(retrofit, cls, method);
        Type genericReturnType = method.getGenericReturnType();
        if (Utils.hasUnresolvableType(genericReturnType)) {
            throw Utils.methodError(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
        }
        if (genericReturnType != Void.TYPE) {
            return HttpServiceMethod.parseAnnotations(retrofit, method, parseAnnotations);
        }
        throw Utils.methodError(method, "Service methods cannot return void.", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T invoke(Object obj, Object[] objArr);
}
