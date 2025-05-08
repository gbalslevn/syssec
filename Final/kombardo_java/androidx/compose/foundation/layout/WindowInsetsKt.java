package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0019\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u001c\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0013\u0010\u0010\u001a\u00020\u0000*\u00020\rH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a5\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0018\u001a8\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00192\b\b\u0002\u0010\u0014\u001a\u00020\u00192\b\b\u0002\u0010\u0015\u001a\u00020\u00192\b\b\u0002\u0010\u0016\u001a\u00020\u0019ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsets;", "insets", "union", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/WindowInsets;)Landroidx/compose/foundation/layout/WindowInsets;", "exclude", "add", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "sides", "only-bOOhFvg", "(Landroidx/compose/foundation/layout/WindowInsets;I)Landroidx/compose/foundation/layout/WindowInsets;", "only", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/foundation/layout/PaddingValues;", "asPaddingValues", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/unit/Density;)Landroidx/compose/foundation/layout/PaddingValues;", "asInsets", "(Landroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/foundation/layout/WindowInsets;", BuildConfig.FLAVOR, "left", "top", "right", "bottom", "WindowInsets", "(IIII)Landroidx/compose/foundation/layout/WindowInsets;", "Landroidx/compose/ui/unit/Dp;", "WindowInsets-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/WindowInsets;", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class WindowInsetsKt {
    public static final WindowInsets WindowInsets(int i5, int i6, int i7, int i8) {
        return new Insets(i5, i6, i7, i8);
    }

    /* renamed from: WindowInsets-a9UjIt4, reason: not valid java name */
    public static final WindowInsets m346WindowInsetsa9UjIt4(float f5, float f6, float f7, float f8) {
        return new Insets(f5, f6, f7, f8, null);
    }

    /* renamed from: WindowInsets-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ WindowInsets m347WindowInsetsa9UjIt4$default(float f5, float f6, float f7, float f8, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            f5 = Dp.m2599constructorimpl(0);
        }
        if ((i5 & 2) != 0) {
            f6 = Dp.m2599constructorimpl(0);
        }
        if ((i5 & 4) != 0) {
            f7 = Dp.m2599constructorimpl(0);
        }
        if ((i5 & 8) != 0) {
            f8 = Dp.m2599constructorimpl(0);
        }
        return m346WindowInsetsa9UjIt4(f5, f6, f7, f8);
    }

    public static final WindowInsets add(WindowInsets windowInsets, WindowInsets windowInsets2) {
        return new AddedInsets(windowInsets, windowInsets2);
    }

    public static final WindowInsets asInsets(PaddingValues paddingValues) {
        return new PaddingValues(paddingValues);
    }

    public static final PaddingValues asPaddingValues(WindowInsets windowInsets, Density density) {
        return new InsetsPaddingValues(windowInsets, density);
    }

    public static final WindowInsets exclude(WindowInsets windowInsets, WindowInsets windowInsets2) {
        return new ExcludeInsets(windowInsets, windowInsets2);
    }

    /* renamed from: only-bOOhFvg, reason: not valid java name */
    public static final WindowInsets m348onlybOOhFvg(WindowInsets windowInsets, int i5) {
        return new LimitInsets(windowInsets, i5, null);
    }

    public static final WindowInsets union(WindowInsets windowInsets, WindowInsets windowInsets2) {
        return new UnionInsets(windowInsets, windowInsets2);
    }
}
