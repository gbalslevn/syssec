package dk.molslinjen.api.services.config.response;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/api/services/config/response/SiteDTO;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Mols", "Bornholm", "Als", "Langeland", "Samsoe", "Fanoe", "Kombardo", "Oeresund", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SiteDTO {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SiteDTO[] $VALUES;
    public static final SiteDTO Mols = new SiteDTO("Mols", 0);
    public static final SiteDTO Bornholm = new SiteDTO("Bornholm", 1);
    public static final SiteDTO Als = new SiteDTO("Als", 2);
    public static final SiteDTO Langeland = new SiteDTO("Langeland", 3);
    public static final SiteDTO Samsoe = new SiteDTO("Samsoe", 4);
    public static final SiteDTO Fanoe = new SiteDTO("Fanoe", 5);
    public static final SiteDTO Kombardo = new SiteDTO("Kombardo", 6);
    public static final SiteDTO Oeresund = new SiteDTO("Oeresund", 7);

    private static final /* synthetic */ SiteDTO[] $values() {
        return new SiteDTO[]{Mols, Bornholm, Als, Langeland, Samsoe, Fanoe, Kombardo, Oeresund};
    }

    static {
        SiteDTO[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private SiteDTO(String str, int i5) {
    }

    public static EnumEntries<SiteDTO> getEntries() {
        return $ENTRIES;
    }

    public static SiteDTO valueOf(String str) {
        return (SiteDTO) Enum.valueOf(SiteDTO.class, str);
    }

    public static SiteDTO[] values() {
        return (SiteDTO[]) $VALUES.clone();
    }
}
