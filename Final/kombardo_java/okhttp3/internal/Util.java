package okhttp3.internal;

import com.adjust.sdk.Constants;
import com.sun.jna.Function;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Header;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Source;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0094\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a%\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\r\u001a;\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e*\b\u0012\u0004\u0012\u00020\u00070\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u0012\u0010\u0013\u001a7\u0010\u0014\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00070\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001b\u0010\u0018\u001a\u00020\u0007*\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u0019\u001a-\u0010\u001c\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u001a\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0004\b\u001c\u0010\u001d\u001a%\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e*\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a%\u0010\"\u001a\u00020\u001b*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b\"\u0010#\u001a%\u0010$\u001a\u00020\u001b*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b$\u0010#\u001a%\u0010%\u001a\u00020\u0007*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b%\u0010&\u001a-\u0010(\u001a\u00020\u001b*\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b(\u0010)\u001a-\u0010(\u001a\u00020\u001b*\u00020\u00072\u0006\u0010+\u001a\u00020*2\b\b\u0002\u0010 \u001a\u00020\u001b2\b\b\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\b(\u0010,\u001a\u0011\u0010-\u001a\u00020\u001b*\u00020\u0007¢\u0006\u0004\b-\u0010.\u001a\u0011\u0010/\u001a\u00020\t*\u00020\u0007¢\u0006\u0004\b/\u00100\u001a\u0015\u00101\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b1\u00100\u001a)\u00102\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0012\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u0002030\u000e\"\u000203¢\u0006\u0004\b2\u00105\u001a\u0019\u00109\u001a\u000207*\u0002062\u0006\u00108\u001a\u000207¢\u0006\u0004\b9\u0010:\u001a'\u0010>\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00002\b\u0010=\u001a\u0004\u0018\u00010<¢\u0006\u0004\b>\u0010?\u001a\u0011\u0010@\u001a\u00020\u001b*\u00020*¢\u0006\u0004\b@\u0010A\u001a\u0017\u0010E\u001a\u00020D*\b\u0012\u0004\u0012\u00020C0B¢\u0006\u0004\bE\u0010F\u001a\u0017\u0010G\u001a\b\u0012\u0004\u0012\u00020C0B*\u00020D¢\u0006\u0004\bG\u0010H\u001a\u0019\u0010I\u001a\u00020\t*\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0016¢\u0006\u0004\bI\u0010J\u001a\u0011\u0010M\u001a\u00020L*\u00020K¢\u0006\u0004\bM\u0010N\u001a\u001c\u0010Q\u001a\u00020\u001b*\u00020O2\u0006\u0010P\u001a\u00020\u001bH\u0086\u0004¢\u0006\u0004\bQ\u0010R\u001a\u001c\u0010Q\u001a\u00020\u001b*\u00020S2\u0006\u0010P\u001a\u00020\u001bH\u0086\u0004¢\u0006\u0004\bQ\u0010T\u001a\u001c\u0010Q\u001a\u00020\u0000*\u00020\u001b2\u0006\u0010P\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0004\bQ\u0010U\u001a\u0019\u0010X\u001a\u00020\u0004*\u00020V2\u0006\u0010W\u001a\u00020\u001b¢\u0006\u0004\bX\u0010Y\u001a\u0011\u0010Z\u001a\u00020\u001b*\u000206¢\u0006\u0004\bZ\u0010[\u001a!\u0010^\u001a\u00020\t*\u00020\\2\u0006\u0010;\u001a\u00020\u001b2\u0006\u0010]\u001a\u00020<¢\u0006\u0004\b^\u0010_\u001a!\u0010a\u001a\u00020\t*\u00020\\2\u0006\u0010`\u001a\u00020\u001b2\u0006\u0010]\u001a\u00020<¢\u0006\u0004\ba\u0010_\u001a\u0019\u0010d\u001a\u00020\t*\u00020b2\u0006\u0010c\u001a\u000206¢\u0006\u0004\bd\u0010e\u001a\u0019\u0010^\u001a\u00020\u001b*\u00020f2\u0006\u0010g\u001a\u00020O¢\u0006\u0004\b^\u0010h\u001a\u001b\u0010i\u001a\u00020\u001b*\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u001b¢\u0006\u0004\bi\u0010j\u001a\u0011\u0010l\u001a\u00020\u0000*\u00020k¢\u0006\u0004\bl\u0010m\u001a\u0019\u0010o\u001a\u00020\u0000*\u00020\u00072\u0006\u0010n\u001a\u00020\u0000¢\u0006\u0004\bo\u0010p\u001a\u001b\u0010q\u001a\u00020\u001b*\u0004\u0018\u00010\u00072\u0006\u0010n\u001a\u00020\u001b¢\u0006\u0004\bq\u0010j\u001a#\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000B\"\u0004\b\u0000\u0010r*\b\u0012\u0004\u0012\u00028\u00000B¢\u0006\u0004\bs\u0010t\u001a/\u0010v\u001a\b\u0012\u0004\u0012\u00028\u00000B\"\u0004\b\u0000\u0010r2\u0012\u0010u\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000e\"\u00028\u0000H\u0007¢\u0006\u0004\bv\u0010w\u001a5\u0010{\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010z\"\u0004\b\u0000\u0010x\"\u0004\b\u0001\u0010y*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010z¢\u0006\u0004\b{\u0010|\u001a\u0011\u0010~\u001a\u00020\u0004*\u00020}¢\u0006\u0004\b~\u0010\u007f\u001a\u0012\u0010~\u001a\u00020\u0004*\u00020b¢\u0006\u0005\b~\u0010\u0080\u0001\u001a-\u0010\u0084\u0001\u001a\u00020\u0004\"\u0005\b\u0000\u0010\u0081\u0001*\t\u0012\u0004\u0012\u00028\u00000\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00028\u0000H\u0000¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a0\u0010\u008a\u0001\u001a\u00030\u0089\u0001*\b0\u0086\u0001j\u0003`\u0087\u00012\u0013\u0010\u0088\u0001\u001a\u000e\u0012\n\u0012\b0\u0086\u0001j\u0003`\u0087\u00010B¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0018\u0010\u008d\u0001\u001a\u00030\u008c\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0017\u0010\u008f\u0001\u001a\u00020D8\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0018\u0010\u0092\u0001\u001a\u00030\u0091\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0018\u0010\u0095\u0001\u001a\u00030\u0094\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0018\u0010\u0098\u0001\u001a\u00030\u0097\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0018\u0010\u009b\u0001\u001a\u00030\u009a\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0018\u0010\u009e\u0001\u001a\u00030\u009d\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001\"\u0017\u0010 \u0001\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001\"\u0017\u0010¢\u0001\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001¨\u0006¤\u0001"}, d2 = {BuildConfig.FLAVOR, "arrayLength", "offset", "count", BuildConfig.FLAVOR, "checkOffsetAndCount", "(JJJ)V", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "daemon", "Ljava/util/concurrent/ThreadFactory;", "threadFactory", "(Ljava/lang/String;Z)Ljava/util/concurrent/ThreadFactory;", BuildConfig.FLAVOR, "other", "Ljava/util/Comparator;", "comparator", "intersect", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "hasIntersection", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "Lokhttp3/HttpUrl;", "includeDefaultPort", "toHostHeader", "(Lokhttp3/HttpUrl;Z)Ljava/lang/String;", "value", BuildConfig.FLAVOR, "indexOf", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "concat", "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "startIndex", "endIndex", "indexOfFirstNonAsciiWhitespace", "(Ljava/lang/String;II)I", "indexOfLastNonAsciiWhitespace", "trimSubstring", "(Ljava/lang/String;II)Ljava/lang/String;", "delimiters", "delimiterOffset", "(Ljava/lang/String;Ljava/lang/String;II)I", BuildConfig.FLAVOR, "delimiter", "(Ljava/lang/String;CII)I", "indexOfControlOrNonAscii", "(Ljava/lang/String;)I", "canParseAsIpAddress", "(Ljava/lang/String;)Z", "isSensitiveHeader", "format", BuildConfig.FLAVOR, "args", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Lokio/BufferedSource;", "Ljava/nio/charset/Charset;", "default", "readBomAsCharset", "(Lokio/BufferedSource;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;", "duration", "Ljava/util/concurrent/TimeUnit;", "unit", "checkDuration", "(Ljava/lang/String;JLjava/util/concurrent/TimeUnit;)I", "parseHexDigit", "(C)I", BuildConfig.FLAVOR, "Lokhttp3/internal/http2/Header;", "Lokhttp3/Headers;", "toHeaders", "(Ljava/util/List;)Lokhttp3/Headers;", "toHeaderList", "(Lokhttp3/Headers;)Ljava/util/List;", "canReuseConnectionFor", "(Lokhttp3/HttpUrl;Lokhttp3/HttpUrl;)Z", "Lokhttp3/EventListener;", "Lokhttp3/EventListener$Factory;", "asFactory", "(Lokhttp3/EventListener;)Lokhttp3/EventListener$Factory;", BuildConfig.FLAVOR, "mask", "and", "(BI)I", BuildConfig.FLAVOR, "(SI)I", "(IJ)J", "Lokio/BufferedSink;", Constants.MEDIUM, "writeMedium", "(Lokio/BufferedSink;I)V", "readMedium", "(Lokio/BufferedSource;)I", "Lokio/Source;", "timeUnit", "skipAll", "(Lokio/Source;ILjava/util/concurrent/TimeUnit;)Z", "timeout", "discard", "Ljava/net/Socket;", "source", "isHealthy", "(Ljava/net/Socket;Lokio/BufferedSource;)Z", "Lokio/Buffer;", "b", "(Lokio/Buffer;B)I", "indexOfNonWhitespace", "(Ljava/lang/String;I)I", "Lokhttp3/Response;", "headersContentLength", "(Lokhttp3/Response;)J", "defaultValue", "toLongOrDefault", "(Ljava/lang/String;J)J", "toNonNegativeInt", "T", "toImmutableList", "(Ljava/util/List;)Ljava/util/List;", "elements", "immutableListOf", "([Ljava/lang/Object;)Ljava/util/List;", "K", "V", BuildConfig.FLAVOR, "toImmutableMap", "(Ljava/util/Map;)Ljava/util/Map;", "Ljava/io/Closeable;", "closeQuietly", "(Ljava/io/Closeable;)V", "(Ljava/net/Socket;)V", "E", BuildConfig.FLAVOR, "element", "addIfAbsent", "(Ljava/util/List;Ljava/lang/Object;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "suppressed", BuildConfig.FLAVOR, "withSuppressed", "(Ljava/lang/Exception;Ljava/util/List;)Ljava/lang/Throwable;", BuildConfig.FLAVOR, "EMPTY_BYTE_ARRAY", "[B", "EMPTY_HEADERS", "Lokhttp3/Headers;", "Lokhttp3/ResponseBody;", "EMPTY_RESPONSE", "Lokhttp3/ResponseBody;", "Lokhttp3/RequestBody;", "EMPTY_REQUEST", "Lokhttp3/RequestBody;", "Lokio/Options;", "UNICODE_BOMS", "Lokio/Options;", "Ljava/util/TimeZone;", "UTC", "Ljava/util/TimeZone;", "Lkotlin/text/Regex;", "VERIFY_AS_IP_ADDRESS", "Lkotlin/text/Regex;", "assertionsEnabled", "Z", "okHttpName", "Ljava/lang/String;", "okhttp"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class Util {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final Headers EMPTY_HEADERS = Headers.INSTANCE.of(new String[0]);
    public static final RequestBody EMPTY_REQUEST;
    public static final ResponseBody EMPTY_RESPONSE;
    private static final Options UNICODE_BOMS;
    public static final TimeZone UTC;
    private static final Regex VERIFY_AS_IP_ADDRESS;
    public static final boolean assertionsEnabled;
    public static final String okHttpName;

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.INSTANCE, bArr, (MediaType) null, 1, (Object) null);
        EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.INSTANCE, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        Options.Companion companion = Options.INSTANCE;
        ByteString.Companion companion2 = ByteString.INSTANCE;
        UNICODE_BOMS = companion.of(companion2.decodeHex("efbbbf"), companion2.decodeHex("feff"), companion2.decodeHex("fffe"), companion2.decodeHex("0000ffff"), companion2.decodeHex("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Intrinsics.checkNotNull(timeZone);
        UTC = timeZone;
        VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        assertionsEnabled = false;
        String name = OkHttpClient.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "OkHttpClient::class.java.name");
        okHttpName = StringsKt.removeSuffix(StringsKt.removePrefix(name, "okhttp3."), "Client");
    }

    public static final <E> void addIfAbsent(List<E> list, E e5) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.contains(e5)) {
            return;
        }
        list.add(e5);
    }

    public static final int and(byte b5, int i5) {
        return b5 & i5;
    }

    public static final EventListener.Factory asFactory(final EventListener eventListener) {
        Intrinsics.checkNotNullParameter(eventListener, "<this>");
        return new EventListener.Factory() { // from class: J4.a
            @Override // okhttp3.EventListener.Factory
            public final EventListener create(Call call) {
                EventListener m3829asFactory$lambda8;
                m3829asFactory$lambda8 = Util.m3829asFactory$lambda8(EventListener.this, call);
                return m3829asFactory$lambda8;
            }
        };
    }

    /* renamed from: asFactory$lambda-8 */
    public static final EventListener m3829asFactory$lambda8(EventListener this_asFactory, Call it) {
        Intrinsics.checkNotNullParameter(this_asFactory, "$this_asFactory");
        Intrinsics.checkNotNullParameter(it, "it");
        return this_asFactory;
    }

    public static final boolean canParseAsIpAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return VERIFY_AS_IP_ADDRESS.matches(str);
    }

    public static final boolean canReuseConnectionFor(HttpUrl httpUrl, HttpUrl other) {
        Intrinsics.checkNotNullParameter(httpUrl, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.areEqual(httpUrl.getHost(), other.getHost()) && httpUrl.getPort() == other.getPort() && Intrinsics.areEqual(httpUrl.getScheme(), other.getScheme());
    }

    public static final int checkDuration(String name, long j5, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (j5 < 0) {
            throw new IllegalStateException(Intrinsics.stringPlus(name, " < 0").toString());
        }
        if (timeUnit == null) {
            throw new IllegalStateException("unit == null");
        }
        long millis = timeUnit.toMillis(j5);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(Intrinsics.stringPlus(name, " too large.").toString());
        }
        if (millis != 0 || j5 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus(name, " too small.").toString());
    }

    public static final void checkOffsetAndCount(long j5, long j6, long j7) {
        if ((j6 | j7) < 0 || j6 > j5 || j5 - j6 < j7) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void closeQuietly(Closeable closeable) {
        Intrinsics.checkNotNullParameter(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e5) {
            throw e5;
        } catch (Exception unused) {
        }
    }

    public static final String[] concat(String[] strArr, String value) {
        Intrinsics.checkNotNullParameter(strArr, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Object[] copyOf = Arrays.copyOf(strArr, strArr.length + 1);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        String[] strArr2 = (String[]) copyOf;
        strArr2[ArraysKt.getLastIndex(strArr2)] = value;
        return strArr2;
    }

    public static final int delimiterOffset(String str, String delimiters, int i5, int i6) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        while (i5 < i6) {
            int i7 = i5 + 1;
            if (StringsKt.contains$default((CharSequence) delimiters, str.charAt(i5), false, 2, (Object) null)) {
                return i5;
            }
            i5 = i7;
        }
        return i6;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c5, int i5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            i6 = str.length();
        }
        return delimiterOffset(str, c5, i5, i6);
    }

    public static final boolean discard(Source source, int i5, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(source, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        try {
            return skipAll(source, i5, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String format(String format, Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(args, args.length);
        String format2 = String.format(locale, format, Arrays.copyOf(copyOf, copyOf.length));
        Intrinsics.checkNotNullExpressionValue(format2, "format(locale, format, *args)");
        return format2;
    }

    public static final boolean hasIntersection(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        Intrinsics.checkNotNullParameter(strArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            int length = strArr.length;
            int i5 = 0;
            while (i5 < length) {
                String str = strArr[i5];
                i5++;
                Iterator it = ArrayIteratorKt.iterator(strArr2);
                while (it.hasNext()) {
                    if (comparator.compare(str, (String) it.next()) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final long headersContentLength(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        String str = response.getHeaders().get("Content-Length");
        if (str == null) {
            return -1L;
        }
        return toLongOrDefault(str, -1L);
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        List<T> unmodifiableList = Collections.unmodifiableList(CollectionsKt.listOf(Arrays.copyOf(objArr, objArr.length)));
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return unmodifiableList;
    }

    public static final int indexOf(String[] strArr, String value, Comparator<String> comparator) {
        Intrinsics.checkNotNullParameter(strArr, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int length = strArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (comparator.compare(strArr[i5], value) == 0) {
                return i5;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        int i5 = 0;
        while (i5 < length) {
            int i6 = i5 + 1;
            char charAt = str.charAt(i5);
            if (Intrinsics.compare((int) charAt, 31) <= 0 || Intrinsics.compare((int) charAt, 127) >= 0) {
                return i5;
            }
            i5 = i6;
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(String str, int i5, int i6) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        while (i5 < i6) {
            int i7 = i5 + 1;
            char charAt = str.charAt(i5);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i5;
            }
            i5 = i7;
        }
        return i6;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i5 = 0;
        }
        if ((i7 & 2) != 0) {
            i6 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i5, i6);
    }

    public static final int indexOfLastNonAsciiWhitespace(String str, int i5, int i6) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int i7 = i6 - 1;
        if (i5 <= i7) {
            while (true) {
                int i8 = i7 - 1;
                char charAt = str.charAt(i7);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i7 + 1;
                }
                if (i7 == i5) {
                    break;
                }
                i7 = i8;
            }
        }
        return i5;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i5 = 0;
        }
        if ((i7 & 2) != 0) {
            i6 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i5, i6);
    }

    public static final int indexOfNonWhitespace(String str, int i5) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        while (i5 < length) {
            int i6 = i5 + 1;
            char charAt = str.charAt(i5);
            if (charAt != ' ' && charAt != '\t') {
                return i5;
            }
            i5 = i6;
        }
        return str.length();
    }

    public static final String[] intersect(String[] strArr, String[] other, Comparator<? super String> comparator) {
        Intrinsics.checkNotNullParameter(strArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i5 = 0;
        while (i5 < length) {
            String str = strArr[i5];
            i5++;
            int length2 = other.length;
            int i6 = 0;
            while (true) {
                if (i6 < length2) {
                    String str2 = other[i6];
                    i6++;
                    if (comparator.compare(str, str2) == 0) {
                        arrayList.add(str);
                        break;
                    }
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final boolean isHealthy(Socket socket, BufferedSource source) {
        Intrinsics.checkNotNullParameter(socket, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                boolean z5 = !source.exhausted();
                socket.setSoTimeout(soTimeout);
                return z5;
            } catch (Throwable th) {
                socket.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final boolean isSensitiveHeader(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return StringsKt.equals(name, "Authorization", true) || StringsKt.equals(name, "Cookie", true) || StringsKt.equals(name, "Proxy-Authorization", true) || StringsKt.equals(name, "Set-Cookie", true);
    }

    public static final int parseHexDigit(char c5) {
        if ('0' <= c5 && c5 < ':') {
            return c5 - '0';
        }
        if ('a' <= c5 && c5 < 'g') {
            return c5 - 'W';
        }
        if ('A' > c5 || c5 >= 'G') {
            return -1;
        }
        return c5 - '7';
    }

    public static final Charset readBomAsCharset(BufferedSource bufferedSource, Charset charset) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(charset, "default");
        int select = bufferedSource.select(UNICODE_BOMS);
        if (select == -1) {
            return charset;
        }
        if (select == 0) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            return UTF_8;
        }
        if (select == 1) {
            Charset UTF_16BE = StandardCharsets.UTF_16BE;
            Intrinsics.checkNotNullExpressionValue(UTF_16BE, "UTF_16BE");
            return UTF_16BE;
        }
        if (select == 2) {
            Charset UTF_16LE = StandardCharsets.UTF_16LE;
            Intrinsics.checkNotNullExpressionValue(UTF_16LE, "UTF_16LE");
            return UTF_16LE;
        }
        if (select == 3) {
            return Charsets.INSTANCE.UTF32_BE();
        }
        if (select == 4) {
            return Charsets.INSTANCE.UTF32_LE();
        }
        throw new AssertionError();
    }

    public static final int readMedium(BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        return and(bufferedSource.readByte(), Function.USE_VARARGS) | (and(bufferedSource.readByte(), Function.USE_VARARGS) << 16) | (and(bufferedSource.readByte(), Function.USE_VARARGS) << 8);
    }

    public static final boolean skipAll(Source source, int i5, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(source, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        long nanoTime = System.nanoTime();
        long deadlineNanoTime = source.getTimeout().getHasDeadline() ? source.getTimeout().deadlineNanoTime() - nanoTime : Long.MAX_VALUE;
        source.getTimeout().deadlineNanoTime(Math.min(deadlineNanoTime, timeUnit.toNanos(i5)) + nanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.read(buffer, 8192L) != -1) {
                buffer.clear();
            }
            if (deadlineNanoTime == Long.MAX_VALUE) {
                source.getTimeout().clearDeadline();
            } else {
                source.getTimeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (deadlineNanoTime == Long.MAX_VALUE) {
                source.getTimeout().clearDeadline();
            } else {
                source.getTimeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            return false;
        } catch (Throwable th) {
            if (deadlineNanoTime == Long.MAX_VALUE) {
                source.getTimeout().clearDeadline();
            } else {
                source.getTimeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            throw th;
        }
    }

    public static final ThreadFactory threadFactory(final String name, final boolean z5) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ThreadFactory() { // from class: J4.b
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread m3830threadFactory$lambda1;
                m3830threadFactory$lambda1 = Util.m3830threadFactory$lambda1(name, z5, runnable);
                return m3830threadFactory$lambda1;
            }
        };
    }

    /* renamed from: threadFactory$lambda-1 */
    public static final Thread m3830threadFactory$lambda1(String name, boolean z5, Runnable runnable) {
        Intrinsics.checkNotNullParameter(name, "$name");
        Thread thread = new Thread(runnable, name);
        thread.setDaemon(z5);
        return thread;
    }

    public static final List<Header> toHeaderList(Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        IntRange until = RangesKt.until(0, headers.size());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            arrayList.add(new Header(headers.name(nextInt), headers.value(nextInt)));
        }
        return arrayList;
    }

    public static final Headers toHeaders(List<Header> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            builder.addLenient$okhttp(header.getName().utf8(), header.getValue().utf8());
        }
        return builder.build();
    }

    public static final String toHostHeader(HttpUrl httpUrl, boolean z5) {
        String host;
        Intrinsics.checkNotNullParameter(httpUrl, "<this>");
        if (StringsKt.contains$default((CharSequence) httpUrl.getHost(), (CharSequence) ":", false, 2, (Object) null)) {
            host = '[' + httpUrl.getHost() + ']';
        } else {
            host = httpUrl.getHost();
        }
        if (!z5 && httpUrl.getPort() == HttpUrl.INSTANCE.defaultPort(httpUrl.getScheme())) {
            return host;
        }
        return host + ':' + httpUrl.getPort();
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        return toHostHeader(httpUrl, z5);
    }

    public static final <T> List<T> toImmutableList(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<T> unmodifiableList = Collections.unmodifiableList(CollectionsKt.toMutableList((Collection) list));
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(toMutableList())");
        return unmodifiableList;
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (map.isEmpty()) {
            return MapsKt.emptyMap();
        }
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        return unmodifiableMap;
    }

    public static final long toLongOrDefault(String str, long j5) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j5;
        }
    }

    public static final int toNonNegativeInt(String str, int i5) {
        Long valueOf;
        if (str == null) {
            valueOf = null;
        } else {
            try {
                valueOf = Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                return i5;
            }
        }
        if (valueOf == null) {
            return i5;
        }
        long longValue = valueOf.longValue();
        if (longValue > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (longValue < 0) {
            return 0;
        }
        return (int) longValue;
    }

    public static final String trimSubstring(String str, int i5, int i6) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int indexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(str, i5, i6);
        String substring = str.substring(indexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(str, indexOfFirstNonAsciiWhitespace, i6));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i5 = 0;
        }
        if ((i7 & 2) != 0) {
            i6 = str.length();
        }
        return trimSubstring(str, i5, i6);
    }

    public static final Throwable withSuppressed(Exception exc, List<? extends Exception> suppressed) {
        Intrinsics.checkNotNullParameter(exc, "<this>");
        Intrinsics.checkNotNullParameter(suppressed, "suppressed");
        if (suppressed.size() > 1) {
            System.out.println(suppressed);
        }
        Iterator<? extends Exception> it = suppressed.iterator();
        while (it.hasNext()) {
            ExceptionsKt.addSuppressed(exc, it.next());
        }
        return exc;
    }

    public static final void writeMedium(BufferedSink bufferedSink, int i5) {
        Intrinsics.checkNotNullParameter(bufferedSink, "<this>");
        bufferedSink.writeByte((i5 >>> 16) & Function.USE_VARARGS);
        bufferedSink.writeByte((i5 >>> 8) & Function.USE_VARARGS);
        bufferedSink.writeByte(i5 & Function.USE_VARARGS);
    }

    public static final int and(short s5, int i5) {
        return s5 & i5;
    }

    public static final int delimiterOffset(String str, char c5, int i5, int i6) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        while (i5 < i6) {
            int i7 = i5 + 1;
            if (str.charAt(i5) == c5) {
                return i5;
            }
            i5 = i7;
        }
        return i6;
    }

    public static final long and(int i5, long j5) {
        return i5 & j5;
    }

    public static final void closeQuietly(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e5) {
            throw e5;
        } catch (RuntimeException e6) {
            if (!Intrinsics.areEqual(e6.getMessage(), "bio == null")) {
                throw e6;
            }
        } catch (Exception unused) {
        }
    }

    public static final int skipAll(Buffer buffer, byte b5) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        int i5 = 0;
        while (!buffer.exhausted() && buffer.getByte(0L) == b5) {
            i5++;
            buffer.readByte();
        }
        return i5;
    }
}
