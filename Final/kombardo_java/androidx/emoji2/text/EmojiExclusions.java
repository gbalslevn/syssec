package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.os.Build;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
abstract class EmojiExclusions {

    /* loaded from: classes.dex */
    private static class EmojiExclusions_Api34 {
        static Set<int[]> getExclusions() {
            return EmojiExclusions_Reflections.getExclusions();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class EmojiExclusions_Reflections {
        @SuppressLint({"BanUncheckedReflection"})
        static Set<int[]> getExclusions() {
            try {
                Object invoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", null).invoke(null, null);
                if (invoke == null) {
                    return Collections.emptySet();
                }
                Set<int[]> set = (Set) invoke;
                Iterator<int[]> it = set.iterator();
                while (it.hasNext()) {
                    if (!(it.next() instanceof int[])) {
                        return Collections.emptySet();
                    }
                }
                return set;
            } catch (Throwable unused) {
                return Collections.emptySet();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set<int[]> getEmojiExclusions() {
        return Build.VERSION.SDK_INT >= 34 ? EmojiExclusions_Api34.getExclusions() : EmojiExclusions_Reflections.getExclusions();
    }
}
