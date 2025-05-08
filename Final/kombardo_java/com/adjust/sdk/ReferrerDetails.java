package com.adjust.sdk;

/* loaded from: classes.dex */
public class ReferrerDetails {
    public Boolean googlePlayInstant;
    public long installBeginTimestampSeconds;
    public long installBeginTimestampServerSeconds;
    public String installReferrer;
    public String installVersion;
    public long referrerClickTimestampSeconds;
    public long referrerClickTimestampServerSeconds;

    public ReferrerDetails(String str, long j5, long j6) {
        this(str, j5, j6, -1L, -1L, null, null);
    }

    public ReferrerDetails(String str, long j5, long j6, long j7, long j8, String str2, Boolean bool) {
        this.installReferrer = str;
        this.referrerClickTimestampSeconds = j5;
        this.installBeginTimestampSeconds = j6;
        this.referrerClickTimestampServerSeconds = j7;
        this.installBeginTimestampServerSeconds = j8;
        this.installVersion = str2;
        this.googlePlayInstant = bool;
    }
}
