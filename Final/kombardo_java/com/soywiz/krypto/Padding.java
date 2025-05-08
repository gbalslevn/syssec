package com.soywiz.krypto;

import com.soywiz.krypto.internal.KryptoToolsKt;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.random.Random;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/soywiz/krypto/Padding;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "NoPadding", "PKCS7Padding", "ANSIX923Padding", "ISO10126Padding", "ZeroPadding", "Companion", "krypto_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public enum Padding {
    NoPadding,
    PKCS7Padding,
    ANSIX923Padding,
    ISO10126Padding,
    ZeroPadding;


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\b¨\u0006\n"}, d2 = {"Lcom/soywiz/krypto/Padding$Companion;", BuildConfig.FLAVOR, "()V", "padding", BuildConfig.FLAVOR, "data", "blockSize", BuildConfig.FLAVOR, "Lcom/soywiz/krypto/Padding;", "removePadding", "krypto_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Padding.values().length];
                iArr[Padding.NoPadding.ordinal()] = 1;
                iArr[Padding.PKCS7Padding.ordinal()] = 2;
                iArr[Padding.ANSIX923Padding.ordinal()] = 3;
                iArr[Padding.ISO10126Padding.ordinal()] = 4;
                iArr[Padding.ZeroPadding.ordinal()] = 5;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final byte[] padding(byte[] data, int blockSize, Padding padding) {
            int length = padding == Padding.NoPadding ? 0 : blockSize - (data.length % blockSize);
            int length2 = data.length + length;
            byte[] bArr = new byte[length2];
            KryptoToolsKt.arraycopy(data, 0, bArr, 0, data.length);
            int i5 = WhenMappings.$EnumSwitchMapping$0[padding.ordinal()];
            if (i5 != 1) {
                if (i5 == 2) {
                    for (int length3 = data.length; length3 < length2; length3++) {
                        bArr[length3] = (byte) length;
                    }
                } else if (i5 == 3) {
                    bArr[length2 - 1] = (byte) length;
                } else if (i5 == 4) {
                    byte[] nextBytes = Random.INSTANCE.nextBytes(length);
                    nextBytes[length - 1] = (byte) length;
                    KryptoToolsKt.arraycopy(nextBytes, 0, bArr, data.length, nextBytes.length);
                } else if (i5 != 5) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return bArr;
        }

        public final byte[] removePadding(byte[] data, Padding padding) {
            int i5 = WhenMappings.$EnumSwitchMapping$0[padding.ordinal()];
            if (i5 == 1) {
                return data;
            }
            if (i5 == 2 || i5 == 3 || i5 == 4) {
                int length = data.length - (data[data.length - 1] & Function.USE_VARARGS);
                byte[] bArr = new byte[length];
                KryptoToolsKt.arraycopy(data, 0, bArr, 0, length);
                return bArr;
            }
            if (i5 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            int length2 = data.length - 1;
            int i6 = 0;
            if (length2 >= 0) {
                while (true) {
                    int i7 = length2 - 1;
                    if (data[length2] != 0) {
                        break;
                    }
                    i6++;
                    if (i7 < 0) {
                        break;
                    }
                    length2 = i7;
                }
            }
            int length3 = data.length - i6;
            byte[] bArr2 = new byte[length3];
            KryptoToolsKt.arraycopy(data, 0, bArr2, 0, length3);
            return bArr2;
        }

        private Companion() {
        }
    }
}
