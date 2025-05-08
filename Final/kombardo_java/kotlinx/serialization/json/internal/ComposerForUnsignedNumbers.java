package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000bH\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\fH\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/serialization/json/internal/ComposerForUnsignedNumbers;", "Lkotlinx/serialization/json/internal/Composer;", "writer", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "forceQuoting", BuildConfig.FLAVOR, "(Lkotlinx/serialization/json/internal/InternalJsonWriter;Z)V", "print", BuildConfig.FLAVOR, "v", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "kotlinx-serialization-json"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ComposerForUnsignedNumbers extends Composer {
    private final boolean forceQuoting;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerForUnsignedNumbers(InternalJsonWriter writer, boolean z5) {
        super(writer);
        Intrinsics.checkNotNullParameter(writer, "writer");
        this.forceQuoting = z5;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(int v5) {
        boolean z5 = this.forceQuoting;
        String unsignedString = Integer.toUnsignedString(UInt.m3599constructorimpl(v5));
        if (z5) {
            printQuoted(unsignedString);
        } else {
            print(unsignedString);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(long v5) {
        boolean z5 = this.forceQuoting;
        String unsignedString = Long.toUnsignedString(ULong.m3622constructorimpl(v5));
        if (z5) {
            printQuoted(unsignedString);
        } else {
            print(unsignedString);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(byte v5) {
        boolean z5 = this.forceQuoting;
        String m3580toStringimpl = UByte.m3580toStringimpl(UByte.m3577constructorimpl(v5));
        if (z5) {
            printQuoted(m3580toStringimpl);
        } else {
            print(m3580toStringimpl);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(short v5) {
        boolean z5 = this.forceQuoting;
        String m3649toStringimpl = UShort.m3649toStringimpl(UShort.m3646constructorimpl(v5));
        if (z5) {
            printQuoted(m3649toStringimpl);
        } else {
            print(m3649toStringimpl);
        }
    }
}
