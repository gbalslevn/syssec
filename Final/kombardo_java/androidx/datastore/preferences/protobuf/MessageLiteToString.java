package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class MessageLiteToString {
    private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
    private static final String BYTES_SUFFIX = "Bytes";
    private static final char[] INDENT_BUFFER;
    private static final String LIST_SUFFIX = "List";
    private static final String MAP_SUFFIX = "Map";

    static {
        char[] cArr = new char[80];
        INDENT_BUFFER = cArr;
        Arrays.fill(cArr, ' ');
    }

    private static void indent(int i5, StringBuilder sb) {
        while (i5 > 0) {
            char[] cArr = INDENT_BUFFER;
            int length = i5 > cArr.length ? cArr.length : i5;
            sb.append(cArr, 0, length);
            i5 -= length;
        }
    }

    private static boolean isDefaultValue(Object obj) {
        return obj instanceof Boolean ? !((Boolean) obj).booleanValue() : obj instanceof Integer ? ((Integer) obj).intValue() == 0 : obj instanceof Float ? Float.floatToRawIntBits(((Float) obj).floatValue()) == 0 : obj instanceof Double ? Double.doubleToRawLongBits(((Double) obj).doubleValue()) == 0 : obj instanceof String ? obj.equals(BuildConfig.FLAVOR) : obj instanceof ByteString ? obj.equals(ByteString.EMPTY) : obj instanceof MessageLite ? obj == ((MessageLite) obj).getDefaultInstanceForType() : (obj instanceof Enum) && ((Enum) obj).ordinal() == 0;
    }

    private static String pascalCaseToSnakeCase(String str) {
        if (str.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toLowerCase(str.charAt(0)));
        for (int i5 = 1; i5 < str.length(); i5++) {
            char charAt = str.charAt(i5);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void printField(StringBuilder sb, int i5, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                printField(sb, i5, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                printField(sb, i5, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        indent(i5, sb);
        sb.append(pascalCaseToSnakeCase(str));
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(TextFormatEscaper.escapeText((String) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof ByteString) {
            sb.append(": \"");
            sb.append(TextFormatEscaper.escapeBytes((ByteString) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof GeneratedMessageLite) {
            sb.append(" {");
            reflectivePrintWithIndent((GeneratedMessageLite) obj, sb, i5 + 2);
            sb.append("\n");
            indent(i5, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i6 = i5 + 2;
        printField(sb, i6, "key", entry.getKey());
        printField(sb, i6, "value", entry.getValue());
        sb.append("\n");
        indent(i5, sb);
        sb.append("}");
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0170, code lost:
    
        if (r5.containsKey("get" + r9.substring(0, r9.length() - 5)) != false) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void reflectivePrintWithIndent(MessageLite messageLite, StringBuilder sb, int i5) {
        int i6;
        int i7;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = messageLite.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i8 = 0;
        while (true) {
            i6 = 3;
            if (i8 >= length) {
                break;
            }
            Method method3 = declaredMethods[i8];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i8++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i6);
            if (!substring.endsWith(LIST_SUFFIX) || substring.endsWith(BUILDER_LIST_SUFFIX) || substring.equals(LIST_SUFFIX) || (method2 = (Method) entry.getValue()) == null || !method2.getReturnType().equals(List.class)) {
                if (!substring.endsWith(MAP_SUFFIX) || substring.equals(MAP_SUFFIX) || (method = (Method) entry.getValue()) == null || !method.getReturnType().equals(Map.class) || method.isAnnotationPresent(Deprecated.class) || !Modifier.isPublic(method.getModifiers())) {
                    i7 = 3;
                    if (hashSet.contains("set" + substring)) {
                        if (substring.endsWith(BYTES_SUFFIX)) {
                        }
                        Method method4 = (Method) entry.getValue();
                        Method method5 = (Method) hashMap.get("has" + substring);
                        if (method4 != null) {
                            Object invokeOrDie = GeneratedMessageLite.invokeOrDie(method4, messageLite, new Object[0]);
                            if (method5 == null ? !isDefaultValue(invokeOrDie) : ((Boolean) GeneratedMessageLite.invokeOrDie(method5, messageLite, new Object[0])).booleanValue()) {
                                printField(sb, i5, substring, invokeOrDie);
                            }
                        }
                    }
                } else {
                    i7 = 3;
                    printField(sb, i5, substring.substring(0, substring.length() - 3), GeneratedMessageLite.invokeOrDie(method, messageLite, new Object[0]));
                }
                i6 = i7;
            } else {
                printField(sb, i5, substring.substring(0, substring.length() - 4), GeneratedMessageLite.invokeOrDie(method2, messageLite, new Object[0]));
                i6 = 3;
            }
        }
        UnknownFieldSetLite unknownFieldSetLite = ((GeneratedMessageLite) messageLite).unknownFields;
        if (unknownFieldSetLite != null) {
            unknownFieldSetLite.printWithIndent(sb, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toString(MessageLite messageLite, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        reflectivePrintWithIndent(messageLite, sb, 0);
        return sb.toString();
    }
}
