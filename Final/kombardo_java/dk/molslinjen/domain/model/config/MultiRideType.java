package dk.molslinjen.domain.model.config;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.config.response.ConfigurationResponseDTO;
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

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002'(B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bB?\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0007\u0010\u0010J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J-\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\rHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0004HÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006)"}, d2 = {"Ldk/molslinjen/domain/model/config/MultiRideType;", BuildConfig.FLAVOR, "allowedTransportIds", BuildConfig.FLAVOR, BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "name", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$MultiRideTypeDTO;", "(Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$MultiRideTypeDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAllowedTransportIds", "()Ljava/util/List;", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class MultiRideType {
    private final List<String> allowedTransportIds;
    private final String id;
    private final String name;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(StringSerializer.INSTANCE), null, null};
    private static final MultiRideType mockStandard = new MultiRideType(CollectionsKt.listOf((Object[]) new String[]{"691K", "691KH"}), "041", "Standard turkort");
    private static final MultiRideType mockBlueClass = new MultiRideType(CollectionsKt.listOf((Object[]) new String[]{"638K", "638KH"}), "081", "Business BlueClass");

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/config/MultiRideType$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mockStandard", "Ldk/molslinjen/domain/model/config/MultiRideType;", "getMockStandard", "()Ldk/molslinjen/domain/model/config/MultiRideType;", "mockBlueClass", "getMockBlueClass", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MultiRideType getMockBlueClass() {
            return MultiRideType.mockBlueClass;
        }

        public final MultiRideType getMockStandard() {
            return MultiRideType.mockStandard;
        }

        public final KSerializer<MultiRideType> serializer() {
            return MultiRideType$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ MultiRideType(int i5, List list, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, MultiRideType$$serializer.INSTANCE.getDescriptor());
        }
        this.allowedTransportIds = list;
        this.id = str;
        this.name = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MultiRideType copy$default(MultiRideType multiRideType, List list, String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            list = multiRideType.allowedTransportIds;
        }
        if ((i5 & 2) != 0) {
            str = multiRideType.id;
        }
        if ((i5 & 4) != 0) {
            str2 = multiRideType.name;
        }
        return multiRideType.copy(list, str, str2);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(MultiRideType self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.allowedTransportIds);
        output.encodeStringElement(serialDesc, 1, self.id);
        output.encodeStringElement(serialDesc, 2, self.name);
    }

    public final List<String> component1() {
        return this.allowedTransportIds;
    }

    /* renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final MultiRideType copy(List<String> allowedTransportIds, String id, String name) {
        Intrinsics.checkNotNullParameter(allowedTransportIds, "allowedTransportIds");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new MultiRideType(allowedTransportIds, id, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiRideType)) {
            return false;
        }
        MultiRideType multiRideType = (MultiRideType) other;
        return Intrinsics.areEqual(this.allowedTransportIds, multiRideType.allowedTransportIds) && Intrinsics.areEqual(this.id, multiRideType.id) && Intrinsics.areEqual(this.name, multiRideType.name);
    }

    public final List<String> getAllowedTransportIds() {
        return this.allowedTransportIds;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (((this.allowedTransportIds.hashCode() * 31) + this.id.hashCode()) * 31) + this.name.hashCode();
    }

    public String toString() {
        return "MultiRideType(allowedTransportIds=" + this.allowedTransportIds + ", id=" + this.id + ", name=" + this.name + ")";
    }

    public MultiRideType(List<String> allowedTransportIds, String id, String name) {
        Intrinsics.checkNotNullParameter(allowedTransportIds, "allowedTransportIds");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.allowedTransportIds = allowedTransportIds;
        this.id = id;
        this.name = name;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiRideType(ConfigurationResponseDTO.MultiRideTypeDTO dto) {
        this(dto.getAllowedTransportIds(), dto.getId(), dto.getName());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
