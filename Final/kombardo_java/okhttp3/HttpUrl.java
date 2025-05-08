package okhttp3;

import com.adjust.sdk.Constants;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okio.Buffer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u0000 52\u00020\u0001:\u000265Bc\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\r\u0010\u0011J\u000f\u0010\u0016\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0007H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0002H\u0016¢\u0006\u0004\b&\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b\u0003\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010'\u001a\u0004\b\u0004\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b\u0005\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010'\u001a\u0004\b\u0006\u0010\u0018R\u0017\u0010\b\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b\b\u0010%R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0007¢\u0006\f\n\u0004\b\n\u0010)\u001a\u0004\b\n\u0010*R\u001e\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010)R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\f\u0010'\u001a\u0004\b\f\u0010\u0018R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010'R\u0017\u0010+\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b+\u0010-R\u0011\u0010.\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b.\u0010\u0018R\u0011\u0010/\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b/\u0010\u0018R\u0011\u00100\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b0\u0010\u0018R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020\t8G¢\u0006\u0006\u001a\u0004\b1\u0010*R\u0013\u00102\u001a\u0004\u0018\u00010\u00028G¢\u0006\u0006\u001a\u0004\b2\u0010\u0018R\u0013\u00103\u001a\u0004\u0018\u00010\u00028G¢\u0006\u0006\u001a\u0004\b3\u0010\u0018R\u0013\u00104\u001a\u0004\u0018\u00010\u00028G¢\u0006\u0006\u001a\u0004\b4\u0010\u0018¨\u00067"}, d2 = {"Lokhttp3/HttpUrl;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "scheme", "username", "password", "host", BuildConfig.FLAVOR, "port", BuildConfig.FLAVOR, "pathSegments", "queryNamesAndValues", "fragment", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "Ljava/net/URL;", "()Ljava/net/URL;", "toUrl", "Ljava/net/URI;", "uri", "()Ljava/net/URI;", "toUri", "redact", "()Ljava/lang/String;", "link", "resolve", "(Ljava/lang/String;)Lokhttp3/HttpUrl;", "Lokhttp3/HttpUrl$Builder;", "newBuilder", "()Lokhttp3/HttpUrl$Builder;", "(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "I", "Ljava/util/List;", "()Ljava/util/List;", "isHttps", "Z", "()Z", "encodedUsername", "encodedPassword", "encodedPath", "encodedPathSegments", "encodedQuery", "query", "encodedFragment", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HttpUrl {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final String fragment;
    private final String host;
    private final boolean isHttps;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010!\n\u0002\b\r\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ7\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u0015\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u0019J\u0015\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u001f\u0010\u0019J\u0017\u0010 \u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b \u0010\u0019J\u001f\u0010#\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b#\u0010$J\u001f\u0010'\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b'\u0010$J\u0017\u0010(\u001a\u00020\u00002\b\u0010(\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b(\u0010\u0019J\u000f\u0010+\u001a\u00020\u0000H\u0000¢\u0006\u0004\b)\u0010*J\r\u0010-\u001a\u00020,¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0007H\u0016¢\u0006\u0004\b/\u00100J!\u00104\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010,2\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b2\u00103R$\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0018\u00105\u001a\u0004\b6\u00100\"\u0004\b7\u00108R\"\u00109\u001a\u00020\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b9\u00105\u001a\u0004\b:\u00100\"\u0004\b;\u00108R\"\u0010<\u001a\u00020\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b<\u00105\u001a\u0004\b=\u00100\"\u0004\b>\u00108R$\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001c\u00105\u001a\u0004\b?\u00100\"\u0004\b@\u00108R\"\u0010\u001d\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010A\u001a\u0004\bB\u0010\u0006\"\u0004\bC\u0010DR \u0010F\u001a\b\u0012\u0004\u0012\u00020\u00070E8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR,\u0010J\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010E8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bJ\u0010G\u001a\u0004\bK\u0010I\"\u0004\bL\u0010MR$\u0010N\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bN\u00105\u001a\u0004\bO\u00100\"\u0004\bP\u00108¨\u0006R"}, d2 = {"Lokhttp3/HttpUrl$Builder;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "effectivePort", "()I", BuildConfig.FLAVOR, "input", "startPos", "limit", BuildConfig.FLAVOR, "resolvePath", "(Ljava/lang/String;II)V", "pos", BuildConfig.FLAVOR, "addTrailingSlash", "alreadyEncoded", Constants.PUSH, "(Ljava/lang/String;IIZZ)V", "isDot", "(Ljava/lang/String;)Z", "isDotDot", "pop", "scheme", "(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", "username", "password", "host", "port", "(I)Lokhttp3/HttpUrl$Builder;", "query", "encodedQuery", "name", "value", "addQueryParameter", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", "encodedName", "encodedValue", "addEncodedQueryParameter", "fragment", "reencodeForUri$okhttp", "()Lokhttp3/HttpUrl$Builder;", "reencodeForUri", "Lokhttp3/HttpUrl;", "build", "()Lokhttp3/HttpUrl;", "toString", "()Ljava/lang/String;", "base", "parse$okhttp", "(Lokhttp3/HttpUrl;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", "parse", "Ljava/lang/String;", "getScheme$okhttp", "setScheme$okhttp", "(Ljava/lang/String;)V", "encodedUsername", "getEncodedUsername$okhttp", "setEncodedUsername$okhttp", "encodedPassword", "getEncodedPassword$okhttp", "setEncodedPassword$okhttp", "getHost$okhttp", "setHost$okhttp", "I", "getPort$okhttp", "setPort$okhttp", "(I)V", BuildConfig.FLAVOR, "encodedPathSegments", "Ljava/util/List;", "getEncodedPathSegments$okhttp", "()Ljava/util/List;", "encodedQueryNamesAndValues", "getEncodedQueryNamesAndValues$okhttp", "setEncodedQueryNamesAndValues$okhttp", "(Ljava/util/List;)V", "encodedFragment", "getEncodedFragment$okhttp", "setEncodedFragment$okhttp", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Builder {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private String encodedFragment;
        private final List<String> encodedPathSegments;
        private List<String> encodedQueryNamesAndValues;
        private String host;
        private String scheme;
        private String encodedUsername = BuildConfig.FLAVOR;
        private String encodedPassword = BuildConfig.FLAVOR;
        private int port = -1;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u001c\u0010\f\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokhttp3/HttpUrl$Builder$Companion;", BuildConfig.FLAVOR, "()V", "INVALID_HOST", BuildConfig.FLAVOR, "parsePort", BuildConfig.FLAVOR, "input", "pos", "limit", "portColonOffset", "schemeDelimiterOffset", "slashCount", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int parsePort(String input, int pos, int limit) {
                try {
                    int parseInt = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, input, pos, limit, BuildConfig.FLAVOR, false, false, false, false, null, 248, null));
                    if (1 > parseInt || parseInt >= 65536) {
                        return -1;
                    }
                    return parseInt;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int portColonOffset(String input, int pos, int limit) {
                while (pos < limit) {
                    char charAt = input.charAt(pos);
                    if (charAt != '[') {
                        if (charAt == ':') {
                            return pos;
                        }
                        pos++;
                    }
                    do {
                        pos++;
                        if (pos < limit) {
                        }
                        pos++;
                    } while (input.charAt(pos) != ']');
                    pos++;
                }
                return limit;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int schemeDelimiterOffset(String input, int pos, int limit) {
                if (limit - pos < 2) {
                    return -1;
                }
                char charAt = input.charAt(pos);
                if ((Intrinsics.compare((int) charAt, 97) < 0 || Intrinsics.compare((int) charAt, 122) > 0) && (Intrinsics.compare((int) charAt, 65) < 0 || Intrinsics.compare((int) charAt, 90) > 0)) {
                    return -1;
                }
                int i5 = pos + 1;
                while (i5 < limit) {
                    int i6 = i5 + 1;
                    char charAt2 = input.charAt(i5);
                    if (('a' > charAt2 || charAt2 >= '{') && (('A' > charAt2 || charAt2 >= '[') && !(('0' <= charAt2 && charAt2 < ':') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                        if (charAt2 == ':') {
                            return i5;
                        }
                        return -1;
                    }
                    i5 = i6;
                }
                return -1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int slashCount(String str, int i5, int i6) {
                int i7 = 0;
                while (i5 < i6) {
                    int i8 = i5 + 1;
                    char charAt = str.charAt(i5);
                    if (charAt != '\\' && charAt != '/') {
                        break;
                    }
                    i7++;
                    i5 = i8;
                }
                return i7;
            }

            private Companion() {
            }
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add(BuildConfig.FLAVOR);
        }

        private final int effectivePort() {
            int i5 = this.port;
            if (i5 != -1) {
                return i5;
            }
            Companion companion = HttpUrl.INSTANCE;
            String str = this.scheme;
            Intrinsics.checkNotNull(str);
            return companion.defaultPort(str);
        }

        private final boolean isDot(String input) {
            return Intrinsics.areEqual(input, ".") || StringsKt.equals(input, "%2e", true);
        }

        private final boolean isDotDot(String input) {
            return Intrinsics.areEqual(input, "..") || StringsKt.equals(input, "%2e.", true) || StringsKt.equals(input, ".%2e", true) || StringsKt.equals(input, "%2e%2e", true);
        }

        private final void pop() {
            if (this.encodedPathSegments.remove(r0.size() - 1).length() != 0 || this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add(BuildConfig.FLAVOR);
            } else {
                this.encodedPathSegments.set(r0.size() - 1, BuildConfig.FLAVOR);
            }
        }

        private final void push(String input, int pos, int limit, boolean addTrailingSlash, boolean alreadyEncoded) {
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, input, pos, limit, " \"<>^`{}|/\\?#", alreadyEncoded, false, false, false, null, 240, null);
            if (isDot(canonicalize$okhttp$default)) {
                return;
            }
            if (isDotDot(canonicalize$okhttp$default)) {
                pop();
                return;
            }
            if (this.encodedPathSegments.get(r2.size() - 1).length() == 0) {
                this.encodedPathSegments.set(r2.size() - 1, canonicalize$okhttp$default);
            } else {
                this.encodedPathSegments.add(canonicalize$okhttp$default);
            }
            if (addTrailingSlash) {
                this.encodedPathSegments.add(BuildConfig.FLAVOR);
            }
        }

        private final void resolvePath(String input, int startPos, int limit) {
            if (startPos == limit) {
                return;
            }
            char charAt = input.charAt(startPos);
            if (charAt == '/' || charAt == '\\') {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add(BuildConfig.FLAVOR);
                startPos++;
            } else {
                List<String> list = this.encodedPathSegments;
                list.set(list.size() - 1, BuildConfig.FLAVOR);
            }
            while (true) {
                int i5 = startPos;
                while (i5 < limit) {
                    startPos = Util.delimiterOffset(input, "/\\", i5, limit);
                    boolean z5 = startPos < limit;
                    push(input, i5, startPos, z5, true);
                    if (z5) {
                        i5 = startPos + 1;
                    }
                }
                return;
            }
        }

        public final Builder addEncodedQueryParameter(String encodedName, String encodedValue) {
            Intrinsics.checkNotNullParameter(encodedName, "encodedName");
            if (getEncodedQueryNamesAndValues$okhttp() == null) {
                setEncodedQueryNamesAndValues$okhttp(new ArrayList());
            }
            List<String> encodedQueryNamesAndValues$okhttp = getEncodedQueryNamesAndValues$okhttp();
            Intrinsics.checkNotNull(encodedQueryNamesAndValues$okhttp);
            Companion companion = HttpUrl.INSTANCE;
            encodedQueryNamesAndValues$okhttp.add(Companion.canonicalize$okhttp$default(companion, encodedName, 0, 0, " \"'<>#&=", true, false, true, false, null, 211, null));
            List<String> encodedQueryNamesAndValues$okhttp2 = getEncodedQueryNamesAndValues$okhttp();
            Intrinsics.checkNotNull(encodedQueryNamesAndValues$okhttp2);
            encodedQueryNamesAndValues$okhttp2.add(encodedValue == null ? null : Companion.canonicalize$okhttp$default(companion, encodedValue, 0, 0, " \"'<>#&=", true, false, true, false, null, 211, null));
            return this;
        }

        public final Builder addQueryParameter(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            if (getEncodedQueryNamesAndValues$okhttp() == null) {
                setEncodedQueryNamesAndValues$okhttp(new ArrayList());
            }
            List<String> encodedQueryNamesAndValues$okhttp = getEncodedQueryNamesAndValues$okhttp();
            Intrinsics.checkNotNull(encodedQueryNamesAndValues$okhttp);
            Companion companion = HttpUrl.INSTANCE;
            encodedQueryNamesAndValues$okhttp.add(Companion.canonicalize$okhttp$default(companion, name, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null));
            List<String> encodedQueryNamesAndValues$okhttp2 = getEncodedQueryNamesAndValues$okhttp();
            Intrinsics.checkNotNull(encodedQueryNamesAndValues$okhttp2);
            encodedQueryNamesAndValues$okhttp2.add(value == null ? null : Companion.canonicalize$okhttp$default(companion, value, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null));
            return this;
        }

        public final HttpUrl build() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            Companion companion = HttpUrl.INSTANCE;
            String percentDecode$okhttp$default = Companion.percentDecode$okhttp$default(companion, this.encodedUsername, 0, 0, false, 7, null);
            String percentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(companion, this.encodedPassword, 0, 0, false, 7, null);
            String str2 = this.host;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int effectivePort = effectivePort();
            List<String> list = this.encodedPathSegments;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(Companion.percentDecode$okhttp$default(HttpUrl.INSTANCE, (String) it.next(), 0, 0, false, 7, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 == null) {
                arrayList = null;
            } else {
                List<String> list3 = list2;
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                for (String str3 : list3) {
                    arrayList.add(str3 == null ? null : Companion.percentDecode$okhttp$default(HttpUrl.INSTANCE, str3, 0, 0, true, 3, null));
                }
            }
            String str4 = this.encodedFragment;
            return new HttpUrl(str, percentDecode$okhttp$default, percentDecode$okhttp$default2, str2, effectivePort, arrayList2, arrayList, str4 == null ? null : Companion.percentDecode$okhttp$default(HttpUrl.INSTANCE, str4, 0, 0, false, 7, null), toString());
        }

        public final Builder encodedQuery(String encodedQuery) {
            List<String> list = null;
            if (encodedQuery != null) {
                Companion companion = HttpUrl.INSTANCE;
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, encodedQuery, 0, 0, " \"'<>#", true, false, true, false, null, 211, null);
                if (canonicalize$okhttp$default != null) {
                    list = companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
                }
            }
            setEncodedQueryNamesAndValues$okhttp(list);
            return this;
        }

        public final Builder fragment(String fragment) {
            setEncodedFragment$okhttp(fragment == null ? null : Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, fragment, 0, 0, BuildConfig.FLAVOR, false, false, false, true, null, 187, null));
            return this;
        }

        /* renamed from: getEncodedFragment$okhttp, reason: from getter */
        public final String getEncodedFragment() {
            return this.encodedFragment;
        }

        /* renamed from: getEncodedPassword$okhttp, reason: from getter */
        public final String getEncodedPassword() {
            return this.encodedPassword;
        }

        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        /* renamed from: getEncodedUsername$okhttp, reason: from getter */
        public final String getEncodedUsername() {
            return this.encodedUsername;
        }

        /* renamed from: getHost$okhttp, reason: from getter */
        public final String getHost() {
            return this.host;
        }

        /* renamed from: getPort$okhttp, reason: from getter */
        public final int getPort() {
            return this.port;
        }

        /* renamed from: getScheme$okhttp, reason: from getter */
        public final String getScheme() {
            return this.scheme;
        }

        public final Builder host(String host) {
            Intrinsics.checkNotNullParameter(host, "host");
            String canonicalHost = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.INSTANCE, host, 0, 0, false, 7, null));
            if (canonicalHost == null) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected host: ", host));
            }
            setHost$okhttp(canonicalHost);
            return this;
        }

        public final Builder parse$okhttp(HttpUrl base, String input) {
            int delimiterOffset;
            int i5;
            int i6;
            boolean z5;
            int i7;
            boolean z6;
            String input2 = input;
            Intrinsics.checkNotNullParameter(input2, "input");
            int indexOfFirstNonAsciiWhitespace$default = Util.indexOfFirstNonAsciiWhitespace$default(input2, 0, 0, 3, null);
            int indexOfLastNonAsciiWhitespace$default = Util.indexOfLastNonAsciiWhitespace$default(input2, indexOfFirstNonAsciiWhitespace$default, 0, 2, null);
            Companion companion = INSTANCE;
            int schemeDelimiterOffset = companion.schemeDelimiterOffset(input2, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            boolean z7 = true;
            char c5 = 65535;
            if (schemeDelimiterOffset != -1) {
                if (StringsKt.startsWith(input2, "https:", indexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = Constants.SCHEME;
                    indexOfFirstNonAsciiWhitespace$default += 6;
                } else {
                    if (!StringsKt.startsWith(input2, "http:", indexOfFirstNonAsciiWhitespace$default, true)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected URL scheme 'http' or 'https' but was '");
                        String substring = input2.substring(0, schemeDelimiterOffset);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb.append(substring);
                        sb.append('\'');
                        throw new IllegalArgumentException(sb.toString());
                    }
                    this.scheme = "http";
                    indexOfFirstNonAsciiWhitespace$default += 5;
                }
            } else {
                if (base == null) {
                    if (input.length() > 6) {
                        input2 = Intrinsics.stringPlus(StringsKt.take(input2, 6), "...");
                    }
                    throw new IllegalArgumentException(Intrinsics.stringPlus("Expected URL scheme 'http' or 'https' but no scheme was found for ", input2));
                }
                this.scheme = base.getScheme();
            }
            int slashCount = companion.slashCount(input2, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            char c6 = '?';
            char c7 = '#';
            if (slashCount >= 2 || base == null || !Intrinsics.areEqual(base.getScheme(), this.scheme)) {
                boolean z8 = false;
                boolean z9 = false;
                int i8 = indexOfFirstNonAsciiWhitespace$default + slashCount;
                while (true) {
                    delimiterOffset = Util.delimiterOffset(input2, "@/\\?#", i8, indexOfLastNonAsciiWhitespace$default);
                    char charAt = delimiterOffset != indexOfLastNonAsciiWhitespace$default ? input2.charAt(delimiterOffset) : c5;
                    if (charAt == c5 || charAt == c7 || charAt == '/' || charAt == '\\' || charAt == c6) {
                        break;
                    }
                    if (charAt == '@') {
                        if (z8) {
                            i6 = delimiterOffset;
                            z5 = z7;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.encodedPassword);
                            sb2.append("%40");
                            i7 = indexOfLastNonAsciiWhitespace$default;
                            sb2.append(Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, input, i8, i6, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
                            this.encodedPassword = sb2.toString();
                        } else {
                            int delimiterOffset2 = Util.delimiterOffset(input2, ':', i8, delimiterOffset);
                            Companion companion2 = HttpUrl.INSTANCE;
                            z5 = z7;
                            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion2, input, i8, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z9) {
                                canonicalize$okhttp$default = this.encodedUsername + "%40" + canonicalize$okhttp$default;
                            }
                            this.encodedUsername = canonicalize$okhttp$default;
                            if (delimiterOffset2 != delimiterOffset) {
                                i6 = delimiterOffset;
                                this.encodedPassword = Companion.canonicalize$okhttp$default(companion2, input, delimiterOffset2 + 1, delimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z6 = z5;
                            } else {
                                i6 = delimiterOffset;
                                z6 = z8;
                            }
                            z8 = z6;
                            i7 = indexOfLastNonAsciiWhitespace$default;
                            z9 = z5;
                        }
                        i8 = i6 + 1;
                        z7 = z5;
                        indexOfLastNonAsciiWhitespace$default = i7;
                        c7 = '#';
                        c6 = '?';
                        c5 = 65535;
                    }
                }
                i5 = indexOfLastNonAsciiWhitespace$default;
                Companion companion3 = INSTANCE;
                int portColonOffset = companion3.portColonOffset(input2, i8, delimiterOffset);
                int i9 = portColonOffset + 1;
                if (i9 < delimiterOffset) {
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.INSTANCE, input, i8, portColonOffset, false, 4, null));
                    int parsePort = companion3.parsePort(input2, i9, delimiterOffset);
                    this.port = parsePort;
                    if (parsePort == -1) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Invalid URL port: \"");
                        String substring2 = input2.substring(i9, delimiterOffset);
                        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb3.append(substring2);
                        sb3.append('\"');
                        throw new IllegalArgumentException(sb3.toString().toString());
                    }
                } else {
                    Companion companion4 = HttpUrl.INSTANCE;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(companion4, input, i8, portColonOffset, false, 4, null));
                    String str = this.scheme;
                    Intrinsics.checkNotNull(str);
                    this.port = companion4.defaultPort(str);
                }
                if (this.host == null) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Invalid URL host: \"");
                    String substring3 = input2.substring(i8, portColonOffset);
                    Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    sb4.append(substring3);
                    sb4.append('\"');
                    throw new IllegalArgumentException(sb4.toString().toString());
                }
                indexOfFirstNonAsciiWhitespace$default = delimiterOffset;
            } else {
                this.encodedUsername = base.encodedUsername();
                this.encodedPassword = base.encodedPassword();
                this.host = base.getHost();
                this.port = base.getPort();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(base.encodedPathSegments());
                if (indexOfFirstNonAsciiWhitespace$default == indexOfLastNonAsciiWhitespace$default || input2.charAt(indexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(base.encodedQuery());
                }
                i5 = indexOfLastNonAsciiWhitespace$default;
            }
            int i10 = i5;
            int delimiterOffset3 = Util.delimiterOffset(input2, "?#", indexOfFirstNonAsciiWhitespace$default, i10);
            resolvePath(input2, indexOfFirstNonAsciiWhitespace$default, delimiterOffset3);
            if (delimiterOffset3 < i10 && input2.charAt(delimiterOffset3) == '?') {
                int delimiterOffset4 = Util.delimiterOffset(input2, '#', delimiterOffset3, i10);
                Companion companion5 = HttpUrl.INSTANCE;
                this.encodedQueryNamesAndValues = companion5.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(companion5, input, delimiterOffset3 + 1, delimiterOffset4, " \"'<>#", true, false, true, false, null, 208, null));
                delimiterOffset3 = delimiterOffset4;
            }
            if (delimiterOffset3 < i10 && input2.charAt(delimiterOffset3) == '#') {
                this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, input, delimiterOffset3 + 1, i10, BuildConfig.FLAVOR, true, false, false, true, null, 176, null);
            }
            return this;
        }

        public final Builder password(String password) {
            Intrinsics.checkNotNullParameter(password, "password");
            setEncodedPassword$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null));
            return this;
        }

        public final Builder port(int port) {
            if (1 > port || port >= 65536) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected port: ", Integer.valueOf(port)).toString());
            }
            setPort$okhttp(port);
            return this;
        }

        public final Builder query(String query) {
            List<String> list = null;
            if (query != null) {
                Companion companion = HttpUrl.INSTANCE;
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, query, 0, 0, " \"'<>#", false, false, true, false, null, 219, null);
                if (canonicalize$okhttp$default != null) {
                    list = companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
                }
            }
            setEncodedQueryNamesAndValues$okhttp(list);
            return this;
        }

        public final Builder reencodeForUri$okhttp() {
            String host = getHost();
            setHost$okhttp(host == null ? null : new Regex("[\"<>^`{|}]").replace(host, BuildConfig.FLAVOR));
            int size = getEncodedPathSegments$okhttp().size();
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                getEncodedPathSegments$okhttp().set(i6, Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, getEncodedPathSegments$okhttp().get(i6), 0, 0, "[]", true, true, false, false, null, 227, null));
            }
            List<String> encodedQueryNamesAndValues$okhttp = getEncodedQueryNamesAndValues$okhttp();
            if (encodedQueryNamesAndValues$okhttp != null) {
                int size2 = encodedQueryNamesAndValues$okhttp.size();
                while (i5 < size2) {
                    int i7 = i5 + 1;
                    String str = encodedQueryNamesAndValues$okhttp.get(i5);
                    encodedQueryNamesAndValues$okhttp.set(i5, str == null ? null : Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, str, 0, 0, "\\^`{|}", true, true, true, false, null, 195, null));
                    i5 = i7;
                }
            }
            String encodedFragment = getEncodedFragment();
            setEncodedFragment$okhttp(encodedFragment != null ? Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, encodedFragment, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, 163, null) : null);
            return this;
        }

        public final Builder scheme(String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            if (StringsKt.equals(scheme, "http", true)) {
                setScheme$okhttp("http");
            } else {
                if (!StringsKt.equals(scheme, Constants.SCHEME, true)) {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected scheme: ", scheme));
                }
                setScheme$okhttp(Constants.SCHEME);
            }
            return this;
        }

        public final void setEncodedFragment$okhttp(String str) {
            this.encodedFragment = str;
        }

        public final void setEncodedPassword$okhttp(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.encodedPassword = str;
        }

        public final void setEncodedQueryNamesAndValues$okhttp(List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        public final void setEncodedUsername$okhttp(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final void setHost$okhttp(String str) {
            this.host = str;
        }

        public final void setPort$okhttp(int i5) {
            this.port = i5;
        }

        public final void setScheme$okhttp(String str) {
            this.scheme = str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x00a7, code lost:
        
            if (r1 != r3.defaultPort(r4)) goto L29;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (getScheme() != null) {
                sb.append(getScheme());
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (getEncodedUsername().length() > 0 || getEncodedPassword().length() > 0) {
                sb.append(getEncodedUsername());
                if (getEncodedPassword().length() > 0) {
                    sb.append(':');
                    sb.append(getEncodedPassword());
                }
                sb.append('@');
            }
            if (getHost() != null) {
                String host = getHost();
                Intrinsics.checkNotNull(host);
                if (StringsKt.contains$default((CharSequence) host, ':', false, 2, (Object) null)) {
                    sb.append('[');
                    sb.append(getHost());
                    sb.append(']');
                } else {
                    sb.append(getHost());
                }
            }
            if (getPort() != -1 || getScheme() != null) {
                int effectivePort = effectivePort();
                if (getScheme() != null) {
                    Companion companion = HttpUrl.INSTANCE;
                    String scheme = getScheme();
                    Intrinsics.checkNotNull(scheme);
                }
                sb.append(':');
                sb.append(effectivePort);
            }
            Companion companion2 = HttpUrl.INSTANCE;
            companion2.toPathString$okhttp(getEncodedPathSegments$okhttp(), sb);
            if (getEncodedQueryNamesAndValues$okhttp() != null) {
                sb.append('?');
                List<String> encodedQueryNamesAndValues$okhttp = getEncodedQueryNamesAndValues$okhttp();
                Intrinsics.checkNotNull(encodedQueryNamesAndValues$okhttp);
                companion2.toQueryString$okhttp(encodedQueryNamesAndValues$okhttp, sb);
            }
            if (getEncodedFragment() != null) {
                sb.append('#');
                sb.append(getEncodedFragment());
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }

        public final Builder username(String username) {
            Intrinsics.checkNotNullParameter(username, "username");
            setEncodedUsername$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null));
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0019\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\r\u001a\u00020\f*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u000f\u001a\u00020\n*\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J]\u0010\u0018\u001a\u00020\f*\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010#\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u00050\u001d2\n\u0010 \u001a\u00060\u001ej\u0002`\u001fH\u0000¢\u0006\u0004\b!\u0010\"J'\u0010%\u001a\u00020\f*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001d2\n\u0010 \u001a\u00060\u001ej\u0002`\u001fH\u0000¢\u0006\u0004\b$\u0010\"J\u001b\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050&*\u00020\u0005H\u0000¢\u0006\u0004\b'\u0010(J\u0013\u0010-\u001a\u00020**\u00020\u0005H\u0007¢\u0006\u0004\b+\u0010,J\u0015\u0010/\u001a\u0004\u0018\u00010**\u00020\u0005H\u0007¢\u0006\u0004\b.\u0010,J1\u00102\u001a\u00020\u0005*\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b0\u00101Jc\u00105\u001a\u00020\u0005*\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0000¢\u0006\u0004\b3\u00104R\u0014\u00106\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00108\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b8\u00107R\u0014\u00109\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b9\u00107R\u0014\u0010;\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b=\u00107R\u0014\u0010>\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b>\u00107R\u0014\u0010?\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b?\u00107R\u0014\u0010@\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b@\u00107R\u0014\u0010A\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\bA\u00107R\u0014\u0010B\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\bB\u00107R\u0014\u0010C\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\bC\u00107R\u0014\u0010D\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\bD\u00107¨\u0006E"}, d2 = {"Lokhttp3/HttpUrl$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Lokio/Buffer;", BuildConfig.FLAVOR, "encoded", BuildConfig.FLAVOR, "pos", "limit", BuildConfig.FLAVOR, "plusIsSpace", BuildConfig.FLAVOR, "writePercentDecoded", "(Lokio/Buffer;Ljava/lang/String;IIZ)V", "isPercentEncoded", "(Ljava/lang/String;II)Z", "input", "encodeSet", "alreadyEncoded", "strict", "unicodeAllowed", "Ljava/nio/charset/Charset;", "charset", "writeCanonicalized", "(Lokio/Buffer;Ljava/lang/String;IILjava/lang/String;ZZZZLjava/nio/charset/Charset;)V", "scheme", "defaultPort", "(Ljava/lang/String;)I", BuildConfig.FLAVOR, "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "out", "toPathString$okhttp", "(Ljava/util/List;Ljava/lang/StringBuilder;)V", "toPathString", "toQueryString$okhttp", "toQueryString", BuildConfig.FLAVOR, "toQueryNamesAndValues$okhttp", "(Ljava/lang/String;)Ljava/util/List;", "toQueryNamesAndValues", "Lokhttp3/HttpUrl;", "get", "(Ljava/lang/String;)Lokhttp3/HttpUrl;", "toHttpUrl", "parse", "toHttpUrlOrNull", "percentDecode$okhttp", "(Ljava/lang/String;IIZ)Ljava/lang/String;", "percentDecode", "canonicalize$okhttp", "(Ljava/lang/String;IILjava/lang/String;ZZZZLjava/nio/charset/Charset;)Ljava/lang/String;", "canonicalize", "FORM_ENCODE_SET", "Ljava/lang/String;", "FRAGMENT_ENCODE_SET", "FRAGMENT_ENCODE_SET_URI", BuildConfig.FLAVOR, "HEX_DIGITS", "[C", "PASSWORD_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET_URI", "QUERY_COMPONENT_ENCODE_SET", "QUERY_COMPONENT_ENCODE_SET_URI", "QUERY_COMPONENT_REENCODE_SET", "QUERY_ENCODE_SET", "USERNAME_ENCODE_SET", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ String canonicalize$okhttp$default(Companion companion, String str, int i5, int i6, String str2, boolean z5, boolean z6, boolean z7, boolean z8, Charset charset, int i7, Object obj) {
            return companion.canonicalize$okhttp(str, (i7 & 1) != 0 ? 0 : i5, (i7 & 2) != 0 ? str.length() : i6, str2, (i7 & 8) != 0 ? false : z5, (i7 & 16) != 0 ? false : z6, (i7 & 32) != 0 ? false : z7, (i7 & 64) != 0 ? false : z8, (i7 & 128) != 0 ? null : charset);
        }

        private final boolean isPercentEncoded(String str, int i5, int i6) {
            int i7 = i5 + 2;
            return i7 < i6 && str.charAt(i5) == '%' && Util.parseHexDigit(str.charAt(i5 + 1)) != -1 && Util.parseHexDigit(str.charAt(i7)) != -1;
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion companion, String str, int i5, int i6, boolean z5, int i7, Object obj) {
            if ((i7 & 1) != 0) {
                i5 = 0;
            }
            if ((i7 & 2) != 0) {
                i6 = str.length();
            }
            if ((i7 & 4) != 0) {
                z5 = false;
            }
            return companion.percentDecode$okhttp(str, i5, i6, z5);
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x0064, code lost:
        
            if (isPercentEncoded(r16, r5, r18) == false) goto L42;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void writeCanonicalized(Buffer buffer, String str, int i5, int i6, String str2, boolean z5, boolean z6, boolean z7, boolean z8, Charset charset) {
            int i7 = i5;
            Buffer buffer2 = null;
            while (i7 < i6) {
                int codePointAt = str.codePointAt(i7);
                if (!z5 || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                    if (codePointAt == 43 && z7) {
                        buffer.writeUtf8(z5 ? "+" : "%2B");
                    } else {
                        if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || z8)) {
                            if (!StringsKt.contains$default((CharSequence) str2, (char) codePointAt, false, 2, (Object) null)) {
                                if (codePointAt == 37) {
                                    if (z5) {
                                        if (z6) {
                                        }
                                    }
                                }
                                buffer.writeUtf8CodePoint(codePointAt);
                                i7 += Character.charCount(codePointAt);
                            }
                        }
                        if (buffer2 == null) {
                            buffer2 = new Buffer();
                        }
                        if (charset == null || Intrinsics.areEqual(charset, StandardCharsets.UTF_8)) {
                            buffer2.writeUtf8CodePoint(codePointAt);
                        } else {
                            buffer2.writeString(str, i7, Character.charCount(codePointAt) + i7, charset);
                        }
                        while (!buffer2.exhausted()) {
                            byte readByte = buffer2.readByte();
                            buffer.writeByte(37);
                            buffer.writeByte((int) HttpUrl.HEX_DIGITS[((readByte & 255) >> 4) & 15]);
                            buffer.writeByte((int) HttpUrl.HEX_DIGITS[readByte & 15]);
                        }
                        i7 += Character.charCount(codePointAt);
                    }
                }
                i7 += Character.charCount(codePointAt);
            }
        }

        private final void writePercentDecoded(Buffer buffer, String str, int i5, int i6, boolean z5) {
            int i7;
            while (i5 < i6) {
                int codePointAt = str.codePointAt(i5);
                if (codePointAt != 37 || (i7 = i5 + 2) >= i6) {
                    if (codePointAt == 43 && z5) {
                        buffer.writeByte(32);
                        i5++;
                    }
                    buffer.writeUtf8CodePoint(codePointAt);
                    i5 += Character.charCount(codePointAt);
                } else {
                    int parseHexDigit = Util.parseHexDigit(str.charAt(i5 + 1));
                    int parseHexDigit2 = Util.parseHexDigit(str.charAt(i7));
                    if (parseHexDigit != -1 && parseHexDigit2 != -1) {
                        buffer.writeByte((parseHexDigit << 4) + parseHexDigit2);
                        i5 = Character.charCount(codePointAt) + i7;
                    }
                    buffer.writeUtf8CodePoint(codePointAt);
                    i5 += Character.charCount(codePointAt);
                }
            }
        }

        public final String canonicalize$okhttp(String str, int i5, int i6, String encodeSet, boolean z5, boolean z6, boolean z7, boolean z8, Charset charset) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(encodeSet, "encodeSet");
            int i7 = i5;
            while (i7 < i6) {
                int codePointAt = str.codePointAt(i7);
                if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || z8) && !StringsKt.contains$default((CharSequence) encodeSet, (char) codePointAt, false, 2, (Object) null))) {
                    if (codePointAt == 37) {
                        if (z5) {
                            if (z6) {
                                if (!isPercentEncoded(str, i7, i6)) {
                                    Buffer buffer = new Buffer();
                                    buffer.writeUtf8(str, i5, i7);
                                    writeCanonicalized(buffer, str, i7, i6, encodeSet, z5, z6, z7, z8, charset);
                                    return buffer.readUtf8();
                                }
                                if (codePointAt != 43 && z7) {
                                    Buffer buffer2 = new Buffer();
                                    buffer2.writeUtf8(str, i5, i7);
                                    writeCanonicalized(buffer2, str, i7, i6, encodeSet, z5, z6, z7, z8, charset);
                                    return buffer2.readUtf8();
                                }
                                i7 += Character.charCount(codePointAt);
                            }
                        }
                    }
                    if (codePointAt != 43) {
                    }
                    i7 += Character.charCount(codePointAt);
                }
                Buffer buffer22 = new Buffer();
                buffer22.writeUtf8(str, i5, i7);
                writeCanonicalized(buffer22, str, i7, i6, encodeSet, z5, z6, z7, z8, charset);
                return buffer22.readUtf8();
            }
            String substring = str.substring(i5, i6);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }

        public final int defaultPort(String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            if (Intrinsics.areEqual(scheme, "http")) {
                return 80;
            }
            return Intrinsics.areEqual(scheme, Constants.SCHEME) ? 443 : -1;
        }

        public final HttpUrl get(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return new Builder().parse$okhttp(null, str).build();
        }

        public final HttpUrl parse(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final String percentDecode$okhttp(String str, int i5, int i6, boolean z5) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            int i7 = i5;
            while (i7 < i6) {
                int i8 = i7 + 1;
                char charAt = str.charAt(i7);
                if (charAt == '%' || (charAt == '+' && z5)) {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(str, i5, i7);
                    writePercentDecoded(buffer, str, i7, i6, z5);
                    return buffer.readUtf8();
                }
                i7 = i8;
            }
            String substring = str.substring(i5, i6);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }

        public final void toPathString$okhttp(List<String> list, StringBuilder out) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(out, "out");
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                out.append('/');
                out.append(list.get(i5));
            }
        }

        public final List<String> toQueryNamesAndValues$okhttp(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            ArrayList arrayList = new ArrayList();
            int i5 = 0;
            while (i5 <= str.length()) {
                int indexOf$default = StringsKt.indexOf$default((CharSequence) str, '&', i5, false, 4, (Object) null);
                if (indexOf$default == -1) {
                    indexOf$default = str.length();
                }
                int i6 = indexOf$default;
                int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str, '=', i5, false, 4, (Object) null);
                if (indexOf$default2 == -1 || indexOf$default2 > i6) {
                    String substring = str.substring(i5, i6);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring);
                    arrayList.add(null);
                } else {
                    String substring2 = str.substring(i5, indexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring2);
                    String substring3 = str.substring(indexOf$default2 + 1, i6);
                    Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(substring3);
                }
                i5 = i6 + 1;
            }
            return arrayList;
        }

        public final void toQueryString$okhttp(List<String> list, StringBuilder out) {
            Intrinsics.checkNotNullParameter(list, "<this>");
            Intrinsics.checkNotNullParameter(out, "out");
            IntProgression step = RangesKt.step(RangesKt.until(0, list.size()), 2);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 <= 0 || first > last) && (step2 >= 0 || last > first)) {
                return;
            }
            while (true) {
                int i5 = first + step2;
                String str = list.get(first);
                String str2 = list.get(first + 1);
                if (first > 0) {
                    out.append('&');
                }
                out.append(str);
                if (str2 != null) {
                    out.append('=');
                    out.append(str2);
                }
                if (first == last) {
                    return;
                } else {
                    first = i5;
                }
            }
        }

        private Companion() {
        }
    }

    public HttpUrl(String scheme, String username, String password, String host, int i5, List<String> pathSegments, List<String> list, String str, String url) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        Intrinsics.checkNotNullParameter(url, "url");
        this.scheme = scheme;
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = i5;
        this.pathSegments = pathSegments;
        this.queryNamesAndValues = list;
        this.fragment = str;
        this.url = url;
        this.isHttps = Intrinsics.areEqual(scheme, Constants.SCHEME);
    }

    public static final HttpUrl get(String str) {
        return INSTANCE.get(str);
    }

    public static final HttpUrl parse(String str) {
        return INSTANCE.parse(str);
    }

    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        String substring = this.url.substring(StringsKt.indexOf$default((CharSequence) this.url, '#', 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return BuildConfig.FLAVOR;
        }
        String substring = this.url.substring(StringsKt.indexOf$default((CharSequence) this.url, ':', this.scheme.length() + 3, false, 4, (Object) null) + 1, StringsKt.indexOf$default((CharSequence) this.url, '@', 0, false, 6, (Object) null));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final String encodedPath() {
        int indexOf$default = StringsKt.indexOf$default((CharSequence) this.url, '/', this.scheme.length() + 3, false, 4, (Object) null);
        String str = this.url;
        String substring = this.url.substring(indexOf$default, Util.delimiterOffset(str, "?#", indexOf$default, str.length()));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final List<String> encodedPathSegments() {
        int indexOf$default = StringsKt.indexOf$default((CharSequence) this.url, '/', this.scheme.length() + 3, false, 4, (Object) null);
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, "?#", indexOf$default, str.length());
        ArrayList arrayList = new ArrayList();
        while (indexOf$default < delimiterOffset) {
            int i5 = indexOf$default + 1;
            int delimiterOffset2 = Util.delimiterOffset(this.url, '/', i5, delimiterOffset);
            String substring = this.url.substring(i5, delimiterOffset2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(substring);
            indexOf$default = delimiterOffset2;
        }
        return arrayList;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int indexOf$default = StringsKt.indexOf$default((CharSequence) this.url, '?', 0, false, 6, (Object) null) + 1;
        String str = this.url;
        String substring = this.url.substring(indexOf$default, Util.delimiterOffset(str, '#', indexOf$default, str.length()));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return BuildConfig.FLAVOR;
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        String substring = this.url.substring(length, Util.delimiterOffset(str, ":@", length, str.length()));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public boolean equals(Object other) {
        return (other instanceof HttpUrl) && Intrinsics.areEqual(((HttpUrl) other).url, this.url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    /* renamed from: host, reason: from getter */
    public final String getHost() {
        return this.host;
    }

    /* renamed from: isHttps, reason: from getter */
    public final boolean getIsHttps() {
        return this.isHttps;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != INSTANCE.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    /* renamed from: port, reason: from getter */
    public final int getPort() {
        return this.port;
    }

    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        INSTANCE.toQueryString$okhttp(this.queryNamesAndValues, sb);
        return sb.toString();
    }

    public final String redact() {
        Builder newBuilder = newBuilder("/...");
        Intrinsics.checkNotNull(newBuilder);
        return newBuilder.username(BuildConfig.FLAVOR).password(BuildConfig.FLAVOR).build().getUrl();
    }

    public final HttpUrl resolve(String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        Builder newBuilder = newBuilder(link);
        if (newBuilder == null) {
            return null;
        }
        return newBuilder.build();
    }

    /* renamed from: scheme, reason: from getter */
    public final String getScheme() {
        return this.scheme;
    }

    /* renamed from: toString, reason: from getter */
    public String getUrl() {
        return this.url;
    }

    public final URI uri() {
        String builder = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e5) {
            try {
                URI create = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(builder, BuildConfig.FLAVOR));
                Intrinsics.checkNotNullExpressionValue(create, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e5);
            }
        }
    }

    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e5) {
            throw new RuntimeException(e5);
        }
    }

    public final Builder newBuilder(String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        try {
            return new Builder().parse$okhttp(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
