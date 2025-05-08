package dk.molslinjen.domain.model.payment;

import dk.molslinjen.api.services.paymentTypes.response.PaymentTypeDTO;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007j\u0002\b\u0004j\u0002\b\u0005¨\u0006\t"}, d2 = {"Ldk/molslinjen/domain/model/payment/PaymentType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Card", "MobilePay", "toDTO", "Ldk/molslinjen/api/services/paymentTypes/response/PaymentTypeDTO;", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PaymentType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PaymentType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final PaymentType Card = new PaymentType("Card", 0);
    public static final PaymentType MobilePay = new PaymentType("MobilePay", 1);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/payment/PaymentType$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/payment/PaymentType;", "dto", "Ldk/molslinjen/api/services/paymentTypes/response/PaymentTypeDTO;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PaymentTypeDTO.values().length];
                try {
                    iArr[PaymentTypeDTO.Card.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[PaymentTypeDTO.MobilePay.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PaymentType invoke(PaymentTypeDTO dto) {
            Intrinsics.checkNotNullParameter(dto, "dto");
            int i5 = WhenMappings.$EnumSwitchMapping$0[dto.ordinal()];
            if (i5 == 1) {
                return PaymentType.Card;
            }
            if (i5 == 2) {
                return PaymentType.MobilePay;
            }
            throw new NoWhenBranchMatchedException();
        }

        private Companion() {
        }
    }

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

    private static final /* synthetic */ PaymentType[] $values() {
        return new PaymentType[]{Card, MobilePay};
    }

    static {
        PaymentType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private PaymentType(String str, int i5) {
    }

    public static EnumEntries<PaymentType> getEntries() {
        return $ENTRIES;
    }

    public static PaymentType valueOf(String str) {
        return (PaymentType) Enum.valueOf(PaymentType.class, str);
    }

    public static PaymentType[] values() {
        return (PaymentType[]) $VALUES.clone();
    }

    public final PaymentTypeDTO toDTO() {
        int i5 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i5 == 1) {
            return PaymentTypeDTO.Card;
        }
        if (i5 == 2) {
            return PaymentTypeDTO.MobilePay;
        }
        throw new NoWhenBranchMatchedException();
    }
}
