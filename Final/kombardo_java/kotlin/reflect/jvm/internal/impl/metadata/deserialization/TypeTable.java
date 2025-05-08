package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;

/* loaded from: classes3.dex */
public final class TypeTable {
    private final List<ProtoBuf$Type> types;

    public TypeTable(ProtoBuf$TypeTable typeTable) {
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        List<ProtoBuf$Type> typeList = typeTable.getTypeList();
        if (typeTable.hasFirstNullable()) {
            int firstNullable = typeTable.getFirstNullable();
            List<ProtoBuf$Type> typeList2 = typeTable.getTypeList();
            Intrinsics.checkNotNullExpressionValue(typeList2, "getTypeList(...)");
            List<ProtoBuf$Type> list = typeList2;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            int i5 = 0;
            for (Object obj : list) {
                int i6 = i5 + 1;
                if (i5 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) obj;
                if (i5 >= firstNullable) {
                    protoBuf$Type = protoBuf$Type.toBuilder().setNullable(true).build();
                }
                arrayList.add(protoBuf$Type);
                i5 = i6;
            }
            typeList = arrayList;
        }
        Intrinsics.checkNotNullExpressionValue(typeList, "run(...)");
        this.types = typeList;
    }

    public final ProtoBuf$Type get(int i5) {
        return this.types.get(i5);
    }
}
