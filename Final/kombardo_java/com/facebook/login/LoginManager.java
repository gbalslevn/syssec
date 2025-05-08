package com.facebook.login;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/facebook/login/LoginManager;", BuildConfig.FLAVOR, "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class LoginManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final String EXPRESS_LOGIN_ALLOWED = "express_login_allowed";
    private static final String MANAGE_PERMISSION_PREFIX = "manage";
    private static final Set<String> OTHER_PUBLISH_PERMISSIONS;
    private static final String PREFERENCE_LOGIN_MANAGER = "com.facebook.loginManager";
    private static final String PUBLISH_PERMISSION_PREFIX = "publish";
    private static final String TAG;
    private static volatile LoginManager instance;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/facebook/login/LoginManager$Companion;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "permission", BuildConfig.FLAVOR, "isPublishPermission", "(Ljava/lang/String;)Z", BuildConfig.FLAVOR, "getOtherPublishPermissions", "()Ljava/util/Set;", "otherPublishPermissions", "EXPRESS_LOGIN_ALLOWED", "Ljava/lang/String;", "MANAGE_PERMISSION_PREFIX", "OTHER_PUBLISH_PERMISSIONS", "Ljava/util/Set;", "PREFERENCE_LOGIN_MANAGER", "PUBLISH_PERMISSION_PREFIX", "TAG", "Lcom/facebook/login/LoginManager;", "instance", "Lcom/facebook/login/LoginManager;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Set<String> getOtherPublishPermissions() {
            return SetsKt.setOf((Object[]) new String[]{"ads_management", "create_event", "rsvp_event"});
        }

        public final boolean isPublishPermission(String permission) {
            if (permission != null) {
                return StringsKt.startsWith$default(permission, LoginManager.PUBLISH_PERMISSION_PREFIX, false, 2, (Object) null) || StringsKt.startsWith$default(permission, LoginManager.MANAGE_PERMISSION_PREFIX, false, 2, (Object) null) || LoginManager.OTHER_PUBLISH_PERMISSIONS.contains(permission);
            }
            return false;
        }

        private Companion() {
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        OTHER_PUBLISH_PERMISSIONS = companion.getOtherPublishPermissions();
        String cls = LoginManager.class.toString();
        Intrinsics.checkNotNullExpressionValue(cls, "LoginManager::class.java.toString()");
        TAG = cls;
    }
}
