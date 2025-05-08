package org.conscrypt;

import androidx.appcompat.R$styleable;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class SSLUtils {
    private static final String KEY_TYPE_EC = "EC";
    private static final String KEY_TYPE_RSA = "RSA";
    private static final int MAX_ENCRYPTION_OVERHEAD_DIFF = 2147483561;
    private static final int MAX_ENCRYPTION_OVERHEAD_LENGTH = 86;
    private static final int MAX_PROTOCOL_LENGTH = 255;
    static final boolean USE_ENGINE_SOCKET_BY_DEFAULT = Boolean.parseBoolean(System.getProperty("org.conscrypt.useEngineSocketByDefault", "true"));
    private static final Charset US_ASCII = Charset.forName("US-ASCII");

    /* loaded from: classes3.dex */
    static final class EngineStates {
        static final int STATE_CLOSED = 8;
        static final int STATE_CLOSED_INBOUND = 6;
        static final int STATE_CLOSED_OUTBOUND = 7;
        static final int STATE_HANDSHAKE_COMPLETED = 3;
        static final int STATE_HANDSHAKE_STARTED = 2;
        static final int STATE_MODE_SET = 1;
        static final int STATE_NEW = 0;
        static final int STATE_READY = 5;
        static final int STATE_READY_HANDSHAKE_CUT_THROUGH = 4;

        private EngineStates() {
        }
    }

    /* loaded from: classes3.dex */
    enum SessionType {
        OPEN_SSL(1),
        OPEN_SSL_WITH_OCSP(2),
        OPEN_SSL_WITH_TLS_SCT(3);

        final int value;

        SessionType(int i5) {
            this.value = i5;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static boolean isSupportedType(int i5) {
            return i5 == OPEN_SSL.value || i5 == OPEN_SSL_WITH_OCSP.value || i5 == OPEN_SSL_WITH_TLS_SCT.value;
        }
    }

    private SSLUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int calculateOutNetBufSize(int i5) {
        return Math.min(16709, Math.min(MAX_ENCRYPTION_OVERHEAD_DIFF, i5) + MAX_ENCRYPTION_OVERHEAD_LENGTH);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] concat(String[]... strArr) {
        int i5 = 0;
        for (String[] strArr2 : strArr) {
            i5 += strArr2.length;
        }
        String[] strArr3 = new String[i5];
        int i6 = 0;
        for (String[] strArr4 : strArr) {
            System.arraycopy(strArr4, 0, strArr3, i6, strArr4.length);
            i6 += strArr4.length;
        }
        return strArr3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] decodeProtocols(byte[] bArr) {
        String str;
        if (bArr.length == 0) {
            return EmptyArray.STRING;
        }
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i6 < bArr.length) {
            byte b5 = bArr[i6];
            if (b5 < 0 || b5 > bArr.length - i6) {
                StringBuilder sb = new StringBuilder();
                sb.append("Protocol has invalid length (");
                sb.append((int) b5);
                sb.append(" at position ");
                sb.append(i6);
                sb.append("): ");
                if (bArr.length < 50) {
                    str = Arrays.toString(bArr);
                } else {
                    str = bArr.length + " byte array";
                }
                sb.append(str);
                throw new IllegalArgumentException(sb.toString());
            }
            i7++;
            i6 += b5 + 1;
        }
        String[] strArr = new String[i7];
        int i8 = 0;
        while (i5 < bArr.length) {
            byte b6 = bArr[i5];
            int i9 = i8 + 1;
            strArr[i8] = b6 > 0 ? new String(bArr, i5 + 1, b6, US_ASCII) : BuildConfig.FLAVOR;
            i5 += b6 + 1;
            i8 = i9;
        }
        return strArr;
    }

    private static X509Certificate decodeX509Certificate(CertificateFactory certificateFactory, byte[] bArr) {
        return certificateFactory != null ? (X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArr)) : OpenSSLX509Certificate.fromX509Der(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static X509Certificate[] decodeX509CertificateChain(byte[][] bArr) {
        CertificateFactory certificateFactory = getCertificateFactory();
        int length = bArr.length;
        X509Certificate[] x509CertificateArr = new X509Certificate[length];
        for (int i5 = 0; i5 < length; i5++) {
            x509CertificateArr[i5] = decodeX509Certificate(certificateFactory, bArr[i5]);
        }
        return x509CertificateArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] encodeProtocols(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException("protocols array must be non-null");
        }
        if (strArr.length == 0) {
            return EmptyArray.BYTE;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < strArr.length; i6++) {
            String str = strArr[i6];
            if (str == null) {
                throw new IllegalArgumentException("protocol[" + i6 + "] is null");
            }
            int length = str.length();
            if (length == 0 || length > 255) {
                throw new IllegalArgumentException("protocol[" + i6 + "] has invalid length: " + length);
            }
            i5 += length + 1;
        }
        byte[] bArr = new byte[i5];
        int i7 = 0;
        for (String str2 : strArr) {
            int length2 = str2.length();
            bArr[i7] = (byte) length2;
            i7++;
            int i8 = 0;
            while (i8 < length2) {
                char charAt = str2.charAt(i8);
                if (charAt > 127) {
                    throw new IllegalArgumentException("Protocol contains invalid character: " + charAt + "(protocol=" + str2 + ")");
                }
                bArr[i7] = (byte) charAt;
                i8++;
                i7++;
            }
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[][] encodeSubjectX509Principals(X509Certificate[] x509CertificateArr) {
        byte[][] bArr = new byte[x509CertificateArr.length];
        for (int i5 = 0; i5 < x509CertificateArr.length; i5++) {
            bArr[i5] = x509CertificateArr[i5].getSubjectX500Principal().getEncoded();
        }
        return bArr;
    }

    private static CertificateFactory getCertificateFactory() {
        try {
            return CertificateFactory.getInstance("X.509");
        } catch (CertificateException unused) {
            return null;
        }
    }

    static String getClientKeyType(byte b5) {
        if (b5 == 1) {
            return KEY_TYPE_RSA;
        }
        if (b5 != 64) {
            return null;
        }
        return KEY_TYPE_EC;
    }

    static String getClientKeyTypeFromSignatureAlg(int i5) {
        int SSL_get_signature_algorithm_key_type = NativeCrypto.SSL_get_signature_algorithm_key_type(i5);
        if (SSL_get_signature_algorithm_key_type == 6) {
            return KEY_TYPE_RSA;
        }
        if (SSL_get_signature_algorithm_key_type != 408) {
            return null;
        }
        return KEY_TYPE_EC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getEncryptedPacketLength(ByteBuffer[] byteBufferArr, int i5) {
        ByteBuffer byteBuffer = byteBufferArr[i5];
        if (byteBuffer.remaining() >= 5) {
            return getEncryptedPacketLength(byteBuffer);
        }
        ByteBuffer allocate = ByteBuffer.allocate(5);
        while (true) {
            int i6 = i5 + 1;
            ByteBuffer byteBuffer2 = byteBufferArr[i5];
            int position = byteBuffer2.position();
            int limit = byteBuffer2.limit();
            if (byteBuffer2.remaining() > allocate.remaining()) {
                byteBuffer2.limit(allocate.remaining() + position);
            }
            try {
                allocate.put(byteBuffer2);
                byteBuffer2.limit(limit);
                byteBuffer2.position(position);
                if (!allocate.hasRemaining()) {
                    allocate.flip();
                    return getEncryptedPacketLength(allocate);
                }
                i5 = i6;
            } catch (Throwable th) {
                byteBuffer2.limit(limit);
                byteBuffer2.position(position);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getServerX509KeyType(long j5) {
        String SSL_CIPHER_get_kx_name = NativeCrypto.SSL_CIPHER_get_kx_name(j5);
        if (SSL_CIPHER_get_kx_name.equals(KEY_TYPE_RSA) || SSL_CIPHER_get_kx_name.equals("DHE_RSA") || SSL_CIPHER_get_kx_name.equals("ECDHE_RSA")) {
            return KEY_TYPE_RSA;
        }
        if (SSL_CIPHER_get_kx_name.equals("ECDHE_ECDSA")) {
            return KEY_TYPE_EC;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set<String> getSupportedClientKeyTypes(byte[] bArr, int[] iArr) {
        HashSet hashSet = new HashSet(bArr.length);
        for (byte b5 : bArr) {
            String clientKeyType = getClientKeyType(b5);
            if (clientKeyType != null) {
                hashSet.add(clientKeyType);
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(iArr.length);
        for (int i5 : iArr) {
            String clientKeyTypeFromSignatureAlg = getClientKeyTypeFromSignatureAlg(i5);
            if (clientKeyTypeFromSignatureAlg != null) {
                linkedHashSet.add(clientKeyTypeFromSignatureAlg);
            }
        }
        if (bArr.length <= 0 || iArr.length <= 0) {
            return iArr.length > 0 ? linkedHashSet : hashSet;
        }
        linkedHashSet.retainAll(hashSet);
        return linkedHashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static javax.security.cert.X509Certificate[] toCertificateChain(X509Certificate[] x509CertificateArr) {
        try {
            javax.security.cert.X509Certificate[] x509CertificateArr2 = new javax.security.cert.X509Certificate[x509CertificateArr.length];
            for (int i5 = 0; i5 < x509CertificateArr.length; i5++) {
                x509CertificateArr2[i5] = javax.security.cert.X509Certificate.getInstance(x509CertificateArr[i5].getEncoded());
            }
            return x509CertificateArr2;
        } catch (CertificateEncodingException e5) {
            Throwable sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e5.getMessage());
            sSLPeerUnverifiedException.initCause(sSLPeerUnverifiedException);
            throw sSLPeerUnverifiedException;
        } catch (javax.security.cert.CertificateException e6) {
            Throwable sSLPeerUnverifiedException2 = new SSLPeerUnverifiedException(e6.getMessage());
            sSLPeerUnverifiedException2.initCause(sSLPeerUnverifiedException2);
            throw sSLPeerUnverifiedException2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] toProtocolBytes(String str) {
        if (str == null) {
            return null;
        }
        return str.getBytes(US_ASCII);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toProtocolString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new String(bArr, US_ASCII);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SSLException toSSLException(Throwable th) {
        return th instanceof SSLException ? (SSLException) th : new SSLException(th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SSLHandshakeException toSSLHandshakeException(Throwable th) {
        return th instanceof SSLHandshakeException ? (SSLHandshakeException) th : (SSLHandshakeException) new SSLHandshakeException(th.getMessage()).initCause(th);
    }

    private static short unsignedByte(byte b5) {
        return (short) (b5 & 255);
    }

    private static int unsignedShort(short s5) {
        return s5 & 65535;
    }

    private static int getEncryptedPacketLength(ByteBuffer byteBuffer) {
        int unsignedShort;
        int position = byteBuffer.position();
        switch (unsignedByte(byteBuffer.get(position))) {
            case 20:
            case 21:
            case 22:
            case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                if (unsignedByte(byteBuffer.get(position + 1)) == 3 && (unsignedShort = unsignedShort(byteBuffer.getShort(position + 3)) + 5) > 5) {
                    return unsignedShort;
                }
                return -1;
            default:
                return -1;
        }
    }
}
