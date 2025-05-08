package dk.molslinjen.domain.managers;

import dk.molslinjen.api.helpers.NetworkStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Ldk/molslinjen/domain/managers/ManagerResult;", "T", BuildConfig.FLAVOR, "<init>", "()V", "Success", "Error", "Ldk/molslinjen/domain/managers/ManagerResult$Error;", "Ldk/molslinjen/domain/managers/ManagerResult$Success;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ManagerResult<T> {

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\nB\u0011\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\t\u0082\u0001\u0001\f¨\u0006\r"}, d2 = {"Ldk/molslinjen/domain/managers/ManagerResult$Error;", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "Ldk/molslinjen/api/helpers/NetworkStatus;", "networkStatus", "<init>", "(Ldk/molslinjen/api/helpers/NetworkStatus;)V", "Ldk/molslinjen/api/helpers/NetworkStatus;", "getNetworkStatus", "()Ldk/molslinjen/api/helpers/NetworkStatus;", "Companion", "ErrorString", "Ldk/molslinjen/domain/managers/ManagerResult$Error$ErrorString;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static abstract class Error extends ManagerResult {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final NetworkStatus networkStatus;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/managers/ManagerResult$Error$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Ldk/molslinjen/domain/managers/ManagerResult$Error;", "noMessage", "()Ldk/molslinjen/domain/managers/ManagerResult$Error;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final Error noMessage() {
                return new ErrorString(null, 0 == true ? 1 : 0, 1, 0 == true ? 1 : 0);
            }

            private Companion() {
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\t¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/domain/managers/ManagerResult$Error$ErrorString;", "Ldk/molslinjen/domain/managers/ManagerResult$Error;", "Ldk/molslinjen/api/helpers/NetworkStatus;", "networkStatus", BuildConfig.FLAVOR, "message", "<init>", "(Ldk/molslinjen/api/helpers/NetworkStatus;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/api/helpers/NetworkStatus;", "getNetworkStatus", "()Ldk/molslinjen/api/helpers/NetworkStatus;", "Ljava/lang/String;", "getMessage", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final /* data */ class ErrorString extends Error {
            private final String message;
            private final NetworkStatus networkStatus;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ErrorString(NetworkStatus networkStatus, String str) {
                super(networkStatus, null);
                Intrinsics.checkNotNullParameter(networkStatus, "networkStatus");
                this.networkStatus = networkStatus;
                this.message = str;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ErrorString)) {
                    return false;
                }
                ErrorString errorString = (ErrorString) other;
                return this.networkStatus == errorString.networkStatus && Intrinsics.areEqual(this.message, errorString.message);
            }

            public final String getMessage() {
                return this.message;
            }

            @Override // dk.molslinjen.domain.managers.ManagerResult.Error
            public NetworkStatus getNetworkStatus() {
                return this.networkStatus;
            }

            public int hashCode() {
                int hashCode = this.networkStatus.hashCode() * 31;
                String str = this.message;
                return hashCode + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "ErrorString(networkStatus=" + this.networkStatus + ", message=" + this.message + ")";
            }

            public /* synthetic */ ErrorString(NetworkStatus networkStatus, String str, int i5, DefaultConstructorMarker defaultConstructorMarker) {
                this((i5 & 1) != 0 ? NetworkStatus.UnknownError : networkStatus, str);
            }
        }

        public /* synthetic */ Error(NetworkStatus networkStatus, DefaultConstructorMarker defaultConstructorMarker) {
            this(networkStatus);
        }

        public abstract NetworkStatus getNetworkStatus();

        private Error(NetworkStatus networkStatus) {
            super(null);
            this.networkStatus = networkStatus;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00028\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/domain/managers/ManagerResult$Success;", "T", "Ldk/molslinjen/domain/managers/ManagerResult;", "data", "<init>", "(Ljava/lang/Object;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Success<T> extends ManagerResult<T> {
        private final T data;

        public Success(T t5) {
            super(null);
            this.data = t5;
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

    public /* synthetic */ ManagerResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ManagerResult() {
    }
}
