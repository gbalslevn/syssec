package androidx.room;

import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Landroidx/room/CoroutinesRoom;", BuildConfig.FLAVOR, "Companion", "room-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class CoroutinesRoom {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JG\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/room/CoroutinesRoom$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "R", "Landroidx/room/RoomDatabase;", "db", BuildConfig.FLAVOR, "inTransaction", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "tableNames", "Ljava/util/concurrent/Callable;", "callable", "Lkotlinx/coroutines/flow/Flow;", "createFlow", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lkotlinx/coroutines/flow/Flow;", "room-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <R> Flow<R> createFlow(RoomDatabase db, boolean inTransaction, String[] tableNames, Callable<R> callable) {
            return FlowKt.flow(new CoroutinesRoom$Companion$createFlow$1(inTransaction, db, tableNames, callable, null));
        }

        private Companion() {
        }
    }

    public static final <R> Flow<R> createFlow(RoomDatabase roomDatabase, boolean z5, String[] strArr, Callable<R> callable) {
        return INSTANCE.createFlow(roomDatabase, z5, strArr, callable);
    }
}
