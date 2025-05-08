package dk.molslinjen.domain.model.site;

import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.SiteSupportInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/domain/model/site/SiteInfo;", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/domain/model/config/Site;", "siteName", BuildConfig.FLAVOR, "supportInfo", "Ldk/molslinjen/domain/model/config/SiteSupportInfo;", "<init>", "(Ldk/molslinjen/domain/model/config/Site;Ljava/lang/String;Ldk/molslinjen/domain/model/config/SiteSupportInfo;)V", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "getSiteName", "()Ljava/lang/String;", "getSupportInfo", "()Ldk/molslinjen/domain/model/config/SiteSupportInfo;", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SiteInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SiteInfo mock = new SiteInfo(Site.Mols, "Molslinjen", SiteSupportInfo.INSTANCE.getMock());
    private final Site site;
    private final String siteName;
    private final SiteSupportInfo supportInfo;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/site/SiteInfo$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/site/SiteInfo;", "getMock", "()Ldk/molslinjen/domain/model/site/SiteInfo;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SiteInfo getMock() {
            return SiteInfo.mock;
        }

        private Companion() {
        }
    }

    public SiteInfo(Site site, String siteName, SiteSupportInfo supportInfo) {
        Intrinsics.checkNotNullParameter(site, "site");
        Intrinsics.checkNotNullParameter(siteName, "siteName");
        Intrinsics.checkNotNullParameter(supportInfo, "supportInfo");
        this.site = site;
        this.siteName = siteName;
        this.supportInfo = supportInfo;
    }

    public static /* synthetic */ SiteInfo copy$default(SiteInfo siteInfo, Site site, String str, SiteSupportInfo siteSupportInfo, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            site = siteInfo.site;
        }
        if ((i5 & 2) != 0) {
            str = siteInfo.siteName;
        }
        if ((i5 & 4) != 0) {
            siteSupportInfo = siteInfo.supportInfo;
        }
        return siteInfo.copy(site, str, siteSupportInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final Site getSite() {
        return this.site;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSiteName() {
        return this.siteName;
    }

    /* renamed from: component3, reason: from getter */
    public final SiteSupportInfo getSupportInfo() {
        return this.supportInfo;
    }

    public final SiteInfo copy(Site site, String siteName, SiteSupportInfo supportInfo) {
        Intrinsics.checkNotNullParameter(site, "site");
        Intrinsics.checkNotNullParameter(siteName, "siteName");
        Intrinsics.checkNotNullParameter(supportInfo, "supportInfo");
        return new SiteInfo(site, siteName, supportInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SiteInfo)) {
            return false;
        }
        SiteInfo siteInfo = (SiteInfo) other;
        return this.site == siteInfo.site && Intrinsics.areEqual(this.siteName, siteInfo.siteName) && Intrinsics.areEqual(this.supportInfo, siteInfo.supportInfo);
    }

    public final Site getSite() {
        return this.site;
    }

    public final String getSiteName() {
        return this.siteName;
    }

    public final SiteSupportInfo getSupportInfo() {
        return this.supportInfo;
    }

    public int hashCode() {
        return (((this.site.hashCode() * 31) + this.siteName.hashCode()) * 31) + this.supportInfo.hashCode();
    }

    public String toString() {
        return "SiteInfo(site=" + this.site + ", siteName=" + this.siteName + ", supportInfo=" + this.supportInfo + ")";
    }
}
