package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
/* synthetic */ class BuiltInsLoaderImpl$createPackageFragmentProvider$1 extends FunctionReferenceImpl implements Function1<String, InputStream> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public BuiltInsLoaderImpl$createPackageFragmentProvider$1(Object obj) {
        super(1, obj, BuiltInsResourceLoader.class, "loadResource", "loadResource(Ljava/lang/String;)Ljava/io/InputStream;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final InputStream invoke(String p02) {
        Intrinsics.checkNotNullParameter(p02, "p0");
        return ((BuiltInsResourceLoader) this.receiver).loadResource(p02);
    }
}
