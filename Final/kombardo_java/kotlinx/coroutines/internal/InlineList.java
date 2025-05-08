package kotlinx.coroutines.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\b\u0081@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0016\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0006\u001a\u00028\u0000H\u0086\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0088\u0001\u0003\u0092\u0001\u0004\u0018\u00010\u0002ø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/internal/InlineList;", "E", BuildConfig.FLAVOR, "holder", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "element", "plus-FjFbRPM", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "plus", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class InlineList<E> {
    /* renamed from: constructor-impl, reason: not valid java name */
    public static <E> Object m3787constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ Object m3788constructorimpl$default(Object obj, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i5 & 1) != 0) {
            obj = null;
        }
        return m3787constructorimpl(obj);
    }

    /* renamed from: plus-FjFbRPM, reason: not valid java name */
    public static final Object m3789plusFjFbRPM(Object obj, E e5) {
        if (obj == null) {
            return m3787constructorimpl(e5);
        }
        if (obj instanceof ArrayList) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ((ArrayList) obj).add(e5);
            return m3787constructorimpl(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e5);
        return m3787constructorimpl(arrayList);
    }
}
