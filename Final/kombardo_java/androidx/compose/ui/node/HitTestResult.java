package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010*\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0010\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002JKB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0015\u0010\n\u001a\u00020\u0007H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0004J\u001d\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016¢\u0006\u0004\b\u0018\u0010\u0019J3\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ3\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u0018\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\"\u001a\u00020\f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0018\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$H\u0096\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\fH\u0016¢\u0006\u0004\b*\u0010\u000eJ\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020+H\u0096\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0004\b.\u0010)J\u0015\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020/H\u0016¢\u0006\u0004\b0\u00101J\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020/2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b0\u00102J%\u00105\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020$H\u0016¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\u0005¢\u0006\u0004\b7\u0010\u0004R\u001e\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u000109088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R$\u0010B\u001a\u00020$2\u0006\u0010A\u001a\u00020$8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bB\u0010@\u001a\u0004\bC\u0010DR\"\u0010E\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010\u000e\"\u0004\bH\u0010I\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006L"}, d2 = {"Landroidx/compose/ui/node/HitTestResult;", BuildConfig.FLAVOR, "Landroidx/compose/ui/Modifier$Node;", "<init>", "()V", BuildConfig.FLAVOR, "resizeToHitDepth", "Landroidx/compose/ui/node/DistanceAndInLayer;", "findBestHitDistance-ptXAw2c", "()J", "findBestHitDistance", "ensureContainerSize", BuildConfig.FLAVOR, "hasHit", "()Z", "acceptHits", BuildConfig.FLAVOR, "distanceFromEdge", "isInLayer", "isHitInMinimumTouchTargetBetter", "(FZ)Z", "node", "Lkotlin/Function0;", "childHitTest", "hit", "(Landroidx/compose/ui/Modifier$Node;ZLkotlin/jvm/functions/Function0;)V", "hitInMinimumTouchTarget", "(Landroidx/compose/ui/Modifier$Node;FZLkotlin/jvm/functions/Function0;)V", "speculativeHit", "element", "contains", "(Landroidx/compose/ui/Modifier$Node;)Z", BuildConfig.FLAVOR, "elements", "containsAll", "(Ljava/util/Collection;)Z", BuildConfig.FLAVOR, "index", "get", "(I)Landroidx/compose/ui/Modifier$Node;", "indexOf", "(Landroidx/compose/ui/Modifier$Node;)I", "isEmpty", BuildConfig.FLAVOR, "iterator", "()Ljava/util/Iterator;", "lastIndexOf", BuildConfig.FLAVOR, "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "clear", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "values", "[Ljava/lang/Object;", BuildConfig.FLAVOR, "distanceFromEdgeAndInLayer", "[J", "hitDepth", "I", "<set-?>", "size", "getSize", "()I", "shouldSharePointerInputWithSibling", "Z", "getShouldSharePointerInputWithSibling", "setShouldSharePointerInputWithSibling", "(Z)V", "HitTestResultIterator", "SubList", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HitTestResult implements List<Modifier.Node>, KMappedMarker {
    private int size;
    private Object[] values = new Object[16];
    private long[] distanceFromEdgeAndInLayer = new long[16];
    private int hitDepth = -1;
    private boolean shouldSharePointerInputWithSibling = true;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010*\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0010R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0017\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0018\u0010\u0010¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/node/HitTestResult$HitTestResultIterator;", BuildConfig.FLAVOR, "Landroidx/compose/ui/Modifier$Node;", BuildConfig.FLAVOR, "index", "minIndex", "maxIndex", "<init>", "(Landroidx/compose/ui/node/HitTestResult;III)V", BuildConfig.FLAVOR, "hasNext", "()Z", "hasPrevious", "next", "()Landroidx/compose/ui/Modifier$Node;", "nextIndex", "()I", "previous", "previousIndex", "I", "getIndex", "setIndex", "(I)V", "getMinIndex", "getMaxIndex", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    private final class HitTestResultIterator implements ListIterator<Modifier.Node>, KMappedMarker {
        private int index;
        private final int maxIndex;
        private final int minIndex;

        public HitTestResultIterator(int i5, int i6, int i7) {
            this.index = i5;
            this.minIndex = i6;
            this.maxIndex = i7;
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Modifier.Node node) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.index < this.maxIndex;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.index > this.minIndex;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.index - this.minIndex;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return (this.index - this.minIndex) - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Modifier.Node node) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Modifier.Node next() {
            Object[] objArr = HitTestResult.this.values;
            int i5 = this.index;
            this.index = i5 + 1;
            Object obj = objArr[i5];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (Modifier.Node) obj;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.ListIterator
        public Modifier.Node previous() {
            Object[] objArr = HitTestResult.this.values;
            int i5 = this.index - 1;
            this.index = i5;
            Object obj = objArr[i5];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (Modifier.Node) obj;
        }

        public /* synthetic */ HitTestResultIterator(HitTestResult hitTestResult, int i5, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? 0 : i5, (i8 & 2) != 0 ? 0 : i6, (i8 & 4) != 0 ? hitTestResult.size() : i7);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010*\n\u0002\b\u000e\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0014J\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u001eJ%\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003H\u0016¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b&\u0010%R\u0014\u0010(\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010%¨\u0006)"}, d2 = {"Landroidx/compose/ui/node/HitTestResult$SubList;", BuildConfig.FLAVOR, "Landroidx/compose/ui/Modifier$Node;", BuildConfig.FLAVOR, "minIndex", "maxIndex", "<init>", "(Landroidx/compose/ui/node/HitTestResult;II)V", "element", BuildConfig.FLAVOR, "contains", "(Landroidx/compose/ui/Modifier$Node;)Z", BuildConfig.FLAVOR, "elements", "containsAll", "(Ljava/util/Collection;)Z", "index", "get", "(I)Landroidx/compose/ui/Modifier$Node;", "indexOf", "(Landroidx/compose/ui/Modifier$Node;)I", "isEmpty", "()Z", BuildConfig.FLAVOR, "iterator", "()Ljava/util/Iterator;", "lastIndexOf", BuildConfig.FLAVOR, "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "I", "getMinIndex", "()I", "getMaxIndex", "getSize", "size", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    private final class SubList implements List<Modifier.Node>, KMappedMarker {
        private final int maxIndex;
        private final int minIndex;

        public SubList(int i5, int i6) {
            this.minIndex = i5;
            this.maxIndex = i6;
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ void add(int i5, Modifier.Node node) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public boolean addAll(int i5, Collection<? extends Modifier.Node> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Modifier.Node) {
                return contains((Modifier.Node) obj);
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<? extends Object> elements) {
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        public int getSize() {
            return this.maxIndex - this.minIndex;
        }

        @Override // java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Modifier.Node) {
                return indexOf((Modifier.Node) obj);
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return size() == 0;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<Modifier.Node> iterator() {
            HitTestResult hitTestResult = HitTestResult.this;
            int i5 = this.minIndex;
            return new HitTestResultIterator(i5, i5, this.maxIndex);
        }

        @Override // java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Modifier.Node) {
                return lastIndexOf((Modifier.Node) obj);
            }
            return -1;
        }

        @Override // java.util.List
        public ListIterator<Modifier.Node> listIterator() {
            HitTestResult hitTestResult = HitTestResult.this;
            int i5 = this.minIndex;
            return new HitTestResultIterator(i5, i5, this.maxIndex);
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Modifier.Node remove(int i5) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator<Modifier.Node> unaryOperator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Modifier.Node set(int i5, Modifier.Node node) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        public void sort(Comparator<? super Modifier.Node> comparator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public List<Modifier.Node> subList(int fromIndex, int toIndex) {
            HitTestResult hitTestResult = HitTestResult.this;
            int i5 = this.minIndex;
            return new SubList(fromIndex + i5, i5 + toIndex);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        @Override // java.util.List, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends Modifier.Node> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public boolean contains(Modifier.Node element) {
            return indexOf((Object) element) != -1;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.List
        public Modifier.Node get(int index) {
            Object obj = HitTestResult.this.values[index + this.minIndex];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (Modifier.Node) obj;
        }

        public int indexOf(Modifier.Node element) {
            int i5 = this.minIndex;
            int i6 = this.maxIndex;
            if (i5 > i6) {
                return -1;
            }
            while (!Intrinsics.areEqual(HitTestResult.this.values[i5], element)) {
                if (i5 == i6) {
                    return -1;
                }
                i5++;
            }
            return i5 - this.minIndex;
        }

        public int lastIndexOf(Modifier.Node element) {
            int i5 = this.maxIndex;
            int i6 = this.minIndex;
            if (i6 > i5) {
                return -1;
            }
            while (!Intrinsics.areEqual(HitTestResult.this.values[i5], element)) {
                if (i5 == i6) {
                    return -1;
                }
                i5--;
            }
            return i5 - this.minIndex;
        }

        @Override // java.util.List
        public ListIterator<Modifier.Node> listIterator(int index) {
            HitTestResult hitTestResult = HitTestResult.this;
            int i5 = this.minIndex;
            return new HitTestResultIterator(index + i5, i5, this.maxIndex);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) CollectionToArray.toArray(this, tArr);
        }
    }

    private final void ensureContainerSize() {
        int i5 = this.hitDepth;
        Object[] objArr = this.values;
        if (i5 >= objArr.length) {
            int length = objArr.length + 16;
            Object[] copyOf = Arrays.copyOf(objArr, length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.values = copyOf;
            long[] copyOf2 = Arrays.copyOf(this.distanceFromEdgeAndInLayer, length);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
            this.distanceFromEdgeAndInLayer = copyOf2;
        }
    }

    /* renamed from: findBestHitDistance-ptXAw2c, reason: not valid java name */
    private final long m1995findBestHitDistanceptXAw2c() {
        long DistanceAndInLayer;
        DistanceAndInLayer = HitTestResultKt.DistanceAndInLayer(Float.POSITIVE_INFINITY, false);
        int i5 = this.hitDepth + 1;
        int lastIndex = CollectionsKt.getLastIndex(this);
        if (i5 <= lastIndex) {
            while (true) {
                long m1992constructorimpl = DistanceAndInLayer.m1992constructorimpl(this.distanceFromEdgeAndInLayer[i5]);
                if (DistanceAndInLayer.m1991compareToS_HNhKs(m1992constructorimpl, DistanceAndInLayer) < 0) {
                    DistanceAndInLayer = m1992constructorimpl;
                }
                if (DistanceAndInLayer.m1993getDistanceimpl(DistanceAndInLayer) < 0.0f && DistanceAndInLayer.m1994isInLayerimpl(DistanceAndInLayer)) {
                    return DistanceAndInLayer;
                }
                if (i5 == lastIndex) {
                    break;
                }
                i5++;
            }
        }
        return DistanceAndInLayer;
    }

    private final void resizeToHitDepth() {
        int i5 = this.hitDepth + 1;
        int lastIndex = CollectionsKt.getLastIndex(this);
        if (i5 <= lastIndex) {
            while (true) {
                this.values[i5] = null;
                if (i5 == lastIndex) {
                    break;
                } else {
                    i5++;
                }
            }
        }
        this.size = this.hitDepth + 1;
    }

    public final void acceptHits() {
        this.hitDepth = size() - 1;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int i5, Modifier.Node node) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i5, Collection<? extends Modifier.Node> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.hitDepth = -1;
        resizeToHitDepth();
        this.shouldSharePointerInputWithSibling = true;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Modifier.Node) {
            return contains((Modifier.Node) obj);
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean getShouldSharePointerInputWithSibling() {
        return this.shouldSharePointerInputWithSibling;
    }

    public int getSize() {
        return this.size;
    }

    public final boolean hasHit() {
        long m1995findBestHitDistanceptXAw2c = m1995findBestHitDistanceptXAw2c();
        return DistanceAndInLayer.m1993getDistanceimpl(m1995findBestHitDistanceptXAw2c) < 0.0f && DistanceAndInLayer.m1994isInLayerimpl(m1995findBestHitDistanceptXAw2c);
    }

    public final void hit(Modifier.Node node, boolean isInLayer, Function0<Unit> childHitTest) {
        hitInMinimumTouchTarget(node, -1.0f, isInLayer, childHitTest);
        NodeCoordinator coordinator = node.getCoordinator();
        if (coordinator == null || coordinator.shouldSharePointerInputWithSiblings()) {
            return;
        }
        this.shouldSharePointerInputWithSibling = false;
    }

    public final void hitInMinimumTouchTarget(Modifier.Node node, float distanceFromEdge, boolean isInLayer, Function0<Unit> childHitTest) {
        long DistanceAndInLayer;
        int i5 = this.hitDepth;
        this.hitDepth = i5 + 1;
        ensureContainerSize();
        Object[] objArr = this.values;
        int i6 = this.hitDepth;
        objArr[i6] = node;
        long[] jArr = this.distanceFromEdgeAndInLayer;
        DistanceAndInLayer = HitTestResultKt.DistanceAndInLayer(distanceFromEdge, isInLayer);
        jArr[i6] = DistanceAndInLayer;
        resizeToHitDepth();
        childHitTest.invoke();
        this.hitDepth = i5;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Modifier.Node) {
            return indexOf((Modifier.Node) obj);
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    public final boolean isHitInMinimumTouchTargetBetter(float distanceFromEdge, boolean isInLayer) {
        long DistanceAndInLayer;
        if (this.hitDepth == CollectionsKt.getLastIndex(this)) {
            return true;
        }
        DistanceAndInLayer = HitTestResultKt.DistanceAndInLayer(distanceFromEdge, isInLayer);
        return DistanceAndInLayer.m1991compareToS_HNhKs(m1995findBestHitDistanceptXAw2c(), DistanceAndInLayer) > 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<Modifier.Node> iterator() {
        return new HitTestResultIterator(this, 0, 0, 0, 7, null);
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Modifier.Node) {
            return lastIndexOf((Modifier.Node) obj);
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<Modifier.Node> listIterator() {
        return new HitTestResultIterator(this, 0, 0, 0, 7, null);
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Modifier.Node remove(int i5) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<Modifier.Node> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Modifier.Node set(int i5, Modifier.Node node) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    public void sort(Comparator<? super Modifier.Node> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void speculativeHit(Modifier.Node node, float distanceFromEdge, boolean isInLayer, Function0<Unit> childHitTest) {
        if (this.hitDepth == CollectionsKt.getLastIndex(this)) {
            hitInMinimumTouchTarget(node, distanceFromEdge, isInLayer, childHitTest);
            if (this.hitDepth + 1 == CollectionsKt.getLastIndex(this)) {
                resizeToHitDepth();
                return;
            }
            return;
        }
        long m1995findBestHitDistanceptXAw2c = m1995findBestHitDistanceptXAw2c();
        int i5 = this.hitDepth;
        this.hitDepth = CollectionsKt.getLastIndex(this);
        hitInMinimumTouchTarget(node, distanceFromEdge, isInLayer, childHitTest);
        if (this.hitDepth + 1 < CollectionsKt.getLastIndex(this) && DistanceAndInLayer.m1991compareToS_HNhKs(m1995findBestHitDistanceptXAw2c, m1995findBestHitDistanceptXAw2c()) > 0) {
            int i6 = this.hitDepth + 1;
            int i7 = i5 + 1;
            Object[] objArr = this.values;
            ArraysKt.copyInto(objArr, objArr, i7, i6, size());
            long[] jArr = this.distanceFromEdgeAndInLayer;
            ArraysKt.copyInto(jArr, jArr, i7, i6, size());
            this.hitDepth = ((size() + i5) - this.hitDepth) - 1;
        }
        resizeToHitDepth();
        this.hitDepth = i5;
    }

    @Override // java.util.List
    public List<Modifier.Node> subList(int fromIndex, int toIndex) {
        return new SubList(fromIndex, toIndex);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Modifier.Node> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(Modifier.Node element) {
        return indexOf((Object) element) != -1;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.List
    public Modifier.Node get(int index) {
        Object obj = this.values[index];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
        return (Modifier.Node) obj;
    }

    public int indexOf(Modifier.Node element) {
        int lastIndex = CollectionsKt.getLastIndex(this);
        if (lastIndex < 0) {
            return -1;
        }
        int i5 = 0;
        while (!Intrinsics.areEqual(this.values[i5], element)) {
            if (i5 == lastIndex) {
                return -1;
            }
            i5++;
        }
        return i5;
    }

    public int lastIndexOf(Modifier.Node element) {
        for (int lastIndex = CollectionsKt.getLastIndex(this); -1 < lastIndex; lastIndex--) {
            if (Intrinsics.areEqual(this.values[lastIndex], element)) {
                return lastIndex;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<Modifier.Node> listIterator(int index) {
        return new HitTestResultIterator(this, index, 0, 0, 6, null);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.toArray(this, tArr);
    }
}
