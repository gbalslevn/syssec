package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u001d\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u001a\u0010\t\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u0012\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "LocalTextSelectionColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalTextSelectionColors", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/graphics/Color;", "DefaultSelectionColor", "J", "DefaultTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "getDefaultTextSelectionColors$annotations", "()V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TextSelectionColorsKt {
    private static final long DefaultSelectionColor;
    private static final SelectionColors DefaultTextSelectionColors;
    private static final ProvidableCompositionLocal<SelectionColors> LocalTextSelectionColors = CompositionLocalKt.compositionLocalOf$default(null, new Function0<SelectionColors>() { // from class: androidx.compose.foundation.text.selection.TextSelectionColorsKt$LocalTextSelectionColors$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SelectionColors invoke() {
            SelectionColors selectionColors;
            selectionColors = TextSelectionColorsKt.DefaultTextSelectionColors;
            return selectionColors;
        }
    }, 1, null);

    static {
        long Color = ColorKt.Color(4282550004L);
        DefaultSelectionColor = Color;
        DefaultTextSelectionColors = new SelectionColors(Color, Color.m1485copywmQWz5c$default(Color, 0.4f, 0.0f, 0.0f, 0.0f, 14, null), null);
    }

    public static final ProvidableCompositionLocal<SelectionColors> getLocalTextSelectionColors() {
        return LocalTextSelectionColors;
    }
}
