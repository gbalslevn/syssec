package dk.molslinjen.domain.managers.route;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.model.booking.TransportProducts;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.Transportation;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ<\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Ldk/molslinjen/domain/managers/route/RouteState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/config/Transportation;", "transportations", "Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;", "configuration", "Ldk/molslinjen/domain/managers/ManagerResult;", "Ldk/molslinjen/domain/model/booking/TransportProducts;", "transportProducts", "<init>", "(Ljava/util/List;Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;Ldk/molslinjen/domain/managers/ManagerResult;)V", "copy", "(Ljava/util/List;Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;Ldk/molslinjen/domain/managers/ManagerResult;)Ldk/molslinjen/domain/managers/route/RouteState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getTransportations", "()Ljava/util/List;", "Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;", "getConfiguration", "()Ldk/molslinjen/domain/model/config/LocalizedSiteConfiguration;", "Ldk/molslinjen/domain/managers/ManagerResult;", "getTransportProducts", "()Ldk/molslinjen/domain/managers/ManagerResult;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class RouteState {
    private final LocalizedSiteConfiguration configuration;
    private final ManagerResult<TransportProducts> transportProducts;
    private final List<Transportation> transportations;

    public RouteState(List<Transportation> transportations, LocalizedSiteConfiguration configuration, ManagerResult<TransportProducts> managerResult) {
        Intrinsics.checkNotNullParameter(transportations, "transportations");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.transportations = transportations;
        this.configuration = configuration;
        this.transportProducts = managerResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RouteState copy$default(RouteState routeState, List list, LocalizedSiteConfiguration localizedSiteConfiguration, ManagerResult managerResult, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            list = routeState.transportations;
        }
        if ((i5 & 2) != 0) {
            localizedSiteConfiguration = routeState.configuration;
        }
        if ((i5 & 4) != 0) {
            managerResult = routeState.transportProducts;
        }
        return routeState.copy(list, localizedSiteConfiguration, managerResult);
    }

    public final RouteState copy(List<Transportation> transportations, LocalizedSiteConfiguration configuration, ManagerResult<TransportProducts> transportProducts) {
        Intrinsics.checkNotNullParameter(transportations, "transportations");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return new RouteState(transportations, configuration, transportProducts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RouteState)) {
            return false;
        }
        RouteState routeState = (RouteState) other;
        return Intrinsics.areEqual(this.transportations, routeState.transportations) && Intrinsics.areEqual(this.configuration, routeState.configuration) && Intrinsics.areEqual(this.transportProducts, routeState.transportProducts);
    }

    public final LocalizedSiteConfiguration getConfiguration() {
        return this.configuration;
    }

    public final ManagerResult<TransportProducts> getTransportProducts() {
        return this.transportProducts;
    }

    public int hashCode() {
        int hashCode = ((this.transportations.hashCode() * 31) + this.configuration.hashCode()) * 31;
        ManagerResult<TransportProducts> managerResult = this.transportProducts;
        return hashCode + (managerResult == null ? 0 : managerResult.hashCode());
    }

    public String toString() {
        return "RouteState(transportations=" + this.transportations + ", configuration=" + this.configuration + ", transportProducts=" + this.transportProducts + ")";
    }

    public /* synthetic */ RouteState(List list, LocalizedSiteConfiguration localizedSiteConfiguration, ManagerResult managerResult, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? CollectionsKt.emptyList() : list, localizedSiteConfiguration, (i5 & 4) != 0 ? null : managerResult);
    }
}
