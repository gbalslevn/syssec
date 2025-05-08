package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006\"\u001a\u0010\n\u001a\u00020\u0007*\u0004\u0018\u00010\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u001a\u0010\u000e\u001a\u00020\u000b*\u0004\u0018\u00010\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000f*\u0004\u0018\u00010\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"\u001a\u0010\u0013\u001a\u00020\u000b*\u0004\u0018\u00010\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\r¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/layout/IntrinsicMeasurable;", "Landroidx/compose/foundation/layout/RowColumnParentData;", "getRowColumnParentData", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Landroidx/compose/foundation/layout/RowColumnParentData;", "rowColumnParentData", "Landroidx/compose/ui/layout/Placeable;", "(Landroidx/compose/ui/layout/Placeable;)Landroidx/compose/foundation/layout/RowColumnParentData;", BuildConfig.FLAVOR, "getWeight", "(Landroidx/compose/foundation/layout/RowColumnParentData;)F", "weight", BuildConfig.FLAVOR, "getFill", "(Landroidx/compose/foundation/layout/RowColumnParentData;)Z", "fill", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCrossAxisAlignment", "(Landroidx/compose/foundation/layout/RowColumnParentData;)Landroidx/compose/foundation/layout/CrossAxisAlignment;", "crossAxisAlignment", "isRelative", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class RowColumnImplKt {
    public static final CrossAxisAlignment getCrossAxisAlignment(RowColumnParentData rowColumnParentData) {
        if (rowColumnParentData != null) {
            return rowColumnParentData.getCrossAxisAlignment();
        }
        return null;
    }

    public static final boolean getFill(RowColumnParentData rowColumnParentData) {
        if (rowColumnParentData != null) {
            return rowColumnParentData.getFill();
        }
        return true;
    }

    public static final RowColumnParentData getRowColumnParentData(IntrinsicMeasurable intrinsicMeasurable) {
        Object parentData = intrinsicMeasurable.getParentData();
        if (parentData instanceof RowColumnParentData) {
            return (RowColumnParentData) parentData;
        }
        return null;
    }

    public static final float getWeight(RowColumnParentData rowColumnParentData) {
        if (rowColumnParentData != null) {
            return rowColumnParentData.getWeight();
        }
        return 0.0f;
    }

    public static final boolean isRelative(RowColumnParentData rowColumnParentData) {
        CrossAxisAlignment crossAxisAlignment = getCrossAxisAlignment(rowColumnParentData);
        if (crossAxisAlignment != null) {
            return crossAxisAlignment.isRelative$foundation_layout_release();
        }
        return false;
    }

    public static final RowColumnParentData getRowColumnParentData(Placeable placeable) {
        Object parentData = placeable.getParentData();
        if (parentData instanceof RowColumnParentData) {
            return (RowColumnParentData) parentData;
        }
        return null;
    }
}
