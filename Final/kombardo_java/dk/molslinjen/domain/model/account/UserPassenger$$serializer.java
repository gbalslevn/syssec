package dk.molslinjen.domain.model.account;

import dk.molslinjen.api.helpers.serializers.LocalDateSerializer;
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
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/domain/model/account/UserPassenger.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/domain/model/account/UserPassenger;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class UserPassenger$$serializer implements GeneratedSerializer<UserPassenger> {
    public static final UserPassenger$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        UserPassenger$$serializer userPassenger$$serializer = new UserPassenger$$serializer();
        INSTANCE = userPassenger$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.domain.model.account.UserPassenger", userPassenger$$serializer, 11);
        pluginGeneratedSerialDescriptor.addElement("localId", false);
        pluginGeneratedSerialDescriptor.addElement("remoteId", false);
        pluginGeneratedSerialDescriptor.addElement("firstName", false);
        pluginGeneratedSerialDescriptor.addElement("lastName", false);
        pluginGeneratedSerialDescriptor.addElement("gender", false);
        pluginGeneratedSerialDescriptor.addElement("birthdate", false);
        pluginGeneratedSerialDescriptor.addElement("nationality", false);
        pluginGeneratedSerialDescriptor.addElement("isCurrentUser", false);
        pluginGeneratedSerialDescriptor.addElement("formattedBirthdate", true);
        pluginGeneratedSerialDescriptor.addElement("fullName", true);
        pluginGeneratedSerialDescriptor.addElement("initials", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private UserPassenger$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = UserPassenger.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, BuiltinSerializersKt.getNullable(stringSerializer), stringSerializer, stringSerializer, kSerializerArr[4], LocalDateSerializer.INSTANCE, stringSerializer, BooleanSerializer.INSTANCE, stringSerializer, stringSerializer, stringSerializer};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0096. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final UserPassenger deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        boolean z5;
        LocalDate localDate;
        Gender gender;
        String str;
        int i5;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = UserPassenger.$childSerializers;
        int i6 = 10;
        int i7 = 9;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 2);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 3);
            Gender gender2 = (Gender) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            LocalDate localDate2 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 5, LocalDateSerializer.INSTANCE, null);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 6);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 7);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 8);
            String decodeStringElement6 = beginStructure.decodeStringElement(serialDescriptor, 9);
            gender = gender2;
            str2 = decodeStringElement;
            str8 = beginStructure.decodeStringElement(serialDescriptor, 10);
            str7 = decodeStringElement6;
            z5 = decodeBooleanElement;
            str5 = decodeStringElement4;
            localDate = localDate2;
            str4 = decodeStringElement3;
            str6 = decodeStringElement5;
            str3 = decodeStringElement2;
            i5 = 2047;
            str = str9;
        } else {
            boolean z6 = true;
            boolean z7 = false;
            LocalDate localDate3 = null;
            Gender gender3 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            String str15 = null;
            String str16 = null;
            String str17 = null;
            int i8 = 0;
            while (z6) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z6 = false;
                        i6 = 10;
                    case 0:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i8 |= 1;
                        i6 = 10;
                        i7 = 9;
                    case 1:
                        str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str17);
                        i8 |= 2;
                        i6 = 10;
                        i7 = 9;
                    case 2:
                        str11 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i8 |= 4;
                        i6 = 10;
                    case 3:
                        str12 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i8 |= 8;
                    case 4:
                        gender3 = (Gender) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], gender3);
                        i8 |= 16;
                    case 5:
                        localDate3 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 5, LocalDateSerializer.INSTANCE, localDate3);
                        i8 |= 32;
                    case 6:
                        str13 = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i8 |= 64;
                    case 7:
                        z7 = beginStructure.decodeBooleanElement(serialDescriptor, 7);
                        i8 |= 128;
                    case 8:
                        str14 = beginStructure.decodeStringElement(serialDescriptor, 8);
                        i8 |= 256;
                    case 9:
                        str15 = beginStructure.decodeStringElement(serialDescriptor, i7);
                        i8 |= 512;
                    case 10:
                        str16 = beginStructure.decodeStringElement(serialDescriptor, i6);
                        i8 |= 1024;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            z5 = z7;
            localDate = localDate3;
            gender = gender3;
            str = str17;
            i5 = i8;
            str2 = str10;
            str3 = str11;
            str4 = str12;
            str5 = str13;
            str6 = str14;
            str7 = str15;
            str8 = str16;
        }
        beginStructure.endStructure(serialDescriptor);
        return new UserPassenger(i5, str2, str, str3, str4, gender, localDate, str5, z5, str6, str7, str8, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, UserPassenger value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        UserPassenger.write$Self$domain_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
