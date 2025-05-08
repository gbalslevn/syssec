package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0003IJKB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010(\u001a\u0004\u0018\u00010\u00072\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u000bJ1\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\u000b2\u0012\b\u0002\u0010.\u001a\f0\u0010R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002¢\u0006\u0002\u0010/J\u0082\u0001\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b2\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\f\u001a\u00020\r2\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u0000062\u0006\u00107\u001a\u00020#2\u0006\u00108\u001a\u00020#2\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@J\u0010\u0010A\u001a\u00020,2\u0006\u0010)\u001a\u00020\u0003H\u0002J\u0006\u0010B\u001a\u00020,J\u001f\u0010C\u001a\u00020,2\u0006\u0010-\u001a\u00028\u00002\b\b\u0002\u0010D\u001a\u00020#H\u0002¢\u0006\u0002\u0010EJ\u0019\u0010F\u001a\u00020\u000b*\u00020G2\u0006\u0010-\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010HR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f0\u0010R\b\u0012\u0004\u0012\u00028\u00000\u00000\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\u00020\u00128Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001f\u001a\u00020\u000b*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0018\u0010\"\u001a\u00020#*\u00028\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0018\u0010&\u001a\u00020\u000b*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010!\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006L"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "T", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", BuildConfig.FLAVOR, "()V", "disappearingItems", BuildConfig.FLAVOR, "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "displayingNode", "Landroidx/compose/ui/node/DrawModifierNode;", "firstVisibleIndex", BuildConfig.FLAVOR, "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "keyToItemInfoMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;", "minSizeToFitDisappearingItems", "Landroidx/compose/ui/unit/IntSize;", "getMinSizeToFitDisappearingItems-YbymL2g", "()J", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "movingAwayKeys", "Landroidx/collection/MutableScatterSet;", "movingAwayToEndBound", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "crossAxisOffset", "getCrossAxisOffset", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "hasAnimations", BuildConfig.FLAVOR, "getHasAnimations", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)Z", "mainAxisOffset", "getMainAxisOffset", "getAnimation", "key", "placeableIndex", "initializeAnimation", BuildConfig.FLAVOR, "item", "itemInfo", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;ILandroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;)V", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItemProvider;", "isVertical", "isLookingAhead", "laneCount", "hasLookaheadOccurred", "layoutMinOffset", "layoutMaxOffset", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "removeInfoForKey", "reset", "startPlacementAnimationsIfNeeded", "isMovingAway", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;Z)V", "updateAndReturnOffsetFor", BuildConfig.FLAVOR, "([ILandroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "DisplayingDisappearingItemsElement", "DisplayingDisappearingItemsNode", "ItemInfo", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyLayoutItemAnimator<T extends LazyLayoutMeasuredItem> {
    private DrawModifierNode displayingNode;
    private int firstVisibleIndex;
    private LazyLayoutKeyIndexMap keyIndexMap;
    private final MutableScatterMap<Object, LazyLayoutItemAnimator<T>.ItemInfo> keyToItemInfoMap = ScatterMapKt.mutableScatterMapOf();
    private final MutableScatterSet<Object> movingAwayKeys = ScatterSetKt.mutableScatterSetOf();
    private final List<T> movingInFromStartBound = new ArrayList();
    private final List<T> movingInFromEndBound = new ArrayList();
    private final List<T> movingAwayToStartBound = new ArrayList();
    private final List<T> movingAwayToEndBound = new ArrayList();
    private final List<LazyLayoutItemAnimation> disappearingItems = new ArrayList();
    private final Modifier modifier = new DisplayingDisappearingItemsElement(this);

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsNode;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "animator", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "create", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsNode;", "node", BuildConfig.FLAVOR, "update", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsNode;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    private static final /* data */ class DisplayingDisappearingItemsElement extends ModifierNodeElement<DisplayingDisappearingItemsNode> {
        private final LazyLayoutItemAnimator<?> animator;

        public DisplayingDisappearingItemsElement(LazyLayoutItemAnimator<?> lazyLayoutItemAnimator) {
            this.animator = lazyLayoutItemAnimator;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DisplayingDisappearingItemsElement) && Intrinsics.areEqual(this.animator, ((DisplayingDisappearingItemsElement) other).animator);
        }

        public int hashCode() {
            return this.animator.hashCode();
        }

        public String toString() {
            return "DisplayingDisappearingItemsElement(animator=" + this.animator + ')';
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // androidx.compose.ui.node.ModifierNodeElement
        /* renamed from: create */
        public DisplayingDisappearingItemsNode getNode() {
            return new DisplayingDisappearingItemsNode(this.animator);
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public void update(DisplayingDisappearingItemsNode node) {
            node.setAnimator(this.animator);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\u00020\b*\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u000e\u001a\u00020\b2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u000e\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u001a¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$DisplayingDisappearingItemsNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "animator", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", BuildConfig.FLAVOR, "draw", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;)V", "onAttach", "()V", "onDetach", "setAnimator", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* data */ class DisplayingDisappearingItemsNode extends Modifier.Node implements DrawModifierNode {
        private LazyLayoutItemAnimator<?> animator;

        public DisplayingDisappearingItemsNode(LazyLayoutItemAnimator<?> lazyLayoutItemAnimator) {
            this.animator = lazyLayoutItemAnimator;
        }

        @Override // androidx.compose.ui.node.DrawModifierNode
        public void draw(ContentDrawScope contentDrawScope) {
            List list = ((LazyLayoutItemAnimator) this.animator).disappearingItems;
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                LazyLayoutItemAnimation lazyLayoutItemAnimation = (LazyLayoutItemAnimation) list.get(i5);
                GraphicsLayer layer = lazyLayoutItemAnimation.getLayer();
                if (layer != null) {
                    float m2640getXimpl = IntOffset.m2640getXimpl(lazyLayoutItemAnimation.m409getFinalOffsetnOccac());
                    float m2640getXimpl2 = m2640getXimpl - IntOffset.m2640getXimpl(layer.getTopLeft());
                    float m2641getYimpl = IntOffset.m2641getYimpl(lazyLayoutItemAnimation.m409getFinalOffsetnOccac()) - IntOffset.m2641getYimpl(layer.getTopLeft());
                    contentDrawScope.getDrawContext().getTransform().translate(m2640getXimpl2, m2641getYimpl);
                    try {
                        GraphicsLayerKt.drawLayer(contentDrawScope, layer);
                    } finally {
                        contentDrawScope.getDrawContext().getTransform().translate(-m2640getXimpl2, -m2641getYimpl);
                    }
                }
            }
            contentDrawScope.drawContent();
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DisplayingDisappearingItemsNode) && Intrinsics.areEqual(this.animator, ((DisplayingDisappearingItemsNode) other).animator);
        }

        public int hashCode() {
            return this.animator.hashCode();
        }

        @Override // androidx.compose.ui.Modifier.Node
        public void onAttach() {
            ((LazyLayoutItemAnimator) this.animator).displayingNode = this;
        }

        @Override // androidx.compose.ui.Modifier.Node
        public void onDetach() {
            this.animator.reset();
        }

        public final void setAnimator(LazyLayoutItemAnimator<?> animator) {
            if (Intrinsics.areEqual(this.animator, animator) || !getNode().getIsAttached()) {
                return;
            }
            this.animator.reset();
            ((LazyLayoutItemAnimator) animator).displayingNode = this;
            this.animator = animator;
        }

        public String toString() {
            return "DisplayingDisappearingItemsNode(animator=" + this.animator + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fR4\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00108\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R*\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\"\u0010&\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001e\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R$\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b)\u0010 R$\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b*\u0010 R\u0014\u0010,\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator$ItemInfo;", BuildConfig.FLAVOR, "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;)V", "positionedItem", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Landroidx/compose/ui/graphics/GraphicsContext;", "graphicsContext", BuildConfig.FLAVOR, "layoutMinOffset", "layoutMaxOffset", "crossAxisOffset", BuildConfig.FLAVOR, "updateAnimation", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;III)V", BuildConfig.FLAVOR, "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "<set-?>", "animations", "[Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "getAnimations", "()[Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "setConstraints-_Sx5XlM", "(Landroidx/compose/ui/unit/Constraints;)V", "I", "getCrossAxisOffset", "()I", "setCrossAxisOffset", "(I)V", "lane", "getLane", "setLane", "span", "getSpan", "setSpan", "getLayoutMinOffset", "getLayoutMaxOffset", BuildConfig.FLAVOR, "isRunningPlacement", "()Z", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class ItemInfo {
        private LazyLayoutItemAnimation[] animations;
        private Constraints constraints;
        private int crossAxisOffset;
        private int lane;
        private int layoutMaxOffset;
        private int layoutMinOffset;
        private int span;

        public ItemInfo() {
            LazyLayoutItemAnimation[] lazyLayoutItemAnimationArr;
            lazyLayoutItemAnimationArr = LazyLayoutItemAnimatorKt.EmptyArray;
            this.animations = lazyLayoutItemAnimationArr;
            this.span = 1;
        }

        private final boolean isRunningPlacement() {
            for (LazyLayoutItemAnimation lazyLayoutItemAnimation : this.animations) {
            }
            return false;
        }

        public static /* synthetic */ void updateAnimation$default(ItemInfo itemInfo, LazyLayoutMeasuredItem lazyLayoutMeasuredItem, CoroutineScope coroutineScope, GraphicsContext graphicsContext, int i5, int i6, int i7, int i8, Object obj) {
            if ((i8 & 32) != 0) {
                i7 = LazyLayoutItemAnimator.this.getCrossAxisOffset(lazyLayoutMeasuredItem);
            }
            itemInfo.updateAnimation(lazyLayoutMeasuredItem, coroutineScope, graphicsContext, i5, i6, i7);
        }

        public final LazyLayoutItemAnimation[] getAnimations() {
            return this.animations;
        }

        /* renamed from: getConstraints-DWUhwKw, reason: not valid java name and from getter */
        public final Constraints getConstraints() {
            return this.constraints;
        }

        public final int getCrossAxisOffset() {
            return this.crossAxisOffset;
        }

        public final int getLane() {
            return this.lane;
        }

        public final int getLayoutMaxOffset() {
            return this.layoutMaxOffset;
        }

        public final int getLayoutMinOffset() {
            return this.layoutMinOffset;
        }

        public final int getSpan() {
            return this.span;
        }

        public final void setLane(int i5) {
            this.lane = i5;
        }

        public final void setSpan(int i5) {
            this.span = i5;
        }

        public final void updateAnimation(T positionedItem, CoroutineScope coroutineScope, GraphicsContext graphicsContext, int layoutMinOffset, int layoutMaxOffset, int crossAxisOffset) {
            if (!isRunningPlacement()) {
                this.layoutMinOffset = layoutMinOffset;
                this.layoutMaxOffset = layoutMaxOffset;
            }
            int length = this.animations.length;
            for (int placeablesCount = positionedItem.getPlaceablesCount(); placeablesCount < length; placeablesCount++) {
                LazyLayoutItemAnimation lazyLayoutItemAnimation = this.animations[placeablesCount];
            }
            if (this.animations.length != positionedItem.getPlaceablesCount()) {
                Object[] copyOf = Arrays.copyOf(this.animations, positionedItem.getPlaceablesCount());
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                this.animations = (LazyLayoutItemAnimation[]) copyOf;
            }
            this.constraints = Constraints.m2567boximpl(positionedItem.getConstraints());
            this.crossAxisOffset = crossAxisOffset;
            this.lane = positionedItem.getLane();
            this.span = positionedItem.getSpan();
            int placeablesCount2 = positionedItem.getPlaceablesCount();
            for (int i5 = 0; i5 < placeablesCount2; i5++) {
                LazyLayoutItemAnimatorKt.access$getSpecs(positionedItem.getParentData(i5));
                LazyLayoutItemAnimation lazyLayoutItemAnimation2 = this.animations[i5];
                this.animations[i5] = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCrossAxisOffset(LazyLayoutMeasuredItem lazyLayoutMeasuredItem) {
        long mo373getOffsetBjo55l4 = lazyLayoutMeasuredItem.mo373getOffsetBjo55l4(0);
        return !lazyLayoutMeasuredItem.getIsVertical() ? IntOffset.m2641getYimpl(mo373getOffsetBjo55l4) : IntOffset.m2640getXimpl(mo373getOffsetBjo55l4);
    }

    private final boolean getHasAnimations(T t5) {
        int placeablesCount = t5.getPlaceablesCount();
        for (int i5 = 0; i5 < placeablesCount; i5++) {
            LazyLayoutItemAnimatorKt.access$getSpecs(t5.getParentData(i5));
        }
        return false;
    }

    private final int getMainAxisOffset(LazyLayoutMeasuredItem lazyLayoutMeasuredItem) {
        long mo373getOffsetBjo55l4 = lazyLayoutMeasuredItem.mo373getOffsetBjo55l4(0);
        return lazyLayoutMeasuredItem.getIsVertical() ? IntOffset.m2641getYimpl(mo373getOffsetBjo55l4) : IntOffset.m2640getXimpl(mo373getOffsetBjo55l4);
    }

    private final void initializeAnimation(T item, int mainAxisOffset, LazyLayoutItemAnimator<T>.ItemInfo itemInfo) {
        long mo373getOffsetBjo55l4 = item.mo373getOffsetBjo55l4(0);
        if (item.getIsVertical()) {
            IntOffset.m2637copyiSbpLlY$default(mo373getOffsetBjo55l4, 0, mainAxisOffset, 1, null);
        } else {
            IntOffset.m2637copyiSbpLlY$default(mo373getOffsetBjo55l4, mainAxisOffset, 0, 2, null);
        }
        for (LazyLayoutItemAnimation lazyLayoutItemAnimation : itemInfo.getAnimations()) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void initializeAnimation$default(LazyLayoutItemAnimator lazyLayoutItemAnimator, LazyLayoutMeasuredItem lazyLayoutMeasuredItem, int i5, ItemInfo itemInfo, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            LazyLayoutItemAnimator<T>.ItemInfo itemInfo2 = lazyLayoutItemAnimator.keyToItemInfoMap.get(lazyLayoutMeasuredItem.getKey());
            Intrinsics.checkNotNull(itemInfo2);
            itemInfo = itemInfo2;
        }
        lazyLayoutItemAnimator.initializeAnimation(lazyLayoutMeasuredItem, i5, itemInfo);
    }

    private final void removeInfoForKey(Object key) {
        LazyLayoutItemAnimation[] animations;
        LazyLayoutItemAnimator<T>.ItemInfo remove = this.keyToItemInfoMap.remove(key);
        if (remove == null || (animations = remove.getAnimations()) == null) {
            return;
        }
        for (LazyLayoutItemAnimation lazyLayoutItemAnimation : animations) {
        }
    }

    private final void startPlacementAnimationsIfNeeded(T item, boolean isMovingAway) {
        LazyLayoutItemAnimator<T>.ItemInfo itemInfo = this.keyToItemInfoMap.get(item.getKey());
        Intrinsics.checkNotNull(itemInfo);
        for (LazyLayoutItemAnimation lazyLayoutItemAnimation : itemInfo.getAnimations()) {
        }
    }

    static /* synthetic */ void startPlacementAnimationsIfNeeded$default(LazyLayoutItemAnimator lazyLayoutItemAnimator, LazyLayoutMeasuredItem lazyLayoutMeasuredItem, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        lazyLayoutItemAnimator.startPlacementAnimationsIfNeeded(lazyLayoutMeasuredItem, z5);
    }

    private final int updateAndReturnOffsetFor(int[] iArr, T t5) {
        int lane = t5.getLane();
        int span = t5.getSpan() + lane;
        int i5 = 0;
        while (lane < span) {
            int mainAxisSizeWithSpacings = iArr[lane] + t5.getMainAxisSizeWithSpacings();
            iArr[lane] = mainAxisSizeWithSpacings;
            i5 = Math.max(i5, mainAxisSizeWithSpacings);
            lane++;
        }
        return i5;
    }

    public final LazyLayoutItemAnimation getAnimation(Object key, int placeableIndex) {
        LazyLayoutItemAnimation[] animations;
        LazyLayoutItemAnimator<T>.ItemInfo itemInfo = this.keyToItemInfoMap.get(key);
        if (itemInfo == null || (animations = itemInfo.getAnimations()) == null) {
            return null;
        }
        return animations[placeableIndex];
    }

    /* renamed from: getMinSizeToFitDisappearingItems-YbymL2g, reason: not valid java name */
    public final long m417getMinSizeToFitDisappearingItemsYbymL2g() {
        long m2665getZeroYbymL2g = IntSize.INSTANCE.m2665getZeroYbymL2g();
        List<LazyLayoutItemAnimation> list = this.disappearingItems;
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = list.get(i5);
            GraphicsLayer layer = lazyLayoutItemAnimation.getLayer();
            if (layer != null) {
                m2665getZeroYbymL2g = IntSizeKt.IntSize(Math.max(IntSize.m2661getWidthimpl(m2665getZeroYbymL2g), IntOffset.m2640getXimpl(lazyLayoutItemAnimation.m412getRawOffsetnOccac()) + IntSize.m2661getWidthimpl(layer.getSize())), Math.max(IntSize.m2660getHeightimpl(m2665getZeroYbymL2g), IntOffset.m2641getYimpl(lazyLayoutItemAnimation.m412getRawOffsetnOccac()) + IntSize.m2660getHeightimpl(layer.getSize())));
            }
        }
        return m2665getZeroYbymL2g;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0228, code lost:
    
        r31 = r3;
        r14 = r5;
        kotlin.collections.ArraysKt.fill$default(r31, 0, 0, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0246, code lost:
    
        if (r35.movingInFromEndBound.isEmpty() != false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0248, code lost:
    
        r0 = r35.movingInFromEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x024f, code lost:
    
        if (r0.size() <= 1) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0251, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r0, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$1(r15));
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0259, code lost:
    
        r12 = r35.movingInFromEndBound;
        r5 = r12.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0260, code lost:
    
        if (r4 >= r5) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0262, code lost:
    
        r3 = r12.get(r4);
        initializeAnimation$default(r35, r3, (r47 + updateAndReturnOffsetFor(r31, r3)) - r3.getMainAxisSizeWithSpacings(), null, 4, null);
        startPlacementAnimationsIfNeeded$default(r35, r3, false, r14, null);
        r4 = r4 + 1;
        r5 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0046, code lost:
    
        r35.firstVisibleIndex = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x029d, code lost:
    
        kotlin.collections.ArraysKt.fill$default(r31, 0, 0, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x02b0, code lost:
    
        r0 = r35.movingAwayKeys;
        r1 = r0.elements;
        r0 = r0.metadata;
        r2 = r0.length - r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02b8, code lost:
    
        if (r2 < 0) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x02ba, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x02bb, code lost:
    
        r12 = r0[r4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02c5, code lost:
    
        if (((((~r12) << 7) & r12) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x02c7, code lost:
    
        r3 = 8 - ((~(r4 - r2)) >>> 31);
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02d1, code lost:
    
        if (r5 >= r3) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x02d7, code lost:
    
        if ((r12 & 255) >= 128) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
    
        if (r42 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x02d9, code lost:
    
        r7 = r1[(r4 << 3) + r5];
        r8 = r35.keyToItemInfoMap.get(r7);
        kotlin.jvm.internal.Intrinsics.checkNotNull(r8);
        r8 = r8;
        r14 = r40.getIndex(r7);
        r33 = r0;
        r8.setSpan(java.lang.Math.min(r11, r8.getSpan()));
        r34 = r1;
        r8.setLane(java.lang.Math.min(r11 - r8.getSpan(), r8.getLane()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x030e, code lost:
    
        if (r14 != (-1)) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0310, code lost:
    
        r1 = r8.getAnimations();
        r8 = r1.length;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0316, code lost:
    
        if (r14 >= r8) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0318, code lost:
    
        r24 = r1[r14];
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x031f, code lost:
    
        removeInfoForKey(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0387, code lost:
    
        r12 = r12 >> 8;
        r5 = r5 + 1;
        r11 = r44;
        r0 = r33;
        r1 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0323, code lost:
    
        r1 = r8.getConstraints();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r1);
        r1 = r41.mo375getAndMeasurehBUhpc(r14, r8.getLane(), r8.getSpan(), r1.getValue());
        r1.setNonScrollableItem(true);
        r0 = r8.getAnimations();
        r11 = r0.length;
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x004a, code lost:
    
        androidx.compose.ui.unit.IntOffsetKt.IntOffset(0, r36);
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0348, code lost:
    
        if (r9 >= r11) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x034a, code lost:
    
        r24 = r0[r9];
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0351, code lost:
    
        if (r15 == null) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0357, code lost:
    
        if (r14 != r15.getIndex(r7)) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0359, code lost:
    
        removeInfoForKey(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x035d, code lost:
    
        r8.updateAnimation(r1, r48, r49, r46, r47, r8.getCrossAxisOffset());
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0372, code lost:
    
        if (r14 >= r35.firstVisibleIndex) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0374, code lost:
    
        r35.movingAwayToStartBound.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0051, code lost:
    
        if (r43 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x037a, code lost:
    
        r35.movingAwayToEndBound.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0382, code lost:
    
        r33 = r0;
        r34 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0394, code lost:
    
        r33 = r0;
        r34 = r1;
        r1 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x039b, code lost:
    
        if (r3 != 8) goto L197;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x03a5, code lost:
    
        if (r4 == r2) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x03a7, code lost:
    
        r4 = r4 + r1;
        r11 = r44;
        r0 = r33;
        r1 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x039e, code lost:
    
        r33 = r0;
        r34 = r1;
        r1 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0053, code lost:
    
        if (r45 != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x03be, code lost:
    
        if (r35.movingAwayToStartBound.isEmpty() != false) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x03c0, code lost:
    
        r0 = r35.movingAwayToStartBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x03c7, code lost:
    
        if (r0.size() <= 1) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x03c9, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r0, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortByDescending$2(r40));
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x03d1, code lost:
    
        r0 = r35.movingAwayToStartBound;
        r1 = r0.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x03d8, code lost:
    
        if (r4 >= r1) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x03da, code lost:
    
        r2 = r0.get(r4);
        r3 = r35.keyToItemInfoMap.get(r2.getKey());
        kotlin.jvm.internal.Intrinsics.checkNotNull(r3);
        r3 = r3;
        r5 = r31;
        r7 = updateAndReturnOffsetFor(r5, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x03f5, code lost:
    
        if (r43 == false) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x03f7, code lost:
    
        r8 = getMainAxisOffset((androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem) kotlin.collections.CollectionsKt.first((java.util.List) r39));
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0056, code lost:
    
        r15 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0406, code lost:
    
        r2.position(r8 - r7, r3.getCrossAxisOffset(), r37, r38);
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0413, code lost:
    
        if (r42 == false) goto L204;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0415, code lost:
    
        startPlacementAnimationsIfNeeded(r2, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0418, code lost:
    
        r4 = r4 + 1;
        r31 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0402, code lost:
    
        r8 = r3.getLayoutMinOffset();
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x041c, code lost:
    
        r7 = r37;
        r9 = r38;
        r5 = r31;
        kotlin.collections.ArraysKt.fill$default(r5, 0, 0, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        r0 = r35.keyToItemInfoMap;
        r2 = r0.keys;
        r0 = r0.metadata;
        r3 = r0.length - 2;
        r4 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0440, code lost:
    
        if (r35.movingAwayToEndBound.isEmpty() != false) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0442, code lost:
    
        r0 = r35.movingAwayToEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0449, code lost:
    
        if (r0.size() <= 1) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x044b, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r0, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$2(r40));
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0453, code lost:
    
        r0 = r35.movingAwayToEndBound;
        r1 = r0.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x045a, code lost:
    
        if (r4 >= r1) goto L205;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x045c, code lost:
    
        r2 = r0.get(r4);
        r3 = r35.keyToItemInfoMap.get(r2.getKey());
        kotlin.jvm.internal.Intrinsics.checkNotNull(r3);
        r3 = r3;
        r8 = updateAndReturnOffsetFor(r5, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0475, code lost:
    
        if (r43 == false) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0477, code lost:
    
        r10 = getMainAxisOffset((androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem) kotlin.collections.CollectionsKt.last((java.util.List) r39));
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x048b, code lost:
    
        r2.position(r10 + r8, r3.getCrossAxisOffset(), r7, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006f, code lost:
    
        if (r3 < 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0494, code lost:
    
        if (r42 == false) goto L207;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0496, code lost:
    
        startPlacementAnimationsIfNeeded(r2, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0499, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0482, code lost:
    
        r10 = r3.getLayoutMaxOffset() - r2.getMainAxisSizeWithSpacings();
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x049b, code lost:
    
        r0 = r35.movingAwayToStartBound;
        kotlin.collections.CollectionsKt.reverse(r0);
        r1 = kotlin.Unit.INSTANCE;
        r39.addAll(0, r0);
        r39.addAll(r35.movingAwayToEndBound);
        r35.movingInFromStartBound.clear();
        r35.movingInFromEndBound.clear();
        r35.movingAwayToStartBound.clear();
        r35.movingAwayToEndBound.clear();
        r35.movingAwayKeys.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x04ca, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0071, code lost:
    
        r5 = 0;
        r42 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0432, code lost:
    
        r7 = r37;
        r9 = r38;
        r5 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x023b, code lost:
    
        r31 = r3;
        r14 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x02ad, code lost:
    
        r31 = r3;
        r14 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x00b0, code lost:
    
        r25 = r0;
        r0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x00bc, code lost:
    
        r24 = r13;
        r42 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0058, code lost:
    
        r15 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x004e, code lost:
    
        androidx.compose.ui.unit.IntOffsetKt.IntOffset(r36, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0045, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0074, code lost:
    
        r14 = r0[r5];
        r24 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0080, code lost:
    
        if (((((~r14) << 7) & r14) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0082, code lost:
    
        r12 = 8 - ((~(r5 - r3)) >>> 31);
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008a, code lost:
    
        if (r13 >= r12) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:
    
        if ((r14 & 255) >= 128) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0092, code lost:
    
        r25 = r0;
        r35.movingAwayKeys.add(r2[(r5 << 3) + r13]);
        r4 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a4, code lost:
    
        r14 = r14 >> r4;
        r13 = r13 + 1;
        r0 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a2, code lost:
    
        r25 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00aa, code lost:
    
        r25 = r0;
        r0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ad, code lost:
    
        if (r12 != r4) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b3, code lost:
    
        if (r5 == r3) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b5, code lost:
    
        r5 = r5 + r0;
        r13 = r24;
        r0 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c0, code lost:
    
        r0 = r39.size();
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c7, code lost:
    
        if (r2 >= r0) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c9, code lost:
    
        r3 = r39.get(r2);
        r35.movingAwayKeys.remove(r3.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00dc, code lost:
    
        if (getHasAnimations(r3) == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00de, code lost:
    
        r5 = r35.keyToItemInfoMap.get(r3.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ea, code lost:
    
        if (r24 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ec, code lost:
    
        r15 = r24;
        r14 = r15.getIndex(r3.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00fa, code lost:
    
        if (r14 != (-1)) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00fc, code lost:
    
        if (r15 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00fe, code lost:
    
        r24 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0103, code lost:
    
        if (r5 != null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0105, code lost:
    
        r5 = new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.ItemInfo(r35);
        androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.ItemInfo.updateAnimation$default(r5, r3, r48, r49, r46, r47, 0, 32, null);
        r35.keyToItemInfoMap.set(r3.getKey(), r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x012c, code lost:
    
        if (r3.getIndex() == r14) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x012e, code lost:
    
        if (r14 == (-1)) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0130, code lost:
    
        if (r14 >= r1) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0132, code lost:
    
        r35.movingInFromStartBound.add(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0137, code lost:
    
        r12 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01b1, code lost:
    
        r2 = r2 + r12;
        r24 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x013c, code lost:
    
        r35.movingInFromEndBound.add(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0142, code lost:
    
        r12 = r3.mo373getOffsetBjo55l4(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x014b, code lost:
    
        if (r3.isVertical() == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x014d, code lost:
    
        r4 = androidx.compose.ui.unit.IntOffset.m2641getYimpl(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0156, code lost:
    
        initializeAnimation(r3, r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0159, code lost:
    
        if (r24 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x015b, code lost:
    
        r3 = r5.getAnimations();
        r4 = r3.length;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0161, code lost:
    
        if (r5 >= r4) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0163, code lost:
    
        r12 = r3[r5];
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0152, code lost:
    
        r4 = androidx.compose.ui.unit.IntOffset.m2640getXimpl(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0168, code lost:
    
        if (r42 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x016a, code lost:
    
        androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator.ItemInfo.updateAnimation$default(r5, r3, r48, r49, r46, r47, 0, 32, null);
        r4 = r5.getAnimations();
        r12 = r4.length;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0185, code lost:
    
        if (r14 >= r12) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0187, code lost:
    
        r25 = r4[r14];
        r14 = r14 + 1;
        r12 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0190, code lost:
    
        r12 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0191, code lost:
    
        if (r24 == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0193, code lost:
    
        r4 = r5.getAnimations();
        r5 = r4.length;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0199, code lost:
    
        if (r14 >= r5) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x019b, code lost:
    
        r23 = r4[r14];
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x019f, code lost:
    
        startPlacementAnimationsIfNeeded$default(r35, r3, false, 2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0036, code lost:
    
        r1 = r35.firstVisibleIndex;
        r2 = (androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem) kotlin.collections.CollectionsKt.firstOrNull((java.util.List) r39);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0101, code lost:
    
        r24 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00f7, code lost:
    
        r15 = r24;
        r14 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01a5, code lost:
    
        r15 = r24;
        r12 = 1;
        removeInfoForKey(r3.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01b8, code lost:
    
        r15 = r24;
        r4 = 0;
        r5 = 2;
        r3 = new int[r11];
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01c1, code lost:
    
        if (r0 >= r11) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01c3, code lost:
    
        r3[r0] = r4;
        r0 = r0 + 1;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01c8, code lost:
    
        if (r42 == false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003e, code lost:
    
        if (r2 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01ca, code lost:
    
        if (r15 == null) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01d4, code lost:
    
        if (r35.movingInFromStartBound.isEmpty() != false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01d6, code lost:
    
        r0 = r35.movingInFromStartBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01dc, code lost:
    
        if (r0.size() <= 1) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01de, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r0, new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortByDescending$1(r15));
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01e6, code lost:
    
        r12 = r35.movingInFromStartBound;
        r4 = r12.size();
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01ed, code lost:
    
        if (r2 >= r4) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01ef, code lost:
    
        r1 = r12.get(r2);
        r14 = r5;
        initializeAnimation$default(r35, r1, r46 - updateAndReturnOffsetFor(r3, r1), null, 4, null);
        startPlacementAnimationsIfNeeded$default(r35, r1, false, r14, null);
        r2 = r2 + 1;
        r5 = r14;
        r4 = r4;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0040, code lost:
    
        r2 = r2.getIndex();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onMeasured(int consumedScroll, int layoutWidth, int layoutHeight, List<T> positionedItems, final LazyLayoutKeyIndexMap keyIndexMap, LazyLayoutMeasuredItemProvider<T> itemProvider, boolean isVertical, boolean isLookingAhead, int laneCount, boolean hasLookaheadOccurred, int layoutMinOffset, int layoutMaxOffset, CoroutineScope coroutineScope, GraphicsContext graphicsContext) {
        int i5 = laneCount;
        LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap = this.keyIndexMap;
        this.keyIndexMap = keyIndexMap;
        int size = positionedItems.size();
        int i6 = 0;
        while (true) {
            if (i6 < size) {
                if (getHasAnimations(positionedItems.get(i6))) {
                    break;
                } else {
                    i6++;
                }
            } else if (this.keyToItemInfoMap.isEmpty()) {
                reset();
                return;
            }
        }
    }

    public final void reset() {
        if (this.keyToItemInfoMap.isNotEmpty()) {
            MutableScatterMap<Object, LazyLayoutItemAnimator<T>.ItemInfo> mutableScatterMap = this.keyToItemInfoMap;
            Object[] objArr = mutableScatterMap.values;
            long[] jArr = mutableScatterMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i5 = 0;
                while (true) {
                    long j5 = jArr[i5];
                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i6 = 8 - ((~(i5 - length)) >>> 31);
                        for (int i7 = 0; i7 < i6; i7++) {
                            if ((255 & j5) < 128) {
                                for (LazyLayoutItemAnimation lazyLayoutItemAnimation : ((ItemInfo) objArr[(i5 << 3) + i7]).getAnimations()) {
                                }
                            }
                            j5 >>= 8;
                        }
                        if (i6 != 8) {
                            break;
                        }
                    }
                    if (i5 == length) {
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            this.keyToItemInfoMap.clear();
        }
        this.keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
        this.firstVisibleIndex = -1;
    }
}
