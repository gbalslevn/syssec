package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u001a'\u0010\u0007\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {BuildConfig.FLAVOR, BuildConfig.FLAVOR, "beginIndex", "endIndex", BuildConfig.FLAVOR, "size", "(Ljava/lang/String;II)J", "utf8Size", "okio"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class Utf8 {
    public static final long size(String str, int i5, int i6) {
        int i7;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i5).toString());
        }
        if (i6 < i5) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i6 + " < " + i5).toString());
        }
        if (i6 > str.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i6 + " > " + str.length()).toString());
        }
        long j5 = 0;
        while (i5 < i6) {
            char charAt = str.charAt(i5);
            if (charAt < 128) {
                j5++;
            } else {
                if (charAt < 2048) {
                    i7 = 2;
                } else if (charAt < 55296 || charAt > 57343) {
                    i7 = 3;
                } else {
                    int i8 = i5 + 1;
                    char charAt2 = i8 < i6 ? str.charAt(i8) : (char) 0;
                    if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                        j5++;
                        i5 = i8;
                    } else {
                        j5 += 4;
                        i5 += 2;
                    }
                }
                j5 += i7;
            }
            i5++;
        }
        return j5;
    }

    public static /* synthetic */ long size$default(String str, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i5 = 0;
        }
        if ((i7 & 2) != 0) {
            i6 = str.length();
        }
        return size(str, i5, i6);
    }
}
