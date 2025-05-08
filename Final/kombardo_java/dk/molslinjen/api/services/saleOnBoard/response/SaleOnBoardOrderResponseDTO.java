package dk.molslinjen.api.services.saleOnBoard.response;

import dk.molslinjen.api.helpers.serializers.LocalDateTimeRetailItsSerializer;
import dk.molslinjen.api.services.saleOnBoard.response.SaleOnBoardOrderResponseDTO;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
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
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 92\u00020\u0001:\u0003789B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rBa\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003JO\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u000fHÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0014\u001a\u0004\b!\u0010\u001f¨\u0006:"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/SaleOnBoardOrderResponseDTO;", BuildConfig.FLAVOR, "orderNumber", BuildConfig.FLAVOR, "name", "mobileNumber", "email", "orderStatus", "Ldk/molslinjen/api/services/saleOnBoard/response/SaleOnBoardOrderResponseDTO$CateringOrderStatusResponseDTO;", "estimatedServingTimeStart", "Lorg/threeten/bp/LocalDateTime;", "estimatedServingTimeEnd", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/saleOnBoard/response/SaleOnBoardOrderResponseDTO$CateringOrderStatusResponseDTO;Lorg/threeten/bp/LocalDateTime;Lorg/threeten/bp/LocalDateTime;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/saleOnBoard/response/SaleOnBoardOrderResponseDTO$CateringOrderStatusResponseDTO;Lorg/threeten/bp/LocalDateTime;Lorg/threeten/bp/LocalDateTime;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getOrderNumber$annotations", "()V", "getOrderNumber", "()Ljava/lang/String;", "getName", "getMobileNumber$annotations", "getMobileNumber", "getEmail", "getOrderStatus", "()Ldk/molslinjen/api/services/saleOnBoard/response/SaleOnBoardOrderResponseDTO$CateringOrderStatusResponseDTO;", "getEstimatedServingTimeStart$annotations", "getEstimatedServingTimeStart", "()Lorg/threeten/bp/LocalDateTime;", "getEstimatedServingTimeEnd$annotations", "getEstimatedServingTimeEnd", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "CateringOrderStatusResponseDTO", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class SaleOnBoardOrderResponseDTO {
    private final String email;
    private final LocalDateTime estimatedServingTimeEnd;
    private final LocalDateTime estimatedServingTimeStart;
    private final String mobileNumber;
    private final String name;
    private final String orderNumber;
    private final CateringOrderStatusResponseDTO orderStatus;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, CateringOrderStatusResponseDTO.INSTANCE.serializer(), null, null};

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/SaleOnBoardOrderResponseDTO$CateringOrderStatusResponseDTO;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Received", "Printed", "Processing", "Done", "Cancelled", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final class CateringOrderStatusResponseDTO {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ CateringOrderStatusResponseDTO[] $VALUES;
        private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final CateringOrderStatusResponseDTO Received = new CateringOrderStatusResponseDTO("Received", 0);
        public static final CateringOrderStatusResponseDTO Printed = new CateringOrderStatusResponseDTO("Printed", 1);
        public static final CateringOrderStatusResponseDTO Processing = new CateringOrderStatusResponseDTO("Processing", 2);
        public static final CateringOrderStatusResponseDTO Done = new CateringOrderStatusResponseDTO("Done", 3);
        public static final CateringOrderStatusResponseDTO Cancelled = new CateringOrderStatusResponseDTO("Cancelled", 4);

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/SaleOnBoardOrderResponseDTO$CateringOrderStatusResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/response/SaleOnBoardOrderResponseDTO$CateringOrderStatusResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            private final /* synthetic */ KSerializer get$cachedSerializer() {
                return (KSerializer) CateringOrderStatusResponseDTO.$cachedSerializer$delegate.getValue();
            }

            public final KSerializer<CateringOrderStatusResponseDTO> serializer() {
                return get$cachedSerializer();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ CateringOrderStatusResponseDTO[] $values() {
            return new CateringOrderStatusResponseDTO[]{Received, Printed, Processing, Done, Cancelled};
        }

        static {
            CateringOrderStatusResponseDTO[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            INSTANCE = new Companion(null);
            $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: s1.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    KSerializer _init_$_anonymous_;
                    _init_$_anonymous_ = SaleOnBoardOrderResponseDTO.CateringOrderStatusResponseDTO._init_$_anonymous_();
                    return _init_$_anonymous_;
                }
            });
        }

        private CateringOrderStatusResponseDTO(String str, int i5) {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return EnumsKt.createAnnotatedEnumSerializer("dk.molslinjen.api.services.saleOnBoard.response.SaleOnBoardOrderResponseDTO.CateringOrderStatusResponseDTO", values(), new String[]{"RECEIVED", "PRINTED", "PROCESSING", "DONE", "CANCELLED"}, new Annotation[][]{null, null, null, null, null}, null);
        }

        public static EnumEntries<CateringOrderStatusResponseDTO> getEntries() {
            return $ENTRIES;
        }

        public static CateringOrderStatusResponseDTO valueOf(String str) {
            return (CateringOrderStatusResponseDTO) Enum.valueOf(CateringOrderStatusResponseDTO.class, str);
        }

        public static CateringOrderStatusResponseDTO[] values() {
            return (CateringOrderStatusResponseDTO[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/saleOnBoard/response/SaleOnBoardOrderResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/saleOnBoard/response/SaleOnBoardOrderResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<SaleOnBoardOrderResponseDTO> serializer() {
            return SaleOnBoardOrderResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ SaleOnBoardOrderResponseDTO(int i5, String str, String str2, String str3, String str4, CateringOrderStatusResponseDTO cateringOrderStatusResponseDTO, LocalDateTime localDateTime, LocalDateTime localDateTime2, SerializationConstructorMarker serializationConstructorMarker) {
        if (127 != (i5 & 127)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 127, SaleOnBoardOrderResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.orderNumber = str;
        this.name = str2;
        this.mobileNumber = str3;
        this.email = str4;
        this.orderStatus = cateringOrderStatusResponseDTO;
        this.estimatedServingTimeStart = localDateTime;
        this.estimatedServingTimeEnd = localDateTime2;
    }

    public static /* synthetic */ SaleOnBoardOrderResponseDTO copy$default(SaleOnBoardOrderResponseDTO saleOnBoardOrderResponseDTO, String str, String str2, String str3, String str4, CateringOrderStatusResponseDTO cateringOrderStatusResponseDTO, LocalDateTime localDateTime, LocalDateTime localDateTime2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = saleOnBoardOrderResponseDTO.orderNumber;
        }
        if ((i5 & 2) != 0) {
            str2 = saleOnBoardOrderResponseDTO.name;
        }
        String str5 = str2;
        if ((i5 & 4) != 0) {
            str3 = saleOnBoardOrderResponseDTO.mobileNumber;
        }
        String str6 = str3;
        if ((i5 & 8) != 0) {
            str4 = saleOnBoardOrderResponseDTO.email;
        }
        String str7 = str4;
        if ((i5 & 16) != 0) {
            cateringOrderStatusResponseDTO = saleOnBoardOrderResponseDTO.orderStatus;
        }
        CateringOrderStatusResponseDTO cateringOrderStatusResponseDTO2 = cateringOrderStatusResponseDTO;
        if ((i5 & 32) != 0) {
            localDateTime = saleOnBoardOrderResponseDTO.estimatedServingTimeStart;
        }
        LocalDateTime localDateTime3 = localDateTime;
        if ((i5 & 64) != 0) {
            localDateTime2 = saleOnBoardOrderResponseDTO.estimatedServingTimeEnd;
        }
        return saleOnBoardOrderResponseDTO.copy(str, str5, str6, str7, cateringOrderStatusResponseDTO2, localDateTime3, localDateTime2);
    }

    @Serializable(with = LocalDateTimeRetailItsSerializer.class)
    public static /* synthetic */ void getEstimatedServingTimeEnd$annotations() {
    }

    @Serializable(with = LocalDateTimeRetailItsSerializer.class)
    public static /* synthetic */ void getEstimatedServingTimeStart$annotations() {
    }

    public static /* synthetic */ void getMobileNumber$annotations() {
    }

    public static /* synthetic */ void getOrderNumber$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(SaleOnBoardOrderResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.orderNumber);
        output.encodeStringElement(serialDesc, 1, self.name);
        output.encodeStringElement(serialDesc, 2, self.mobileNumber);
        output.encodeStringElement(serialDesc, 3, self.email);
        output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.orderStatus);
        LocalDateTimeRetailItsSerializer localDateTimeRetailItsSerializer = LocalDateTimeRetailItsSerializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 5, localDateTimeRetailItsSerializer, self.estimatedServingTimeStart);
        output.encodeSerializableElement(serialDesc, 6, localDateTimeRetailItsSerializer, self.estimatedServingTimeEnd);
    }

    /* renamed from: component1, reason: from getter */
    public final String getOrderNumber() {
        return this.orderNumber;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMobileNumber() {
        return this.mobileNumber;
    }

    /* renamed from: component4, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component5, reason: from getter */
    public final CateringOrderStatusResponseDTO getOrderStatus() {
        return this.orderStatus;
    }

    /* renamed from: component6, reason: from getter */
    public final LocalDateTime getEstimatedServingTimeStart() {
        return this.estimatedServingTimeStart;
    }

    /* renamed from: component7, reason: from getter */
    public final LocalDateTime getEstimatedServingTimeEnd() {
        return this.estimatedServingTimeEnd;
    }

    public final SaleOnBoardOrderResponseDTO copy(String orderNumber, String name, String mobileNumber, String email, CateringOrderStatusResponseDTO orderStatus, LocalDateTime estimatedServingTimeStart, LocalDateTime estimatedServingTimeEnd) {
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(mobileNumber, "mobileNumber");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(orderStatus, "orderStatus");
        Intrinsics.checkNotNullParameter(estimatedServingTimeStart, "estimatedServingTimeStart");
        Intrinsics.checkNotNullParameter(estimatedServingTimeEnd, "estimatedServingTimeEnd");
        return new SaleOnBoardOrderResponseDTO(orderNumber, name, mobileNumber, email, orderStatus, estimatedServingTimeStart, estimatedServingTimeEnd);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleOnBoardOrderResponseDTO)) {
            return false;
        }
        SaleOnBoardOrderResponseDTO saleOnBoardOrderResponseDTO = (SaleOnBoardOrderResponseDTO) other;
        return Intrinsics.areEqual(this.orderNumber, saleOnBoardOrderResponseDTO.orderNumber) && Intrinsics.areEqual(this.name, saleOnBoardOrderResponseDTO.name) && Intrinsics.areEqual(this.mobileNumber, saleOnBoardOrderResponseDTO.mobileNumber) && Intrinsics.areEqual(this.email, saleOnBoardOrderResponseDTO.email) && this.orderStatus == saleOnBoardOrderResponseDTO.orderStatus && Intrinsics.areEqual(this.estimatedServingTimeStart, saleOnBoardOrderResponseDTO.estimatedServingTimeStart) && Intrinsics.areEqual(this.estimatedServingTimeEnd, saleOnBoardOrderResponseDTO.estimatedServingTimeEnd);
    }

    public final String getEmail() {
        return this.email;
    }

    public final LocalDateTime getEstimatedServingTimeEnd() {
        return this.estimatedServingTimeEnd;
    }

    public final LocalDateTime getEstimatedServingTimeStart() {
        return this.estimatedServingTimeStart;
    }

    public final String getMobileNumber() {
        return this.mobileNumber;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOrderNumber() {
        return this.orderNumber;
    }

    public final CateringOrderStatusResponseDTO getOrderStatus() {
        return this.orderStatus;
    }

    public int hashCode() {
        return (((((((((((this.orderNumber.hashCode() * 31) + this.name.hashCode()) * 31) + this.mobileNumber.hashCode()) * 31) + this.email.hashCode()) * 31) + this.orderStatus.hashCode()) * 31) + this.estimatedServingTimeStart.hashCode()) * 31) + this.estimatedServingTimeEnd.hashCode();
    }

    public String toString() {
        return "SaleOnBoardOrderResponseDTO(orderNumber=" + this.orderNumber + ", name=" + this.name + ", mobileNumber=" + this.mobileNumber + ", email=" + this.email + ", orderStatus=" + this.orderStatus + ", estimatedServingTimeStart=" + this.estimatedServingTimeStart + ", estimatedServingTimeEnd=" + this.estimatedServingTimeEnd + ")";
    }

    public SaleOnBoardOrderResponseDTO(String orderNumber, String name, String mobileNumber, String email, CateringOrderStatusResponseDTO orderStatus, LocalDateTime estimatedServingTimeStart, LocalDateTime estimatedServingTimeEnd) {
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(mobileNumber, "mobileNumber");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(orderStatus, "orderStatus");
        Intrinsics.checkNotNullParameter(estimatedServingTimeStart, "estimatedServingTimeStart");
        Intrinsics.checkNotNullParameter(estimatedServingTimeEnd, "estimatedServingTimeEnd");
        this.orderNumber = orderNumber;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.orderStatus = orderStatus;
        this.estimatedServingTimeStart = estimatedServingTimeStart;
        this.estimatedServingTimeEnd = estimatedServingTimeEnd;
    }
}
