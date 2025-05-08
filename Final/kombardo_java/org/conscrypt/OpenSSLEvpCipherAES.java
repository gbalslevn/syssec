package org.conscrypt;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import javax.crypto.NoSuchPaddingException;
import org.conscrypt.OpenSSLCipher;

/* loaded from: classes3.dex */
public abstract class OpenSSLEvpCipherAES extends OpenSSLEvpCipher {
    private static final int AES_BLOCK_SIZE = 16;

    /* renamed from: org.conscrypt.OpenSSLEvpCipherAES$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$conscrypt$OpenSSLCipher$Mode;
        static final /* synthetic */ int[] $SwitchMap$org$conscrypt$OpenSSLCipher$Padding;

        static {
            int[] iArr = new int[OpenSSLCipher.Padding.values().length];
            $SwitchMap$org$conscrypt$OpenSSLCipher$Padding = iArr;
            try {
                iArr[OpenSSLCipher.Padding.NOPADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLCipher$Padding[OpenSSLCipher.Padding.PKCS5PADDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[OpenSSLCipher.Mode.values().length];
            $SwitchMap$org$conscrypt$OpenSSLCipher$Mode = iArr2;
            try {
                iArr2[OpenSSLCipher.Mode.CBC.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLCipher$Mode[OpenSSLCipher.Mode.CTR.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$conscrypt$OpenSSLCipher$Mode[OpenSSLCipher.Mode.ECB.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class AES extends OpenSSLEvpCipherAES {

        /* loaded from: classes3.dex */
        public static class CBC extends AES {

            /* loaded from: classes3.dex */
            public static class NoPadding extends CBC {
                public NoPadding() {
                    super(OpenSSLCipher.Padding.NOPADDING);
                }
            }

            /* loaded from: classes3.dex */
            public static class PKCS5Padding extends CBC {
                public PKCS5Padding() {
                    super(OpenSSLCipher.Padding.PKCS5PADDING);
                }
            }

            CBC(OpenSSLCipher.Padding padding) {
                super(OpenSSLCipher.Mode.CBC, padding);
            }
        }

        /* loaded from: classes3.dex */
        public static class CTR extends AES {
            public CTR() {
                super(OpenSSLCipher.Mode.CTR, OpenSSLCipher.Padding.NOPADDING);
            }
        }

        /* loaded from: classes3.dex */
        public static class ECB extends AES {

            /* loaded from: classes3.dex */
            public static class NoPadding extends ECB {
                public NoPadding() {
                    super(OpenSSLCipher.Padding.NOPADDING);
                }
            }

            /* loaded from: classes3.dex */
            public static class PKCS5Padding extends ECB {
                public PKCS5Padding() {
                    super(OpenSSLCipher.Padding.PKCS5PADDING);
                }
            }

            ECB(OpenSSLCipher.Padding padding) {
                super(OpenSSLCipher.Mode.ECB, padding);
            }
        }

        AES(OpenSSLCipher.Mode mode, OpenSSLCipher.Padding padding) {
            super(mode, padding);
        }

        @Override // org.conscrypt.OpenSSLCipher
        void checkSupportedKeySize(int i5) {
            if (i5 == 16 || i5 == 24 || i5 == 32) {
                return;
            }
            throw new InvalidKeyException("Unsupported key size: " + i5 + " bytes");
        }
    }

    /* loaded from: classes3.dex */
    public static class AES_128 extends OpenSSLEvpCipherAES {

        /* loaded from: classes3.dex */
        public static class CBC extends AES_128 {

            /* loaded from: classes3.dex */
            public static class NoPadding extends CBC {
                public NoPadding() {
                    super(OpenSSLCipher.Padding.NOPADDING);
                }
            }

            /* loaded from: classes3.dex */
            public static class PKCS5Padding extends CBC {
                public PKCS5Padding() {
                    super(OpenSSLCipher.Padding.PKCS5PADDING);
                }
            }

            CBC(OpenSSLCipher.Padding padding) {
                super(OpenSSLCipher.Mode.CBC, padding);
            }
        }

        /* loaded from: classes3.dex */
        public static class CTR extends AES_128 {
            public CTR() {
                super(OpenSSLCipher.Mode.CTR, OpenSSLCipher.Padding.NOPADDING);
            }
        }

        /* loaded from: classes3.dex */
        public static class ECB extends AES_128 {

            /* loaded from: classes3.dex */
            public static class NoPadding extends ECB {
                public NoPadding() {
                    super(OpenSSLCipher.Padding.NOPADDING);
                }
            }

            /* loaded from: classes3.dex */
            public static class PKCS5Padding extends ECB {
                public PKCS5Padding() {
                    super(OpenSSLCipher.Padding.PKCS5PADDING);
                }
            }

            ECB(OpenSSLCipher.Padding padding) {
                super(OpenSSLCipher.Mode.ECB, padding);
            }
        }

        AES_128(OpenSSLCipher.Mode mode, OpenSSLCipher.Padding padding) {
            super(mode, padding);
        }

        @Override // org.conscrypt.OpenSSLCipher
        void checkSupportedKeySize(int i5) {
            if (i5 == 16) {
                return;
            }
            throw new InvalidKeyException("Unsupported key size: " + i5 + " bytes");
        }
    }

    /* loaded from: classes3.dex */
    public static class AES_256 extends OpenSSLEvpCipherAES {

        /* loaded from: classes3.dex */
        public static class CBC extends AES_256 {

            /* loaded from: classes3.dex */
            public static class NoPadding extends CBC {
                public NoPadding() {
                    super(OpenSSLCipher.Padding.NOPADDING);
                }
            }

            /* loaded from: classes3.dex */
            public static class PKCS5Padding extends CBC {
                public PKCS5Padding() {
                    super(OpenSSLCipher.Padding.PKCS5PADDING);
                }
            }

            CBC(OpenSSLCipher.Padding padding) {
                super(OpenSSLCipher.Mode.CBC, padding);
            }
        }

        /* loaded from: classes3.dex */
        public static class CTR extends AES_256 {
            public CTR() {
                super(OpenSSLCipher.Mode.CTR, OpenSSLCipher.Padding.NOPADDING);
            }
        }

        /* loaded from: classes3.dex */
        public static class ECB extends AES_256 {

            /* loaded from: classes3.dex */
            public static class NoPadding extends ECB {
                public NoPadding() {
                    super(OpenSSLCipher.Padding.NOPADDING);
                }
            }

            /* loaded from: classes3.dex */
            public static class PKCS5Padding extends ECB {
                public PKCS5Padding() {
                    super(OpenSSLCipher.Padding.PKCS5PADDING);
                }
            }

            ECB(OpenSSLCipher.Padding padding) {
                super(OpenSSLCipher.Mode.ECB, padding);
            }
        }

        AES_256(OpenSSLCipher.Mode mode, OpenSSLCipher.Padding padding) {
            super(mode, padding);
        }

        @Override // org.conscrypt.OpenSSLCipher
        void checkSupportedKeySize(int i5) {
            if (i5 == 32) {
                return;
            }
            throw new InvalidKeyException("Unsupported key size: " + i5 + " bytes");
        }
    }

    OpenSSLEvpCipherAES(OpenSSLCipher.Mode mode, OpenSSLCipher.Padding padding) {
        super(mode, padding);
    }

    @Override // org.conscrypt.OpenSSLCipher
    void checkSupportedMode(OpenSSLCipher.Mode mode) {
        int i5 = AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLCipher$Mode[mode.ordinal()];
        if (i5 == 1 || i5 == 2 || i5 == 3) {
            return;
        }
        throw new NoSuchAlgorithmException("Unsupported mode " + mode.toString());
    }

    @Override // org.conscrypt.OpenSSLCipher
    void checkSupportedPadding(OpenSSLCipher.Padding padding) {
        int i5 = AnonymousClass1.$SwitchMap$org$conscrypt$OpenSSLCipher$Padding[padding.ordinal()];
        if (i5 == 1 || i5 == 2) {
            return;
        }
        throw new NoSuchPaddingException("Unsupported padding " + padding.toString());
    }

    @Override // org.conscrypt.OpenSSLCipher
    String getBaseCipherName() {
        return "AES";
    }

    @Override // org.conscrypt.OpenSSLCipher
    int getCipherBlockSize() {
        return 16;
    }

    @Override // org.conscrypt.OpenSSLEvpCipher
    String getCipherName(int i5, OpenSSLCipher.Mode mode) {
        return "aes-" + (i5 * 8) + "-" + mode.toString().toLowerCase(Locale.US);
    }
}
