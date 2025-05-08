package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.appcompat.R$styleable;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class zzdo extends zzbx implements zzdl {
    public zzdo() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static zzdl asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return queryLocalInterface instanceof zzdl ? (zzdl) queryLocalInterface : new zzdn(iBinder);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0005. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzbx
    protected final boolean zza(int i5, Parcel parcel, Parcel parcel2, int i6) {
        zzdq zzdsVar;
        zzdq zzdqVar = null;
        zzdr zzdrVar = null;
        zzdq zzdqVar2 = null;
        zzdq zzdqVar3 = null;
        zzdq zzdqVar4 = null;
        zzdq zzdqVar5 = null;
        zzdw zzdwVar = null;
        zzdw zzdwVar2 = null;
        zzdw zzdwVar3 = null;
        zzdq zzdqVar6 = null;
        zzdq zzdqVar7 = null;
        zzdq zzdqVar8 = null;
        zzdq zzdqVar9 = null;
        zzdq zzdqVar10 = null;
        zzdq zzdqVar11 = null;
        zzdx zzdxVar = null;
        zzdq zzdqVar12 = null;
        zzdq zzdqVar13 = null;
        zzdq zzdqVar14 = null;
        zzdq zzdqVar15 = null;
        switch (i5) {
            case 1:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzdz zzdzVar = (zzdz) zzbw.zza(parcel, zzdz.CREATOR);
                long readLong = parcel.readLong();
                zzbw.zzb(parcel);
                initialize(asInterface, zzdzVar, readLong);
                parcel2.writeNoException();
                return true;
            case 2:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                Bundle bundle = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                boolean zzc = zzbw.zzc(parcel);
                boolean zzc2 = zzbw.zzc(parcel);
                long readLong2 = parcel.readLong();
                zzbw.zzb(parcel);
                logEvent(readString, readString2, bundle, zzc, zzc2, readLong2);
                parcel2.writeNoException();
                return true;
            case 3:
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                Bundle bundle2 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzdsVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdsVar = queryLocalInterface instanceof zzdq ? (zzdq) queryLocalInterface : new zzds(readStrongBinder);
                }
                long readLong3 = parcel.readLong();
                zzbw.zzb(parcel);
                logEventAndBundle(readString3, readString4, bundle2, zzdsVar, readLong3);
                parcel2.writeNoException();
                return true;
            case 4:
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                boolean zzc3 = zzbw.zzc(parcel);
                long readLong4 = parcel.readLong();
                zzbw.zzb(parcel);
                setUserProperty(readString5, readString6, asInterface2, zzc3, readLong4);
                parcel2.writeNoException();
                return true;
            case 5:
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                boolean zzc4 = zzbw.zzc(parcel);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdqVar = queryLocalInterface2 instanceof zzdq ? (zzdq) queryLocalInterface2 : new zzds(readStrongBinder2);
                }
                zzbw.zzb(parcel);
                getUserProperties(readString7, readString8, zzc4, zzdqVar);
                parcel2.writeNoException();
                return true;
            case 6:
                String readString9 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdqVar15 = queryLocalInterface3 instanceof zzdq ? (zzdq) queryLocalInterface3 : new zzds(readStrongBinder3);
                }
                zzbw.zzb(parcel);
                getMaxUserProperties(readString9, zzdqVar15);
                parcel2.writeNoException();
                return true;
            case 7:
                String readString10 = parcel.readString();
                long readLong5 = parcel.readLong();
                zzbw.zzb(parcel);
                setUserId(readString10, readLong5);
                parcel2.writeNoException();
                return true;
            case 8:
                Bundle bundle3 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                long readLong6 = parcel.readLong();
                zzbw.zzb(parcel);
                setConditionalUserProperty(bundle3, readLong6);
                parcel2.writeNoException();
                return true;
            case 9:
                String readString11 = parcel.readString();
                String readString12 = parcel.readString();
                Bundle bundle4 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                zzbw.zzb(parcel);
                clearConditionalUserProperty(readString11, readString12, bundle4);
                parcel2.writeNoException();
                return true;
            case 10:
                String readString13 = parcel.readString();
                String readString14 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdqVar14 = queryLocalInterface4 instanceof zzdq ? (zzdq) queryLocalInterface4 : new zzds(readStrongBinder4);
                }
                zzbw.zzb(parcel);
                getConditionalUserProperties(readString13, readString14, zzdqVar14);
                parcel2.writeNoException();
                return true;
            case 11:
                boolean zzc5 = zzbw.zzc(parcel);
                long readLong7 = parcel.readLong();
                zzbw.zzb(parcel);
                setMeasurementEnabled(zzc5, readLong7);
                parcel2.writeNoException();
                return true;
            case 12:
                long readLong8 = parcel.readLong();
                zzbw.zzb(parcel);
                resetAnalyticsData(readLong8);
                parcel2.writeNoException();
                return true;
            case 13:
                long readLong9 = parcel.readLong();
                zzbw.zzb(parcel);
                setMinimumSessionDuration(readLong9);
                parcel2.writeNoException();
                return true;
            case 14:
                long readLong10 = parcel.readLong();
                zzbw.zzb(parcel);
                setSessionTimeoutDuration(readLong10);
                parcel2.writeNoException();
                return true;
            case 15:
                IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString15 = parcel.readString();
                String readString16 = parcel.readString();
                long readLong11 = parcel.readLong();
                zzbw.zzb(parcel);
                setCurrentScreen(asInterface3, readString15, readString16, readLong11);
                parcel2.writeNoException();
                return true;
            case 16:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdqVar13 = queryLocalInterface5 instanceof zzdq ? (zzdq) queryLocalInterface5 : new zzds(readStrongBinder5);
                }
                zzbw.zzb(parcel);
                getCurrentScreenName(zzdqVar13);
                parcel2.writeNoException();
                return true;
            case 17:
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdqVar12 = queryLocalInterface6 instanceof zzdq ? (zzdq) queryLocalInterface6 : new zzds(readStrongBinder6);
                }
                zzbw.zzb(parcel);
                getCurrentScreenClass(zzdqVar12);
                parcel2.writeNoException();
                return true;
            case 18:
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    zzdxVar = queryLocalInterface7 instanceof zzdx ? (zzdx) queryLocalInterface7 : new zzea(readStrongBinder7);
                }
                zzbw.zzb(parcel);
                setInstanceIdProvider(zzdxVar);
                parcel2.writeNoException();
                return true;
            case 19:
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdqVar11 = queryLocalInterface8 instanceof zzdq ? (zzdq) queryLocalInterface8 : new zzds(readStrongBinder8);
                }
                zzbw.zzb(parcel);
                getCachedAppInstanceId(zzdqVar11);
                parcel2.writeNoException();
                return true;
            case 20:
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdqVar10 = queryLocalInterface9 instanceof zzdq ? (zzdq) queryLocalInterface9 : new zzds(readStrongBinder9);
                }
                zzbw.zzb(parcel);
                getAppInstanceId(zzdqVar10);
                parcel2.writeNoException();
                return true;
            case 21:
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdqVar9 = queryLocalInterface10 instanceof zzdq ? (zzdq) queryLocalInterface10 : new zzds(readStrongBinder10);
                }
                zzbw.zzb(parcel);
                getGmpAppId(zzdqVar9);
                parcel2.writeNoException();
                return true;
            case 22:
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdqVar8 = queryLocalInterface11 instanceof zzdq ? (zzdq) queryLocalInterface11 : new zzds(readStrongBinder11);
                }
                zzbw.zzb(parcel);
                generateEventId(zzdqVar8);
                parcel2.writeNoException();
                return true;
            case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                String readString17 = parcel.readString();
                long readLong12 = parcel.readLong();
                zzbw.zzb(parcel);
                beginAdUnitExposure(readString17, readLong12);
                parcel2.writeNoException();
                return true;
            case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                String readString18 = parcel.readString();
                long readLong13 = parcel.readLong();
                zzbw.zzb(parcel);
                endAdUnitExposure(readString18, readLong13);
                parcel2.writeNoException();
                return true;
            case 25:
                IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong14 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityStarted(asInterface4, readLong14);
                parcel2.writeNoException();
                return true;
            case 26:
                IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong15 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityStopped(asInterface5, readLong15);
                parcel2.writeNoException();
                return true;
            case 27:
                IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                Bundle bundle5 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                long readLong16 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityCreated(asInterface6, bundle5, readLong16);
                parcel2.writeNoException();
                return true;
            case 28:
                IObjectWrapper asInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong17 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityDestroyed(asInterface7, readLong17);
                parcel2.writeNoException();
                return true;
            case R$styleable.Toolbar_titleTextColor /* 29 */:
                IObjectWrapper asInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong18 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityPaused(asInterface8, readLong18);
                parcel2.writeNoException();
                return true;
            case 30:
                IObjectWrapper asInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong19 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityResumed(asInterface9, readLong19);
                parcel2.writeNoException();
                return true;
            case 31:
                IObjectWrapper asInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                if (readStrongBinder12 != null) {
                    IInterface queryLocalInterface12 = readStrongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdqVar7 = queryLocalInterface12 instanceof zzdq ? (zzdq) queryLocalInterface12 : new zzds(readStrongBinder12);
                }
                long readLong20 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivitySaveInstanceState(asInterface10, zzdqVar7, readLong20);
                parcel2.writeNoException();
                return true;
            case 32:
                Bundle bundle6 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdqVar6 = queryLocalInterface13 instanceof zzdq ? (zzdq) queryLocalInterface13 : new zzds(readStrongBinder13);
                }
                long readLong21 = parcel.readLong();
                zzbw.zzb(parcel);
                performAction(bundle6, zzdqVar6, readLong21);
                parcel2.writeNoException();
                return true;
            case 33:
                int readInt = parcel.readInt();
                String readString19 = parcel.readString();
                IObjectWrapper asInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface13 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbw.zzb(parcel);
                logHealthData(readInt, readString19, asInterface11, asInterface12, asInterface13);
                parcel2.writeNoException();
                return true;
            case 34:
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                if (readStrongBinder14 != null) {
                    IInterface queryLocalInterface14 = readStrongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zzdwVar3 = queryLocalInterface14 instanceof zzdw ? (zzdw) queryLocalInterface14 : new zzdy(readStrongBinder14);
                }
                zzbw.zzb(parcel);
                setEventInterceptor(zzdwVar3);
                parcel2.writeNoException();
                return true;
            case 35:
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zzdwVar2 = queryLocalInterface15 instanceof zzdw ? (zzdw) queryLocalInterface15 : new zzdy(readStrongBinder15);
                }
                zzbw.zzb(parcel);
                registerOnMeasurementEventListener(zzdwVar2);
                parcel2.writeNoException();
                return true;
            case 36:
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    zzdwVar = queryLocalInterface16 instanceof zzdw ? (zzdw) queryLocalInterface16 : new zzdy(readStrongBinder16);
                }
                zzbw.zzb(parcel);
                unregisterOnMeasurementEventListener(zzdwVar);
                parcel2.writeNoException();
                return true;
            case 37:
                HashMap zza = zzbw.zza(parcel);
                zzbw.zzb(parcel);
                initForTests(zza);
                parcel2.writeNoException();
                return true;
            case 38:
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                if (readStrongBinder17 != null) {
                    IInterface queryLocalInterface17 = readStrongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdqVar5 = queryLocalInterface17 instanceof zzdq ? (zzdq) queryLocalInterface17 : new zzds(readStrongBinder17);
                }
                int readInt2 = parcel.readInt();
                zzbw.zzb(parcel);
                getTestFlag(zzdqVar5, readInt2);
                parcel2.writeNoException();
                return true;
            case 39:
                boolean zzc6 = zzbw.zzc(parcel);
                zzbw.zzb(parcel);
                setDataCollectionEnabled(zzc6);
                parcel2.writeNoException();
                return true;
            case 40:
                IBinder readStrongBinder18 = parcel.readStrongBinder();
                if (readStrongBinder18 != null) {
                    IInterface queryLocalInterface18 = readStrongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdqVar4 = queryLocalInterface18 instanceof zzdq ? (zzdq) queryLocalInterface18 : new zzds(readStrongBinder18);
                }
                zzbw.zzb(parcel);
                isDataCollectionEnabled(zzdqVar4);
                parcel2.writeNoException();
                return true;
            case 41:
            case 47:
            case 49:
            default:
                return false;
            case 42:
                Bundle bundle7 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                zzbw.zzb(parcel);
                setDefaultEventParameters(bundle7);
                parcel2.writeNoException();
                return true;
            case 43:
                long readLong22 = parcel.readLong();
                zzbw.zzb(parcel);
                clearMeasurementEnabled(readLong22);
                parcel2.writeNoException();
                return true;
            case 44:
                Bundle bundle8 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                long readLong23 = parcel.readLong();
                zzbw.zzb(parcel);
                setConsent(bundle8, readLong23);
                parcel2.writeNoException();
                return true;
            case 45:
                Bundle bundle9 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                long readLong24 = parcel.readLong();
                zzbw.zzb(parcel);
                setConsentThirdParty(bundle9, readLong24);
                parcel2.writeNoException();
                return true;
            case 46:
                IBinder readStrongBinder19 = parcel.readStrongBinder();
                if (readStrongBinder19 != null) {
                    IInterface queryLocalInterface19 = readStrongBinder19.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdqVar3 = queryLocalInterface19 instanceof zzdq ? (zzdq) queryLocalInterface19 : new zzds(readStrongBinder19);
                }
                zzbw.zzb(parcel);
                getSessionId(zzdqVar3);
                parcel2.writeNoException();
                return true;
            case 48:
                Intent intent = (Intent) zzbw.zza(parcel, Intent.CREATOR);
                zzbw.zzb(parcel);
                setSgtmDebugInfo(intent);
                parcel2.writeNoException();
                return true;
            case 50:
                zzeb zzebVar = (zzeb) zzbw.zza(parcel, zzeb.CREATOR);
                String readString20 = parcel.readString();
                String readString21 = parcel.readString();
                long readLong25 = parcel.readLong();
                zzbw.zzb(parcel);
                setCurrentScreenByScionActivityInfo(zzebVar, readString20, readString21, readLong25);
                parcel2.writeNoException();
                return true;
            case 51:
                zzeb zzebVar2 = (zzeb) zzbw.zza(parcel, zzeb.CREATOR);
                long readLong26 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityStartedByScionActivityInfo(zzebVar2, readLong26);
                parcel2.writeNoException();
                return true;
            case 52:
                zzeb zzebVar3 = (zzeb) zzbw.zza(parcel, zzeb.CREATOR);
                long readLong27 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityStoppedByScionActivityInfo(zzebVar3, readLong27);
                parcel2.writeNoException();
                return true;
            case 53:
                zzeb zzebVar4 = (zzeb) zzbw.zza(parcel, zzeb.CREATOR);
                Bundle bundle10 = (Bundle) zzbw.zza(parcel, Bundle.CREATOR);
                long readLong28 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityCreatedByScionActivityInfo(zzebVar4, bundle10, readLong28);
                parcel2.writeNoException();
                return true;
            case 54:
                zzeb zzebVar5 = (zzeb) zzbw.zza(parcel, zzeb.CREATOR);
                long readLong29 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityDestroyedByScionActivityInfo(zzebVar5, readLong29);
                parcel2.writeNoException();
                return true;
            case 55:
                zzeb zzebVar6 = (zzeb) zzbw.zza(parcel, zzeb.CREATOR);
                long readLong30 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityPausedByScionActivityInfo(zzebVar6, readLong30);
                parcel2.writeNoException();
                return true;
            case 56:
                zzeb zzebVar7 = (zzeb) zzbw.zza(parcel, zzeb.CREATOR);
                long readLong31 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivityResumedByScionActivityInfo(zzebVar7, readLong31);
                parcel2.writeNoException();
                return true;
            case 57:
                zzeb zzebVar8 = (zzeb) zzbw.zza(parcel, zzeb.CREATOR);
                IBinder readStrongBinder20 = parcel.readStrongBinder();
                if (readStrongBinder20 != null) {
                    IInterface queryLocalInterface20 = readStrongBinder20.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    zzdqVar2 = queryLocalInterface20 instanceof zzdq ? (zzdq) queryLocalInterface20 : new zzds(readStrongBinder20);
                }
                long readLong32 = parcel.readLong();
                zzbw.zzb(parcel);
                onActivitySaveInstanceStateByScionActivityInfo(zzebVar8, zzdqVar2, readLong32);
                parcel2.writeNoException();
                return true;
            case 58:
                IBinder readStrongBinder21 = parcel.readStrongBinder();
                if (readStrongBinder21 != null) {
                    IInterface queryLocalInterface21 = readStrongBinder21.queryLocalInterface("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
                    zzdrVar = queryLocalInterface21 instanceof zzdr ? (zzdr) queryLocalInterface21 : new zzdt(readStrongBinder21);
                }
                zzbw.zzb(parcel);
                retrieveAndUploadBatches(zzdrVar);
                parcel2.writeNoException();
                return true;
        }
    }
}
