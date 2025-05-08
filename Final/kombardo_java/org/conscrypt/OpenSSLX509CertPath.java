package org.conscrypt;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.conscrypt.OpenSSLX509CertificateFactory;

/* loaded from: classes3.dex */
final class OpenSSLX509CertPath extends CertPath {
    private static final List<String> ALL_ENCODINGS;
    private static final Encoding DEFAULT_ENCODING;
    private static final byte[] PKCS7_MARKER = {45, 45, 45, 45, 45, 66, 69, 71, 73, 78, 32, 80, 75, 67, 83, 55};
    private static final int PUSHBACK_SIZE = 64;
    private static final long serialVersionUID = -3249106005255170761L;
    private final List<? extends X509Certificate> mCertificates;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: org.conscrypt.OpenSSLX509CertPath$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$conscrypt$OpenSSLX509CertPath$Encoding;

        static {
            int[] iArr = new int[Encoding.values().length];
            $SwitchMap$org$conscrypt$OpenSSLX509CertPath$Encoding = iArr;
            try {
                iArr[Encoding.PKI_PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLX509CertPath$Encoding[Encoding.PKCS7.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum Encoding {
        PKI_PATH("PkiPath"),
        PKCS7("PKCS7");

        private final String apiName;

        Encoding(String str) {
            this.apiName = str;
        }

        static Encoding findByApiName(String str) {
            for (Encoding encoding : values()) {
                if (encoding.apiName.equals(str)) {
                    return encoding;
                }
            }
            return null;
        }
    }

    static {
        Encoding encoding = Encoding.PKI_PATH;
        ALL_ENCODINGS = Collections.unmodifiableList(Arrays.asList(encoding.apiName, Encoding.PKCS7.apiName));
        DEFAULT_ENCODING = encoding;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OpenSSLX509CertPath(List<? extends X509Certificate> list) {
        super("X.509");
        this.mCertificates = list;
    }

    private static CertPath fromEncoding(InputStream inputStream, Encoding encoding) {
        int i5 = AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLX509CertPath$Encoding[encoding.ordinal()];
        if (i5 == 1) {
            return fromPkiPathEncoding(inputStream);
        }
        if (i5 == 2) {
            return fromPkcs7Encoding(inputStream);
        }
        throw new CertificateEncodingException("Unknown encoding");
    }

    private static CertPath fromPkcs7Encoding(InputStream inputStream) {
        if (inputStream != null) {
            try {
                if (inputStream.available() != 0) {
                    boolean markSupported = inputStream.markSupported();
                    if (markSupported) {
                        inputStream.mark(64);
                    }
                    PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 64);
                    try {
                        byte[] bArr = PKCS7_MARKER;
                        byte[] bArr2 = new byte[bArr.length];
                        int read = pushbackInputStream.read(bArr2);
                        if (read < 0) {
                            throw new OpenSSLX509CertificateFactory.ParsingException("inStream is empty");
                        }
                        pushbackInputStream.unread(bArr2, 0, read);
                        return (read == bArr.length && Arrays.equals(bArr, bArr2)) ? new OpenSSLX509CertPath(OpenSSLX509Certificate.fromPkcs7PemInputStream(pushbackInputStream)) : new OpenSSLX509CertPath(OpenSSLX509Certificate.fromPkcs7DerInputStream(pushbackInputStream));
                    } catch (Exception e5) {
                        if (markSupported) {
                            try {
                                inputStream.reset();
                            } catch (IOException unused) {
                            }
                        }
                        throw new CertificateException(e5);
                    }
                }
            } catch (IOException e6) {
                throw new CertificateException("Problem reading input stream", e6);
            }
        }
        return new OpenSSLX509CertPath(Collections.emptyList());
    }

    private static CertPath fromPkiPathEncoding(InputStream inputStream) {
        OpenSSLBIOInputStream openSSLBIOInputStream = new OpenSSLBIOInputStream(inputStream, true);
        boolean markSupported = inputStream.markSupported();
        if (markSupported) {
            inputStream.mark(64);
        }
        try {
            try {
                long[] ASN1_seq_unpack_X509_bio = NativeCrypto.ASN1_seq_unpack_X509_bio(openSSLBIOInputStream.getBioContext());
                if (ASN1_seq_unpack_X509_bio == null) {
                    return new OpenSSLX509CertPath(Collections.emptyList());
                }
                ArrayList arrayList = new ArrayList(ASN1_seq_unpack_X509_bio.length);
                for (int length = ASN1_seq_unpack_X509_bio.length - 1; length >= 0; length--) {
                    if (ASN1_seq_unpack_X509_bio[length] != 0) {
                        try {
                            arrayList.add(new OpenSSLX509Certificate(ASN1_seq_unpack_X509_bio[length]));
                        } catch (OpenSSLX509CertificateFactory.ParsingException e5) {
                            throw new CertificateParsingException(e5);
                        }
                    }
                }
                return new OpenSSLX509CertPath(arrayList);
            } catch (Exception e6) {
                if (markSupported) {
                    try {
                        inputStream.reset();
                    } catch (IOException unused) {
                    }
                }
                throw new CertificateException(e6);
            }
        } finally {
            openSSLBIOInputStream.release();
        }
    }

    private byte[] getEncoded(Encoding encoding) {
        int size = this.mCertificates.size();
        OpenSSLX509Certificate[] openSSLX509CertificateArr = new OpenSSLX509Certificate[size];
        long[] jArr = new long[size];
        int i5 = 0;
        for (int i6 = size - 1; i6 >= 0; i6--) {
            X509Certificate x509Certificate = this.mCertificates.get(i5);
            if (x509Certificate instanceof OpenSSLX509Certificate) {
                openSSLX509CertificateArr[i6] = (OpenSSLX509Certificate) x509Certificate;
            } else {
                openSSLX509CertificateArr[i6] = OpenSSLX509Certificate.fromX509Der(x509Certificate.getEncoded());
            }
            jArr[i6] = openSSLX509CertificateArr[i6].getContext();
            i5++;
        }
        int i7 = AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLX509CertPath$Encoding[encoding.ordinal()];
        if (i7 == 1) {
            return NativeCrypto.ASN1_seq_pack_X509(jArr);
        }
        if (i7 == 2) {
            return NativeCrypto.i2d_PKCS7(jArr);
        }
        throw new CertificateEncodingException("Unknown encoding");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Iterator<String> getEncodingsIterator() {
        return ALL_ENCODINGS.iterator();
    }

    @Override // java.security.cert.CertPath
    public List<? extends Certificate> getCertificates() {
        return Collections.unmodifiableList(this.mCertificates);
    }

    @Override // java.security.cert.CertPath
    public Iterator<String> getEncodings() {
        return getEncodingsIterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CertPath fromEncoding(InputStream inputStream, String str) {
        if (inputStream != null) {
            Encoding findByApiName = Encoding.findByApiName(str);
            if (findByApiName != null) {
                return fromEncoding(inputStream, findByApiName);
            }
            throw new CertificateException("Invalid encoding: " + str);
        }
        throw new CertificateException("inStream == null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CertPath fromEncoding(InputStream inputStream) {
        if (inputStream != null) {
            return fromEncoding(inputStream, DEFAULT_ENCODING);
        }
        throw new CertificateException("inStream == null");
    }

    @Override // java.security.cert.CertPath
    public byte[] getEncoded() {
        return getEncoded(DEFAULT_ENCODING);
    }

    @Override // java.security.cert.CertPath
    public byte[] getEncoded(String str) {
        Encoding findByApiName = Encoding.findByApiName(str);
        if (findByApiName != null) {
            return getEncoded(findByApiName);
        }
        throw new CertificateEncodingException("Invalid encoding: " + str);
    }
}
