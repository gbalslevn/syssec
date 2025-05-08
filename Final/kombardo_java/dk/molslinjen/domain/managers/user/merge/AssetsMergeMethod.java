package dk.molslinjen.domain.managers.user.merge;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/managers/user/merge/AssetsMergeMethod;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Merge", "Discard", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AssetsMergeMethod {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AssetsMergeMethod[] $VALUES;
    public static final AssetsMergeMethod Merge = new AssetsMergeMethod("Merge", 0);
    public static final AssetsMergeMethod Discard = new AssetsMergeMethod("Discard", 1);

    private static final /* synthetic */ AssetsMergeMethod[] $values() {
        return new AssetsMergeMethod[]{Merge, Discard};
    }

    static {
        AssetsMergeMethod[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private AssetsMergeMethod(String str, int i5) {
    }

    public static AssetsMergeMethod valueOf(String str) {
        return (AssetsMergeMethod) Enum.valueOf(AssetsMergeMethod.class, str);
    }

    public static AssetsMergeMethod[] values() {
        return (AssetsMergeMethod[]) $VALUES.clone();
    }
}
