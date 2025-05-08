package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* loaded from: classes.dex */
public interface zzdl extends IInterface {
    void beginAdUnitExposure(String str, long j5);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void clearMeasurementEnabled(long j5);

    void endAdUnitExposure(String str, long j5);

    void generateEventId(zzdq zzdqVar);

    void getAppInstanceId(zzdq zzdqVar);

    void getCachedAppInstanceId(zzdq zzdqVar);

    void getConditionalUserProperties(String str, String str2, zzdq zzdqVar);

    void getCurrentScreenClass(zzdq zzdqVar);

    void getCurrentScreenName(zzdq zzdqVar);

    void getGmpAppId(zzdq zzdqVar);

    void getMaxUserProperties(String str, zzdq zzdqVar);

    void getSessionId(zzdq zzdqVar);

    void getTestFlag(zzdq zzdqVar, int i5);

    void getUserProperties(String str, String str2, boolean z5, zzdq zzdqVar);

    void initForTests(Map map);

    void initialize(IObjectWrapper iObjectWrapper, zzdz zzdzVar, long j5);

    void isDataCollectionEnabled(zzdq zzdqVar);

    void logEvent(String str, String str2, Bundle bundle, boolean z5, boolean z6, long j5);

    void logEventAndBundle(String str, String str2, Bundle bundle, zzdq zzdqVar, long j5);

    void logHealthData(int i5, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3);

    void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j5);

    void onActivityCreatedByScionActivityInfo(zzeb zzebVar, Bundle bundle, long j5);

    void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j5);

    void onActivityDestroyedByScionActivityInfo(zzeb zzebVar, long j5);

    void onActivityPaused(IObjectWrapper iObjectWrapper, long j5);

    void onActivityPausedByScionActivityInfo(zzeb zzebVar, long j5);

    void onActivityResumed(IObjectWrapper iObjectWrapper, long j5);

    void onActivityResumedByScionActivityInfo(zzeb zzebVar, long j5);

    void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzdq zzdqVar, long j5);

    void onActivitySaveInstanceStateByScionActivityInfo(zzeb zzebVar, zzdq zzdqVar, long j5);

    void onActivityStarted(IObjectWrapper iObjectWrapper, long j5);

    void onActivityStartedByScionActivityInfo(zzeb zzebVar, long j5);

    void onActivityStopped(IObjectWrapper iObjectWrapper, long j5);

    void onActivityStoppedByScionActivityInfo(zzeb zzebVar, long j5);

    void performAction(Bundle bundle, zzdq zzdqVar, long j5);

    void registerOnMeasurementEventListener(zzdw zzdwVar);

    void resetAnalyticsData(long j5);

    void retrieveAndUploadBatches(zzdr zzdrVar);

    void setConditionalUserProperty(Bundle bundle, long j5);

    void setConsent(Bundle bundle, long j5);

    void setConsentThirdParty(Bundle bundle, long j5);

    void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j5);

    void setCurrentScreenByScionActivityInfo(zzeb zzebVar, String str, String str2, long j5);

    void setDataCollectionEnabled(boolean z5);

    void setDefaultEventParameters(Bundle bundle);

    void setEventInterceptor(zzdw zzdwVar);

    void setInstanceIdProvider(zzdx zzdxVar);

    void setMeasurementEnabled(boolean z5, long j5);

    void setMinimumSessionDuration(long j5);

    void setSessionTimeoutDuration(long j5);

    void setSgtmDebugInfo(Intent intent);

    void setUserId(String str, long j5);

    void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z5, long j5);

    void unregisterOnMeasurementEventListener(zzdw zzdwVar);
}
