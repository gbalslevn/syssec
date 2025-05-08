package androidx.compose.material3.internal;

import androidx.compose.material3.MenuKt;
import androidx.compose.material3.internal.MenuPosition;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0081\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0004\b\f\u0010\rJ2\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010(\u001a\u0004\b)\u0010\u001cR)\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0006¢\u0006\f\n\u0004\b\u000b\u0010*\u001a\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010/R\u0014\u00101\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010/R\u0014\u00102\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010/R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00105R\u0014\u00107\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00105R\u0014\u00108\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00105R\u0014\u00109\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00105\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006:"}, d2 = {"Landroidx/compose/material3/internal/DropdownMenuPositionProvider;", "Landroidx/compose/ui/window/PopupPositionProvider;", "Landroidx/compose/ui/unit/DpOffset;", "contentOffset", "Landroidx/compose/ui/unit/Density;", "density", BuildConfig.FLAVOR, "verticalMargin", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntRect;", BuildConfig.FLAVOR, "onPositionCalculated", "<init>", "(JLandroidx/compose/ui/unit/Density;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "anchorBounds", "Landroidx/compose/ui/unit/IntSize;", "windowSize", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "popupContentSize", "Landroidx/compose/ui/unit/IntOffset;", "calculatePosition-llwVHH4", "(Landroidx/compose/ui/unit/IntRect;JLandroidx/compose/ui/unit/LayoutDirection;J)J", "calculatePosition", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "J", "getContentOffset-RKDOV3M", "()J", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "I", "getVerticalMargin", "Lkotlin/jvm/functions/Function2;", "getOnPositionCalculated", "()Lkotlin/jvm/functions/Function2;", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "startToAnchorStart", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "endToAnchorEnd", "leftToWindowLeft", "rightToWindowRight", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "topToAnchorBottom", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "bottomToAnchorTop", "centerToAnchorTop", "topToWindowTop", "bottomToWindowBottom", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DropdownMenuPositionProvider implements PopupPositionProvider {
    private final MenuPosition.Vertical bottomToAnchorTop;
    private final MenuPosition.Vertical bottomToWindowBottom;
    private final MenuPosition.Vertical centerToAnchorTop;
    private final long contentOffset;
    private final Density density;
    private final MenuPosition.Horizontal endToAnchorEnd;
    private final MenuPosition.Horizontal leftToWindowLeft;
    private final Function2<IntRect, IntRect, Unit> onPositionCalculated;
    private final MenuPosition.Horizontal rightToWindowRight;
    private final MenuPosition.Horizontal startToAnchorStart;
    private final MenuPosition.Vertical topToAnchorBottom;
    private final MenuPosition.Vertical topToWindowTop;
    private final int verticalMargin;

    public /* synthetic */ DropdownMenuPositionProvider(long j5, Density density, int i5, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, density, i5, function2);
    }

    @Override // androidx.compose.ui.window.PopupPositionProvider
    /* renamed from: calculatePosition-llwVHH4 */
    public long mo155calculatePositionllwVHH4(IntRect anchorBounds, long windowSize, LayoutDirection layoutDirection, long popupContentSize) {
        int i5;
        int i6 = 0;
        List listOf = CollectionsKt.listOf((Object[]) new MenuPosition.Horizontal[]{this.startToAnchorStart, this.endToAnchorEnd, IntOffset.m2640getXimpl(anchorBounds.m2652getCenternOccac()) < IntSize.m2661getWidthimpl(windowSize) / 2 ? this.leftToWindowLeft : this.rightToWindowRight});
        int size = listOf.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size) {
                i5 = 0;
                break;
            }
            i5 = ((MenuPosition.Horizontal) listOf.get(i7)).mo991position95KtPRI(anchorBounds, windowSize, IntSize.m2661getWidthimpl(popupContentSize), layoutDirection);
            if (i7 == CollectionsKt.getLastIndex(listOf) || (i5 >= 0 && IntSize.m2661getWidthimpl(popupContentSize) + i5 <= IntSize.m2661getWidthimpl(windowSize))) {
                break;
            }
            i7++;
        }
        List listOf2 = CollectionsKt.listOf((Object[]) new MenuPosition.Vertical[]{this.topToAnchorBottom, this.bottomToAnchorTop, this.centerToAnchorTop, IntOffset.m2641getYimpl(anchorBounds.m2652getCenternOccac()) < IntSize.m2660getHeightimpl(windowSize) / 2 ? this.topToWindowTop : this.bottomToWindowBottom});
        int size2 = listOf2.size();
        for (int i8 = 0; i8 < size2; i8++) {
            int mo992positionJVtK1S4 = ((MenuPosition.Vertical) listOf2.get(i8)).mo992positionJVtK1S4(anchorBounds, windowSize, IntSize.m2660getHeightimpl(popupContentSize));
            if (i8 == CollectionsKt.getLastIndex(listOf2) || (mo992positionJVtK1S4 >= this.verticalMargin && IntSize.m2660getHeightimpl(popupContentSize) + mo992positionJVtK1S4 <= IntSize.m2660getHeightimpl(windowSize) - this.verticalMargin)) {
                i6 = mo992positionJVtK1S4;
                break;
            }
        }
        long IntOffset = IntOffsetKt.IntOffset(i5, i6);
        this.onPositionCalculated.invoke(anchorBounds, IntRectKt.m2655IntRectVbeCjmY(IntOffset, popupContentSize));
        return IntOffset;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DropdownMenuPositionProvider)) {
            return false;
        }
        DropdownMenuPositionProvider dropdownMenuPositionProvider = (DropdownMenuPositionProvider) other;
        return DpOffset.m2615equalsimpl0(this.contentOffset, dropdownMenuPositionProvider.contentOffset) && Intrinsics.areEqual(this.density, dropdownMenuPositionProvider.density) && this.verticalMargin == dropdownMenuPositionProvider.verticalMargin && Intrinsics.areEqual(this.onPositionCalculated, dropdownMenuPositionProvider.onPositionCalculated);
    }

    public int hashCode() {
        return (((((DpOffset.m2618hashCodeimpl(this.contentOffset) * 31) + this.density.hashCode()) * 31) + Integer.hashCode(this.verticalMargin)) * 31) + this.onPositionCalculated.hashCode();
    }

    public String toString() {
        return "DropdownMenuPositionProvider(contentOffset=" + ((Object) DpOffset.m2619toStringimpl(this.contentOffset)) + ", density=" + this.density + ", verticalMargin=" + this.verticalMargin + ", onPositionCalculated=" + this.onPositionCalculated + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DropdownMenuPositionProvider(long j5, Density density, int i5, Function2<? super IntRect, ? super IntRect, Unit> function2) {
        this.contentOffset = j5;
        this.density = density;
        this.verticalMargin = i5;
        this.onPositionCalculated = function2;
        int mo206roundToPx0680j_4 = density.mo206roundToPx0680j_4(DpOffset.m2616getXD9Ej5fM(j5));
        MenuPosition menuPosition = MenuPosition.INSTANCE;
        this.startToAnchorStart = menuPosition.startToAnchorStart(mo206roundToPx0680j_4);
        this.endToAnchorEnd = menuPosition.endToAnchorEnd(mo206roundToPx0680j_4);
        this.leftToWindowLeft = menuPosition.leftToWindowLeft(0);
        this.rightToWindowRight = menuPosition.rightToWindowRight(0);
        int mo206roundToPx0680j_42 = density.mo206roundToPx0680j_4(DpOffset.m2617getYD9Ej5fM(j5));
        this.topToAnchorBottom = menuPosition.topToAnchorBottom(mo206roundToPx0680j_42);
        this.bottomToAnchorTop = menuPosition.bottomToAnchorTop(mo206roundToPx0680j_42);
        this.centerToAnchorTop = menuPosition.centerToAnchorTop(mo206roundToPx0680j_42);
        this.topToWindowTop = menuPosition.topToWindowTop(i5);
        this.bottomToWindowBottom = menuPosition.bottomToWindowBottom(i5);
    }

    public /* synthetic */ DropdownMenuPositionProvider(long j5, Density density, int i5, Function2 function2, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, density, (i6 & 4) != 0 ? density.mo206roundToPx0680j_4(MenuKt.getMenuVerticalMargin()) : i5, (i6 & 8) != 0 ? new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material3.internal.DropdownMenuPositionProvider.2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IntRect intRect, IntRect intRect2) {
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                invoke2(intRect, intRect2);
                return Unit.INSTANCE;
            }
        } : function2, null);
    }
}
