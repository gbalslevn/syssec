package dk.molslinjen.domain.model.booking;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.core.log.CriticalLog;
import dk.molslinjen.core.log.Logger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\r"}, d2 = {"Ldk/molslinjen/domain/model/booking/TicketCategoryType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "LowPrice", "Flex", "Standard", "BlueClass", "Commuter", "Unknown", "trackingKey", BuildConfig.FLAVOR, "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TicketCategoryType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TicketCategoryType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final TicketCategoryType LowPrice = new TicketCategoryType("LowPrice", 0);
    public static final TicketCategoryType Flex = new TicketCategoryType("Flex", 1);
    public static final TicketCategoryType Standard = new TicketCategoryType("Standard", 2);
    public static final TicketCategoryType BlueClass = new TicketCategoryType("BlueClass", 3);
    public static final TicketCategoryType Commuter = new TicketCategoryType("Commuter", 4);
    public static final TicketCategoryType Unknown = new TicketCategoryType("Unknown", 5);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/TicketCategoryType$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/booking/TicketCategoryType;", Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TicketCategoryType invoke(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            switch (id.hashCode()) {
                case 49:
                    if (id.equals("1")) {
                        return TicketCategoryType.LowPrice;
                    }
                    break;
                case 50:
                    if (id.equals("2")) {
                        return TicketCategoryType.Flex;
                    }
                    break;
                case 51:
                    if (id.equals("3")) {
                        return TicketCategoryType.Standard;
                    }
                    break;
                case 52:
                    if (id.equals("4")) {
                        return TicketCategoryType.BlueClass;
                    }
                    break;
                case 53:
                    if (id.equals("5")) {
                        return TicketCategoryType.Commuter;
                    }
                    break;
            }
            Logger.INSTANCE.logCritical(new CriticalLog("Unknown ticket category type: " + id));
            return TicketCategoryType.Unknown;
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TicketCategoryType.values().length];
            try {
                iArr[TicketCategoryType.LowPrice.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TicketCategoryType.Flex.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TicketCategoryType.Standard.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TicketCategoryType.BlueClass.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TicketCategoryType.Commuter.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TicketCategoryType.Unknown.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ TicketCategoryType[] $values() {
        return new TicketCategoryType[]{LowPrice, Flex, Standard, BlueClass, Commuter, Unknown};
    }

    static {
        TicketCategoryType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private TicketCategoryType(String str, int i5) {
    }

    public static EnumEntries<TicketCategoryType> getEntries() {
        return $ENTRIES;
    }

    public static TicketCategoryType valueOf(String str) {
        return (TicketCategoryType) Enum.valueOf(TicketCategoryType.class, str);
    }

    public static TicketCategoryType[] values() {
        return (TicketCategoryType[]) $VALUES.clone();
    }

    public final String trackingKey() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return "lowprice";
            case 2:
                return "flex";
            case 3:
                return "standard";
            case 4:
                return "blueclass";
            case 5:
                return "commuter";
            case 6:
                return "unknown";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
