package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ServiceLoader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* loaded from: classes3.dex */
public interface BuiltInsLoader {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Lazy<BuiltInsLoader> Instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader$Companion$$Lambda$0
            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                BuiltInsLoader Instance_delegate$lambda$0;
                Instance_delegate$lambda$0 = BuiltInsLoader.Companion.Instance_delegate$lambda$0();
                return Instance_delegate$lambda$0;
            }
        });

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BuiltInsLoader Instance_delegate$lambda$0() {
            ServiceLoader load = ServiceLoader.load(BuiltInsLoader.class, BuiltInsLoader.class.getClassLoader());
            Intrinsics.checkNotNull(load);
            BuiltInsLoader builtInsLoader = (BuiltInsLoader) CollectionsKt.firstOrNull(load);
            if (builtInsLoader != null) {
                return builtInsLoader;
            }
            throw new IllegalStateException("No BuiltInsLoader implementation was found. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
        }

        public final BuiltInsLoader getInstance() {
            return Instance$delegate.getValue();
        }
    }

    PackageFragmentProvider createPackageFragmentProvider(StorageManager storageManager, ModuleDescriptor moduleDescriptor, Iterable<? extends ClassDescriptorFactory> iterable, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, AdditionalClassPartsProvider additionalClassPartsProvider, boolean z5);
}
