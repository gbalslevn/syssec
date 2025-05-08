package dk.molslinjen.domain.model.saleOnBoard;

import dk.molslinjen.api.services.saleOnBoard.request.PatchOrderRequestParameters;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007j\u0002\b\u0004j\u0002\b\u0005¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/NotificationType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Sms", "Push", "toDTO", "Ldk/molslinjen/api/services/saleOnBoard/request/PatchOrderRequestParameters$NotificationTypeRequestParameters;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NotificationType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ NotificationType[] $VALUES;
    public static final NotificationType Sms = new NotificationType("Sms", 0);
    public static final NotificationType Push = new NotificationType("Push", 1);

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NotificationType.values().length];
            try {
                iArr[NotificationType.Sms.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NotificationType.Push.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ NotificationType[] $values() {
        return new NotificationType[]{Sms, Push};
    }

    static {
        NotificationType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private NotificationType(String str, int i5) {
    }

    public static EnumEntries<NotificationType> getEntries() {
        return $ENTRIES;
    }

    public static NotificationType valueOf(String str) {
        return (NotificationType) Enum.valueOf(NotificationType.class, str);
    }

    public static NotificationType[] values() {
        return (NotificationType[]) $VALUES.clone();
    }

    public final PatchOrderRequestParameters.NotificationTypeRequestParameters toDTO() {
        int i5 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i5 == 1) {
            return PatchOrderRequestParameters.NotificationTypeRequestParameters.Sms;
        }
        if (i5 == 2) {
            return PatchOrderRequestParameters.NotificationTypeRequestParameters.Push;
        }
        throw new NoWhenBranchMatchedException();
    }
}
