package okio;

import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0012\u0010\nJ\u0017\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000eH\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010 \u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0017H\u0010¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010#\u001a\u00020\u0017H\u0010¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020\u0003H\u0016¢\u0006\u0004\b$\u0010%J'\u0010-\u001a\u00020*2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u0017H\u0010¢\u0006\u0004\b+\u0010,J/\u00101\u001a\u0002002\u0006\u0010(\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u0017H\u0016¢\u0006\u0004\b1\u00102J/\u00101\u001a\u0002002\u0006\u0010(\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u0017H\u0016¢\u0006\u0004\b1\u00103J\u001f\u00105\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0017H\u0016¢\u0006\u0004\b5\u00106J\u001f\u00107\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0017H\u0016¢\u0006\u0004\b7\u00106J\u000f\u00109\u001a\u00020\u0003H\u0010¢\u0006\u0004\b8\u0010%J\u001a\u0010;\u001a\u0002002\b\u0010.\u001a\u0004\u0018\u00010:H\u0096\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0017H\u0016¢\u0006\u0004\b=\u0010\"J\u000f\u0010>\u001a\u00020\u000eH\u0016¢\u0006\u0004\b>\u0010\u0010R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010?\u001a\u0004\b@\u0010AR\u001a\u0010\u0006\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010B\u001a\u0004\bC\u0010D¨\u0006E"}, d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "segments", BuildConfig.FLAVOR, "directory", "<init>", "([[B[I)V", "toByteString", "()Lokio/ByteString;", "Ljava/lang/Object;", "writeReplace", "()Ljava/lang/Object;", BuildConfig.FLAVOR, "base64", "()Ljava/lang/String;", "hex", "toAsciiLowercase", "algorithm", "digest$okio", "(Ljava/lang/String;)Lokio/ByteString;", "digest", BuildConfig.FLAVOR, "beginIndex", "endIndex", "substring", "(II)Lokio/ByteString;", "pos", BuildConfig.FLAVOR, "internalGet$okio", "(I)B", "internalGet", "getSize$okio", "()I", "getSize", "toByteArray", "()[B", "Lokio/Buffer;", "buffer", "offset", "byteCount", BuildConfig.FLAVOR, "write$okio", "(Lokio/Buffer;II)V", "write", "other", "otherOffset", BuildConfig.FLAVOR, "rangeEquals", "(ILokio/ByteString;II)Z", "(I[BII)Z", "fromIndex", "indexOf", "([BI)I", "lastIndexOf", "internalArray$okio", "internalArray", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "[[B", "getSegments$okio", "()[[B", "[I", "getDirectory$okio", "()[I", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* renamed from: okio.SegmentedByteString, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0683SegmentedByteString extends ByteString {
    private final transient int[] directory;
    private final transient byte[][] segments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0683SegmentedByteString(byte[][] segments, int[] directory) {
        super(ByteString.EMPTY.getData());
        Intrinsics.checkNotNullParameter(segments, "segments");
        Intrinsics.checkNotNullParameter(directory, "directory");
        this.segments = segments;
        this.directory = directory;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        ByteString byteString = toByteString();
        Intrinsics.checkNotNull(byteString, "null cannot be cast to non-null type java.lang.Object");
        return byteString;
    }

    @Override // okio.ByteString
    public String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    public ByteString digest$okio(String algorithm) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = getSegments().length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            int i7 = getDirectory()[length + i5];
            int i8 = getDirectory()[i5];
            messageDigest.update(getSegments()[i5], i7, i8 - i6);
            i5++;
            i6 = i8;
        }
        byte[] digestBytes = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digestBytes, "digestBytes");
        return new ByteString(digestBytes);
    }

    @Override // okio.ByteString
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ByteString) {
            ByteString byteString = (ByteString) other;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: getDirectory$okio, reason: from getter */
    public final int[] getDirectory() {
        return this.directory;
    }

    /* renamed from: getSegments$okio, reason: from getter */
    public final byte[][] getSegments() {
        return this.segments;
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory()[getSegments().length - 1];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int hashCode = getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int length = getSegments().length;
        int i5 = 0;
        int i6 = 1;
        int i7 = 0;
        while (i5 < length) {
            int i8 = getDirectory()[length + i5];
            int i9 = getDirectory()[i5];
            byte[] bArr = getSegments()[i5];
            int i10 = (i9 - i7) + i8;
            while (i8 < i10) {
                i6 = (i6 * 31) + bArr[i8];
                i8++;
            }
            i5++;
            i7 = i9;
        }
        setHashCode$okio(i6);
        return i6;
    }

    @Override // okio.ByteString
    public String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    public int indexOf(byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        return toByteString().indexOf(other, fromIndex);
    }

    @Override // okio.ByteString
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int pos) {
        SegmentedByteString.checkOffsetAndCount(getDirectory()[getSegments().length - 1], pos, 1L);
        int segment = okio.internal.SegmentedByteString.segment(this, pos);
        return getSegments()[segment][(pos - (segment == 0 ? 0 : getDirectory()[segment - 1])) + getDirectory()[getSegments().length + segment]];
    }

    @Override // okio.ByteString
    public int lastIndexOf(byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        return toByteString().lastIndexOf(other, fromIndex);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int offset, ByteString other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (offset < 0 || offset > size() - byteCount) {
            return false;
        }
        int i5 = byteCount + offset;
        int segment = okio.internal.SegmentedByteString.segment(this, offset);
        while (offset < i5) {
            int i6 = segment == 0 ? 0 : getDirectory()[segment - 1];
            int i7 = getDirectory()[segment] - i6;
            int i8 = getDirectory()[getSegments().length + segment];
            int min = Math.min(i5, i7 + i6) - offset;
            if (!other.rangeEquals(otherOffset, getSegments()[segment], i8 + (offset - i6), min)) {
                return false;
            }
            otherOffset += min;
            offset += min;
            segment++;
        }
        return true;
    }

    @Override // okio.ByteString
    public ByteString substring(int beginIndex, int endIndex) {
        int resolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(this, endIndex);
        if (beginIndex < 0) {
            throw new IllegalArgumentException(("beginIndex=" + beginIndex + " < 0").toString());
        }
        if (resolveDefaultParameter > size()) {
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " > length(" + size() + ')').toString());
        }
        int i5 = resolveDefaultParameter - beginIndex;
        if (i5 < 0) {
            throw new IllegalArgumentException(("endIndex=" + resolveDefaultParameter + " < beginIndex=" + beginIndex).toString());
        }
        if (beginIndex == 0 && resolveDefaultParameter == size()) {
            return this;
        }
        if (beginIndex == resolveDefaultParameter) {
            return ByteString.EMPTY;
        }
        int segment = okio.internal.SegmentedByteString.segment(this, beginIndex);
        int segment2 = okio.internal.SegmentedByteString.segment(this, resolveDefaultParameter - 1);
        byte[][] bArr = (byte[][]) ArraysKt.copyOfRange(getSegments(), segment, segment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (segment <= segment2) {
            int i6 = segment;
            int i7 = 0;
            while (true) {
                iArr[i7] = Math.min(getDirectory()[i6] - beginIndex, i5);
                int i8 = i7 + 1;
                iArr[i7 + bArr.length] = getDirectory()[getSegments().length + i6];
                if (i6 == segment2) {
                    break;
                }
                i6++;
                i7 = i8;
            }
        }
        int i9 = segment != 0 ? getDirectory()[segment - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (beginIndex - i9);
        return new C0683SegmentedByteString(bArr, iArr);
    }

    @Override // okio.ByteString
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments().length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < length) {
            int i8 = getDirectory()[length + i5];
            int i9 = getDirectory()[i5];
            int i10 = i9 - i6;
            ArraysKt.copyInto(getSegments()[i5], bArr, i7, i8, i8 + i10);
            i7 += i10;
            i5++;
            i6 = i9;
        }
        return bArr;
    }

    @Override // okio.ByteString
    public String toString() {
        return toByteString().toString();
    }

    @Override // okio.ByteString
    public void write$okio(Buffer buffer, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i5 = offset + byteCount;
        int segment = okio.internal.SegmentedByteString.segment(this, offset);
        while (offset < i5) {
            int i6 = segment == 0 ? 0 : getDirectory()[segment - 1];
            int i7 = getDirectory()[segment] - i6;
            int i8 = getDirectory()[getSegments().length + segment];
            int min = Math.min(i5, i7 + i6) - offset;
            int i9 = i8 + (offset - i6);
            Segment segment2 = new Segment(getSegments()[segment], i9, i9 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                Intrinsics.checkNotNull(segment3);
                Segment segment4 = segment3.prev;
                Intrinsics.checkNotNull(segment4);
                segment4.push(segment2);
            }
            offset += min;
            segment++;
        }
        buffer.setSize$okio(buffer.getSize() + byteCount);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int offset, byte[] other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (offset < 0 || offset > size() - byteCount || otherOffset < 0 || otherOffset > other.length - byteCount) {
            return false;
        }
        int i5 = byteCount + offset;
        int segment = okio.internal.SegmentedByteString.segment(this, offset);
        while (offset < i5) {
            int i6 = segment == 0 ? 0 : getDirectory()[segment - 1];
            int i7 = getDirectory()[segment] - i6;
            int i8 = getDirectory()[getSegments().length + segment];
            int min = Math.min(i5, i7 + i6) - offset;
            if (!SegmentedByteString.arrayRangeEquals(getSegments()[segment], i8 + (offset - i6), other, otherOffset, min)) {
                return false;
            }
            otherOffset += min;
            offset += min;
            segment++;
        }
        return true;
    }
}
