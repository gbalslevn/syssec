package dk.molslinjen.domain.model.booking;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Ldk/molslinjen/domain/model/booking/TicketSection;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Passenger", "Addons", "Food", "Summary", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TicketSection {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TicketSection[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final TicketSection Passenger = new TicketSection("Passenger", 0);
    public static final TicketSection Addons = new TicketSection("Addons", 1);
    public static final TicketSection Food = new TicketSection("Food", 2);
    public static final TicketSection Summary = new TicketSection("Summary", 3);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/TicketSection$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/booking/TicketSection;", "name", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TicketSection invoke(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            for (TicketSection ticketSection : TicketSection.values()) {
                if (Intrinsics.areEqual(ticketSection.name(), name)) {
                    return ticketSection;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ TicketSection[] $values() {
        return new TicketSection[]{Passenger, Addons, Food, Summary};
    }

    static {
        TicketSection[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private TicketSection(String str, int i5) {
    }

    public static EnumEntries<TicketSection> getEntries() {
        return $ENTRIES;
    }

    public static TicketSection valueOf(String str) {
        return (TicketSection) Enum.valueOf(TicketSection.class, str);
    }

    public static TicketSection[] values() {
        return (TicketSection[]) $VALUES.clone();
    }
}
