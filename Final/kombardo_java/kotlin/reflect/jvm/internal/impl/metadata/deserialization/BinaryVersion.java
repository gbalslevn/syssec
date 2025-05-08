package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public abstract class BinaryVersion {
    public static final Companion Companion = new Companion(null);
    private final int major;
    private final int minor;
    private final int[] numbers;
    private final int patch;
    private final List<Integer> rest;

    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public BinaryVersion(int... numbers) {
        List<Integer> emptyList;
        Intrinsics.checkNotNullParameter(numbers, "numbers");
        this.numbers = numbers;
        Integer orNull = ArraysKt.getOrNull(numbers, 0);
        this.major = orNull != null ? orNull.intValue() : -1;
        Integer orNull2 = ArraysKt.getOrNull(numbers, 1);
        this.minor = orNull2 != null ? orNull2.intValue() : -1;
        Integer orNull3 = ArraysKt.getOrNull(numbers, 2);
        this.patch = orNull3 != null ? orNull3.intValue() : -1;
        if (numbers.length <= 3) {
            emptyList = CollectionsKt.emptyList();
        } else {
            if (numbers.length > 1024) {
                throw new IllegalArgumentException("BinaryVersion with length more than 1024 are not supported. Provided length " + numbers.length + '.');
            }
            emptyList = CollectionsKt.toList(ArraysKt.asList(numbers).subList(3, numbers.length));
        }
        this.rest = emptyList;
    }

    public boolean equals(Object obj) {
        if (obj != null && Intrinsics.areEqual(getClass(), obj.getClass())) {
            BinaryVersion binaryVersion = (BinaryVersion) obj;
            if (this.major == binaryVersion.major && this.minor == binaryVersion.minor && this.patch == binaryVersion.patch && Intrinsics.areEqual(this.rest, binaryVersion.rest)) {
                return true;
            }
        }
        return false;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public int hashCode() {
        int i5 = this.major;
        int i6 = i5 + (i5 * 31) + this.minor;
        int i7 = i6 + (i6 * 31) + this.patch;
        return i7 + (i7 * 31) + this.rest.hashCode();
    }

    public final boolean isAtLeast(BinaryVersion version) {
        Intrinsics.checkNotNullParameter(version, "version");
        return isAtLeast(version.major, version.minor, version.patch);
    }

    public final boolean isAtMost(int i5, int i6, int i7) {
        int i8 = this.major;
        if (i8 < i5) {
            return true;
        }
        if (i8 > i5) {
            return false;
        }
        int i9 = this.minor;
        if (i9 < i6) {
            return true;
        }
        return i9 <= i6 && this.patch <= i7;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isCompatibleTo(BinaryVersion ourVersion) {
        Intrinsics.checkNotNullParameter(ourVersion, "ourVersion");
        int i5 = this.major;
        if (i5 == 0) {
            if (ourVersion.major != 0 || this.minor != ourVersion.minor) {
                return false;
            }
        } else if (i5 != ourVersion.major || this.minor > ourVersion.minor) {
            return false;
        }
        return true;
    }

    public final int[] toArray() {
        return this.numbers;
    }

    public String toString() {
        int[] array = toArray();
        ArrayList arrayList = new ArrayList();
        for (int i5 : array) {
            if (i5 == -1) {
                break;
            }
            arrayList.add(Integer.valueOf(i5));
        }
        return arrayList.isEmpty() ? "unknown" : CollectionsKt.joinToString$default(arrayList, ".", null, null, 0, null, null, 62, null);
    }

    public final boolean isAtLeast(int i5, int i6, int i7) {
        int i8 = this.major;
        if (i8 > i5) {
            return true;
        }
        if (i8 < i5) {
            return false;
        }
        int i9 = this.minor;
        if (i9 > i6) {
            return true;
        }
        return i9 >= i6 && this.patch >= i7;
    }
}
