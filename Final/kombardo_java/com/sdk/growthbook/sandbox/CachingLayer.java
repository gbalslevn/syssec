package com.sdk.growthbook.sandbox;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElement;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"Lcom/sdk/growthbook/sandbox/CachingLayer;", BuildConfig.FLAVOR, "getContent", "Lkotlinx/serialization/json/JsonElement;", "fileName", BuildConfig.FLAVOR, "saveContent", BuildConfig.FLAVOR, "content", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface CachingLayer {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static JsonElement getContent(CachingLayer cachingLayer, String fileName) {
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            return null;
        }

        public static void saveContent(CachingLayer cachingLayer, String fileName, JsonElement content) {
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            Intrinsics.checkNotNullParameter(content, "content");
        }
    }

    JsonElement getContent(String fileName);

    void saveContent(String fileName, JsonElement content);
}
