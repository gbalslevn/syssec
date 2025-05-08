package dk.molslinjen.domain.managers.faq;

import dk.molslinjen.domain.model.faq.SiteFaq;
import dk.molslinjen.domain.model.site.SiteInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/domain/managers/faq/FaqManagerState;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/faq/SiteFaq;", "siteFaq", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/site/SiteInfo;", "availableSites", "<init>", "(Ldk/molslinjen/domain/model/faq/SiteFaq;Ljava/util/List;)V", "copy", "(Ldk/molslinjen/domain/model/faq/SiteFaq;Ljava/util/List;)Ldk/molslinjen/domain/managers/faq/FaqManagerState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/faq/SiteFaq;", "getSiteFaq", "()Ldk/molslinjen/domain/model/faq/SiteFaq;", "Ljava/util/List;", "getAvailableSites", "()Ljava/util/List;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class FaqManagerState {
    private final List<SiteInfo> availableSites;
    private final SiteFaq siteFaq;

    public FaqManagerState(SiteFaq siteFaq, List<SiteInfo> list) {
        this.siteFaq = siteFaq;
        this.availableSites = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FaqManagerState copy$default(FaqManagerState faqManagerState, SiteFaq siteFaq, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            siteFaq = faqManagerState.siteFaq;
        }
        if ((i5 & 2) != 0) {
            list = faqManagerState.availableSites;
        }
        return faqManagerState.copy(siteFaq, list);
    }

    public final FaqManagerState copy(SiteFaq siteFaq, List<SiteInfo> availableSites) {
        return new FaqManagerState(siteFaq, availableSites);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaqManagerState)) {
            return false;
        }
        FaqManagerState faqManagerState = (FaqManagerState) other;
        return Intrinsics.areEqual(this.siteFaq, faqManagerState.siteFaq) && Intrinsics.areEqual(this.availableSites, faqManagerState.availableSites);
    }

    public final List<SiteInfo> getAvailableSites() {
        return this.availableSites;
    }

    public final SiteFaq getSiteFaq() {
        return this.siteFaq;
    }

    public int hashCode() {
        SiteFaq siteFaq = this.siteFaq;
        int hashCode = (siteFaq == null ? 0 : siteFaq.hashCode()) * 31;
        List<SiteInfo> list = this.availableSites;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "FaqManagerState(siteFaq=" + this.siteFaq + ", availableSites=" + this.availableSites + ")";
    }

    public /* synthetic */ FaqManagerState(SiteFaq siteFaq, List list, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : siteFaq, (i5 & 2) != 0 ? null : list);
    }
}
