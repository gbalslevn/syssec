package retrofit2;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class Invocation {
    private final List<?> arguments;
    private final Object instance;
    private final Method method;
    private final Class<?> service;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Invocation(Class<?> cls, Object obj, Method method, List<?> list) {
        this.service = cls;
        this.instance = obj;
        this.method = method;
        this.arguments = Collections.unmodifiableList(list);
    }

    public Method method() {
        return this.method;
    }

    public Class<?> service() {
        return this.service;
    }

    public String toString() {
        return String.format("%s.%s() %s", this.service.getName(), this.method.getName(), this.arguments);
    }
}
