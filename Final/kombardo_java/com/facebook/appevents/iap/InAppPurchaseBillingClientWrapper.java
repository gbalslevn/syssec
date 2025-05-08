package com.facebook.appevents.iap;

import com.facebook.appevents.iap.InAppPurchaseUtils;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseBillingClientWrapper;", BuildConfig.FLAVOR, "Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;", "productType", "Ljava/lang/Runnable;", "completionHandler", BuildConfig.FLAVOR, "queryPurchaseHistory", "(Lcom/facebook/appevents/iap/InAppPurchaseUtils$IAPProductType;Ljava/lang/Runnable;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public interface InAppPurchaseBillingClientWrapper {
    void queryPurchaseHistory(InAppPurchaseUtils.IAPProductType productType, Runnable completionHandler);
}
