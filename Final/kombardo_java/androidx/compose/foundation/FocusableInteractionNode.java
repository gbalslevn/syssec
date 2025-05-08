package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.FocusInteraction$Unfocus;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bJ\u0010\u0010\u000f\u001a\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003J\u0014\u0010\u0010\u001a\u00020\f*\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/FocusableInteractionNode;", "Landroidx/compose/ui/Modifier$Node;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "focusedInteraction", "Landroidx/compose/foundation/interaction/FocusInteraction$Focus;", "shouldAutoInvalidate", BuildConfig.FLAVOR, "getShouldAutoInvalidate", "()Z", "disposeInteractionSource", BuildConfig.FLAVOR, "setFocus", "isFocused", "update", "emitWithFallback", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusableInteractionNode extends Modifier.Node {
    private FocusInteraction$Focus focusedInteraction;
    private MutableInteractionSource interactionSource;
    private final boolean shouldAutoInvalidate;

    public FocusableInteractionNode(MutableInteractionSource mutableInteractionSource) {
        this.interactionSource = mutableInteractionSource;
    }

    private final void disposeInteractionSource() {
        FocusInteraction$Focus focusInteraction$Focus;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null && (focusInteraction$Focus = this.focusedInteraction) != null) {
            mutableInteractionSource.tryEmit(new FocusInteraction$Unfocus(focusInteraction$Focus));
        }
        this.focusedInteraction = null;
    }

    private final void emitWithFallback(final MutableInteractionSource mutableInteractionSource, final Interaction interaction) {
        if (!getIsAttached()) {
            mutableInteractionSource.tryEmit(interaction);
        } else {
            Job job = (Job) getCoroutineScope().getCoroutineContext().get(Job.INSTANCE);
            BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), null, null, new FocusableInteractionNode$emitWithFallback$1(mutableInteractionSource, interaction, job != null ? job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.FocusableInteractionNode$emitWithFallback$handler$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    MutableInteractionSource.this.tryEmit(interaction);
                }
            }) : null, null), 3, null);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    public final void setFocus(boolean isFocused) {
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        if (mutableInteractionSource != null) {
            if (!isFocused) {
                FocusInteraction$Focus focusInteraction$Focus = this.focusedInteraction;
                if (focusInteraction$Focus != null) {
                    emitWithFallback(mutableInteractionSource, new FocusInteraction$Unfocus(focusInteraction$Focus));
                    this.focusedInteraction = null;
                    return;
                }
                return;
            }
            FocusInteraction$Focus focusInteraction$Focus2 = this.focusedInteraction;
            if (focusInteraction$Focus2 != null) {
                emitWithFallback(mutableInteractionSource, new FocusInteraction$Unfocus(focusInteraction$Focus2));
                this.focusedInteraction = null;
            }
            FocusInteraction$Focus focusInteraction$Focus3 = new FocusInteraction$Focus();
            emitWithFallback(mutableInteractionSource, focusInteraction$Focus3);
            this.focusedInteraction = focusInteraction$Focus3;
        }
    }

    public final void update(MutableInteractionSource interactionSource) {
        if (Intrinsics.areEqual(this.interactionSource, interactionSource)) {
            return;
        }
        disposeInteractionSource();
        this.interactionSource = interactionSource;
    }
}
