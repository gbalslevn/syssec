package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
public interface Converter<F, T> {

    /* loaded from: classes3.dex */
    public static abstract class Factory {
        /* JADX INFO: Access modifiers changed from: protected */
        public static Type getParameterUpperBound(int i5, ParameterizedType parameterizedType) {
            return Utils.getParameterUpperBound(i5, parameterizedType);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static Class<?> getRawType(Type type) {
            return Utils.getRawType(type);
        }

        public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
            return null;
        }

        public abstract Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit);

        public Converter<?, String> stringConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return null;
        }
    }

    T convert(F f5);
}
