package com.soywiz.krypto;

import android.R;
import com.soywiz.krypto.internal.KryptoToolsKt;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000bJH\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0016\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000bR\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/soywiz/krypto/AES;", BuildConfig.FLAVOR, "key", BuildConfig.FLAVOR, "([B)V", "keyWords", BuildConfig.FLAVOR, "([I)V", "invKeySchedule", "keySchedule", "keySize", BuildConfig.FLAVOR, "getKeyWords", "()[I", "ksRows", "numRounds", "decryptBlock", BuildConfig.FLAVOR, "M", "offset", "doCryptBlock", "SUB_MIX_0", "SUB_MIX_1", "SUB_MIX_2", "SUB_MIX_3", "SBOX", "encryptBlock", "Companion", "krypto_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AES {
    private static final int BLOCK_SIZE = 16;
    private final int[] invKeySchedule;
    private final int[] keySchedule;
    private final int keySize;
    private final int[] keyWords;
    private final int ksRows;
    private final int numRounds;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] SBOX = new int[256];
    private static final int[] INV_SBOX = new int[256];
    private static final int[] SUB_MIX_0 = new int[256];
    private static final int[] SUB_MIX_1 = new int[256];
    private static final int[] SUB_MIX_2 = new int[256];
    private static final int[] SUB_MIX_3 = new int[256];
    private static final int[] INV_SUB_MIX_0 = new int[256];
    private static final int[] INV_SUB_MIX_1 = new int[256];
    private static final int[] INV_SUB_MIX_2 = new int[256];
    private static final int[] INV_SUB_MIX_3 = new int[256];
    private static final int[] RCON = {0, 1, 2, 4, 8, 16, 32, 64, 128, 27, 54};

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0015\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\b\u001a\u00020\u0004*\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0014\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u0014\u0010\u001f\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0014\u0010 \u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0019R\u0014\u0010!\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0019R\u0014\u0010\"\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0019R\u0014\u0010#\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0019¨\u0006$"}, d2 = {"Lcom/soywiz/krypto/AES$Companion;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "toIntArray", "([B)[I", "toByteArray", "([I)[B", "srcIV", "getIV", "([B)[B", "data", "key", "iv", "Lcom/soywiz/krypto/Padding;", "padding", "encryptAesCbc", "([B[B[BLcom/soywiz/krypto/Padding;)[B", "decryptAesCbc", BuildConfig.FLAVOR, "BLOCK_SIZE", "I", "INV_SBOX", "[I", "INV_SUB_MIX_0", "INV_SUB_MIX_1", "INV_SUB_MIX_2", "INV_SUB_MIX_3", "RCON", "SBOX", "SUB_MIX_0", "SUB_MIX_1", "SUB_MIX_2", "SUB_MIX_3", "krypto_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final byte[] getIV(byte[] srcIV) {
            byte[] bArr = new byte[16];
            if (srcIV != null) {
                KryptoToolsKt.arraycopy(srcIV, 0, bArr, 0, srcIV.length < 16 ? srcIV.length : 16);
            }
            return bArr;
        }

        private final byte[] toByteArray(int[] iArr) {
            byte[] bArr = new byte[iArr.length * 4];
            int length = iArr.length;
            int i5 = 0;
            int i6 = 0;
            while (i5 < length) {
                int i7 = i5 + 1;
                int i8 = iArr[i5];
                bArr[i6] = (byte) ((i8 >> 24) & Function.USE_VARARGS);
                bArr[i6 + 1] = (byte) ((i8 >> 16) & Function.USE_VARARGS);
                int i9 = i6 + 3;
                bArr[i6 + 2] = (byte) ((i8 >> 8) & Function.USE_VARARGS);
                i6 += 4;
                bArr[i9] = (byte) (i8 & Function.USE_VARARGS);
                i5 = i7;
            }
            return bArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int[] toIntArray(byte[] bArr) {
            int length = bArr.length / 4;
            int[] iArr = new int[length];
            int i5 = 0;
            for (int i6 = 0; i6 < length; i6++) {
                int i7 = bArr[i5] & 255;
                int i8 = bArr[i5 + 1] & 255;
                int i9 = i5 + 3;
                int i10 = bArr[i5 + 2] & 255;
                i5 += 4;
                iArr[i6] = (i8 << 16) | (i10 << 8) | (bArr[i9] & 255) | (i7 << 24);
            }
            return iArr;
        }

        public final byte[] decryptAesCbc(byte[] data, byte[] key, byte[] iv, Padding padding) {
            AES aes = new AES(key);
            int[] intArray = toIntArray(data);
            int length = intArray.length;
            int[] intArray2 = toIntArray(getIV(iv));
            int i5 = intArray2[0];
            int i6 = intArray2[1];
            int i7 = intArray2[2];
            int i8 = intArray2[3];
            IntProgression step = RangesKt.step(RangesKt.until(0, length), 4);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                while (true) {
                    int i9 = first + step2;
                    int i10 = intArray[first];
                    int i11 = first + 1;
                    int i12 = intArray[i11];
                    int i13 = first + 2;
                    int i14 = intArray[i13];
                    int i15 = first + 3;
                    int i16 = intArray[i15];
                    aes.decryptBlock(intArray, first);
                    intArray[first] = intArray[first] ^ i5;
                    intArray[i11] = intArray[i11] ^ i6;
                    intArray[i13] = intArray[i13] ^ i7;
                    intArray[i15] = i8 ^ intArray[i15];
                    if (first == last) {
                        break;
                    }
                    first = i9;
                    i5 = i10;
                    i6 = i12;
                    i7 = i14;
                    i8 = i16;
                }
            }
            return Padding.INSTANCE.removePadding(toByteArray(intArray), padding);
        }

        public final byte[] encryptAesCbc(byte[] data, byte[] key, byte[] iv, Padding padding) {
            byte[] padding2 = Padding.INSTANCE.padding(data, 16, padding);
            AES aes = new AES(key);
            int[] intArray = toIntArray(padding2);
            int length = intArray.length;
            int[] intArray2 = toIntArray(getIV(iv));
            if (intArray.length % 4 != 0) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Data is not multiple of 16, and padding was set to ", Padding.NoPadding));
            }
            int i5 = intArray2[0];
            int i6 = intArray2[1];
            int i7 = intArray2[2];
            int i8 = intArray2[3];
            IntProgression step = RangesKt.step(RangesKt.until(0, length), 4);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                while (true) {
                    int i9 = first + step2;
                    intArray[first] = i5 ^ intArray[first];
                    int i10 = first + 1;
                    intArray[i10] = i6 ^ intArray[i10];
                    int i11 = first + 2;
                    intArray[i11] = i7 ^ intArray[i11];
                    int i12 = first + 3;
                    intArray[i12] = i8 ^ intArray[i12];
                    aes.encryptBlock(intArray, first);
                    int i13 = intArray[first];
                    int i14 = intArray[i10];
                    int i15 = intArray[i11];
                    int i16 = intArray[i12];
                    if (first == last) {
                        break;
                    }
                    first = i9;
                    i5 = i13;
                    i8 = i16;
                    i7 = i15;
                    i6 = i14;
                }
            }
            return toByteArray(intArray);
        }

        private Companion() {
        }
    }

    static {
        int i5 = 0;
        int[] iArr = new int[256];
        for (int i6 = 0; i6 < 256; i6++) {
            int i7 = i6 << 1;
            if (i6 >= 128) {
                i7 ^= 283;
            }
            iArr[i6] = i7;
        }
        int i8 = 0;
        while (true) {
            int i9 = i8;
            while (i5 < 256) {
                i5++;
                int i10 = ((((i8 << 1) ^ i8) ^ (i8 << 2)) ^ (i8 << 3)) ^ (i8 << 4);
                int i11 = ((i10 & Function.USE_VARARGS) ^ (i10 >>> 8)) ^ 99;
                SBOX[i9] = i11;
                INV_SBOX[i11] = i9;
                int i12 = iArr[i9];
                int i13 = iArr[i12];
                int i14 = iArr[i13];
                int i15 = (iArr[i11] * 257) ^ (i11 * R.attr.transcriptMode);
                SUB_MIX_0[i9] = (i15 << 24) | (i15 >>> 8);
                SUB_MIX_1[i9] = (i15 << 16) | (i15 >>> 16);
                SUB_MIX_2[i9] = (i15 << 8) | (i15 >>> 24);
                SUB_MIX_3[i9] = i15;
                int i16 = (((i13 * 65537) ^ (R.attr.cacheColorHint * i14)) ^ (i12 * 257)) ^ (R.attr.transcriptMode * i9);
                INV_SUB_MIX_0[i11] = (i16 << 24) | (i16 >>> 8);
                INV_SUB_MIX_1[i11] = (i16 << 16) | (i16 >>> 16);
                INV_SUB_MIX_2[i11] = (i16 << 8) | (i16 >>> 24);
                INV_SUB_MIX_3[i11] = i16;
                if (i9 == 0) {
                    break;
                }
                i9 = iArr[iArr[iArr[i14 ^ i12]]] ^ i12;
                i8 ^= iArr[iArr[i8]];
            }
            return;
            i8 = 1;
        }
    }

    public AES(int[] iArr) {
        int i5;
        this.keyWords = iArr;
        int length = iArr.length;
        this.keySize = length;
        this.numRounds = length + 6;
        int i6 = (length + 7) * 4;
        this.ksRows = i6;
        int[] iArr2 = new int[i6];
        int i7 = 0;
        int i8 = 0;
        while (i8 < i6) {
            int i9 = i8 + 1;
            int i10 = this.keySize;
            if (i8 < i10) {
                i5 = getKeyWords()[i8];
            } else {
                int i11 = iArr2[i8 - 1];
                if (i8 % i10 == 0) {
                    int i12 = (i11 >>> 24) | (i11 << 8);
                    int[] iArr3 = SBOX;
                    i11 = (iArr3[i12 & Function.USE_VARARGS] | (((iArr3[(i12 >>> 24) & Function.USE_VARARGS] << 24) | (iArr3[(i12 >>> 16) & Function.USE_VARARGS] << 16)) | (iArr3[(i12 >>> 8) & Function.USE_VARARGS] << 8))) ^ (RCON[i8 / i10] << 24);
                } else if (i10 > 6 && i8 % i10 == 4) {
                    int[] iArr4 = SBOX;
                    i11 = iArr4[i11 & Function.USE_VARARGS] | (iArr4[(i11 >>> 24) & Function.USE_VARARGS] << 24) | (iArr4[(i11 >>> 16) & Function.USE_VARARGS] << 16) | (iArr4[(i11 >>> 8) & Function.USE_VARARGS] << 8);
                }
                i5 = iArr2[i8 - i10] ^ i11;
            }
            iArr2[i8] = i5;
            i8 = i9;
        }
        this.keySchedule = iArr2;
        int i13 = this.ksRows;
        int[] iArr5 = new int[i13];
        while (i7 < i13) {
            int i14 = i7 + 1;
            int i15 = this.ksRows - i7;
            int i16 = i7 % 4 != 0 ? this.keySchedule[i15] : this.keySchedule[i15 - 4];
            if (i7 >= 4 && i15 > 4) {
                int[] iArr6 = INV_SUB_MIX_0;
                int[] iArr7 = SBOX;
                i16 = INV_SUB_MIX_3[iArr7[i16 & Function.USE_VARARGS]] ^ ((iArr6[iArr7[(i16 >>> 24) & Function.USE_VARARGS]] ^ INV_SUB_MIX_1[iArr7[(i16 >>> 16) & Function.USE_VARARGS]]) ^ INV_SUB_MIX_2[iArr7[(i16 >>> 8) & Function.USE_VARARGS]]);
            }
            iArr5[i7] = i16;
            i7 = i14;
        }
        this.invKeySchedule = iArr5;
    }

    private final void doCryptBlock(int[] M4, int offset, int[] keySchedule, int[] SUB_MIX_02, int[] SUB_MIX_12, int[] SUB_MIX_22, int[] SUB_MIX_32, int[] SBOX2) {
        int i5 = M4[offset] ^ keySchedule[0];
        int i6 = offset + 1;
        int i7 = 1;
        int i8 = M4[i6] ^ keySchedule[1];
        int i9 = offset + 2;
        int i10 = M4[i9] ^ keySchedule[2];
        int i11 = offset + 3;
        int i12 = M4[i11] ^ keySchedule[3];
        int i13 = this.numRounds;
        int i14 = 4;
        while (i7 < i13) {
            i7++;
            int i15 = (((SUB_MIX_02[(i5 >>> 24) & Function.USE_VARARGS] ^ SUB_MIX_12[(i8 >>> 16) & Function.USE_VARARGS]) ^ SUB_MIX_22[(i10 >>> 8) & Function.USE_VARARGS]) ^ SUB_MIX_32[i12 & Function.USE_VARARGS]) ^ keySchedule[i14];
            int i16 = keySchedule[i14 + 1] ^ (((SUB_MIX_02[(i8 >>> 24) & Function.USE_VARARGS] ^ SUB_MIX_12[(i10 >>> 16) & Function.USE_VARARGS]) ^ SUB_MIX_22[(i12 >>> 8) & Function.USE_VARARGS]) ^ SUB_MIX_32[i5 & Function.USE_VARARGS]);
            int i17 = ((SUB_MIX_12[(i12 >>> 16) & Function.USE_VARARGS] ^ SUB_MIX_02[(i10 >>> 24) & Function.USE_VARARGS]) ^ SUB_MIX_22[(i5 >>> 8) & Function.USE_VARARGS]) ^ SUB_MIX_32[i8 & Function.USE_VARARGS];
            int i18 = i14 + 3;
            int i19 = i17 ^ keySchedule[i14 + 2];
            i14 += 4;
            i12 = (((SUB_MIX_12[(i5 >>> 16) & Function.USE_VARARGS] ^ SUB_MIX_02[(i12 >>> 24) & Function.USE_VARARGS]) ^ SUB_MIX_22[(i8 >>> 8) & Function.USE_VARARGS]) ^ SUB_MIX_32[i10 & Function.USE_VARARGS]) ^ keySchedule[i18];
            i10 = i19;
            i5 = i15;
            i8 = i16;
        }
        int i20 = ((((SBOX2[(i5 >>> 24) & Function.USE_VARARGS] << 24) | (SBOX2[(i8 >>> 16) & Function.USE_VARARGS] << 16)) | (SBOX2[(i10 >>> 8) & Function.USE_VARARGS] << 8)) | SBOX2[i12 & Function.USE_VARARGS]) ^ keySchedule[i14];
        int i21 = keySchedule[i14 + 1] ^ ((((SBOX2[(i8 >>> 24) & Function.USE_VARARGS] << 24) | (SBOX2[(i10 >>> 16) & Function.USE_VARARGS] << 16)) | (SBOX2[(i12 >>> 8) & Function.USE_VARARGS] << 8)) | SBOX2[i5 & Function.USE_VARARGS]);
        int i22 = ((((SBOX2[(i10 >>> 24) & Function.USE_VARARGS] << 24) | (SBOX2[(i12 >>> 16) & Function.USE_VARARGS] << 16)) | (SBOX2[(i5 >>> 8) & Function.USE_VARARGS] << 8)) | SBOX2[i8 & Function.USE_VARARGS]) ^ keySchedule[i14 + 2];
        int i23 = ((((SBOX2[(i5 >>> 16) & Function.USE_VARARGS] << 16) | (SBOX2[(i12 >>> 24) & Function.USE_VARARGS] << 24)) | (SBOX2[(i8 >>> 8) & Function.USE_VARARGS] << 8)) | SBOX2[i10 & Function.USE_VARARGS]) ^ keySchedule[i14 + 3];
        M4[offset] = i20;
        M4[i6] = i21;
        M4[i9] = i22;
        M4[i11] = i23;
    }

    public final void decryptBlock(int[] M4, int offset) {
        int i5 = offset + 1;
        int i6 = M4[i5];
        int i7 = offset + 3;
        M4[i5] = M4[i7];
        M4[i7] = i6;
        doCryptBlock(M4, offset, this.invKeySchedule, INV_SUB_MIX_0, INV_SUB_MIX_1, INV_SUB_MIX_2, INV_SUB_MIX_3, INV_SBOX);
        int i8 = M4[i5];
        M4[i5] = M4[i7];
        M4[i7] = i8;
    }

    public final void encryptBlock(int[] M4, int offset) {
        doCryptBlock(M4, offset, this.keySchedule, SUB_MIX_0, SUB_MIX_1, SUB_MIX_2, SUB_MIX_3, SBOX);
    }

    public final int[] getKeyWords() {
        return this.keyWords;
    }

    public AES(byte[] bArr) {
        this(INSTANCE.toIntArray(bArr));
    }
}
