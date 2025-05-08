package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class ParameterHandler<T> {

    /* loaded from: classes3.dex */
    static final class Body<T> extends ParameterHandler<T> {
        private final Converter<T, RequestBody> converter;
        private final Method method;

        /* renamed from: p, reason: collision with root package name */
        private final int f6924p;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Body(Method method, int i5, Converter<T, RequestBody> converter) {
            this.method = method;
            this.f6924p = i5;
            this.converter = converter;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, T t5) {
            if (t5 == null) {
                throw Utils.parameterError(this.method, this.f6924p, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                requestBuilder.setBody(this.converter.convert(t5));
            } catch (IOException e5) {
                throw Utils.parameterError(this.method, e5, this.f6924p, "Unable to convert " + t5 + " to RequestBody", new Object[0]);
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class Field<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Field(String str, Converter<T, String> converter, boolean z5) {
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
            this.encoded = z5;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, T t5) {
            String convert;
            if (t5 == null || (convert = this.valueConverter.convert(t5)) == null) {
                return;
            }
            requestBuilder.addFormField(this.name, convert, this.encoded);
        }
    }

    /* loaded from: classes3.dex */
    static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Method method;

        /* renamed from: p, reason: collision with root package name */
        private final int f6925p;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public FieldMap(Method method, int i5, Converter<T, String> converter, boolean z5) {
            this.method = method;
            this.f6925p = i5;
            this.valueConverter = converter;
            this.encoded = z5;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, Map<String, T> map) {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value == null) {
                            throw Utils.parameterError(this.method, this.f6925p, "Field map contained null value for key '" + key + "'.", new Object[0]);
                        }
                        String convert = this.valueConverter.convert(value);
                        if (convert != null) {
                            requestBuilder.addFormField(key, convert, this.encoded);
                        } else {
                            throw Utils.parameterError(this.method, this.f6925p, "Field map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.f6925p, "Field map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.f6925p, "Field map was null.", new Object[0]);
        }
    }

    /* loaded from: classes3.dex */
    static final class Header<T> extends ParameterHandler<T> {
        private final boolean allowUnsafeNonAsciiValues;
        private final String name;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Header(String str, Converter<T, String> converter, boolean z5) {
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
            this.allowUnsafeNonAsciiValues = z5;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, T t5) {
            String convert;
            if (t5 == null || (convert = this.valueConverter.convert(t5)) == null) {
                return;
            }
            requestBuilder.addHeader(this.name, convert, this.allowUnsafeNonAsciiValues);
        }
    }

    /* loaded from: classes3.dex */
    static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean allowUnsafeNonAsciiValues;
        private final Method method;

        /* renamed from: p, reason: collision with root package name */
        private final int f6926p;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public HeaderMap(Method method, int i5, Converter<T, String> converter, boolean z5) {
            this.method = method;
            this.f6926p = i5;
            this.valueConverter = converter;
            this.allowUnsafeNonAsciiValues = z5;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, Map<String, T> map) {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value == null) {
                            throw Utils.parameterError(this.method, this.f6926p, "Header map contained null value for key '" + key + "'.", new Object[0]);
                        }
                        requestBuilder.addHeader(key, this.valueConverter.convert(value), this.allowUnsafeNonAsciiValues);
                    } else {
                        throw Utils.parameterError(this.method, this.f6926p, "Header map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.f6926p, "Header map was null.", new Object[0]);
        }
    }

    /* loaded from: classes3.dex */
    static final class Headers extends ParameterHandler<okhttp3.Headers> {
        private final Method method;

        /* renamed from: p, reason: collision with root package name */
        private final int f6927p;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Headers(Method method, int i5) {
            this.method = method;
            this.f6927p = i5;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, okhttp3.Headers headers) {
            if (headers != null) {
                requestBuilder.addHeaders(headers);
                return;
            }
            throw Utils.parameterError(this.method, this.f6927p, "Headers parameter must not be null.", new Object[0]);
        }
    }

    /* loaded from: classes3.dex */
    static final class Part<T> extends ParameterHandler<T> {
        private final Converter<T, RequestBody> converter;
        private final okhttp3.Headers headers;
        private final Method method;

        /* renamed from: p, reason: collision with root package name */
        private final int f6928p;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Part(Method method, int i5, okhttp3.Headers headers, Converter<T, RequestBody> converter) {
            this.method = method;
            this.f6928p = i5;
            this.headers = headers;
            this.converter = converter;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, T t5) {
            if (t5 == null) {
                return;
            }
            try {
                requestBuilder.addPart(this.headers, this.converter.convert(t5));
            } catch (IOException e5) {
                throw Utils.parameterError(this.method, this.f6928p, "Unable to convert " + t5 + " to RequestBody", e5);
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        private final Method method;

        /* renamed from: p, reason: collision with root package name */
        private final int f6929p;
        private final String transferEncoding;
        private final Converter<T, RequestBody> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public PartMap(Method method, int i5, Converter<T, RequestBody> converter, String str) {
            this.method = method;
            this.f6929p = i5;
            this.valueConverter = converter;
            this.transferEncoding = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, Map<String, T> map) {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value == null) {
                            throw Utils.parameterError(this.method, this.f6929p, "Part map contained null value for key '" + key + "'.", new Object[0]);
                        }
                        requestBuilder.addPart(okhttp3.Headers.of("Content-Disposition", "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.transferEncoding), this.valueConverter.convert(value));
                    } else {
                        throw Utils.parameterError(this.method, this.f6929p, "Part map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.f6929p, "Part map was null.", new Object[0]);
        }
    }

    /* loaded from: classes3.dex */
    static final class Path<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Method method;
        private final String name;

        /* renamed from: p, reason: collision with root package name */
        private final int f6930p;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Path(Method method, int i5, String str, Converter<T, String> converter, boolean z5) {
            this.method = method;
            this.f6930p = i5;
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
            this.encoded = z5;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, T t5) {
            if (t5 != null) {
                requestBuilder.addPathParam(this.name, this.valueConverter.convert(t5), this.encoded);
                return;
            }
            throw Utils.parameterError(this.method, this.f6930p, "Path parameter \"" + this.name + "\" value must not be null.", new Object[0]);
        }
    }

    /* loaded from: classes3.dex */
    static final class Query<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Query(String str, Converter<T, String> converter, boolean z5) {
            Objects.requireNonNull(str, "name == null");
            this.name = str;
            this.valueConverter = converter;
            this.encoded = z5;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, T t5) {
            String convert;
            if (t5 == null || (convert = this.valueConverter.convert(t5)) == null) {
                return;
            }
            requestBuilder.addQueryParam(this.name, convert, this.encoded);
        }
    }

    /* loaded from: classes3.dex */
    static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Method method;

        /* renamed from: p, reason: collision with root package name */
        private final int f6931p;
        private final Converter<T, String> valueConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public QueryMap(Method method, int i5, Converter<T, String> converter, boolean z5) {
            this.method = method;
            this.f6931p = i5;
            this.valueConverter = converter;
            this.encoded = z5;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, Map<String, T> map) {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value == null) {
                            throw Utils.parameterError(this.method, this.f6931p, "Query map contained null value for key '" + key + "'.", new Object[0]);
                        }
                        String convert = this.valueConverter.convert(value);
                        if (convert != null) {
                            requestBuilder.addQueryParam(key, convert, this.encoded);
                        } else {
                            throw Utils.parameterError(this.method, this.f6931p, "Query map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.f6931p, "Query map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.f6931p, "Query map was null", new Object[0]);
        }
    }

    /* loaded from: classes3.dex */
    static final class QueryName<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Converter<T, String> nameConverter;

        /* JADX INFO: Access modifiers changed from: package-private */
        public QueryName(Converter<T, String> converter, boolean z5) {
            this.nameConverter = converter;
            this.encoded = z5;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, T t5) {
            if (t5 == null) {
                return;
            }
            requestBuilder.addQueryParam(this.nameConverter.convert(t5), null, this.encoded);
        }
    }

    /* loaded from: classes3.dex */
    static final class RawPart extends ParameterHandler<MultipartBody.Part> {
        static final RawPart INSTANCE = new RawPart();

        private RawPart() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, MultipartBody.Part part) {
            if (part != null) {
                requestBuilder.addPart(part);
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class RelativeUrl extends ParameterHandler<Object> {
        private final Method method;

        /* renamed from: p, reason: collision with root package name */
        private final int f6932p;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RelativeUrl(Method method, int i5) {
            this.method = method;
            this.f6932p = i5;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, Object obj) {
            if (obj == null) {
                throw Utils.parameterError(this.method, this.f6932p, "@Url parameter is null.", new Object[0]);
            }
            requestBuilder.setRelativeUrl(obj);
        }
    }

    /* loaded from: classes3.dex */
    static final class Tag<T> extends ParameterHandler<T> {
        final Class<T> cls;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Tag(Class<T> cls) {
            this.cls = cls;
        }

        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, T t5) {
            requestBuilder.addTag(this.cls, t5);
        }
    }

    ParameterHandler() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void apply(RequestBuilder requestBuilder, T t5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ParameterHandler<Object> array() {
        return new ParameterHandler<Object>() { // from class: retrofit2.ParameterHandler.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // retrofit2.ParameterHandler
            void apply(RequestBuilder requestBuilder, Object obj) {
                if (obj == null) {
                    return;
                }
                int length = Array.getLength(obj);
                for (int i5 = 0; i5 < length; i5++) {
                    ParameterHandler.this.apply(requestBuilder, Array.get(obj, i5));
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ParameterHandler<Iterable<T>> iterable() {
        return new ParameterHandler<Iterable<T>>() { // from class: retrofit2.ParameterHandler.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // retrofit2.ParameterHandler
            public void apply(RequestBuilder requestBuilder, Iterable<T> iterable) {
                if (iterable == null) {
                    return;
                }
                Iterator<T> it = iterable.iterator();
                while (it.hasNext()) {
                    ParameterHandler.this.apply(requestBuilder, it.next());
                }
            }
        };
    }
}
