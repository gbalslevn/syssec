package uniffi.molslinjen_shared;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FfiConverter;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Luniffi/molslinjen_shared/FfiConverterString;", "Luniffi/molslinjen_shared/FfiConverter;", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/RustBuffer$ByValue;", "()V", "allocationSize", "Lkotlin/ULong;", "value", "allocationSize-I7RO_PI", "(Ljava/lang/String;)J", "lift", "lower", "read", "buf", "Ljava/nio/ByteBuffer;", "toUtf8", "write", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FfiConverterString implements FfiConverter<String, RustBuffer.ByValue> {
    public static final FfiConverterString INSTANCE = new FfiConverterString();

    private FfiConverterString() {
    }

    public final ByteBuffer toUtf8(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        CharsetEncoder newEncoder = Charsets.UTF_8.newEncoder();
        newEncoder.onMalformedInput(CodingErrorAction.REPORT);
        ByteBuffer encode = newEncoder.encode(CharBuffer.wrap(value));
        Intrinsics.checkNotNullExpressionValue(encode, "run(...)");
        return encode;
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: allocationSize-I7RO_PI, reason: avoid collision after fix types in other method and not valid java name and merged with bridge method [inline-methods] */
    public long mo3834allocationSizeI7RO_PI(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return ULong.m3622constructorimpl(ULong.m3622constructorimpl(ULong.m3622constructorimpl(value.length()) * 3) + 4);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: lift, reason: avoid collision after fix types in other method */
    public String lift2(RustBuffer.ByValue value) {
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            byte[] bArr = new byte[(int) value.len];
            ByteBuffer asByteBuffer = value.asByteBuffer();
            Intrinsics.checkNotNull(asByteBuffer);
            asByteBuffer.get(bArr);
            return new String(bArr, Charsets.UTF_8);
        } finally {
            RustBuffer.INSTANCE.free$shared_release(value);
        }
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public String liftFromRustBuffer(RustBuffer.ByValue byValue) {
        return (String) FfiConverter.DefaultImpls.liftFromRustBuffer(this, byValue);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: lower, reason: avoid collision after fix types in other method */
    public RustBuffer.ByValue lower2(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ByteBuffer utf8 = toUtf8(value);
        RustBuffer.ByValue m3921allocVKZWuLQ$shared_release = RustBuffer.INSTANCE.m3921allocVKZWuLQ$shared_release(ULong.m3622constructorimpl(utf8.limit()));
        ByteBuffer asByteBuffer = m3921allocVKZWuLQ$shared_release.asByteBuffer();
        Intrinsics.checkNotNull(asByteBuffer);
        asByteBuffer.put(utf8);
        return m3921allocVKZWuLQ$shared_release;
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public RustBuffer.ByValue lowerIntoRustBuffer(String str) {
        return FfiConverter.DefaultImpls.lowerIntoRustBuffer(this, str);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public String read(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        byte[] bArr = new byte[buf.getInt()];
        buf.get(bArr);
        return new String(bArr, Charsets.UTF_8);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public void write(String value, ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(buf, "buf");
        ByteBuffer utf8 = toUtf8(value);
        buf.putInt(utf8.limit());
        buf.put(utf8);
    }
}
