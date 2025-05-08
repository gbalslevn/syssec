package dk.molslinjen.api;

import dk.molslinjen.core.Environment;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"dk/molslinjen/api/ApiConstants$Payment", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "PaymentServiceBaseUrl", "Ljava/lang/String;", "getPaymentServiceBaseUrl", "()Ljava/lang/String;", "PaymentServiceApiKey", "getPaymentServiceApiKey", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ApiConstants$Payment {
    public static final ApiConstants$Payment INSTANCE = new ApiConstants$Payment();
    private static final String PaymentServiceApiKey;
    private static final String PaymentServiceBaseUrl;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Environment.values().length];
            try {
                iArr[Environment.Dev.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Environment.Test.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Environment.ProdTest.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Environment.Prod.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        String str;
        String str2;
        Environment.Companion companion = Environment.INSTANCE;
        Environment current = companion.current();
        int[] iArr = WhenMappings.$EnumSwitchMapping$0;
        int i5 = iArr[current.ordinal()];
        if (i5 == 1 || i5 == 2) {
            str = "https://payment.stage.molslinjen.dk/api/payment";
        } else {
            if (i5 != 3 && i5 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            str = "https://payment.molslinjen.dk/api/payment";
        }
        PaymentServiceBaseUrl = str;
        int i6 = iArr[companion.current().ordinal()];
        if (i6 == 1 || i6 == 2) {
            str2 = companion.isKombardo() ? "EFdT7JCC+dmrg1XV+xRUORtQwIFqz24C5X5ggm3RtPjzRucIs7/yLu+V4XaD1GxANaXCgsOoo7ooOZ0JAyoR9Q==" : "7rqzmTXodlJjz0quM7CE/37Vswn5PgIpkQMeEPo4YsPDTXDBWUlrAVD6E7TfWzCqEcr1oQHhGCZVWVc+ZtGqoA==";
        } else {
            if (i6 != 3 && i6 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            str2 = companion.isKombardo() ? "sVYOVaXClIfWLIb7r9tHqNz6HzHFbdB4H8F88cwJyJX1vnTGp19o7miCZP7bPBaNp1JqevpId1UejMtOmulkfg==" : "jCT7k0ovVmsS8crzvPjLIynRkzBdOAQ+/ipGLkjLnxJ3Ap4X+LI1NzOQMGhJiVOxAYc5NY96X0r4ynAc8ugpbQ==";
        }
        PaymentServiceApiKey = str2;
    }

    private ApiConstants$Payment() {
    }

    public final String getPaymentServiceApiKey() {
        return PaymentServiceApiKey;
    }

    public final String getPaymentServiceBaseUrl() {
        return PaymentServiceBaseUrl;
    }
}
