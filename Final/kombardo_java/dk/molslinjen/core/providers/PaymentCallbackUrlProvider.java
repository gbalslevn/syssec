package dk.molslinjen.core.providers;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/core/providers/PaymentCallbackUrlProvider;", "Ldk/molslinjen/core/providers/IPaymentCallbackUrlProvider;", "<init>", "()V", "paymentCallbackUrl", BuildConfig.FLAVOR, "getPaymentCallbackUrl", "()Ljava/lang/String;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PaymentCallbackUrlProvider implements IPaymentCallbackUrlProvider {
    @Override // dk.molslinjen.core.providers.IPaymentCallbackUrlProvider
    public String getPaymentCallbackUrl() {
        return "dk.molslinjen.kombardo://paymentcallback";
    }
}
