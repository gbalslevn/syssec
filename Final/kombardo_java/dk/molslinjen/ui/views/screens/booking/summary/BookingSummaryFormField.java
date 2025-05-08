package dk.molslinjen.ui.views.screens.booking.summary;

import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0013\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/summary/BookingSummaryFormField;", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", BuildConfig.FLAVOR, "label", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/Integer;)V", "getLabel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "NationalNumber", "CountryCode", "Email", "PostalCode", "Terms", "EarlyCheckIn", "LicensePlate", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BookingSummaryFormField implements IFormValidator.ValidationKey {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BookingSummaryFormField[] $VALUES;
    private final Integer label;
    public static final BookingSummaryFormField NationalNumber = new BookingSummaryFormField("NationalNumber", 0, null);
    public static final BookingSummaryFormField CountryCode = new BookingSummaryFormField("CountryCode", 1, null);
    public static final BookingSummaryFormField Email = new BookingSummaryFormField("Email", 2, Integer.valueOf(R.string.textField_label_email));
    public static final BookingSummaryFormField PostalCode = new BookingSummaryFormField("PostalCode", 3, Integer.valueOf(R.string.textField_label_zipcode));
    public static final BookingSummaryFormField Terms = new BookingSummaryFormField("Terms", 4, null);
    public static final BookingSummaryFormField EarlyCheckIn = new BookingSummaryFormField("EarlyCheckIn", 5, null);
    public static final BookingSummaryFormField LicensePlate = new BookingSummaryFormField("LicensePlate", 6, null);

    private static final /* synthetic */ BookingSummaryFormField[] $values() {
        return new BookingSummaryFormField[]{NationalNumber, CountryCode, Email, PostalCode, Terms, EarlyCheckIn, LicensePlate};
    }

    static {
        BookingSummaryFormField[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private BookingSummaryFormField(String str, int i5, Integer num) {
        this.label = num;
    }

    public static BookingSummaryFormField valueOf(String str) {
        return (BookingSummaryFormField) Enum.valueOf(BookingSummaryFormField.class, str);
    }

    public static BookingSummaryFormField[] values() {
        return (BookingSummaryFormField[]) $VALUES.clone();
    }

    @Override // dk.molslinjen.ui.views.reusable.input.validation.IFormValidator.ValidationKey
    public Integer getLabel() {
        return this.label;
    }
}
