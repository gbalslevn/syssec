package androidx.compose.foundation.contextmenu;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\n\u0010\u0003JU\u0010\u0017\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0004\b\u0017\u0010\u0018R&\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00130\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuScope;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "colors", BuildConfig.FLAVOR, "Content$foundation_release", "(Landroidx/compose/foundation/contextmenu/ContextMenuColors;Landroidx/compose/runtime/Composer;I)V", "Content", "clear$foundation_release", "clear", "Lkotlin/Function0;", BuildConfig.FLAVOR, "label", "Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "enabled", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Color;", "leadingIcon", "onClick", "item", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "composables", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ContextMenuScope {
    private final SnapshotStateList<Function3<ContextMenuColors, Composer, Integer, Unit>> composables = SnapshotStateKt.mutableStateListOf();

    public static /* synthetic */ void item$default(ContextMenuScope contextMenuScope, Function2 function2, Modifier modifier, boolean z5, Function3 function3, Function0 function0, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            modifier = Modifier.INSTANCE;
        }
        Modifier modifier2 = modifier;
        if ((i5 & 4) != 0) {
            z5 = true;
        }
        boolean z6 = z5;
        if ((i5 & 8) != 0) {
            function3 = null;
        }
        contextMenuScope.item(function2, modifier2, z6, function3, function0);
    }

    public final void Content$foundation_release(final ContextMenuColors contextMenuColors, Composer composer, final int i5) {
        Composer startRestartGroup = composer.startRestartGroup(1320309496);
        int i6 = (i5 & 6) == 0 ? (startRestartGroup.changed(contextMenuColors) ? 4 : 2) | i5 : i5;
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(this) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1320309496, i6, -1, "androidx.compose.foundation.contextmenu.ContextMenuScope.Content (ContextMenuUi.android.kt:233)");
            }
            SnapshotStateList<Function3<ContextMenuColors, Composer, Integer, Unit>> snapshotStateList = this.composables;
            int size = snapshotStateList.size();
            for (int i7 = 0; i7 < size; i7++) {
                snapshotStateList.get(i7).invoke(contextMenuColors, startRestartGroup, Integer.valueOf(i6 & 14));
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuScope$Content$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i8) {
                    ContextMenuScope.this.Content$foundation_release(contextMenuColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    public final void clear$foundation_release() {
        this.composables.clear();
    }

    public final void item(final Function2<? super Composer, ? super Integer, String> label, final Modifier modifier, final boolean enabled, final Function3<? super Color, ? super Composer, ? super Integer, Unit> leadingIcon, final Function0<Unit> onClick) {
        this.composables.add(ComposableLambdaKt.composableLambdaInstance(262103052, true, new Function3<ContextMenuColors, Composer, Integer, Unit>() { // from class: androidx.compose.foundation.contextmenu.ContextMenuScope$item$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ContextMenuColors contextMenuColors, Composer composer, Integer num) {
                invoke(contextMenuColors, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ContextMenuColors contextMenuColors, Composer composer, int i5) {
                if ((i5 & 6) == 0) {
                    i5 |= composer.changed(contextMenuColors) ? 4 : 2;
                }
                if ((i5 & 19) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(262103052, i5, -1, "androidx.compose.foundation.contextmenu.ContextMenuScope.item.<anonymous> (ContextMenuUi.android.kt:275)");
                }
                String invoke = label.invoke(composer, 0);
                if (!StringsKt.isBlank(invoke)) {
                    ContextMenuUi_androidKt.ContextMenuItem(invoke, enabled, contextMenuColors, modifier, leadingIcon, onClick, composer, (i5 << 6) & 896, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("Label must not be blank");
            }
        }));
    }
}
