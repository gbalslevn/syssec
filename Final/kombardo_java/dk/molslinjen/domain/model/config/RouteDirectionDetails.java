package dk.molslinjen.domain.model.config;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.config.response.ConfigurationResponseDTO;
import dk.molslinjen.api.shared.response.RouteTypeResponseDTO;
import dk.molslinjen.api.shared.response.SublineDTO;
import dk.molslinjen.domain.model.booking.RouteType;
import dk.molslinjen.domain.model.config.HarborReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 =2\u00020\u0001:\u0002=>BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011B\u0019\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0014Bo\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0010\u0010\u0019J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\bHÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u000fHÆ\u0003Je\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u00101\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0016HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001J%\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006?"}, d2 = {"Ldk/molslinjen/domain/model/config/RouteDirectionDetails;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "name", "askForPersonData", BuildConfig.FLAVOR, "departureHarbor", "Ldk/molslinjen/domain/model/config/HarborReference;", "arrivalHarbor", "useRegionsAsHarbors", "routeType", "Ldk/molslinjen/domain/model/booking/RouteType;", "isSubRoute", "subline", "Ldk/molslinjen/domain/model/config/Subline;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLdk/molslinjen/domain/model/config/HarborReference;Ldk/molslinjen/domain/model/config/HarborReference;ZLdk/molslinjen/domain/model/booking/RouteType;ZLdk/molslinjen/domain/model/config/Subline;)V", "routeDirectionDetailsDTO", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDirectionDetailsDTO;", "(Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$RouteDirectionDetailsDTO;Z)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;ZLdk/molslinjen/domain/model/config/HarborReference;Ldk/molslinjen/domain/model/config/HarborReference;ZLdk/molslinjen/domain/model/booking/RouteType;ZLdk/molslinjen/domain/model/config/Subline;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName", "getAskForPersonData", "()Z", "getDepartureHarbor", "()Ldk/molslinjen/domain/model/config/HarborReference;", "getArrivalHarbor", "getUseRegionsAsHarbors", "getRouteType", "()Ldk/molslinjen/domain/model/booking/RouteType;", "getSubline", "()Ldk/molslinjen/domain/model/config/Subline;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class RouteDirectionDetails {
    private static final RouteDirectionDetails mockAarhusOdden;
    private static final RouteDirectionDetails mockOddenAarhus;
    private final HarborReference arrivalHarbor;
    private final boolean askForPersonData;
    private final HarborReference departureHarbor;
    private final String id;
    private final boolean isSubRoute;
    private final String name;
    private final RouteType routeType;
    private final Subline subline;
    private final boolean useRegionsAsHarbors;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, EnumsKt.createSimpleEnumSerializer("dk.molslinjen.domain.model.booking.RouteType", RouteType.values()), null, null};

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/config/RouteDirectionDetails$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mockAarhusOdden", "Ldk/molslinjen/domain/model/config/RouteDirectionDetails;", "getMockAarhusOdden", "()Ldk/molslinjen/domain/model/config/RouteDirectionDetails;", "mockOddenAarhus", "getMockOddenAarhus", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RouteDirectionDetails getMockAarhusOdden() {
            return RouteDirectionDetails.mockAarhusOdden;
        }

        public final RouteDirectionDetails getMockOddenAarhus() {
            return RouteDirectionDetails.mockOddenAarhus;
        }

        public final KSerializer<RouteDirectionDetails> serializer() {
            return RouteDirectionDetails$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        HarborReference.Companion companion = HarborReference.INSTANCE;
        HarborReference mockAarhus = companion.getMockAarhus();
        HarborReference mockZealand = companion.getMockZealand();
        RouteType routeType = RouteType.Ferry;
        mockAarhusOdden = new RouteDirectionDetails("ÅRH3", "Aarhus - Odden", true, mockAarhus, mockZealand, true, routeType, false, Subline.INSTANCE.getMock());
        mockOddenAarhus = new RouteDirectionDetails("SJÆ3", "Odden - Aarhus", true, companion.getMockZealand(), companion.getMockAarhus(), true, routeType, false, null);
    }

    public /* synthetic */ RouteDirectionDetails(int i5, String str, String str2, boolean z5, HarborReference harborReference, HarborReference harborReference2, boolean z6, RouteType routeType, boolean z7, Subline subline, SerializationConstructorMarker serializationConstructorMarker) {
        if (511 != (i5 & 511)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 511, RouteDirectionDetails$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.name = str2;
        this.askForPersonData = z5;
        this.departureHarbor = harborReference;
        this.arrivalHarbor = harborReference2;
        this.useRegionsAsHarbors = z6;
        this.routeType = routeType;
        this.isSubRoute = z7;
        this.subline = subline;
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(RouteDirectionDetails self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.name);
        output.encodeBooleanElement(serialDesc, 2, self.askForPersonData);
        HarborReference$$serializer harborReference$$serializer = HarborReference$$serializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 3, harborReference$$serializer, self.departureHarbor);
        output.encodeSerializableElement(serialDesc, 4, harborReference$$serializer, self.arrivalHarbor);
        output.encodeBooleanElement(serialDesc, 5, self.useRegionsAsHarbors);
        output.encodeSerializableElement(serialDesc, 6, kSerializerArr[6], self.routeType);
        output.encodeBooleanElement(serialDesc, 7, self.isSubRoute);
        output.encodeNullableSerializableElement(serialDesc, 8, Subline$$serializer.INSTANCE, self.subline);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getAskForPersonData() {
        return this.askForPersonData;
    }

    /* renamed from: component4, reason: from getter */
    public final HarborReference getDepartureHarbor() {
        return this.departureHarbor;
    }

    /* renamed from: component5, reason: from getter */
    public final HarborReference getArrivalHarbor() {
        return this.arrivalHarbor;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getUseRegionsAsHarbors() {
        return this.useRegionsAsHarbors;
    }

    /* renamed from: component7, reason: from getter */
    public final RouteType getRouteType() {
        return this.routeType;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsSubRoute() {
        return this.isSubRoute;
    }

    /* renamed from: component9, reason: from getter */
    public final Subline getSubline() {
        return this.subline;
    }

    public final RouteDirectionDetails copy(String id, String name, boolean askForPersonData, HarborReference departureHarbor, HarborReference arrivalHarbor, boolean useRegionsAsHarbors, RouteType routeType, boolean isSubRoute, Subline subline) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(departureHarbor, "departureHarbor");
        Intrinsics.checkNotNullParameter(arrivalHarbor, "arrivalHarbor");
        Intrinsics.checkNotNullParameter(routeType, "routeType");
        return new RouteDirectionDetails(id, name, askForPersonData, departureHarbor, arrivalHarbor, useRegionsAsHarbors, routeType, isSubRoute, subline);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RouteDirectionDetails)) {
            return false;
        }
        RouteDirectionDetails routeDirectionDetails = (RouteDirectionDetails) other;
        return Intrinsics.areEqual(this.id, routeDirectionDetails.id) && Intrinsics.areEqual(this.name, routeDirectionDetails.name) && this.askForPersonData == routeDirectionDetails.askForPersonData && Intrinsics.areEqual(this.departureHarbor, routeDirectionDetails.departureHarbor) && Intrinsics.areEqual(this.arrivalHarbor, routeDirectionDetails.arrivalHarbor) && this.useRegionsAsHarbors == routeDirectionDetails.useRegionsAsHarbors && this.routeType == routeDirectionDetails.routeType && this.isSubRoute == routeDirectionDetails.isSubRoute && Intrinsics.areEqual(this.subline, routeDirectionDetails.subline);
    }

    public final HarborReference getArrivalHarbor() {
        return this.arrivalHarbor;
    }

    public final boolean getAskForPersonData() {
        return this.askForPersonData;
    }

    public final HarborReference getDepartureHarbor() {
        return this.departureHarbor;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final RouteType getRouteType() {
        return this.routeType;
    }

    public final Subline getSubline() {
        return this.subline;
    }

    public final boolean getUseRegionsAsHarbors() {
        return this.useRegionsAsHarbors;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + Boolean.hashCode(this.askForPersonData)) * 31) + this.departureHarbor.hashCode()) * 31) + this.arrivalHarbor.hashCode()) * 31) + Boolean.hashCode(this.useRegionsAsHarbors)) * 31) + this.routeType.hashCode()) * 31) + Boolean.hashCode(this.isSubRoute)) * 31;
        Subline subline = this.subline;
        return hashCode + (subline == null ? 0 : subline.hashCode());
    }

    public final boolean isSubRoute() {
        return this.isSubRoute;
    }

    public String toString() {
        return "RouteDirectionDetails(id=" + this.id + ", name=" + this.name + ", askForPersonData=" + this.askForPersonData + ", departureHarbor=" + this.departureHarbor + ", arrivalHarbor=" + this.arrivalHarbor + ", useRegionsAsHarbors=" + this.useRegionsAsHarbors + ", routeType=" + this.routeType + ", isSubRoute=" + this.isSubRoute + ", subline=" + this.subline + ")";
    }

    public RouteDirectionDetails(String id, String name, boolean z5, HarborReference departureHarbor, HarborReference arrivalHarbor, boolean z6, RouteType routeType, boolean z7, Subline subline) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(departureHarbor, "departureHarbor");
        Intrinsics.checkNotNullParameter(arrivalHarbor, "arrivalHarbor");
        Intrinsics.checkNotNullParameter(routeType, "routeType");
        this.id = id;
        this.name = name;
        this.askForPersonData = z5;
        this.departureHarbor = departureHarbor;
        this.arrivalHarbor = arrivalHarbor;
        this.useRegionsAsHarbors = z6;
        this.routeType = routeType;
        this.isSubRoute = z7;
        this.subline = subline;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RouteDirectionDetails(ConfigurationResponseDTO.RouteDirectionDetailsDTO routeDirectionDetailsDTO, boolean z5) {
        this(r2, r3, r4, r5, r6, z5, r8, r9, r12 != null ? new Subline(r12) : null);
        Intrinsics.checkNotNullParameter(routeDirectionDetailsDTO, "routeDirectionDetailsDTO");
        String id = routeDirectionDetailsDTO.getId();
        String name = routeDirectionDetailsDTO.getName();
        boolean askForPersonData = routeDirectionDetailsDTO.getAskForPersonData();
        HarborReference harborReference = new HarborReference(routeDirectionDetailsDTO.getDepartureHarbor());
        HarborReference harborReference2 = new HarborReference(routeDirectionDetailsDTO.getArrivalHarbor());
        RouteType invoke = RouteType.INSTANCE.invoke((RouteTypeResponseDTO) CollectionsKt.first((List) routeDirectionDetailsDTO.getRouteTypes()));
        boolean isSubRoute = routeDirectionDetailsDTO.isSubRoute();
        SublineDTO subline = routeDirectionDetailsDTO.getSubline();
    }
}
