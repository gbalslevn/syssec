package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001aG\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0006*\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\f\u0010\r\u001aC\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007*\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00002\u000e\u0010\u0010\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001aO\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0006*\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a+\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007*\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a+\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007*\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u000e\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0017\u0010\u0016¨\u0006\u0018"}, d2 = {BuildConfig.FLAVOR, "index", "shift", "indexSegment", "(II)I", "K", "V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "keyIndex", "key", "value", "insertEntryAtIndex", "([Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "nodeIndex", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "newNode", "replaceEntryWithNode", "([Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;)[Ljava/lang/Object;", "replaceNodeWithEntry", "([Ljava/lang/Object;IILjava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "removeEntryAtIndex", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "removeNodeAtIndex", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TrieNodeKt {
    public static final /* synthetic */ Object[] access$insertEntryAtIndex(Object[] objArr, int i5, Object obj, Object obj2) {
        return insertEntryAtIndex(objArr, i5, obj, obj2);
    }

    public static final /* synthetic */ Object[] access$removeEntryAtIndex(Object[] objArr, int i5) {
        return removeEntryAtIndex(objArr, i5);
    }

    public static final /* synthetic */ Object[] access$removeNodeAtIndex(Object[] objArr, int i5) {
        return removeNodeAtIndex(objArr, i5);
    }

    public static final /* synthetic */ Object[] access$replaceEntryWithNode(Object[] objArr, int i5, int i6, TrieNode trieNode) {
        return replaceEntryWithNode(objArr, i5, i6, trieNode);
    }

    public static final /* synthetic */ Object[] access$replaceNodeWithEntry(Object[] objArr, int i5, int i6, Object obj, Object obj2) {
        return replaceNodeWithEntry(objArr, i5, i6, obj, obj2);
    }

    public static final int indexSegment(int i5, int i6) {
        return (i5 >> i6) & 31;
    }

    public static final <K, V> Object[] insertEntryAtIndex(Object[] objArr, int i5, K k5, V v5) {
        Object[] objArr2 = new Object[objArr.length + 2];
        ArraysKt.copyInto$default(objArr, objArr2, 0, 0, i5, 6, (Object) null);
        ArraysKt.copyInto(objArr, objArr2, i5 + 2, i5, objArr.length);
        objArr2[i5] = k5;
        objArr2[i5 + 1] = v5;
        return objArr2;
    }

    public static final Object[] removeEntryAtIndex(Object[] objArr, int i5) {
        Object[] objArr2 = new Object[objArr.length - 2];
        ArraysKt.copyInto$default(objArr, objArr2, 0, 0, i5, 6, (Object) null);
        ArraysKt.copyInto(objArr, objArr2, i5, i5 + 2, objArr.length);
        return objArr2;
    }

    public static final Object[] removeNodeAtIndex(Object[] objArr, int i5) {
        Object[] objArr2 = new Object[objArr.length - 1];
        ArraysKt.copyInto$default(objArr, objArr2, 0, 0, i5, 6, (Object) null);
        ArraysKt.copyInto(objArr, objArr2, i5, i5 + 1, objArr.length);
        return objArr2;
    }

    public static final Object[] replaceEntryWithNode(Object[] objArr, int i5, int i6, TrieNode<?, ?> trieNode) {
        Object[] objArr2 = new Object[objArr.length - 1];
        ArraysKt.copyInto$default(objArr, objArr2, 0, 0, i5, 6, (Object) null);
        ArraysKt.copyInto(objArr, objArr2, i5, i5 + 2, i6);
        objArr2[i6 - 2] = trieNode;
        ArraysKt.copyInto(objArr, objArr2, i6 - 1, i6, objArr.length);
        return objArr2;
    }

    public static final <K, V> Object[] replaceNodeWithEntry(Object[] objArr, int i5, int i6, K k5, V v5) {
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length + 1);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        ArraysKt.copyInto(copyOf, copyOf, i5 + 2, i5 + 1, objArr.length);
        ArraysKt.copyInto(copyOf, copyOf, i6 + 2, i6, i5);
        copyOf[i6] = k5;
        copyOf[i6 + 1] = v5;
        return copyOf;
    }
}
