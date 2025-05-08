package retrofit2.converter.kotlinx.serialization;

import dk.molslinjen.domain.model.constants.Constants;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialFormat;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ3\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u00042\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000f\u001a\u00028\u0000H&¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188$X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u0082\u0001\u0001\u001d¨\u0006\u001e"}, d2 = {"Lretrofit2/converter/kotlinx/serialization/Serializer;", BuildConfig.FLAVOR, "<init>", "()V", "T", "Lkotlinx/serialization/DeserializationStrategy;", "loader", "Lokhttp3/ResponseBody;", Constants.IntentExtra.PushBody, "fromResponseBody", "(Lkotlinx/serialization/DeserializationStrategy;Lokhttp3/ResponseBody;)Ljava/lang/Object;", "Lokhttp3/MediaType;", "contentType", "Lkotlinx/serialization/SerializationStrategy;", "saver", "value", "Lokhttp3/RequestBody;", "toRequestBody", "(Lokhttp3/MediaType;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Lokhttp3/RequestBody;", "Ljava/lang/reflect/Type;", "type", "Lkotlinx/serialization/KSerializer;", "serializer", "(Ljava/lang/reflect/Type;)Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/SerialFormat;", "getFormat", "()Lkotlinx/serialization/SerialFormat;", "format", "FromString", "Lretrofit2/converter/kotlinx/serialization/Serializer$FromString;", "kotlinx-serialization"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class Serializer {

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ1\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\b0\u00132\u0006\u0010\u0014\u001a\u0002H\bH\u0016¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0002\u001a\u00020\u0003X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lretrofit2/converter/kotlinx/serialization/Serializer$FromString;", "Lretrofit2/converter/kotlinx/serialization/Serializer;", "format", "Lkotlinx/serialization/StringFormat;", "(Lkotlinx/serialization/StringFormat;)V", "getFormat", "()Lkotlinx/serialization/StringFormat;", "fromResponseBody", "T", "loader", "Lkotlinx/serialization/DeserializationStrategy;", Constants.IntentExtra.PushBody, "Lokhttp3/ResponseBody;", "(Lkotlinx/serialization/DeserializationStrategy;Lokhttp3/ResponseBody;)Ljava/lang/Object;", "toRequestBody", "Lokhttp3/RequestBody;", "contentType", "Lokhttp3/MediaType;", "saver", "Lkotlinx/serialization/SerializationStrategy;", "value", "(Lokhttp3/MediaType;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Lokhttp3/RequestBody;", "kotlinx-serialization"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class FromString extends Serializer {
        private final StringFormat format;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FromString(StringFormat format) {
            super(null);
            Intrinsics.checkNotNullParameter(format, "format");
            this.format = format;
        }

        @Override // retrofit2.converter.kotlinx.serialization.Serializer
        public <T> T fromResponseBody(DeserializationStrategy<? extends T> loader, ResponseBody body) {
            Intrinsics.checkNotNullParameter(loader, "loader");
            Intrinsics.checkNotNullParameter(body, "body");
            String string = body.string();
            StringFormat format = getFormat();
            Intrinsics.checkNotNull(string);
            return (T) format.decodeFromString(loader, string);
        }

        @Override // retrofit2.converter.kotlinx.serialization.Serializer
        public <T> RequestBody toRequestBody(MediaType contentType, SerializationStrategy<? super T> saver, T value) {
            Intrinsics.checkNotNullParameter(contentType, "contentType");
            Intrinsics.checkNotNullParameter(saver, "saver");
            RequestBody create = RequestBody.create(contentType, getFormat().encodeToString(saver, value));
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            return create;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // retrofit2.converter.kotlinx.serialization.Serializer
        public StringFormat getFormat() {
            return this.format;
        }
    }

    public /* synthetic */ Serializer(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract <T> T fromResponseBody(DeserializationStrategy<? extends T> loader, ResponseBody body);

    protected abstract SerialFormat getFormat();

    public final KSerializer<Object> serializer(Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return SerializersKt.serializer(getFormat().getSerializersModule(), type);
    }

    public abstract <T> RequestBody toRequestBody(MediaType contentType, SerializationStrategy<? super T> saver, T value);

    private Serializer() {
    }
}
