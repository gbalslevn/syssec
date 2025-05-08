package androidx.compose.ui.layout;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.MotionReferencePlacementDelegate;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b'\u0018\u00002\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J8\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH$ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ*\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0012R$\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R0\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b8\u0004@DX\u0084\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R0\u0010$\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020#8\u0004@DX\u0084\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R*\u0010'\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00068\u0004@BX\u0084\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b'\u0010\u001e\u001a\u0004\b(\u0010 R\u0014\u0010*\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0018R\u0014\u0010,\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0018\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, d2 = {"Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measured;", "<init>", "()V", BuildConfig.FLAVOR, "onMeasuredSizeChanged", "Landroidx/compose/ui/unit/IntOffset;", "position", BuildConfig.FLAVOR, "zIndex", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "layerBlock", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeAt", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", BuildConfig.FLAVOR, "<set-?>", "width", "I", "getWidth", "()I", "height", "getHeight", "Landroidx/compose/ui/unit/IntSize;", "value", "measuredSize", "J", "getMeasuredSize-YbymL2g", "()J", "setMeasuredSize-ozmzZPI", "(J)V", "Landroidx/compose/ui/unit/Constraints;", "measurementConstraints", "getMeasurementConstraints-msEJaDk", "setMeasurementConstraints-BRTryo0", "apparentToRealOffset", "getApparentToRealOffset-nOcc-ac", "getMeasuredWidth", "measuredWidth", "getMeasuredHeight", "measuredHeight", "PlacementScope", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class Placeable implements Measured {
    private int height;
    private int width;
    private long measuredSize = IntSizeKt.IntSize(0, 0);
    private long measurementConstraints = PlaceableKt.access$getDefaultConstraints$p();
    private long apparentToRealOffset = IntOffset.INSTANCE.m2648getZeronOccac();

    private final void onMeasuredSizeChanged() {
        this.width = RangesKt.coerceIn(IntSize.m2661getWidthimpl(this.measuredSize), Constraints.m2580getMinWidthimpl(this.measurementConstraints), Constraints.m2578getMaxWidthimpl(this.measurementConstraints));
        this.height = RangesKt.coerceIn(IntSize.m2660getHeightimpl(this.measuredSize), Constraints.m2579getMinHeightimpl(this.measurementConstraints), Constraints.m2577getMaxHeightimpl(this.measurementConstraints));
        this.apparentToRealOffset = IntOffsetKt.IntOffset((this.width - IntSize.m2661getWidthimpl(this.measuredSize)) / 2, (this.height - IntSize.m2660getHeightimpl(this.measuredSize)) / 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: getApparentToRealOffset-nOcc-ac, reason: not valid java name and from getter */
    public final long getApparentToRealOffset() {
        return this.apparentToRealOffset;
    }

    public final int getHeight() {
        return this.height;
    }

    public int getMeasuredHeight() {
        return IntSize.m2660getHeightimpl(this.measuredSize);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: getMeasuredSize-YbymL2g, reason: not valid java name and from getter */
    public final long getMeasuredSize() {
        return this.measuredSize;
    }

    public int getMeasuredWidth() {
        return IntSize.m2661getWidthimpl(this.measuredSize);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: getMeasurementConstraints-msEJaDk, reason: not valid java name and from getter */
    public final long getMeasurementConstraints() {
        return this.measurementConstraints;
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno, reason: not valid java name */
    public void mo1965placeAtf8xVGno(long position, float zIndex, GraphicsLayer layer) {
        mo1947placeAtf8xVGno(position, zIndex, (Function1<? super GraphicsLayerScope, Unit>) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: placeAt-f8xVGno */
    public abstract void mo1947placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: setMeasuredSize-ozmzZPI, reason: not valid java name */
    public final void m1966setMeasuredSizeozmzZPI(long j5) {
        if (IntSize.m2659equalsimpl0(this.measuredSize, j5)) {
            return;
        }
        this.measuredSize = j5;
        onMeasuredSizeChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: setMeasurementConstraints-BRTryo0, reason: not valid java name */
    public final void m1967setMeasurementConstraintsBRTryo0(long j5) {
        if (Constraints.m2572equalsimpl0(this.measurementConstraints, j5)) {
            return;
        }
        this.measurementConstraints = j5;
        onMeasuredSizeChanged();
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u000e\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ+\u0010\u000e\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u0012J+\u0010\u0013\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0012J&\u0010\u0013\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\rJ<\u0010\u001a\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\u0015ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019JA\u0010\u001a\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\u0015¢\u0006\u0004\b\u001a\u0010\u001bJA\u0010\u001c\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\u0015¢\u0006\u0004\b\u001c\u0010\u001bJ<\u0010\u001c\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\u0015ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0019J.\u0010\u001c\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010\u000b\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010 J.\u0010\u001a\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010\u000b\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\b\u0018\u0010 J!\u0010\"\u001a\u00020\u00052\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00050\u0015¢\u0006\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u000f8$X¤\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8$X¤\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006."}, d2 = {"Landroidx/compose/ui/layout/Placeable$PlacementScope;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/layout/Placeable;", BuildConfig.FLAVOR, "handleMotionFrameOfReferencePlacement", "(Landroidx/compose/ui/layout/Placeable;)V", "Landroidx/compose/ui/unit/IntOffset;", "position", BuildConfig.FLAVOR, "zIndex", "placeRelative-70tqf50", "(Landroidx/compose/ui/layout/Placeable;JF)V", "placeRelative", BuildConfig.FLAVOR, "x", "y", "(Landroidx/compose/ui/layout/Placeable;IIF)V", "place", "place-70tqf50", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "layerBlock", "placeRelativeWithLayer-aW-9-wM", "(Landroidx/compose/ui/layout/Placeable;JFLkotlin/jvm/functions/Function1;)V", "placeRelativeWithLayer", "(Landroidx/compose/ui/layout/Placeable;IIFLkotlin/jvm/functions/Function1;)V", "placeWithLayer", "placeWithLayer-aW-9-wM", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "layer", "(Landroidx/compose/ui/layout/Placeable;JLandroidx/compose/ui/graphics/layer/GraphicsLayer;F)V", "block", "withMotionFrameOfReferencePlacement", "(Lkotlin/jvm/functions/Function1;)V", BuildConfig.FLAVOR, "motionFrameOfReferencePlacement", "Z", "getParentWidth", "()I", "parentWidth", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "parentLayoutDirection", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static abstract class PlacementScope {
        private boolean motionFrameOfReferencePlacement;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public final void handleMotionFrameOfReferencePlacement(Placeable placeable) {
            if (placeable instanceof MotionReferencePlacementDelegate) {
                ((MotionReferencePlacementDelegate) placeable).setPlacedUnderMotionFrameOfReference(this.motionFrameOfReferencePlacement);
            }
        }

        public static /* synthetic */ void place$default(PlacementScope placementScope, Placeable placeable, int i5, int i6, float f5, int i7, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place");
            }
            if ((i7 & 4) != 0) {
                f5 = 0.0f;
            }
            placementScope.place(placeable, i5, i6, f5);
        }

        /* renamed from: place-70tqf50$default, reason: not valid java name */
        public static /* synthetic */ void m1968place70tqf50$default(PlacementScope placementScope, Placeable placeable, long j5, float f5, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place-70tqf50");
            }
            if ((i5 & 2) != 0) {
                f5 = 0.0f;
            }
            placementScope.m1974place70tqf50(placeable, j5, f5);
        }

        public static /* synthetic */ void placeRelative$default(PlacementScope placementScope, Placeable placeable, int i5, int i6, float f5, int i7, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative");
            }
            if ((i7 & 4) != 0) {
                f5 = 0.0f;
            }
            placementScope.placeRelative(placeable, i5, i6, f5);
        }

        /* renamed from: placeRelative-70tqf50$default, reason: not valid java name */
        public static /* synthetic */ void m1969placeRelative70tqf50$default(PlacementScope placementScope, Placeable placeable, long j5, float f5, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative-70tqf50");
            }
            if ((i5 & 2) != 0) {
                f5 = 0.0f;
            }
            placementScope.m1975placeRelative70tqf50(placeable, j5, f5);
        }

        public static /* synthetic */ void placeRelativeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i5, int i6, float f5, Function1 function1, int i7, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
            }
            if ((i7 & 4) != 0) {
                f5 = 0.0f;
            }
            float f6 = f5;
            if ((i7 & 8) != 0) {
                function1 = PlaceableKt.access$getDefaultLayerBlock$p();
            }
            placementScope.placeRelativeWithLayer(placeable, i5, i6, f6, function1);
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m1970placeRelativeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j5, float f5, Function1 function1, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            }
            if ((i5 & 2) != 0) {
                f5 = 0.0f;
            }
            float f6 = f5;
            if ((i5 & 4) != 0) {
                function1 = PlaceableKt.access$getDefaultLayerBlock$p();
            }
            placementScope.m1976placeRelativeWithLayeraW9wM(placeable, j5, f6, (Function1<? super GraphicsLayerScope, Unit>) function1);
        }

        public static /* synthetic */ void placeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i5, int i6, float f5, Function1 function1, int i7, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
            }
            if ((i7 & 4) != 0) {
                f5 = 0.0f;
            }
            float f6 = f5;
            if ((i7 & 8) != 0) {
                function1 = PlaceableKt.access$getDefaultLayerBlock$p();
            }
            placementScope.placeWithLayer(placeable, i5, i6, f6, function1);
        }

        /* renamed from: placeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m1972placeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j5, float f5, Function1 function1, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            }
            if ((i5 & 2) != 0) {
                f5 = 0.0f;
            }
            float f6 = f5;
            if ((i5 & 4) != 0) {
                function1 = PlaceableKt.access$getDefaultLayerBlock$p();
            }
            placementScope.m1978placeWithLayeraW9wM(placeable, j5, f6, (Function1<? super GraphicsLayerScope, Unit>) function1);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract LayoutDirection getParentLayoutDirection();

        /* JADX INFO: Access modifiers changed from: protected */
        public abstract int getParentWidth();

        public final void place(Placeable placeable, int i5, int i6, float f5) {
            long IntOffset = IntOffsetKt.IntOffset(i5, i6);
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo1947placeAtf8xVGno(IntOffset.m2644plusqkQi6aY(IntOffset, placeable.apparentToRealOffset), f5, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        /* renamed from: place-70tqf50, reason: not valid java name */
        public final void m1974place70tqf50(Placeable placeable, long j5, float f5) {
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo1947placeAtf8xVGno(IntOffset.m2644plusqkQi6aY(j5, placeable.apparentToRealOffset), f5, (Function1<? super GraphicsLayerScope, Unit>) null);
        }

        public final void placeRelative(Placeable placeable, int i5, int i6, float f5) {
            long IntOffset = IntOffsetKt.IntOffset(i5, i6);
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo1947placeAtf8xVGno(IntOffset.m2644plusqkQi6aY(IntOffset, placeable.apparentToRealOffset), f5, (Function1<? super GraphicsLayerScope, Unit>) null);
            } else {
                long IntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m2640getXimpl(IntOffset), IntOffset.m2641getYimpl(IntOffset));
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo1947placeAtf8xVGno(IntOffset.m2644plusqkQi6aY(IntOffset2, placeable.apparentToRealOffset), f5, (Function1<? super GraphicsLayerScope, Unit>) null);
            }
        }

        /* renamed from: placeRelative-70tqf50, reason: not valid java name */
        public final void m1975placeRelative70tqf50(Placeable placeable, long j5, float f5) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo1947placeAtf8xVGno(IntOffset.m2644plusqkQi6aY(j5, placeable.apparentToRealOffset), f5, (Function1<? super GraphicsLayerScope, Unit>) null);
            } else {
                long IntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m2640getXimpl(j5), IntOffset.m2641getYimpl(j5));
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo1947placeAtf8xVGno(IntOffset.m2644plusqkQi6aY(IntOffset, placeable.apparentToRealOffset), f5, (Function1<? super GraphicsLayerScope, Unit>) null);
            }
        }

        public final void placeRelativeWithLayer(Placeable placeable, int i5, int i6, float f5, Function1<? super GraphicsLayerScope, Unit> function1) {
            long IntOffset = IntOffsetKt.IntOffset(i5, i6);
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo1947placeAtf8xVGno(IntOffset.m2644plusqkQi6aY(IntOffset, placeable.apparentToRealOffset), f5, function1);
            } else {
                long IntOffset2 = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m2640getXimpl(IntOffset), IntOffset.m2641getYimpl(IntOffset));
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo1947placeAtf8xVGno(IntOffset.m2644plusqkQi6aY(IntOffset2, placeable.apparentToRealOffset), f5, function1);
            }
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m1976placeRelativeWithLayeraW9wM(Placeable placeable, long j5, float f5, Function1<? super GraphicsLayerScope, Unit> function1) {
            if (getParentLayoutDirection() != LayoutDirection.Ltr && getParentWidth() != 0) {
                long IntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m2640getXimpl(j5), IntOffset.m2641getYimpl(j5));
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo1947placeAtf8xVGno(IntOffset.m2644plusqkQi6aY(IntOffset, placeable.apparentToRealOffset), f5, function1);
            } else {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo1947placeAtf8xVGno(IntOffset.m2644plusqkQi6aY(j5, placeable.apparentToRealOffset), f5, function1);
            }
        }

        public final void placeWithLayer(Placeable placeable, int i5, int i6, float f5, Function1<? super GraphicsLayerScope, Unit> function1) {
            long IntOffset = IntOffsetKt.IntOffset(i5, i6);
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo1947placeAtf8xVGno(IntOffset.m2644plusqkQi6aY(IntOffset, placeable.apparentToRealOffset), f5, function1);
        }

        /* renamed from: placeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m1978placeWithLayeraW9wM(Placeable placeable, long j5, float f5, Function1<? super GraphicsLayerScope, Unit> function1) {
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo1947placeAtf8xVGno(IntOffset.m2644plusqkQi6aY(j5, placeable.apparentToRealOffset), f5, function1);
        }

        public final void withMotionFrameOfReferencePlacement(Function1<? super PlacementScope, Unit> block) {
            this.motionFrameOfReferencePlacement = true;
            block.invoke(this);
            this.motionFrameOfReferencePlacement = false;
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m1971placeRelativeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j5, GraphicsLayer graphicsLayer, float f5, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            }
            if ((i5 & 4) != 0) {
                f5 = 0.0f;
            }
            placementScope.m1977placeRelativeWithLayeraW9wM(placeable, j5, graphicsLayer, f5);
        }

        /* renamed from: placeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m1973placeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j5, GraphicsLayer graphicsLayer, float f5, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            }
            if ((i5 & 4) != 0) {
                f5 = 0.0f;
            }
            placementScope.m1979placeWithLayeraW9wM(placeable, j5, graphicsLayer, f5);
        }

        /* renamed from: placeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m1979placeWithLayeraW9wM(Placeable placeable, long j5, GraphicsLayer graphicsLayer, float f5) {
            handleMotionFrameOfReferencePlacement(placeable);
            placeable.mo1965placeAtf8xVGno(IntOffset.m2644plusqkQi6aY(j5, placeable.apparentToRealOffset), f5, graphicsLayer);
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m1977placeRelativeWithLayeraW9wM(Placeable placeable, long j5, GraphicsLayer graphicsLayer, float f5) {
            if (getParentLayoutDirection() != LayoutDirection.Ltr && getParentWidth() != 0) {
                long IntOffset = IntOffsetKt.IntOffset((getParentWidth() - placeable.getWidth()) - IntOffset.m2640getXimpl(j5), IntOffset.m2641getYimpl(j5));
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo1965placeAtf8xVGno(IntOffset.m2644plusqkQi6aY(IntOffset, placeable.apparentToRealOffset), f5, graphicsLayer);
            } else {
                handleMotionFrameOfReferencePlacement(placeable);
                placeable.mo1965placeAtf8xVGno(IntOffset.m2644plusqkQi6aY(j5, placeable.apparentToRealOffset), f5, graphicsLayer);
            }
        }
    }
}
