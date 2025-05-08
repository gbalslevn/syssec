package dk.molslinjen.ui.views.screens.developer.inputs;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Ldk/molslinjen/ui/views/screens/developer/inputs/InputType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Buttons", "TextField", "TickersAndCheckboxes", "Others", "PhoneNumbers", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class InputType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InputType[] $VALUES;
    public static final InputType Buttons = new InputType("Buttons", 0);
    public static final InputType TextField = new InputType("TextField", 1);
    public static final InputType TickersAndCheckboxes = new InputType("TickersAndCheckboxes", 2);
    public static final InputType Others = new InputType("Others", 3);
    public static final InputType PhoneNumbers = new InputType("PhoneNumbers", 4);

    private static final /* synthetic */ InputType[] $values() {
        return new InputType[]{Buttons, TextField, TickersAndCheckboxes, Others, PhoneNumbers};
    }

    static {
        InputType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private InputType(String str, int i5) {
    }

    public static InputType valueOf(String str) {
        return (InputType) Enum.valueOf(InputType.class, str);
    }

    public static InputType[] values() {
        return (InputType[]) $VALUES.clone();
    }
}
