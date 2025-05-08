package com.google.android.gms.internal.identity;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class zzes {
    public static String zza(String str, Object... objArr) {
        int length;
        int length2;
        int indexOf;
        String sb;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            length = objArr.length;
            if (i6 >= length) {
                break;
            }
            Object obj = objArr[i6];
            if (obj == null) {
                sb = "null";
            } else {
                try {
                    sb = obj.toString();
                } catch (Exception e5) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb2 = new StringBuilder(name.length() + 1 + String.valueOf(hexString).length());
                    sb2.append(name);
                    sb2.append("@");
                    sb2.append(hexString);
                    String sb3 = sb2.toString();
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(sb3), (Throwable) e5);
                    String name2 = e5.getClass().getName();
                    StringBuilder sb4 = new StringBuilder(sb3.length() + 8 + name2.length() + 1);
                    sb4.append("<");
                    sb4.append(sb3);
                    sb4.append(" threw ");
                    sb4.append(name2);
                    sb4.append(">");
                    sb = sb4.toString();
                }
            }
            objArr[i6] = sb;
            i6++;
        }
        StringBuilder sb5 = new StringBuilder(str.length() + (length * 16));
        int i7 = 0;
        while (true) {
            length2 = objArr.length;
            if (i5 >= length2 || (indexOf = str.indexOf("%s", i7)) == -1) {
                break;
            }
            sb5.append((CharSequence) str, i7, indexOf);
            sb5.append(objArr[i5]);
            i7 = indexOf + 2;
            i5++;
        }
        sb5.append((CharSequence) str, i7, str.length());
        if (i5 < length2) {
            sb5.append(" [");
            sb5.append(objArr[i5]);
            for (int i8 = i5 + 1; i8 < objArr.length; i8++) {
                sb5.append(", ");
                sb5.append(objArr[i8]);
            }
            sb5.append(']');
        }
        return sb5.toString();
    }
}
