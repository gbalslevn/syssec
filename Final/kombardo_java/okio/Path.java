package okio;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0007\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00014B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\n\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u001cH\u0096\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0004\b!\u0010\"R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010%R\u0013\u0010'\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b&\u0010\u0012R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020(8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0011\u0010,\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0013\u0010/\u001a\u0004\u0018\u00010.8G¢\u0006\u0006\u001a\u0004\b/\u00100R\u0011\u00101\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b1\u0010%R\u0011\u00102\u001a\u00020\u00068G¢\u0006\u0006\u001a\u0004\b2\u0010\"R\u0013\u00103\u001a\u0004\u0018\u00010\u00008G¢\u0006\u0006\u001a\u0004\b3\u0010\u0012¨\u00065"}, d2 = {"Lokio/Path;", BuildConfig.FLAVOR, "Lokio/ByteString;", "bytes", "<init>", "(Lokio/ByteString;)V", BuildConfig.FLAVOR, "child", "resolve", "(Ljava/lang/String;)Lokio/Path;", "div", BuildConfig.FLAVOR, "normalize", "(Lokio/Path;Z)Lokio/Path;", "other", "relativeTo", "(Lokio/Path;)Lokio/Path;", "normalized", "()Lokio/Path;", "Ljava/io/File;", "toFile", "()Ljava/io/File;", "Ljava/nio/file/Path;", "toNioPath", "()Ljava/nio/file/Path;", BuildConfig.FLAVOR, "compareTo", "(Lokio/Path;)I", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Lokio/ByteString;", "getBytes$okio", "()Lokio/ByteString;", "getRoot", "root", BuildConfig.FLAVOR, "getSegmentsBytes", "()Ljava/util/List;", "segmentsBytes", "isAbsolute", "()Z", BuildConfig.FLAVOR, "volumeLetter", "()Ljava/lang/Character;", "nameBytes", "name", "parent", "Companion", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Path implements Comparable<Path> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DIRECTORY_SEPARATOR;
    private final ByteString bytes;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u001b\u0010\u0005\u001a\u00020\u0006*\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u001b\u0010\f\u001a\u00020\u0006*\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokio/Path$Companion;", BuildConfig.FLAVOR, "()V", "DIRECTORY_SEPARATOR", BuildConfig.FLAVOR, "toOkioPath", "Lokio/Path;", "Ljava/io/File;", "normalize", BuildConfig.FLAVOR, "get", "Ljava/nio/file/Path;", "toPath", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Path get$default(Companion companion, String str, boolean z5, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = false;
            }
            return companion.get(str, z5);
        }

        public final Path get(String str, boolean z5) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return okio.internal.Path.commonToPath(str, z5);
        }

        private Companion() {
        }

        public static /* synthetic */ Path get$default(Companion companion, File file, boolean z5, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = false;
            }
            return companion.get(file, z5);
        }

        public final Path get(File file, boolean z5) {
            Intrinsics.checkNotNullParameter(file, "<this>");
            String file2 = file.toString();
            Intrinsics.checkNotNullExpressionValue(file2, "toString()");
            return get(file2, z5);
        }

        public static /* synthetic */ Path get$default(Companion companion, java.nio.file.Path path, boolean z5, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                z5 = false;
            }
            return companion.get(path, z5);
        }

        public final Path get(java.nio.file.Path path, boolean z5) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            return get(path.toString(), z5);
        }
    }

    static {
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        DIRECTORY_SEPARATOR = separator;
    }

    public Path(ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.bytes = bytes;
    }

    public boolean equals(Object other) {
        return (other instanceof Path) && Intrinsics.areEqual(((Path) other).getBytes(), getBytes());
    }

    /* renamed from: getBytes$okio, reason: from getter */
    public final ByteString getBytes() {
        return this.bytes;
    }

    public final Path getRoot() {
        int rootLength;
        rootLength = okio.internal.Path.rootLength(this);
        if (rootLength == -1) {
            return null;
        }
        return new Path(getBytes().substring(0, rootLength));
    }

    public final List<ByteString> getSegmentsBytes() {
        int rootLength;
        ArrayList arrayList = new ArrayList();
        rootLength = okio.internal.Path.rootLength(this);
        if (rootLength == -1) {
            rootLength = 0;
        } else if (rootLength < getBytes().size() && getBytes().getByte(rootLength) == 92) {
            rootLength++;
        }
        int size = getBytes().size();
        int i5 = rootLength;
        while (rootLength < size) {
            if (getBytes().getByte(rootLength) == 47 || getBytes().getByte(rootLength) == 92) {
                arrayList.add(getBytes().substring(i5, rootLength));
                i5 = rootLength + 1;
            }
            rootLength++;
        }
        if (i5 < getBytes().size()) {
            arrayList.add(getBytes().substring(i5, getBytes().size()));
        }
        return arrayList;
    }

    public int hashCode() {
        return getBytes().hashCode();
    }

    public final boolean isAbsolute() {
        int rootLength;
        rootLength = okio.internal.Path.rootLength(this);
        return rootLength != -1;
    }

    public final String name() {
        return nameBytes().utf8();
    }

    public final ByteString nameBytes() {
        int indexOfLastSlash;
        indexOfLastSlash = okio.internal.Path.getIndexOfLastSlash(this);
        return indexOfLastSlash != -1 ? ByteString.substring$default(getBytes(), indexOfLastSlash + 1, 0, 2, null) : (volumeLetter() == null || getBytes().size() != 2) ? getBytes() : ByteString.EMPTY;
    }

    public final Path normalized() {
        return INSTANCE.get(toString(), true);
    }

    public final Path parent() {
        ByteString byteString;
        ByteString byteString2;
        ByteString byteString3;
        boolean lastSegmentIsDotDot;
        int indexOfLastSlash;
        Path path;
        ByteString byteString4;
        ByteString byteString5;
        ByteString bytes = getBytes();
        byteString = okio.internal.Path.DOT;
        if (Intrinsics.areEqual(bytes, byteString)) {
            return null;
        }
        ByteString bytes2 = getBytes();
        byteString2 = okio.internal.Path.SLASH;
        if (Intrinsics.areEqual(bytes2, byteString2)) {
            return null;
        }
        ByteString bytes3 = getBytes();
        byteString3 = okio.internal.Path.BACKSLASH;
        if (Intrinsics.areEqual(bytes3, byteString3)) {
            return null;
        }
        lastSegmentIsDotDot = okio.internal.Path.lastSegmentIsDotDot(this);
        if (lastSegmentIsDotDot) {
            return null;
        }
        indexOfLastSlash = okio.internal.Path.getIndexOfLastSlash(this);
        if (indexOfLastSlash != 2 || volumeLetter() == null) {
            if (indexOfLastSlash == 1) {
                ByteString bytes4 = getBytes();
                byteString5 = okio.internal.Path.BACKSLASH;
                if (bytes4.startsWith(byteString5)) {
                    return null;
                }
            }
            if (indexOfLastSlash != -1 || volumeLetter() == null) {
                if (indexOfLastSlash == -1) {
                    byteString4 = okio.internal.Path.DOT;
                    return new Path(byteString4);
                }
                if (indexOfLastSlash != 0) {
                    return new Path(ByteString.substring$default(getBytes(), 0, indexOfLastSlash, 1, null));
                }
                path = new Path(ByteString.substring$default(getBytes(), 0, 1, 1, null));
            } else {
                if (getBytes().size() == 2) {
                    return null;
                }
                path = new Path(ByteString.substring$default(getBytes(), 0, 2, 1, null));
            }
        } else {
            if (getBytes().size() == 3) {
                return null;
            }
            path = new Path(ByteString.substring$default(getBytes(), 0, 3, 1, null));
        }
        return path;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x007b, code lost:
    
        r9 = okio.internal.Path.getSlash(r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Path relativeTo(Path other) {
        ByteString byteString;
        ByteString slash;
        ByteString byteString2;
        Intrinsics.checkNotNullParameter(other, "other");
        if (!Intrinsics.areEqual(getRoot(), other.getRoot())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + other).toString());
        }
        List<ByteString> segmentsBytes = getSegmentsBytes();
        List<ByteString> segmentsBytes2 = other.getSegmentsBytes();
        int min = Math.min(segmentsBytes.size(), segmentsBytes2.size());
        int i5 = 0;
        while (i5 < min && Intrinsics.areEqual(segmentsBytes.get(i5), segmentsBytes2.get(i5))) {
            i5++;
        }
        if (i5 == min && getBytes().size() == other.getBytes().size()) {
            return Companion.get$default(INSTANCE, ".", false, 1, (Object) null);
        }
        List<ByteString> subList = segmentsBytes2.subList(i5, segmentsBytes2.size());
        byteString = okio.internal.Path.DOT_DOT;
        if (subList.indexOf(byteString) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + other).toString());
        }
        Buffer buffer = new Buffer();
        slash = okio.internal.Path.getSlash(other);
        if (slash == null && slash == null) {
            slash = okio.internal.Path.toSlash(DIRECTORY_SEPARATOR);
        }
        int size = segmentsBytes2.size();
        for (int i6 = i5; i6 < size; i6++) {
            byteString2 = okio.internal.Path.DOT_DOT;
            buffer.write(byteString2);
            buffer.write(slash);
        }
        int size2 = segmentsBytes.size();
        while (i5 < size2) {
            buffer.write(segmentsBytes.get(i5));
            buffer.write(slash);
            i5++;
        }
        return okio.internal.Path.toPath(buffer, false);
    }

    public final Path resolve(Path child, boolean normalize) {
        Intrinsics.checkNotNullParameter(child, "child");
        return okio.internal.Path.commonResolve(this, child, normalize);
    }

    public final File toFile() {
        return new File(toString());
    }

    public final java.nio.file.Path toNioPath() {
        java.nio.file.Path path = Paths.get(toString(), new String[0]);
        Intrinsics.checkNotNullExpressionValue(path, "get(toString())");
        return path;
    }

    public String toString() {
        return getBytes().utf8();
    }

    public final Character volumeLetter() {
        ByteString byteString;
        ByteString bytes = getBytes();
        byteString = okio.internal.Path.SLASH;
        if (ByteString.indexOf$default(bytes, byteString, 0, 2, null) != -1 || getBytes().size() < 2 || getBytes().getByte(1) != 58) {
            return null;
        }
        char c5 = (char) getBytes().getByte(0);
        if (('a' > c5 || c5 >= '{') && ('A' > c5 || c5 >= '[')) {
            return null;
        }
        return Character.valueOf(c5);
    }

    @Override // java.lang.Comparable
    public int compareTo(Path other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return getBytes().compareTo(other.getBytes());
    }

    public final Path resolve(String child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return okio.internal.Path.commonResolve(this, okio.internal.Path.toPath(new Buffer().writeUtf8(child), false), false);
    }
}
