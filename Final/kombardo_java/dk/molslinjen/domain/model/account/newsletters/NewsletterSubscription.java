package dk.molslinjen.domain.model.account.newsletters;

import dk.molslinjen.domain.model.site.SiteInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000b¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/domain/model/account/newsletters/NewsletterSubscription;", BuildConfig.FLAVOR, "siteInfo", "Ldk/molslinjen/domain/model/site/SiteInfo;", "isNewslettersSubscribed", BuildConfig.FLAVOR, "isPromotionsSubscribed", "<init>", "(Ldk/molslinjen/domain/model/site/SiteInfo;ZZ)V", "getSiteInfo", "()Ldk/molslinjen/domain/model/site/SiteInfo;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class NewsletterSubscription {
    private final boolean isNewslettersSubscribed;
    private final boolean isPromotionsSubscribed;
    private final SiteInfo siteInfo;

    public NewsletterSubscription(SiteInfo siteInfo, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(siteInfo, "siteInfo");
        this.siteInfo = siteInfo;
        this.isNewslettersSubscribed = z5;
        this.isPromotionsSubscribed = z6;
    }

    public static /* synthetic */ NewsletterSubscription copy$default(NewsletterSubscription newsletterSubscription, SiteInfo siteInfo, boolean z5, boolean z6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            siteInfo = newsletterSubscription.siteInfo;
        }
        if ((i5 & 2) != 0) {
            z5 = newsletterSubscription.isNewslettersSubscribed;
        }
        if ((i5 & 4) != 0) {
            z6 = newsletterSubscription.isPromotionsSubscribed;
        }
        return newsletterSubscription.copy(siteInfo, z5, z6);
    }

    /* renamed from: component1, reason: from getter */
    public final SiteInfo getSiteInfo() {
        return this.siteInfo;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsNewslettersSubscribed() {
        return this.isNewslettersSubscribed;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsPromotionsSubscribed() {
        return this.isPromotionsSubscribed;
    }

    public final NewsletterSubscription copy(SiteInfo siteInfo, boolean isNewslettersSubscribed, boolean isPromotionsSubscribed) {
        Intrinsics.checkNotNullParameter(siteInfo, "siteInfo");
        return new NewsletterSubscription(siteInfo, isNewslettersSubscribed, isPromotionsSubscribed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NewsletterSubscription)) {
            return false;
        }
        NewsletterSubscription newsletterSubscription = (NewsletterSubscription) other;
        return Intrinsics.areEqual(this.siteInfo, newsletterSubscription.siteInfo) && this.isNewslettersSubscribed == newsletterSubscription.isNewslettersSubscribed && this.isPromotionsSubscribed == newsletterSubscription.isPromotionsSubscribed;
    }

    public final SiteInfo getSiteInfo() {
        return this.siteInfo;
    }

    public int hashCode() {
        return (((this.siteInfo.hashCode() * 31) + Boolean.hashCode(this.isNewslettersSubscribed)) * 31) + Boolean.hashCode(this.isPromotionsSubscribed);
    }

    public final boolean isNewslettersSubscribed() {
        return this.isNewslettersSubscribed;
    }

    public final boolean isPromotionsSubscribed() {
        return this.isPromotionsSubscribed;
    }

    public String toString() {
        return "NewsletterSubscription(siteInfo=" + this.siteInfo + ", isNewslettersSubscribed=" + this.isNewslettersSubscribed + ", isPromotionsSubscribed=" + this.isPromotionsSubscribed + ")";
    }
}
