package dk.molslinjen.core.push;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Ldk/molslinjen/core/push/PushType;", BuildConfig.FLAVOR, "pushTagKey", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getPushTagKey", "()Ljava/lang/String;", "Departure", "Ticket", "SaleOnBoard", "Companion", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PushType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PushType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String pushTagKey;
    public static final PushType Departure = new PushType("Departure", 0, "Departure");
    public static final PushType Ticket = new PushType("Ticket", 1, "Ticket");
    public static final PushType SaleOnBoard = new PushType("SaleOnBoard", 2, "Catering");

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Ldk/molslinjen/core/push/PushType$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/core/push/PushType;", "pushTagKey", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PushType invoke(String pushTagKey) {
            Object obj;
            Iterator<E> it = PushType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((PushType) obj).getPushTagKey(), pushTagKey)) {
                    break;
                }
            }
            return (PushType) obj;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ PushType[] $values() {
        return new PushType[]{Departure, Ticket, SaleOnBoard};
    }

    static {
        PushType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private PushType(String str, int i5, String str2) {
        this.pushTagKey = str2;
    }

    public static EnumEntries<PushType> getEntries() {
        return $ENTRIES;
    }

    public static PushType valueOf(String str) {
        return (PushType) Enum.valueOf(PushType.class, str);
    }

    public static PushType[] values() {
        return (PushType[]) $VALUES.clone();
    }

    public final String getPushTagKey() {
        return this.pushTagKey;
    }
}
