package kotlin.coroutines;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CombinedContext;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\"B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\t\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH\u0096\u0002¢\u0006\u0002\u0010\rJ5\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u0002H\u000f2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u000f0\u0012H\u0016¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u00020\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0000H\u0002J\u0013\u0010\u001b\u001a\u00020\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "minusKey", "size", BuildConfig.FLAVOR, "contains", BuildConfig.FLAVOR, "containsAll", "context", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "writeReplace", "Serialized", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CombinedContext implements CoroutineContext, Serializable {
    private final CoroutineContext.Element element;
    private final CoroutineContext left;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", BuildConfig.FLAVOR, "Lkotlin/coroutines/CoroutineContext;", "elements", "<init>", "([Lkotlin/coroutines/CoroutineContext;)V", BuildConfig.FLAVOR, "readResolve", "()Ljava/lang/Object;", "[Lkotlin/coroutines/CoroutineContext;", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    private static final class Serialized implements Serializable {
        private static final long serialVersionUID = 0;
        private final CoroutineContext[] elements;

        public Serialized(CoroutineContext[] elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            this.elements = elements;
        }

        private final Object readResolve() {
            CoroutineContext[] coroutineContextArr = this.elements;
            CoroutineContext coroutineContext = EmptyCoroutineContext.INSTANCE;
            for (CoroutineContext coroutineContext2 : coroutineContextArr) {
                coroutineContext = coroutineContext.plus(coroutineContext2);
            }
            return coroutineContext;
        }
    }

    public CombinedContext(CoroutineContext left, CoroutineContext.Element element) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(element, "element");
        this.left = left;
        this.element = element;
    }

    private final boolean contains(CoroutineContext.Element element) {
        return Intrinsics.areEqual(get(element.getKey()), element);
    }

    private final boolean containsAll(CombinedContext context) {
        while (contains(context.element)) {
            CoroutineContext coroutineContext = context.left;
            if (!(coroutineContext instanceof CombinedContext)) {
                Intrinsics.checkNotNull(coroutineContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return contains((CoroutineContext.Element) coroutineContext);
            }
            context = (CombinedContext) coroutineContext;
        }
        return false;
    }

    private final int size() {
        int i5 = 2;
        CombinedContext combinedContext = this;
        while (true) {
            CoroutineContext coroutineContext = combinedContext.left;
            combinedContext = coroutineContext instanceof CombinedContext ? (CombinedContext) coroutineContext : null;
            if (combinedContext == null) {
                return i5;
            }
            i5++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toString$lambda$2(String acc, CoroutineContext.Element element) {
        Intrinsics.checkNotNullParameter(acc, "acc");
        Intrinsics.checkNotNullParameter(element, "element");
        if (acc.length() == 0) {
            return element.toString();
        }
        return acc + ", " + element;
    }

    private final Object writeReplace() {
        int size = size();
        final CoroutineContext[] coroutineContextArr = new CoroutineContext[size];
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        fold(Unit.INSTANCE, new Function2() { // from class: E4.a
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit writeReplace$lambda$3;
                writeReplace$lambda$3 = CombinedContext.writeReplace$lambda$3(coroutineContextArr, ref$IntRef, (Unit) obj, (CoroutineContext.Element) obj2);
                return writeReplace$lambda$3;
            }
        });
        if (ref$IntRef.element == size) {
            return new Serialized(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeReplace$lambda$3(CoroutineContext[] coroutineContextArr, Ref$IntRef ref$IntRef, Unit unit, CoroutineContext.Element element) {
        Intrinsics.checkNotNullParameter(unit, "<unused var>");
        Intrinsics.checkNotNullParameter(element, "element");
        int i5 = ref$IntRef.element;
        ref$IntRef.element = i5 + 1;
        coroutineContextArr[i5] = element;
        return Unit.INSTANCE;
    }

    public boolean equals(Object other) {
        if (this != other) {
            if (other instanceof CombinedContext) {
                CombinedContext combinedContext = (CombinedContext) other;
                if (combinedContext.size() != size() || !combinedContext.containsAll(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R initial, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return operation.invoke((Object) this.left.fold(initial, operation), this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        CombinedContext combinedContext = this;
        while (true) {
            E e5 = (E) combinedContext.element.get(key);
            if (e5 != null) {
                return e5;
            }
            CoroutineContext coroutineContext = combinedContext.left;
            if (!(coroutineContext instanceof CombinedContext)) {
                return (E) coroutineContext.get(key);
            }
            combinedContext = (CombinedContext) coroutineContext;
        }
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.element.get(key) != null) {
            return this.left;
        }
        CoroutineContext minusKey = this.left.minusKey(key);
        return minusKey == this.left ? this : minusKey == EmptyCoroutineContext.INSTANCE ? this.element : new CombinedContext(minusKey, this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.plus(this, coroutineContext);
    }

    public String toString() {
        return '[' + ((String) fold(BuildConfig.FLAVOR, new Function2() { // from class: E4.b
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                String string$lambda$2;
                string$lambda$2 = CombinedContext.toString$lambda$2((String) obj, (CoroutineContext.Element) obj2);
                return string$lambda$2;
            }
        })) + ']';
    }
}
