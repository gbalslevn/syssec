package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public abstract class ReflectKotlinClassFinderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String toRuntimeFqName(ClassId classId) {
        String replace$default = StringsKt.replace$default(classId.getRelativeClassName().asString(), '.', '$', false, 4, (Object) null);
        if (classId.getPackageFqName().isRoot()) {
            return replace$default;
        }
        return classId.getPackageFqName() + '.' + replace$default;
    }
}
