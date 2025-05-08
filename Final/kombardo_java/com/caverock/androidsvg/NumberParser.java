package com.caverock.androidsvg;

/* loaded from: classes.dex */
class NumberParser {
    private int pos;
    private static final float[] positivePowersOf10 = {1.0f, 10.0f, 100.0f, 1000.0f, 10000.0f, 100000.0f, 1000000.0f, 1.0E7f, 1.0E8f, 1.0E9f, 1.0E10f, 1.0E11f, 1.0E12f, 1.0E13f, 1.0E14f, 1.0E15f, 1.0E16f, 1.0E17f, 1.0E18f, 1.0E19f, 1.0E20f, 1.0E21f, 1.0E22f, 1.0E23f, 1.0E24f, 1.0E25f, 1.0E26f, 1.0E27f, 1.0E28f, 1.0E29f, 1.0E30f, 1.0E31f, 1.0E32f, 1.0E33f, 1.0E34f, 1.0E35f, 1.0E36f, 1.0E37f, 1.0E38f};
    private static final float[] negativePowersOf10 = {1.0f, 0.1f, 0.01f, 0.001f, 1.0E-4f, 1.0E-5f, 1.0E-6f, 1.0E-7f, 1.0E-8f, 1.0E-9f, 1.0E-10f, 1.0E-11f, 1.0E-12f, 1.0E-13f, 1.0E-14f, 1.0E-15f, 1.0E-16f, 1.0E-17f, 1.0E-18f, 1.0E-19f, 1.0E-20f, 1.0E-21f, 1.0E-22f, 1.0E-23f, 1.0E-24f, 1.0E-25f, 1.0E-26f, 1.0E-27f, 1.0E-28f, 1.0E-29f, 1.0E-30f, 1.0E-31f, 1.0E-32f, 1.0E-33f, 1.0E-34f, 1.0E-35f, 1.0E-36f, 1.0E-37f, 1.0E-38f};

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getEndPos() {
        return this.pos;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:118:0x008a A[EDGE_INSN: B:118:0x008a->B:47:0x008a BREAK  A[LOOP:0: B:10:0x0032->B:17:0x0080], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public float parseNumber(String str, int i5, int i6) {
        boolean z5;
        int i7;
        int i8;
        boolean z6;
        int i9;
        int i10;
        int i11;
        float f5;
        char charAt;
        int i12;
        boolean z7;
        boolean z8;
        char charAt2;
        this.pos = i5;
        if (i5 >= i6) {
            return Float.NaN;
        }
        char charAt3 = str.charAt(i5);
        if (charAt3 == '+') {
            z5 = false;
        } else {
            if (charAt3 != '-') {
                z5 = false;
                int i13 = this.pos;
                long j5 = 0;
                i7 = 0;
                i8 = 0;
                int i14 = 0;
                z6 = false;
                int i15 = 0;
                while (true) {
                    i9 = this.pos;
                    if (i9 >= i6) {
                        break;
                    }
                    char charAt4 = str.charAt(i9);
                    if (charAt4 == '0') {
                        if (i7 == 0) {
                            i14++;
                        } else {
                            i8++;
                        }
                    } else if (charAt4 >= '1' && charAt4 <= '9') {
                        int i16 = i7 + i8;
                        while (i8 > 0) {
                            if (j5 > 922337203685477580L) {
                                return Float.NaN;
                            }
                            j5 *= 10;
                            i8--;
                        }
                        if (j5 > 922337203685477580L) {
                            return Float.NaN;
                        }
                        j5 = (j5 * 10) + (charAt4 - '0');
                        i7 = i16 + 1;
                        if (j5 < 0) {
                            return Float.NaN;
                        }
                    } else {
                        if (charAt4 != '.' || z6) {
                            break;
                        }
                        i15 = this.pos - i13;
                        z6 = true;
                    }
                    this.pos++;
                }
                if (!z6 && this.pos == i15 + 1) {
                    return Float.NaN;
                }
                if (i7 == 0) {
                    if (i14 == 0) {
                        return Float.NaN;
                    }
                    i7 = 1;
                }
                if (z6) {
                    i8 = (i15 - i14) - i7;
                }
                i10 = this.pos;
                if (i10 < i6 && ((charAt = str.charAt(i10)) == 'E' || charAt == 'e')) {
                    i12 = this.pos + 1;
                    this.pos = i12;
                    if (i12 != i6) {
                        return Float.NaN;
                    }
                    char charAt5 = str.charAt(i12);
                    if (charAt5 == '+') {
                        z7 = false;
                    } else if (charAt5 != '-') {
                        switch (charAt5) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                z7 = false;
                                z8 = false;
                                break;
                            default:
                                this.pos--;
                                z8 = true;
                                z7 = false;
                                break;
                        }
                        if (!z8) {
                            int i17 = this.pos;
                            int i18 = 0;
                            while (true) {
                                int i19 = this.pos;
                                if (i19 < i6 && (charAt2 = str.charAt(i19)) >= '0' && charAt2 <= '9') {
                                    if (i18 > 922337203685477580L) {
                                        return Float.NaN;
                                    }
                                    i18 = (i18 * 10) + (charAt2 - '0');
                                    this.pos++;
                                }
                            }
                            if (this.pos == i17) {
                                return Float.NaN;
                            }
                            i8 = z7 ? i8 - i18 : i8 + i18;
                        }
                    } else {
                        z7 = true;
                    }
                    this.pos++;
                    z8 = false;
                    if (!z8) {
                    }
                }
                i11 = i7 + i8;
                if (i11 <= 39 || i11 < -44) {
                    return Float.NaN;
                }
                long j6 = j5;
                float f6 = (float) j6;
                if (j6 != 0) {
                    if (i8 > 0) {
                        f5 = positivePowersOf10[i8];
                    } else if (i8 < 0) {
                        if (i8 < -38) {
                            f6 = (float) (f6 * 1.0E-20d);
                            i8 += 20;
                        }
                        f5 = negativePowersOf10[-i8];
                    }
                    f6 *= f5;
                }
                return z5 ? -f6 : f6;
            }
            z5 = true;
        }
        this.pos++;
        int i132 = this.pos;
        long j52 = 0;
        i7 = 0;
        i8 = 0;
        int i142 = 0;
        z6 = false;
        int i152 = 0;
        while (true) {
            i9 = this.pos;
            if (i9 >= i6) {
            }
            this.pos++;
        }
        if (!z6) {
        }
        if (i7 == 0) {
        }
        if (z6) {
        }
        i10 = this.pos;
        if (i10 < i6) {
            i12 = this.pos + 1;
            this.pos = i12;
            if (i12 != i6) {
            }
        }
        i11 = i7 + i8;
        if (i11 <= 39) {
        }
        return Float.NaN;
    }
}
