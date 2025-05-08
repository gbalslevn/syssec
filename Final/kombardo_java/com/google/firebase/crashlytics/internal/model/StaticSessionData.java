package com.google.firebase.crashlytics.internal.model;

import com.google.auto.value.AutoValue;
import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;

@AutoValue
/* loaded from: classes2.dex */
public abstract class StaticSessionData {

    @AutoValue
    /* loaded from: classes2.dex */
    public static abstract class AppData {
        public static AppData create(String str, String str2, String str3, String str4, int i5, DevelopmentPlatformProvider developmentPlatformProvider) {
            return new AutoValue_StaticSessionData_AppData(str, str2, str3, str4, i5, developmentPlatformProvider);
        }

        public abstract String appIdentifier();

        public abstract int deliveryMechanism();

        public abstract DevelopmentPlatformProvider developmentPlatformProvider();

        public abstract String installUuid();

        public abstract String versionCode();

        public abstract String versionName();
    }

    @AutoValue
    /* loaded from: classes2.dex */
    public static abstract class DeviceData {
        public static DeviceData create(int i5, String str, int i6, long j5, long j6, boolean z5, int i7, String str2, String str3) {
            return new AutoValue_StaticSessionData_DeviceData(i5, str, i6, j5, j6, z5, i7, str2, str3);
        }

        public abstract int arch();

        public abstract int availableProcessors();

        public abstract long diskSpace();

        public abstract boolean isEmulator();

        public abstract String manufacturer();

        public abstract String model();

        public abstract String modelClass();

        public abstract int state();

        public abstract long totalRam();
    }

    @AutoValue
    /* loaded from: classes2.dex */
    public static abstract class OsData {
        public static OsData create(String str, String str2, boolean z5) {
            return new AutoValue_StaticSessionData_OsData(str, str2, z5);
        }

        public abstract boolean isRooted();

        public abstract String osCodeName();

        public abstract String osRelease();
    }

    public static StaticSessionData create(AppData appData, OsData osData, DeviceData deviceData) {
        return new AutoValue_StaticSessionData(appData, osData, deviceData);
    }

    public abstract AppData appData();

    public abstract DeviceData deviceData();

    public abstract OsData osData();
}
