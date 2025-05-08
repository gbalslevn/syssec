package uniffi.molslinjen_shared;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0012\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\n\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Luniffi/molslinjen_shared/CurrencyDto;", BuildConfig.FLAVOR, "value", "Lkotlin/UByte;", "(Ljava/lang/String;IB)V", "getValue-w2LRezQ", "()B", "B", "DKK", "SEK", "EUR", "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CurrencyDto {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CurrencyDto[] $VALUES;
    private final byte value;
    public static final CurrencyDto DKK = new CurrencyDto("DKK", 0, (byte) 0);
    public static final CurrencyDto SEK = new CurrencyDto("SEK", 1, (byte) 1);
    public static final CurrencyDto EUR = new CurrencyDto("EUR", 2, (byte) 2);

    private static final /* synthetic */ CurrencyDto[] $values() {
        return new CurrencyDto[]{DKK, SEK, EUR};
    }

    static {
        CurrencyDto[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private CurrencyDto(String str, int i5, byte b5) {
        this.value = b5;
    }

    public static EnumEntries<CurrencyDto> getEntries() {
        return $ENTRIES;
    }

    public static CurrencyDto valueOf(String str) {
        return (CurrencyDto) Enum.valueOf(CurrencyDto.class, str);
    }

    public static CurrencyDto[] values() {
        return (CurrencyDto[]) $VALUES.clone();
    }

    /* renamed from: getValue-w2LRezQ, reason: not valid java name and from getter */
    public final byte getValue() {
        return this.value;
    }
}
