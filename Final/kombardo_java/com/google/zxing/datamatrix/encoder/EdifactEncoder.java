package com.google.zxing.datamatrix.encoder;

import com.sun.jna.Function;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class EdifactEncoder implements Encoder {
    private static void encodeChar(char c5, StringBuilder sb) {
        if (c5 >= ' ' && c5 <= '?') {
            sb.append(c5);
        } else if (c5 < '@' || c5 > '^') {
            HighLevelEncoder.illegalCharacter(c5);
        } else {
            sb.append((char) (c5 - '@'));
        }
    }

    private static String encodeToCodewords(CharSequence charSequence, int i5) {
        int length = charSequence.length() - i5;
        if (length == 0) {
            throw new IllegalStateException("StringBuilder must not be empty");
        }
        int charAt = (charSequence.charAt(i5) << 18) + ((length >= 2 ? charSequence.charAt(i5 + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i5 + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i5 + 3) : (char) 0);
        char c5 = (char) ((charAt >> 16) & Function.USE_VARARGS);
        char c6 = (char) ((charAt >> 8) & Function.USE_VARARGS);
        char c7 = (char) (charAt & Function.USE_VARARGS);
        StringBuilder sb = new StringBuilder(3);
        sb.append(c5);
        if (length >= 2) {
            sb.append(c6);
        }
        if (length >= 3) {
            sb.append(c7);
        }
        return sb.toString();
    }

    private static void handleEOD(EncoderContext encoderContext, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                return;
            }
            boolean z5 = true;
            if (length == 1) {
                encoderContext.updateSymbolInfo();
                int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount();
                int remainingCharacters = encoderContext.getRemainingCharacters();
                if (remainingCharacters > dataCapacity) {
                    encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + 1);
                    dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount();
                }
                if (remainingCharacters <= dataCapacity && dataCapacity <= 2) {
                    return;
                }
            }
            if (length > 4) {
                throw new IllegalStateException("Count must not exceed 4");
            }
            int i5 = length - 1;
            String encodeToCodewords = encodeToCodewords(charSequence, 0);
            if (encoderContext.hasMoreCharacters() || i5 > 2) {
                z5 = false;
            }
            if (i5 <= 2) {
                encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + i5);
                if (encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount() >= 3) {
                    encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + encodeToCodewords.length());
                    z5 = false;
                }
            }
            if (z5) {
                encoderContext.resetSymbolInfo();
                encoderContext.pos -= i5;
            } else {
                encoderContext.writeCodewords(encodeToCodewords);
            }
        } finally {
            encoderContext.signalEncoderChange(0);
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext encoderContext) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            encodeChar(encoderContext.getCurrentChar(), sb);
            encoderContext.pos++;
            if (sb.length() >= 4) {
                encoderContext.writeCodewords(encodeToCodewords(sb, 0));
                sb.delete(0, 4);
                if (HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode()) != getEncodingMode()) {
                    encoderContext.signalEncoderChange(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        handleEOD(encoderContext, sb);
    }

    public int getEncodingMode() {
        return 4;
    }
}
