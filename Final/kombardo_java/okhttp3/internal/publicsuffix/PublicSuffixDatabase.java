package okhttp3.internal.publicsuffix;

import com.sun.jna.Function;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u0003J\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019¨\u0006\u001c"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "domain", BuildConfig.FLAVOR, "splitDomain", "(Ljava/lang/String;)Ljava/util/List;", "domainLabels", "findMatchingRule", "(Ljava/util/List;)Ljava/util/List;", BuildConfig.FLAVOR, "readTheListUninterruptibly", "readTheList", "getEffectiveTldPlusOne", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "listRead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/CountDownLatch;", "readCompleteLatch", "Ljava/util/concurrent/CountDownLatch;", BuildConfig.FLAVOR, "publicSuffixListBytes", "[B", "publicSuffixExceptionListBytes", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PublicSuffixDatabase {
    private static final char EXCEPTION_MARKER = '!';
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final byte[] WILDCARD_LABEL = {42};
    private static final List<String> PREVAILING_RULE = CollectionsKt.listOf("*");
    private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\fJ)\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase$Companion;", BuildConfig.FLAVOR, "()V", "EXCEPTION_MARKER", BuildConfig.FLAVOR, "PREVAILING_RULE", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "PUBLIC_SUFFIX_RESOURCE", "WILDCARD_LABEL", BuildConfig.FLAVOR, "instance", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "get", "binarySearch", "labels", BuildConfig.FLAVOR, "labelIndex", BuildConfig.FLAVOR, "([B[[BI)Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String binarySearch(byte[] bArr, byte[][] bArr2, int i5) {
            int i6;
            int and;
            boolean z5;
            int and2;
            int length = bArr.length;
            int i7 = 0;
            while (i7 < length) {
                int i8 = (i7 + length) / 2;
                while (i8 > -1 && bArr[i8] != 10) {
                    i8--;
                }
                int i9 = i8 + 1;
                int i10 = 1;
                while (true) {
                    i6 = i9 + i10;
                    if (bArr[i6] == 10) {
                        break;
                    }
                    i10++;
                }
                int i11 = i6 - i9;
                int i12 = i5;
                boolean z6 = false;
                int i13 = 0;
                int i14 = 0;
                while (true) {
                    if (z6) {
                        and = 46;
                        z5 = false;
                    } else {
                        boolean z7 = z6;
                        and = Util.and(bArr2[i12][i13], Function.USE_VARARGS);
                        z5 = z7;
                    }
                    and2 = and - Util.and(bArr[i9 + i14], Function.USE_VARARGS);
                    if (and2 != 0) {
                        break;
                    }
                    i14++;
                    i13++;
                    if (i14 == i11) {
                        break;
                    }
                    if (bArr2[i12].length != i13) {
                        z6 = z5;
                    } else {
                        if (i12 == bArr2.length - 1) {
                            break;
                        }
                        i12++;
                        z6 = true;
                        i13 = -1;
                    }
                }
                if (and2 >= 0) {
                    if (and2 <= 0) {
                        int i15 = i11 - i14;
                        int length2 = bArr2[i12].length - i13;
                        int length3 = bArr2.length;
                        for (int i16 = i12 + 1; i16 < length3; i16++) {
                            length2 += bArr2[i16].length;
                        }
                        if (length2 >= i15) {
                            if (length2 <= i15) {
                                Charset UTF_8 = StandardCharsets.UTF_8;
                                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                                return new String(bArr, i9, i11, UTF_8);
                            }
                        }
                    }
                    i7 = i6 + 1;
                }
                length = i8;
            }
            return null;
        }

        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }

        private Companion() {
        }
    }

    private final List<String> findMatchingRule(List<String> domainLabels) {
        String str;
        String str2;
        String str3;
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            readTheListUninterruptibly();
        }
        if (this.publicSuffixListBytes == null) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
        }
        int size = domainLabels.size();
        byte[][] bArr = new byte[size];
        for (int i5 = 0; i5 < size; i5++) {
            String str4 = domainLabels.get(i5);
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            byte[] bytes = str4.getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            bArr[i5] = bytes;
        }
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                str = null;
                break;
            }
            int i7 = i6 + 1;
            Companion companion = INSTANCE;
            byte[] bArr2 = this.publicSuffixListBytes;
            if (bArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                bArr2 = null;
            }
            String binarySearch = companion.binarySearch(bArr2, bArr, i6);
            if (binarySearch != null) {
                str = binarySearch;
                break;
            }
            i6 = i7;
        }
        if (size > 1) {
            byte[][] bArr3 = (byte[][]) bArr.clone();
            int length = bArr3.length - 1;
            int i8 = 0;
            while (i8 < length) {
                int i9 = i8 + 1;
                bArr3[i8] = WILDCARD_LABEL;
                Companion companion2 = INSTANCE;
                byte[] bArr4 = this.publicSuffixListBytes;
                if (bArr4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                    bArr4 = null;
                }
                String binarySearch2 = companion2.binarySearch(bArr4, bArr3, i8);
                if (binarySearch2 != null) {
                    str2 = binarySearch2;
                    break;
                }
                i8 = i9;
            }
        }
        str2 = null;
        if (str2 != null) {
            int i10 = size - 1;
            int i11 = 0;
            while (i11 < i10) {
                int i12 = i11 + 1;
                Companion companion3 = INSTANCE;
                byte[] bArr5 = this.publicSuffixExceptionListBytes;
                if (bArr5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");
                    bArr5 = null;
                }
                str3 = companion3.binarySearch(bArr5, bArr, i11);
                if (str3 != null) {
                    break;
                }
                i11 = i12;
            }
        }
        str3 = null;
        if (str3 != null) {
            return StringsKt.split$default((CharSequence) Intrinsics.stringPlus("!", str3), new char[]{'.'}, false, 0, 6, (Object) null);
        }
        if (str == null && str2 == null) {
            return PREVAILING_RULE;
        }
        List<String> split$default = str == null ? null : StringsKt.split$default((CharSequence) str, new char[]{'.'}, false, 0, 6, (Object) null);
        if (split$default == null) {
            split$default = CollectionsKt.emptyList();
        }
        List<String> split$default2 = str2 != null ? StringsKt.split$default((CharSequence) str2, new char[]{'.'}, false, 0, 6, (Object) null) : null;
        if (split$default2 == null) {
            split$default2 = CollectionsKt.emptyList();
        }
        return split$default.size() > split$default2.size() ? split$default : split$default2;
    }

    private final void readTheList() {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        BufferedSource buffer = Okio.buffer(new GzipSource(Okio.source(resourceAsStream)));
        try {
            byte[] readByteArray = buffer.readByteArray(buffer.readInt());
            byte[] readByteArray2 = buffer.readByteArray(buffer.readInt());
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(buffer, null);
            synchronized (this) {
                Intrinsics.checkNotNull(readByteArray);
                this.publicSuffixListBytes = readByteArray;
                Intrinsics.checkNotNull(readByteArray2);
                this.publicSuffixExceptionListBytes = readByteArray2;
            }
            this.readCompleteLatch.countDown();
        } finally {
        }
    }

    private final void readTheListUninterruptibly() {
        boolean z5 = false;
        while (true) {
            try {
                try {
                    readTheList();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z5 = true;
                } catch (IOException e5) {
                    Platform.INSTANCE.get().log("Failed to read public suffix list", 5, e5);
                    if (z5) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z5) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z5) {
            Thread.currentThread().interrupt();
        }
    }

    private final List<String> splitDomain(String domain) {
        List<String> split$default = StringsKt.split$default((CharSequence) domain, new char[]{'.'}, false, 0, 6, (Object) null);
        return Intrinsics.areEqual(CollectionsKt.last((List) split$default), BuildConfig.FLAVOR) ? CollectionsKt.dropLast(split$default, 1) : split$default;
    }

    public final String getEffectiveTldPlusOne(String domain) {
        int size;
        int size2;
        Intrinsics.checkNotNullParameter(domain, "domain");
        String unicodeDomain = IDN.toUnicode(domain);
        Intrinsics.checkNotNullExpressionValue(unicodeDomain, "unicodeDomain");
        List<String> splitDomain = splitDomain(unicodeDomain);
        List<String> findMatchingRule = findMatchingRule(splitDomain);
        if (splitDomain.size() == findMatchingRule.size() && findMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (findMatchingRule.get(0).charAt(0) == '!') {
            size = splitDomain.size();
            size2 = findMatchingRule.size();
        } else {
            size = splitDomain.size();
            size2 = findMatchingRule.size() + 1;
        }
        return SequencesKt.joinToString$default(SequencesKt.drop(CollectionsKt.asSequence(splitDomain(domain)), size - size2), ".", null, null, 0, null, null, 62, null);
    }
}
