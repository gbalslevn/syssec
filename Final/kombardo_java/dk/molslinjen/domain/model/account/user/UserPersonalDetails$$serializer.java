package dk.molslinjen.domain.model.account.user;

import dk.molslinjen.api.helpers.serializers.LocalDateSerializer;
import dk.molslinjen.domain.model.account.Gender;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/domain/model/account/user/UserPersonalDetails.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/domain/model/account/user/UserPersonalDetails;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class UserPersonalDetails$$serializer implements GeneratedSerializer<UserPersonalDetails> {
    public static final UserPersonalDetails$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        UserPersonalDetails$$serializer userPersonalDetails$$serializer = new UserPersonalDetails$$serializer();
        INSTANCE = userPersonalDetails$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.domain.model.account.user.UserPersonalDetails", userPersonalDetails$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("gender", false);
        pluginGeneratedSerialDescriptor.addElement("firstName", false);
        pluginGeneratedSerialDescriptor.addElement("lastName", false);
        pluginGeneratedSerialDescriptor.addElement("birthDate", false);
        pluginGeneratedSerialDescriptor.addElement("nationality", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private UserPersonalDetails$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = UserPersonalDetails.$childSerializers;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(kSerializerArr[0]);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{nullable, stringSerializer, stringSerializer, BuiltinSerializersKt.getNullable(LocalDateSerializer.INSTANCE), BuiltinSerializersKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final UserPersonalDetails deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        Gender gender;
        String str;
        String str2;
        LocalDate localDate;
        String str3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = UserPersonalDetails.$childSerializers;
        Gender gender2 = null;
        if (beginStructure.decodeSequentially()) {
            Gender gender3 = (Gender) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, kSerializerArr[0], null);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 2);
            gender = gender3;
            str = decodeStringElement;
            localDate = (LocalDate) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, LocalDateSerializer.INSTANCE, null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, null);
            str2 = decodeStringElement2;
            i5 = 31;
        } else {
            boolean z5 = true;
            int i6 = 0;
            String str4 = null;
            String str5 = null;
            LocalDate localDate2 = null;
            String str6 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z5 = false;
                } else if (decodeElementIndex == 0) {
                    gender2 = (Gender) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, kSerializerArr[0], gender2);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    str4 = beginStructure.decodeStringElement(serialDescriptor, 1);
                    i6 |= 2;
                } else if (decodeElementIndex == 2) {
                    str5 = beginStructure.decodeStringElement(serialDescriptor, 2);
                    i6 |= 4;
                } else if (decodeElementIndex == 3) {
                    localDate2 = (LocalDate) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, LocalDateSerializer.INSTANCE, localDate2);
                    i6 |= 8;
                } else {
                    if (decodeElementIndex != 4) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str6);
                    i6 |= 16;
                }
            }
            i5 = i6;
            gender = gender2;
            str = str4;
            str2 = str5;
            localDate = localDate2;
            str3 = str6;
        }
        beginStructure.endStructure(serialDescriptor);
        return new UserPersonalDetails(i5, gender, str, str2, localDate, str3, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, UserPersonalDetails value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        UserPersonalDetails.write$Self$domain_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
