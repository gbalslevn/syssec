package com.google.zxing.datamatrix.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ASCIIEncoder implements Encoder {
    private static char encodeASCIIDigits(char c5, char c6) {
        if (HighLevelEncoder.isDigit(c5) && HighLevelEncoder.isDigit(c6)) {
            return (char) (((c5 - '0') * 10) + (c6 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c5 + c6);
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext encoderContext) {
        if (HighLevelEncoder.determineConsecutiveDigitCount(encoderContext.getMessage(), encoderContext.pos) >= 2) {
            encoderContext.writeCodeword(encodeASCIIDigits(encoderContext.getMessage().charAt(encoderContext.pos), encoderContext.getMessage().charAt(encoderContext.pos + 1)));
            encoderContext.pos += 2;
            return;
        }
        char currentChar = encoderContext.getCurrentChar();
        int lookAheadTest = HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode());
        if (lookAheadTest == getEncodingMode()) {
            if (!HighLevelEncoder.isExtendedASCII(currentChar)) {
                encoderContext.writeCodeword((char) (currentChar + 1));
                encoderContext.pos++;
                return;
            } else {
                encoderContext.writeCodeword((char) 235);
                encoderContext.writeCodeword((char) (currentChar - 127));
                encoderContext.pos++;
                return;
            }
        }
        if (lookAheadTest == 1) {
            encoderContext.writeCodeword((char) 230);
            encoderContext.signalEncoderChange(1);
            return;
        }
        if (lookAheadTest == 2) {
            encoderContext.writeCodeword((char) 239);
            encoderContext.signalEncoderChange(2);
            return;
        }
        if (lookAheadTest == 3) {
            encoderContext.writeCodeword((char) 238);
            encoderContext.signalEncoderChange(3);
        } else if (lookAheadTest == 4) {
            encoderContext.writeCodeword((char) 240);
            encoderContext.signalEncoderChange(4);
        } else {
            if (lookAheadTest != 5) {
                throw new IllegalStateException("Illegal mode: ".concat(String.valueOf(lookAheadTest)));
            }
            encoderContext.writeCodeword((char) 231);
            encoderContext.signalEncoderChange(5);
        }
    }

    public int getEncodingMode() {
        return 0;
    }
}
