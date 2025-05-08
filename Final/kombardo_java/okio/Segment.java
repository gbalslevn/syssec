package okio;

import com.adjust.sdk.Constants;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\f\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B1\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u0002\u0010\fJ\r\u0010\r\u001a\u00020\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0003J\u001d\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0016\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u001cR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u001dR\u0016\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010\u001f¨\u0006\""}, d2 = {"Lokio/Segment;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "data", BuildConfig.FLAVOR, "pos", "limit", BuildConfig.FLAVOR, "shared", "owner", "([BIIZZ)V", "sharedCopy", "()Lokio/Segment;", "pop", "segment", Constants.PUSH, "(Lokio/Segment;)Lokio/Segment;", "byteCount", "split", "(I)Lokio/Segment;", BuildConfig.FLAVOR, "compact", "sink", "writeTo", "(Lokio/Segment;I)V", "[B", "I", "Z", "next", "Lokio/Segment;", "prev", "Companion", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Segment {
    public final byte[] data;
    public int limit;
    public Segment next;
    public boolean owner;
    public int pos;
    public Segment prev;
    public boolean shared;

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public final void compact() {
        int i5;
        Segment segment = this.prev;
        if (segment == this) {
            throw new IllegalStateException("cannot compact");
        }
        Intrinsics.checkNotNull(segment);
        if (segment.owner) {
            int i6 = this.limit - this.pos;
            Segment segment2 = this.prev;
            Intrinsics.checkNotNull(segment2);
            int i7 = 8192 - segment2.limit;
            Segment segment3 = this.prev;
            Intrinsics.checkNotNull(segment3);
            if (segment3.shared) {
                i5 = 0;
            } else {
                Segment segment4 = this.prev;
                Intrinsics.checkNotNull(segment4);
                i5 = segment4.pos;
            }
            if (i6 > i7 + i5) {
                return;
            }
            Segment segment5 = this.prev;
            Intrinsics.checkNotNull(segment5);
            writeTo(segment5, i6);
            pop();
            SegmentPool.recycle(this);
        }
    }

    public final Segment pop() {
        Segment segment = this.next;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.prev;
        Intrinsics.checkNotNull(segment2);
        segment2.next = this.next;
        Segment segment3 = this.next;
        Intrinsics.checkNotNull(segment3);
        segment3.prev = this.prev;
        this.next = null;
        this.prev = null;
        return segment;
    }

    public final Segment push(Segment segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        Segment segment2 = this.next;
        Intrinsics.checkNotNull(segment2);
        segment2.prev = segment;
        this.next = segment;
        return segment;
    }

    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    public final Segment split(int byteCount) {
        Segment take;
        if (byteCount <= 0 || byteCount > this.limit - this.pos) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (byteCount >= 1024) {
            take = sharedCopy();
        } else {
            take = SegmentPool.take();
            byte[] bArr = this.data;
            byte[] bArr2 = take.data;
            int i5 = this.pos;
            ArraysKt.copyInto$default(bArr, bArr2, 0, i5, i5 + byteCount, 2, (Object) null);
        }
        take.limit = take.pos + byteCount;
        this.pos += byteCount;
        Segment segment = this.prev;
        Intrinsics.checkNotNull(segment);
        segment.push(take);
        return take;
    }

    public final void writeTo(Segment sink, int byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!sink.owner) {
            throw new IllegalStateException("only owner can write");
        }
        int i5 = sink.limit;
        if (i5 + byteCount > 8192) {
            if (sink.shared) {
                throw new IllegalArgumentException();
            }
            int i6 = sink.pos;
            if ((i5 + byteCount) - i6 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.data;
            ArraysKt.copyInto$default(bArr, bArr, 0, i6, i5, 2, (Object) null);
            sink.limit -= sink.pos;
            sink.pos = 0;
        }
        byte[] bArr2 = this.data;
        byte[] bArr3 = sink.data;
        int i7 = sink.limit;
        int i8 = this.pos;
        ArraysKt.copyInto(bArr2, bArr3, i7, i8, i8 + byteCount);
        sink.limit += byteCount;
        this.pos += byteCount;
    }

    public Segment(byte[] data, int i5, int i6, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.pos = i5;
        this.limit = i6;
        this.shared = z5;
        this.owner = z6;
    }
}
