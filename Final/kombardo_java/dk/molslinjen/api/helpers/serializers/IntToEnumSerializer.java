package dk.molslinjen.api.helpers.serializers;

import android.graphics.ColorSpace;
import dk.molslinjen.api.helpers.serializers.SerializableEnum;
import java.lang.Enum;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\u0012\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/api/helpers/serializers/IntToEnumSerializer;", "E", BuildConfig.FLAVOR, "Ldk/molslinjen/api/helpers/serializers/SerializableEnum;", "Lkotlinx/serialization/KSerializer;", "enumType", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Enum;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Enum;)V", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class IntToEnumSerializer<E extends Enum<E> & SerializableEnum> implements KSerializer<E> {
    private final Class<E> enumType;

    public IntToEnumSerializer(Class<E> enumType) {
        Intrinsics.checkNotNullParameter(enumType, "enumType");
        this.enumType = enumType;
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return SerialDescriptorsKt.PrimitiveSerialDescriptor("IntToEnumSerializer", PrimitiveKind.INT.INSTANCE);
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlinx/serialization/encoding/Decoder;)TE; */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.DeserializationStrategy
    public Enum deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        int decodeInt = decoder.decodeInt();
        Enum[] enumArr = (Enum[]) this.enumType.getEnumConstants();
        if (enumArr != 0) {
            for (ColorSpace.Named named : enumArr) {
                if (((SerializableEnum) named).getRawValue() == decodeInt) {
                    Intrinsics.checkNotNullExpressionValue(named, "first(...)");
                    return named;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        throw new NullPointerException("Could not find enumConstants for " + this.enumType.getSimpleName());
    }

    /* JADX WARN: Incorrect types in method signature: (Lkotlinx/serialization/encoding/Encoder;TE;)V */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Enum value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.encodeInt(((SerializableEnum) value).getRawValue());
    }
}
