package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001c\u001bBs\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0003\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0004\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0006\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0007\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\b\u0010\u0017R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\t\u0010\u0017R\u0017\u0010\n\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\n\u0010\u0017R\u0017\u0010\u000b\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u000b\u0010\u0019R\u0017\u0010\f\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\f\u0010\u0019R\u0017\u0010\r\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\r\u0010\u0017R\u0017\u0010\u000e\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u000e\u0010\u0017R\u0017\u0010\u000f\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u0016\u001a\u0004\b\u000f\u0010\u0017R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001a¨\u0006\u001d"}, d2 = {"Lokhttp3/CacheControl;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "noCache", "noStore", BuildConfig.FLAVOR, "maxAgeSeconds", "sMaxAgeSeconds", "isPrivate", "isPublic", "mustRevalidate", "maxStaleSeconds", "minFreshSeconds", "onlyIfCached", "noTransform", "immutable", BuildConfig.FLAVOR, "headerValue", "<init>", "(ZZIIZZZIIZZZLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "Z", "()Z", "I", "()I", "Ljava/lang/String;", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CacheControl {
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0000¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\n\u0010\tJ\u001d\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000b\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0000¢\u0006\u0004\b\u000f\u0010\tJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u000f\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0016\u0010\u001a\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014¨\u0006\u001b"}, d2 = {"Lokhttp3/CacheControl$Builder;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "clampToInt", "(J)I", "noCache", "()Lokhttp3/CacheControl$Builder;", "noStore", "maxStale", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "(ILjava/util/concurrent/TimeUnit;)Lokhttp3/CacheControl$Builder;", "onlyIfCached", "Lokhttp3/CacheControl;", "build", "()Lokhttp3/CacheControl;", BuildConfig.FLAVOR, "Z", "maxAgeSeconds", "I", "maxStaleSeconds", "minFreshSeconds", "noTransform", "immutable", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        private final int clampToInt(long j5) {
            if (j5 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) j5;
        }

        public final CacheControl build() {
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, null, null);
        }

        public final Builder maxStale(int maxStale, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            if (maxStale < 0) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("maxStale < 0: ", Integer.valueOf(maxStale)).toString());
            }
            this.maxStaleSeconds = clampToInt(timeUnit.toSeconds(maxStale));
            return this;
        }

        public final Builder noCache() {
            this.noCache = true;
            return this;
        }

        public final Builder noStore() {
            this.noStore = true;
            return this;
        }

        public final Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001e\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\nH\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lokhttp3/CacheControl$Companion;", BuildConfig.FLAVOR, "()V", "FORCE_CACHE", "Lokhttp3/CacheControl;", "FORCE_NETWORK", "parse", "headers", "Lokhttp3/Headers;", "indexOfElement", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "characters", "startIndex", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int indexOfElement(String str, String str2, int i5) {
            int length = str.length();
            while (i5 < length) {
                int i6 = i5 + 1;
                if (StringsKt.contains$default((CharSequence) str2, str.charAt(i5), false, 2, (Object) null)) {
                    return i5;
                }
                i5 = i6;
            }
            return str.length();
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final CacheControl parse(Headers headers) {
            int i5;
            int i6;
            String str;
            Headers headers2 = headers;
            Intrinsics.checkNotNullParameter(headers2, "headers");
            int size = headers.size();
            boolean z5 = true;
            boolean z6 = true;
            int i7 = 0;
            String str2 = null;
            boolean z7 = false;
            boolean z8 = false;
            int i8 = -1;
            int i9 = -1;
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            int i10 = -1;
            int i11 = -1;
            boolean z12 = false;
            boolean z13 = false;
            boolean z14 = false;
            while (i7 < size) {
                int i12 = i7 + 1;
                String name = headers2.name(i7);
                String value = headers2.value(i7);
                if (StringsKt.equals(name, "Cache-Control", z5)) {
                    if (str2 == null) {
                        str2 = value;
                        i5 = 0;
                        while (i5 < value.length()) {
                            int indexOfElement = indexOfElement(value, "=,;", i5);
                            String substring = value.substring(i5, indexOfElement);
                            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                            String obj = StringsKt.trim(substring).toString();
                            if (indexOfElement == value.length() || value.charAt(indexOfElement) == ',' || value.charAt(indexOfElement) == ';') {
                                i6 = indexOfElement + 1;
                                str = null;
                            } else {
                                int indexOfNonWhitespace = Util.indexOfNonWhitespace(value, indexOfElement + 1);
                                if (indexOfNonWhitespace >= value.length() || value.charAt(indexOfNonWhitespace) != '\"') {
                                    i6 = indexOfElement(value, ",;", indexOfNonWhitespace);
                                    String substring2 = value.substring(indexOfNonWhitespace, i6);
                                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                                    str = StringsKt.trim(substring2).toString();
                                } else {
                                    int i13 = indexOfNonWhitespace + 1;
                                    int indexOf$default = StringsKt.indexOf$default((CharSequence) value, '\"', i13, false, 4, (Object) null);
                                    str = value.substring(i13, indexOf$default);
                                    Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String…ing(startIndex, endIndex)");
                                    i6 = indexOf$default + 1;
                                }
                            }
                            if (StringsKt.equals("no-cache", obj, true)) {
                                i5 = i6;
                                z5 = true;
                                z7 = true;
                            } else if (StringsKt.equals("no-store", obj, true)) {
                                i5 = i6;
                                z5 = true;
                                z8 = true;
                            } else {
                                if (StringsKt.equals("max-age", obj, true)) {
                                    i8 = Util.toNonNegativeInt(str, -1);
                                } else if (StringsKt.equals("s-maxage", obj, true)) {
                                    i9 = Util.toNonNegativeInt(str, -1);
                                } else if (StringsKt.equals("private", obj, true)) {
                                    i5 = i6;
                                    z5 = true;
                                    z9 = true;
                                } else if (StringsKt.equals("public", obj, true)) {
                                    i5 = i6;
                                    z5 = true;
                                    z10 = true;
                                } else if (StringsKt.equals("must-revalidate", obj, true)) {
                                    i5 = i6;
                                    z5 = true;
                                    z11 = true;
                                } else if (StringsKt.equals("max-stale", obj, true)) {
                                    i10 = Util.toNonNegativeInt(str, Integer.MAX_VALUE);
                                } else if (StringsKt.equals("min-fresh", obj, true)) {
                                    i11 = Util.toNonNegativeInt(str, -1);
                                } else if (StringsKt.equals("only-if-cached", obj, true)) {
                                    i5 = i6;
                                    z5 = true;
                                    z12 = true;
                                } else if (StringsKt.equals("no-transform", obj, true)) {
                                    i5 = i6;
                                    z5 = true;
                                    z13 = true;
                                } else if (StringsKt.equals("immutable", obj, true)) {
                                    i5 = i6;
                                    z5 = true;
                                    z14 = true;
                                }
                                i5 = i6;
                                z5 = true;
                            }
                        }
                        headers2 = headers;
                        i7 = i12;
                    }
                } else if (!StringsKt.equals(name, "Pragma", z5)) {
                    headers2 = headers;
                    i7 = i12;
                }
                z6 = false;
                i5 = 0;
                while (i5 < value.length()) {
                }
                headers2 = headers;
                i7 = i12;
            }
            return new CacheControl(z7, z8, i8, i9, z9, z10, z11, i10, i11, z12, z13, z14, !z6 ? null : str2, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ CacheControl(boolean z5, boolean z6, int i5, int i6, boolean z7, boolean z8, boolean z9, int i7, int i8, boolean z10, boolean z11, boolean z12, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(z5, z6, i5, i6, z7, z8, z9, i7, i8, z10, z11, z12, str);
    }

    /* renamed from: immutable, reason: from getter */
    public final boolean getImmutable() {
        return this.immutable;
    }

    /* renamed from: isPrivate, reason: from getter */
    public final boolean getIsPrivate() {
        return this.isPrivate;
    }

    /* renamed from: isPublic, reason: from getter */
    public final boolean getIsPublic() {
        return this.isPublic;
    }

    /* renamed from: maxAgeSeconds, reason: from getter */
    public final int getMaxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    /* renamed from: maxStaleSeconds, reason: from getter */
    public final int getMaxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    /* renamed from: minFreshSeconds, reason: from getter */
    public final int getMinFreshSeconds() {
        return this.minFreshSeconds;
    }

    /* renamed from: mustRevalidate, reason: from getter */
    public final boolean getMustRevalidate() {
        return this.mustRevalidate;
    }

    /* renamed from: noCache, reason: from getter */
    public final boolean getNoCache() {
        return this.noCache;
    }

    /* renamed from: noStore, reason: from getter */
    public final boolean getNoStore() {
        return this.noStore;
    }

    /* renamed from: noTransform, reason: from getter */
    public final boolean getNoTransform() {
        return this.noTransform;
    }

    /* renamed from: onlyIfCached, reason: from getter */
    public final boolean getOnlyIfCached() {
        return this.onlyIfCached;
    }

    /* renamed from: sMaxAgeSeconds, reason: from getter */
    public final int getSMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public String toString() {
        String str = this.headerValue;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (getNoCache()) {
            sb.append("no-cache, ");
        }
        if (getNoStore()) {
            sb.append("no-store, ");
        }
        if (getMaxAgeSeconds() != -1) {
            sb.append("max-age=");
            sb.append(getMaxAgeSeconds());
            sb.append(", ");
        }
        if (getSMaxAgeSeconds() != -1) {
            sb.append("s-maxage=");
            sb.append(getSMaxAgeSeconds());
            sb.append(", ");
        }
        if (getIsPrivate()) {
            sb.append("private, ");
        }
        if (getIsPublic()) {
            sb.append("public, ");
        }
        if (getMustRevalidate()) {
            sb.append("must-revalidate, ");
        }
        if (getMaxStaleSeconds() != -1) {
            sb.append("max-stale=");
            sb.append(getMaxStaleSeconds());
            sb.append(", ");
        }
        if (getMinFreshSeconds() != -1) {
            sb.append("min-fresh=");
            sb.append(getMinFreshSeconds());
            sb.append(", ");
        }
        if (getOnlyIfCached()) {
            sb.append("only-if-cached, ");
        }
        if (getNoTransform()) {
            sb.append("no-transform, ");
        }
        if (getImmutable()) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return BuildConfig.FLAVOR;
        }
        sb.delete(sb.length() - 2, sb.length());
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        this.headerValue = sb2;
        return sb2;
    }

    private CacheControl(boolean z5, boolean z6, int i5, int i6, boolean z7, boolean z8, boolean z9, int i7, int i8, boolean z10, boolean z11, boolean z12, String str) {
        this.noCache = z5;
        this.noStore = z6;
        this.maxAgeSeconds = i5;
        this.sMaxAgeSeconds = i6;
        this.isPrivate = z7;
        this.isPublic = z8;
        this.mustRevalidate = z9;
        this.maxStaleSeconds = i7;
        this.minFreshSeconds = i8;
        this.onlyIfCached = z10;
        this.noTransform = z11;
        this.immutable = z12;
        this.headerValue = str;
    }
}
