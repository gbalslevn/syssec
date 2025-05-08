package com.google.common.collect;

/* loaded from: classes2.dex */
public abstract class Multimaps {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean equalsImpl(Multimap<?, ?> multimap, Object obj) {
        if (obj == multimap) {
            return true;
        }
        if (obj instanceof Multimap) {
            return multimap.asMap().equals(((Multimap) obj).asMap());
        }
        return false;
    }
}
