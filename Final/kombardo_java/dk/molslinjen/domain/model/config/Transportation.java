package dk.molslinjen.domain.model.config;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.shared.response.TransportResponseDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 a2\u00020\u0001:\u0002abB·\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eB!\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020 \u0012\u0006\u0010!\u001a\u00020\u0006\u0012\u0006\u0010\"\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010#B\u0019\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020 \u0012\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010$BÕ\u0001\b\u0010\u0012\u0006\u0010%\u001a\u00020\u0013\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\b\u0010&\u001a\u0004\u0018\u00010'¢\u0006\u0004\b\u001d\u0010(J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0006HÆ\u0003J\t\u0010A\u001a\u00020\u0006HÆ\u0003J\t\u0010B\u001a\u00020\u0006HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010D\u001a\u00020\u0004HÆ\u0003J\t\u0010E\u001a\u00020\u0006HÆ\u0003J\t\u0010F\u001a\u00020\u0006HÆ\u0003J\t\u0010G\u001a\u00020\u0006HÆ\u0003J\t\u0010H\u001a\u00020\u0006HÆ\u0003J\t\u0010I\u001a\u00020\u0010HÆ\u0003J\t\u0010J\u001a\u00020\u0010HÆ\u0003J\t\u0010K\u001a\u00020\u0013HÆ\u0003J\t\u0010L\u001a\u00020\u0010HÆ\u0003J\t\u0010M\u001a\u00020\u0004HÆ\u0003J\t\u0010N\u001a\u00020\u0004HÆ\u0003J\t\u0010O\u001a\u00020\u0018HÆ\u0003J\t\u0010P\u001a\u00020\u0006HÆ\u0003J\t\u0010Q\u001a\u00020\u0006HÆ\u0003J\t\u0010R\u001a\u00020\u0006HÆ\u0003J\t\u0010S\u001a\u00020\u0006HÆ\u0003Jã\u0001\u0010T\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0006HÆ\u0001J\u0013\u0010U\u001a\u00020\u00062\b\u0010V\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010W\u001a\u00020\u0013HÖ\u0001J\t\u0010X\u001a\u00020\u0004HÖ\u0001J%\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\u00002\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_H\u0001¢\u0006\u0002\b`R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b.\u0010,R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010,R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010,R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010,R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010,R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0014\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b7\u00103R\u0011\u0010\u0015\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00100R\u0011\u0010\u0016\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u00100R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010\u0019\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b<\u0010,R\u0011\u0010\u001a\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b=\u0010,R\u0011\u0010\u001b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b>\u0010,R\u0011\u0010\u001c\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010,¨\u0006c"}, d2 = {"Ldk/molslinjen/domain/model/config/Transportation;", BuildConfig.FLAVOR, "allowedRouteIds", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "adultRequired", BuildConfig.FLAVOR, "adultRequiredForInfants", "allowLicensePlate", "imageUrl", Constants.ID_ATTRIBUTE_KEY, "isEarlyCheckInAllowed", "isFreightPossible", "isWalking", "isOnlyAvailableWithReturnTicket", "maxHeight", BuildConfig.FLAVOR, "maxLength", "maxPassengers", BuildConfig.FLAVOR, "maxWeight", "name", "nameWithoutPossibleCategory", "passengerEntryType", "Ldk/molslinjen/domain/model/config/PassengerEntryType;", "personDataOnlyForChauffeur", "licensePlateRequired", "trailerAllowed", "isTura", "<init>", "(Ljava/util/List;ZZZLjava/lang/String;Ljava/lang/String;ZZZZDDIDLjava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/PassengerEntryType;ZZZZ)V", "transportResponseDTO", "Ldk/molslinjen/api/shared/response/TransportResponseDTO;", "addTransportationCategoryName", "categoryName", "(Ldk/molslinjen/api/shared/response/TransportResponseDTO;ZLjava/lang/String;)V", "(Ldk/molslinjen/api/shared/response/TransportResponseDTO;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;ZZZLjava/lang/String;Ljava/lang/String;ZZZZDDIDLjava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/PassengerEntryType;ZZZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAllowedRouteIds", "()Ljava/util/List;", "getAdultRequired", "()Z", "getAdultRequiredForInfants", "getAllowLicensePlate", "getImageUrl", "()Ljava/lang/String;", "getId", "getMaxHeight", "()D", "getMaxLength", "getMaxPassengers", "()I", "getMaxWeight", "getName", "getNameWithoutPossibleCategory", "getPassengerEntryType", "()Ldk/molslinjen/domain/model/config/PassengerEntryType;", "getPersonDataOnlyForChauffeur", "getLicensePlateRequired", "getTrailerAllowed", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class Transportation {
    private final boolean adultRequired;
    private final boolean adultRequiredForInfants;
    private final boolean allowLicensePlate;
    private final List<String> allowedRouteIds;
    private final String id;
    private final String imageUrl;
    private final boolean isEarlyCheckInAllowed;
    private final boolean isFreightPossible;
    private final boolean isOnlyAvailableWithReturnTicket;
    private final boolean isTura;
    private final boolean isWalking;
    private final boolean licensePlateRequired;
    private final double maxHeight;
    private final double maxLength;
    private final int maxPassengers;
    private final double maxWeight;
    private final String name;
    private final String nameWithoutPossibleCategory;
    private final PassengerEntryType passengerEntryType;
    private final boolean personDataOnlyForChauffeur;
    private final boolean trailerAllowed;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(StringSerializer.INSTANCE), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, EnumsKt.createSimpleEnumSerializer("dk.molslinjen.domain.model.config.PassengerEntryType", PassengerEntryType.values()), null, null, null, null};
    private static final Transportation mockCar = new Transportation(CollectionsKt.listOf((Object[]) new String[]{"3", "2"}), true, false, true, "/media/95525/test.svg", "10", true, false, false, false, 1.85d, 6.0d, 9, 3.5d, "Bil", "Bil", PassengerEntryType.Standard, false, false, true, false);
    private static final Transportation mockWalking = new Transportation(CollectionsKt.listOf((Object[]) new String[]{"3", "2"}), false, true, false, null, "8888PASS", false, false, true, false, 0.0d, 0.0d, 207, 0.0d, "Gående", "Gående", PassengerEntryType.AdultsAndChildren, false, false, false, false);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/config/Transportation$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mockCar", "Ldk/molslinjen/domain/model/config/Transportation;", "getMockCar", "()Ldk/molslinjen/domain/model/config/Transportation;", "mockWalking", "getMockWalking", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Transportation getMockCar() {
            return Transportation.mockCar;
        }

        public final Transportation getMockWalking() {
            return Transportation.mockWalking;
        }

        public final KSerializer<Transportation> serializer() {
            return Transportation$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Transportation(int i5, List list, boolean z5, boolean z6, boolean z7, String str, String str2, boolean z8, boolean z9, boolean z10, boolean z11, double d5, double d6, int i6, double d7, String str3, String str4, PassengerEntryType passengerEntryType, boolean z12, boolean z13, boolean z14, boolean z15, SerializationConstructorMarker serializationConstructorMarker) {
        if (2097151 != (i5 & 2097151)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 2097151, Transportation$$serializer.INSTANCE.getDescriptor());
        }
        this.allowedRouteIds = list;
        this.adultRequired = z5;
        this.adultRequiredForInfants = z6;
        this.allowLicensePlate = z7;
        this.imageUrl = str;
        this.id = str2;
        this.isEarlyCheckInAllowed = z8;
        this.isFreightPossible = z9;
        this.isWalking = z10;
        this.isOnlyAvailableWithReturnTicket = z11;
        this.maxHeight = d5;
        this.maxLength = d6;
        this.maxPassengers = i6;
        this.maxWeight = d7;
        this.name = str3;
        this.nameWithoutPossibleCategory = str4;
        this.passengerEntryType = passengerEntryType;
        this.personDataOnlyForChauffeur = z12;
        this.licensePlateRequired = z13;
        this.trailerAllowed = z14;
        this.isTura = z15;
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(Transportation self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, kSerializerArr[0], self.allowedRouteIds);
        output.encodeBooleanElement(serialDesc, 1, self.adultRequired);
        output.encodeBooleanElement(serialDesc, 2, self.adultRequiredForInfants);
        output.encodeBooleanElement(serialDesc, 3, self.allowLicensePlate);
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.imageUrl);
        output.encodeStringElement(serialDesc, 5, self.id);
        output.encodeBooleanElement(serialDesc, 6, self.isEarlyCheckInAllowed);
        output.encodeBooleanElement(serialDesc, 7, self.isFreightPossible);
        output.encodeBooleanElement(serialDesc, 8, self.isWalking);
        output.encodeBooleanElement(serialDesc, 9, self.isOnlyAvailableWithReturnTicket);
        output.encodeDoubleElement(serialDesc, 10, self.maxHeight);
        output.encodeDoubleElement(serialDesc, 11, self.maxLength);
        output.encodeIntElement(serialDesc, 12, self.maxPassengers);
        output.encodeDoubleElement(serialDesc, 13, self.maxWeight);
        output.encodeStringElement(serialDesc, 14, self.name);
        output.encodeStringElement(serialDesc, 15, self.nameWithoutPossibleCategory);
        output.encodeSerializableElement(serialDesc, 16, kSerializerArr[16], self.passengerEntryType);
        output.encodeBooleanElement(serialDesc, 17, self.personDataOnlyForChauffeur);
        output.encodeBooleanElement(serialDesc, 18, self.licensePlateRequired);
        output.encodeBooleanElement(serialDesc, 19, self.trailerAllowed);
        output.encodeBooleanElement(serialDesc, 20, self.isTura);
    }

    public final List<String> component1() {
        return this.allowedRouteIds;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsOnlyAvailableWithReturnTicket() {
        return this.isOnlyAvailableWithReturnTicket;
    }

    /* renamed from: component11, reason: from getter */
    public final double getMaxHeight() {
        return this.maxHeight;
    }

    /* renamed from: component12, reason: from getter */
    public final double getMaxLength() {
        return this.maxLength;
    }

    /* renamed from: component13, reason: from getter */
    public final int getMaxPassengers() {
        return this.maxPassengers;
    }

    /* renamed from: component14, reason: from getter */
    public final double getMaxWeight() {
        return this.maxWeight;
    }

    /* renamed from: component15, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component16, reason: from getter */
    public final String getNameWithoutPossibleCategory() {
        return this.nameWithoutPossibleCategory;
    }

    /* renamed from: component17, reason: from getter */
    public final PassengerEntryType getPassengerEntryType() {
        return this.passengerEntryType;
    }

    /* renamed from: component18, reason: from getter */
    public final boolean getPersonDataOnlyForChauffeur() {
        return this.personDataOnlyForChauffeur;
    }

    /* renamed from: component19, reason: from getter */
    public final boolean getLicensePlateRequired() {
        return this.licensePlateRequired;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getAdultRequired() {
        return this.adultRequired;
    }

    /* renamed from: component20, reason: from getter */
    public final boolean getTrailerAllowed() {
        return this.trailerAllowed;
    }

    /* renamed from: component21, reason: from getter */
    public final boolean getIsTura() {
        return this.isTura;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getAdultRequiredForInfants() {
        return this.adultRequiredForInfants;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getAllowLicensePlate() {
        return this.allowLicensePlate;
    }

    /* renamed from: component5, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* renamed from: component6, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsEarlyCheckInAllowed() {
        return this.isEarlyCheckInAllowed;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsFreightPossible() {
        return this.isFreightPossible;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsWalking() {
        return this.isWalking;
    }

    public final Transportation copy(List<String> allowedRouteIds, boolean adultRequired, boolean adultRequiredForInfants, boolean allowLicensePlate, String imageUrl, String id, boolean isEarlyCheckInAllowed, boolean isFreightPossible, boolean isWalking, boolean isOnlyAvailableWithReturnTicket, double maxHeight, double maxLength, int maxPassengers, double maxWeight, String name, String nameWithoutPossibleCategory, PassengerEntryType passengerEntryType, boolean personDataOnlyForChauffeur, boolean licensePlateRequired, boolean trailerAllowed, boolean isTura) {
        Intrinsics.checkNotNullParameter(allowedRouteIds, "allowedRouteIds");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(nameWithoutPossibleCategory, "nameWithoutPossibleCategory");
        Intrinsics.checkNotNullParameter(passengerEntryType, "passengerEntryType");
        return new Transportation(allowedRouteIds, adultRequired, adultRequiredForInfants, allowLicensePlate, imageUrl, id, isEarlyCheckInAllowed, isFreightPossible, isWalking, isOnlyAvailableWithReturnTicket, maxHeight, maxLength, maxPassengers, maxWeight, name, nameWithoutPossibleCategory, passengerEntryType, personDataOnlyForChauffeur, licensePlateRequired, trailerAllowed, isTura);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Transportation)) {
            return false;
        }
        Transportation transportation = (Transportation) other;
        return Intrinsics.areEqual(this.allowedRouteIds, transportation.allowedRouteIds) && this.adultRequired == transportation.adultRequired && this.adultRequiredForInfants == transportation.adultRequiredForInfants && this.allowLicensePlate == transportation.allowLicensePlate && Intrinsics.areEqual(this.imageUrl, transportation.imageUrl) && Intrinsics.areEqual(this.id, transportation.id) && this.isEarlyCheckInAllowed == transportation.isEarlyCheckInAllowed && this.isFreightPossible == transportation.isFreightPossible && this.isWalking == transportation.isWalking && this.isOnlyAvailableWithReturnTicket == transportation.isOnlyAvailableWithReturnTicket && Double.compare(this.maxHeight, transportation.maxHeight) == 0 && Double.compare(this.maxLength, transportation.maxLength) == 0 && this.maxPassengers == transportation.maxPassengers && Double.compare(this.maxWeight, transportation.maxWeight) == 0 && Intrinsics.areEqual(this.name, transportation.name) && Intrinsics.areEqual(this.nameWithoutPossibleCategory, transportation.nameWithoutPossibleCategory) && this.passengerEntryType == transportation.passengerEntryType && this.personDataOnlyForChauffeur == transportation.personDataOnlyForChauffeur && this.licensePlateRequired == transportation.licensePlateRequired && this.trailerAllowed == transportation.trailerAllowed && this.isTura == transportation.isTura;
    }

    public final boolean getAdultRequired() {
        return this.adultRequired;
    }

    public final boolean getAdultRequiredForInfants() {
        return this.adultRequiredForInfants;
    }

    public final boolean getAllowLicensePlate() {
        return this.allowLicensePlate;
    }

    public final List<String> getAllowedRouteIds() {
        return this.allowedRouteIds;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final boolean getLicensePlateRequired() {
        return this.licensePlateRequired;
    }

    public final double getMaxHeight() {
        return this.maxHeight;
    }

    public final double getMaxLength() {
        return this.maxLength;
    }

    public final int getMaxPassengers() {
        return this.maxPassengers;
    }

    public final double getMaxWeight() {
        return this.maxWeight;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNameWithoutPossibleCategory() {
        return this.nameWithoutPossibleCategory;
    }

    public final PassengerEntryType getPassengerEntryType() {
        return this.passengerEntryType;
    }

    public final boolean getPersonDataOnlyForChauffeur() {
        return this.personDataOnlyForChauffeur;
    }

    public final boolean getTrailerAllowed() {
        return this.trailerAllowed;
    }

    public int hashCode() {
        int hashCode = ((((((this.allowedRouteIds.hashCode() * 31) + Boolean.hashCode(this.adultRequired)) * 31) + Boolean.hashCode(this.adultRequiredForInfants)) * 31) + Boolean.hashCode(this.allowLicensePlate)) * 31;
        String str = this.imageUrl;
        return ((((((((((((((((((((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.id.hashCode()) * 31) + Boolean.hashCode(this.isEarlyCheckInAllowed)) * 31) + Boolean.hashCode(this.isFreightPossible)) * 31) + Boolean.hashCode(this.isWalking)) * 31) + Boolean.hashCode(this.isOnlyAvailableWithReturnTicket)) * 31) + Double.hashCode(this.maxHeight)) * 31) + Double.hashCode(this.maxLength)) * 31) + Integer.hashCode(this.maxPassengers)) * 31) + Double.hashCode(this.maxWeight)) * 31) + this.name.hashCode()) * 31) + this.nameWithoutPossibleCategory.hashCode()) * 31) + this.passengerEntryType.hashCode()) * 31) + Boolean.hashCode(this.personDataOnlyForChauffeur)) * 31) + Boolean.hashCode(this.licensePlateRequired)) * 31) + Boolean.hashCode(this.trailerAllowed)) * 31) + Boolean.hashCode(this.isTura);
    }

    public final boolean isEarlyCheckInAllowed() {
        return this.isEarlyCheckInAllowed;
    }

    public final boolean isFreightPossible() {
        return this.isFreightPossible;
    }

    public final boolean isOnlyAvailableWithReturnTicket() {
        return this.isOnlyAvailableWithReturnTicket;
    }

    public final boolean isTura() {
        return this.isTura;
    }

    public final boolean isWalking() {
        return this.isWalking;
    }

    public String toString() {
        return "Transportation(allowedRouteIds=" + this.allowedRouteIds + ", adultRequired=" + this.adultRequired + ", adultRequiredForInfants=" + this.adultRequiredForInfants + ", allowLicensePlate=" + this.allowLicensePlate + ", imageUrl=" + this.imageUrl + ", id=" + this.id + ", isEarlyCheckInAllowed=" + this.isEarlyCheckInAllowed + ", isFreightPossible=" + this.isFreightPossible + ", isWalking=" + this.isWalking + ", isOnlyAvailableWithReturnTicket=" + this.isOnlyAvailableWithReturnTicket + ", maxHeight=" + this.maxHeight + ", maxLength=" + this.maxLength + ", maxPassengers=" + this.maxPassengers + ", maxWeight=" + this.maxWeight + ", name=" + this.name + ", nameWithoutPossibleCategory=" + this.nameWithoutPossibleCategory + ", passengerEntryType=" + this.passengerEntryType + ", personDataOnlyForChauffeur=" + this.personDataOnlyForChauffeur + ", licensePlateRequired=" + this.licensePlateRequired + ", trailerAllowed=" + this.trailerAllowed + ", isTura=" + this.isTura + ")";
    }

    public Transportation(List<String> allowedRouteIds, boolean z5, boolean z6, boolean z7, String str, String id, boolean z8, boolean z9, boolean z10, boolean z11, double d5, double d6, int i5, double d7, String name, String nameWithoutPossibleCategory, PassengerEntryType passengerEntryType, boolean z12, boolean z13, boolean z14, boolean z15) {
        Intrinsics.checkNotNullParameter(allowedRouteIds, "allowedRouteIds");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(nameWithoutPossibleCategory, "nameWithoutPossibleCategory");
        Intrinsics.checkNotNullParameter(passengerEntryType, "passengerEntryType");
        this.allowedRouteIds = allowedRouteIds;
        this.adultRequired = z5;
        this.adultRequiredForInfants = z6;
        this.allowLicensePlate = z7;
        this.imageUrl = str;
        this.id = id;
        this.isEarlyCheckInAllowed = z8;
        this.isFreightPossible = z9;
        this.isWalking = z10;
        this.isOnlyAvailableWithReturnTicket = z11;
        this.maxHeight = d5;
        this.maxLength = d6;
        this.maxPassengers = i5;
        this.maxWeight = d7;
        this.name = name;
        this.nameWithoutPossibleCategory = nameWithoutPossibleCategory;
        this.passengerEntryType = passengerEntryType;
        this.personDataOnlyForChauffeur = z12;
        this.licensePlateRequired = z13;
        this.trailerAllowed = z14;
        this.isTura = z15;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Transportation(TransportResponseDTO transportResponseDTO, boolean z5, String categoryName) {
        this(transportResponseDTO, r3);
        String name;
        Intrinsics.checkNotNullParameter(transportResponseDTO, "transportResponseDTO");
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        if (z5) {
            name = transportResponseDTO.getName() + " - " + categoryName;
        } else {
            name = transportResponseDTO.getName();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Transportation(TransportResponseDTO transportResponseDTO, String name) {
        this(transportResponseDTO.getAllowedRouteIds(), transportResponseDTO.getAdultRequired(), transportResponseDTO.getAdultRequiredForInfants(), transportResponseDTO.getAllowLicensePlate(), transportResponseDTO.getImageUrl(), transportResponseDTO.getId(), transportResponseDTO.getIsEarlyCheckInAllowed(), transportResponseDTO.getIsFreightPossible(), transportResponseDTO.getIsWalking(), transportResponseDTO.getIsOnlyAvailableWithReturnTicket(), transportResponseDTO.getMaxHeight(), transportResponseDTO.getMaxLength(), transportResponseDTO.getMaxPassengers(), transportResponseDTO.getMaxWeight(), name, transportResponseDTO.getName(), PassengerEntryType.INSTANCE.invoke(transportResponseDTO.getPassengerEntryType()), transportResponseDTO.getPersonDataOnlyForChauffeur(), transportResponseDTO.getLicensePlateRequired(), transportResponseDTO.getTrailerAllowed(), StringsKt.contains$default((CharSequence) transportResponseDTO.getName(), (CharSequence) "Tura", false, 2, (Object) null) && transportResponseDTO.getIsWalking());
        Intrinsics.checkNotNullParameter(transportResponseDTO, "transportResponseDTO");
        Intrinsics.checkNotNullParameter(name, "name");
    }
}
