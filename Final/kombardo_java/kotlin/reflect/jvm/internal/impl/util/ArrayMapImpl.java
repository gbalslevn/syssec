package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.AbstractIterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class ArrayMapImpl<T> extends ArrayMap<T> {
    public static final Companion Companion = new Companion(null);
    private Object[] data;
    private int size;

    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private ArrayMapImpl(Object[] objArr, int i5) {
        super(null);
        this.data = objArr;
        this.size = i5;
    }

    private final void ensureCapacity(int i5) {
        Object[] objArr = this.data;
        if (objArr.length > i5) {
            return;
        }
        int length = objArr.length;
        do {
            length *= 2;
        } while (length <= i5);
        Object[] copyOf = Arrays.copyOf(this.data, length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        this.data = copyOf;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public T get(int i5) {
        return (T) ArraysKt.getOrNull(this.data, i5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public int getSize() {
        return this.size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap, java.lang.Iterable
    public Iterator<T> iterator() {
        return new AbstractIterator<T>(this) { // from class: kotlin.reflect.jvm.internal.impl.util.ArrayMapImpl$iterator$1
            private int index = -1;
            final /* synthetic */ ArrayMapImpl<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.collections.AbstractIterator
            protected void computeNext() {
                Object[] objArr;
                Object[] objArr2;
                Object[] objArr3;
                Object[] objArr4;
                do {
                    int i5 = this.index + 1;
                    this.index = i5;
                    objArr = ((ArrayMapImpl) this.this$0).data;
                    if (i5 >= objArr.length) {
                        break;
                    } else {
                        objArr4 = ((ArrayMapImpl) this.this$0).data;
                    }
                } while (objArr4[this.index] == null);
                int i6 = this.index;
                objArr2 = ((ArrayMapImpl) this.this$0).data;
                if (i6 >= objArr2.length) {
                    done();
                    return;
                }
                objArr3 = ((ArrayMapImpl) this.this$0).data;
                Object obj = objArr3[this.index];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of org.jetbrains.kotlin.util.ArrayMapImpl");
                setNext(obj);
            }
        };
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public void set(int i5, T value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ensureCapacity(i5);
        if (this.data[i5] == null) {
            this.size = getSize() + 1;
        }
        this.data[i5] = value;
    }

    public ArrayMapImpl() {
        this(new Object[20], 0);
    }
}
