package androidx.collection;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0007\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\bJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJA\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u000fJ\u001a\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010 \u001a\u00020\u001f8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b \u0010!\u0012\u0004\b\"\u0010#R\u001c\u0010$\u001a\u00020\u00028\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b$\u0010%\u0012\u0004\b&\u0010#R\u0011\u0010(\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b'\u0010\u000f\u0082\u0001\u0001)¨\u0006*"}, d2 = {"Landroidx/collection/IntList;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "initialCapacity", "<init>", "(I)V", "index", "get", "(I)I", "element", "indexOf", BuildConfig.FLAVOR, "isEmpty", "()Z", "last", "()I", BuildConfig.FLAVOR, "separator", "prefix", "postfix", "limit", "truncated", BuildConfig.FLAVOR, "joinToString", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;)Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "content", "[I", "getContent$annotations", "()V", "_size", "I", "get_size$annotations", "getSize", "size", "Landroidx/collection/MutableIntList;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class IntList {
    public int _size;
    public int[] content;

    public /* synthetic */ IntList(int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i5);
    }

    public static /* synthetic */ String joinToString$default(IntList intList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, int i6, Object obj) {
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
        return intList.joinToString(charSequence, charSequence6, charSequence5, i8, charSequence4);
    }

    public boolean equals(Object other) {
        if (other instanceof IntList) {
            IntList intList = (IntList) other;
            int i5 = intList._size;
            int i6 = this._size;
            if (i5 == i6) {
                int[] iArr = this.content;
                int[] iArr2 = intList.content;
                IntRange until = RangesKt.until(0, i6);
                int first = until.getFirst();
                int last = until.getLast();
                if (first > last) {
                    return true;
                }
                while (iArr[first] == iArr2[first]) {
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

    public final int get(int index) {
        if (index >= 0 && index < this._size) {
            return this.content[index];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Index ");
        sb.append(index);
        sb.append(" must be in 0..");
        sb.append(this._size - 1);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    /* renamed from: getSize, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public int hashCode() {
        int[] iArr = this.content;
        int i5 = this._size;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 += Integer.hashCode(iArr[i7]) * 31;
        }
        return i6;
    }

    public final int indexOf(int element) {
        int[] iArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (element == iArr[i6]) {
                return i6;
            }
        }
        return -1;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final String joinToString(CharSequence separator, CharSequence prefix, CharSequence postfix, int limit, CharSequence truncated) {
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        int[] iArr = this.content;
        int i5 = this._size;
        int i6 = 0;
        while (true) {
            if (i6 >= i5) {
                sb.append(postfix);
                break;
            }
            int i7 = iArr[i6];
            if (i6 == limit) {
                sb.append(truncated);
                break;
            }
            if (i6 != 0) {
                sb.append(separator);
            }
            sb.append(i7);
            i6++;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final int last() {
        if (isEmpty()) {
            throw new NoSuchElementException("IntList is empty.");
        }
        return this.content[this._size - 1];
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, 25, null);
    }

    private IntList(int i5) {
        int[] iArr;
        if (i5 == 0) {
            iArr = IntSetKt.getEmptyIntArray();
        } else {
            iArr = new int[i5];
        }
        this.content = iArr;
    }
}
