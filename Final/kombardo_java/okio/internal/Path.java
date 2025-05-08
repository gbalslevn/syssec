package okio.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0015\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\f\u001a\u00020\u0000*\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u000f\u001a\u00020\u0000*\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0013\u0010\u0012\u001a\u00020\u0011*\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0013\u0010\u0012\u001a\u00020\u0011*\u00020\u0014H\u0002¢\u0006\u0004\b\u0012\u0010\u0015\u001a\u001b\u0010\u0017\u001a\u00020\u0004*\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u0019\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u001b\u0010\u001c\"\u001a\u0010\u001d\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u0012\u0004\b\u001e\u0010\u001c\"\u001a\u0010\u001f\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u0012\u0004\b \u0010\u001c\"\u001a\u0010!\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\f\n\u0004\b!\u0010\u001a\u0012\u0004\b\"\u0010\u001c\"\u001a\u0010#\u001a\u00020\u00118\u0002X\u0083\u0004¢\u0006\f\n\u0004\b#\u0010\u001a\u0012\u0004\b$\u0010\u001c\"\u0018\u0010&\u001a\u00020\u0001*\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0003\"\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u0011*\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lokio/Path;", BuildConfig.FLAVOR, "rootLength", "(Lokio/Path;)I", BuildConfig.FLAVOR, "lastSegmentIsDotDot", "(Lokio/Path;)Z", "child", "normalize", "commonResolve", "(Lokio/Path;Lokio/Path;Z)Lokio/Path;", BuildConfig.FLAVOR, "commonToPath", "(Ljava/lang/String;Z)Lokio/Path;", "Lokio/Buffer;", "toPath", "(Lokio/Buffer;Z)Lokio/Path;", "Lokio/ByteString;", "toSlash", "(Ljava/lang/String;)Lokio/ByteString;", BuildConfig.FLAVOR, "(B)Lokio/ByteString;", "slash", "startsWithVolumeLetterAndColon", "(Lokio/Buffer;Lokio/ByteString;)Z", "SLASH", "Lokio/ByteString;", "getSLASH$annotations", "()V", "BACKSLASH", "getBACKSLASH$annotations", "ANY_SLASH", "getANY_SLASH$annotations", "DOT", "getDOT$annotations", "DOT_DOT", "getDOT_DOT$annotations", "getIndexOfLastSlash", "indexOfLastSlash", "getSlash", "(Lokio/Path;)Lokio/ByteString;", "okio"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* renamed from: okio.internal.-Path, reason: invalid class name */
/* loaded from: classes3.dex */
public abstract class Path {
    private static final ByteString ANY_SLASH;
    private static final ByteString BACKSLASH;
    private static final ByteString DOT;
    private static final ByteString DOT_DOT;
    private static final ByteString SLASH;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        SLASH = companion.encodeUtf8("/");
        BACKSLASH = companion.encodeUtf8("\\");
        ANY_SLASH = companion.encodeUtf8("/\\");
        DOT = companion.encodeUtf8(".");
        DOT_DOT = companion.encodeUtf8("..");
    }

    public static final okio.Path commonResolve(okio.Path path, okio.Path child, boolean z5) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        if (child.isAbsolute() || child.volumeLetter() != null) {
            return child;
        }
        ByteString slash = getSlash(path);
        if (slash == null && (slash = getSlash(child)) == null) {
            slash = toSlash(okio.Path.DIRECTORY_SEPARATOR);
        }
        Buffer buffer = new Buffer();
        buffer.write(path.getBytes());
        if (buffer.getSize() > 0) {
            buffer.write(slash);
        }
        buffer.write(child.getBytes());
        return toPath(buffer, z5);
    }

    public static final okio.Path commonToPath(String str, boolean z5) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return toPath(new Buffer().writeUtf8(str), z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getIndexOfLastSlash(okio.Path path) {
        int lastIndexOf$default = ByteString.lastIndexOf$default(path.getBytes(), SLASH, 0, 2, null);
        return lastIndexOf$default != -1 ? lastIndexOf$default : ByteString.lastIndexOf$default(path.getBytes(), BACKSLASH, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteString getSlash(okio.Path path) {
        ByteString bytes = path.getBytes();
        ByteString byteString = SLASH;
        if (ByteString.indexOf$default(bytes, byteString, 0, 2, null) != -1) {
            return byteString;
        }
        ByteString bytes2 = path.getBytes();
        ByteString byteString2 = BACKSLASH;
        if (ByteString.indexOf$default(bytes2, byteString2, 0, 2, null) != -1) {
            return byteString2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean lastSegmentIsDotDot(okio.Path path) {
        return path.getBytes().endsWith(DOT_DOT) && (path.getBytes().size() == 2 || path.getBytes().rangeEquals(path.getBytes().size() + (-3), SLASH, 0, 1) || path.getBytes().rangeEquals(path.getBytes().size() + (-3), BACKSLASH, 0, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int rootLength(okio.Path path) {
        if (path.getBytes().size() == 0) {
            return -1;
        }
        if (path.getBytes().getByte(0) == 47) {
            return 1;
        }
        if (path.getBytes().getByte(0) == 92) {
            if (path.getBytes().size() <= 2 || path.getBytes().getByte(1) != 92) {
                return 1;
            }
            int indexOf = path.getBytes().indexOf(BACKSLASH, 2);
            return indexOf == -1 ? path.getBytes().size() : indexOf;
        }
        if (path.getBytes().size() > 2 && path.getBytes().getByte(1) == 58 && path.getBytes().getByte(2) == 92) {
            char c5 = (char) path.getBytes().getByte(0);
            if ('a' <= c5 && c5 < '{') {
                return 3;
            }
            if ('A' <= c5 && c5 < '[') {
                return 3;
            }
        }
        return -1;
    }

    private static final boolean startsWithVolumeLetterAndColon(Buffer buffer, ByteString byteString) {
        if (!Intrinsics.areEqual(byteString, BACKSLASH) || buffer.getSize() < 2 || buffer.getByte(1L) != 58) {
            return false;
        }
        char c5 = (char) buffer.getByte(0L);
        return ('a' <= c5 && c5 < '{') || ('A' <= c5 && c5 < '[');
    }

    public static final okio.Path toPath(Buffer buffer, boolean z5) {
        ByteString byteString;
        ByteString readByteString;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Buffer buffer2 = new Buffer();
        ByteString byteString2 = null;
        int i5 = 0;
        while (true) {
            if (!buffer.rangeEquals(0L, SLASH)) {
                byteString = BACKSLASH;
                if (!buffer.rangeEquals(0L, byteString)) {
                    break;
                }
            }
            byte readByte = buffer.readByte();
            if (byteString2 == null) {
                byteString2 = toSlash(readByte);
            }
            i5++;
        }
        boolean z6 = i5 >= 2 && Intrinsics.areEqual(byteString2, byteString);
        if (z6) {
            Intrinsics.checkNotNull(byteString2);
            buffer2.write(byteString2);
            buffer2.write(byteString2);
        } else if (i5 > 0) {
            Intrinsics.checkNotNull(byteString2);
            buffer2.write(byteString2);
        } else {
            long indexOfElement = buffer.indexOfElement(ANY_SLASH);
            if (byteString2 == null) {
                byteString2 = indexOfElement == -1 ? toSlash(okio.Path.DIRECTORY_SEPARATOR) : toSlash(buffer.getByte(indexOfElement));
            }
            if (startsWithVolumeLetterAndColon(buffer, byteString2)) {
                if (indexOfElement == 2) {
                    buffer2.write(buffer, 3L);
                } else {
                    buffer2.write(buffer, 2L);
                }
            }
        }
        boolean z7 = buffer2.getSize() > 0;
        ArrayList arrayList = new ArrayList();
        while (!buffer.exhausted()) {
            long indexOfElement2 = buffer.indexOfElement(ANY_SLASH);
            if (indexOfElement2 == -1) {
                readByteString = buffer.readByteString();
            } else {
                readByteString = buffer.readByteString(indexOfElement2);
                buffer.readByte();
            }
            ByteString byteString3 = DOT_DOT;
            if (Intrinsics.areEqual(readByteString, byteString3)) {
                if (!z7 || !arrayList.isEmpty()) {
                    if (!z5 || (!z7 && (arrayList.isEmpty() || Intrinsics.areEqual(CollectionsKt.last((List) arrayList), byteString3)))) {
                        arrayList.add(readByteString);
                    } else if (!z6 || arrayList.size() != 1) {
                        CollectionsKt.removeLastOrNull(arrayList);
                    }
                }
            } else if (!Intrinsics.areEqual(readByteString, DOT) && !Intrinsics.areEqual(readByteString, ByteString.EMPTY)) {
                arrayList.add(readByteString);
            }
        }
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (i6 > 0) {
                buffer2.write(byteString2);
            }
            buffer2.write((ByteString) arrayList.get(i6));
        }
        if (buffer2.getSize() == 0) {
            buffer2.write(DOT);
        }
        return new okio.Path(buffer2.readByteString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteString toSlash(String str) {
        if (Intrinsics.areEqual(str, "/")) {
            return SLASH;
        }
        if (Intrinsics.areEqual(str, "\\")) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException("not a directory separator: " + str);
    }

    private static final ByteString toSlash(byte b5) {
        if (b5 == 47) {
            return SLASH;
        }
        if (b5 == 92) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException("not a directory separator: " + ((int) b5));
    }
}
