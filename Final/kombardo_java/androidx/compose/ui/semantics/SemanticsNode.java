package androidx.compose.ui.semantics;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.unit.IntSize;
import com.sdk.growthbook.utils.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0013\u001a\u00020\r*\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00000\u00152\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0019\u001a\u00020\r2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00000\u0010H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ0\u0010\"\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\r0\u001dH\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010!J)\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00000\u00152\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0004H\u0000¢\u0006\u0004\b$\u0010%J3\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00000\u00152\b\b\u0002\u0010&\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0004H\u0000¢\u0006\u0004\b'\u0010(J\u0011\u0010-\u001a\u0004\u0018\u00010*H\u0000¢\u0006\u0004\b+\u0010,J\u000f\u00100\u001a\u00020\u0000H\u0000¢\u0006\u0004\b.\u0010/R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u00101\u001a\u0004\b2\u00103R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00104\u001a\u0004\b5\u00106R\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u00107\u001a\u0004\b8\u00109R\u001a\u0010\t\u001a\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010:\u001a\u0004\b;\u0010<R\"\u0010=\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b=\u00104\u001a\u0004\b>\u00106\"\u0004\b?\u0010@R\u0018\u0010A\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0017\u0010D\u001a\u00020C8\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bH\u00106R\u0014\u0010J\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bI\u00106R\u0011\u0010N\u001a\u00020K8F¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0011\u0010R\u001a\u00020O8F¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0017\u0010V\u001a\u00020S8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0011\u0010X\u001a\u00020O8F¢\u0006\u0006\u001a\u0004\bW\u0010QR\u0017\u0010[\u001a\u00020Y8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bZ\u0010UR\u0011\u0010]\u001a\u00020O8F¢\u0006\u0006\u001a\u0004\b\\\u0010QR\u0014\u0010_\u001a\u00020O8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b^\u0010QR\u0014\u0010a\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b`\u00106R\u0011\u0010c\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bb\u0010<R\u0017\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00000\u00158F¢\u0006\u0006\u001a\u0004\b)\u0010dR\u001a\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00000\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bf\u0010dR\u0013\u0010i\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\bh\u0010/\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006j"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsNode;", BuildConfig.FLAVOR, "Landroidx/compose/ui/Modifier$Node;", "outerSemanticsNode", BuildConfig.FLAVOR, "mergingEnabled", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "unmergedConfig", "<init>", "(Landroidx/compose/ui/Modifier$Node;ZLandroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/semantics/SemanticsConfiguration;)V", "mergedConfig", BuildConfig.FLAVOR, "mergeConfig", "(Landroidx/compose/ui/semantics/SemanticsConfiguration;)V", BuildConfig.FLAVOR, "list", "includeDeactivatedNodes", "fillOneLayerOfSemanticsWrappers", "(Landroidx/compose/ui/node/LayoutNode;Ljava/util/List;Z)V", BuildConfig.FLAVOR, "findOneLayerOfMergingSemanticsNodes", "(Ljava/util/List;)Ljava/util/List;", "unmergedChildren", "emitFakeNodes", "(Ljava/util/List;)V", "Landroidx/compose/ui/semantics/Role;", "role", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "properties", "fakeSemanticsNode-ypyhhiA", "(Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/semantics/SemanticsNode;", "fakeSemanticsNode", "includeFakeNodes", "unmergedChildren$ui_release", "(ZZ)Ljava/util/List;", "includeReplacedSemantics", "getChildren$ui_release", "(ZZZ)Ljava/util/List;", "getChildren", "Landroidx/compose/ui/node/NodeCoordinator;", "findCoordinatorToGetBounds$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "findCoordinatorToGetBounds", "copyWithMergingEnabled$ui_release", "()Landroidx/compose/ui/semantics/SemanticsNode;", "copyWithMergingEnabled", "Landroidx/compose/ui/Modifier$Node;", "getOuterSemanticsNode$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "Z", "getMergingEnabled", "()Z", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getUnmergedConfig$ui_release", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "isFake", "isFake$ui_release", "setFake$ui_release", "(Z)V", "fakeNodeParent", "Landroidx/compose/ui/semantics/SemanticsNode;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "I", "getId", "()I", "isMergingSemanticsOfDescendants", "isUnmergedLeafNode$ui_release", "isUnmergedLeafNode", "Landroidx/compose/ui/layout/LayoutInfo;", "getLayoutInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "layoutInfo", "Landroidx/compose/ui/geometry/Rect;", "getTouchBoundsInRoot", "()Landroidx/compose/ui/geometry/Rect;", "touchBoundsInRoot", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "size", "getBoundsInRoot", "boundsInRoot", "Landroidx/compose/ui/geometry/Offset;", "getPositionInRoot-F1C5BW0", "positionInRoot", "getBoundsInWindow", "boundsInWindow", "getBoundsInParent$ui_release", "boundsInParent", "isTransparent$ui_release", "isTransparent", "getConfig", "config", "()Ljava/util/List;", "children", "getReplacedChildren$ui_release", "replacedChildren", "getParent", "parent", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SemanticsNode {
    private SemanticsNode fakeNodeParent;
    private final int id;
    private boolean isFake;
    private final LayoutNode layoutNode;
    private final boolean mergingEnabled;
    private final Modifier.Node outerSemanticsNode;
    private final SemanticsConfiguration unmergedConfig;

    public SemanticsNode(Modifier.Node node, boolean z5, LayoutNode layoutNode, SemanticsConfiguration semanticsConfiguration) {
        this.outerSemanticsNode = node;
        this.mergingEnabled = z5;
        this.layoutNode = layoutNode;
        this.unmergedConfig = semanticsConfiguration;
        this.id = layoutNode.getSemanticsId();
    }

    private final void emitFakeNodes(List<SemanticsNode> unmergedChildren) {
        final Role access$getRole = SemanticsNodeKt.access$getRole(this);
        if (access$getRole != null && this.unmergedConfig.getIsMergingSemanticsOfDescendants() && !unmergedChildren.isEmpty()) {
            unmergedChildren.add(m2177fakeSemanticsNodeypyhhiA(access$getRole, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsNode$emitFakeNodes$fakeNode$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m2184setRolekuIjeqM(semanticsPropertyReceiver, Role.this.getValue());
                }
            }));
        }
        SemanticsConfiguration semanticsConfiguration = this.unmergedConfig;
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        if (semanticsConfiguration.contains(semanticsProperties.getContentDescription()) && !unmergedChildren.isEmpty() && this.unmergedConfig.getIsMergingSemanticsOfDescendants()) {
            List list = (List) SemanticsConfigurationKt.getOrNull(this.unmergedConfig, semanticsProperties.getContentDescription());
            final String str = list != null ? (String) CollectionsKt.firstOrNull(list) : null;
            if (str != null) {
                unmergedChildren.add(0, m2177fakeSemanticsNodeypyhhiA(null, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsNode$emitFakeNodes$fakeNode$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
                    }
                }));
            }
        }
    }

    /* renamed from: fakeSemanticsNode-ypyhhiA, reason: not valid java name */
    private final SemanticsNode m2177fakeSemanticsNodeypyhhiA(Role role, Function1<? super SemanticsPropertyReceiver, Unit> properties) {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.setMergingSemanticsOfDescendants(false);
        semanticsConfiguration.setClearingSemantics(false);
        properties.invoke(semanticsConfiguration);
        SemanticsNode semanticsNode = new SemanticsNode(new SemanticsNode$fakeSemanticsNode$fakeNode$1(properties), false, new LayoutNode(true, role != null ? SemanticsNodeKt.access$roleFakeNodeId(this) : SemanticsNodeKt.access$contentDescriptionFakeNodeId(this)), semanticsConfiguration);
        semanticsNode.isFake = true;
        semanticsNode.fakeNodeParent = this;
        return semanticsNode;
    }

    private final void fillOneLayerOfSemanticsWrappers(LayoutNode layoutNode, List<SemanticsNode> list, boolean z5) {
        MutableVector<LayoutNode> zSortedChildren = layoutNode.getZSortedChildren();
        int size = zSortedChildren.getSize();
        if (size > 0) {
            LayoutNode[] content = zSortedChildren.getContent();
            int i5 = 0;
            do {
                LayoutNode layoutNode2 = content[i5];
                if (layoutNode2.isAttached() && (z5 || !layoutNode2.getIsDeactivated())) {
                    if (layoutNode2.getNodes().m2042hasH91voCI$ui_release(NodeKind.m2074constructorimpl(8))) {
                        list.add(SemanticsNodeKt.SemanticsNode(layoutNode2, this.mergingEnabled));
                    } else {
                        fillOneLayerOfSemanticsWrappers(layoutNode2, list, z5);
                    }
                }
                i5++;
            } while (i5 < size);
        }
    }

    private final List<SemanticsNode> findOneLayerOfMergingSemanticsNodes(List<SemanticsNode> list) {
        List unmergedChildren$ui_release$default = unmergedChildren$ui_release$default(this, false, false, 3, null);
        int size = unmergedChildren$ui_release$default.size();
        for (int i5 = 0; i5 < size; i5++) {
            SemanticsNode semanticsNode = (SemanticsNode) unmergedChildren$ui_release$default.get(i5);
            if (semanticsNode.isMergingSemanticsOfDescendants()) {
                list.add(semanticsNode);
            } else if (!semanticsNode.unmergedConfig.getIsClearingSemantics()) {
                semanticsNode.findOneLayerOfMergingSemanticsNodes(list);
            }
        }
        return list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ List findOneLayerOfMergingSemanticsNodes$default(SemanticsNode semanticsNode, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            list = new ArrayList();
        }
        return semanticsNode.findOneLayerOfMergingSemanticsNodes(list);
    }

    public static /* synthetic */ List getChildren$ui_release$default(SemanticsNode semanticsNode, boolean z5, boolean z6, boolean z7, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = !semanticsNode.mergingEnabled;
        }
        if ((i5 & 2) != 0) {
            z6 = false;
        }
        if ((i5 & 4) != 0) {
            z7 = false;
        }
        return semanticsNode.getChildren$ui_release(z5, z6, z7);
    }

    private final boolean isMergingSemanticsOfDescendants() {
        return this.mergingEnabled && this.unmergedConfig.getIsMergingSemanticsOfDescendants();
    }

    private final void mergeConfig(SemanticsConfiguration mergedConfig) {
        if (this.unmergedConfig.getIsClearingSemantics()) {
            return;
        }
        List unmergedChildren$ui_release$default = unmergedChildren$ui_release$default(this, false, false, 3, null);
        int size = unmergedChildren$ui_release$default.size();
        for (int i5 = 0; i5 < size; i5++) {
            SemanticsNode semanticsNode = (SemanticsNode) unmergedChildren$ui_release$default.get(i5);
            if (!semanticsNode.isMergingSemanticsOfDescendants()) {
                mergedConfig.mergeChild$ui_release(semanticsNode.unmergedConfig);
                semanticsNode.mergeConfig(mergedConfig);
            }
        }
    }

    public static /* synthetic */ List unmergedChildren$ui_release$default(SemanticsNode semanticsNode, boolean z5, boolean z6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        if ((i5 & 2) != 0) {
            z6 = false;
        }
        return semanticsNode.unmergedChildren$ui_release(z5, z6);
    }

    public final SemanticsNode copyWithMergingEnabled$ui_release() {
        return new SemanticsNode(this.outerSemanticsNode, true, this.layoutNode, this.unmergedConfig);
    }

    public final NodeCoordinator findCoordinatorToGetBounds$ui_release() {
        if (this.isFake) {
            SemanticsNode parent = getParent();
            if (parent != null) {
                return parent.findCoordinatorToGetBounds$ui_release();
            }
            return null;
        }
        DelegatableNode outerMergingSemantics = SemanticsNodeKt.getOuterMergingSemantics(this.layoutNode);
        if (outerMergingSemantics == null) {
            outerMergingSemantics = this.outerSemanticsNode;
        }
        return DelegatableNodeKt.m1990requireCoordinator64DMado(outerMergingSemantics, NodeKind.m2074constructorimpl(8));
    }

    public final Rect getBoundsInParent$ui_release() {
        LayoutCoordinates coordinates;
        SemanticsNode parent = getParent();
        if (parent == null) {
            return Rect.INSTANCE.getZero();
        }
        NodeCoordinator findCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (findCoordinatorToGetBounds$ui_release != null) {
            if (!findCoordinatorToGetBounds$ui_release.isAttached()) {
                findCoordinatorToGetBounds$ui_release = null;
            }
            if (findCoordinatorToGetBounds$ui_release != null && (coordinates = findCoordinatorToGetBounds$ui_release.getCoordinates()) != null) {
                return LayoutCoordinates.localBoundingBoxOf$default(DelegatableNodeKt.m1990requireCoordinator64DMado(parent.outerSemanticsNode, NodeKind.m2074constructorimpl(8)), coordinates, false, 2, null);
            }
        }
        return Rect.INSTANCE.getZero();
    }

    public final Rect getBoundsInRoot() {
        Rect boundsInRoot;
        NodeCoordinator findCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (findCoordinatorToGetBounds$ui_release != null) {
            if (!findCoordinatorToGetBounds$ui_release.isAttached()) {
                findCoordinatorToGetBounds$ui_release = null;
            }
            if (findCoordinatorToGetBounds$ui_release != null && (boundsInRoot = LayoutCoordinatesKt.boundsInRoot(findCoordinatorToGetBounds$ui_release)) != null) {
                return boundsInRoot;
            }
        }
        return Rect.INSTANCE.getZero();
    }

    public final Rect getBoundsInWindow() {
        Rect boundsInWindow;
        NodeCoordinator findCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (findCoordinatorToGetBounds$ui_release != null) {
            if (!findCoordinatorToGetBounds$ui_release.isAttached()) {
                findCoordinatorToGetBounds$ui_release = null;
            }
            if (findCoordinatorToGetBounds$ui_release != null && (boundsInWindow = LayoutCoordinatesKt.boundsInWindow(findCoordinatorToGetBounds$ui_release)) != null) {
                return boundsInWindow;
            }
        }
        return Rect.INSTANCE.getZero();
    }

    public final List<SemanticsNode> getChildren() {
        return getChildren$ui_release$default(this, false, false, false, 7, null);
    }

    public final List<SemanticsNode> getChildren$ui_release(boolean includeReplacedSemantics, boolean includeFakeNodes, boolean includeDeactivatedNodes) {
        return (includeReplacedSemantics || !this.unmergedConfig.getIsClearingSemantics()) ? isMergingSemanticsOfDescendants() ? findOneLayerOfMergingSemanticsNodes$default(this, null, 1, null) : unmergedChildren$ui_release(includeFakeNodes, includeDeactivatedNodes) : CollectionsKt.emptyList();
    }

    public final SemanticsConfiguration getConfig() {
        if (!isMergingSemanticsOfDescendants()) {
            return this.unmergedConfig;
        }
        SemanticsConfiguration copy = this.unmergedConfig.copy();
        mergeConfig(copy);
        return copy;
    }

    public final int getId() {
        return this.id;
    }

    public final LayoutInfo getLayoutInfo() {
        return this.layoutNode;
    }

    /* renamed from: getLayoutNode$ui_release, reason: from getter */
    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public final SemanticsNode getParent() {
        SemanticsNode semanticsNode = this.fakeNodeParent;
        if (semanticsNode != null) {
            return semanticsNode;
        }
        LayoutNode findClosestParentNode = this.mergingEnabled ? SemanticsNodeKt.findClosestParentNode(this.layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.semantics.SemanticsNode$parent$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(LayoutNode layoutNode) {
                SemanticsConfiguration collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release();
                boolean z5 = false;
                if (collapsedSemantics$ui_release != null && collapsedSemantics$ui_release.getIsMergingSemanticsOfDescendants()) {
                    z5 = true;
                }
                return Boolean.valueOf(z5);
            }
        }) : null;
        if (findClosestParentNode == null) {
            findClosestParentNode = SemanticsNodeKt.findClosestParentNode(this.layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.semantics.SemanticsNode$parent$2
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(LayoutNode layoutNode) {
                    return Boolean.valueOf(layoutNode.getNodes().m2042hasH91voCI$ui_release(NodeKind.m2074constructorimpl(8)));
                }
            });
        }
        if (findClosestParentNode == null) {
            return null;
        }
        return SemanticsNodeKt.SemanticsNode(findClosestParentNode, this.mergingEnabled);
    }

    /* renamed from: getPositionInRoot-F1C5BW0, reason: not valid java name */
    public final long m2178getPositionInRootF1C5BW0() {
        NodeCoordinator findCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (findCoordinatorToGetBounds$ui_release != null) {
            if (!findCoordinatorToGetBounds$ui_release.isAttached()) {
                findCoordinatorToGetBounds$ui_release = null;
            }
            if (findCoordinatorToGetBounds$ui_release != null) {
                return LayoutCoordinatesKt.positionInRoot(findCoordinatorToGetBounds$ui_release);
            }
        }
        return Offset.INSTANCE.m1349getZeroF1C5BW0();
    }

    public final List<SemanticsNode> getReplacedChildren$ui_release() {
        return getChildren$ui_release$default(this, false, true, false, 4, null);
    }

    /* renamed from: getSize-YbymL2g, reason: not valid java name */
    public final long m2179getSizeYbymL2g() {
        NodeCoordinator findCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        return findCoordinatorToGetBounds$ui_release != null ? findCoordinatorToGetBounds$ui_release.mo1948getSizeYbymL2g() : IntSize.INSTANCE.m2665getZeroYbymL2g();
    }

    public final Rect getTouchBoundsInRoot() {
        DelegatableNode delegatableNode;
        if (this.unmergedConfig.getIsMergingSemanticsOfDescendants()) {
            delegatableNode = SemanticsNodeKt.getOuterMergingSemantics(this.layoutNode);
            if (delegatableNode == null) {
                delegatableNode = this.outerSemanticsNode;
            }
        } else {
            delegatableNode = this.outerSemanticsNode;
        }
        return SemanticsModifierNodeKt.touchBoundsInRoot(delegatableNode.getNode(), SemanticsModifierNodeKt.getUseMinimumTouchTarget(this.unmergedConfig));
    }

    /* renamed from: getUnmergedConfig$ui_release, reason: from getter */
    public final SemanticsConfiguration getUnmergedConfig() {
        return this.unmergedConfig;
    }

    /* renamed from: isFake$ui_release, reason: from getter */
    public final boolean getIsFake() {
        return this.isFake;
    }

    public final boolean isTransparent$ui_release() {
        NodeCoordinator findCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (findCoordinatorToGetBounds$ui_release != null) {
            return findCoordinatorToGetBounds$ui_release.isTransparent();
        }
        return false;
    }

    public final boolean isUnmergedLeafNode$ui_release() {
        return !this.isFake && getReplacedChildren$ui_release().isEmpty() && SemanticsNodeKt.findClosestParentNode(this.layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.semantics.SemanticsNode$isUnmergedLeafNode$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(LayoutNode layoutNode) {
                SemanticsConfiguration collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release();
                boolean z5 = false;
                if (collapsedSemantics$ui_release != null && collapsedSemantics$ui_release.getIsMergingSemanticsOfDescendants()) {
                    z5 = true;
                }
                return Boolean.valueOf(z5);
            }
        }) == null;
    }

    public final List<SemanticsNode> unmergedChildren$ui_release(boolean includeFakeNodes, boolean includeDeactivatedNodes) {
        if (this.isFake) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        fillOneLayerOfSemanticsWrappers(this.layoutNode, arrayList, includeDeactivatedNodes);
        if (includeFakeNodes) {
            emitFakeNodes(arrayList);
        }
        return arrayList;
    }
}
