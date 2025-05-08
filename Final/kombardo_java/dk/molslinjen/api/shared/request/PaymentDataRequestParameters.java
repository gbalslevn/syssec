package dk.molslinjen.api.shared.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002#\"B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ'\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b \u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b!\u0010\u0017¨\u0006$"}, d2 = {"Ldk/molslinjen/api/shared/request/PaymentDataRequestParameters;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "creditCardToken", "receiptUrl", "callbackFailUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", BuildConfig.FLAVOR, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", BuildConfig.FLAVOR, "write$Self$api_kombardoProd", "(Ldk/molslinjen/api/shared/request/PaymentDataRequestParameters;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCreditCardToken", "getReceiptUrl", "getCallbackFailUrl", "Companion", "$serializer", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class PaymentDataRequestParameters {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String callbackFailUrl;
    private final String creditCardToken;
    private final String receiptUrl;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/shared/request/PaymentDataRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/shared/request/PaymentDataRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<PaymentDataRequestParameters> serializer() {
            return PaymentDataRequestParameters$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ PaymentDataRequestParameters(int i5, String str, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i5 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 7, PaymentDataRequestParameters$$serializer.INSTANCE.getDescriptor());
        }
        this.creditCardToken = str;
        this.receiptUrl = str2;
        this.callbackFailUrl = str3;
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(PaymentDataRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.creditCardToken);
        output.encodeStringElement(serialDesc, 1, self.receiptUrl);
        output.encodeStringElement(serialDesc, 2, self.callbackFailUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentDataRequestParameters)) {
            return false;
        }
        PaymentDataRequestParameters paymentDataRequestParameters = (PaymentDataRequestParameters) other;
        return Intrinsics.areEqual(this.creditCardToken, paymentDataRequestParameters.creditCardToken) && Intrinsics.areEqual(this.receiptUrl, paymentDataRequestParameters.receiptUrl) && Intrinsics.areEqual(this.callbackFailUrl, paymentDataRequestParameters.callbackFailUrl);
    }

    public int hashCode() {
        String str = this.creditCardToken;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.receiptUrl.hashCode()) * 31) + this.callbackFailUrl.hashCode();
    }

    public String toString() {
        return "PaymentDataRequestParameters(creditCardToken=" + this.creditCardToken + ", receiptUrl=" + this.receiptUrl + ", callbackFailUrl=" + this.callbackFailUrl + ")";
    }

    public PaymentDataRequestParameters(String str, String receiptUrl, String callbackFailUrl) {
        Intrinsics.checkNotNullParameter(receiptUrl, "receiptUrl");
        Intrinsics.checkNotNullParameter(callbackFailUrl, "callbackFailUrl");
        this.creditCardToken = str;
        this.receiptUrl = receiptUrl;
        this.callbackFailUrl = callbackFailUrl;
    }
}
