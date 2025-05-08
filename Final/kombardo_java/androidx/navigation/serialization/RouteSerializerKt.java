package androidx.navigation.serialization;

import androidx.navigation.NavType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a=\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00050\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\tH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001ac\u0010\u0012\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\t2\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00050\u00032&\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0005\u0012\u0004\u0012\u00020\u000e0\rH\u0003¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0013\u0010\u0015\u001a\u00020\u0014*\u00020\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {BuildConfig.FLAVOR, "T", "route", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Landroidx/navigation/NavType;", "typeMap", "generateRouteWithArgs", "(Ljava/lang/Object;Ljava/util/Map;)Ljava/lang/String;", "Lkotlinx/serialization/KSerializer;", BuildConfig.FLAVOR, "generateHashCode", "(Lkotlinx/serialization/KSerializer;)I", "Lkotlin/Function3;", BuildConfig.FLAVOR, "operation", "forEachIndexedName", "(Lkotlinx/serialization/KSerializer;Ljava/util/Map;Lkotlin/jvm/functions/Function3;)V", "forEachIndexed", "Lkotlinx/serialization/descriptors/SerialDescriptor;", BuildConfig.FLAVOR, "isValueClass", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Z", "navigation-common_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class RouteSerializerKt {
    private static final <T> void forEachIndexedName(KSerializer<T> kSerializer, Map<String, ? extends NavType<Object>> map, Function3<? super Integer, ? super String, ? super NavType<Object>, Unit> function3) {
        int elementsCount = kSerializer.getDescriptor().getElementsCount();
        for (int i5 = 0; i5 < elementsCount; i5++) {
            String elementName = kSerializer.getDescriptor().getElementName(i5);
            NavType<Object> navType = map.get(elementName);
            if (navType == null) {
                throw new IllegalStateException(("Cannot locate NavType for argument [" + elementName + ']').toString());
            }
            function3.invoke(Integer.valueOf(i5), elementName, navType);
        }
    }

    public static final <T> int generateHashCode(KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "<this>");
        int hashCode = kSerializer.getDescriptor().getSerialName().hashCode();
        int elementsCount = kSerializer.getDescriptor().getElementsCount();
        for (int i5 = 0; i5 < elementsCount; i5++) {
            hashCode = (hashCode * 31) + kSerializer.getDescriptor().getElementName(i5).hashCode();
        }
        return hashCode;
    }

    public static final <T> String generateRouteWithArgs(T route, Map<String, ? extends NavType<Object>> typeMap) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        KSerializer serializer = SerializersKt.serializer(Reflection.getOrCreateKotlinClass(route.getClass()));
        final Map<String, List<String>> encodeToArgMap = new RouteEncoder(serializer, typeMap).encodeToArgMap(route);
        final RouteBuilder routeBuilder = new RouteBuilder(serializer);
        forEachIndexedName(serializer, typeMap, new Function3<Integer, String, NavType<Object>, Unit>() { // from class: androidx.navigation.serialization.RouteSerializerKt$generateRouteWithArgs$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, NavType<Object> navType) {
                invoke(num.intValue(), str, navType);
                return Unit.INSTANCE;
            }

            public final void invoke(int i5, String argName, NavType<Object> navType) {
                Intrinsics.checkNotNullParameter(argName, "argName");
                Intrinsics.checkNotNullParameter(navType, "navType");
                List<String> list = encodeToArgMap.get(argName);
                Intrinsics.checkNotNull(list);
                routeBuilder.appendArg(i5, argName, navType, list);
            }
        });
        return routeBuilder.build();
    }

    public static final boolean isValueClass(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        return Intrinsics.areEqual(serialDescriptor.getKind(), StructureKind.CLASS.INSTANCE) && serialDescriptor.getIsInline() && serialDescriptor.getElementsCount() == 1;
    }
}
