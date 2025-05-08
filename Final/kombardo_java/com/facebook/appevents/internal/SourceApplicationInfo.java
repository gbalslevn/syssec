package com.facebook.appevents.internal;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001b\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0005\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/facebook/appevents/internal/SourceApplicationInfo;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "callingApplicationPackage", BuildConfig.FLAVOR, "isOpenedByAppLink", "<init>", "(Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "writeSourceApplicationInfoToDisk", "()V", "Ljava/lang/String;", "getCallingApplicationPackage", "Z", "()Z", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SourceApplicationInfo {
    private static final String CALL_APPLICATION_PACKAGE_KEY = "com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String OPENED_BY_APP_LINK_KEY = "com.facebook.appevents.SourceApplicationInfo.openedByApplink";
    private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";
    private final String callingApplicationPackage;
    private final boolean isOpenedByAppLink;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/facebook/appevents/internal/SourceApplicationInfo$Companion;", BuildConfig.FLAVOR, "()V", "CALL_APPLICATION_PACKAGE_KEY", BuildConfig.FLAVOR, "OPENED_BY_APP_LINK_KEY", "SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT", "clearSavedSourceApplicationInfoFromDisk", BuildConfig.FLAVOR, "getStoredSourceApplicatioInfo", "Lcom/facebook/appevents/internal/SourceApplicationInfo;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void clearSavedSourceApplicationInfoFromDisk() {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
            edit.remove(SourceApplicationInfo.CALL_APPLICATION_PACKAGE_KEY);
            edit.remove(SourceApplicationInfo.OPENED_BY_APP_LINK_KEY);
            edit.apply();
        }

        public final SourceApplicationInfo getStoredSourceApplicatioInfo() {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (defaultSharedPreferences.contains(SourceApplicationInfo.CALL_APPLICATION_PACKAGE_KEY)) {
                return new SourceApplicationInfo(defaultSharedPreferences.getString(SourceApplicationInfo.CALL_APPLICATION_PACKAGE_KEY, null), defaultSharedPreferences.getBoolean(SourceApplicationInfo.OPENED_BY_APP_LINK_KEY, false), defaultConstructorMarker);
            }
            return null;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SourceApplicationInfo(String str, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z5);
    }

    public String toString() {
        String str = this.isOpenedByAppLink ? "Applink" : "Unclassified";
        if (this.callingApplicationPackage == null) {
            return str;
        }
        return str + '(' + ((Object) this.callingApplicationPackage) + ')';
    }

    public final void writeSourceApplicationInfoToDisk() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        edit.putString(CALL_APPLICATION_PACKAGE_KEY, this.callingApplicationPackage);
        edit.putBoolean(OPENED_BY_APP_LINK_KEY, this.isOpenedByAppLink);
        edit.apply();
    }

    private SourceApplicationInfo(String str, boolean z5) {
        this.callingApplicationPackage = str;
        this.isOpenedByAppLink = z5;
    }
}
