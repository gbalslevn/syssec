package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* loaded from: classes3.dex */
public interface DescriptorRendererOptions {

    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static boolean getIncludeAnnotationArguments(DescriptorRendererOptions descriptorRendererOptions) {
            return descriptorRendererOptions.getAnnotationArgumentsRenderingPolicy().getIncludeAnnotationArguments();
        }

        public static boolean getIncludeEmptyAnnotationArguments(DescriptorRendererOptions descriptorRendererOptions) {
            return descriptorRendererOptions.getAnnotationArgumentsRenderingPolicy().getIncludeEmptyAnnotationArguments();
        }
    }

    AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy();

    boolean getDebugMode();

    boolean getEnhancedTypes();

    Set<FqName> getExcludedTypeAnnotationClasses();

    void setClassifierNamePolicy(ClassifierNamePolicy classifierNamePolicy);

    void setDebugMode(boolean z5);

    void setExcludedTypeAnnotationClasses(Set<FqName> set);

    void setModifiers(Set<? extends DescriptorRendererModifier> set);

    void setParameterNameRenderingPolicy(ParameterNameRenderingPolicy parameterNameRenderingPolicy);

    void setReceiverAfterName(boolean z5);

    void setRenderCompanionObjectName(boolean z5);

    void setStartFromName(boolean z5);

    void setTextFormat(RenderingFormat renderingFormat);

    void setWithDefinedIn(boolean z5);

    void setWithoutSuperTypes(boolean z5);

    void setWithoutTypeParameters(boolean z5);
}
