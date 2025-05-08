package com.google.zxing.common.reedsolomon;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class GenericGFPoly {
    private final int[] coefficients;
    private final GenericGF field;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GenericGFPoly(GenericGF genericGF, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.field = genericGF;
        int length = iArr.length;
        int i5 = 1;
        if (length <= 1 || iArr[0] != 0) {
            this.coefficients = iArr;
            return;
        }
        while (i5 < length && iArr[i5] == 0) {
            i5++;
        }
        if (i5 == length) {
            this.coefficients = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i5];
        this.coefficients = iArr2;
        System.arraycopy(iArr, i5, iArr2, 0, iArr2.length);
    }

    GenericGFPoly addOrSubtract(GenericGFPoly genericGFPoly) {
        if (!this.field.equals(genericGFPoly.field)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (isZero()) {
            return genericGFPoly;
        }
        if (genericGFPoly.isZero()) {
            return this;
        }
        int[] iArr = this.coefficients;
        int[] iArr2 = genericGFPoly.coefficients;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i5 = length; i5 < iArr.length; i5++) {
            iArr3[i5] = GenericGF.addOrSubtract(iArr2[i5 - length], iArr[i5]);
        }
        return new GenericGFPoly(this.field, iArr3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GenericGFPoly[] divide(GenericGFPoly genericGFPoly) {
        if (!this.field.equals(genericGFPoly.field)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (genericGFPoly.isZero()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        GenericGFPoly zero = this.field.getZero();
        int inverse = this.field.inverse(genericGFPoly.getCoefficient(genericGFPoly.getDegree()));
        GenericGFPoly genericGFPoly2 = this;
        while (genericGFPoly2.getDegree() >= genericGFPoly.getDegree() && !genericGFPoly2.isZero()) {
            int degree = genericGFPoly2.getDegree() - genericGFPoly.getDegree();
            int multiply = this.field.multiply(genericGFPoly2.getCoefficient(genericGFPoly2.getDegree()), inverse);
            GenericGFPoly multiplyByMonomial = genericGFPoly.multiplyByMonomial(degree, multiply);
            zero = zero.addOrSubtract(this.field.buildMonomial(degree, multiply));
            genericGFPoly2 = genericGFPoly2.addOrSubtract(multiplyByMonomial);
        }
        return new GenericGFPoly[]{zero, genericGFPoly2};
    }

    int getCoefficient(int i5) {
        return this.coefficients[(r0.length - 1) - i5];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] getCoefficients() {
        return this.coefficients;
    }

    int getDegree() {
        return this.coefficients.length - 1;
    }

    boolean isZero() {
        return this.coefficients[0] == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GenericGFPoly multiply(GenericGFPoly genericGFPoly) {
        if (!this.field.equals(genericGFPoly.field)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (isZero() || genericGFPoly.isZero()) {
            return this.field.getZero();
        }
        int[] iArr = this.coefficients;
        int length = iArr.length;
        int[] iArr2 = genericGFPoly.coefficients;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = iArr[i5];
            for (int i7 = 0; i7 < length2; i7++) {
                int i8 = i5 + i7;
                iArr3[i8] = GenericGF.addOrSubtract(iArr3[i8], this.field.multiply(i6, iArr2[i7]));
            }
        }
        return new GenericGFPoly(this.field, iArr3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GenericGFPoly multiplyByMonomial(int i5, int i6) {
        if (i5 < 0) {
            throw new IllegalArgumentException();
        }
        if (i6 == 0) {
            return this.field.getZero();
        }
        int length = this.coefficients.length;
        int[] iArr = new int[i5 + length];
        for (int i7 = 0; i7 < length; i7++) {
            iArr[i7] = this.field.multiply(this.coefficients[i7], i6);
        }
        return new GenericGFPoly(this.field, iArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(getDegree() * 8);
        for (int degree = getDegree(); degree >= 0; degree--) {
            int coefficient = getCoefficient(degree);
            if (coefficient != 0) {
                if (coefficient < 0) {
                    sb.append(" - ");
                    coefficient = -coefficient;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (degree == 0 || coefficient != 1) {
                    int log = this.field.log(coefficient);
                    if (log == 0) {
                        sb.append('1');
                    } else if (log == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(log);
                    }
                }
                if (degree != 0) {
                    if (degree == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(degree);
                    }
                }
            }
        }
        return sb.toString();
    }
}
