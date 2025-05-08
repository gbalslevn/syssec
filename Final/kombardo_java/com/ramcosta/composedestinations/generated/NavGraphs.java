package com.ramcosta.composedestinations.generated;

import com.ramcosta.composedestinations.generated.navgraphs.AnimatedRootNavigationNavGraph;
import com.ramcosta.composedestinations.generated.navgraphs.CheckoutNavigationNavGraph;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/ramcosta/composedestinations/generated/NavGraphs;", BuildConfig.FLAVOR, "<init>", "()V", "Lcom/ramcosta/composedestinations/generated/navgraphs/AnimatedRootNavigationNavGraph;", "animatedRoot", "Lcom/ramcosta/composedestinations/generated/navgraphs/AnimatedRootNavigationNavGraph;", "getAnimatedRoot", "()Lcom/ramcosta/composedestinations/generated/navgraphs/AnimatedRootNavigationNavGraph;", "Lcom/ramcosta/composedestinations/generated/navgraphs/CheckoutNavigationNavGraph;", "checkout", "Lcom/ramcosta/composedestinations/generated/navgraphs/CheckoutNavigationNavGraph;", "getCheckout", "()Lcom/ramcosta/composedestinations/generated/navgraphs/CheckoutNavigationNavGraph;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NavGraphs {
    public static final NavGraphs INSTANCE = new NavGraphs();
    private static final AnimatedRootNavigationNavGraph animatedRoot = AnimatedRootNavigationNavGraph.INSTANCE;
    private static final CheckoutNavigationNavGraph checkout = CheckoutNavigationNavGraph.INSTANCE;
    public static final int $stable = 8;

    private NavGraphs() {
    }

    public final CheckoutNavigationNavGraph getCheckout() {
        return checkout;
    }
}
