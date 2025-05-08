package com.adjust.sdk;

/* loaded from: classes.dex */
public enum ActivityKind {
    UNKNOWN,
    SESSION,
    EVENT,
    CLICK,
    ATTRIBUTION,
    REVENUE,
    REATTRIBUTION,
    INFO,
    GDPR,
    AD_REVENUE,
    DISABLE_THIRD_PARTY_SHARING,
    SUBSCRIPTION,
    THIRD_PARTY_SHARING,
    MEASUREMENT_CONSENT;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4117a;

        static {
            int[] iArr = new int[ActivityKind.values().length];
            f4117a = iArr;
            try {
                iArr[ActivityKind.SESSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4117a[ActivityKind.EVENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4117a[ActivityKind.CLICK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4117a[ActivityKind.ATTRIBUTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4117a[ActivityKind.INFO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4117a[ActivityKind.GDPR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4117a[ActivityKind.DISABLE_THIRD_PARTY_SHARING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4117a[ActivityKind.AD_REVENUE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4117a[ActivityKind.SUBSCRIPTION.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4117a[ActivityKind.THIRD_PARTY_SHARING.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4117a[ActivityKind.MEASUREMENT_CONSENT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public static ActivityKind fromString(String str) {
        return "session".equals(str) ? SESSION : "event".equals(str) ? EVENT : "click".equals(str) ? CLICK : "attribution".equals(str) ? ATTRIBUTION : "info".equals(str) ? INFO : "gdpr".equals(str) ? GDPR : "disable_third_party_sharing".equals(str) ? DISABLE_THIRD_PARTY_SHARING : "ad_revenue".equals(str) ? AD_REVENUE : "subscription".equals(str) ? SUBSCRIPTION : "third_party_sharing".equals(str) ? THIRD_PARTY_SHARING : "measurement_consent".equals(str) ? MEASUREMENT_CONSENT : UNKNOWN;
    }

    @Override // java.lang.Enum
    public String toString() {
        switch (a.f4117a[ordinal()]) {
            case 1:
                return "session";
            case 2:
                return "event";
            case 3:
                return "click";
            case 4:
                return "attribution";
            case 5:
                return "info";
            case 6:
                return "gdpr";
            case 7:
                return "disable_third_party_sharing";
            case 8:
                return "ad_revenue";
            case 9:
                return "subscription";
            case 10:
                return "third_party_sharing";
            case 11:
                return "measurement_consent";
            default:
                return "unknown";
        }
    }
}
