package dk.molslinjen.ui.views.screens.profile.merge;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/merge/AssetsMergeFlowType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Login", "ResetPassword", "AccountActivation", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AssetsMergeFlowType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AssetsMergeFlowType[] $VALUES;
    public static final AssetsMergeFlowType Login = new AssetsMergeFlowType("Login", 0);
    public static final AssetsMergeFlowType ResetPassword = new AssetsMergeFlowType("ResetPassword", 1);
    public static final AssetsMergeFlowType AccountActivation = new AssetsMergeFlowType("AccountActivation", 2);

    private static final /* synthetic */ AssetsMergeFlowType[] $values() {
        return new AssetsMergeFlowType[]{Login, ResetPassword, AccountActivation};
    }

    static {
        AssetsMergeFlowType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private AssetsMergeFlowType(String str, int i5) {
    }

    public static AssetsMergeFlowType valueOf(String str) {
        return (AssetsMergeFlowType) Enum.valueOf(AssetsMergeFlowType.class, str);
    }

    public static AssetsMergeFlowType[] values() {
        return (AssetsMergeFlowType[]) $VALUES.clone();
    }
}
