package dk.molslinjen.core.extensions;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\u0002H\u0001\"\u0010\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0003*\u0002H\u0001\"\u0004\b\u0001\u0010\u0001*\u0004\u0018\u0001H\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"ifNullOrEmpty", "R", "C", BuildConfig.FLAVOR, "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "core_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CollectionExtensionsKt {
    /* JADX WARN: Incorrect types in method signature: <C::Ljava/util/Collection<*>;:TR;R:Ljava/lang/Object;>(TC;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    public static final Object ifNullOrEmpty(Collection collection, Function0 defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (collection == null || collection.isEmpty()) ? defaultValue.invoke() : collection;
    }
}
