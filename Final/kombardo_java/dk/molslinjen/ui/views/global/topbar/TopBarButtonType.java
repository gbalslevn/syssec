package dk.molslinjen.ui.views.global.topbar;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Ldk/molslinjen/ui/views/global/topbar/TopBarButtonType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Profile", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TopBarButtonType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TopBarButtonType[] $VALUES;
    public static final TopBarButtonType Profile = new TopBarButtonType("Profile", 0);

    private static final /* synthetic */ TopBarButtonType[] $values() {
        return new TopBarButtonType[]{Profile};
    }

    static {
        TopBarButtonType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private TopBarButtonType(String str, int i5) {
    }

    public static TopBarButtonType valueOf(String str) {
        return (TopBarButtonType) Enum.valueOf(TopBarButtonType.class, str);
    }

    public static TopBarButtonType[] values() {
        return (TopBarButtonType[]) $VALUES.clone();
    }
}
