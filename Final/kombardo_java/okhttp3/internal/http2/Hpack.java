package okhttp3.internal.http2;

import com.adjust.sdk.Constants;
import com.sun.jna.Function;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/http2/Hpack;", BuildConfig.FLAVOR, "()V", "NAME_TO_FIRST_INDEX", BuildConfig.FLAVOR, "Lokio/ByteString;", BuildConfig.FLAVOR, "getNAME_TO_FIRST_INDEX", "()Ljava/util/Map;", "PREFIX_4_BITS", "PREFIX_5_BITS", "PREFIX_6_BITS", "PREFIX_7_BITS", "SETTINGS_HEADER_TABLE_SIZE", "SETTINGS_HEADER_TABLE_SIZE_LIMIT", "STATIC_HEADER_TABLE", BuildConfig.FLAVOR, "Lokhttp3/internal/http2/Header;", "getSTATIC_HEADER_TABLE", "()[Lokhttp3/internal/http2/Header;", "[Lokhttp3/internal/http2/Header;", "checkLowercase", "name", "nameToFirstIndex", "Reader", "Writer", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Hpack {
    public static final Hpack INSTANCE;
    private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    private static final Header[] STATIC_HEADER_TABLE;

    static {
        Hpack hpack = new Hpack();
        INSTANCE = hpack;
        Header header = new Header(Header.TARGET_AUTHORITY, BuildConfig.FLAVOR);
        ByteString byteString = Header.TARGET_METHOD;
        Header header2 = new Header(byteString, "GET");
        Header header3 = new Header(byteString, "POST");
        ByteString byteString2 = Header.TARGET_PATH;
        Header header4 = new Header(byteString2, "/");
        Header header5 = new Header(byteString2, "/index.html");
        ByteString byteString3 = Header.TARGET_SCHEME;
        Header header6 = new Header(byteString3, "http");
        Header header7 = new Header(byteString3, Constants.SCHEME);
        ByteString byteString4 = Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new Header[]{header, header2, header3, header4, header5, header6, header7, new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, "206"), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, "404"), new Header(byteString4, "500"), new Header("accept-charset", BuildConfig.FLAVOR), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", BuildConfig.FLAVOR), new Header("accept-ranges", BuildConfig.FLAVOR), new Header("accept", BuildConfig.FLAVOR), new Header("access-control-allow-origin", BuildConfig.FLAVOR), new Header("age", BuildConfig.FLAVOR), new Header("allow", BuildConfig.FLAVOR), new Header("authorization", BuildConfig.FLAVOR), new Header("cache-control", BuildConfig.FLAVOR), new Header("content-disposition", BuildConfig.FLAVOR), new Header("content-encoding", BuildConfig.FLAVOR), new Header("content-language", BuildConfig.FLAVOR), new Header("content-length", BuildConfig.FLAVOR), new Header("content-location", BuildConfig.FLAVOR), new Header("content-range", BuildConfig.FLAVOR), new Header("content-type", BuildConfig.FLAVOR), new Header("cookie", BuildConfig.FLAVOR), new Header("date", BuildConfig.FLAVOR), new Header("etag", BuildConfig.FLAVOR), new Header("expect", BuildConfig.FLAVOR), new Header("expires", BuildConfig.FLAVOR), new Header("from", BuildConfig.FLAVOR), new Header("host", BuildConfig.FLAVOR), new Header("if-match", BuildConfig.FLAVOR), new Header("if-modified-since", BuildConfig.FLAVOR), new Header("if-none-match", BuildConfig.FLAVOR), new Header("if-range", BuildConfig.FLAVOR), new Header("if-unmodified-since", BuildConfig.FLAVOR), new Header("last-modified", BuildConfig.FLAVOR), new Header("link", BuildConfig.FLAVOR), new Header("location", BuildConfig.FLAVOR), new Header("max-forwards", BuildConfig.FLAVOR), new Header("proxy-authenticate", BuildConfig.FLAVOR), new Header("proxy-authorization", BuildConfig.FLAVOR), new Header("range", BuildConfig.FLAVOR), new Header("referer", BuildConfig.FLAVOR), new Header("refresh", BuildConfig.FLAVOR), new Header("retry-after", BuildConfig.FLAVOR), new Header("server", BuildConfig.FLAVOR), new Header("set-cookie", BuildConfig.FLAVOR), new Header("strict-transport-security", BuildConfig.FLAVOR), new Header("transfer-encoding", BuildConfig.FLAVOR), new Header("user-agent", BuildConfig.FLAVOR), new Header("vary", BuildConfig.FLAVOR), new Header("via", BuildConfig.FLAVOR), new Header("www-authenticate", BuildConfig.FLAVOR)};
        NAME_TO_FIRST_INDEX = hpack.nameToFirstIndex();
    }

    private Hpack() {
    }

    private final Map<ByteString, Integer> nameToFirstIndex() {
        Header[] headerArr = STATIC_HEADER_TABLE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(headerArr.length);
        int length = headerArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = i5 + 1;
            Header[] headerArr2 = STATIC_HEADER_TABLE;
            if (!linkedHashMap.containsKey(headerArr2[i5].name)) {
                linkedHashMap.put(headerArr2[i5].name, Integer.valueOf(i5));
            }
            i5 = i6;
        }
        Map<ByteString, Integer> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "unmodifiableMap(result)");
        return unmodifiableMap;
    }

    public final ByteString checkLowercase(ByteString name) {
        Intrinsics.checkNotNullParameter(name, "name");
        int size = name.size();
        int i5 = 0;
        while (i5 < size) {
            int i6 = i5 + 1;
            byte b5 = name.getByte(i5);
            if (65 <= b5 && b5 <= 90) {
                throw new IOException(Intrinsics.stringPlus("PROTOCOL_ERROR response malformed: mixed case name: ", name.utf8()));
            }
            i5 = i6;
        }
        return name;
    }

    public final Map<ByteString, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u000bJ\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0012J\u000f\u0010\u0018\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\u000bJ\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010!\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010$J\u0013\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0%¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\t¢\u0006\u0004\b(\u0010\u000bJ\u001d\u0010+\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\u0019¢\u0006\u0004\b-\u0010.R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010/R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010/R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u001f008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u0010\u0003\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00104R\u001e\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010/R\u0016\u00109\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b9\u0010/R\u0016\u0010:\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b:\u0010/¨\u0006;"}, d2 = {"Lokhttp3/internal/http2/Hpack$Reader;", BuildConfig.FLAVOR, "Lokio/Source;", "source", BuildConfig.FLAVOR, "headerTableSizeSetting", "maxDynamicTableByteCount", "<init>", "(Lokio/Source;II)V", BuildConfig.FLAVOR, "adjustDynamicTableByteCount", "()V", "clearDynamicTable", "bytesToRecover", "evictToRecoverBytes", "(I)I", "index", "readIndexedHeader", "(I)V", "dynamicTableIndex", "readLiteralHeaderWithoutIndexingIndexedName", "readLiteralHeaderWithoutIndexingNewName", "nameIndex", "readLiteralHeaderWithIncrementalIndexingIndexedName", "readLiteralHeaderWithIncrementalIndexingNewName", "Lokio/ByteString;", "getName", "(I)Lokio/ByteString;", BuildConfig.FLAVOR, "isStaticHeader", "(I)Z", "Lokhttp3/internal/http2/Header;", "entry", "insertIntoDynamicTable", "(ILokhttp3/internal/http2/Header;)V", "readByte", "()I", BuildConfig.FLAVOR, "getAndResetHeaderList", "()Ljava/util/List;", "readHeaders", "firstByte", "prefixMask", "readInt", "(II)I", "readByteString", "()Lokio/ByteString;", "I", BuildConfig.FLAVOR, "headerList", "Ljava/util/List;", "Lokio/BufferedSource;", "Lokio/BufferedSource;", BuildConfig.FLAVOR, "dynamicTable", "[Lokhttp3/internal/http2/Header;", "nextHeaderIndex", "headerCount", "dynamicTableByteCount", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Reader {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        public int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final BufferedSource source;

        public Reader(Source source, int i5, int i6) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.headerTableSizeSetting = i5;
            this.maxDynamicTableByteCount = i6;
            this.headerList = new ArrayList();
            this.source = Okio.buffer(source);
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = r2.length - 1;
        }

        private final void adjustDynamicTableByteCount() {
            int i5 = this.maxDynamicTableByteCount;
            int i6 = this.dynamicTableByteCount;
            if (i5 < i6) {
                if (i5 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i6 - i5);
                }
            }
        }

        private final void clearDynamicTable() {
            ArraysKt.fill$default(this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int dynamicTableIndex(int index) {
            return this.nextHeaderIndex + 1 + index;
        }

        private final int evictToRecoverBytes(int bytesToRecover) {
            int i5;
            int i6 = 0;
            if (bytesToRecover > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i5 = this.nextHeaderIndex;
                    if (length < i5 || bytesToRecover <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    Intrinsics.checkNotNull(header);
                    int i7 = header.hpackSize;
                    bytesToRecover -= i7;
                    this.dynamicTableByteCount -= i7;
                    this.headerCount--;
                    i6++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i5 + 1, headerArr, i5 + 1 + i6, this.headerCount);
                this.nextHeaderIndex += i6;
            }
            return i6;
        }

        private final ByteString getName(int index) {
            if (isStaticHeader(index)) {
                return Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[index].name;
            }
            int dynamicTableIndex = dynamicTableIndex(index - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    Header header = headerArr[dynamicTableIndex];
                    Intrinsics.checkNotNull(header);
                    return header.name;
                }
            }
            throw new IOException(Intrinsics.stringPlus("Header index too large ", Integer.valueOf(index + 1)));
        }

        private final void insertIntoDynamicTable(int index, Header entry) {
            this.headerList.add(entry);
            int i5 = entry.hpackSize;
            if (index != -1) {
                Header header = this.dynamicTable[dynamicTableIndex(index)];
                Intrinsics.checkNotNull(header);
                i5 -= header.hpackSize;
            }
            int i6 = this.maxDynamicTableByteCount;
            if (i5 > i6) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i5) - i6);
            if (index == -1) {
                int i7 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i7 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i8 = this.nextHeaderIndex;
                this.nextHeaderIndex = i8 - 1;
                this.dynamicTable[i8] = entry;
                this.headerCount++;
            } else {
                this.dynamicTable[index + dynamicTableIndex(index) + evictToRecoverBytes] = entry;
            }
            this.dynamicTableByteCount += i5;
        }

        private final boolean isStaticHeader(int index) {
            return index >= 0 && index <= Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1;
        }

        private final int readByte() {
            return Util.and(this.source.readByte(), Function.USE_VARARGS);
        }

        private final void readIndexedHeader(int index) {
            if (isStaticHeader(index)) {
                this.headerList.add(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[index]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(index - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    List<Header> list = this.headerList;
                    Header header = headerArr[dynamicTableIndex];
                    Intrinsics.checkNotNull(header);
                    list.add(header);
                    return;
                }
            }
            throw new IOException(Intrinsics.stringPlus("Header index too large ", Integer.valueOf(index + 1)));
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int nameIndex) {
            insertIntoDynamicTable(-1, new Header(getName(nameIndex), readByteString()));
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() {
            insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int index) {
            this.headerList.add(new Header(getName(index), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingNewName() {
            this.headerList.add(new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        public final List<Header> getAndResetHeaderList() {
            List<Header> list = CollectionsKt.toList(this.headerList);
            this.headerList.clear();
            return list;
        }

        public final ByteString readByteString() {
            int readByte = readByte();
            boolean z5 = (readByte & 128) == 128;
            long readInt = readInt(readByte, Hpack.PREFIX_7_BITS);
            if (!z5) {
                return this.source.readByteString(readInt);
            }
            Buffer buffer = new Buffer();
            Huffman.INSTANCE.decode(this.source, readInt, buffer);
            return buffer.readByteString();
        }

        public final void readHeaders() {
            while (!this.source.exhausted()) {
                int and = Util.and(this.source.readByte(), Function.USE_VARARGS);
                if (and == 128) {
                    throw new IOException("index == 0");
                }
                if ((and & 128) == 128) {
                    readIndexedHeader(readInt(and, Hpack.PREFIX_7_BITS) - 1);
                } else if (and == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((and & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(and, 63) - 1);
                } else if ((and & 32) == 32) {
                    int readInt = readInt(and, Hpack.PREFIX_5_BITS);
                    this.maxDynamicTableByteCount = readInt;
                    if (readInt < 0 || readInt > this.headerTableSizeSetting) {
                        throw new IOException(Intrinsics.stringPlus("Invalid dynamic table size update ", Integer.valueOf(this.maxDynamicTableByteCount)));
                    }
                    adjustDynamicTableByteCount();
                } else if (and == 16 || and == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(and, 15) - 1);
                }
            }
        }

        public final int readInt(int firstByte, int prefixMask) {
            int i5 = firstByte & prefixMask;
            if (i5 < prefixMask) {
                return i5;
            }
            int i6 = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & 128) == 0) {
                    return prefixMask + (readByte << i6);
                }
                prefixMask += (readByte & Hpack.PREFIX_7_BITS) << i6;
                i6 += 7;
            }
        }

        public /* synthetic */ Reader(Source source, int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
            this(source, i5, (i7 & 4) != 0 ? i5 : i6);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dJ\u0014\u0010\u001e\u001a\u00020\u00142\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0 J\u001e\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003R\u001c\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lokhttp3/internal/http2/Hpack$Writer;", BuildConfig.FLAVOR, "headerTableSizeSetting", BuildConfig.FLAVOR, "useCompression", BuildConfig.FLAVOR, "out", "Lokio/Buffer;", "(IZLokio/Buffer;)V", "dynamicTable", BuildConfig.FLAVOR, "Lokhttp3/internal/http2/Header;", "[Lokhttp3/internal/http2/Header;", "dynamicTableByteCount", "emitDynamicTableSizeUpdate", "headerCount", "maxDynamicTableByteCount", "nextHeaderIndex", "smallestHeaderTableSizeSetting", "adjustDynamicTableByteCount", BuildConfig.FLAVOR, "clearDynamicTable", "evictToRecoverBytes", "bytesToRecover", "insertIntoDynamicTable", "entry", "resizeHeaderTable", "writeByteString", "data", "Lokio/ByteString;", "writeHeaders", "headerBlock", BuildConfig.FLAVOR, "writeInt", "value", "prefixMask", "bits", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Writer {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        public int headerCount;
        public int headerTableSizeSetting;
        public int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        public Writer(int i5, boolean z5, Buffer out) {
            Intrinsics.checkNotNullParameter(out, "out");
            this.headerTableSizeSetting = i5;
            this.useCompression = z5;
            this.out = out;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.maxDynamicTableByteCount = i5;
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = r2.length - 1;
        }

        private final void adjustDynamicTableByteCount() {
            int i5 = this.maxDynamicTableByteCount;
            int i6 = this.dynamicTableByteCount;
            if (i5 < i6) {
                if (i5 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i6 - i5);
                }
            }
        }

        private final void clearDynamicTable() {
            ArraysKt.fill$default(this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int bytesToRecover) {
            int i5;
            int i6 = 0;
            if (bytesToRecover > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i5 = this.nextHeaderIndex;
                    if (length < i5 || bytesToRecover <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    Intrinsics.checkNotNull(header);
                    bytesToRecover -= header.hpackSize;
                    int i7 = this.dynamicTableByteCount;
                    Header header2 = this.dynamicTable[length];
                    Intrinsics.checkNotNull(header2);
                    this.dynamicTableByteCount = i7 - header2.hpackSize;
                    this.headerCount--;
                    i6++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i5 + 1, headerArr, i5 + 1 + i6, this.headerCount);
                Header[] headerArr2 = this.dynamicTable;
                int i8 = this.nextHeaderIndex;
                Arrays.fill(headerArr2, i8 + 1, i8 + 1 + i6, (Object) null);
                this.nextHeaderIndex += i6;
            }
            return i6;
        }

        private final void insertIntoDynamicTable(Header entry) {
            int i5 = entry.hpackSize;
            int i6 = this.maxDynamicTableByteCount;
            if (i5 > i6) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i5) - i6);
            int i7 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i7 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i8 = this.nextHeaderIndex;
            this.nextHeaderIndex = i8 - 1;
            this.dynamicTable[i8] = entry;
            this.headerCount++;
            this.dynamicTableByteCount += i5;
        }

        public final void resizeHeaderTable(int headerTableSizeSetting) {
            this.headerTableSizeSetting = headerTableSizeSetting;
            int min = Math.min(headerTableSizeSetting, Hpack.SETTINGS_HEADER_TABLE_SIZE_LIMIT);
            int i5 = this.maxDynamicTableByteCount;
            if (i5 == min) {
                return;
            }
            if (min < i5) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, min);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = min;
            adjustDynamicTableByteCount();
        }

        public final void writeByteString(ByteString data) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (this.useCompression) {
                Huffman huffman = Huffman.INSTANCE;
                if (huffman.encodedLength(data) < data.size()) {
                    Buffer buffer = new Buffer();
                    huffman.encode(data, buffer);
                    ByteString readByteString = buffer.readByteString();
                    writeInt(readByteString.size(), Hpack.PREFIX_7_BITS, 128);
                    this.out.write(readByteString);
                    return;
                }
            }
            writeInt(data.size(), Hpack.PREFIX_7_BITS, 0);
            this.out.write(data);
        }

        public final void writeHeaders(List<Header> headerBlock) {
            int i5;
            int i6;
            Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
            if (this.emitDynamicTableSizeUpdate) {
                int i7 = this.smallestHeaderTableSizeSetting;
                if (i7 < this.maxDynamicTableByteCount) {
                    writeInt(i7, Hpack.PREFIX_5_BITS, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                writeInt(this.maxDynamicTableByteCount, Hpack.PREFIX_5_BITS, 32);
            }
            int size = headerBlock.size();
            int i8 = 0;
            while (i8 < size) {
                int i9 = i8 + 1;
                Header header = headerBlock.get(i8);
                ByteString asciiLowercase = header.name.toAsciiLowercase();
                ByteString byteString = header.value;
                Hpack hpack = Hpack.INSTANCE;
                Integer num = hpack.getNAME_TO_FIRST_INDEX().get(asciiLowercase);
                if (num != null) {
                    int intValue = num.intValue();
                    i6 = intValue + 1;
                    if (2 <= i6 && i6 < 8) {
                        if (Intrinsics.areEqual(hpack.getSTATIC_HEADER_TABLE()[intValue].value, byteString)) {
                            i5 = i6;
                        } else if (Intrinsics.areEqual(hpack.getSTATIC_HEADER_TABLE()[i6].value, byteString)) {
                            i5 = i6;
                            i6 = intValue + 2;
                        }
                    }
                    i5 = i6;
                    i6 = -1;
                } else {
                    i5 = -1;
                    i6 = -1;
                }
                if (i6 == -1) {
                    int i10 = this.nextHeaderIndex + 1;
                    int length = this.dynamicTable.length;
                    while (true) {
                        if (i10 >= length) {
                            break;
                        }
                        int i11 = i10 + 1;
                        Header header2 = this.dynamicTable[i10];
                        Intrinsics.checkNotNull(header2);
                        if (Intrinsics.areEqual(header2.name, asciiLowercase)) {
                            Header header3 = this.dynamicTable[i10];
                            Intrinsics.checkNotNull(header3);
                            if (Intrinsics.areEqual(header3.value, byteString)) {
                                i6 = Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length + (i10 - this.nextHeaderIndex);
                                break;
                            } else if (i5 == -1) {
                                i5 = Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length + (i10 - this.nextHeaderIndex);
                            }
                        }
                        i10 = i11;
                    }
                }
                if (i6 != -1) {
                    writeInt(i6, Hpack.PREFIX_7_BITS, 128);
                } else if (i5 == -1) {
                    this.out.writeByte(64);
                    writeByteString(asciiLowercase);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                } else if (!asciiLowercase.startsWith(Header.PSEUDO_PREFIX) || Intrinsics.areEqual(Header.TARGET_AUTHORITY, asciiLowercase)) {
                    writeInt(i5, 63, 64);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                } else {
                    writeInt(i5, 15, 0);
                    writeByteString(byteString);
                }
                i8 = i9;
            }
        }

        public final void writeInt(int value, int prefixMask, int bits) {
            if (value < prefixMask) {
                this.out.writeByte(value | bits);
                return;
            }
            this.out.writeByte(bits | prefixMask);
            int i5 = value - prefixMask;
            while (i5 >= 128) {
                this.out.writeByte(128 | (i5 & Hpack.PREFIX_7_BITS));
                i5 >>>= 7;
            }
            this.out.writeByte(i5);
        }

        public /* synthetic */ Writer(int i5, boolean z5, Buffer buffer, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this((i6 & 1) != 0 ? Hpack.SETTINGS_HEADER_TABLE_SIZE : i5, (i6 & 2) != 0 ? true : z5, buffer);
        }
    }
}
