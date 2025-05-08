package dk.molslinjen.domain.model.agreement.multiRide;

import dk.molslinjen.api.services.multiRide.response.MultiRideTransportDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00020\u0001:\u000201B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\n\u0010\u000eBQ\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\n\u0010\u0013J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003JE\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0010HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001J%\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001¢\u0006\u0002\b/R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u00062"}, d2 = {"Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideTransport;", BuildConfig.FLAVOR, "transportId", BuildConfig.FLAVOR, "name", "maxHeightInMeters", BuildConfig.FLAVOR, "maxLengthInMeters", "maxWeight", "icon", "<init>", "(Ljava/lang/String;Ljava/lang/String;DDDLjava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/multiRide/response/MultiRideTransportDTO;", "(Ldk/molslinjen/api/services/multiRide/response/MultiRideTransportDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;DDDLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTransportId", "()Ljava/lang/String;", "getName", "getMaxHeightInMeters", "()D", "getMaxLengthInMeters", "getMaxWeight", "getIcon", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class MultiRideTransport {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MultiRideTransport mock = new MultiRideTransport("10", "Bil", 2.95d, 6.0d, 3500.0d, "regularcar");
    private final String icon;
    private final double maxHeightInMeters;
    private final double maxLengthInMeters;
    private final double maxWeight;
    private final String name;
    private final String transportId;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideTransport$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideTransport;", "getMock", "()Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideTransport;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MultiRideTransport getMock() {
            return MultiRideTransport.mock;
        }

        public final KSerializer<MultiRideTransport> serializer() {
            return MultiRideTransport$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ MultiRideTransport(int i5, String str, String str2, double d5, double d6, double d7, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i5 & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 63, MultiRideTransport$$serializer.INSTANCE.getDescriptor());
        }
        this.transportId = str;
        this.name = str2;
        this.maxHeightInMeters = d5;
        this.maxLengthInMeters = d6;
        this.maxWeight = d7;
        this.icon = str3;
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(MultiRideTransport self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.transportId);
        output.encodeStringElement(serialDesc, 1, self.name);
        output.encodeDoubleElement(serialDesc, 2, self.maxHeightInMeters);
        output.encodeDoubleElement(serialDesc, 3, self.maxLengthInMeters);
        output.encodeDoubleElement(serialDesc, 4, self.maxWeight);
        output.encodeStringElement(serialDesc, 5, self.icon);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTransportId() {
        return this.transportId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final double getMaxHeightInMeters() {
        return this.maxHeightInMeters;
    }

    /* renamed from: component4, reason: from getter */
    public final double getMaxLengthInMeters() {
        return this.maxLengthInMeters;
    }

    /* renamed from: component5, reason: from getter */
    public final double getMaxWeight() {
        return this.maxWeight;
    }

    /* renamed from: component6, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    public final MultiRideTransport copy(String transportId, String name, double maxHeightInMeters, double maxLengthInMeters, double maxWeight, String icon) {
        Intrinsics.checkNotNullParameter(transportId, "transportId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new MultiRideTransport(transportId, name, maxHeightInMeters, maxLengthInMeters, maxWeight, icon);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiRideTransport)) {
            return false;
        }
        MultiRideTransport multiRideTransport = (MultiRideTransport) other;
        return Intrinsics.areEqual(this.transportId, multiRideTransport.transportId) && Intrinsics.areEqual(this.name, multiRideTransport.name) && Double.compare(this.maxHeightInMeters, multiRideTransport.maxHeightInMeters) == 0 && Double.compare(this.maxLengthInMeters, multiRideTransport.maxLengthInMeters) == 0 && Double.compare(this.maxWeight, multiRideTransport.maxWeight) == 0 && Intrinsics.areEqual(this.icon, multiRideTransport.icon);
    }

    public final String getIcon() {
        return this.icon;
    }

    public final double getMaxHeightInMeters() {
        return this.maxHeightInMeters;
    }

    public final double getMaxLengthInMeters() {
        return this.maxLengthInMeters;
    }

    public final double getMaxWeight() {
        return this.maxWeight;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTransportId() {
        return this.transportId;
    }

    public int hashCode() {
        return (((((((((this.transportId.hashCode() * 31) + this.name.hashCode()) * 31) + Double.hashCode(this.maxHeightInMeters)) * 31) + Double.hashCode(this.maxLengthInMeters)) * 31) + Double.hashCode(this.maxWeight)) * 31) + this.icon.hashCode();
    }

    public String toString() {
        return "MultiRideTransport(transportId=" + this.transportId + ", name=" + this.name + ", maxHeightInMeters=" + this.maxHeightInMeters + ", maxLengthInMeters=" + this.maxLengthInMeters + ", maxWeight=" + this.maxWeight + ", icon=" + this.icon + ")";
    }

    public MultiRideTransport(String transportId, String name, double d5, double d6, double d7, String icon) {
        Intrinsics.checkNotNullParameter(transportId, "transportId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.transportId = transportId;
        this.name = name;
        this.maxHeightInMeters = d5;
        this.maxLengthInMeters = d6;
        this.maxWeight = d7;
        this.icon = icon;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiRideTransport(MultiRideTransportDTO dto) {
        this(dto.getId(), dto.getName(), dto.getMaxHeight(), dto.getMaxLength(), dto.getMaxWeight(), dto.getIcon());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
