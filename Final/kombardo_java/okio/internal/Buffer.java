package okio.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Options;
import okio.Segment;
import okio._JvmPlatformKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a7\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a%\u0010\u0014\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0014\u0010\u0015\" \u0010\u0016\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lokio/Segment;", "segment", BuildConfig.FLAVOR, "segmentPos", BuildConfig.FLAVOR, "bytes", "bytesOffset", "bytesLimit", BuildConfig.FLAVOR, "rangeEquals", "(Lokio/Segment;I[BII)Z", "Lokio/Buffer;", BuildConfig.FLAVOR, "newline", BuildConfig.FLAVOR, "readUtf8Line", "(Lokio/Buffer;J)Ljava/lang/String;", "Lokio/Options;", "options", "selectTruncated", "selectPrefix", "(Lokio/Buffer;Lokio/Options;Z)I", "HEX_DIGIT_BYTES", "[B", "getHEX_DIGIT_BYTES", "()[B", "getHEX_DIGIT_BYTES$annotations", "()V", "okio"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* renamed from: okio.internal.-Buffer, reason: invalid class name */
/* loaded from: classes3.dex */
public abstract class Buffer {
    private static final byte[] HEX_DIGIT_BYTES = _JvmPlatformKt.asUtf8ToByteArray("0123456789abcdef");

    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(Segment segment, int i5, byte[] bytes, int i6, int i7) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        int i8 = segment.limit;
        byte[] bArr = segment.data;
        while (i6 < i7) {
            if (i5 == i8) {
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                byte[] bArr2 = segment.data;
                bArr = bArr2;
                i5 = segment.pos;
                i8 = segment.limit;
            }
            if (bArr[i5] != bytes[i6]) {
                return false;
            }
            i5++;
            i6++;
        }
        return true;
    }

    public static final String readUtf8Line(okio.Buffer buffer, long j5) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (j5 > 0) {
            long j6 = j5 - 1;
            if (buffer.getByte(j6) == 13) {
                String readUtf8 = buffer.readUtf8(j6);
                buffer.skip(2L);
                return readUtf8;
            }
        }
        String readUtf82 = buffer.readUtf8(j5);
        buffer.skip(1L);
        return readUtf82;
    }

    public static final int selectPrefix(okio.Buffer buffer, Options options, boolean z5) {
        int i5;
        int i6;
        Segment segment;
        int i7;
        int i8;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Segment segment2 = buffer.head;
        if (segment2 == null) {
            return z5 ? -2 : -1;
        }
        byte[] bArr = segment2.data;
        int i9 = segment2.pos;
        int i10 = segment2.limit;
        int[] trie = options.getTrie();
        Segment segment3 = segment2;
        int i11 = -1;
        int i12 = 0;
        loop0: while (true) {
            int i13 = i12 + 1;
            int i14 = trie[i12];
            int i15 = i12 + 2;
            int i16 = trie[i13];
            if (i16 != -1) {
                i11 = i16;
            }
            if (segment3 == null) {
                break;
            }
            if (i14 >= 0) {
                i5 = i9 + 1;
                int i17 = bArr[i9] & 255;
                int i18 = i15 + i14;
                while (i15 != i18) {
                    if (i17 == trie[i15]) {
                        i6 = trie[i15 + i14];
                        if (i5 == i10) {
                            segment3 = segment3.next;
                            Intrinsics.checkNotNull(segment3);
                            i5 = segment3.pos;
                            bArr = segment3.data;
                            i10 = segment3.limit;
                            if (segment3 == segment2) {
                                segment3 = null;
                            }
                        }
                    } else {
                        i15++;
                    }
                }
                return i11;
            }
            int i19 = i15 + (i14 * (-1));
            while (true) {
                int i20 = i9 + 1;
                int i21 = i15 + 1;
                if ((bArr[i9] & 255) != trie[i15]) {
                    return i11;
                }
                boolean z6 = i21 == i19;
                if (i20 == i10) {
                    Intrinsics.checkNotNull(segment3);
                    Segment segment4 = segment3.next;
                    Intrinsics.checkNotNull(segment4);
                    i8 = segment4.pos;
                    byte[] bArr2 = segment4.data;
                    i7 = segment4.limit;
                    if (segment4 != segment2) {
                        segment = segment4;
                        bArr = bArr2;
                    } else {
                        if (!z6) {
                            break loop0;
                        }
                        bArr = bArr2;
                        segment = null;
                    }
                } else {
                    segment = segment3;
                    i7 = i10;
                    i8 = i20;
                }
                if (z6) {
                    i6 = trie[i21];
                    i5 = i8;
                    i10 = i7;
                    segment3 = segment;
                    break;
                }
                i9 = i8;
                i10 = i7;
                segment3 = segment;
                i15 = i21;
            }
            if (i6 >= 0) {
                return i6;
            }
            i12 = -i6;
            i9 = i5;
        }
        if (z5) {
            return -2;
        }
        return i11;
    }

    public static /* synthetic */ int selectPrefix$default(okio.Buffer buffer, Options options, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        return selectPrefix(buffer, options, z5);
    }
}
