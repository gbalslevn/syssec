package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00152\u00020\u0001:\u0002\u0014\u0015B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005J\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005R\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/animation/core/ArcSpline;", BuildConfig.FLAVOR, "arcModes", BuildConfig.FLAVOR, "timePoints", BuildConfig.FLAVOR, "y", BuildConfig.FLAVOR, "([I[F[[F)V", "arcs", "Landroidx/compose/animation/core/ArcSpline$Arc;", "[[Landroidx/compose/animation/core/ArcSpline$Arc;", "isExtrapolate", BuildConfig.FLAVOR, "getPos", BuildConfig.FLAVOR, "time", BuildConfig.FLAVOR, "v", "getSlope", "Arc", "Companion", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ArcSpline {
    private static final int DownArc = 4;
    private static final int StartHorizontal = 2;
    private static final int StartLinear = 3;
    private static final int StartVertical = 1;
    private static final int UpArc = 5;
    private final Arc[][] arcs;
    private final boolean isExtrapolate = true;
    public static final int $stable = 8;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B?\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0006\u0010 \u001a\u00020\u0005J\u0006\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\u0005J\u000e\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J\u000e\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0002J\u000e\u0010+\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u0005R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Landroidx/compose/animation/core/ArcSpline$Arc;", BuildConfig.FLAVOR, "mode", BuildConfig.FLAVOR, "time1", BuildConfig.FLAVOR, "time2", "x1", "y1", "x2", "y2", "(IFFFFFF)V", "arcDistance", "arcVelocity", "ellipseA", "ellipseB", "ellipseCenterX", "ellipseCenterY", "isLinear", BuildConfig.FLAVOR, "()Z", "isVertical", "lut", BuildConfig.FLAVOR, "oneOverDeltaTime", "getTime1", "()F", "getTime2", "tmpCosAngle", "tmpSinAngle", "buildTable", BuildConfig.FLAVOR, "calcDX", "calcDY", "calcX", "calcY", "getLinearDX", "getLinearDY", "getLinearX", "time", "getLinearY", "lookup", "v", "setPoint", "Companion", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Arc {
        private static final float Epsilon = 0.001f;
        private static float[] _ourPercent;
        private float arcDistance;
        private final float arcVelocity;
        private final float ellipseA;
        private final float ellipseB;
        private final float ellipseCenterX;
        private final float ellipseCenterY;
        private final boolean isLinear;
        private final boolean isVertical;
        private final float[] lut;
        private final float oneOverDeltaTime;
        private final float time1;
        private final float time2;
        private float tmpCosAngle;
        private float tmpSinAngle;
        private final float x1;
        private final float x2;
        private final float y1;
        private final float y2;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/animation/core/ArcSpline$Arc$Companion;", BuildConfig.FLAVOR, "()V", "Epsilon", BuildConfig.FLAVOR, "_ourPercent", BuildConfig.FLAVOR, "ourPercent", "getOurPercent", "()[F", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final float[] getOurPercent() {
                if (Arc._ourPercent != null) {
                    float[] fArr = Arc._ourPercent;
                    Intrinsics.checkNotNull(fArr);
                    return fArr;
                }
                Arc._ourPercent = new float[91];
                float[] fArr2 = Arc._ourPercent;
                Intrinsics.checkNotNull(fArr2);
                return fArr2;
            }

            private Companion() {
            }
        }

        public Arc(int i5, float f5, float f6, float f7, float f8, float f9, float f10) {
            this.time1 = f5;
            this.time2 = f6;
            this.x1 = f7;
            this.y1 = f8;
            this.x2 = f9;
            this.y2 = f10;
            float f11 = f9 - f7;
            float f12 = f10 - f8;
            boolean z5 = true;
            boolean z6 = i5 == 1 || (i5 == 4 ? f12 > 0.0f : !(i5 != 5 || f12 >= 0.0f));
            this.isVertical = z6;
            float f13 = 1 / (f6 - f5);
            this.oneOverDeltaTime = f13;
            boolean z7 = 3 == i5;
            if (z7 || Math.abs(f11) < Epsilon || Math.abs(f12) < Epsilon) {
                float hypot = (float) Math.hypot(f12, f11);
                this.arcDistance = hypot;
                this.arcVelocity = hypot * f13;
                this.ellipseCenterX = f11 / (f6 - f5);
                this.ellipseCenterY = f12 / (f6 - f5);
                this.lut = new float[101];
                this.ellipseA = Float.NaN;
                this.ellipseB = Float.NaN;
            } else {
                this.lut = new float[101];
                this.ellipseA = f11 * (z6 ? -1 : 1);
                this.ellipseB = f12 * (z6 ? 1 : -1);
                this.ellipseCenterX = z6 ? f9 : f7;
                this.ellipseCenterY = z6 ? f8 : f10;
                buildTable(f7, f8, f9, f10);
                this.arcVelocity = this.arcDistance * f13;
                z5 = z7;
            }
            this.isLinear = z5;
        }

        private final void buildTable(float x12, float y12, float x22, float y22) {
            float f5 = x22 - x12;
            float f6 = y12 - y22;
            int length = INSTANCE.getOurPercent().length;
            float f7 = 0.0f;
            float f8 = 0.0f;
            float f9 = 0.0f;
            int i5 = 0;
            while (i5 < length) {
                Companion companion = INSTANCE;
                double radians = (float) Math.toRadians((i5 * 90.0d) / (companion.getOurPercent().length - 1));
                float sin = ((float) Math.sin(radians)) * f5;
                float cos = ((float) Math.cos(radians)) * f6;
                if (i5 > 0) {
                    f7 += (float) Math.hypot(sin - f8, cos - f9);
                    companion.getOurPercent()[i5] = f7;
                }
                i5++;
                f9 = cos;
                f8 = sin;
            }
            this.arcDistance = f7;
            int length2 = INSTANCE.getOurPercent().length;
            for (int i6 = 0; i6 < length2; i6++) {
                float[] ourPercent = INSTANCE.getOurPercent();
                ourPercent[i6] = ourPercent[i6] / f7;
            }
            int length3 = this.lut.length;
            for (int i7 = 0; i7 < length3; i7++) {
                float length4 = i7 / (this.lut.length - 1);
                Companion companion2 = INSTANCE;
                int binarySearch$default = ArraysKt.binarySearch$default(companion2.getOurPercent(), length4, 0, 0, 6, null);
                if (binarySearch$default >= 0) {
                    this.lut[i7] = binarySearch$default / (companion2.getOurPercent().length - 1);
                } else if (binarySearch$default == -1) {
                    this.lut[i7] = 0.0f;
                } else {
                    int i8 = -binarySearch$default;
                    int i9 = i8 - 2;
                    this.lut[i7] = (i9 + ((length4 - companion2.getOurPercent()[i9]) / (companion2.getOurPercent()[i8 - 1] - companion2.getOurPercent()[i9]))) / (companion2.getOurPercent().length - 1);
                }
            }
        }

        private final float lookup(float v5) {
            if (v5 <= 0.0f) {
                return 0.0f;
            }
            if (v5 >= 1.0f) {
                return 1.0f;
            }
            float[] fArr = this.lut;
            float length = v5 * (fArr.length - 1);
            int i5 = (int) length;
            float f5 = length - i5;
            float f6 = fArr[i5];
            return f6 + (f5 * (fArr[i5 + 1] - f6));
        }

        public final float calcDX() {
            float f5 = this.ellipseA * this.tmpCosAngle;
            float hypot = this.arcVelocity / ((float) Math.hypot(f5, (-this.ellipseB) * this.tmpSinAngle));
            if (this.isVertical) {
                f5 = -f5;
            }
            return f5 * hypot;
        }

        public final float calcDY() {
            float f5 = this.ellipseA * this.tmpCosAngle;
            float f6 = (-this.ellipseB) * this.tmpSinAngle;
            float hypot = this.arcVelocity / ((float) Math.hypot(f5, f6));
            return this.isVertical ? (-f6) * hypot : f6 * hypot;
        }

        public final float calcX() {
            return this.ellipseCenterX + (this.ellipseA * this.tmpSinAngle);
        }

        public final float calcY() {
            return this.ellipseCenterY + (this.ellipseB * this.tmpCosAngle);
        }

        /* renamed from: getLinearDX, reason: from getter */
        public final float getEllipseCenterX() {
            return this.ellipseCenterX;
        }

        /* renamed from: getLinearDY, reason: from getter */
        public final float getEllipseCenterY() {
            return this.ellipseCenterY;
        }

        public final float getLinearX(float time) {
            float f5 = (time - this.time1) * this.oneOverDeltaTime;
            float f6 = this.x1;
            return f6 + (f5 * (this.x2 - f6));
        }

        public final float getLinearY(float time) {
            float f5 = (time - this.time1) * this.oneOverDeltaTime;
            float f6 = this.y1;
            return f6 + (f5 * (this.y2 - f6));
        }

        public final float getTime1() {
            return this.time1;
        }

        public final float getTime2() {
            return this.time2;
        }

        /* renamed from: isLinear, reason: from getter */
        public final boolean getIsLinear() {
            return this.isLinear;
        }

        public final void setPoint(float time) {
            double lookup = lookup((this.isVertical ? this.time2 - time : time - this.time1) * this.oneOverDeltaTime) * 1.5707964f;
            this.tmpSinAngle = (float) Math.sin(lookup);
            this.tmpCosAngle = (float) Math.cos(lookup);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
    
        if (r9 != 5) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0029, code lost:
    
        if (r7 == 1) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e A[LOOP:1: B:13:0x003c->B:14:0x003e, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArcSpline(int[] iArr, float[] fArr, float[][] fArr2) {
        int length;
        int i5;
        int length2 = fArr.length - 1;
        Arc[][] arcArr = new Arc[length2];
        int i6 = 1;
        int i7 = 1;
        for (int i8 = 0; i8 < length2; i8++) {
            int i9 = iArr[i8];
            int i10 = 3;
            if (i9 != 0) {
                if (i9 != 1) {
                    if (i9 != 2) {
                        if (i9 != 3) {
                            i10 = 4;
                            if (i9 != 4) {
                                i10 = 5;
                            }
                        }
                    }
                    i6 = 2;
                    i7 = i6;
                    float[] fArr3 = fArr2[i8];
                    length = (fArr3.length / 2) + (fArr3.length % 2);
                    Arc[] arcArr2 = new Arc[length];
                    for (i5 = 0; i5 < length; i5++) {
                        int i11 = i5 * 2;
                        float f5 = fArr[i8];
                        int i12 = i8 + 1;
                        float f6 = fArr[i12];
                        float[] fArr4 = fArr2[i8];
                        float f7 = fArr4[i11];
                        int i13 = i11 + 1;
                        float f8 = fArr4[i13];
                        float[] fArr5 = fArr2[i12];
                        arcArr2[i5] = new Arc(i7, f5, f6, f7, f8, fArr5[i11], fArr5[i13]);
                    }
                    arcArr[i8] = arcArr2;
                }
                i6 = 1;
                i7 = i6;
                float[] fArr32 = fArr2[i8];
                length = (fArr32.length / 2) + (fArr32.length % 2);
                Arc[] arcArr22 = new Arc[length];
                while (i5 < length) {
                }
                arcArr[i8] = arcArr22;
            }
            i7 = i10;
            float[] fArr322 = fArr2[i8];
            length = (fArr322.length / 2) + (fArr322.length % 2);
            Arc[] arcArr222 = new Arc[length];
            while (i5 < length) {
            }
            arcArr[i8] = arcArr222;
        }
        this.arcs = arcArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0022, code lost:
    
        if (r9 > r0[r0.length - 1][0].getTime2()) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void getPos(float time, float[] v5) {
        float time1;
        int i5;
        int i6 = 0;
        if (this.isExtrapolate) {
            if (time >= this.arcs[0][0].getTime1()) {
                Arc[][] arcArr = this.arcs;
            }
            Arc[][] arcArr2 = this.arcs;
            if (time > arcArr2[arcArr2.length - 1][0].getTime2()) {
                Arc[][] arcArr3 = this.arcs;
                i5 = arcArr3.length - 1;
                time1 = arcArr3[arcArr3.length - 1][0].getTime2();
            } else {
                time1 = this.arcs[0][0].getTime1();
                i5 = 0;
            }
            float f5 = time - time1;
            int i7 = 0;
            while (i6 < v5.length) {
                if (this.arcs[i5][i7].getIsLinear()) {
                    v5[i6] = this.arcs[i5][i7].getLinearX(time1) + (this.arcs[i5][i7].getEllipseCenterX() * f5);
                    v5[i6 + 1] = this.arcs[i5][i7].getLinearY(time1) + (this.arcs[i5][i7].getEllipseCenterY() * f5);
                } else {
                    this.arcs[i5][i7].setPoint(time1);
                    v5[i6] = this.arcs[i5][i7].calcX() + (this.arcs[i5][i7].calcDX() * f5);
                    v5[i6 + 1] = this.arcs[i5][i7].calcY() + (this.arcs[i5][i7].calcDY() * f5);
                }
                i6 += 2;
                i7++;
            }
            return;
        }
        if (time < this.arcs[0][0].getTime1()) {
            time = this.arcs[0][0].getTime1();
        }
        Arc[][] arcArr4 = this.arcs;
        if (time > arcArr4[arcArr4.length - 1][0].getTime2()) {
            Arc[][] arcArr5 = this.arcs;
            time = arcArr5[arcArr5.length - 1][0].getTime2();
        }
        int length = this.arcs.length;
        boolean z5 = false;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = 0;
            int i10 = 0;
            while (i9 < v5.length) {
                if (time <= this.arcs[i8][i10].getTime2()) {
                    if (this.arcs[i8][i10].getIsLinear()) {
                        v5[i9] = this.arcs[i8][i10].getLinearX(time);
                        v5[i9 + 1] = this.arcs[i8][i10].getLinearY(time);
                    } else {
                        this.arcs[i8][i10].setPoint(time);
                        v5[i9] = this.arcs[i8][i10].calcX();
                        v5[i9 + 1] = this.arcs[i8][i10].calcY();
                    }
                    z5 = true;
                }
                i9 += 2;
                i10++;
            }
            if (z5) {
                return;
            }
        }
    }

    public final void getSlope(float time, float[] v5) {
        if (time < this.arcs[0][0].getTime1()) {
            time = this.arcs[0][0].getTime1();
        } else {
            Arc[][] arcArr = this.arcs;
            if (time > arcArr[arcArr.length - 1][0].getTime2()) {
                Arc[][] arcArr2 = this.arcs;
                time = arcArr2[arcArr2.length - 1][0].getTime2();
            }
        }
        int length = this.arcs.length;
        boolean z5 = false;
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = 0;
            int i7 = 0;
            while (i6 < v5.length) {
                if (time <= this.arcs[i5][i7].getTime2()) {
                    if (this.arcs[i5][i7].getIsLinear()) {
                        v5[i6] = this.arcs[i5][i7].getEllipseCenterX();
                        v5[i6 + 1] = this.arcs[i5][i7].getEllipseCenterY();
                    } else {
                        this.arcs[i5][i7].setPoint(time);
                        v5[i6] = this.arcs[i5][i7].calcDX();
                        v5[i6 + 1] = this.arcs[i5][i7].calcDY();
                    }
                    z5 = true;
                }
                i6 += 2;
                i7++;
            }
            if (z5) {
                return;
            }
        }
    }
}
