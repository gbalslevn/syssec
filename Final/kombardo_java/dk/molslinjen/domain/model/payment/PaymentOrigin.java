package dk.molslinjen.domain.model.payment;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/domain/model/payment/PaymentOrigin;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Ticket", "TicketChange", "SimpleChangeOrEarlyCheckInTicket", "MultiRideCardFromDetails", "MultiRideCardFromAgreements", "MultiRideTicketFromDetails", "MultiRideTicketFromAgreements", "CommuterTicketFromDetails", "CommuterTicketFromAgreements", "SaleOnBoard", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PaymentOrigin {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PaymentOrigin[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final PaymentOrigin Ticket = new PaymentOrigin("Ticket", 0);
    public static final PaymentOrigin TicketChange = new PaymentOrigin("TicketChange", 1);
    public static final PaymentOrigin SimpleChangeOrEarlyCheckInTicket = new PaymentOrigin("SimpleChangeOrEarlyCheckInTicket", 2);
    public static final PaymentOrigin MultiRideCardFromDetails = new PaymentOrigin("MultiRideCardFromDetails", 3);
    public static final PaymentOrigin MultiRideCardFromAgreements = new PaymentOrigin("MultiRideCardFromAgreements", 4);
    public static final PaymentOrigin MultiRideTicketFromDetails = new PaymentOrigin("MultiRideTicketFromDetails", 5);
    public static final PaymentOrigin MultiRideTicketFromAgreements = new PaymentOrigin("MultiRideTicketFromAgreements", 6);
    public static final PaymentOrigin CommuterTicketFromDetails = new PaymentOrigin("CommuterTicketFromDetails", 7);
    public static final PaymentOrigin CommuterTicketFromAgreements = new PaymentOrigin("CommuterTicketFromAgreements", 8);
    public static final PaymentOrigin SaleOnBoard = new PaymentOrigin("SaleOnBoard", 9);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/payment/PaymentOrigin$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/payment/PaymentOrigin;", "name", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PaymentOrigin invoke(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            for (PaymentOrigin paymentOrigin : PaymentOrigin.values()) {
                if (Intrinsics.areEqual(paymentOrigin.name(), name)) {
                    return paymentOrigin;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ PaymentOrigin[] $values() {
        return new PaymentOrigin[]{Ticket, TicketChange, SimpleChangeOrEarlyCheckInTicket, MultiRideCardFromDetails, MultiRideCardFromAgreements, MultiRideTicketFromDetails, MultiRideTicketFromAgreements, CommuterTicketFromDetails, CommuterTicketFromAgreements, SaleOnBoard};
    }

    static {
        PaymentOrigin[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private PaymentOrigin(String str, int i5) {
    }

    public static EnumEntries<PaymentOrigin> getEntries() {
        return $ENTRIES;
    }

    public static PaymentOrigin valueOf(String str) {
        return (PaymentOrigin) Enum.valueOf(PaymentOrigin.class, str);
    }

    public static PaymentOrigin[] values() {
        return (PaymentOrigin[]) $VALUES.clone();
    }
}
