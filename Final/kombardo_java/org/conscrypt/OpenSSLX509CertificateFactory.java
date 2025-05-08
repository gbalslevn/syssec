package org.conscrypt;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactorySpi;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class OpenSSLX509CertificateFactory extends CertificateFactorySpi {
    private static final byte[] PKCS7_MARKER = {45, 45, 45, 45, 45, 66, 69, 71, 73, 78, 32, 80, 75, 67, 83, 55};
    private static final int PUSHBACK_SIZE = 64;
    private Parser<OpenSSLX509Certificate> certificateParser = new Parser<OpenSSLX509Certificate>() { // from class: org.conscrypt.OpenSSLX509CertificateFactory.1
        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public List<? extends OpenSSLX509Certificate> fromPkcs7DerInputStream(InputStream inputStream) {
            return OpenSSLX509Certificate.fromPkcs7DerInputStream(inputStream);
        }

        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public List<? extends OpenSSLX509Certificate> fromPkcs7PemInputStream(InputStream inputStream) {
            return OpenSSLX509Certificate.fromPkcs7PemInputStream(inputStream);
        }

        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public OpenSSLX509Certificate fromX509DerInputStream(InputStream inputStream) {
            return OpenSSLX509Certificate.fromX509DerInputStream(inputStream);
        }

        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public OpenSSLX509Certificate fromX509PemInputStream(InputStream inputStream) {
            return OpenSSLX509Certificate.fromX509PemInputStream(inputStream);
        }
    };
    private Parser<OpenSSLX509CRL> crlParser = new Parser<OpenSSLX509CRL>() { // from class: org.conscrypt.OpenSSLX509CertificateFactory.2
        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public List<? extends OpenSSLX509CRL> fromPkcs7DerInputStream(InputStream inputStream) {
            return OpenSSLX509CRL.fromPkcs7DerInputStream(inputStream);
        }

        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public List<? extends OpenSSLX509CRL> fromPkcs7PemInputStream(InputStream inputStream) {
            return OpenSSLX509CRL.fromPkcs7PemInputStream(inputStream);
        }

        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public OpenSSLX509CRL fromX509DerInputStream(InputStream inputStream) {
            return OpenSSLX509CRL.fromX509DerInputStream(inputStream);
        }

        @Override // org.conscrypt.OpenSSLX509CertificateFactory.Parser
        public OpenSSLX509CRL fromX509PemInputStream(InputStream inputStream) {
            return OpenSSLX509CRL.fromX509PemInputStream(inputStream);
        }
    };

    /* loaded from: classes3.dex */
    private static abstract class Parser<T> {
        private Parser() {
        }

        protected abstract List<? extends T> fromPkcs7DerInputStream(InputStream inputStream);

        protected abstract List<? extends T> fromPkcs7PemInputStream(InputStream inputStream);

        protected abstract T fromX509DerInputStream(InputStream inputStream);

        protected abstract T fromX509PemInputStream(InputStream inputStream);

        T generateItem(InputStream inputStream) {
            if (inputStream == null) {
                throw new ParsingException("inStream == null");
            }
            boolean markSupported = inputStream.markSupported();
            if (markSupported) {
                inputStream.mark(OpenSSLX509CertificateFactory.PKCS7_MARKER.length);
            }
            PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 64);
            try {
                byte[] bArr = new byte[OpenSSLX509CertificateFactory.PKCS7_MARKER.length];
                int read = pushbackInputStream.read(bArr);
                if (read < 0) {
                    throw new ParsingException("inStream is empty");
                }
                pushbackInputStream.unread(bArr, 0, read);
                if (bArr[0] == 45) {
                    if (read != OpenSSLX509CertificateFactory.PKCS7_MARKER.length || !Arrays.equals(OpenSSLX509CertificateFactory.PKCS7_MARKER, bArr)) {
                        return fromX509PemInputStream(pushbackInputStream);
                    }
                    List<? extends T> fromPkcs7PemInputStream = fromPkcs7PemInputStream(pushbackInputStream);
                    if (fromPkcs7PemInputStream.size() == 0) {
                        return null;
                    }
                    fromPkcs7PemInputStream.get(0);
                }
                if (bArr[4] != 6) {
                    return fromX509DerInputStream(pushbackInputStream);
                }
                List<? extends T> fromPkcs7DerInputStream = fromPkcs7DerInputStream(pushbackInputStream);
                if (fromPkcs7DerInputStream.size() == 0) {
                    return null;
                }
                return fromPkcs7DerInputStream.get(0);
            } catch (Exception e5) {
                if (markSupported) {
                    try {
                        inputStream.reset();
                    } catch (IOException unused) {
                    }
                }
                throw new ParsingException(e5);
            }
        }

        Collection<? extends T> generateItems(InputStream inputStream) {
            T t5;
            if (inputStream == null) {
                throw new ParsingException("inStream == null");
            }
            try {
                if (inputStream.available() == 0) {
                    return new ArrayList();
                }
                boolean markSupported = inputStream.markSupported();
                if (markSupported) {
                    inputStream.mark(64);
                }
                PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream, 64);
                try {
                    byte[] bArr = new byte[OpenSSLX509CertificateFactory.PKCS7_MARKER.length];
                    int read = pushbackInputStream.read(bArr);
                    if (read < 0) {
                        throw new ParsingException("inStream is empty");
                    }
                    pushbackInputStream.unread(bArr, 0, read);
                    if (read == OpenSSLX509CertificateFactory.PKCS7_MARKER.length && Arrays.equals(OpenSSLX509CertificateFactory.PKCS7_MARKER, bArr)) {
                        return fromPkcs7PemInputStream(pushbackInputStream);
                    }
                    if (bArr[4] == 6) {
                        return fromPkcs7DerInputStream(pushbackInputStream);
                    }
                    ArrayList arrayList = new ArrayList();
                    do {
                        if (markSupported) {
                            inputStream.mark(64);
                        }
                        try {
                            t5 = generateItem(pushbackInputStream);
                            arrayList.add(t5);
                        } catch (ParsingException unused) {
                            if (markSupported) {
                                try {
                                    inputStream.reset();
                                } catch (IOException unused2) {
                                }
                            }
                            t5 = null;
                        }
                    } while (t5 != null);
                    return arrayList;
                } catch (Exception e5) {
                    if (markSupported) {
                        try {
                            inputStream.reset();
                        } catch (IOException unused3) {
                        }
                    }
                    throw new ParsingException(e5);
                }
            } catch (IOException e6) {
                throw new ParsingException("Problem reading input stream", e6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ParsingException extends Exception {
        private static final long serialVersionUID = 8390802697728301325L;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ParsingException(String str) {
            super(str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ParsingException(Exception exc) {
            super(exc);
        }

        ParsingException(String str, Exception exc) {
            super(str, exc);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CRL engineGenerateCRL(InputStream inputStream) {
        try {
            return this.crlParser.generateItem(inputStream);
        } catch (ParsingException e5) {
            throw new CRLException(e5);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Collection<? extends CRL> engineGenerateCRLs(InputStream inputStream) {
        if (inputStream == null) {
            return Collections.emptyList();
        }
        try {
            return this.crlParser.generateItems(inputStream);
        } catch (ParsingException e5) {
            throw new CRLException(e5);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(InputStream inputStream) {
        return OpenSSLX509CertPath.fromEncoding(inputStream);
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Certificate engineGenerateCertificate(InputStream inputStream) {
        try {
            return this.certificateParser.generateItem(inputStream);
        } catch (ParsingException e5) {
            throw new CertificateException(e5);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Collection<? extends Certificate> engineGenerateCertificates(InputStream inputStream) {
        try {
            return this.certificateParser.generateItems(inputStream);
        } catch (ParsingException e5) {
            throw new CertificateException(e5);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Iterator<String> engineGetCertPathEncodings() {
        return OpenSSLX509CertPath.getEncodingsIterator();
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(InputStream inputStream, String str) {
        return OpenSSLX509CertPath.fromEncoding(inputStream, str);
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(List<? extends Certificate> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i5 = 0; i5 < list.size(); i5++) {
            Certificate certificate = list.get(i5);
            if (certificate instanceof X509Certificate) {
                arrayList.add((X509Certificate) certificate);
            } else {
                throw new CertificateException("Certificate not X.509 type at index " + i5);
            }
        }
        return new OpenSSLX509CertPath(arrayList);
    }
}
