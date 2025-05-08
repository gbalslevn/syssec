package kotlin.enums;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {BuildConfig.FLAVOR, "E", BuildConfig.FLAVOR, "entries", "Lkotlin/enums/EnumEntries;", "enumEntries", "([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class EnumEntriesKt {
    public static final <E extends Enum<E>> EnumEntries<E> enumEntries(E[] entries) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        return new EnumEntriesList(entries);
    }
}
