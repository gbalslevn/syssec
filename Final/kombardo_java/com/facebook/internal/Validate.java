package com.facebook.internal;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.FacebookSdkNotInitializedException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ+\u0010\r\u001a\u00020\u0007\"\u0004\b\u0000\u0010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u000f\u001a\u00020\u0007\"\u0004\b\u0000\u0010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000f\u0010\u000eJ+\u0010\u0010\u001a\u00020\u0007\"\u0004\b\u0000\u0010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0010\u0010\u000eJ!\u0010\u0011\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\r\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\r\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0017\u0010\u0016J\u001f\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001e\u0010\u001dJ\u001f\u0010 \u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0005H\u0007¢\u0006\u0004\b \u0010!R\u001c\u0010#\u001a\n \"*\u0004\u0018\u00010\u00050\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010$R\u0014\u0010&\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010$R\u0014\u0010'\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010$R\u0014\u0010(\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010$¨\u0006)"}, d2 = {"Lcom/facebook/internal/Validate;", BuildConfig.FLAVOR, "<init>", "()V", "arg", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "notNull", "(Ljava/lang/Object;Ljava/lang/String;)V", "T", BuildConfig.FLAVOR, "container", "notEmpty", "(Ljava/util/Collection;Ljava/lang/String;)V", "containsNoNulls", "notEmptyAndContainsNoNulls", "notNullOrEmpty", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "(Ljava/lang/String;Ljava/lang/String;)V", "sdkInitialized", "hasAppID", "()Ljava/lang/String;", "hasClientToken", "Landroid/content/Context;", "context", BuildConfig.FLAVOR, "shouldThrow", "hasInternetPermissions", "(Landroid/content/Context;Z)V", "hasFacebookActivity", "redirectURI", "hasCustomTabRedirectActivity", "(Landroid/content/Context;Ljava/lang/String;)Z", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "NO_INTERNET_PERMISSION_REASON", "FACEBOOK_ACTIVITY_NOT_FOUND_REASON", "CONTENT_PROVIDER_NOT_FOUND_REASON", "CONTENT_PROVIDER_BASE", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class Validate {
    private static final String CONTENT_PROVIDER_BASE = "com.facebook.app.FacebookContentProvider";
    private static final String CONTENT_PROVIDER_NOT_FOUND_REASON = "A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.";
    private static final String FACEBOOK_ACTIVITY_NOT_FOUND_REASON = "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.";
    private static final String NO_INTERNET_PERMISSION_REASON = "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.";
    public static final Validate INSTANCE = new Validate();
    private static final String TAG = Validate.class.getName();

    private Validate() {
    }

    public static final <T> void containsNoNulls(Collection<? extends T> container, String name) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(name, "name");
        Iterator<? extends T> it = container.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("Container '" + name + "' cannot contain null values");
            }
        }
    }

    public static final String hasAppID() {
        String applicationId = FacebookSdk.getApplicationId();
        if (applicationId != null) {
            return applicationId;
        }
        throw new IllegalStateException("No App ID found, please set the App ID.");
    }

    public static final String hasClientToken() {
        String clientToken = FacebookSdk.getClientToken();
        if (clientToken != null) {
            return clientToken;
        }
        throw new IllegalStateException("No Client Token found, please set the Client Token. Please follow https://developers.facebook.com/docs/android/getting-started/#client-access-token to get the token and fill it in AndroidManifest.xml");
    }

    public static final boolean hasCustomTabRedirectActivity(Context context, String redirectURI) {
        List<ResolveInfo> list;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(redirectURI, "redirectURI");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(redirectURI));
            list = packageManager.queryIntentActivities(intent, 64);
        } else {
            list = null;
        }
        if (list == null) {
            return false;
        }
        Iterator<ResolveInfo> it = list.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (!Intrinsics.areEqual(activityInfo.name, "com.facebook.CustomTabActivity") || !Intrinsics.areEqual(activityInfo.packageName, context.getPackageName())) {
                return false;
            }
            z5 = true;
        }
        return z5;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @SuppressLint({"WrongConstant"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void hasFacebookActivity(Context context, boolean shouldThrow) {
        ActivityInfo activityInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                activityInfo = packageManager.getActivityInfo(new ComponentName(context, "com.facebook.FacebookActivity"), 1);
            } catch (PackageManager.NameNotFoundException unused) {
            }
            if (activityInfo != null) {
                if (shouldThrow) {
                    throw new IllegalStateException(FACEBOOK_ACTIVITY_NOT_FOUND_REASON);
                }
                Log.w(TAG, FACEBOOK_ACTIVITY_NOT_FOUND_REASON);
                return;
            }
            return;
        }
        activityInfo = null;
        if (activityInfo != null) {
        }
    }

    public static final void hasInternetPermissions(Context context, boolean shouldThrow) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
            if (shouldThrow) {
                throw new IllegalStateException(NO_INTERNET_PERMISSION_REASON);
            }
            Log.w(TAG, NO_INTERNET_PERMISSION_REASON);
        }
    }

    public static final <T> void notEmpty(Collection<? extends T> container, String name) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(name, "name");
        if (container.isEmpty()) {
            throw new IllegalArgumentException(("Container '" + name + "' cannot be empty").toString());
        }
    }

    public static final <T> void notEmptyAndContainsNoNulls(Collection<? extends T> container, String name) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(name, "name");
        containsNoNulls(container, name);
        notEmpty(container, name);
    }

    public static final void notNull(Object arg, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (arg != null) {
            return;
        }
        throw new NullPointerException("Argument '" + name + "' cannot be null");
    }

    public static final String notNullOrEmpty(String arg, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (arg != null && arg.length() > 0) {
            return arg;
        }
        throw new IllegalArgumentException(("Argument '" + name + "' cannot be null or empty").toString());
    }

    public static final void sdkInitialized() {
        if (!FacebookSdk.isInitialized()) {
            throw new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        }
    }

    public static final void notEmpty(String arg, String name) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        Intrinsics.checkNotNullParameter(name, "name");
        if (arg.length() > 0) {
            return;
        }
        throw new IllegalArgumentException(("Argument '" + name + "' cannot be empty").toString());
    }
}
