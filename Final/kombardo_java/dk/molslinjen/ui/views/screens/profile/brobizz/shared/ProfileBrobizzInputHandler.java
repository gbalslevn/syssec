package dk.molslinjen.ui.views.screens.profile.brobizz.shared;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/brobizz/shared/ProfileBrobizzInputHandler;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "brobizzNumber", BuildConfig.FLAVOR, "updateBrobizzNumber", "(Ljava/lang/String;)V", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/profile/brobizz/shared/IProfileBrobizzInputHandler$InputState;", "inputState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getInputState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProfileBrobizzInputHandler {
    private final MutableStateFlow<InputState> inputState = StateFlowKt.MutableStateFlow(new InputState(null, 1, null));

    public MutableStateFlow<InputState> getInputState() {
        return this.inputState;
    }

    public void updateBrobizzNumber(String brobizzNumber) {
        InputState value;
        Intrinsics.checkNotNullParameter(brobizzNumber, "brobizzNumber");
        MutableStateFlow<InputState> inputState = getInputState();
        do {
            value = inputState.getValue();
        } while (!inputState.compareAndSet(value, value.copy(brobizzNumber)));
    }
}
