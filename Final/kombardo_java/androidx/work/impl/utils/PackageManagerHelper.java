package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.Logger;

/* loaded from: classes.dex */
public abstract class PackageManagerHelper {
    private static final String TAG = Logger.tagWithPrefix("PackageManagerHelper");

    private static int getComponentEnabledSetting(Context context, String str) {
        return context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, str));
    }

    private static boolean isComponentEnabled(int i5, boolean z5) {
        return i5 == 0 ? z5 : i5 == 1;
    }

    public static void setComponentEnabled(Context context, Class<?> cls, boolean z5) {
        try {
            if (z5 == isComponentEnabled(getComponentEnabledSetting(context, cls.getName()), false)) {
                Logger.get().debug(TAG, "Skipping component enablement for " + cls.getName());
                return;
            }
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z5 ? 1 : 2, 1);
            Logger logger = Logger.get();
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName());
            sb.append(" ");
            sb.append(z5 ? "enabled" : "disabled");
            logger.debug(str, sb.toString());
        } catch (Exception e5) {
            Logger logger2 = Logger.get();
            String str2 = TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append("could not be ");
            sb2.append(z5 ? "enabled" : "disabled");
            logger2.debug(str2, sb2.toString(), e5);
        }
    }
}
