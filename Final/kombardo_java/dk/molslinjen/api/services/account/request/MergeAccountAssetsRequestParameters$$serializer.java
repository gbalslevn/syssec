package dk.molslinjen.api.services.account.request;

import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/api/services/account/request/MergeAccountAssetsRequestParameters.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/api/services/account/request/MergeAccountAssetsRequestParameters;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class MergeAccountAssetsRequestParameters$$serializer implements GeneratedSerializer<MergeAccountAssetsRequestParameters> {
    public static final MergeAccountAssetsRequestParameters$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        MergeAccountAssetsRequestParameters$$serializer mergeAccountAssetsRequestParameters$$serializer = new MergeAccountAssetsRequestParameters$$serializer();
        INSTANCE = mergeAccountAssetsRequestParameters$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.api.services.account.request.MergeAccountAssetsRequestParameters", mergeAccountAssetsRequestParameters$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("multiRides", false);
        pluginGeneratedSerialDescriptor.addElement("vehicles", false);
        pluginGeneratedSerialDescriptor.addElement("companion", false);
        pluginGeneratedSerialDescriptor.addElement("creditCards", false);
        pluginGeneratedSerialDescriptor.addElement("reservations", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private MergeAccountAssetsRequestParameters$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = MergeAccountAssetsRequestParameters.$childSerializers;
        return new KSerializer[]{kSerializerArr[0], kSerializerArr[1], kSerializerArr[2], kSerializerArr[3], kSerializerArr[4]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final MergeAccountAssetsRequestParameters deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        List list;
        List list2;
        List list3;
        List list4;
        List list5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = MergeAccountAssetsRequestParameters.$childSerializers;
        List list6 = null;
        if (beginStructure.decodeSequentially()) {
            List list7 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], null);
            List list8 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], null);
            List list9 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], null);
            List list10 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 3, kSerializerArr[3], null);
            list5 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            list = list7;
            list4 = list10;
            i5 = 31;
            list3 = list9;
            list2 = list8;
        } else {
            boolean z5 = true;
            int i6 = 0;
            List list11 = null;
            List list12 = null;
            List list13 = null;
            List list14 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                if (decodeElementIndex == -1) {
                    z5 = false;
                } else if (decodeElementIndex == 0) {
                    list6 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], list6);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    list11 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 1, kSerializerArr[1], list11);
                    i6 |= 2;
                } else if (decodeElementIndex == 2) {
                    list12 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], list12);
                    i6 |= 4;
                } else if (decodeElementIndex == 3) {
                    list13 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 3, kSerializerArr[3], list13);
                    i6 |= 8;
                } else {
                    if (decodeElementIndex != 4) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    list14 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 4, kSerializerArr[4], list14);
                    i6 |= 16;
                }
            }
            i5 = i6;
            list = list6;
            list2 = list11;
            list3 = list12;
            list4 = list13;
            list5 = list14;
        }
        beginStructure.endStructure(serialDescriptor);
        return new MergeAccountAssetsRequestParameters(i5, list, list2, list3, list4, list5, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, MergeAccountAssetsRequestParameters value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        MergeAccountAssetsRequestParameters.write$Self$api_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
