package dk.molslinjen.ui.views.screens.tickets.addExisting;

import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0013\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/addExisting/AddExistingTicketFormField;", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", BuildConfig.FLAVOR, "label", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/Integer;)V", "getLabel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "CountryCode", "NationalNumber", "ReservationNumber", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AddExistingTicketFormField implements IFormValidator.ValidationKey {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AddExistingTicketFormField[] $VALUES;
    public static final AddExistingTicketFormField CountryCode = new AddExistingTicketFormField("CountryCode", 0, null);
    public static final AddExistingTicketFormField NationalNumber = new AddExistingTicketFormField("NationalNumber", 1, null);
    public static final AddExistingTicketFormField ReservationNumber = new AddExistingTicketFormField("ReservationNumber", 2, Integer.valueOf(R.string.tickets_addExistingTicket_reservationNumber));
    private final Integer label;

    private static final /* synthetic */ AddExistingTicketFormField[] $values() {
        return new AddExistingTicketFormField[]{CountryCode, NationalNumber, ReservationNumber};
    }

    static {
        AddExistingTicketFormField[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private AddExistingTicketFormField(String str, int i5, Integer num) {
        this.label = num;
    }

    public static AddExistingTicketFormField valueOf(String str) {
        return (AddExistingTicketFormField) Enum.valueOf(AddExistingTicketFormField.class, str);
    }

    public static AddExistingTicketFormField[] values() {
        return (AddExistingTicketFormField[]) $VALUES.clone();
    }

    @Override // dk.molslinjen.ui.views.reusable.input.validation.IFormValidator.ValidationKey
    public Integer getLabel() {
        return this.label;
    }
}
