package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

/* loaded from: classes3.dex */
public final class ClassMapperLite {
    public static final ClassMapperLite INSTANCE = new ClassMapperLite();

    /* renamed from: kotlin, reason: collision with root package name */
    private static final String f6168kotlin = CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), BuildConfig.FLAVOR, null, null, 0, null, null, 62, null);
    private static final Map<String, String> map;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D"});
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, listOf.size() - 1, 2);
        if (progressionLastElement >= 0) {
            int i5 = 0;
            while (true) {
                StringBuilder sb = new StringBuilder();
                String str = f6168kotlin;
                sb.append(str);
                sb.append('/');
                sb.append((String) listOf.get(i5));
                int i6 = i5 + 1;
                linkedHashMap.put(sb.toString(), listOf.get(i6));
                linkedHashMap.put(str + '/' + ((String) listOf.get(i5)) + "Array", '[' + ((String) listOf.get(i6)));
                if (i5 == progressionLastElement) {
                    break;
                } else {
                    i5 += 2;
                }
            }
        }
        linkedHashMap.put(f6168kotlin + "/Unit", "V");
        map$lambda$0$add(linkedHashMap, "Any", "java/lang/Object");
        map$lambda$0$add(linkedHashMap, "Nothing", "java/lang/Void");
        map$lambda$0$add(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : CollectionsKt.listOf((Object[]) new String[]{"String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum"})) {
            map$lambda$0$add(linkedHashMap, str2, "java/lang/" + str2);
        }
        for (String str3 : CollectionsKt.listOf((Object[]) new String[]{"Iterator", "Collection", "List", "Set", "Map", "ListIterator"})) {
            map$lambda$0$add(linkedHashMap, "collections/" + str3, "java/util/" + str3);
            map$lambda$0$add(linkedHashMap, "collections/Mutable" + str3, "java/util/" + str3);
        }
        map$lambda$0$add(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        map$lambda$0$add(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        map$lambda$0$add(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        map$lambda$0$add(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i7 = 0; i7 < 23; i7++) {
            StringBuilder sb2 = new StringBuilder();
            String str4 = f6168kotlin;
            sb2.append(str4);
            sb2.append("/jvm/functions/Function");
            sb2.append(i7);
            map$lambda$0$add(linkedHashMap, "Function" + i7, sb2.toString());
            map$lambda$0$add(linkedHashMap, "reflect/KFunction" + i7, str4 + "/reflect/KFunction");
        }
        for (String str5 : CollectionsKt.listOf((Object[]) new String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum"})) {
            map$lambda$0$add(linkedHashMap, str5 + ".Companion", f6168kotlin + "/jvm/internal/" + str5 + "CompanionObject");
        }
        map = linkedHashMap;
    }

    private ClassMapperLite() {
    }

    private static final void map$lambda$0$add(Map<String, String> map2, String str, String str2) {
        map2.put(f6168kotlin + '/' + str, 'L' + str2 + ';');
    }

    public static final String mapClass(String classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        String str = map.get(classId);
        if (str != null) {
            return str;
        }
        return 'L' + StringsKt.replace$default(classId, '.', '$', false, 4, (Object) null) + ';';
    }
}
