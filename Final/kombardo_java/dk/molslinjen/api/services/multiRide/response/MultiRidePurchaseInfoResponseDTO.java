package dk.molslinjen.api.services.multiRide.response;

import com.sdk.growthbook.utils.Constants;
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
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 22\u00020\u0001:\u0003012B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rB]\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JM\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u000fHÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001J%\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001¢\u0006\u0002\b/R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u00063"}, d2 = {"Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseInfoResponseDTO;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "name", "shortName", "validToDescription", "ticketCategory", "Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseInfoResponseDTO$TicketCategoryResponseDTO;", "priceSteps", BuildConfig.FLAVOR, "Ldk/molslinjen/api/services/multiRide/response/MultiRidePriceStepResponseDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseInfoResponseDTO$TicketCategoryResponseDTO;Ljava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseInfoResponseDTO$TicketCategoryResponseDTO;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName", "getShortName", "getValidToDescription", "getTicketCategory", "()Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseInfoResponseDTO$TicketCategoryResponseDTO;", "getPriceSteps", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "TicketCategoryResponseDTO", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class MultiRidePurchaseInfoResponseDTO {
    private final String id;
    private final String name;
    private final List<MultiRidePriceStepResponseDTO> priceSteps;
    private final String shortName;
    private final TicketCategoryResponseDTO ticketCategory;
    private final String validToDescription;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, null, null, new ArrayListSerializer(MultiRidePriceStepResponseDTO$$serializer.INSTANCE)};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseInfoResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseInfoResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<MultiRidePurchaseInfoResponseDTO> serializer() {
            return MultiRidePurchaseInfoResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bB?\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\nHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseInfoResponseDTO$TicketCategoryResponseDTO;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "name", "terms", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getName", "getTerms", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable
    /* loaded from: classes2.dex */
    public static final /* data */ class TicketCategoryResponseDTO {
        private final String id;
        private final String name;
        private final List<String> terms;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(StringSerializer.INSTANCE)};

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseInfoResponseDTO$TicketCategoryResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseInfoResponseDTO$TicketCategoryResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<TicketCategoryResponseDTO> serializer() {
                return MultiRidePurchaseInfoResponseDTO$TicketCategoryResponseDTO$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ TicketCategoryResponseDTO(int i5, String str, String str2, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i5 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i5, 7, MultiRidePurchaseInfoResponseDTO$TicketCategoryResponseDTO$$serializer.INSTANCE.getDescriptor());
            }
            this.id = str;
            this.name = str2;
            this.terms = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TicketCategoryResponseDTO copy$default(TicketCategoryResponseDTO ticketCategoryResponseDTO, String str, String str2, List list, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = ticketCategoryResponseDTO.id;
            }
            if ((i5 & 2) != 0) {
                str2 = ticketCategoryResponseDTO.name;
            }
            if ((i5 & 4) != 0) {
                list = ticketCategoryResponseDTO.terms;
            }
            return ticketCategoryResponseDTO.copy(str, str2, list);
        }

        public static final /* synthetic */ void write$Self$api_kombardoProd(TicketCategoryResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
            KSerializer<Object>[] kSerializerArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.id);
            output.encodeStringElement(serialDesc, 1, self.name);
            output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.terms);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final List<String> component3() {
            return this.terms;
        }

        public final TicketCategoryResponseDTO copy(String id, String name, List<String> terms) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(terms, "terms");
            return new TicketCategoryResponseDTO(id, name, terms);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TicketCategoryResponseDTO)) {
                return false;
            }
            TicketCategoryResponseDTO ticketCategoryResponseDTO = (TicketCategoryResponseDTO) other;
            return Intrinsics.areEqual(this.id, ticketCategoryResponseDTO.id) && Intrinsics.areEqual(this.name, ticketCategoryResponseDTO.name) && Intrinsics.areEqual(this.terms, ticketCategoryResponseDTO.terms);
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final List<String> getTerms() {
            return this.terms;
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.terms.hashCode();
        }

        public String toString() {
            return "TicketCategoryResponseDTO(id=" + this.id + ", name=" + this.name + ", terms=" + this.terms + ")";
        }

        public TicketCategoryResponseDTO(String id, String name, List<String> terms) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(terms, "terms");
            this.id = id;
            this.name = name;
            this.terms = terms;
        }
    }

    public /* synthetic */ MultiRidePurchaseInfoResponseDTO(int i5, String str, String str2, String str3, String str4, TicketCategoryResponseDTO ticketCategoryResponseDTO, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i5 & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 63, MultiRidePurchaseInfoResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.name = str2;
        this.shortName = str3;
        this.validToDescription = str4;
        this.ticketCategory = ticketCategoryResponseDTO;
        this.priceSteps = list;
    }

    public static /* synthetic */ MultiRidePurchaseInfoResponseDTO copy$default(MultiRidePurchaseInfoResponseDTO multiRidePurchaseInfoResponseDTO, String str, String str2, String str3, String str4, TicketCategoryResponseDTO ticketCategoryResponseDTO, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = multiRidePurchaseInfoResponseDTO.id;
        }
        if ((i5 & 2) != 0) {
            str2 = multiRidePurchaseInfoResponseDTO.name;
        }
        String str5 = str2;
        if ((i5 & 4) != 0) {
            str3 = multiRidePurchaseInfoResponseDTO.shortName;
        }
        String str6 = str3;
        if ((i5 & 8) != 0) {
            str4 = multiRidePurchaseInfoResponseDTO.validToDescription;
        }
        String str7 = str4;
        if ((i5 & 16) != 0) {
            ticketCategoryResponseDTO = multiRidePurchaseInfoResponseDTO.ticketCategory;
        }
        TicketCategoryResponseDTO ticketCategoryResponseDTO2 = ticketCategoryResponseDTO;
        if ((i5 & 32) != 0) {
            list = multiRidePurchaseInfoResponseDTO.priceSteps;
        }
        return multiRidePurchaseInfoResponseDTO.copy(str, str5, str6, str7, ticketCategoryResponseDTO2, list);
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(MultiRidePurchaseInfoResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.name);
        output.encodeStringElement(serialDesc, 2, self.shortName);
        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.validToDescription);
        output.encodeSerializableElement(serialDesc, 4, MultiRidePurchaseInfoResponseDTO$TicketCategoryResponseDTO$$serializer.INSTANCE, self.ticketCategory);
        output.encodeSerializableElement(serialDesc, 5, kSerializerArr[5], self.priceSteps);
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
    public final String getShortName() {
        return this.shortName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getValidToDescription() {
        return this.validToDescription;
    }

    /* renamed from: component5, reason: from getter */
    public final TicketCategoryResponseDTO getTicketCategory() {
        return this.ticketCategory;
    }

    public final List<MultiRidePriceStepResponseDTO> component6() {
        return this.priceSteps;
    }

    public final MultiRidePurchaseInfoResponseDTO copy(String id, String name, String shortName, String validToDescription, TicketCategoryResponseDTO ticketCategory, List<MultiRidePriceStepResponseDTO> priceSteps) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(shortName, "shortName");
        Intrinsics.checkNotNullParameter(ticketCategory, "ticketCategory");
        Intrinsics.checkNotNullParameter(priceSteps, "priceSteps");
        return new MultiRidePurchaseInfoResponseDTO(id, name, shortName, validToDescription, ticketCategory, priceSteps);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiRidePurchaseInfoResponseDTO)) {
            return false;
        }
        MultiRidePurchaseInfoResponseDTO multiRidePurchaseInfoResponseDTO = (MultiRidePurchaseInfoResponseDTO) other;
        return Intrinsics.areEqual(this.id, multiRidePurchaseInfoResponseDTO.id) && Intrinsics.areEqual(this.name, multiRidePurchaseInfoResponseDTO.name) && Intrinsics.areEqual(this.shortName, multiRidePurchaseInfoResponseDTO.shortName) && Intrinsics.areEqual(this.validToDescription, multiRidePurchaseInfoResponseDTO.validToDescription) && Intrinsics.areEqual(this.ticketCategory, multiRidePurchaseInfoResponseDTO.ticketCategory) && Intrinsics.areEqual(this.priceSteps, multiRidePurchaseInfoResponseDTO.priceSteps);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final List<MultiRidePriceStepResponseDTO> getPriceSteps() {
        return this.priceSteps;
    }

    public final String getShortName() {
        return this.shortName;
    }

    public final TicketCategoryResponseDTO getTicketCategory() {
        return this.ticketCategory;
    }

    public final String getValidToDescription() {
        return this.validToDescription;
    }

    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.shortName.hashCode()) * 31;
        String str = this.validToDescription;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.ticketCategory.hashCode()) * 31) + this.priceSteps.hashCode();
    }

    public String toString() {
        return "MultiRidePurchaseInfoResponseDTO(id=" + this.id + ", name=" + this.name + ", shortName=" + this.shortName + ", validToDescription=" + this.validToDescription + ", ticketCategory=" + this.ticketCategory + ", priceSteps=" + this.priceSteps + ")";
    }

    public MultiRidePurchaseInfoResponseDTO(String id, String name, String shortName, String str, TicketCategoryResponseDTO ticketCategory, List<MultiRidePriceStepResponseDTO> priceSteps) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(shortName, "shortName");
        Intrinsics.checkNotNullParameter(ticketCategory, "ticketCategory");
        Intrinsics.checkNotNullParameter(priceSteps, "priceSteps");
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.validToDescription = str;
        this.ticketCategory = ticketCategory;
        this.priceSteps = priceSteps;
    }
}
