package com.airbnb.lottie.compose;

import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.sun.jna.Callback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B3\b\u0000\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\t\u0010\nB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\fR\u001a\u0010\u0003\u001a\u00028\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R,\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00028\u00000\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/airbnb/lottie/compose/LottieDynamicProperty;", "T", BuildConfig.FLAVOR, "property", "Lcom/airbnb/lottie/model/KeyPath;", "keyPath", "Lkotlin/Function1;", "Lcom/airbnb/lottie/value/LottieFrameInfo;", Callback.METHOD_NAME, "<init>", "(Ljava/lang/Object;Lcom/airbnb/lottie/model/KeyPath;Lkotlin/jvm/functions/Function1;)V", "value", "(Ljava/lang/Object;Lcom/airbnb/lottie/model/KeyPath;Ljava/lang/Object;)V", "Ljava/lang/Object;", "getProperty$lottie_compose_release", "()Ljava/lang/Object;", "Lcom/airbnb/lottie/model/KeyPath;", "getKeyPath$lottie_compose_release", "()Lcom/airbnb/lottie/model/KeyPath;", "Lkotlin/jvm/functions/Function1;", "getCallback$lottie_compose_release", "()Lkotlin/jvm/functions/Function1;", "lottie-compose_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LottieDynamicProperty<T> {
    public static final int $stable = 8;
    private final Function1<LottieFrameInfo<T>, T> callback;
    private final KeyPath keyPath;
    private final T property;

    /* JADX WARN: Multi-variable type inference failed */
    public LottieDynamicProperty(T t5, KeyPath keyPath, Function1<? super LottieFrameInfo<T>, ? extends T> callback) {
        Intrinsics.checkNotNullParameter(keyPath, "keyPath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.property = t5;
        this.keyPath = keyPath;
        this.callback = callback;
    }

    public final Function1<LottieFrameInfo<T>, T> getCallback$lottie_compose_release() {
        return this.callback;
    }

    /* renamed from: getKeyPath$lottie_compose_release, reason: from getter */
    public final KeyPath getKeyPath() {
        return this.keyPath;
    }

    public final T getProperty$lottie_compose_release() {
        return this.property;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LottieDynamicProperty(T t5, KeyPath keyPath, final T t6) {
        this((Object) t5, keyPath, (Function1) new Function1<LottieFrameInfo<T>, T>() { // from class: com.airbnb.lottie.compose.LottieDynamicProperty.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final T invoke(LottieFrameInfo<T> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return t6;
            }
        });
        Intrinsics.checkNotNullParameter(keyPath, "keyPath");
    }
}
