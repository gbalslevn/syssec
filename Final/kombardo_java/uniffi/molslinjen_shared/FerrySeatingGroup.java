package uniffi.molslinjen_shared;

import com.sdk.growthbook.utils.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J1\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Luniffi/molslinjen_shared/FerrySeatingGroup;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "Luniffi/molslinjen_shared/FerrySeatingGroupId;", "groupType", "Luniffi/molslinjen_shared/FerrySeatingGroupType;", "rotation", BuildConfig.FLAVOR, "origin", "Luniffi/molslinjen_shared/Point;", "(Luniffi/molslinjen_shared/FerrySeatingGroupId;Luniffi/molslinjen_shared/FerrySeatingGroupType;DLuniffi/molslinjen_shared/Point;)V", "getGroupType", "()Luniffi/molslinjen_shared/FerrySeatingGroupType;", "setGroupType", "(Luniffi/molslinjen_shared/FerrySeatingGroupType;)V", "getId", "()Luniffi/molslinjen_shared/FerrySeatingGroupId;", "setId", "(Luniffi/molslinjen_shared/FerrySeatingGroupId;)V", "getOrigin", "()Luniffi/molslinjen_shared/Point;", "setOrigin", "(Luniffi/molslinjen_shared/Point;)V", "getRotation", "()D", "setRotation", "(D)V", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FerrySeatingGroup {
    private FerrySeatingGroupType groupType;
    private FerrySeatingGroupId id;
    private Point origin;
    private double rotation;

    public FerrySeatingGroup(FerrySeatingGroupId id, FerrySeatingGroupType groupType, double d5, Point origin) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(groupType, "groupType");
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.id = id;
        this.groupType = groupType;
        this.rotation = d5;
        this.origin = origin;
    }

    public static /* synthetic */ FerrySeatingGroup copy$default(FerrySeatingGroup ferrySeatingGroup, FerrySeatingGroupId ferrySeatingGroupId, FerrySeatingGroupType ferrySeatingGroupType, double d5, Point point, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            ferrySeatingGroupId = ferrySeatingGroup.id;
        }
        if ((i5 & 2) != 0) {
            ferrySeatingGroupType = ferrySeatingGroup.groupType;
        }
        FerrySeatingGroupType ferrySeatingGroupType2 = ferrySeatingGroupType;
        if ((i5 & 4) != 0) {
            d5 = ferrySeatingGroup.rotation;
        }
        double d6 = d5;
        if ((i5 & 8) != 0) {
            point = ferrySeatingGroup.origin;
        }
        return ferrySeatingGroup.copy(ferrySeatingGroupId, ferrySeatingGroupType2, d6, point);
    }

    /* renamed from: component1, reason: from getter */
    public final FerrySeatingGroupId getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final FerrySeatingGroupType getGroupType() {
        return this.groupType;
    }

    /* renamed from: component3, reason: from getter */
    public final double getRotation() {
        return this.rotation;
    }

    /* renamed from: component4, reason: from getter */
    public final Point getOrigin() {
        return this.origin;
    }

    public final FerrySeatingGroup copy(FerrySeatingGroupId id, FerrySeatingGroupType groupType, double rotation, Point origin) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(groupType, "groupType");
        Intrinsics.checkNotNullParameter(origin, "origin");
        return new FerrySeatingGroup(id, groupType, rotation, origin);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FerrySeatingGroup)) {
            return false;
        }
        FerrySeatingGroup ferrySeatingGroup = (FerrySeatingGroup) other;
        return Intrinsics.areEqual(this.id, ferrySeatingGroup.id) && Intrinsics.areEqual(this.groupType, ferrySeatingGroup.groupType) && Double.compare(this.rotation, ferrySeatingGroup.rotation) == 0 && Intrinsics.areEqual(this.origin, ferrySeatingGroup.origin);
    }

    public final FerrySeatingGroupType getGroupType() {
        return this.groupType;
    }

    public final FerrySeatingGroupId getId() {
        return this.id;
    }

    public final Point getOrigin() {
        return this.origin;
    }

    public final double getRotation() {
        return this.rotation;
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.groupType.hashCode()) * 31) + Double.hashCode(this.rotation)) * 31) + this.origin.hashCode();
    }

    public final void setGroupType(FerrySeatingGroupType ferrySeatingGroupType) {
        Intrinsics.checkNotNullParameter(ferrySeatingGroupType, "<set-?>");
        this.groupType = ferrySeatingGroupType;
    }

    public final void setId(FerrySeatingGroupId ferrySeatingGroupId) {
        Intrinsics.checkNotNullParameter(ferrySeatingGroupId, "<set-?>");
        this.id = ferrySeatingGroupId;
    }

    public final void setOrigin(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.origin = point;
    }

    public final void setRotation(double d5) {
        this.rotation = d5;
    }

    public String toString() {
        return "FerrySeatingGroup(id=" + this.id + ", groupType=" + this.groupType + ", rotation=" + this.rotation + ", origin=" + this.origin + ")";
    }
}
