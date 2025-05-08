package androidx.browser.customtabs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.BundleCompat;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class CustomTabsIntent {
    private static final String EXTRA_USER_OPT_OUT_FROM_CUSTOM_TABS = "android.support.customtabs.extra.user_opt_out";
    private static final int MAX_TOOLBAR_ITEMS = 5;
    public final Intent intent;
    public final Bundle startAnimationBundle;

    /* loaded from: classes.dex */
    public static final class Builder {
        private ArrayList<Bundle> mActionButtons;
        private boolean mInstantAppsEnabled;
        private final Intent mIntent;
        private ArrayList<Bundle> mMenuItems;
        private Bundle mStartAnimationBundle;

        public Builder(CustomTabsSession customTabsSession) {
            Intent intent = new Intent("android.intent.action.VIEW");
            this.mIntent = intent;
            this.mMenuItems = null;
            this.mStartAnimationBundle = null;
            this.mActionButtons = null;
            this.mInstantAppsEnabled = true;
            Bundle bundle = new Bundle();
            BundleCompat.putBinder(bundle, "android.support.customtabs.extra.SESSION", null);
            intent.putExtras(bundle);
        }

        public CustomTabsIntent build() {
            ArrayList<Bundle> arrayList = this.mMenuItems;
            if (arrayList != null) {
                this.mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.mActionButtons;
            if (arrayList2 != null) {
                this.mIntent.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.mIntent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.mInstantAppsEnabled);
            return new CustomTabsIntent(this.mIntent, this.mStartAnimationBundle);
        }
    }

    CustomTabsIntent(Intent intent, Bundle bundle) {
        this.intent = intent;
        this.startAnimationBundle = bundle;
    }

    public void launchUrl(Context context, Uri uri) {
        this.intent.setData(uri);
        ContextCompat.startActivity(context, this.intent, this.startAnimationBundle);
    }
}
