package dk.molslinjen.domain.model.account.user;

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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/domain/model/account/user/UserInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/domain/model/account/user/UserInfo;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class UserInfo$$serializer implements GeneratedSerializer<UserInfo> {
    public static final UserInfo$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        UserInfo$$serializer userInfo$$serializer = new UserInfo$$serializer();
        INSTANCE = userInfo$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.domain.model.account.user.UserInfo", userInfo$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("personalDetails", false);
        pluginGeneratedSerialDescriptor.addElement("contactDetails", false);
        pluginGeneratedSerialDescriptor.addElement("isEmpty", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private UserInfo$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(UserPersonalDetails$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(UserContactDetails$$serializer.INSTANCE), BooleanSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final UserInfo deserialize(Decoder decoder) {
        boolean z5;
        int i5;
        UserPersonalDetails userPersonalDetails;
        UserContactDetails userContactDetails;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            UserPersonalDetails userPersonalDetails2 = (UserPersonalDetails) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, UserPersonalDetails$$serializer.INSTANCE, null);
            UserContactDetails userContactDetails2 = (UserContactDetails) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, UserContactDetails$$serializer.INSTANCE, null);
            userPersonalDetails = userPersonalDetails2;
            z5 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
            userContactDetails = userContactDetails2;
            i5 = 7;
        } else {
            boolean z6 = true;
            boolean z7 = false;
            UserPersonalDetails userPersonalDetails3 = null;
            UserContactDetails userContactDetails3 = null;
            int i6 = 0;
            while (z6) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z6 = false;
                } else if (decodeElementIndex == 0) {
                    userPersonalDetails3 = (UserPersonalDetails) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, UserPersonalDetails$$serializer.INSTANCE, userPersonalDetails3);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    userContactDetails3 = (UserContactDetails) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, UserContactDetails$$serializer.INSTANCE, userContactDetails3);
                    i6 |= 2;
                } else {
                    if (decodeElementIndex != 2) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    z7 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                    i6 |= 4;
                }
            }
            z5 = z7;
            i5 = i6;
            userPersonalDetails = userPersonalDetails3;
            userContactDetails = userContactDetails3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new UserInfo(i5, userPersonalDetails, userContactDetails, z5, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, UserInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        UserInfo.write$Self$domain_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
