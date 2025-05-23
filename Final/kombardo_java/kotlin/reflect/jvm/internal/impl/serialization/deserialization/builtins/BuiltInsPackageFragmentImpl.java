package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.builtins.ReadPackageFragmentKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* loaded from: classes3.dex */
public final class BuiltInsPackageFragmentImpl extends DeserializedPackageFragmentImpl implements BuiltInsPackageFragment {
    public static final Companion Companion = new Companion(null);
    private final boolean isFallback;

    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BuiltInsPackageFragmentImpl create(FqName fqName, StorageManager storageManager, ModuleDescriptor module, InputStream inputStream, boolean z5) {
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            Intrinsics.checkNotNullParameter(module, "module");
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            Pair<ProtoBuf$PackageFragment, BuiltInsBinaryVersion> readBuiltinsPackageFragment = ReadPackageFragmentKt.readBuiltinsPackageFragment(inputStream);
            ProtoBuf$PackageFragment component1 = readBuiltinsPackageFragment.component1();
            BuiltInsBinaryVersion component2 = readBuiltinsPackageFragment.component2();
            if (component1 != null) {
                return new BuiltInsPackageFragmentImpl(fqName, storageManager, module, component1, component2, z5, null);
            }
            throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + BuiltInsBinaryVersion.INSTANCE + ", actual " + component2 + ". Please update Kotlin");
        }

        private Companion() {
        }
    }

    public /* synthetic */ BuiltInsPackageFragmentImpl(FqName fqName, StorageManager storageManager, ModuleDescriptor moduleDescriptor, ProtoBuf$PackageFragment protoBuf$PackageFragment, BuiltInsBinaryVersion builtInsBinaryVersion, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this(fqName, storageManager, moduleDescriptor, protoBuf$PackageFragment, builtInsBinaryVersion, z5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public String toString() {
        return "builtins package fragment for " + getFqName() + " from " + DescriptorUtilsKt.getModule(this);
    }

    private BuiltInsPackageFragmentImpl(FqName fqName, StorageManager storageManager, ModuleDescriptor moduleDescriptor, ProtoBuf$PackageFragment protoBuf$PackageFragment, BuiltInsBinaryVersion builtInsBinaryVersion, boolean z5) {
        super(fqName, storageManager, moduleDescriptor, protoBuf$PackageFragment, builtInsBinaryVersion, null);
        this.isFallback = z5;
    }
}
