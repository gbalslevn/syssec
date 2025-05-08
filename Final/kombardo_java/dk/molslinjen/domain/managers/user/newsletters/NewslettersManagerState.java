package dk.molslinjen.domain.managers.user.newsletters;

import dk.molslinjen.domain.model.account.newsletters.NewsletterSubscription;
import dk.molslinjen.domain.model.site.SiteInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/domain/managers/user/newsletters/NewslettersManagerState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/account/newsletters/NewsletterSubscription;", "subscriptions", "Ldk/molslinjen/domain/model/site/SiteInfo;", "defaultSite", "<init>", "(Ljava/util/List;Ldk/molslinjen/domain/model/site/SiteInfo;)V", "copy", "(Ljava/util/List;Ldk/molslinjen/domain/model/site/SiteInfo;)Ldk/molslinjen/domain/managers/user/newsletters/NewslettersManagerState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getSubscriptions", "()Ljava/util/List;", "Ldk/molslinjen/domain/model/site/SiteInfo;", "getDefaultSite", "()Ldk/molslinjen/domain/model/site/SiteInfo;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class NewslettersManagerState {
    private final SiteInfo defaultSite;
    private final List<NewsletterSubscription> subscriptions;

    public NewslettersManagerState(List<NewsletterSubscription> subscriptions, SiteInfo siteInfo) {
        Intrinsics.checkNotNullParameter(subscriptions, "subscriptions");
        this.subscriptions = subscriptions;
        this.defaultSite = siteInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NewslettersManagerState copy$default(NewslettersManagerState newslettersManagerState, List list, SiteInfo siteInfo, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            list = newslettersManagerState.subscriptions;
        }
        if ((i5 & 2) != 0) {
            siteInfo = newslettersManagerState.defaultSite;
        }
        return newslettersManagerState.copy(list, siteInfo);
    }

    public final NewslettersManagerState copy(List<NewsletterSubscription> subscriptions, SiteInfo defaultSite) {
        Intrinsics.checkNotNullParameter(subscriptions, "subscriptions");
        return new NewslettersManagerState(subscriptions, defaultSite);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewslettersManagerState)) {
            return false;
        }
        NewslettersManagerState newslettersManagerState = (NewslettersManagerState) other;
        return Intrinsics.areEqual(this.subscriptions, newslettersManagerState.subscriptions) && Intrinsics.areEqual(this.defaultSite, newslettersManagerState.defaultSite);
    }

    public final SiteInfo getDefaultSite() {
        return this.defaultSite;
    }

    public final List<NewsletterSubscription> getSubscriptions() {
        return this.subscriptions;
    }

    public int hashCode() {
        int hashCode = this.subscriptions.hashCode() * 31;
        SiteInfo siteInfo = this.defaultSite;
        return hashCode + (siteInfo == null ? 0 : siteInfo.hashCode());
    }

    public String toString() {
        return "NewslettersManagerState(subscriptions=" + this.subscriptions + ", defaultSite=" + this.defaultSite + ")";
    }

    public /* synthetic */ NewslettersManagerState(List list, SiteInfo siteInfo, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? CollectionsKt.emptyList() : list, (i5 & 2) != 0 ? null : siteInfo);
    }
}
