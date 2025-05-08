package kotlin.reflect.jvm.internal.impl.types.error;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.conscrypt.BuildConfig;

/* loaded from: classes3.dex */
public final class ErrorClassDescriptor extends ClassDescriptorImpl {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ErrorClassDescriptor(Name name) {
        super(r2, name, r4, r5, r6, r10, false, LockBasedStorageManager.NO_LOCKS);
        Intrinsics.checkNotNullParameter(name, "name");
        ErrorUtils errorUtils = ErrorUtils.INSTANCE;
        ModuleDescriptor errorModule = errorUtils.getErrorModule();
        Modality modality = Modality.OPEN;
        ClassKind classKind = ClassKind.CLASS;
        List emptyList = CollectionsKt.emptyList();
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        ClassConstructorDescriptorImpl create = ClassConstructorDescriptorImpl.create(this, Annotations.Companion.getEMPTY(), true, sourceElement);
        create.initialize(CollectionsKt.emptyList(), DescriptorVisibilities.INTERNAL);
        Intrinsics.checkNotNullExpressionValue(create, "apply(...)");
        MemberScope createErrorScope = ErrorUtils.createErrorScope(ErrorScopeKind.SCOPE_FOR_ERROR_CLASS, create.getName().toString(), BuildConfig.FLAVOR);
        ErrorTypeKind errorTypeKind = ErrorTypeKind.ERROR_CLASS;
        create.setReturnType(new ErrorType(errorUtils.createErrorTypeConstructor(errorTypeKind, new String[0]), createErrorScope, errorTypeKind, null, false, new String[0], 24, null));
        initialize(createErrorScope, SetsKt.setOf(create), create);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor
    public MemberScope getMemberScope(TypeSubstitution typeSubstitution, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(typeSubstitution, "typeSubstitution");
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return ErrorUtils.createErrorScope(ErrorScopeKind.SCOPE_FOR_ERROR_CLASS, getName().toString(), typeSubstitution.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    public ClassDescriptor substitute(TypeSubstitutor substitutor) {
        Intrinsics.checkNotNullParameter(substitutor, "substitutor");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl
    public String toString() {
        String asString = getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString(...)");
        return asString;
    }
}
