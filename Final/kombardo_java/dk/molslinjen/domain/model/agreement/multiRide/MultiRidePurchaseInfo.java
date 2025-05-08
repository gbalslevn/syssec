package dk.molslinjen.domain.model.agreement.multiRide;

import dk.molslinjen.api.services.multiRide.response.MultiRidePriceStepResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRidePurchaseInfoResponseDTO;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRidePriceStep;
import dk.molslinjen.domain.model.booking.TicketCategoryType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(BI\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\r\u0010\u0011J\r\u0010\u001b\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010!\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013¨\u0006)"}, d2 = {"Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePurchaseInfo;", BuildConfig.FLAVOR, "multiRideTypeId", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideTypeId;", "ticketCategoryType", "Ldk/molslinjen/domain/model/booking/TicketCategoryType;", "ticketTypeName", "terms", BuildConfig.FLAVOR, "priceSteps", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePriceStep;", "validToDescription", "<init>", "(Ljava/lang/String;Ldk/molslinjen/domain/model/booking/TicketCategoryType;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseInfoResponseDTO;", "(Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseInfoResponseDTO;)V", "getMultiRideTypeId", "()Ljava/lang/String;", "getTicketCategoryType", "()Ldk/molslinjen/domain/model/booking/TicketCategoryType;", "getTicketTypeName", "getTerms", "()Ljava/util/List;", "getPriceSteps", "getValidToDescription", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MultiRidePurchaseInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MultiRidePurchaseInfo mock;
    private final String multiRideTypeId;
    private final List<MultiRidePriceStep> priceSteps;
    private final List<String> terms;
    private final TicketCategoryType ticketCategoryType;
    private final String ticketTypeName;
    private final String validToDescription;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePurchaseInfo$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePurchaseInfo;", "getMock", "()Ldk/molslinjen/domain/model/agreement/multiRide/MultiRidePurchaseInfo;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MultiRidePurchaseInfo getMock() {
            return MultiRidePurchaseInfo.mock;
        }

        private Companion() {
        }
    }

    static {
        TicketCategoryType ticketCategoryType = TicketCategoryType.BlueClass;
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"Term 0", "Term 1", "Term 2", "Term 3 - This line is very long and should span multiple lines", "Term 4"});
        MultiRidePriceStep.Companion companion = MultiRidePriceStep.INSTANCE;
        mock = new MultiRidePurchaseInfo("084", ticketCategoryType, "Blueclass", listOf, CollectionsKt.listOf((Object[]) new MultiRidePriceStep[]{companion.getMock1(), companion.getMock2(), companion.getMock3()}), "Valid to description goes here");
    }

    public MultiRidePurchaseInfo(String multiRideTypeId, TicketCategoryType ticketCategoryType, String ticketTypeName, List<String> terms, List<MultiRidePriceStep> priceSteps, String str) {
        Intrinsics.checkNotNullParameter(multiRideTypeId, "multiRideTypeId");
        Intrinsics.checkNotNullParameter(ticketCategoryType, "ticketCategoryType");
        Intrinsics.checkNotNullParameter(ticketTypeName, "ticketTypeName");
        Intrinsics.checkNotNullParameter(terms, "terms");
        Intrinsics.checkNotNullParameter(priceSteps, "priceSteps");
        this.multiRideTypeId = multiRideTypeId;
        this.ticketCategoryType = ticketCategoryType;
        this.ticketTypeName = ticketTypeName;
        this.terms = terms;
        this.priceSteps = priceSteps;
        this.validToDescription = str;
    }

    public static /* synthetic */ MultiRidePurchaseInfo copy$default(MultiRidePurchaseInfo multiRidePurchaseInfo, String str, TicketCategoryType ticketCategoryType, String str2, List list, List list2, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = multiRidePurchaseInfo.multiRideTypeId;
        }
        if ((i5 & 2) != 0) {
            ticketCategoryType = multiRidePurchaseInfo.ticketCategoryType;
        }
        TicketCategoryType ticketCategoryType2 = ticketCategoryType;
        if ((i5 & 4) != 0) {
            str2 = multiRidePurchaseInfo.ticketTypeName;
        }
        String str4 = str2;
        if ((i5 & 8) != 0) {
            list = multiRidePurchaseInfo.terms;
        }
        List list3 = list;
        if ((i5 & 16) != 0) {
            list2 = multiRidePurchaseInfo.priceSteps;
        }
        List list4 = list2;
        if ((i5 & 32) != 0) {
            str3 = multiRidePurchaseInfo.validToDescription;
        }
        return multiRidePurchaseInfo.copy(str, ticketCategoryType2, str4, list3, list4, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMultiRideTypeId() {
        return this.multiRideTypeId;
    }

    /* renamed from: component2, reason: from getter */
    public final TicketCategoryType getTicketCategoryType() {
        return this.ticketCategoryType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTicketTypeName() {
        return this.ticketTypeName;
    }

    public final List<String> component4() {
        return this.terms;
    }

    public final List<MultiRidePriceStep> component5() {
        return this.priceSteps;
    }

    /* renamed from: component6, reason: from getter */
    public final String getValidToDescription() {
        return this.validToDescription;
    }

    public final MultiRidePurchaseInfo copy(String multiRideTypeId, TicketCategoryType ticketCategoryType, String ticketTypeName, List<String> terms, List<MultiRidePriceStep> priceSteps, String validToDescription) {
        Intrinsics.checkNotNullParameter(multiRideTypeId, "multiRideTypeId");
        Intrinsics.checkNotNullParameter(ticketCategoryType, "ticketCategoryType");
        Intrinsics.checkNotNullParameter(ticketTypeName, "ticketTypeName");
        Intrinsics.checkNotNullParameter(terms, "terms");
        Intrinsics.checkNotNullParameter(priceSteps, "priceSteps");
        return new MultiRidePurchaseInfo(multiRideTypeId, ticketCategoryType, ticketTypeName, terms, priceSteps, validToDescription);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiRidePurchaseInfo)) {
            return false;
        }
        MultiRidePurchaseInfo multiRidePurchaseInfo = (MultiRidePurchaseInfo) other;
        return Intrinsics.areEqual(this.multiRideTypeId, multiRidePurchaseInfo.multiRideTypeId) && this.ticketCategoryType == multiRidePurchaseInfo.ticketCategoryType && Intrinsics.areEqual(this.ticketTypeName, multiRidePurchaseInfo.ticketTypeName) && Intrinsics.areEqual(this.terms, multiRidePurchaseInfo.terms) && Intrinsics.areEqual(this.priceSteps, multiRidePurchaseInfo.priceSteps) && Intrinsics.areEqual(this.validToDescription, multiRidePurchaseInfo.validToDescription);
    }

    public final String getMultiRideTypeId() {
        return this.multiRideTypeId;
    }

    public final List<MultiRidePriceStep> getPriceSteps() {
        return this.priceSteps;
    }

    public final List<String> getTerms() {
        return this.terms;
    }

    public final TicketCategoryType getTicketCategoryType() {
        return this.ticketCategoryType;
    }

    public final String getTicketTypeName() {
        return this.ticketTypeName;
    }

    public final String getValidToDescription() {
        return this.validToDescription;
    }

    public int hashCode() {
        int hashCode = ((((((((this.multiRideTypeId.hashCode() * 31) + this.ticketCategoryType.hashCode()) * 31) + this.ticketTypeName.hashCode()) * 31) + this.terms.hashCode()) * 31) + this.priceSteps.hashCode()) * 31;
        String str = this.validToDescription;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "MultiRidePurchaseInfo(multiRideTypeId=" + this.multiRideTypeId + ", ticketCategoryType=" + this.ticketCategoryType + ", ticketTypeName=" + this.ticketTypeName + ", terms=" + this.terms + ", priceSteps=" + this.priceSteps + ", validToDescription=" + this.validToDescription + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MultiRidePurchaseInfo(MultiRidePurchaseInfoResponseDTO dto) {
        this(r2, r3, r4, r5, r6, dto.getValidToDescription());
        Intrinsics.checkNotNullParameter(dto, "dto");
        String id = dto.getId();
        TicketCategoryType invoke = TicketCategoryType.INSTANCE.invoke(dto.getTicketCategory().getId());
        String name = dto.getTicketCategory().getName();
        List<String> terms = dto.getTicketCategory().getTerms();
        List<MultiRidePriceStepResponseDTO> priceSteps = dto.getPriceSteps();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(priceSteps, 10));
        Iterator<T> it = priceSteps.iterator();
        while (it.hasNext()) {
            arrayList.add(new MultiRidePriceStep((MultiRidePriceStepResponseDTO) it.next()));
        }
    }
}
