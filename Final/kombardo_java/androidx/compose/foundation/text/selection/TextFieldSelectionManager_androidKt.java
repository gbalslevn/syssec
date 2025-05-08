package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.contextmenu.ContextMenuState_androidKt;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\n\u0010\u000b\"\u0018\u0010\u000e\u001a\u00020\r*\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012²\u0006\u000e\u0010\u0011\u001a\u00020\u00108\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "manager", "textFieldMagnifier", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "contextMenuState", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", BuildConfig.FLAVOR, "contextMenuBuilder", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/foundation/contextmenu/ContextMenuState;)Lkotlin/jvm/functions/Function1;", "Landroidx/compose/ui/input/pointer/PointerEvent;", BuildConfig.FLAVOR, "isShiftPressed", "(Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "Landroidx/compose/ui/unit/IntSize;", "magnifierSize", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TextFieldSelectionManager_androidKt {
    public static final Function1<ContextMenuScope, Unit> contextMenuBuilder(final TextFieldSelectionManager textFieldSelectionManager, final ContextMenuState contextMenuState) {
        return new Function1<ContextMenuScope, Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$contextMenuBuilder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContextMenuScope contextMenuScope) {
                invoke2(contextMenuScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContextMenuScope contextMenuScope) {
                ClipboardManager clipboardManager;
                boolean z5 = TextFieldSelectionManager.this.getVisualTransformation() instanceof PasswordVisualTransformation;
                boolean m2279getCollapsedimpl = TextRange.m2279getCollapsedimpl(TextFieldSelectionManager.this.getValue$foundation_release().getSelection());
                final ContextMenuState contextMenuState2 = contextMenuState;
                final TextContextMenuItems textContextMenuItems = TextContextMenuItems.Cut;
                boolean z6 = (m2279getCollapsedimpl || !TextFieldSelectionManager.this.getEditable() || z5) ? false : true;
                final TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                ContextMenuScope.item$default(contextMenuScope, new Function2<Composer, Integer, String>() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$TextItem$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ String invoke(Composer composer, Integer num) {
                        return invoke(composer, num.intValue());
                    }

                    public final String invoke(Composer composer, int i5) {
                        composer.startReplaceGroup(-1451087197);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1451087197, i5, -1, "androidx.compose.foundation.text.TextItem.<anonymous> (ContextMenu.android.kt:98)");
                        }
                        String resolvedString = TextContextMenuItems.this.resolvedString(composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer.endReplaceGroup();
                        return resolvedString;
                    }
                }, null, z6, null, new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        textFieldSelectionManager2.cut$foundation_release();
                        ContextMenuState_androidKt.close(ContextMenuState.this);
                    }
                }, 10, null);
                final ContextMenuState contextMenuState3 = contextMenuState;
                final TextContextMenuItems textContextMenuItems2 = TextContextMenuItems.Copy;
                boolean z7 = (m2279getCollapsedimpl || z5) ? false : true;
                final TextFieldSelectionManager textFieldSelectionManager3 = TextFieldSelectionManager.this;
                ContextMenuScope.item$default(contextMenuScope, new Function2<Composer, Integer, String>() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$TextItem$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ String invoke(Composer composer, Integer num) {
                        return invoke(composer, num.intValue());
                    }

                    public final String invoke(Composer composer, int i5) {
                        composer.startReplaceGroup(-1451087197);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1451087197, i5, -1, "androidx.compose.foundation.text.TextItem.<anonymous> (ContextMenu.android.kt:98)");
                        }
                        String resolvedString = TextContextMenuItems.this.resolvedString(composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer.endReplaceGroup();
                        return resolvedString;
                    }
                }, null, z7, null, new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        textFieldSelectionManager3.copy$foundation_release(false);
                        ContextMenuState_androidKt.close(ContextMenuState.this);
                    }
                }, 10, null);
                final ContextMenuState contextMenuState4 = contextMenuState;
                final TextContextMenuItems textContextMenuItems3 = TextContextMenuItems.Paste;
                boolean z8 = TextFieldSelectionManager.this.getEditable() && (clipboardManager = TextFieldSelectionManager.this.getClipboardManager()) != null && clipboardManager.hasText();
                final TextFieldSelectionManager textFieldSelectionManager4 = TextFieldSelectionManager.this;
                ContextMenuScope.item$default(contextMenuScope, new Function2<Composer, Integer, String>() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$TextItem$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ String invoke(Composer composer, Integer num) {
                        return invoke(composer, num.intValue());
                    }

                    public final String invoke(Composer composer, int i5) {
                        composer.startReplaceGroup(-1451087197);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1451087197, i5, -1, "androidx.compose.foundation.text.TextItem.<anonymous> (ContextMenu.android.kt:98)");
                        }
                        String resolvedString = TextContextMenuItems.this.resolvedString(composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer.endReplaceGroup();
                        return resolvedString;
                    }
                }, null, z8, null, new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        textFieldSelectionManager4.paste$foundation_release();
                        ContextMenuState_androidKt.close(ContextMenuState.this);
                    }
                }, 10, null);
                final ContextMenuState contextMenuState5 = contextMenuState;
                final TextContextMenuItems textContextMenuItems4 = TextContextMenuItems.SelectAll;
                boolean z9 = TextRange.m2281getLengthimpl(TextFieldSelectionManager.this.getValue$foundation_release().getSelection()) != TextFieldSelectionManager.this.getValue$foundation_release().getText().length();
                final TextFieldSelectionManager textFieldSelectionManager5 = TextFieldSelectionManager.this;
                ContextMenuScope.item$default(contextMenuScope, new Function2<Composer, Integer, String>() { // from class: androidx.compose.foundation.text.ContextMenu_androidKt$TextItem$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ String invoke(Composer composer, Integer num) {
                        return invoke(composer, num.intValue());
                    }

                    public final String invoke(Composer composer, int i5) {
                        composer.startReplaceGroup(-1451087197);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1451087197, i5, -1, "androidx.compose.foundation.text.TextItem.<anonymous> (ContextMenu.android.kt:98)");
                        }
                        String resolvedString = TextContextMenuItems.this.resolvedString(composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer.endReplaceGroup();
                        return resolvedString;
                    }
                }, null, z9, null, new Function0<Unit>() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$contextMenuBuilder$1$invoke$$inlined$TextItem$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        textFieldSelectionManager5.selectAll$foundation_release();
                        ContextMenuState_androidKt.close(ContextMenuState.this);
                    }
                }, 10, null);
            }
        };
    }

    public static final boolean isShiftPressed(PointerEvent pointerEvent) {
        return false;
    }

    public static final Modifier textFieldMagnifier(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager) {
        return !Magnifier_androidKt.isPlatformMagnifierSupported$default(0, 1, null) ? modifier : ComposedModifierKt.composed$default(modifier, null, new TextFieldSelectionManager_androidKt$textFieldMagnifier$1(textFieldSelectionManager), 1, null);
    }
}
