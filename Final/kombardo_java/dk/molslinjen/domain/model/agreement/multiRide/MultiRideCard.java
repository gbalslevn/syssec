package dk.molslinjen.domain.model.agreement.multiRide;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.helpers.serializers.LocalDateWithTimeSerializer;
import dk.molslinjen.api.services.multiRide.response.AccountMultiRideResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRideCardResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRideTransportDTO;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideTransport;
import dk.molslinjen.domain.model.booking.TicketCategoryType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
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
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 Y2\u00020\u0001:\u0002YZB}\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0004\b\u0018\u0010\u001cB\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u001d¢\u0006\u0004\b\u0018\u0010\u001eB\u009b\u0001\b\u0010\u0012\u0006\u0010\u001f\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010 \u001a\u0004\u0018\u00010!¢\u0006\u0004\b\u0018\u0010\"J\r\u0010@\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\r\u0010A\u001a\u00060\u0003j\u0002`\u0006HÆ\u0003J\t\u0010B\u001a\u00020\bHÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u000f\u0010D\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u0010E\u001a\u00020\fHÆ\u0003J\t\u0010F\u001a\u00020\u000fHÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\u000f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\t\u0010I\u001a\u00020\u0013HÂ\u0003J\t\u0010J\u001a\u00020\u0015HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0017HÂ\u0003J\u0097\u0001\u0010L\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\f\b\u0002\u0010\u0005\u001a\u00060\u0003j\u0002`\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÆ\u0001J\u0013\u0010M\u001a\u00020\u00132\b\u0010N\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010O\u001a\u00020\u000fHÖ\u0001J\t\u0010P\u001a\u00020\u0003HÖ\u0001J%\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020\u00002\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WH\u0001¢\u0006\u0002\bXR\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0015\u0010\u0005\u001a\u00060\u0003j\u0002`\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010$R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010*R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u00105\u001a\u0004\u0018\u00010\u00178F¢\u0006\u0006\u001a\u0004\b6\u00107R\u0011\u00108\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b8\u00109R\u0011\u0010:\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b;\u00109R\u0011\u0010<\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b=\u0010.R\u0011\u0010>\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b?\u00109¨\u0006["}, d2 = {"Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCardNumber;", "multiRideTypeId", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideTypeId;", "ticketType", "Ldk/molslinjen/domain/model/booking/TicketCategoryType;", "ticketTypeName", "enabledTransportations", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideTransport;", "defaultTransportation", "remainingCharges", BuildConfig.FLAVOR, "customer", "allowedRouteIds", "canRefill", BuildConfig.FLAVOR, "validUntil", "Lorg/threeten/bp/LocalDate;", "chargesExpirySoonInternal", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideChargesExpiry;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/TicketCategoryType;Ljava/lang/String;Ljava/util/List;Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideTransport;ILjava/lang/String;Ljava/util/List;ZLorg/threeten/bp/LocalDate;Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideChargesExpiry;)V", "dto", "Ldk/molslinjen/api/services/multiRide/response/MultiRideCardResponseDTO;", "(Ldk/molslinjen/api/services/multiRide/response/MultiRideCardResponseDTO;)V", "Ldk/molslinjen/api/services/multiRide/response/AccountMultiRideResponseDTO;", "(Ldk/molslinjen/api/services/multiRide/response/AccountMultiRideResponseDTO;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/TicketCategoryType;Ljava/lang/String;Ljava/util/List;Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideTransport;ILjava/lang/String;Ljava/util/List;ZLorg/threeten/bp/LocalDate;Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideChargesExpiry;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getMultiRideTypeId", "getTicketType", "()Ldk/molslinjen/domain/model/booking/TicketCategoryType;", "getTicketTypeName", "getEnabledTransportations", "()Ljava/util/List;", "getDefaultTransportation", "()Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideTransport;", "getRemainingCharges", "()I", "getCustomer", "getAllowedRouteIds", "getValidUntil$annotations", "()V", "getValidUntil", "()Lorg/threeten/bp/LocalDate;", "chargesExpirySoon", "getChargesExpirySoon", "()Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideChargesExpiry;", "isExpired", "()Z", "expiresSoon", "getExpiresSoon", "daysUntilCardExpiry", "getDaysUntilCardExpiry", "enableForRefill", "getEnableForRefill", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class MultiRideCard {
    private static final MultiRideCard mock;
    private final List<String> allowedRouteIds;
    private final boolean canRefill;
    private final MultiRideChargesExpiry chargesExpirySoonInternal;
    private final String customer;
    private final MultiRideTransport defaultTransportation;
    private final List<MultiRideTransport> enabledTransportations;
    private final String id;
    private final String multiRideTypeId;
    private final int remainingCharges;
    private final TicketCategoryType ticketType;
    private final String ticketTypeName;
    private final LocalDate validUntil;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, EnumsKt.createSimpleEnumSerializer("dk.molslinjen.domain.model.booking.TicketCategoryType", TicketCategoryType.values()), null, new ArrayListSerializer(MultiRideTransport$$serializer.INSTANCE), null, null, null, new ArrayListSerializer(StringSerializer.INSTANCE), null, null, null};
    private static final IntRange validExpiresSoonInterval = new IntRange(1, 89);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "validExpiresSoonInterval", "Lkotlin/ranges/IntRange;", "getValidExpiresSoonInterval", "()Lkotlin/ranges/IntRange;", "mock", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "getMock", "()Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCard;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MultiRideCard getMock() {
            return MultiRideCard.mock;
        }

        public final IntRange getValidExpiresSoonInterval() {
            return MultiRideCard.validExpiresSoonInterval;
        }

        public final KSerializer<MultiRideCard> serializer() {
            return MultiRideCard$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        TicketCategoryType ticketCategoryType = TicketCategoryType.BlueClass;
        MultiRideTransport.Companion companion = MultiRideTransport.INSTANCE;
        List listOf = CollectionsKt.listOf(companion.getMock());
        MultiRideTransport mock2 = companion.getMock();
        List listOf2 = CollectionsKt.listOf((Object[]) new String[]{"2", "3"});
        LocalDate plusDays = LocalDate.now().plusDays(100L);
        Intrinsics.checkNotNullExpressionValue(plusDays, "plusDays(...)");
        mock = new MultiRideCard("08100000000000000832", "081", ticketCategoryType, "Blueclass", listOf, mock2, 10, BuildConfig.FLAVOR, listOf2, true, plusDays, null);
    }

    public /* synthetic */ MultiRideCard(int i5, String str, String str2, TicketCategoryType ticketCategoryType, String str3, List list, MultiRideTransport multiRideTransport, int i6, String str4, List list2, boolean z5, LocalDate localDate, MultiRideChargesExpiry multiRideChargesExpiry, SerializationConstructorMarker serializationConstructorMarker) {
        if (4095 != (i5 & 4095)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 4095, MultiRideCard$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.multiRideTypeId = str2;
        this.ticketType = ticketCategoryType;
        this.ticketTypeName = str3;
        this.enabledTransportations = list;
        this.defaultTransportation = multiRideTransport;
        this.remainingCharges = i6;
        this.customer = str4;
        this.allowedRouteIds = list2;
        this.canRefill = z5;
        this.validUntil = localDate;
        this.chargesExpirySoonInternal = multiRideChargesExpiry;
    }

    /* renamed from: component10, reason: from getter */
    private final boolean getCanRefill() {
        return this.canRefill;
    }

    /* renamed from: component12, reason: from getter */
    private final MultiRideChargesExpiry getChargesExpirySoonInternal() {
        return this.chargesExpirySoonInternal;
    }

    @Serializable(with = LocalDateWithTimeSerializer.class)
    public static /* synthetic */ void getValidUntil$annotations() {
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(MultiRideCard self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.multiRideTypeId);
        output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.ticketType);
        output.encodeStringElement(serialDesc, 3, self.ticketTypeName);
        output.encodeSerializableElement(serialDesc, 4, kSerializerArr[4], self.enabledTransportations);
        output.encodeSerializableElement(serialDesc, 5, MultiRideTransport$$serializer.INSTANCE, self.defaultTransportation);
        output.encodeIntElement(serialDesc, 6, self.remainingCharges);
        output.encodeStringElement(serialDesc, 7, self.customer);
        output.encodeSerializableElement(serialDesc, 8, kSerializerArr[8], self.allowedRouteIds);
        output.encodeBooleanElement(serialDesc, 9, self.canRefill);
        output.encodeSerializableElement(serialDesc, 10, LocalDateWithTimeSerializer.INSTANCE, self.validUntil);
        output.encodeNullableSerializableElement(serialDesc, 11, MultiRideChargesExpiry$$serializer.INSTANCE, self.chargesExpirySoonInternal);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component11, reason: from getter */
    public final LocalDate getValidUntil() {
        return this.validUntil;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMultiRideTypeId() {
        return this.multiRideTypeId;
    }

    /* renamed from: component3, reason: from getter */
    public final TicketCategoryType getTicketType() {
        return this.ticketType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTicketTypeName() {
        return this.ticketTypeName;
    }

    public final List<MultiRideTransport> component5() {
        return this.enabledTransportations;
    }

    /* renamed from: component6, reason: from getter */
    public final MultiRideTransport getDefaultTransportation() {
        return this.defaultTransportation;
    }

    /* renamed from: component7, reason: from getter */
    public final int getRemainingCharges() {
        return this.remainingCharges;
    }

    /* renamed from: component8, reason: from getter */
    public final String getCustomer() {
        return this.customer;
    }

    public final List<String> component9() {
        return this.allowedRouteIds;
    }

    public final MultiRideCard copy(String id, String multiRideTypeId, TicketCategoryType ticketType, String ticketTypeName, List<MultiRideTransport> enabledTransportations, MultiRideTransport defaultTransportation, int remainingCharges, String customer, List<String> allowedRouteIds, boolean canRefill, LocalDate validUntil, MultiRideChargesExpiry chargesExpirySoonInternal) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(multiRideTypeId, "multiRideTypeId");
        Intrinsics.checkNotNullParameter(ticketType, "ticketType");
        Intrinsics.checkNotNullParameter(ticketTypeName, "ticketTypeName");
        Intrinsics.checkNotNullParameter(enabledTransportations, "enabledTransportations");
        Intrinsics.checkNotNullParameter(defaultTransportation, "defaultTransportation");
        Intrinsics.checkNotNullParameter(customer, "customer");
        Intrinsics.checkNotNullParameter(allowedRouteIds, "allowedRouteIds");
        Intrinsics.checkNotNullParameter(validUntil, "validUntil");
        return new MultiRideCard(id, multiRideTypeId, ticketType, ticketTypeName, enabledTransportations, defaultTransportation, remainingCharges, customer, allowedRouteIds, canRefill, validUntil, chargesExpirySoonInternal);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiRideCard)) {
            return false;
        }
        MultiRideCard multiRideCard = (MultiRideCard) other;
        return Intrinsics.areEqual(this.id, multiRideCard.id) && Intrinsics.areEqual(this.multiRideTypeId, multiRideCard.multiRideTypeId) && this.ticketType == multiRideCard.ticketType && Intrinsics.areEqual(this.ticketTypeName, multiRideCard.ticketTypeName) && Intrinsics.areEqual(this.enabledTransportations, multiRideCard.enabledTransportations) && Intrinsics.areEqual(this.defaultTransportation, multiRideCard.defaultTransportation) && this.remainingCharges == multiRideCard.remainingCharges && Intrinsics.areEqual(this.customer, multiRideCard.customer) && Intrinsics.areEqual(this.allowedRouteIds, multiRideCard.allowedRouteIds) && this.canRefill == multiRideCard.canRefill && Intrinsics.areEqual(this.validUntil, multiRideCard.validUntil) && Intrinsics.areEqual(this.chargesExpirySoonInternal, multiRideCard.chargesExpirySoonInternal);
    }

    public final List<String> getAllowedRouteIds() {
        return this.allowedRouteIds;
    }

    public final MultiRideChargesExpiry getChargesExpirySoon() {
        MultiRideChargesExpiry multiRideChargesExpiry = this.chargesExpirySoonInternal;
        if (multiRideChargesExpiry != null && multiRideChargesExpiry.getCharges() <= this.remainingCharges) {
            IntRange intRange = validExpiresSoonInterval;
            int first = intRange.getFirst();
            int last = intRange.getLast();
            int daysFromNow = LocalDateTimeExtensionsKt.daysFromNow(this.chargesExpirySoonInternal.getExpiryDate());
            if (first <= daysFromNow && daysFromNow <= last) {
                return this.chargesExpirySoonInternal;
            }
        }
        return null;
    }

    public final String getCustomer() {
        return this.customer;
    }

    public final int getDaysUntilCardExpiry() {
        return LocalDateTimeExtensionsKt.daysFromNow(this.validUntil);
    }

    public final MultiRideTransport getDefaultTransportation() {
        return this.defaultTransportation;
    }

    public final boolean getEnableForRefill() {
        return (this.canRefill && this.remainingCharges <= 2) || isExpired();
    }

    public final List<MultiRideTransport> getEnabledTransportations() {
        return this.enabledTransportations;
    }

    public final boolean getExpiresSoon() {
        IntRange intRange = validExpiresSoonInterval;
        int first = intRange.getFirst();
        int last = intRange.getLast();
        int daysUntilCardExpiry = getDaysUntilCardExpiry();
        return first <= daysUntilCardExpiry && daysUntilCardExpiry <= last;
    }

    public final String getId() {
        return this.id;
    }

    public final String getMultiRideTypeId() {
        return this.multiRideTypeId;
    }

    public final int getRemainingCharges() {
        return this.remainingCharges;
    }

    public final TicketCategoryType getTicketType() {
        return this.ticketType;
    }

    public final String getTicketTypeName() {
        return this.ticketTypeName;
    }

    public final LocalDate getValidUntil() {
        return this.validUntil;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((this.id.hashCode() * 31) + this.multiRideTypeId.hashCode()) * 31) + this.ticketType.hashCode()) * 31) + this.ticketTypeName.hashCode()) * 31) + this.enabledTransportations.hashCode()) * 31) + this.defaultTransportation.hashCode()) * 31) + Integer.hashCode(this.remainingCharges)) * 31) + this.customer.hashCode()) * 31) + this.allowedRouteIds.hashCode()) * 31) + Boolean.hashCode(this.canRefill)) * 31) + this.validUntil.hashCode()) * 31;
        MultiRideChargesExpiry multiRideChargesExpiry = this.chargesExpirySoonInternal;
        return hashCode + (multiRideChargesExpiry == null ? 0 : multiRideChargesExpiry.hashCode());
    }

    public final boolean isExpired() {
        return this.validUntil.isBefore(LocalDate.now());
    }

    public String toString() {
        return "MultiRideCard(id=" + this.id + ", multiRideTypeId=" + this.multiRideTypeId + ", ticketType=" + this.ticketType + ", ticketTypeName=" + this.ticketTypeName + ", enabledTransportations=" + this.enabledTransportations + ", defaultTransportation=" + this.defaultTransportation + ", remainingCharges=" + this.remainingCharges + ", customer=" + this.customer + ", allowedRouteIds=" + this.allowedRouteIds + ", canRefill=" + this.canRefill + ", validUntil=" + this.validUntil + ", chargesExpirySoonInternal=" + this.chargesExpirySoonInternal + ")";
    }

    public MultiRideCard(String id, String multiRideTypeId, TicketCategoryType ticketType, String ticketTypeName, List<MultiRideTransport> enabledTransportations, MultiRideTransport defaultTransportation, int i5, String customer, List<String> allowedRouteIds, boolean z5, LocalDate validUntil, MultiRideChargesExpiry multiRideChargesExpiry) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(multiRideTypeId, "multiRideTypeId");
        Intrinsics.checkNotNullParameter(ticketType, "ticketType");
        Intrinsics.checkNotNullParameter(ticketTypeName, "ticketTypeName");
        Intrinsics.checkNotNullParameter(enabledTransportations, "enabledTransportations");
        Intrinsics.checkNotNullParameter(defaultTransportation, "defaultTransportation");
        Intrinsics.checkNotNullParameter(customer, "customer");
        Intrinsics.checkNotNullParameter(allowedRouteIds, "allowedRouteIds");
        Intrinsics.checkNotNullParameter(validUntil, "validUntil");
        this.id = id;
        this.multiRideTypeId = multiRideTypeId;
        this.ticketType = ticketType;
        this.ticketTypeName = ticketTypeName;
        this.enabledTransportations = enabledTransportations;
        this.defaultTransportation = defaultTransportation;
        this.remainingCharges = i5;
        this.customer = customer;
        this.allowedRouteIds = allowedRouteIds;
        this.canRefill = z5;
        this.validUntil = validUntil;
        this.chargesExpirySoonInternal = multiRideChargesExpiry;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MultiRideCard(MultiRideCardResponseDTO dto) {
        this(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r0 != null ? new MultiRideChargesExpiry(dto.getTicketExpiringCount(), r0) : null);
        Intrinsics.checkNotNullParameter(dto, "dto");
        String cardNumber = dto.getCardNumber();
        String cardType = dto.getCardType();
        TicketCategoryType invoke = TicketCategoryType.INSTANCE.invoke(dto.getCategory().getId());
        String name = dto.getCategory().getName();
        List<MultiRideTransportDTO> enabledTransports = dto.getEnabledTransports();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(enabledTransports, 10));
        Iterator<T> it = enabledTransports.iterator();
        while (it.hasNext()) {
            arrayList.add(new MultiRideTransport((MultiRideTransportDTO) it.next()));
        }
        MultiRideTransport multiRideTransport = new MultiRideTransport(dto.getDefaultTransport());
        int numberOfTickets = dto.getNumberOfTickets();
        String customerId = dto.getCustomerId();
        List<String> allowedRoundtripRouteIds = dto.getAllowedRoundtripRouteIds();
        boolean canRefill = dto.getCanRefill();
        LocalDate validUntil = dto.getValidUntil();
        Duration ticketExpiration = dto.getTicketExpiration();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MultiRideCard(AccountMultiRideResponseDTO dto) {
        this(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r0 != null ? new MultiRideChargesExpiry(dto.getTicketExpiringCount(), r0) : null);
        Intrinsics.checkNotNullParameter(dto, "dto");
        String agreementNumber = dto.getAgreementNumber();
        String multiRideTypeId = dto.getMultiRideTypeId();
        TicketCategoryType invoke = TicketCategoryType.INSTANCE.invoke(dto.getTicketTypeId());
        String ticketTypeName = dto.getTicketTypeName();
        List<MultiRideTransportDTO> enabledTransports = dto.getEnabledTransports();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(enabledTransports, 10));
        Iterator<T> it = enabledTransports.iterator();
        while (it.hasNext()) {
            arrayList.add(new MultiRideTransport((MultiRideTransportDTO) it.next()));
        }
        MultiRideTransport multiRideTransport = new MultiRideTransport(dto.getDefaultTransport());
        int remainingTrips = dto.getRemainingTrips();
        String customer = dto.getCustomer();
        List<String> allowedRoundtripRouteIds = dto.getAllowedRoundtripRouteIds();
        boolean canRefill = dto.getCanRefill();
        LocalDate validUntil = dto.getValidUntil();
        Duration ticketExpiration = dto.getTicketExpiration();
    }
}
