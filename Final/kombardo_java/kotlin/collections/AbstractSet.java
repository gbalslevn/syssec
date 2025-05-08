package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b'\u0018\u0000 \f*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\fB\t\b\u0004¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lkotlin/collections/AbstractSet;", "E", "Lkotlin/collections/AbstractCollection;", BuildConfig.FLAVOR, "<init>", "()V", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AbstractSet<E> extends AbstractCollection<E> implements Set<E>, KMappedMarker {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\"\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0000¢\u0006\u0002\b\bJ%\u0010\t\u001a\u00020\n2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0000¢\u0006\u0002\b\r¨\u0006\u000e"}, d2 = {"Lkotlin/collections/AbstractSet$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "unorderedHashCode", BuildConfig.FLAVOR, "c", BuildConfig.FLAVOR, "unorderedHashCode$kotlin_stdlib", "setEquals", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "other", "setEquals$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean setEquals$kotlin_stdlib(Set<?> c5, Set<?> other) {
            Intrinsics.checkNotNullParameter(c5, "c");
            Intrinsics.checkNotNullParameter(other, "other");
            if (c5.size() != other.size()) {
                return false;
            }
            return c5.containsAll(other);
        }

        public final int unorderedHashCode$kotlin_stdlib(Collection<?> c5) {
            Intrinsics.checkNotNullParameter(c5, "c");
            Iterator<?> it = c5.iterator();
            int i5 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                i5 += next != null ? next.hashCode() : 0;
            }
            return i5;
        }

        private Companion() {
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof Set) {
            return INSTANCE.setEquals$kotlin_stdlib(this, (Set) other);
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return INSTANCE.unorderedHashCode$kotlin_stdlib(this);
    }
}
