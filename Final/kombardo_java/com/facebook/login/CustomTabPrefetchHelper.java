package com.facebook.login;

import android.net.Uri;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/facebook/login/CustomTabPrefetchHelper;", "Landroidx/browser/customtabs/CustomTabsServiceConnection;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public abstract class CustomTabPrefetchHelper extends CustomTabsServiceConnection {
    private static CustomTabsClient client;
    private static CustomTabsSession session;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ReentrantLock lock = new ReentrantLock();

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u000bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/login/CustomTabPrefetchHelper$Companion;", BuildConfig.FLAVOR, "()V", "client", "Landroidx/browser/customtabs/CustomTabsClient;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "session", "Landroidx/browser/customtabs/CustomTabsSession;", "getPreparedSessionOnce", "mayLaunchUrl", BuildConfig.FLAVOR, "url", "Landroid/net/Uri;", "prepareSession", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void prepareSession() {
            CustomTabPrefetchHelper.lock.lock();
            CustomTabPrefetchHelper.access$getSession$cp();
            CustomTabPrefetchHelper.access$getClient$cp();
            CustomTabPrefetchHelper.lock.unlock();
        }

        public final CustomTabsSession getPreparedSessionOnce() {
            CustomTabPrefetchHelper.lock.lock();
            CustomTabPrefetchHelper.access$getSession$cp();
            CustomTabPrefetchHelper.access$setSession$cp(null);
            CustomTabPrefetchHelper.lock.unlock();
            return null;
        }

        public final void mayLaunchUrl(Uri url) {
            Intrinsics.checkNotNullParameter(url, "url");
            prepareSession();
            CustomTabPrefetchHelper.lock.lock();
            CustomTabPrefetchHelper.access$getSession$cp();
            CustomTabPrefetchHelper.lock.unlock();
        }

        private Companion() {
        }
    }

    public static final /* synthetic */ CustomTabsClient access$getClient$cp() {
        return null;
    }

    public static final /* synthetic */ CustomTabsSession access$getSession$cp() {
        return null;
    }

    public static final /* synthetic */ void access$setSession$cp(CustomTabsSession customTabsSession) {
    }
}
