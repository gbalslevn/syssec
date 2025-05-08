package dk.molslinjen.extensions.domain;

import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.payment.PaymentType;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"icon", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/payment/PaymentType;", "getIcon", "(Ldk/molslinjen/domain/model/payment/PaymentType;)I", Constants.IntentExtra.PushTitle, "getTitle", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PaymentTypeExtensionsKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaymentType.values().length];
            try {
                iArr[PaymentType.Card.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PaymentType.MobilePay.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int getIcon(PaymentType paymentType) {
        Intrinsics.checkNotNullParameter(paymentType, "<this>");
        int i5 = WhenMappings.$EnumSwitchMapping$0[paymentType.ordinal()];
        if (i5 == 1) {
            return 2131165402;
        }
        if (i5 == 2) {
            return R.drawable.icon_payment_mobilepay;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final int getTitle(PaymentType paymentType) {
        Intrinsics.checkNotNullParameter(paymentType, "<this>");
        int i5 = WhenMappings.$EnumSwitchMapping$0[paymentType.ordinal()];
        if (i5 == 1) {
            return R.string.payment_cards;
        }
        if (i5 == 2) {
            return R.string.payment_mobilePay;
        }
        throw new NoWhenBranchMatchedException();
    }
}
