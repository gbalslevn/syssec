package dk.molslinjen.ui.views.screens.profile.contact;

import dk.molslinjen.domain.model.config.Site;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0005¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/contact/ContactScreenNavArgs;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/config/Site;", "site", "<init>", "(Ldk/molslinjen/domain/model/config/Site;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/config/Site;", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "setSite", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ContactScreenNavArgs {
    private Site site;

    public ContactScreenNavArgs(Site site) {
        this.site = site;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ContactScreenNavArgs) && this.site == ((ContactScreenNavArgs) other).site;
    }

    public final Site getSite() {
        return this.site;
    }

    public int hashCode() {
        Site site = this.site;
        if (site == null) {
            return 0;
        }
        return site.hashCode();
    }

    public String toString() {
        return "ContactScreenNavArgs(site=" + this.site + ")";
    }
}
