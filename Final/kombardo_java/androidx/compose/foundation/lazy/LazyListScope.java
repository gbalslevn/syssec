package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J;\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJa\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00042\u0016\b\u0002\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00060\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H'¢\u0006\u0004\b\u0010\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListScope;", BuildConfig.FLAVOR, "key", "contentType", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyItemScope;", BuildConfig.FLAVOR, "content", "item", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", BuildConfig.FLAVOR, "count", "Lkotlin/Function2;", "itemContent", "items", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "stickyHeader", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface LazyListScope {
    static /* synthetic */ void item$default(LazyListScope lazyListScope, Object obj, Object obj2, Function3 function3, int i5, Object obj3) {
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        }
        if ((i5 & 1) != 0) {
            obj = null;
        }
        if ((i5 & 2) != 0) {
            obj2 = null;
        }
        lazyListScope.item(obj, obj2, function3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void items$default(LazyListScope lazyListScope, int i5, Function1 function1, Function1 function12, Function4 function4, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
        }
        if ((i6 & 2) != 0) {
            function1 = null;
        }
        if ((i6 & 4) != 0) {
            function12 = new Function1() { // from class: androidx.compose.foundation.lazy.LazyListScope$items$1
                public final Void invoke(int i7) {
                    return null;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    return invoke(((Number) obj2).intValue());
                }
            };
        }
        lazyListScope.items(i5, function1, function12, function4);
    }

    static /* synthetic */ void stickyHeader$default(LazyListScope lazyListScope, Object obj, Object obj2, Function3 function3, int i5, Object obj3) {
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stickyHeader");
        }
        if ((i5 & 1) != 0) {
            obj = null;
        }
        if ((i5 & 2) != 0) {
            obj2 = null;
        }
        lazyListScope.stickyHeader(obj, obj2, function3);
    }

    void item(Object key, Object contentType, Function3<? super LazyItemScope, ? super Composer, ? super Integer, Unit> content);

    void items(int count, Function1<? super Integer, ? extends Object> key, Function1<? super Integer, ? extends Object> contentType, Function4<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> itemContent);

    void stickyHeader(Object key, Object contentType, Function3<? super LazyItemScope, ? super Composer, ? super Integer, Unit> content);
}
