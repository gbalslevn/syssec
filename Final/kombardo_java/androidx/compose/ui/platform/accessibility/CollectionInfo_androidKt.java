package androidx.compose.ui.platform.accessibility;

import android.support.v4.media.session.a;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\u0006\u001a\u0013\u0010\t\u001a\u00020\b*\u00020\u0000H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001d\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u001b\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010*\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013\"\u0018\u0010\u0014\u001a\u00020\b*\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsNode;", "node", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "info", BuildConfig.FLAVOR, "setCollectionInfo", "(Landroidx/compose/ui/semantics/SemanticsNode;Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;)V", "setCollectionItemInfo", BuildConfig.FLAVOR, "hasCollectionInfo", "(Landroidx/compose/ui/semantics/SemanticsNode;)Z", BuildConfig.FLAVOR, "items", "calculateIfHorizontallyStacked", "(Ljava/util/List;)Z", "Landroidx/compose/ui/semantics/CollectionInfo;", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat$CollectionInfoCompat;", "kotlin.jvm.PlatformType", "toAccessibilityCollectionInfo", "(Landroidx/compose/ui/semantics/CollectionInfo;)Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat$CollectionInfoCompat;", "isLazyCollection", "(Landroidx/compose/ui/semantics/CollectionInfo;)Z", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class CollectionInfo_androidKt {
    private static final boolean calculateIfHorizontallyStacked(List<SemanticsNode> list) {
        List emptyList;
        long packedValue;
        if (list.size() < 2) {
            return true;
        }
        if (list.size() == 0 || list.size() == 1) {
            emptyList = CollectionsKt.emptyList();
        } else {
            emptyList = new ArrayList();
            SemanticsNode semanticsNode = list.get(0);
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i5 = 0;
            while (i5 < lastIndex) {
                i5++;
                SemanticsNode semanticsNode2 = list.get(i5);
                SemanticsNode semanticsNode3 = semanticsNode2;
                SemanticsNode semanticsNode4 = semanticsNode;
                emptyList.add(Offset.m1328boximpl(OffsetKt.Offset(Math.abs(Offset.m1337getXimpl(semanticsNode4.getBoundsInRoot().m1356getCenterF1C5BW0()) - Offset.m1337getXimpl(semanticsNode3.getBoundsInRoot().m1356getCenterF1C5BW0())), Math.abs(Offset.m1338getYimpl(semanticsNode4.getBoundsInRoot().m1356getCenterF1C5BW0()) - Offset.m1338getYimpl(semanticsNode3.getBoundsInRoot().m1356getCenterF1C5BW0())))));
                semanticsNode = semanticsNode2;
            }
        }
        if (emptyList.size() == 1) {
            packedValue = ((Offset) CollectionsKt.first(emptyList)).getPackedValue();
        } else {
            if (emptyList.isEmpty()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object first = CollectionsKt.first((List<? extends Object>) emptyList);
            int lastIndex2 = CollectionsKt.getLastIndex(emptyList);
            if (1 <= lastIndex2) {
                int i6 = 1;
                while (true) {
                    first = Offset.m1328boximpl(Offset.m1342plusMKHz9U(((Offset) first).getPackedValue(), ((Offset) emptyList.get(i6)).getPackedValue()));
                    if (i6 == lastIndex2) {
                        break;
                    }
                    i6++;
                }
            }
            packedValue = ((Offset) first).getPackedValue();
        }
        return Offset.m1338getYimpl(packedValue) < Offset.m1337getXimpl(packedValue);
    }

    public static final boolean hasCollectionInfo(SemanticsNode semanticsNode) {
        SemanticsConfiguration config = semanticsNode.getConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        return (SemanticsConfigurationKt.getOrNull(config, semanticsProperties.getCollectionInfo()) == null && SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), semanticsProperties.getSelectableGroup()) == null) ? false : true;
    }

    private static final boolean isLazyCollection(CollectionInfo collectionInfo) {
        return collectionInfo.getRowCount() < 0 || collectionInfo.getColumnCount() < 0;
    }

    public static final void setCollectionInfo(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        SemanticsConfiguration config = semanticsNode.getConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        CollectionInfo collectionInfo = (CollectionInfo) SemanticsConfigurationKt.getOrNull(config, semanticsProperties.getCollectionInfo());
        if (collectionInfo != null) {
            accessibilityNodeInfoCompat.setCollectionInfo(toAccessibilityCollectionInfo(collectionInfo));
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), semanticsProperties.getSelectableGroup()) != null) {
            List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
            int size = replacedChildren$ui_release.size();
            for (int i5 = 0; i5 < size; i5++) {
                SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(i5);
                if (semanticsNode2.getConfig().contains(SemanticsProperties.INSTANCE.getSelected())) {
                    arrayList.add(semanticsNode2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        boolean calculateIfHorizontallyStacked = calculateIfHorizontallyStacked(arrayList);
        accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(calculateIfHorizontallyStacked ? 1 : arrayList.size(), calculateIfHorizontallyStacked ? arrayList.size() : 1, false, 0));
    }

    public static final void setCollectionItemInfo(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        SemanticsConfiguration config = semanticsNode.getConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        a.a(SemanticsConfigurationKt.getOrNull(config, semanticsProperties.getCollectionItemInfo()));
        SemanticsNode parent = semanticsNode.getParent();
        if (parent == null || SemanticsConfigurationKt.getOrNull(parent.getConfig(), semanticsProperties.getSelectableGroup()) == null) {
            return;
        }
        CollectionInfo collectionInfo = (CollectionInfo) SemanticsConfigurationKt.getOrNull(parent.getConfig(), semanticsProperties.getCollectionInfo());
        if ((collectionInfo == null || !isLazyCollection(collectionInfo)) && semanticsNode.getConfig().contains(semanticsProperties.getSelected())) {
            ArrayList arrayList = new ArrayList();
            List<SemanticsNode> replacedChildren$ui_release = parent.getReplacedChildren$ui_release();
            int size = replacedChildren$ui_release.size();
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(i6);
                if (semanticsNode2.getConfig().contains(SemanticsProperties.INSTANCE.getSelected())) {
                    arrayList.add(semanticsNode2);
                    if (semanticsNode2.getLayoutNode().getPlaceOrder$ui_release() < semanticsNode.getLayoutNode().getPlaceOrder$ui_release()) {
                        i5++;
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            boolean calculateIfHorizontallyStacked = calculateIfHorizontallyStacked(arrayList);
            AccessibilityNodeInfoCompat.CollectionItemInfoCompat obtain = AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(calculateIfHorizontallyStacked ? 0 : i5, 1, calculateIfHorizontallyStacked ? i5 : 0, 1, false, ((Boolean) semanticsNode.getConfig().getOrElse(SemanticsProperties.INSTANCE.getSelected(), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.accessibility.CollectionInfo_androidKt$setCollectionItemInfo$itemInfo$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.FALSE;
                }
            })).booleanValue());
            if (obtain != null) {
                accessibilityNodeInfoCompat.setCollectionItemInfo(obtain);
            }
        }
    }

    private static final AccessibilityNodeInfoCompat.CollectionInfoCompat toAccessibilityCollectionInfo(CollectionInfo collectionInfo) {
        return AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(collectionInfo.getRowCount(), collectionInfo.getColumnCount(), false, 0);
    }
}
