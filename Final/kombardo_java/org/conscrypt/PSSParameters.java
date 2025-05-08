package org.conscrypt;

import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;

/* loaded from: classes3.dex */
public class PSSParameters extends AlgorithmParametersSpi {
    private PSSParameterSpec spec = PSSParameterSpec.DEFAULT;

    @Override // java.security.AlgorithmParametersSpi
    protected byte[] engineGetEncoded() {
        long j5;
        Throwable th;
        long j6;
        IOException e5;
        long j7 = 0;
        try {
            try {
                j6 = NativeCrypto.asn1_write_init();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                long asn1_write_sequence = NativeCrypto.asn1_write_sequence(j6);
                try {
                    OAEPParameters.writeHashAndMgfHash(asn1_write_sequence, this.spec.getDigestAlgorithm(), (MGF1ParameterSpec) this.spec.getMGFParameters());
                    if (this.spec.getSaltLength() != 20) {
                        try {
                            j7 = NativeCrypto.asn1_write_tag(asn1_write_sequence, 2);
                            NativeCrypto.asn1_write_uint64(j7, this.spec.getSaltLength());
                            NativeCrypto.asn1_write_flush(asn1_write_sequence);
                            NativeCrypto.asn1_write_free(j7);
                        } catch (Throwable th3) {
                            NativeCrypto.asn1_write_flush(asn1_write_sequence);
                            NativeCrypto.asn1_write_free(j7);
                            throw th3;
                        }
                    }
                    byte[] asn1_write_finish = NativeCrypto.asn1_write_finish(j6);
                    NativeCrypto.asn1_write_free(asn1_write_sequence);
                    NativeCrypto.asn1_write_free(j6);
                    return asn1_write_finish;
                } catch (IOException e6) {
                    e5 = e6;
                    NativeCrypto.asn1_write_cleanup(j6);
                    throw e5;
                }
            } catch (IOException e7) {
                e5 = e7;
            } catch (Throwable th4) {
                th = th4;
                j5 = 0;
                NativeCrypto.asn1_write_free(j5);
                NativeCrypto.asn1_write_free(j6);
                throw th;
            }
        } catch (IOException e8) {
            e5 = e8;
            j6 = 0;
        } catch (Throwable th5) {
            j5 = 0;
            th = th5;
            j6 = 0;
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    protected <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) {
        if (cls != null && cls == PSSParameterSpec.class) {
            return this.spec;
        }
        throw new InvalidParameterSpecException("Unsupported class: " + cls);
    }

    @Override // java.security.AlgorithmParametersSpi
    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
        if (algorithmParameterSpec instanceof PSSParameterSpec) {
            this.spec = (PSSParameterSpec) algorithmParameterSpec;
            return;
        }
        throw new InvalidParameterSpecException("Only PSSParameterSpec is supported");
    }

    @Override // java.security.AlgorithmParametersSpi
    protected String engineToString() {
        return "Conscrypt PSS AlgorithmParameters";
    }

    @Override // java.security.AlgorithmParametersSpi
    protected void engineInit(byte[] bArr) {
        long j5;
        long asn1_read_sequence;
        int asn1_read_uint64;
        long j6 = 0;
        try {
            j5 = NativeCrypto.asn1_read_init(bArr);
            try {
                asn1_read_sequence = NativeCrypto.asn1_read_sequence(j5);
            } catch (Throwable th) {
                th = th;
            }
            try {
                String readHash = OAEPParameters.readHash(asn1_read_sequence);
                String readMgfHash = OAEPParameters.readMgfHash(asn1_read_sequence);
                if (NativeCrypto.asn1_read_next_tag_is(asn1_read_sequence, 2)) {
                    try {
                        long asn1_read_tagged = NativeCrypto.asn1_read_tagged(asn1_read_sequence);
                        try {
                            asn1_read_uint64 = (int) NativeCrypto.asn1_read_uint64(asn1_read_tagged);
                            NativeCrypto.asn1_read_free(asn1_read_tagged);
                        } catch (Throwable th2) {
                            th = th2;
                            j6 = asn1_read_tagged;
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    asn1_read_uint64 = 20;
                }
                int i5 = asn1_read_uint64;
                if (NativeCrypto.asn1_read_next_tag_is(asn1_read_sequence, 3)) {
                    try {
                        j6 = NativeCrypto.asn1_read_tagged(asn1_read_sequence);
                        long asn1_read_uint642 = (int) NativeCrypto.asn1_read_uint64(j6);
                        NativeCrypto.asn1_read_free(j6);
                        if (asn1_read_uint642 != 1) {
                            throw new IOException("Error reading ASN.1 encoding");
                        }
                    } finally {
                        NativeCrypto.asn1_read_free(j6);
                    }
                }
                if (NativeCrypto.asn1_read_is_empty(asn1_read_sequence) && NativeCrypto.asn1_read_is_empty(j5)) {
                    this.spec = new PSSParameterSpec(readHash, "MGF1", new MGF1ParameterSpec(readMgfHash), i5, 1);
                    NativeCrypto.asn1_read_free(asn1_read_sequence);
                    NativeCrypto.asn1_read_free(j5);
                    return;
                }
                throw new IOException("Error reading ASN.1 encoding");
            } catch (Throwable th4) {
                th = th4;
                j6 = asn1_read_sequence;
                NativeCrypto.asn1_read_free(j6);
                NativeCrypto.asn1_read_free(j5);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            j5 = 0;
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    protected byte[] engineGetEncoded(String str) {
        if (str != null && !str.equals("ASN.1") && !str.equals("X.509")) {
            throw new IOException("Unsupported format: " + str);
        }
        return engineGetEncoded();
    }

    @Override // java.security.AlgorithmParametersSpi
    protected void engineInit(byte[] bArr, String str) {
        if (str != null && !str.equals("ASN.1") && !str.equals("X.509")) {
            throw new IOException("Unsupported format: " + str);
        }
        engineInit(bArr);
    }
}
