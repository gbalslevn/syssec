package org.conscrypt;

import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

/* loaded from: classes3.dex */
public final class GCMParameters extends AlgorithmParametersSpi {
    private static final int DEFAULT_TLEN = 96;
    private byte[] iv;
    private int tLen;

    public GCMParameters() {
    }

    @Override // java.security.AlgorithmParametersSpi
    protected byte[] engineGetEncoded() {
        long j5;
        long j6;
        long j7 = 0;
        try {
            j5 = NativeCrypto.asn1_write_init();
        } catch (IOException e5) {
            e = e5;
            j6 = 0;
        } catch (Throwable th) {
            th = th;
            j5 = 0;
        }
        try {
            j7 = NativeCrypto.asn1_write_sequence(j5);
            NativeCrypto.asn1_write_octetstring(j7, this.iv);
            if (this.tLen != DEFAULT_TLEN) {
                NativeCrypto.asn1_write_uint64(j7, r4 / 8);
            }
            byte[] asn1_write_finish = NativeCrypto.asn1_write_finish(j5);
            NativeCrypto.asn1_write_free(j7);
            NativeCrypto.asn1_write_free(j5);
            return asn1_write_finish;
        } catch (IOException e6) {
            e = e6;
            long j8 = j7;
            j7 = j5;
            j6 = j8;
            try {
                NativeCrypto.asn1_write_cleanup(j7);
                throw e;
            } catch (Throwable th2) {
                th = th2;
                long j9 = j7;
                j7 = j6;
                j5 = j9;
                NativeCrypto.asn1_write_free(j7);
                NativeCrypto.asn1_write_free(j5);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            NativeCrypto.asn1_write_free(j7);
            NativeCrypto.asn1_write_free(j5);
            throw th;
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    protected <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) {
        if (cls != null && cls.getName().equals("javax.crypto.spec.GCMParameterSpec")) {
            return cls.cast(Platform.toGCMParameterSpec(this.tLen, this.iv));
        }
        throw new InvalidParameterSpecException("Unsupported class: " + cls);
    }

    @Override // java.security.AlgorithmParametersSpi
    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
        GCMParameters fromGCMParameterSpec = Platform.fromGCMParameterSpec(algorithmParameterSpec);
        if (fromGCMParameterSpec != null) {
            this.tLen = fromGCMParameterSpec.tLen;
            this.iv = fromGCMParameterSpec.iv;
            return;
        }
        throw new InvalidParameterSpecException("Only GCMParameterSpec is supported");
    }

    @Override // java.security.AlgorithmParametersSpi
    protected String engineToString() {
        return "Conscrypt GCM AlgorithmParameters";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getIV() {
        return this.iv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getTLen() {
        return this.tLen;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GCMParameters(int i5, byte[] bArr) {
        this.tLen = i5;
        this.iv = bArr;
    }

    @Override // java.security.AlgorithmParametersSpi
    protected void engineInit(byte[] bArr) {
        long j5;
        try {
            j5 = NativeCrypto.asn1_read_init(bArr);
            try {
                long asn1_read_sequence = NativeCrypto.asn1_read_sequence(j5);
                byte[] asn1_read_octetstring = NativeCrypto.asn1_read_octetstring(asn1_read_sequence);
                int asn1_read_uint64 = !NativeCrypto.asn1_read_is_empty(asn1_read_sequence) ? ((int) NativeCrypto.asn1_read_uint64(asn1_read_sequence)) * 8 : DEFAULT_TLEN;
                if (NativeCrypto.asn1_read_is_empty(asn1_read_sequence) && NativeCrypto.asn1_read_is_empty(j5)) {
                    this.iv = asn1_read_octetstring;
                    this.tLen = asn1_read_uint64;
                    NativeCrypto.asn1_read_free(asn1_read_sequence);
                    NativeCrypto.asn1_read_free(j5);
                    return;
                }
                throw new IOException("Error reading ASN.1 encoding");
            } catch (Throwable th) {
                th = th;
                NativeCrypto.asn1_read_free(0L);
                NativeCrypto.asn1_read_free(j5);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            j5 = 0;
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    protected byte[] engineGetEncoded(String str) {
        if (str != null && !str.equals("ASN.1")) {
            throw new IOException("Unsupported format: " + str);
        }
        return engineGetEncoded();
    }

    @Override // java.security.AlgorithmParametersSpi
    protected void engineInit(byte[] bArr, String str) {
        if (str != null && !str.equals("ASN.1")) {
            throw new IOException("Unsupported format: " + str);
        }
        engineInit(bArr);
    }
}
