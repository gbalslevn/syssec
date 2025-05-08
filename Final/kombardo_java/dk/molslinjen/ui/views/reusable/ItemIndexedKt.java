package dk.molslinjen.ui.views.reusable;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\u001aK\u0010\u000b\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0004\b\u000b\u0010\f\u001aK\u0010\r\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListScope;", "Ldk/molslinjen/ui/views/reusable/IndexHolder;", "currentIndex", BuildConfig.FLAVOR, "key", "contentType", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/LazyItemScope;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "content", "itemIndexed", "(Landroidx/compose/foundation/lazy/LazyListScope;Ldk/molslinjen/ui/views/reusable/IndexHolder;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)V", "stickyHeaderIndexed", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ItemIndexedKt {
    public static final void itemIndexed(LazyListScope lazyListScope, IndexHolder currentIndex, Object obj, Object obj2, final Function4<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(currentIndex, "currentIndex");
        Intrinsics.checkNotNullParameter(content, "content");
        final int value = currentIndex.getValue();
        currentIndex.setValue(value + 1);
        lazyListScope.item(obj, obj2, ComposableLambdaKt.composableLambdaInstance(409297701, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.ItemIndexedKt$itemIndexed$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope item, Composer composer, int i5) {
                Intrinsics.checkNotNullParameter(item, "$this$item");
                if ((i5 & 6) == 0) {
                    i5 |= composer.changed(item) ? 4 : 2;
                }
                if ((i5 & 19) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(409297701, i5, -1, "dk.molslinjen.ui.views.reusable.itemIndexed.<anonymous> (ItemIndexed.kt:19)");
                }
                content.invoke(item, Integer.valueOf(value), composer, Integer.valueOf(i5 & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    public static /* synthetic */ void itemIndexed$default(LazyListScope lazyListScope, IndexHolder indexHolder, Object obj, Object obj2, Function4 function4, int i5, Object obj3) {
        if ((i5 & 2) != 0) {
            obj = null;
        }
        if ((i5 & 4) != 0) {
            obj2 = null;
        }
        itemIndexed(lazyListScope, indexHolder, obj, obj2, function4);
    }

    public static final void stickyHeaderIndexed(LazyListScope lazyListScope, IndexHolder currentIndex, Object obj, Object obj2, final Function4<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(currentIndex, "currentIndex");
        Intrinsics.checkNotNullParameter(content, "content");
        final int value = currentIndex.getValue();
        currentIndex.setValue(value + 1);
        lazyListScope.stickyHeader(obj, obj2, ComposableLambdaKt.composableLambdaInstance(1640152773, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.ItemIndexedKt$stickyHeaderIndexed$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                invoke(lazyItemScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope stickyHeader, Composer composer, int i5) {
                Intrinsics.checkNotNullParameter(stickyHeader, "$this$stickyHeader");
                if ((i5 & 6) == 0) {
                    i5 |= composer.changed(stickyHeader) ? 4 : 2;
                }
                if ((i5 & 19) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1640152773, i5, -1, "dk.molslinjen.ui.views.reusable.stickyHeaderIndexed.<anonymous> (ItemIndexed.kt:32)");
                }
                content.invoke(stickyHeader, Integer.valueOf(value), composer, Integer.valueOf(i5 & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
    }

    public static /* synthetic */ void stickyHeaderIndexed$default(LazyListScope lazyListScope, IndexHolder indexHolder, Object obj, Object obj2, Function4 function4, int i5, Object obj3) {
        if ((i5 & 2) != 0) {
            obj = null;
        }
        if ((i5 & 4) != 0) {
            obj2 = null;
        }
        stickyHeaderIndexed(lazyListScope, indexHolder, obj, obj2, function4);
    }
}
