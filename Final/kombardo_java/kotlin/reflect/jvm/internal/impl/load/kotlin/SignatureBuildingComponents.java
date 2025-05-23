package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* loaded from: classes3.dex */
public final class SignatureBuildingComponents {
    public static final SignatureBuildingComponents INSTANCE = new SignatureBuildingComponents();

    private SignatureBuildingComponents() {
    }

    private final String escapeClassName(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return 'L' + str + ';';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence jvmDescriptor$lambda$2(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return INSTANCE.escapeClassName(it);
    }

    public final String[] constructors(String... signatures) {
        Intrinsics.checkNotNullParameter(signatures, "signatures");
        ArrayList arrayList = new ArrayList(signatures.length);
        for (String str : signatures) {
            arrayList.add("<init>(" + str + ")V");
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public final Set<String> inClass(String internalName, String... signatures) {
        Intrinsics.checkNotNullParameter(internalName, "internalName");
        Intrinsics.checkNotNullParameter(signatures, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str : signatures) {
            linkedHashSet.add(internalName + '.' + str);
        }
        return linkedHashSet;
    }

    public final Set<String> inJavaLang(String name, String... signatures) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(signatures, "signatures");
        return inClass(javaLang(name), (String[]) Arrays.copyOf(signatures, signatures.length));
    }

    public final Set<String> inJavaUtil(String name, String... signatures) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(signatures, "signatures");
        return inClass(javaUtil(name), (String[]) Arrays.copyOf(signatures, signatures.length));
    }

    public final String javaFunction(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return "java/util/function/" + name;
    }

    public final String javaLang(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return "java/lang/" + name;
    }

    public final String javaUtil(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return "java/util/" + name;
    }

    public final String jvmDescriptor(String name, List<String> parameters, String ret) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(ret, "ret");
        return name + '(' + CollectionsKt.joinToString$default(parameters, BuildConfig.FLAVOR, null, null, 0, null, new Function1() { // from class: kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents$$Lambda$0
            @Override // kotlin.jvm.functions.Function1
            public Object invoke(Object obj) {
                CharSequence jvmDescriptor$lambda$2;
                jvmDescriptor$lambda$2 = SignatureBuildingComponents.jvmDescriptor$lambda$2((String) obj);
                return jvmDescriptor$lambda$2;
            }
        }, 30, null) + ')' + escapeClassName(ret);
    }

    public final String signature(String internalName, String jvmDescriptor) {
        Intrinsics.checkNotNullParameter(internalName, "internalName");
        Intrinsics.checkNotNullParameter(jvmDescriptor, "jvmDescriptor");
        return internalName + '.' + jvmDescriptor;
    }
}
