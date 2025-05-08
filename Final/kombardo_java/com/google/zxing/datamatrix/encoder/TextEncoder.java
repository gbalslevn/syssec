package com.google.zxing.datamatrix.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class TextEncoder extends C40Encoder {
    @Override // com.google.zxing.datamatrix.encoder.C40Encoder
    int encodeChar(char c5, StringBuilder sb) {
        if (c5 == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c5 >= '0' && c5 <= '9') {
            sb.append((char) (c5 - ','));
            return 1;
        }
        if (c5 >= 'a' && c5 <= 'z') {
            sb.append((char) (c5 - 'S'));
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
        if (c5 == '`') {
            sb.append((char) 2);
            sb.append((char) (c5 - '`'));
            return 2;
        }
        if (c5 >= 'A' && c5 <= 'Z') {
            sb.append((char) 2);
            sb.append((char) (c5 - '@'));
            return 2;
        }
        if (c5 < '{' || c5 > 127) {
            sb.append("\u0001\u001e");
            return encodeChar((char) (c5 - 128), sb) + 2;
        }
        sb.append((char) 2);
        sb.append((char) (c5 - '`'));
        return 2;
    }

    @Override // com.google.zxing.datamatrix.encoder.C40Encoder
    public int getEncodingMode() {
        return 2;
    }
}
