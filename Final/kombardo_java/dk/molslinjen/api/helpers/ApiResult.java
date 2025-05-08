package dk.molslinjen.api.helpers;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Ldk/molslinjen/api/helpers/ApiResult;", "R", BuildConfig.FLAVOR, "<init>", "()V", "Success", "Error", "Ldk/molslinjen/api/helpers/ApiResult$Error;", "Ldk/molslinjen/api/helpers/ApiResult$Success;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ApiResult<R> {

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\n¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/api/helpers/ApiResult$Error;", "Ldk/molslinjen/api/helpers/ApiResult;", BuildConfig.FLAVOR, "Ldk/molslinjen/api/helpers/NetworkStatus;", "networkStatus", BuildConfig.FLAVOR, "errorMessage", "<init>", "(Ldk/molslinjen/api/helpers/NetworkStatus;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/api/helpers/NetworkStatus;", "getNetworkStatus", "()Ldk/molslinjen/api/helpers/NetworkStatus;", "Ljava/lang/String;", "getErrorMessage", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Error extends ApiResult {
        private final String errorMessage;
        private final NetworkStatus networkStatus;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(NetworkStatus networkStatus, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(networkStatus, "networkStatus");
            this.networkStatus = networkStatus;
            this.errorMessage = str;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return this.networkStatus == error.networkStatus && Intrinsics.areEqual(this.errorMessage, error.errorMessage);
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }

        public final NetworkStatus getNetworkStatus() {
            return this.networkStatus;
        }

        public int hashCode() {
            int hashCode = this.networkStatus.hashCode() * 31;
            String str = this.errorMessage;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "Error(networkStatus=" + this.networkStatus + ", errorMessage=" + this.errorMessage + ")";
        }

        public /* synthetic */ Error(NetworkStatus networkStatus, String str, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(networkStatus, (i5 & 2) != 0 ? null : str);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00028\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/api/helpers/ApiResult$Success;", "T", "Ldk/molslinjen/api/helpers/ApiResult;", "data", "<init>", "(Ljava/lang/Object;)V", "copy", "(Ljava/lang/Object;)Ldk/molslinjen/api/helpers/ApiResult$Success;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Success<T> extends ApiResult<T> {
        private final T data;

        public Success(T t5) {
            super(null);
            this.data = t5;
        }

        public final Success<T> copy(T data) {
            return new Success<>(data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Success) && Intrinsics.areEqual(this.data, ((Success) other).data);
        }

        public final T getData() {
            return this.data;
        }

        public int hashCode() {
            T t5 = this.data;
            if (t5 == null) {
                return 0;
            }
            return t5.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.data + ")";
        }
    }

    public /* synthetic */ ApiResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ApiResult() {
    }
}
