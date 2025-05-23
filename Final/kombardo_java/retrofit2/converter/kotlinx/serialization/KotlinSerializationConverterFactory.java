package retrofit2.converter.kotlinx.serialization;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.StringFormat;
import okhttp3.MediaType;
import retrofit2.Converter;
import retrofit2.converter.kotlinx.serialization.Serializer;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lkotlinx/serialization/StringFormat;", "Lokhttp3/MediaType;", "contentType", "Lretrofit2/Converter$Factory;", "create", "(Lkotlinx/serialization/StringFormat;Lokhttp3/MediaType;)Lretrofit2/Converter$Factory;", "asConverterFactory", "kotlinx-serialization"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class KotlinSerializationConverterFactory {
    public static final Converter.Factory create(StringFormat stringFormat, MediaType contentType) {
        Intrinsics.checkNotNullParameter(stringFormat, "<this>");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        return new Factory(contentType, new Serializer.FromString(stringFormat));
    }
}
