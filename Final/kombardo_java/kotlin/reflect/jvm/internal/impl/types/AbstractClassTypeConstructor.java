package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* loaded from: classes3.dex */
public abstract class AbstractClassTypeConstructor extends AbstractTypeConstructor {
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void $$$reportNull$$$0(int i5) {
        String format;
        String str = (i5 == 1 || i5 == 3 || i5 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i5 == 1 || i5 == 3 || i5 == 4) ? 2 : 3];
        if (i5 != 1) {
            if (i5 == 2) {
                objArr[0] = "classifier";
            } else if (i5 != 3 && i5 != 4) {
                objArr[0] = "storageManager";
            }
            if (i5 != 1) {
                objArr[1] = "getBuiltIns";
            } else if (i5 == 3 || i5 == 4) {
                objArr[1] = "getAdditionalNeighboursInSupertypeGraph";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
            }
            if (i5 != 1) {
                if (i5 == 2) {
                    objArr[2] = "isSameClassifier";
                } else if (i5 != 3 && i5 != 4) {
                    objArr[2] = "<init>";
                }
            }
            format = String.format(str, objArr);
            if (i5 == 1 && i5 != 3 && i5 != 4) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }
        objArr[0] = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor";
        if (i5 != 1) {
        }
        if (i5 != 1) {
        }
        format = String.format(str, objArr);
        if (i5 == 1) {
        }
        throw new IllegalStateException(format);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractClassTypeConstructor(StorageManager storageManager) {
        super(storageManager);
        if (storageManager == null) {
            $$$reportNull$$$0(0);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    protected KotlinType defaultSupertypeIfEmpty() {
        if (KotlinBuiltIns.isSpecialClassWithNoSupertypes(mo3718getDeclarationDescriptor())) {
            return null;
        }
        return getBuiltIns().getAnyType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    protected Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean z5) {
        DeclarationDescriptor containingDeclaration = mo3718getDeclarationDescriptor().getContainingDeclaration();
        if (!(containingDeclaration instanceof ClassDescriptor)) {
            List emptyList = Collections.emptyList();
            if (emptyList == null) {
                $$$reportNull$$$0(3);
            }
            return emptyList;
        }
        SmartList smartList = new SmartList();
        ClassDescriptor classDescriptor = (ClassDescriptor) containingDeclaration;
        smartList.add(classDescriptor.getDefaultType());
        ClassDescriptor mo3683getCompanionObjectDescriptor = classDescriptor.mo3683getCompanionObjectDescriptor();
        if (z5 && mo3683getCompanionObjectDescriptor != null) {
            smartList.add(mo3683getCompanionObjectDescriptor.getDefaultType());
        }
        return smartList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns builtIns = DescriptorUtilsKt.getBuiltIns(mo3718getDeclarationDescriptor());
        if (builtIns == null) {
            $$$reportNull$$$0(1);
        }
        return builtIns;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor, kotlin.reflect.jvm.internal.impl.types.TypeConstructor
    /* renamed from: getDeclarationDescriptor */
    public abstract ClassDescriptor mo3718getDeclarationDescriptor();

    @Override // kotlin.reflect.jvm.internal.impl.types.ClassifierBasedTypeConstructor
    protected boolean isSameClassifier(ClassifierDescriptor classifierDescriptor) {
        if (classifierDescriptor == null) {
            $$$reportNull$$$0(2);
        }
        return (classifierDescriptor instanceof ClassDescriptor) && areFqNamesEqual(mo3718getDeclarationDescriptor(), classifierDescriptor);
    }
}
