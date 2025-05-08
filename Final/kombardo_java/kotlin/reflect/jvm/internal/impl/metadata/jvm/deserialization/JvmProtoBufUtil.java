package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import org.conscrypt.BuildConfig;

/* loaded from: classes3.dex */
public final class JvmProtoBufUtil {
    private static final ExtensionRegistryLite EXTENSION_REGISTRY;
    public static final JvmProtoBufUtil INSTANCE = new JvmProtoBufUtil();

    static {
        ExtensionRegistryLite newInstance = ExtensionRegistryLite.newInstance();
        JvmProtoBuf.registerAllExtensions(newInstance);
        Intrinsics.checkNotNullExpressionValue(newInstance, "apply(...)");
        EXTENSION_REGISTRY = newInstance;
    }

    private JvmProtoBufUtil() {
    }

    public static /* synthetic */ JvmMemberSignature.Field getJvmFieldSignature$default(JvmProtoBufUtil jvmProtoBufUtil, ProtoBuf$Property protoBuf$Property, NameResolver nameResolver, TypeTable typeTable, boolean z5, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            z5 = true;
        }
        return jvmProtoBufUtil.getJvmFieldSignature(protoBuf$Property, nameResolver, typeTable, z5);
    }

    public static final boolean isMovedFromInterfaceCompanion(ProtoBuf$Property proto) {
        Intrinsics.checkNotNullParameter(proto, "proto");
        Flags.BooleanFlagField is_moved_from_interface_companion = JvmFlags.INSTANCE.getIS_MOVED_FROM_INTERFACE_COMPANION();
        Object extension = proto.getExtension(JvmProtoBuf.flags);
        Intrinsics.checkNotNullExpressionValue(extension, "getExtension(...)");
        Boolean bool = is_moved_from_interface_companion.get(((Number) extension).intValue());
        Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
        return bool.booleanValue();
    }

    private final String mapTypeDefault(ProtoBuf$Type protoBuf$Type, NameResolver nameResolver) {
        if (protoBuf$Type.hasClassName()) {
            return ClassMapperLite.mapClass(nameResolver.getQualifiedClassName(protoBuf$Type.getClassName()));
        }
        return null;
    }

    public static final Pair<JvmNameResolver, ProtoBuf$Class> readClassDataFrom(String[] data, String[] strings) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(strings, "strings");
        byte[] decodeBytes = BitEncoding.decodeBytes(data);
        Intrinsics.checkNotNullExpressionValue(decodeBytes, "decodeBytes(...)");
        return readClassDataFrom(decodeBytes, strings);
    }

    public static final Pair<JvmNameResolver, ProtoBuf$Function> readFunctionDataFrom(String[] data, String[] strings) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(BitEncoding.decodeBytes(data));
        return new Pair<>(INSTANCE.readNameResolver(byteArrayInputStream, strings), ProtoBuf$Function.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }

    private final JvmNameResolver readNameResolver(InputStream inputStream, String[] strArr) {
        JvmProtoBuf.StringTableTypes parseDelimitedFrom = JvmProtoBuf.StringTableTypes.parseDelimitedFrom(inputStream, EXTENSION_REGISTRY);
        Intrinsics.checkNotNullExpressionValue(parseDelimitedFrom, "parseDelimitedFrom(...)");
        return new JvmNameResolver(parseDelimitedFrom, strArr);
    }

    public static final Pair<JvmNameResolver, ProtoBuf$Package> readPackageDataFrom(String[] data, String[] strings) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(strings, "strings");
        byte[] decodeBytes = BitEncoding.decodeBytes(data);
        Intrinsics.checkNotNullExpressionValue(decodeBytes, "decodeBytes(...)");
        return readPackageDataFrom(decodeBytes, strings);
    }

    public final ExtensionRegistryLite getEXTENSION_REGISTRY() {
        return EXTENSION_REGISTRY;
    }

    public final JvmMemberSignature.Method getJvmConstructorSignature(ProtoBuf$Constructor proto, NameResolver nameResolver, TypeTable typeTable) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Constructor, JvmProtoBuf.JvmMethodSignature> constructorSignature = JvmProtoBuf.constructorSignature;
        Intrinsics.checkNotNullExpressionValue(constructorSignature, "constructorSignature");
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(proto, constructorSignature);
        String string = (jvmMethodSignature == null || !jvmMethodSignature.hasName()) ? "<init>" : nameResolver.getString(jvmMethodSignature.getName());
        if (jvmMethodSignature == null || !jvmMethodSignature.hasDesc()) {
            List<ProtoBuf$ValueParameter> valueParameterList = proto.getValueParameterList();
            Intrinsics.checkNotNullExpressionValue(valueParameterList, "getValueParameterList(...)");
            List<ProtoBuf$ValueParameter> list = valueParameterList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (ProtoBuf$ValueParameter protoBuf$ValueParameter : list) {
                JvmProtoBufUtil jvmProtoBufUtil = INSTANCE;
                Intrinsics.checkNotNull(protoBuf$ValueParameter);
                String mapTypeDefault = jvmProtoBufUtil.mapTypeDefault(ProtoTypeTableUtilKt.type(protoBuf$ValueParameter, typeTable), nameResolver);
                if (mapTypeDefault == null) {
                    return null;
                }
                arrayList.add(mapTypeDefault);
            }
            joinToString$default = CollectionsKt.joinToString$default(arrayList, BuildConfig.FLAVOR, "(", ")V", 0, null, null, 56, null);
        } else {
            joinToString$default = nameResolver.getString(jvmMethodSignature.getDesc());
        }
        return new JvmMemberSignature.Method(string, joinToString$default);
    }

    public final JvmMemberSignature.Field getJvmFieldSignature(ProtoBuf$Property proto, NameResolver nameResolver, TypeTable typeTable, boolean z5) {
        String mapTypeDefault;
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.propertySignature;
        Intrinsics.checkNotNullExpressionValue(propertySignature, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(proto, propertySignature);
        if (jvmPropertySignature == null) {
            return null;
        }
        JvmProtoBuf.JvmFieldSignature field = jvmPropertySignature.hasField() ? jvmPropertySignature.getField() : null;
        if (field == null && z5) {
            return null;
        }
        int name = (field == null || !field.hasName()) ? proto.getName() : field.getName();
        if (field == null || !field.hasDesc()) {
            mapTypeDefault = mapTypeDefault(ProtoTypeTableUtilKt.returnType(proto, typeTable), nameResolver);
            if (mapTypeDefault == null) {
                return null;
            }
        } else {
            mapTypeDefault = nameResolver.getString(field.getDesc());
        }
        return new JvmMemberSignature.Field(nameResolver.getString(name), mapTypeDefault);
    }

    public final JvmMemberSignature.Method getJvmMethodSignature(ProtoBuf$Function proto, NameResolver nameResolver, TypeTable typeTable) {
        String str;
        Intrinsics.checkNotNullParameter(proto, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Function, JvmProtoBuf.JvmMethodSignature> methodSignature = JvmProtoBuf.methodSignature;
        Intrinsics.checkNotNullExpressionValue(methodSignature, "methodSignature");
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(proto, methodSignature);
        int name = (jvmMethodSignature == null || !jvmMethodSignature.hasName()) ? proto.getName() : jvmMethodSignature.getName();
        if (jvmMethodSignature == null || !jvmMethodSignature.hasDesc()) {
            List listOfNotNull = CollectionsKt.listOfNotNull(ProtoTypeTableUtilKt.receiverType(proto, typeTable));
            List<ProtoBuf$ValueParameter> valueParameterList = proto.getValueParameterList();
            Intrinsics.checkNotNullExpressionValue(valueParameterList, "getValueParameterList(...)");
            List<ProtoBuf$ValueParameter> list = valueParameterList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (ProtoBuf$ValueParameter protoBuf$ValueParameter : list) {
                Intrinsics.checkNotNull(protoBuf$ValueParameter);
                arrayList.add(ProtoTypeTableUtilKt.type(protoBuf$ValueParameter, typeTable));
            }
            List plus = CollectionsKt.plus((Collection) listOfNotNull, (Iterable) arrayList);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(plus, 10));
            Iterator it = plus.iterator();
            while (it.hasNext()) {
                String mapTypeDefault = INSTANCE.mapTypeDefault((ProtoBuf$Type) it.next(), nameResolver);
                if (mapTypeDefault == null) {
                    return null;
                }
                arrayList2.add(mapTypeDefault);
            }
            String mapTypeDefault2 = mapTypeDefault(ProtoTypeTableUtilKt.returnType(proto, typeTable), nameResolver);
            if (mapTypeDefault2 == null) {
                return null;
            }
            str = CollectionsKt.joinToString$default(arrayList2, BuildConfig.FLAVOR, "(", ")", 0, null, null, 56, null) + mapTypeDefault2;
        } else {
            str = nameResolver.getString(jvmMethodSignature.getDesc());
        }
        return new JvmMemberSignature.Method(nameResolver.getString(name), str);
    }

    public static final Pair<JvmNameResolver, ProtoBuf$Class> readClassDataFrom(byte[] bytes, String[] strings) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        return new Pair<>(INSTANCE.readNameResolver(byteArrayInputStream, strings), ProtoBuf$Class.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }

    public static final Pair<JvmNameResolver, ProtoBuf$Package> readPackageDataFrom(byte[] bytes, String[] strings) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        return new Pair<>(INSTANCE.readNameResolver(byteArrayInputStream, strings), ProtoBuf$Package.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }
}
