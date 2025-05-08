package dk.molslinjen.ui.views.screens.profile.brobizz.register;

import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0013\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bj\u0002\b\n¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/brobizz/register/BrobizzInputFormField;", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", BuildConfig.FLAVOR, "label", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/Integer;)V", "getLabel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "BrobizzNumber", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BrobizzInputFormField implements IFormValidator.ValidationKey {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BrobizzInputFormField[] $VALUES;
    public static final BrobizzInputFormField BrobizzNumber = new BrobizzInputFormField("BrobizzNumber", 0, Integer.valueOf(R.string.profile_brobizz_register_label));
    private final Integer label;

    private static final /* synthetic */ BrobizzInputFormField[] $values() {
        return new BrobizzInputFormField[]{BrobizzNumber};
    }

    static {
        BrobizzInputFormField[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private BrobizzInputFormField(String str, int i5, Integer num) {
        this.label = num;
    }

    public static BrobizzInputFormField valueOf(String str) {
        return (BrobizzInputFormField) Enum.valueOf(BrobizzInputFormField.class, str);
    }

    public static BrobizzInputFormField[] values() {
        return (BrobizzInputFormField[]) $VALUES.clone();
    }

    @Override // dk.molslinjen.ui.views.reusable.input.validation.IFormValidator.ValidationKey
    public Integer getLabel() {
        return this.label;
    }
}
