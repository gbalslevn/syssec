package uniffi.molslinjen_shared;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Luniffi/molslinjen_shared/DepartureCalendarPrices;", BuildConfig.FLAVOR, "priceIndicators", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/DepartureCalendarPrice;", "collapsedPriceIndicator", BuildConfig.FLAVOR, "(Ljava/util/List;Ljava/lang/String;)V", "getCollapsedPriceIndicator", "()Ljava/lang/String;", "setCollapsedPriceIndicator", "(Ljava/lang/String;)V", "getPriceIndicators", "()Ljava/util/List;", "setPriceIndicators", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DepartureCalendarPrices {
    private String collapsedPriceIndicator;
    private List<DepartureCalendarPrice> priceIndicators;

    public DepartureCalendarPrices(List<DepartureCalendarPrice> priceIndicators, String str) {
        Intrinsics.checkNotNullParameter(priceIndicators, "priceIndicators");
        this.priceIndicators = priceIndicators;
        this.collapsedPriceIndicator = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DepartureCalendarPrices copy$default(DepartureCalendarPrices departureCalendarPrices, List list, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            list = departureCalendarPrices.priceIndicators;
        }
        if ((i5 & 2) != 0) {
            str = departureCalendarPrices.collapsedPriceIndicator;
        }
        return departureCalendarPrices.copy(list, str);
    }

    public final List<DepartureCalendarPrice> component1() {
        return this.priceIndicators;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCollapsedPriceIndicator() {
        return this.collapsedPriceIndicator;
    }

    public final DepartureCalendarPrices copy(List<DepartureCalendarPrice> priceIndicators, String collapsedPriceIndicator) {
        Intrinsics.checkNotNullParameter(priceIndicators, "priceIndicators");
        return new DepartureCalendarPrices(priceIndicators, collapsedPriceIndicator);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DepartureCalendarPrices)) {
            return false;
        }
        DepartureCalendarPrices departureCalendarPrices = (DepartureCalendarPrices) other;
        return Intrinsics.areEqual(this.priceIndicators, departureCalendarPrices.priceIndicators) && Intrinsics.areEqual(this.collapsedPriceIndicator, departureCalendarPrices.collapsedPriceIndicator);
    }

    public final String getCollapsedPriceIndicator() {
        return this.collapsedPriceIndicator;
    }

    public final List<DepartureCalendarPrice> getPriceIndicators() {
        return this.priceIndicators;
    }

    public int hashCode() {
        int hashCode = this.priceIndicators.hashCode() * 31;
        String str = this.collapsedPriceIndicator;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final void setCollapsedPriceIndicator(String str) {
        this.collapsedPriceIndicator = str;
    }

    public final void setPriceIndicators(List<DepartureCalendarPrice> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.priceIndicators = list;
    }

    public String toString() {
        return "DepartureCalendarPrices(priceIndicators=" + this.priceIndicators + ", collapsedPriceIndicator=" + this.collapsedPriceIndicator + ")";
    }
}
