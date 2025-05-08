package uniffi.molslinjen_shared;

import com.sdk.growthbook.utils.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b.\b\u0086\b\u0018\u0000 =2\u00020\u0001:\u0001=BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\tHÆ\u0003J\t\u00104\u001a\u00020\u000bHÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\t\u00106\u001a\u00020\u000eHÆ\u0003J\t\u00107\u001a\u00020\u0010HÆ\u0003J_\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u00109\u001a\u00020\u00102\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u000eHÖ\u0001J\t\u0010<\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0017\"\u0004\b'\u0010\u0019R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006>"}, d2 = {"Luniffi/molslinjen_shared/FerrySeatingSectionOverview;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "Luniffi/molslinjen_shared/FerrySeatingSectionId;", "name", BuildConfig.FLAVOR, "origin", "Luniffi/molslinjen_shared/Point;", "coordinates", BuildConfig.FLAVOR, "size", "Luniffi/molslinjen_shared/Size;", "center", "availableSeats", BuildConfig.FLAVOR, "showAvailableSeats", BuildConfig.FLAVOR, "(Luniffi/molslinjen_shared/FerrySeatingSectionId;Ljava/lang/String;Luniffi/molslinjen_shared/Point;Ljava/util/List;Luniffi/molslinjen_shared/Size;Luniffi/molslinjen_shared/Point;IZ)V", "getAvailableSeats", "()I", "setAvailableSeats", "(I)V", "getCenter", "()Luniffi/molslinjen_shared/Point;", "setCenter", "(Luniffi/molslinjen_shared/Point;)V", "getCoordinates", "()Ljava/util/List;", "setCoordinates", "(Ljava/util/List;)V", "getId", "()Luniffi/molslinjen_shared/FerrySeatingSectionId;", "setId", "(Luniffi/molslinjen_shared/FerrySeatingSectionId;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getOrigin", "setOrigin", "getShowAvailableSeats", "()Z", "setShowAvailableSeats", "(Z)V", "getSize", "()Luniffi/molslinjen_shared/Size;", "setSize", "(Luniffi/molslinjen_shared/Size;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FerrySeatingSectionOverview {
    private int availableSeats;
    private Point center;
    private List<Point> coordinates;
    private FerrySeatingSectionId id;
    private String name;
    private Point origin;
    private boolean showAvailableSeats;
    private Size size;

    public FerrySeatingSectionOverview(FerrySeatingSectionId id, String name, Point origin, List<Point> coordinates, Size size, Point center, int i5, boolean z5) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(center, "center");
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.coordinates = coordinates;
        this.size = size;
        this.center = center;
        this.availableSeats = i5;
        this.showAvailableSeats = z5;
    }

    /* renamed from: component1, reason: from getter */
    public final FerrySeatingSectionId getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final Point getOrigin() {
        return this.origin;
    }

    public final List<Point> component4() {
        return this.coordinates;
    }

    /* renamed from: component5, reason: from getter */
    public final Size getSize() {
        return this.size;
    }

    /* renamed from: component6, reason: from getter */
    public final Point getCenter() {
        return this.center;
    }

    /* renamed from: component7, reason: from getter */
    public final int getAvailableSeats() {
        return this.availableSeats;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getShowAvailableSeats() {
        return this.showAvailableSeats;
    }

    public final FerrySeatingSectionOverview copy(FerrySeatingSectionId id, String name, Point origin, List<Point> coordinates, Size size, Point center, int availableSeats, boolean showAvailableSeats) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(center, "center");
        return new FerrySeatingSectionOverview(id, name, origin, coordinates, size, center, availableSeats, showAvailableSeats);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FerrySeatingSectionOverview)) {
            return false;
        }
        FerrySeatingSectionOverview ferrySeatingSectionOverview = (FerrySeatingSectionOverview) other;
        return Intrinsics.areEqual(this.id, ferrySeatingSectionOverview.id) && Intrinsics.areEqual(this.name, ferrySeatingSectionOverview.name) && Intrinsics.areEqual(this.origin, ferrySeatingSectionOverview.origin) && Intrinsics.areEqual(this.coordinates, ferrySeatingSectionOverview.coordinates) && Intrinsics.areEqual(this.size, ferrySeatingSectionOverview.size) && Intrinsics.areEqual(this.center, ferrySeatingSectionOverview.center) && this.availableSeats == ferrySeatingSectionOverview.availableSeats && this.showAvailableSeats == ferrySeatingSectionOverview.showAvailableSeats;
    }

    public final int getAvailableSeats() {
        return this.availableSeats;
    }

    public final Point getCenter() {
        return this.center;
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

    public final Point getOrigin() {
        return this.origin;
    }

    public final boolean getShowAvailableSeats() {
        return this.showAvailableSeats;
    }

    public final Size getSize() {
        return this.size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.origin.hashCode()) * 31) + this.coordinates.hashCode()) * 31) + this.size.hashCode()) * 31) + this.center.hashCode()) * 31) + Integer.hashCode(this.availableSeats)) * 31;
        boolean z5 = this.showAvailableSeats;
        int i5 = z5;
        if (z5 != 0) {
            i5 = 1;
        }
        return hashCode + i5;
    }

    public final void setAvailableSeats(int i5) {
        this.availableSeats = i5;
    }

    public final void setCenter(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.center = point;
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

    public final void setOrigin(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.origin = point;
    }

    public final void setShowAvailableSeats(boolean z5) {
        this.showAvailableSeats = z5;
    }

    public final void setSize(Size size) {
        Intrinsics.checkNotNullParameter(size, "<set-?>");
        this.size = size;
    }

    public String toString() {
        return "FerrySeatingSectionOverview(id=" + this.id + ", name=" + this.name + ", origin=" + this.origin + ", coordinates=" + this.coordinates + ", size=" + this.size + ", center=" + this.center + ", availableSeats=" + this.availableSeats + ", showAvailableSeats=" + this.showAvailableSeats + ")";
    }
}
