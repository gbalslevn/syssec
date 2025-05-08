package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001c\bÇ\u0002\u0018\u00002\u00020\u0001:\u0005@ABCDB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0017\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0018\u0010\u0013J/\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u001a\u0010\u0013J/\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u001c\u0010\u0013J/\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u001e\u0010\u0013R \u0010!\u001a\u00020 8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b!\u0010\"\u0012\u0004\b%\u0010\u0003\u001a\u0004\b#\u0010$R \u0010&\u001a\u00020 8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b&\u0010\"\u0012\u0004\b(\u0010\u0003\u001a\u0004\b'\u0010$R \u0010*\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b*\u0010+\u0012\u0004\b.\u0010\u0003\u001a\u0004\b,\u0010-R \u0010/\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b/\u0010+\u0012\u0004\b1\u0010\u0003\u001a\u0004\b0\u0010-R \u00102\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b2\u00103\u0012\u0004\b6\u0010\u0003\u001a\u0004\b4\u00105R \u00107\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b7\u00103\u0012\u0004\b9\u0010\u0003\u001a\u0004\b8\u00105R \u0010:\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b:\u00103\u0012\u0004\b<\u0010\u0003\u001a\u0004\b;\u00105R \u0010=\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b=\u00103\u0012\u0004\b?\u0010\u0003\u001a\u0004\b>\u00105\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006E"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/unit/Dp;", "space", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "spacedBy-0680j_4", "(F)Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "spacedBy", BuildConfig.FLAVOR, "totalSize", BuildConfig.FLAVOR, "size", "outPosition", BuildConfig.FLAVOR, "reverseInput", BuildConfig.FLAVOR, "placeRightOrBottom$foundation_layout_release", "(I[I[IZ)V", "placeRightOrBottom", "placeLeftOrTop$foundation_layout_release", "([I[IZ)V", "placeLeftOrTop", "placeCenter$foundation_layout_release", "placeCenter", "placeSpaceEvenly$foundation_layout_release", "placeSpaceEvenly", "placeSpaceBetween$foundation_layout_release", "placeSpaceBetween", "placeSpaceAround$foundation_layout_release", "placeSpaceAround", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Start", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getStart", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getStart$annotations", "End", "getEnd", "getEnd$annotations", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "Top", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getTop", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getTop$annotations", "Bottom", "getBottom", "getBottom$annotations", "Center", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "getCenter", "()Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "getCenter$annotations", "SpaceEvenly", "getSpaceEvenly", "getSpaceEvenly$annotations", "SpaceBetween", "getSpaceBetween", "getSpaceBetween$annotations", "SpaceAround", "getSpaceAround", "getSpaceAround$annotations", "Absolute", "Horizontal", "HorizontalOrVertical", "SpacedAligned", "Vertical", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Arrangement {
    public static final Arrangement INSTANCE = new Arrangement();
    private static final Horizontal Start = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Start$1
        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i5, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i5, iArr, iArr2, true);
            }
        }

        public String toString() {
            return "Arrangement#Start";
        }
    };
    private static final Horizontal End = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$End$1
        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i5, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i5, iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(iArr, iArr2, true);
            }
        }

        public String toString() {
            return "Arrangement#End";
        }
    };
    private static final Vertical Top = new Vertical() { // from class: androidx.compose.foundation.layout.Arrangement$Top$1
        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i5, int[] iArr, int[] iArr2) {
            Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#Top";
        }
    };
    private static final Vertical Bottom = new Vertical() { // from class: androidx.compose.foundation.layout.Arrangement$Bottom$1
        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i5, int[] iArr, int[] iArr2) {
            Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i5, iArr, iArr2, false);
        }

        public String toString() {
            return "Arrangement#Bottom";
        }
    };
    private static final HorizontalOrVertical Center = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$Center$1
        private final float spacing = Dp.m2599constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i5, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeCenter$foundation_layout_release(i5, iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeCenter$foundation_layout_release(i5, iArr, iArr2, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM, reason: not valid java name and from getter */
        public float getSpacing() {
            return this.spacing;
        }

        public String toString() {
            return "Arrangement#Center";
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i5, int[] iArr, int[] iArr2) {
            Arrangement.INSTANCE.placeCenter$foundation_layout_release(i5, iArr, iArr2, false);
        }
    };
    private static final HorizontalOrVertical SpaceEvenly = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$SpaceEvenly$1
        private final float spacing = Dp.m2599constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i5, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i5, iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i5, iArr, iArr2, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM, reason: from getter */
        public float getSpacing() {
            return this.spacing;
        }

        public String toString() {
            return "Arrangement#SpaceEvenly";
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i5, int[] iArr, int[] iArr2) {
            Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i5, iArr, iArr2, false);
        }
    };
    private static final HorizontalOrVertical SpaceBetween = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$SpaceBetween$1
        private final float spacing = Dp.m2599constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i5, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i5, iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i5, iArr, iArr2, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM, reason: from getter */
        public float getSpacing() {
            return this.spacing;
        }

        public String toString() {
            return "Arrangement#SpaceBetween";
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i5, int[] iArr, int[] iArr2) {
            Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i5, iArr, iArr2, false);
        }
    };
    private static final HorizontalOrVertical SpaceAround = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$SpaceAround$1
        private final float spacing = Dp.m2599constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i5, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeSpaceAround$foundation_layout_release(i5, iArr, iArr2, false);
            } else {
                Arrangement.INSTANCE.placeSpaceAround$foundation_layout_release(i5, iArr, iArr2, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM, reason: from getter */
        public float getSpacing() {
            return this.spacing;
        }

        public String toString() {
            return "Arrangement#SpaceAround";
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i5, int[] iArr, int[] iArr2) {
            Arrangement.INSTANCE.placeSpaceAround$foundation_layout_release(i5, iArr, iArr2, false);
        }
    };

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bR \u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\f\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0011\u0010\u000eR \u0010\u0013\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010\f\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0014\u0010\u000eR \u0010\u0016\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\f\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0017\u0010\u000eR \u0010\u0019\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0019\u0010\f\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001a\u0010\u000eR \u0010\u001c\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001c\u0010\f\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001d\u0010\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Absolute;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/unit/Dp;", "space", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "spacedBy-0680j_4", "(F)Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "spacedBy", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Left", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getLeft", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getLeft$annotations", "Center", "getCenter", "getCenter$annotations", "Right", "getRight", "getRight$annotations", "SpaceBetween", "getSpaceBetween", "getSpaceBetween$annotations", "SpaceEvenly", "getSpaceEvenly", "getSpaceEvenly$annotations", "SpaceAround", "getSpaceAround", "getSpaceAround$annotations", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Absolute {
        public static final Absolute INSTANCE = new Absolute();
        private static final Horizontal Left = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$Left$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i5, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#Left";
            }
        };
        private static final Horizontal Center = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$Center$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i5, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.INSTANCE.placeCenter$foundation_layout_release(i5, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#Center";
            }
        };
        private static final Horizontal Right = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$Right$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i5, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i5, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#Right";
            }
        };
        private static final Horizontal SpaceBetween = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$SpaceBetween$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i5, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i5, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#SpaceBetween";
            }
        };
        private static final Horizontal SpaceEvenly = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$SpaceEvenly$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i5, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i5, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#SpaceEvenly";
            }
        };
        private static final Horizontal SpaceAround = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Absolute$SpaceAround$1
            @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
            public void arrange(Density density, int i5, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
                Arrangement.INSTANCE.placeSpaceAround$foundation_layout_release(i5, iArr, iArr2, false);
            }

            public String toString() {
                return "AbsoluteArrangement#SpaceAround";
            }
        };

        private Absolute() {
        }

        public final Horizontal getLeft() {
            return Left;
        }

        public final Horizontal getRight() {
            return Right;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: spacedBy-0680j_4, reason: not valid java name */
        public final HorizontalOrVertical m266spacedBy0680j_4(float space) {
            return new SpacedAligned(space, false, null, 0 == true ? 1 : 0);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J,\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH&R\u001a\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Horizontal;", BuildConfig.FLAVOR, "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "arrange", BuildConfig.FLAVOR, "Landroidx/compose/ui/unit/Density;", "totalSize", BuildConfig.FLAVOR, "sizes", BuildConfig.FLAVOR, "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outPositions", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Horizontal {
        void arrange(Density density, int i5, int[] iArr, LayoutDirection layoutDirection, int[] iArr2);

        /* renamed from: getSpacing-D9Ej5fM */
        default float getSpacing() {
            return Dp.m2599constructorimpl(0);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u00012\u00020\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface HorizontalOrVertical extends Horizontal, Vertical {
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0081\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u0013\u001a\u00020\u0012*\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0013\u001a\u00020\u0012*\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010$R+\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b&\u0010'R \u0010(\u001a\u00020\u00028\u0016X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b(\u0010\u001f\u001a\u0004\b)\u0010!\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$SpacedAligned;", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "Landroidx/compose/ui/unit/Dp;", "space", BuildConfig.FLAVOR, "rtlMirror", "Lkotlin/Function2;", BuildConfig.FLAVOR, "Landroidx/compose/ui/unit/LayoutDirection;", "alignment", "<init>", "(FZLkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Landroidx/compose/ui/unit/Density;", "totalSize", BuildConfig.FLAVOR, "sizes", "layoutDirection", "outPositions", BuildConfig.FLAVOR, "arrange", "(Landroidx/compose/ui/unit/Density;I[ILandroidx/compose/ui/unit/LayoutDirection;[I)V", "(Landroidx/compose/ui/unit/Density;I[I[I)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", "F", "getSpace-D9Ej5fM", "()F", "Z", "getRtlMirror", "()Z", "Lkotlin/jvm/functions/Function2;", "getAlignment", "()Lkotlin/jvm/functions/Function2;", "spacing", "getSpacing-D9Ej5fM", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* data */ class SpacedAligned implements HorizontalOrVertical {
        private final Function2<Integer, LayoutDirection, Integer> alignment;
        private final boolean rtlMirror;
        private final float space;
        private final float spacing;

        public /* synthetic */ SpacedAligned(float f5, boolean z5, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
            this(f5, z5, function2);
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i5, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
            int i6;
            int i7;
            if (iArr.length == 0) {
                return;
            }
            int mo206roundToPx0680j_4 = density.mo206roundToPx0680j_4(this.space);
            boolean z5 = this.rtlMirror && layoutDirection == LayoutDirection.Rtl;
            Arrangement arrangement = Arrangement.INSTANCE;
            if (!z5) {
                int length = iArr.length;
                int i8 = 0;
                i6 = 0;
                i7 = 0;
                int i9 = 0;
                while (i8 < length) {
                    int i10 = iArr[i8];
                    int min = Math.min(i6, i5 - i10);
                    iArr2[i9] = min;
                    int min2 = Math.min(mo206roundToPx0680j_4, (i5 - min) - i10);
                    int i11 = iArr2[i9] + i10 + min2;
                    i8++;
                    i9++;
                    i7 = min2;
                    i6 = i11;
                }
            } else {
                int length2 = iArr.length - 1;
                i6 = 0;
                i7 = 0;
                while (-1 < length2) {
                    int i12 = iArr[length2];
                    int min3 = Math.min(i6, i5 - i12);
                    iArr2[length2] = min3;
                    int min4 = Math.min(mo206roundToPx0680j_4, (i5 - min3) - i12);
                    int i13 = iArr2[length2] + i12 + min4;
                    length2--;
                    i7 = min4;
                    i6 = i13;
                }
            }
            int i14 = i6 - i7;
            Function2<Integer, LayoutDirection, Integer> function2 = this.alignment;
            if (function2 == null || i14 >= i5) {
                return;
            }
            int intValue = function2.invoke(Integer.valueOf(i5 - i14), layoutDirection).intValue();
            int length3 = iArr2.length;
            for (int i15 = 0; i15 < length3; i15++) {
                iArr2[i15] = iArr2[i15] + intValue;
            }
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SpacedAligned)) {
                return false;
            }
            SpacedAligned spacedAligned = (SpacedAligned) other;
            return Dp.m2601equalsimpl0(this.space, spacedAligned.space) && this.rtlMirror == spacedAligned.rtlMirror && Intrinsics.areEqual(this.alignment, spacedAligned.alignment);
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM, reason: from getter */
        public float getSpacing() {
            return this.spacing;
        }

        public int hashCode() {
            int m2602hashCodeimpl = ((Dp.m2602hashCodeimpl(this.space) * 31) + Boolean.hashCode(this.rtlMirror)) * 31;
            Function2<Integer, LayoutDirection, Integer> function2 = this.alignment;
            return m2602hashCodeimpl + (function2 == null ? 0 : function2.hashCode());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.rtlMirror ? BuildConfig.FLAVOR : "Absolute");
            sb.append("Arrangement#spacedAligned(");
            sb.append((Object) Dp.m2603toStringimpl(this.space));
            sb.append(", ");
            sb.append(this.alignment);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private SpacedAligned(float f5, boolean z5, Function2<? super Integer, ? super LayoutDirection, Integer> function2) {
            this.space = f5;
            this.rtlMirror = z5;
            this.alignment = function2;
            this.spacing = f5;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i5, int[] iArr, int[] iArr2) {
            arrange(density, i5, iArr, LayoutDirection.Ltr, iArr2);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J$\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH&R\u001a\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Vertical;", BuildConfig.FLAVOR, "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "arrange", BuildConfig.FLAVOR, "Landroidx/compose/ui/unit/Density;", "totalSize", BuildConfig.FLAVOR, "sizes", BuildConfig.FLAVOR, "outPositions", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Vertical {
        void arrange(Density density, int i5, int[] iArr, int[] iArr2);

        /* renamed from: getSpacing-D9Ej5fM */
        default float getSpacing() {
            return Dp.m2599constructorimpl(0);
        }
    }

    private Arrangement() {
    }

    public final Vertical getBottom() {
        return Bottom;
    }

    public final HorizontalOrVertical getCenter() {
        return Center;
    }

    public final Horizontal getEnd() {
        return End;
    }

    public final HorizontalOrVertical getSpaceBetween() {
        return SpaceBetween;
    }

    public final Horizontal getStart() {
        return Start;
    }

    public final Vertical getTop() {
        return Top;
    }

    public final void placeCenter$foundation_layout_release(int totalSize, int[] size, int[] outPosition, boolean reverseInput) {
        int i5 = 0;
        int i6 = 0;
        for (int i7 : size) {
            i6 += i7;
        }
        float f5 = (totalSize - i6) / 2;
        if (!reverseInput) {
            int length = size.length;
            int i8 = 0;
            while (i5 < length) {
                int i9 = size[i5];
                outPosition[i8] = Math.round(f5);
                f5 += i9;
                i5++;
                i8++;
            }
            return;
        }
        int length2 = size.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i10 = size[length2];
            outPosition[length2] = Math.round(f5);
            f5 += i10;
        }
    }

    public final void placeLeftOrTop$foundation_layout_release(int[] size, int[] outPosition, boolean reverseInput) {
        int i5 = 0;
        if (!reverseInput) {
            int length = size.length;
            int i6 = 0;
            int i7 = 0;
            while (i5 < length) {
                int i8 = size[i5];
                outPosition[i6] = i7;
                i7 += i8;
                i5++;
                i6++;
            }
            return;
        }
        int length2 = size.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i9 = size[length2];
            outPosition[length2] = i5;
            i5 += i9;
        }
    }

    public final void placeRightOrBottom$foundation_layout_release(int totalSize, int[] size, int[] outPosition, boolean reverseInput) {
        int i5 = 0;
        int i6 = 0;
        for (int i7 : size) {
            i6 += i7;
        }
        int i8 = totalSize - i6;
        if (!reverseInput) {
            int length = size.length;
            int i9 = 0;
            while (i5 < length) {
                int i10 = size[i5];
                outPosition[i9] = i8;
                i8 += i10;
                i5++;
                i9++;
            }
            return;
        }
        int length2 = size.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i11 = size[length2];
            outPosition[length2] = i8;
            i8 += i11;
        }
    }

    public final void placeSpaceAround$foundation_layout_release(int totalSize, int[] size, int[] outPosition, boolean reverseInput) {
        int i5 = 0;
        int i6 = 0;
        for (int i7 : size) {
            i6 += i7;
        }
        float length = !(size.length == 0) ? (totalSize - i6) / size.length : 0.0f;
        float f5 = length / 2;
        if (reverseInput) {
            for (int length2 = size.length - 1; -1 < length2; length2--) {
                int i8 = size[length2];
                outPosition[length2] = Math.round(f5);
                f5 += i8 + length;
            }
            return;
        }
        int length3 = size.length;
        int i9 = 0;
        while (i5 < length3) {
            int i10 = size[i5];
            outPosition[i9] = Math.round(f5);
            f5 += i10 + length;
            i5++;
            i9++;
        }
    }

    public final void placeSpaceBetween$foundation_layout_release(int totalSize, int[] size, int[] outPosition, boolean reverseInput) {
        if (size.length == 0) {
            return;
        }
        int i5 = 0;
        int i6 = 0;
        for (int i7 : size) {
            i6 += i7;
        }
        float max = (totalSize - i6) / Math.max(ArraysKt.getLastIndex(size), 1);
        float f5 = (reverseInput && size.length == 1) ? max : 0.0f;
        if (reverseInput) {
            for (int length = size.length - 1; -1 < length; length--) {
                int i8 = size[length];
                outPosition[length] = Math.round(f5);
                f5 += i8 + max;
            }
            return;
        }
        int length2 = size.length;
        int i9 = 0;
        while (i5 < length2) {
            int i10 = size[i5];
            outPosition[i9] = Math.round(f5);
            f5 += i10 + max;
            i5++;
            i9++;
        }
    }

    public final void placeSpaceEvenly$foundation_layout_release(int totalSize, int[] size, int[] outPosition, boolean reverseInput) {
        int i5 = 0;
        int i6 = 0;
        for (int i7 : size) {
            i6 += i7;
        }
        float length = (totalSize - i6) / (size.length + 1);
        if (reverseInput) {
            float f5 = length;
            for (int length2 = size.length - 1; -1 < length2; length2--) {
                int i8 = size[length2];
                outPosition[length2] = Math.round(f5);
                f5 += i8 + length;
            }
            return;
        }
        int length3 = size.length;
        float f6 = length;
        int i9 = 0;
        while (i5 < length3) {
            int i10 = size[i5];
            outPosition[i9] = Math.round(f6);
            f6 += i10 + length;
            i5++;
            i9++;
        }
    }

    /* renamed from: spacedBy-0680j_4, reason: not valid java name */
    public final HorizontalOrVertical m265spacedBy0680j_4(float space) {
        return new SpacedAligned(space, true, new Function2<Integer, LayoutDirection, Integer>() { // from class: androidx.compose.foundation.layout.Arrangement$spacedBy$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Integer invoke(Integer num, LayoutDirection layoutDirection) {
                return invoke(num.intValue(), layoutDirection);
            }

            public final Integer invoke(int i5, LayoutDirection layoutDirection) {
                return Integer.valueOf(Alignment.INSTANCE.getStart().align(0, i5, layoutDirection));
            }
        }, null);
    }
}
