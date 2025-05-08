package dk.molslinjen.api.helpers;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Ldk/molslinjen/api/helpers/NetworkStatus;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "NoNetwork", "UnknownError", "NotFound", "Success", "Unauthorized", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ NetworkStatus[] $VALUES;
    public static final NetworkStatus NoNetwork = new NetworkStatus("NoNetwork", 0);
    public static final NetworkStatus UnknownError = new NetworkStatus("UnknownError", 1);
    public static final NetworkStatus NotFound = new NetworkStatus("NotFound", 2);
    public static final NetworkStatus Success = new NetworkStatus("Success", 3);
    public static final NetworkStatus Unauthorized = new NetworkStatus("Unauthorized", 4);

    private static final /* synthetic */ NetworkStatus[] $values() {
        return new NetworkStatus[]{NoNetwork, UnknownError, NotFound, Success, Unauthorized};
    }

    static {
        NetworkStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private NetworkStatus(String str, int i5) {
    }

    public static NetworkStatus valueOf(String str) {
        return (NetworkStatus) Enum.valueOf(NetworkStatus.class, str);
    }

    public static NetworkStatus[] values() {
        return (NetworkStatus[]) $VALUES.clone();
    }
}
