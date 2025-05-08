package androidx.compose.foundation.text;

import androidx.collection.MutableObjectList;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.FocusInteraction$Unfocus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0011\u0010\f\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\r\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/text/LinkStateInteractionSourceObserver;", BuildConfig.FLAVOR, "()V", "Focused", BuildConfig.FLAVOR, "Hovered", "Pressed", "interactionState", "Landroidx/compose/runtime/MutableIntState;", "isFocused", BuildConfig.FLAVOR, "()Z", "isHovered", "isPressed", "collectInteractionsForLinks", BuildConfig.FLAVOR, "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/interaction/InteractionSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LinkStateInteractionSourceObserver {
    private final int Focused = 1;
    private final int Hovered = 2;
    private final int Pressed = 4;
    private final MutableIntState interactionState = SnapshotIntStateKt.mutableIntStateOf(0);

    public final Object collectInteractionsForLinks(InteractionSource interactionSource, Continuation<? super Unit> continuation) {
        final MutableObjectList mutableObjectList = new MutableObjectList(0, 1, null);
        Object collect = interactionSource.getInteractions().collect(new FlowCollector() { // from class: androidx.compose.foundation.text.LinkStateInteractionSourceObserver$collectInteractionsForLinks$2
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((Interaction) obj, (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(Interaction interaction, Continuation<? super Unit> continuation2) {
                MutableIntState mutableIntState;
                int i5;
                if (interaction instanceof HoverInteraction$Enter ? true : interaction instanceof FocusInteraction$Focus ? true : interaction instanceof PressInteraction.Press) {
                    mutableObjectList.add(interaction);
                } else if (interaction instanceof HoverInteraction$Exit) {
                    mutableObjectList.remove(((HoverInteraction$Exit) interaction).getEnter());
                } else if (interaction instanceof FocusInteraction$Unfocus) {
                    mutableObjectList.remove(((FocusInteraction$Unfocus) interaction).getFocus());
                } else if (interaction instanceof PressInteraction.Release) {
                    mutableObjectList.remove(((PressInteraction.Release) interaction).getPress());
                } else if (interaction instanceof PressInteraction.Cancel) {
                    mutableObjectList.remove(((PressInteraction.Cancel) interaction).getPress());
                }
                MutableObjectList<Interaction> mutableObjectList2 = mutableObjectList;
                LinkStateInteractionSourceObserver linkStateInteractionSourceObserver = this;
                Object[] objArr = mutableObjectList2.content;
                int i6 = mutableObjectList2._size;
                int i7 = 0;
                for (int i8 = 0; i8 < i6; i8++) {
                    Interaction interaction2 = (Interaction) objArr[i8];
                    if (interaction2 instanceof HoverInteraction$Enter) {
                        i5 = linkStateInteractionSourceObserver.Hovered;
                    } else if (interaction2 instanceof FocusInteraction$Focus) {
                        i5 = linkStateInteractionSourceObserver.Focused;
                    } else if (interaction2 instanceof PressInteraction.Press) {
                        i5 = linkStateInteractionSourceObserver.Pressed;
                    }
                    i7 |= i5;
                }
                mutableIntState = this.interactionState;
                mutableIntState.setIntValue(i7);
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public final boolean isFocused() {
        return (this.interactionState.getIntValue() & this.Focused) != 0;
    }

    public final boolean isHovered() {
        return (this.interactionState.getIntValue() & this.Hovered) != 0;
    }

    public final boolean isPressed() {
        return (this.interactionState.getIntValue() & this.Pressed) != 0;
    }
}
