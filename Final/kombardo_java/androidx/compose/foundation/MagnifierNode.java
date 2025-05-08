package androidx.compose.foundation;

import android.view.View;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0091\u0001\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ\u0088\u0001\u0010!\u001a\u00020\f2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00102\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u0017ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020\fH\u0016¢\u0006\u0004\b\"\u0010\u001cJ\u000f\u0010#\u001a\u00020\fH\u0016¢\u0006\u0004\b#\u0010\u001cJ\u000f\u0010$\u001a\u00020\fH\u0016¢\u0006\u0004\b$\u0010\u001cJ\u0013\u0010&\u001a\u00020\f*\u00020%H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\f2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u0013\u0010-\u001a\u00020\f*\u00020,H\u0016¢\u0006\u0004\b-\u0010.R.\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R0\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010/\u001a\u0004\b4\u00101\"\u0004\b5\u00103R0\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010/\u001a\u0004\b6\u00101\"\u0004\b7\u00103R\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR(\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0012\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR(\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0014\u00108\u001a\u0004\bG\u0010:\"\u0004\bH\u0010<R(\u0010\u0015\u001a\u00020\u00138\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0015\u00108\u001a\u0004\bI\u0010:\"\u0004\bJ\u0010<R\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010=\u001a\u0004\bK\u0010?\"\u0004\bL\u0010AR\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0018\u0010S\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010U\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010X\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR/\u0010`\u001a\u0004\u0018\u00010(2\b\u0010Z\u001a\u0004\u0018\u00010(8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010+R\u001e\u0010b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u001c\u0010d\u001a\u00020\b8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\bd\u0010BR\u001e\u0010f\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\bf\u0010gR\u001e\u0010i\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u001a\u0010l\u001a\u00020\b8BX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bk\u0010D\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006m"}, d2 = {"Landroidx/compose/foundation/MagnifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/geometry/Offset;", "sourceCenter", "magnifierCenter", "Landroidx/compose/ui/unit/DpSize;", BuildConfig.FLAVOR, "onSizeChanged", BuildConfig.FLAVOR, "zoom", BuildConfig.FLAVOR, "useTextDefault", "size", "Landroidx/compose/ui/unit/Dp;", "cornerRadius", "elevation", "clippingEnabled", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "platformMagnifierFactory", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLandroidx/compose/foundation/PlatformMagnifierFactory;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "recreateMagnifier", "()V", "updateMagnifier", "updateSizeIfNecessary", "update-5F03MCQ", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FZJFFZLkotlin/jvm/functions/Function1;Landroidx/compose/foundation/PlatformMagnifierFactory;)V", "update", "onAttach", "onDetach", "onObservedReadsChanged", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "draw", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;)V", "Landroidx/compose/ui/layout/LayoutCoordinates;", "coordinates", "onGloballyPositioned", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "applySemantics", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)V", "Lkotlin/jvm/functions/Function1;", "getSourceCenter", "()Lkotlin/jvm/functions/Function1;", "setSourceCenter", "(Lkotlin/jvm/functions/Function1;)V", "getMagnifierCenter", "setMagnifierCenter", "getOnSizeChanged", "setOnSizeChanged", "F", "getZoom", "()F", "setZoom", "(F)V", "Z", "getUseTextDefault", "()Z", "setUseTextDefault", "(Z)V", "J", "getSize-MYxV2XQ", "()J", "setSize-EaSLcWc", "(J)V", "getCornerRadius-D9Ej5fM", "setCornerRadius-0680j_4", "getElevation-D9Ej5fM", "setElevation-0680j_4", "getClippingEnabled", "setClippingEnabled", "Landroidx/compose/foundation/PlatformMagnifierFactory;", "getPlatformMagnifierFactory", "()Landroidx/compose/foundation/PlatformMagnifierFactory;", "setPlatformMagnifierFactory", "(Landroidx/compose/foundation/PlatformMagnifierFactory;)V", "Landroid/view/View;", "view", "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/foundation/PlatformMagnifier;", "magnifier", "Landroidx/compose/foundation/PlatformMagnifier;", "<set-?>", "layoutCoordinates$delegate", "Landroidx/compose/runtime/MutableState;", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates", "layoutCoordinates", "Landroidx/compose/runtime/State;", "anchorPositionInRootState", "Landroidx/compose/runtime/State;", "sourceCenterInRoot", "Landroidx/compose/ui/unit/IntSize;", "previousSize", "Landroidx/compose/ui/unit/IntSize;", "Lkotlinx/coroutines/channels/Channel;", "drawSignalChannel", "Lkotlinx/coroutines/channels/Channel;", "getAnchorPositionInRoot-F1C5BW0", "anchorPositionInRoot", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MagnifierNode extends Modifier.Node implements GlobalPositionAwareModifierNode, DrawModifierNode, SemanticsModifierNode, ObserverModifierNode {
    private State<Offset> anchorPositionInRootState;
    private boolean clippingEnabled;
    private float cornerRadius;
    private Density density;
    private Channel<Unit> drawSignalChannel;
    private float elevation;

    /* renamed from: layoutCoordinates$delegate, reason: from kotlin metadata */
    private final MutableState layoutCoordinates;
    private PlatformMagnifier magnifier;
    private Function1<? super Density, Offset> magnifierCenter;
    private Function1<? super DpSize, Unit> onSizeChanged;
    private PlatformMagnifierFactory platformMagnifierFactory;
    private IntSize previousSize;
    private long size;
    private Function1<? super Density, Offset> sourceCenter;
    private long sourceCenterInRoot;
    private boolean useTextDefault;
    private View view;
    private float zoom;

    public /* synthetic */ MagnifierNode(Function1 function1, Function1 function12, Function1 function13, float f5, boolean z5, long j5, float f6, float f7, boolean z6, PlatformMagnifierFactory platformMagnifierFactory, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function12, function13, f5, z5, j5, f6, f7, z6, platformMagnifierFactory);
    }

    /* renamed from: getAnchorPositionInRoot-F1C5BW0, reason: not valid java name */
    private final long m139getAnchorPositionInRootF1C5BW0() {
        if (this.anchorPositionInRootState == null) {
            this.anchorPositionInRootState = SnapshotStateKt.derivedStateOf(new Function0<Offset>() { // from class: androidx.compose.foundation.MagnifierNode$anchorPositionInRoot$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Offset invoke() {
                    return Offset.m1328boximpl(m141invokeF1C5BW0());
                }

                /* renamed from: invoke-F1C5BW0, reason: not valid java name */
                public final long m141invokeF1C5BW0() {
                    LayoutCoordinates layoutCoordinates;
                    layoutCoordinates = MagnifierNode.this.getLayoutCoordinates();
                    return layoutCoordinates != null ? LayoutCoordinatesKt.positionInRoot(layoutCoordinates) : Offset.INSTANCE.m1348getUnspecifiedF1C5BW0();
                }
            });
        }
        State<Offset> state = this.anchorPositionInRootState;
        return state != null ? state.getValue().getPackedValue() : Offset.INSTANCE.m1348getUnspecifiedF1C5BW0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates getLayoutCoordinates() {
        return (LayoutCoordinates) this.layoutCoordinates.getValue();
    }

    private final void recreateMagnifier() {
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier != null) {
            platformMagnifier.dismiss();
        }
        View view = this.view;
        if (view == null) {
            view = DelegatableNode_androidKt.requireView(this);
        }
        View view2 = view;
        this.view = view2;
        Density density = this.density;
        if (density == null) {
            density = DelegatableNodeKt.requireDensity(this);
        }
        Density density2 = density;
        this.density = density2;
        this.magnifier = this.platformMagnifierFactory.mo148createnHHXs2Y(view2, this.useTextDefault, this.size, this.cornerRadius, this.elevation, this.clippingEnabled, density2, this.zoom);
        updateSizeIfNecessary();
    }

    private final void setLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        this.layoutCoordinates.setValue(layoutCoordinates);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateMagnifier() {
        long m1348getUnspecifiedF1C5BW0;
        PlatformMagnifier platformMagnifier;
        Density density = this.density;
        if (density == null) {
            density = DelegatableNodeKt.requireDensity(this);
            this.density = density;
        }
        long packedValue = this.sourceCenter.invoke(density).getPackedValue();
        if (!OffsetKt.m1351isSpecifiedk4lQ0M(packedValue) || !OffsetKt.m1351isSpecifiedk4lQ0M(m139getAnchorPositionInRootF1C5BW0())) {
            this.sourceCenterInRoot = Offset.INSTANCE.m1348getUnspecifiedF1C5BW0();
            PlatformMagnifier platformMagnifier2 = this.magnifier;
            if (platformMagnifier2 != null) {
                platformMagnifier2.dismiss();
                return;
            }
            return;
        }
        this.sourceCenterInRoot = Offset.m1342plusMKHz9U(m139getAnchorPositionInRootF1C5BW0(), packedValue);
        Function1<? super Density, Offset> function1 = this.magnifierCenter;
        if (function1 != null) {
            Offset m1328boximpl = Offset.m1328boximpl(function1.invoke(density).getPackedValue());
            if (!OffsetKt.m1351isSpecifiedk4lQ0M(m1328boximpl.getPackedValue())) {
                m1328boximpl = null;
            }
            if (m1328boximpl != null) {
                m1348getUnspecifiedF1C5BW0 = Offset.m1342plusMKHz9U(m139getAnchorPositionInRootF1C5BW0(), m1328boximpl.getPackedValue());
                long j5 = m1348getUnspecifiedF1C5BW0;
                if (this.magnifier == null) {
                    recreateMagnifier();
                }
                platformMagnifier = this.magnifier;
                if (platformMagnifier != null) {
                    platformMagnifier.mo147updateWko1d7g(this.sourceCenterInRoot, j5, this.zoom);
                }
                updateSizeIfNecessary();
            }
        }
        m1348getUnspecifiedF1C5BW0 = Offset.INSTANCE.m1348getUnspecifiedF1C5BW0();
        long j52 = m1348getUnspecifiedF1C5BW0;
        if (this.magnifier == null) {
        }
        platformMagnifier = this.magnifier;
        if (platformMagnifier != null) {
        }
        updateSizeIfNecessary();
    }

    private final void updateSizeIfNecessary() {
        Density density;
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier == null || (density = this.density) == null || IntSize.m2658equalsimpl(platformMagnifier.mo146getSizeYbymL2g(), this.previousSize)) {
            return;
        }
        Function1<? super DpSize, Unit> function1 = this.onSizeChanged;
        if (function1 != null) {
            function1.invoke(DpSize.m2621boximpl(density.mo210toDpSizekrfVVM(IntSizeKt.m2668toSizeozmzZPI(platformMagnifier.mo146getSizeYbymL2g()))));
        }
        this.previousSize = IntSize.m2656boximpl(platformMagnifier.mo146getSizeYbymL2g());
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(Magnifier_androidKt.getMagnifierPositionInRoot(), new Function0<Offset>() { // from class: androidx.compose.foundation.MagnifierNode$applySemantics$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Offset invoke() {
                return Offset.m1328boximpl(m142invokeF1C5BW0());
            }

            /* renamed from: invoke-F1C5BW0, reason: not valid java name */
            public final long m142invokeF1C5BW0() {
                long j5;
                j5 = MagnifierNode.this.sourceCenterInRoot;
                return j5;
            }
        });
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        Channel<Unit> channel = this.drawSignalChannel;
        if (channel != null) {
            ChannelResult.m3768boximpl(channel.mo3767trySendJP2dKIU(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        onObservedReadsChanged();
        this.drawSignalChannel = ChannelKt.Channel$default(0, null, null, 7, null);
        BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new MagnifierNode$onAttach$1(this, null), 3, null);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        PlatformMagnifier platformMagnifier = this.magnifier;
        if (platformMagnifier != null) {
            platformMagnifier.dismiss();
        }
        this.magnifier = null;
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        setLayoutCoordinates(coordinates);
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public void onObservedReadsChanged() {
        ObserverModifierNodeKt.observeReads(this, new Function0<Unit>() { // from class: androidx.compose.foundation.MagnifierNode$onObservedReadsChanged$1
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
                MagnifierNode.this.updateMagnifier();
            }
        });
    }

    /* renamed from: update-5F03MCQ, reason: not valid java name */
    public final void m140update5F03MCQ(Function1<? super Density, Offset> sourceCenter, Function1<? super Density, Offset> magnifierCenter, float zoom, boolean useTextDefault, long size, float cornerRadius, float elevation, boolean clippingEnabled, Function1<? super DpSize, Unit> onSizeChanged, PlatformMagnifierFactory platformMagnifierFactory) {
        float f5 = this.zoom;
        long j5 = this.size;
        float f6 = this.cornerRadius;
        boolean z5 = this.useTextDefault;
        float f7 = this.elevation;
        boolean z6 = this.clippingEnabled;
        PlatformMagnifierFactory platformMagnifierFactory2 = this.platformMagnifierFactory;
        View view = this.view;
        Density density = this.density;
        this.sourceCenter = sourceCenter;
        this.magnifierCenter = magnifierCenter;
        this.zoom = zoom;
        this.useTextDefault = useTextDefault;
        this.size = size;
        this.cornerRadius = cornerRadius;
        this.elevation = elevation;
        this.clippingEnabled = clippingEnabled;
        this.onSizeChanged = onSizeChanged;
        this.platformMagnifierFactory = platformMagnifierFactory;
        View requireView = DelegatableNode_androidKt.requireView(this);
        Density requireDensity = DelegatableNodeKt.requireDensity(this);
        if (this.magnifier != null && ((!Magnifier_androidKt.equalsIncludingNaN(zoom, f5) && !platformMagnifierFactory.getCanUpdateZoom()) || !DpSize.m2624equalsimpl0(size, j5) || !Dp.m2601equalsimpl0(cornerRadius, f6) || !Dp.m2601equalsimpl0(elevation, f7) || useTextDefault != z5 || clippingEnabled != z6 || !Intrinsics.areEqual(platformMagnifierFactory, platformMagnifierFactory2) || !Intrinsics.areEqual(requireView, view) || !Intrinsics.areEqual(requireDensity, density))) {
            recreateMagnifier();
        }
        updateMagnifier();
    }

    private MagnifierNode(Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function12, Function1<? super DpSize, Unit> function13, float f5, boolean z5, long j5, float f6, float f7, boolean z6, PlatformMagnifierFactory platformMagnifierFactory) {
        this.sourceCenter = function1;
        this.magnifierCenter = function12;
        this.onSizeChanged = function13;
        this.zoom = f5;
        this.useTextDefault = z5;
        this.size = j5;
        this.cornerRadius = f6;
        this.elevation = f7;
        this.clippingEnabled = z6;
        this.platformMagnifierFactory = platformMagnifierFactory;
        this.layoutCoordinates = SnapshotStateKt.mutableStateOf(null, SnapshotStateKt.neverEqualPolicy());
        this.sourceCenterInRoot = Offset.INSTANCE.m1348getUnspecifiedF1C5BW0();
    }
}
