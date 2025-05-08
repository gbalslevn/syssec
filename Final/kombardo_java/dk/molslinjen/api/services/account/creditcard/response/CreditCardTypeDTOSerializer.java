package dk.molslinjen.api.services.account.creditcard.response;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/api/services/account/creditcard/response/CreditCardTypeDTOSerializer;", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/account/creditcard/response/CreditCardTypeDTO;", "<init>", "()V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CreditCardTypeDTOSerializer implements KSerializer<CreditCardTypeDTO> {
    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        String simpleName = CreditCardTypeDTO.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        return SerialDescriptorsKt.PrimitiveSerialDescriptor(simpleName, PrimitiveKind.STRING.INSTANCE);
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CreditCardTypeDTO deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        try {
            return CreditCardTypeDTO.INSTANCE.serializer().deserialize(decoder);
        } catch (Exception unused) {
            return CreditCardTypeDTO.Other;
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CreditCardTypeDTO value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        CreditCardTypeDTO.INSTANCE.serializer().serialize(encoder, value);
    }
}
