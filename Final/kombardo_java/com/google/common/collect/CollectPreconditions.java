package com.google.common.collect;

import com.google.common.base.Preconditions;

/* loaded from: classes2.dex */
abstract class CollectPreconditions {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkEntryNotNull(Object obj, Object obj2) {
        if (obj == null) {
            String valueOf = String.valueOf(obj2);
            StringBuilder sb = new StringBuilder(valueOf.length() + 24);
            sb.append("null key in entry: null=");
            sb.append(valueOf);
            throw new NullPointerException(sb.toString());
        }
        if (obj2 != null) {
            return;
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(valueOf2.length() + 26);
        sb2.append("null value in entry: ");
        sb2.append(valueOf2);
        sb2.append("=null");
        throw new NullPointerException(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int checkNonnegative(int i5, String str) {
        if (i5 >= 0) {
            return i5;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
        sb.append(str);
        sb.append(" cannot be negative but was: ");
        sb.append(i5);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkRemove(boolean z5) {
        Preconditions.checkState(z5, "no calls to next() since the last call to remove()");
    }
}
