package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a!\u0010\u0004\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\"\u0010\f\u001a\u00020\t*\u00020\u00062\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0000ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\"\u0010\u0011\u001a\u00020\u000e*\u00020\u00062\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0000ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0013\u0010\u0013\u001a\u00020\u0012*\u00020\u0006H\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0013\u0010\u0016\u001a\u00020\u0015*\u00020\u0006H\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0011\u0010\u0019\u001a\u00020\u0018*\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0011\u0010\u001c\u001a\u00020\u001b*\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0011\u0010\u001f\u001a\u00020\u001e*\u00020\u0006¢\u0006\u0004\b\u001f\u0010 \u001a\u0011\u0010\"\u001a\u00020!*\u00020\u0006¢\u0006\u0004\b\"\u0010#\u001a\u0015\u0010%\u001a\u0004\u0018\u00010$*\u00020\u0001H\u0000¢\u0006\u0004\b%\u0010&\u001a\u001d\u0010'\u001a\u0004\u0018\u00010\u0001*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000H\u0002¢\u0006\u0004\b'\u0010(\"\u0018\u0010)\u001a\u00020\t*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Node;", "node", BuildConfig.FLAVOR, "addLayoutNodeChildren", "(Landroidx/compose/runtime/collection/MutableVector;Landroidx/compose/ui/Modifier$Node;)V", "Landroidx/compose/ui/node/DelegatableNode;", "Landroidx/compose/ui/node/NodeKind;", "type", BuildConfig.FLAVOR, "has-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Z", "has", "kind", "Landroidx/compose/ui/node/NodeCoordinator;", "requireCoordinator-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Landroidx/compose/ui/node/NodeCoordinator;", "requireCoordinator", "Landroidx/compose/ui/node/LayoutNode;", "requireLayoutNode", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/node/Owner;", "requireOwner", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/unit/Density;", "requireDensity", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/graphics/GraphicsContext;", "requireGraphicsContext", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/graphics/GraphicsContext;", "Landroidx/compose/ui/unit/LayoutDirection;", "requireLayoutDirection", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "requireLayoutCoordinates", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/LayoutModifierNode;", "asLayoutModifierNode", "(Landroidx/compose/ui/Modifier$Node;)Landroidx/compose/ui/node/LayoutModifierNode;", "pop", "(Landroidx/compose/runtime/collection/MutableVector;)Landroidx/compose/ui/Modifier$Node;", "isDelegationRoot", "(Landroidx/compose/ui/node/DelegatableNode;)Z", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class DelegatableNodeKt {
    public static final /* synthetic */ Modifier.Node access$pop(MutableVector mutableVector) {
        return pop(mutableVector);
    }

    public static final void addLayoutNodeChildren(MutableVector<Modifier.Node> mutableVector, Modifier.Node node) {
        MutableVector<LayoutNode> mutableVector2 = requireLayoutNode(node).get_children$ui_release();
        int size = mutableVector2.getSize();
        if (size > 0) {
            int i5 = size - 1;
            LayoutNode[] content = mutableVector2.getContent();
            do {
                mutableVector.add(content[i5].getNodes().getHead());
                i5--;
            } while (i5 >= 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final LayoutModifierNode asLayoutModifierNode(Modifier.Node node) {
        if ((NodeKind.m2074constructorimpl(2) & node.getKindSet()) != 0) {
            if (node instanceof LayoutModifierNode) {
                return (LayoutModifierNode) node;
            }
            if (node instanceof DelegatingNode) {
                Modifier.Node delegate = ((DelegatingNode) node).getDelegate();
                while (delegate != 0) {
                    if (delegate instanceof LayoutModifierNode) {
                        return (LayoutModifierNode) delegate;
                    }
                    delegate = (!(delegate instanceof DelegatingNode) || (NodeKind.m2074constructorimpl(2) & delegate.getKindSet()) == 0) ? delegate.getChild() : ((DelegatingNode) delegate).getDelegate();
                }
            }
        }
        return null;
    }

    /* renamed from: has-64DMado */
    public static final boolean m1989has64DMado(DelegatableNode delegatableNode, int i5) {
        return (delegatableNode.getNode().getAggregateChildKindSet() & i5) != 0;
    }

    public static final boolean isDelegationRoot(DelegatableNode delegatableNode) {
        return delegatableNode.getNode() == delegatableNode;
    }

    public static final Modifier.Node pop(MutableVector<Modifier.Node> mutableVector) {
        if (mutableVector == null || mutableVector.isEmpty()) {
            return null;
        }
        return mutableVector.removeAt(mutableVector.getSize() - 1);
    }

    /* renamed from: requireCoordinator-64DMado */
    public static final NodeCoordinator m1990requireCoordinator64DMado(DelegatableNode delegatableNode, int i5) {
        NodeCoordinator coordinator = delegatableNode.getNode().getCoordinator();
        Intrinsics.checkNotNull(coordinator);
        if (coordinator.getTail() != delegatableNode || !NodeKindKt.m2075getIncludeSelfInTraversalH91voCI(i5)) {
            return coordinator;
        }
        NodeCoordinator wrapped = coordinator.getWrapped();
        Intrinsics.checkNotNull(wrapped);
        return wrapped;
    }

    public static final Density requireDensity(DelegatableNode delegatableNode) {
        return requireLayoutNode(delegatableNode).getDensity();
    }

    public static final GraphicsContext requireGraphicsContext(DelegatableNode delegatableNode) {
        return requireOwner(delegatableNode).getGraphicsContext();
    }

    public static final LayoutCoordinates requireLayoutCoordinates(DelegatableNode delegatableNode) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("Cannot get LayoutCoordinates, Modifier.Node is not attached.");
        }
        LayoutCoordinates coordinates = m1990requireCoordinator64DMado(delegatableNode, NodeKind.m2074constructorimpl(2)).getCoordinates();
        if (!coordinates.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinates is not attached.");
        }
        return coordinates;
    }

    public static final LayoutDirection requireLayoutDirection(DelegatableNode delegatableNode) {
        return requireLayoutNode(delegatableNode).getLayoutDirection();
    }

    public static final LayoutNode requireLayoutNode(DelegatableNode delegatableNode) {
        NodeCoordinator coordinator = delegatableNode.getNode().getCoordinator();
        if (coordinator != null) {
            return coordinator.getLayoutNode();
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Cannot obtain node coordinator. Is the Modifier.Node attached?");
        throw new KotlinNothingValueException();
    }

    public static final Owner requireOwner(DelegatableNode delegatableNode) {
        Owner owner = requireLayoutNode(delegatableNode).getOwner();
        if (owner != null) {
            return owner;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("This node does not have an owner.");
        throw new KotlinNothingValueException();
    }
}
