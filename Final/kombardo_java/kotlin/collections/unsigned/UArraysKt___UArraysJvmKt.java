package kotlin.collections.unsigned;

import java.util.List;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lkotlin/ULongArray;", BuildConfig.FLAVOR, "Lkotlin/ULong;", "asList-QwZRm1k", "([J)Ljava/util/List;", "asList", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/unsigned/UArraysKt")
/* loaded from: classes2.dex */
abstract class UArraysKt___UArraysJvmKt {
    /* renamed from: asList-QwZRm1k, reason: not valid java name */
    public static final List<ULong> m3671asListQwZRm1k(long[] asList) {
        Intrinsics.checkNotNullParameter(asList, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$2(asList);
    }
}
