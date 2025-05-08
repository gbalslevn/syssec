package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collection;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* loaded from: classes3.dex */
public class JavaAnnotationDescriptor implements PossiblyExternalAnnotationDescriptor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(JavaAnnotationDescriptor.class, "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;", 0))};
    private final JavaAnnotationArgument firstArgument;
    private final FqName fqName;
    private final boolean isIdeExternalAnnotation;
    private final SourceElement source;
    private final NotNullLazyValue type$delegate;

    public JavaAnnotationDescriptor(final LazyJavaResolverContext c5, JavaAnnotation javaAnnotation, FqName fqName) {
        SourceElement NO_SOURCE;
        Collection<JavaAnnotationArgument> arguments;
        Intrinsics.checkNotNullParameter(c5, "c");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        this.fqName = fqName;
        if (javaAnnotation == null || (NO_SOURCE = c5.getComponents().getSourceElementFactory().source(javaAnnotation)) == null) {
            NO_SOURCE = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
        }
        this.source = NO_SOURCE;
        this.type$delegate = c5.getStorageManager().createLazyValue(new Function0(c5, this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationDescriptor$$Lambda$0
            private final LazyJavaResolverContext arg$0;
            private final JavaAnnotationDescriptor arg$1;

            {
                this.arg$0 = c5;
                this.arg$1 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                SimpleType type_delegate$lambda$1;
                type_delegate$lambda$1 = JavaAnnotationDescriptor.type_delegate$lambda$1(this.arg$0, this.arg$1);
                return type_delegate$lambda$1;
            }
        });
        this.firstArgument = (javaAnnotation == null || (arguments = javaAnnotation.getArguments()) == null) ? null : (JavaAnnotationArgument) CollectionsKt.firstOrNull(arguments);
        boolean z5 = false;
        if (javaAnnotation != null && javaAnnotation.isIdeExternalAnnotation()) {
            z5 = true;
        }
        this.isIdeExternalAnnotation = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SimpleType type_delegate$lambda$1(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotationDescriptor javaAnnotationDescriptor) {
        SimpleType defaultType = lazyJavaResolverContext.getModule().getBuiltIns().getBuiltInClassByFqName(javaAnnotationDescriptor.getFqName()).getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "getDefaultType(...)");
        return defaultType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return MapsKt.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final JavaAnnotationArgument getFirstArgument() {
        return this.firstArgument;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public FqName getFqName() {
        return this.fqName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public SourceElement getSource() {
        return this.source;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor
    public boolean isIdeExternalAnnotation() {
        return this.isIdeExternalAnnotation;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor
    public SimpleType getType() {
        return (SimpleType) StorageKt.getValue(this.type$delegate, this, (KProperty<?>) $$delegatedProperties[0]);
    }
}
