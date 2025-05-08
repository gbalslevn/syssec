package dk.molslinjen.ui.views.screens.tickets.details;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.domain.model.config.Site;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\b\u0010\u001a¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/details/TicketDetailsScreenNavArgs;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "phone", "Ldk/molslinjen/domain/model/config/Site;", "site", BuildConfig.FLAVOR, "isHistory", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;Z)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getPhone", "Ldk/molslinjen/domain/model/config/Site;", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "Z", "()Z", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class TicketDetailsScreenNavArgs {
    private final String id;
    private final boolean isHistory;
    private final String phone;
    private final Site site;

    public TicketDetailsScreenNavArgs(String id, String phone, Site site, boolean z5) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(site, "site");
        this.id = id;
        this.phone = phone;
        this.site = site;
        this.isHistory = z5;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TicketDetailsScreenNavArgs)) {
            return false;
        }
        TicketDetailsScreenNavArgs ticketDetailsScreenNavArgs = (TicketDetailsScreenNavArgs) other;
        return Intrinsics.areEqual(this.id, ticketDetailsScreenNavArgs.id) && Intrinsics.areEqual(this.phone, ticketDetailsScreenNavArgs.phone) && this.site == ticketDetailsScreenNavArgs.site && this.isHistory == ticketDetailsScreenNavArgs.isHistory;
    }

    public final String getId() {
        return this.id;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final Site getSite() {
        return this.site;
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.phone.hashCode()) * 31) + this.site.hashCode()) * 31) + Boolean.hashCode(this.isHistory);
    }

    /* renamed from: isHistory, reason: from getter */
    public final boolean getIsHistory() {
        return this.isHistory;
    }

    public String toString() {
        return "TicketDetailsScreenNavArgs(id=" + this.id + ", phone=" + this.phone + ", site=" + this.site + ", isHistory=" + this.isHistory + ")";
    }
}
