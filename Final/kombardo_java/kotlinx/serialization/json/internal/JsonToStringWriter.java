package kotlinx.serialization.json.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlinx/serialization/json/internal/JsonToStringWriter;", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "()V", "array", BuildConfig.FLAVOR, "size", BuildConfig.FLAVOR, "appendStringSlowPath", BuildConfig.FLAVOR, "firstEscapedChar", "currentSize", "string", BuildConfig.FLAVOR, "ensureAdditionalCapacity", "expected", "ensureTotalCapacity", "oldSize", "additional", "release", "toString", "write", "text", "writeChar", "char", BuildConfig.FLAVOR, "writeLong", "value", BuildConfig.FLAVOR, "writeQuoted", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class JsonToStringWriter implements InternalJsonWriter {
    private char[] array = CharArrayPool.INSTANCE.take();
    private int size;

    private final void appendStringSlowPath(int firstEscapedChar, int currentSize, String string) {
        int i5;
        int length = string.length();
        while (firstEscapedChar < length) {
            int ensureTotalCapacity = ensureTotalCapacity(currentSize, 2);
            char charAt = string.charAt(firstEscapedChar);
            if (charAt < StringOpsKt.getESCAPE_MARKERS().length) {
                byte b5 = StringOpsKt.getESCAPE_MARKERS()[charAt];
                if (b5 == 0) {
                    i5 = ensureTotalCapacity + 1;
                    this.array[ensureTotalCapacity] = charAt;
                } else {
                    if (b5 == 1) {
                        String str = StringOpsKt.getESCAPE_STRINGS()[charAt];
                        Intrinsics.checkNotNull(str);
                        int ensureTotalCapacity2 = ensureTotalCapacity(ensureTotalCapacity, str.length());
                        str.getChars(0, str.length(), this.array, ensureTotalCapacity2);
                        currentSize = ensureTotalCapacity2 + str.length();
                        this.size = currentSize;
                    } else {
                        char[] cArr = this.array;
                        cArr[ensureTotalCapacity] = '\\';
                        cArr[ensureTotalCapacity + 1] = (char) b5;
                        currentSize = ensureTotalCapacity + 2;
                        this.size = currentSize;
                    }
                    firstEscapedChar++;
                }
            } else {
                i5 = ensureTotalCapacity + 1;
                this.array[ensureTotalCapacity] = charAt;
            }
            currentSize = i5;
            firstEscapedChar++;
        }
        int ensureTotalCapacity3 = ensureTotalCapacity(currentSize, 1);
        this.array[ensureTotalCapacity3] = '\"';
        this.size = ensureTotalCapacity3 + 1;
    }

    private final void ensureAdditionalCapacity(int expected) {
        ensureTotalCapacity(this.size, expected);
    }

    private final int ensureTotalCapacity(int oldSize, int additional) {
        int i5 = additional + oldSize;
        char[] cArr = this.array;
        if (cArr.length <= i5) {
            char[] copyOf = Arrays.copyOf(cArr, RangesKt.coerceAtLeast(i5, oldSize * 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            this.array = copyOf;
        }
        return oldSize;
    }

    public void release() {
        CharArrayPool.INSTANCE.release(this.array);
    }

    public String toString() {
        return new String(this.array, 0, this.size);
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void write(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        int length = text.length();
        if (length == 0) {
            return;
        }
        ensureAdditionalCapacity(length);
        text.getChars(0, text.length(), this.array, this.size);
        this.size += length;
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeChar(char r42) {
        ensureAdditionalCapacity(1);
        char[] cArr = this.array;
        int i5 = this.size;
        this.size = i5 + 1;
        cArr[i5] = r42;
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeLong(long value) {
        write(String.valueOf(value));
    }

    @Override // kotlinx.serialization.json.internal.InternalJsonWriter
    public void writeQuoted(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        ensureAdditionalCapacity(text.length() + 2);
        char[] cArr = this.array;
        int i5 = this.size;
        int i6 = i5 + 1;
        cArr[i5] = '\"';
        int length = text.length();
        text.getChars(0, length, cArr, i6);
        int i7 = length + i6;
        for (int i8 = i6; i8 < i7; i8++) {
            char c5 = cArr[i8];
            if (c5 < StringOpsKt.getESCAPE_MARKERS().length && StringOpsKt.getESCAPE_MARKERS()[c5] != 0) {
                appendStringSlowPath(i8 - i6, i8, text);
                return;
            }
        }
        cArr[i7] = '\"';
        this.size = i7 + 1;
    }
}
