package androidx.compose.material3.internal;

import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bÁ\u0002\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\u0006J\u0010\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0006¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/internal/MenuPosition;", BuildConfig.FLAVOR, "()V", "bottomToAnchorTop", "Landroidx/compose/material3/internal/MenuPosition$Vertical;", "offset", BuildConfig.FLAVOR, "bottomToWindowBottom", "margin", "centerToAnchorTop", "endToAnchorEnd", "Landroidx/compose/material3/internal/MenuPosition$Horizontal;", "leftToWindowLeft", "rightToWindowRight", "startToAnchorStart", "topToAnchorBottom", "topToWindowTop", "Horizontal", "Vertical", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MenuPosition {
    public static final MenuPosition INSTANCE = new MenuPosition();

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bç\u0080\u0001\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/compose/material3/internal/MenuPosition$Horizontal;", BuildConfig.FLAVOR, "position", BuildConfig.FLAVOR, "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "menuWidth", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "position-95KtPRI", "(Landroidx/compose/ui/unit/IntRect;JILandroidx/compose/ui/unit/LayoutDirection;)I", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Horizontal {
        /* renamed from: position-95KtPRI */
        int mo991position95KtPRI(IntRect anchorBounds, long windowSize, int menuWidth, LayoutDirection layoutDirection);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bç\u0080\u0001\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/material3/internal/MenuPosition$Vertical;", BuildConfig.FLAVOR, "position", BuildConfig.FLAVOR, "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "windowSize", "Landroidx/compose/ui/unit/IntSize;", "menuHeight", "position-JVtK1S4", "(Landroidx/compose/ui/unit/IntRect;JI)I", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Vertical {
        /* renamed from: position-JVtK1S4 */
        int mo992positionJVtK1S4(IntRect anchorBounds, long windowSize, int menuHeight);
    }

    private MenuPosition() {
    }

    public final Vertical bottomToAnchorTop(int offset) {
        Alignment.Companion companion = Alignment.INSTANCE;
        return new androidx.compose.material3.internal.Vertical(companion.getBottom(), companion.getTop(), offset);
    }

    public final Vertical bottomToWindowBottom(int margin) {
        return new androidx.compose.material3.internal.Vertical(Alignment.INSTANCE.getBottom(), margin);
    }

    public final Vertical centerToAnchorTop(int offset) {
        Alignment.Companion companion = Alignment.INSTANCE;
        return new androidx.compose.material3.internal.Vertical(companion.getCenterVertically(), companion.getTop(), offset);
    }

    public final Horizontal endToAnchorEnd(int offset) {
        Alignment.Companion companion = Alignment.INSTANCE;
        return new androidx.compose.material3.internal.Horizontal(companion.getEnd(), companion.getEnd(), offset);
    }

    public final Horizontal leftToWindowLeft(int margin) {
        return new androidx.compose.material3.internal.Horizontal(AbsoluteAlignment.INSTANCE.getLeft(), margin);
    }

    public final Horizontal rightToWindowRight(int margin) {
        return new androidx.compose.material3.internal.Horizontal(AbsoluteAlignment.INSTANCE.getRight(), margin);
    }

    public final Horizontal startToAnchorStart(int offset) {
        Alignment.Companion companion = Alignment.INSTANCE;
        return new androidx.compose.material3.internal.Horizontal(companion.getStart(), companion.getStart(), offset);
    }

    public final Vertical topToAnchorBottom(int offset) {
        Alignment.Companion companion = Alignment.INSTANCE;
        return new androidx.compose.material3.internal.Vertical(companion.getTop(), companion.getBottom(), offset);
    }

    public final Vertical topToWindowTop(int margin) {
        return new androidx.compose.material3.internal.Vertical(Alignment.INSTANCE.getTop(), margin);
    }
}
