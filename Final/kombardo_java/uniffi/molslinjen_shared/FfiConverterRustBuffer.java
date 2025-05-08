package uniffi.molslinjen_shared;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uniffi.molslinjen_shared.FfiConverter;
import uniffi.molslinjen_shared.RustBuffer;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002J\u0015\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Luniffi/molslinjen_shared/FfiConverterRustBuffer;", "KotlinType", "Luniffi/molslinjen_shared/FfiConverter;", "Luniffi/molslinjen_shared/RustBuffer$ByValue;", "lift", "value", "(Luniffi/molslinjen_shared/RustBuffer$ByValue;)Ljava/lang/Object;", "lower", "(Ljava/lang/Object;)Luniffi/molslinjen_shared/RustBuffer$ByValue;", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface FfiConverterRustBuffer<KotlinType> extends FfiConverter<KotlinType, RustBuffer.ByValue> {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static <KotlinType> KotlinType lift(FfiConverterRustBuffer<KotlinType> ffiConverterRustBuffer, RustBuffer.ByValue value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return ffiConverterRustBuffer.liftFromRustBuffer(value);
        }

        public static <KotlinType> KotlinType liftFromRustBuffer(FfiConverterRustBuffer<KotlinType> ffiConverterRustBuffer, RustBuffer.ByValue rbuf) {
            Intrinsics.checkNotNullParameter(rbuf, "rbuf");
            return (KotlinType) FfiConverter.DefaultImpls.liftFromRustBuffer(ffiConverterRustBuffer, rbuf);
        }

        public static <KotlinType> RustBuffer.ByValue lower(FfiConverterRustBuffer<KotlinType> ffiConverterRustBuffer, KotlinType kotlintype) {
            return ffiConverterRustBuffer.lowerIntoRustBuffer(kotlintype);
        }

        public static <KotlinType> RustBuffer.ByValue lowerIntoRustBuffer(FfiConverterRustBuffer<KotlinType> ffiConverterRustBuffer, KotlinType kotlintype) {
            return FfiConverter.DefaultImpls.lowerIntoRustBuffer(ffiConverterRustBuffer, kotlintype);
        }
    }

    KotlinType lift(RustBuffer.ByValue value);

    @Override // uniffi.molslinjen_shared.FfiConverter
    RustBuffer.ByValue lower(KotlinType value);
}
