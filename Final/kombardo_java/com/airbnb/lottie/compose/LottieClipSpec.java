package com.airbnb.lottie.compose;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.Marker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H ¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H ¢\u0006\u0004\b\n\u0010\b\u0082\u0001\u0001\r¨\u0006\u000e"}, d2 = {"Lcom/airbnb/lottie/compose/LottieClipSpec;", BuildConfig.FLAVOR, "<init>", "()V", "Lcom/airbnb/lottie/LottieComposition;", "composition", BuildConfig.FLAVOR, "getMinProgress$lottie_compose_release", "(Lcom/airbnb/lottie/LottieComposition;)F", "getMinProgress", "getMaxProgress$lottie_compose_release", "getMaxProgress", "Markers", "Lcom/airbnb/lottie/compose/LottieClipSpec$Markers;", "lottie-compose_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LottieClipSpec {
    public static final int $stable = 0;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0010¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0010¢\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u0012R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001c\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/airbnb/lottie/compose/LottieClipSpec$Markers;", "Lcom/airbnb/lottie/compose/LottieClipSpec;", BuildConfig.FLAVOR, "min", "max", BuildConfig.FLAVOR, "maxInclusive", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "Lcom/airbnb/lottie/LottieComposition;", "composition", BuildConfig.FLAVOR, "getMinProgress$lottie_compose_release", "(Lcom/airbnb/lottie/LottieComposition;)F", "getMinProgress", "getMaxProgress$lottie_compose_release", "getMaxProgress", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMin", "getMax", "Z", "getMaxInclusive", "()Z", "lottie-compose_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final /* data */ class Markers extends LottieClipSpec {
        public static final int $stable = 0;
        private final String max;
        private final boolean maxInclusive;
        private final String min;

        public /* synthetic */ Markers(String str, String str2, boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : str, (i5 & 2) != 0 ? null : str2, (i5 & 4) != 0 ? true : z5);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Markers)) {
                return false;
            }
            Markers markers = (Markers) other;
            return Intrinsics.areEqual(this.min, markers.min) && Intrinsics.areEqual(this.max, markers.max) && this.maxInclusive == markers.maxInclusive;
        }

        @Override // com.airbnb.lottie.compose.LottieClipSpec
        public float getMaxProgress$lottie_compose_release(LottieComposition composition) {
            Intrinsics.checkNotNullParameter(composition, "composition");
            String str = this.max;
            if (str == null) {
                return 1.0f;
            }
            int i5 = this.maxInclusive ? 0 : -1;
            Marker marker = composition.getMarker(str);
            return RangesKt.coerceIn((marker == null ? 0.0f : marker.startFrame + i5) / composition.getEndFrame(), 0.0f, 1.0f);
        }

        @Override // com.airbnb.lottie.compose.LottieClipSpec
        public float getMinProgress$lottie_compose_release(LottieComposition composition) {
            Intrinsics.checkNotNullParameter(composition, "composition");
            String str = this.min;
            if (str == null) {
                return 0.0f;
            }
            Marker marker = composition.getMarker(str);
            return RangesKt.coerceIn((marker == null ? 0.0f : marker.startFrame) / composition.getEndFrame(), 0.0f, 1.0f);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.min;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.max;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z5 = this.maxInclusive;
            int i5 = z5;
            if (z5 != 0) {
                i5 = 1;
            }
            return hashCode2 + i5;
        }

        public String toString() {
            return "Markers(min=" + ((Object) this.min) + ", max=" + ((Object) this.max) + ", maxInclusive=" + this.maxInclusive + ')';
        }

        public Markers(String str, String str2, boolean z5) {
            super(null);
            this.min = str;
            this.max = str2;
            this.maxInclusive = z5;
        }
    }

    public /* synthetic */ LottieClipSpec(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract float getMaxProgress$lottie_compose_release(LottieComposition composition);

    public abstract float getMinProgress$lottie_compose_release(LottieComposition composition);

    private LottieClipSpec() {
    }
}
