package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import java.util.List;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\n\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\f\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\r\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\u000e\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\u000f\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\u0010\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J$\u0010\u0011\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/layout/IntrinsicMeasureBlocks;", BuildConfig.FLAVOR, "()V", "HorizontalMaxHeight", BuildConfig.FLAVOR, "measurables", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "availableWidth", "mainAxisSpacing", "HorizontalMaxWidth", "availableHeight", "HorizontalMinHeight", "HorizontalMinWidth", "VerticalMaxHeight", "VerticalMaxWidth", "VerticalMinHeight", "VerticalMinWidth", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IntrinsicMeasureBlocks {
    public static final IntrinsicMeasureBlocks INSTANCE = new IntrinsicMeasureBlocks();

    private IntrinsicMeasureBlocks() {
    }

    public final int HorizontalMaxHeight(List<? extends IntrinsicMeasurable> measurables, int availableWidth, int mainAxisSpacing) {
        if (measurables.isEmpty()) {
            return 0;
        }
        int min = Math.min((measurables.size() - 1) * mainAxisSpacing, availableWidth);
        int size = measurables.size();
        int i5 = 0;
        float f5 = 0.0f;
        for (int i6 = 0; i6 < size; i6++) {
            IntrinsicMeasurable intrinsicMeasurable = measurables.get(i6);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            if (weight == 0.0f) {
                int min2 = Math.min(intrinsicMeasurable.maxIntrinsicWidth(Integer.MAX_VALUE), availableWidth == Integer.MAX_VALUE ? Integer.MAX_VALUE : availableWidth - min);
                min += min2;
                i5 = Math.max(i5, intrinsicMeasurable.maxIntrinsicHeight(min2));
            } else if (weight > 0.0f) {
                f5 += weight;
            }
        }
        int round = f5 == 0.0f ? 0 : availableWidth == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(Math.max(availableWidth - min, 0) / f5);
        int size2 = measurables.size();
        for (int i7 = 0; i7 < size2; i7++) {
            IntrinsicMeasurable intrinsicMeasurable2 = measurables.get(i7);
            float weight2 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable2));
            if (weight2 > 0.0f) {
                i5 = Math.max(i5, intrinsicMeasurable2.maxIntrinsicHeight(round != Integer.MAX_VALUE ? Math.round(round * weight2) : Integer.MAX_VALUE));
            }
        }
        return i5;
    }

    public final int HorizontalMaxWidth(List<? extends IntrinsicMeasurable> measurables, int availableHeight, int mainAxisSpacing) {
        if (measurables.isEmpty()) {
            return 0;
        }
        int size = measurables.size();
        int i5 = 0;
        int i6 = 0;
        float f5 = 0.0f;
        for (int i7 = 0; i7 < size; i7++) {
            IntrinsicMeasurable intrinsicMeasurable = measurables.get(i7);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            int maxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(availableHeight);
            if (weight == 0.0f) {
                i6 += maxIntrinsicWidth;
            } else if (weight > 0.0f) {
                f5 += weight;
                i5 = Math.max(i5, Math.round(maxIntrinsicWidth / weight));
            }
        }
        return Math.round(i5 * f5) + i6 + ((measurables.size() - 1) * mainAxisSpacing);
    }

    public final int HorizontalMinHeight(List<? extends IntrinsicMeasurable> measurables, int availableWidth, int mainAxisSpacing) {
        if (measurables.isEmpty()) {
            return 0;
        }
        int min = Math.min((measurables.size() - 1) * mainAxisSpacing, availableWidth);
        int size = measurables.size();
        int i5 = 0;
        float f5 = 0.0f;
        for (int i6 = 0; i6 < size; i6++) {
            IntrinsicMeasurable intrinsicMeasurable = measurables.get(i6);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            if (weight == 0.0f) {
                int min2 = Math.min(intrinsicMeasurable.maxIntrinsicWidth(Integer.MAX_VALUE), availableWidth == Integer.MAX_VALUE ? Integer.MAX_VALUE : availableWidth - min);
                min += min2;
                i5 = Math.max(i5, intrinsicMeasurable.minIntrinsicHeight(min2));
            } else if (weight > 0.0f) {
                f5 += weight;
            }
        }
        int round = f5 == 0.0f ? 0 : availableWidth == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(Math.max(availableWidth - min, 0) / f5);
        int size2 = measurables.size();
        for (int i7 = 0; i7 < size2; i7++) {
            IntrinsicMeasurable intrinsicMeasurable2 = measurables.get(i7);
            float weight2 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable2));
            if (weight2 > 0.0f) {
                i5 = Math.max(i5, intrinsicMeasurable2.minIntrinsicHeight(round != Integer.MAX_VALUE ? Math.round(round * weight2) : Integer.MAX_VALUE));
            }
        }
        return i5;
    }

    public final int HorizontalMinWidth(List<? extends IntrinsicMeasurable> measurables, int availableHeight, int mainAxisSpacing) {
        if (measurables.isEmpty()) {
            return 0;
        }
        int size = measurables.size();
        int i5 = 0;
        int i6 = 0;
        float f5 = 0.0f;
        for (int i7 = 0; i7 < size; i7++) {
            IntrinsicMeasurable intrinsicMeasurable = measurables.get(i7);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            int minIntrinsicWidth = intrinsicMeasurable.minIntrinsicWidth(availableHeight);
            if (weight == 0.0f) {
                i6 += minIntrinsicWidth;
            } else if (weight > 0.0f) {
                f5 += weight;
                i5 = Math.max(i5, Math.round(minIntrinsicWidth / weight));
            }
        }
        return Math.round(i5 * f5) + i6 + ((measurables.size() - 1) * mainAxisSpacing);
    }

    public final int VerticalMaxHeight(List<? extends IntrinsicMeasurable> measurables, int availableWidth, int mainAxisSpacing) {
        if (measurables.isEmpty()) {
            return 0;
        }
        int size = measurables.size();
        int i5 = 0;
        int i6 = 0;
        float f5 = 0.0f;
        for (int i7 = 0; i7 < size; i7++) {
            IntrinsicMeasurable intrinsicMeasurable = measurables.get(i7);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            int maxIntrinsicHeight = intrinsicMeasurable.maxIntrinsicHeight(availableWidth);
            if (weight == 0.0f) {
                i6 += maxIntrinsicHeight;
            } else if (weight > 0.0f) {
                f5 += weight;
                i5 = Math.max(i5, Math.round(maxIntrinsicHeight / weight));
            }
        }
        return Math.round(i5 * f5) + i6 + ((measurables.size() - 1) * mainAxisSpacing);
    }

    public final int VerticalMaxWidth(List<? extends IntrinsicMeasurable> measurables, int availableHeight, int mainAxisSpacing) {
        if (measurables.isEmpty()) {
            return 0;
        }
        int min = Math.min((measurables.size() - 1) * mainAxisSpacing, availableHeight);
        int size = measurables.size();
        int i5 = 0;
        float f5 = 0.0f;
        for (int i6 = 0; i6 < size; i6++) {
            IntrinsicMeasurable intrinsicMeasurable = measurables.get(i6);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            if (weight == 0.0f) {
                int min2 = Math.min(intrinsicMeasurable.maxIntrinsicHeight(Integer.MAX_VALUE), availableHeight == Integer.MAX_VALUE ? Integer.MAX_VALUE : availableHeight - min);
                min += min2;
                i5 = Math.max(i5, intrinsicMeasurable.maxIntrinsicWidth(min2));
            } else if (weight > 0.0f) {
                f5 += weight;
            }
        }
        int round = f5 == 0.0f ? 0 : availableHeight == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(Math.max(availableHeight - min, 0) / f5);
        int size2 = measurables.size();
        for (int i7 = 0; i7 < size2; i7++) {
            IntrinsicMeasurable intrinsicMeasurable2 = measurables.get(i7);
            float weight2 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable2));
            if (weight2 > 0.0f) {
                i5 = Math.max(i5, intrinsicMeasurable2.maxIntrinsicWidth(round != Integer.MAX_VALUE ? Math.round(round * weight2) : Integer.MAX_VALUE));
            }
        }
        return i5;
    }

    public final int VerticalMinHeight(List<? extends IntrinsicMeasurable> measurables, int availableWidth, int mainAxisSpacing) {
        if (measurables.isEmpty()) {
            return 0;
        }
        int size = measurables.size();
        int i5 = 0;
        int i6 = 0;
        float f5 = 0.0f;
        for (int i7 = 0; i7 < size; i7++) {
            IntrinsicMeasurable intrinsicMeasurable = measurables.get(i7);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            int minIntrinsicHeight = intrinsicMeasurable.minIntrinsicHeight(availableWidth);
            if (weight == 0.0f) {
                i6 += minIntrinsicHeight;
            } else if (weight > 0.0f) {
                f5 += weight;
                i5 = Math.max(i5, Math.round(minIntrinsicHeight / weight));
            }
        }
        return Math.round(i5 * f5) + i6 + ((measurables.size() - 1) * mainAxisSpacing);
    }

    public final int VerticalMinWidth(List<? extends IntrinsicMeasurable> measurables, int availableHeight, int mainAxisSpacing) {
        if (measurables.isEmpty()) {
            return 0;
        }
        int min = Math.min((measurables.size() - 1) * mainAxisSpacing, availableHeight);
        int size = measurables.size();
        int i5 = 0;
        float f5 = 0.0f;
        for (int i6 = 0; i6 < size; i6++) {
            IntrinsicMeasurable intrinsicMeasurable = measurables.get(i6);
            float weight = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable));
            if (weight == 0.0f) {
                int min2 = Math.min(intrinsicMeasurable.maxIntrinsicHeight(Integer.MAX_VALUE), availableHeight == Integer.MAX_VALUE ? Integer.MAX_VALUE : availableHeight - min);
                min += min2;
                i5 = Math.max(i5, intrinsicMeasurable.minIntrinsicWidth(min2));
            } else if (weight > 0.0f) {
                f5 += weight;
            }
        }
        int round = f5 == 0.0f ? 0 : availableHeight == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.round(Math.max(availableHeight - min, 0) / f5);
        int size2 = measurables.size();
        for (int i7 = 0; i7 < size2; i7++) {
            IntrinsicMeasurable intrinsicMeasurable2 = measurables.get(i7);
            float weight2 = RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(intrinsicMeasurable2));
            if (weight2 > 0.0f) {
                i5 = Math.max(i5, intrinsicMeasurable2.minIntrinsicWidth(round != Integer.MAX_VALUE ? Math.round(round * weight2) : Integer.MAX_VALUE));
            }
        }
        return i5;
    }
}
