package uniffi.molslinjen_shared;

import java.lang.ref.Cleaner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.UniffiCleaner;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Luniffi/molslinjen_shared/JavaLangRefCleaner;", "Luniffi/molslinjen_shared/UniffiCleaner;", "()V", "cleaner", "Ljava/lang/ref/Cleaner;", "kotlin.jvm.PlatformType", "getCleaner", "()Ljava/lang/ref/Cleaner;", "register", "Luniffi/molslinjen_shared/UniffiCleaner$Cleanable;", "value", BuildConfig.FLAVOR, "cleanUpTask", "Ljava/lang/Runnable;", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
final class JavaLangRefCleaner implements UniffiCleaner {
    private final Cleaner cleaner;

    public JavaLangRefCleaner() {
        Cleaner create;
        create = Cleaner.create();
        this.cleaner = create;
    }

    public final Cleaner getCleaner() {
        return this.cleaner;
    }

    @Override // uniffi.molslinjen_shared.UniffiCleaner
    public UniffiCleaner.Cleanable register(Object value, Runnable cleanUpTask) {
        Cleaner.Cleanable register;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(cleanUpTask, "cleanUpTask");
        register = this.cleaner.register(value, cleanUpTask);
        Intrinsics.checkNotNullExpressionValue(register, "register(...)");
        return new JavaLangRefCleanable(register);
    }
}
