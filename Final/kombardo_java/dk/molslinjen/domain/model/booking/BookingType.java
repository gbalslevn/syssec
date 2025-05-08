package dk.molslinjen.domain.model.booking;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/booking/BookingType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Single", "TwoWay", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BookingType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BookingType[] $VALUES;
    public static final BookingType Single = new BookingType("Single", 0);
    public static final BookingType TwoWay = new BookingType("TwoWay", 1);

    private static final /* synthetic */ BookingType[] $values() {
        return new BookingType[]{Single, TwoWay};
    }

    static {
        BookingType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private BookingType(String str, int i5) {
    }

    public static EnumEntries<BookingType> getEntries() {
        return $ENTRIES;
    }

    public static BookingType valueOf(String str) {
        return (BookingType) Enum.valueOf(BookingType.class, str);
    }

    public static BookingType[] values() {
        return (BookingType[]) $VALUES.clone();
    }
}
