package uniffi.molslinjen_shared;

import com.sdk.growthbook.utils.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 12\u00020\u0001:\u00011B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003JK\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0007HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001e¨\u00062"}, d2 = {"Luniffi/molslinjen_shared/FerryFloorPlan;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "Luniffi/molslinjen_shared/FerryFloorId;", "name", BuildConfig.FLAVOR, "ferryWidthInCm", BuildConfig.FLAVOR, "focusPoint", "Luniffi/molslinjen_shared/Point;", "sectionsPlanImageUrl", "sections", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeatingSection;", "(Luniffi/molslinjen_shared/FerryFloorId;Ljava/lang/String;ILuniffi/molslinjen_shared/Point;Ljava/lang/String;Ljava/util/List;)V", "getFerryWidthInCm", "()I", "setFerryWidthInCm", "(I)V", "getFocusPoint", "()Luniffi/molslinjen_shared/Point;", "setFocusPoint", "(Luniffi/molslinjen_shared/Point;)V", "getId", "()Luniffi/molslinjen_shared/FerryFloorId;", "setId", "(Luniffi/molslinjen_shared/FerryFloorId;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getSections", "()Ljava/util/List;", "setSections", "(Ljava/util/List;)V", "getSectionsPlanImageUrl", "setSectionsPlanImageUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FerryFloorPlan {
    private int ferryWidthInCm;
    private Point focusPoint;
    private FerryFloorId id;
    private String name;
    private List<FerrySeatingSection> sections;
    private String sectionsPlanImageUrl;

    public FerryFloorPlan(FerryFloorId id, String name, int i5, Point focusPoint, String sectionsPlanImageUrl, List<FerrySeatingSection> sections) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(focusPoint, "focusPoint");
        Intrinsics.checkNotNullParameter(sectionsPlanImageUrl, "sectionsPlanImageUrl");
        Intrinsics.checkNotNullParameter(sections, "sections");
        this.id = id;
        this.name = name;
        this.ferryWidthInCm = i5;
        this.focusPoint = focusPoint;
        this.sectionsPlanImageUrl = sectionsPlanImageUrl;
        this.sections = sections;
    }

    public static /* synthetic */ FerryFloorPlan copy$default(FerryFloorPlan ferryFloorPlan, FerryFloorId ferryFloorId, String str, int i5, Point point, String str2, List list, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            ferryFloorId = ferryFloorPlan.id;
        }
        if ((i6 & 2) != 0) {
            str = ferryFloorPlan.name;
        }
        String str3 = str;
        if ((i6 & 4) != 0) {
            i5 = ferryFloorPlan.ferryWidthInCm;
        }
        int i7 = i5;
        if ((i6 & 8) != 0) {
            point = ferryFloorPlan.focusPoint;
        }
        Point point2 = point;
        if ((i6 & 16) != 0) {
            str2 = ferryFloorPlan.sectionsPlanImageUrl;
        }
        String str4 = str2;
        if ((i6 & 32) != 0) {
            list = ferryFloorPlan.sections;
        }
        return ferryFloorPlan.copy(ferryFloorId, str3, i7, point2, str4, list);
    }

    /* renamed from: component1, reason: from getter */
    public final FerryFloorId getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final int getFerryWidthInCm() {
        return this.ferryWidthInCm;
    }

    /* renamed from: component4, reason: from getter */
    public final Point getFocusPoint() {
        return this.focusPoint;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSectionsPlanImageUrl() {
        return this.sectionsPlanImageUrl;
    }

    public final List<FerrySeatingSection> component6() {
        return this.sections;
    }

    public final FerryFloorPlan copy(FerryFloorId id, String name, int ferryWidthInCm, Point focusPoint, String sectionsPlanImageUrl, List<FerrySeatingSection> sections) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(focusPoint, "focusPoint");
        Intrinsics.checkNotNullParameter(sectionsPlanImageUrl, "sectionsPlanImageUrl");
        Intrinsics.checkNotNullParameter(sections, "sections");
        return new FerryFloorPlan(id, name, ferryWidthInCm, focusPoint, sectionsPlanImageUrl, sections);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FerryFloorPlan)) {
            return false;
        }
        FerryFloorPlan ferryFloorPlan = (FerryFloorPlan) other;
        return Intrinsics.areEqual(this.id, ferryFloorPlan.id) && Intrinsics.areEqual(this.name, ferryFloorPlan.name) && this.ferryWidthInCm == ferryFloorPlan.ferryWidthInCm && Intrinsics.areEqual(this.focusPoint, ferryFloorPlan.focusPoint) && Intrinsics.areEqual(this.sectionsPlanImageUrl, ferryFloorPlan.sectionsPlanImageUrl) && Intrinsics.areEqual(this.sections, ferryFloorPlan.sections);
    }

    public final int getFerryWidthInCm() {
        return this.ferryWidthInCm;
    }

    public final Point getFocusPoint() {
        return this.focusPoint;
    }

    public final FerryFloorId getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final List<FerrySeatingSection> getSections() {
        return this.sections;
    }

    public final String getSectionsPlanImageUrl() {
        return this.sectionsPlanImageUrl;
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.ferryWidthInCm)) * 31) + this.focusPoint.hashCode()) * 31) + this.sectionsPlanImageUrl.hashCode()) * 31) + this.sections.hashCode();
    }

    public final void setFerryWidthInCm(int i5) {
        this.ferryWidthInCm = i5;
    }

    public final void setFocusPoint(Point point) {
        Intrinsics.checkNotNullParameter(point, "<set-?>");
        this.focusPoint = point;
    }

    public final void setId(FerryFloorId ferryFloorId) {
        Intrinsics.checkNotNullParameter(ferryFloorId, "<set-?>");
        this.id = ferryFloorId;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setSections(List<FerrySeatingSection> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.sections = list;
    }

    public final void setSectionsPlanImageUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sectionsPlanImageUrl = str;
    }

    public String toString() {
        return "FerryFloorPlan(id=" + this.id + ", name=" + this.name + ", ferryWidthInCm=" + this.ferryWidthInCm + ", focusPoint=" + this.focusPoint + ", sectionsPlanImageUrl=" + this.sectionsPlanImageUrl + ", sections=" + this.sections + ")";
    }
}
