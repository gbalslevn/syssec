package dk.molslinjen.domain.model.saleOnBoard;

import com.adjust.sdk.Constants;
import dk.molslinjen.api.helpers.serializers.LocalDateTimeSerializer;
import dk.molslinjen.api.services.saleOnBoard.response.SaleOnBoardOrderResponseDTO;
import dk.molslinjen.domain.model.booking.SaleOnBoardContactInfo;
import dk.molslinjen.domain.model.booking.SaleOnBoardContactInfo$$serializer;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardDeparture;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.chrono.ChronoLocalDateTime;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 L2\u00020\u0001:\u0003LMNB]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015B\u0085\u0001\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u0014\u0010\u001aJ\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000204J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\bHÆ\u0003J\t\u00109\u001a\u00020\nHÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0011HÆ\u0003J\t\u0010>\u001a\u00020\u0013HÆ\u0003Js\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001J\u0013\u0010@\u001a\u0002042\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020\u0017HÖ\u0001J\t\u0010C\u001a\u00020\u0003HÖ\u0001J%\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0001¢\u0006\u0002\bKR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010 R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b/\u00100¨\u0006O"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", BuildConfig.FLAVOR, "orderNumber", BuildConfig.FLAVOR, "startDateTime", "Lorg/threeten/bp/LocalDateTime;", "endDateTime", "departure", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardDeparture;", "status", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder$OrderStatus;", "lineItems", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "shopImageUrl", "shopLocation", "contactInfo", "Ldk/molslinjen/domain/model/booking/SaleOnBoardContactInfo;", "notificationType", "Ldk/molslinjen/domain/model/saleOnBoard/NotificationType;", "<init>", "(Ljava/lang/String;Lorg/threeten/bp/LocalDateTime;Lorg/threeten/bp/LocalDateTime;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardDeparture;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder$OrderStatus;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/SaleOnBoardContactInfo;Ldk/molslinjen/domain/model/saleOnBoard/NotificationType;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lorg/threeten/bp/LocalDateTime;Lorg/threeten/bp/LocalDateTime;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardDeparture;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder$OrderStatus;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/SaleOnBoardContactInfo;Ldk/molslinjen/domain/model/saleOnBoard/NotificationType;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getOrderNumber", "()Ljava/lang/String;", "getStartDateTime$annotations", "()V", "getStartDateTime", "()Lorg/threeten/bp/LocalDateTime;", "getEndDateTime$annotations", "getEndDateTime", "getDeparture", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardDeparture;", "getStatus", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder$OrderStatus;", "setStatus", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder$OrderStatus;)V", "getLineItems", "()Ljava/util/List;", "getShopImageUrl", "getShopLocation", "getContactInfo", "()Ldk/molslinjen/domain/model/booking/SaleOnBoardContactInfo;", "getNotificationType", "()Ldk/molslinjen/domain/model/saleOnBoard/NotificationType;", "totalPrice", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "isActive", BuildConfig.FLAVOR, "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "OrderStatus", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class SaleOnBoardOrder {
    private static final SaleOnBoardOrder mock1;
    private static final SaleOnBoardOrder mock2;
    private final SaleOnBoardContactInfo contactInfo;
    private final SaleOnBoardDeparture departure;
    private final LocalDateTime endDateTime;
    private final List<SaleOnBoardLineItem> lineItems;
    private final NotificationType notificationType;
    private final String orderNumber;
    private final String shopImageUrl;
    private final String shopLocation;
    private final LocalDateTime startDateTime;
    private OrderStatus status;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, EnumsKt.createSimpleEnumSerializer("dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder.OrderStatus", OrderStatus.values()), new ArrayListSerializer(SaleOnBoardLineItem$$serializer.INSTANCE), null, null, null, EnumsKt.createSimpleEnumSerializer("dk.molslinjen.domain.model.saleOnBoard.NotificationType", NotificationType.values())};

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0086\u0002J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "dto", "Ldk/molslinjen/api/services/saleOnBoard/response/SaleOnBoardOrderResponseDTO;", "existingLocalOrder", "mock1", "getMock1", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "mock2", "getMock2", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SaleOnBoardOrder getMock1() {
            return SaleOnBoardOrder.mock1;
        }

        public final SaleOnBoardOrder getMock2() {
            return SaleOnBoardOrder.mock2;
        }

        public final SaleOnBoardOrder invoke(SaleOnBoardOrderResponseDTO dto, SaleOnBoardOrder existingLocalOrder) {
            Intrinsics.checkNotNullParameter(dto, "dto");
            Intrinsics.checkNotNullParameter(existingLocalOrder, "existingLocalOrder");
            return SaleOnBoardOrder.copy$default(existingLocalOrder, dto.getOrderNumber(), dto.getEstimatedServingTimeStart(), dto.getEstimatedServingTimeEnd(), null, OrderStatus.INSTANCE.invoke(dto.getOrderStatus()), null, null, null, null, null, Constants.ONE_SECOND, null);
        }

        public final KSerializer<SaleOnBoardOrder> serializer() {
            return SaleOnBoardOrder$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder$OrderStatus;", BuildConfig.FLAVOR, "step", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getStep", "()I", "Received", "Printed", "Processing", "Done", "Cancelled", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class OrderStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ OrderStatus[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final int step;
        public static final OrderStatus Received = new OrderStatus("Received", 0, 0);
        public static final OrderStatus Printed = new OrderStatus("Printed", 1, 1);
        public static final OrderStatus Processing = new OrderStatus("Processing", 2, 2);
        public static final OrderStatus Done = new OrderStatus("Done", 3, 3);
        public static final OrderStatus Cancelled = new OrderStatus("Cancelled", 4, 4);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder$OrderStatus$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder$OrderStatus;", "dto", "Ldk/molslinjen/api/services/saleOnBoard/response/SaleOnBoardOrderResponseDTO$CateringOrderStatusResponseDTO;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {

            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes2.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[SaleOnBoardOrderResponseDTO.CateringOrderStatusResponseDTO.values().length];
                    try {
                        iArr[SaleOnBoardOrderResponseDTO.CateringOrderStatusResponseDTO.Received.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[SaleOnBoardOrderResponseDTO.CateringOrderStatusResponseDTO.Printed.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[SaleOnBoardOrderResponseDTO.CateringOrderStatusResponseDTO.Processing.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[SaleOnBoardOrderResponseDTO.CateringOrderStatusResponseDTO.Done.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[SaleOnBoardOrderResponseDTO.CateringOrderStatusResponseDTO.Cancelled.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final OrderStatus invoke(SaleOnBoardOrderResponseDTO.CateringOrderStatusResponseDTO dto) {
                Intrinsics.checkNotNullParameter(dto, "dto");
                int i5 = WhenMappings.$EnumSwitchMapping$0[dto.ordinal()];
                if (i5 == 1) {
                    return OrderStatus.Received;
                }
                if (i5 == 2) {
                    return OrderStatus.Printed;
                }
                if (i5 == 3) {
                    return OrderStatus.Processing;
                }
                if (i5 == 4) {
                    return OrderStatus.Done;
                }
                if (i5 == 5) {
                    return OrderStatus.Cancelled;
                }
                throw new NoWhenBranchMatchedException();
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ OrderStatus[] $values() {
            return new OrderStatus[]{Received, Printed, Processing, Done, Cancelled};
        }

        static {
            OrderStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            INSTANCE = new Companion(null);
        }

        private OrderStatus(String str, int i5, int i6) {
            this.step = i6;
        }

        public static EnumEntries<OrderStatus> getEntries() {
            return $ENTRIES;
        }

        public static OrderStatus valueOf(String str) {
            return (OrderStatus) Enum.valueOf(OrderStatus.class, str);
        }

        public static OrderStatus[] values() {
            return (OrderStatus[]) $VALUES.clone();
        }

        public final int getStep() {
            return this.step;
        }
    }

    static {
        LocalDateTime of = LocalDateTime.of(2021, 1, 1, 10, 0);
        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
        LocalDateTime of2 = LocalDateTime.of(2021, 1, 1, 10, 10);
        Intrinsics.checkNotNullExpressionValue(of2, "of(...)");
        SaleOnBoardDeparture.Companion companion = SaleOnBoardDeparture.INSTANCE;
        SaleOnBoardDeparture mock = companion.getMock();
        OrderStatus orderStatus = OrderStatus.Received;
        SaleOnBoardLineItem.Companion companion2 = SaleOnBoardLineItem.INSTANCE;
        List listOf = CollectionsKt.listOf(companion2.getMock());
        SaleOnBoardContactInfo.Companion companion3 = SaleOnBoardContactInfo.INSTANCE;
        mock1 = new SaleOnBoardOrder("23412341", of, of2, mock, orderStatus, listOf, "https://molsmediaprod.blob.core.windows.net/catering/Kvadratisk-til-placeholderbillede-i-produktliste-m.m._640x640px.jpg", "Midskibs", companion3.getMock(), NotificationType.Push);
        LocalDateTime of3 = LocalDateTime.of(2021, 1, 1, 20, 15);
        Intrinsics.checkNotNullExpressionValue(of3, "of(...)");
        LocalDateTime of4 = LocalDateTime.of(2021, 1, 1, 20, 25);
        Intrinsics.checkNotNullExpressionValue(of4, "of(...)");
        mock2 = new SaleOnBoardOrder("23412341", of3, of4, companion.getMock(), OrderStatus.Processing, CollectionsKt.listOf(companion2.getMock()), "https://molsmediaprod.blob.core.windows.net/catering/Kvadratisk-til-placeholderbillede-i-produktliste-m.m._640x640px.jpg", "Midskibs", companion3.getMock(), NotificationType.Sms);
    }

    public /* synthetic */ SaleOnBoardOrder(int i5, String str, LocalDateTime localDateTime, LocalDateTime localDateTime2, SaleOnBoardDeparture saleOnBoardDeparture, OrderStatus orderStatus, List list, String str2, String str3, SaleOnBoardContactInfo saleOnBoardContactInfo, NotificationType notificationType, SerializationConstructorMarker serializationConstructorMarker) {
        if (1023 != (i5 & 1023)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 1023, SaleOnBoardOrder$$serializer.INSTANCE.getDescriptor());
        }
        this.orderNumber = str;
        this.startDateTime = localDateTime;
        this.endDateTime = localDateTime2;
        this.departure = saleOnBoardDeparture;
        this.status = orderStatus;
        this.lineItems = list;
        this.shopImageUrl = str2;
        this.shopLocation = str3;
        this.contactInfo = saleOnBoardContactInfo;
        this.notificationType = notificationType;
    }

    public static /* synthetic */ SaleOnBoardOrder copy$default(SaleOnBoardOrder saleOnBoardOrder, String str, LocalDateTime localDateTime, LocalDateTime localDateTime2, SaleOnBoardDeparture saleOnBoardDeparture, OrderStatus orderStatus, List list, String str2, String str3, SaleOnBoardContactInfo saleOnBoardContactInfo, NotificationType notificationType, int i5, Object obj) {
        return saleOnBoardOrder.copy((i5 & 1) != 0 ? saleOnBoardOrder.orderNumber : str, (i5 & 2) != 0 ? saleOnBoardOrder.startDateTime : localDateTime, (i5 & 4) != 0 ? saleOnBoardOrder.endDateTime : localDateTime2, (i5 & 8) != 0 ? saleOnBoardOrder.departure : saleOnBoardDeparture, (i5 & 16) != 0 ? saleOnBoardOrder.status : orderStatus, (i5 & 32) != 0 ? saleOnBoardOrder.lineItems : list, (i5 & 64) != 0 ? saleOnBoardOrder.shopImageUrl : str2, (i5 & 128) != 0 ? saleOnBoardOrder.shopLocation : str3, (i5 & 256) != 0 ? saleOnBoardOrder.contactInfo : saleOnBoardContactInfo, (i5 & 512) != 0 ? saleOnBoardOrder.notificationType : notificationType);
    }

    @Serializable(with = LocalDateTimeSerializer.class)
    public static /* synthetic */ void getEndDateTime$annotations() {
    }

    @Serializable(with = LocalDateTimeSerializer.class)
    public static /* synthetic */ void getStartDateTime$annotations() {
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(SaleOnBoardOrder self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.orderNumber);
        LocalDateTimeSerializer localDateTimeSerializer = LocalDateTimeSerializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 1, localDateTimeSerializer, self.startDateTime);
        output.encodeSerializableElement(serialDesc, 2, localDateTimeSerializer, self.endDateTime);
        output.encodeSerializableElement(serialDesc, 3, SaleOnBoardDeparture$$serializer.INSTANCE, self.departure);
        output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.status);
        output.encodeSerializableElement(serialDesc, 5, kSerializerArr[5], self.lineItems);
        output.encodeStringElement(serialDesc, 6, self.shopImageUrl);
        output.encodeStringElement(serialDesc, 7, self.shopLocation);
        output.encodeSerializableElement(serialDesc, 8, SaleOnBoardContactInfo$$serializer.INSTANCE, self.contactInfo);
        output.encodeSerializableElement(serialDesc, 9, kSerializerArr[9], self.notificationType);
    }

    /* renamed from: component1, reason: from getter */
    public final String getOrderNumber() {
        return this.orderNumber;
    }

    /* renamed from: component10, reason: from getter */
    public final NotificationType getNotificationType() {
        return this.notificationType;
    }

    /* renamed from: component2, reason: from getter */
    public final LocalDateTime getStartDateTime() {
        return this.startDateTime;
    }

    /* renamed from: component3, reason: from getter */
    public final LocalDateTime getEndDateTime() {
        return this.endDateTime;
    }

    /* renamed from: component4, reason: from getter */
    public final SaleOnBoardDeparture getDeparture() {
        return this.departure;
    }

    /* renamed from: component5, reason: from getter */
    public final OrderStatus getStatus() {
        return this.status;
    }

    public final List<SaleOnBoardLineItem> component6() {
        return this.lineItems;
    }

    /* renamed from: component7, reason: from getter */
    public final String getShopImageUrl() {
        return this.shopImageUrl;
    }

    /* renamed from: component8, reason: from getter */
    public final String getShopLocation() {
        return this.shopLocation;
    }

    /* renamed from: component9, reason: from getter */
    public final SaleOnBoardContactInfo getContactInfo() {
        return this.contactInfo;
    }

    public final SaleOnBoardOrder copy(String orderNumber, LocalDateTime startDateTime, LocalDateTime endDateTime, SaleOnBoardDeparture departure, OrderStatus status, List<SaleOnBoardLineItem> lineItems, String shopImageUrl, String shopLocation, SaleOnBoardContactInfo contactInfo, NotificationType notificationType) {
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        Intrinsics.checkNotNullParameter(startDateTime, "startDateTime");
        Intrinsics.checkNotNullParameter(endDateTime, "endDateTime");
        Intrinsics.checkNotNullParameter(departure, "departure");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(lineItems, "lineItems");
        Intrinsics.checkNotNullParameter(shopImageUrl, "shopImageUrl");
        Intrinsics.checkNotNullParameter(shopLocation, "shopLocation");
        Intrinsics.checkNotNullParameter(contactInfo, "contactInfo");
        Intrinsics.checkNotNullParameter(notificationType, "notificationType");
        return new SaleOnBoardOrder(orderNumber, startDateTime, endDateTime, departure, status, lineItems, shopImageUrl, shopLocation, contactInfo, notificationType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleOnBoardOrder)) {
            return false;
        }
        SaleOnBoardOrder saleOnBoardOrder = (SaleOnBoardOrder) other;
        return Intrinsics.areEqual(this.orderNumber, saleOnBoardOrder.orderNumber) && Intrinsics.areEqual(this.startDateTime, saleOnBoardOrder.startDateTime) && Intrinsics.areEqual(this.endDateTime, saleOnBoardOrder.endDateTime) && Intrinsics.areEqual(this.departure, saleOnBoardOrder.departure) && this.status == saleOnBoardOrder.status && Intrinsics.areEqual(this.lineItems, saleOnBoardOrder.lineItems) && Intrinsics.areEqual(this.shopImageUrl, saleOnBoardOrder.shopImageUrl) && Intrinsics.areEqual(this.shopLocation, saleOnBoardOrder.shopLocation) && Intrinsics.areEqual(this.contactInfo, saleOnBoardOrder.contactInfo) && this.notificationType == saleOnBoardOrder.notificationType;
    }

    public final SaleOnBoardContactInfo getContactInfo() {
        return this.contactInfo;
    }

    public final SaleOnBoardDeparture getDeparture() {
        return this.departure;
    }

    public final LocalDateTime getEndDateTime() {
        return this.endDateTime;
    }

    public final List<SaleOnBoardLineItem> getLineItems() {
        return this.lineItems;
    }

    public final NotificationType getNotificationType() {
        return this.notificationType;
    }

    public final String getOrderNumber() {
        return this.orderNumber;
    }

    public final String getShopImageUrl() {
        return this.shopImageUrl;
    }

    public final String getShopLocation() {
        return this.shopLocation;
    }

    public final LocalDateTime getStartDateTime() {
        return this.startDateTime;
    }

    public final OrderStatus getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (((((((((((((((((this.orderNumber.hashCode() * 31) + this.startDateTime.hashCode()) * 31) + this.endDateTime.hashCode()) * 31) + this.departure.hashCode()) * 31) + this.status.hashCode()) * 31) + this.lineItems.hashCode()) * 31) + this.shopImageUrl.hashCode()) * 31) + this.shopLocation.hashCode()) * 31) + this.contactInfo.hashCode()) * 31) + this.notificationType.hashCode();
    }

    public final boolean isActive() {
        return this.startDateTime.compareTo((ChronoLocalDateTime<?>) LocalDate.now().atStartOfDay()) > 0 && this.status != OrderStatus.Cancelled;
    }

    public final void setStatus(OrderStatus orderStatus) {
        Intrinsics.checkNotNullParameter(orderStatus, "<set-?>");
        this.status = orderStatus;
    }

    public String toString() {
        return "SaleOnBoardOrder(orderNumber=" + this.orderNumber + ", startDateTime=" + this.startDateTime + ", endDateTime=" + this.endDateTime + ", departure=" + this.departure + ", status=" + this.status + ", lineItems=" + this.lineItems + ", shopImageUrl=" + this.shopImageUrl + ", shopLocation=" + this.shopLocation + ", contactInfo=" + this.contactInfo + ", notificationType=" + this.notificationType + ")";
    }

    public final PriceWithCurrency totalPrice() {
        PriceWithCurrency priceWithCurrency;
        Iterator<T> it = this.lineItems.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            i5 += ((SaleOnBoardLineItem) it.next()).totalPrice().getValue();
        }
        SaleOnBoardLineItem saleOnBoardLineItem = (SaleOnBoardLineItem) CollectionsKt.firstOrNull((List) this.lineItems);
        if (saleOnBoardLineItem == null || (priceWithCurrency = saleOnBoardLineItem.totalPrice()) == null) {
            priceWithCurrency = new PriceWithCurrency(0, CurrencyType.DKK);
        }
        return PriceWithCurrency.copy$default(priceWithCurrency, i5, null, 2, null);
    }

    public SaleOnBoardOrder(String orderNumber, LocalDateTime startDateTime, LocalDateTime endDateTime, SaleOnBoardDeparture departure, OrderStatus status, List<SaleOnBoardLineItem> lineItems, String shopImageUrl, String shopLocation, SaleOnBoardContactInfo contactInfo, NotificationType notificationType) {
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        Intrinsics.checkNotNullParameter(startDateTime, "startDateTime");
        Intrinsics.checkNotNullParameter(endDateTime, "endDateTime");
        Intrinsics.checkNotNullParameter(departure, "departure");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(lineItems, "lineItems");
        Intrinsics.checkNotNullParameter(shopImageUrl, "shopImageUrl");
        Intrinsics.checkNotNullParameter(shopLocation, "shopLocation");
        Intrinsics.checkNotNullParameter(contactInfo, "contactInfo");
        Intrinsics.checkNotNullParameter(notificationType, "notificationType");
        this.orderNumber = orderNumber;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.departure = departure;
        this.status = status;
        this.lineItems = lineItems;
        this.shopImageUrl = shopImageUrl;
        this.shopLocation = shopLocation;
        this.contactInfo = contactInfo;
        this.notificationType = notificationType;
    }
}
