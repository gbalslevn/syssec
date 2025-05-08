package com.sdk.growthbook.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/sdk/growthbook/utils/OptionalProperty;", "T", BuildConfig.FLAVOR, "()V", "NotPresent", "Present", "Lcom/sdk/growthbook/utils/OptionalProperty$NotPresent;", "Lcom/sdk/growthbook/utils/OptionalProperty$Present;", "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class OptionalProperty<T> {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/sdk/growthbook/utils/OptionalProperty$NotPresent;", "Lcom/sdk/growthbook/utils/OptionalProperty;", BuildConfig.FLAVOR, "()V", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class NotPresent extends OptionalProperty {
        public static final NotPresent INSTANCE = new NotPresent();

        private NotPresent() {
            super(null);
        }

        public boolean equals(Object other) {
            return this == other || (other instanceof NotPresent);
        }

        public int hashCode() {
            return -1860197977;
        }

        public String toString() {
            return "NotPresent";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/sdk/growthbook/utils/OptionalProperty$Present;", "T", "Lcom/sdk/growthbook/utils/OptionalProperty;", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/sdk/growthbook/utils/OptionalProperty$Present;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "GrowthBook_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Present<T> extends OptionalProperty<T> {
        private final T value;

        public Present(T t5) {
            super(null);
            this.value = t5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Present copy$default(Present present, Object obj, int i5, Object obj2) {
            if ((i5 & 1) != 0) {
                obj = present.value;
            }
            return present.copy(obj);
        }

        public final T component1() {
            return this.value;
        }

        public final Present<T> copy(T value) {
            return new Present<>(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Present) && Intrinsics.areEqual(this.value, ((Present) other).value);
        }

        public final T getValue() {
            return this.value;
        }

        public int hashCode() {
            T t5 = this.value;
            if (t5 == null) {
                return 0;
            }
            return t5.hashCode();
        }

        public String toString() {
            return "Present(value=" + this.value + ')';
        }
    }

    public /* synthetic */ OptionalProperty(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private OptionalProperty() {
    }
}
