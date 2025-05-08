package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class RopeByteString extends ByteString {
    private static final int[] minLengthByDepth;
    private int hash;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    /* loaded from: classes3.dex */
    private static class Balancer {
        private final Stack<ByteString> prefixesStack;

        private Balancer() {
            this.prefixesStack = new Stack<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ByteString balance(ByteString byteString, ByteString byteString2) {
            doBalance(byteString);
            doBalance(byteString2);
            ByteString pop = this.prefixesStack.pop();
            while (!this.prefixesStack.isEmpty()) {
                pop = new RopeByteString(this.prefixesStack.pop(), pop);
            }
            return pop;
        }

        private void doBalance(ByteString byteString) {
            if (byteString.isBalanced()) {
                insert(byteString);
                return;
            }
            if (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                doBalance(ropeByteString.left);
                doBalance(ropeByteString.right);
            } else {
                String valueOf = String.valueOf(byteString.getClass());
                StringBuilder sb = new StringBuilder(valueOf.length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }

        private int getDepthBinForLength(int i5) {
            int binarySearch = Arrays.binarySearch(RopeByteString.minLengthByDepth, i5);
            return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
        }

        private void insert(ByteString byteString) {
            int depthBinForLength = getDepthBinForLength(byteString.size());
            int i5 = RopeByteString.minLengthByDepth[depthBinForLength + 1];
            if (this.prefixesStack.isEmpty() || this.prefixesStack.peek().size() >= i5) {
                this.prefixesStack.push(byteString);
                return;
            }
            int i6 = RopeByteString.minLengthByDepth[depthBinForLength];
            ByteString pop = this.prefixesStack.pop();
            while (true) {
                if (this.prefixesStack.isEmpty() || this.prefixesStack.peek().size() >= i6) {
                    break;
                } else {
                    pop = new RopeByteString(this.prefixesStack.pop(), pop);
                }
            }
            RopeByteString ropeByteString = new RopeByteString(pop, byteString);
            while (!this.prefixesStack.isEmpty()) {
                if (this.prefixesStack.peek().size() >= RopeByteString.minLengthByDepth[getDepthBinForLength(ropeByteString.size()) + 1]) {
                    break;
                } else {
                    ropeByteString = new RopeByteString(this.prefixesStack.pop(), ropeByteString);
                }
            }
            this.prefixesStack.push(ropeByteString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class PieceIterator implements Iterator<LiteralByteString> {
        private final Stack<RopeByteString> breadCrumbs;
        private LiteralByteString next;

        private LiteralByteString getLeafByLeft(ByteString byteString) {
            while (byteString instanceof RopeByteString) {
                RopeByteString ropeByteString = (RopeByteString) byteString;
                this.breadCrumbs.push(ropeByteString);
                byteString = ropeByteString.left;
            }
            return (LiteralByteString) byteString;
        }

        private LiteralByteString getNextNonEmptyLeaf() {
            while (!this.breadCrumbs.isEmpty()) {
                LiteralByteString leafByLeft = getLeafByLeft(this.breadCrumbs.pop().right);
                if (!leafByLeft.isEmpty()) {
                    return leafByLeft;
                }
            }
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private PieceIterator(ByteString byteString) {
            this.breadCrumbs = new Stack<>();
            this.next = getLeafByLeft(byteString);
        }

        @Override // java.util.Iterator
        public LiteralByteString next() {
            LiteralByteString literalByteString = this.next;
            if (literalByteString != null) {
                this.next = getNextNonEmptyLeaf();
                return literalByteString;
            }
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class RopeByteIterator implements ByteString.ByteIterator {
        private ByteString.ByteIterator bytes;
        int bytesRemaining;
        private final PieceIterator pieces;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.bytesRemaining > 0;
        }

        /* JADX WARN: Type inference failed for: r0v8, types: [kotlin.reflect.jvm.internal.impl.protobuf.ByteString$ByteIterator] */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            if (!this.bytes.hasNext()) {
                this.bytes = this.pieces.next().iterator();
            }
            this.bytesRemaining--;
            return this.bytes.nextByte();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.reflect.jvm.internal.impl.protobuf.ByteString$ByteIterator] */
        private RopeByteIterator() {
            PieceIterator pieceIterator = new PieceIterator(RopeByteString.this);
            this.pieces = pieceIterator;
            this.bytes = pieceIterator.next().iterator();
            this.bytesRemaining = RopeByteString.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i5 = 1;
        int i6 = 1;
        while (i5 > 0) {
            arrayList.add(Integer.valueOf(i5));
            int i7 = i6 + i5;
            i6 = i5;
            i5 = i7;
        }
        arrayList.add(Integer.MAX_VALUE);
        minLengthByDepth = new int[arrayList.size()];
        int i8 = 0;
        while (true) {
            int[] iArr = minLengthByDepth;
            if (i8 >= iArr.length) {
                return;
            }
            iArr[i8] = ((Integer) arrayList.get(i8)).intValue();
            i8++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString concatenate(ByteString byteString, ByteString byteString2) {
        RopeByteString ropeByteString = byteString instanceof RopeByteString ? (RopeByteString) byteString : null;
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() != 0) {
            int size = byteString.size() + byteString2.size();
            if (size < 128) {
                return concatenateBytes(byteString, byteString2);
            }
            if (ropeByteString != null && ropeByteString.right.size() + byteString2.size() < 128) {
                byteString2 = new RopeByteString(ropeByteString.left, concatenateBytes(ropeByteString.right, byteString2));
            } else {
                if (ropeByteString == null || ropeByteString.left.getTreeDepth() <= ropeByteString.right.getTreeDepth() || ropeByteString.getTreeDepth() <= byteString2.getTreeDepth()) {
                    return size >= minLengthByDepth[Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1] ? new RopeByteString(byteString, byteString2) : new Balancer().balance(byteString, byteString2);
                }
                byteString2 = new RopeByteString(ropeByteString.left, new RopeByteString(ropeByteString.right, byteString2));
            }
        }
        return byteString2;
    }

    private static LiteralByteString concatenateBytes(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[size + size2];
        byteString.copyTo(bArr, 0, 0, size);
        byteString2.copyTo(bArr, 0, size, size2);
        return new LiteralByteString(bArr);
    }

    private boolean equalsFragments(ByteString byteString) {
        PieceIterator pieceIterator = new PieceIterator(this);
        LiteralByteString next = pieceIterator.next();
        PieceIterator pieceIterator2 = new PieceIterator(byteString);
        LiteralByteString next2 = pieceIterator2.next();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int size = next.size() - i5;
            int size2 = next2.size() - i6;
            int min = Math.min(size, size2);
            if (!(i5 == 0 ? next.equalsRange(next2, i6, min) : next2.equalsRange(next, i5, min))) {
                return false;
            }
            i7 += min;
            int i8 = this.totalLength;
            if (i7 >= i8) {
                if (i7 == i8) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == size) {
                next = pieceIterator.next();
                i5 = 0;
            } else {
                i5 += min;
            }
            if (min == size2) {
                next2 = pieceIterator2.next();
                i6 = 0;
            } else {
                i6 += min;
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected void copyToInternal(byte[] bArr, int i5, int i6, int i7) {
        int i8 = i5 + i7;
        int i9 = this.leftLength;
        if (i8 <= i9) {
            this.left.copyToInternal(bArr, i5, i6, i7);
        } else {
            if (i5 >= i9) {
                this.right.copyToInternal(bArr, i5 - i9, i6, i7);
                return;
            }
            int i10 = i9 - i5;
            this.left.copyToInternal(bArr, i5, i6, i10);
            this.right.copyToInternal(bArr, 0, i6 + i10, i7 - i10);
        }
    }

    public boolean equals(Object obj) {
        int peekCachedHashCode;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.totalLength != byteString.size()) {
            return false;
        }
        if (this.totalLength == 0) {
            return true;
        }
        if (this.hash == 0 || (peekCachedHashCode = byteString.peekCachedHashCode()) == 0 || this.hash == peekCachedHashCode) {
            return equalsFragments(byteString);
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int getTreeDepth() {
        return this.treeDepth;
    }

    public int hashCode() {
        int i5 = this.hash;
        if (i5 == 0) {
            int i6 = this.totalLength;
            i5 = partialHash(i6, 0, i6);
            if (i5 == 0) {
                i5 = 1;
            }
            this.hash = i5;
        }
        return i5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected boolean isBalanced() {
        return this.totalLength >= minLengthByDepth[this.treeDepth];
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean isValidUtf8() {
        int partialIsValidUtf8 = this.left.partialIsValidUtf8(0, 0, this.leftLength);
        ByteString byteString = this.right;
        return byteString.partialIsValidUtf8(partialIsValidUtf8, 0, byteString.size()) == 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int partialHash(int i5, int i6, int i7) {
        int i8 = i6 + i7;
        int i9 = this.leftLength;
        if (i8 <= i9) {
            return this.left.partialHash(i5, i6, i7);
        }
        if (i6 >= i9) {
            return this.right.partialHash(i5, i6 - i9, i7);
        }
        int i10 = i9 - i6;
        return this.right.partialHash(this.left.partialHash(i5, i6, i10), 0, i7 - i10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int partialIsValidUtf8(int i5, int i6, int i7) {
        int i8 = i6 + i7;
        int i9 = this.leftLength;
        if (i8 <= i9) {
            return this.left.partialIsValidUtf8(i5, i6, i7);
        }
        if (i6 >= i9) {
            return this.right.partialIsValidUtf8(i5, i6 - i9, i7);
        }
        int i10 = i9 - i6;
        return this.right.partialIsValidUtf8(this.left.partialIsValidUtf8(i5, i6, i10), 0, i7 - i10);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int peekCachedHashCode() {
        return this.hash;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.totalLength;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public String toString(String str) {
        return new String(toByteArray(), str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    void writeToInternal(OutputStream outputStream, int i5, int i6) {
        int i7 = i5 + i6;
        int i8 = this.leftLength;
        if (i7 <= i8) {
            this.left.writeToInternal(outputStream, i5, i6);
        } else {
            if (i5 >= i8) {
                this.right.writeToInternal(outputStream, i5 - i8, i6);
                return;
            }
            int i9 = i8 - i5;
            this.left.writeToInternal(outputStream, i5, i9);
            this.right.writeToInternal(outputStream, 0, i6 - i9);
        }
    }

    private RopeByteString(ByteString byteString, ByteString byteString2) {
        this.hash = 0;
        this.left = byteString;
        this.right = byteString2;
        int size = byteString.size();
        this.leftLength = size;
        this.totalLength = size + byteString2.size();
        this.treeDepth = Math.max(byteString.getTreeDepth(), byteString2.getTreeDepth()) + 1;
    }

    @Override // java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new RopeByteIterator();
    }
}
