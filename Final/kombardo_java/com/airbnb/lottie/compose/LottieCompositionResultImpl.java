package com.airbnb.lottie.compose;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import com.airbnb.lottie.LottieComposition;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R/\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00048V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\bR/\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\n8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\rR\u001b\u0010 \u001a\u00020\u001d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020\u001d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010!R\u001b\u0010%\u001a\u00020\u001d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!R\u001b\u0010'\u001a\u00020\u001d8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!¨\u0006("}, d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionResultImpl;", "Lcom/airbnb/lottie/compose/LottieCompositionResult;", "<init>", "()V", "Lcom/airbnb/lottie/LottieComposition;", "composition", BuildConfig.FLAVOR, "complete$lottie_compose_release", "(Lcom/airbnb/lottie/LottieComposition;)V", "complete", BuildConfig.FLAVOR, "error", "completeExceptionally$lottie_compose_release", "(Ljava/lang/Throwable;)V", "completeExceptionally", "Lkotlinx/coroutines/CompletableDeferred;", "compositionDeferred", "Lkotlinx/coroutines/CompletableDeferred;", "<set-?>", "value$delegate", "Landroidx/compose/runtime/MutableState;", "getValue", "()Lcom/airbnb/lottie/LottieComposition;", "setValue", "value", "error$delegate", "getError", "()Ljava/lang/Throwable;", "setError", BuildConfig.FLAVOR, "isLoading$delegate", "Landroidx/compose/runtime/State;", "isLoading", "()Z", "isComplete$delegate", "isComplete", "isFailure$delegate", "isFailure", "isSuccess$delegate", "isSuccess", "lottie-compose_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LottieCompositionResultImpl implements LottieCompositionResult {
    private final CompletableDeferred<LottieComposition> compositionDeferred = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);

    /* renamed from: error$delegate, reason: from kotlin metadata */
    private final MutableState error;

    /* renamed from: isComplete$delegate, reason: from kotlin metadata */
    private final State isComplete;

    /* renamed from: isFailure$delegate, reason: from kotlin metadata */
    private final State isFailure;

    /* renamed from: isLoading$delegate, reason: from kotlin metadata */
    private final State isLoading;

    /* renamed from: isSuccess$delegate, reason: from kotlin metadata */
    private final State isSuccess;

    /* renamed from: value$delegate, reason: from kotlin metadata */
    private final MutableState value;

    public LottieCompositionResultImpl() {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.value = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.error = mutableStateOf$default2;
        this.isLoading = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.airbnb.lottie.compose.LottieCompositionResultImpl$isLoading$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(LottieCompositionResultImpl.this.getValue() == null && LottieCompositionResultImpl.this.getError() == null);
            }
        });
        this.isComplete = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.airbnb.lottie.compose.LottieCompositionResultImpl$isComplete$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf((LottieCompositionResultImpl.this.getValue() == null && LottieCompositionResultImpl.this.getError() == null) ? false : true);
            }
        });
        this.isFailure = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.airbnb.lottie.compose.LottieCompositionResultImpl$isFailure$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(LottieCompositionResultImpl.this.getError() != null);
            }
        });
        this.isSuccess = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.airbnb.lottie.compose.LottieCompositionResultImpl$isSuccess$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(LottieCompositionResultImpl.this.getValue() != null);
            }
        });
    }

    private void setError(Throwable th) {
        this.error.setValue(th);
    }

    private void setValue(LottieComposition lottieComposition) {
        this.value.setValue(lottieComposition);
    }

    public final synchronized void complete$lottie_compose_release(LottieComposition composition) {
        Intrinsics.checkNotNullParameter(composition, "composition");
        if (isComplete()) {
            return;
        }
        setValue(composition);
        this.compositionDeferred.complete(composition);
    }

    public final synchronized void completeExceptionally$lottie_compose_release(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        if (isComplete()) {
            return;
        }
        setError(error);
        this.compositionDeferred.completeExceptionally(error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Throwable getError() {
        return (Throwable) this.error.getValue();
    }

    public boolean isComplete() {
        return ((Boolean) this.isComplete.getValue()).booleanValue();
    }

    public boolean isSuccess() {
        return ((Boolean) this.isSuccess.getValue()).booleanValue();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.State
    public LottieComposition getValue() {
        return (LottieComposition) this.value.getValue();
    }
}
