package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* loaded from: classes3.dex */
public final class NameUtils {
    public static final NameUtils INSTANCE = new NameUtils();
    private static final Regex SANITIZE_AS_JAVA_INVALID_CHARACTERS = new Regex("[^\\p{L}\\p{Digit}]");
    private static final String CONTEXT_RECEIVER_PREFIX = "$context_receiver";

    private NameUtils() {
    }

    public static final Name contextReceiverName(int i5) {
        Name identifier = Name.identifier(CONTEXT_RECEIVER_PREFIX + '_' + i5);
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(...)");
        return identifier;
    }

    public static final String sanitizeAsJavaIdentifier(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return SANITIZE_AS_JAVA_INVALID_CHARACTERS.replace(name, "_");
    }
}
