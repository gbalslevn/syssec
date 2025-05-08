package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\rJ\u000f\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\rJ\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\rJ\u0011\u0010\u0015\u001a\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0016\u0010\rJ*\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u000bH\u0016¢\u0006\u0004\b \u0010\rJ\u000f\u0010!\u001a\u00020\u000bH\u0016¢\u0006\u0004\b!\u0010\rR\u001a\u0010#\u001a\u00020\"8\u0016X\u0096D¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R*\u0010\u0006\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00058\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R*\u0010\b\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010-R\u0016\u00106\u001a\u0004\u0018\u0001038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b4\u00105\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00067"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerHoverIconModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/input/pointer/PointerIcon;", "icon", BuildConfig.FLAVOR, "overrideDescendants", "<init>", "(Landroidx/compose/ui/input/pointer/PointerIcon;Z)V", BuildConfig.FLAVOR, "onEnter", "()V", "onExit", "displayIcon", "displayDefaultIcon", "displayIconIfDescendantsDoNotHavePriority", "findDescendantNodeWithCursorInBounds", "()Landroidx/compose/ui/input/pointer/PointerHoverIconModifierNode;", "displayIconFromCurrentNodeOrDescendantsWithCursorInBounds", "findOverridingAncestorNode", "displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "pass", "Landroidx/compose/ui/unit/IntSize;", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onPointerEvent", "onCancelPointerInput", "onDetach", BuildConfig.FLAVOR, "traverseKey", "Ljava/lang/String;", "getTraverseKey", "()Ljava/lang/String;", "value", "Landroidx/compose/ui/input/pointer/PointerIcon;", "getIcon", "()Landroidx/compose/ui/input/pointer/PointerIcon;", "setIcon", "(Landroidx/compose/ui/input/pointer/PointerIcon;)V", "Z", "getOverrideDescendants", "()Z", "setOverrideDescendants", "(Z)V", "cursorInBoundsOfNode", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "pointerIconService", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PointerHoverIconModifierNode extends Modifier.Node implements TraversableNode, PointerInputModifierNode, CompositionLocalConsumerModifierNode {
    private boolean cursorInBoundsOfNode;
    private PointerIcon icon;
    private boolean overrideDescendants;
    private final String traverseKey = "androidx.compose.ui.input.pointer.PointerHoverIcon";

    public PointerHoverIconModifierNode(PointerIcon pointerIcon, boolean z5) {
        this.icon = pointerIcon;
        this.overrideDescendants = z5;
    }

    private final void displayDefaultIcon() {
        PointerIconService pointerIconService = getPointerIconService();
        if (pointerIconService != null) {
            pointerIconService.setIcon(null);
        }
    }

    private final void displayIcon() {
        PointerIcon pointerIcon;
        PointerHoverIconModifierNode findOverridingAncestorNode = findOverridingAncestorNode();
        if (findOverridingAncestorNode == null || (pointerIcon = findOverridingAncestorNode.icon) == null) {
            pointerIcon = this.icon;
        }
        PointerIconService pointerIconService = getPointerIconService();
        if (pointerIconService != null) {
            pointerIconService.setIcon(pointerIcon);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon() {
        Unit unit;
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        TraversableNodeKt.traverseAncestors(this, new Function1<PointerHoverIconModifierNode, Boolean>() { // from class: androidx.compose.ui.input.pointer.PointerHoverIconModifierNode$displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(PointerHoverIconModifierNode pointerHoverIconModifierNode) {
                boolean z5;
                boolean z6;
                if (ref$ObjectRef.element == null) {
                    z6 = pointerHoverIconModifierNode.cursorInBoundsOfNode;
                    if (z6) {
                        ref$ObjectRef.element = pointerHoverIconModifierNode;
                        return Boolean.TRUE;
                    }
                }
                if (ref$ObjectRef.element != null && pointerHoverIconModifierNode.getOverrideDescendants()) {
                    z5 = pointerHoverIconModifierNode.cursorInBoundsOfNode;
                    if (z5) {
                        ref$ObjectRef.element = pointerHoverIconModifierNode;
                    }
                }
                return Boolean.TRUE;
            }
        });
        PointerHoverIconModifierNode pointerHoverIconModifierNode = (PointerHoverIconModifierNode) ref$ObjectRef.element;
        if (pointerHoverIconModifierNode != null) {
            pointerHoverIconModifierNode.displayIcon();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            displayDefaultIcon();
        }
    }

    private final void displayIconFromCurrentNodeOrDescendantsWithCursorInBounds() {
        PointerHoverIconModifierNode pointerHoverIconModifierNode;
        if (this.cursorInBoundsOfNode) {
            if (this.overrideDescendants || (pointerHoverIconModifierNode = findDescendantNodeWithCursorInBounds()) == null) {
                pointerHoverIconModifierNode = this;
            }
            pointerHoverIconModifierNode.displayIcon();
        }
    }

    private final void displayIconIfDescendantsDoNotHavePriority() {
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        ref$BooleanRef.element = true;
        if (!this.overrideDescendants) {
            TraversableNodeKt.traverseDescendants(this, new Function1<PointerHoverIconModifierNode, TraversableNode$Companion$TraverseDescendantsAction>() { // from class: androidx.compose.ui.input.pointer.PointerHoverIconModifierNode$displayIconIfDescendantsDoNotHavePriority$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final TraversableNode$Companion$TraverseDescendantsAction invoke(PointerHoverIconModifierNode pointerHoverIconModifierNode) {
                    boolean z5;
                    z5 = pointerHoverIconModifierNode.cursorInBoundsOfNode;
                    if (z5) {
                        Ref$BooleanRef.this.element = false;
                        return TraversableNode$Companion$TraverseDescendantsAction.CancelTraversal;
                    }
                    return TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
                }
            });
        }
        if (ref$BooleanRef.element) {
            displayIcon();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final PointerHoverIconModifierNode findDescendantNodeWithCursorInBounds() {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        TraversableNodeKt.traverseDescendants(this, new Function1<PointerHoverIconModifierNode, TraversableNode$Companion$TraverseDescendantsAction>() { // from class: androidx.compose.ui.input.pointer.PointerHoverIconModifierNode$findDescendantNodeWithCursorInBounds$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final TraversableNode$Companion$TraverseDescendantsAction invoke(PointerHoverIconModifierNode pointerHoverIconModifierNode) {
                boolean z5;
                TraversableNode$Companion$TraverseDescendantsAction traversableNode$Companion$TraverseDescendantsAction = TraversableNode$Companion$TraverseDescendantsAction.ContinueTraversal;
                z5 = pointerHoverIconModifierNode.cursorInBoundsOfNode;
                if (!z5) {
                    return traversableNode$Companion$TraverseDescendantsAction;
                }
                ref$ObjectRef.element = pointerHoverIconModifierNode;
                return pointerHoverIconModifierNode.getOverrideDescendants() ? TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal : traversableNode$Companion$TraverseDescendantsAction;
            }
        });
        return (PointerHoverIconModifierNode) ref$ObjectRef.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final PointerHoverIconModifierNode findOverridingAncestorNode() {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        TraversableNodeKt.traverseAncestors(this, new Function1<PointerHoverIconModifierNode, Boolean>() { // from class: androidx.compose.ui.input.pointer.PointerHoverIconModifierNode$findOverridingAncestorNode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(PointerHoverIconModifierNode pointerHoverIconModifierNode) {
                boolean z5;
                if (pointerHoverIconModifierNode.getOverrideDescendants()) {
                    z5 = pointerHoverIconModifierNode.cursorInBoundsOfNode;
                    if (z5) {
                        ref$ObjectRef.element = pointerHoverIconModifierNode;
                    }
                }
                return Boolean.TRUE;
            }
        });
        return (PointerHoverIconModifierNode) ref$ObjectRef.element;
    }

    private final PointerIconService getPointerIconService() {
        return (PointerIconService) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalPointerIconService());
    }

    private final void onEnter() {
        this.cursorInBoundsOfNode = true;
        displayIconIfDescendantsDoNotHavePriority();
    }

    private final void onExit() {
        if (this.cursorInBoundsOfNode) {
            this.cursorInBoundsOfNode = false;
            if (getIsAttached()) {
                displayIconFromAncestorNodeWithCursorInBoundsOrDefaultIcon();
            }
        }
    }

    public final boolean getOverrideDescendants() {
        return this.overrideDescendants;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        onExit();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        onExit();
        super.onDetach();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY */
    public void mo91onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        if (pass == PointerEventPass.Main) {
            int type = pointerEvent.getType();
            PointerEventType.Companion companion = PointerEventType.INSTANCE;
            if (PointerEventType.m1859equalsimpl0(type, companion.m1860getEnter7fucELk())) {
                onEnter();
            } else if (PointerEventType.m1859equalsimpl0(pointerEvent.getType(), companion.m1861getExit7fucELk())) {
                onExit();
            }
        }
    }

    public final void setIcon(PointerIcon pointerIcon) {
        if (Intrinsics.areEqual(this.icon, pointerIcon)) {
            return;
        }
        this.icon = pointerIcon;
        if (this.cursorInBoundsOfNode) {
            displayIconIfDescendantsDoNotHavePriority();
        }
    }

    public final void setOverrideDescendants(boolean z5) {
        if (this.overrideDescendants != z5) {
            this.overrideDescendants = z5;
            if (z5) {
                if (this.cursorInBoundsOfNode) {
                    displayIcon();
                }
            } else if (this.cursorInBoundsOfNode) {
                displayIconFromCurrentNodeOrDescendantsWithCursorInBounds();
            }
        }
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public String getTraverseKey() {
        return this.traverseKey;
    }
}
