package dk.molslinjen.ui.views.screens.profile.permissions;

import android.annotation.SuppressLint;
import dk.molslinjen.kombardo.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/permissions/AppPermission;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Location", "Notifications", "MarketingNotifications", "titleRes", BuildConfig.FLAVOR, "isEnabled", BuildConfig.FLAVOR, "descriptionRes", "permissions", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "getPermissions", "()Ljava/util/List;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AppPermission {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AppPermission[] $VALUES;
    public static final AppPermission Location = new AppPermission("Location", 0);
    public static final AppPermission Notifications = new AppPermission("Notifications", 1);
    public static final AppPermission MarketingNotifications = new AppPermission("MarketingNotifications", 2);

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AppPermission.values().length];
            try {
                iArr[AppPermission.Location.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppPermission.Notifications.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AppPermission.MarketingNotifications.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ AppPermission[] $values() {
        return new AppPermission[]{Location, Notifications, MarketingNotifications};
    }

    static {
        AppPermission[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private AppPermission(String str, int i5) {
    }

    public static AppPermission valueOf(String str) {
        return (AppPermission) Enum.valueOf(AppPermission.class, str);
    }

    public static AppPermission[] values() {
        return (AppPermission[]) $VALUES.clone();
    }

    public final int descriptionRes(boolean isEnabled) {
        int i5 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i5 == 1) {
            return R.string.permission_location_openSettings_description;
        }
        if (i5 == 2) {
            return isEnabled ? R.string.permission_notification_openSettings_withMarketingPermission_descriptionDisable : R.string.permission_notification_openSettings_description;
        }
        if (i5 == 3) {
            return R.string.permission_notification_openSettings_withMarketingPermission_descriptionEnable;
        }
        throw new NoWhenBranchMatchedException();
    }

    @SuppressLint({"InlinedApi"})
    public final List<String> getPermissions() {
        int i5 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i5 == 1) {
            return CollectionsKt.listOf((Object[]) new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"});
        }
        if (i5 == 2 || i5 == 3) {
            return CollectionsKt.listOf("android.permission.POST_NOTIFICATIONS");
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int titleRes(boolean isEnabled) {
        int i5 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i5 == 1) {
            return isEnabled ? R.string.permission_location_openSettings_titleDisable : R.string.permission_location_openSettings_titleEnable;
        }
        if (i5 == 2 || i5 == 3) {
            return isEnabled ? R.string.permission_notification_openSettings_titleDisable : R.string.permission_notification_openSettings_titleEnable;
        }
        throw new NoWhenBranchMatchedException();
    }
}
