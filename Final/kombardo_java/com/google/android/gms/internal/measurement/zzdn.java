package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzdn extends zzbu implements zzdl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void beginAdUnitExposure(String str, long j5) {
        Parcel b_ = b_();
        b_.writeString(str);
        b_.writeLong(j5);
        zzb(23, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        Parcel b_ = b_();
        b_.writeString(str);
        b_.writeString(str2);
        zzbw.zza(b_, bundle);
        zzb(9, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void endAdUnitExposure(String str, long j5) {
        Parcel b_ = b_();
        b_.writeString(str);
        b_.writeLong(j5);
        zzb(24, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void generateEventId(zzdq zzdqVar) {
        Parcel b_ = b_();
        zzbw.zza(b_, zzdqVar);
        zzb(22, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getCachedAppInstanceId(zzdq zzdqVar) {
        Parcel b_ = b_();
        zzbw.zza(b_, zzdqVar);
        zzb(19, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getConditionalUserProperties(String str, String str2, zzdq zzdqVar) {
        Parcel b_ = b_();
        b_.writeString(str);
        b_.writeString(str2);
        zzbw.zza(b_, zzdqVar);
        zzb(10, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getCurrentScreenClass(zzdq zzdqVar) {
        Parcel b_ = b_();
        zzbw.zza(b_, zzdqVar);
        zzb(17, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getCurrentScreenName(zzdq zzdqVar) {
        Parcel b_ = b_();
        zzbw.zza(b_, zzdqVar);
        zzb(16, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getGmpAppId(zzdq zzdqVar) {
        Parcel b_ = b_();
        zzbw.zza(b_, zzdqVar);
        zzb(21, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getMaxUserProperties(String str, zzdq zzdqVar) {
        Parcel b_ = b_();
        b_.writeString(str);
        zzbw.zza(b_, zzdqVar);
        zzb(6, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void getUserProperties(String str, String str2, boolean z5, zzdq zzdqVar) {
        Parcel b_ = b_();
        b_.writeString(str);
        b_.writeString(str2);
        zzbw.zza(b_, z5);
        zzbw.zza(b_, zzdqVar);
        zzb(5, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void initialize(IObjectWrapper iObjectWrapper, zzdz zzdzVar, long j5) {
        Parcel b_ = b_();
        zzbw.zza(b_, iObjectWrapper);
        zzbw.zza(b_, zzdzVar);
        b_.writeLong(j5);
        zzb(1, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void logEvent(String str, String str2, Bundle bundle, boolean z5, boolean z6, long j5) {
        Parcel b_ = b_();
        b_.writeString(str);
        b_.writeString(str2);
        zzbw.zza(b_, bundle);
        zzbw.zza(b_, z5);
        zzbw.zza(b_, z6);
        b_.writeLong(j5);
        zzb(2, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void logHealthData(int i5, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel b_ = b_();
        b_.writeInt(i5);
        b_.writeString(str);
        zzbw.zza(b_, iObjectWrapper);
        zzbw.zza(b_, iObjectWrapper2);
        zzbw.zza(b_, iObjectWrapper3);
        zzb(33, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityCreatedByScionActivityInfo(zzeb zzebVar, Bundle bundle, long j5) {
        Parcel b_ = b_();
        zzbw.zza(b_, zzebVar);
        zzbw.zza(b_, bundle);
        b_.writeLong(j5);
        zzb(53, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityDestroyedByScionActivityInfo(zzeb zzebVar, long j5) {
        Parcel b_ = b_();
        zzbw.zza(b_, zzebVar);
        b_.writeLong(j5);
        zzb(54, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityPausedByScionActivityInfo(zzeb zzebVar, long j5) {
        Parcel b_ = b_();
        zzbw.zza(b_, zzebVar);
        b_.writeLong(j5);
        zzb(55, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityResumedByScionActivityInfo(zzeb zzebVar, long j5) {
        Parcel b_ = b_();
        zzbw.zza(b_, zzebVar);
        b_.writeLong(j5);
        zzb(56, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivitySaveInstanceStateByScionActivityInfo(zzeb zzebVar, zzdq zzdqVar, long j5) {
        Parcel b_ = b_();
        zzbw.zza(b_, zzebVar);
        zzbw.zza(b_, zzdqVar);
        b_.writeLong(j5);
        zzb(57, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityStartedByScionActivityInfo(zzeb zzebVar, long j5) {
        Parcel b_ = b_();
        zzbw.zza(b_, zzebVar);
        b_.writeLong(j5);
        zzb(51, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void onActivityStoppedByScionActivityInfo(zzeb zzebVar, long j5) {
        Parcel b_ = b_();
        zzbw.zza(b_, zzebVar);
        b_.writeLong(j5);
        zzb(52, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void registerOnMeasurementEventListener(zzdw zzdwVar) {
        Parcel b_ = b_();
        zzbw.zza(b_, zzdwVar);
        zzb(35, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void retrieveAndUploadBatches(zzdr zzdrVar) {
        Parcel b_ = b_();
        zzbw.zza(b_, zzdrVar);
        zzb(58, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setConditionalUserProperty(Bundle bundle, long j5) {
        Parcel b_ = b_();
        zzbw.zza(b_, bundle);
        b_.writeLong(j5);
        zzb(8, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setCurrentScreenByScionActivityInfo(zzeb zzebVar, String str, String str2, long j5) {
        Parcel b_ = b_();
        zzbw.zza(b_, zzebVar);
        b_.writeString(str);
        b_.writeString(str2);
        b_.writeLong(j5);
        zzb(50, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setDataCollectionEnabled(boolean z5) {
        Parcel b_ = b_();
        zzbw.zza(b_, z5);
        zzb(39, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setUserId(String str, long j5) {
        Parcel b_ = b_();
        b_.writeString(str);
        b_.writeLong(j5);
        zzb(7, b_);
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    public final void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z5, long j5) {
        Parcel b_ = b_();
        b_.writeString(str);
        b_.writeString(str2);
        zzbw.zza(b_, iObjectWrapper);
        zzbw.zza(b_, z5);
        b_.writeLong(j5);
        zzb(4, b_);
    }
}
