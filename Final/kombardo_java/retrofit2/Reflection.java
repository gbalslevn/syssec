package retrofit2;

import android.annotation.TargetApi;
import androidx.appcompat.R$styleable;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* loaded from: classes3.dex */
class Reflection {

    @TargetApi(R$styleable.Toolbar_titleMarginEnd)
    @IgnoreJRERequirement
    /* loaded from: classes3.dex */
    static final class Android24 extends Reflection {
        @Override // retrofit2.Reflection
        Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object[] objArr) {
            return DefaultMethodSupport.invoke(method, cls, obj, objArr);
        }

        @Override // retrofit2.Reflection
        boolean isDefaultMethod(Method method) {
            return method.isDefault();
        }
    }

    @IgnoreJRERequirement
    /* loaded from: classes3.dex */
    static class Java8 extends Reflection {
        @Override // retrofit2.Reflection
        String describeMethodParameter(Method method, int i5) {
            Parameter parameter = method.getParameters()[i5];
            if (!parameter.isNamePresent()) {
                return super.describeMethodParameter(method, i5);
            }
            return "parameter '" + parameter.getName() + '\'';
        }

        @Override // retrofit2.Reflection
        Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object[] objArr) {
            return DefaultMethodSupport.invoke(method, cls, obj, objArr);
        }

        @Override // retrofit2.Reflection
        boolean isDefaultMethod(Method method) {
            return method.isDefault();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String describeMethodParameter(Method method, int i5) {
        return "parameter #" + (i5 + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object[] objArr) {
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isDefaultMethod(Method method) {
        return false;
    }
}
