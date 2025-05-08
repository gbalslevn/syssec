package dk.molslinjen.core.migration.oldApp;

import dk.molslinjen.domain.model.account.Gender;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppGender;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "rawValue", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ldk/molslinjen/domain/model/account/Gender;", "toGender", "()Ldk/molslinjen/domain/model/account/Gender;", "Ljava/lang/String;", "getRawValue", "()Ljava/lang/String;", "Male", "Female", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OldAppGender {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ OldAppGender[] $VALUES;
    private final String rawValue;
    public static final OldAppGender Male = new OldAppGender("Male", 0, "M");
    public static final OldAppGender Female = new OldAppGender("Female", 1, "F");

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OldAppGender.values().length];
            try {
                iArr[OldAppGender.Male.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OldAppGender.Female.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ OldAppGender[] $values() {
        return new OldAppGender[]{Male, Female};
    }

    static {
        OldAppGender[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private OldAppGender(String str, int i5, String str2) {
        this.rawValue = str2;
    }

    public static OldAppGender valueOf(String str) {
        return (OldAppGender) Enum.valueOf(OldAppGender.class, str);
    }

    public static OldAppGender[] values() {
        return (OldAppGender[]) $VALUES.clone();
    }

    public final Gender toGender() {
        int i5 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i5 == 1) {
            return Gender.Male;
        }
        if (i5 == 2) {
            return Gender.Female;
        }
        throw new NoWhenBranchMatchedException();
    }
}
