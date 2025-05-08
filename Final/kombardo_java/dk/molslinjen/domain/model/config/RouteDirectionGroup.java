package dk.molslinjen.domain.model.config;

import dk.molslinjen.api.services.config.response.ConfigurationResponseDTO;
import dk.molslinjen.domain.model.config.HarborReference;
import dk.molslinjen.domain.model.config.RouteDirectionDetails;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000223B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u0019\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\f\u0010\u0011BQ\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\f\u0010\u0016J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003JA\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0013HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J%\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0001¢\u0006\u0002\b1R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001e¨\u00064"}, d2 = {"Ldk/molslinjen/domain/model/config/RouteDirectionGroup;", BuildConfig.FLAVOR, "mainRouteId", BuildConfig.FLAVOR, "routes", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/config/RouteDirectionDetails;", "useRegionsAsHarbors", BuildConfig.FLAVOR, "departureHarbor", "Ldk/molslinjen/domain/model/config/HarborReference;", "arrivalHarbor", "<init>", "(Ljava/lang/String;Ljava/util/List;ZLdk/molslinjen/domain/model/config/HarborReference;Ldk/molslinjen/domain/model/config/HarborReference;)V", "routeDirectionGroupDTO", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDirectionGroupDTO;", "useRegions", "(Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDirectionGroupDTO;Z)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;ZLdk/molslinjen/domain/model/config/HarborReference;Ldk/molslinjen/domain/model/config/HarborReference;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMainRouteId", "()Ljava/lang/String;", "getRoutes", "()Ljava/util/List;", "getUseRegionsAsHarbors", "()Z", "getDepartureHarbor", "()Ldk/molslinjen/domain/model/config/HarborReference;", "getArrivalHarbor", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class RouteDirectionGroup {
    private static final RouteDirectionGroup mockAarhusOdden;
    private static final RouteDirectionGroup mockOddenAarhus;
    private final HarborReference arrivalHarbor;
    private final HarborReference departureHarbor;
    private final String mainRouteId;
    private final List<RouteDirectionDetails> routes;
    private final boolean useRegionsAsHarbors;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(RouteDirectionDetails$$serializer.INSTANCE), null, null, null};

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/config/RouteDirectionGroup$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mockAarhusOdden", "Ldk/molslinjen/domain/model/config/RouteDirectionGroup;", "getMockAarhusOdden", "()Ldk/molslinjen/domain/model/config/RouteDirectionGroup;", "mockOddenAarhus", "getMockOddenAarhus", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RouteDirectionGroup getMockAarhusOdden() {
            return RouteDirectionGroup.mockAarhusOdden;
        }

        public final RouteDirectionGroup getMockOddenAarhus() {
            return RouteDirectionGroup.mockOddenAarhus;
        }

        public final KSerializer<RouteDirectionGroup> serializer() {
            return RouteDirectionGroup$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        RouteDirectionDetails.Companion companion = RouteDirectionDetails.INSTANCE;
        List listOf = CollectionsKt.listOf(companion.getMockAarhusOdden());
        HarborReference.Companion companion2 = HarborReference.INSTANCE;
        mockAarhusOdden = new RouteDirectionGroup("ÅRH3", listOf, true, companion2.getMockAarhus(), companion2.getMockZealand());
        mockOddenAarhus = new RouteDirectionGroup("SJÆ3", CollectionsKt.listOf(companion.getMockOddenAarhus()), true, companion2.getMockZealand(), companion2.getMockAarhus());
    }

    public /* synthetic */ RouteDirectionGroup(int i5, String str, List list, boolean z5, HarborReference harborReference, HarborReference harborReference2, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i5 & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 31, RouteDirectionGroup$$serializer.INSTANCE.getDescriptor());
        }
        this.mainRouteId = str;
        this.routes = list;
        this.useRegionsAsHarbors = z5;
        this.departureHarbor = harborReference;
        this.arrivalHarbor = harborReference2;
    }

    public static /* synthetic */ RouteDirectionGroup copy$default(RouteDirectionGroup routeDirectionGroup, String str, List list, boolean z5, HarborReference harborReference, HarborReference harborReference2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = routeDirectionGroup.mainRouteId;
        }
        if ((i5 & 2) != 0) {
            list = routeDirectionGroup.routes;
        }
        List list2 = list;
        if ((i5 & 4) != 0) {
            z5 = routeDirectionGroup.useRegionsAsHarbors;
        }
        boolean z6 = z5;
        if ((i5 & 8) != 0) {
            harborReference = routeDirectionGroup.departureHarbor;
        }
        HarborReference harborReference3 = harborReference;
        if ((i5 & 16) != 0) {
            harborReference2 = routeDirectionGroup.arrivalHarbor;
        }
        return routeDirectionGroup.copy(str, list2, z6, harborReference3, harborReference2);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(RouteDirectionGroup self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.mainRouteId);
        output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.routes);
        output.encodeBooleanElement(serialDesc, 2, self.useRegionsAsHarbors);
        HarborReference$$serializer harborReference$$serializer = HarborReference$$serializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 3, harborReference$$serializer, self.departureHarbor);
        output.encodeSerializableElement(serialDesc, 4, harborReference$$serializer, self.arrivalHarbor);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMainRouteId() {
        return this.mainRouteId;
    }

    public final List<RouteDirectionDetails> component2() {
        return this.routes;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getUseRegionsAsHarbors() {
        return this.useRegionsAsHarbors;
    }

    /* renamed from: component4, reason: from getter */
    public final HarborReference getDepartureHarbor() {
        return this.departureHarbor;
    }

    /* renamed from: component5, reason: from getter */
    public final HarborReference getArrivalHarbor() {
        return this.arrivalHarbor;
    }

    public final RouteDirectionGroup copy(String mainRouteId, List<RouteDirectionDetails> routes, boolean useRegionsAsHarbors, HarborReference departureHarbor, HarborReference arrivalHarbor) {
        Intrinsics.checkNotNullParameter(mainRouteId, "mainRouteId");
        Intrinsics.checkNotNullParameter(routes, "routes");
        Intrinsics.checkNotNullParameter(departureHarbor, "departureHarbor");
        Intrinsics.checkNotNullParameter(arrivalHarbor, "arrivalHarbor");
        return new RouteDirectionGroup(mainRouteId, routes, useRegionsAsHarbors, departureHarbor, arrivalHarbor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RouteDirectionGroup)) {
            return false;
        }
        RouteDirectionGroup routeDirectionGroup = (RouteDirectionGroup) other;
        return Intrinsics.areEqual(this.mainRouteId, routeDirectionGroup.mainRouteId) && Intrinsics.areEqual(this.routes, routeDirectionGroup.routes) && this.useRegionsAsHarbors == routeDirectionGroup.useRegionsAsHarbors && Intrinsics.areEqual(this.departureHarbor, routeDirectionGroup.departureHarbor) && Intrinsics.areEqual(this.arrivalHarbor, routeDirectionGroup.arrivalHarbor);
    }

    public final HarborReference getArrivalHarbor() {
        return this.arrivalHarbor;
    }

    public final HarborReference getDepartureHarbor() {
        return this.departureHarbor;
    }

    public final String getMainRouteId() {
        return this.mainRouteId;
    }

    public final List<RouteDirectionDetails> getRoutes() {
        return this.routes;
    }

    public final boolean getUseRegionsAsHarbors() {
        return this.useRegionsAsHarbors;
    }

    public int hashCode() {
        return (((((((this.mainRouteId.hashCode() * 31) + this.routes.hashCode()) * 31) + Boolean.hashCode(this.useRegionsAsHarbors)) * 31) + this.departureHarbor.hashCode()) * 31) + this.arrivalHarbor.hashCode();
    }

    public String toString() {
        return "RouteDirectionGroup(mainRouteId=" + this.mainRouteId + ", routes=" + this.routes + ", useRegionsAsHarbors=" + this.useRegionsAsHarbors + ", departureHarbor=" + this.departureHarbor + ", arrivalHarbor=" + this.arrivalHarbor + ")";
    }

    public RouteDirectionGroup(String mainRouteId, List<RouteDirectionDetails> routes, boolean z5, HarborReference departureHarbor, HarborReference arrivalHarbor) {
        Intrinsics.checkNotNullParameter(mainRouteId, "mainRouteId");
        Intrinsics.checkNotNullParameter(routes, "routes");
        Intrinsics.checkNotNullParameter(departureHarbor, "departureHarbor");
        Intrinsics.checkNotNullParameter(arrivalHarbor, "arrivalHarbor");
        this.mainRouteId = mainRouteId;
        this.routes = routes;
        this.useRegionsAsHarbors = z5;
        this.departureHarbor = departureHarbor;
        this.arrivalHarbor = arrivalHarbor;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RouteDirectionGroup(ConfigurationResponseDTO.RouteDirectionGroupDTO routeDirectionGroupDTO, boolean z5) {
        this(r2, r3, z5, new HarborReference(((ConfigurationResponseDTO.RouteDirectionDetailsDTO) CollectionsKt.first((List) routeDirectionGroupDTO.getRoutes())).getDepartureHarbor()), new HarborReference(((ConfigurationResponseDTO.RouteDirectionDetailsDTO) CollectionsKt.first((List) routeDirectionGroupDTO.getRoutes())).getArrivalHarbor()));
        Intrinsics.checkNotNullParameter(routeDirectionGroupDTO, "routeDirectionGroupDTO");
        String mainRouteId = routeDirectionGroupDTO.getMainRouteId();
        List<ConfigurationResponseDTO.RouteDirectionDetailsDTO> routes = routeDirectionGroupDTO.getRoutes();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(routes, 10));
        Iterator<T> it = routes.iterator();
        while (it.hasNext()) {
            arrayList.add(new RouteDirectionDetails((ConfigurationResponseDTO.RouteDirectionDetailsDTO) it.next(), z5));
        }
    }
}
