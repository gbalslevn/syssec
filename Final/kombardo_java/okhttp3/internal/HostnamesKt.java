package okhttp3.internal;

import com.sun.jna.Function;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0002\u001a\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u0003H\u0002\u001a\f\u0010\u000e\u001a\u0004\u0018\u00010\u0003*\u00020\u0003¨\u0006\u000f"}, d2 = {"decodeIpv4Suffix", BuildConfig.FLAVOR, "input", BuildConfig.FLAVOR, "pos", BuildConfig.FLAVOR, "limit", "address", BuildConfig.FLAVOR, "addressOffset", "decodeIpv6", "Ljava/net/InetAddress;", "inet6AddressToAscii", "containsInvalidHostnameAsciiCodes", "toCanonicalHost", "okhttp"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class HostnamesKt {
    private static final boolean containsInvalidHostnameAsciiCodes(String str) {
        int length = str.length();
        int i5 = 0;
        while (i5 < length) {
            int i6 = i5 + 1;
            char charAt = str.charAt(i5);
            if (Intrinsics.compare((int) charAt, 31) <= 0 || Intrinsics.compare((int) charAt, 127) >= 0 || StringsKt.indexOf$default((CharSequence) " #%/:?@[\\]", charAt, 0, false, 6, (Object) null) != -1) {
                return true;
            }
            i5 = i6;
        }
        return false;
    }

    private static final boolean decodeIpv4Suffix(String str, int i5, int i6, byte[] bArr, int i7) {
        int i8 = i7;
        while (i5 < i6) {
            if (i8 == bArr.length) {
                return false;
            }
            if (i8 != i7) {
                if (str.charAt(i5) != '.') {
                    return false;
                }
                i5++;
            }
            int i9 = i5;
            int i10 = 0;
            while (i9 < i6) {
                char charAt = str.charAt(i9);
                if (Intrinsics.compare((int) charAt, 48) < 0 || Intrinsics.compare((int) charAt, 57) > 0) {
                    break;
                }
                if ((i10 == 0 && i5 != i9) || (i10 = ((i10 * 10) + charAt) - 48) > 255) {
                    return false;
                }
                i9++;
            }
            if (i9 - i5 == 0) {
                return false;
            }
            bArr[i8] = (byte) i10;
            i8++;
            i5 = i9;
        }
        return i8 == i7 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0097, code lost:
    
        if (r13 == 16) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0099, code lost:
    
        if (r14 != (-1)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009b, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009c, code lost:
    
        r0 = r13 - r14;
        java.lang.System.arraycopy(r9, r14, r9, 16 - r0, r0);
        java.util.Arrays.fill(r9, r14, (16 - r13) + r14, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ad, code lost:
    
        return java.net.InetAddress.getByAddress(r9);
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final InetAddress decodeIpv6(String str, int i5, int i6) {
        int i7;
        byte[] bArr = new byte[16];
        int i8 = i5;
        int i9 = -1;
        int i10 = -1;
        int i11 = 0;
        while (true) {
            if (i8 < i6) {
                if (i11 != 16) {
                    int i12 = i8 + 2;
                    if (i12 <= i6 && StringsKt.startsWith$default(str, "::", i8, false, 4, null)) {
                        if (i9 == -1) {
                            i11 += 2;
                            if (i12 != i6) {
                                i10 = i12;
                                i9 = i11;
                                i8 = i10;
                                int i13 = 0;
                                while (i8 < i6) {
                                }
                                i7 = i8 - i10;
                                if (i7 == 0) {
                                    break;
                                }
                                break;
                            }
                            i9 = i11;
                            break;
                        }
                        return null;
                    }
                    if (i11 != 0) {
                        if (StringsKt.startsWith$default(str, ":", i8, false, 4, null)) {
                            i8++;
                        } else {
                            if (!StringsKt.startsWith$default(str, ".", i8, false, 4, null) || !decodeIpv4Suffix(str, i10, i6, bArr, i11 - 2)) {
                                return null;
                            }
                            i11 += 2;
                        }
                    }
                    i10 = i8;
                    i8 = i10;
                    int i132 = 0;
                    while (i8 < i6) {
                        int parseHexDigit = Util.parseHexDigit(str.charAt(i8));
                        if (parseHexDigit == -1) {
                            break;
                        }
                        i132 = (i132 << 4) + parseHexDigit;
                        i8++;
                    }
                    i7 = i8 - i10;
                    if (i7 == 0 || i7 > 4) {
                        break;
                    }
                    int i14 = i11 + 1;
                    bArr[i11] = (byte) ((i132 >>> 8) & Function.USE_VARARGS);
                    i11 += 2;
                    bArr[i14] = (byte) (i132 & Function.USE_VARARGS);
                } else {
                    return null;
                }
            } else {
                break;
            }
        }
        return null;
    }

    private static final String inet6AddressToAscii(byte[] bArr) {
        int i5 = -1;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i7 < bArr.length) {
            int i9 = i7;
            while (i9 < 16 && bArr[i9] == 0 && bArr[i9 + 1] == 0) {
                i9 += 2;
            }
            int i10 = i9 - i7;
            if (i10 > i8 && i10 >= 4) {
                i5 = i7;
                i8 = i10;
            }
            i7 = i9 + 2;
        }
        Buffer buffer = new Buffer();
        while (i6 < bArr.length) {
            if (i6 == i5) {
                buffer.writeByte(58);
                i6 += i8;
                if (i6 == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i6 > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong((Util.and(bArr[i6], Function.USE_VARARGS) << 8) | Util.and(bArr[i6 + 1], Function.USE_VARARGS));
                i6 += 2;
            }
        }
        return buffer.readUtf8();
    }

    public static final String toCanonicalHost(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) ":", false, 2, (Object) null)) {
            try {
                String ascii = IDN.toASCII(str);
                Intrinsics.checkNotNullExpressionValue(ascii, "toASCII(host)");
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String lowerCase = ascii.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (lowerCase.length() == 0) {
                    return null;
                }
                if (containsInvalidHostnameAsciiCodes(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress decodeIpv6 = (StringsKt.startsWith$default(str, "[", false, 2, (Object) null) && StringsKt.endsWith$default(str, "]", false, 2, (Object) null)) ? decodeIpv6(str, 1, str.length() - 1) : decodeIpv6(str, 0, str.length());
        if (decodeIpv6 == null) {
            return null;
        }
        byte[] address = decodeIpv6.getAddress();
        if (address.length == 16) {
            Intrinsics.checkNotNullExpressionValue(address, "address");
            return inet6AddressToAscii(address);
        }
        if (address.length == 4) {
            return decodeIpv6.getHostAddress();
        }
        throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
    }
}
