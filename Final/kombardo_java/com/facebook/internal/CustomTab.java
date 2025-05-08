package com.facebook.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsIntent;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.CustomTabPrefetchHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/facebook/internal/CustomTab;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "action", "Landroid/os/Bundle;", "parameters", "<init>", "(Ljava/lang/String;Landroid/os/Bundle;)V", "Landroid/app/Activity;", "activity", "packageName", BuildConfig.FLAVOR, "openCustomTab", "(Landroid/app/Activity;Ljava/lang/String;)Z", "Landroid/net/Uri;", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public class CustomTab {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Uri uri;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0017¨\u0006\t"}, d2 = {"Lcom/facebook/internal/CustomTab$Companion;", BuildConfig.FLAVOR, "()V", "getURIForAction", "Landroid/net/Uri;", "action", BuildConfig.FLAVOR, "parameters", "Landroid/os/Bundle;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Uri getURIForAction(String action, Bundle parameters) {
            Intrinsics.checkNotNullParameter(action, "action");
            Utility utility = Utility.INSTANCE;
            return Utility.buildUri(ServerProtocol.getDialogAuthority(), FacebookSdk.getGraphApiVersion() + "/dialog/" + action, parameters);
        }

        private Companion() {
        }
    }

    public CustomTab(String action, Bundle bundle) {
        Uri uRIForAction;
        Intrinsics.checkNotNullParameter(action, "action");
        bundle = bundle == null ? new Bundle() : bundle;
        GamingAction[] valuesCustom = GamingAction.valuesCustom();
        ArrayList arrayList = new ArrayList(valuesCustom.length);
        for (GamingAction gamingAction : valuesCustom) {
            arrayList.add(gamingAction.getRawValue());
        }
        if (arrayList.contains(action)) {
            Utility utility = Utility.INSTANCE;
            uRIForAction = Utility.buildUri(ServerProtocol.getGamingDialogAuthority(), Intrinsics.stringPlus("/dialog/", action), bundle);
        } else {
            uRIForAction = INSTANCE.getURIForAction(action, bundle);
        }
        this.uri = uRIForAction;
    }

    public final boolean openCustomTab(Activity activity, String packageName) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            Intrinsics.checkNotNullParameter(activity, "activity");
            CustomTabPrefetchHelper.INSTANCE.getPreparedSessionOnce();
            CustomTabsIntent build = new CustomTabsIntent.Builder(null).build();
            build.intent.setPackage(packageName);
            try {
                build.launchUrl(activity, this.uri);
                return true;
            } catch (ActivityNotFoundException unused) {
                return false;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setUri(Uri uri) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(uri, "<set-?>");
            this.uri = uri;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
