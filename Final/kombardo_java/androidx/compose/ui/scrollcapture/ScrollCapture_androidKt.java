package androidx.compose.ui.scrollcapture;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.platform.SemanticsUtils_androidKt;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a5\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u0019\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\n*\u00020\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\f\"6\u0010\u0013\u001a \b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\r*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u0018\u0010\u0017\u001a\u00020\u0014*\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsNode;", "fromNode", BuildConfig.FLAVOR, "depth", "Lkotlin/Function1;", "Landroidx/compose/ui/scrollcapture/ScrollCaptureCandidate;", BuildConfig.FLAVOR, "onCandidate", "visitScrollCaptureCandidates", "(Landroidx/compose/ui/semantics/SemanticsNode;ILkotlin/jvm/functions/Function1;)V", BuildConfig.FLAVOR, "getChildrenForSearch", "(Landroidx/compose/ui/semantics/SemanticsNode;)Ljava/util/List;", "Lkotlin/Function2;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "getScrollCaptureScrollByAction", "(Landroidx/compose/ui/semantics/SemanticsNode;)Lkotlin/jvm/functions/Function2;", "scrollCaptureScrollByAction", BuildConfig.FLAVOR, "getCanScrollVertically", "(Landroidx/compose/ui/semantics/SemanticsNode;)Z", "canScrollVertically", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ScrollCapture_androidKt {
    private static final boolean getCanScrollVertically(SemanticsNode semanticsNode) {
        Function2<Offset, Continuation<? super Offset>, Object> scrollCaptureScrollByAction = getScrollCaptureScrollByAction(semanticsNode);
        ScrollAxisRange scrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
        return (scrollCaptureScrollByAction == null || scrollAxisRange == null || scrollAxisRange.getMaxValue().invoke().floatValue() <= 0.0f) ? false : true;
    }

    private static final List<SemanticsNode> getChildrenForSearch(SemanticsNode semanticsNode) {
        return semanticsNode.getChildren$ui_release(false, false, false);
    }

    public static final Function2<Offset, Continuation<? super Offset>, Object> getScrollCaptureScrollByAction(SemanticsNode semanticsNode) {
        return (Function2) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getScrollByOffset());
    }

    private static final void visitScrollCaptureCandidates(SemanticsNode semanticsNode, int i5, Function1<? super ScrollCaptureCandidate, Unit> function1) {
        SemanticsNode semanticsNode2;
        MutableVector mutableVector = new MutableVector(new SemanticsNode[16], 0);
        List<SemanticsNode> childrenForSearch = getChildrenForSearch(semanticsNode);
        while (true) {
            mutableVector.addAll(mutableVector.getSize(), (List) childrenForSearch);
            while (mutableVector.isNotEmpty()) {
                semanticsNode2 = (SemanticsNode) mutableVector.removeAt(mutableVector.getSize() - 1);
                if (SemanticsUtils_androidKt.isVisible(semanticsNode2) && !semanticsNode2.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getDisabled())) {
                    NodeCoordinator findCoordinatorToGetBounds$ui_release = semanticsNode2.findCoordinatorToGetBounds$ui_release();
                    if (findCoordinatorToGetBounds$ui_release == null) {
                        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Expected semantics node to have a coordinator.");
                        throw new KotlinNothingValueException();
                    }
                    LayoutCoordinates coordinates = findCoordinatorToGetBounds$ui_release.getCoordinates();
                    IntRect roundToIntRect = IntRectKt.roundToIntRect(LayoutCoordinatesKt.boundsInWindow(coordinates));
                    if (roundToIntRect.isEmpty()) {
                        continue;
                    } else {
                        if (!getCanScrollVertically(semanticsNode2)) {
                            break;
                        }
                        int i6 = i5 + 1;
                        function1.invoke(new ScrollCaptureCandidate(semanticsNode2, i6, roundToIntRect, coordinates));
                        visitScrollCaptureCandidates(semanticsNode2, i6, function1);
                    }
                }
            }
            return;
            childrenForSearch = getChildrenForSearch(semanticsNode2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void visitScrollCaptureCandidates$default(SemanticsNode semanticsNode, int i5, Function1 function1, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        visitScrollCaptureCandidates(semanticsNode, i5, function1);
    }
}
