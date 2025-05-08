package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.LinkedList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable;

/* loaded from: classes3.dex */
public final class NameResolverImpl implements NameResolver {
    private final ProtoBuf$QualifiedNameTable qualifiedNames;
    private final ProtoBuf$StringTable strings;

    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProtoBuf$QualifiedNameTable.QualifiedName.Kind.values().length];
            try {
                iArr[ProtoBuf$QualifiedNameTable.QualifiedName.Kind.CLASS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProtoBuf$QualifiedNameTable.QualifiedName.Kind.PACKAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProtoBuf$QualifiedNameTable.QualifiedName.Kind.LOCAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public NameResolverImpl(ProtoBuf$StringTable strings, ProtoBuf$QualifiedNameTable qualifiedNames) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(qualifiedNames, "qualifiedNames");
        this.strings = strings;
        this.qualifiedNames = qualifiedNames;
    }

    private final Triple<List<String>, List<String>, Boolean> traverseIds(int i5) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z5 = false;
        while (i5 != -1) {
            ProtoBuf$QualifiedNameTable.QualifiedName qualifiedName = this.qualifiedNames.getQualifiedName(i5);
            String string = this.strings.getString(qualifiedName.getShortName());
            ProtoBuf$QualifiedNameTable.QualifiedName.Kind kind = qualifiedName.getKind();
            Intrinsics.checkNotNull(kind);
            int i6 = WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
            if (i6 == 1) {
                linkedList2.addFirst(string);
            } else if (i6 == 2) {
                linkedList.addFirst(string);
            } else {
                if (i6 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                linkedList2.addFirst(string);
                z5 = true;
            }
            i5 = qualifiedName.getParentQualifiedName();
        }
        return new Triple<>(linkedList, linkedList2, Boolean.valueOf(z5));
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int i5) {
        Triple<List<String>, List<String>, Boolean> traverseIds = traverseIds(i5);
        List<String> component1 = traverseIds.component1();
        String joinToString$default = CollectionsKt.joinToString$default(traverseIds.component2(), ".", null, null, 0, null, null, 62, null);
        if (component1.isEmpty()) {
            return joinToString$default;
        }
        return CollectionsKt.joinToString$default(component1, "/", null, null, 0, null, null, 62, null) + '/' + joinToString$default;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getString(int i5) {
        String string = this.strings.getString(i5);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int i5) {
        return traverseIds(i5).getThird().booleanValue();
    }
}
