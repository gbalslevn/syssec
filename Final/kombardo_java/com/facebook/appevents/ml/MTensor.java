package com.facebook.appevents.ml;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/facebook/appevents/ml/MTensor;", BuildConfig.FLAVOR, "shape", BuildConfig.FLAVOR, "([I)V", "capacity", BuildConfig.FLAVOR, "<set-?>", BuildConfig.FLAVOR, "data", "getData", "()[F", "shapeSize", "getShapeSize", "()I", "getShape", "i", "reshape", BuildConfig.FLAVOR, "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class MTensor {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int capacity;
    private float[] data;
    private int[] shape;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/facebook/appevents/ml/MTensor$Companion;", BuildConfig.FLAVOR, "()V", "getCapacity", BuildConfig.FLAVOR, "shape", BuildConfig.FLAVOR, "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getCapacity(int[] shape) {
            if (shape.length == 0) {
                throw new UnsupportedOperationException("Empty array can't be reduced.");
            }
            int i5 = shape[0];
            int lastIndex = ArraysKt.getLastIndex(shape);
            int i6 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    i5 *= shape[i6];
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
            return i5;
        }

        private Companion() {
        }
    }

    public MTensor(int[] shape) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        this.shape = shape;
        int capacity = INSTANCE.getCapacity(shape);
        this.capacity = capacity;
        this.data = new float[capacity];
    }

    public final float[] getData() {
        return this.data;
    }

    public final int getShape(int i5) {
        return this.shape[i5];
    }

    public final int getShapeSize() {
        return this.shape.length;
    }

    public final void reshape(int[] shape) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        this.shape = shape;
        int capacity = INSTANCE.getCapacity(shape);
        float[] fArr = new float[capacity];
        System.arraycopy(this.data, 0, fArr, 0, Math.min(this.capacity, capacity));
        this.data = fArr;
        this.capacity = capacity;
    }
}
