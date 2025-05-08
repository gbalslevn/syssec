package com.facebook.appevents.ml;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u001b\u0010\b\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0007¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0007J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J+\u0010\u000f\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0013H\u0007J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0013H\u0007J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u001e"}, d2 = {"Lcom/facebook/appevents/ml/Operator;", BuildConfig.FLAVOR, "()V", "addmv", BuildConfig.FLAVOR, "x", "Lcom/facebook/appevents/ml/MTensor;", "b", "concatenate", "tensors", BuildConfig.FLAVOR, "([Lcom/facebook/appevents/ml/MTensor;)Lcom/facebook/appevents/ml/MTensor;", "conv1D", "w", "dense", "embedding", "texts", BuildConfig.FLAVOR, "seqLength", BuildConfig.FLAVOR, "([Ljava/lang/String;ILcom/facebook/appevents/ml/MTensor;)Lcom/facebook/appevents/ml/MTensor;", "flatten", "startDim", "maxPool1D", "poolSize", "mul", "relu", "softmax", "transpose2D", "transpose3D", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class Operator {
    public static final Operator INSTANCE = new Operator();

    private Operator() {
    }

    public static final void addmv(MTensor x5, MTensor b5) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(x5, "x");
            Intrinsics.checkNotNullParameter(b5, "b");
            int shape = x5.getShape(0);
            int shape2 = x5.getShape(1);
            int shape3 = x5.getShape(2);
            float[] data = x5.getData();
            float[] data2 = b5.getData();
            if (shape <= 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                if (shape2 > 0) {
                    int i7 = 0;
                    while (true) {
                        int i8 = i7 + 1;
                        if (shape3 > 0) {
                            int i9 = 0;
                            while (true) {
                                int i10 = i9 + 1;
                                int i11 = (i5 * shape2 * shape3) + (i7 * shape3) + i9;
                                data[i11] = data[i11] + data2[i9];
                                if (i10 >= shape3) {
                                    break;
                                } else {
                                    i9 = i10;
                                }
                            }
                        }
                        if (i8 >= shape2) {
                            break;
                        } else {
                            i7 = i8;
                        }
                    }
                }
                if (i6 >= shape) {
                    return;
                } else {
                    i5 = i6;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
        }
    }

    public static final MTensor concatenate(MTensor[] tensors) {
        int i5;
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(tensors, "tensors");
            int i6 = 0;
            int shape = tensors[0].getShape(0);
            int length = tensors.length - 1;
            if (length >= 0) {
                int i7 = 0;
                i5 = 0;
                while (true) {
                    int i8 = i7 + 1;
                    i5 += tensors[i7].getShape(1);
                    if (i8 > length) {
                        break;
                    }
                    i7 = i8;
                }
            } else {
                i5 = 0;
            }
            MTensor mTensor = new MTensor(new int[]{shape, i5});
            float[] data = mTensor.getData();
            if (shape > 0) {
                int i9 = 0;
                while (true) {
                    int i10 = i9 + 1;
                    int i11 = i9 * i5;
                    int length2 = tensors.length - 1;
                    if (length2 >= 0) {
                        int i12 = i6;
                        while (true) {
                            int i13 = i12 + 1;
                            float[] data2 = tensors[i12].getData();
                            int shape2 = tensors[i12].getShape(1);
                            System.arraycopy(data2, i9 * shape2, data, i11, shape2);
                            i11 += shape2;
                            if (i13 > length2) {
                                break;
                            }
                            i12 = i13;
                        }
                    }
                    if (i10 >= shape) {
                        break;
                    }
                    i9 = i10;
                    i6 = 0;
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    public static final MTensor conv1D(MTensor x5, MTensor w5) {
        Class<Operator> cls;
        MTensor mTensor;
        Class<Operator> cls2 = Operator.class;
        if (CrashShieldHandler.isObjectCrashing(cls2)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(x5, "x");
            Intrinsics.checkNotNullParameter(w5, "w");
            int i5 = 0;
            int shape = x5.getShape(0);
            int shape2 = x5.getShape(1);
            int shape3 = x5.getShape(2);
            int shape4 = w5.getShape(0);
            int i6 = (shape2 - shape4) + 1;
            int shape5 = w5.getShape(2);
            MTensor mTensor2 = new MTensor(new int[]{shape, i6, shape5});
            float[] data = x5.getData();
            float[] data2 = mTensor2.getData();
            float[] data3 = w5.getData();
            if (shape <= 0) {
                return mTensor2;
            }
            int i7 = 0;
            while (true) {
                int i8 = i7 + 1;
                if (shape5 > 0) {
                    int i9 = i5;
                    while (true) {
                        int i10 = i9 + 1;
                        if (i6 > 0) {
                            int i11 = 0;
                            while (true) {
                                int i12 = i11 + 1;
                                float f5 = 0.0f;
                                if (shape4 > 0) {
                                    int i13 = 0;
                                    while (true) {
                                        cls = cls2;
                                        int i14 = i13 + 1;
                                        if (shape3 > 0) {
                                            int i15 = 0;
                                            while (true) {
                                                mTensor = mTensor2;
                                                int i16 = i15 + 1;
                                                try {
                                                    f5 += data[(shape2 * shape3 * i7) + ((i13 + i11) * shape3) + i15] * data3[(((i13 * shape3) + i15) * shape5) + i9];
                                                    if (i16 >= shape3) {
                                                        break;
                                                    }
                                                    i15 = i16;
                                                    mTensor2 = mTensor;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    CrashShieldHandler.handleThrowable(th, cls);
                                                    return null;
                                                }
                                            }
                                        } else {
                                            mTensor = mTensor2;
                                        }
                                        if (i14 >= shape4) {
                                            break;
                                        }
                                        i13 = i14;
                                        cls2 = cls;
                                        mTensor2 = mTensor;
                                    }
                                } else {
                                    cls = cls2;
                                    mTensor = mTensor2;
                                }
                                data2[(i6 * shape5 * i7) + (i11 * shape5) + i9] = f5;
                                if (i12 >= i6) {
                                    break;
                                }
                                i11 = i12;
                                cls2 = cls;
                                mTensor2 = mTensor;
                            }
                        } else {
                            cls = cls2;
                            mTensor = mTensor2;
                        }
                        if (i10 >= shape5) {
                            break;
                        }
                        i9 = i10;
                        cls2 = cls;
                        mTensor2 = mTensor;
                    }
                } else {
                    cls = cls2;
                    mTensor = mTensor2;
                }
                if (i8 >= shape) {
                    return mTensor;
                }
                i7 = i8;
                cls2 = cls;
                mTensor2 = mTensor;
                i5 = 0;
            }
        } catch (Throwable th2) {
            th = th2;
            cls = cls2;
        }
    }

    public static final MTensor dense(MTensor x5, MTensor w5, MTensor b5) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(x5, "x");
            Intrinsics.checkNotNullParameter(w5, "w");
            Intrinsics.checkNotNullParameter(b5, "b");
            int shape = x5.getShape(0);
            int shape2 = b5.getShape(0);
            MTensor mul = mul(x5, w5);
            float[] data = b5.getData();
            float[] data2 = mul.getData();
            if (shape > 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    if (shape2 > 0) {
                        int i7 = 0;
                        while (true) {
                            int i8 = i7 + 1;
                            int i9 = (i5 * shape2) + i7;
                            data2[i9] = data2[i9] + data[i7];
                            if (i8 >= shape2) {
                                break;
                            }
                            i7 = i8;
                        }
                    }
                    if (i6 >= shape) {
                        break;
                    }
                    i5 = i6;
                }
            }
            return mul;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    public static final MTensor embedding(String[] texts, int seqLength, MTensor w5) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(texts, "texts");
            Intrinsics.checkNotNullParameter(w5, "w");
            int length = texts.length;
            int shape = w5.getShape(1);
            MTensor mTensor = new MTensor(new int[]{length, seqLength, shape});
            float[] data = mTensor.getData();
            float[] data2 = w5.getData();
            if (length > 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    int[] vectorize = Utils.INSTANCE.vectorize(texts[i5], seqLength);
                    if (seqLength > 0) {
                        int i7 = 0;
                        while (true) {
                            int i8 = i7 + 1;
                            System.arraycopy(data2, vectorize[i7] * shape, data, (shape * seqLength * i5) + (i7 * shape), shape);
                            if (i8 >= seqLength) {
                                break;
                            }
                            i7 = i8;
                        }
                    }
                    if (i6 >= length) {
                        break;
                    }
                    i5 = i6;
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    public static final void flatten(MTensor x5, int startDim) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(x5, "x");
            if (startDim >= x5.getShapeSize()) {
                return;
            }
            int shapeSize = x5.getShapeSize();
            int i5 = 1;
            if (startDim < shapeSize) {
                int i6 = startDim;
                while (true) {
                    int i7 = i6 + 1;
                    i5 *= x5.getShape(i6);
                    if (i7 >= shapeSize) {
                        break;
                    } else {
                        i6 = i7;
                    }
                }
            }
            int[] iArr = new int[startDim + 1];
            if (startDim > 0) {
                int i8 = 0;
                while (true) {
                    int i9 = i8 + 1;
                    iArr[i8] = x5.getShape(i8);
                    if (i9 >= startDim) {
                        break;
                    } else {
                        i8 = i9;
                    }
                }
            }
            iArr[startDim] = i5;
            x5.reshape(iArr);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
        }
    }

    public static final MTensor maxPool1D(MTensor x5, int poolSize) {
        int i5;
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(x5, "x");
            int i6 = 0;
            int shape = x5.getShape(0);
            int shape2 = x5.getShape(1);
            int shape3 = x5.getShape(2);
            int i7 = (shape2 - poolSize) + 1;
            MTensor mTensor = new MTensor(new int[]{shape, i7, shape3});
            float[] data = x5.getData();
            float[] data2 = mTensor.getData();
            if (shape > 0) {
                int i8 = 0;
                while (true) {
                    int i9 = i8 + 1;
                    if (shape3 > 0) {
                        int i10 = i6;
                        while (true) {
                            int i11 = i10 + 1;
                            if (i7 > 0) {
                                int i12 = i6;
                                while (true) {
                                    int i13 = i12 + 1;
                                    int i14 = i12 * shape3;
                                    int i15 = (i8 * i7 * shape3) + i14 + i10;
                                    int i16 = (i8 * shape2 * shape3) + i14 + i10;
                                    data2[i15] = Float.MIN_VALUE;
                                    if (poolSize > 0) {
                                        int i17 = 0;
                                        while (true) {
                                            int i18 = i17 + 1;
                                            i5 = shape2;
                                            data2[i15] = Math.max(data2[i15], data[i16 + (i17 * shape3)]);
                                            if (i18 >= poolSize) {
                                                break;
                                            }
                                            i17 = i18;
                                            shape2 = i5;
                                        }
                                    } else {
                                        i5 = shape2;
                                    }
                                    if (i13 >= i7) {
                                        break;
                                    }
                                    i12 = i13;
                                    shape2 = i5;
                                }
                            } else {
                                i5 = shape2;
                            }
                            if (i11 >= shape3) {
                                break;
                            }
                            i10 = i11;
                            shape2 = i5;
                            i6 = 0;
                        }
                    } else {
                        i5 = shape2;
                    }
                    if (i9 >= shape) {
                        break;
                    }
                    i8 = i9;
                    shape2 = i5;
                    i6 = 0;
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    public static final MTensor mul(MTensor x5, MTensor w5) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(x5, "x");
            Intrinsics.checkNotNullParameter(w5, "w");
            int i5 = 0;
            int shape = x5.getShape(0);
            int shape2 = w5.getShape(0);
            int shape3 = w5.getShape(1);
            MTensor mTensor = new MTensor(new int[]{shape, shape3});
            float[] data = x5.getData();
            float[] data2 = w5.getData();
            float[] data3 = mTensor.getData();
            if (shape > 0) {
                int i6 = 0;
                while (true) {
                    int i7 = i6 + 1;
                    if (shape3 > 0) {
                        int i8 = i5;
                        while (true) {
                            int i9 = i8 + 1;
                            int i10 = (i6 * shape3) + i8;
                            data3[i10] = 0.0f;
                            if (shape2 > 0) {
                                int i11 = i5;
                                while (true) {
                                    int i12 = i11 + 1;
                                    data3[i10] = data3[i10] + (data[(i6 * shape2) + i11] * data2[(i11 * shape3) + i8]);
                                    if (i12 >= shape2) {
                                        break;
                                    }
                                    i11 = i12;
                                }
                            }
                            if (i9 >= shape3) {
                                break;
                            }
                            i8 = i9;
                            i5 = 0;
                        }
                    }
                    if (i7 >= shape) {
                        break;
                    }
                    i6 = i7;
                    i5 = 0;
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    public static final void relu(MTensor x5) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(x5, "x");
            float[] data = x5.getData();
            int length = data.length - 1;
            if (length < 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                if (data[i5] < 0.0f) {
                    data[i5] = 0.0f;
                }
                if (i6 > length) {
                    return;
                } else {
                    i5 = i6;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
        }
    }

    public static final void softmax(MTensor x5) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(x5, "x");
            int i5 = 0;
            int shape = x5.getShape(0);
            int shape2 = x5.getShape(1);
            float[] data = x5.getData();
            if (shape <= 0) {
                return;
            }
            while (true) {
                int i6 = i5 + 1;
                int i7 = i5 * shape2;
                int i8 = i7 + shape2;
                float f5 = Float.MIN_VALUE;
                if (i7 < i8) {
                    int i9 = i7;
                    while (true) {
                        int i10 = i9 + 1;
                        float f6 = data[i9];
                        if (f6 > f5) {
                            f5 = f6;
                        }
                        if (i10 >= i8) {
                            break;
                        } else {
                            i9 = i10;
                        }
                    }
                }
                float f7 = 0.0f;
                if (i7 < i8) {
                    int i11 = i7;
                    while (true) {
                        int i12 = i11 + 1;
                        float exp = (float) Math.exp(data[i11] - f5);
                        data[i11] = exp;
                        f7 += exp;
                        if (i12 >= i8) {
                            break;
                        } else {
                            i11 = i12;
                        }
                    }
                }
                if (i7 < i8) {
                    while (true) {
                        int i13 = i7 + 1;
                        data[i7] = data[i7] / f7;
                        if (i13 >= i8) {
                            break;
                        } else {
                            i7 = i13;
                        }
                    }
                }
                if (i6 >= shape) {
                    return;
                } else {
                    i5 = i6;
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
        }
    }

    public static final MTensor transpose2D(MTensor x5) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(x5, "x");
            int shape = x5.getShape(0);
            int shape2 = x5.getShape(1);
            MTensor mTensor = new MTensor(new int[]{shape2, shape});
            float[] data = x5.getData();
            float[] data2 = mTensor.getData();
            if (shape > 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    if (shape2 > 0) {
                        int i7 = 0;
                        while (true) {
                            int i8 = i7 + 1;
                            data2[(i7 * shape) + i5] = data[(i5 * shape2) + i7];
                            if (i8 >= shape2) {
                                break;
                            }
                            i7 = i8;
                        }
                    }
                    if (i6 >= shape) {
                        break;
                    }
                    i5 = i6;
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }

    public static final MTensor transpose3D(MTensor x5) {
        if (CrashShieldHandler.isObjectCrashing(Operator.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(x5, "x");
            int shape = x5.getShape(0);
            int shape2 = x5.getShape(1);
            int shape3 = x5.getShape(2);
            MTensor mTensor = new MTensor(new int[]{shape3, shape2, shape});
            float[] data = x5.getData();
            float[] data2 = mTensor.getData();
            if (shape > 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    if (shape2 > 0) {
                        int i7 = 0;
                        while (true) {
                            int i8 = i7 + 1;
                            if (shape3 > 0) {
                                int i9 = 0;
                                while (true) {
                                    int i10 = i9 + 1;
                                    data2[(i9 * shape * shape2) + (i7 * shape) + i5] = data[(i5 * shape2 * shape3) + (i7 * shape3) + i9];
                                    if (i10 >= shape3) {
                                        break;
                                    }
                                    i9 = i10;
                                }
                            }
                            if (i8 >= shape2) {
                                break;
                            }
                            i7 = i8;
                        }
                    }
                    if (i6 >= shape) {
                        break;
                    }
                    i5 = i6;
                }
            }
            return mTensor;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Operator.class);
            return null;
        }
    }
}
