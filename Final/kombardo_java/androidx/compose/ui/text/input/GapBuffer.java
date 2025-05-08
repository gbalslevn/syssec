package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0011\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0086\u0002J\u0006\u0010\u0018\u001a\u00020\u0005J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u001e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001dH\u0016R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/text/input/GapBuffer;", BuildConfig.FLAVOR, "initBuffer", BuildConfig.FLAVOR, "initGapStart", BuildConfig.FLAVOR, "initGapEnd", "([CII)V", "buffer", "capacity", "gapEnd", "gapStart", "append", BuildConfig.FLAVOR, "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "delete", "start", "end", "gapLength", "get", BuildConfig.FLAVOR, "index", "length", "makeSureAvailableSpace", "requestSize", "replace", "text", BuildConfig.FLAVOR, "toString", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GapBuffer {
    private char[] buffer;
    private int capacity;
    private int gapEnd;
    private int gapStart;

    public GapBuffer(char[] cArr, int i5, int i6) {
        this.capacity = cArr.length;
        this.buffer = cArr;
        this.gapStart = i5;
        this.gapEnd = i6;
    }

    private final void delete(int start, int end) {
        int i5 = this.gapStart;
        if (start < i5 && end <= i5) {
            int i6 = i5 - end;
            char[] cArr = this.buffer;
            ArraysKt.copyInto(cArr, cArr, this.gapEnd - i6, end, i5);
            this.gapStart = start;
            this.gapEnd -= i6;
            return;
        }
        if (start < i5 && end >= i5) {
            this.gapEnd = end + gapLength();
            this.gapStart = start;
            return;
        }
        int gapLength = start + gapLength();
        int gapLength2 = end + gapLength();
        int i7 = this.gapEnd;
        char[] cArr2 = this.buffer;
        ArraysKt.copyInto(cArr2, cArr2, this.gapStart, i7, gapLength);
        this.gapStart += gapLength - i7;
        this.gapEnd = gapLength2;
    }

    private final int gapLength() {
        return this.gapEnd - this.gapStart;
    }

    private final void makeSureAvailableSpace(int requestSize) {
        if (requestSize <= gapLength()) {
            return;
        }
        int gapLength = requestSize - gapLength();
        int i5 = this.capacity;
        do {
            i5 *= 2;
        } while (i5 - this.capacity < gapLength);
        char[] cArr = new char[i5];
        ArraysKt.copyInto(this.buffer, cArr, 0, 0, this.gapStart);
        int i6 = this.capacity;
        int i7 = this.gapEnd;
        int i8 = i6 - i7;
        int i9 = i5 - i8;
        ArraysKt.copyInto(this.buffer, cArr, i9, i7, i8 + i7);
        this.buffer = cArr;
        this.capacity = i5;
        this.gapEnd = i9;
    }

    public final void append(StringBuilder builder) {
        builder.append(this.buffer, 0, this.gapStart);
        Intrinsics.checkNotNullExpressionValue(builder, "this.append(value, start…x, endIndex - startIndex)");
        char[] cArr = this.buffer;
        int i5 = this.gapEnd;
        builder.append(cArr, i5, this.capacity - i5);
        Intrinsics.checkNotNullExpressionValue(builder, "this.append(value, start…x, endIndex - startIndex)");
    }

    public final char get(int index) {
        int i5 = this.gapStart;
        return index < i5 ? this.buffer[index] : this.buffer[(index - i5) + this.gapEnd];
    }

    public final int length() {
        return this.capacity - gapLength();
    }

    public final void replace(int start, int end, String text) {
        makeSureAvailableSpace(text.length() - (end - start));
        delete(start, end);
        GapBufferKt.toCharArray(text, this.buffer, this.gapStart);
        this.gapStart += text.length();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) sb);
        return sb.toString();
    }
}
