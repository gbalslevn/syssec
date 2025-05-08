package kotlin.reflect.jvm.internal.impl.utils.addToStdlib;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public abstract class AddToStdlibKt {
    private static final ConcurrentHashMap<Function0<?>, Object> constantMap = new ConcurrentHashMap<>();

    public static final Void shouldNotBeCalled(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        throw new IllegalStateException(message.toString());
    }

    public static /* synthetic */ Void shouldNotBeCalled$default(String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = "should not be called";
        }
        return shouldNotBeCalled(str);
    }
}
