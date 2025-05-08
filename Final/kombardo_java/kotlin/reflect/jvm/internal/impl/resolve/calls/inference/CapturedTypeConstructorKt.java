package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public abstract class CapturedTypeConstructorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final TypeProjection createCapturedIfNeeded(final TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor == null || typeProjection.getProjectionKind() == Variance.INVARIANT) {
            return typeProjection;
        }
        if (typeParameterDescriptor.getVariance() != typeProjection.getProjectionKind()) {
            return new TypeProjectionImpl(createCapturedType(typeProjection));
        }
        if (!typeProjection.isStarProjection()) {
            return new TypeProjectionImpl(typeProjection.getType());
        }
        StorageManager NO_LOCKS = LockBasedStorageManager.NO_LOCKS;
        Intrinsics.checkNotNullExpressionValue(NO_LOCKS, "NO_LOCKS");
        return new TypeProjectionImpl(new LazyWrappedType(NO_LOCKS, new Function0(typeProjection) { // from class: kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt$$Lambda$0
            private final TypeProjection arg$0;

            {
                this.arg$0 = typeProjection;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                KotlinType createCapturedIfNeeded$lambda$1;
                createCapturedIfNeeded$lambda$1 = CapturedTypeConstructorKt.createCapturedIfNeeded$lambda$1(this.arg$0);
                return createCapturedIfNeeded$lambda$1;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KotlinType createCapturedIfNeeded$lambda$1(TypeProjection typeProjection) {
        KotlinType type = typeProjection.getType();
        Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
        return type;
    }

    public static final KotlinType createCapturedType(TypeProjection typeProjection) {
        Intrinsics.checkNotNullParameter(typeProjection, "typeProjection");
        return new CapturedType(typeProjection, null, false, null, 14, null);
    }

    public static final boolean isCaptured(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return kotlinType.getConstructor() instanceof CapturedTypeConstructor;
    }

    public static final TypeSubstitution wrapWithCapturingSubstitution(final TypeSubstitution typeSubstitution, final boolean z5) {
        Intrinsics.checkNotNullParameter(typeSubstitution, "<this>");
        if (!(typeSubstitution instanceof IndexedParametersSubstitution)) {
            return new DelegatedTypeSubstitution(typeSubstitution) { // from class: kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt$wrapWithCapturingSubstitution$2
                @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
                public boolean approximateContravariantCapturedTypes() {
                    return z5;
                }

                @Override // kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution, kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
                /* renamed from: get */
                public TypeProjection mo3723get(KotlinType key) {
                    TypeProjection createCapturedIfNeeded;
                    Intrinsics.checkNotNullParameter(key, "key");
                    TypeProjection mo3723get = super.mo3723get(key);
                    if (mo3723get == null) {
                        return null;
                    }
                    ClassifierDescriptor mo3718getDeclarationDescriptor = key.getConstructor().mo3718getDeclarationDescriptor();
                    createCapturedIfNeeded = CapturedTypeConstructorKt.createCapturedIfNeeded(mo3723get, mo3718getDeclarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) mo3718getDeclarationDescriptor : null);
                    return createCapturedIfNeeded;
                }
            };
        }
        IndexedParametersSubstitution indexedParametersSubstitution = (IndexedParametersSubstitution) typeSubstitution;
        TypeParameterDescriptor[] parameters = indexedParametersSubstitution.getParameters();
        List<Pair> zip = ArraysKt.zip(indexedParametersSubstitution.getArguments(), indexedParametersSubstitution.getParameters());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(zip, 10));
        for (Pair pair : zip) {
            arrayList.add(createCapturedIfNeeded((TypeProjection) pair.getFirst(), (TypeParameterDescriptor) pair.getSecond()));
        }
        return new IndexedParametersSubstitution(parameters, (TypeProjection[]) arrayList.toArray(new TypeProjection[0]), z5);
    }

    public static /* synthetic */ TypeSubstitution wrapWithCapturingSubstitution$default(TypeSubstitution typeSubstitution, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = true;
        }
        return wrapWithCapturingSubstitution(typeSubstitution, z5);
    }
}
