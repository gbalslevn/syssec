package androidx.compose.runtime;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\u001a\u001b\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\b\u0010\u0004\u001a\u001b\u0010\t\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\t\u0010\u0007\u001a\u001b\u0010\n\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\n\u0010\u0004\u001a\u001b\u0010\u000b\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\u0007\u001a\u001b\u0010\f\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\f\u0010\u0007\u001a#\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001b\u0010\u0011\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0011\u0010\u0007\u001a#\u0010\u0012\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0010\u001a\u001b\u0010\u0013\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0013\u0010\u0007\u001a\u001b\u0010\u0014\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0014\u0010\u0004\u001a\u001b\u0010\u0015\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0015\u0010\u0004\u001a\u0017\u0010\u0016\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001b\u0010\u0018\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0018\u0010\u0004\u001a\u001b\u0010\u0019\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0019\u0010\u0004\u001a#\u0010\u001a\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001b\u0010\u001c\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001c\u0010\u0004\u001a#\u0010\u001d\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001d\u0010\u001b\u001a\u001b\u0010\u001e\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001e\u0010\u0004\u001a#\u0010\u001f\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u001f\u0010\u001b\u001a\u001b\u0010 \u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b \u0010\u0004\u001a#\u0010\"\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\"\u0010\u001b\u001aK\u0010%\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u0001H\u0002¢\u0006\u0004\b%\u0010&\u001a5\u0010,\u001a\u0004\u0018\u00010(*\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)2\u0006\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u0001H\u0002¢\u0006\u0004\b,\u0010-\u001a3\u0010/\u001a\u00020\u0001*\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)2\u0006\u0010.\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u0001H\u0002¢\u0006\u0004\b/\u00100\u001a3\u00101\u001a\u00020\u0001*\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)2\u0006\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u0001H\u0002¢\u0006\u0004\b1\u00100\"\u0014\u00102\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u00103\"\u0014\u00104\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u00103\"\u0014\u00105\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u00103\"\u0014\u00106\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00103\"\u0014\u00107\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00103\"\u0014\u00108\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00103\"\u0014\u00109\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u00103\"\u0014\u0010:\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u00103\"\u0014\u0010;\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u00103\"\u0014\u0010<\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u00103\"\u0014\u0010=\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\b=\u00103\"\u0014\u0010>\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\b>\u00103\"\u0014\u0010?\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\b?\u00103\"\u0014\u0010@\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\b@\u00103\"\u0014\u0010A\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\bA\u00103\"\u0014\u0010B\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\bB\u00103\"\u0014\u0010C\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\bC\u00103\"\u0014\u0010D\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\bD\u00103\"\u0014\u0010E\u001a\u00020\u00018\u0002X\u0082T¢\u0006\u0006\n\u0004\bE\u00103¨\u0006F"}, d2 = {BuildConfig.FLAVOR, BuildConfig.FLAVOR, "address", "groupInfo", "([II)I", BuildConfig.FLAVOR, "isNode", "([II)Z", "nodeIndex", "hasObjectKey", "objectKeyIndex", "hasAux", "hasMark", "value", BuildConfig.FLAVOR, "updateMark", "([IIZ)V", "containsMark", "updateContainsMark", "containsAnyMark", "auxIndex", "slotAnchor", "countOneBits", "(I)I", "key", "nodeCount", "updateNodeCount", "([III)V", "parentAnchor", "updateParentAnchor", "groupSize", "updateGroupSize", "dataAnchor", "anchor", "updateDataAnchor", "hasDataKey", "hasData", "initGroup", "([IIIZZZII)V", "Ljava/util/ArrayList;", "Landroidx/compose/runtime/Anchor;", "Lkotlin/collections/ArrayList;", "index", "effectiveSize", "find", "(Ljava/util/ArrayList;II)Landroidx/compose/runtime/Anchor;", "location", "search", "(Ljava/util/ArrayList;II)I", "locationOf", "parentAnchorPivot", "I", "Key_Offset", "GroupInfo_Offset", "ParentAnchor_Offset", "Size_Offset", "DataAnchor_Offset", "Group_Fields_Size", "NodeBit_Mask", "ObjectKey_Mask", "ObjectKey_Shift", "Aux_Mask", "Aux_Shift", "Mark_Mask", "ContainsMark_Mask", "Slots_Shift", "NodeCount_Mask", "MinGroupGrowthSize", "MinSlotsGrowthSize", "LIVE_EDIT_INVALID_KEY", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SlotTableKt {
    private static final int Aux_Mask = 268435456;
    private static final int Aux_Shift = 28;
    private static final int ContainsMark_Mask = 67108864;
    private static final int DataAnchor_Offset = 4;
    private static final int GroupInfo_Offset = 1;
    private static final int Group_Fields_Size = 5;
    private static final int Key_Offset = 0;
    private static final int LIVE_EDIT_INVALID_KEY = -3;
    private static final int Mark_Mask = 134217728;
    private static final int MinGroupGrowthSize = 32;
    private static final int MinSlotsGrowthSize = 32;
    private static final int NodeBit_Mask = 1073741824;
    private static final int NodeCount_Mask = 67108863;
    private static final int ObjectKey_Mask = 536870912;
    private static final int ObjectKey_Shift = 29;
    private static final int ParentAnchor_Offset = 2;
    private static final int Size_Offset = 3;
    private static final int Slots_Shift = 28;
    private static final int parentAnchorPivot = -2;

    public static final /* synthetic */ int access$auxIndex(int[] iArr, int i5) {
        return auxIndex(iArr, i5);
    }

    public static final /* synthetic */ boolean access$containsAnyMark(int[] iArr, int i5) {
        return containsAnyMark(iArr, i5);
    }

    public static final /* synthetic */ boolean access$containsMark(int[] iArr, int i5) {
        return containsMark(iArr, i5);
    }

    public static final /* synthetic */ int access$countOneBits(int i5) {
        return countOneBits(i5);
    }

    public static final /* synthetic */ int access$dataAnchor(int[] iArr, int i5) {
        return dataAnchor(iArr, i5);
    }

    public static final /* synthetic */ Anchor access$find(ArrayList arrayList, int i5, int i6) {
        return find(arrayList, i5, i6);
    }

    public static final /* synthetic */ int access$groupInfo(int[] iArr, int i5) {
        return groupInfo(iArr, i5);
    }

    public static final /* synthetic */ int access$groupSize(int[] iArr, int i5) {
        return groupSize(iArr, i5);
    }

    public static final /* synthetic */ boolean access$hasAux(int[] iArr, int i5) {
        return hasAux(iArr, i5);
    }

    public static final /* synthetic */ boolean access$hasMark(int[] iArr, int i5) {
        return hasMark(iArr, i5);
    }

    public static final /* synthetic */ boolean access$hasObjectKey(int[] iArr, int i5) {
        return hasObjectKey(iArr, i5);
    }

    public static final /* synthetic */ void access$initGroup(int[] iArr, int i5, int i6, boolean z5, boolean z6, boolean z7, int i7, int i8) {
        initGroup(iArr, i5, i6, z5, z6, z7, i7, i8);
    }

    public static final /* synthetic */ boolean access$isNode(int[] iArr, int i5) {
        return isNode(iArr, i5);
    }

    public static final /* synthetic */ int access$key(int[] iArr, int i5) {
        return key(iArr, i5);
    }

    public static final /* synthetic */ int access$locationOf(ArrayList arrayList, int i5, int i6) {
        return locationOf(arrayList, i5, i6);
    }

    public static final /* synthetic */ int access$nodeCount(int[] iArr, int i5) {
        return nodeCount(iArr, i5);
    }

    public static final /* synthetic */ int access$nodeIndex(int[] iArr, int i5) {
        return nodeIndex(iArr, i5);
    }

    public static final /* synthetic */ int access$objectKeyIndex(int[] iArr, int i5) {
        return objectKeyIndex(iArr, i5);
    }

    public static final /* synthetic */ int access$parentAnchor(int[] iArr, int i5) {
        return parentAnchor(iArr, i5);
    }

    public static final /* synthetic */ int access$search(ArrayList arrayList, int i5, int i6) {
        return search(arrayList, i5, i6);
    }

    public static final /* synthetic */ int access$slotAnchor(int[] iArr, int i5) {
        return slotAnchor(iArr, i5);
    }

    public static final /* synthetic */ void access$updateContainsMark(int[] iArr, int i5, boolean z5) {
        updateContainsMark(iArr, i5, z5);
    }

    public static final /* synthetic */ void access$updateDataAnchor(int[] iArr, int i5, int i6) {
        updateDataAnchor(iArr, i5, i6);
    }

    public static final /* synthetic */ void access$updateGroupSize(int[] iArr, int i5, int i6) {
        updateGroupSize(iArr, i5, i6);
    }

    public static final /* synthetic */ void access$updateMark(int[] iArr, int i5, boolean z5) {
        updateMark(iArr, i5, z5);
    }

    public static final /* synthetic */ void access$updateNodeCount(int[] iArr, int i5, int i6) {
        updateNodeCount(iArr, i5, i6);
    }

    public static final /* synthetic */ void access$updateParentAnchor(int[] iArr, int i5, int i6) {
        updateParentAnchor(iArr, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int auxIndex(int[] iArr, int i5) {
        int i6 = i5 * 5;
        if (i6 >= iArr.length) {
            return iArr.length;
        }
        return countOneBits(iArr[i6 + 1] >> 29) + iArr[i6 + 4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean containsAnyMark(int[] iArr, int i5) {
        return (iArr[(i5 * 5) + 1] & 201326592) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean containsMark(int[] iArr, int i5) {
        return (iArr[(i5 * 5) + 1] & ContainsMark_Mask) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int countOneBits(int i5) {
        switch (i5) {
            case 0:
                return 0;
            case 1:
            case 2:
            case 4:
                return 1;
            case 3:
            case 5:
            case 6:
                return 2;
            default:
                return 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int dataAnchor(int[] iArr, int i5) {
        return iArr[(i5 * 5) + 4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Anchor find(ArrayList<Anchor> arrayList, int i5, int i6) {
        int search = search(arrayList, i5, i6);
        if (search >= 0) {
            return arrayList.get(search);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int groupInfo(int[] iArr, int i5) {
        return iArr[(i5 * 5) + 1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int groupSize(int[] iArr, int i5) {
        return iArr[(i5 * 5) + 3];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasAux(int[] iArr, int i5) {
        return (iArr[(i5 * 5) + 1] & Aux_Mask) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasMark(int[] iArr, int i5) {
        return (iArr[(i5 * 5) + 1] & Mark_Mask) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasObjectKey(int[] iArr, int i5) {
        return (iArr[(i5 * 5) + 1] & ObjectKey_Mask) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initGroup(int[] iArr, int i5, int i6, boolean z5, boolean z6, boolean z7, int i7, int i8) {
        int i9 = z5 ? NodeBit_Mask : 0;
        int i10 = z6 ? ObjectKey_Mask : 0;
        int i11 = z7 ? Aux_Mask : 0;
        int i12 = i5 * 5;
        iArr[i12] = i6;
        iArr[i12 + 1] = i9 | i10 | i11;
        iArr[i12 + 2] = i7;
        iArr[i12 + 3] = 0;
        iArr[i12 + 4] = i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isNode(int[] iArr, int i5) {
        return (iArr[(i5 * 5) + 1] & NodeBit_Mask) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int key(int[] iArr, int i5) {
        return iArr[i5 * 5];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int locationOf(ArrayList<Anchor> arrayList, int i5, int i6) {
        int search = search(arrayList, i5, i6);
        return search >= 0 ? search : -(search + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int nodeCount(int[] iArr, int i5) {
        return iArr[(i5 * 5) + 1] & NodeCount_Mask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int nodeIndex(int[] iArr, int i5) {
        return iArr[(i5 * 5) + 4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int objectKeyIndex(int[] iArr, int i5) {
        int i6 = i5 * 5;
        return iArr[i6 + 4] + countOneBits(iArr[i6 + 1] >> 30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int parentAnchor(int[] iArr, int i5) {
        return iArr[(i5 * 5) + 2];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int search(ArrayList<Anchor> arrayList, int i5, int i6) {
        int size = arrayList.size() - 1;
        int i7 = 0;
        while (i7 <= size) {
            int i8 = (i7 + size) >>> 1;
            int location = arrayList.get(i8).getLocation();
            if (location < 0) {
                location += i6;
            }
            int compare = Intrinsics.compare(location, i5);
            if (compare < 0) {
                i7 = i8 + 1;
            } else {
                if (compare <= 0) {
                    return i8;
                }
                size = i8 - 1;
            }
        }
        return -(i7 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int slotAnchor(int[] iArr, int i5) {
        int i6 = i5 * 5;
        return iArr[i6 + 4] + countOneBits(iArr[i6 + 1] >> 28);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateContainsMark(int[] iArr, int i5, boolean z5) {
        int i6 = (i5 * 5) + 1;
        if (z5) {
            iArr[i6] = iArr[i6] | ContainsMark_Mask;
        } else {
            iArr[i6] = iArr[i6] & (-67108865);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateDataAnchor(int[] iArr, int i5, int i6) {
        iArr[(i5 * 5) + 4] = i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateGroupSize(int[] iArr, int i5, int i6) {
        ComposerKt.runtimeCheck(i6 >= 0);
        iArr[(i5 * 5) + 3] = i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateMark(int[] iArr, int i5, boolean z5) {
        int i6 = (i5 * 5) + 1;
        if (z5) {
            iArr[i6] = iArr[i6] | Mark_Mask;
        } else {
            iArr[i6] = iArr[i6] & (-134217729);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateNodeCount(int[] iArr, int i5, int i6) {
        ComposerKt.runtimeCheck(i6 >= 0 && i6 < NodeCount_Mask);
        int i7 = (i5 * 5) + 1;
        iArr[i7] = i6 | (iArr[i7] & (-67108864));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateParentAnchor(int[] iArr, int i5, int i6) {
        iArr[(i5 * 5) + 2] = i6;
    }
}
