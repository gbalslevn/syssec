package com.sdk.growthbook.sandbox;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0000¢\u0006\u0002\u0010\u0007\u001a5\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u0002H\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0006H\u0000¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"getData", "T", "Lcom/sdk/growthbook/sandbox/CachingLayer;", "fileName", BuildConfig.FLAVOR, "serializer", "Lkotlinx/serialization/KSerializer;", "(Lcom/sdk/growthbook/sandbox/CachingLayer;Ljava/lang/String;Lkotlinx/serialization/KSerializer;)Ljava/lang/Object;", "putData", BuildConfig.FLAVOR, "content", "(Lcom/sdk/growthbook/sandbox/CachingLayer;Ljava/lang/String;Ljava/lang/Object;Lkotlinx/serialization/KSerializer;)V", "GrowthBook_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class KMMCachingKt {
    public static final <T> T getData(CachingLayer cachingLayer, String fileName, KSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter(cachingLayer, "<this>");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        JsonElement content = cachingLayer.getContent(fileName);
        if (content == null) {
            return null;
        }
        return (T) Json.INSTANCE.decodeFromJsonElement(serializer, content);
    }

    public static final <T> void putData(CachingLayer cachingLayer, String fileName, T t5, KSerializer<T> serializer) {
        Intrinsics.checkNotNullParameter(cachingLayer, "<this>");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        cachingLayer.saveContent(fileName, Json.INSTANCE.encodeToJsonElement(serializer, t5));
    }
}
