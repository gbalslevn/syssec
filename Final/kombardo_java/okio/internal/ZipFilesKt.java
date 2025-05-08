package okio.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okio.BufferedSource;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.ZipFileSystem;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a5\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0000¢\u0006\u0004\b\t\u0010\n\u001a)\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00050\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0013\u0010\u0011\u001a\u00020\u0005*\u00020\u0010H\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0013\u0010\u0014\u001a\u00020\u0013*\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001b\u0010\u0017\u001a\u00020\u0013*\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a5\u0010\u001f\u001a\u00020\u001d*\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bH\u0002¢\u0006\u0004\b\u001f\u0010 \u001a\u0013\u0010!\u001a\u00020\u001d*\u00020\u0010H\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001b\u0010%\u001a\u00020#*\u00020\u00102\u0006\u0010$\u001a\u00020#H\u0000¢\u0006\u0004\b%\u0010&\u001a\u001f\u0010'\u001a\u0004\u0018\u00010#*\u00020\u00102\b\u0010$\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b'\u0010&\u001a!\u0010*\u001a\u0004\u0018\u00010\u001c2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0019H\u0002¢\u0006\u0004\b*\u0010+\"\u0014\u0010,\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010-\"\u0014\u0010.\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010-\"\u0014\u0010/\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010-\"\u0014\u00100\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010-\"\u0014\u00101\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u0010-\"\u0014\u00102\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u0010-\"\u0014\u00103\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u0010-\"\u0014\u00104\u001a\u00020\u001c8\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u00105\"\u0014\u00106\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u0010-\"\u0014\u00107\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u0010-\"\u0018\u0010;\u001a\u000208*\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006<"}, d2 = {"Lokio/Path;", "zipPath", "Lokio/FileSystem;", "fileSystem", "Lkotlin/Function1;", "Lokio/internal/ZipEntry;", BuildConfig.FLAVOR, "predicate", "Lokio/ZipFileSystem;", "openZip", "(Lokio/Path;Lokio/FileSystem;Lkotlin/jvm/functions/Function1;)Lokio/ZipFileSystem;", BuildConfig.FLAVOR, "entries", BuildConfig.FLAVOR, "buildIndex", "(Ljava/util/List;)Ljava/util/Map;", "Lokio/BufferedSource;", "readEntry", "(Lokio/BufferedSource;)Lokio/internal/ZipEntry;", "Lokio/internal/EocdRecord;", "readEocdRecord", "(Lokio/BufferedSource;)Lokio/internal/EocdRecord;", "regularRecord", "readZip64EocdRecord", "(Lokio/BufferedSource;Lokio/internal/EocdRecord;)Lokio/internal/EocdRecord;", BuildConfig.FLAVOR, "extraSize", "Lkotlin/Function2;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "block", "readExtra", "(Lokio/BufferedSource;ILkotlin/jvm/functions/Function2;)V", "skipLocalHeader", "(Lokio/BufferedSource;)V", "Lokio/FileMetadata;", "basicMetadata", "readLocalHeader", "(Lokio/BufferedSource;Lokio/FileMetadata;)Lokio/FileMetadata;", "readOrSkipLocalHeader", "date", "time", "dosDateTimeToEpochMillis", "(II)Ljava/lang/Long;", "LOCAL_FILE_HEADER_SIGNATURE", "I", "CENTRAL_FILE_HEADER_SIGNATURE", "END_OF_CENTRAL_DIRECTORY_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "ZIP64_EOCD_RECORD_SIGNATURE", "BIT_FLAG_ENCRYPTED", "BIT_FLAG_UNSUPPORTED_MASK", "MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE", "J", "HEADER_ID_ZIP64_EXTENDED_INFO", "HEADER_ID_EXTENDED_TIMESTAMP", BuildConfig.FLAVOR, "getHex", "(I)Ljava/lang/String;", "hex", "okio"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ZipFilesKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> list) {
        Path path = Path.Companion.get$default(Path.INSTANCE, "/", false, 1, (Object) null);
        Map<Path, ZipEntry> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(path, new ZipEntry(path, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null)));
        for (ZipEntry zipEntry : CollectionsKt.sortedWith(list, new Comparator() { // from class: okio.internal.ZipFilesKt$buildIndex$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t5, T t6) {
                return ComparisonsKt.compareValues(((ZipEntry) t5).getCanonicalPath(), ((ZipEntry) t6).getCanonicalPath());
            }
        })) {
            if (mutableMapOf.put(zipEntry.getCanonicalPath(), zipEntry) == null) {
                while (true) {
                    Path parent = zipEntry.getCanonicalPath().parent();
                    if (parent != null) {
                        ZipEntry zipEntry2 = mutableMapOf.get(parent);
                        if (zipEntry2 != null) {
                            zipEntry2.getChildren().add(zipEntry.getCanonicalPath());
                            break;
                        }
                        ZipEntry zipEntry3 = new ZipEntry(parent, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null);
                        mutableMapOf.put(parent, zipEntry3);
                        zipEntry3.getChildren().add(zipEntry.getCanonicalPath());
                        zipEntry = zipEntry3;
                    }
                }
            }
        }
        return mutableMapOf;
    }

    private static final Long dosDateTimeToEpochMillis(int i5, int i6) {
        if (i6 == -1) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        gregorianCalendar.set(((i5 >> 9) & 127) + 1980, ((i5 >> 5) & 15) - 1, i5 & 31, (i6 >> 11) & 31, (i6 >> 5) & 63, (i6 & 31) << 1);
        return Long.valueOf(gregorianCalendar.getTime().getTime());
    }

    private static final String getHex(int i5) {
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        String num = Integer.toString(i5, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        sb.append(num);
        return sb.toString();
    }

    /* JADX WARN: Finally extract failed */
    public static final ZipFileSystem openZip(Path zipPath, FileSystem fileSystem, Function1<? super ZipEntry, Boolean> predicate) {
        BufferedSource buffer;
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        FileHandle openReadOnly = fileSystem.openReadOnly(zipPath);
        try {
            long size = openReadOnly.size() - 22;
            if (size < 0) {
                throw new IOException("not a zip: size=" + openReadOnly.size());
            }
            long max = Math.max(size - 65536, 0L);
            do {
                BufferedSource buffer2 = Okio.buffer(openReadOnly.source(size));
                try {
                    if (buffer2.readIntLe() == END_OF_CENTRAL_DIRECTORY_SIGNATURE) {
                        EocdRecord readEocdRecord = readEocdRecord(buffer2);
                        String readUtf8 = buffer2.readUtf8(readEocdRecord.getCommentByteCount());
                        buffer2.close();
                        long j5 = size - 20;
                        if (j5 > 0) {
                            BufferedSource buffer3 = Okio.buffer(openReadOnly.source(j5));
                            try {
                                if (buffer3.readIntLe() == ZIP64_LOCATOR_SIGNATURE) {
                                    int readIntLe = buffer3.readIntLe();
                                    long readLongLe = buffer3.readLongLe();
                                    if (buffer3.readIntLe() != 1 || readIntLe != 0) {
                                        throw new IOException("unsupported zip: spanned");
                                    }
                                    buffer = Okio.buffer(openReadOnly.source(readLongLe));
                                    try {
                                        int readIntLe2 = buffer.readIntLe();
                                        if (readIntLe2 != ZIP64_EOCD_RECORD_SIGNATURE) {
                                            throw new IOException("bad zip: expected " + getHex(ZIP64_EOCD_RECORD_SIGNATURE) + " but was " + getHex(readIntLe2));
                                        }
                                        readEocdRecord = readZip64EocdRecord(buffer, readEocdRecord);
                                        Unit unit = Unit.INSTANCE;
                                        CloseableKt.closeFinally(buffer, null);
                                    } finally {
                                    }
                                }
                                Unit unit2 = Unit.INSTANCE;
                                CloseableKt.closeFinally(buffer3, null);
                            } finally {
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        buffer = Okio.buffer(openReadOnly.source(readEocdRecord.getCentralDirectoryOffset()));
                        try {
                            long entryCount = readEocdRecord.getEntryCount();
                            for (long j6 = 0; j6 < entryCount; j6++) {
                                ZipEntry readEntry = readEntry(buffer);
                                if (readEntry.getOffset() >= readEocdRecord.getCentralDirectoryOffset()) {
                                    throw new IOException("bad zip: local file header offset >= central directory offset");
                                }
                                if (predicate.invoke(readEntry).booleanValue()) {
                                    arrayList.add(readEntry);
                                }
                            }
                            Unit unit3 = Unit.INSTANCE;
                            CloseableKt.closeFinally(buffer, null);
                            ZipFileSystem zipFileSystem = new ZipFileSystem(zipPath, fileSystem, buildIndex(arrayList), readUtf8);
                            CloseableKt.closeFinally(openReadOnly, null);
                            return zipFileSystem;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } finally {
                                CloseableKt.closeFinally(buffer, th);
                            }
                        }
                    }
                    buffer2.close();
                    size--;
                } finally {
                    buffer2.close();
                }
            } while (size >= max);
            throw new IOException("not a zip: end of central directory signature not found");
        } finally {
        }
    }

    public static final ZipEntry readEntry(final BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe != CENTRAL_FILE_HEADER_SIGNATURE) {
            throw new IOException("bad zip: expected " + getHex(CENTRAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
        }
        bufferedSource.skip(4L);
        short readShortLe = bufferedSource.readShortLe();
        int i5 = readShortLe & 65535;
        if ((readShortLe & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(i5));
        }
        int readShortLe2 = bufferedSource.readShortLe() & 65535;
        Long dosDateTimeToEpochMillis = dosDateTimeToEpochMillis(bufferedSource.readShortLe() & 65535, bufferedSource.readShortLe() & 65535);
        long readIntLe2 = bufferedSource.readIntLe() & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        final Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.element = bufferedSource.readIntLe() & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        final Ref$LongRef ref$LongRef2 = new Ref$LongRef();
        ref$LongRef2.element = bufferedSource.readIntLe() & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        int readShortLe3 = bufferedSource.readShortLe() & 65535;
        int readShortLe4 = bufferedSource.readShortLe() & 65535;
        int readShortLe5 = bufferedSource.readShortLe() & 65535;
        bufferedSource.skip(8L);
        final Ref$LongRef ref$LongRef3 = new Ref$LongRef();
        ref$LongRef3.element = bufferedSource.readIntLe() & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
        String readUtf8 = bufferedSource.readUtf8(readShortLe3);
        if (StringsKt.contains$default((CharSequence) readUtf8, (char) 0, false, 2, (Object) null)) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        long j5 = ref$LongRef2.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? 8 : 0L;
        long j6 = ref$LongRef.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE ? j5 + 8 : j5;
        if (ref$LongRef3.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
            j6 += 8;
        }
        final long j7 = j6;
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        readExtra(bufferedSource, readShortLe4, new Function2<Integer, Long, Unit>() { // from class: okio.internal.ZipFilesKt$readEntry$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Long l5) {
                invoke(num.intValue(), l5.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i6, long j8) {
                if (i6 == 1) {
                    Ref$BooleanRef ref$BooleanRef2 = Ref$BooleanRef.this;
                    if (!ref$BooleanRef2.element) {
                        ref$BooleanRef2.element = true;
                        if (j8 >= j7) {
                            Ref$LongRef ref$LongRef4 = ref$LongRef2;
                            long j9 = ref$LongRef4.element;
                            if (j9 == 4294967295L) {
                                j9 = bufferedSource.readLongLe();
                            }
                            ref$LongRef4.element = j9;
                            Ref$LongRef ref$LongRef5 = ref$LongRef;
                            ref$LongRef5.element = ref$LongRef5.element == 4294967295L ? bufferedSource.readLongLe() : 0L;
                            Ref$LongRef ref$LongRef6 = ref$LongRef3;
                            ref$LongRef6.element = ref$LongRef6.element == 4294967295L ? bufferedSource.readLongLe() : 0L;
                            return;
                        }
                        throw new IOException("bad zip: zip64 extra too short");
                    }
                    throw new IOException("bad zip: zip64 extra repeated");
                }
            }
        });
        if (j7 <= 0 || ref$BooleanRef.element) {
            return new ZipEntry(Path.Companion.get$default(Path.INSTANCE, "/", false, 1, (Object) null).resolve(readUtf8), StringsKt.endsWith$default(readUtf8, "/", false, 2, (Object) null), bufferedSource.readUtf8(readShortLe5), readIntLe2, ref$LongRef.element, ref$LongRef2.element, readShortLe2, dosDateTimeToEpochMillis, ref$LongRef3.element);
        }
        throw new IOException("bad zip: zip64 extra required but absent");
    }

    private static final EocdRecord readEocdRecord(BufferedSource bufferedSource) {
        int readShortLe = bufferedSource.readShortLe() & 65535;
        int readShortLe2 = bufferedSource.readShortLe() & 65535;
        long readShortLe3 = bufferedSource.readShortLe() & 65535;
        if (readShortLe3 != (bufferedSource.readShortLe() & 65535) || readShortLe != 0 || readShortLe2 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        bufferedSource.skip(4L);
        return new EocdRecord(readShortLe3, MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE & bufferedSource.readIntLe(), bufferedSource.readShortLe() & 65535);
    }

    private static final void readExtra(BufferedSource bufferedSource, int i5, Function2<? super Integer, ? super Long, Unit> function2) {
        long j5 = i5;
        while (j5 != 0) {
            if (j5 < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int readShortLe = bufferedSource.readShortLe() & 65535;
            long readShortLe2 = bufferedSource.readShortLe() & 65535;
            long j6 = j5 - 4;
            if (j6 < readShortLe2) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            bufferedSource.require(readShortLe2);
            long size = bufferedSource.getBufferField().getSize();
            function2.invoke(Integer.valueOf(readShortLe), Long.valueOf(readShortLe2));
            long size2 = (bufferedSource.getBufferField().getSize() + readShortLe2) - size;
            if (size2 < 0) {
                throw new IOException("unsupported zip: too many bytes processed for " + readShortLe);
            }
            if (size2 > 0) {
                bufferedSource.getBufferField().skip(size2);
            }
            j5 = j6 - readShortLe2;
        }
    }

    public static final FileMetadata readLocalHeader(BufferedSource bufferedSource, FileMetadata basicMetadata) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(basicMetadata, "basicMetadata");
        FileMetadata readOrSkipLocalHeader = readOrSkipLocalHeader(bufferedSource, basicMetadata);
        Intrinsics.checkNotNull(readOrSkipLocalHeader);
        return readOrSkipLocalHeader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final FileMetadata readOrSkipLocalHeader(final BufferedSource bufferedSource, FileMetadata fileMetadata) {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = fileMetadata != null ? fileMetadata.getLastModifiedAtMillis() : 0;
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe != LOCAL_FILE_HEADER_SIGNATURE) {
            throw new IOException("bad zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
        }
        bufferedSource.skip(2L);
        short readShortLe = bufferedSource.readShortLe();
        int i5 = readShortLe & 65535;
        if ((readShortLe & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(i5));
        }
        bufferedSource.skip(18L);
        int readShortLe2 = bufferedSource.readShortLe() & 65535;
        bufferedSource.skip(bufferedSource.readShortLe() & 65535);
        if (fileMetadata == null) {
            bufferedSource.skip(readShortLe2);
            return null;
        }
        readExtra(bufferedSource, readShortLe2, new Function2<Integer, Long, Unit>() { // from class: okio.internal.ZipFilesKt$readOrSkipLocalHeader$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Long l5) {
                invoke(num.intValue(), l5.longValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r0v13, types: [T, java.lang.Long] */
            /* JADX WARN: Type inference failed for: r10v11, types: [T, java.lang.Long] */
            /* JADX WARN: Type inference failed for: r11v3, types: [T, java.lang.Long] */
            public final void invoke(int i6, long j5) {
                if (i6 == 21589) {
                    if (j5 >= 1) {
                        byte readByte = BufferedSource.this.readByte();
                        boolean z5 = (readByte & 1) == 1;
                        boolean z6 = (readByte & 2) == 2;
                        boolean z7 = (readByte & 4) == 4;
                        BufferedSource bufferedSource2 = BufferedSource.this;
                        long j6 = z5 ? 5L : 1L;
                        if (z6) {
                            j6 += 4;
                        }
                        if (z7) {
                            j6 += 4;
                        }
                        if (j5 < j6) {
                            throw new IOException("bad zip: extended timestamp extra too short");
                        }
                        if (z5) {
                            ref$ObjectRef.element = Long.valueOf(bufferedSource2.readIntLe() * 1000);
                        }
                        if (z6) {
                            ref$ObjectRef2.element = Long.valueOf(BufferedSource.this.readIntLe() * 1000);
                        }
                        if (z7) {
                            ref$ObjectRef3.element = Long.valueOf(BufferedSource.this.readIntLe() * 1000);
                            return;
                        }
                        return;
                    }
                    throw new IOException("bad zip: extended timestamp extra too short");
                }
            }
        });
        return new FileMetadata(fileMetadata.getIsRegularFile(), fileMetadata.getIsDirectory(), null, fileMetadata.getSize(), (Long) ref$ObjectRef3.element, (Long) ref$ObjectRef.element, (Long) ref$ObjectRef2.element, null, 128, null);
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource bufferedSource, EocdRecord eocdRecord) {
        bufferedSource.skip(12L);
        int readIntLe = bufferedSource.readIntLe();
        int readIntLe2 = bufferedSource.readIntLe();
        long readLongLe = bufferedSource.readLongLe();
        if (readLongLe != bufferedSource.readLongLe() || readIntLe != 0 || readIntLe2 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        bufferedSource.skip(8L);
        return new EocdRecord(readLongLe, bufferedSource.readLongLe(), eocdRecord.getCommentByteCount());
    }

    public static final void skipLocalHeader(BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        readOrSkipLocalHeader(bufferedSource, null);
    }
}
