package com.google.zxing.qrcode.encoder;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import com.sun.jna.Function;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class Encoder {
    private static final int[] ALPHANUMERIC_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.zxing.qrcode.encoder.Encoder$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$qrcode$decoder$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$qrcode$decoder$Mode = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static void append8BitBytes(String str, BitArray bitArray, String str2) {
        try {
            for (byte b5 : str.getBytes(str2)) {
                bitArray.appendBits(b5, 8);
            }
        } catch (UnsupportedEncodingException e5) {
            throw new WriterException(e5);
        }
    }

    static void appendAlphanumericBytes(CharSequence charSequence, BitArray bitArray) {
        int length = charSequence.length();
        int i5 = 0;
        while (i5 < length) {
            int alphanumericCode = getAlphanumericCode(charSequence.charAt(i5));
            if (alphanumericCode == -1) {
                throw new WriterException();
            }
            int i6 = i5 + 1;
            if (i6 < length) {
                int alphanumericCode2 = getAlphanumericCode(charSequence.charAt(i6));
                if (alphanumericCode2 == -1) {
                    throw new WriterException();
                }
                bitArray.appendBits((alphanumericCode * 45) + alphanumericCode2, 11);
                i5 += 2;
            } else {
                bitArray.appendBits(alphanumericCode, 6);
                i5 = i6;
            }
        }
    }

    static void appendBytes(String str, Mode mode, BitArray bitArray, String str2) {
        int i5 = AnonymousClass1.$SwitchMap$com$google$zxing$qrcode$decoder$Mode[mode.ordinal()];
        if (i5 == 1) {
            appendNumericBytes(str, bitArray);
            return;
        }
        if (i5 == 2) {
            appendAlphanumericBytes(str, bitArray);
        } else if (i5 == 3) {
            append8BitBytes(str, bitArray, str2);
        } else {
            if (i5 != 4) {
                throw new WriterException("Invalid mode: ".concat(String.valueOf(mode)));
            }
            appendKanjiBytes(str, bitArray);
        }
    }

    private static void appendECI(CharacterSetECI characterSetECI, BitArray bitArray) {
        bitArray.appendBits(Mode.ECI.getBits(), 4);
        bitArray.appendBits(characterSetECI.getValue(), 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035 A[LOOP:0: B:4:0x0008->B:11:0x0035, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0044 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void appendKanjiBytes(String str, BitArray bitArray) {
        int i5;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i6 = 0; i6 < length; i6 += 2) {
                int i7 = ((bytes[i6] & 255) << 8) | (bytes[i6 + 1] & 255);
                int i8 = 33088;
                if (i7 < 33088 || i7 > 40956) {
                    if (i7 < 57408 || i7 > 60351) {
                        i5 = -1;
                        if (i5 != -1) {
                            throw new WriterException("Invalid byte sequence");
                        }
                        bitArray.appendBits(((i5 >> 8) * 192) + (i5 & Function.USE_VARARGS), 13);
                    } else {
                        i8 = 49472;
                    }
                }
                i5 = i7 - i8;
                if (i5 != -1) {
                }
            }
        } catch (UnsupportedEncodingException e5) {
            throw new WriterException(e5);
        }
    }

    static void appendLengthInfo(int i5, Version version, Mode mode, BitArray bitArray) {
        int characterCountBits = mode.getCharacterCountBits(version);
        int i6 = 1 << characterCountBits;
        if (i5 < i6) {
            bitArray.appendBits(i5, characterCountBits);
            return;
        }
        throw new WriterException(i5 + " is bigger than " + (i6 - 1));
    }

    static void appendModeInfo(Mode mode, BitArray bitArray) {
        bitArray.appendBits(mode.getBits(), 4);
    }

    static void appendNumericBytes(CharSequence charSequence, BitArray bitArray) {
        int length = charSequence.length();
        int i5 = 0;
        while (i5 < length) {
            int charAt = charSequence.charAt(i5) - '0';
            int i6 = i5 + 2;
            if (i6 < length) {
                bitArray.appendBits((charAt * 100) + ((charSequence.charAt(i5 + 1) - '0') * 10) + (charSequence.charAt(i6) - '0'), 10);
                i5 += 3;
            } else {
                i5++;
                if (i5 < length) {
                    bitArray.appendBits((charAt * 10) + (charSequence.charAt(i5) - '0'), 7);
                    i5 = i6;
                } else {
                    bitArray.appendBits(charAt, 4);
                }
            }
        }
    }

    private static int calculateBitsNeeded(Mode mode, BitArray bitArray, BitArray bitArray2, Version version) {
        return bitArray.getSize() + mode.getCharacterCountBits(version) + bitArray2.getSize();
    }

    private static int calculateMaskPenalty(ByteMatrix byteMatrix) {
        return MaskUtil.applyMaskPenaltyRule1(byteMatrix) + MaskUtil.applyMaskPenaltyRule2(byteMatrix) + MaskUtil.applyMaskPenaltyRule3(byteMatrix) + MaskUtil.applyMaskPenaltyRule4(byteMatrix);
    }

    private static int chooseMaskPattern(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, ByteMatrix byteMatrix) {
        int i5 = Integer.MAX_VALUE;
        int i6 = -1;
        for (int i7 = 0; i7 < 8; i7++) {
            MatrixUtil.buildMatrix(bitArray, errorCorrectionLevel, version, i7, byteMatrix);
            int calculateMaskPenalty = calculateMaskPenalty(byteMatrix);
            if (calculateMaskPenalty < i5) {
                i6 = i7;
                i5 = calculateMaskPenalty;
            }
        }
        return i6;
    }

    private static Mode chooseMode(String str, String str2) {
        if ("Shift_JIS".equals(str2) && isOnlyDoubleByteKanji(str)) {
            return Mode.KANJI;
        }
        boolean z5 = false;
        boolean z6 = false;
        for (int i5 = 0; i5 < str.length(); i5++) {
            char charAt = str.charAt(i5);
            if (charAt >= '0' && charAt <= '9') {
                z6 = true;
            } else {
                if (getAlphanumericCode(charAt) == -1) {
                    return Mode.BYTE;
                }
                z5 = true;
            }
        }
        return z5 ? Mode.ALPHANUMERIC : z6 ? Mode.NUMERIC : Mode.BYTE;
    }

    private static Version chooseVersion(int i5, ErrorCorrectionLevel errorCorrectionLevel) {
        for (int i6 = 1; i6 <= 40; i6++) {
            Version versionForNumber = Version.getVersionForNumber(i6);
            if (willFit(i5, versionForNumber, errorCorrectionLevel)) {
                return versionForNumber;
            }
        }
        throw new WriterException("Data too big");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static QRCode encode(String str, ErrorCorrectionLevel errorCorrectionLevel, Map<EncodeHintType, ?> map) {
        Version recommendVersion;
        CharacterSetECI characterSetECIByName;
        boolean z5 = map != null && map.containsKey(EncodeHintType.CHARACTER_SET);
        String obj = z5 ? map.get(EncodeHintType.CHARACTER_SET).toString() : "ISO-8859-1";
        Mode chooseMode = chooseMode(str, obj);
        BitArray bitArray = new BitArray();
        Mode mode = Mode.BYTE;
        if (chooseMode == mode && z5 && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(obj)) != null) {
            appendECI(characterSetECIByName, bitArray);
        }
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.GS1_FORMAT;
            if (map.containsKey(encodeHintType) && Boolean.valueOf(map.get(encodeHintType).toString()).booleanValue()) {
                appendModeInfo(Mode.FNC1_FIRST_POSITION, bitArray);
            }
        }
        appendModeInfo(chooseMode, bitArray);
        BitArray bitArray2 = new BitArray();
        appendBytes(str, chooseMode, bitArray2, obj);
        if (map != null) {
            EncodeHintType encodeHintType2 = EncodeHintType.QR_VERSION;
            if (map.containsKey(encodeHintType2)) {
                recommendVersion = Version.getVersionForNumber(Integer.parseInt(map.get(encodeHintType2).toString()));
                if (!willFit(calculateBitsNeeded(chooseMode, bitArray, bitArray2, recommendVersion), recommendVersion, errorCorrectionLevel)) {
                    throw new WriterException("Data too big for requested version");
                }
                BitArray bitArray3 = new BitArray();
                bitArray3.appendBitArray(bitArray);
                appendLengthInfo(chooseMode != mode ? bitArray2.getSizeInBytes() : str.length(), recommendVersion, chooseMode, bitArray3);
                bitArray3.appendBitArray(bitArray2);
                Version.ECBlocks eCBlocksForLevel = recommendVersion.getECBlocksForLevel(errorCorrectionLevel);
                int totalCodewords = recommendVersion.getTotalCodewords() - eCBlocksForLevel.getTotalECCodewords();
                terminateBits(totalCodewords, bitArray3);
                BitArray interleaveWithECBytes = interleaveWithECBytes(bitArray3, recommendVersion.getTotalCodewords(), totalCodewords, eCBlocksForLevel.getNumBlocks());
                QRCode qRCode = new QRCode();
                qRCode.setECLevel(errorCorrectionLevel);
                qRCode.setMode(chooseMode);
                qRCode.setVersion(recommendVersion);
                int dimensionForVersion = recommendVersion.getDimensionForVersion();
                ByteMatrix byteMatrix = new ByteMatrix(dimensionForVersion, dimensionForVersion);
                int chooseMaskPattern = chooseMaskPattern(interleaveWithECBytes, errorCorrectionLevel, recommendVersion, byteMatrix);
                qRCode.setMaskPattern(chooseMaskPattern);
                MatrixUtil.buildMatrix(interleaveWithECBytes, errorCorrectionLevel, recommendVersion, chooseMaskPattern, byteMatrix);
                qRCode.setMatrix(byteMatrix);
                return qRCode;
            }
        }
        recommendVersion = recommendVersion(errorCorrectionLevel, chooseMode, bitArray, bitArray2);
        BitArray bitArray32 = new BitArray();
        bitArray32.appendBitArray(bitArray);
        appendLengthInfo(chooseMode != mode ? bitArray2.getSizeInBytes() : str.length(), recommendVersion, chooseMode, bitArray32);
        bitArray32.appendBitArray(bitArray2);
        Version.ECBlocks eCBlocksForLevel2 = recommendVersion.getECBlocksForLevel(errorCorrectionLevel);
        int totalCodewords2 = recommendVersion.getTotalCodewords() - eCBlocksForLevel2.getTotalECCodewords();
        terminateBits(totalCodewords2, bitArray32);
        BitArray interleaveWithECBytes2 = interleaveWithECBytes(bitArray32, recommendVersion.getTotalCodewords(), totalCodewords2, eCBlocksForLevel2.getNumBlocks());
        QRCode qRCode2 = new QRCode();
        qRCode2.setECLevel(errorCorrectionLevel);
        qRCode2.setMode(chooseMode);
        qRCode2.setVersion(recommendVersion);
        int dimensionForVersion2 = recommendVersion.getDimensionForVersion();
        ByteMatrix byteMatrix2 = new ByteMatrix(dimensionForVersion2, dimensionForVersion2);
        int chooseMaskPattern2 = chooseMaskPattern(interleaveWithECBytes2, errorCorrectionLevel, recommendVersion, byteMatrix2);
        qRCode2.setMaskPattern(chooseMaskPattern2);
        MatrixUtil.buildMatrix(interleaveWithECBytes2, errorCorrectionLevel, recommendVersion, chooseMaskPattern2, byteMatrix2);
        qRCode2.setMatrix(byteMatrix2);
        return qRCode2;
    }

    static byte[] generateECBytes(byte[] bArr, int i5) {
        int length = bArr.length;
        int[] iArr = new int[length + i5];
        for (int i6 = 0; i6 < length; i6++) {
            iArr[i6] = bArr[i6] & 255;
        }
        new ReedSolomonEncoder(GenericGF.QR_CODE_FIELD_256).encode(iArr, i5);
        byte[] bArr2 = new byte[i5];
        for (int i7 = 0; i7 < i5; i7++) {
            bArr2[i7] = (byte) iArr[length + i7];
        }
        return bArr2;
    }

    static int getAlphanumericCode(int i5) {
        int[] iArr = ALPHANUMERIC_TABLE;
        if (i5 < iArr.length) {
            return iArr[i5];
        }
        return -1;
    }

    static void getNumDataBytesAndNumECBytesForBlockID(int i5, int i6, int i7, int i8, int[] iArr, int[] iArr2) {
        if (i8 >= i7) {
            throw new WriterException("Block ID too large");
        }
        int i9 = i5 % i7;
        int i10 = i7 - i9;
        int i11 = i5 / i7;
        int i12 = i11 + 1;
        int i13 = i6 / i7;
        int i14 = i13 + 1;
        int i15 = i11 - i13;
        int i16 = i12 - i14;
        if (i15 != i16) {
            throw new WriterException("EC bytes mismatch");
        }
        if (i7 != i10 + i9) {
            throw new WriterException("RS blocks mismatch");
        }
        if (i5 != ((i13 + i15) * i10) + ((i14 + i16) * i9)) {
            throw new WriterException("Total bytes mismatch");
        }
        if (i8 < i10) {
            iArr[0] = i13;
            iArr2[0] = i15;
        } else {
            iArr[0] = i14;
            iArr2[0] = i16;
        }
    }

    static BitArray interleaveWithECBytes(BitArray bitArray, int i5, int i6, int i7) {
        if (bitArray.getSizeInBytes() != i6) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(i7);
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i7; i11++) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            getNumDataBytesAndNumECBytesForBlockID(i5, i6, i7, i11, iArr, iArr2);
            int i12 = iArr[0];
            byte[] bArr = new byte[i12];
            bitArray.toBytes(i8 << 3, bArr, 0, i12);
            byte[] generateECBytes = generateECBytes(bArr, iArr2[0]);
            arrayList.add(new BlockPair(bArr, generateECBytes));
            i9 = Math.max(i9, i12);
            i10 = Math.max(i10, generateECBytes.length);
            i8 += iArr[0];
        }
        if (i6 != i8) {
            throw new WriterException("Data bytes does not match offset");
        }
        BitArray bitArray2 = new BitArray();
        for (int i13 = 0; i13 < i9; i13++) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] dataBytes = ((BlockPair) it.next()).getDataBytes();
                if (i13 < dataBytes.length) {
                    bitArray2.appendBits(dataBytes[i13], 8);
                }
            }
        }
        for (int i14 = 0; i14 < i10; i14++) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] errorCorrectionBytes = ((BlockPair) it2.next()).getErrorCorrectionBytes();
                if (i14 < errorCorrectionBytes.length) {
                    bitArray2.appendBits(errorCorrectionBytes[i14], 8);
                }
            }
        }
        if (i5 == bitArray2.getSizeInBytes()) {
            return bitArray2;
        }
        throw new WriterException("Interleaving error: " + i5 + " and " + bitArray2.getSizeInBytes() + " differ.");
    }

    private static boolean isOnlyDoubleByteKanji(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i5 = 0; i5 < length; i5 += 2) {
                int i6 = bytes[i5] & 255;
                if ((i6 < 129 || i6 > 159) && (i6 < 224 || i6 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static Version recommendVersion(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, BitArray bitArray, BitArray bitArray2) {
        return chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, Version.getVersionForNumber(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    static void terminateBits(int i5, BitArray bitArray) {
        int i6 = i5 << 3;
        if (bitArray.getSize() > i6) {
            throw new WriterException("data bits cannot fit in the QR Code" + bitArray.getSize() + " > " + i6);
        }
        for (int i7 = 0; i7 < 4 && bitArray.getSize() < i6; i7++) {
            bitArray.appendBit(false);
        }
        int size = bitArray.getSize() & 7;
        if (size > 0) {
            while (size < 8) {
                bitArray.appendBit(false);
                size++;
            }
        }
        int sizeInBytes = i5 - bitArray.getSizeInBytes();
        for (int i8 = 0; i8 < sizeInBytes; i8++) {
            bitArray.appendBits((i8 & 1) == 0 ? 236 : 17, 8);
        }
        if (bitArray.getSize() != i6) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    private static boolean willFit(int i5, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        return version.getTotalCodewords() - version.getECBlocksForLevel(errorCorrectionLevel).getTotalECCodewords() >= (i5 + 7) / 8;
    }
}
