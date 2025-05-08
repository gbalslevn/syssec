package dk.molslinjen.domain.model.saleOnBoard;

import dk.molslinjen.api.helpers.serializers.DurationSerializer;
import dk.molslinjen.api.helpers.serializers.LocalDateSerializer;
import dk.molslinjen.api.helpers.serializers.LocalTimeSerializer;
import dk.molslinjen.domain.model.booking.Ferry;
import dk.molslinjen.domain.model.booking.Ferry$$serializer;
import dk.molslinjen.domain.model.booking.RouteType;
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
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"dk/molslinjen/domain/model/saleOnBoard/SaleOnBoardDeparture.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardDeparture;", "<init>", "()V", "childSerializers", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Deprecated
/* loaded from: classes2.dex */
public /* synthetic */ class SaleOnBoardDeparture$$serializer implements GeneratedSerializer<SaleOnBoardDeparture> {
    public static final SaleOnBoardDeparture$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        SaleOnBoardDeparture$$serializer saleOnBoardDeparture$$serializer = new SaleOnBoardDeparture$$serializer();
        INSTANCE = saleOnBoardDeparture$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardDeparture", saleOnBoardDeparture$$serializer, 11);
        pluginGeneratedSerialDescriptor.addElement("arrivalTime", false);
        pluginGeneratedSerialDescriptor.addElement("date", false);
        pluginGeneratedSerialDescriptor.addElement("departureTime", false);
        pluginGeneratedSerialDescriptor.addElement("routeId", false);
        pluginGeneratedSerialDescriptor.addElement("routeType", false);
        pluginGeneratedSerialDescriptor.addElement("timeTableId", false);
        pluginGeneratedSerialDescriptor.addElement("ferry", false);
        pluginGeneratedSerialDescriptor.addElement("travelTime", false);
        pluginGeneratedSerialDescriptor.addElement("transportSwitchDescription", false);
        pluginGeneratedSerialDescriptor.addElement("arrivalHarborName", false);
        pluginGeneratedSerialDescriptor.addElement("departureHarborName", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SaleOnBoardDeparture$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = SaleOnBoardDeparture.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        KSerializer<?> nullable = BuiltinSerializersKt.getNullable(kSerializerArr[4]);
        KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(Ferry$$serializer.INSTANCE);
        KSerializer<?> nullable3 = BuiltinSerializersKt.getNullable(stringSerializer);
        LocalTimeSerializer localTimeSerializer = LocalTimeSerializer.INSTANCE;
        return new KSerializer[]{localTimeSerializer, LocalDateSerializer.INSTANCE, localTimeSerializer, stringSerializer, nullable, stringSerializer, nullable2, DurationSerializer.INSTANCE, nullable3, stringSerializer, stringSerializer};
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x00a1. Please report as an issue. */
    @Override // kotlinx.serialization.DeserializationStrategy
    public final SaleOnBoardDeparture deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i5;
        String str;
        Ferry ferry;
        RouteType routeType;
        Duration duration;
        LocalTime localTime;
        LocalDate localDate;
        LocalTime localTime2;
        String str2;
        String str3;
        String str4;
        String str5;
        char c5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = SaleOnBoardDeparture.$childSerializers;
        int i6 = 9;
        LocalTime localTime3 = null;
        if (beginStructure.decodeSequentially()) {
            LocalTimeSerializer localTimeSerializer = LocalTimeSerializer.INSTANCE;
            LocalTime localTime4 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 0, localTimeSerializer, null);
            LocalDate localDate2 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 1, LocalDateSerializer.INSTANCE, null);
            LocalTime localTime5 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 2, localTimeSerializer, null);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 3);
            RouteType routeType2 = (RouteType) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, kSerializerArr[4], null);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 5);
            Ferry ferry2 = (Ferry) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, Ferry$$serializer.INSTANCE, null);
            Duration duration2 = (Duration) beginStructure.decodeSerializableElement(serialDescriptor, 7, DurationSerializer.INSTANCE, null);
            String str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, null);
            routeType = routeType2;
            localTime = localTime5;
            localDate = localDate2;
            str4 = beginStructure.decodeStringElement(serialDescriptor, 9);
            duration = duration2;
            ferry = ferry2;
            str3 = decodeStringElement2;
            str2 = decodeStringElement;
            str = str6;
            str5 = beginStructure.decodeStringElement(serialDescriptor, 10);
            i5 = 2047;
            localTime2 = localTime4;
        } else {
            int i7 = 10;
            boolean z5 = true;
            int i8 = 0;
            String str7 = null;
            Ferry ferry3 = null;
            RouteType routeType3 = null;
            Duration duration3 = null;
            LocalTime localTime6 = null;
            LocalDate localDate3 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            while (z5) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z5 = false;
                        i6 = 9;
                    case 0:
                        localTime3 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 0, LocalTimeSerializer.INSTANCE, localTime3);
                        i8 |= 1;
                        i7 = 10;
                        i6 = 9;
                    case 1:
                        localDate3 = (LocalDate) beginStructure.decodeSerializableElement(serialDescriptor, 1, LocalDateSerializer.INSTANCE, localDate3);
                        i8 |= 2;
                        i7 = 10;
                        i6 = 9;
                    case 2:
                        localTime6 = (LocalTime) beginStructure.decodeSerializableElement(serialDescriptor, 2, LocalTimeSerializer.INSTANCE, localTime6);
                        i8 |= 4;
                        i7 = 10;
                        i6 = 9;
                    case 3:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i8 |= 8;
                        i7 = 10;
                        i6 = 9;
                    case 4:
                        routeType3 = (RouteType) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, kSerializerArr[4], routeType3);
                        i8 |= 16;
                        i7 = 10;
                        i6 = 9;
                    case 5:
                        c5 = 6;
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i8 |= 32;
                        i7 = 10;
                    case 6:
                        c5 = 6;
                        ferry3 = (Ferry) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, Ferry$$serializer.INSTANCE, ferry3);
                        i8 |= 64;
                        i7 = 10;
                    case 7:
                        duration3 = (Duration) beginStructure.decodeSerializableElement(serialDescriptor, 7, DurationSerializer.INSTANCE, duration3);
                        i8 |= 128;
                    case 8:
                        str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str7);
                        i8 |= 256;
                    case 9:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, i6);
                        i8 |= 512;
                    case 10:
                        str11 = beginStructure.decodeStringElement(serialDescriptor, i7);
                        i8 |= 1024;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i5 = i8;
            str = str7;
            ferry = ferry3;
            routeType = routeType3;
            duration = duration3;
            localTime = localTime6;
            localDate = localDate3;
            localTime2 = localTime3;
            str2 = str8;
            str3 = str9;
            str4 = str10;
            str5 = str11;
        }
        beginStructure.endStructure(serialDescriptor);
        return new SaleOnBoardDeparture(i5, localTime2, localDate, localTime, str2, routeType, str3, ferry, duration, str, str4, str5, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, SaleOnBoardDeparture value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        SaleOnBoardDeparture.write$Self$domain_kombardoProd(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
