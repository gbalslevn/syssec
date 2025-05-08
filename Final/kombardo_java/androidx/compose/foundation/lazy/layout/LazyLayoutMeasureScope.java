package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000e\u001a\u00020\u000b*\u00020\u0002H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u0082\u0001\u0001\u000fø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", BuildConfig.FLAVOR, "index", "Landroidx/compose/ui/unit/Constraints;", "constraints", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/Placeable;", "measure-0kLqBqw", "(IJ)Ljava/util/List;", "measure", "Landroidx/compose/ui/unit/Dp;", "toDp-u2uoSUM", "(I)F", "toDp", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScopeImpl;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface LazyLayoutMeasureScope extends MeasureScope {
    /* renamed from: measure-0kLqBqw, reason: not valid java name */
    List<Placeable> mo422measure0kLqBqw(int index, long constraints);

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    float mo209toDpu2uoSUM(int i5);
}
