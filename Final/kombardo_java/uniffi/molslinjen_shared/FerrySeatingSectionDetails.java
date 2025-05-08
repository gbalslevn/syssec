package uniffi.molslinjen_shared;

import com.sdk.growthbook.utils.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 ,2\u00020\u0001:\u0001,B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0002\u0010\rJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u0007HÆ\u0003JG\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006-"}, d2 = {"Luniffi/molslinjen_shared/FerrySeatingSectionDetails;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "Luniffi/molslinjen_shared/FerrySeatingSectionId;", "name", BuildConfig.FLAVOR, "coordinates", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/Point;", "size", "Luniffi/molslinjen_shared/Size;", "seatGroups", "Luniffi/molslinjen_shared/FerrySeatingGroup;", "(Luniffi/molslinjen_shared/FerrySeatingSectionId;Ljava/lang/String;Ljava/util/List;Luniffi/molslinjen_shared/Size;Ljava/util/List;)V", "getCoordinates", "()Ljava/util/List;", "setCoordinates", "(Ljava/util/List;)V", "getId", "()Luniffi/molslinjen_shared/FerrySeatingSectionId;", "setId", "(Luniffi/molslinjen_shared/FerrySeatingSectionId;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getSeatGroups", "setSeatGroups", "getSize", "()Luniffi/molslinjen_shared/Size;", "setSize", "(Luniffi/molslinjen_shared/Size;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FerrySeatingSectionDetails {
    private List<Point> coordinates;
    private FerrySeatingSectionId id;
    private String name;
    private List<FerrySeatingGroup> seatGroups;
    private Size size;

    public FerrySeatingSectionDetails(FerrySeatingSectionId id, String name, List<Point> coordinates, Size size, List<FerrySeatingGroup> seatGroups) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(seatGroups, "seatGroups");
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.size = size;
        this.seatGroups = seatGroups;
    }

    public static /* synthetic */ FerrySeatingSectionDetails copy$default(FerrySeatingSectionDetails ferrySeatingSectionDetails, FerrySeatingSectionId ferrySeatingSectionId, String str, List list, Size size, List list2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            ferrySeatingSectionId = ferrySeatingSectionDetails.id;
        }
        if ((i5 & 2) != 0) {
            str = ferrySeatingSectionDetails.name;
        }
        String str2 = str;
        if ((i5 & 4) != 0) {
            list = ferrySeatingSectionDetails.coordinates;
        }
        List list3 = list;
        if ((i5 & 8) != 0) {
            size = ferrySeatingSectionDetails.size;
        }
        Size size2 = size;
        if ((i5 & 16) != 0) {
            list2 = ferrySeatingSectionDetails.seatGroups;
        }
        return ferrySeatingSectionDetails.copy(ferrySeatingSectionId, str2, list3, size2, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final FerrySeatingSectionId getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<Point> component3() {
        return this.coordinates;
    }

    /* renamed from: component4, reason: from getter */
    public final Size getSize() {
        return this.size;
    }

    public final List<FerrySeatingGroup> component5() {
        return this.seatGroups;
    }

    public final FerrySeatingSectionDetails copy(FerrySeatingSectionId id, String name, List<Point> coordinates, Size size, List<FerrySeatingGroup> seatGroups) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(seatGroups, "seatGroups");
        return new FerrySeatingSectionDetails(id, name, coordinates, size, seatGroups);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FerrySeatingSectionDetails)) {
            return false;
        }
        FerrySeatingSectionDetails ferrySeatingSectionDetails = (FerrySeatingSectionDetails) other;
        return Intrinsics.areEqual(this.id, ferrySeatingSectionDetails.id) && Intrinsics.areEqual(this.name, ferrySeatingSectionDetails.name) && Intrinsics.areEqual(this.coordinates, ferrySeatingSectionDetails.coordinates) && Intrinsics.areEqual(this.size, ferrySeatingSectionDetails.size) && Intrinsics.areEqual(this.seatGroups, ferrySeatingSectionDetails.seatGroups);
    }

    public final List<Point> getCoordinates() {
        return this.coordinates;
    }

    public final FerrySeatingSectionId getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final List<FerrySeatingGroup> getSeatGroups() {
        return this.seatGroups;
    }

    public final Size getSize() {
        return this.size;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.coordinates.hashCode()) * 31) + this.size.hashCode()) * 31) + this.seatGroups.hashCode();
    }

    public final void setCoordinates(List<Point> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.coordinates = list;
    }

    public final void setId(FerrySeatingSectionId ferrySeatingSectionId) {
        Intrinsics.checkNotNullParameter(ferrySeatingSectionId, "<set-?>");
        this.id = ferrySeatingSectionId;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setSeatGroups(List<FerrySeatingGroup> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.seatGroups = list;
    }

    public final void setSize(Size size) {
        Intrinsics.checkNotNullParameter(size, "<set-?>");
        this.size = size;
    }

    public String toString() {
        return "FerrySeatingSectionDetails(id=" + this.id + ", name=" + this.name + ", coordinates=" + this.coordinates + ", size=" + this.size + ", seatGroups=" + this.seatGroups + ")";
    }
}
