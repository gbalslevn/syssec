package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", BuildConfig.FLAVOR, "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface NestedScrollConnection {
    /* renamed from: onPostFling-RZ2iAVY$suspendImpl, reason: not valid java name */
    static /* synthetic */ Object m1833onPostFlingRZ2iAVY$suspendImpl(NestedScrollConnection nestedScrollConnection, long j5, long j6, Continuation<? super Velocity> continuation) {
        return Velocity.m2695boximpl(Velocity.INSTANCE.m2709getZero9UxMQ8M());
    }

    /* renamed from: onPreFling-QWom1Mo$suspendImpl, reason: not valid java name */
    static /* synthetic */ Object m1834onPreFlingQWom1Mo$suspendImpl(NestedScrollConnection nestedScrollConnection, long j5, Continuation<? super Velocity> continuation) {
        return Velocity.m2695boximpl(Velocity.INSTANCE.m2709getZero9UxMQ8M());
    }

    /* renamed from: onPostFling-RZ2iAVY */
    default Object mo218onPostFlingRZ2iAVY(long j5, long j6, Continuation<? super Velocity> continuation) {
        return m1833onPostFlingRZ2iAVY$suspendImpl(this, j5, j6, continuation);
    }

    /* renamed from: onPostScroll-DzOQY0M */
    default long mo219onPostScrollDzOQY0M(long consumed, long available, int source) {
        return Offset.INSTANCE.m1349getZeroF1C5BW0();
    }

    /* renamed from: onPreFling-QWom1Mo */
    default Object mo711onPreFlingQWom1Mo(long j5, Continuation<? super Velocity> continuation) {
        return m1834onPreFlingQWom1Mo$suspendImpl(this, j5, continuation);
    }

    /* renamed from: onPreScroll-OzD1aCk */
    default long mo435onPreScrollOzD1aCk(long available, int source) {
        return Offset.INSTANCE.m1349getZeroF1C5BW0();
    }
}
