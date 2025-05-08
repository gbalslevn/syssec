package dk.molslinjen.ui.views.screens.agreements.multiride.add;

import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0013\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/multiride/add/MultiRideAddCardFormField;", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", BuildConfig.FLAVOR, "label", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/Integer;)V", "getLabel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "MultiRideCardId", "Email", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MultiRideAddCardFormField implements IFormValidator.ValidationKey {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MultiRideAddCardFormField[] $VALUES;
    private final Integer label;
    public static final MultiRideAddCardFormField MultiRideCardId = new MultiRideAddCardFormField("MultiRideCardId", 0, Integer.valueOf(R.string.multiRide_addExisting_cardNumber));
    public static final MultiRideAddCardFormField Email = new MultiRideAddCardFormField("Email", 1, Integer.valueOf(R.string.textField_label_email));

    private static final /* synthetic */ MultiRideAddCardFormField[] $values() {
        return new MultiRideAddCardFormField[]{MultiRideCardId, Email};
    }

    static {
        MultiRideAddCardFormField[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private MultiRideAddCardFormField(String str, int i5, Integer num) {
        this.label = num;
    }

    public static MultiRideAddCardFormField valueOf(String str) {
        return (MultiRideAddCardFormField) Enum.valueOf(MultiRideAddCardFormField.class, str);
    }

    public static MultiRideAddCardFormField[] values() {
        return (MultiRideAddCardFormField[]) $VALUES.clone();
    }

    @Override // dk.molslinjen.ui.views.reusable.input.validation.IFormValidator.ValidationKey
    public Integer getLabel() {
        return this.label;
    }
}
