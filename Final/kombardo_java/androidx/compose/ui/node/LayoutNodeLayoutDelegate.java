package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u001c\b\u0000\u0018\u00002\u00020\u0001:\u0002ghB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010R\u001a\u00020MH\u0000¢\u0006\u0002\bSJ\u0006\u0010T\u001a\u00020MJ\u0006\u0010U\u001a\u00020MJ\r\u0010V\u001a\u00020MH\u0000¢\u0006\u0002\bWJ\r\u0010X\u001a\u00020MH\u0000¢\u0006\u0002\bYJ\r\u0010Z\u001a\u00020MH\u0000¢\u0006\u0002\b[J\r\u0010\\\u001a\u00020MH\u0000¢\u0006\u0002\b]J\u0006\u0010^\u001a\u00020MJ\u001a\u0010_\u001a\u00020M2\u0006\u0010`\u001a\u00020\"H\u0002ø\u0001\u0000¢\u0006\u0004\ba\u0010bJ\u001a\u0010c\u001a\u00020M2\u0006\u0010`\u001a\u00020\"H\u0002ø\u0001\u0000¢\u0006\u0004\bd\u0010bJ\u0006\u0010e\u001a\u00020MJ\u0006\u0010f\u001a\u00020MR\u0014\u0010\u0005\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0014\u0010\u001f\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b \u0010\rR\u0019\u0010!\u001a\u0004\u0018\u00010\"8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0019\u0010%\u001a\u0004\u0018\u00010\"8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b&\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010'\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0016R\u000e\u0010)\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u00020*2\u0006\u0010\u001c\u001a\u00020*@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010.\u001a\u0004\u0018\u00010\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\bR$\u00100\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0016\"\u0004\b2\u0010\u0018R$\u00103\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0016\"\u0004\b5\u0010\u0018R\u001e\u00106\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0016R\u000e\u00108\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00109\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0016R*\u0010<\u001a\b\u0018\u00010;R\u00020\u00002\f\u0010\u001c\u001a\b\u0018\u00010;R\u00020\u0000@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0018\u0010?\u001a\u00060@R\u00020\u0000X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u001e\u0010C\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0013@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0016R\u000e\u0010E\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010G\u001a\u00020H8F¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0014\u0010K\u001a\b\u0012\u0004\u0012\u00020M0LX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010N\u001a\u00020\"X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010OR\u0014\u0010P\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006i"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", BuildConfig.FLAVOR, "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner$ui_release", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "value", BuildConfig.FLAVOR, "childrenAccessingCoordinatesDuringPlacement", "getChildrenAccessingCoordinatesDuringPlacement", "()I", "setChildrenAccessingCoordinatesDuringPlacement", "(I)V", "childrenAccessingLookaheadCoordinatesDuringPlacement", "getChildrenAccessingLookaheadCoordinatesDuringPlacement", "setChildrenAccessingLookaheadCoordinatesDuringPlacement", BuildConfig.FLAVOR, "coordinatesAccessedDuringModifierPlacement", "getCoordinatesAccessedDuringModifierPlacement", "()Z", "setCoordinatesAccessedDuringModifierPlacement", "(Z)V", "coordinatesAccessedDuringPlacement", "getCoordinatesAccessedDuringPlacement", "setCoordinatesAccessedDuringPlacement", "<set-?>", "detachedFromParentLookaheadPass", "getDetachedFromParentLookaheadPass$ui_release", "height", "getHeight$ui_release", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastLookaheadConstraints", "getLastLookaheadConstraints-DWUhwKw", "layoutPending", "getLayoutPending$ui_release", "layoutPendingForAlignment", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "layoutState", "getLayoutState$ui_release", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "lookaheadAlignmentLinesOwner", "getLookaheadAlignmentLinesOwner$ui_release", "lookaheadCoordinatesAccessedDuringModifierPlacement", "getLookaheadCoordinatesAccessedDuringModifierPlacement", "setLookaheadCoordinatesAccessedDuringModifierPlacement", "lookaheadCoordinatesAccessedDuringPlacement", "getLookaheadCoordinatesAccessedDuringPlacement", "setLookaheadCoordinatesAccessedDuringPlacement", "lookaheadLayoutPending", "getLookaheadLayoutPending$ui_release", "lookaheadLayoutPendingForAlignment", "lookaheadMeasurePending", "getLookaheadMeasurePending$ui_release", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "lookaheadPassDelegate", "getLookaheadPassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "measurePassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "getMeasurePassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "measurePending", "getMeasurePending$ui_release", "nextChildLookaheadPlaceOrder", "nextChildPlaceOrder", "outerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "getOuterCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "performMeasureBlock", "Lkotlin/Function0;", BuildConfig.FLAVOR, "performMeasureConstraints", "J", "width", "getWidth$ui_release", "ensureLookaheadDelegateCreated", "ensureLookaheadDelegateCreated$ui_release", "invalidateParentData", "markChildrenDirty", "markLayoutPending", "markLayoutPending$ui_release", "markLookaheadLayoutPending", "markLookaheadLayoutPending$ui_release", "markLookaheadMeasurePending", "markLookaheadMeasurePending$ui_release", "markMeasurePending", "markMeasurePending$ui_release", "onCoordinatesUsed", "performLookaheadMeasure", "constraints", "performLookaheadMeasure-BRTryo0", "(J)V", "performMeasure", "performMeasure-BRTryo0", "resetAlignmentLines", "updateParentData", "LookaheadPassDelegate", "MeasurePassDelegate", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayoutNodeLayoutDelegate {
    private int childrenAccessingCoordinatesDuringPlacement;
    private int childrenAccessingLookaheadCoordinatesDuringPlacement;
    private boolean coordinatesAccessedDuringModifierPlacement;
    private boolean coordinatesAccessedDuringPlacement;
    private boolean detachedFromParentLookaheadPass;
    private final LayoutNode layoutNode;
    private boolean layoutPending;
    private boolean layoutPendingForAlignment;
    private boolean lookaheadCoordinatesAccessedDuringModifierPlacement;
    private boolean lookaheadCoordinatesAccessedDuringPlacement;
    private boolean lookaheadLayoutPending;
    private boolean lookaheadLayoutPendingForAlignment;
    private boolean lookaheadMeasurePending;
    private LookaheadPassDelegate lookaheadPassDelegate;
    private boolean measurePending;
    private int nextChildLookaheadPlaceOrder;
    private int nextChildPlaceOrder;
    private LayoutNode.LayoutState layoutState = LayoutNode.LayoutState.Idle;
    private final MeasurePassDelegate measurePassDelegate = new MeasurePassDelegate();
    private long performMeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
    private final Function0<Unit> performMeasureBlock = new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasureBlock$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            long j5;
            NodeCoordinator outerCoordinator = LayoutNodeLayoutDelegate.this.getOuterCoordinator();
            j5 = LayoutNodeLayoutDelegate.this.performMeasureConstraints;
            outerCoordinator.mo1946measureBRTryo0(j5);
        }
    };

    @Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJB\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001b\u0010\tJ\u000f\u0010\u001c\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\tJ\u000f\u0010\u001d\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001d\u0010\tJ\u000f\u0010\u001e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\tJ\u000f\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010\tJ\u001b\u0010#\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 H\u0016¢\u0006\u0004\b#\u0010$J#\u0010&\u001a\u00020\u00072\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0013H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0007H\u0016¢\u0006\u0004\b(\u0010\tJ\u000f\u0010)\u001a\u00020\u0007H\u0016¢\u0006\u0004\b)\u0010\tJ\r\u0010*\u001a\u00020\u0007¢\u0006\u0004\b*\u0010\tJ\u001a\u0010/\u001a\u00020\u00012\u0006\u0010,\u001a\u00020+H\u0016ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u0018\u00103\u001a\u0002002\u0006\u0010,\u001a\u00020+ø\u0001\u0000¢\u0006\u0004\b1\u00102J8\u00106\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013H\u0014ø\u0001\u0000¢\u0006\u0004\b4\u00105J*\u00106\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0016H\u0014ø\u0001\u0000¢\u0006\u0004\b4\u00107J\u0018\u00109\u001a\u00020\"2\u0006\u00108\u001a\u00020!H\u0096\u0002¢\u0006\u0004\b9\u0010:J\u0017\u0010<\u001a\u00020\"2\u0006\u0010;\u001a\u00020\"H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u00020\"2\u0006\u0010;\u001a\u00020\"H\u0016¢\u0006\u0004\b>\u0010=J\u0017\u0010@\u001a\u00020\"2\u0006\u0010?\u001a\u00020\"H\u0016¢\u0006\u0004\b@\u0010=J\u0017\u0010A\u001a\u00020\"2\u0006\u0010?\u001a\u00020\"H\u0016¢\u0006\u0004\bA\u0010=J\u0015\u0010C\u001a\u00020\u00072\u0006\u0010B\u001a\u000200¢\u0006\u0004\bC\u0010DJ\r\u0010E\u001a\u00020\u0007¢\u0006\u0004\bE\u0010\tJ\r\u0010F\u001a\u000200¢\u0006\u0004\bF\u0010GJ\u000f\u0010I\u001a\u00020\u0007H\u0000¢\u0006\u0004\bH\u0010\tJ\r\u0010J\u001a\u00020\u0007¢\u0006\u0004\bJ\u0010\tJ\r\u0010K\u001a\u00020\u0007¢\u0006\u0004\bK\u0010\tR\u0016\u0010L\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u001e\u0010O\u001a\u00020\"2\u0006\u0010N\u001a\u00020\"8\u0002@BX\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010PR\"\u0010Q\u001a\u00020\"8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bQ\u0010P\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010W\u001a\u00020V8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010]\u001a\u0002008\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b]\u0010M\u001a\u0004\b^\u0010G\"\u0004\b_\u0010DR\"\u0010`\u001a\u0002008\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b`\u0010M\u001a\u0004\ba\u0010G\"\u0004\bb\u0010DR\u0016\u0010c\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010MR\u001e\u0010d\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\bd\u0010eR*\u0010f\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020\u000f8\u0000@BX\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010iR$\u0010j\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\u00118\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010mR@\u0010n\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00132\u0014\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00138\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR(\u0010r\u001a\u0004\u0018\u00010\u00162\b\u0010N\u001a\u0004\u0018\u00010\u00168\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR\"\u0010v\u001a\u0002008\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bv\u0010M\u001a\u0004\bv\u0010G\"\u0004\bw\u0010DR\u001a\u0010y\u001a\u00020x8\u0016X\u0096\u0004¢\u0006\f\n\u0004\by\u0010z\u001a\u0004\b{\u0010|R\u001f\u0010\u007f\u001a\f\u0012\b\u0012\u00060\u0000R\u00020~0}8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R&\u0010\u0081\u0001\u001a\u0002008\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0005\b\u0081\u0001\u0010M\u001a\u0005\b\u0082\u0001\u0010G\"\u0005\b\u0083\u0001\u0010DR'\u0010\u0084\u0001\u001a\u0002002\u0006\u0010N\u001a\u0002008\u0006@BX\u0086\u000e¢\u0006\u000e\n\u0005\b\u0084\u0001\u0010M\u001a\u0005\b\u0085\u0001\u0010GR\u0018\u0010\u0086\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010MR/\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0087\u00012\t\u0010N\u001a\u0005\u0018\u00010\u0087\u00018\u0016@RX\u0096\u000e¢\u0006\u0010\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R/\u0010\u008d\u0001\u001a\u0002002\u0007\u0010\u008c\u0001\u001a\u0002008\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u008d\u0001\u0010M\u001a\u0005\b\u008d\u0001\u0010G\"\u0005\b\u008e\u0001\u0010DR\u0018\u0010\u008f\u0001\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008f\u0001\u0010MR\u001c\u0010\u0093\u0001\u001a\u00070\u0090\u0001R\u00020~8@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001c\u0010\u0096\u0001\u001a\u0004\u0018\u00010+8Fø\u0001\u0000ø\u0001\u0001¢\u0006\b\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0018\u0010\u009a\u0001\u001a\u00030\u0097\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\"\u0010\u009e\u0001\u001a\r\u0012\b\u0012\u00060\u0000R\u00020~0\u009b\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0019\u0010¡\u0001\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009f\u0001\u0010 \u0001R\u0016\u0010£\u0001\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¢\u0001\u0010SR\u0016\u0010¥\u0001\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¤\u0001\u0010S\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¦\u0001"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", "<init>", "(Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;)V", BuildConfig.FLAVOR, "checkChildrenPlaceOrderForUpdates", "()V", "markSubtreeAsNotPlaced", "Landroidx/compose/ui/node/LayoutNode;", "node", "trackLookaheadMeasurementByParent", "(Landroidx/compose/ui/node/LayoutNode;)V", "Landroidx/compose/ui/unit/IntOffset;", "position", BuildConfig.FLAVOR, "zIndex", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "layerBlock", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "placeSelf-MLgxB_4", "(JFLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeSelf", "onIntrinsicsQueried", "clearPlaceOrder", "markNodeAndSubtreeAsPlaced", "onBeforeLayoutChildren", "layoutChildren", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/AlignmentLine;", BuildConfig.FLAVOR, "calculateAlignmentLines", "()Ljava/util/Map;", "block", "forEachChildAlignmentLinesOwner", "(Lkotlin/jvm/functions/Function1;)V", "requestLayout", "requestMeasure", "notifyChildrenUsingLookaheadCoordinatesWhilePlacing", "Landroidx/compose/ui/unit/Constraints;", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "measure", BuildConfig.FLAVOR, "remeasure-BRTryo0", "(J)Z", "remeasure", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeAt", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "alignmentLine", "get", "(Landroidx/compose/ui/layout/AlignmentLine;)I", "height", "minIntrinsicWidth", "(I)I", "maxIntrinsicWidth", "width", "minIntrinsicHeight", "maxIntrinsicHeight", "forceRequest", "invalidateIntrinsicsParent", "(Z)V", "invalidateParentData", "updateParentData", "()Z", "onNodePlaced$ui_release", "onNodePlaced", "replace", "onNodeDetached", "relayoutWithoutParentInProgress", "Z", "<set-?>", "previousPlaceOrder", "I", "placeOrder", "getPlaceOrder$ui_release", "()I", "setPlaceOrder$ui_release", "(I)V", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "measuredByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getMeasuredByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setMeasuredByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "duringAlignmentLinesQuery", "getDuringAlignmentLinesQuery$ui_release", "setDuringAlignmentLinesQuery$ui_release", "placedOnce", "getPlacedOnce$ui_release", "setPlacedOnce$ui_release", "measuredOnce", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "lastPosition", "J", "getLastPosition-nOcc-ac$ui_release", "()J", "lastZIndex", "F", "getLastZIndex$ui_release", "()F", "lastLayerBlock", "Lkotlin/jvm/functions/Function1;", "getLastLayerBlock$ui_release", "()Lkotlin/jvm/functions/Function1;", "lastExplicitLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "getLastExplicitLayer$ui_release", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "isPlaced", "setPlaced", "Landroidx/compose/ui/node/AlignmentLines;", "alignmentLines", "Landroidx/compose/ui/node/AlignmentLines;", "getAlignmentLines", "()Landroidx/compose/ui/node/AlignmentLines;", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "_childDelegates", "Landroidx/compose/runtime/collection/MutableVector;", "childDelegatesDirty", "getChildDelegatesDirty$ui_release", "setChildDelegatesDirty$ui_release", "layingOutChildren", "getLayingOutChildren", "parentDataDirty", BuildConfig.FLAVOR, "parentData", "Ljava/lang/Object;", "getParentData", "()Ljava/lang/Object;", "new", "isPlacedUnderMotionFrameOfReference", "setPlacedUnderMotionFrameOfReference", "onNodePlacedCalled", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "getMeasurePassDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "measurePassDelegate", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastConstraints", "Landroidx/compose/ui/node/NodeCoordinator;", "getInnerCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "innerCoordinator", BuildConfig.FLAVOR, "getChildDelegates$ui_release", "()Ljava/util/List;", "childDelegates", "getParentAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "parentAlignmentLinesOwner", "getMeasuredWidth", "measuredWidth", "getMeasuredHeight", "measuredHeight", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class LookaheadPassDelegate extends Placeable implements Measurable, AlignmentLinesOwner, MotionReferencePlacementDelegate {
        private boolean duringAlignmentLinesQuery;
        private boolean isPlaced;
        private boolean isPlacedUnderMotionFrameOfReference;
        private GraphicsLayer lastExplicitLayer;
        private Function1<? super GraphicsLayerScope, Unit> lastLayerBlock;
        private float lastZIndex;
        private boolean layingOutChildren;
        private Constraints lookaheadConstraints;
        private boolean measuredOnce;
        private boolean onNodePlacedCalled;
        private boolean placedOnce;
        private boolean relayoutWithoutParentInProgress;
        private int previousPlaceOrder = Integer.MAX_VALUE;
        private int placeOrder = Integer.MAX_VALUE;
        private LayoutNode.UsageByParent measuredByParent = LayoutNode.UsageByParent.NotUsed;
        private long lastPosition = IntOffset.INSTANCE.m2648getZeronOccac();
        private final AlignmentLines alignmentLines = new LookaheadAlignmentLines(this);
        private final MutableVector<LookaheadPassDelegate> _childDelegates = new MutableVector<>(new LookaheadPassDelegate[16], 0);
        private boolean childDelegatesDirty = true;
        private boolean parentDataDirty = true;
        private Object parentData = getMeasurePassDelegate$ui_release().getParentData();

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[LayoutNode.LayoutState.values().length];
                try {
                    iArr[LayoutNode.LayoutState.LookaheadMeasuring.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[LayoutNode.LayoutState.LookaheadLayingOut.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
                try {
                    iArr2[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr2[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
                } catch (NoSuchFieldError unused6) {
                }
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        public LookaheadPassDelegate() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkChildrenPlaceOrderForUpdates() {
            MutableVector<LayoutNode> mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                LayoutNode[] content = mutableVector.getContent();
                int i5 = 0;
                do {
                    LookaheadPassDelegate lookaheadPassDelegate = content[i5].getLayoutDelegate().getLookaheadPassDelegate();
                    Intrinsics.checkNotNull(lookaheadPassDelegate);
                    int i6 = lookaheadPassDelegate.previousPlaceOrder;
                    int i7 = lookaheadPassDelegate.placeOrder;
                    if (i6 != i7 && i7 == Integer.MAX_VALUE) {
                        lookaheadPassDelegate.markSubtreeAsNotPlaced();
                    }
                    i5++;
                } while (i5 < size);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void clearPlaceOrder() {
            int i5 = 0;
            LayoutNodeLayoutDelegate.this.nextChildLookaheadPlaceOrder = 0;
            MutableVector<LayoutNode> mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                LayoutNode[] content = mutableVector.getContent();
                do {
                    LookaheadPassDelegate lookaheadPassDelegate = content[i5].getLayoutDelegate().getLookaheadPassDelegate();
                    Intrinsics.checkNotNull(lookaheadPassDelegate);
                    lookaheadPassDelegate.previousPlaceOrder = lookaheadPassDelegate.placeOrder;
                    lookaheadPassDelegate.placeOrder = Integer.MAX_VALUE;
                    if (lookaheadPassDelegate.measuredByParent == LayoutNode.UsageByParent.InLayoutBlock) {
                        lookaheadPassDelegate.measuredByParent = LayoutNode.UsageByParent.NotUsed;
                    }
                    i5++;
                } while (i5 < size);
            }
        }

        private final void markNodeAndSubtreeAsPlaced() {
            boolean isPlaced = getIsPlaced();
            setPlaced(true);
            if (!isPlaced && LayoutNodeLayoutDelegate.this.getLookaheadMeasurePending()) {
                LayoutNode.requestLookaheadRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, true, false, false, 6, null);
            }
            MutableVector<LayoutNode> mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                LayoutNode[] content = mutableVector.getContent();
                int i5 = 0;
                do {
                    LayoutNode layoutNode = content[i5];
                    LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutNode.getLookaheadPassDelegate$ui_release();
                    if (lookaheadPassDelegate$ui_release == null) {
                        throw new IllegalArgumentException("Error: Child node's lookahead pass delegate cannot be null when in a lookahead scope.");
                    }
                    if (lookaheadPassDelegate$ui_release.placeOrder != Integer.MAX_VALUE) {
                        lookaheadPassDelegate$ui_release.markNodeAndSubtreeAsPlaced();
                        layoutNode.rescheduleRemeasureOrRelayout$ui_release(layoutNode);
                    }
                    i5++;
                } while (i5 < size);
            }
        }

        private final void markSubtreeAsNotPlaced() {
            if (getIsPlaced()) {
                int i5 = 0;
                setPlaced(false);
                MutableVector<LayoutNode> mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
                int size = mutableVector.getSize();
                if (size > 0) {
                    LayoutNode[] content = mutableVector.getContent();
                    do {
                        LookaheadPassDelegate lookaheadPassDelegate = content[i5].getLayoutDelegate().getLookaheadPassDelegate();
                        Intrinsics.checkNotNull(lookaheadPassDelegate);
                        lookaheadPassDelegate.markSubtreeAsNotPlaced();
                        i5++;
                    } while (i5 < size);
                }
            }
        }

        private final void onBeforeLayoutChildren() {
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.layoutNode;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                LayoutNode[] content = mutableVector.getContent();
                int i5 = 0;
                do {
                    LayoutNode layoutNode2 = content[i5];
                    if (layoutNode2.getLookaheadMeasurePending$ui_release() && layoutNode2.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                        LookaheadPassDelegate lookaheadPassDelegate = layoutNode2.getLayoutDelegate().getLookaheadPassDelegate();
                        Intrinsics.checkNotNull(lookaheadPassDelegate);
                        Constraints m2020getLastLookaheadConstraintsDWUhwKw = layoutNode2.getLayoutDelegate().m2020getLastLookaheadConstraintsDWUhwKw();
                        Intrinsics.checkNotNull(m2020getLastLookaheadConstraintsDWUhwKw);
                        if (lookaheadPassDelegate.m2023remeasureBRTryo0(m2020getLastLookaheadConstraintsDWUhwKw.getValue())) {
                            LayoutNode.requestLookaheadRemeasure$ui_release$default(layoutNodeLayoutDelegate.layoutNode, false, false, false, 7, null);
                        }
                    }
                    i5++;
                } while (i5 < size);
            }
        }

        private final void onIntrinsicsQueried() {
            LayoutNode.requestLookaheadRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, false, false, 7, null);
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (parent$ui_release == null || LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent() != LayoutNode.UsageByParent.NotUsed) {
                return;
            }
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.layoutNode;
            int i5 = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
            layoutNode.setIntrinsicsUsageByParent$ui_release(i5 != 2 ? i5 != 3 ? parent$ui_release.getIntrinsicsUsageByParent() : LayoutNode.UsageByParent.InLayoutBlock : LayoutNode.UsageByParent.InMeasureBlock);
        }

        /* renamed from: placeSelf-MLgxB_4, reason: not valid java name */
        private final void m2021placeSelfMLgxB_4(final long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock, GraphicsLayer layer) {
            if (LayoutNodeLayoutDelegate.this.layoutNode.getIsDeactivated()) {
                InlineClassHelperKt.throwIllegalArgumentException("place is called on a deactivated node");
            }
            LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.LookaheadLayingOut;
            this.placedOnce = true;
            this.onNodePlacedCalled = false;
            if (!IntOffset.m2639equalsimpl0(position, this.lastPosition)) {
                if (LayoutNodeLayoutDelegate.this.getLookaheadCoordinatesAccessedDuringModifierPlacement() || LayoutNodeLayoutDelegate.this.getLookaheadCoordinatesAccessedDuringPlacement()) {
                    LayoutNodeLayoutDelegate.this.lookaheadLayoutPending = true;
                }
                notifyChildrenUsingLookaheadCoordinatesWhilePlacing();
            }
            final Owner requireOwner = LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.this.layoutNode);
            if (LayoutNodeLayoutDelegate.this.getLookaheadLayoutPending() || !getIsPlaced()) {
                LayoutNodeLayoutDelegate.this.setLookaheadCoordinatesAccessedDuringModifierPlacement(false);
                getAlignmentLines().setUsedByModifierLayout$ui_release(false);
                OwnerSnapshotObserver snapshotObserver = requireOwner.getSnapshotObserver();
                LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.layoutNode;
                final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
                OwnerSnapshotObserver.observeLayoutModifierSnapshotReads$ui_release$default(snapshotObserver, layoutNode, false, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$placeSelf$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        LookaheadDelegate lookaheadDelegate;
                        Placeable.PlacementScope placementScope = null;
                        if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(LayoutNodeLayoutDelegate.this.layoutNode)) {
                            NodeCoordinator wrappedBy = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getWrappedBy();
                            if (wrappedBy != null) {
                                placementScope = wrappedBy.getPlacementScope();
                            }
                        } else {
                            NodeCoordinator wrappedBy2 = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getWrappedBy();
                            if (wrappedBy2 != null && (lookaheadDelegate = wrappedBy2.getLookaheadDelegate()) != null) {
                                placementScope = lookaheadDelegate.getPlacementScope();
                            }
                        }
                        if (placementScope == null) {
                            placementScope = requireOwner.getPlacementScope();
                        }
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = LayoutNodeLayoutDelegate.this;
                        long j5 = position;
                        LookaheadDelegate lookaheadDelegate2 = layoutNodeLayoutDelegate2.getOuterCoordinator().getLookaheadDelegate();
                        Intrinsics.checkNotNull(lookaheadDelegate2);
                        Placeable.PlacementScope.m1968place70tqf50$default(placementScope, lookaheadDelegate2, j5, 0.0f, 2, null);
                    }
                }, 2, null);
            } else {
                LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
                Intrinsics.checkNotNull(lookaheadDelegate);
                lookaheadDelegate.m2032placeSelfApparentToRealOffsetgyyYBs$ui_release(position);
                onNodePlaced$ui_release();
            }
            this.lastPosition = position;
            this.lastZIndex = zIndex;
            this.lastLayerBlock = layerBlock;
            this.lastExplicitLayer = layer;
            LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.Idle;
        }

        private final void trackLookaheadMeasurementByParent(LayoutNode node) {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode parent$ui_release = node.getParent$ui_release();
            if (parent$ui_release == null) {
                this.measuredByParent = LayoutNode.UsageByParent.NotUsed;
                return;
            }
            if (!(this.measuredByParent == LayoutNode.UsageByParent.NotUsed || node.getCanMultiMeasure())) {
                InlineClassHelperKt.throwIllegalStateException("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
            }
            int i5 = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
            if (i5 == 1 || i5 == 2) {
                usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
            } else {
                if (i5 != 3 && i5 != 4) {
                    throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + parent$ui_release.getLayoutState$ui_release());
                }
                usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
            }
            this.measuredByParent = usageByParent;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public Map<AlignmentLine, Integer> calculateAlignmentLines() {
            if (!this.duringAlignmentLinesQuery) {
                if (LayoutNodeLayoutDelegate.this.getLayoutState() == LayoutNode.LayoutState.LookaheadMeasuring) {
                    getAlignmentLines().setUsedByModifierMeasurement$ui_release(true);
                    if (getAlignmentLines().getDirty()) {
                        LayoutNodeLayoutDelegate.this.markLookaheadLayoutPending$ui_release();
                    }
                } else {
                    getAlignmentLines().setUsedByModifierLayout$ui_release(true);
                }
            }
            LookaheadDelegate lookaheadDelegate = getInnerCoordinator().getLookaheadDelegate();
            if (lookaheadDelegate != null) {
                lookaheadDelegate.setPlacingForAlignment$ui_release(true);
            }
            layoutChildren();
            LookaheadDelegate lookaheadDelegate2 = getInnerCoordinator().getLookaheadDelegate();
            if (lookaheadDelegate2 != null) {
                lookaheadDelegate2.setPlacingForAlignment$ui_release(false);
            }
            return getAlignmentLines().getLastCalculation();
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public void forEachChildAlignmentLinesOwner(Function1<? super AlignmentLinesOwner, Unit> block) {
            MutableVector<LayoutNode> mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                LayoutNode[] content = mutableVector.getContent();
                int i5 = 0;
                do {
                    AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = content[i5].getLayoutDelegate().getLookaheadAlignmentLinesOwner$ui_release();
                    Intrinsics.checkNotNull(lookaheadAlignmentLinesOwner$ui_release);
                    block.invoke(lookaheadAlignmentLinesOwner$ui_release);
                    i5++;
                } while (i5 < size);
            }
        }

        @Override // androidx.compose.ui.layout.Measured
        public int get(AlignmentLine alignmentLine) {
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if ((parent$ui_release != null ? parent$ui_release.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.LookaheadMeasuring) {
                getAlignmentLines().setUsedDuringParentMeasurement$ui_release(true);
            } else {
                LayoutNode parent$ui_release2 = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
                if ((parent$ui_release2 != null ? parent$ui_release2.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.LookaheadLayingOut) {
                    getAlignmentLines().setUsedDuringParentLayout$ui_release(true);
                }
            }
            this.duringAlignmentLinesQuery = true;
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            int i5 = lookaheadDelegate.get(alignmentLine);
            this.duringAlignmentLinesQuery = false;
            return i5;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public AlignmentLines getAlignmentLines() {
            return this.alignmentLines;
        }

        public final List<LookaheadPassDelegate> getChildDelegates$ui_release() {
            LayoutNodeLayoutDelegate.this.layoutNode.getChildren$ui_release();
            if (!this.childDelegatesDirty) {
                return this._childDelegates.asMutableList();
            }
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.layoutNode;
            MutableVector<LookaheadPassDelegate> mutableVector = this._childDelegates;
            MutableVector<LayoutNode> mutableVector2 = layoutNode.get_children$ui_release();
            int size = mutableVector2.getSize();
            if (size > 0) {
                LayoutNode[] content = mutableVector2.getContent();
                int i5 = 0;
                do {
                    LayoutNode layoutNode2 = content[i5];
                    if (mutableVector.getSize() <= i5) {
                        LookaheadPassDelegate lookaheadPassDelegate = layoutNode2.getLayoutDelegate().getLookaheadPassDelegate();
                        Intrinsics.checkNotNull(lookaheadPassDelegate);
                        mutableVector.add(lookaheadPassDelegate);
                    } else {
                        LookaheadPassDelegate lookaheadPassDelegate2 = layoutNode2.getLayoutDelegate().getLookaheadPassDelegate();
                        Intrinsics.checkNotNull(lookaheadPassDelegate2);
                        mutableVector.set(i5, lookaheadPassDelegate2);
                    }
                    i5++;
                } while (i5 < size);
            }
            mutableVector.removeRange(layoutNode.getChildren$ui_release().size(), mutableVector.getSize());
            this.childDelegatesDirty = false;
            return this._childDelegates.asMutableList();
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public NodeCoordinator getInnerCoordinator() {
            return LayoutNodeLayoutDelegate.this.layoutNode.getInnerCoordinator$ui_release();
        }

        /* renamed from: getLastConstraints-DWUhwKw, reason: not valid java name and from getter */
        public final Constraints getLookaheadConstraints() {
            return this.lookaheadConstraints;
        }

        public final boolean getLayingOutChildren() {
            return this.layingOutChildren;
        }

        public final MeasurePassDelegate getMeasurePassDelegate$ui_release() {
            return LayoutNodeLayoutDelegate.this.getMeasurePassDelegate();
        }

        /* renamed from: getMeasuredByParent$ui_release, reason: from getter */
        public final LayoutNode.UsageByParent getMeasuredByParent() {
            return this.measuredByParent;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public int getMeasuredHeight() {
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.getMeasuredHeight();
        }

        @Override // androidx.compose.ui.layout.Placeable
        public int getMeasuredWidth() {
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.getMeasuredWidth();
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public AlignmentLinesOwner getParentAlignmentLinesOwner() {
            LayoutNodeLayoutDelegate layoutDelegate;
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (parent$ui_release == null || (layoutDelegate = parent$ui_release.getLayoutDelegate()) == null) {
                return null;
            }
            return layoutDelegate.getLookaheadAlignmentLinesOwner$ui_release();
        }

        @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
        public Object getParentData() {
            return this.parentData;
        }

        /* renamed from: getPlacedOnce$ui_release, reason: from getter */
        public final boolean getPlacedOnce() {
            return this.placedOnce;
        }

        public final void invalidateIntrinsicsParent(boolean forceRequest) {
            LayoutNode layoutNode;
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            LayoutNode.UsageByParent intrinsicsUsageByParent = LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent();
            if (parent$ui_release == null || intrinsicsUsageByParent == LayoutNode.UsageByParent.NotUsed) {
                return;
            }
            do {
                layoutNode = parent$ui_release;
                if (layoutNode.getIntrinsicsUsageByParent() != intrinsicsUsageByParent) {
                    break;
                } else {
                    parent$ui_release = layoutNode.getParent$ui_release();
                }
            } while (parent$ui_release != null);
            int i5 = WhenMappings.$EnumSwitchMapping$1[intrinsicsUsageByParent.ordinal()];
            if (i5 == 1) {
                if (layoutNode.getLookaheadRoot() != null) {
                    LayoutNode.requestLookaheadRemeasure$ui_release$default(layoutNode, forceRequest, false, false, 6, null);
                    return;
                } else {
                    LayoutNode.requestRemeasure$ui_release$default(layoutNode, forceRequest, false, false, 6, null);
                    return;
                }
            }
            if (i5 != 2) {
                throw new IllegalStateException("Intrinsics isn't used by the parent");
            }
            if (layoutNode.getLookaheadRoot() != null) {
                layoutNode.requestLookaheadRelayout$ui_release(forceRequest);
            } else {
                layoutNode.requestRelayout$ui_release(forceRequest);
            }
        }

        public final void invalidateParentData() {
            this.parentDataDirty = true;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        /* renamed from: isPlaced, reason: from getter */
        public boolean getIsPlaced() {
            return this.isPlaced;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public void layoutChildren() {
            this.layingOutChildren = true;
            getAlignmentLines().recalculateQueryOwner();
            if (LayoutNodeLayoutDelegate.this.getLookaheadLayoutPending()) {
                onBeforeLayoutChildren();
            }
            final LookaheadDelegate lookaheadDelegate = getInnerCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            if (LayoutNodeLayoutDelegate.this.lookaheadLayoutPendingForAlignment || (!this.duringAlignmentLinesQuery && !lookaheadDelegate.getIsPlacingForAlignment() && LayoutNodeLayoutDelegate.this.getLookaheadLayoutPending())) {
                LayoutNodeLayoutDelegate.this.lookaheadLayoutPending = false;
                LayoutNode.LayoutState layoutState = LayoutNodeLayoutDelegate.this.getLayoutState();
                LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.LookaheadLayingOut;
                Owner requireOwner = LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.this.layoutNode);
                LayoutNodeLayoutDelegate.this.setLookaheadCoordinatesAccessedDuringPlacement(false);
                OwnerSnapshotObserver snapshotObserver = requireOwner.getSnapshotObserver();
                LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.layoutNode;
                final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
                OwnerSnapshotObserver.observeLayoutSnapshotReads$ui_release$default(snapshotObserver, layoutNode, false, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        LayoutNodeLayoutDelegate.LookaheadPassDelegate.this.clearPlaceOrder();
                        LayoutNodeLayoutDelegate.LookaheadPassDelegate.this.forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                                invoke2(alignmentLinesOwner);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(AlignmentLinesOwner alignmentLinesOwner) {
                                alignmentLinesOwner.getAlignmentLines().setUsedDuringParentLayout$ui_release(false);
                            }
                        });
                        LookaheadDelegate lookaheadDelegate2 = LayoutNodeLayoutDelegate.LookaheadPassDelegate.this.getInnerCoordinator().getLookaheadDelegate();
                        if (lookaheadDelegate2 != null) {
                            boolean isPlacingForAlignment = lookaheadDelegate2.getIsPlacingForAlignment();
                            List<LayoutNode> children$ui_release = layoutNodeLayoutDelegate.layoutNode.getChildren$ui_release();
                            int size = children$ui_release.size();
                            for (int i5 = 0; i5 < size; i5++) {
                                LookaheadDelegate lookaheadDelegate3 = children$ui_release.get(i5).getOuterCoordinator$ui_release().getLookaheadDelegate();
                                if (lookaheadDelegate3 != null) {
                                    lookaheadDelegate3.setPlacingForAlignment$ui_release(isPlacingForAlignment);
                                }
                            }
                        }
                        lookaheadDelegate.getMeasureResult$ui_release().placeChildren();
                        LookaheadDelegate lookaheadDelegate4 = LayoutNodeLayoutDelegate.LookaheadPassDelegate.this.getInnerCoordinator().getLookaheadDelegate();
                        if (lookaheadDelegate4 != null) {
                            lookaheadDelegate4.getIsPlacingForAlignment();
                            List<LayoutNode> children$ui_release2 = layoutNodeLayoutDelegate.layoutNode.getChildren$ui_release();
                            int size2 = children$ui_release2.size();
                            for (int i6 = 0; i6 < size2; i6++) {
                                LookaheadDelegate lookaheadDelegate5 = children$ui_release2.get(i6).getOuterCoordinator$ui_release().getLookaheadDelegate();
                                if (lookaheadDelegate5 != null) {
                                    lookaheadDelegate5.setPlacingForAlignment$ui_release(false);
                                }
                            }
                        }
                        LayoutNodeLayoutDelegate.LookaheadPassDelegate.this.checkChildrenPlaceOrderForUpdates();
                        LayoutNodeLayoutDelegate.LookaheadPassDelegate.this.forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1.4
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                                invoke2(alignmentLinesOwner);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(AlignmentLinesOwner alignmentLinesOwner) {
                                alignmentLinesOwner.getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(alignmentLinesOwner.getAlignmentLines().getUsedDuringParentLayout());
                            }
                        });
                    }
                }, 2, null);
                LayoutNodeLayoutDelegate.this.layoutState = layoutState;
                if (LayoutNodeLayoutDelegate.this.getLookaheadCoordinatesAccessedDuringPlacement() && lookaheadDelegate.getIsPlacingForAlignment()) {
                    requestLayout();
                }
                LayoutNodeLayoutDelegate.this.lookaheadLayoutPendingForAlignment = false;
            }
            if (getAlignmentLines().getUsedDuringParentLayout()) {
                getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(true);
            }
            if (getAlignmentLines().getDirty() && getAlignmentLines().getRequired$ui_release()) {
                getAlignmentLines().recalculate();
            }
            this.layingOutChildren = false;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int maxIntrinsicHeight(int width) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.maxIntrinsicHeight(width);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int maxIntrinsicWidth(int height) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.maxIntrinsicWidth(height);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
        
            if ((r0 != null ? r0.getLayoutState$ui_release() : null) == androidx.compose.ui.node.LayoutNode.LayoutState.LookaheadLayingOut) goto L13;
         */
        @Override // androidx.compose.ui.layout.Measurable
        /* renamed from: measure-BRTryo0 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Placeable mo1946measureBRTryo0(long constraints) {
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if ((parent$ui_release != null ? parent$ui_release.getLayoutState$ui_release() : null) != LayoutNode.LayoutState.LookaheadMeasuring) {
                LayoutNode parent$ui_release2 = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            }
            LayoutNodeLayoutDelegate.this.detachedFromParentLookaheadPass = false;
            trackLookaheadMeasurementByParent(LayoutNodeLayoutDelegate.this.layoutNode);
            if (LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent() == LayoutNode.UsageByParent.NotUsed) {
                LayoutNodeLayoutDelegate.this.layoutNode.clearSubtreeIntrinsicsUsage$ui_release();
            }
            m2023remeasureBRTryo0(constraints);
            return this;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int minIntrinsicHeight(int width) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.minIntrinsicHeight(width);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int minIntrinsicWidth(int height) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.minIntrinsicWidth(height);
        }

        public final void notifyChildrenUsingLookaheadCoordinatesWhilePlacing() {
            MutableVector<LayoutNode> mutableVector;
            int size;
            if (LayoutNodeLayoutDelegate.this.getChildrenAccessingLookaheadCoordinatesDuringPlacement() <= 0 || (size = (mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release()).getSize()) <= 0) {
                return;
            }
            LayoutNode[] content = mutableVector.getContent();
            int i5 = 0;
            do {
                LayoutNode layoutNode = content[i5];
                LayoutNodeLayoutDelegate layoutDelegate = layoutNode.getLayoutDelegate();
                if ((layoutDelegate.getLookaheadCoordinatesAccessedDuringPlacement() || layoutDelegate.getLookaheadCoordinatesAccessedDuringModifierPlacement()) && !layoutDelegate.getLookaheadLayoutPending()) {
                    LayoutNode.requestLookaheadRelayout$ui_release$default(layoutNode, false, 1, null);
                }
                LookaheadPassDelegate lookaheadPassDelegate = layoutDelegate.getLookaheadPassDelegate();
                if (lookaheadPassDelegate != null) {
                    lookaheadPassDelegate.notifyChildrenUsingLookaheadCoordinatesWhilePlacing();
                }
                i5++;
            } while (i5 < size);
        }

        public final void onNodeDetached() {
            this.placeOrder = Integer.MAX_VALUE;
            this.previousPlaceOrder = Integer.MAX_VALUE;
            setPlaced(false);
        }

        public final void onNodePlaced$ui_release() {
            this.onNodePlacedCalled = true;
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (!getIsPlaced()) {
                markNodeAndSubtreeAsPlaced();
                if (this.relayoutWithoutParentInProgress && parent$ui_release != null) {
                    LayoutNode.requestLookaheadRelayout$ui_release$default(parent$ui_release, false, 1, null);
                }
            }
            if (parent$ui_release == null) {
                this.placeOrder = 0;
            } else if (!this.relayoutWithoutParentInProgress && (parent$ui_release.getLayoutState$ui_release() == LayoutNode.LayoutState.LayingOut || parent$ui_release.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadLayingOut)) {
                if (!(this.placeOrder == Integer.MAX_VALUE)) {
                    InlineClassHelperKt.throwIllegalStateException("Place was called on a node which was placed already");
                }
                this.placeOrder = parent$ui_release.getLayoutDelegate().nextChildLookaheadPlaceOrder;
                parent$ui_release.getLayoutDelegate().nextChildLookaheadPlaceOrder++;
            }
            layoutChildren();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.compose.ui.layout.Placeable
        /* renamed from: placeAt-f8xVGno */
        public void mo1947placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            m2021placeSelfMLgxB_4(position, zIndex, layerBlock, null);
        }

        /* renamed from: remeasure-BRTryo0, reason: not valid java name */
        public final boolean m2023remeasureBRTryo0(long constraints) {
            if (LayoutNodeLayoutDelegate.this.layoutNode.getIsDeactivated()) {
                InlineClassHelperKt.throwIllegalArgumentException("measure is called on a deactivated node");
            }
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            LayoutNodeLayoutDelegate.this.layoutNode.setCanMultiMeasure$ui_release(LayoutNodeLayoutDelegate.this.layoutNode.getCanMultiMeasure() || (parent$ui_release != null && parent$ui_release.getCanMultiMeasure()));
            if (!LayoutNodeLayoutDelegate.this.layoutNode.getLookaheadMeasurePending$ui_release()) {
                Constraints constraints2 = this.lookaheadConstraints;
                if (constraints2 == null ? false : Constraints.m2572equalsimpl0(constraints2.getValue(), constraints)) {
                    Owner owner = LayoutNodeLayoutDelegate.this.layoutNode.getOwner();
                    if (owner != null) {
                        owner.forceMeasureTheSubtree(LayoutNodeLayoutDelegate.this.layoutNode, true);
                    }
                    LayoutNodeLayoutDelegate.this.layoutNode.resetSubtreeIntrinsicsUsage$ui_release();
                    return false;
                }
            }
            this.lookaheadConstraints = Constraints.m2567boximpl(constraints);
            m1967setMeasurementConstraintsBRTryo0(constraints);
            getAlignmentLines().setUsedByModifierMeasurement$ui_release(false);
            forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$remeasure$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                    invoke2(alignmentLinesOwner);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AlignmentLinesOwner alignmentLinesOwner) {
                    alignmentLinesOwner.getAlignmentLines().setUsedDuringParentMeasurement$ui_release(false);
                }
            });
            long measuredSize = this.measuredOnce ? getMeasuredSize() : IntSizeKt.IntSize(Integer.MIN_VALUE, Integer.MIN_VALUE);
            this.measuredOnce = true;
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            if (!(lookaheadDelegate != null)) {
                InlineClassHelperKt.throwIllegalStateException("Lookahead result from lookaheadRemeasure cannot be null");
            }
            LayoutNodeLayoutDelegate.this.m2017performLookaheadMeasureBRTryo0(constraints);
            m1966setMeasuredSizeozmzZPI(IntSizeKt.IntSize(lookaheadDelegate.getWidth(), lookaheadDelegate.getHeight()));
            return (IntSize.m2661getWidthimpl(measuredSize) == lookaheadDelegate.getWidth() && IntSize.m2660getHeightimpl(measuredSize) == lookaheadDelegate.getHeight()) ? false : true;
        }

        public final void replace() {
            LayoutNode parent$ui_release;
            try {
                this.relayoutWithoutParentInProgress = true;
                if (!this.placedOnce) {
                    InlineClassHelperKt.throwIllegalStateException("replace() called on item that was not placed");
                }
                this.onNodePlacedCalled = false;
                boolean isPlaced = getIsPlaced();
                m2021placeSelfMLgxB_4(this.lastPosition, 0.0f, this.lastLayerBlock, this.lastExplicitLayer);
                if (isPlaced && !this.onNodePlacedCalled && (parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release()) != null) {
                    LayoutNode.requestLookaheadRelayout$ui_release$default(parent$ui_release, false, 1, null);
                }
                this.relayoutWithoutParentInProgress = false;
            } catch (Throwable th) {
                this.relayoutWithoutParentInProgress = false;
                throw th;
            }
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public void requestLayout() {
            LayoutNode.requestLookaheadRelayout$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, 1, null);
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public void requestMeasure() {
            LayoutNode.requestLookaheadRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, false, false, 7, null);
        }

        public final void setChildDelegatesDirty$ui_release(boolean z5) {
            this.childDelegatesDirty = z5;
        }

        public final void setMeasuredByParent$ui_release(LayoutNode.UsageByParent usageByParent) {
            this.measuredByParent = usageByParent;
        }

        public final void setPlaceOrder$ui_release(int i5) {
            this.placeOrder = i5;
        }

        public void setPlaced(boolean z5) {
            this.isPlaced = z5;
        }

        @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
        public void setPlacedUnderMotionFrameOfReference(boolean z5) {
            LookaheadDelegate lookaheadDelegate;
            LookaheadDelegate lookaheadDelegate2 = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            if (!Intrinsics.areEqual(Boolean.valueOf(z5), lookaheadDelegate2 != null ? Boolean.valueOf(lookaheadDelegate2.getIsPlacedUnderMotionFrameOfReference()) : null) && (lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate()) != null) {
                lookaheadDelegate.setPlacedUnderMotionFrameOfReference(z5);
            }
            this.isPlacedUnderMotionFrameOfReference = z5;
        }

        public final boolean updateParentData() {
            if (getParentData() == null) {
                LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
                Intrinsics.checkNotNull(lookaheadDelegate);
                if (lookaheadDelegate.getParentData() == null) {
                    return false;
                }
            }
            if (!this.parentDataDirty) {
                return false;
            }
            this.parentDataDirty = false;
            LookaheadDelegate lookaheadDelegate2 = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate2);
            this.parentData = lookaheadDelegate2.getParentData();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.compose.ui.layout.Placeable
        /* renamed from: placeAt-f8xVGno */
        public void mo1965placeAtf8xVGno(long position, float zIndex, GraphicsLayer layer) {
            m2021placeSelfMLgxB_4(position, zIndex, null, layer);
        }
    }

    @Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010$\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\tJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010JB\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJB\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001bJ\u000f\u0010\u001f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001f\u0010\tJ\u000f\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0004\b \u0010\tJ\u000f\u0010\"\u001a\u00020\u0007H\u0000¢\u0006\u0004\b!\u0010\tJ\u000f\u0010#\u001a\u00020\u0007H\u0016¢\u0006\u0004\b#\u0010\tJ\u000f\u0010%\u001a\u00020\u0007H\u0000¢\u0006\u0004\b$\u0010\tJ\u001a\u0010*\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&H\u0016ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u0018\u0010.\u001a\u00020+2\u0006\u0010'\u001a\u00020&ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u0018\u00102\u001a\u0002012\u0006\u00100\u001a\u00020/H\u0096\u0002¢\u0006\u0004\b2\u00103J8\u00106\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015H\u0014ø\u0001\u0000¢\u0006\u0004\b4\u00105J*\u00106\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0018H\u0014ø\u0001\u0000¢\u0006\u0004\b4\u00107J\r\u00108\u001a\u00020\u0007¢\u0006\u0004\b8\u0010\tJ\u0017\u0010:\u001a\u0002012\u0006\u00109\u001a\u000201H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u0002012\u0006\u00109\u001a\u000201H\u0016¢\u0006\u0004\b<\u0010;J\u0017\u0010>\u001a\u0002012\u0006\u0010=\u001a\u000201H\u0016¢\u0006\u0004\b>\u0010;J\u0017\u0010?\u001a\u0002012\u0006\u0010=\u001a\u000201H\u0016¢\u0006\u0004\b?\u0010;J\r\u0010@\u001a\u00020\u0007¢\u0006\u0004\b@\u0010\tJ\r\u0010A\u001a\u00020+¢\u0006\u0004\bA\u0010BJ\u001b\u0010D\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002010CH\u0016¢\u0006\u0004\bD\u0010EJ#\u0010G\u001a\u00020\u00072\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0015H\u0016¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u0007H\u0016¢\u0006\u0004\bI\u0010\tJ\u000f\u0010J\u001a\u00020\u0007H\u0016¢\u0006\u0004\bJ\u0010\tJ\r\u0010K\u001a\u00020\u0007¢\u0006\u0004\bK\u0010\tJ\u0015\u0010M\u001a\u00020\u00072\u0006\u0010L\u001a\u00020+¢\u0006\u0004\bM\u0010NJ\r\u0010O\u001a\u00020\u0007¢\u0006\u0004\bO\u0010\tR\u0016\u0010P\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR$\u0010S\u001a\u0002012\u0006\u0010R\u001a\u0002018\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR$\u0010W\u001a\u0002012\u0006\u0010R\u001a\u0002018\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bW\u0010T\u001a\u0004\bX\u0010VR\u0016\u0010Y\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010QR\u0016\u0010Z\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010QR\"\u0010\\\u001a\u00020[8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\"\u0010b\u001a\u00020+8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bb\u0010Q\u001a\u0004\bc\u0010B\"\u0004\bd\u0010NR\u001c\u0010e\u001a\u00020\u00118\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\be\u0010fR$\u0010g\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010i\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010k\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010m\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010QR(\u0010o\u001a\u0004\u0018\u00010n2\b\u0010R\u001a\u0004\u0018\u00010n8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bq\u0010rR*\u0010s\u001a\u00020+2\u0006\u0010R\u001a\u00020+8\u0016@PX\u0096\u000e¢\u0006\u0012\n\u0004\bs\u0010Q\u001a\u0004\bs\u0010B\"\u0004\bt\u0010NR*\u0010u\u001a\u00020+2\u0006\u0010R\u001a\u00020+8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010Q\u001a\u0004\bu\u0010B\"\u0004\bv\u0010NR\u001a\u0010x\u001a\u00020w8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{R\u001e\u0010~\u001a\f\u0012\b\u0012\u00060\u0000R\u00020}0|8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR&\u0010\u0080\u0001\u001a\u00020+8\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0005\b\u0080\u0001\u0010Q\u001a\u0005\b\u0081\u0001\u0010B\"\u0005\b\u0082\u0001\u0010NR'\u0010\u0083\u0001\u001a\u00020+2\u0006\u0010R\u001a\u00020+8\u0006@BX\u0086\u000e¢\u0006\u000e\n\u0005\b\u0083\u0001\u0010Q\u001a\u0005\b\u0084\u0001\u0010BR\u001e\u0010\u0086\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0085\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R&\u0010\u0014\u001a\u00020\u00132\u0006\u0010R\u001a\u00020\u00138\u0000@BX\u0080\u000e¢\u0006\u000e\n\u0004\b\u0014\u0010l\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0018\u0010\u008a\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010QR&\u0010\u008b\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010hR\u001a\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010jR\u001e\u0010\u008d\u0001\u001a\u00020\u00118\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010fR\u0018\u0010\u008e\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010lR\u001e\u0010\u008f\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0085\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0087\u0001R\u0018\u0010\u0090\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010QR/\u0010\u0092\u0001\u001a\u00020+2\u0007\u0010\u0091\u0001\u001a\u00020+8\u0016@VX\u0096\u000e¢\u0006\u0015\n\u0005\b\u0092\u0001\u0010Q\u001a\u0005\b\u0092\u0001\u0010B\"\u0005\b\u0093\u0001\u0010NR\u001c\u0010\u0096\u0001\u001a\u0004\u0018\u00010&8Fø\u0001\u0000ø\u0001\u0001¢\u0006\b\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0018\u0010\u009a\u0001\u001a\u00030\u0097\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\"\u0010\u009e\u0001\u001a\r\u0012\b\u0012\u00060\u0000R\u00020}0\u009b\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0016\u0010 \u0001\u001a\u0002018VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u009f\u0001\u0010VR\u0016\u0010¢\u0001\u001a\u0002018VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¡\u0001\u0010VR\u0019\u0010¥\u0001\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\b£\u0001\u0010¤\u0001\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006¦\u0001"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", "<init>", "(Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;)V", BuildConfig.FLAVOR, "checkChildrenPlaceOrderForUpdates", "()V", "markSubtreeAsNotPlaced", "markNodeAndSubtreeAsPlaced", "clearPlaceOrder", "Landroidx/compose/ui/node/LayoutNode;", "node", "trackMeasurementByParent", "(Landroidx/compose/ui/node/LayoutNode;)V", "Landroidx/compose/ui/unit/IntOffset;", "position", BuildConfig.FLAVOR, "zIndex", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "layerBlock", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "placeSelf-MLgxB_4", "(JFLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeSelf", "placeOuterCoordinator-MLgxB_4", "placeOuterCoordinator", "onIntrinsicsQueried", "onBeforeLayoutChildren", "markDetachedFromParentLookaheadPass$ui_release", "markDetachedFromParentLookaheadPass", "layoutChildren", "onNodePlaced$ui_release", "onNodePlaced", "Landroidx/compose/ui/unit/Constraints;", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "measure", BuildConfig.FLAVOR, "remeasure-BRTryo0", "(J)Z", "remeasure", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLine", BuildConfig.FLAVOR, "get", "(Landroidx/compose/ui/layout/AlignmentLine;)I", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeAt", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "replace", "height", "minIntrinsicWidth", "(I)I", "maxIntrinsicWidth", "width", "minIntrinsicHeight", "maxIntrinsicHeight", "invalidateParentData", "updateParentData", "()Z", BuildConfig.FLAVOR, "calculateAlignmentLines", "()Ljava/util/Map;", "block", "forEachChildAlignmentLinesOwner", "(Lkotlin/jvm/functions/Function1;)V", "requestLayout", "requestMeasure", "notifyChildrenUsingCoordinatesWhilePlacing", "forceRequest", "invalidateIntrinsicsParent", "(Z)V", "onNodeDetached", "relayoutWithoutParentInProgress", "Z", "<set-?>", "previousPlaceOrder", "I", "getPreviousPlaceOrder$ui_release", "()I", "placeOrder", "getPlaceOrder$ui_release", "measuredOnce", "placedOnce", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "measuredByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getMeasuredByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setMeasuredByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "duringAlignmentLinesQuery", "getDuringAlignmentLinesQuery$ui_release", "setDuringAlignmentLinesQuery$ui_release", "lastPosition", "J", "lastLayerBlock", "Lkotlin/jvm/functions/Function1;", "lastExplicitLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "lastZIndex", "F", "parentDataDirty", BuildConfig.FLAVOR, "parentData", "Ljava/lang/Object;", "getParentData", "()Ljava/lang/Object;", "isPlaced", "setPlaced$ui_release", "isPlacedByParent", "setPlacedByParent$ui_release", "Landroidx/compose/ui/node/AlignmentLines;", "alignmentLines", "Landroidx/compose/ui/node/AlignmentLines;", "getAlignmentLines", "()Landroidx/compose/ui/node/AlignmentLines;", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "_childDelegates", "Landroidx/compose/runtime/collection/MutableVector;", "childDelegatesDirty", "getChildDelegatesDirty$ui_release", "setChildDelegatesDirty$ui_release", "layingOutChildren", "getLayingOutChildren", "Lkotlin/Function0;", "layoutChildrenBlock", "Lkotlin/jvm/functions/Function0;", "getZIndex$ui_release", "()F", "onNodePlacedCalled", "placeOuterCoordinatorLayerBlock", "placeOuterCoordinatorLayer", "placeOuterCoordinatorPosition", "placeOuterCoordinatorZIndex", "placeOuterCoordinatorBlock", "needsCoordinatesUpdate", "new", "isPlacedUnderMotionFrameOfReference", "setPlacedUnderMotionFrameOfReference", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastConstraints", "Landroidx/compose/ui/node/NodeCoordinator;", "getInnerCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "innerCoordinator", BuildConfig.FLAVOR, "getChildDelegates$ui_release", "()Ljava/util/List;", "childDelegates", "getMeasuredWidth", "measuredWidth", "getMeasuredHeight", "measuredHeight", "getParentAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "parentAlignmentLinesOwner", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class MeasurePassDelegate extends Placeable implements Measurable, AlignmentLinesOwner, MotionReferencePlacementDelegate {
        private final MutableVector<MeasurePassDelegate> _childDelegates;
        private final AlignmentLines alignmentLines;
        private boolean childDelegatesDirty;
        private boolean duringAlignmentLinesQuery;
        private boolean isPlaced;
        private boolean isPlacedByParent;
        private boolean isPlacedUnderMotionFrameOfReference;
        private GraphicsLayer lastExplicitLayer;
        private Function1<? super GraphicsLayerScope, Unit> lastLayerBlock;
        private long lastPosition;
        private float lastZIndex;
        private boolean layingOutChildren;
        private final Function0<Unit> layoutChildrenBlock;
        private boolean measuredOnce;
        private boolean needsCoordinatesUpdate;
        private boolean onNodePlacedCalled;
        private Object parentData;
        private boolean parentDataDirty;
        private final Function0<Unit> placeOuterCoordinatorBlock;
        private GraphicsLayer placeOuterCoordinatorLayer;
        private Function1<? super GraphicsLayerScope, Unit> placeOuterCoordinatorLayerBlock;
        private long placeOuterCoordinatorPosition;
        private float placeOuterCoordinatorZIndex;
        private boolean placedOnce;
        private boolean relayoutWithoutParentInProgress;
        private float zIndex;
        private int previousPlaceOrder = Integer.MAX_VALUE;
        private int placeOrder = Integer.MAX_VALUE;
        private LayoutNode.UsageByParent measuredByParent = LayoutNode.UsageByParent.NotUsed;

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] iArr = new int[LayoutNode.LayoutState.values().length];
                try {
                    iArr[LayoutNode.LayoutState.Measuring.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LayoutNode.LayoutState.LayingOut.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
                int[] iArr2 = new int[LayoutNode.UsageByParent.values().length];
                try {
                    iArr2[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr2[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$1 = iArr2;
            }
        }

        public MeasurePassDelegate() {
            IntOffset.Companion companion = IntOffset.INSTANCE;
            this.lastPosition = companion.m2648getZeronOccac();
            this.parentDataDirty = true;
            this.alignmentLines = new LayoutNodeAlignmentLines(this);
            this._childDelegates = new MutableVector<>(new MeasurePassDelegate[16], 0);
            this.childDelegatesDirty = true;
            this.layoutChildrenBlock = new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildrenBlock$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    LayoutNodeLayoutDelegate.MeasurePassDelegate.this.clearPlaceOrder();
                    LayoutNodeLayoutDelegate.MeasurePassDelegate.this.forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildrenBlock$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                            invoke2(alignmentLinesOwner);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(AlignmentLinesOwner alignmentLinesOwner) {
                            alignmentLinesOwner.getAlignmentLines().setUsedDuringParentLayout$ui_release(false);
                        }
                    });
                    LayoutNodeLayoutDelegate.MeasurePassDelegate.this.getInnerCoordinator().getMeasureResult$ui_release().placeChildren();
                    LayoutNodeLayoutDelegate.MeasurePassDelegate.this.checkChildrenPlaceOrderForUpdates();
                    LayoutNodeLayoutDelegate.MeasurePassDelegate.this.forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildrenBlock$1.2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                            invoke2(alignmentLinesOwner);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(AlignmentLinesOwner alignmentLinesOwner) {
                            alignmentLinesOwner.getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(alignmentLinesOwner.getAlignmentLines().getUsedDuringParentLayout());
                        }
                    });
                }
            };
            this.placeOuterCoordinatorPosition = companion.m2648getZeronOccac();
            this.placeOuterCoordinatorBlock = new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$placeOuterCoordinatorBlock$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Placeable.PlacementScope placementScope;
                    Function1<? super GraphicsLayerScope, Unit> function1;
                    GraphicsLayer graphicsLayer;
                    long j5;
                    float f5;
                    long j6;
                    float f6;
                    long j7;
                    float f7;
                    NodeCoordinator wrappedBy = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getWrappedBy();
                    if (wrappedBy == null || (placementScope = wrappedBy.getPlacementScope()) == null) {
                        placementScope = LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.this.layoutNode).getPlacementScope();
                    }
                    Placeable.PlacementScope placementScope2 = placementScope;
                    LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate = this;
                    LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
                    function1 = measurePassDelegate.placeOuterCoordinatorLayerBlock;
                    graphicsLayer = measurePassDelegate.placeOuterCoordinatorLayer;
                    if (graphicsLayer != null) {
                        NodeCoordinator outerCoordinator = layoutNodeLayoutDelegate.getOuterCoordinator();
                        j7 = measurePassDelegate.placeOuterCoordinatorPosition;
                        f7 = measurePassDelegate.placeOuterCoordinatorZIndex;
                        placementScope2.m1979placeWithLayeraW9wM(outerCoordinator, j7, graphicsLayer, f7);
                        return;
                    }
                    if (function1 == null) {
                        NodeCoordinator outerCoordinator2 = layoutNodeLayoutDelegate.getOuterCoordinator();
                        j6 = measurePassDelegate.placeOuterCoordinatorPosition;
                        f6 = measurePassDelegate.placeOuterCoordinatorZIndex;
                        placementScope2.m1974place70tqf50(outerCoordinator2, j6, f6);
                        return;
                    }
                    NodeCoordinator outerCoordinator3 = layoutNodeLayoutDelegate.getOuterCoordinator();
                    j5 = measurePassDelegate.placeOuterCoordinatorPosition;
                    f5 = measurePassDelegate.placeOuterCoordinatorZIndex;
                    placementScope2.m1978placeWithLayeraW9wM(outerCoordinator3, j5, f5, function1);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkChildrenPlaceOrderForUpdates() {
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.layoutNode;
            MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                LayoutNode[] content = mutableVector.getContent();
                int i5 = 0;
                do {
                    LayoutNode layoutNode2 = content[i5];
                    if (layoutNode2.getMeasurePassDelegate$ui_release().previousPlaceOrder != layoutNode2.getPlaceOrder$ui_release()) {
                        layoutNode.onZSortedChildrenInvalidated$ui_release();
                        layoutNode.invalidateLayer$ui_release();
                        if (layoutNode2.getPlaceOrder$ui_release() == Integer.MAX_VALUE) {
                            layoutNode2.getMeasurePassDelegate$ui_release().markSubtreeAsNotPlaced();
                        }
                    }
                    i5++;
                } while (i5 < size);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void clearPlaceOrder() {
            LayoutNodeLayoutDelegate.this.nextChildPlaceOrder = 0;
            MutableVector<LayoutNode> mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                LayoutNode[] content = mutableVector.getContent();
                int i5 = 0;
                do {
                    MeasurePassDelegate measurePassDelegate$ui_release = content[i5].getMeasurePassDelegate$ui_release();
                    measurePassDelegate$ui_release.previousPlaceOrder = measurePassDelegate$ui_release.placeOrder;
                    measurePassDelegate$ui_release.placeOrder = Integer.MAX_VALUE;
                    measurePassDelegate$ui_release.isPlacedByParent = false;
                    if (measurePassDelegate$ui_release.measuredByParent == LayoutNode.UsageByParent.InLayoutBlock) {
                        measurePassDelegate$ui_release.measuredByParent = LayoutNode.UsageByParent.NotUsed;
                    }
                    i5++;
                } while (i5 < size);
            }
        }

        private final void markNodeAndSubtreeAsPlaced() {
            boolean isPlaced = getIsPlaced();
            setPlaced$ui_release(true);
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.layoutNode;
            if (!isPlaced) {
                if (layoutNode.getMeasurePending$ui_release()) {
                    LayoutNode.requestRemeasure$ui_release$default(layoutNode, true, false, false, 6, null);
                } else if (layoutNode.getLookaheadMeasurePending$ui_release()) {
                    LayoutNode.requestLookaheadRemeasure$ui_release$default(layoutNode, true, false, false, 6, null);
                }
            }
            NodeCoordinator wrapped = layoutNode.getInnerCoordinator$ui_release().getWrapped();
            for (NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release(); !Intrinsics.areEqual(outerCoordinator$ui_release, wrapped) && outerCoordinator$ui_release != null; outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped()) {
                if (outerCoordinator$ui_release.getLastLayerDrawingWasSkipped()) {
                    outerCoordinator$ui_release.invalidateLayer();
                }
            }
            MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                LayoutNode[] content = mutableVector.getContent();
                int i5 = 0;
                do {
                    LayoutNode layoutNode2 = content[i5];
                    if (layoutNode2.getPlaceOrder$ui_release() != Integer.MAX_VALUE) {
                        layoutNode2.getMeasurePassDelegate$ui_release().markNodeAndSubtreeAsPlaced();
                        layoutNode.rescheduleRemeasureOrRelayout$ui_release(layoutNode2);
                    }
                    i5++;
                } while (i5 < size);
            }
        }

        private final void markSubtreeAsNotPlaced() {
            if (getIsPlaced()) {
                int i5 = 0;
                setPlaced$ui_release(false);
                LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.layoutNode;
                NodeCoordinator wrapped = layoutNode.getInnerCoordinator$ui_release().getWrapped();
                for (NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release(); !Intrinsics.areEqual(outerCoordinator$ui_release, wrapped) && outerCoordinator$ui_release != null; outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped()) {
                    outerCoordinator$ui_release.releaseLayer();
                }
                MutableVector<LayoutNode> mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
                int size = mutableVector.getSize();
                if (size > 0) {
                    LayoutNode[] content = mutableVector.getContent();
                    do {
                        content[i5].getMeasurePassDelegate$ui_release().markSubtreeAsNotPlaced();
                        i5++;
                    } while (i5 < size);
                }
            }
        }

        private final void onBeforeLayoutChildren() {
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.layoutNode;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                LayoutNode[] content = mutableVector.getContent();
                int i5 = 0;
                do {
                    LayoutNode layoutNode2 = content[i5];
                    if (layoutNode2.getMeasurePending$ui_release() && layoutNode2.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && LayoutNode.m2002remeasure_Sx5XlM$ui_release$default(layoutNode2, null, 1, null)) {
                        LayoutNode.requestRemeasure$ui_release$default(layoutNodeLayoutDelegate.layoutNode, false, false, false, 7, null);
                    }
                    i5++;
                } while (i5 < size);
            }
        }

        private final void onIntrinsicsQueried() {
            LayoutNode.requestRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, false, false, 7, null);
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (parent$ui_release == null || LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent() != LayoutNode.UsageByParent.NotUsed) {
                return;
            }
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.layoutNode;
            int i5 = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
            layoutNode.setIntrinsicsUsageByParent$ui_release(i5 != 1 ? i5 != 2 ? parent$ui_release.getIntrinsicsUsageByParent() : LayoutNode.UsageByParent.InLayoutBlock : LayoutNode.UsageByParent.InMeasureBlock);
        }

        /* renamed from: placeOuterCoordinator-MLgxB_4, reason: not valid java name */
        private final void m2024placeOuterCoordinatorMLgxB_4(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock, GraphicsLayer layer) {
            if (LayoutNodeLayoutDelegate.this.layoutNode.getIsDeactivated()) {
                InlineClassHelperKt.throwIllegalArgumentException("place is called on a deactivated node");
            }
            LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.LayingOut;
            this.lastPosition = position;
            this.lastZIndex = zIndex;
            this.lastLayerBlock = layerBlock;
            this.lastExplicitLayer = layer;
            this.placedOnce = true;
            this.onNodePlacedCalled = false;
            Owner requireOwner = LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.this.layoutNode);
            if (LayoutNodeLayoutDelegate.this.getLayoutPending() || !getIsPlaced()) {
                getAlignmentLines().setUsedByModifierLayout$ui_release(false);
                LayoutNodeLayoutDelegate.this.setCoordinatesAccessedDuringModifierPlacement(false);
                this.placeOuterCoordinatorLayerBlock = layerBlock;
                this.placeOuterCoordinatorPosition = position;
                this.placeOuterCoordinatorZIndex = zIndex;
                this.placeOuterCoordinatorLayer = layer;
                requireOwner.getSnapshotObserver().observeLayoutModifierSnapshotReads$ui_release(LayoutNodeLayoutDelegate.this.layoutNode, false, this.placeOuterCoordinatorBlock);
            } else {
                LayoutNodeLayoutDelegate.this.getOuterCoordinator().m2066placeSelfApparentToRealOffsetMLgxB_4(position, zIndex, layerBlock, layer);
                onNodePlaced$ui_release();
            }
            LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.Idle;
        }

        /* renamed from: placeSelf-MLgxB_4, reason: not valid java name */
        private final void m2025placeSelfMLgxB_4(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock, GraphicsLayer layer) {
            Placeable.PlacementScope placementScope;
            this.isPlacedByParent = true;
            if (!IntOffset.m2639equalsimpl0(position, this.lastPosition) || this.needsCoordinatesUpdate) {
                if (LayoutNodeLayoutDelegate.this.getCoordinatesAccessedDuringModifierPlacement() || LayoutNodeLayoutDelegate.this.getCoordinatesAccessedDuringPlacement() || this.needsCoordinatesUpdate) {
                    LayoutNodeLayoutDelegate.this.layoutPending = true;
                    this.needsCoordinatesUpdate = false;
                }
                notifyChildrenUsingCoordinatesWhilePlacing();
            }
            if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(LayoutNodeLayoutDelegate.this.layoutNode)) {
                NodeCoordinator wrappedBy = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getWrappedBy();
                if (wrappedBy == null || (placementScope = wrappedBy.getPlacementScope()) == null) {
                    placementScope = LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.this.layoutNode).getPlacementScope();
                }
                Placeable.PlacementScope placementScope2 = placementScope;
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
                LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.getLookaheadPassDelegate();
                Intrinsics.checkNotNull(lookaheadPassDelegate);
                LayoutNode parent$ui_release = layoutNodeLayoutDelegate.layoutNode.getParent$ui_release();
                if (parent$ui_release != null) {
                    parent$ui_release.getLayoutDelegate().nextChildLookaheadPlaceOrder = 0;
                }
                lookaheadPassDelegate.setPlaceOrder$ui_release(Integer.MAX_VALUE);
                Placeable.PlacementScope.place$default(placementScope2, lookaheadPassDelegate, IntOffset.m2640getXimpl(position), IntOffset.m2641getYimpl(position), 0.0f, 4, null);
            }
            LookaheadPassDelegate lookaheadPassDelegate2 = LayoutNodeLayoutDelegate.this.getLookaheadPassDelegate();
            if ((lookaheadPassDelegate2 == null || lookaheadPassDelegate2.getPlacedOnce()) ? false : true) {
                InlineClassHelperKt.throwIllegalStateException("Error: Placement happened before lookahead.");
            }
            m2024placeOuterCoordinatorMLgxB_4(position, zIndex, layerBlock, layer);
        }

        private final void trackMeasurementByParent(LayoutNode node) {
            LayoutNode.UsageByParent usageByParent;
            LayoutNode parent$ui_release = node.getParent$ui_release();
            if (parent$ui_release == null) {
                this.measuredByParent = LayoutNode.UsageByParent.NotUsed;
                return;
            }
            if (!(this.measuredByParent == LayoutNode.UsageByParent.NotUsed || node.getCanMultiMeasure())) {
                InlineClassHelperKt.throwIllegalStateException("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()");
            }
            int i5 = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.getLayoutState$ui_release().ordinal()];
            if (i5 == 1) {
                usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
            } else {
                if (i5 != 2) {
                    throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + parent$ui_release.getLayoutState$ui_release());
                }
                usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
            }
            this.measuredByParent = usageByParent;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public Map<AlignmentLine, Integer> calculateAlignmentLines() {
            if (!this.duringAlignmentLinesQuery) {
                if (LayoutNodeLayoutDelegate.this.getLayoutState() == LayoutNode.LayoutState.Measuring) {
                    getAlignmentLines().setUsedByModifierMeasurement$ui_release(true);
                    if (getAlignmentLines().getDirty()) {
                        LayoutNodeLayoutDelegate.this.markLayoutPending$ui_release();
                    }
                } else {
                    getAlignmentLines().setUsedByModifierLayout$ui_release(true);
                }
            }
            getInnerCoordinator().setPlacingForAlignment$ui_release(true);
            layoutChildren();
            getInnerCoordinator().setPlacingForAlignment$ui_release(false);
            return getAlignmentLines().getLastCalculation();
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public void forEachChildAlignmentLinesOwner(Function1<? super AlignmentLinesOwner, Unit> block) {
            MutableVector<LayoutNode> mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                LayoutNode[] content = mutableVector.getContent();
                int i5 = 0;
                do {
                    block.invoke(content[i5].getLayoutDelegate().getAlignmentLinesOwner$ui_release());
                    i5++;
                } while (i5 < size);
            }
        }

        @Override // androidx.compose.ui.layout.Measured
        public int get(AlignmentLine alignmentLine) {
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if ((parent$ui_release != null ? parent$ui_release.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.Measuring) {
                getAlignmentLines().setUsedDuringParentMeasurement$ui_release(true);
            } else {
                LayoutNode parent$ui_release2 = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
                if ((parent$ui_release2 != null ? parent$ui_release2.getLayoutState$ui_release() : null) == LayoutNode.LayoutState.LayingOut) {
                    getAlignmentLines().setUsedDuringParentLayout$ui_release(true);
                }
            }
            this.duringAlignmentLinesQuery = true;
            int i5 = LayoutNodeLayoutDelegate.this.getOuterCoordinator().get(alignmentLine);
            this.duringAlignmentLinesQuery = false;
            return i5;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public AlignmentLines getAlignmentLines() {
            return this.alignmentLines;
        }

        public final List<MeasurePassDelegate> getChildDelegates$ui_release() {
            LayoutNodeLayoutDelegate.this.layoutNode.updateChildrenIfDirty$ui_release();
            if (!this.childDelegatesDirty) {
                return this._childDelegates.asMutableList();
            }
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.layoutNode;
            MutableVector<MeasurePassDelegate> mutableVector = this._childDelegates;
            MutableVector<LayoutNode> mutableVector2 = layoutNode.get_children$ui_release();
            int size = mutableVector2.getSize();
            if (size > 0) {
                LayoutNode[] content = mutableVector2.getContent();
                int i5 = 0;
                do {
                    LayoutNode layoutNode2 = content[i5];
                    if (mutableVector.getSize() <= i5) {
                        mutableVector.add(layoutNode2.getLayoutDelegate().getMeasurePassDelegate());
                    } else {
                        mutableVector.set(i5, layoutNode2.getLayoutDelegate().getMeasurePassDelegate());
                    }
                    i5++;
                } while (i5 < size);
            }
            mutableVector.removeRange(layoutNode.getChildren$ui_release().size(), mutableVector.getSize());
            this.childDelegatesDirty = false;
            return this._childDelegates.asMutableList();
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public NodeCoordinator getInnerCoordinator() {
            return LayoutNodeLayoutDelegate.this.layoutNode.getInnerCoordinator$ui_release();
        }

        /* renamed from: getLastConstraints-DWUhwKw, reason: not valid java name */
        public final Constraints m2026getLastConstraintsDWUhwKw() {
            if (this.measuredOnce) {
                return Constraints.m2567boximpl(getMeasurementConstraints());
            }
            return null;
        }

        public final boolean getLayingOutChildren() {
            return this.layingOutChildren;
        }

        /* renamed from: getMeasuredByParent$ui_release, reason: from getter */
        public final LayoutNode.UsageByParent getMeasuredByParent() {
            return this.measuredByParent;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public int getMeasuredHeight() {
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().getMeasuredHeight();
        }

        @Override // androidx.compose.ui.layout.Placeable
        public int getMeasuredWidth() {
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().getMeasuredWidth();
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public AlignmentLinesOwner getParentAlignmentLinesOwner() {
            LayoutNodeLayoutDelegate layoutDelegate;
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (parent$ui_release == null || (layoutDelegate = parent$ui_release.getLayoutDelegate()) == null) {
                return null;
            }
            return layoutDelegate.getAlignmentLinesOwner$ui_release();
        }

        @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
        public Object getParentData() {
            return this.parentData;
        }

        /* renamed from: getPlaceOrder$ui_release, reason: from getter */
        public final int getPlaceOrder() {
            return this.placeOrder;
        }

        /* renamed from: getZIndex$ui_release, reason: from getter */
        public final float getZIndex() {
            return this.zIndex;
        }

        public final void invalidateIntrinsicsParent(boolean forceRequest) {
            LayoutNode layoutNode;
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            LayoutNode.UsageByParent intrinsicsUsageByParent = LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent();
            if (parent$ui_release == null || intrinsicsUsageByParent == LayoutNode.UsageByParent.NotUsed) {
                return;
            }
            do {
                layoutNode = parent$ui_release;
                if (layoutNode.getIntrinsicsUsageByParent() != intrinsicsUsageByParent) {
                    break;
                } else {
                    parent$ui_release = layoutNode.getParent$ui_release();
                }
            } while (parent$ui_release != null);
            int i5 = WhenMappings.$EnumSwitchMapping$1[intrinsicsUsageByParent.ordinal()];
            if (i5 == 1) {
                LayoutNode.requestRemeasure$ui_release$default(layoutNode, forceRequest, false, false, 6, null);
            } else {
                if (i5 != 2) {
                    throw new IllegalStateException("Intrinsics isn't used by the parent");
                }
                layoutNode.requestRelayout$ui_release(forceRequest);
            }
        }

        public final void invalidateParentData() {
            this.parentDataDirty = true;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        /* renamed from: isPlaced, reason: from getter */
        public boolean getIsPlaced() {
            return this.isPlaced;
        }

        /* renamed from: isPlacedByParent, reason: from getter */
        public final boolean getIsPlacedByParent() {
            return this.isPlacedByParent;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public void layoutChildren() {
            this.layingOutChildren = true;
            getAlignmentLines().recalculateQueryOwner();
            if (LayoutNodeLayoutDelegate.this.getLayoutPending()) {
                onBeforeLayoutChildren();
            }
            if (LayoutNodeLayoutDelegate.this.layoutPendingForAlignment || (!this.duringAlignmentLinesQuery && !getInnerCoordinator().getIsPlacingForAlignment() && LayoutNodeLayoutDelegate.this.getLayoutPending())) {
                LayoutNodeLayoutDelegate.this.layoutPending = false;
                LayoutNode.LayoutState layoutState = LayoutNodeLayoutDelegate.this.getLayoutState();
                LayoutNodeLayoutDelegate.this.layoutState = LayoutNode.LayoutState.LayingOut;
                LayoutNodeLayoutDelegate.this.setCoordinatesAccessedDuringPlacement(false);
                LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.layoutNode;
                LayoutNodeKt.requireOwner(layoutNode).getSnapshotObserver().observeLayoutSnapshotReads$ui_release(layoutNode, false, this.layoutChildrenBlock);
                LayoutNodeLayoutDelegate.this.layoutState = layoutState;
                if (getInnerCoordinator().getIsPlacingForAlignment() && LayoutNodeLayoutDelegate.this.getCoordinatesAccessedDuringPlacement()) {
                    requestLayout();
                }
                LayoutNodeLayoutDelegate.this.layoutPendingForAlignment = false;
            }
            if (getAlignmentLines().getUsedDuringParentLayout()) {
                getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(true);
            }
            if (getAlignmentLines().getDirty() && getAlignmentLines().getRequired$ui_release()) {
                getAlignmentLines().recalculate();
            }
            this.layingOutChildren = false;
        }

        public final void markDetachedFromParentLookaheadPass$ui_release() {
            LayoutNodeLayoutDelegate.this.detachedFromParentLookaheadPass = true;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int maxIntrinsicHeight(int width) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().maxIntrinsicHeight(width);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int maxIntrinsicWidth(int height) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().maxIntrinsicWidth(height);
        }

        @Override // androidx.compose.ui.layout.Measurable
        /* renamed from: measure-BRTryo0 */
        public Placeable mo1946measureBRTryo0(long constraints) {
            LayoutNode.UsageByParent intrinsicsUsageByParent = LayoutNodeLayoutDelegate.this.layoutNode.getIntrinsicsUsageByParent();
            LayoutNode.UsageByParent usageByParent = LayoutNode.UsageByParent.NotUsed;
            if (intrinsicsUsageByParent == usageByParent) {
                LayoutNodeLayoutDelegate.this.layoutNode.clearSubtreeIntrinsicsUsage$ui_release();
            }
            if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(LayoutNodeLayoutDelegate.this.layoutNode)) {
                LookaheadPassDelegate lookaheadPassDelegate = LayoutNodeLayoutDelegate.this.getLookaheadPassDelegate();
                Intrinsics.checkNotNull(lookaheadPassDelegate);
                lookaheadPassDelegate.setMeasuredByParent$ui_release(usageByParent);
                lookaheadPassDelegate.mo1946measureBRTryo0(constraints);
            }
            trackMeasurementByParent(LayoutNodeLayoutDelegate.this.layoutNode);
            m2027remeasureBRTryo0(constraints);
            return this;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int minIntrinsicHeight(int width) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().minIntrinsicHeight(width);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int minIntrinsicWidth(int height) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().minIntrinsicWidth(height);
        }

        public final void notifyChildrenUsingCoordinatesWhilePlacing() {
            MutableVector<LayoutNode> mutableVector;
            int size;
            if (LayoutNodeLayoutDelegate.this.getChildrenAccessingCoordinatesDuringPlacement() <= 0 || (size = (mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release()).getSize()) <= 0) {
                return;
            }
            LayoutNode[] content = mutableVector.getContent();
            int i5 = 0;
            do {
                LayoutNode layoutNode = content[i5];
                LayoutNodeLayoutDelegate layoutDelegate = layoutNode.getLayoutDelegate();
                if ((layoutDelegate.getCoordinatesAccessedDuringPlacement() || layoutDelegate.getCoordinatesAccessedDuringModifierPlacement()) && !layoutDelegate.getLayoutPending()) {
                    LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, null);
                }
                layoutDelegate.getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
                i5++;
            } while (i5 < size);
        }

        public final void onNodeDetached() {
            this.placeOrder = Integer.MAX_VALUE;
            this.previousPlaceOrder = Integer.MAX_VALUE;
            setPlaced$ui_release(false);
        }

        public final void onNodePlaced$ui_release() {
            this.onNodePlacedCalled = true;
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            float zIndex = getInnerCoordinator().getZIndex();
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.layoutNode;
            NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release();
            NodeCoordinator innerCoordinator$ui_release = layoutNode.getInnerCoordinator$ui_release();
            while (outerCoordinator$ui_release != innerCoordinator$ui_release) {
                Intrinsics.checkNotNull(outerCoordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) outerCoordinator$ui_release;
                zIndex += layoutModifierNodeCoordinator.getZIndex();
                outerCoordinator$ui_release = layoutModifierNodeCoordinator.getWrapped();
            }
            if (zIndex != this.zIndex) {
                this.zIndex = zIndex;
                if (parent$ui_release != null) {
                    parent$ui_release.onZSortedChildrenInvalidated$ui_release();
                }
                if (parent$ui_release != null) {
                    parent$ui_release.invalidateLayer$ui_release();
                }
            }
            if (!getIsPlaced()) {
                if (parent$ui_release != null) {
                    parent$ui_release.invalidateLayer$ui_release();
                }
                markNodeAndSubtreeAsPlaced();
                if (this.relayoutWithoutParentInProgress && parent$ui_release != null) {
                    LayoutNode.requestRelayout$ui_release$default(parent$ui_release, false, 1, null);
                }
            }
            if (parent$ui_release == null) {
                this.placeOrder = 0;
            } else if (!this.relayoutWithoutParentInProgress && parent$ui_release.getLayoutState$ui_release() == LayoutNode.LayoutState.LayingOut) {
                if (!(this.placeOrder == Integer.MAX_VALUE)) {
                    InlineClassHelperKt.throwIllegalStateException("Place was called on a node which was placed already");
                }
                this.placeOrder = parent$ui_release.getLayoutDelegate().nextChildPlaceOrder;
                parent$ui_release.getLayoutDelegate().nextChildPlaceOrder++;
            }
            layoutChildren();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.compose.ui.layout.Placeable
        /* renamed from: placeAt-f8xVGno */
        public void mo1947placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
            m2025placeSelfMLgxB_4(position, zIndex, layerBlock, null);
        }

        /* renamed from: remeasure-BRTryo0, reason: not valid java name */
        public final boolean m2027remeasureBRTryo0(long constraints) {
            if (LayoutNodeLayoutDelegate.this.layoutNode.getIsDeactivated()) {
                InlineClassHelperKt.throwIllegalArgumentException("measure is called on a deactivated node");
            }
            Owner requireOwner = LayoutNodeKt.requireOwner(LayoutNodeLayoutDelegate.this.layoutNode);
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            boolean z5 = true;
            LayoutNodeLayoutDelegate.this.layoutNode.setCanMultiMeasure$ui_release(LayoutNodeLayoutDelegate.this.layoutNode.getCanMultiMeasure() || (parent$ui_release != null && parent$ui_release.getCanMultiMeasure()));
            if (!LayoutNodeLayoutDelegate.this.layoutNode.getMeasurePending$ui_release() && Constraints.m2572equalsimpl0(getMeasurementConstraints(), constraints)) {
                Owner.forceMeasureTheSubtree$default(requireOwner, LayoutNodeLayoutDelegate.this.layoutNode, false, 2, null);
                LayoutNodeLayoutDelegate.this.layoutNode.resetSubtreeIntrinsicsUsage$ui_release();
                return false;
            }
            getAlignmentLines().setUsedByModifierMeasurement$ui_release(false);
            forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$remeasure$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                    invoke2(alignmentLinesOwner);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AlignmentLinesOwner alignmentLinesOwner) {
                    alignmentLinesOwner.getAlignmentLines().setUsedDuringParentMeasurement$ui_release(false);
                }
            });
            this.measuredOnce = true;
            long mo1948getSizeYbymL2g = LayoutNodeLayoutDelegate.this.getOuterCoordinator().mo1948getSizeYbymL2g();
            m1967setMeasurementConstraintsBRTryo0(constraints);
            LayoutNodeLayoutDelegate.this.m2018performMeasureBRTryo0(constraints);
            if (IntSize.m2659equalsimpl0(LayoutNodeLayoutDelegate.this.getOuterCoordinator().mo1948getSizeYbymL2g(), mo1948getSizeYbymL2g) && LayoutNodeLayoutDelegate.this.getOuterCoordinator().getWidth() == getWidth() && LayoutNodeLayoutDelegate.this.getOuterCoordinator().getHeight() == getHeight()) {
                z5 = false;
            }
            m1966setMeasuredSizeozmzZPI(IntSizeKt.IntSize(LayoutNodeLayoutDelegate.this.getOuterCoordinator().getWidth(), LayoutNodeLayoutDelegate.this.getOuterCoordinator().getHeight()));
            return z5;
        }

        public final void replace() {
            LayoutNode parent$ui_release;
            try {
                this.relayoutWithoutParentInProgress = true;
                if (!this.placedOnce) {
                    InlineClassHelperKt.throwIllegalStateException("replace called on unplaced item");
                }
                boolean isPlaced = getIsPlaced();
                m2024placeOuterCoordinatorMLgxB_4(this.lastPosition, this.lastZIndex, this.lastLayerBlock, this.lastExplicitLayer);
                if (isPlaced && !this.onNodePlacedCalled && (parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release()) != null) {
                    LayoutNode.requestRelayout$ui_release$default(parent$ui_release, false, 1, null);
                }
                this.relayoutWithoutParentInProgress = false;
            } catch (Throwable th) {
                this.relayoutWithoutParentInProgress = false;
                throw th;
            }
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public void requestLayout() {
            LayoutNode.requestRelayout$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, 1, null);
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public void requestMeasure() {
            LayoutNode.requestRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, false, false, 7, null);
        }

        public final void setChildDelegatesDirty$ui_release(boolean z5) {
            this.childDelegatesDirty = z5;
        }

        public final void setMeasuredByParent$ui_release(LayoutNode.UsageByParent usageByParent) {
            this.measuredByParent = usageByParent;
        }

        public void setPlaced$ui_release(boolean z5) {
            this.isPlaced = z5;
        }

        @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
        public void setPlacedUnderMotionFrameOfReference(boolean z5) {
            boolean isPlacedUnderMotionFrameOfReference = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getIsPlacedUnderMotionFrameOfReference();
            if (z5 != isPlacedUnderMotionFrameOfReference) {
                LayoutNodeLayoutDelegate.this.getOuterCoordinator().setPlacedUnderMotionFrameOfReference(isPlacedUnderMotionFrameOfReference);
                this.needsCoordinatesUpdate = true;
            }
            this.isPlacedUnderMotionFrameOfReference = z5;
        }

        public final boolean updateParentData() {
            if ((getParentData() == null && LayoutNodeLayoutDelegate.this.getOuterCoordinator().getParentData() == null) || !this.parentDataDirty) {
                return false;
            }
            this.parentDataDirty = false;
            this.parentData = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getParentData();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.compose.ui.layout.Placeable
        /* renamed from: placeAt-f8xVGno */
        public void mo1965placeAtf8xVGno(long position, float zIndex, GraphicsLayer layer) {
            m2025placeSelfMLgxB_4(position, zIndex, null, layer);
        }
    }

    public LayoutNodeLayoutDelegate(LayoutNode layoutNode) {
        this.layoutNode = layoutNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: performLookaheadMeasure-BRTryo0, reason: not valid java name */
    public final void m2017performLookaheadMeasureBRTryo0(final long constraints) {
        this.layoutState = LayoutNode.LayoutState.LookaheadMeasuring;
        this.lookaheadMeasurePending = false;
        OwnerSnapshotObserver.observeMeasureSnapshotReads$ui_release$default(LayoutNodeKt.requireOwner(this.layoutNode).getSnapshotObserver(), this.layoutNode, false, new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$performLookaheadMeasure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
                Intrinsics.checkNotNull(lookaheadDelegate);
                lookaheadDelegate.mo1946measureBRTryo0(constraints);
            }
        }, 2, null);
        markLookaheadLayoutPending$ui_release();
        if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(this.layoutNode)) {
            markLayoutPending$ui_release();
        } else {
            markMeasurePending$ui_release();
        }
        this.layoutState = LayoutNode.LayoutState.Idle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: performMeasure-BRTryo0, reason: not valid java name */
    public final void m2018performMeasureBRTryo0(long constraints) {
        LayoutNode.LayoutState layoutState = this.layoutState;
        LayoutNode.LayoutState layoutState2 = LayoutNode.LayoutState.Idle;
        if (!(layoutState == layoutState2)) {
            InlineClassHelperKt.throwIllegalStateException("layout state is not idle before measure starts");
        }
        LayoutNode.LayoutState layoutState3 = LayoutNode.LayoutState.Measuring;
        this.layoutState = layoutState3;
        this.measurePending = false;
        this.performMeasureConstraints = constraints;
        LayoutNodeKt.requireOwner(this.layoutNode).getSnapshotObserver().observeMeasureSnapshotReads$ui_release(this.layoutNode, false, this.performMeasureBlock);
        if (this.layoutState == layoutState3) {
            markLayoutPending$ui_release();
            this.layoutState = layoutState2;
        }
    }

    public final void ensureLookaheadDelegateCreated$ui_release() {
        if (this.lookaheadPassDelegate == null) {
            this.lookaheadPassDelegate = new LookaheadPassDelegate();
        }
    }

    public final AlignmentLinesOwner getAlignmentLinesOwner$ui_release() {
        return this.measurePassDelegate;
    }

    public final int getChildrenAccessingCoordinatesDuringPlacement() {
        return this.childrenAccessingCoordinatesDuringPlacement;
    }

    public final int getChildrenAccessingLookaheadCoordinatesDuringPlacement() {
        return this.childrenAccessingLookaheadCoordinatesDuringPlacement;
    }

    public final boolean getCoordinatesAccessedDuringModifierPlacement() {
        return this.coordinatesAccessedDuringModifierPlacement;
    }

    public final boolean getCoordinatesAccessedDuringPlacement() {
        return this.coordinatesAccessedDuringPlacement;
    }

    /* renamed from: getDetachedFromParentLookaheadPass$ui_release, reason: from getter */
    public final boolean getDetachedFromParentLookaheadPass() {
        return this.detachedFromParentLookaheadPass;
    }

    public final int getHeight$ui_release() {
        return this.measurePassDelegate.getHeight();
    }

    /* renamed from: getLastConstraints-DWUhwKw, reason: not valid java name */
    public final Constraints m2019getLastConstraintsDWUhwKw() {
        return this.measurePassDelegate.m2026getLastConstraintsDWUhwKw();
    }

    /* renamed from: getLastLookaheadConstraints-DWUhwKw, reason: not valid java name */
    public final Constraints m2020getLastLookaheadConstraintsDWUhwKw() {
        LookaheadPassDelegate lookaheadPassDelegate = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate != null) {
            return lookaheadPassDelegate.getLookaheadConstraints();
        }
        return null;
    }

    /* renamed from: getLayoutPending$ui_release, reason: from getter */
    public final boolean getLayoutPending() {
        return this.layoutPending;
    }

    /* renamed from: getLayoutState$ui_release, reason: from getter */
    public final LayoutNode.LayoutState getLayoutState() {
        return this.layoutState;
    }

    public final AlignmentLinesOwner getLookaheadAlignmentLinesOwner$ui_release() {
        return this.lookaheadPassDelegate;
    }

    public final boolean getLookaheadCoordinatesAccessedDuringModifierPlacement() {
        return this.lookaheadCoordinatesAccessedDuringModifierPlacement;
    }

    public final boolean getLookaheadCoordinatesAccessedDuringPlacement() {
        return this.lookaheadCoordinatesAccessedDuringPlacement;
    }

    /* renamed from: getLookaheadLayoutPending$ui_release, reason: from getter */
    public final boolean getLookaheadLayoutPending() {
        return this.lookaheadLayoutPending;
    }

    /* renamed from: getLookaheadMeasurePending$ui_release, reason: from getter */
    public final boolean getLookaheadMeasurePending() {
        return this.lookaheadMeasurePending;
    }

    /* renamed from: getLookaheadPassDelegate$ui_release, reason: from getter */
    public final LookaheadPassDelegate getLookaheadPassDelegate() {
        return this.lookaheadPassDelegate;
    }

    /* renamed from: getMeasurePassDelegate$ui_release, reason: from getter */
    public final MeasurePassDelegate getMeasurePassDelegate() {
        return this.measurePassDelegate;
    }

    /* renamed from: getMeasurePending$ui_release, reason: from getter */
    public final boolean getMeasurePending() {
        return this.measurePending;
    }

    public final NodeCoordinator getOuterCoordinator() {
        return this.layoutNode.getNodes().getOuterCoordinator();
    }

    public final int getWidth$ui_release() {
        return this.measurePassDelegate.getWidth();
    }

    public final void invalidateParentData() {
        this.measurePassDelegate.invalidateParentData();
        LookaheadPassDelegate lookaheadPassDelegate = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate != null) {
            lookaheadPassDelegate.invalidateParentData();
        }
    }

    public final void markChildrenDirty() {
        this.measurePassDelegate.setChildDelegatesDirty$ui_release(true);
        LookaheadPassDelegate lookaheadPassDelegate = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate != null) {
            lookaheadPassDelegate.setChildDelegatesDirty$ui_release(true);
        }
    }

    public final void markLayoutPending$ui_release() {
        this.layoutPending = true;
        this.layoutPendingForAlignment = true;
    }

    public final void markLookaheadLayoutPending$ui_release() {
        this.lookaheadLayoutPending = true;
        this.lookaheadLayoutPendingForAlignment = true;
    }

    public final void markLookaheadMeasurePending$ui_release() {
        this.lookaheadMeasurePending = true;
    }

    public final void markMeasurePending$ui_release() {
        this.measurePending = true;
    }

    public final void onCoordinatesUsed() {
        LayoutNode.LayoutState layoutState$ui_release = this.layoutNode.getLayoutState$ui_release();
        if (layoutState$ui_release == LayoutNode.LayoutState.LayingOut || layoutState$ui_release == LayoutNode.LayoutState.LookaheadLayingOut) {
            if (this.measurePassDelegate.getLayingOutChildren()) {
                setCoordinatesAccessedDuringPlacement(true);
            } else {
                setCoordinatesAccessedDuringModifierPlacement(true);
            }
        }
        if (layoutState$ui_release == LayoutNode.LayoutState.LookaheadLayingOut) {
            LookaheadPassDelegate lookaheadPassDelegate = this.lookaheadPassDelegate;
            if (lookaheadPassDelegate == null || !lookaheadPassDelegate.getLayingOutChildren()) {
                setLookaheadCoordinatesAccessedDuringModifierPlacement(true);
            } else {
                setLookaheadCoordinatesAccessedDuringPlacement(true);
            }
        }
    }

    public final void resetAlignmentLines() {
        AlignmentLines alignmentLines;
        this.measurePassDelegate.getAlignmentLines().reset$ui_release();
        LookaheadPassDelegate lookaheadPassDelegate = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate == null || (alignmentLines = lookaheadPassDelegate.getAlignmentLines()) == null) {
            return;
        }
        alignmentLines.reset$ui_release();
    }

    public final void setChildrenAccessingCoordinatesDuringPlacement(int i5) {
        int i6 = this.childrenAccessingCoordinatesDuringPlacement;
        this.childrenAccessingCoordinatesDuringPlacement = i5;
        if ((i6 == 0) != (i5 == 0)) {
            LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
            LayoutNodeLayoutDelegate layoutDelegate = parent$ui_release != null ? parent$ui_release.getLayoutDelegate() : null;
            if (layoutDelegate != null) {
                if (i5 == 0) {
                    layoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutDelegate.childrenAccessingCoordinatesDuringPlacement - 1);
                } else {
                    layoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutDelegate.childrenAccessingCoordinatesDuringPlacement + 1);
                }
            }
        }
    }

    public final void setChildrenAccessingLookaheadCoordinatesDuringPlacement(int i5) {
        int i6 = this.childrenAccessingLookaheadCoordinatesDuringPlacement;
        this.childrenAccessingLookaheadCoordinatesDuringPlacement = i5;
        if ((i6 == 0) != (i5 == 0)) {
            LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
            LayoutNodeLayoutDelegate layoutDelegate = parent$ui_release != null ? parent$ui_release.getLayoutDelegate() : null;
            if (layoutDelegate != null) {
                if (i5 == 0) {
                    layoutDelegate.setChildrenAccessingLookaheadCoordinatesDuringPlacement(layoutDelegate.childrenAccessingLookaheadCoordinatesDuringPlacement - 1);
                } else {
                    layoutDelegate.setChildrenAccessingLookaheadCoordinatesDuringPlacement(layoutDelegate.childrenAccessingLookaheadCoordinatesDuringPlacement + 1);
                }
            }
        }
    }

    public final void setCoordinatesAccessedDuringModifierPlacement(boolean z5) {
        if (this.coordinatesAccessedDuringModifierPlacement != z5) {
            this.coordinatesAccessedDuringModifierPlacement = z5;
            if (z5 && !this.coordinatesAccessedDuringPlacement) {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement + 1);
            } else {
                if (z5 || this.coordinatesAccessedDuringPlacement) {
                    return;
                }
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement - 1);
            }
        }
    }

    public final void setCoordinatesAccessedDuringPlacement(boolean z5) {
        if (this.coordinatesAccessedDuringPlacement != z5) {
            this.coordinatesAccessedDuringPlacement = z5;
            if (z5 && !this.coordinatesAccessedDuringModifierPlacement) {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement + 1);
            } else {
                if (z5 || this.coordinatesAccessedDuringModifierPlacement) {
                    return;
                }
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement - 1);
            }
        }
    }

    public final void setLookaheadCoordinatesAccessedDuringModifierPlacement(boolean z5) {
        if (this.lookaheadCoordinatesAccessedDuringModifierPlacement != z5) {
            this.lookaheadCoordinatesAccessedDuringModifierPlacement = z5;
            if (z5 && !this.lookaheadCoordinatesAccessedDuringPlacement) {
                setChildrenAccessingLookaheadCoordinatesDuringPlacement(this.childrenAccessingLookaheadCoordinatesDuringPlacement + 1);
            } else {
                if (z5 || this.lookaheadCoordinatesAccessedDuringPlacement) {
                    return;
                }
                setChildrenAccessingLookaheadCoordinatesDuringPlacement(this.childrenAccessingLookaheadCoordinatesDuringPlacement - 1);
            }
        }
    }

    public final void setLookaheadCoordinatesAccessedDuringPlacement(boolean z5) {
        if (this.lookaheadCoordinatesAccessedDuringPlacement != z5) {
            this.lookaheadCoordinatesAccessedDuringPlacement = z5;
            if (z5 && !this.lookaheadCoordinatesAccessedDuringModifierPlacement) {
                setChildrenAccessingLookaheadCoordinatesDuringPlacement(this.childrenAccessingLookaheadCoordinatesDuringPlacement + 1);
            } else {
                if (z5 || this.lookaheadCoordinatesAccessedDuringModifierPlacement) {
                    return;
                }
                setChildrenAccessingLookaheadCoordinatesDuringPlacement(this.childrenAccessingLookaheadCoordinatesDuringPlacement - 1);
            }
        }
    }

    public final void updateParentData() {
        LayoutNode parent$ui_release;
        if (this.measurePassDelegate.updateParentData() && (parent$ui_release = this.layoutNode.getParent$ui_release()) != null) {
            LayoutNode.requestRemeasure$ui_release$default(parent$ui_release, false, false, false, 7, null);
        }
        LookaheadPassDelegate lookaheadPassDelegate = this.lookaheadPassDelegate;
        if (lookaheadPassDelegate == null || !lookaheadPassDelegate.updateParentData()) {
            return;
        }
        if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(this.layoutNode)) {
            LayoutNode parent$ui_release2 = this.layoutNode.getParent$ui_release();
            if (parent$ui_release2 != null) {
                LayoutNode.requestRemeasure$ui_release$default(parent$ui_release2, false, false, false, 7, null);
                return;
            }
            return;
        }
        LayoutNode parent$ui_release3 = this.layoutNode.getParent$ui_release();
        if (parent$ui_release3 != null) {
            LayoutNode.requestLookaheadRemeasure$ui_release$default(parent$ui_release3, false, false, false, 7, null);
        }
    }
}
