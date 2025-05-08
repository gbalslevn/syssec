package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u000eJY\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00102\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0016H\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001e\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u001e\u0010\nJ\u000f\u0010\u001f\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001f\u0010 R$\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020!8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b\"\u0010#\u0012\u0004\b$\u0010%R\u001c\u0010&\u001a\u00020\u00038\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b&\u0010'\u0012\u0004\b(\u0010%\u0082\u0001\u0001)¨\u0006*"}, d2 = {"Landroidx/collection/ObjectList;", "E", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "initialCapacity", "<init>", "(I)V", "element", BuildConfig.FLAVOR, "contains", "(Ljava/lang/Object;)Z", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "()Z", "isNotEmpty", BuildConfig.FLAVOR, "separator", "prefix", "postfix", "limit", "truncated", "Lkotlin/Function1;", "transform", BuildConfig.FLAVOR, "joinToString", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "hashCode", "()I", "other", "equals", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "content", "[Ljava/lang/Object;", "getContent$annotations", "()V", "_size", "I", "get_size$annotations", "Landroidx/collection/MutableObjectList;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ObjectList<E> {
    public int _size;
    public Object[] content;

    public /* synthetic */ ObjectList(int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i5);
    }

    public static /* synthetic */ String joinToString$default(ObjectList objectList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, Function1 function1, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        int i7 = i6 & 2;
        CharSequence charSequence5 = BuildConfig.FLAVOR;
        CharSequence charSequence6 = i7 != 0 ? BuildConfig.FLAVOR : charSequence2;
        if ((i6 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i6 & 8) != 0) {
            i5 = -1;
        }
        int i8 = i5;
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i6 & 32) != 0) {
            function1 = null;
        }
        return objectList.joinToString(charSequence, charSequence6, charSequence5, i8, charSequence7, function1);
    }

    public final boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    public boolean equals(Object other) {
        if (other instanceof ObjectList) {
            ObjectList objectList = (ObjectList) other;
            int i5 = objectList._size;
            int i6 = this._size;
            if (i5 == i6) {
                Object[] objArr = this.content;
                Object[] objArr2 = objectList.content;
                IntRange until = RangesKt.until(0, i6);
                int first = until.getFirst();
                int last = until.getLast();
                if (first > last) {
                    return true;
                }
                while (Intrinsics.areEqual(objArr[first], objArr2[first])) {
                    if (first == last) {
                        return true;
                    }
                    first++;
                }
                return false;
            }
        }
        return false;
    }

    public int hashCode() {
        Object[] objArr = this.content;
        int i5 = this._size;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            Object obj = objArr[i7];
            i6 += (obj != null ? obj.hashCode() : 0) * 31;
        }
        return i6;
    }

    public final int indexOf(E element) {
        int i5 = 0;
        if (element == null) {
            Object[] objArr = this.content;
            int i6 = this._size;
            while (i5 < i6) {
                if (objArr[i5] == null) {
                    return i5;
                }
                i5++;
            }
            return -1;
        }
        Object[] objArr2 = this.content;
        int i7 = this._size;
        while (i5 < i7) {
            if (element.equals(objArr2[i5])) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated, Function1<? super E, ? extends CharSequence> transform) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        Object[] objArr = this.content;
        int i5 = this._size;
        int i6 = 0;
        while (true) {
            if (i6 >= i5) {
                sb.append(postfix);
                break;
            }
            Object obj = objArr[i6];
            if (i6 == limit) {
                sb.append(truncated);
                break;
            }
            if (i6 != 0) {
                sb.append(separator);
            }
            if (transform == null) {
                sb.append(obj);
            } else {
                sb.append(transform.invoke(obj));
            }
            i6++;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, new Function1<E, CharSequence>(this) { // from class: androidx.collection.ObjectList$toString$1
            final /* synthetic */ ObjectList<E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Object obj) {
                return invoke((ObjectList$toString$1<E>) obj);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(E e5) {
                if (e5 == this.this$0) {
                    return "(this)";
                }
                return String.valueOf(e5);
            }
        }, 25, null);
    }

    private ObjectList(int i5) {
        Object[] objArr;
        if (i5 == 0) {
            objArr = ObjectListKt.access$getEmptyArray$p();
        } else {
            objArr = new Object[i5];
        }
        this.content = objArr;
    }
}
