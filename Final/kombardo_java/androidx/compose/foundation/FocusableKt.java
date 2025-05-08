package androidx.compose.foundation;

import android.support.v4.media.session.a;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectableModifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004*\u0001\n\u001a)\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\"\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t\"\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/ui/Modifier;", BuildConfig.FLAVOR, "enabled", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "focusable", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/platform/InspectableModifier;", "focusGroupInspectorInfo", "Landroidx/compose/ui/platform/InspectableModifier;", "androidx/compose/foundation/FocusableKt$FocusableInNonTouchModeElement$1", "FocusableInNonTouchModeElement", "Landroidx/compose/foundation/FocusableKt$FocusableInNonTouchModeElement$1;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class FocusableKt {
    private static final FocusableKt$FocusableInNonTouchModeElement$1 FocusableInNonTouchModeElement;
    private static final InspectableModifier focusGroupInspectorInfo;

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.foundation.FocusableKt$FocusableInNonTouchModeElement$1] */
    static {
        focusGroupInspectorInfo = new InspectableModifier(InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.FocusableKt$special$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                a.a(inspectorInfo);
                invoke2((InspectorInfo) null);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                throw null;
            }
        } : InspectableValueKt.getNoInspectorInfo());
        FocusableInNonTouchModeElement = new ModifierNodeElement<FocusableInNonTouchMode>() { // from class: androidx.compose.foundation.FocusableKt$FocusableInNonTouchModeElement$1
            public boolean equals(Object other) {
                return this == other;
            }

            public int hashCode() {
                return Focusable_androidKt.identityHashCode(this);
            }

            @Override // androidx.compose.ui.node.ModifierNodeElement
            public void update(FocusableInNonTouchMode node) {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.compose.ui.node.ModifierNodeElement
            /* renamed from: create */
            public FocusableInNonTouchMode getNode() {
                return new FocusableInNonTouchMode();
            }
        };
    }

    public static final Modifier focusable(Modifier modifier, boolean z5, MutableInteractionSource mutableInteractionSource) {
        return modifier.then(z5 ? new FocusableElement(mutableInteractionSource) : Modifier.INSTANCE);
    }

    public static /* synthetic */ Modifier focusable$default(Modifier modifier, boolean z5, MutableInteractionSource mutableInteractionSource, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = true;
        }
        if ((i5 & 2) != 0) {
            mutableInteractionSource = null;
        }
        return focusable(modifier, z5, mutableInteractionSource);
    }
}
