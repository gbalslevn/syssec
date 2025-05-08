package uniffi.molslinjen_shared;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00032\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Luniffi/molslinjen_shared/FerrySeatingGroupType;", BuildConfig.FLAVOR, "()V", "Companion", "CornerTable", "CornerTableLarge", "DoubleSeat", "LargeTable", "SingleSeat", "SmallTable", "XLargeTable", "Luniffi/molslinjen_shared/FerrySeatingGroupType$CornerTable;", "Luniffi/molslinjen_shared/FerrySeatingGroupType$CornerTableLarge;", "Luniffi/molslinjen_shared/FerrySeatingGroupType$DoubleSeat;", "Luniffi/molslinjen_shared/FerrySeatingGroupType$LargeTable;", "Luniffi/molslinjen_shared/FerrySeatingGroupType$SingleSeat;", "Luniffi/molslinjen_shared/FerrySeatingGroupType$SmallTable;", "Luniffi/molslinjen_shared/FerrySeatingGroupType$XLargeTable;", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class FerrySeatingGroupType {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001e"}, d2 = {"Luniffi/molslinjen_shared/FerrySeatingGroupType$CornerTable;", "Luniffi/molslinjen_shared/FerrySeatingGroupType;", "topLeft", "Luniffi/molslinjen_shared/FerrySeat;", "topRight", "middle", "bottomLeft", "bottomRight", "(Luniffi/molslinjen_shared/FerrySeat;Luniffi/molslinjen_shared/FerrySeat;Luniffi/molslinjen_shared/FerrySeat;Luniffi/molslinjen_shared/FerrySeat;Luniffi/molslinjen_shared/FerrySeat;)V", "getBottomLeft", "()Luniffi/molslinjen_shared/FerrySeat;", "getBottomRight", "getMiddle", "getTopLeft", "getTopRight", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* data */ class CornerTable extends FerrySeatingGroupType {
        private final FerrySeat bottomLeft;
        private final FerrySeat bottomRight;
        private final FerrySeat middle;
        private final FerrySeat topLeft;
        private final FerrySeat topRight;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CornerTable(FerrySeat topLeft, FerrySeat topRight, FerrySeat middle, FerrySeat bottomLeft, FerrySeat bottomRight) {
            super(null);
            Intrinsics.checkNotNullParameter(topLeft, "topLeft");
            Intrinsics.checkNotNullParameter(topRight, "topRight");
            Intrinsics.checkNotNullParameter(middle, "middle");
            Intrinsics.checkNotNullParameter(bottomLeft, "bottomLeft");
            Intrinsics.checkNotNullParameter(bottomRight, "bottomRight");
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.middle = middle;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }

        public static /* synthetic */ CornerTable copy$default(CornerTable cornerTable, FerrySeat ferrySeat, FerrySeat ferrySeat2, FerrySeat ferrySeat3, FerrySeat ferrySeat4, FerrySeat ferrySeat5, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                ferrySeat = cornerTable.topLeft;
            }
            if ((i5 & 2) != 0) {
                ferrySeat2 = cornerTable.topRight;
            }
            FerrySeat ferrySeat6 = ferrySeat2;
            if ((i5 & 4) != 0) {
                ferrySeat3 = cornerTable.middle;
            }
            FerrySeat ferrySeat7 = ferrySeat3;
            if ((i5 & 8) != 0) {
                ferrySeat4 = cornerTable.bottomLeft;
            }
            FerrySeat ferrySeat8 = ferrySeat4;
            if ((i5 & 16) != 0) {
                ferrySeat5 = cornerTable.bottomRight;
            }
            return cornerTable.copy(ferrySeat, ferrySeat6, ferrySeat7, ferrySeat8, ferrySeat5);
        }

        /* renamed from: component1, reason: from getter */
        public final FerrySeat getTopLeft() {
            return this.topLeft;
        }

        /* renamed from: component2, reason: from getter */
        public final FerrySeat getTopRight() {
            return this.topRight;
        }

        /* renamed from: component3, reason: from getter */
        public final FerrySeat getMiddle() {
            return this.middle;
        }

        /* renamed from: component4, reason: from getter */
        public final FerrySeat getBottomLeft() {
            return this.bottomLeft;
        }

        /* renamed from: component5, reason: from getter */
        public final FerrySeat getBottomRight() {
            return this.bottomRight;
        }

        public final CornerTable copy(FerrySeat topLeft, FerrySeat topRight, FerrySeat middle, FerrySeat bottomLeft, FerrySeat bottomRight) {
            Intrinsics.checkNotNullParameter(topLeft, "topLeft");
            Intrinsics.checkNotNullParameter(topRight, "topRight");
            Intrinsics.checkNotNullParameter(middle, "middle");
            Intrinsics.checkNotNullParameter(bottomLeft, "bottomLeft");
            Intrinsics.checkNotNullParameter(bottomRight, "bottomRight");
            return new CornerTable(topLeft, topRight, middle, bottomLeft, bottomRight);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CornerTable)) {
                return false;
            }
            CornerTable cornerTable = (CornerTable) other;
            return Intrinsics.areEqual(this.topLeft, cornerTable.topLeft) && Intrinsics.areEqual(this.topRight, cornerTable.topRight) && Intrinsics.areEqual(this.middle, cornerTable.middle) && Intrinsics.areEqual(this.bottomLeft, cornerTable.bottomLeft) && Intrinsics.areEqual(this.bottomRight, cornerTable.bottomRight);
        }

        public final FerrySeat getBottomLeft() {
            return this.bottomLeft;
        }

        public final FerrySeat getBottomRight() {
            return this.bottomRight;
        }

        public final FerrySeat getMiddle() {
            return this.middle;
        }

        public final FerrySeat getTopLeft() {
            return this.topLeft;
        }

        public final FerrySeat getTopRight() {
            return this.topRight;
        }

        public int hashCode() {
            return (((((((this.topLeft.hashCode() * 31) + this.topRight.hashCode()) * 31) + this.middle.hashCode()) * 31) + this.bottomLeft.hashCode()) * 31) + this.bottomRight.hashCode();
        }

        public String toString() {
            return "CornerTable(topLeft=" + this.topLeft + ", topRight=" + this.topRight + ", middle=" + this.middle + ", bottomLeft=" + this.bottomLeft + ", bottomRight=" + this.bottomRight + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006$"}, d2 = {"Luniffi/molslinjen_shared/FerrySeatingGroupType$CornerTableLarge;", "Luniffi/molslinjen_shared/FerrySeatingGroupType;", "topLeft", "Luniffi/molslinjen_shared/FerrySeat;", "topMiddle", "topRight", "middle", "bottomLeft", "bottomMiddle", "bottomRight", "(Luniffi/molslinjen_shared/FerrySeat;Luniffi/molslinjen_shared/FerrySeat;Luniffi/molslinjen_shared/FerrySeat;Luniffi/molslinjen_shared/FerrySeat;Luniffi/molslinjen_shared/FerrySeat;Luniffi/molslinjen_shared/FerrySeat;Luniffi/molslinjen_shared/FerrySeat;)V", "getBottomLeft", "()Luniffi/molslinjen_shared/FerrySeat;", "getBottomMiddle", "getBottomRight", "getMiddle", "getTopLeft", "getTopMiddle", "getTopRight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* data */ class CornerTableLarge extends FerrySeatingGroupType {
        private final FerrySeat bottomLeft;
        private final FerrySeat bottomMiddle;
        private final FerrySeat bottomRight;
        private final FerrySeat middle;
        private final FerrySeat topLeft;
        private final FerrySeat topMiddle;
        private final FerrySeat topRight;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CornerTableLarge(FerrySeat topLeft, FerrySeat topMiddle, FerrySeat topRight, FerrySeat middle, FerrySeat bottomLeft, FerrySeat bottomMiddle, FerrySeat bottomRight) {
            super(null);
            Intrinsics.checkNotNullParameter(topLeft, "topLeft");
            Intrinsics.checkNotNullParameter(topMiddle, "topMiddle");
            Intrinsics.checkNotNullParameter(topRight, "topRight");
            Intrinsics.checkNotNullParameter(middle, "middle");
            Intrinsics.checkNotNullParameter(bottomLeft, "bottomLeft");
            Intrinsics.checkNotNullParameter(bottomMiddle, "bottomMiddle");
            Intrinsics.checkNotNullParameter(bottomRight, "bottomRight");
            this.topLeft = topLeft;
            this.topMiddle = topMiddle;
            this.topRight = topRight;
            this.middle = middle;
            this.bottomLeft = bottomLeft;
            this.bottomMiddle = bottomMiddle;
            this.bottomRight = bottomRight;
        }

        public static /* synthetic */ CornerTableLarge copy$default(CornerTableLarge cornerTableLarge, FerrySeat ferrySeat, FerrySeat ferrySeat2, FerrySeat ferrySeat3, FerrySeat ferrySeat4, FerrySeat ferrySeat5, FerrySeat ferrySeat6, FerrySeat ferrySeat7, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                ferrySeat = cornerTableLarge.topLeft;
            }
            if ((i5 & 2) != 0) {
                ferrySeat2 = cornerTableLarge.topMiddle;
            }
            FerrySeat ferrySeat8 = ferrySeat2;
            if ((i5 & 4) != 0) {
                ferrySeat3 = cornerTableLarge.topRight;
            }
            FerrySeat ferrySeat9 = ferrySeat3;
            if ((i5 & 8) != 0) {
                ferrySeat4 = cornerTableLarge.middle;
            }
            FerrySeat ferrySeat10 = ferrySeat4;
            if ((i5 & 16) != 0) {
                ferrySeat5 = cornerTableLarge.bottomLeft;
            }
            FerrySeat ferrySeat11 = ferrySeat5;
            if ((i5 & 32) != 0) {
                ferrySeat6 = cornerTableLarge.bottomMiddle;
            }
            FerrySeat ferrySeat12 = ferrySeat6;
            if ((i5 & 64) != 0) {
                ferrySeat7 = cornerTableLarge.bottomRight;
            }
            return cornerTableLarge.copy(ferrySeat, ferrySeat8, ferrySeat9, ferrySeat10, ferrySeat11, ferrySeat12, ferrySeat7);
        }

        /* renamed from: component1, reason: from getter */
        public final FerrySeat getTopLeft() {
            return this.topLeft;
        }

        /* renamed from: component2, reason: from getter */
        public final FerrySeat getTopMiddle() {
            return this.topMiddle;
        }

        /* renamed from: component3, reason: from getter */
        public final FerrySeat getTopRight() {
            return this.topRight;
        }

        /* renamed from: component4, reason: from getter */
        public final FerrySeat getMiddle() {
            return this.middle;
        }

        /* renamed from: component5, reason: from getter */
        public final FerrySeat getBottomLeft() {
            return this.bottomLeft;
        }

        /* renamed from: component6, reason: from getter */
        public final FerrySeat getBottomMiddle() {
            return this.bottomMiddle;
        }

        /* renamed from: component7, reason: from getter */
        public final FerrySeat getBottomRight() {
            return this.bottomRight;
        }

        public final CornerTableLarge copy(FerrySeat topLeft, FerrySeat topMiddle, FerrySeat topRight, FerrySeat middle, FerrySeat bottomLeft, FerrySeat bottomMiddle, FerrySeat bottomRight) {
            Intrinsics.checkNotNullParameter(topLeft, "topLeft");
            Intrinsics.checkNotNullParameter(topMiddle, "topMiddle");
            Intrinsics.checkNotNullParameter(topRight, "topRight");
            Intrinsics.checkNotNullParameter(middle, "middle");
            Intrinsics.checkNotNullParameter(bottomLeft, "bottomLeft");
            Intrinsics.checkNotNullParameter(bottomMiddle, "bottomMiddle");
            Intrinsics.checkNotNullParameter(bottomRight, "bottomRight");
            return new CornerTableLarge(topLeft, topMiddle, topRight, middle, bottomLeft, bottomMiddle, bottomRight);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CornerTableLarge)) {
                return false;
            }
            CornerTableLarge cornerTableLarge = (CornerTableLarge) other;
            return Intrinsics.areEqual(this.topLeft, cornerTableLarge.topLeft) && Intrinsics.areEqual(this.topMiddle, cornerTableLarge.topMiddle) && Intrinsics.areEqual(this.topRight, cornerTableLarge.topRight) && Intrinsics.areEqual(this.middle, cornerTableLarge.middle) && Intrinsics.areEqual(this.bottomLeft, cornerTableLarge.bottomLeft) && Intrinsics.areEqual(this.bottomMiddle, cornerTableLarge.bottomMiddle) && Intrinsics.areEqual(this.bottomRight, cornerTableLarge.bottomRight);
        }

        public final FerrySeat getBottomLeft() {
            return this.bottomLeft;
        }

        public final FerrySeat getBottomMiddle() {
            return this.bottomMiddle;
        }

        public final FerrySeat getBottomRight() {
            return this.bottomRight;
        }

        public final FerrySeat getMiddle() {
            return this.middle;
        }

        public final FerrySeat getTopLeft() {
            return this.topLeft;
        }

        public final FerrySeat getTopMiddle() {
            return this.topMiddle;
        }

        public final FerrySeat getTopRight() {
            return this.topRight;
        }

        public int hashCode() {
            return (((((((((((this.topLeft.hashCode() * 31) + this.topMiddle.hashCode()) * 31) + this.topRight.hashCode()) * 31) + this.middle.hashCode()) * 31) + this.bottomLeft.hashCode()) * 31) + this.bottomMiddle.hashCode()) * 31) + this.bottomRight.hashCode();
        }

        public String toString() {
            return "CornerTableLarge(topLeft=" + this.topLeft + ", topMiddle=" + this.topMiddle + ", topRight=" + this.topRight + ", middle=" + this.middle + ", bottomLeft=" + this.bottomLeft + ", bottomMiddle=" + this.bottomMiddle + ", bottomRight=" + this.bottomRight + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, d2 = {"Luniffi/molslinjen_shared/FerrySeatingGroupType$DoubleSeat;", "Luniffi/molslinjen_shared/FerrySeatingGroupType;", "left", "Luniffi/molslinjen_shared/FerrySeat;", "right", "(Luniffi/molslinjen_shared/FerrySeat;Luniffi/molslinjen_shared/FerrySeat;)V", "getLeft", "()Luniffi/molslinjen_shared/FerrySeat;", "getRight", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* data */ class DoubleSeat extends FerrySeatingGroupType {
        private final FerrySeat left;
        private final FerrySeat right;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DoubleSeat(FerrySeat left, FerrySeat right) {
            super(null);
            Intrinsics.checkNotNullParameter(left, "left");
            Intrinsics.checkNotNullParameter(right, "right");
            this.left = left;
            this.right = right;
        }

        public static /* synthetic */ DoubleSeat copy$default(DoubleSeat doubleSeat, FerrySeat ferrySeat, FerrySeat ferrySeat2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                ferrySeat = doubleSeat.left;
            }
            if ((i5 & 2) != 0) {
                ferrySeat2 = doubleSeat.right;
            }
            return doubleSeat.copy(ferrySeat, ferrySeat2);
        }

        /* renamed from: component1, reason: from getter */
        public final FerrySeat getLeft() {
            return this.left;
        }

        /* renamed from: component2, reason: from getter */
        public final FerrySeat getRight() {
            return this.right;
        }

        public final DoubleSeat copy(FerrySeat left, FerrySeat right) {
            Intrinsics.checkNotNullParameter(left, "left");
            Intrinsics.checkNotNullParameter(right, "right");
            return new DoubleSeat(left, right);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DoubleSeat)) {
                return false;
            }
            DoubleSeat doubleSeat = (DoubleSeat) other;
            return Intrinsics.areEqual(this.left, doubleSeat.left) && Intrinsics.areEqual(this.right, doubleSeat.right);
        }

        public final FerrySeat getLeft() {
            return this.left;
        }

        public final FerrySeat getRight() {
            return this.right;
        }

        public int hashCode() {
            return (this.left.hashCode() * 31) + this.right.hashCode();
        }

        public String toString() {
            return "DoubleSeat(left=" + this.left + ", right=" + this.right + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001b"}, d2 = {"Luniffi/molslinjen_shared/FerrySeatingGroupType$LargeTable;", "Luniffi/molslinjen_shared/FerrySeatingGroupType;", "topLeft", "Luniffi/molslinjen_shared/FerrySeat;", "topRight", "bottomLeft", "bottomRight", "(Luniffi/molslinjen_shared/FerrySeat;Luniffi/molslinjen_shared/FerrySeat;Luniffi/molslinjen_shared/FerrySeat;Luniffi/molslinjen_shared/FerrySeat;)V", "getBottomLeft", "()Luniffi/molslinjen_shared/FerrySeat;", "getBottomRight", "getTopLeft", "getTopRight", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* data */ class LargeTable extends FerrySeatingGroupType {
        private final FerrySeat bottomLeft;
        private final FerrySeat bottomRight;
        private final FerrySeat topLeft;
        private final FerrySeat topRight;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LargeTable(FerrySeat topLeft, FerrySeat topRight, FerrySeat bottomLeft, FerrySeat bottomRight) {
            super(null);
            Intrinsics.checkNotNullParameter(topLeft, "topLeft");
            Intrinsics.checkNotNullParameter(topRight, "topRight");
            Intrinsics.checkNotNullParameter(bottomLeft, "bottomLeft");
            Intrinsics.checkNotNullParameter(bottomRight, "bottomRight");
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }

        public static /* synthetic */ LargeTable copy$default(LargeTable largeTable, FerrySeat ferrySeat, FerrySeat ferrySeat2, FerrySeat ferrySeat3, FerrySeat ferrySeat4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                ferrySeat = largeTable.topLeft;
            }
            if ((i5 & 2) != 0) {
                ferrySeat2 = largeTable.topRight;
            }
            if ((i5 & 4) != 0) {
                ferrySeat3 = largeTable.bottomLeft;
            }
            if ((i5 & 8) != 0) {
                ferrySeat4 = largeTable.bottomRight;
            }
            return largeTable.copy(ferrySeat, ferrySeat2, ferrySeat3, ferrySeat4);
        }

        /* renamed from: component1, reason: from getter */
        public final FerrySeat getTopLeft() {
            return this.topLeft;
        }

        /* renamed from: component2, reason: from getter */
        public final FerrySeat getTopRight() {
            return this.topRight;
        }

        /* renamed from: component3, reason: from getter */
        public final FerrySeat getBottomLeft() {
            return this.bottomLeft;
        }

        /* renamed from: component4, reason: from getter */
        public final FerrySeat getBottomRight() {
            return this.bottomRight;
        }

        public final LargeTable copy(FerrySeat topLeft, FerrySeat topRight, FerrySeat bottomLeft, FerrySeat bottomRight) {
            Intrinsics.checkNotNullParameter(topLeft, "topLeft");
            Intrinsics.checkNotNullParameter(topRight, "topRight");
            Intrinsics.checkNotNullParameter(bottomLeft, "bottomLeft");
            Intrinsics.checkNotNullParameter(bottomRight, "bottomRight");
            return new LargeTable(topLeft, topRight, bottomLeft, bottomRight);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LargeTable)) {
                return false;
            }
            LargeTable largeTable = (LargeTable) other;
            return Intrinsics.areEqual(this.topLeft, largeTable.topLeft) && Intrinsics.areEqual(this.topRight, largeTable.topRight) && Intrinsics.areEqual(this.bottomLeft, largeTable.bottomLeft) && Intrinsics.areEqual(this.bottomRight, largeTable.bottomRight);
        }

        public final FerrySeat getBottomLeft() {
            return this.bottomLeft;
        }

        public final FerrySeat getBottomRight() {
            return this.bottomRight;
        }

        public final FerrySeat getTopLeft() {
            return this.topLeft;
        }

        public final FerrySeat getTopRight() {
            return this.topRight;
        }

        public int hashCode() {
            return (((((this.topLeft.hashCode() * 31) + this.topRight.hashCode()) * 31) + this.bottomLeft.hashCode()) * 31) + this.bottomRight.hashCode();
        }

        public String toString() {
            return "LargeTable(topLeft=" + this.topLeft + ", topRight=" + this.topRight + ", bottomLeft=" + this.bottomLeft + ", bottomRight=" + this.bottomRight + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Luniffi/molslinjen_shared/FerrySeatingGroupType$SingleSeat;", "Luniffi/molslinjen_shared/FerrySeatingGroupType;", "seat", "Luniffi/molslinjen_shared/FerrySeat;", "(Luniffi/molslinjen_shared/FerrySeat;)V", "getSeat", "()Luniffi/molslinjen_shared/FerrySeat;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* data */ class SingleSeat extends FerrySeatingGroupType {
        private final FerrySeat seat;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SingleSeat(FerrySeat seat) {
            super(null);
            Intrinsics.checkNotNullParameter(seat, "seat");
            this.seat = seat;
        }

        public static /* synthetic */ SingleSeat copy$default(SingleSeat singleSeat, FerrySeat ferrySeat, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                ferrySeat = singleSeat.seat;
            }
            return singleSeat.copy(ferrySeat);
        }

        /* renamed from: component1, reason: from getter */
        public final FerrySeat getSeat() {
            return this.seat;
        }

        public final SingleSeat copy(FerrySeat seat) {
            Intrinsics.checkNotNullParameter(seat, "seat");
            return new SingleSeat(seat);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SingleSeat) && Intrinsics.areEqual(this.seat, ((SingleSeat) other).seat);
        }

        public final FerrySeat getSeat() {
            return this.seat;
        }

        public int hashCode() {
            return this.seat.hashCode();
        }

        public String toString() {
            return "SingleSeat(seat=" + this.seat + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, d2 = {"Luniffi/molslinjen_shared/FerrySeatingGroupType$SmallTable;", "Luniffi/molslinjen_shared/FerrySeatingGroupType;", "top", "Luniffi/molslinjen_shared/FerrySeat;", "bottom", "(Luniffi/molslinjen_shared/FerrySeat;Luniffi/molslinjen_shared/FerrySeat;)V", "getBottom", "()Luniffi/molslinjen_shared/FerrySeat;", "getTop", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* data */ class SmallTable extends FerrySeatingGroupType {
        private final FerrySeat bottom;
        private final FerrySeat top;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SmallTable(FerrySeat top, FerrySeat bottom) {
            super(null);
            Intrinsics.checkNotNullParameter(top, "top");
            Intrinsics.checkNotNullParameter(bottom, "bottom");
            this.top = top;
            this.bottom = bottom;
        }

        public static /* synthetic */ SmallTable copy$default(SmallTable smallTable, FerrySeat ferrySeat, FerrySeat ferrySeat2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                ferrySeat = smallTable.top;
            }
            if ((i5 & 2) != 0) {
                ferrySeat2 = smallTable.bottom;
            }
            return smallTable.copy(ferrySeat, ferrySeat2);
        }

        /* renamed from: component1, reason: from getter */
        public final FerrySeat getTop() {
            return this.top;
        }

        /* renamed from: component2, reason: from getter */
        public final FerrySeat getBottom() {
            return this.bottom;
        }

        public final SmallTable copy(FerrySeat top, FerrySeat bottom) {
            Intrinsics.checkNotNullParameter(top, "top");
            Intrinsics.checkNotNullParameter(bottom, "bottom");
            return new SmallTable(top, bottom);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SmallTable)) {
                return false;
            }
            SmallTable smallTable = (SmallTable) other;
            return Intrinsics.areEqual(this.top, smallTable.top) && Intrinsics.areEqual(this.bottom, smallTable.bottom);
        }

        public final FerrySeat getBottom() {
            return this.bottom;
        }

        public final FerrySeat getTop() {
            return this.top;
        }

        public int hashCode() {
            return (this.top.hashCode() * 31) + this.bottom.hashCode();
        }

        public String toString() {
            return "SmallTable(top=" + this.top + ", bottom=" + this.bottom + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006!"}, d2 = {"Luniffi/molslinjen_shared/FerrySeatingGroupType$XLargeTable;", "Luniffi/molslinjen_shared/FerrySeatingGroupType;", "topLeft", "Luniffi/molslinjen_shared/FerrySeat;", "topMiddle", "topRight", "bottomLeft", "bottomMiddle", "bottomRight", "(Luniffi/molslinjen_shared/FerrySeat;Luniffi/molslinjen_shared/FerrySeat;Luniffi/molslinjen_shared/FerrySeat;Luniffi/molslinjen_shared/FerrySeat;Luniffi/molslinjen_shared/FerrySeat;Luniffi/molslinjen_shared/FerrySeat;)V", "getBottomLeft", "()Luniffi/molslinjen_shared/FerrySeat;", "getBottomMiddle", "getBottomRight", "getTopLeft", "getTopMiddle", "getTopRight", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* data */ class XLargeTable extends FerrySeatingGroupType {
        private final FerrySeat bottomLeft;
        private final FerrySeat bottomMiddle;
        private final FerrySeat bottomRight;
        private final FerrySeat topLeft;
        private final FerrySeat topMiddle;
        private final FerrySeat topRight;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public XLargeTable(FerrySeat topLeft, FerrySeat topMiddle, FerrySeat topRight, FerrySeat bottomLeft, FerrySeat bottomMiddle, FerrySeat bottomRight) {
            super(null);
            Intrinsics.checkNotNullParameter(topLeft, "topLeft");
            Intrinsics.checkNotNullParameter(topMiddle, "topMiddle");
            Intrinsics.checkNotNullParameter(topRight, "topRight");
            Intrinsics.checkNotNullParameter(bottomLeft, "bottomLeft");
            Intrinsics.checkNotNullParameter(bottomMiddle, "bottomMiddle");
            Intrinsics.checkNotNullParameter(bottomRight, "bottomRight");
            this.topLeft = topLeft;
            this.topMiddle = topMiddle;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomMiddle = bottomMiddle;
            this.bottomRight = bottomRight;
        }

        public static /* synthetic */ XLargeTable copy$default(XLargeTable xLargeTable, FerrySeat ferrySeat, FerrySeat ferrySeat2, FerrySeat ferrySeat3, FerrySeat ferrySeat4, FerrySeat ferrySeat5, FerrySeat ferrySeat6, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                ferrySeat = xLargeTable.topLeft;
            }
            if ((i5 & 2) != 0) {
                ferrySeat2 = xLargeTable.topMiddle;
            }
            FerrySeat ferrySeat7 = ferrySeat2;
            if ((i5 & 4) != 0) {
                ferrySeat3 = xLargeTable.topRight;
            }
            FerrySeat ferrySeat8 = ferrySeat3;
            if ((i5 & 8) != 0) {
                ferrySeat4 = xLargeTable.bottomLeft;
            }
            FerrySeat ferrySeat9 = ferrySeat4;
            if ((i5 & 16) != 0) {
                ferrySeat5 = xLargeTable.bottomMiddle;
            }
            FerrySeat ferrySeat10 = ferrySeat5;
            if ((i5 & 32) != 0) {
                ferrySeat6 = xLargeTable.bottomRight;
            }
            return xLargeTable.copy(ferrySeat, ferrySeat7, ferrySeat8, ferrySeat9, ferrySeat10, ferrySeat6);
        }

        /* renamed from: component1, reason: from getter */
        public final FerrySeat getTopLeft() {
            return this.topLeft;
        }

        /* renamed from: component2, reason: from getter */
        public final FerrySeat getTopMiddle() {
            return this.topMiddle;
        }

        /* renamed from: component3, reason: from getter */
        public final FerrySeat getTopRight() {
            return this.topRight;
        }

        /* renamed from: component4, reason: from getter */
        public final FerrySeat getBottomLeft() {
            return this.bottomLeft;
        }

        /* renamed from: component5, reason: from getter */
        public final FerrySeat getBottomMiddle() {
            return this.bottomMiddle;
        }

        /* renamed from: component6, reason: from getter */
        public final FerrySeat getBottomRight() {
            return this.bottomRight;
        }

        public final XLargeTable copy(FerrySeat topLeft, FerrySeat topMiddle, FerrySeat topRight, FerrySeat bottomLeft, FerrySeat bottomMiddle, FerrySeat bottomRight) {
            Intrinsics.checkNotNullParameter(topLeft, "topLeft");
            Intrinsics.checkNotNullParameter(topMiddle, "topMiddle");
            Intrinsics.checkNotNullParameter(topRight, "topRight");
            Intrinsics.checkNotNullParameter(bottomLeft, "bottomLeft");
            Intrinsics.checkNotNullParameter(bottomMiddle, "bottomMiddle");
            Intrinsics.checkNotNullParameter(bottomRight, "bottomRight");
            return new XLargeTable(topLeft, topMiddle, topRight, bottomLeft, bottomMiddle, bottomRight);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof XLargeTable)) {
                return false;
            }
            XLargeTable xLargeTable = (XLargeTable) other;
            return Intrinsics.areEqual(this.topLeft, xLargeTable.topLeft) && Intrinsics.areEqual(this.topMiddle, xLargeTable.topMiddle) && Intrinsics.areEqual(this.topRight, xLargeTable.topRight) && Intrinsics.areEqual(this.bottomLeft, xLargeTable.bottomLeft) && Intrinsics.areEqual(this.bottomMiddle, xLargeTable.bottomMiddle) && Intrinsics.areEqual(this.bottomRight, xLargeTable.bottomRight);
        }

        public final FerrySeat getBottomLeft() {
            return this.bottomLeft;
        }

        public final FerrySeat getBottomMiddle() {
            return this.bottomMiddle;
        }

        public final FerrySeat getBottomRight() {
            return this.bottomRight;
        }

        public final FerrySeat getTopLeft() {
            return this.topLeft;
        }

        public final FerrySeat getTopMiddle() {
            return this.topMiddle;
        }

        public final FerrySeat getTopRight() {
            return this.topRight;
        }

        public int hashCode() {
            return (((((((((this.topLeft.hashCode() * 31) + this.topMiddle.hashCode()) * 31) + this.topRight.hashCode()) * 31) + this.bottomLeft.hashCode()) * 31) + this.bottomMiddle.hashCode()) * 31) + this.bottomRight.hashCode();
        }

        public String toString() {
            return "XLargeTable(topLeft=" + this.topLeft + ", topMiddle=" + this.topMiddle + ", topRight=" + this.topRight + ", bottomLeft=" + this.bottomLeft + ", bottomMiddle=" + this.bottomMiddle + ", bottomRight=" + this.bottomRight + ")";
        }
    }

    public /* synthetic */ FerrySeatingGroupType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private FerrySeatingGroupType() {
    }
}
