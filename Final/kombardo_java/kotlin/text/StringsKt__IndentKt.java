package kotlin.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001d\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a%\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\t\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\t\u0010\u0003\u001a\u0013\u0010\r\u001a\u00020\n*\u00020\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a#\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u000f2\u0006\u0010\u000e\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {BuildConfig.FLAVOR, "marginPrefix", "trimMargin", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "newIndent", "replaceIndentByMargin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "trimIndent", "(Ljava/lang/String;)Ljava/lang/String;", "replaceIndent", BuildConfig.FLAVOR, "indentWidth$StringsKt__IndentKt", "(Ljava/lang/String;)I", "indentWidth", "indent", "Lkotlin/Function1;", "getIndentFunction$StringsKt__IndentKt", "(Ljava/lang/String;)Lkotlin/jvm/functions/Function1;", "getIndentFunction", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes3.dex */
public abstract class StringsKt__IndentKt extends StringsKt__AppendableKt {
    private static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(final String str) {
        return str.length() == 0 ? new Function1() { // from class: kotlin.text.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                String indentFunction$lambda$8$StringsKt__IndentKt;
                indentFunction$lambda$8$StringsKt__IndentKt = StringsKt__IndentKt.getIndentFunction$lambda$8$StringsKt__IndentKt((String) obj);
                return indentFunction$lambda$8$StringsKt__IndentKt;
            }
        } : new Function1() { // from class: kotlin.text.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                String indentFunction$lambda$9$StringsKt__IndentKt;
                indentFunction$lambda$9$StringsKt__IndentKt = StringsKt__IndentKt.getIndentFunction$lambda$9$StringsKt__IndentKt(str, (String) obj);
                return indentFunction$lambda$9$StringsKt__IndentKt;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getIndentFunction$lambda$8$StringsKt__IndentKt(String line) {
        Intrinsics.checkNotNullParameter(line, "line");
        return line;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getIndentFunction$lambda$9$StringsKt__IndentKt(String str, String line) {
        Intrinsics.checkNotNullParameter(line, "line");
        return str + line;
    }

    private static final int indentWidth$StringsKt__IndentKt(String str) {
        int length = str.length();
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                i5 = -1;
                break;
            }
            if (!CharsKt.isWhitespace(str.charAt(i5))) {
                break;
            }
            i5++;
        }
        return i5 == -1 ? str.length() : i5;
    }

    public static final String replaceIndent(String str, String newIndent) {
        String invoke;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(newIndent, "newIndent");
        List<String> lines = StringsKt__StringsKt.lines(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : lines) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(indentWidth$StringsKt__IndentKt((String) it.next())));
        }
        Integer num = (Integer) CollectionsKt.minOrNull((Iterable) arrayList2);
        int i5 = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (newIndent.length() * lines.size());
        Function1<String, String> indentFunction$StringsKt__IndentKt = getIndentFunction$StringsKt__IndentKt(newIndent);
        int lastIndex = CollectionsKt.getLastIndex(lines);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : lines) {
            int i6 = i5 + 1;
            if (i5 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str2 = (String) obj2;
            if ((i5 == 0 || i5 == lastIndex) && StringsKt.isBlank(str2)) {
                str2 = null;
            } else {
                String drop = StringsKt.drop(str2, intValue);
                if (drop != null && (invoke = indentFunction$StringsKt__IndentKt.invoke(drop)) != null) {
                    str2 = invoke;
                }
            }
            if (str2 != null) {
                arrayList3.add(str2);
            }
            i5 = i6;
        }
        return ((StringBuilder) CollectionsKt.joinTo$default(arrayList3, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
    }

    public static final String replaceIndentByMargin(String str, String newIndent, String marginPrefix) {
        int i5;
        String invoke;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(newIndent, "newIndent");
        Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        if (StringsKt.isBlank(marginPrefix)) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        List<String> lines = StringsKt__StringsKt.lines(str);
        int length = str.length() + (newIndent.length() * lines.size());
        Function1<String, String> indentFunction$StringsKt__IndentKt = getIndentFunction$StringsKt__IndentKt(newIndent);
        int lastIndex = CollectionsKt.getLastIndex(lines);
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        for (Object obj : lines) {
            int i7 = i6 + 1;
            if (i6 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str2 = (String) obj;
            String str3 = null;
            if ((i6 == 0 || i6 == lastIndex) && StringsKt.isBlank(str2)) {
                str2 = null;
            } else {
                int length2 = str2.length();
                int i8 = 0;
                while (true) {
                    if (i8 >= length2) {
                        i5 = -1;
                        break;
                    }
                    if (!CharsKt.isWhitespace(str2.charAt(i8))) {
                        i5 = i8;
                        break;
                    }
                    i8++;
                }
                if (i5 != -1) {
                    int i9 = i5;
                    if (StringsKt.startsWith$default(str2, marginPrefix, i5, false, 4, null)) {
                        int length3 = i9 + marginPrefix.length();
                        Intrinsics.checkNotNull(str2, "null cannot be cast to non-null type java.lang.String");
                        str3 = str2.substring(length3);
                        Intrinsics.checkNotNullExpressionValue(str3, "substring(...)");
                    }
                }
                if (str3 != null && (invoke = indentFunction$StringsKt__IndentKt.invoke(str3)) != null) {
                    str2 = invoke;
                }
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
            i6 = i7;
        }
        return ((StringBuilder) CollectionsKt.joinTo$default(arrayList, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
    }

    public static String trimIndent(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return replaceIndent(str, BuildConfig.FLAVOR);
    }

    public static final String trimMargin(String str, String marginPrefix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        return replaceIndentByMargin(str, BuildConfig.FLAVOR, marginPrefix);
    }

    public static /* synthetic */ String trimMargin$default(String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str2 = "|";
        }
        return trimMargin(str, str2);
    }
}
