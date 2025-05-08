package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\ba\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0003H&¢\u0006\u0004\b\u000b\u0010\fJ4\u0010\u0010\u001a\u00020\u00062\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH¦@¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", BuildConfig.FLAVOR, "Landroidx/compose/foundation/gestures/ScrollScope;", BuildConfig.FLAVOR, "index", "scrollOffset", BuildConfig.FLAVOR, "snapToItem", "(Landroidx/compose/foundation/gestures/ScrollScope;II)V", "targetIndex", BuildConfig.FLAVOR, "calculateDistanceTo", "(I)F", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "block", "scroll", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFirstVisibleItemIndex", "()I", "firstVisibleItemIndex", "getFirstVisibleItemScrollOffset", "firstVisibleItemScrollOffset", "getLastVisibleItemIndex", "lastVisibleItemIndex", "getItemCount", "itemCount", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface LazyLayoutAnimateScrollScope {
    float calculateDistanceTo(int targetIndex);

    int getFirstVisibleItemIndex();

    int getFirstVisibleItemScrollOffset();

    int getItemCount();

    int getLastVisibleItemIndex();

    Object scroll(Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation);

    void snapToItem(ScrollScope scrollScope, int i5, int i6);
}
