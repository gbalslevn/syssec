package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\b \u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u00028\u00020\u0004B;\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u001e\u0010\t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u0015R2\u0010\t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b0\u00078\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0083\u000e¢\u0006\f\n\u0004\b\u0017\u0010#\u0012\u0004\b$\u0010\u0012¨\u0006%"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBaseIterator;", "K", "V", "T", BuildConfig.FLAVOR, "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "node", BuildConfig.FLAVOR, "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "path", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;)V", BuildConfig.FLAVOR, "pathIndex", "moveToNextNodeWithData", "(I)I", BuildConfig.FLAVOR, "ensureNextEntryIsReady", "()V", "checkHasNext", "currentKey", "()Ljava/lang/Object;", BuildConfig.FLAVOR, "hasNext", "()Z", "next", "[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "getPath", "()[Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNodeBaseIterator;", "pathLastIndex", "I", "getPathLastIndex", "()I", "setPathLastIndex", "(I)V", "Z", "getHasNext$annotations", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PersistentHashMapBaseIterator<K, V, T> implements Iterator<T>, KMappedMarker {
    private boolean hasNext = true;
    private final TrieNodeBaseIterator<K, V, T>[] path;
    private int pathLastIndex;

    public PersistentHashMapBaseIterator(TrieNode<K, V> trieNode, TrieNodeBaseIterator<K, V, T>[] trieNodeBaseIteratorArr) {
        this.path = trieNodeBaseIteratorArr;
        trieNodeBaseIteratorArr[0].reset(trieNode.getBuffer(), trieNode.entryCount$runtime_release() * 2);
        this.pathLastIndex = 0;
        ensureNextEntryIsReady();
    }

    private final void checkHasNext() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }

    private final void ensureNextEntryIsReady() {
        if (this.path[this.pathLastIndex].hasNextKey()) {
            return;
        }
        for (int i5 = this.pathLastIndex; -1 < i5; i5--) {
            int moveToNextNodeWithData = moveToNextNodeWithData(i5);
            if (moveToNextNodeWithData == -1 && this.path[i5].hasNextNode()) {
                this.path[i5].moveToNextNode();
                moveToNextNodeWithData = moveToNextNodeWithData(i5);
            }
            if (moveToNextNodeWithData != -1) {
                this.pathLastIndex = moveToNextNodeWithData;
                return;
            }
            if (i5 > 0) {
                this.path[i5 - 1].moveToNextNode();
            }
            this.path[i5].reset(TrieNode.INSTANCE.getEMPTY$runtime_release().getBuffer(), 0);
        }
        this.hasNext = false;
    }

    private final int moveToNextNodeWithData(int pathIndex) {
        if (this.path[pathIndex].hasNextKey()) {
            return pathIndex;
        }
        if (!this.path[pathIndex].hasNextNode()) {
            return -1;
        }
        TrieNode<? extends K, ? extends V> currentNode = this.path[pathIndex].currentNode();
        if (pathIndex == 6) {
            this.path[pathIndex + 1].reset(currentNode.getBuffer(), currentNode.getBuffer().length);
        } else {
            this.path[pathIndex + 1].reset(currentNode.getBuffer(), currentNode.entryCount$runtime_release() * 2);
        }
        return moveToNextNodeWithData(pathIndex + 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final K currentKey() {
        checkHasNext();
        return this.path[this.pathLastIndex].currentKey();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TrieNodeBaseIterator<K, V, T>[] getPath() {
        return this.path;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // java.util.Iterator
    public T next() {
        checkHasNext();
        T next = this.path[this.pathLastIndex].next();
        ensureNextEntryIsReady();
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setPathLastIndex(int i5) {
        this.pathLastIndex = i5;
    }
}
