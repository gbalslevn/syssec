package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeQualifiersByElementType;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* loaded from: classes3.dex */
public final class LazyJavaResolverContext {
    private final JavaResolverComponents components;
    private final Lazy<JavaTypeQualifiersByElementType> delegateForDefaultTypeQualifiers;
    private final TypeParameterResolver typeParameterResolver;
    private final JavaTypeResolver typeResolver;

    public LazyJavaResolverContext(JavaResolverComponents components, TypeParameterResolver typeParameterResolver, Lazy<JavaTypeQualifiersByElementType> delegateForDefaultTypeQualifiers) {
        Intrinsics.checkNotNullParameter(components, "components");
        Intrinsics.checkNotNullParameter(typeParameterResolver, "typeParameterResolver");
        Intrinsics.checkNotNullParameter(delegateForDefaultTypeQualifiers, "delegateForDefaultTypeQualifiers");
        this.components = components;
        this.typeParameterResolver = typeParameterResolver;
        this.delegateForDefaultTypeQualifiers = delegateForDefaultTypeQualifiers;
        this.typeResolver = new JavaTypeResolver(this, typeParameterResolver);
    }

    public final JavaResolverComponents getComponents() {
        return this.components;
    }

    public final JavaTypeQualifiersByElementType getDefaultTypeQualifiers() {
        return this.delegateForDefaultTypeQualifiers.getValue();
    }

    public final Lazy<JavaTypeQualifiersByElementType> getDelegateForDefaultTypeQualifiers$descriptors_jvm() {
        return this.delegateForDefaultTypeQualifiers;
    }

    public final ModuleDescriptor getModule() {
        return this.components.getModule();
    }

    public final StorageManager getStorageManager() {
        return this.components.getStorageManager();
    }

    public final TypeParameterResolver getTypeParameterResolver() {
        return this.typeParameterResolver;
    }

    public final JavaTypeResolver getTypeResolver() {
        return this.typeResolver;
    }
}
