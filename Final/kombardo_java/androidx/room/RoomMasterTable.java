package androidx.room;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Landroidx/room/RoomMasterTable;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "hash", "createInsertQuery", "(Ljava/lang/String;)Ljava/lang/String;", "COLUMN_ID", "Ljava/lang/String;", "COLUMN_IDENTITY_HASH", "room-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RoomMasterTable {
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_IDENTITY_HASH = "identity_hash";
    public static final RoomMasterTable INSTANCE = new RoomMasterTable();

    private RoomMasterTable() {
    }

    public static final String createInsertQuery(String hash) {
        Intrinsics.checkNotNullParameter(hash, "hash");
        return "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + hash + "')";
    }
}
