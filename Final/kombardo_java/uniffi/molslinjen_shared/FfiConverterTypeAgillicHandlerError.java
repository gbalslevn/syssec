package uniffi.molslinjen_shared;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.AgillicHandlerException;
import uniffi.molslinjen_shared.FfiConverterRustBuffer;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Luniffi/molslinjen_shared/FfiConverterTypeAgillicHandlerError;", "Luniffi/molslinjen_shared/FfiConverterRustBuffer;", "Luniffi/molslinjen_shared/AgillicHandlerException;", "()V", "allocationSize", "Lkotlin/ULong;", "value", "allocationSize-I7RO_PI", "(Luniffi/molslinjen_shared/AgillicHandlerException;)J", "read", "buf", "Ljava/nio/ByteBuffer;", "write", BuildConfig.FLAVOR, "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FfiConverterTypeAgillicHandlerError implements FfiConverterRustBuffer<AgillicHandlerException> {
    public static final FfiConverterTypeAgillicHandlerError INSTANCE = new FfiConverterTypeAgillicHandlerError();

    private FfiConverterTypeAgillicHandlerError() {
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    /* renamed from: allocationSize-I7RO_PI, reason: not valid java name and merged with bridge method [inline-methods] */
    public long mo3834allocationSizeI7RO_PI(AgillicHandlerException value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value instanceof AgillicHandlerException.ServiceException) {
            return ULong.m3622constructorimpl(FfiConverterString.INSTANCE.mo3834allocationSizeI7RO_PI(((AgillicHandlerException.ServiceException) value).getErrorMessage()) + 4);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public AgillicHandlerException liftFromRustBuffer(RustBuffer.ByValue byValue) {
        return (AgillicHandlerException) FfiConverterRustBuffer.DefaultImpls.liftFromRustBuffer(this, byValue);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public RustBuffer.ByValue lowerIntoRustBuffer(AgillicHandlerException agillicHandlerException) {
        return FfiConverterRustBuffer.DefaultImpls.lowerIntoRustBuffer(this, agillicHandlerException);
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public AgillicHandlerException read(ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (buf.getInt() == 1) {
            return new AgillicHandlerException.ServiceException(FfiConverterString.INSTANCE.read(buf));
        }
        throw new RuntimeException("invalid error enum value, something is very wrong!!");
    }

    @Override // uniffi.molslinjen_shared.FfiConverter
    public void write(AgillicHandlerException value, ByteBuffer buf) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(buf, "buf");
        if (!(value instanceof AgillicHandlerException.ServiceException)) {
            throw new NoWhenBranchMatchedException();
        }
        buf.putInt(1);
        FfiConverterString.INSTANCE.write(((AgillicHandlerException.ServiceException) value).getErrorMessage(), buf);
        Unit unit = Unit.INSTANCE;
    }

    @Override // uniffi.molslinjen_shared.FfiConverterRustBuffer
    /* renamed from: lift */
    public AgillicHandlerException lift2(RustBuffer.ByValue byValue) {
        return (AgillicHandlerException) FfiConverterRustBuffer.DefaultImpls.lift(this, byValue);
    }

    @Override // uniffi.molslinjen_shared.FfiConverterRustBuffer, uniffi.molslinjen_shared.FfiConverter
    /* renamed from: lower, reason: merged with bridge method [inline-methods] */
    public RustBuffer.ByValue lower2(AgillicHandlerException agillicHandlerException) {
        return FfiConverterRustBuffer.DefaultImpls.lower(this, agillicHandlerException);
    }
}
