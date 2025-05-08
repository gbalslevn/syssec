package com.facebook.appevents;

import com.facebook.appevents.AppEventsManager$start$1;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.cloudbridge.AppEventsCAPIManager;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.gps.ara.GpsAraTriggersManager;
import com.facebook.appevents.gps.pa.PACustomAudienceClient;
import com.facebook.appevents.iap.InAppPurchaseManager;
import com.facebook.appevents.integrity.BannedParamManager;
import com.facebook.appevents.integrity.BlocklistEventsManager;
import com.facebook.appevents.integrity.MACARuleMatchingManager;
import com.facebook.appevents.integrity.ProtectedModeManager;
import com.facebook.appevents.integrity.RedactedEventsManager;
import com.facebook.appevents.integrity.SensitiveParamsManager;
import com.facebook.appevents.integrity.StdParamsEnforcementManager;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/facebook/appevents/AppEventsManager$start$1", "Lcom/facebook/internal/FetchedAppSettingsManager$FetchedAppSettingsCallback;", "onError", BuildConfig.FLAVOR, "onSuccess", "fetchedAppSettings", "Lcom/facebook/internal/FetchedAppSettings;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class AppEventsManager$start$1 implements FetchedAppSettingsManager.FetchedAppSettingsCallback {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-0, reason: not valid java name */
    public static final void m2797onSuccess$lambda0(boolean z5) {
        if (z5) {
            MetadataIndexer.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-1, reason: not valid java name */
    public static final void m2798onSuccess$lambda1(boolean z5) {
        if (z5) {
            RestrictiveDataManager.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-10, reason: not valid java name */
    public static final void m2799onSuccess$lambda10(boolean z5) {
        if (z5) {
            RedactedEventsManager.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-11, reason: not valid java name */
    public static final void m2800onSuccess$lambda11(boolean z5) {
        if (z5) {
            SensitiveParamsManager.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-12, reason: not valid java name */
    public static final void m2801onSuccess$lambda12(boolean z5) {
        if (z5) {
            AppEventsCAPIManager.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-13, reason: not valid java name */
    public static final void m2802onSuccess$lambda13(boolean z5) {
        if (z5) {
            GpsAraTriggersManager.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-14, reason: not valid java name */
    public static final void m2803onSuccess$lambda14(boolean z5) {
        if (z5) {
            PACustomAudienceClient.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-2, reason: not valid java name */
    public static final void m2804onSuccess$lambda2(boolean z5) {
        if (z5) {
            ModelManager.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-3, reason: not valid java name */
    public static final void m2805onSuccess$lambda3(boolean z5) {
        if (z5) {
            EventDeactivationManager.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-4, reason: not valid java name */
    public static final void m2806onSuccess$lambda4(boolean z5) {
        if (z5) {
            BannedParamManager.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-5, reason: not valid java name */
    public static final void m2807onSuccess$lambda5(boolean z5) {
        if (z5) {
            InAppPurchaseManager.enableAutoLogging();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-6, reason: not valid java name */
    public static final void m2808onSuccess$lambda6(boolean z5) {
        if (z5) {
            StdParamsEnforcementManager.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-7, reason: not valid java name */
    public static final void m2809onSuccess$lambda7(boolean z5) {
        if (z5) {
            ProtectedModeManager.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-8, reason: not valid java name */
    public static final void m2810onSuccess$lambda8(boolean z5) {
        if (z5) {
            MACARuleMatchingManager.enable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-9, reason: not valid java name */
    public static final void m2811onSuccess$lambda9(boolean z5) {
        if (z5) {
            BlocklistEventsManager.enable();
        }
    }

    @Override // com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback
    public void onError() {
    }

    @Override // com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback
    public void onSuccess(FetchedAppSettings fetchedAppSettings) {
        FeatureManager featureManager = FeatureManager.INSTANCE;
        FeatureManager.checkFeature(FeatureManager.Feature.AAM, new FeatureManager.Callback() { // from class: e0.j
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z5) {
                AppEventsManager$start$1.m2797onSuccess$lambda0(z5);
            }
        });
        FeatureManager.checkFeature(FeatureManager.Feature.RestrictiveDataFiltering, new FeatureManager.Callback() { // from class: e0.u
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z5) {
                AppEventsManager$start$1.m2798onSuccess$lambda1(z5);
            }
        });
        FeatureManager.checkFeature(FeatureManager.Feature.PrivacyProtection, new FeatureManager.Callback() { // from class: e0.v
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z5) {
                AppEventsManager$start$1.m2804onSuccess$lambda2(z5);
            }
        });
        FeatureManager.checkFeature(FeatureManager.Feature.EventDeactivation, new FeatureManager.Callback() { // from class: e0.w
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z5) {
                AppEventsManager$start$1.m2805onSuccess$lambda3(z5);
            }
        });
        FeatureManager.checkFeature(FeatureManager.Feature.BannedParamFiltering, new FeatureManager.Callback() { // from class: e0.x
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z5) {
                AppEventsManager$start$1.m2806onSuccess$lambda4(z5);
            }
        });
        FeatureManager.checkFeature(FeatureManager.Feature.IapLogging, new FeatureManager.Callback() { // from class: e0.k
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z5) {
                AppEventsManager$start$1.m2807onSuccess$lambda5(z5);
            }
        });
        FeatureManager.checkFeature(FeatureManager.Feature.StdParamEnforcement, new FeatureManager.Callback() { // from class: e0.l
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z5) {
                AppEventsManager$start$1.m2808onSuccess$lambda6(z5);
            }
        });
        FeatureManager.checkFeature(FeatureManager.Feature.ProtectedMode, new FeatureManager.Callback() { // from class: e0.m
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z5) {
                AppEventsManager$start$1.m2809onSuccess$lambda7(z5);
            }
        });
        FeatureManager.checkFeature(FeatureManager.Feature.MACARuleMatching, new FeatureManager.Callback() { // from class: e0.n
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z5) {
                AppEventsManager$start$1.m2810onSuccess$lambda8(z5);
            }
        });
        FeatureManager.checkFeature(FeatureManager.Feature.BlocklistEvents, new FeatureManager.Callback() { // from class: e0.o
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z5) {
                AppEventsManager$start$1.m2811onSuccess$lambda9(z5);
            }
        });
        FeatureManager.checkFeature(FeatureManager.Feature.FilterRedactedEvents, new FeatureManager.Callback() { // from class: e0.p
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z5) {
                AppEventsManager$start$1.m2799onSuccess$lambda10(z5);
            }
        });
        FeatureManager.checkFeature(FeatureManager.Feature.FilterSensitiveParams, new FeatureManager.Callback() { // from class: e0.q
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z5) {
                AppEventsManager$start$1.m2800onSuccess$lambda11(z5);
            }
        });
        FeatureManager.checkFeature(FeatureManager.Feature.CloudBridge, new FeatureManager.Callback() { // from class: e0.r
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z5) {
                AppEventsManager$start$1.m2801onSuccess$lambda12(z5);
            }
        });
        FeatureManager.checkFeature(FeatureManager.Feature.GPSARATriggers, new FeatureManager.Callback() { // from class: e0.s
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z5) {
                AppEventsManager$start$1.m2802onSuccess$lambda13(z5);
            }
        });
        FeatureManager.checkFeature(FeatureManager.Feature.GPSPACAProcessing, new FeatureManager.Callback() { // from class: e0.t
            @Override // com.facebook.internal.FeatureManager.Callback
            public final void onCompleted(boolean z5) {
                AppEventsManager$start$1.m2803onSuccess$lambda14(z5);
            }
        });
    }
}
