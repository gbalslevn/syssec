package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002\u001a/\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u000f\u0010\f\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u0011\u001a\u00020\t*\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\t*\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0013\u0010\u0012\u001a-\u0010\u0018\u001a\u00020\t*\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a3\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d\"\u0004\b\u0000\u0010\u001a\"\b\b\u0001\u0010\u001b*\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a!\u0010#\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020\u0003H\u0002¢\u0006\u0004\b#\u0010$\u001a!\u0010%\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020\u0003H\u0002¢\u0006\u0004\b%\u0010$\u001a3\u0010)\u001a\u00020\t*\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b)\u0010*\u001a+\u0010-\u001a\u0004\u0018\u00010!*\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0003H\u0002¢\u0006\u0004\b-\u0010.\u001a#\u0010/\u001a\u0004\u0018\u00010!*\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020\u0003H\u0002¢\u0006\u0004\b/\u00100\u001a)\u00101\u001a\u00020\t*\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0003H\u0002¢\u0006\u0004\b1\u00102\u001a\u0013\u00103\u001a\u00020\u0003*\u00020\u0000H\u0002¢\u0006\u0004\b3\u00104\u001a\u0013\u00105\u001a\u00020\u0000*\u00020\u0003H\u0002¢\u0006\u0004\b5\u00106\u001a#\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160:*\u0002072\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0004\b;\u0010<\u001a#\u0010?\u001a\u00020\u0003*\u00020=2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u0003H\u0002¢\u0006\u0004\b?\u0010@\u001a+\u0010D\u001a\u00020\u0003*\u00020=2\u0006\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u0003H\u0002¢\u0006\u0004\bD\u0010E\u001a\u0017\u0010G\u001a\u00020\t2\u0006\u0010F\u001a\u00020\u0000H\u0000¢\u0006\u0004\bG\u0010H\u001a\u0017\u0010K\u001a\u00020J2\u0006\u0010I\u001a\u00020\u0007H\u0000¢\u0006\u0004\bK\u0010L\u001a\u0017\u0010M\u001a\u00020\t2\u0006\u0010I\u001a\u00020\u0007H\u0000¢\u0006\u0004\bM\u0010N\"\u001e\u0010P\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\bP\u0010Q\u0012\u0004\bR\u0010\r\"\u0014\u0010S\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\bS\u0010T\"\u0014\u0010U\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\bU\u0010T\"\u0014\u0010V\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\bV\u0010T\" \u0010W\u001a\u00020\u00168\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bW\u0010X\u0012\u0004\b[\u0010\r\u001a\u0004\bY\u0010Z\" \u0010\\\u001a\u00020\u00168\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\\\u0010X\u0012\u0004\b^\u0010\r\u001a\u0004\b]\u0010Z\" \u0010_\u001a\u00020\u00168\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b_\u0010X\u0012\u0004\ba\u0010\r\u001a\u0004\b`\u0010Z\" \u0010b\u001a\u00020\u00168\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bb\u0010X\u0012\u0004\bd\u0010\r\u001a\u0004\bc\u0010Z\" \u0010e\u001a\u00020\u00168\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\be\u0010X\u0012\u0004\bg\u0010\r\u001a\u0004\bf\u0010Z\" \u0010h\u001a\u00020\u00168\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bh\u0010X\u0012\u0004\bj\u0010\r\u001a\u0004\bi\u0010Z\"\u0014\u0010k\u001a\u00020\u00038\u0002X\u0082T¢\u0006\u0006\n\u0004\bk\u0010T\"\u001a\u0010m\u001a\b\u0012\u0004\u0012\u00020!0l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010n\"\u0018\u0010o\u001a\u00020\u0000*\u00020\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bo\u0010p\"\u0018\u0010o\u001a\u00020\u0000*\u00020=8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bo\u0010q\"\u0018\u0010u\u001a\u00020\u0016*\u00020r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bs\u0010t¨\u0006v"}, d2 = {BuildConfig.FLAVOR, "isTraceInProgress", "()Z", BuildConfig.FLAVOR, "key", "dirty1", "dirty2", BuildConfig.FLAVOR, "info", BuildConfig.FLAVOR, "traceEventStart", "(IIILjava/lang/String;)V", "traceEventEnd", "()V", "Landroidx/compose/runtime/SlotWriter;", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "removeCurrentGroup", "(Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "deactivateCurrentGroup", "group", "index", BuildConfig.FLAVOR, "data", "removeData", "(Landroidx/compose/runtime/SlotWriter;IILjava/lang/Object;)V", "K", "V", "initialCapacity", "Landroidx/compose/runtime/MutableScatterMultiMap;", "multiMap", "(I)Landroidx/collection/MutableScatterMap;", BuildConfig.FLAVOR, "Landroidx/compose/runtime/Invalidation;", "location", "findLocation", "(Ljava/util/List;I)I", "findInsertLocation", "Landroidx/compose/runtime/RecomposeScopeImpl;", "scope", "instance", "insertIfMissing", "(Ljava/util/List;ILandroidx/compose/runtime/RecomposeScopeImpl;Ljava/lang/Object;)V", "start", "end", "firstInRange", "(Ljava/util/List;II)Landroidx/compose/runtime/Invalidation;", "removeLocation", "(Ljava/util/List;I)Landroidx/compose/runtime/Invalidation;", "removeRange", "(Ljava/util/List;II)V", "asInt", "(Z)I", "asBool", "(I)Z", "Landroidx/compose/runtime/SlotTable;", "Landroidx/compose/runtime/Anchor;", "anchor", BuildConfig.FLAVOR, "collectNodesFrom", "(Landroidx/compose/runtime/SlotTable;Landroidx/compose/runtime/Anchor;)Ljava/util/List;", "Landroidx/compose/runtime/SlotReader;", "root", "distanceFrom", "(Landroidx/compose/runtime/SlotReader;II)I", "a", "b", "common", "nearestCommonRootOf", "(Landroidx/compose/runtime/SlotReader;III)I", "value", "runtimeCheck", "(Z)V", "message", BuildConfig.FLAVOR, "composeRuntimeError", "(Ljava/lang/String;)Ljava/lang/Void;", "composeImmediateRuntimeError", "(Ljava/lang/String;)V", "Landroidx/compose/runtime/CompositionTracer;", "compositionTracer", "Landroidx/compose/runtime/CompositionTracer;", "getCompositionTracer$annotations", "rootKey", "I", "nodeKey", "defaultsKey", "invocation", "Ljava/lang/Object;", "getInvocation", "()Ljava/lang/Object;", "getInvocation$annotations", "provider", "getProvider", "getProvider$annotations", "compositionLocalMap", "getCompositionLocalMap", "getCompositionLocalMap$annotations", "providerValues", "getProviderValues", "getProviderValues$annotations", "providerMaps", "getProviderMaps", "getProviderMaps$annotations", "reference", "getReference", "getReference$annotations", "invalidGroupLocation", "Ljava/util/Comparator;", "InvalidationLocationAscending", "Ljava/util/Comparator;", "isAfterFirstChild", "(Landroidx/compose/runtime/SlotWriter;)Z", "(Landroidx/compose/runtime/SlotReader;)Z", "Landroidx/compose/runtime/KeyInfo;", "getJoinedKey", "(Landroidx/compose/runtime/KeyInfo;)Ljava/lang/Object;", "joinedKey", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ComposerKt {
    private static CompositionTracer compositionTracer = null;
    private static final int defaultsKey = -127;
    private static final int invalidGroupLocation = -2;
    private static final int nodeKey = 125;
    private static final int rootKey = 100;
    private static final Object invocation = new OpaqueKey("provider");
    private static final Object provider = new OpaqueKey("provider");
    private static final Object compositionLocalMap = new OpaqueKey("compositionLocalMap");
    private static final Object providerValues = new OpaqueKey("providerValues");
    private static final Object providerMaps = new OpaqueKey("providers");
    private static final Object reference = new OpaqueKey("reference");
    private static final Comparator<Invalidation> InvalidationLocationAscending = new Comparator() { // from class: androidx.compose.runtime.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int InvalidationLocationAscending$lambda$15;
            InvalidationLocationAscending$lambda$15 = ComposerKt.InvalidationLocationAscending$lambda$15((Invalidation) obj, (Invalidation) obj2);
            return InvalidationLocationAscending$lambda$15;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final int InvalidationLocationAscending$lambda$15(Invalidation invalidation, Invalidation invalidation2) {
        return Intrinsics.compare(invalidation.getLocation(), invalidation2.getLocation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean asBool(int i5) {
        return i5 != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int asInt(boolean z5) {
        return z5 ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Object> collectNodesFrom(SlotTable slotTable, Anchor anchor) {
        ArrayList arrayList = new ArrayList();
        SlotReader openReader = slotTable.openReader();
        try {
            collectNodesFrom$lambda$10$collectFromGroup(openReader, arrayList, slotTable.anchorIndex(anchor));
            Unit unit = Unit.INSTANCE;
            return arrayList;
        } finally {
            openReader.close();
        }
    }

    private static final void collectNodesFrom$lambda$10$collectFromGroup(SlotReader slotReader, List<Object> list, int i5) {
        if (slotReader.isNode(i5)) {
            list.add(slotReader.node(i5));
            return;
        }
        int i6 = i5 + 1;
        int groupSize = i5 + slotReader.groupSize(i5);
        while (i6 < groupSize) {
            collectNodesFrom$lambda$10$collectFromGroup(slotReader, list, i6);
            i6 += slotReader.groupSize(i6);
        }
    }

    public static final void composeImmediateRuntimeError(String str) {
        throw new ComposeRuntimeError("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + str + "). Please report to Google or use https://goo.gle/compose-feedback");
    }

    public static final Void composeRuntimeError(String str) {
        throw new ComposeRuntimeError("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + str + "). Please report to Google or use https://goo.gle/compose-feedback");
    }

    public static final void deactivateCurrentGroup(SlotWriter slotWriter, RememberManager rememberManager) {
        int groupIndexToAddress;
        int slotIndex;
        int groupIndexToAddress2;
        int dataIndexToDataAddress;
        int i5;
        int i6;
        int currentGroup = slotWriter.getCurrentGroup();
        int currentGroupEnd = slotWriter.getCurrentGroupEnd();
        while (currentGroup < currentGroupEnd) {
            Object node = slotWriter.node(currentGroup);
            if (node instanceof ComposeNodeLifecycleCallback) {
                rememberManager.deactivating((ComposeNodeLifecycleCallback) node, slotWriter.getSlotsSize() - slotWriter.slotsStartIndex$runtime_release(currentGroup), -1, -1);
            }
            groupIndexToAddress = slotWriter.groupIndexToAddress(currentGroup);
            slotIndex = slotWriter.slotIndex(slotWriter.groups, groupIndexToAddress);
            int[] iArr = slotWriter.groups;
            int i7 = currentGroup + 1;
            groupIndexToAddress2 = slotWriter.groupIndexToAddress(i7);
            int dataIndex = slotWriter.dataIndex(iArr, groupIndexToAddress2);
            for (int i8 = slotIndex; i8 < dataIndex; i8++) {
                int i9 = i8 - slotIndex;
                Object[] objArr = slotWriter.slots;
                dataIndexToDataAddress = slotWriter.dataIndexToDataAddress(i8);
                Object obj = objArr[dataIndexToDataAddress];
                if (obj instanceof RememberObserverHolder) {
                    RememberObserverHolder rememberObserverHolder = (RememberObserverHolder) obj;
                    RememberObserver wrapped = rememberObserverHolder.getWrapped();
                    if (!(wrapped instanceof ReusableRememberObserver)) {
                        removeData(slotWriter, currentGroup, i9, obj);
                        int slotsSize = slotWriter.getSlotsSize() - i9;
                        Anchor after = rememberObserverHolder.getAfter();
                        if (after == null || !after.getValid()) {
                            i5 = -1;
                            i6 = -1;
                        } else {
                            i5 = slotWriter.anchorIndex(after);
                            i6 = slotWriter.getSlotsSize() - slotWriter.slotsEndAllIndex$runtime_release(i5);
                        }
                        rememberManager.forgetting(wrapped, slotsSize, i5, i6);
                    }
                } else if (obj instanceof RecomposeScopeImpl) {
                    removeData(slotWriter, currentGroup, i9, obj);
                    ((RecomposeScopeImpl) obj).release();
                }
            }
            currentGroup = i7;
        }
    }

    private static final int distanceFrom(SlotReader slotReader, int i5, int i6) {
        int i7 = 0;
        while (i5 > 0 && i5 != i6) {
            i5 = slotReader.parent(i5);
            i7++;
        }
        return i7;
    }

    private static final int findInsertLocation(List<Invalidation> list, int i5) {
        int findLocation = findLocation(list, i5);
        return findLocation < 0 ? -(findLocation + 1) : findLocation;
    }

    private static final int findLocation(List<Invalidation> list, int i5) {
        int size = list.size() - 1;
        int i6 = 0;
        while (i6 <= size) {
            int i7 = (i6 + size) >>> 1;
            int compare = Intrinsics.compare(list.get(i7).getLocation(), i5);
            if (compare < 0) {
                i6 = i7 + 1;
            } else {
                if (compare <= 0) {
                    return i7;
                }
                size = i7 - 1;
            }
        }
        return -(i6 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Invalidation firstInRange(List<Invalidation> list, int i5, int i6) {
        int findInsertLocation = findInsertLocation(list, i5);
        if (findInsertLocation >= list.size()) {
            return null;
        }
        Invalidation invalidation = list.get(findInsertLocation);
        if (invalidation.getLocation() < i6) {
            return invalidation;
        }
        return null;
    }

    public static final Object getCompositionLocalMap() {
        return compositionLocalMap;
    }

    public static final Object getInvocation() {
        return invocation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getJoinedKey(KeyInfo keyInfo) {
        return keyInfo.getObjectKey() != null ? new JoinedKey(Integer.valueOf(keyInfo.getKey()), keyInfo.getObjectKey()) : Integer.valueOf(keyInfo.getKey());
    }

    public static final Object getProvider() {
        return provider;
    }

    public static final Object getProviderMaps() {
        return providerMaps;
    }

    public static final Object getReference() {
        return reference;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void insertIfMissing(List<Invalidation> list, int i5, RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        int findLocation = findLocation(list, i5);
        if (findLocation < 0) {
            int i6 = -(findLocation + 1);
            if (!(obj instanceof DerivedState)) {
                obj = null;
            }
            list.add(i6, new Invalidation(recomposeScopeImpl, i5, obj));
            return;
        }
        Invalidation invalidation = list.get(findLocation);
        if (!(obj instanceof DerivedState)) {
            invalidation.setInstances(null);
            return;
        }
        Object instances = invalidation.getInstances();
        if (instances == null) {
            invalidation.setInstances(obj);
        } else if (instances instanceof MutableScatterSet) {
            ((MutableScatterSet) instances).add(obj);
        } else {
            invalidation.setInstances(ScatterSetKt.mutableScatterSetOf(instances, obj));
        }
    }

    public static final boolean isAfterFirstChild(SlotWriter slotWriter) {
        return slotWriter.getCurrentGroup() > slotWriter.getParent() + 1;
    }

    public static final boolean isTraceInProgress() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <K, V> MutableScatterMap<K, Object> multiMap(int i5) {
        return MutableScatterMultiMap.m1217constructorimpl(new MutableScatterMap(i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int nearestCommonRootOf(SlotReader slotReader, int i5, int i6, int i7) {
        if (i5 == i6) {
            return i5;
        }
        if (i5 == i7 || i6 == i7) {
            return i7;
        }
        if (slotReader.parent(i5) == i6) {
            return i6;
        }
        if (slotReader.parent(i6) == i5) {
            return i5;
        }
        if (slotReader.parent(i5) == slotReader.parent(i6)) {
            return slotReader.parent(i5);
        }
        int distanceFrom = distanceFrom(slotReader, i5, i7);
        int distanceFrom2 = distanceFrom(slotReader, i6, i7);
        int i8 = distanceFrom - distanceFrom2;
        for (int i9 = 0; i9 < i8; i9++) {
            i5 = slotReader.parent(i5);
        }
        int i10 = distanceFrom2 - distanceFrom;
        for (int i11 = 0; i11 < i10; i11++) {
            i6 = slotReader.parent(i6);
        }
        while (i5 != i6) {
            i5 = slotReader.parent(i5);
            i6 = slotReader.parent(i6);
        }
        return i5;
    }

    public static final void removeCurrentGroup(SlotWriter slotWriter, RememberManager rememberManager) {
        int groupIndexToAddress;
        int groupIndexToAddress2;
        int dataIndexToDataAddress;
        int i5;
        groupIndexToAddress = slotWriter.groupIndexToAddress(slotWriter.getCurrentGroup());
        int[] iArr = slotWriter.groups;
        groupIndexToAddress2 = slotWriter.groupIndexToAddress(slotWriter.getCurrentGroup() + slotWriter.groupSize(slotWriter.getCurrentGroup()));
        int dataIndex = slotWriter.dataIndex(iArr, groupIndexToAddress2);
        for (int dataIndex2 = slotWriter.dataIndex(slotWriter.groups, groupIndexToAddress); dataIndex2 < dataIndex; dataIndex2++) {
            Object[] objArr = slotWriter.slots;
            dataIndexToDataAddress = slotWriter.dataIndexToDataAddress(dataIndex2);
            Object obj = objArr[dataIndexToDataAddress];
            int i6 = -1;
            if (obj instanceof ComposeNodeLifecycleCallback) {
                rememberManager.releasing((ComposeNodeLifecycleCallback) obj, slotWriter.getSlotsSize() - dataIndex2, -1, -1);
            }
            if (obj instanceof RememberObserverHolder) {
                int slotsSize = slotWriter.getSlotsSize() - dataIndex2;
                RememberObserverHolder rememberObserverHolder = (RememberObserverHolder) obj;
                Anchor after = rememberObserverHolder.getAfter();
                if (after == null || !after.getValid()) {
                    i5 = -1;
                } else {
                    i6 = slotWriter.anchorIndex(after);
                    i5 = slotWriter.getSlotsSize() - slotWriter.slotsEndAllIndex$runtime_release(i6);
                }
                rememberManager.forgetting(rememberObserverHolder.getWrapped(), slotsSize, i6, i5);
            }
            if (obj instanceof RecomposeScopeImpl) {
                ((RecomposeScopeImpl) obj).release();
            }
        }
        slotWriter.removeGroup();
    }

    private static final void removeData(SlotWriter slotWriter, int i5, int i6, Object obj) {
        if (obj == slotWriter.set(i5, i6, Composer.INSTANCE.getEmpty())) {
            return;
        }
        composeImmediateRuntimeError("Slot table is out of sync");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Invalidation removeLocation(List<Invalidation> list, int i5) {
        int findLocation = findLocation(list, i5);
        if (findLocation >= 0) {
            return list.remove(findLocation);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeRange(List<Invalidation> list, int i5, int i6) {
        int findInsertLocation = findInsertLocation(list, i5);
        while (findInsertLocation < list.size() && list.get(findInsertLocation).getLocation() < i6) {
            list.remove(findInsertLocation);
        }
    }

    public static final void runtimeCheck(boolean z5) {
        if (z5) {
            return;
        }
        composeImmediateRuntimeError("Check failed");
    }

    public static final void traceEventEnd() {
    }

    public static final void traceEventStart(int i5, int i6, int i7, String str) {
    }

    public static final boolean isAfterFirstChild(SlotReader slotReader) {
        return slotReader.getCurrent() > slotReader.getParent() + 1;
    }
}
