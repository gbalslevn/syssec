package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 &2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002'&B\u0017\b\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\b\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0010J\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0015H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0096\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000eH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\"\u0010#R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010$R\u0011\u0010%\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b%\u0010!¨\u0006("}, d2 = {"Lokhttp3/Headers;", BuildConfig.FLAVOR, "Lkotlin/Pair;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "namesAndValues", "<init>", "([Ljava/lang/String;)V", "name", "get", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/util/Date;", "getDate", "(Ljava/lang/String;)Ljava/util/Date;", BuildConfig.FLAVOR, "index", "(I)Ljava/lang/String;", "value", BuildConfig.FLAVOR, "values", "(Ljava/lang/String;)Ljava/util/List;", BuildConfig.FLAVOR, "iterator", "()Ljava/util/Iterator;", "Lokhttp3/Headers$Builder;", "newBuilder", "()Lokhttp3/Headers$Builder;", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "()Ljava/lang/String;", "[Ljava/lang/String;", "size", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, KMappedMarker {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String[] namesAndValues;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\b\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0013\u001a\u00020\u00102\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lokhttp3/Headers$Companion;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "namesAndValues", "name", "get", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", BuildConfig.FLAVOR, "checkName", "(Ljava/lang/String;)V", "value", "checkValue", "(Ljava/lang/String;Ljava/lang/String;)V", "Lokhttp3/Headers;", "of", "([Ljava/lang/String;)Lokhttp3/Headers;", "headersOf", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkName(String name) {
            if (name.length() <= 0) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = name.length();
            int i5 = 0;
            while (i5 < length) {
                int i6 = i5 + 1;
                char charAt = name.charAt(i5);
                if ('!' > charAt || charAt >= 127) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i5), name).toString());
                }
                i5 = i6;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void checkValue(String value, String name) {
            int length = value.length();
            int i5 = 0;
            while (i5 < length) {
                int i6 = i5 + 1;
                char charAt = value.charAt(i5);
                if (charAt != '\t' && (' ' > charAt || charAt >= 127)) {
                    throw new IllegalArgumentException(Intrinsics.stringPlus(Util.format("Unexpected char %#04x at %d in %s value", Integer.valueOf(charAt), Integer.valueOf(i5), name), Util.isSensitiveHeader(name) ? BuildConfig.FLAVOR : Intrinsics.stringPlus(": ", value)).toString());
                }
                i5 = i6;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String get(String[] namesAndValues, String name) {
            int length = namesAndValues.length - 2;
            int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(length, 0, -2);
            if (progressionLastElement > length) {
                return null;
            }
            while (true) {
                int i5 = length - 2;
                if (StringsKt.equals(name, namesAndValues[length], true)) {
                    return namesAndValues[length + 1];
                }
                if (length == progressionLastElement) {
                    return null;
                }
                length = i5;
            }
        }

        public final Headers of(String... namesAndValues) {
            Intrinsics.checkNotNullParameter(namesAndValues, "namesAndValues");
            if (namesAndValues.length % 2 != 0) {
                throw new IllegalArgumentException("Expected alternating header names and values");
            }
            String[] strArr = (String[]) namesAndValues.clone();
            int length = strArr.length;
            int i5 = 0;
            int i6 = 0;
            while (i6 < length) {
                int i7 = i6 + 1;
                String str = strArr[i6];
                if (str == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                strArr[i6] = StringsKt.trim(str).toString();
                i6 = i7;
            }
            int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, strArr.length - 1, 2);
            if (progressionLastElement >= 0) {
                while (true) {
                    int i8 = i5 + 2;
                    String str2 = strArr[i5];
                    String str3 = strArr[i5 + 1];
                    checkName(str2);
                    checkValue(str3, str2);
                    if (i5 == progressionLastElement) {
                        break;
                    }
                    i5 = i8;
                }
            }
            return new Headers(strArr, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ Headers(String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(strArr);
    }

    public static final Headers of(String... strArr) {
        return INSTANCE.of(strArr);
    }

    public boolean equals(Object other) {
        return (other instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) other).namesAndValues);
    }

    public final String get(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return INSTANCE.get(this.namesAndValues, name);
    }

    public final Date getDate(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String str = get(name);
        if (str == null) {
            return null;
        }
        return DatesKt.toHttpDateOrNull(str);
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i5 = 0; i5 < size; i5++) {
            pairArr[i5] = TuplesKt.to(name(i5), value(i5));
        }
        return ArrayIteratorKt.iterator(pairArr);
    }

    public final String name(int index) {
        return this.namesAndValues[index * 2];
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        CollectionsKt.addAll(builder.getNamesAndValues$okhttp(), this.namesAndValues);
        return builder;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        int i5 = 0;
        while (i5 < size) {
            int i6 = i5 + 1;
            String name = name(i5);
            String value = value(i5);
            sb.append(name);
            sb.append(": ");
            if (Util.isSensitiveHeader(name)) {
                value = "██";
            }
            sb.append(value);
            sb.append("\n");
            i5 = i6;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String value(int index) {
        return this.namesAndValues[(index * 2) + 1];
    }

    public final List<String> values(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        int size = size();
        ArrayList arrayList = null;
        int i5 = 0;
        while (i5 < size) {
            int i6 = i5 + 1;
            if (StringsKt.equals(name, name(i5), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i5));
            }
            i5 = i6;
        }
        if (arrayList == null) {
            return CollectionsKt.emptyList();
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "{\n      Collections.unmodifiableList(result)\n    }");
        return unmodifiableList;
    }

    private Headers(String[] strArr) {
        this.namesAndValues = strArr;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\fJ\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0007J \u0010\u0013\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\fJ\r\u0010\u0014\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00168\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lokhttp3/Headers$Builder;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "line", "addLenient$okhttp", "(Ljava/lang/String;)Lokhttp3/Headers$Builder;", "addLenient", "name", "value", "add", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/Headers$Builder;", "addUnsafeNonAscii", "Lokhttp3/Headers;", "headers", "addAll", "(Lokhttp3/Headers;)Lokhttp3/Headers$Builder;", "removeAll", "set", "build", "()Lokhttp3/Headers;", BuildConfig.FLAVOR, "namesAndValues", "Ljava/util/List;", "getNamesAndValues$okhttp", "()Ljava/util/List;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Builder {
        private final List<String> namesAndValues = new ArrayList(20);

        public final Builder add(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Companion companion = Headers.INSTANCE;
            companion.checkName(name);
            companion.checkValue(value, name);
            addLenient$okhttp(name, value);
            return this;
        }

        public final Builder addAll(Headers headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            int size = headers.size();
            for (int i5 = 0; i5 < size; i5++) {
                addLenient$okhttp(headers.name(i5), headers.value(i5));
            }
            return this;
        }

        public final Builder addLenient$okhttp(String line) {
            Intrinsics.checkNotNullParameter(line, "line");
            int indexOf$default = StringsKt.indexOf$default((CharSequence) line, ':', 1, false, 4, (Object) null);
            if (indexOf$default != -1) {
                String substring = line.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String substring2 = line.substring(indexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                addLenient$okhttp(substring, substring2);
            } else if (line.charAt(0) == ':') {
                String substring3 = line.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                addLenient$okhttp(BuildConfig.FLAVOR, substring3);
            } else {
                addLenient$okhttp(BuildConfig.FLAVOR, line);
            }
            return this;
        }

        public final Builder addUnsafeNonAscii(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Headers.INSTANCE.checkName(name);
            addLenient$okhttp(name, value);
            return this;
        }

        public final Headers build() {
            Object[] array = this.namesAndValues.toArray(new String[0]);
            if (array != null) {
                return new Headers((String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }

        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        public final Builder removeAll(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            int i5 = 0;
            while (i5 < getNamesAndValues$okhttp().size()) {
                if (StringsKt.equals(name, getNamesAndValues$okhttp().get(i5), true)) {
                    getNamesAndValues$okhttp().remove(i5);
                    getNamesAndValues$okhttp().remove(i5);
                    i5 -= 2;
                }
                i5 += 2;
            }
            return this;
        }

        public final Builder set(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Companion companion = Headers.INSTANCE;
            companion.checkName(name);
            companion.checkValue(value, name);
            removeAll(name);
            addLenient$okhttp(name, value);
            return this;
        }

        public final Builder addLenient$okhttp(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            getNamesAndValues$okhttp().add(name);
            getNamesAndValues$okhttp().add(StringsKt.trim(value).toString());
            return this;
        }
    }
}
