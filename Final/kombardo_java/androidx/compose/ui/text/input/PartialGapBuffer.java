package androidx.compose.ui.text.input;

import com.sun.jna.Function;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011\"\u0004\b\u0014\u0010\u0005R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0011\u0010\u001d\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/text/input/PartialGapBuffer;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "text", "<init>", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "start", "end", BuildConfig.FLAVOR, "replace", "(IILjava/lang/String;)V", "index", BuildConfig.FLAVOR, "get", "(I)C", "toString", "()Ljava/lang/String;", "Ljava/lang/String;", "getText", "setText", "Landroidx/compose/ui/text/input/GapBuffer;", "buffer", "Landroidx/compose/ui/text/input/GapBuffer;", "bufStart", "I", "bufEnd", "getLength", "()I", "length", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PartialGapBuffer {
    private GapBuffer buffer;
    private String text;
    public static final int $stable = 8;
    private int bufStart = -1;
    private int bufEnd = -1;

    public PartialGapBuffer(String str) {
        this.text = str;
    }

    public final char get(int index) {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer != null && index >= this.bufStart) {
            int length = gapBuffer.length();
            int i5 = this.bufStart;
            return index < length + i5 ? gapBuffer.get(index - i5) : this.text.charAt(index - ((length - this.bufEnd) + i5));
        }
        return this.text.charAt(index);
    }

    public final int getLength() {
        GapBuffer gapBuffer = this.buffer;
        return gapBuffer == null ? this.text.length() : (this.text.length() - (this.bufEnd - this.bufStart)) + gapBuffer.length();
    }

    public final void replace(int start, int end, String text) {
        if (start > end) {
            throw new IllegalArgumentException(("start index must be less than or equal to end index: " + start + " > " + end).toString());
        }
        if (start < 0) {
            throw new IllegalArgumentException(("start must be non-negative, but was " + start).toString());
        }
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer != null) {
            int i5 = this.bufStart;
            int i6 = start - i5;
            int i7 = end - i5;
            if (i6 >= 0 && i7 <= gapBuffer.length()) {
                gapBuffer.replace(i6, i7, text);
                return;
            }
            this.text = toString();
            this.buffer = null;
            this.bufStart = -1;
            this.bufEnd = -1;
            replace(start, end, text);
            return;
        }
        int max = Math.max(Function.USE_VARARGS, text.length() + 128);
        char[] cArr = new char[max];
        int min = Math.min(start, 64);
        int min2 = Math.min(this.text.length() - end, 64);
        int i8 = start - min;
        GapBuffer_jvmKt.toCharArray(this.text, cArr, 0, i8, start);
        int i9 = max - min2;
        int i10 = min2 + end;
        GapBuffer_jvmKt.toCharArray(this.text, cArr, i9, end, i10);
        GapBufferKt.toCharArray(text, cArr, min);
        this.buffer = new GapBuffer(cArr, min + text.length(), i9);
        this.bufStart = i8;
        this.bufEnd = i10;
    }

    public String toString() {
        GapBuffer gapBuffer = this.buffer;
        if (gapBuffer == null) {
            return this.text;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) this.text, 0, this.bufStart);
        gapBuffer.append(sb);
        String str = this.text;
        sb.append((CharSequence) str, this.bufEnd, str.length());
        return sb.toString();
    }
}
