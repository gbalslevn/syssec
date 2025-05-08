package com.google.zxing.datamatrix.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class C40Encoder implements Encoder {
    private int backtrackOneCharacter(EncoderContext encoderContext, StringBuilder sb, StringBuilder sb2, int i5) {
        int length = sb.length();
        sb.delete(length - i5, length);
        encoderContext.pos--;
        int encodeChar = encodeChar(encoderContext.getCurrentChar(), sb2);
        encoderContext.resetSymbolInfo();
        return encodeChar;
    }

    private static String encodeToCodewords(CharSequence charSequence, int i5) {
        int charAt = (charSequence.charAt(i5) * 1600) + (charSequence.charAt(i5 + 1) * '(') + charSequence.charAt(i5 + 2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeNextTriplet(EncoderContext encoderContext, StringBuilder sb) {
        encoderContext.writeCodewords(encodeToCodewords(sb, 0));
        sb.delete(0, 3);
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext encoderContext) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            char currentChar = encoderContext.getCurrentChar();
            encoderContext.pos++;
            int encodeChar = encodeChar(currentChar, sb);
            int codewordCount = encoderContext.getCodewordCount() + ((sb.length() / 3) << 1);
            encoderContext.updateSymbolInfo(codewordCount);
            int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount;
            if (!encoderContext.hasMoreCharacters()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (dataCapacity < 2 || dataCapacity > 2)) {
                    encodeChar = backtrackOneCharacter(encoderContext, sb, sb2, encodeChar);
                }
                while (sb.length() % 3 == 1 && ((encodeChar <= 3 && dataCapacity != 1) || encodeChar > 3)) {
                    encodeChar = backtrackOneCharacter(encoderContext, sb, sb2, encodeChar);
                }
            } else if (sb.length() % 3 == 0 && HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode()) != getEncodingMode()) {
                encoderContext.signalEncoderChange(0);
                break;
            }
        }
        handleEOD(encoderContext, sb);
    }

    int encodeChar(char c5, StringBuilder sb) {
        if (c5 == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c5 >= '0' && c5 <= '9') {
            sb.append((char) (c5 - ','));
            return 1;
        }
        if (c5 >= 'A' && c5 <= 'Z') {
            sb.append((char) (c5 - '3'));
            return 1;
        }
        if (c5 < ' ') {
            sb.append((char) 0);
            sb.append(c5);
            return 2;
        }
        if (c5 >= '!' && c5 <= '/') {
            sb.append((char) 1);
            sb.append((char) (c5 - '!'));
            return 2;
        }
        if (c5 >= ':' && c5 <= '@') {
            sb.append((char) 1);
            sb.append((char) (c5 - '+'));
            return 2;
        }
        if (c5 >= '[' && c5 <= '_') {
            sb.append((char) 1);
            sb.append((char) (c5 - 'E'));
            return 2;
        }
        if (c5 < '`' || c5 > 127) {
            sb.append("\u0001\u001e");
            return encodeChar((char) (c5 - 128), sb) + 2;
        }
        sb.append((char) 2);
        sb.append((char) (c5 - '`'));
        return 2;
    }

    public int getEncodingMode() {
        return 1;
    }

    void handleEOD(EncoderContext encoderContext, StringBuilder sb) {
        int length = (sb.length() / 3) << 1;
        int length2 = sb.length() % 3;
        int codewordCount = encoderContext.getCodewordCount() + length;
        encoderContext.updateSymbolInfo(codewordCount);
        int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount;
        if (length2 == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword((char) 254);
            }
        } else if (dataCapacity == 1 && length2 == 1) {
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword((char) 254);
            }
            encoderContext.pos--;
        } else {
            if (length2 != 0) {
                throw new IllegalStateException("Unexpected case. Please report!");
            }
            while (sb.length() >= 3) {
                writeNextTriplet(encoderContext, sb);
            }
            if (dataCapacity > 0 || encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword((char) 254);
            }
        }
        encoderContext.signalEncoderChange(0);
    }
}
