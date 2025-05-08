package dk.molslinjen.ui.views.screens.developer.inputs;

import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.input.licensePlate.LicensePlateInputValidator;
import dk.molslinjen.ui.views.reusable.input.validation.IFormValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.EmailInputValidator;
import dk.molslinjen.ui.views.reusable.input.validation.validators.IInputValidator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00102\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0010B\u0013\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/ui/views/screens/developer/inputs/DeveloperInputFormField;", "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", BuildConfig.FLAVOR, "label", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/Integer;)V", "getLabel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "DevEmail", "DevNoErrorText", "DevErrorOnDescription", "DevErrorBelowDescription", "DevPassword", "DevLicensePlate", "Companion", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeveloperInputFormField implements IFormValidator.ValidationKey {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DeveloperInputFormField[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final Integer label;
    public static final DeveloperInputFormField DevEmail = new DeveloperInputFormField("DevEmail", 0, Integer.valueOf(R.string.textField_label_email));
    public static final DeveloperInputFormField DevNoErrorText = new DeveloperInputFormField("DevNoErrorText", 1, null);
    public static final DeveloperInputFormField DevErrorOnDescription = new DeveloperInputFormField("DevErrorOnDescription", 2, null);
    public static final DeveloperInputFormField DevErrorBelowDescription = new DeveloperInputFormField("DevErrorBelowDescription", 3, null);
    public static final DeveloperInputFormField DevPassword = new DeveloperInputFormField("DevPassword", 4, Integer.valueOf(R.string.textField_label_password));
    public static final DeveloperInputFormField DevLicensePlate = new DeveloperInputFormField("DevLicensePlate", 5, Integer.valueOf(R.string.textField_label_licensePlate));

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¨\u0006\b"}, d2 = {"Ldk/molslinjen/ui/views/screens/developer/inputs/DeveloperInputFormField$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "getValidators", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/reusable/input/validation/IFormValidator$ValidationKey;", "Ldk/molslinjen/ui/views/reusable/input/validation/validators/IInputValidator;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DeveloperInputFormField.values().length];
                try {
                    iArr[DeveloperInputFormField.DevEmail.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DeveloperInputFormField.DevNoErrorText.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[DeveloperInputFormField.DevErrorOnDescription.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[DeveloperInputFormField.DevErrorBelowDescription.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[DeveloperInputFormField.DevPassword.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[DeveloperInputFormField.DevLicensePlate.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Map<IFormValidator.ValidationKey, IInputValidator> getValidators() {
            Pair pair;
            DeveloperInputFormField[] values = DeveloperInputFormField.values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
            for (DeveloperInputFormField developerInputFormField : values) {
                switch (WhenMappings.$EnumSwitchMapping$0[developerInputFormField.ordinal()]) {
                    case 1:
                        pair = TuplesKt.to(developerInputFormField, EmailInputValidator.INSTANCE);
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        pair = TuplesKt.to(developerInputFormField, LicensePlateInputValidator.INSTANCE);
                        break;
                    case 6:
                        pair = TuplesKt.to(developerInputFormField, LicensePlateInputValidator.INSTANCE);
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return linkedHashMap;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ DeveloperInputFormField[] $values() {
        return new DeveloperInputFormField[]{DevEmail, DevNoErrorText, DevErrorOnDescription, DevErrorBelowDescription, DevPassword, DevLicensePlate};
    }

    static {
        DeveloperInputFormField[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private DeveloperInputFormField(String str, int i5, Integer num) {
        this.label = num;
    }

    public static DeveloperInputFormField valueOf(String str) {
        return (DeveloperInputFormField) Enum.valueOf(DeveloperInputFormField.class, str);
    }

    public static DeveloperInputFormField[] values() {
        return (DeveloperInputFormField[]) $VALUES.clone();
    }

    @Override // dk.molslinjen.ui.views.reusable.input.validation.IFormValidator.ValidationKey
    public Integer getLabel() {
        return this.label;
    }
}
