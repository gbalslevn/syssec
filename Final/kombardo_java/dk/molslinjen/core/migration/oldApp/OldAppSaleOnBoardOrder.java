package dk.molslinjen.core.migration.oldApp;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.domain.model.booking.RouteType;
import dk.molslinjen.domain.model.booking.SaleOnBoardContactInfo;
import dk.molslinjen.domain.model.saleOnBoard.NotificationType;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardDeparture;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProduct;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProductAddOnOption;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardVariant;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
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
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0087\b\u0018\u0000 C2\u00020\u0001:\u0005DEFGCB\u008f\u0001\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010!\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0001¢\u0006\u0004\b\u001f\u0010 J\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010-\u001a\u0004\b.\u0010&R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010/\u001a\u0004\b0\u00101R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010/\u001a\u0004\b2\u00101R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u00103\u001a\u0004\b4\u00105R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010;\u001a\u0004\b<\u0010=R\u0017\u0010\u0010\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010-\u001a\u0004\b>\u0010&R\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010-\u001a\u0004\b?\u0010&R\u0017\u0010\u0012\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010-\u001a\u0004\b@\u0010&R\u0017\u0010\u0013\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010-\u001a\u0004\bA\u0010&R\u0017\u0010\u0014\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010-\u001a\u0004\bB\u0010&¨\u0006H"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "seen0", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "Ldk/molslinjen/core/migration/oldApp/OldAppLocalDateTime;", "startDateTime", "endDateTime", "Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardDeparture;", "departure", "Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppOrderStatus;", "status", BuildConfig.FLAVOR, "Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem;", "products", "name", "email", "phoneNumber", "shopImageUrl", "shopLocation", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Ldk/molslinjen/core/migration/oldApp/OldAppLocalDateTime;Ldk/molslinjen/core/migration/oldApp/OldAppLocalDateTime;Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardDeparture;Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppOrderStatus;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", BuildConfig.FLAVOR, "write$Self$app_kombardoProd", "(Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "toSaleOnBoardOrder", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "Ldk/molslinjen/core/migration/oldApp/OldAppLocalDateTime;", "getStartDateTime", "()Ldk/molslinjen/core/migration/oldApp/OldAppLocalDateTime;", "getEndDateTime", "Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardDeparture;", "getDeparture", "()Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardDeparture;", "Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppOrderStatus;", "getStatus", "()Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppOrderStatus;", "setStatus", "(Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppOrderStatus;)V", "Ljava/util/List;", "getProducts", "()Ljava/util/List;", "getName", "getEmail", "getPhoneNumber", "getShopImageUrl", "getShopLocation", "Companion", "OldAppOrderStatus", "OldAppSaleOnBoardDeparture", "OldAppSaleOnBoardBasketItem", "$serializer", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class OldAppSaleOnBoardOrder {
    private final OldAppSaleOnBoardDeparture departure;
    private final String email;
    private final OldAppLocalDateTime endDateTime;
    private final String id;
    private final String name;
    private final String phoneNumber;
    private final List<OldAppSaleOnBoardBasketItem> products;
    private final String shopImageUrl;
    private final String shopLocation;
    private final OldAppLocalDateTime startDateTime;
    private OldAppOrderStatus status;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, EnumsKt.createSimpleEnumSerializer("dk.molslinjen.core.migration.oldApp.OldAppSaleOnBoardOrder.OldAppOrderStatus", OldAppOrderStatus.values()), new ArrayListSerializer(OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$$serializer.INSTANCE), null, null, null, null, null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<OldAppSaleOnBoardOrder> serializer() {
            return OldAppSaleOnBoardOrder$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppOrderStatus;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "rawValue", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder$OrderStatus;", "toSaleOnBoardOrderStatus", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder$OrderStatus;", "Ljava/lang/String;", "getRawValue", "()Ljava/lang/String;", "Received", "Printed", "Processing", "Done", "Cancelled", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class OldAppOrderStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ OldAppOrderStatus[] $VALUES;
        private final String rawValue;
        public static final OldAppOrderStatus Received = new OldAppOrderStatus("Received", 0, "RECEIVED");
        public static final OldAppOrderStatus Printed = new OldAppOrderStatus("Printed", 1, "PRINTED");
        public static final OldAppOrderStatus Processing = new OldAppOrderStatus("Processing", 2, "PROCESSING");
        public static final OldAppOrderStatus Done = new OldAppOrderStatus("Done", 3, "DONE");
        public static final OldAppOrderStatus Cancelled = new OldAppOrderStatus("Cancelled", 4, "CANCELLED");

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[OldAppOrderStatus.values().length];
                try {
                    iArr[OldAppOrderStatus.Received.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[OldAppOrderStatus.Printed.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[OldAppOrderStatus.Processing.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[OldAppOrderStatus.Done.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[OldAppOrderStatus.Cancelled.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private static final /* synthetic */ OldAppOrderStatus[] $values() {
            return new OldAppOrderStatus[]{Received, Printed, Processing, Done, Cancelled};
        }

        static {
            OldAppOrderStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private OldAppOrderStatus(String str, int i5, String str2) {
            this.rawValue = str2;
        }

        public static OldAppOrderStatus valueOf(String str) {
            return (OldAppOrderStatus) Enum.valueOf(OldAppOrderStatus.class, str);
        }

        public static OldAppOrderStatus[] values() {
            return (OldAppOrderStatus[]) $VALUES.clone();
        }

        public final SaleOnBoardOrder.OrderStatus toSaleOnBoardOrderStatus() {
            int i5 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i5 == 1) {
                return SaleOnBoardOrder.OrderStatus.Received;
            }
            if (i5 == 2) {
                return SaleOnBoardOrder.OrderStatus.Printed;
            }
            if (i5 == 3) {
                return SaleOnBoardOrder.OrderStatus.Processing;
            }
            if (i5 == 4) {
                return SaleOnBoardOrder.OrderStatus.Done;
            }
            if (i5 == 5) {
                return SaleOnBoardOrder.OrderStatus.Cancelled;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0087\b\u0018\u0000 C2\u00020\u0001:\u0004DEFCB\u0081\u0001\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010!\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010)\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b)\u0010*R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010+\u001a\u0004\b,\u0010$R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010+\u001a\u0004\b-\u0010$R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010+\u001a\u0004\b.\u0010$R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010+\u001a\u0004\b/\u0010$R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u00100\u001a\u0004\b1\u00102R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u00103\u001a\u0004\b4\u0010&\"\u0004\b5\u00106R\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010+\u001a\u0004\b7\u0010$R\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010+\u001a\u0004\b8\u0010$R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006G"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "seen0", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "itemNo", "name", "imageUrl", BuildConfig.FLAVOR, "price", "quantity", "categoryName", "categoryId", "Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardVariant;", "variant", BuildConfig.FLAVOR, "Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardAddOn;", "addOns", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DILjava/lang/String;Ljava/lang/String;Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardVariant;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", BuildConfig.FLAVOR, "write$Self$app_kombardoProd", "(Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "toSaleOnBoardLineItem", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getItemNo", "getName", "getImageUrl", "D", "getPrice", "()D", "I", "getQuantity", "setQuantity", "(I)V", "getCategoryName", "getCategoryId", "Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardVariant;", "getVariant", "()Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardVariant;", "setVariant", "(Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardVariant;)V", "Ljava/util/List;", "getAddOns", "()Ljava/util/List;", "setAddOns", "(Ljava/util/List;)V", "Companion", "OldAppSaleOnBoardVariant", "OldAppSaleOnBoardAddOn", "$serializer", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class OldAppSaleOnBoardBasketItem {
        private List<OldAppSaleOnBoardAddOn> addOns;
        private final String categoryId;
        private final String categoryName;
        private final String id;
        private final String imageUrl;
        private final String itemNo;
        private final String name;
        private final double price;
        private int quantity;
        private OldAppSaleOnBoardVariant variant;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;
        private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, null, null, null, null, new ArrayListSerializer(OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardAddOn$$serializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<OldAppSaleOnBoardBasketItem> serializer() {
                return OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0002#\"BA\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardAddOn;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "seen0", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "itemNo", "name", BuildConfig.FLAVOR, "price", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;DLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", BuildConfig.FLAVOR, "write$Self$app_kombardoProd", "(Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardAddOn;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProductAddOnOption;", "toSaleOnBoardAddOn", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProductAddOnOption;", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "getItemNo", "getName", "D", "getPrice", "()D", "Companion", "$serializer", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @Serializable
        /* loaded from: classes2.dex */
        public static final class OldAppSaleOnBoardAddOn {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String id;
            private final String itemNo;
            private final String name;
            private final double price;

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardAddOn$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardAddOn;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes2.dex */
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<OldAppSaleOnBoardAddOn> serializer() {
                    return OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardAddOn$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public /* synthetic */ OldAppSaleOnBoardAddOn(int i5, String str, String str2, String str3, double d5, SerializationConstructorMarker serializationConstructorMarker) {
                if (15 != (i5 & 15)) {
                    PluginExceptionsKt.throwMissingFieldException(i5, 15, OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardAddOn$$serializer.INSTANCE.getDescriptor());
                }
                this.id = str;
                this.itemNo = str2;
                this.name = str3;
                this.price = d5;
            }

            public static final /* synthetic */ void write$Self$app_kombardoProd(OldAppSaleOnBoardAddOn self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeStringElement(serialDesc, 0, self.id);
                output.encodeStringElement(serialDesc, 1, self.itemNo);
                output.encodeStringElement(serialDesc, 2, self.name);
                output.encodeDoubleElement(serialDesc, 3, self.price);
            }

            public final SaleOnBoardProductAddOnOption toSaleOnBoardAddOn() {
                return new SaleOnBoardProductAddOnOption(this.id, this.name, null, this.itemNo, new PriceWithCurrency((int) this.price, CurrencyType.DKK));
            }
        }

        @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002#\"B/\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b!\u0010\u0018¨\u0006$"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardVariant;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "seen0", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "name", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", BuildConfig.FLAVOR, "write$Self$app_kombardoProd", "(Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardVariant;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariant;", "toSaleOnBoardVariant", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardVariant;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getName", "Companion", "$serializer", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @Serializable
        /* loaded from: classes2.dex */
        public static final /* data */ class OldAppSaleOnBoardVariant {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final String id;
            private final String name;

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardVariant$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardVariant;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
            /* loaded from: classes2.dex */
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<OldAppSaleOnBoardVariant> serializer() {
                    return OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardVariant$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public /* synthetic */ OldAppSaleOnBoardVariant(int i5, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
                if (3 != (i5 & 3)) {
                    PluginExceptionsKt.throwMissingFieldException(i5, 3, OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardVariant$$serializer.INSTANCE.getDescriptor());
                }
                this.id = str;
                this.name = str2;
            }

            public static final /* synthetic */ void write$Self$app_kombardoProd(OldAppSaleOnBoardVariant self, CompositeEncoder output, SerialDescriptor serialDesc) {
                output.encodeStringElement(serialDesc, 0, self.id);
                output.encodeStringElement(serialDesc, 1, self.name);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OldAppSaleOnBoardVariant)) {
                    return false;
                }
                OldAppSaleOnBoardVariant oldAppSaleOnBoardVariant = (OldAppSaleOnBoardVariant) other;
                return Intrinsics.areEqual(this.id, oldAppSaleOnBoardVariant.id) && Intrinsics.areEqual(this.name, oldAppSaleOnBoardVariant.name);
            }

            public int hashCode() {
                return (this.id.hashCode() * 31) + this.name.hashCode();
            }

            public final SaleOnBoardVariant toSaleOnBoardVariant() {
                return new SaleOnBoardVariant(this.id, this.name, null);
            }

            public String toString() {
                return "OldAppSaleOnBoardVariant(id=" + this.id + ", name=" + this.name + ")";
            }
        }

        public /* synthetic */ OldAppSaleOnBoardBasketItem(int i5, String str, String str2, String str3, String str4, double d5, int i6, String str5, String str6, OldAppSaleOnBoardVariant oldAppSaleOnBoardVariant, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (767 != (i5 & 767)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 767, OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.itemNo = str2;
            this.name = str3;
            this.imageUrl = str4;
            this.price = d5;
            this.quantity = i6;
            this.categoryName = str5;
            this.categoryId = str6;
            if ((i5 & 256) == 0) {
                this.variant = null;
            } else {
                this.variant = oldAppSaleOnBoardVariant;
            }
            this.addOns = list;
        }

        public static final /* synthetic */ void write$Self$app_kombardoProd(OldAppSaleOnBoardBasketItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeStringElement(serialDesc, 1, self.itemNo);
            output.encodeStringElement(serialDesc, 2, self.name);
            output.encodeStringElement(serialDesc, 3, self.imageUrl);
            output.encodeDoubleElement(serialDesc, 4, self.price);
            output.encodeIntElement(serialDesc, 5, self.quantity);
            output.encodeStringElement(serialDesc, 6, self.categoryName);
            output.encodeStringElement(serialDesc, 7, self.categoryId);
            if (output.shouldEncodeElementDefault(serialDesc, 8) || self.variant != null) {
                output.encodeNullableSerializableElement(serialDesc, 8, OldAppSaleOnBoardOrder$OldAppSaleOnBoardBasketItem$OldAppSaleOnBoardVariant$$serializer.INSTANCE, self.variant);
            }
            output.encodeSerializableElement(serialDesc, 9, kSerializerArr[9], self.addOns);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OldAppSaleOnBoardBasketItem)) {
                return false;
            }
            OldAppSaleOnBoardBasketItem oldAppSaleOnBoardBasketItem = (OldAppSaleOnBoardBasketItem) other;
            return Intrinsics.areEqual(this.id, oldAppSaleOnBoardBasketItem.id) && Intrinsics.areEqual(this.itemNo, oldAppSaleOnBoardBasketItem.itemNo) && Intrinsics.areEqual(this.name, oldAppSaleOnBoardBasketItem.name) && Intrinsics.areEqual(this.imageUrl, oldAppSaleOnBoardBasketItem.imageUrl) && Double.compare(this.price, oldAppSaleOnBoardBasketItem.price) == 0 && this.quantity == oldAppSaleOnBoardBasketItem.quantity && Intrinsics.areEqual(this.categoryName, oldAppSaleOnBoardBasketItem.categoryName) && Intrinsics.areEqual(this.categoryId, oldAppSaleOnBoardBasketItem.categoryId) && Intrinsics.areEqual(this.variant, oldAppSaleOnBoardBasketItem.variant) && Intrinsics.areEqual(this.addOns, oldAppSaleOnBoardBasketItem.addOns);
        }

        public int hashCode() {
            int hashCode = ((((((((((((((this.id.hashCode() * 31) + this.itemNo.hashCode()) * 31) + this.name.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + Double.hashCode(this.price)) * 31) + Integer.hashCode(this.quantity)) * 31) + this.categoryName.hashCode()) * 31) + this.categoryId.hashCode()) * 31;
            OldAppSaleOnBoardVariant oldAppSaleOnBoardVariant = this.variant;
            return ((hashCode + (oldAppSaleOnBoardVariant == null ? 0 : oldAppSaleOnBoardVariant.hashCode())) * 31) + this.addOns.hashCode();
        }

        public final SaleOnBoardLineItem toSaleOnBoardLineItem() {
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
            SaleOnBoardProduct saleOnBoardProduct = new SaleOnBoardProduct(uuid, CollectionsKt.emptyList(), null, this.name, null, BuildConfig.FLAVOR, null, PriceWithCurrency.INSTANCE.mock(0), this.imageUrl, BuildConfig.FLAVOR, false, BuildConfig.FLAVOR, BuildConfig.FLAVOR, 0);
            String str = this.id;
            PriceWithCurrency priceWithCurrency = new PriceWithCurrency((int) this.price, CurrencyType.DKK);
            int i5 = this.quantity;
            OldAppSaleOnBoardVariant oldAppSaleOnBoardVariant = this.variant;
            SaleOnBoardVariant saleOnBoardVariant = oldAppSaleOnBoardVariant != null ? oldAppSaleOnBoardVariant.toSaleOnBoardVariant() : null;
            List<OldAppSaleOnBoardAddOn> list = this.addOns;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((OldAppSaleOnBoardAddOn) it.next()).toSaleOnBoardAddOn());
            }
            return new SaleOnBoardLineItem(str, saleOnBoardProduct, priceWithCurrency, i5, saleOnBoardVariant, arrayList);
        }

        public String toString() {
            return "OldAppSaleOnBoardBasketItem(id=" + this.id + ", itemNo=" + this.itemNo + ", name=" + this.name + ", imageUrl=" + this.imageUrl + ", price=" + this.price + ", quantity=" + this.quantity + ", categoryName=" + this.categoryName + ", categoryId=" + this.categoryId + ", variant=" + this.variant + ", addOns=" + this.addOns + ")";
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002.-BW\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010$\u001a\u0004\b%\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010&\u001a\u0004\b)\u0010(R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b*\u0010\u001dR\u0017\u0010\n\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010$\u001a\u0004\b+\u0010\u001dR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b,\u0010\u001d¨\u0006/"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardDeparture;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "seen0", BuildConfig.FLAVOR, "timetableId", "Ldk/molslinjen/core/migration/oldApp/OldAppLocalDateTime;", "departureTime", "arrivalTime", "departureHarborName", "arrivalHarborName", "ferryName", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Ldk/molslinjen/core/migration/oldApp/OldAppLocalDateTime;Ldk/molslinjen/core/migration/oldApp/OldAppLocalDateTime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", BuildConfig.FLAVOR, "write$Self$app_kombardoProd", "(Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardDeparture;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardDeparture;", "toSaleOnBoardDeparture", "()Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardDeparture;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTimetableId", "Ldk/molslinjen/core/migration/oldApp/OldAppLocalDateTime;", "getDepartureTime", "()Ldk/molslinjen/core/migration/oldApp/OldAppLocalDateTime;", "getArrivalTime", "getDepartureHarborName", "getArrivalHarborName", "getFerryName", "Companion", "$serializer", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class OldAppSaleOnBoardDeparture {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String arrivalHarborName;
        private final OldAppLocalDateTime arrivalTime;
        private final String departureHarborName;
        private final OldAppLocalDateTime departureTime;
        private final String ferryName;
        private final String timetableId;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardDeparture$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/core/migration/oldApp/OldAppSaleOnBoardOrder$OldAppSaleOnBoardDeparture;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<OldAppSaleOnBoardDeparture> serializer() {
                return OldAppSaleOnBoardOrder$OldAppSaleOnBoardDeparture$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ OldAppSaleOnBoardDeparture(int i5, String str, OldAppLocalDateTime oldAppLocalDateTime, OldAppLocalDateTime oldAppLocalDateTime2, String str2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
            if (63 != (i5 & 63)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 63, OldAppSaleOnBoardOrder$OldAppSaleOnBoardDeparture$$serializer.INSTANCE.getDescriptor());
            }
            this.timetableId = str;
            this.departureTime = oldAppLocalDateTime;
            this.arrivalTime = oldAppLocalDateTime2;
            this.departureHarborName = str2;
            this.arrivalHarborName = str3;
            this.ferryName = str4;
        }

        public static final /* synthetic */ void write$Self$app_kombardoProd(OldAppSaleOnBoardDeparture self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.timetableId);
            OldAppLocalDateTime$$serializer oldAppLocalDateTime$$serializer = OldAppLocalDateTime$$serializer.INSTANCE;
            output.encodeSerializableElement(serialDesc, 1, oldAppLocalDateTime$$serializer, self.departureTime);
            output.encodeSerializableElement(serialDesc, 2, oldAppLocalDateTime$$serializer, self.arrivalTime);
            output.encodeStringElement(serialDesc, 3, self.departureHarborName);
            output.encodeStringElement(serialDesc, 4, self.arrivalHarborName);
            output.encodeStringElement(serialDesc, 5, self.ferryName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OldAppSaleOnBoardDeparture)) {
                return false;
            }
            OldAppSaleOnBoardDeparture oldAppSaleOnBoardDeparture = (OldAppSaleOnBoardDeparture) other;
            return Intrinsics.areEqual(this.timetableId, oldAppSaleOnBoardDeparture.timetableId) && Intrinsics.areEqual(this.departureTime, oldAppSaleOnBoardDeparture.departureTime) && Intrinsics.areEqual(this.arrivalTime, oldAppSaleOnBoardDeparture.arrivalTime) && Intrinsics.areEqual(this.departureHarborName, oldAppSaleOnBoardDeparture.departureHarborName) && Intrinsics.areEqual(this.arrivalHarborName, oldAppSaleOnBoardDeparture.arrivalHarborName) && Intrinsics.areEqual(this.ferryName, oldAppSaleOnBoardDeparture.ferryName);
        }

        public int hashCode() {
            return (((((((((this.timetableId.hashCode() * 31) + this.departureTime.hashCode()) * 31) + this.arrivalTime.hashCode()) * 31) + this.departureHarborName.hashCode()) * 31) + this.arrivalHarborName.hashCode()) * 31) + this.ferryName.hashCode();
        }

        public final SaleOnBoardDeparture toSaleOnBoardDeparture() {
            LocalDateTime localDateTime = this.arrivalTime.toLocalDateTime();
            LocalDateTime localDateTime2 = this.departureTime.toLocalDateTime();
            LocalTime localTime = localDateTime.toLocalTime();
            Intrinsics.checkNotNullExpressionValue(localTime, "toLocalTime(...)");
            LocalDate localDate = localDateTime2.toLocalDate();
            Intrinsics.checkNotNullExpressionValue(localDate, "toLocalDate(...)");
            LocalTime localTime2 = localDateTime2.toLocalTime();
            Intrinsics.checkNotNullExpressionValue(localTime2, "toLocalTime(...)");
            RouteType routeType = RouteType.Ferry;
            String str = this.timetableId;
            Duration between = Duration.between(localDateTime2, localDateTime);
            Intrinsics.checkNotNullExpressionValue(between, "between(...)");
            return new SaleOnBoardDeparture(localTime, localDate, localTime2, "Not important", routeType, str, null, between, null, this.arrivalHarborName, this.departureHarborName);
        }

        public String toString() {
            return "OldAppSaleOnBoardDeparture(timetableId=" + this.timetableId + ", departureTime=" + this.departureTime + ", arrivalTime=" + this.arrivalTime + ", departureHarborName=" + this.departureHarborName + ", arrivalHarborName=" + this.arrivalHarborName + ", ferryName=" + this.ferryName + ")";
        }
    }

    public /* synthetic */ OldAppSaleOnBoardOrder(int i5, String str, OldAppLocalDateTime oldAppLocalDateTime, OldAppLocalDateTime oldAppLocalDateTime2, OldAppSaleOnBoardDeparture oldAppSaleOnBoardDeparture, OldAppOrderStatus oldAppOrderStatus, List list, String str2, String str3, String str4, String str5, String str6, SerializationConstructorMarker serializationConstructorMarker) {
        if (2047 != (i5 & 2047)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 2047, OldAppSaleOnBoardOrder$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.startDateTime = oldAppLocalDateTime;
        this.endDateTime = oldAppLocalDateTime2;
        this.departure = oldAppSaleOnBoardDeparture;
        this.status = oldAppOrderStatus;
        this.products = list;
        this.name = str2;
        this.email = str3;
        this.phoneNumber = str4;
        this.shopImageUrl = str5;
        this.shopLocation = str6;
    }

    public static final /* synthetic */ void write$Self$app_kombardoProd(OldAppSaleOnBoardOrder self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.id);
        OldAppLocalDateTime$$serializer oldAppLocalDateTime$$serializer = OldAppLocalDateTime$$serializer.INSTANCE;
        output.encodeSerializableElement(serialDesc, 1, oldAppLocalDateTime$$serializer, self.startDateTime);
        output.encodeSerializableElement(serialDesc, 2, oldAppLocalDateTime$$serializer, self.endDateTime);
        output.encodeSerializableElement(serialDesc, 3, OldAppSaleOnBoardOrder$OldAppSaleOnBoardDeparture$$serializer.INSTANCE, self.departure);
        output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.status);
        output.encodeSerializableElement(serialDesc, 5, kSerializerArr[5], self.products);
        output.encodeStringElement(serialDesc, 6, self.name);
        output.encodeStringElement(serialDesc, 7, self.email);
        output.encodeStringElement(serialDesc, 8, self.phoneNumber);
        output.encodeStringElement(serialDesc, 9, self.shopImageUrl);
        output.encodeStringElement(serialDesc, 10, self.shopLocation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OldAppSaleOnBoardOrder)) {
            return false;
        }
        OldAppSaleOnBoardOrder oldAppSaleOnBoardOrder = (OldAppSaleOnBoardOrder) other;
        return Intrinsics.areEqual(this.id, oldAppSaleOnBoardOrder.id) && Intrinsics.areEqual(this.startDateTime, oldAppSaleOnBoardOrder.startDateTime) && Intrinsics.areEqual(this.endDateTime, oldAppSaleOnBoardOrder.endDateTime) && Intrinsics.areEqual(this.departure, oldAppSaleOnBoardOrder.departure) && this.status == oldAppSaleOnBoardOrder.status && Intrinsics.areEqual(this.products, oldAppSaleOnBoardOrder.products) && Intrinsics.areEqual(this.name, oldAppSaleOnBoardOrder.name) && Intrinsics.areEqual(this.email, oldAppSaleOnBoardOrder.email) && Intrinsics.areEqual(this.phoneNumber, oldAppSaleOnBoardOrder.phoneNumber) && Intrinsics.areEqual(this.shopImageUrl, oldAppSaleOnBoardOrder.shopImageUrl) && Intrinsics.areEqual(this.shopLocation, oldAppSaleOnBoardOrder.shopLocation);
    }

    public int hashCode() {
        return (((((((((((((((((((this.id.hashCode() * 31) + this.startDateTime.hashCode()) * 31) + this.endDateTime.hashCode()) * 31) + this.departure.hashCode()) * 31) + this.status.hashCode()) * 31) + this.products.hashCode()) * 31) + this.name.hashCode()) * 31) + this.email.hashCode()) * 31) + this.phoneNumber.hashCode()) * 31) + this.shopImageUrl.hashCode()) * 31) + this.shopLocation.hashCode();
    }

    public final SaleOnBoardOrder toSaleOnBoardOrder() {
        String str = this.id;
        LocalDateTime localDateTime = this.startDateTime.toLocalDateTime();
        LocalDateTime localDateTime2 = this.endDateTime.toLocalDateTime();
        SaleOnBoardDeparture saleOnBoardDeparture = this.departure.toSaleOnBoardDeparture();
        SaleOnBoardOrder.OrderStatus saleOnBoardOrderStatus = this.status.toSaleOnBoardOrderStatus();
        List<OldAppSaleOnBoardBasketItem> list = this.products;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((OldAppSaleOnBoardBasketItem) it.next()).toSaleOnBoardLineItem());
        }
        return new SaleOnBoardOrder(str, localDateTime, localDateTime2, saleOnBoardDeparture, saleOnBoardOrderStatus, arrayList, this.shopImageUrl, this.shopLocation, new SaleOnBoardContactInfo(this.name, this.email, new PhoneNumber(BuildConfig.FLAVOR, this.phoneNumber), false), NotificationType.Sms);
    }

    public String toString() {
        return "OldAppSaleOnBoardOrder(id=" + this.id + ", startDateTime=" + this.startDateTime + ", endDateTime=" + this.endDateTime + ", departure=" + this.departure + ", status=" + this.status + ", products=" + this.products + ", name=" + this.name + ", email=" + this.email + ", phoneNumber=" + this.phoneNumber + ", shopImageUrl=" + this.shopImageUrl + ", shopLocation=" + this.shopLocation + ")";
    }
}
