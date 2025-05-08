package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;

/* loaded from: classes.dex */
public class ActionBarPolicy {
    private Context mContext;

    private ActionBarPolicy(Context context) {
        this.mContext = context;
    }

    public static ActionBarPolicy get(Context context) {
        return new ActionBarPolicy(context);
    }

    public int getEmbeddedMenuWidthLimit() {
        return this.mContext.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int getMaxActionButtons() {
        Configuration configuration = this.mContext.getResources().getConfiguration();
        int i5 = configuration.screenWidthDp;
        int i6 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i5 > 600) {
            return 5;
        }
        if (i5 > 960 && i6 > 720) {
            return 5;
        }
        if (i5 > 720 && i6 > 960) {
            return 5;
        }
        if (i5 >= 500) {
            return 4;
        }
        if (i5 > 640 && i6 > 480) {
            return 4;
        }
        if (i5 <= 480 || i6 <= 640) {
            return i5 >= 360 ? 3 : 2;
        }
        return 4;
    }

    public boolean showsOverflowMenuButton() {
        return true;
    }
}
