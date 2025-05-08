package uniffi.molslinjen_shared;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Luniffi/molslinjen_shared/SiteId;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "MOLS", "BORNHOLM", "ALS", "LANGELAND", "SAMSOE", "FANOE", "KOMBARDO", "OERESUND", "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SiteId {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SiteId[] $VALUES;
    public static final SiteId MOLS = new SiteId("MOLS", 0);
    public static final SiteId BORNHOLM = new SiteId("BORNHOLM", 1);
    public static final SiteId ALS = new SiteId("ALS", 2);
    public static final SiteId LANGELAND = new SiteId("LANGELAND", 3);
    public static final SiteId SAMSOE = new SiteId("SAMSOE", 4);
    public static final SiteId FANOE = new SiteId("FANOE", 5);
    public static final SiteId KOMBARDO = new SiteId("KOMBARDO", 6);
    public static final SiteId OERESUND = new SiteId("OERESUND", 7);

    private static final /* synthetic */ SiteId[] $values() {
        return new SiteId[]{MOLS, BORNHOLM, ALS, LANGELAND, SAMSOE, FANOE, KOMBARDO, OERESUND};
    }

    static {
        SiteId[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private SiteId(String str, int i5) {
    }

    public static EnumEntries<SiteId> getEntries() {
        return $ENTRIES;
    }

    public static SiteId valueOf(String str) {
        return (SiteId) Enum.valueOf(SiteId.class, str);
    }

    public static SiteId[] values() {
        return (SiteId[]) $VALUES.clone();
    }
}
