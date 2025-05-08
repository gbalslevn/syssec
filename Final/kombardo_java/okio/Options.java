package okio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0015B\u001f\b\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000eH\u0096\u0002R\u001e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0006X\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lokio/Options;", "Lkotlin/collections/AbstractList;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "byteStrings", BuildConfig.FLAVOR, "trie", BuildConfig.FLAVOR, "([Lokio/ByteString;[I)V", "getByteStrings$okio", "()[Lokio/ByteString;", "[Lokio/ByteString;", "size", BuildConfig.FLAVOR, "getSize", "()I", "getTrie$okio", "()[I", "get", "index", "Companion", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ByteString[] byteStrings;
    private final int[] trie;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002J!\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0016\"\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0017R\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lokio/Options$Companion;", BuildConfig.FLAVOR, "()V", "intCount", BuildConfig.FLAVOR, "Lokio/Buffer;", "getIntCount", "(Lokio/Buffer;)J", "buildTrieRecursive", BuildConfig.FLAVOR, "nodeOffset", "node", "byteStringOffset", BuildConfig.FLAVOR, "byteStrings", BuildConfig.FLAVOR, "Lokio/ByteString;", "fromIndex", "toIndex", "indexes", "of", "Lokio/Options;", BuildConfig.FLAVOR, "([Lokio/ByteString;)Lokio/Options;", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void buildTrieRecursive(long nodeOffset, Buffer node, int byteStringOffset, List<? extends ByteString> byteStrings, int fromIndex, int toIndex, List<Integer> indexes) {
            int i5;
            int i6;
            int i7;
            int i8;
            Buffer buffer;
            int i9 = byteStringOffset;
            if (fromIndex >= toIndex) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            for (int i10 = fromIndex; i10 < toIndex; i10++) {
                if (byteStrings.get(i10).size() < i9) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
            }
            ByteString byteString = byteStrings.get(fromIndex);
            ByteString byteString2 = byteStrings.get(toIndex - 1);
            int i11 = -1;
            if (i9 == byteString.size()) {
                int intValue = indexes.get(fromIndex).intValue();
                int i12 = fromIndex + 1;
                ByteString byteString3 = byteStrings.get(i12);
                i5 = i12;
                i6 = intValue;
                byteString = byteString3;
            } else {
                i5 = fromIndex;
                i6 = -1;
            }
            if (byteString.getByte(i9) == byteString2.getByte(i9)) {
                int min = Math.min(byteString.size(), byteString2.size());
                int i13 = 0;
                for (int i14 = i9; i14 < min && byteString.getByte(i14) == byteString2.getByte(i14); i14++) {
                    i13++;
                }
                long intCount = nodeOffset + getIntCount(node) + 2 + i13 + 1;
                node.writeInt(-i13);
                node.writeInt(i6);
                int i15 = i13 + i9;
                while (i9 < i15) {
                    node.writeInt(byteString.getByte(i9) & 255);
                    i9++;
                }
                if (i5 + 1 == toIndex) {
                    if (i15 != byteStrings.get(i5).size()) {
                        throw new IllegalStateException("Check failed.");
                    }
                    node.writeInt(indexes.get(i5).intValue());
                    return;
                } else {
                    Buffer buffer2 = new Buffer();
                    node.writeInt(((int) (getIntCount(buffer2) + intCount)) * (-1));
                    buildTrieRecursive(intCount, buffer2, i15, byteStrings, i5, toIndex, indexes);
                    node.writeAll(buffer2);
                    return;
                }
            }
            int i16 = 1;
            for (int i17 = i5 + 1; i17 < toIndex; i17++) {
                if (byteStrings.get(i17 - 1).getByte(i9) != byteStrings.get(i17).getByte(i9)) {
                    i16++;
                }
            }
            long intCount2 = nodeOffset + getIntCount(node) + 2 + (i16 * 2);
            node.writeInt(i16);
            node.writeInt(i6);
            for (int i18 = i5; i18 < toIndex; i18++) {
                byte b5 = byteStrings.get(i18).getByte(i9);
                if (i18 == i5 || b5 != byteStrings.get(i18 - 1).getByte(i9)) {
                    node.writeInt(b5 & 255);
                }
            }
            Buffer buffer3 = new Buffer();
            while (i5 < toIndex) {
                byte b6 = byteStrings.get(i5).getByte(i9);
                int i19 = i5 + 1;
                int i20 = i19;
                while (true) {
                    if (i20 >= toIndex) {
                        i7 = toIndex;
                        break;
                    } else {
                        if (b6 != byteStrings.get(i20).getByte(i9)) {
                            i7 = i20;
                            break;
                        }
                        i20++;
                    }
                }
                if (i19 == i7 && i9 + 1 == byteStrings.get(i5).size()) {
                    node.writeInt(indexes.get(i5).intValue());
                    i8 = i7;
                    buffer = buffer3;
                } else {
                    node.writeInt(((int) (intCount2 + getIntCount(buffer3))) * i11);
                    i8 = i7;
                    buffer = buffer3;
                    buildTrieRecursive(intCount2, buffer3, i9 + 1, byteStrings, i5, i7, indexes);
                }
                buffer3 = buffer;
                i5 = i8;
                i11 = -1;
            }
            node.writeAll(buffer3);
        }

        static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j5, Buffer buffer, int i5, List list, int i6, int i7, List list2, int i8, Object obj) {
            companion.buildTrieRecursive((i8 & 1) != 0 ? 0L : j5, buffer, (i8 & 4) != 0 ? 0 : i5, list, (i8 & 16) != 0 ? 0 : i6, (i8 & 32) != 0 ? list.size() : i7, list2);
        }

        private final long getIntCount(Buffer buffer) {
            return buffer.getSize() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x00d7, code lost:
        
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Options of(ByteString... byteStrings) {
            Intrinsics.checkNotNullParameter(byteStrings, "byteStrings");
            DefaultConstructorMarker defaultConstructorMarker = null;
            int i5 = 0;
            if (byteStrings.length == 0) {
                return new Options(new ByteString[0], new int[]{0, -1}, defaultConstructorMarker);
            }
            List mutableList = ArraysKt.toMutableList(byteStrings);
            CollectionsKt.sort(mutableList);
            ArrayList arrayList = new ArrayList(byteStrings.length);
            for (ByteString byteString : byteStrings) {
                arrayList.add(-1);
            }
            Integer[] numArr = (Integer[]) arrayList.toArray(new Integer[0]);
            List mutableListOf = CollectionsKt.mutableListOf(Arrays.copyOf(numArr, numArr.length));
            int length = byteStrings.length;
            int i6 = 0;
            int i7 = 0;
            while (i6 < length) {
                mutableListOf.set(CollectionsKt.binarySearch$default(mutableList, byteStrings[i6], 0, 0, 6, (Object) null), Integer.valueOf(i7));
                i6++;
                i7++;
            }
            if (((ByteString) mutableList.get(0)).size() <= 0) {
                throw new IllegalArgumentException("the empty byte string is not a supported option");
            }
            int i8 = 0;
            while (i8 < mutableList.size()) {
                ByteString byteString2 = (ByteString) mutableList.get(i8);
                int i9 = i8 + 1;
                int i10 = i9;
                while (i10 < mutableList.size()) {
                    ByteString byteString3 = (ByteString) mutableList.get(i10);
                    if (byteString3.startsWith(byteString2)) {
                        if (byteString3.size() == byteString2.size()) {
                            throw new IllegalArgumentException(("duplicate option: " + byteString3).toString());
                        }
                        if (((Number) mutableListOf.get(i10)).intValue() > ((Number) mutableListOf.get(i8)).intValue()) {
                            mutableList.remove(i10);
                            mutableListOf.remove(i10);
                        } else {
                            i10++;
                        }
                    }
                }
                i8 = i9;
            }
            Buffer buffer = new Buffer();
            buildTrieRecursive$default(this, 0L, buffer, 0, mutableList, 0, 0, mutableListOf, 53, null);
            int[] iArr = new int[(int) getIntCount(buffer)];
            while (!buffer.exhausted()) {
                iArr[i5] = buffer.readInt();
                i5++;
            }
            Object[] copyOf = Arrays.copyOf(byteStrings, byteStrings.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
            return new Options((ByteString[]) copyOf, iArr, defaultConstructorMarker);
        }

        private Companion() {
        }
    }

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }

    public static final Options of(ByteString... byteStringArr) {
        return INSTANCE.of(byteStringArr);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    /* renamed from: getByteStrings$okio, reason: from getter */
    public final ByteString[] getByteStrings() {
        return this.byteStrings;
    }

    @Override // kotlin.collections.AbstractCollection
    /* renamed from: getSize */
    public int get_size() {
        return this.byteStrings.length;
    }

    /* renamed from: getTrie$okio, reason: from getter */
    public final int[] getTrie() {
        return this.trie;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains((Options) byteString);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ByteString get(int index) {
        return this.byteStrings[index];
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf((Options) byteString);
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf((Options) byteString);
    }
}
