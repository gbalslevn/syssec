package dk.molslinjen.ui.views.reusable.input.validation;

import android.content.Context;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\r\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n\u0082\u0001\r\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$¨\u0006%"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", BuildConfig.FLAVOR, "<init>", "()V", "defaultFormError", BuildConfig.FLAVOR, "Landroid/content/Context;", "toErrorMessage", "context", "fieldKey", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", "Empty", "OnlyLetters", "OnlyDigits", "Length", "Password", "PhoneNumber", "MaxValue", "PassengerCount", "Passenger", "EarlyCheckIn", "LicensePlateRequired", "EarlyCheckInLicensePlateRequired", "Predefined", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$EarlyCheckIn;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$EarlyCheckInLicensePlateRequired;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Empty;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Length;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$LicensePlateRequired;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$MaxValue;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$OnlyDigits;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$OnlyLetters;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Passenger;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$PassengerCount;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Password;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$PhoneNumber;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Predefined;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class InputValidationError {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$EarlyCheckIn;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class EarlyCheckIn extends InputValidationError {
        public static final EarlyCheckIn INSTANCE = new EarlyCheckIn();

        private EarlyCheckIn() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$EarlyCheckInLicensePlateRequired;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class EarlyCheckInLicensePlateRequired extends InputValidationError {
        public static final EarlyCheckInLicensePlateRequired INSTANCE = new EarlyCheckInLicensePlateRequired();

        private EarlyCheckInLicensePlateRequired() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Empty;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Empty extends InputValidationError {
        public static final Empty INSTANCE = new Empty();

        private Empty() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Length;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "<init>", "()V", "Max", "Range", "Exact", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Length$Exact;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Length$Max;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Length$Range;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class Length extends InputValidationError {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\n¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Length$Exact;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Length;", BuildConfig.FLAVOR, "exact", "<init>", "(I)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "I", "getExact", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final /* data */ class Exact extends Length {
            private final int exact;

            public Exact(int i5) {
                super(null);
                this.exact = i5;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Exact) && this.exact == ((Exact) other).exact;
            }

            public final int getExact() {
                return this.exact;
            }

            public int hashCode() {
                return Integer.hashCode(this.exact);
            }

            public String toString() {
                return "Exact(exact=" + this.exact + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\n¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Length$Max;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Length;", BuildConfig.FLAVOR, "max", "<init>", "(I)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "I", "getMax", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final /* data */ class Max extends Length {
            private final int max;

            public Max(int i5) {
                super(null);
                this.max = i5;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Max) && this.max == ((Max) other).max;
            }

            public final int getMax() {
                return this.max;
            }

            public int hashCode() {
                return Integer.hashCode(this.max);
            }

            public String toString() {
                return "Max(max=" + this.max + ")";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Length$Range;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Length;", BuildConfig.FLAVOR, "min", "max", "<init>", "(II)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "I", "getMin", "getMax", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final /* data */ class Range extends Length {
            private final int max;
            private final int min;

            public Range(int i5, int i6) {
                super(null);
                this.min = i5;
                this.max = i6;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Range)) {
                    return false;
                }
                Range range = (Range) other;
                return this.min == range.min && this.max == range.max;
            }

            public final int getMax() {
                return this.max;
            }

            public final int getMin() {
                return this.min;
            }

            public int hashCode() {
                return (Integer.hashCode(this.min) * 31) + Integer.hashCode(this.max);
            }

            public String toString() {
                return "Range(min=" + this.min + ", max=" + this.max + ")";
            }
        }

        public /* synthetic */ Length(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Length() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$LicensePlateRequired;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class LicensePlateRequired extends InputValidationError {
        public static final LicensePlateRequired INSTANCE = new LicensePlateRequired();

        private LicensePlateRequired() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\f¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$MaxValue;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", BuildConfig.FLAVOR, "maxValue", BuildConfig.FLAVOR, "maxValueStringRes", "<init>", "(DI)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "D", "getMaxValue", "()D", "I", "getMaxValueStringRes", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class MaxValue extends InputValidationError {
        private final double maxValue;
        private final int maxValueStringRes;

        public MaxValue(double d5, int i5) {
            super(null);
            this.maxValue = d5;
            this.maxValueStringRes = i5;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MaxValue)) {
                return false;
            }
            MaxValue maxValue = (MaxValue) other;
            return Double.compare(this.maxValue, maxValue.maxValue) == 0 && this.maxValueStringRes == maxValue.maxValueStringRes;
        }

        public final double getMaxValue() {
            return this.maxValue;
        }

        public final int getMaxValueStringRes() {
            return this.maxValueStringRes;
        }

        public int hashCode() {
            return (Double.hashCode(this.maxValue) * 31) + Integer.hashCode(this.maxValueStringRes);
        }

        public String toString() {
            return "MaxValue(maxValue=" + this.maxValue + ", maxValueStringRes=" + this.maxValueStringRes + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$OnlyDigits;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class OnlyDigits extends InputValidationError {
        public static final OnlyDigits INSTANCE = new OnlyDigits();

        private OnlyDigits() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$OnlyLetters;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class OnlyLetters extends InputValidationError {
        public static final OnlyLetters INSTANCE = new OnlyLetters();

        private OnlyLetters() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Passenger;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "<init>", "()V", "SelectMorePassengers", "RemoveSelectedPassengers", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Passenger$RemoveSelectedPassengers;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Passenger$SelectMorePassengers;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class Passenger extends InputValidationError {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Passenger$RemoveSelectedPassengers;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Passenger;", BuildConfig.FLAVOR, "message", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMessage", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final /* data */ class RemoveSelectedPassengers extends Passenger {
            private final String message;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RemoveSelectedPassengers(String message) {
                super(null);
                Intrinsics.checkNotNullParameter(message, "message");
                this.message = message;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RemoveSelectedPassengers) && Intrinsics.areEqual(this.message, ((RemoveSelectedPassengers) other).message);
            }

            public final String getMessage() {
                return this.message;
            }

            public int hashCode() {
                return this.message.hashCode();
            }

            public String toString() {
                return "RemoveSelectedPassengers(message=" + this.message + ")";
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Passenger$SelectMorePassengers;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Passenger;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class SelectMorePassengers extends Passenger {
            public static final SelectMorePassengers INSTANCE = new SelectMorePassengers();

            private SelectMorePassengers() {
                super(null);
            }
        }

        public /* synthetic */ Passenger(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Passenger() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$PassengerCount;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "<init>", "()V", "NoPassengersSelected", "AdultForInfantRequired", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$PassengerCount$AdultForInfantRequired;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$PassengerCount$NoPassengersSelected;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class PassengerCount extends InputValidationError {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$PassengerCount$AdultForInfantRequired;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$PassengerCount;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class AdultForInfantRequired extends PassengerCount {
            public static final AdultForInfantRequired INSTANCE = new AdultForInfantRequired();

            private AdultForInfantRequired() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$PassengerCount$NoPassengersSelected;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$PassengerCount;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class NoPassengersSelected extends PassengerCount {
            public static final NoPassengersSelected INSTANCE = new NoPassengersSelected();

            private NoPassengersSelected() {
                super(null);
            }
        }

        public /* synthetic */ PassengerCount(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private PassengerCount() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Password;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "<init>", "()V", "TooShort", "NoUppercase", "NoLowercase", "NoNumberOrSpecialCharacter", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Password$NoLowercase;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Password$NoNumberOrSpecialCharacter;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Password$NoUppercase;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Password$TooShort;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class Password extends InputValidationError {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Password$NoLowercase;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Password;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class NoLowercase extends Password {
            public static final NoLowercase INSTANCE = new NoLowercase();

            private NoLowercase() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Password$NoNumberOrSpecialCharacter;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Password;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class NoNumberOrSpecialCharacter extends Password {
            public static final NoNumberOrSpecialCharacter INSTANCE = new NoNumberOrSpecialCharacter();

            private NoNumberOrSpecialCharacter() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Password$NoUppercase;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Password;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class NoUppercase extends Password {
            public static final NoUppercase INSTANCE = new NoUppercase();

            private NoUppercase() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Password$TooShort;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Password;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class TooShort extends Password {
            public static final TooShort INSTANCE = new TooShort();

            private TooShort() {
                super(null);
            }
        }

        public /* synthetic */ Password(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Password() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$PhoneNumber;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", "<init>", "()V", "InvalidCountryCode", "InvalidNationalNumber", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$PhoneNumber$InvalidCountryCode;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$PhoneNumber$InvalidNationalNumber;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class PhoneNumber extends InputValidationError {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$PhoneNumber$InvalidCountryCode;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$PhoneNumber;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class InvalidCountryCode extends PhoneNumber {
            public static final InvalidCountryCode INSTANCE = new InvalidCountryCode();

            private InvalidCountryCode() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$PhoneNumber$InvalidNationalNumber;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$PhoneNumber;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class InvalidNationalNumber extends PhoneNumber {
            public static final InvalidNationalNumber INSTANCE = new InvalidNationalNumber();

            private InvalidNationalNumber() {
                super(null);
            }
        }

        public /* synthetic */ PhoneNumber(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private PhoneNumber() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\n¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError$Predefined;", "Ldk/molslinjen/ui/views/reusable/input/validation/InputValidationError;", BuildConfig.FLAVOR, "message", "<init>", "(I)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "I", "getMessage", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Predefined extends InputValidationError {
        private final int message;

        public Predefined(int i5) {
            super(null);
            this.message = i5;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Predefined) && this.message == ((Predefined) other).message;
        }

        public final int getMessage() {
            return this.message;
        }

        public int hashCode() {
            return Integer.hashCode(this.message);
        }

        public String toString() {
            return "Predefined(message=" + this.message + ")";
        }
    }

    public /* synthetic */ InputValidationError(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final String defaultFormError(Context context) {
        String string = context.getString(R.string.validation_default);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final String toErrorMessage(Context context, IFormValidator.ValidationKey fieldKey) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fieldKey, "fieldKey");
        Integer label = fieldKey.getLabel();
        String string2 = label != null ? context.getString(label.intValue()) : null;
        if (Intrinsics.areEqual(this, Empty.INSTANCE)) {
            return (string2 == null || (string = context.getString(R.string.validation_required, string2)) == null) ? defaultFormError(context) : string;
        }
        if (Intrinsics.areEqual(this, OnlyDigits.INSTANCE)) {
            String string3 = context.getString(R.string.validation_onlyNumbers);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        }
        if (Intrinsics.areEqual(this, OnlyLetters.INSTANCE)) {
            String string4 = context.getString(R.string.validation_onlyLetters);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return string4;
        }
        if (this instanceof Length) {
            if (string2 == null) {
                return defaultFormError(context);
            }
            Length length = (Length) this;
            if (length instanceof Length.Max) {
                String string5 = context.getString(R.string.validation_maxLength, string2, Integer.valueOf(((Length.Max) this).getMax()));
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                return string5;
            }
            if (length instanceof Length.Range) {
                Length.Range range = (Length.Range) this;
                String string6 = context.getString(R.string.validation_lengthRange, string2, Integer.valueOf(range.getMin()), Integer.valueOf(range.getMax()));
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                return string6;
            }
            if (!(length instanceof Length.Exact)) {
                throw new NoWhenBranchMatchedException();
            }
            String string7 = context.getString(R.string.validation_lengthExact, string2, Integer.valueOf(((Length.Exact) this).getExact()));
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            return string7;
        }
        if (this instanceof Password) {
            Password password = (Password) this;
            if (!Intrinsics.areEqual(password, Password.NoLowercase.INSTANCE) && !Intrinsics.areEqual(password, Password.NoNumberOrSpecialCharacter.INSTANCE) && !Intrinsics.areEqual(password, Password.NoUppercase.INSTANCE) && !Intrinsics.areEqual(password, Password.TooShort.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            String string8 = context.getString(R.string.signup_passwordScreen_hint_lowerCase);
            Intrinsics.checkNotNull(string8);
            return string8;
        }
        if (this instanceof MaxValue) {
            MaxValue maxValue = (MaxValue) this;
            String string9 = context.getString(maxValue.getMaxValueStringRes(), Double.valueOf(maxValue.getMaxValue()));
            Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
            return string9;
        }
        if (this instanceof Predefined) {
            String string10 = context.getString(((Predefined) this).getMessage());
            Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
            return string10;
        }
        if (this instanceof PassengerCount) {
            PassengerCount passengerCount = (PassengerCount) this;
            if (Intrinsics.areEqual(passengerCount, PassengerCount.AdultForInfantRequired.INSTANCE)) {
                String string11 = context.getString(R.string.passengers_validation_adultForInfantRequired);
                Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                return string11;
            }
            if (!Intrinsics.areEqual(passengerCount, PassengerCount.NoPassengersSelected.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            String string12 = context.getString(R.string.passengers_validation_nonSelected);
            Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
            return string12;
        }
        if (this instanceof Passenger.RemoveSelectedPassengers) {
            return ((Passenger.RemoveSelectedPassengers) this).getMessage();
        }
        if (this instanceof Passenger.SelectMorePassengers) {
            String string13 = context.getString(R.string.passengers_proceedButton_invalidCount);
            Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
            return string13;
        }
        if (Intrinsics.areEqual(this, PhoneNumber.InvalidCountryCode.INSTANCE) || Intrinsics.areEqual(this, PhoneNumber.InvalidNationalNumber.INSTANCE)) {
            String string14 = context.getString(R.string.validation_phoneNumber);
            Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
            return string14;
        }
        if (Intrinsics.areEqual(this, EarlyCheckIn.INSTANCE)) {
            String string15 = context.getString(R.string.validation_earlyCheckIn);
            Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
            return string15;
        }
        if (Intrinsics.areEqual(this, LicensePlateRequired.INSTANCE)) {
            String string16 = context.getString(R.string.validation_licensePlateRequired);
            Intrinsics.checkNotNullExpressionValue(string16, "getString(...)");
            return string16;
        }
        if (!Intrinsics.areEqual(this, EarlyCheckInLicensePlateRequired.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        String string17 = context.getString(R.string.validation_earlyCheckIn);
        Intrinsics.checkNotNullExpressionValue(string17, "getString(...)");
        return string17;
    }

    private InputValidationError() {
    }
}
