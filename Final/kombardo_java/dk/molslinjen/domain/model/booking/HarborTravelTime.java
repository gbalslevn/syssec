package dk.molslinjen.domain.model.booking;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/domain/model/booking/HarborTravelTime;", BuildConfig.FLAVOR, "publicTransportationTime", BuildConfig.FLAVOR, "walkingTime", "nearestCity", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPublicTransportationTime", "()Ljava/lang/String;", "getWalkingTime", "getNearestCity", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class HarborTravelTime {
    private final String nearestCity;
    private final String publicTransportationTime;
    private final String walkingTime;

    public HarborTravelTime(String str, String str2, String nearestCity) {
        Intrinsics.checkNotNullParameter(nearestCity, "nearestCity");
        this.publicTransportationTime = str;
        this.walkingTime = str2;
        this.nearestCity = nearestCity;
    }

    public static /* synthetic */ HarborTravelTime copy$default(HarborTravelTime harborTravelTime, String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = harborTravelTime.publicTransportationTime;
        }
        if ((i5 & 2) != 0) {
            str2 = harborTravelTime.walkingTime;
        }
        if ((i5 & 4) != 0) {
            str3 = harborTravelTime.nearestCity;
        }
        return harborTravelTime.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPublicTransportationTime() {
        return this.publicTransportationTime;
    }

    /* renamed from: component2, reason: from getter */
    public final String getWalkingTime() {
        return this.walkingTime;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNearestCity() {
        return this.nearestCity;
    }

    public final HarborTravelTime copy(String publicTransportationTime, String walkingTime, String nearestCity) {
        Intrinsics.checkNotNullParameter(nearestCity, "nearestCity");
        return new HarborTravelTime(publicTransportationTime, walkingTime, nearestCity);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HarborTravelTime)) {
            return false;
        }
        HarborTravelTime harborTravelTime = (HarborTravelTime) other;
        return Intrinsics.areEqual(this.publicTransportationTime, harborTravelTime.publicTransportationTime) && Intrinsics.areEqual(this.walkingTime, harborTravelTime.walkingTime) && Intrinsics.areEqual(this.nearestCity, harborTravelTime.nearestCity);
    }

    public final String getNearestCity() {
        return this.nearestCity;
    }

    public final String getPublicTransportationTime() {
        return this.publicTransportationTime;
    }

    public final String getWalkingTime() {
        return this.walkingTime;
    }

    public int hashCode() {
        String str = this.publicTransportationTime;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.walkingTime;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.nearestCity.hashCode();
    }

    public String toString() {
        return "HarborTravelTime(publicTransportationTime=" + this.publicTransportationTime + ", walkingTime=" + this.walkingTime + ", nearestCity=" + this.nearestCity + ")";
    }

    public /* synthetic */ HarborTravelTime(String str, String str2, String str3, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? null : str, (i5 & 2) != 0 ? null : str2, str3);
    }
}
