package dk.molslinjen.domain.model.config;

import dk.molslinjen.api.services.config.response.ConfigurationResponseDTO;
import dk.molslinjen.api.shared.response.TransportResponseDTO;
import dk.molslinjen.domain.model.config.Transportation;
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
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002,-B3\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0004\b\n\u0010\u000bB\u0019\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000fBM\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\n\u0010\u0014J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u0003HÆ\u0003J=\u0010\u001f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0011HÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016¨\u0006."}, d2 = {"Ldk/molslinjen/domain/model/config/TransportationCategory;", BuildConfig.FLAVOR, "allowedRouteIds", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isOnlyAvailableWithReturnTicket", BuildConfig.FLAVOR, "name", "transportations", "Ldk/molslinjen/domain/model/config/Transportation;", "<init>", "(Ljava/util/List;ZLjava/lang/String;Ljava/util/List;)V", "transportCategoryDTO", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$TransportCategoryDTO;", "isTransportationSpecificToCategory", "(Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$TransportCategoryDTO;Z)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;ZLjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAllowedRouteIds", "()Ljava/util/List;", "()Z", "getName", "()Ljava/lang/String;", "getTransportations", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class TransportationCategory {
    private static final TransportationCategory mock;
    private final List<String> allowedRouteIds;
    private final boolean isOnlyAvailableWithReturnTicket;
    private final String name;
    private final List<Transportation> transportations;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(StringSerializer.INSTANCE), null, null, new ArrayListSerializer(Transportation$$serializer.INSTANCE)};

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/config/TransportationCategory$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/config/TransportationCategory;", "getMock", "()Ldk/molslinjen/domain/model/config/TransportationCategory;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TransportationCategory getMock() {
            return TransportationCategory.mock;
        }

        public final KSerializer<TransportationCategory> serializer() {
            return TransportationCategory$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"3", "2"});
        Transportation.Companion companion = Transportation.INSTANCE;
        mock = new TransportationCategory(listOf, false, "Bil", CollectionsKt.listOf((Object[]) new Transportation[]{companion.getMockCar(), companion.getMockWalking()}));
    }

    public /* synthetic */ TransportationCategory(int i5, List list, boolean z5, String str, List list2, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i5 & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 15, TransportationCategory$$serializer.INSTANCE.getDescriptor());
        }
        this.allowedRouteIds = list;
        this.isOnlyAvailableWithReturnTicket = z5;
        this.name = str;
        this.transportations = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TransportationCategory copy$default(TransportationCategory transportationCategory, List list, boolean z5, String str, List list2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            list = transportationCategory.allowedRouteIds;
        }
        if ((i5 & 2) != 0) {
            z5 = transportationCategory.isOnlyAvailableWithReturnTicket;
        }
        if ((i5 & 4) != 0) {
            str = transportationCategory.name;
        }
        if ((i5 & 8) != 0) {
            list2 = transportationCategory.transportations;
        }
        return transportationCategory.copy(list, z5, str, list2);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(TransportationCategory self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, kSerializerArr[0], self.allowedRouteIds);
        output.encodeBooleanElement(serialDesc, 1, self.isOnlyAvailableWithReturnTicket);
        output.encodeStringElement(serialDesc, 2, self.name);
        output.encodeSerializableElement(serialDesc, 3, kSerializerArr[3], self.transportations);
    }

    public final List<String> component1() {
        return this.allowedRouteIds;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsOnlyAvailableWithReturnTicket() {
        return this.isOnlyAvailableWithReturnTicket;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<Transportation> component4() {
        return this.transportations;
    }

    public final TransportationCategory copy(List<String> allowedRouteIds, boolean isOnlyAvailableWithReturnTicket, String name, List<Transportation> transportations) {
        Intrinsics.checkNotNullParameter(allowedRouteIds, "allowedRouteIds");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(transportations, "transportations");
        return new TransportationCategory(allowedRouteIds, isOnlyAvailableWithReturnTicket, name, transportations);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransportationCategory)) {
            return false;
        }
        TransportationCategory transportationCategory = (TransportationCategory) other;
        return Intrinsics.areEqual(this.allowedRouteIds, transportationCategory.allowedRouteIds) && this.isOnlyAvailableWithReturnTicket == transportationCategory.isOnlyAvailableWithReturnTicket && Intrinsics.areEqual(this.name, transportationCategory.name) && Intrinsics.areEqual(this.transportations, transportationCategory.transportations);
    }

    public final List<String> getAllowedRouteIds() {
        return this.allowedRouteIds;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Transportation> getTransportations() {
        return this.transportations;
    }

    public int hashCode() {
        return (((((this.allowedRouteIds.hashCode() * 31) + Boolean.hashCode(this.isOnlyAvailableWithReturnTicket)) * 31) + this.name.hashCode()) * 31) + this.transportations.hashCode();
    }

    public final boolean isOnlyAvailableWithReturnTicket() {
        return this.isOnlyAvailableWithReturnTicket;
    }

    public String toString() {
        return "TransportationCategory(allowedRouteIds=" + this.allowedRouteIds + ", isOnlyAvailableWithReturnTicket=" + this.isOnlyAvailableWithReturnTicket + ", name=" + this.name + ", transportations=" + this.transportations + ")";
    }

    public TransportationCategory(List<String> allowedRouteIds, boolean z5, String name, List<Transportation> transportations) {
        Intrinsics.checkNotNullParameter(allowedRouteIds, "allowedRouteIds");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(transportations, "transportations");
        this.allowedRouteIds = allowedRouteIds;
        this.isOnlyAvailableWithReturnTicket = z5;
        this.name = name;
        this.transportations = transportations;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TransportationCategory(ConfigurationResponseDTO.TransportCategoryDTO transportCategoryDTO, boolean z5) {
        this(r0, r1, r2, r4);
        Intrinsics.checkNotNullParameter(transportCategoryDTO, "transportCategoryDTO");
        List<String> allowedRouteIds = transportCategoryDTO.getAllowedRouteIds();
        boolean isOnlyAvailableWithReturnTicket = transportCategoryDTO.isOnlyAvailableWithReturnTicket();
        String name = transportCategoryDTO.getName();
        List<TransportResponseDTO> transports = transportCategoryDTO.getTransports();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(transports, 10));
        Iterator<T> it = transports.iterator();
        while (it.hasNext()) {
            arrayList.add(new Transportation((TransportResponseDTO) it.next(), z5, transportCategoryDTO.getName()));
        }
    }
}
