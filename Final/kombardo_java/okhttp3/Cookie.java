package okhttp3;

import com.adjust.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000  2\u00020\u0001:\u0001 BQ\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0017¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u0003\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u0004\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u0006\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u0007\u0010\u0017R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\b\u0010\u0017R\u0017\u0010\n\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\n\u0010\u001fR\u0017\u0010\u000b\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\u000b\u0010\u001fR\u0017\u0010\f\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\f\u0010\u001fR\u0017\u0010\r\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\r\u0010\u001f¨\u0006!"}, d2 = {"Lokhttp3/Cookie;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "name", "value", BuildConfig.FLAVOR, "expiresAt", "domain", "path", BuildConfig.FLAVOR, "secure", "httpOnly", "persistent", "hostOnly", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZ)V", "other", "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", "toString", "()Ljava/lang/String;", "forObsoleteRfc2965", "toString$okhttp", "(Z)Ljava/lang/String;", "Ljava/lang/String;", "J", "()J", "Z", "()Z", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Cookie {
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ)\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0004H\u0000¢\u0006\u0004\b \u0010!J%\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0$2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\"H\u0007¢\u0006\u0004\b%\u0010&R\u001c\u0010)\u001a\n (*\u0004\u0018\u00010'0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001c\u0010+\u001a\n (*\u0004\u0018\u00010'0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010*R\u001c\u0010,\u001a\n (*\u0004\u0018\u00010'0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010*R\u001c\u0010-\u001a\n (*\u0004\u0018\u00010'0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010*¨\u0006."}, d2 = {"Lokhttp3/Cookie$Companion;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "urlHost", "domain", BuildConfig.FLAVOR, "domainMatch", "(Ljava/lang/String;Ljava/lang/String;)Z", "s", BuildConfig.FLAVOR, "pos", "limit", BuildConfig.FLAVOR, "parseExpires", "(Ljava/lang/String;II)J", "input", "invert", "dateCharacterOffset", "(Ljava/lang/String;IIZ)I", "parseMaxAge", "(Ljava/lang/String;)J", "parseDomain", "(Ljava/lang/String;)Ljava/lang/String;", "Lokhttp3/HttpUrl;", "url", "setCookie", "Lokhttp3/Cookie;", "parse", "(Lokhttp3/HttpUrl;Ljava/lang/String;)Lokhttp3/Cookie;", "currentTimeMillis", "parse$okhttp", "(JLokhttp3/HttpUrl;Ljava/lang/String;)Lokhttp3/Cookie;", "Lokhttp3/Headers;", "headers", BuildConfig.FLAVOR, "parseAll", "(Lokhttp3/HttpUrl;Lokhttp3/Headers;)Ljava/util/List;", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "DAY_OF_MONTH_PATTERN", "Ljava/util/regex/Pattern;", "MONTH_PATTERN", "TIME_PATTERN", "YEAR_PATTERN", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int dateCharacterOffset(String input, int pos, int limit, boolean invert) {
            while (pos < limit) {
                int i5 = pos + 1;
                char charAt = input.charAt(pos);
                if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt <= '9' && '0' <= charAt) || ((charAt <= 'z' && 'a' <= charAt) || ((charAt <= 'Z' && 'A' <= charAt) || charAt == ':'))) == (!invert)) {
                    return pos;
                }
                pos = i5;
            }
            return limit;
        }

        private final boolean domainMatch(String urlHost, String domain) {
            if (Intrinsics.areEqual(urlHost, domain)) {
                return true;
            }
            return StringsKt.endsWith$default(urlHost, domain, false, 2, (Object) null) && urlHost.charAt((urlHost.length() - domain.length()) - 1) == '.' && !Util.canParseAsIpAddress(urlHost);
        }

        private final String parseDomain(String s5) {
            if (StringsKt.endsWith$default(s5, ".", false, 2, (Object) null)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            String canonicalHost = HostnamesKt.toCanonicalHost(StringsKt.removePrefix(s5, "."));
            if (canonicalHost != null) {
                return canonicalHost;
            }
            throw new IllegalArgumentException();
        }

        private final long parseExpires(String s5, int pos, int limit) {
            int dateCharacterOffset = dateCharacterOffset(s5, pos, limit, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(s5);
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            int i10 = -1;
            while (dateCharacterOffset < limit) {
                int dateCharacterOffset2 = dateCharacterOffset(s5, dateCharacterOffset + 1, limit, true);
                matcher.region(dateCharacterOffset, dateCharacterOffset2);
                if (i6 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String group = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group, "matcher.group(1)");
                    i6 = Integer.parseInt(group);
                    String group2 = matcher.group(2);
                    Intrinsics.checkNotNullExpressionValue(group2, "matcher.group(2)");
                    i9 = Integer.parseInt(group2);
                    String group3 = matcher.group(3);
                    Intrinsics.checkNotNullExpressionValue(group3, "matcher.group(3)");
                    i10 = Integer.parseInt(group3);
                } else if (i7 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String group4 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group4, "matcher.group(1)");
                    i7 = Integer.parseInt(group4);
                } else if (i8 == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String group5 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group5, "matcher.group(1)");
                    Locale US = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(US, "US");
                    String lowerCase = group5.toLowerCase(US);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    String pattern = Cookie.MONTH_PATTERN.pattern();
                    Intrinsics.checkNotNullExpressionValue(pattern, "MONTH_PATTERN.pattern()");
                    i8 = StringsKt.indexOf$default((CharSequence) pattern, lowerCase, 0, false, 6, (Object) null) / 4;
                } else if (i5 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String group6 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group6, "matcher.group(1)");
                    i5 = Integer.parseInt(group6);
                }
                dateCharacterOffset = dateCharacterOffset(s5, dateCharacterOffset2 + 1, limit, false);
            }
            if (70 <= i5 && i5 < 100) {
                i5 += 1900;
            }
            if (i5 >= 0 && i5 < 70) {
                i5 += 2000;
            }
            if (i5 < 1601) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i8 == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (1 > i7 || i7 >= 32) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i6 < 0 || i6 >= 24) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i9 < 0 || i9 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i10 < 0 || i10 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i5);
            gregorianCalendar.set(2, i8 - 1);
            gregorianCalendar.set(5, i7);
            gregorianCalendar.set(11, i6);
            gregorianCalendar.set(12, i9);
            gregorianCalendar.set(13, i10);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        private final long parseMaxAge(String s5) {
            try {
                long parseLong = Long.parseLong(s5);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e5) {
                if (new Regex("-?\\d+").matches(s5)) {
                    return StringsKt.startsWith$default(s5, "-", false, 2, (Object) null) ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e5;
            }
        }

        public final Cookie parse(HttpUrl url, String setCookie) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(setCookie, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), url, setCookie);
        }

        /* JADX WARN: Code restructure failed: missing block: B:83:0x00fd, code lost:
        
            if (r1 > 253402300799999L) goto L56;
         */
        /* JADX WARN: Removed duplicated region for block: B:54:0x010f  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0155  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0112  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Cookie parse$okhttp(long currentTimeMillis, HttpUrl url, String setCookie) {
            long j5;
            String host;
            Cookie cookie;
            String str;
            String str2;
            String str3;
            int lastIndexOf$default;
            String str4;
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(setCookie, "setCookie");
            int delimiterOffset$default = Util.delimiterOffset$default(setCookie, ';', 0, 0, 6, null);
            int delimiterOffset$default2 = Util.delimiterOffset$default(setCookie, '=', 0, delimiterOffset$default, 2, null);
            if (delimiterOffset$default2 == delimiterOffset$default) {
                return null;
            }
            String trimSubstring$default = Util.trimSubstring$default(setCookie, 0, delimiterOffset$default2, 1, null);
            if (trimSubstring$default.length() == 0 || Util.indexOfControlOrNonAscii(trimSubstring$default) != -1) {
                return null;
            }
            String trimSubstring = Util.trimSubstring(setCookie, delimiterOffset$default2 + 1, delimiterOffset$default);
            if (Util.indexOfControlOrNonAscii(trimSubstring) != -1) {
                return null;
            }
            int i5 = delimiterOffset$default + 1;
            int length = setCookie.length();
            String str5 = null;
            String str6 = null;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = true;
            long j6 = -1;
            long j7 = 253402300799999L;
            while (i5 < length) {
                int delimiterOffset = Util.delimiterOffset(setCookie, ';', i5, length);
                int delimiterOffset2 = Util.delimiterOffset(setCookie, '=', i5, delimiterOffset);
                String trimSubstring2 = Util.trimSubstring(setCookie, i5, delimiterOffset2);
                String trimSubstring3 = delimiterOffset2 < delimiterOffset ? Util.trimSubstring(setCookie, delimiterOffset2 + 1, delimiterOffset) : BuildConfig.FLAVOR;
                if (StringsKt.equals(trimSubstring2, "expires", true)) {
                    try {
                        j7 = parseExpires(trimSubstring3, 0, trimSubstring3.length());
                    } catch (NumberFormatException | IllegalArgumentException unused) {
                    }
                } else if (StringsKt.equals(trimSubstring2, "max-age", true)) {
                    j6 = parseMaxAge(trimSubstring3);
                } else {
                    if (StringsKt.equals(trimSubstring2, "domain", true)) {
                        str5 = parseDomain(trimSubstring3);
                        z8 = false;
                    } else if (StringsKt.equals(trimSubstring2, "path", true)) {
                        str6 = trimSubstring3;
                    } else if (StringsKt.equals(trimSubstring2, "secure", true)) {
                        z5 = true;
                    } else if (StringsKt.equals(trimSubstring2, "httponly", true)) {
                        z6 = true;
                    }
                    i5 = delimiterOffset + 1;
                }
                z7 = true;
                i5 = delimiterOffset + 1;
            }
            long j8 = Long.MIN_VALUE;
            if (j6 != Long.MIN_VALUE) {
                if (j6 != -1) {
                    j8 = currentTimeMillis + (j6 <= 9223372036854775L ? j6 * Constants.ONE_SECOND : Long.MAX_VALUE);
                    long j9 = j8 >= currentTimeMillis ? 253402300799999L : 253402300799999L;
                    j5 = j9;
                } else {
                    j5 = j7;
                }
                host = url.getHost();
                if (str5 != null) {
                    str = host;
                    cookie = null;
                } else {
                    if (!domainMatch(host, str5)) {
                        return null;
                    }
                    cookie = null;
                    str = str5;
                }
                if (host.length() == str.length() && PublicSuffixDatabase.INSTANCE.get().getEffectiveTldPlusOne(str) == null) {
                    return cookie;
                }
                str2 = "/";
                str3 = str6;
                if (str3 == null && StringsKt.startsWith$default(str3, "/", false, 2, (Object) cookie)) {
                    str4 = str3;
                } else {
                    String encodedPath = url.encodedPath();
                    lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) encodedPath, '/', 0, false, 6, (Object) null);
                    if (lastIndexOf$default != 0) {
                        str2 = encodedPath.substring(0, lastIndexOf$default);
                        Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String…ing(startIndex, endIndex)");
                    }
                    str4 = str2;
                }
                return new Cookie(trimSubstring$default, trimSubstring, j5, str, str4, z5, z6, z7, z8, null);
            }
            j5 = j8;
            host = url.getHost();
            if (str5 != null) {
            }
            if (host.length() == str.length()) {
            }
            str2 = "/";
            str3 = str6;
            if (str3 == null) {
            }
            String encodedPath2 = url.encodedPath();
            lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) encodedPath2, '/', 0, false, 6, (Object) null);
            if (lastIndexOf$default != 0) {
            }
            str4 = str2;
            return new Cookie(trimSubstring$default, trimSubstring, j5, str, str4, z5, z6, z7, z8, null);
        }

        public final List<Cookie> parseAll(HttpUrl url, Headers headers) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(headers, "headers");
            List<String> values = headers.values("Set-Cookie");
            int size = values.size();
            ArrayList arrayList = null;
            int i5 = 0;
            while (i5 < size) {
                int i6 = i5 + 1;
                Cookie parse = parse(url, values.get(i5));
                if (parse != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(parse);
                }
                i5 = i6;
            }
            if (arrayList == null) {
                return CollectionsKt.emptyList();
            }
            List<Cookie> unmodifiableList = Collections.unmodifiableList(arrayList);
            Intrinsics.checkNotNullExpressionValue(unmodifiableList, "{\n        Collections.un…ableList(cookies)\n      }");
            return unmodifiableList;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Cookie(String str, String str2, long j5, String str3, String str4, boolean z5, boolean z6, boolean z7, boolean z8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j5, str3, str4, z5, z6, z7, z8);
    }

    /* renamed from: domain, reason: from getter */
    public final String getDomain() {
        return this.domain;
    }

    public boolean equals(Object other) {
        if (other instanceof Cookie) {
            Cookie cookie = (Cookie) other;
            if (Intrinsics.areEqual(cookie.name, this.name) && Intrinsics.areEqual(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && Intrinsics.areEqual(cookie.domain, this.domain) && Intrinsics.areEqual(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: expiresAt, reason: from getter */
    public final long getExpiresAt() {
        return this.expiresAt;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return ((((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + Long.hashCode(this.expiresAt)) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + Boolean.hashCode(this.secure)) * 31) + Boolean.hashCode(this.httpOnly)) * 31) + Boolean.hashCode(this.persistent)) * 31) + Boolean.hashCode(this.hostOnly);
    }

    /* renamed from: hostOnly, reason: from getter */
    public final boolean getHostOnly() {
        return this.hostOnly;
    }

    /* renamed from: httpOnly, reason: from getter */
    public final boolean getHttpOnly() {
        return this.httpOnly;
    }

    /* renamed from: name, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: path, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: persistent, reason: from getter */
    public final boolean getPersistent() {
        return this.persistent;
    }

    /* renamed from: secure, reason: from getter */
    public final boolean getSecure() {
        return this.secure;
    }

    public String toString() {
        return toString$okhttp(false);
    }

    public final String toString$okhttp(boolean forObsoleteRfc2965) {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append('=');
        sb.append(getValue());
        if (getPersistent()) {
            if (getExpiresAt() == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(DatesKt.toHttpDateString(new Date(getExpiresAt())));
            }
        }
        if (!getHostOnly()) {
            sb.append("; domain=");
            if (forObsoleteRfc2965) {
                sb.append(".");
            }
            sb.append(getDomain());
        }
        sb.append("; path=");
        sb.append(getPath());
        if (getSecure()) {
            sb.append("; secure");
        }
        if (getHttpOnly()) {
            sb.append("; httponly");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString()");
        return sb2;
    }

    /* renamed from: value, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    private Cookie(String str, String str2, long j5, String str3, String str4, boolean z5, boolean z6, boolean z7, boolean z8) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j5;
        this.domain = str3;
        this.path = str4;
        this.secure = z5;
        this.httpOnly = z6;
        this.persistent = z7;
        this.hostOnly = z8;
    }
}
