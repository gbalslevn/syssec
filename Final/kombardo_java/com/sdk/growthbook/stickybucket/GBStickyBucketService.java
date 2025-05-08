package com.sdk.growthbook.stickybucket;

import com.sdk.growthbook.utils.GBStickyAssignmentsDocument;
import java.util.Map;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H&J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H&¨\u0006\r"}, d2 = {"Lcom/sdk/growthbook/stickybucket/GBStickyBucketService;", BuildConfig.FLAVOR, "getAllAssignments", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/sdk/growthbook/utils/GBStickyAssignmentsDocument;", "attributes", "getAssignments", "attributeName", "attributeValue", "saveAssignments", BuildConfig.FLAVOR, "doc", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface GBStickyBucketService {
    Map<String, GBStickyAssignmentsDocument> getAllAssignments(Map<String, String> attributes);

    GBStickyAssignmentsDocument getAssignments(String attributeName, String attributeValue);

    void saveAssignments(GBStickyAssignmentsDocument doc);
}
