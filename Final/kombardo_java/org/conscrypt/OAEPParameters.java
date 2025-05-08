package org.conscrypt;

import com.adjust.sdk.Constants;
import java.io.IOException;
import java.security.AlgorithmParametersSpi;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

/* loaded from: classes3.dex */
public class OAEPParameters extends AlgorithmParametersSpi {
    private static final String MGF1_OID = "1.2.840.113549.1.1.8";
    private static final Map<String, String> NAME_TO_OID;
    private static final Map<String, String> OID_TO_NAME;
    private static final String PSPECIFIED_OID = "1.2.840.113549.1.1.9";
    private OAEPParameterSpec spec = OAEPParameterSpec.DEFAULT;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        HashMap hashMap = new HashMap();
        OID_TO_NAME = hashMap;
        NAME_TO_OID = new HashMap();
        hashMap.put("1.3.14.3.2.26", "SHA-1");
        hashMap.put("2.16.840.1.101.3.4.2.4", "SHA-224");
        hashMap.put("2.16.840.1.101.3.4.2.1", Constants.SHA256);
        hashMap.put("2.16.840.1.101.3.4.2.2", "SHA-384");
        hashMap.put("2.16.840.1.101.3.4.2.3", "SHA-512");
        for (Map.Entry entry : hashMap.entrySet()) {
            NAME_TO_OID.put(entry.getValue(), entry.getKey());
        }
    }

    private static String getHashName(long j5) {
        long j6;
        try {
            j6 = NativeCrypto.asn1_read_sequence(j5);
            try {
                String asn1_read_oid = NativeCrypto.asn1_read_oid(j6);
                if (!NativeCrypto.asn1_read_is_empty(j6)) {
                    NativeCrypto.asn1_read_null(j6);
                }
                if (NativeCrypto.asn1_read_is_empty(j6)) {
                    Map<String, String> map = OID_TO_NAME;
                    if (map.containsKey(asn1_read_oid)) {
                        String str = map.get(asn1_read_oid);
                        NativeCrypto.asn1_read_free(j6);
                        return str;
                    }
                }
                throw new IOException("Error reading ASN.1 encoding");
            } catch (Throwable th) {
                th = th;
                NativeCrypto.asn1_read_free(j6);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            j6 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String readHash(long j5) {
        long j6;
        if (!NativeCrypto.asn1_read_next_tag_is(j5, 0)) {
            return "SHA-1";
        }
        try {
            j6 = NativeCrypto.asn1_read_tagged(j5);
            try {
                String hashName = getHashName(j6);
                NativeCrypto.asn1_read_free(j6);
                return hashName;
            } catch (Throwable th) {
                th = th;
                NativeCrypto.asn1_read_free(j6);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            j6 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String readMgfHash(long j5) {
        long j6;
        if (!NativeCrypto.asn1_read_next_tag_is(j5, 1)) {
            return "SHA-1";
        }
        try {
            j6 = NativeCrypto.asn1_read_tagged(j5);
            try {
                long asn1_read_sequence = NativeCrypto.asn1_read_sequence(j6);
                if (!NativeCrypto.asn1_read_oid(asn1_read_sequence).equals(MGF1_OID)) {
                    throw new IOException("Error reading ASN.1 encoding");
                }
                String hashName = getHashName(asn1_read_sequence);
                if (!NativeCrypto.asn1_read_is_empty(asn1_read_sequence)) {
                    throw new IOException("Error reading ASN.1 encoding");
                }
                NativeCrypto.asn1_read_free(asn1_read_sequence);
                NativeCrypto.asn1_read_free(j6);
                return hashName;
            } catch (Throwable th) {
                th = th;
                NativeCrypto.asn1_read_free(0L);
                NativeCrypto.asn1_read_free(j6);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            j6 = 0;
        }
    }

    private static long writeAlgorithmIdentifier(long j5, String str) {
        long j6;
        try {
            j6 = NativeCrypto.asn1_write_sequence(j5);
        } catch (IOException e5) {
            e = e5;
            j6 = 0;
        }
        try {
            NativeCrypto.asn1_write_oid(j6, str);
            return j6;
        } catch (IOException e6) {
            e = e6;
            NativeCrypto.asn1_write_free(j6);
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeHashAndMgfHash(long j5, String str, MGF1ParameterSpec mGF1ParameterSpec) {
        long j6;
        long j7;
        long j8;
        long j9 = 0;
        if (!str.equals("SHA-1")) {
            try {
                j8 = NativeCrypto.asn1_write_tag(j5, 0);
                try {
                    long writeAlgorithmIdentifier = writeAlgorithmIdentifier(j8, NAME_TO_OID.get(str));
                    try {
                        NativeCrypto.asn1_write_null(writeAlgorithmIdentifier);
                        NativeCrypto.asn1_write_flush(j5);
                        NativeCrypto.asn1_write_free(writeAlgorithmIdentifier);
                        NativeCrypto.asn1_write_free(j8);
                    } catch (Throwable th) {
                        th = th;
                        j9 = writeAlgorithmIdentifier;
                        NativeCrypto.asn1_write_flush(j5);
                        NativeCrypto.asn1_write_free(j9);
                        NativeCrypto.asn1_write_free(j8);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                j8 = 0;
            }
        }
        if (mGF1ParameterSpec.getDigestAlgorithm().equals("SHA-1")) {
            return;
        }
        try {
            j6 = NativeCrypto.asn1_write_tag(j5, 1);
            try {
                j7 = writeAlgorithmIdentifier(j6, MGF1_OID);
            } catch (Throwable th4) {
                th = th4;
                j7 = 0;
            }
        } catch (Throwable th5) {
            th = th5;
            j6 = 0;
            j7 = 0;
        }
        try {
            j9 = writeAlgorithmIdentifier(j7, NAME_TO_OID.get(mGF1ParameterSpec.getDigestAlgorithm()));
            NativeCrypto.asn1_write_null(j9);
            NativeCrypto.asn1_write_flush(j5);
            NativeCrypto.asn1_write_free(j9);
            NativeCrypto.asn1_write_free(j7);
            NativeCrypto.asn1_write_free(j6);
        } catch (Throwable th6) {
            th = th6;
            NativeCrypto.asn1_write_flush(j5);
            NativeCrypto.asn1_write_free(j9);
            NativeCrypto.asn1_write_free(j7);
            NativeCrypto.asn1_write_free(j6);
            throw th;
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    protected byte[] engineGetEncoded() {
        long j5;
        Throwable th;
        long j6;
        IOException e5;
        long j7;
        long j8 = 0;
        try {
            try {
                j6 = NativeCrypto.asn1_write_init();
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                long asn1_write_sequence = NativeCrypto.asn1_write_sequence(j6);
                try {
                    writeHashAndMgfHash(asn1_write_sequence, this.spec.getDigestAlgorithm(), (MGF1ParameterSpec) this.spec.getMGFParameters());
                    PSource.PSpecified pSpecified = (PSource.PSpecified) this.spec.getPSource();
                    if (pSpecified.getValue().length != 0) {
                        try {
                            j7 = NativeCrypto.asn1_write_tag(asn1_write_sequence, 2);
                            try {
                                j8 = writeAlgorithmIdentifier(j7, PSPECIFIED_OID);
                                NativeCrypto.asn1_write_octetstring(j8, pSpecified.getValue());
                                NativeCrypto.asn1_write_flush(asn1_write_sequence);
                                NativeCrypto.asn1_write_free(j8);
                                NativeCrypto.asn1_write_free(j7);
                            } catch (Throwable th3) {
                                th = th3;
                                NativeCrypto.asn1_write_flush(asn1_write_sequence);
                                NativeCrypto.asn1_write_free(j8);
                                NativeCrypto.asn1_write_free(j7);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            j7 = 0;
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
            } catch (Throwable th5) {
                th = th5;
                j5 = 0;
                NativeCrypto.asn1_write_free(j5);
                NativeCrypto.asn1_write_free(j6);
                throw th;
            }
        } catch (IOException e8) {
            e5 = e8;
            j6 = 0;
        } catch (Throwable th6) {
            j5 = 0;
            th = th6;
            j6 = 0;
        }
    }

    @Override // java.security.AlgorithmParametersSpi
    protected <T extends AlgorithmParameterSpec> T engineGetParameterSpec(Class<T> cls) {
        if (cls != null && cls == OAEPParameterSpec.class) {
            return this.spec;
        }
        throw new InvalidParameterSpecException("Unsupported class: " + cls);
    }

    @Override // java.security.AlgorithmParametersSpi
    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec) {
        if (algorithmParameterSpec instanceof OAEPParameterSpec) {
            this.spec = (OAEPParameterSpec) algorithmParameterSpec;
            return;
        }
        throw new InvalidParameterSpecException("Only OAEPParameterSpec is supported");
    }

    @Override // java.security.AlgorithmParametersSpi
    protected String engineToString() {
        return "Conscrypt OAEP AlgorithmParameters";
    }

    @Override // java.security.AlgorithmParametersSpi
    protected void engineInit(byte[] bArr) {
        long j5;
        long j6;
        long j7 = 0;
        try {
            j5 = NativeCrypto.asn1_read_init(bArr);
            try {
                long asn1_read_sequence = NativeCrypto.asn1_read_sequence(j5);
                try {
                    PSource.PSpecified pSpecified = PSource.PSpecified.DEFAULT;
                    String readHash = readHash(asn1_read_sequence);
                    String readMgfHash = readMgfHash(asn1_read_sequence);
                    if (NativeCrypto.asn1_read_next_tag_is(asn1_read_sequence, 2)) {
                        try {
                            j6 = NativeCrypto.asn1_read_tagged(asn1_read_sequence);
                            try {
                                long asn1_read_sequence2 = NativeCrypto.asn1_read_sequence(j6);
                                if (NativeCrypto.asn1_read_oid(asn1_read_sequence2).equals(PSPECIFIED_OID)) {
                                    pSpecified = new PSource.PSpecified(NativeCrypto.asn1_read_octetstring(asn1_read_sequence2));
                                    if (NativeCrypto.asn1_read_is_empty(asn1_read_sequence2)) {
                                        NativeCrypto.asn1_read_free(asn1_read_sequence2);
                                        NativeCrypto.asn1_read_free(j6);
                                    } else {
                                        throw new IOException("Error reading ASN.1 encoding");
                                    }
                                } else {
                                    throw new IOException("Error reading ASN.1 encoding");
                                }
                            } catch (Throwable th) {
                                th = th;
                                NativeCrypto.asn1_read_free(0L);
                                NativeCrypto.asn1_read_free(j6);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            j6 = 0;
                        }
                    }
                    if (NativeCrypto.asn1_read_is_empty(asn1_read_sequence) && NativeCrypto.asn1_read_is_empty(j5)) {
                        this.spec = new OAEPParameterSpec(readHash, "MGF1", new MGF1ParameterSpec(readMgfHash), pSpecified);
                        NativeCrypto.asn1_read_free(asn1_read_sequence);
                        NativeCrypto.asn1_read_free(j5);
                        return;
                    }
                    throw new IOException("Error reading ASN.1 encoding");
                } catch (Throwable th3) {
                    th = th3;
                    j7 = asn1_read_sequence;
                    NativeCrypto.asn1_read_free(j7);
                    NativeCrypto.asn1_read_free(j5);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
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
