package dk.molslinjen.api.services.multiRide.response;

import com.sdk.growthbook.utils.Constants;
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

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bBQ\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\rHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u0006/"}, d2 = {"Ldk/molslinjen/api/services/multiRide/response/MultiRideTransportDTO;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "name", "maxHeight", BuildConfig.FLAVOR, "maxLength", "maxWeight", "icon", "<init>", "(Ljava/lang/String;Ljava/lang/String;DDDLjava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;DDDLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName", "getMaxHeight", "()D", "getMaxLength", "getMaxWeight", "getIcon", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class MultiRideTransportDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String icon;
    private final String id;
    private final double maxHeight;
    private final double maxLength;
    private final double maxWeight;
    private final String name;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/multiRide/response/MultiRideTransportDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/multiRide/response/MultiRideTransportDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<MultiRideTransportDTO> serializer() {
            return MultiRideTransportDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ MultiRideTransportDTO(int i5, String str, String str2, double d5, double d6, double d7, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i5 & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 63, MultiRideTransportDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.name = str2;
        this.maxHeight = d5;
        this.maxLength = d6;
        this.maxWeight = d7;
        this.icon = str3;
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(MultiRideTransportDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.name);
        output.encodeDoubleElement(serialDesc, 2, self.maxHeight);
        output.encodeDoubleElement(serialDesc, 3, self.maxLength);
        output.encodeDoubleElement(serialDesc, 4, self.maxWeight);
        output.encodeStringElement(serialDesc, 5, self.icon);
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
    public final double getMaxHeight() {
        return this.maxHeight;
    }

    /* renamed from: component4, reason: from getter */
    public final double getMaxLength() {
        return this.maxLength;
    }

    /* renamed from: component5, reason: from getter */
    public final double getMaxWeight() {
        return this.maxWeight;
    }

    /* renamed from: component6, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    public final MultiRideTransportDTO copy(String id, String name, double maxHeight, double maxLength, double maxWeight, String icon) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return new MultiRideTransportDTO(id, name, maxHeight, maxLength, maxWeight, icon);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiRideTransportDTO)) {
            return false;
        }
        MultiRideTransportDTO multiRideTransportDTO = (MultiRideTransportDTO) other;
        return Intrinsics.areEqual(this.id, multiRideTransportDTO.id) && Intrinsics.areEqual(this.name, multiRideTransportDTO.name) && Double.compare(this.maxHeight, multiRideTransportDTO.maxHeight) == 0 && Double.compare(this.maxLength, multiRideTransportDTO.maxLength) == 0 && Double.compare(this.maxWeight, multiRideTransportDTO.maxWeight) == 0 && Intrinsics.areEqual(this.icon, multiRideTransportDTO.icon);
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.id;
    }

    public final double getMaxHeight() {
        return this.maxHeight;
    }

    public final double getMaxLength() {
        return this.maxLength;
    }

    public final double getMaxWeight() {
        return this.maxWeight;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + Double.hashCode(this.maxHeight)) * 31) + Double.hashCode(this.maxLength)) * 31) + Double.hashCode(this.maxWeight)) * 31) + this.icon.hashCode();
    }

    public String toString() {
        return "MultiRideTransportDTO(id=" + this.id + ", name=" + this.name + ", maxHeight=" + this.maxHeight + ", maxLength=" + this.maxLength + ", maxWeight=" + this.maxWeight + ", icon=" + this.icon + ")";
    }

    public MultiRideTransportDTO(String id, String name, double d5, double d6, double d7, String icon) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.id = id;
        this.name = name;
        this.maxHeight = d5;
        this.maxLength = d6;
        this.maxWeight = d7;
        this.icon = icon;
    }
}
