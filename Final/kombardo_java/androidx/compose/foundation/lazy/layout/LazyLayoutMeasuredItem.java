package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\b`\u0018\u00002\u00020\u0001J\u001d\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00018&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012R\u0014\u0010\u001c\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0012R\u001c\u0010 \u001a\u00020\u00168&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001fR\u001a\u0010$\u001a\u00020!8&X¦\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0012R\u0014\u0010(\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0012ø\u0001\u0002\u0082\u0002\u0011\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006)À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "index", "Landroidx/compose/ui/unit/IntOffset;", "getOffset-Bjo55l4", "(I)J", "getOffset", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", BuildConfig.FLAVOR, "position", "(IIII)V", "getParentData", "(I)Ljava/lang/Object;", "getIndex", "()I", "getKey", "()Ljava/lang/Object;", "key", BuildConfig.FLAVOR, "isVertical", "()Z", "getMainAxisSizeWithSpacings", "mainAxisSizeWithSpacings", "getPlaceablesCount", "placeablesCount", "getNonScrollableItem", "setNonScrollableItem", "(Z)V", "nonScrollableItem", "Landroidx/compose/ui/unit/Constraints;", "getConstraints-msEJaDk", "()J", "constraints", "getLane", "lane", "getSpan", "span", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface LazyLayoutMeasuredItem {
    /* renamed from: getConstraints-msEJaDk */
    long mo372getConstraintsmsEJaDk();

    int getIndex();

    Object getKey();

    int getLane();

    int getMainAxisSizeWithSpacings();

    /* renamed from: getOffset-Bjo55l4 */
    long mo373getOffsetBjo55l4(int index);

    Object getParentData(int index);

    int getPlaceablesCount();

    int getSpan();

    boolean isVertical();

    void position(int mainAxisOffset, int crossAxisOffset, int layoutWidth, int layoutHeight);

    void setNonScrollableItem(boolean z5);
}
