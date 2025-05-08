package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a3\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00028\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\"\u0018\u0010\r\u001a\u00020\n*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"T", "Lkotlinx/serialization/json/Json;", "json", "value", "Lkotlinx/serialization/SerializationStrategy;", "serializer", "Lkotlinx/serialization/json/JsonElement;", "writeJson", "(Lkotlinx/serialization/json/Json;Ljava/lang/Object;Lkotlinx/serialization/SerializationStrategy;)Lkotlinx/serialization/json/JsonElement;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", BuildConfig.FLAVOR, "getRequiresTopLevelTag", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Z", "requiresTopLevelTag", "kotlinx-serialization-json"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class TreeJsonEncoderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getRequiresTopLevelTag(SerialDescriptor serialDescriptor) {
        return (serialDescriptor.getKind() instanceof PrimitiveKind) || serialDescriptor.getKind() == SerialKind.ENUM.INSTANCE;
    }

    public static final <T> JsonElement writeJson(Json json, T t5, SerializationStrategy<? super T> serializer) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        new JsonTreeEncoder(json, new Function1<JsonElement, Unit>() { // from class: kotlinx.serialization.json.internal.TreeJsonEncoderKt$writeJson$encoder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonElement jsonElement) {
                invoke2(jsonElement);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonElement it) {
                Intrinsics.checkNotNullParameter(it, "it");
                ref$ObjectRef.element = it;
            }
        }).encodeSerializableValue(serializer, t5);
        T t6 = ref$ObjectRef.element;
        if (t6 != null) {
            return (JsonElement) t6;
        }
        Intrinsics.throwUninitializedPropertyAccessException("result");
        return null;
    }
}
