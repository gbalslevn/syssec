package com.sdk.growthbook.stickybucket;

import com.sdk.growthbook.sandbox.CachingLayer;
import com.sdk.growthbook.utils.GBStickyAssignmentsDocument;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J(\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bH\u0016J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/sdk/growthbook/stickybucket/GBStickyBucketServiceImp;", "Lcom/sdk/growthbook/stickybucket/GBStickyBucketService;", "prefix", BuildConfig.FLAVOR, "localStorage", "Lcom/sdk/growthbook/sandbox/CachingLayer;", "(Ljava/lang/String;Lcom/sdk/growthbook/sandbox/CachingLayer;)V", "getAllAssignments", BuildConfig.FLAVOR, "Lcom/sdk/growthbook/utils/GBStickyAssignmentsDocument;", "attributes", "getAssignments", "attributeName", "attributeValue", "saveAssignments", BuildConfig.FLAVOR, "doc", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GBStickyBucketServiceImp implements GBStickyBucketService {
    private final CachingLayer localStorage;
    private final String prefix;

    /* JADX WARN: Multi-variable type inference failed */
    public GBStickyBucketServiceImp() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.sdk.growthbook.stickybucket.GBStickyBucketService
    public Map<String, GBStickyAssignmentsDocument> getAllAssignments(Map<String, String> attributes) {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            GBStickyAssignmentsDocument assignments = getAssignments(entry.getKey(), entry.getValue());
            if (assignments != null) {
                linkedHashMap.put(assignments.getAttributeName() + "||" + assignments.getAttributeValue(), assignments);
            }
        }
        return linkedHashMap;
    }

    @Override // com.sdk.growthbook.stickybucket.GBStickyBucketService
    public GBStickyAssignmentsDocument getAssignments(String attributeName, String attributeValue) {
        Intrinsics.checkNotNullParameter(attributeName, "attributeName");
        Intrinsics.checkNotNullParameter(attributeValue, "attributeValue");
        String str = attributeName + "||" + attributeValue;
        CachingLayer cachingLayer = this.localStorage;
        if (cachingLayer == null) {
            return null;
        }
        JsonElement content = cachingLayer.getContent(this.prefix + str);
        if (content == null) {
            return null;
        }
        try {
            Json.Companion companion = Json.INSTANCE;
            return (GBStickyAssignmentsDocument) companion.decodeFromJsonElement(SerializersKt.serializer(companion.getSerializersModule(), Reflection.typeOf(GBStickyAssignmentsDocument.class)), content);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.sdk.growthbook.stickybucket.GBStickyBucketService
    public void saveAssignments(GBStickyAssignmentsDocument doc) {
        Intrinsics.checkNotNullParameter(doc, "doc");
        String str = doc.getAttributeName() + "||" + doc.getAttributeValue();
        CachingLayer cachingLayer = this.localStorage;
        if (cachingLayer != null) {
            try {
                Json.Companion companion = Json.INSTANCE;
                cachingLayer.saveContent(this.prefix + str, companion.parseToJsonElement(companion.encodeToString(SerializersKt.serializer(companion.getSerializersModule(), Reflection.typeOf(GBStickyAssignmentsDocument.class)), doc)));
            } catch (Exception unused) {
            }
        }
    }

    public GBStickyBucketServiceImp(String prefix, CachingLayer cachingLayer) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        this.prefix = prefix;
        this.localStorage = cachingLayer;
    }

    public /* synthetic */ GBStickyBucketServiceImp(String str, CachingLayer cachingLayer, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? "gbStickyBuckets__" : str, (i5 & 2) != 0 ? null : cachingLayer);
    }
}
