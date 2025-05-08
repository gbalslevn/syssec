package io.noties.markwon.html;

import java.io.IOException;

/* loaded from: classes2.dex */
abstract class AppendableUtils {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void appendQuietly(Appendable appendable, char c5) {
        try {
            appendable.append(c5);
        } catch (IOException e5) {
            throw new RuntimeException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void appendQuietly(Appendable appendable, CharSequence charSequence) {
        try {
            appendable.append(charSequence);
        } catch (IOException e5) {
            throw new RuntimeException(e5);
        }
    }
}
