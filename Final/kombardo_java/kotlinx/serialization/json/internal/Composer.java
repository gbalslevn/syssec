package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0013J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0014H\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0015H\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0016H\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0017H\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0018H\u0016J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001e"}, d2 = {"Lkotlinx/serialization/json/internal/Composer;", BuildConfig.FLAVOR, "writer", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "(Lkotlinx/serialization/json/internal/InternalJsonWriter;)V", "<set-?>", BuildConfig.FLAVOR, "writingFirst", "getWritingFirst", "()Z", "setWritingFirst", "(Z)V", "indent", BuildConfig.FLAVOR, "nextItem", "nextItemIfNotFirst", "print", "v", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "printQuoted", "value", "space", "unIndent", "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public class Composer {
    public final InternalJsonWriter writer;
    private boolean writingFirst;

    public Composer(InternalJsonWriter writer) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        this.writer = writer;
        this.writingFirst = true;
    }

    public final boolean getWritingFirst() {
        return this.writingFirst;
    }

    public void indent() {
        this.writingFirst = true;
    }

    public void nextItem() {
        this.writingFirst = false;
    }

    public void nextItemIfNotFirst() {
        this.writingFirst = false;
    }

    public final void print(char v5) {
        this.writer.writeChar(v5);
    }

    public void printQuoted(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.writer.writeQuoted(value);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setWritingFirst(boolean z5) {
        this.writingFirst = z5;
    }

    public void space() {
    }

    public void unIndent() {
    }

    public final void print(String v5) {
        Intrinsics.checkNotNullParameter(v5, "v");
        this.writer.write(v5);
    }

    public void print(float v5) {
        this.writer.write(String.valueOf(v5));
    }

    public void print(double v5) {
        this.writer.write(String.valueOf(v5));
    }

    public void print(byte v5) {
        this.writer.writeLong(v5);
    }

    public void print(short v5) {
        this.writer.writeLong(v5);
    }

    public void print(int v5) {
        this.writer.writeLong(v5);
    }

    public void print(long v5) {
        this.writer.writeLong(v5);
    }

    public void print(boolean v5) {
        this.writer.write(String.valueOf(v5));
    }
}
