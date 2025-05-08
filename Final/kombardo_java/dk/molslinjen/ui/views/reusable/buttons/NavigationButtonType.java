package dk.molslinjen.ui.views.reusable.buttons;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/ui/views/reusable/buttons/NavigationButtonType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Back", "Close", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NavigationButtonType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ NavigationButtonType[] $VALUES;
    public static final NavigationButtonType Back = new NavigationButtonType("Back", 0);
    public static final NavigationButtonType Close = new NavigationButtonType("Close", 1);

    private static final /* synthetic */ NavigationButtonType[] $values() {
        return new NavigationButtonType[]{Back, Close};
    }

    static {
        NavigationButtonType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private NavigationButtonType(String str, int i5) {
    }

    public static NavigationButtonType valueOf(String str) {
        return (NavigationButtonType) Enum.valueOf(NavigationButtonType.class, str);
    }

    public static NavigationButtonType[] values() {
        return (NavigationButtonType[]) $VALUES.clone();
    }
}
