package retrofit2;

import java.util.regex.Pattern;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class RequestBuilder {
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private final HttpUrl baseUrl;
    private RequestBody body;
    private MediaType contentType;
    private FormBody.Builder formBuilder;
    private final boolean hasBody;
    private final Headers.Builder headersBuilder;
    private final String method;
    private MultipartBody.Builder multipartBuilder;
    private String relativeUrl;
    private final Request.Builder requestBuilder = new Request.Builder();
    private HttpUrl.Builder urlBuilder;
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final Pattern PATH_TRAVERSAL = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* loaded from: classes3.dex */
    private static class ContentTypeOverridingRequestBody extends RequestBody {
        private final MediaType contentType;
        private final RequestBody delegate;

        ContentTypeOverridingRequestBody(RequestBody requestBody, MediaType mediaType) {
            this.delegate = requestBody;
            this.contentType = mediaType;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() {
            return this.delegate.contentLength();
        }

        @Override // okhttp3.RequestBody
        /* renamed from: contentType */
        public MediaType getContentType() {
            return this.contentType;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) {
            this.delegate.writeTo(bufferedSink);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RequestBuilder(String str, HttpUrl httpUrl, String str2, Headers headers, MediaType mediaType, boolean z5, boolean z6, boolean z7) {
        this.method = str;
        this.baseUrl = httpUrl;
        this.relativeUrl = str2;
        this.contentType = mediaType;
        this.hasBody = z5;
        if (headers != null) {
            this.headersBuilder = headers.newBuilder();
        } else {
            this.headersBuilder = new Headers.Builder();
        }
        if (z6) {
            this.formBuilder = new FormBody.Builder();
        } else if (z7) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            this.multipartBuilder = builder;
            builder.setType(MultipartBody.FORM);
        }
    }

    private static String canonicalizeForPath(String str, boolean z5) {
        int length = str.length();
        int i5 = 0;
        while (i5 < length) {
            int codePointAt = str.codePointAt(i5);
            if (codePointAt >= 32 && codePointAt < 127 && PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePointAt) == -1 && (z5 || (codePointAt != 47 && codePointAt != 37))) {
                i5 += Character.charCount(codePointAt);
            } else {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, 0, i5);
                canonicalizeForPath(buffer, str, i5, length, z5);
                return buffer.readUtf8();
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addFormField(String str, String str2, boolean z5) {
        if (z5) {
            this.formBuilder.addEncoded(str, str2);
        } else {
            this.formBuilder.add(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addHeader(String str, String str2, boolean z5) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            if (z5) {
                this.headersBuilder.addUnsafeNonAscii(str, str2);
                return;
            } else {
                this.headersBuilder.add(str, str2);
                return;
            }
        }
        try {
            this.contentType = MediaType.get(str2);
        } catch (IllegalArgumentException e5) {
            throw new IllegalArgumentException("Malformed content type: " + str2, e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addHeaders(Headers headers) {
        this.headersBuilder.addAll(headers);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addPart(Headers headers, RequestBody requestBody) {
        this.multipartBuilder.addPart(headers, requestBody);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addPathParam(String str, String str2, boolean z5) {
        if (this.relativeUrl == null) {
            throw new AssertionError();
        }
        String canonicalizeForPath = canonicalizeForPath(str2, z5);
        String replace = this.relativeUrl.replace("{" + str + "}", canonicalizeForPath);
        if (!PATH_TRAVERSAL.matcher(replace).matches()) {
            this.relativeUrl = replace;
            return;
        }
        throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addQueryParam(String str, String str2, boolean z5) {
        String str3 = this.relativeUrl;
        if (str3 != null) {
            HttpUrl.Builder newBuilder = this.baseUrl.newBuilder(str3);
            this.urlBuilder = newBuilder;
            if (newBuilder == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
            this.relativeUrl = null;
        }
        if (z5) {
            this.urlBuilder.addEncodedQueryParameter(str, str2);
        } else {
            this.urlBuilder.addQueryParameter(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> void addTag(Class<T> cls, T t5) {
        this.requestBuilder.tag(cls, t5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Request.Builder get() {
        HttpUrl resolve;
        HttpUrl.Builder builder = this.urlBuilder;
        if (builder != null) {
            resolve = builder.build();
        } else {
            resolve = this.baseUrl.resolve(this.relativeUrl);
            if (resolve == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
        }
        RequestBody requestBody = this.body;
        if (requestBody == null) {
            FormBody.Builder builder2 = this.formBuilder;
            if (builder2 != null) {
                requestBody = builder2.build();
            } else {
                MultipartBody.Builder builder3 = this.multipartBuilder;
                if (builder3 != null) {
                    requestBody = builder3.build();
                } else if (this.hasBody) {
                    requestBody = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.contentType;
        if (mediaType != null) {
            if (requestBody != null) {
                requestBody = new ContentTypeOverridingRequestBody(requestBody, mediaType);
            } else {
                this.headersBuilder.add("Content-Type", mediaType.getMediaType());
            }
        }
        return this.requestBuilder.url(resolve).headers(this.headersBuilder.build()).method(this.method, requestBody);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBody(RequestBody requestBody) {
        this.body = requestBody;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRelativeUrl(Object obj) {
        this.relativeUrl = obj.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addPart(MultipartBody.Part part) {
        this.multipartBuilder.addPart(part);
    }

    private static void canonicalizeForPath(Buffer buffer, String str, int i5, int i6, boolean z5) {
        Buffer buffer2 = null;
        while (i5 < i6) {
            int codePointAt = str.codePointAt(i5);
            if (!z5 || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt >= 32 && codePointAt < 127 && PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePointAt) == -1 && (z5 || (codePointAt != 47 && codePointAt != 37))) {
                    buffer.writeUtf8CodePoint(codePointAt);
                } else {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.writeUtf8CodePoint(codePointAt);
                    while (!buffer2.exhausted()) {
                        byte readByte = buffer2.readByte();
                        buffer.writeByte(37);
                        char[] cArr = HEX_DIGITS;
                        buffer.writeByte((int) cArr[((readByte & 255) >> 4) & 15]);
                        buffer.writeByte((int) cArr[readByte & 15]);
                    }
                }
            }
            i5 += Character.charCount(codePointAt);
        }
    }
}
