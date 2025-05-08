package kotlinx.serialization.modules;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0012\b\u0002\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ9\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e\"\b\b\u0000\u0010\u0004*\u00020\u00012\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00052\u0006\u0010\r\u001a\u00028\u0000H'¢\u0006\u0004\b\u000f\u0010\u0010J;\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0013\"\b\b\u0000\u0010\u0004*\u00020\u00012\u000e\u0010\f\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H'¢\u0006\u0004\b\u000f\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H'¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0001\u0001\u001a¨\u0006\u001b"}, d2 = {"Lkotlinx/serialization/modules/SerializersModule;", BuildConfig.FLAVOR, "<init>", "()V", "T", "Lkotlin/reflect/KClass;", "kClass", BuildConfig.FLAVOR, "Lkotlinx/serialization/KSerializer;", "typeArgumentsSerializers", "getContextual", "(Lkotlin/reflect/KClass;Ljava/util/List;)Lkotlinx/serialization/KSerializer;", "baseClass", "value", "Lkotlinx/serialization/SerializationStrategy;", "getPolymorphic", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", BuildConfig.FLAVOR, "serializedClassName", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlin/reflect/KClass;Ljava/lang/String;)Lkotlinx/serialization/DeserializationStrategy;", "Lkotlinx/serialization/modules/SerializersModuleCollector;", "collector", BuildConfig.FLAVOR, "dumpTo", "(Lkotlinx/serialization/modules/SerializersModuleCollector;)V", "Lkotlinx/serialization/modules/SerialModuleImpl;", "kotlinx-serialization-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class SerializersModule {
    public /* synthetic */ SerializersModule(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KSerializer getContextual$default(SerializersModule serializersModule, KClass kClass, List list, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContextual");
        }
        if ((i5 & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        return serializersModule.getContextual(kClass, list);
    }

    public abstract void dumpTo(SerializersModuleCollector collector);

    public abstract <T> KSerializer<T> getContextual(KClass<T> kClass, List<? extends KSerializer<?>> typeArgumentsSerializers);

    public abstract <T> DeserializationStrategy<T> getPolymorphic(KClass<? super T> baseClass, String serializedClassName);

    public abstract <T> SerializationStrategy<T> getPolymorphic(KClass<? super T> baseClass, T value);

    private SerializersModule() {
    }
}
