package dk.molslinjen.core.migration.oldApp;

import android.content.Context;
import dk.molslinjen.kombardo.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.core.migration.oldApp.OldAppDataMigrator$migrateBookings$2$1", f = "OldAppDataMigrator.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class OldAppDataMigrator$migrateBookings$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ List<String> $failureMessages;
    final /* synthetic */ OldAppBooking $it;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OldAppDataMigrator$migrateBookings$2$1(List<String> list, Context context, OldAppBooking oldAppBooking, Continuation<? super OldAppDataMigrator$migrateBookings$2$1> continuation) {
        super(1, continuation);
        this.$failureMessages = list;
        this.$context = context;
        this.$it = oldAppBooking;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new OldAppDataMigrator$migrateBookings$2$1(this.$failureMessages, this.$context, this.$it, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List<String> list = this.$failureMessages;
        String string = this.$context.getString(R.string.migration_bookings_specific, this.$it.getReservationNumber());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        list.add(string);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((OldAppDataMigrator$migrateBookings$2$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
