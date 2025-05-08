package com.sdk.growthbook.utils;

import com.sdk.growthbook.model.GBFeature;
import com.soywiz.krypto.encoding.Base64;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonObject;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u00072\u0006\u0010\b\u001a\u00020\u0003\u001a6\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u00072\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u001a$\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u0010"}, d2 = {"decodeBase64", BuildConfig.FLAVOR, "base64", BuildConfig.FLAVOR, "encryptToFeaturesDataModel", BuildConfig.FLAVOR, "Lcom/sdk/growthbook/model/GBFeature;", "Lcom/sdk/growthbook/utils/GBFeatures;", "string", "getFeaturesFromEncryptedFeatures", "encryptedString", "encryptionKey", "subtleCrypto", "Lcom/sdk/growthbook/utils/Crypto;", "getSavedGroupFromEncryptedSavedGroup", "Lkotlinx/serialization/json/JsonObject;", "GrowthBook_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CryptoKt {
    public static final byte[] decodeBase64(String base64) {
        Intrinsics.checkNotNullParameter(base64, "base64");
        return Base64.decode$default(Base64.INSTANCE, base64, false, 2, null);
    }

    public static final Map<String, GBFeature> encryptToFeaturesDataModel(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        try {
            return (Map) JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.sdk.growthbook.utils.CryptoKt$encryptToFeaturesDataModel$jsonParser$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
                    invoke2(jsonBuilder);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(JsonBuilder Json) {
                    Intrinsics.checkNotNullParameter(Json, "$this$Json");
                    Json.setPrettyPrint(true);
                    Json.setLenient(true);
                    Json.setIgnoreUnknownKeys(true);
                }
            }, 1, null).decodeFromString(BuiltinSerializersKt.MapSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE), GBFeature.INSTANCE.serializer()), string);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final Map<String, GBFeature> getFeaturesFromEncryptedFeatures(String encryptedString, String encryptionKey, Crypto crypto) {
        Intrinsics.checkNotNullParameter(encryptedString, "encryptedString");
        Intrinsics.checkNotNullParameter(encryptionKey, "encryptionKey");
        List split$default = StringsKt.split$default((CharSequence) encryptedString, new String[]{"."}, false, 0, 6, (Object) null);
        byte[] decodeBase64 = decodeBase64((String) split$default.get(0));
        byte[] decodeBase642 = decodeBase64(encryptionKey);
        byte[] decodeBase643 = decodeBase64((String) split$default.get(1));
        if (crypto == null) {
            crypto = new DefaultCrypto();
        }
        return encryptToFeaturesDataModel(StringsKt.decodeToString(crypto.decrypt(decodeBase643, decodeBase642, decodeBase64)));
    }

    public static /* synthetic */ Map getFeaturesFromEncryptedFeatures$default(String str, String str2, Crypto crypto, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            crypto = null;
        }
        return getFeaturesFromEncryptedFeatures(str, str2, crypto);
    }

    public static final JsonObject getSavedGroupFromEncryptedSavedGroup(String encryptedString, String encryptionKey, Crypto crypto) {
        Intrinsics.checkNotNullParameter(encryptedString, "encryptedString");
        Intrinsics.checkNotNullParameter(encryptionKey, "encryptionKey");
        List split$default = StringsKt.split$default((CharSequence) encryptedString, new String[]{"."}, false, 0, 6, (Object) null);
        byte[] decodeBase64 = decodeBase64((String) split$default.get(0));
        byte[] decodeBase642 = decodeBase64(encryptionKey);
        byte[] decodeBase643 = decodeBase64((String) split$default.get(1));
        if (crypto == null) {
            crypto = new DefaultCrypto();
        }
        try {
            return (JsonObject) Json.INSTANCE.decodeFromString(JsonObject.INSTANCE.serializer(), StringsKt.decodeToString(crypto.decrypt(decodeBase643, decodeBase642, decodeBase64)));
        } catch (Exception unused) {
            return null;
        }
    }

    public static /* synthetic */ JsonObject getSavedGroupFromEncryptedSavedGroup$default(String str, String str2, Crypto crypto, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            crypto = null;
        }
        return getSavedGroupFromEncryptedSavedGroup(str, str2, crypto);
    }
}
