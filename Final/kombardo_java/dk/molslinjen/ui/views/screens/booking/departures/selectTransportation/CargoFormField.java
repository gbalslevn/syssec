package dk.molslinjen.ui.views.screens.booking.departures.selectTransportation;

import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0013\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/selectTransportation/CargoFormField;", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", BuildConfig.FLAVOR, "label", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/Integer;)V", "getLabel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Weight", "Note1", "Note2", "Note3", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CargoFormField implements IFormValidator.ValidationKey {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CargoFormField[] $VALUES;
    private final Integer label;
    public static final CargoFormField Weight = new CargoFormField("Weight", 0, null);
    public static final CargoFormField Note1 = new CargoFormField("Note1", 1, Integer.valueOf(R.string.cargoDetails_note1_title));
    public static final CargoFormField Note2 = new CargoFormField("Note2", 2, Integer.valueOf(R.string.cargoDetails_note2_title));
    public static final CargoFormField Note3 = new CargoFormField("Note3", 3, Integer.valueOf(R.string.cargoDetails_note3_title));

    private static final /* synthetic */ CargoFormField[] $values() {
        return new CargoFormField[]{Weight, Note1, Note2, Note3};
    }

    static {
        CargoFormField[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private CargoFormField(String str, int i5, Integer num) {
        this.label = num;
    }

    public static CargoFormField valueOf(String str) {
        return (CargoFormField) Enum.valueOf(CargoFormField.class, str);
    }

    public static CargoFormField[] values() {
        return (CargoFormField[]) $VALUES.clone();
    }

    @Override // dk.molslinjen.ui.views.reusable.input.validation.IFormValidator.ValidationKey
    public Integer getLabel() {
        return this.label;
    }
}
