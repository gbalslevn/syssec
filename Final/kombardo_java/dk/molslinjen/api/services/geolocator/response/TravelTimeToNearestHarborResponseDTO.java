package dk.molslinjen.api.services.geolocator.response;

import java.util.List;
import kotlin.Metadata;
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

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\nHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Ldk/molslinjen/api/services/geolocator/response/TravelTimeToNearestHarborResponseDTO;", BuildConfig.FLAVOR, "harborName", BuildConfig.FLAVOR, "travels", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/geolocator/response/TravelTimeResponseDTO;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getHarborName", "()Ljava/lang/String;", "getTravels", "()Ljava/util/List;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class TravelTimeToNearestHarborResponseDTO {
    private final String harborName;
    private final List<TravelTimeResponseDTO> travels;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(TravelTimeResponseDTO$$serializer.INSTANCE)};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/geolocator/response/TravelTimeToNearestHarborResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/geolocator/response/TravelTimeToNearestHarborResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<TravelTimeToNearestHarborResponseDTO> serializer() {
            return TravelTimeToNearestHarborResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ TravelTimeToNearestHarborResponseDTO(int i5, String str, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i5 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 3, TravelTimeToNearestHarborResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.harborName = str;
        this.travels = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TravelTimeToNearestHarborResponseDTO copy$default(TravelTimeToNearestHarborResponseDTO travelTimeToNearestHarborResponseDTO, String str, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = travelTimeToNearestHarborResponseDTO.harborName;
        }
        if ((i5 & 2) != 0) {
            list = travelTimeToNearestHarborResponseDTO.travels;
        }
        return travelTimeToNearestHarborResponseDTO.copy(str, list);
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(TravelTimeToNearestHarborResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.harborName);
        output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.travels);
    }

    /* renamed from: component1, reason: from getter */
    public final String getHarborName() {
        return this.harborName;
    }

    public final List<TravelTimeResponseDTO> component2() {
        return this.travels;
    }

    public final TravelTimeToNearestHarborResponseDTO copy(String harborName, List<TravelTimeResponseDTO> travels) {
        Intrinsics.checkNotNullParameter(harborName, "harborName");
        Intrinsics.checkNotNullParameter(travels, "travels");
        return new TravelTimeToNearestHarborResponseDTO(harborName, travels);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TravelTimeToNearestHarborResponseDTO)) {
            return false;
        }
        TravelTimeToNearestHarborResponseDTO travelTimeToNearestHarborResponseDTO = (TravelTimeToNearestHarborResponseDTO) other;
        return Intrinsics.areEqual(this.harborName, travelTimeToNearestHarborResponseDTO.harborName) && Intrinsics.areEqual(this.travels, travelTimeToNearestHarborResponseDTO.travels);
    }

    public final String getHarborName() {
        return this.harborName;
    }

    public final List<TravelTimeResponseDTO> getTravels() {
        return this.travels;
    }

    public int hashCode() {
        return (this.harborName.hashCode() * 31) + this.travels.hashCode();
    }

    public String toString() {
        return "TravelTimeToNearestHarborResponseDTO(harborName=" + this.harborName + ", travels=" + this.travels + ")";
    }

    public TravelTimeToNearestHarborResponseDTO(String harborName, List<TravelTimeResponseDTO> travels) {
        Intrinsics.checkNotNullParameter(harborName, "harborName");
        Intrinsics.checkNotNullParameter(travels, "travels");
        this.harborName = harborName;
        this.travels = travels;
    }
}
