package com.google.android.gms.internal.measurement;

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
public abstract class zzlr {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzlm zzlmVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zza(zzlmVar, sb, 0);
        return sb.toString();
    }

    private static void zza(int i5, StringBuilder sb) {
        while (i5 > 0) {
            char[] cArr = zza;
            int length = i5 > cArr.length ? cArr.length : i5;
            sb.append(cArr, 0, length);
            i5 -= length;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(StringBuilder sb, int i5, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zza(sb, i5, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zza(sb, i5, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zza(i5, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i6 = 1; i6 < str.length(); i6++) {
                char charAt = str.charAt(i6);
                if (Character.isUpperCase(charAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(charAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(zzmq.zza(zziy.zza((String) obj)));
            sb.append('\"');
            return;
        }
        if (obj instanceof zziy) {
            sb.append(": \"");
            sb.append(zzmq.zza((zziy) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzkg) {
            sb.append(" {");
            zza((zzkg) obj, sb, i5 + 2);
            sb.append("\n");
            zza(i5, sb);
            sb.append("}");
            return;
        }
        if (obj instanceof Map.Entry) {
            sb.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            int i7 = i5 + 2;
            zza(sb, i7, "key", entry.getKey());
            zza(sb, i7, "value", entry.getValue());
            sb.append("\n");
            zza(i5, sb);
            sb.append("}");
            return;
        }
        sb.append(": ");
        sb.append(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0165, code lost:
    
        if (r5.containsKey("get" + r9.substring(0, r9.length() - 5)) == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0195, code lost:
    
        if (((java.lang.Boolean) r7).booleanValue() == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0197, code lost:
    
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01a8, code lost:
    
        if (((java.lang.Integer) r7).intValue() == 0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01ba, code lost:
    
        if (java.lang.Float.floatToRawIntBits(((java.lang.Float) r7).floatValue()) == 0) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01d0, code lost:
    
        if (java.lang.Double.doubleToRawLongBits(((java.lang.Double) r7).doubleValue()) == 0) goto L65;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void zza(zzlm zzlmVar, StringBuilder sb, int i5) {
        int i6;
        int i7;
        boolean booleanValue;
        boolean equals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzlmVar.getClass().getDeclaredMethods();
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
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                zza(sb, i5, substring.substring(0, substring.length() - 4), zzkg.zza(method2, zzlmVar, new Object[0]));
                i6 = 3;
            } else {
                if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                    i7 = 3;
                    zza(sb, i5, substring.substring(0, substring.length() - 3), zzkg.zza(method, zzlmVar, new Object[0]));
                } else {
                    i7 = 3;
                    if (hashSet.contains("set" + substring)) {
                        if (substring.endsWith("Bytes")) {
                        }
                        Method method4 = (Method) entry.getValue();
                        Method method5 = (Method) hashMap.get("has" + substring);
                        if (method4 != null) {
                            Object zza2 = zzkg.zza(method4, zzlmVar, new Object[0]);
                            if (method5 == null) {
                                booleanValue = true;
                                if (!(zza2 instanceof Boolean)) {
                                    if (!(zza2 instanceof Integer)) {
                                        if (!(zza2 instanceof Float)) {
                                            if (!(zza2 instanceof Double)) {
                                                if (zza2 instanceof String) {
                                                    equals = zza2.equals(BuildConfig.FLAVOR);
                                                } else if (zza2 instanceof zziy) {
                                                    equals = zza2.equals(zziy.zza);
                                                } else {
                                                    equals = !(zza2 instanceof zzlm) ? false : false;
                                                }
                                            }
                                        }
                                    }
                                }
                                if (equals) {
                                    booleanValue = false;
                                }
                            } else {
                                booleanValue = ((Boolean) zzkg.zza(method5, zzlmVar, new Object[0])).booleanValue();
                            }
                            if (booleanValue) {
                                zza(sb, i5, substring, zza2);
                            }
                        }
                    }
                }
                i6 = i7;
            }
        }
        zzmx zzmxVar = ((zzkg) zzlmVar).zzb;
        if (zzmxVar != null) {
            zzmxVar.zza(sb, i5);
        }
    }
}
