package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.PendingIntentCompat;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import com.sdk.growthbook.utils.Constants;

/* loaded from: classes.dex */
public class GoogleApiAvailabilityLight {
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final GoogleApiAvailabilityLight zza = new GoogleApiAvailabilityLight();

    public static GoogleApiAvailabilityLight getInstance() {
        return zza;
    }

    public int getApkVersion(Context context) {
        return GooglePlayServicesUtilLight.getApkVersion(context);
    }

    public Intent getErrorResolutionIntent(Context context, int i5, String str) {
        if (i5 != 1 && i5 != 2) {
            if (i5 != 3) {
                return null;
            }
            int i6 = com.google.android.gms.common.internal.zzu.f4345a;
            Uri fromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(fromParts);
            return intent;
        }
        if (context != null && DeviceProperties.isWearableWithoutPlayStore(context)) {
            int i7 = com.google.android.gms.common.internal.zzu.f4345a;
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        String sb2 = sb.toString();
        int i8 = com.google.android.gms.common.internal.zzu.f4345a;
        Intent intent3 = new Intent("android.intent.action.VIEW");
        Uri.Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter(Constants.ID_ATTRIBUTE_KEY, "com.google.android.gms");
        if (!TextUtils.isEmpty(sb2)) {
            appendQueryParameter.appendQueryParameter("pcampaignid", sb2);
        }
        intent3.setData(appendQueryParameter.build());
        intent3.setPackage("com.android.vending");
        intent3.addFlags(524288);
        return intent3;
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, int i5, int i6) {
        return getErrorResolutionPendingIntent(context, i5, i6, null);
    }

    public String getErrorString(int i5) {
        return GooglePlayServicesUtilLight.getErrorString(i5);
    }

    public int isGooglePlayServicesAvailable(Context context) {
        return isGooglePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public boolean isUninstalledAppPossiblyUpdating(Context context, String str) {
        return GooglePlayServicesUtilLight.zza(context, str);
    }

    public boolean isUserResolvableError(int i5) {
        return GooglePlayServicesUtilLight.isUserRecoverableError(i5);
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, int i5, int i6, String str) {
        Intent errorResolutionIntent = getErrorResolutionIntent(context, i5, str);
        if (errorResolutionIntent == null) {
            return null;
        }
        return PendingIntentCompat.getActivity(context, i6, errorResolutionIntent, 134217728, false);
    }

    public int isGooglePlayServicesAvailable(Context context, int i5) {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, i5);
        if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, isGooglePlayServicesAvailable)) {
            return 18;
        }
        return isGooglePlayServicesAvailable;
    }
}
