package okhttp3.internal.http;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.ByteString;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\u000b\u001a\u00020\n*\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\u000e\u001a\u00020\r*\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001b\u0010\u0012\u001a\u00020\r*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0015\u001a!\u0010\u001b\u001a\u00020\n*\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0011\u0010\u001e\u001a\u00020\r*\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001f\"\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"\"\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\"¨\u0006$"}, d2 = {"Lokhttp3/Headers;", BuildConfig.FLAVOR, "headerName", BuildConfig.FLAVOR, "Lokhttp3/Challenge;", "parseChallenges", "(Lokhttp3/Headers;Ljava/lang/String;)Ljava/util/List;", "Lokio/Buffer;", BuildConfig.FLAVOR, "result", BuildConfig.FLAVOR, "readChallengeHeader", "(Lokio/Buffer;Ljava/util/List;)V", BuildConfig.FLAVOR, "skipCommasAndWhitespace", "(Lokio/Buffer;)Z", BuildConfig.FLAVOR, "prefix", "startsWith", "(Lokio/Buffer;B)Z", "readQuotedString", "(Lokio/Buffer;)Ljava/lang/String;", "readToken", "Lokhttp3/CookieJar;", "Lokhttp3/HttpUrl;", "url", "headers", "receiveHeaders", "(Lokhttp3/CookieJar;Lokhttp3/HttpUrl;Lokhttp3/Headers;)V", "Lokhttp3/Response;", "promisesBody", "(Lokhttp3/Response;)Z", "Lokio/ByteString;", "QUOTED_STRING_DELIMITERS", "Lokio/ByteString;", "TOKEN_DELIMITERS", "okhttp"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS;
    private static final ByteString TOKEN_DELIMITERS;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        QUOTED_STRING_DELIMITERS = companion.encodeUtf8("\"\\");
        TOKEN_DELIMITERS = companion.encodeUtf8("\t ,=");
    }

    public static final List<Challenge> parseChallenges(Headers headers, String headerName) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        Intrinsics.checkNotNullParameter(headerName, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        int i5 = 0;
        while (i5 < size) {
            int i6 = i5 + 1;
            if (StringsKt.equals(headerName, headers.name(i5), true)) {
                try {
                    readChallengeHeader(new Buffer().writeUtf8(headers.value(i5)), arrayList);
                } catch (EOFException e5) {
                    Platform.INSTANCE.get().log("Unable to parse challenge", 5, e5);
                }
            }
            i5 = i6;
        }
        return arrayList;
    }

    public static final boolean promisesBody(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        if (Intrinsics.areEqual(response.getRequest().getMethod(), "HEAD")) {
            return false;
        }
        int code = response.getCode();
        return (((code >= 100 && code < 200) || code == 204 || code == 304) && Util.headersContentLength(response) == -1 && !StringsKt.equals("chunked", Response.header$default(response, "Transfer-Encoding", null, 2, null), true)) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0079, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0079, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void readChallengeHeader(Buffer buffer, List<Challenge> list) {
        String readToken;
        int skipAll;
        while (true) {
            String str = null;
            while (true) {
                if (str == null) {
                    skipCommasAndWhitespace(buffer);
                    str = readToken(buffer);
                    if (str == null) {
                        return;
                    }
                }
                boolean skipCommasAndWhitespace = skipCommasAndWhitespace(buffer);
                readToken = readToken(buffer);
                if (readToken == null) {
                    if (buffer.exhausted()) {
                        list.add(new Challenge(str, MapsKt.emptyMap()));
                        return;
                    }
                    return;
                }
                skipAll = Util.skipAll(buffer, (byte) 61);
                boolean skipCommasAndWhitespace2 = skipCommasAndWhitespace(buffer);
                if (skipCommasAndWhitespace || (!skipCommasAndWhitespace2 && !buffer.exhausted())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int skipAll2 = skipAll + Util.skipAll(buffer, (byte) 61);
                    while (true) {
                        if (readToken == null) {
                            readToken = readToken(buffer);
                            if (skipCommasAndWhitespace(buffer)) {
                                break;
                            } else {
                                skipAll2 = Util.skipAll(buffer, (byte) 61);
                            }
                        }
                        if (skipAll2 == 0) {
                            break;
                        }
                        if (skipAll2 > 1 || skipCommasAndWhitespace(buffer)) {
                            return;
                        }
                        String readQuotedString = startsWith(buffer, (byte) 34) ? readQuotedString(buffer) : readToken(buffer);
                        if (readQuotedString == null || ((String) linkedHashMap.put(readToken, readQuotedString)) != null) {
                            return;
                        }
                        if (!skipCommasAndWhitespace(buffer) && !buffer.exhausted()) {
                            return;
                        } else {
                            readToken = null;
                        }
                    }
                    list.add(new Challenge(str, linkedHashMap));
                    str = readToken;
                }
            }
            Map singletonMap = Collections.singletonMap(null, Intrinsics.stringPlus(readToken, StringsKt.repeat("=", skipAll)));
            Intrinsics.checkNotNullExpressionValue(singletonMap, "singletonMap<String, Str…ek + \"=\".repeat(eqCount))");
            list.add(new Challenge(str, singletonMap));
        }
    }

    private static final String readQuotedString(Buffer buffer) {
        if (buffer.readByte() != 34) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        Buffer buffer2 = new Buffer();
        while (true) {
            long indexOfElement = buffer.indexOfElement(QUOTED_STRING_DELIMITERS);
            if (indexOfElement == -1) {
                return null;
            }
            if (buffer.getByte(indexOfElement) == 34) {
                buffer2.write(buffer, indexOfElement);
                buffer.readByte();
                return buffer2.readUtf8();
            }
            if (buffer.getSize() == indexOfElement + 1) {
                return null;
            }
            buffer2.write(buffer, indexOfElement);
            buffer.readByte();
            buffer2.write(buffer, 1L);
        }
    }

    private static final String readToken(Buffer buffer) {
        long indexOfElement = buffer.indexOfElement(TOKEN_DELIMITERS);
        if (indexOfElement == -1) {
            indexOfElement = buffer.getSize();
        }
        if (indexOfElement != 0) {
            return buffer.readUtf8(indexOfElement);
        }
        return null;
    }

    public static final void receiveHeaders(CookieJar cookieJar, HttpUrl url, Headers headers) {
        Intrinsics.checkNotNullParameter(cookieJar, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> parseAll = Cookie.INSTANCE.parseAll(url, headers);
        if (parseAll.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(url, parseAll);
    }

    private static final boolean skipCommasAndWhitespace(Buffer buffer) {
        boolean z5 = false;
        while (!buffer.exhausted()) {
            byte b5 = buffer.getByte(0L);
            if (b5 == 44) {
                buffer.readByte();
                z5 = true;
            } else {
                if (b5 != 32 && b5 != 9) {
                    break;
                }
                buffer.readByte();
            }
        }
        return z5;
    }

    private static final boolean startsWith(Buffer buffer, byte b5) {
        return !buffer.exhausted() && buffer.getByte(0L) == b5;
    }
}
