package com.airbnb.lottie.compose;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec;", BuildConfig.FLAVOR, "RawRes", "Lcom/airbnb/lottie/compose/LottieCompositionSpec$RawRes;", "lottie-compose_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface LottieCompositionSpec {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087@\u0018\u00002\u00020\u0001B\u0014\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0005J\u001a\u0010\u0011\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u0088\u0001\u0003\u0092\u0001\u00020\u0002ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec$RawRes;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec;", BuildConfig.FLAVOR, "resId", "constructor-impl", "(I)I", BuildConfig.FLAVOR, "toString-impl", "(I)Ljava/lang/String;", "toString", "hashCode-impl", "hashCode", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals-impl", "(ILjava/lang/Object;)Z", "equals", "I", "getResId", "()I", "lottie-compose_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class RawRes implements LottieCompositionSpec {
        private final int resId;

        private /* synthetic */ RawRes(int i5) {
            this.resId = i5;
        }

        /* renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ RawRes m2761boximpl(int i5) {
            return new RawRes(i5);
        }

        /* renamed from: constructor-impl, reason: not valid java name */
        public static int m2762constructorimpl(int i5) {
            return i5;
        }

        /* renamed from: equals-impl, reason: not valid java name */
        public static boolean m2763equalsimpl(int i5, Object obj) {
            return (obj instanceof RawRes) && i5 == ((RawRes) obj).getResId();
        }

        /* renamed from: hashCode-impl, reason: not valid java name */
        public static int m2764hashCodeimpl(int i5) {
            return Integer.hashCode(i5);
        }

        /* renamed from: toString-impl, reason: not valid java name */
        public static String m2765toStringimpl(int i5) {
            return "RawRes(resId=" + i5 + ')';
        }

        public boolean equals(Object obj) {
            return m2763equalsimpl(this.resId, obj);
        }

        public int hashCode() {
            return m2764hashCodeimpl(this.resId);
        }

        public String toString() {
            return m2765toStringimpl(this.resId);
        }

        /* renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getResId() {
            return this.resId;
        }
    }
}
