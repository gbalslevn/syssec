package io.noties.markwon.html;

/* loaded from: classes2.dex */
abstract class TrimmingAppender {

    /* loaded from: classes2.dex */
    static class Impl extends TrimmingAppender {
        Impl() {
        }

        @Override // io.noties.markwon.html.TrimmingAppender
        <T extends Appendable & CharSequence> void append(T t5, String str) {
            int length;
            T t6 = t5;
            int length2 = t6.length();
            int length3 = str.length();
            boolean z5 = false;
            for (int i5 = 0; i5 < length3; i5++) {
                char charAt = str.charAt(i5);
                if (Character.isWhitespace(charAt)) {
                    z5 = true;
                } else {
                    if (z5 && (length = t6.length()) > 0 && !Character.isWhitespace(t6.charAt(length - 1))) {
                        AppendableUtils.appendQuietly((Appendable) t5, ' ');
                    }
                    AppendableUtils.appendQuietly(t5, charAt);
                    z5 = false;
                }
            }
            if (!z5 || length2 >= t6.length()) {
                return;
            }
            AppendableUtils.appendQuietly((Appendable) t5, ' ');
        }
    }

    TrimmingAppender() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TrimmingAppender create() {
        return new Impl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <T extends Appendable & CharSequence> void append(T t5, String str);
}
