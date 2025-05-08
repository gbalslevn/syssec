package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.handwriting.StylusHandwritingKt;
import androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNodeKt;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter_androidKt;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.SelectionColors;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.SelectionHandleAnchor;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerIconKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteAllCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a×\u0001\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\u001a\b\u0002\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001c\u0012\u0004\u0012\u00020\u00030\u0002H\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a-\u0010#\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cH\u0003¢\u0006\u0004\b#\u0010$\u001a#\u0010'\u001a\u00020\u0005*\u00020\u00052\u0006\u0010&\u001a\u00020%2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b'\u0010(\u001a'\u0010,\u001a\u00020\u00032\u0006\u0010&\u001a\u00020%2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u0011H\u0002¢\u0006\u0004\b,\u0010-\u001a7\u00102\u001a\u00020\u00032\u0006\u0010/\u001a\u00020.2\u0006\u0010&\u001a\u00020%2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\b2\u00103\u001a\u0017\u00104\u001a\u00020\u00032\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b4\u00105\u001a4\u0010:\u001a\u00020\u0003*\u0002062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u000b2\u0006\u00101\u001a\u000200H\u0080@¢\u0006\u0004\b:\u0010;\u001a\u001f\u0010=\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 2\u0006\u0010<\u001a\u00020\u0011H\u0003¢\u0006\u0004\b=\u0010>\u001a\u0017\u0010?\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 H\u0001¢\u0006\u0004\b?\u0010@\u001a'\u0010A\u001a\u00020\u00032\u0006\u0010&\u001a\u00020%2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\bA\u0010B¨\u0006D²\u0006\f\u0010C\u001a\u00020\u00118\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/text/input/TextFieldValue;", "value", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onValueChange", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/text/TextStyle;", "textStyle", "Landroidx/compose/ui/text/input/VisualTransformation;", "visualTransformation", "Landroidx/compose/ui/text/TextLayoutResult;", "onTextLayout", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Landroidx/compose/ui/graphics/Brush;", "cursorBrush", BuildConfig.FLAVOR, "softWrap", BuildConfig.FLAVOR, "maxLines", "minLines", "Landroidx/compose/ui/text/input/ImeOptions;", "imeOptions", "Landroidx/compose/foundation/text/KeyboardActions;", "keyboardActions", "enabled", "readOnly", "Lkotlin/Function0;", "decorationBox", "CoreTextField", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZIILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "manager", "content", "CoreTextFieldRootBox", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "state", "previewKeyEventToDeselectOnBack", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;)Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/focus/FocusRequester;", "focusRequester", "allowKeyboard", "tapToFocus", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/ui/focus/FocusRequester;Z)V", "Landroidx/compose/ui/text/input/TextInputService;", "textInputService", "Landroidx/compose/ui/text/input/OffsetMapping;", "offsetMapping", "startInputSession", "(Landroidx/compose/ui/text/input/TextInputService;Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/ui/text/input/OffsetMapping;)V", "endInputSession", "(Landroidx/compose/foundation/text/LegacyTextFieldState;)V", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "Landroidx/compose/foundation/text/TextDelegate;", "textDelegate", "textLayoutResult", "bringSelectionEndIntoView", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "show", "SelectionToolbarAndHandles", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "notifyFocusedRect", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/OffsetMapping;)V", "writeable", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class CoreTextFieldKt {
    /* JADX WARN: Code restructure failed: missing block: B:103:0x03bc, code lost:
    
        if (r9 == r2.getEmpty()) goto L255;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0595  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x05a3  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0609 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0635  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0650  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x067d  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x069f  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x06c1  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0707  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0716  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0738  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x074f  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x075e  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x078d  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0798  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x07a5  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x07bc  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x07d0  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x07fd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0828  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x084c  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0854  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0868  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0890  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x08bd  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x08dc  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x092d  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0946  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x09b0  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x094d  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0893  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x084e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x07a7  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x079a  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x078f  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0751  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x073a  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0709  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x06af  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x06a1  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0647  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x05bf  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x05b1  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0597  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0587  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0577  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:424:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:445:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x09d5  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0393 A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r0v42, types: [androidx.compose.ui.Modifier] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CoreTextField(final TextFieldValue textFieldValue, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, TextStyle textStyle, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function12, MutableInteractionSource mutableInteractionSource, Brush brush, boolean z5, int i5, int i6, ImeOptions imeOptions, KeyboardActions keyboardActions, boolean z6, boolean z7, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i7, final int i8, final int i9) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        Modifier modifier2;
        Brush brush2;
        ImeOptions imeOptions2;
        boolean z8;
        Modifier modifier3;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function32;
        boolean z9;
        int i25;
        KeyboardActions keyboardActions2;
        Brush brush3;
        boolean z10;
        VisualTransformation visualTransformation2;
        Function1<? super TextLayoutResult, Unit> function13;
        int i26;
        ImeOptions imeOptions3;
        TextStyle textStyle2;
        MutableInteractionSource mutableInteractionSource2;
        Object rememberedValue;
        Composer.Companion companion;
        Object rememberedValue2;
        Object rememberedValue3;
        final WindowInfo windowInfo;
        boolean changed;
        MutableInteractionSource mutableInteractionSource3;
        boolean z11;
        Object rememberedValue4;
        TextRange composition;
        ImeOptions imeOptions4;
        boolean changed2;
        Object rememberedValue5;
        final LegacyTextFieldState legacyTextFieldState;
        Object rememberedValue6;
        Object rememberedValue7;
        Object rememberedValue8;
        Object rememberedValue9;
        int i27;
        final ImeOptions imeOptions5;
        int i28;
        int i29;
        boolean z12;
        boolean changedInstance;
        Object rememberedValue10;
        Modifier textFieldFocusModifier;
        Modifier modifier4;
        boolean z13;
        boolean z14;
        Object rememberedValue11;
        boolean changedInstance2;
        Object rememberedValue12;
        boolean changedInstance3;
        Object rememberedValue13;
        boolean changedInstance4;
        Object rememberedValue14;
        boolean changedInstance5;
        Object rememberedValue15;
        boolean changedInstance6;
        Object rememberedValue16;
        boolean changedInstance7;
        Object rememberedValue17;
        boolean changedInstance8;
        Object rememberedValue18;
        boolean changedInstance9;
        Object rememberedValue19;
        Composer composer2;
        final TextStyle textStyle3;
        final Function1<? super TextLayoutResult, Unit> function14;
        final VisualTransformation visualTransformation3;
        final Modifier modifier5;
        final Brush brush4;
        final boolean z15;
        final int i30;
        final boolean z16;
        final KeyboardActions keyboardActions3;
        final ImeOptions imeOptions6;
        final int i31;
        final MutableInteractionSource mutableInteractionSource4;
        final boolean z17;
        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function33;
        ScopeUpdateScope endRestartGroup;
        int i32;
        Composer startRestartGroup = composer.startRestartGroup(-958708118);
        if ((i9 & 1) != 0) {
            i10 = i7 | 6;
        } else if ((i7 & 6) == 0) {
            i10 = (startRestartGroup.changed(textFieldValue) ? 4 : 2) | i7;
        } else {
            i10 = i7;
        }
        if ((i9 & 2) != 0) {
            i10 |= 48;
        } else if ((i7 & 48) == 0) {
            i10 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i33 = i9 & 4;
        if (i33 != 0) {
            i10 |= 384;
        } else if ((i7 & 384) == 0) {
            i10 |= startRestartGroup.changed(modifier) ? 256 : 128;
            i11 = i9 & 8;
            if (i11 == 0) {
                i10 |= 3072;
            } else if ((i7 & 3072) == 0) {
                i10 |= startRestartGroup.changed(textStyle) ? 2048 : 1024;
                i12 = i9 & 16;
                if (i12 != 0) {
                    i10 |= 24576;
                } else if ((i7 & 24576) == 0) {
                    i10 |= startRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                    i13 = i9 & 32;
                    if (i13 == 0) {
                        i10 |= 196608;
                    } else if ((i7 & 196608) == 0) {
                        i10 |= startRestartGroup.changedInstance(function12) ? 131072 : 65536;
                    }
                    i14 = i9 & 64;
                    if (i14 == 0) {
                        i10 |= 1572864;
                    } else if ((i7 & 1572864) == 0) {
                        i10 |= startRestartGroup.changed(mutableInteractionSource) ? 1048576 : 524288;
                    }
                    i15 = i9 & 128;
                    if (i15 == 0) {
                        i10 |= 12582912;
                    } else if ((i7 & 12582912) == 0) {
                        i10 |= startRestartGroup.changed(brush) ? 8388608 : 4194304;
                    }
                    i16 = i9 & 256;
                    if (i16 == 0) {
                        i10 |= 100663296;
                    } else if ((i7 & 100663296) == 0) {
                        i10 |= startRestartGroup.changed(z5) ? 67108864 : 33554432;
                    }
                    i17 = i9 & 512;
                    if (i17 == 0) {
                        i10 |= 805306368;
                    } else if ((i7 & 805306368) == 0) {
                        i10 |= startRestartGroup.changed(i5) ? 536870912 : 268435456;
                    }
                    i18 = i9 & 1024;
                    if (i18 == 0) {
                        i19 = i8 | 6;
                    } else if ((i8 & 6) == 0) {
                        i19 = i8 | (startRestartGroup.changed(i6) ? 4 : 2);
                    } else {
                        i19 = i8;
                    }
                    if ((i8 & 48) == 0) {
                        if ((i9 & 2048) == 0 && startRestartGroup.changed(imeOptions)) {
                            i32 = 32;
                            i19 |= i32;
                        }
                        i32 = 16;
                        i19 |= i32;
                    }
                    i20 = i19;
                    i21 = i9 & 4096;
                    if (i21 == 0) {
                        i20 |= 384;
                    } else if ((i8 & 384) == 0) {
                        i20 |= startRestartGroup.changed(keyboardActions) ? 256 : 128;
                        i22 = i9 & 8192;
                        if (i22 != 0) {
                            i20 |= 3072;
                        } else if ((i8 & 3072) == 0) {
                            i20 |= startRestartGroup.changed(z6) ? 2048 : 1024;
                            i23 = i9 & 16384;
                            if (i23 == 0) {
                                i20 |= 24576;
                            } else if ((i8 & 24576) == 0) {
                                i20 |= startRestartGroup.changed(z7) ? 16384 : 8192;
                                i24 = i9 & 32768;
                                if (i24 != 0) {
                                    i20 |= 196608;
                                } else if ((i8 & 196608) == 0) {
                                    i20 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
                                }
                                if ((i10 & 306783379) != 306783378 && (74899 & i20) == 74898 && startRestartGroup.getSkipping()) {
                                    startRestartGroup.skipToGroupEnd();
                                    modifier5 = modifier;
                                    textStyle3 = textStyle;
                                    visualTransformation3 = visualTransformation;
                                    function14 = function12;
                                    mutableInteractionSource4 = mutableInteractionSource;
                                    brush4 = brush;
                                    z15 = z5;
                                    i31 = i5;
                                    imeOptions6 = imeOptions;
                                    keyboardActions3 = keyboardActions;
                                    z16 = z6;
                                    z17 = z7;
                                    function33 = function3;
                                    composer2 = startRestartGroup;
                                    i30 = i6;
                                } else {
                                    startRestartGroup.startDefaults();
                                    if ((i7 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                        Modifier modifier6 = i33 != 0 ? Modifier.INSTANCE : modifier;
                                        TextStyle textStyle4 = i11 != 0 ? TextStyle.INSTANCE.getDefault() : textStyle;
                                        VisualTransformation none = i12 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                        Function1<? super TextLayoutResult, Unit> function15 = i13 != 0 ? new Function1<TextLayoutResult, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$1
                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(TextLayoutResult textLayoutResult) {
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(TextLayoutResult textLayoutResult) {
                                                invoke2(textLayoutResult);
                                                return Unit.INSTANCE;
                                            }
                                        } : function12;
                                        MutableInteractionSource mutableInteractionSource5 = i14 != 0 ? null : mutableInteractionSource;
                                        if (i15 != 0) {
                                            modifier2 = modifier6;
                                            brush2 = new SolidColor(Color.INSTANCE.m1501getUnspecified0d7_KjU(), null);
                                        } else {
                                            modifier2 = modifier6;
                                            brush2 = brush;
                                        }
                                        boolean z18 = i16 != 0 ? true : z5;
                                        int i34 = i17 != 0 ? Integer.MAX_VALUE : i5;
                                        int i35 = i18 != 0 ? 1 : i6;
                                        if ((i9 & 2048) != 0) {
                                            imeOptions2 = ImeOptions.INSTANCE.getDefault();
                                            i20 &= -113;
                                        } else {
                                            imeOptions2 = imeOptions;
                                        }
                                        KeyboardActions keyboardActions4 = i21 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                        z8 = i22 != 0 ? true : z6;
                                        boolean z19 = i23 != 0 ? false : z7;
                                        if (i24 != 0) {
                                            modifier3 = modifier2;
                                            z9 = z18;
                                            i25 = i35;
                                            keyboardActions2 = keyboardActions4;
                                            brush3 = brush2;
                                            z10 = z19;
                                            function32 = ComposableSingletons$CoreTextFieldKt.INSTANCE.m472getLambda1$foundation_release();
                                        } else {
                                            modifier3 = modifier2;
                                            function32 = function3;
                                            z9 = z18;
                                            i25 = i35;
                                            keyboardActions2 = keyboardActions4;
                                            brush3 = brush2;
                                            z10 = z19;
                                        }
                                        visualTransformation2 = none;
                                        function13 = function15;
                                        i26 = i34;
                                        imeOptions3 = imeOptions2;
                                        MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5;
                                        textStyle2 = textStyle4;
                                        mutableInteractionSource2 = mutableInteractionSource6;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i9 & 2048) != 0) {
                                            i20 &= -113;
                                        }
                                        modifier3 = modifier;
                                        textStyle2 = textStyle;
                                        visualTransformation2 = visualTransformation;
                                        function13 = function12;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        brush3 = brush;
                                        z9 = z5;
                                        i26 = i5;
                                        i25 = i6;
                                        imeOptions3 = imeOptions;
                                        keyboardActions2 = keyboardActions;
                                        z8 = z6;
                                        z10 = z7;
                                        function32 = function3;
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-958708118, i10, i20, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:220)");
                                    }
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    companion = Composer.INSTANCE;
                                    if (rememberedValue == companion.getEmpty()) {
                                        rememberedValue = new FocusRequester();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    final FocusRequester focusRequester = (FocusRequester) rememberedValue;
                                    rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (rememberedValue2 == companion.getEmpty()) {
                                        rememberedValue2 = LegacyPlatformTextInputServiceAdapter_androidKt.createLegacyPlatformTextInputServiceAdapter();
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    final LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter = (LegacyPlatformTextInputServiceAdapter) rememberedValue2;
                                    rememberedValue3 = startRestartGroup.rememberedValue();
                                    if (rememberedValue3 == companion.getEmpty()) {
                                        rememberedValue3 = new TextInputService(legacyPlatformTextInputServiceAdapter);
                                        startRestartGroup.updateRememberedValue(rememberedValue3);
                                    }
                                    final TextInputService textInputService = (TextInputService) rememberedValue3;
                                    final Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                                    FontFamily.Resolver resolver = (FontFamily.Resolver) startRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                                    long selectionBackgroundColor = ((SelectionColors) startRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).getSelectionBackgroundColor();
                                    FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                                    Modifier modifier7 = modifier3;
                                    windowInfo = (WindowInfo) startRestartGroup.consume(CompositionLocalsKt.getLocalWindowInfo());
                                    SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) startRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                                    final Orientation orientation = (i26 == 1 || z9 || !imeOptions3.getSingleLine()) ? Orientation.Vertical : Orientation.Horizontal;
                                    Object[] objArr = {orientation};
                                    Saver<TextFieldScrollerPosition, Object> saver = TextFieldScrollerPosition.INSTANCE.getSaver();
                                    changed = startRestartGroup.changed(orientation);
                                    final int i36 = i26;
                                    Object rememberedValue20 = startRestartGroup.rememberedValue();
                                    if (changed) {
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                    }
                                    rememberedValue20 = new Function0<TextFieldScrollerPosition>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final TextFieldScrollerPosition invoke() {
                                            return new TextFieldScrollerPosition(Orientation.this, 0.0f, 2, null);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue20);
                                    final TextFieldScrollerPosition textFieldScrollerPosition = (TextFieldScrollerPosition) RememberSaveableKt.rememberSaveable(objArr, saver, null, (Function0) rememberedValue20, startRestartGroup, 0, 4);
                                    int i37 = i10 & 14;
                                    z11 = ((i10 & 57344) == 16384) | (i37 == 4);
                                    rememberedValue4 = startRestartGroup.rememberedValue();
                                    if (!z11 || rememberedValue4 == companion.getEmpty()) {
                                        TransformedText filterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation2, textFieldValue.getText());
                                        composition = textFieldValue.getComposition();
                                        if (composition != null) {
                                            imeOptions4 = imeOptions3;
                                            TransformedText m529applyCompositionDecoration72CqOWE = TextFieldDelegate.INSTANCE.m529applyCompositionDecoration72CqOWE(composition.getPackedValue(), filterWithValidation);
                                            if (m529applyCompositionDecoration72CqOWE != null) {
                                                rememberedValue4 = m529applyCompositionDecoration72CqOWE;
                                                startRestartGroup.updateRememberedValue(rememberedValue4);
                                            }
                                        } else {
                                            imeOptions4 = imeOptions3;
                                        }
                                        rememberedValue4 = filterWithValidation;
                                        startRestartGroup.updateRememberedValue(rememberedValue4);
                                    } else {
                                        imeOptions4 = imeOptions3;
                                    }
                                    final TransformedText transformedText = (TransformedText) rememberedValue4;
                                    AnnotatedString text = transformedText.getText();
                                    final OffsetMapping offsetMapping = transformedText.getOffsetMapping();
                                    RecomposeScope currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(startRestartGroup, 0);
                                    changed2 = startRestartGroup.changed(softwareKeyboardController);
                                    rememberedValue5 = startRestartGroup.rememberedValue();
                                    if (!changed2 || rememberedValue5 == companion.getEmpty()) {
                                        rememberedValue5 = new LegacyTextFieldState(new TextDelegate(text, textStyle2, 0, 0, z9, 0, density, resolver, null, 300, null), currentRecomposeScope, softwareKeyboardController);
                                        startRestartGroup.updateRememberedValue(rememberedValue5);
                                    }
                                    legacyTextFieldState = (LegacyTextFieldState) rememberedValue5;
                                    legacyTextFieldState.m492updatefnh65Uc(textFieldValue.getText(), text, textStyle2, z9, density, resolver, function1, keyboardActions2, focusManager, selectionBackgroundColor);
                                    legacyTextFieldState.getProcessor().reset(textFieldValue, legacyTextFieldState.getInputSession());
                                    rememberedValue6 = startRestartGroup.rememberedValue();
                                    if (rememberedValue6 == companion.getEmpty()) {
                                        rememberedValue6 = new UndoManager(0, 1, null);
                                        startRestartGroup.updateRememberedValue(rememberedValue6);
                                    }
                                    UndoManager undoManager = (UndoManager) rememberedValue6;
                                    UndoManager.snapshotIfNeeded$default(undoManager, textFieldValue, 0L, 2, null);
                                    rememberedValue7 = startRestartGroup.rememberedValue();
                                    if (rememberedValue7 == companion.getEmpty()) {
                                        rememberedValue7 = new TextFieldSelectionManager(undoManager);
                                        startRestartGroup.updateRememberedValue(rememberedValue7);
                                    }
                                    final TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) rememberedValue7;
                                    textFieldSelectionManager.setOffsetMapping$foundation_release(offsetMapping);
                                    textFieldSelectionManager.setVisualTransformation$foundation_release(visualTransformation2);
                                    textFieldSelectionManager.setOnValueChange$foundation_release(legacyTextFieldState.getOnValueChange());
                                    textFieldSelectionManager.setState$foundation_release(legacyTextFieldState);
                                    textFieldSelectionManager.setValue$foundation_release(textFieldValue);
                                    textFieldSelectionManager.setClipboardManager$foundation_release((ClipboardManager) startRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
                                    textFieldSelectionManager.setTextToolbar((TextToolbar) startRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
                                    textFieldSelectionManager.setHapticFeedBack((HapticFeedback) startRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
                                    textFieldSelectionManager.setFocusRequester(focusRequester);
                                    textFieldSelectionManager.setEditable(!z10);
                                    textFieldSelectionManager.setEnabled(z8);
                                    rememberedValue8 = startRestartGroup.rememberedValue();
                                    if (rememberedValue8 == companion.getEmpty()) {
                                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                                        startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                        rememberedValue8 = compositionScopedCoroutineScopeCanceller;
                                    }
                                    final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue8).getCoroutineScope();
                                    rememberedValue9 = startRestartGroup.rememberedValue();
                                    if (rememberedValue9 == companion.getEmpty()) {
                                        rememberedValue9 = BringIntoViewRequesterKt.BringIntoViewRequester();
                                        startRestartGroup.updateRememberedValue(rememberedValue9);
                                    }
                                    final BringIntoViewRequester bringIntoViewRequester = (BringIntoViewRequester) rememberedValue9;
                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                    int i38 = i20 & 7168;
                                    final VisualTransformation visualTransformation4 = visualTransformation2;
                                    int i39 = i20 & 57344;
                                    boolean changedInstance10 = startRestartGroup.changedInstance(legacyTextFieldState) | (i38 == 2048) | (i39 == 16384) | startRestartGroup.changedInstance(textInputService) | (i37 == 4);
                                    i27 = (i20 & 112) ^ 48;
                                    if (i27 > 32) {
                                        imeOptions5 = imeOptions4;
                                        if (startRestartGroup.changed(imeOptions5)) {
                                            i29 = i20;
                                            i28 = i39;
                                            z12 = true;
                                            changedInstance = changedInstance10 | z12 | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(bringIntoViewRequester) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                            rememberedValue10 = startRestartGroup.rememberedValue();
                                            if (!changedInstance || rememberedValue10 == companion.getEmpty()) {
                                                final boolean z20 = z8;
                                                final boolean z21 = z10;
                                                final ImeOptions imeOptions7 = imeOptions5;
                                                rememberedValue10 = new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                                                        invoke2(focusState);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(FocusState focusState) {
                                                        TextLayoutResultProxy layoutResult;
                                                        if (LegacyTextFieldState.this.getHasFocus() == focusState.isFocused()) {
                                                            return;
                                                        }
                                                        LegacyTextFieldState.this.setHasFocus(focusState.isFocused());
                                                        if (LegacyTextFieldState.this.getHasFocus() && z20 && !z21) {
                                                            CoreTextFieldKt.startInputSession(textInputService, LegacyTextFieldState.this, textFieldValue, imeOptions7, offsetMapping);
                                                        } else {
                                                            CoreTextFieldKt.endInputSession(LegacyTextFieldState.this);
                                                        }
                                                        if (focusState.isFocused() && (layoutResult = LegacyTextFieldState.this.getLayoutResult()) != null) {
                                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(bringIntoViewRequester, textFieldValue, LegacyTextFieldState.this, layoutResult, offsetMapping, null), 3, null);
                                                        }
                                                        if (focusState.isFocused()) {
                                                            return;
                                                        }
                                                        TextFieldSelectionManager.m640deselect_kEHs6E$foundation_release$default(textFieldSelectionManager, null, 1, null);
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue10);
                                            }
                                            MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource3;
                                            textFieldFocusModifier = TextFieldGestureModifiersKt.textFieldFocusModifier(companion2, z8, focusRequester, mutableInteractionSource7, (Function1) rememberedValue10);
                                            State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf((z8 || z10) ? false : true), startRestartGroup, 0);
                                            Unit unit = Unit.INSTANCE;
                                            boolean changed3 = startRestartGroup.changed(rememberUpdatedState) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                            if (i27 > 32 || !startRestartGroup.changed(imeOptions5)) {
                                                modifier4 = textFieldFocusModifier;
                                                if ((i29 & 48) != 32) {
                                                    z13 = false;
                                                    z14 = changed3 | z13;
                                                    rememberedValue11 = startRestartGroup.rememberedValue();
                                                    if (!z14 || rememberedValue11 == companion.getEmpty()) {
                                                        rememberedValue11 = new CoreTextFieldKt$CoreTextField$2$1(legacyTextFieldState, rememberUpdatedState, textInputService, textFieldSelectionManager, imeOptions5, null);
                                                        startRestartGroup.updateRememberedValue(rememberedValue11);
                                                    }
                                                    EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue11, startRestartGroup, 6);
                                                    changedInstance2 = startRestartGroup.changedInstance(legacyTextFieldState);
                                                    rememberedValue12 = startRestartGroup.rememberedValue();
                                                    if (!changedInstance2 || rememberedValue12 == companion.getEmpty()) {
                                                        rememberedValue12 = new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1$1
                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                                                invoke(bool.booleanValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            public final void invoke(boolean z22) {
                                                                LegacyTextFieldState.this.setInTouchMode(z22);
                                                            }
                                                        };
                                                        startRestartGroup.updateRememberedValue(rememberedValue12);
                                                    }
                                                    Modifier updateSelectionTouchMode = SelectionGesturesKt.updateSelectionTouchMode(companion2, (Function1) rememberedValue12);
                                                    int i40 = i28;
                                                    changedInstance3 = startRestartGroup.changedInstance(legacyTextFieldState) | (i40 != 16384) | (i38 != 2048) | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                                    rememberedValue13 = startRestartGroup.rememberedValue();
                                                    if (!changedInstance3 || rememberedValue13 == companion.getEmpty()) {
                                                        final boolean z22 = z10;
                                                        final boolean z23 = z8;
                                                        rememberedValue13 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2$1
                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                                                m473invokek4lQ0M(offset.getPackedValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                                                            public final void m473invokek4lQ0M(long j5) {
                                                                CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester, !z22);
                                                                if (LegacyTextFieldState.this.getHasFocus() && z23) {
                                                                    if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                                                                        textFieldSelectionManager.m643deselect_kEHs6E$foundation_release(Offset.m1328boximpl(j5));
                                                                        return;
                                                                    }
                                                                    TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                                    if (layoutResult != null) {
                                                                        LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                                                        TextFieldDelegate.INSTANCE.m532setCursorOffsetULxng0E$foundation_release(j5, layoutResult, legacyTextFieldState2.getProcessor(), offsetMapping, legacyTextFieldState2.getOnValueChange());
                                                                        if (legacyTextFieldState2.getTextDelegate().getText().length() > 0) {
                                                                            legacyTextFieldState2.setHandleState(HandleState.Cursor);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        };
                                                        startRestartGroup.updateRememberedValue(rememberedValue13);
                                                    }
                                                    Modifier pointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(updateSelectionTouchMode, mutableInteractionSource7, z8, (Function1) rememberedValue13), textFieldSelectionManager.getMouseSelectionObserver(), textFieldSelectionManager.getTouchSelectionObserver()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                                                    changedInstance4 = startRestartGroup.changedInstance(legacyTextFieldState) | (i37 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                                    rememberedValue14 = startRestartGroup.rememberedValue();
                                                    if (!changedInstance4 || rememberedValue14 == companion.getEmpty()) {
                                                        rememberedValue14 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1$1
                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                                                invoke2(drawScope);
                                                                return Unit.INSTANCE;
                                                            }

                                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                            public final void invoke2(DrawScope drawScope) {
                                                                TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                                if (layoutResult != null) {
                                                                    TextFieldValue textFieldValue2 = textFieldValue;
                                                                    LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                                                    OffsetMapping offsetMapping2 = offsetMapping;
                                                                    TextFieldDelegate.INSTANCE.m530drawQ1vqE60$foundation_release(drawScope.getDrawContext().getCanvas(), textFieldValue2, legacyTextFieldState2.m488getSelectionPreviewHighlightRanged9O1mEE(), legacyTextFieldState2.m485getDeletionPreviewHighlightRanged9O1mEE(), offsetMapping2, layoutResult.getValue(), legacyTextFieldState2.getHighlightPaint(), legacyTextFieldState2.getSelectionBackgroundColor());
                                                                }
                                                            }
                                                        };
                                                        startRestartGroup.updateRememberedValue(rememberedValue14);
                                                    }
                                                    final Modifier drawBehind = DrawModifierKt.drawBehind(companion2, (Function1) rememberedValue14);
                                                    changedInstance5 = startRestartGroup.changedInstance(legacyTextFieldState) | (i38 != 2048) | startRestartGroup.changed(windowInfo) | startRestartGroup.changedInstance(textFieldSelectionManager) | (i37 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                                    rememberedValue15 = startRestartGroup.rememberedValue();
                                                    if (!changedInstance5 || rememberedValue15 == companion.getEmpty()) {
                                                        final boolean z24 = z8;
                                                        rememberedValue15 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1$1
                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                                                invoke2(layoutCoordinates);
                                                                return Unit.INSTANCE;
                                                            }

                                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                            public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                                                LegacyTextFieldState.this.setLayoutCoordinates(layoutCoordinates);
                                                                TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                                if (layoutResult != null) {
                                                                    layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
                                                                }
                                                                if (z24) {
                                                                    if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                                                                        if (LegacyTextFieldState.this.getShowFloatingToolbar() && windowInfo.isWindowFocused()) {
                                                                            textFieldSelectionManager.showSelectionToolbar$foundation_release();
                                                                        } else {
                                                                            textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                                                                        }
                                                                        LegacyTextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true));
                                                                        LegacyTextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, false));
                                                                        LegacyTextFieldState.this.setShowCursorHandle(TextRange.m2279getCollapsedimpl(textFieldValue.getSelection()));
                                                                    } else if (LegacyTextFieldState.this.getHandleState() == HandleState.Cursor) {
                                                                        LegacyTextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true));
                                                                    }
                                                                    CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue, offsetMapping);
                                                                    TextLayoutResultProxy layoutResult2 = LegacyTextFieldState.this.getLayoutResult();
                                                                    if (layoutResult2 != null) {
                                                                        LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                                                        TextFieldValue textFieldValue2 = textFieldValue;
                                                                        OffsetMapping offsetMapping2 = offsetMapping;
                                                                        TextInputSession inputSession = legacyTextFieldState2.getInputSession();
                                                                        if (inputSession == null || !legacyTextFieldState2.getHasFocus()) {
                                                                            return;
                                                                        }
                                                                        TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation_release(inputSession, textFieldValue2, offsetMapping2, layoutResult2);
                                                                    }
                                                                }
                                                            }
                                                        };
                                                        startRestartGroup.updateRememberedValue(rememberedValue15);
                                                    }
                                                    final Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) rememberedValue15);
                                                    final boolean z25 = visualTransformation4 instanceof PasswordVisualTransformation;
                                                    changedInstance6 = (i38 != 2048) | startRestartGroup.changedInstance(transformedText) | (i37 != 4) | startRestartGroup.changed(z25) | (i40 != 16384) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(textFieldSelectionManager) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32);
                                                    rememberedValue16 = startRestartGroup.rememberedValue();
                                                    if (!changedInstance6 || rememberedValue16 == companion.getEmpty()) {
                                                        final boolean z26 = z8;
                                                        final boolean z27 = z10;
                                                        final ImeOptions imeOptions8 = imeOptions5;
                                                        rememberedValue16 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1
                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                                invoke2(semanticsPropertyReceiver);
                                                                return Unit.INSTANCE;
                                                            }

                                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                            public final void invoke2(final SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                                SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, TransformedText.this.getText());
                                                                SemanticsPropertiesKt.m2185setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, textFieldValue.getSelection());
                                                                if (!z26) {
                                                                    SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                                                                }
                                                                if (z25) {
                                                                    SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                                                                }
                                                                boolean z28 = z26 && !z27;
                                                                SemanticsPropertiesKt.setEditable(semanticsPropertyReceiver, z28);
                                                                final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                                                                SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Boolean invoke(List<TextLayoutResult> list) {
                                                                        boolean z29;
                                                                        if (LegacyTextFieldState.this.getLayoutResult() != null) {
                                                                            TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                                            Intrinsics.checkNotNull(layoutResult);
                                                                            list.add(layoutResult.getValue());
                                                                            z29 = true;
                                                                        } else {
                                                                            z29 = false;
                                                                        }
                                                                        return Boolean.valueOf(z29);
                                                                    }
                                                                }, 1, null);
                                                                if (z28) {
                                                                    final LegacyTextFieldState legacyTextFieldState3 = legacyTextFieldState;
                                                                    SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.2
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Boolean invoke(AnnotatedString annotatedString) {
                                                                            Unit unit2;
                                                                            TextInputSession inputSession = LegacyTextFieldState.this.getInputSession();
                                                                            if (inputSession != null) {
                                                                                LegacyTextFieldState legacyTextFieldState4 = LegacyTextFieldState.this;
                                                                                TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(annotatedString, 1)}), legacyTextFieldState4.getProcessor(), legacyTextFieldState4.getOnValueChange(), inputSession);
                                                                                unit2 = Unit.INSTANCE;
                                                                            } else {
                                                                                unit2 = null;
                                                                            }
                                                                            if (unit2 == null) {
                                                                                LegacyTextFieldState.this.getOnValueChange().invoke(new TextFieldValue(annotatedString.getText(), TextRangeKt.TextRange(annotatedString.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                                            }
                                                                            return Boolean.TRUE;
                                                                        }
                                                                    }, 1, null);
                                                                    final boolean z29 = z27;
                                                                    final boolean z30 = z26;
                                                                    final LegacyTextFieldState legacyTextFieldState4 = legacyTextFieldState;
                                                                    final TextFieldValue textFieldValue2 = textFieldValue;
                                                                    SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.3
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Boolean invoke(AnnotatedString annotatedString) {
                                                                            Unit unit2;
                                                                            if (!z29 && z30) {
                                                                                TextInputSession inputSession = legacyTextFieldState4.getInputSession();
                                                                                if (inputSession != null) {
                                                                                    LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                                                                    TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(annotatedString, 1)}), legacyTextFieldState5.getProcessor(), legacyTextFieldState5.getOnValueChange(), inputSession);
                                                                                    unit2 = Unit.INSTANCE;
                                                                                } else {
                                                                                    unit2 = null;
                                                                                }
                                                                                if (unit2 == null) {
                                                                                    TextFieldValue textFieldValue3 = textFieldValue2;
                                                                                    legacyTextFieldState4.getOnValueChange().invoke(new TextFieldValue(StringsKt.replaceRange(textFieldValue3.getText(), TextRange.m2285getStartimpl(textFieldValue3.getSelection()), TextRange.m2280getEndimpl(textFieldValue3.getSelection()), annotatedString).toString(), TextRangeKt.TextRange(TextRange.m2285getStartimpl(textFieldValue3.getSelection()) + annotatedString.length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                                                }
                                                                                return Boolean.TRUE;
                                                                            }
                                                                            return Boolean.FALSE;
                                                                        }
                                                                    }, 1, null);
                                                                }
                                                                final OffsetMapping offsetMapping2 = offsetMapping;
                                                                final boolean z31 = z26;
                                                                final TextFieldValue textFieldValue3 = textFieldValue;
                                                                final TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                                                final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState;
                                                                SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.4
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(3);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function3
                                                                    public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                                                                        return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                                                                    }

                                                                    public final Boolean invoke(int i41, int i42, boolean z32) {
                                                                        if (!z32) {
                                                                            i41 = OffsetMapping.this.transformedToOriginal(i41);
                                                                        }
                                                                        if (!z32) {
                                                                            i42 = OffsetMapping.this.transformedToOriginal(i42);
                                                                        }
                                                                        boolean z33 = false;
                                                                        if (z31 && (i41 != TextRange.m2285getStartimpl(textFieldValue3.getSelection()) || i42 != TextRange.m2280getEndimpl(textFieldValue3.getSelection()))) {
                                                                            if (Math.min(i41, i42) >= 0 && Math.max(i41, i42) <= textFieldValue3.getText().length()) {
                                                                                if (!z32 && i41 != i42) {
                                                                                    TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager2, false, 1, null);
                                                                                } else {
                                                                                    textFieldSelectionManager2.exitSelectionMode$foundation_release();
                                                                                }
                                                                                legacyTextFieldState5.getOnValueChange().invoke(new TextFieldValue(textFieldValue3.getText(), TextRangeKt.TextRange(i41, i42), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                                                z33 = true;
                                                                            } else {
                                                                                textFieldSelectionManager2.exitSelectionMode$foundation_release();
                                                                            }
                                                                        }
                                                                        return Boolean.valueOf(z33);
                                                                    }
                                                                }, 1, null);
                                                                int imeAction = imeOptions8.getImeAction();
                                                                final LegacyTextFieldState legacyTextFieldState6 = legacyTextFieldState;
                                                                final ImeOptions imeOptions9 = imeOptions8;
                                                                SemanticsPropertiesKt.m2182onImeAction9UiTYpY$default(semanticsPropertyReceiver, imeAction, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.5
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Boolean invoke() {
                                                                        LegacyTextFieldState.this.getOnImeActionPerformed().invoke(ImeAction.m2375boximpl(imeOptions9.getImeAction()));
                                                                        return Boolean.TRUE;
                                                                    }
                                                                }, 2, null);
                                                                final LegacyTextFieldState legacyTextFieldState7 = legacyTextFieldState;
                                                                final FocusRequester focusRequester2 = focusRequester;
                                                                final boolean z32 = z27;
                                                                SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.6
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Boolean invoke() {
                                                                        CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester2, !z32);
                                                                        return Boolean.TRUE;
                                                                    }
                                                                }, 1, null);
                                                                final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager;
                                                                SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.7
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Boolean invoke() {
                                                                        TextFieldSelectionManager.enterSelectionMode$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                                                        return Boolean.TRUE;
                                                                    }
                                                                }, 1, null);
                                                                if (!TextRange.m2279getCollapsedimpl(textFieldValue.getSelection()) && !z25) {
                                                                    final TextFieldSelectionManager textFieldSelectionManager4 = textFieldSelectionManager;
                                                                    SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.8
                                                                        {
                                                                            super(0);
                                                                        }

                                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                                        @Override // kotlin.jvm.functions.Function0
                                                                        public final Boolean invoke() {
                                                                            TextFieldSelectionManager.copy$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                                                            return Boolean.TRUE;
                                                                        }
                                                                    }, 1, null);
                                                                    if (z26 && !z27) {
                                                                        final TextFieldSelectionManager textFieldSelectionManager5 = textFieldSelectionManager;
                                                                        SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.9
                                                                            {
                                                                                super(0);
                                                                            }

                                                                            /* JADX WARN: Can't rename method to resolve collision */
                                                                            @Override // kotlin.jvm.functions.Function0
                                                                            public final Boolean invoke() {
                                                                                TextFieldSelectionManager.this.cut$foundation_release();
                                                                                return Boolean.TRUE;
                                                                            }
                                                                        }, 1, null);
                                                                    }
                                                                }
                                                                if (!z26 || z27) {
                                                                    return;
                                                                }
                                                                final TextFieldSelectionManager textFieldSelectionManager6 = textFieldSelectionManager;
                                                                SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.10
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Boolean invoke() {
                                                                        TextFieldSelectionManager.this.paste$foundation_release();
                                                                        return Boolean.TRUE;
                                                                    }
                                                                }, 1, null);
                                                            }
                                                        };
                                                        startRestartGroup.updateRememberedValue(rememberedValue16);
                                                    }
                                                    Modifier semantics = SemanticsModifierKt.semantics(companion2, true, (Function1) rememberedValue16);
                                                    final Modifier cursor = TextFieldCursorKt.cursor(companion2, legacyTextFieldState, textFieldValue, offsetMapping, brush3, (z8 || z10 || !windowInfo.isWindowFocused() || legacyTextFieldState.hasHighlight()) ? false : true);
                                                    changedInstance7 = startRestartGroup.changedInstance(textFieldSelectionManager);
                                                    rememberedValue17 = startRestartGroup.rememberedValue();
                                                    if (!changedInstance7 || rememberedValue17 == companion.getEmpty()) {
                                                        rememberedValue17 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1
                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                                                final TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                                                                return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1$invoke$$inlined$onDispose$1
                                                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                                                    public void dispose() {
                                                                        TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                                                                    }
                                                                };
                                                            }
                                                        };
                                                        startRestartGroup.updateRememberedValue(rememberedValue17);
                                                    }
                                                    EffectsKt.DisposableEffect(textFieldSelectionManager, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue17, startRestartGroup, 0);
                                                    changedInstance8 = (i37 != 4) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32);
                                                    rememberedValue18 = startRestartGroup.rememberedValue();
                                                    if (!changedInstance8 || rememberedValue18 == companion.getEmpty()) {
                                                        rememberedValue18 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1
                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                                                if (LegacyTextFieldState.this.getHasFocus()) {
                                                                    LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                                                    legacyTextFieldState2.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(textInputService, textFieldValue, legacyTextFieldState2.getProcessor(), imeOptions5, LegacyTextFieldState.this.getOnValueChange(), LegacyTextFieldState.this.getOnImeActionPerformed()));
                                                                }
                                                                return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1$invoke$$inlined$onDispose$1
                                                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                                                    public void dispose() {
                                                                    }
                                                                };
                                                            }
                                                        };
                                                        startRestartGroup.updateRememberedValue(rememberedValue18);
                                                    }
                                                    EffectsKt.DisposableEffect(imeOptions5, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue18, startRestartGroup, (i29 >> 3) & 14);
                                                    Modifier m539textFieldKeyInput2WJ9YEU = TextFieldKeyInputKt.m539textFieldKeyInput2WJ9YEU(companion2, legacyTextFieldState, textFieldSelectionManager, textFieldValue, legacyTextFieldState.getOnValueChange(), !z10, i36 != 1, offsetMapping, undoManager, imeOptions5.getImeAction());
                                                    boolean CoreTextField$lambda$11 = CoreTextField$lambda$11(rememberUpdatedState);
                                                    changedInstance9 = startRestartGroup.changedInstance(legacyTextFieldState) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32) | startRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter);
                                                    rememberedValue19 = startRestartGroup.rememberedValue();
                                                    if (!changedInstance9 || rememberedValue19 == companion.getEmpty()) {
                                                        rememberedValue19 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$stylusHandwritingModifier$1$1
                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(0);
                                                            }

                                                            /* JADX WARN: Can't rename method to resolve collision */
                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Boolean invoke() {
                                                                if (!LegacyTextFieldState.this.getHasFocus()) {
                                                                    focusRequester.requestFocus();
                                                                }
                                                                int keyboardType = imeOptions5.getKeyboardType();
                                                                KeyboardType.Companion companion3 = KeyboardType.INSTANCE;
                                                                if (!KeyboardType.m2410equalsimpl0(keyboardType, companion3.m2419getPasswordPjHm6EE()) && !KeyboardType.m2410equalsimpl0(imeOptions5.getKeyboardType(), companion3.m2418getNumberPasswordPjHm6EE())) {
                                                                    legacyPlatformTextInputServiceAdapter.startStylusHandwriting();
                                                                }
                                                                return Boolean.TRUE;
                                                            }
                                                        };
                                                        startRestartGroup.updateRememberedValue(rememberedValue19);
                                                    }
                                                    Modifier onGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier7, legacyPlatformTextInputServiceAdapter, legacyTextFieldState, textFieldSelectionManager).then(StylusHandwritingKt.stylusHandwriting(companion2, CoreTextField$lambda$11, (Function0) rememberedValue19)).then(modifier4), legacyTextFieldState, focusManager), legacyTextFieldState, textFieldSelectionManager).then(m539textFieldKeyInput2WJ9YEU), textFieldScrollerPosition, mutableInteractionSource7, z8).then(pointerHoverIcon$default).then(semantics), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                                            invoke2(layoutCoordinates);
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                        public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                                            TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                            if (layoutResult == null) {
                                                                return;
                                                            }
                                                            layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                                                        }
                                                    });
                                                    boolean z28 = !z8 && legacyTextFieldState.getHasFocus() && legacyTextFieldState.isInTouchMode() && windowInfo.isWindowFocused();
                                                    final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function34 = function32;
                                                    final TextStyle textStyle5 = textStyle2;
                                                    final int i41 = i25;
                                                    boolean z29 = z8;
                                                    ImeOptions imeOptions9 = imeOptions5;
                                                    final Modifier.Companion textFieldMagnifier = !z28 ? TextFieldSelectionManager_androidKt.textFieldMagnifier(companion2, textFieldSelectionManager) : companion2;
                                                    final boolean z30 = z28;
                                                    final boolean z31 = z10;
                                                    final Function1<? super TextLayoutResult, Unit> function16 = function13;
                                                    composer2 = startRestartGroup;
                                                    CoreTextFieldRootBox(onGloballyPositioned2, textFieldSelectionManager, ComposableLambdaKt.rememberComposableLambda(-374338080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                            invoke(composer3, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer3, int i42) {
                                                            if ((i42 & 3) == 2 && composer3.getSkipping()) {
                                                                composer3.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-374338080, i42, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:695)");
                                                            }
                                                            Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function35 = function34;
                                                            final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                                                            final TextStyle textStyle6 = textStyle5;
                                                            final int i43 = i41;
                                                            final int i44 = i36;
                                                            final TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                                                            final TextFieldValue textFieldValue2 = textFieldValue;
                                                            final VisualTransformation visualTransformation5 = visualTransformation4;
                                                            final Modifier modifier8 = cursor;
                                                            final Modifier modifier9 = drawBehind;
                                                            final Modifier modifier10 = onGloballyPositioned;
                                                            final Modifier modifier11 = textFieldMagnifier;
                                                            final BringIntoViewRequester bringIntoViewRequester2 = bringIntoViewRequester;
                                                            final TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                                            final boolean z32 = z30;
                                                            final boolean z33 = z31;
                                                            final Function1<TextLayoutResult, Unit> function17 = function16;
                                                            final OffsetMapping offsetMapping2 = offsetMapping;
                                                            final Density density2 = density;
                                                            function35.invoke(ComposableLambdaKt.rememberComposableLambda(2032502107, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(2);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function2
                                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                                    invoke(composer4, num.intValue());
                                                                    return Unit.INSTANCE;
                                                                }

                                                                public final void invoke(Composer composer4, int i45) {
                                                                    if ((i45 & 3) == 2 && composer4.getSkipping()) {
                                                                        composer4.skipToGroupEnd();
                                                                        return;
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(2032502107, i45, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:698)");
                                                                    }
                                                                    Modifier heightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m327heightInVpY3zN4$default(Modifier.INSTANCE, LegacyTextFieldState.this.m486getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle6, i43, i44);
                                                                    TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition2;
                                                                    TextFieldValue textFieldValue3 = textFieldValue2;
                                                                    VisualTransformation visualTransformation6 = visualTransformation5;
                                                                    boolean changedInstance11 = composer4.changedInstance(LegacyTextFieldState.this);
                                                                    final LegacyTextFieldState legacyTextFieldState3 = LegacyTextFieldState.this;
                                                                    Object rememberedValue21 = composer4.rememberedValue();
                                                                    if (changedInstance11 || rememberedValue21 == Composer.INSTANCE.getEmpty()) {
                                                                        rememberedValue21 = new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1$1
                                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                                            {
                                                                                super(0);
                                                                            }

                                                                            /* JADX WARN: Can't rename method to resolve collision */
                                                                            @Override // kotlin.jvm.functions.Function0
                                                                            public final TextLayoutResultProxy invoke() {
                                                                                return LegacyTextFieldState.this.getLayoutResult();
                                                                            }
                                                                        };
                                                                        composer4.updateRememberedValue(rememberedValue21);
                                                                    }
                                                                    Modifier bringIntoViewRequester3 = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(heightInLines, textFieldScrollerPosition3, textFieldValue3, visualTransformation6, (Function0) rememberedValue21).then(modifier8).then(modifier9), textStyle6).then(modifier10).then(modifier11), bringIntoViewRequester2);
                                                                    final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager2;
                                                                    final LegacyTextFieldState legacyTextFieldState4 = LegacyTextFieldState.this;
                                                                    final boolean z34 = z32;
                                                                    final boolean z35 = z33;
                                                                    final Function1<TextLayoutResult, Unit> function18 = function17;
                                                                    final TextFieldValue textFieldValue4 = textFieldValue2;
                                                                    final OffsetMapping offsetMapping3 = offsetMapping2;
                                                                    final Density density3 = density2;
                                                                    final int i46 = i44;
                                                                    SimpleLayoutKt.SimpleLayout(bringIntoViewRequester3, ComposableLambdaKt.rememberComposableLambda(-363167407, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        /* JADX WARN: Multi-variable type inference failed */
                                                                        {
                                                                            super(2);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function2
                                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                                            invoke(composer5, num.intValue());
                                                                            return Unit.INSTANCE;
                                                                        }

                                                                        /* JADX WARN: Removed duplicated region for block: B:39:0x00ff  */
                                                                        /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
                                                                        /*
                                                                            Code decompiled incorrectly, please refer to instructions dump.
                                                                        */
                                                                        public final void invoke(Composer composer5, int i47) {
                                                                            boolean z36;
                                                                            if ((i47 & 3) == 2 && composer5.getSkipping()) {
                                                                                composer5.skipToGroupEnd();
                                                                                return;
                                                                            }
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(-363167407, i47, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:721)");
                                                                            }
                                                                            final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                                                            final Function1<TextLayoutResult, Unit> function19 = function18;
                                                                            final TextFieldValue textFieldValue5 = textFieldValue4;
                                                                            final OffsetMapping offsetMapping4 = offsetMapping3;
                                                                            final Density density4 = density3;
                                                                            final int i48 = i46;
                                                                            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                                                @Override // androidx.compose.ui.layout.MeasurePolicy
                                                                                public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i49) {
                                                                                    LegacyTextFieldState.this.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                                                                    return LegacyTextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                                                                }

                                                                                @Override // androidx.compose.ui.layout.MeasurePolicy
                                                                                /* renamed from: measure-3p2s80s */
                                                                                public MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                                                                                    Snapshot.Companion companion3 = Snapshot.INSTANCE;
                                                                                    LegacyTextFieldState legacyTextFieldState6 = LegacyTextFieldState.this;
                                                                                    Snapshot currentThreadSnapshot = companion3.getCurrentThreadSnapshot();
                                                                                    Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                                                                    Snapshot makeCurrentNonObservable = companion3.makeCurrentNonObservable(currentThreadSnapshot);
                                                                                    try {
                                                                                        TextLayoutResultProxy layoutResult = legacyTextFieldState6.getLayoutResult();
                                                                                        TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                                                                        Triple<Integer, Integer, TextLayoutResult> m531layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m531layout_EkL_Y$foundation_release(LegacyTextFieldState.this.getTextDelegate(), j5, measureScope.getLayoutDirection(), value);
                                                                                        int intValue = m531layout_EkL_Y$foundation_release.component1().intValue();
                                                                                        int intValue2 = m531layout_EkL_Y$foundation_release.component2().intValue();
                                                                                        TextLayoutResult component3 = m531layout_EkL_Y$foundation_release.component3();
                                                                                        if (!Intrinsics.areEqual(value, component3)) {
                                                                                            LegacyTextFieldState.this.setLayoutResult(new TextLayoutResultProxy(component3, null, layoutResult != null ? layoutResult.getDecorationBoxCoordinates() : null, 2, null));
                                                                                            function19.invoke(component3);
                                                                                            CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue5, offsetMapping4);
                                                                                        }
                                                                                        LegacyTextFieldState.this.m490setMinHeightForSingleLineField0680j_4(density4.mo209toDpu2uoSUM(i48 == 1 ? TextDelegateKt.ceilToIntPx(component3.getLineBottom(0)) : 0));
                                                                                        return measureScope.layout(intValue, intValue2, MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(component3.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(component3.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                                            public final void invoke2(Placeable.PlacementScope placementScope) {
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                                                invoke2(placementScope);
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                    } finally {
                                                                                        companion3.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                                                                    }
                                                                                }
                                                                            };
                                                                            Modifier.Companion companion3 = Modifier.INSTANCE;
                                                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, companion3);
                                                                            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                                                            Function0<ComposeUiNode> constructor = companion4.getConstructor();
                                                                            if (composer5.getApplier() == null) {
                                                                                ComposablesKt.invalidApplier();
                                                                            }
                                                                            composer5.startReusableNode();
                                                                            if (composer5.getInserting()) {
                                                                                composer5.createNode(constructor);
                                                                            } else {
                                                                                composer5.useNode();
                                                                            }
                                                                            Composer m1226constructorimpl = Updater.m1226constructorimpl(composer5);
                                                                            Updater.m1227setimpl(m1226constructorimpl, measurePolicy, companion4.getSetMeasurePolicy());
                                                                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                                                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                                                                            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                                            }
                                                                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
                                                                            composer5.endNode();
                                                                            TextFieldSelectionManager textFieldSelectionManager4 = TextFieldSelectionManager.this;
                                                                            if (legacyTextFieldState4.getHandleState() != HandleState.None && legacyTextFieldState4.getLayoutCoordinates() != null) {
                                                                                LayoutCoordinates layoutCoordinates = legacyTextFieldState4.getLayoutCoordinates();
                                                                                Intrinsics.checkNotNull(layoutCoordinates);
                                                                                if (layoutCoordinates.isAttached() && z34) {
                                                                                    z36 = true;
                                                                                    CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z36, composer5, 0);
                                                                                    if (legacyTextFieldState4.getHandleState() != HandleState.Cursor && !z35 && z34) {
                                                                                        composer5.startReplaceGroup(-2032274);
                                                                                        CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer5, 0);
                                                                                        composer5.endReplaceGroup();
                                                                                    } else {
                                                                                        composer5.startReplaceGroup(-1955394);
                                                                                        composer5.endReplaceGroup();
                                                                                    }
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        return;
                                                                                    }
                                                                                    ComposerKt.traceEventEnd();
                                                                                    return;
                                                                                }
                                                                            }
                                                                            z36 = false;
                                                                            CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z36, composer5, 0);
                                                                            if (legacyTextFieldState4.getHandleState() != HandleState.Cursor) {
                                                                            }
                                                                            composer5.startReplaceGroup(-1955394);
                                                                            composer5.endReplaceGroup();
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                            }
                                                                        }
                                                                    }, composer4, 54), composer4, 48, 0);
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                    }
                                                                }
                                                            }, composer3, 54), composer3, 6);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }, composer2, 54), composer2, 384);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                    textStyle3 = textStyle2;
                                                    function14 = function13;
                                                    visualTransformation3 = visualTransformation4;
                                                    modifier5 = modifier7;
                                                    brush4 = brush3;
                                                    z15 = z9;
                                                    i30 = i25;
                                                    z16 = z29;
                                                    keyboardActions3 = keyboardActions2;
                                                    imeOptions6 = imeOptions9;
                                                    i31 = i36;
                                                    mutableInteractionSource4 = mutableInteractionSource7;
                                                    z17 = z10;
                                                    function33 = function32;
                                                }
                                            } else {
                                                modifier4 = textFieldFocusModifier;
                                            }
                                            z13 = true;
                                            z14 = changed3 | z13;
                                            rememberedValue11 = startRestartGroup.rememberedValue();
                                            if (!z14) {
                                            }
                                            rememberedValue11 = new CoreTextFieldKt$CoreTextField$2$1(legacyTextFieldState, rememberUpdatedState, textInputService, textFieldSelectionManager, imeOptions5, null);
                                            startRestartGroup.updateRememberedValue(rememberedValue11);
                                            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue11, startRestartGroup, 6);
                                            changedInstance2 = startRestartGroup.changedInstance(legacyTextFieldState);
                                            rememberedValue12 = startRestartGroup.rememberedValue();
                                            if (!changedInstance2) {
                                            }
                                            rememberedValue12 = new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                                    invoke(bool.booleanValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(boolean z222) {
                                                    LegacyTextFieldState.this.setInTouchMode(z222);
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue12);
                                            Modifier updateSelectionTouchMode2 = SelectionGesturesKt.updateSelectionTouchMode(companion2, (Function1) rememberedValue12);
                                            int i402 = i28;
                                            changedInstance3 = startRestartGroup.changedInstance(legacyTextFieldState) | (i402 != 16384) | (i38 != 2048) | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                            rememberedValue13 = startRestartGroup.rememberedValue();
                                            if (!changedInstance3) {
                                            }
                                            final boolean z222 = z10;
                                            final boolean z232 = z8;
                                            rememberedValue13 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                                    m473invokek4lQ0M(offset.getPackedValue());
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                                                public final void m473invokek4lQ0M(long j5) {
                                                    CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester, !z222);
                                                    if (LegacyTextFieldState.this.getHasFocus() && z232) {
                                                        if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                                                            textFieldSelectionManager.m643deselect_kEHs6E$foundation_release(Offset.m1328boximpl(j5));
                                                            return;
                                                        }
                                                        TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                        if (layoutResult != null) {
                                                            LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                                            TextFieldDelegate.INSTANCE.m532setCursorOffsetULxng0E$foundation_release(j5, layoutResult, legacyTextFieldState2.getProcessor(), offsetMapping, legacyTextFieldState2.getOnValueChange());
                                                            if (legacyTextFieldState2.getTextDelegate().getText().length() > 0) {
                                                                legacyTextFieldState2.setHandleState(HandleState.Cursor);
                                                            }
                                                        }
                                                    }
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue13);
                                            Modifier pointerHoverIcon$default2 = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(updateSelectionTouchMode2, mutableInteractionSource7, z8, (Function1) rememberedValue13), textFieldSelectionManager.getMouseSelectionObserver(), textFieldSelectionManager.getTouchSelectionObserver()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                                            changedInstance4 = startRestartGroup.changedInstance(legacyTextFieldState) | (i37 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                            rememberedValue14 = startRestartGroup.rememberedValue();
                                            if (!changedInstance4) {
                                            }
                                            rememberedValue14 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                                    invoke2(drawScope);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(DrawScope drawScope) {
                                                    TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                    if (layoutResult != null) {
                                                        TextFieldValue textFieldValue2 = textFieldValue;
                                                        LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                                        OffsetMapping offsetMapping2 = offsetMapping;
                                                        TextFieldDelegate.INSTANCE.m530drawQ1vqE60$foundation_release(drawScope.getDrawContext().getCanvas(), textFieldValue2, legacyTextFieldState2.m488getSelectionPreviewHighlightRanged9O1mEE(), legacyTextFieldState2.m485getDeletionPreviewHighlightRanged9O1mEE(), offsetMapping2, layoutResult.getValue(), legacyTextFieldState2.getHighlightPaint(), legacyTextFieldState2.getSelectionBackgroundColor());
                                                    }
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue14);
                                            final Modifier drawBehind2 = DrawModifierKt.drawBehind(companion2, (Function1) rememberedValue14);
                                            changedInstance5 = startRestartGroup.changedInstance(legacyTextFieldState) | (i38 != 2048) | startRestartGroup.changed(windowInfo) | startRestartGroup.changedInstance(textFieldSelectionManager) | (i37 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                            rememberedValue15 = startRestartGroup.rememberedValue();
                                            if (!changedInstance5) {
                                            }
                                            final boolean z242 = z8;
                                            rememberedValue15 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                                    invoke2(layoutCoordinates);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                                    LegacyTextFieldState.this.setLayoutCoordinates(layoutCoordinates);
                                                    TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                    if (layoutResult != null) {
                                                        layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
                                                    }
                                                    if (z242) {
                                                        if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                                                            if (LegacyTextFieldState.this.getShowFloatingToolbar() && windowInfo.isWindowFocused()) {
                                                                textFieldSelectionManager.showSelectionToolbar$foundation_release();
                                                            } else {
                                                                textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                                                            }
                                                            LegacyTextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true));
                                                            LegacyTextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, false));
                                                            LegacyTextFieldState.this.setShowCursorHandle(TextRange.m2279getCollapsedimpl(textFieldValue.getSelection()));
                                                        } else if (LegacyTextFieldState.this.getHandleState() == HandleState.Cursor) {
                                                            LegacyTextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true));
                                                        }
                                                        CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue, offsetMapping);
                                                        TextLayoutResultProxy layoutResult2 = LegacyTextFieldState.this.getLayoutResult();
                                                        if (layoutResult2 != null) {
                                                            LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                                            TextFieldValue textFieldValue2 = textFieldValue;
                                                            OffsetMapping offsetMapping2 = offsetMapping;
                                                            TextInputSession inputSession = legacyTextFieldState2.getInputSession();
                                                            if (inputSession == null || !legacyTextFieldState2.getHasFocus()) {
                                                                return;
                                                            }
                                                            TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation_release(inputSession, textFieldValue2, offsetMapping2, layoutResult2);
                                                        }
                                                    }
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue15);
                                            final Modifier onGloballyPositioned3 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) rememberedValue15);
                                            final boolean z252 = visualTransformation4 instanceof PasswordVisualTransformation;
                                            changedInstance6 = (i38 != 2048) | startRestartGroup.changedInstance(transformedText) | (i37 != 4) | startRestartGroup.changed(z252) | (i402 != 16384) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(textFieldSelectionManager) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32);
                                            rememberedValue16 = startRestartGroup.rememberedValue();
                                            if (!changedInstance6) {
                                            }
                                            final boolean z262 = z8;
                                            final boolean z272 = z10;
                                            final ImeOptions imeOptions82 = imeOptions5;
                                            rememberedValue16 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                    invoke2(semanticsPropertyReceiver);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(final SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                    SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, TransformedText.this.getText());
                                                    SemanticsPropertiesKt.m2185setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, textFieldValue.getSelection());
                                                    if (!z262) {
                                                        SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                                                    }
                                                    if (z252) {
                                                        SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                                                    }
                                                    boolean z282 = z262 && !z272;
                                                    SemanticsPropertiesKt.setEditable(semanticsPropertyReceiver, z282);
                                                    final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                                                    SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Boolean invoke(List<TextLayoutResult> list) {
                                                            boolean z292;
                                                            if (LegacyTextFieldState.this.getLayoutResult() != null) {
                                                                TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                                Intrinsics.checkNotNull(layoutResult);
                                                                list.add(layoutResult.getValue());
                                                                z292 = true;
                                                            } else {
                                                                z292 = false;
                                                            }
                                                            return Boolean.valueOf(z292);
                                                        }
                                                    }, 1, null);
                                                    if (z282) {
                                                        final LegacyTextFieldState legacyTextFieldState3 = legacyTextFieldState;
                                                        SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Boolean invoke(AnnotatedString annotatedString) {
                                                                Unit unit2;
                                                                TextInputSession inputSession = LegacyTextFieldState.this.getInputSession();
                                                                if (inputSession != null) {
                                                                    LegacyTextFieldState legacyTextFieldState4 = LegacyTextFieldState.this;
                                                                    TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(annotatedString, 1)}), legacyTextFieldState4.getProcessor(), legacyTextFieldState4.getOnValueChange(), inputSession);
                                                                    unit2 = Unit.INSTANCE;
                                                                } else {
                                                                    unit2 = null;
                                                                }
                                                                if (unit2 == null) {
                                                                    LegacyTextFieldState.this.getOnValueChange().invoke(new TextFieldValue(annotatedString.getText(), TextRangeKt.TextRange(annotatedString.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                                }
                                                                return Boolean.TRUE;
                                                            }
                                                        }, 1, null);
                                                        final boolean z292 = z272;
                                                        final boolean z302 = z262;
                                                        final LegacyTextFieldState legacyTextFieldState4 = legacyTextFieldState;
                                                        final TextFieldValue textFieldValue2 = textFieldValue;
                                                        SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.3
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Boolean invoke(AnnotatedString annotatedString) {
                                                                Unit unit2;
                                                                if (!z292 && z302) {
                                                                    TextInputSession inputSession = legacyTextFieldState4.getInputSession();
                                                                    if (inputSession != null) {
                                                                        LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                                                        TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(annotatedString, 1)}), legacyTextFieldState5.getProcessor(), legacyTextFieldState5.getOnValueChange(), inputSession);
                                                                        unit2 = Unit.INSTANCE;
                                                                    } else {
                                                                        unit2 = null;
                                                                    }
                                                                    if (unit2 == null) {
                                                                        TextFieldValue textFieldValue3 = textFieldValue2;
                                                                        legacyTextFieldState4.getOnValueChange().invoke(new TextFieldValue(StringsKt.replaceRange(textFieldValue3.getText(), TextRange.m2285getStartimpl(textFieldValue3.getSelection()), TextRange.m2280getEndimpl(textFieldValue3.getSelection()), annotatedString).toString(), TextRangeKt.TextRange(TextRange.m2285getStartimpl(textFieldValue3.getSelection()) + annotatedString.length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                                    }
                                                                    return Boolean.TRUE;
                                                                }
                                                                return Boolean.FALSE;
                                                            }
                                                        }, 1, null);
                                                    }
                                                    final OffsetMapping offsetMapping2 = offsetMapping;
                                                    final boolean z312 = z262;
                                                    final TextFieldValue textFieldValue3 = textFieldValue;
                                                    final TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                                    final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState;
                                                    SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.4
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                                                            return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                                                        }

                                                        public final Boolean invoke(int i412, int i42, boolean z32) {
                                                            if (!z32) {
                                                                i412 = OffsetMapping.this.transformedToOriginal(i412);
                                                            }
                                                            if (!z32) {
                                                                i42 = OffsetMapping.this.transformedToOriginal(i42);
                                                            }
                                                            boolean z33 = false;
                                                            if (z312 && (i412 != TextRange.m2285getStartimpl(textFieldValue3.getSelection()) || i42 != TextRange.m2280getEndimpl(textFieldValue3.getSelection()))) {
                                                                if (Math.min(i412, i42) >= 0 && Math.max(i412, i42) <= textFieldValue3.getText().length()) {
                                                                    if (!z32 && i412 != i42) {
                                                                        TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager2, false, 1, null);
                                                                    } else {
                                                                        textFieldSelectionManager2.exitSelectionMode$foundation_release();
                                                                    }
                                                                    legacyTextFieldState5.getOnValueChange().invoke(new TextFieldValue(textFieldValue3.getText(), TextRangeKt.TextRange(i412, i42), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                                    z33 = true;
                                                                } else {
                                                                    textFieldSelectionManager2.exitSelectionMode$foundation_release();
                                                                }
                                                            }
                                                            return Boolean.valueOf(z33);
                                                        }
                                                    }, 1, null);
                                                    int imeAction = imeOptions82.getImeAction();
                                                    final LegacyTextFieldState legacyTextFieldState6 = legacyTextFieldState;
                                                    final ImeOptions imeOptions92 = imeOptions82;
                                                    SemanticsPropertiesKt.m2182onImeAction9UiTYpY$default(semanticsPropertyReceiver, imeAction, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.5
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Boolean invoke() {
                                                            LegacyTextFieldState.this.getOnImeActionPerformed().invoke(ImeAction.m2375boximpl(imeOptions92.getImeAction()));
                                                            return Boolean.TRUE;
                                                        }
                                                    }, 2, null);
                                                    final LegacyTextFieldState legacyTextFieldState7 = legacyTextFieldState;
                                                    final FocusRequester focusRequester2 = focusRequester;
                                                    final boolean z32 = z272;
                                                    SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.6
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(0);
                                                        }

                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Boolean invoke() {
                                                            CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester2, !z32);
                                                            return Boolean.TRUE;
                                                        }
                                                    }, 1, null);
                                                    final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager;
                                                    SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.7
                                                        {
                                                            super(0);
                                                        }

                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Boolean invoke() {
                                                            TextFieldSelectionManager.enterSelectionMode$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                                            return Boolean.TRUE;
                                                        }
                                                    }, 1, null);
                                                    if (!TextRange.m2279getCollapsedimpl(textFieldValue.getSelection()) && !z252) {
                                                        final TextFieldSelectionManager textFieldSelectionManager4 = textFieldSelectionManager;
                                                        SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.8
                                                            {
                                                                super(0);
                                                            }

                                                            /* JADX WARN: Can't rename method to resolve collision */
                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Boolean invoke() {
                                                                TextFieldSelectionManager.copy$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                                                return Boolean.TRUE;
                                                            }
                                                        }, 1, null);
                                                        if (z262 && !z272) {
                                                            final TextFieldSelectionManager textFieldSelectionManager5 = textFieldSelectionManager;
                                                            SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.9
                                                                {
                                                                    super(0);
                                                                }

                                                                /* JADX WARN: Can't rename method to resolve collision */
                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final Boolean invoke() {
                                                                    TextFieldSelectionManager.this.cut$foundation_release();
                                                                    return Boolean.TRUE;
                                                                }
                                                            }, 1, null);
                                                        }
                                                    }
                                                    if (!z262 || z272) {
                                                        return;
                                                    }
                                                    final TextFieldSelectionManager textFieldSelectionManager6 = textFieldSelectionManager;
                                                    SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.10
                                                        {
                                                            super(0);
                                                        }

                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Boolean invoke() {
                                                            TextFieldSelectionManager.this.paste$foundation_release();
                                                            return Boolean.TRUE;
                                                        }
                                                    }, 1, null);
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue16);
                                            Modifier semantics2 = SemanticsModifierKt.semantics(companion2, true, (Function1) rememberedValue16);
                                            final Modifier cursor2 = TextFieldCursorKt.cursor(companion2, legacyTextFieldState, textFieldValue, offsetMapping, brush3, (z8 || z10 || !windowInfo.isWindowFocused() || legacyTextFieldState.hasHighlight()) ? false : true);
                                            changedInstance7 = startRestartGroup.changedInstance(textFieldSelectionManager);
                                            rememberedValue17 = startRestartGroup.rememberedValue();
                                            if (!changedInstance7) {
                                            }
                                            rememberedValue17 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                                    final TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                                                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1$invoke$$inlined$onDispose$1
                                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                                        public void dispose() {
                                                            TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                                                        }
                                                    };
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue17);
                                            EffectsKt.DisposableEffect(textFieldSelectionManager, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue17, startRestartGroup, 0);
                                            changedInstance8 = (i37 != 4) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32);
                                            rememberedValue18 = startRestartGroup.rememberedValue();
                                            if (!changedInstance8) {
                                            }
                                            rememberedValue18 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                                    if (LegacyTextFieldState.this.getHasFocus()) {
                                                        LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                                        legacyTextFieldState2.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(textInputService, textFieldValue, legacyTextFieldState2.getProcessor(), imeOptions5, LegacyTextFieldState.this.getOnValueChange(), LegacyTextFieldState.this.getOnImeActionPerformed()));
                                                    }
                                                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1$invoke$$inlined$onDispose$1
                                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                                        public void dispose() {
                                                        }
                                                    };
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue18);
                                            EffectsKt.DisposableEffect(imeOptions5, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue18, startRestartGroup, (i29 >> 3) & 14);
                                            Modifier m539textFieldKeyInput2WJ9YEU2 = TextFieldKeyInputKt.m539textFieldKeyInput2WJ9YEU(companion2, legacyTextFieldState, textFieldSelectionManager, textFieldValue, legacyTextFieldState.getOnValueChange(), !z10, i36 != 1, offsetMapping, undoManager, imeOptions5.getImeAction());
                                            boolean CoreTextField$lambda$112 = CoreTextField$lambda$11(rememberUpdatedState);
                                            changedInstance9 = startRestartGroup.changedInstance(legacyTextFieldState) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32) | startRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter);
                                            rememberedValue19 = startRestartGroup.rememberedValue();
                                            if (!changedInstance9) {
                                            }
                                            rememberedValue19 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$stylusHandwritingModifier$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    if (!LegacyTextFieldState.this.getHasFocus()) {
                                                        focusRequester.requestFocus();
                                                    }
                                                    int keyboardType = imeOptions5.getKeyboardType();
                                                    KeyboardType.Companion companion3 = KeyboardType.INSTANCE;
                                                    if (!KeyboardType.m2410equalsimpl0(keyboardType, companion3.m2419getPasswordPjHm6EE()) && !KeyboardType.m2410equalsimpl0(imeOptions5.getKeyboardType(), companion3.m2418getNumberPasswordPjHm6EE())) {
                                                        legacyPlatformTextInputServiceAdapter.startStylusHandwriting();
                                                    }
                                                    return Boolean.TRUE;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue19);
                                            Modifier onGloballyPositioned22 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier7, legacyPlatformTextInputServiceAdapter, legacyTextFieldState, textFieldSelectionManager).then(StylusHandwritingKt.stylusHandwriting(companion2, CoreTextField$lambda$112, (Function0) rememberedValue19)).then(modifier4), legacyTextFieldState, focusManager), legacyTextFieldState, textFieldSelectionManager).then(m539textFieldKeyInput2WJ9YEU2), textFieldScrollerPosition, mutableInteractionSource7, z8).then(pointerHoverIcon$default2).then(semantics2), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                                    invoke2(layoutCoordinates);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                                    TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                    if (layoutResult == null) {
                                                        return;
                                                    }
                                                    layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                                                }
                                            });
                                            if (z8) {
                                            }
                                            final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function342 = function32;
                                            final TextStyle textStyle52 = textStyle2;
                                            final int i412 = i25;
                                            boolean z292 = z8;
                                            ImeOptions imeOptions92 = imeOptions5;
                                            final Modifier textFieldMagnifier2 = !z28 ? TextFieldSelectionManager_androidKt.textFieldMagnifier(companion2, textFieldSelectionManager) : companion2;
                                            final boolean z302 = z28;
                                            final boolean z312 = z10;
                                            final Function1<? super TextLayoutResult, Unit> function162 = function13;
                                            composer2 = startRestartGroup;
                                            CoreTextFieldRootBox(onGloballyPositioned22, textFieldSelectionManager, ComposableLambdaKt.rememberComposableLambda(-374338080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                    invoke(composer3, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer3, int i42) {
                                                    if ((i42 & 3) == 2 && composer3.getSkipping()) {
                                                        composer3.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-374338080, i42, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:695)");
                                                    }
                                                    Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function35 = function342;
                                                    final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                                                    final TextStyle textStyle6 = textStyle52;
                                                    final int i43 = i412;
                                                    final int i44 = i36;
                                                    final TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                                                    final TextFieldValue textFieldValue2 = textFieldValue;
                                                    final VisualTransformation visualTransformation5 = visualTransformation4;
                                                    final Modifier modifier8 = cursor2;
                                                    final Modifier modifier9 = drawBehind2;
                                                    final Modifier modifier10 = onGloballyPositioned3;
                                                    final Modifier modifier11 = textFieldMagnifier2;
                                                    final BringIntoViewRequester bringIntoViewRequester2 = bringIntoViewRequester;
                                                    final TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                                    final boolean z32 = z302;
                                                    final boolean z33 = z312;
                                                    final Function1<? super TextLayoutResult, Unit> function17 = function162;
                                                    final OffsetMapping offsetMapping2 = offsetMapping;
                                                    final Density density2 = density;
                                                    function35.invoke(ComposableLambdaKt.rememberComposableLambda(2032502107, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                            invoke(composer4, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer4, int i45) {
                                                            if ((i45 & 3) == 2 && composer4.getSkipping()) {
                                                                composer4.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(2032502107, i45, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:698)");
                                                            }
                                                            Modifier heightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m327heightInVpY3zN4$default(Modifier.INSTANCE, LegacyTextFieldState.this.m486getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle6, i43, i44);
                                                            TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition2;
                                                            TextFieldValue textFieldValue3 = textFieldValue2;
                                                            VisualTransformation visualTransformation6 = visualTransformation5;
                                                            boolean changedInstance11 = composer4.changedInstance(LegacyTextFieldState.this);
                                                            final LegacyTextFieldState legacyTextFieldState3 = LegacyTextFieldState.this;
                                                            Object rememberedValue21 = composer4.rememberedValue();
                                                            if (changedInstance11 || rememberedValue21 == Composer.INSTANCE.getEmpty()) {
                                                                rememberedValue21 = new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1$1
                                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final TextLayoutResultProxy invoke() {
                                                                        return LegacyTextFieldState.this.getLayoutResult();
                                                                    }
                                                                };
                                                                composer4.updateRememberedValue(rememberedValue21);
                                                            }
                                                            Modifier bringIntoViewRequester3 = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(heightInLines, textFieldScrollerPosition3, textFieldValue3, visualTransformation6, (Function0) rememberedValue21).then(modifier8).then(modifier9), textStyle6).then(modifier10).then(modifier11), bringIntoViewRequester2);
                                                            final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager2;
                                                            final LegacyTextFieldState legacyTextFieldState4 = LegacyTextFieldState.this;
                                                            final boolean z34 = z32;
                                                            final boolean z35 = z33;
                                                            final Function1<? super TextLayoutResult, Unit> function18 = function17;
                                                            final TextFieldValue textFieldValue4 = textFieldValue2;
                                                            final OffsetMapping offsetMapping3 = offsetMapping2;
                                                            final Density density3 = density2;
                                                            final int i46 = i44;
                                                            SimpleLayoutKt.SimpleLayout(bringIntoViewRequester3, ComposableLambdaKt.rememberComposableLambda(-363167407, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(2);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function2
                                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                                    invoke(composer5, num.intValue());
                                                                    return Unit.INSTANCE;
                                                                }

                                                                /* JADX WARN: Removed duplicated region for block: B:39:0x00ff  */
                                                                /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
                                                                /*
                                                                    Code decompiled incorrectly, please refer to instructions dump.
                                                                */
                                                                public final void invoke(Composer composer5, int i47) {
                                                                    boolean z36;
                                                                    if ((i47 & 3) == 2 && composer5.getSkipping()) {
                                                                        composer5.skipToGroupEnd();
                                                                        return;
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-363167407, i47, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:721)");
                                                                    }
                                                                    final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                                                    final Function1<? super TextLayoutResult, Unit> function19 = function18;
                                                                    final TextFieldValue textFieldValue5 = textFieldValue4;
                                                                    final OffsetMapping offsetMapping4 = offsetMapping3;
                                                                    final Density density4 = density3;
                                                                    final int i48 = i46;
                                                                    MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                                        @Override // androidx.compose.ui.layout.MeasurePolicy
                                                                        public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i49) {
                                                                            LegacyTextFieldState.this.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                                                            return LegacyTextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                                                        }

                                                                        @Override // androidx.compose.ui.layout.MeasurePolicy
                                                                        /* renamed from: measure-3p2s80s */
                                                                        public MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                                                                            Snapshot.Companion companion3 = Snapshot.INSTANCE;
                                                                            LegacyTextFieldState legacyTextFieldState6 = LegacyTextFieldState.this;
                                                                            Snapshot currentThreadSnapshot = companion3.getCurrentThreadSnapshot();
                                                                            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                                                            Snapshot makeCurrentNonObservable = companion3.makeCurrentNonObservable(currentThreadSnapshot);
                                                                            try {
                                                                                TextLayoutResultProxy layoutResult = legacyTextFieldState6.getLayoutResult();
                                                                                TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                                                                Triple<Integer, Integer, TextLayoutResult> m531layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m531layout_EkL_Y$foundation_release(LegacyTextFieldState.this.getTextDelegate(), j5, measureScope.getLayoutDirection(), value);
                                                                                int intValue = m531layout_EkL_Y$foundation_release.component1().intValue();
                                                                                int intValue2 = m531layout_EkL_Y$foundation_release.component2().intValue();
                                                                                TextLayoutResult component3 = m531layout_EkL_Y$foundation_release.component3();
                                                                                if (!Intrinsics.areEqual(value, component3)) {
                                                                                    LegacyTextFieldState.this.setLayoutResult(new TextLayoutResultProxy(component3, null, layoutResult != null ? layoutResult.getDecorationBoxCoordinates() : null, 2, null));
                                                                                    function19.invoke(component3);
                                                                                    CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue5, offsetMapping4);
                                                                                }
                                                                                LegacyTextFieldState.this.m490setMinHeightForSingleLineField0680j_4(density4.mo209toDpu2uoSUM(i48 == 1 ? TextDelegateKt.ceilToIntPx(component3.getLineBottom(0)) : 0));
                                                                                return measureScope.layout(intValue, intValue2, MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(component3.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(component3.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                                    public final void invoke2(Placeable.PlacementScope placementScope) {
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                                        invoke2(placementScope);
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                            } finally {
                                                                                companion3.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                                                            }
                                                                        }
                                                                    };
                                                                    Modifier.Companion companion3 = Modifier.INSTANCE;
                                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, companion3);
                                                                    ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                                                    Function0<ComposeUiNode> constructor = companion4.getConstructor();
                                                                    if (composer5.getApplier() == null) {
                                                                        ComposablesKt.invalidApplier();
                                                                    }
                                                                    composer5.startReusableNode();
                                                                    if (composer5.getInserting()) {
                                                                        composer5.createNode(constructor);
                                                                    } else {
                                                                        composer5.useNode();
                                                                    }
                                                                    Composer m1226constructorimpl = Updater.m1226constructorimpl(composer5);
                                                                    Updater.m1227setimpl(m1226constructorimpl, measurePolicy, companion4.getSetMeasurePolicy());
                                                                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                                                                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                                    }
                                                                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
                                                                    composer5.endNode();
                                                                    TextFieldSelectionManager textFieldSelectionManager4 = TextFieldSelectionManager.this;
                                                                    if (legacyTextFieldState4.getHandleState() != HandleState.None && legacyTextFieldState4.getLayoutCoordinates() != null) {
                                                                        LayoutCoordinates layoutCoordinates = legacyTextFieldState4.getLayoutCoordinates();
                                                                        Intrinsics.checkNotNull(layoutCoordinates);
                                                                        if (layoutCoordinates.isAttached() && z34) {
                                                                            z36 = true;
                                                                            CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z36, composer5, 0);
                                                                            if (legacyTextFieldState4.getHandleState() != HandleState.Cursor && !z35 && z34) {
                                                                                composer5.startReplaceGroup(-2032274);
                                                                                CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer5, 0);
                                                                                composer5.endReplaceGroup();
                                                                            } else {
                                                                                composer5.startReplaceGroup(-1955394);
                                                                                composer5.endReplaceGroup();
                                                                            }
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                return;
                                                                            }
                                                                            ComposerKt.traceEventEnd();
                                                                            return;
                                                                        }
                                                                    }
                                                                    z36 = false;
                                                                    CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z36, composer5, 0);
                                                                    if (legacyTextFieldState4.getHandleState() != HandleState.Cursor) {
                                                                    }
                                                                    composer5.startReplaceGroup(-1955394);
                                                                    composer5.endReplaceGroup();
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                    }
                                                                }
                                                            }, composer4, 54), composer4, 48, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }, composer3, 54), composer3, 6);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, composer2, 54), composer2, 384);
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            textStyle3 = textStyle2;
                                            function14 = function13;
                                            visualTransformation3 = visualTransformation4;
                                            modifier5 = modifier7;
                                            brush4 = brush3;
                                            z15 = z9;
                                            i30 = i25;
                                            z16 = z292;
                                            keyboardActions3 = keyboardActions2;
                                            imeOptions6 = imeOptions92;
                                            i31 = i36;
                                            mutableInteractionSource4 = mutableInteractionSource7;
                                            z17 = z10;
                                            function33 = function32;
                                        }
                                    } else {
                                        imeOptions5 = imeOptions4;
                                    }
                                    i28 = i39;
                                    i29 = i20;
                                    if ((i20 & 48) != 32) {
                                        z12 = false;
                                        changedInstance = changedInstance10 | z12 | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(bringIntoViewRequester) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                        rememberedValue10 = startRestartGroup.rememberedValue();
                                        if (!changedInstance) {
                                        }
                                        final boolean z202 = z8;
                                        final boolean z212 = z10;
                                        final ImeOptions imeOptions72 = imeOptions5;
                                        rememberedValue10 = new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                                                invoke2(focusState);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(FocusState focusState) {
                                                TextLayoutResultProxy layoutResult;
                                                if (LegacyTextFieldState.this.getHasFocus() == focusState.isFocused()) {
                                                    return;
                                                }
                                                LegacyTextFieldState.this.setHasFocus(focusState.isFocused());
                                                if (LegacyTextFieldState.this.getHasFocus() && z202 && !z212) {
                                                    CoreTextFieldKt.startInputSession(textInputService, LegacyTextFieldState.this, textFieldValue, imeOptions72, offsetMapping);
                                                } else {
                                                    CoreTextFieldKt.endInputSession(LegacyTextFieldState.this);
                                                }
                                                if (focusState.isFocused() && (layoutResult = LegacyTextFieldState.this.getLayoutResult()) != null) {
                                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(bringIntoViewRequester, textFieldValue, LegacyTextFieldState.this, layoutResult, offsetMapping, null), 3, null);
                                                }
                                                if (focusState.isFocused()) {
                                                    return;
                                                }
                                                TextFieldSelectionManager.m640deselect_kEHs6E$foundation_release$default(textFieldSelectionManager, null, 1, null);
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue10);
                                        MutableInteractionSource mutableInteractionSource72 = mutableInteractionSource3;
                                        textFieldFocusModifier = TextFieldGestureModifiersKt.textFieldFocusModifier(companion2, z8, focusRequester, mutableInteractionSource72, (Function1) rememberedValue10);
                                        State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf((z8 || z10) ? false : true), startRestartGroup, 0);
                                        Unit unit2 = Unit.INSTANCE;
                                        boolean changed32 = startRestartGroup.changed(rememberUpdatedState2) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                        if (i27 > 32) {
                                        }
                                        modifier4 = textFieldFocusModifier;
                                        if ((i29 & 48) != 32) {
                                        }
                                        z13 = true;
                                        z14 = changed32 | z13;
                                        rememberedValue11 = startRestartGroup.rememberedValue();
                                        if (!z14) {
                                        }
                                        rememberedValue11 = new CoreTextFieldKt$CoreTextField$2$1(legacyTextFieldState, rememberUpdatedState2, textInputService, textFieldSelectionManager, imeOptions5, null);
                                        startRestartGroup.updateRememberedValue(rememberedValue11);
                                        EffectsKt.LaunchedEffect(unit2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue11, startRestartGroup, 6);
                                        changedInstance2 = startRestartGroup.changedInstance(legacyTextFieldState);
                                        rememberedValue12 = startRestartGroup.rememberedValue();
                                        if (!changedInstance2) {
                                        }
                                        rememberedValue12 = new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                                invoke(bool.booleanValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(boolean z2222) {
                                                LegacyTextFieldState.this.setInTouchMode(z2222);
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue12);
                                        Modifier updateSelectionTouchMode22 = SelectionGesturesKt.updateSelectionTouchMode(companion2, (Function1) rememberedValue12);
                                        int i4022 = i28;
                                        changedInstance3 = startRestartGroup.changedInstance(legacyTextFieldState) | (i4022 != 16384) | (i38 != 2048) | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                        rememberedValue13 = startRestartGroup.rememberedValue();
                                        if (!changedInstance3) {
                                        }
                                        final boolean z2222 = z10;
                                        final boolean z2322 = z8;
                                        rememberedValue13 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                                m473invokek4lQ0M(offset.getPackedValue());
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                                            public final void m473invokek4lQ0M(long j5) {
                                                CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester, !z2222);
                                                if (LegacyTextFieldState.this.getHasFocus() && z2322) {
                                                    if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                                                        textFieldSelectionManager.m643deselect_kEHs6E$foundation_release(Offset.m1328boximpl(j5));
                                                        return;
                                                    }
                                                    TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                    if (layoutResult != null) {
                                                        LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                                        TextFieldDelegate.INSTANCE.m532setCursorOffsetULxng0E$foundation_release(j5, layoutResult, legacyTextFieldState2.getProcessor(), offsetMapping, legacyTextFieldState2.getOnValueChange());
                                                        if (legacyTextFieldState2.getTextDelegate().getText().length() > 0) {
                                                            legacyTextFieldState2.setHandleState(HandleState.Cursor);
                                                        }
                                                    }
                                                }
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue13);
                                        Modifier pointerHoverIcon$default22 = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(updateSelectionTouchMode22, mutableInteractionSource72, z8, (Function1) rememberedValue13), textFieldSelectionManager.getMouseSelectionObserver(), textFieldSelectionManager.getTouchSelectionObserver()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                                        changedInstance4 = startRestartGroup.changedInstance(legacyTextFieldState) | (i37 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                        rememberedValue14 = startRestartGroup.rememberedValue();
                                        if (!changedInstance4) {
                                        }
                                        rememberedValue14 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                                invoke2(drawScope);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(DrawScope drawScope) {
                                                TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                if (layoutResult != null) {
                                                    TextFieldValue textFieldValue2 = textFieldValue;
                                                    LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                                    OffsetMapping offsetMapping2 = offsetMapping;
                                                    TextFieldDelegate.INSTANCE.m530drawQ1vqE60$foundation_release(drawScope.getDrawContext().getCanvas(), textFieldValue2, legacyTextFieldState2.m488getSelectionPreviewHighlightRanged9O1mEE(), legacyTextFieldState2.m485getDeletionPreviewHighlightRanged9O1mEE(), offsetMapping2, layoutResult.getValue(), legacyTextFieldState2.getHighlightPaint(), legacyTextFieldState2.getSelectionBackgroundColor());
                                                }
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue14);
                                        final Modifier drawBehind22 = DrawModifierKt.drawBehind(companion2, (Function1) rememberedValue14);
                                        changedInstance5 = startRestartGroup.changedInstance(legacyTextFieldState) | (i38 != 2048) | startRestartGroup.changed(windowInfo) | startRestartGroup.changedInstance(textFieldSelectionManager) | (i37 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                        rememberedValue15 = startRestartGroup.rememberedValue();
                                        if (!changedInstance5) {
                                        }
                                        final boolean z2422 = z8;
                                        rememberedValue15 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                                invoke2(layoutCoordinates);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                                LegacyTextFieldState.this.setLayoutCoordinates(layoutCoordinates);
                                                TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                if (layoutResult != null) {
                                                    layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
                                                }
                                                if (z2422) {
                                                    if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                                                        if (LegacyTextFieldState.this.getShowFloatingToolbar() && windowInfo.isWindowFocused()) {
                                                            textFieldSelectionManager.showSelectionToolbar$foundation_release();
                                                        } else {
                                                            textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                                                        }
                                                        LegacyTextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true));
                                                        LegacyTextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, false));
                                                        LegacyTextFieldState.this.setShowCursorHandle(TextRange.m2279getCollapsedimpl(textFieldValue.getSelection()));
                                                    } else if (LegacyTextFieldState.this.getHandleState() == HandleState.Cursor) {
                                                        LegacyTextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true));
                                                    }
                                                    CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue, offsetMapping);
                                                    TextLayoutResultProxy layoutResult2 = LegacyTextFieldState.this.getLayoutResult();
                                                    if (layoutResult2 != null) {
                                                        LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                                        TextFieldValue textFieldValue2 = textFieldValue;
                                                        OffsetMapping offsetMapping2 = offsetMapping;
                                                        TextInputSession inputSession = legacyTextFieldState2.getInputSession();
                                                        if (inputSession == null || !legacyTextFieldState2.getHasFocus()) {
                                                            return;
                                                        }
                                                        TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation_release(inputSession, textFieldValue2, offsetMapping2, layoutResult2);
                                                    }
                                                }
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue15);
                                        final Modifier onGloballyPositioned32 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) rememberedValue15);
                                        final boolean z2522 = visualTransformation4 instanceof PasswordVisualTransformation;
                                        changedInstance6 = (i38 != 2048) | startRestartGroup.changedInstance(transformedText) | (i37 != 4) | startRestartGroup.changed(z2522) | (i4022 != 16384) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(textFieldSelectionManager) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32);
                                        rememberedValue16 = startRestartGroup.rememberedValue();
                                        if (!changedInstance6) {
                                        }
                                        final boolean z2622 = z8;
                                        final boolean z2722 = z10;
                                        final ImeOptions imeOptions822 = imeOptions5;
                                        rememberedValue16 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                invoke2(semanticsPropertyReceiver);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(final SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, TransformedText.this.getText());
                                                SemanticsPropertiesKt.m2185setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, textFieldValue.getSelection());
                                                if (!z2622) {
                                                    SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                                                }
                                                if (z2522) {
                                                    SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                                                }
                                                boolean z282 = z2622 && !z2722;
                                                SemanticsPropertiesKt.setEditable(semanticsPropertyReceiver, z282);
                                                final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                                                SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Boolean invoke(List<TextLayoutResult> list) {
                                                        boolean z2922;
                                                        if (LegacyTextFieldState.this.getLayoutResult() != null) {
                                                            TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                            Intrinsics.checkNotNull(layoutResult);
                                                            list.add(layoutResult.getValue());
                                                            z2922 = true;
                                                        } else {
                                                            z2922 = false;
                                                        }
                                                        return Boolean.valueOf(z2922);
                                                    }
                                                }, 1, null);
                                                if (z282) {
                                                    final LegacyTextFieldState legacyTextFieldState3 = legacyTextFieldState;
                                                    SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Boolean invoke(AnnotatedString annotatedString) {
                                                            Unit unit22;
                                                            TextInputSession inputSession = LegacyTextFieldState.this.getInputSession();
                                                            if (inputSession != null) {
                                                                LegacyTextFieldState legacyTextFieldState4 = LegacyTextFieldState.this;
                                                                TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(annotatedString, 1)}), legacyTextFieldState4.getProcessor(), legacyTextFieldState4.getOnValueChange(), inputSession);
                                                                unit22 = Unit.INSTANCE;
                                                            } else {
                                                                unit22 = null;
                                                            }
                                                            if (unit22 == null) {
                                                                LegacyTextFieldState.this.getOnValueChange().invoke(new TextFieldValue(annotatedString.getText(), TextRangeKt.TextRange(annotatedString.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                            }
                                                            return Boolean.TRUE;
                                                        }
                                                    }, 1, null);
                                                    final boolean z2922 = z2722;
                                                    final boolean z3022 = z2622;
                                                    final LegacyTextFieldState legacyTextFieldState4 = legacyTextFieldState;
                                                    final TextFieldValue textFieldValue2 = textFieldValue;
                                                    SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.3
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Boolean invoke(AnnotatedString annotatedString) {
                                                            Unit unit22;
                                                            if (!z2922 && z3022) {
                                                                TextInputSession inputSession = legacyTextFieldState4.getInputSession();
                                                                if (inputSession != null) {
                                                                    LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                                                    TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(annotatedString, 1)}), legacyTextFieldState5.getProcessor(), legacyTextFieldState5.getOnValueChange(), inputSession);
                                                                    unit22 = Unit.INSTANCE;
                                                                } else {
                                                                    unit22 = null;
                                                                }
                                                                if (unit22 == null) {
                                                                    TextFieldValue textFieldValue3 = textFieldValue2;
                                                                    legacyTextFieldState4.getOnValueChange().invoke(new TextFieldValue(StringsKt.replaceRange(textFieldValue3.getText(), TextRange.m2285getStartimpl(textFieldValue3.getSelection()), TextRange.m2280getEndimpl(textFieldValue3.getSelection()), annotatedString).toString(), TextRangeKt.TextRange(TextRange.m2285getStartimpl(textFieldValue3.getSelection()) + annotatedString.length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                                }
                                                                return Boolean.TRUE;
                                                            }
                                                            return Boolean.FALSE;
                                                        }
                                                    }, 1, null);
                                                }
                                                final OffsetMapping offsetMapping2 = offsetMapping;
                                                final boolean z3122 = z2622;
                                                final TextFieldValue textFieldValue3 = textFieldValue;
                                                final TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                                final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState;
                                                SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.4
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                                                        return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                                                    }

                                                    public final Boolean invoke(int i4122, int i42, boolean z32) {
                                                        if (!z32) {
                                                            i4122 = OffsetMapping.this.transformedToOriginal(i4122);
                                                        }
                                                        if (!z32) {
                                                            i42 = OffsetMapping.this.transformedToOriginal(i42);
                                                        }
                                                        boolean z33 = false;
                                                        if (z3122 && (i4122 != TextRange.m2285getStartimpl(textFieldValue3.getSelection()) || i42 != TextRange.m2280getEndimpl(textFieldValue3.getSelection()))) {
                                                            if (Math.min(i4122, i42) >= 0 && Math.max(i4122, i42) <= textFieldValue3.getText().length()) {
                                                                if (!z32 && i4122 != i42) {
                                                                    TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager2, false, 1, null);
                                                                } else {
                                                                    textFieldSelectionManager2.exitSelectionMode$foundation_release();
                                                                }
                                                                legacyTextFieldState5.getOnValueChange().invoke(new TextFieldValue(textFieldValue3.getText(), TextRangeKt.TextRange(i4122, i42), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                                z33 = true;
                                                            } else {
                                                                textFieldSelectionManager2.exitSelectionMode$foundation_release();
                                                            }
                                                        }
                                                        return Boolean.valueOf(z33);
                                                    }
                                                }, 1, null);
                                                int imeAction = imeOptions822.getImeAction();
                                                final LegacyTextFieldState legacyTextFieldState6 = legacyTextFieldState;
                                                final ImeOptions imeOptions922 = imeOptions822;
                                                SemanticsPropertiesKt.m2182onImeAction9UiTYpY$default(semanticsPropertyReceiver, imeAction, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.5
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Boolean invoke() {
                                                        LegacyTextFieldState.this.getOnImeActionPerformed().invoke(ImeAction.m2375boximpl(imeOptions922.getImeAction()));
                                                        return Boolean.TRUE;
                                                    }
                                                }, 2, null);
                                                final LegacyTextFieldState legacyTextFieldState7 = legacyTextFieldState;
                                                final FocusRequester focusRequester2 = focusRequester;
                                                final boolean z32 = z2722;
                                                SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.6
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Boolean invoke() {
                                                        CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester2, !z32);
                                                        return Boolean.TRUE;
                                                    }
                                                }, 1, null);
                                                final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager;
                                                SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.7
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Boolean invoke() {
                                                        TextFieldSelectionManager.enterSelectionMode$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                                        return Boolean.TRUE;
                                                    }
                                                }, 1, null);
                                                if (!TextRange.m2279getCollapsedimpl(textFieldValue.getSelection()) && !z2522) {
                                                    final TextFieldSelectionManager textFieldSelectionManager4 = textFieldSelectionManager;
                                                    SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.8
                                                        {
                                                            super(0);
                                                        }

                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Boolean invoke() {
                                                            TextFieldSelectionManager.copy$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                                            return Boolean.TRUE;
                                                        }
                                                    }, 1, null);
                                                    if (z2622 && !z2722) {
                                                        final TextFieldSelectionManager textFieldSelectionManager5 = textFieldSelectionManager;
                                                        SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.9
                                                            {
                                                                super(0);
                                                            }

                                                            /* JADX WARN: Can't rename method to resolve collision */
                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Boolean invoke() {
                                                                TextFieldSelectionManager.this.cut$foundation_release();
                                                                return Boolean.TRUE;
                                                            }
                                                        }, 1, null);
                                                    }
                                                }
                                                if (!z2622 || z2722) {
                                                    return;
                                                }
                                                final TextFieldSelectionManager textFieldSelectionManager6 = textFieldSelectionManager;
                                                SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.10
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Boolean invoke() {
                                                        TextFieldSelectionManager.this.paste$foundation_release();
                                                        return Boolean.TRUE;
                                                    }
                                                }, 1, null);
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue16);
                                        Modifier semantics22 = SemanticsModifierKt.semantics(companion2, true, (Function1) rememberedValue16);
                                        final Modifier cursor22 = TextFieldCursorKt.cursor(companion2, legacyTextFieldState, textFieldValue, offsetMapping, brush3, (z8 || z10 || !windowInfo.isWindowFocused() || legacyTextFieldState.hasHighlight()) ? false : true);
                                        changedInstance7 = startRestartGroup.changedInstance(textFieldSelectionManager);
                                        rememberedValue17 = startRestartGroup.rememberedValue();
                                        if (!changedInstance7) {
                                        }
                                        rememberedValue17 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                                final TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                                                return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1$invoke$$inlined$onDispose$1
                                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                                    public void dispose() {
                                                        TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                                                    }
                                                };
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue17);
                                        EffectsKt.DisposableEffect(textFieldSelectionManager, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue17, startRestartGroup, 0);
                                        changedInstance8 = (i37 != 4) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32);
                                        rememberedValue18 = startRestartGroup.rememberedValue();
                                        if (!changedInstance8) {
                                        }
                                        rememberedValue18 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                                if (LegacyTextFieldState.this.getHasFocus()) {
                                                    LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                                    legacyTextFieldState2.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(textInputService, textFieldValue, legacyTextFieldState2.getProcessor(), imeOptions5, LegacyTextFieldState.this.getOnValueChange(), LegacyTextFieldState.this.getOnImeActionPerformed()));
                                                }
                                                return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1$invoke$$inlined$onDispose$1
                                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                                    public void dispose() {
                                                    }
                                                };
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue18);
                                        EffectsKt.DisposableEffect(imeOptions5, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue18, startRestartGroup, (i29 >> 3) & 14);
                                        Modifier m539textFieldKeyInput2WJ9YEU22 = TextFieldKeyInputKt.m539textFieldKeyInput2WJ9YEU(companion2, legacyTextFieldState, textFieldSelectionManager, textFieldValue, legacyTextFieldState.getOnValueChange(), !z10, i36 != 1, offsetMapping, undoManager, imeOptions5.getImeAction());
                                        boolean CoreTextField$lambda$1122 = CoreTextField$lambda$11(rememberUpdatedState2);
                                        changedInstance9 = startRestartGroup.changedInstance(legacyTextFieldState) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32) | startRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter);
                                        rememberedValue19 = startRestartGroup.rememberedValue();
                                        if (!changedInstance9) {
                                        }
                                        rememberedValue19 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$stylusHandwritingModifier$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                if (!LegacyTextFieldState.this.getHasFocus()) {
                                                    focusRequester.requestFocus();
                                                }
                                                int keyboardType = imeOptions5.getKeyboardType();
                                                KeyboardType.Companion companion3 = KeyboardType.INSTANCE;
                                                if (!KeyboardType.m2410equalsimpl0(keyboardType, companion3.m2419getPasswordPjHm6EE()) && !KeyboardType.m2410equalsimpl0(imeOptions5.getKeyboardType(), companion3.m2418getNumberPasswordPjHm6EE())) {
                                                    legacyPlatformTextInputServiceAdapter.startStylusHandwriting();
                                                }
                                                return Boolean.TRUE;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue19);
                                        Modifier onGloballyPositioned222 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier7, legacyPlatformTextInputServiceAdapter, legacyTextFieldState, textFieldSelectionManager).then(StylusHandwritingKt.stylusHandwriting(companion2, CoreTextField$lambda$1122, (Function0) rememberedValue19)).then(modifier4), legacyTextFieldState, focusManager), legacyTextFieldState, textFieldSelectionManager).then(m539textFieldKeyInput2WJ9YEU22), textFieldScrollerPosition, mutableInteractionSource72, z8).then(pointerHoverIcon$default22).then(semantics22), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                                invoke2(layoutCoordinates);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                                TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                if (layoutResult == null) {
                                                    return;
                                                }
                                                layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                                            }
                                        });
                                        if (z8) {
                                        }
                                        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3422 = function32;
                                        final TextStyle textStyle522 = textStyle2;
                                        final int i4122 = i25;
                                        boolean z2922 = z8;
                                        ImeOptions imeOptions922 = imeOptions5;
                                        final Modifier textFieldMagnifier22 = !z28 ? TextFieldSelectionManager_androidKt.textFieldMagnifier(companion2, textFieldSelectionManager) : companion2;
                                        final boolean z3022 = z28;
                                        final boolean z3122 = z10;
                                        final Function1<? super TextLayoutResult, Unit> function1622 = function13;
                                        composer2 = startRestartGroup;
                                        CoreTextFieldRootBox(onGloballyPositioned222, textFieldSelectionManager, ComposableLambdaKt.rememberComposableLambda(-374338080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i42) {
                                                if ((i42 & 3) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-374338080, i42, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:695)");
                                                }
                                                Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function35 = function3422;
                                                final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                                                final TextStyle textStyle6 = textStyle522;
                                                final int i43 = i4122;
                                                final int i44 = i36;
                                                final TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                                                final TextFieldValue textFieldValue2 = textFieldValue;
                                                final VisualTransformation visualTransformation5 = visualTransformation4;
                                                final Modifier modifier8 = cursor22;
                                                final Modifier modifier9 = drawBehind22;
                                                final Modifier modifier10 = onGloballyPositioned32;
                                                final Modifier modifier11 = textFieldMagnifier22;
                                                final BringIntoViewRequester bringIntoViewRequester2 = bringIntoViewRequester;
                                                final TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                                final boolean z32 = z3022;
                                                final boolean z33 = z3122;
                                                final Function1<? super TextLayoutResult, Unit> function17 = function1622;
                                                final OffsetMapping offsetMapping2 = offsetMapping;
                                                final Density density2 = density;
                                                function35.invoke(ComposableLambdaKt.rememberComposableLambda(2032502107, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                        invoke(composer4, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer4, int i45) {
                                                        if ((i45 & 3) == 2 && composer4.getSkipping()) {
                                                            composer4.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(2032502107, i45, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:698)");
                                                        }
                                                        Modifier heightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m327heightInVpY3zN4$default(Modifier.INSTANCE, LegacyTextFieldState.this.m486getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle6, i43, i44);
                                                        TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition2;
                                                        TextFieldValue textFieldValue3 = textFieldValue2;
                                                        VisualTransformation visualTransformation6 = visualTransformation5;
                                                        boolean changedInstance11 = composer4.changedInstance(LegacyTextFieldState.this);
                                                        final LegacyTextFieldState legacyTextFieldState3 = LegacyTextFieldState.this;
                                                        Object rememberedValue21 = composer4.rememberedValue();
                                                        if (changedInstance11 || rememberedValue21 == Composer.INSTANCE.getEmpty()) {
                                                            rememberedValue21 = new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1$1
                                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                                {
                                                                    super(0);
                                                                }

                                                                /* JADX WARN: Can't rename method to resolve collision */
                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final TextLayoutResultProxy invoke() {
                                                                    return LegacyTextFieldState.this.getLayoutResult();
                                                                }
                                                            };
                                                            composer4.updateRememberedValue(rememberedValue21);
                                                        }
                                                        Modifier bringIntoViewRequester3 = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(heightInLines, textFieldScrollerPosition3, textFieldValue3, visualTransformation6, (Function0) rememberedValue21).then(modifier8).then(modifier9), textStyle6).then(modifier10).then(modifier11), bringIntoViewRequester2);
                                                        final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager2;
                                                        final LegacyTextFieldState legacyTextFieldState4 = LegacyTextFieldState.this;
                                                        final boolean z34 = z32;
                                                        final boolean z35 = z33;
                                                        final Function1<? super TextLayoutResult, Unit> function18 = function17;
                                                        final TextFieldValue textFieldValue4 = textFieldValue2;
                                                        final OffsetMapping offsetMapping3 = offsetMapping2;
                                                        final Density density3 = density2;
                                                        final int i46 = i44;
                                                        SimpleLayoutKt.SimpleLayout(bringIntoViewRequester3, ComposableLambdaKt.rememberComposableLambda(-363167407, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                                invoke(composer5, num.intValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            /* JADX WARN: Removed duplicated region for block: B:39:0x00ff  */
                                                            /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
                                                            /*
                                                                Code decompiled incorrectly, please refer to instructions dump.
                                                            */
                                                            public final void invoke(Composer composer5, int i47) {
                                                                boolean z36;
                                                                if ((i47 & 3) == 2 && composer5.getSkipping()) {
                                                                    composer5.skipToGroupEnd();
                                                                    return;
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-363167407, i47, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:721)");
                                                                }
                                                                final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                                                final Function1<? super TextLayoutResult, Unit> function19 = function18;
                                                                final TextFieldValue textFieldValue5 = textFieldValue4;
                                                                final OffsetMapping offsetMapping4 = offsetMapping3;
                                                                final Density density4 = density3;
                                                                final int i48 = i46;
                                                                MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                                    @Override // androidx.compose.ui.layout.MeasurePolicy
                                                                    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i49) {
                                                                        LegacyTextFieldState.this.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                                                        return LegacyTextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                                                    }

                                                                    @Override // androidx.compose.ui.layout.MeasurePolicy
                                                                    /* renamed from: measure-3p2s80s */
                                                                    public MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                                                                        Snapshot.Companion companion3 = Snapshot.INSTANCE;
                                                                        LegacyTextFieldState legacyTextFieldState6 = LegacyTextFieldState.this;
                                                                        Snapshot currentThreadSnapshot = companion3.getCurrentThreadSnapshot();
                                                                        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                                                        Snapshot makeCurrentNonObservable = companion3.makeCurrentNonObservable(currentThreadSnapshot);
                                                                        try {
                                                                            TextLayoutResultProxy layoutResult = legacyTextFieldState6.getLayoutResult();
                                                                            TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                                                            Triple<Integer, Integer, TextLayoutResult> m531layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m531layout_EkL_Y$foundation_release(LegacyTextFieldState.this.getTextDelegate(), j5, measureScope.getLayoutDirection(), value);
                                                                            int intValue = m531layout_EkL_Y$foundation_release.component1().intValue();
                                                                            int intValue2 = m531layout_EkL_Y$foundation_release.component2().intValue();
                                                                            TextLayoutResult component3 = m531layout_EkL_Y$foundation_release.component3();
                                                                            if (!Intrinsics.areEqual(value, component3)) {
                                                                                LegacyTextFieldState.this.setLayoutResult(new TextLayoutResultProxy(component3, null, layoutResult != null ? layoutResult.getDecorationBoxCoordinates() : null, 2, null));
                                                                                function19.invoke(component3);
                                                                                CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue5, offsetMapping4);
                                                                            }
                                                                            LegacyTextFieldState.this.m490setMinHeightForSingleLineField0680j_4(density4.mo209toDpu2uoSUM(i48 == 1 ? TextDelegateKt.ceilToIntPx(component3.getLineBottom(0)) : 0));
                                                                            return measureScope.layout(intValue, intValue2, MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(component3.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(component3.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                                    invoke2(placementScope);
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                        } finally {
                                                                            companion3.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                                                        }
                                                                    }
                                                                };
                                                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                                CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, companion3);
                                                                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                                                Function0<ComposeUiNode> constructor = companion4.getConstructor();
                                                                if (composer5.getApplier() == null) {
                                                                    ComposablesKt.invalidApplier();
                                                                }
                                                                composer5.startReusableNode();
                                                                if (composer5.getInserting()) {
                                                                    composer5.createNode(constructor);
                                                                } else {
                                                                    composer5.useNode();
                                                                }
                                                                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer5);
                                                                Updater.m1227setimpl(m1226constructorimpl, measurePolicy, companion4.getSetMeasurePolicy());
                                                                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                                                                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                                }
                                                                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
                                                                composer5.endNode();
                                                                TextFieldSelectionManager textFieldSelectionManager4 = TextFieldSelectionManager.this;
                                                                if (legacyTextFieldState4.getHandleState() != HandleState.None && legacyTextFieldState4.getLayoutCoordinates() != null) {
                                                                    LayoutCoordinates layoutCoordinates = legacyTextFieldState4.getLayoutCoordinates();
                                                                    Intrinsics.checkNotNull(layoutCoordinates);
                                                                    if (layoutCoordinates.isAttached() && z34) {
                                                                        z36 = true;
                                                                        CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z36, composer5, 0);
                                                                        if (legacyTextFieldState4.getHandleState() != HandleState.Cursor && !z35 && z34) {
                                                                            composer5.startReplaceGroup(-2032274);
                                                                            CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer5, 0);
                                                                            composer5.endReplaceGroup();
                                                                        } else {
                                                                            composer5.startReplaceGroup(-1955394);
                                                                            composer5.endReplaceGroup();
                                                                        }
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            return;
                                                                        }
                                                                        ComposerKt.traceEventEnd();
                                                                        return;
                                                                    }
                                                                }
                                                                z36 = false;
                                                                CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z36, composer5, 0);
                                                                if (legacyTextFieldState4.getHandleState() != HandleState.Cursor) {
                                                                }
                                                                composer5.startReplaceGroup(-1955394);
                                                                composer5.endReplaceGroup();
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                }
                                                            }
                                                        }, composer4, 54), composer4, 48, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, composer3, 54), composer3, 6);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composer2, 54), composer2, 384);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        textStyle3 = textStyle2;
                                        function14 = function13;
                                        visualTransformation3 = visualTransformation4;
                                        modifier5 = modifier7;
                                        brush4 = brush3;
                                        z15 = z9;
                                        i30 = i25;
                                        z16 = z2922;
                                        keyboardActions3 = keyboardActions2;
                                        imeOptions6 = imeOptions922;
                                        i31 = i36;
                                        mutableInteractionSource4 = mutableInteractionSource72;
                                        z17 = z10;
                                        function33 = function32;
                                    }
                                    z12 = true;
                                    changedInstance = changedInstance10 | z12 | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(bringIntoViewRequester) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                    rememberedValue10 = startRestartGroup.rememberedValue();
                                    if (!changedInstance) {
                                    }
                                    final boolean z2022 = z8;
                                    final boolean z2122 = z10;
                                    final ImeOptions imeOptions722 = imeOptions5;
                                    rememberedValue10 = new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                                            invoke2(focusState);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(FocusState focusState) {
                                            TextLayoutResultProxy layoutResult;
                                            if (LegacyTextFieldState.this.getHasFocus() == focusState.isFocused()) {
                                                return;
                                            }
                                            LegacyTextFieldState.this.setHasFocus(focusState.isFocused());
                                            if (LegacyTextFieldState.this.getHasFocus() && z2022 && !z2122) {
                                                CoreTextFieldKt.startInputSession(textInputService, LegacyTextFieldState.this, textFieldValue, imeOptions722, offsetMapping);
                                            } else {
                                                CoreTextFieldKt.endInputSession(LegacyTextFieldState.this);
                                            }
                                            if (focusState.isFocused() && (layoutResult = LegacyTextFieldState.this.getLayoutResult()) != null) {
                                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(bringIntoViewRequester, textFieldValue, LegacyTextFieldState.this, layoutResult, offsetMapping, null), 3, null);
                                            }
                                            if (focusState.isFocused()) {
                                                return;
                                            }
                                            TextFieldSelectionManager.m640deselect_kEHs6E$foundation_release$default(textFieldSelectionManager, null, 1, null);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue10);
                                    MutableInteractionSource mutableInteractionSource722 = mutableInteractionSource3;
                                    textFieldFocusModifier = TextFieldGestureModifiersKt.textFieldFocusModifier(companion2, z8, focusRequester, mutableInteractionSource722, (Function1) rememberedValue10);
                                    State rememberUpdatedState22 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf((z8 || z10) ? false : true), startRestartGroup, 0);
                                    Unit unit22 = Unit.INSTANCE;
                                    boolean changed322 = startRestartGroup.changed(rememberUpdatedState22) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                    if (i27 > 32) {
                                    }
                                    modifier4 = textFieldFocusModifier;
                                    if ((i29 & 48) != 32) {
                                    }
                                    z13 = true;
                                    z14 = changed322 | z13;
                                    rememberedValue11 = startRestartGroup.rememberedValue();
                                    if (!z14) {
                                    }
                                    rememberedValue11 = new CoreTextFieldKt$CoreTextField$2$1(legacyTextFieldState, rememberUpdatedState22, textInputService, textFieldSelectionManager, imeOptions5, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue11);
                                    EffectsKt.LaunchedEffect(unit22, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue11, startRestartGroup, 6);
                                    changedInstance2 = startRestartGroup.changedInstance(legacyTextFieldState);
                                    rememberedValue12 = startRestartGroup.rememberedValue();
                                    if (!changedInstance2) {
                                    }
                                    rememberedValue12 = new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                            invoke(bool.booleanValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(boolean z22222) {
                                            LegacyTextFieldState.this.setInTouchMode(z22222);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue12);
                                    Modifier updateSelectionTouchMode222 = SelectionGesturesKt.updateSelectionTouchMode(companion2, (Function1) rememberedValue12);
                                    int i40222 = i28;
                                    changedInstance3 = startRestartGroup.changedInstance(legacyTextFieldState) | (i40222 != 16384) | (i38 != 2048) | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                    rememberedValue13 = startRestartGroup.rememberedValue();
                                    if (!changedInstance3) {
                                    }
                                    final boolean z22222 = z10;
                                    final boolean z23222 = z8;
                                    rememberedValue13 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                            m473invokek4lQ0M(offset.getPackedValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                                        public final void m473invokek4lQ0M(long j5) {
                                            CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester, !z22222);
                                            if (LegacyTextFieldState.this.getHasFocus() && z23222) {
                                                if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                                                    textFieldSelectionManager.m643deselect_kEHs6E$foundation_release(Offset.m1328boximpl(j5));
                                                    return;
                                                }
                                                TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                if (layoutResult != null) {
                                                    LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                                    TextFieldDelegate.INSTANCE.m532setCursorOffsetULxng0E$foundation_release(j5, layoutResult, legacyTextFieldState2.getProcessor(), offsetMapping, legacyTextFieldState2.getOnValueChange());
                                                    if (legacyTextFieldState2.getTextDelegate().getText().length() > 0) {
                                                        legacyTextFieldState2.setHandleState(HandleState.Cursor);
                                                    }
                                                }
                                            }
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue13);
                                    Modifier pointerHoverIcon$default222 = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(updateSelectionTouchMode222, mutableInteractionSource722, z8, (Function1) rememberedValue13), textFieldSelectionManager.getMouseSelectionObserver(), textFieldSelectionManager.getTouchSelectionObserver()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                                    changedInstance4 = startRestartGroup.changedInstance(legacyTextFieldState) | (i37 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                    rememberedValue14 = startRestartGroup.rememberedValue();
                                    if (!changedInstance4) {
                                    }
                                    rememberedValue14 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                            invoke2(drawScope);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(DrawScope drawScope) {
                                            TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                            if (layoutResult != null) {
                                                TextFieldValue textFieldValue2 = textFieldValue;
                                                LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                                OffsetMapping offsetMapping2 = offsetMapping;
                                                TextFieldDelegate.INSTANCE.m530drawQ1vqE60$foundation_release(drawScope.getDrawContext().getCanvas(), textFieldValue2, legacyTextFieldState2.m488getSelectionPreviewHighlightRanged9O1mEE(), legacyTextFieldState2.m485getDeletionPreviewHighlightRanged9O1mEE(), offsetMapping2, layoutResult.getValue(), legacyTextFieldState2.getHighlightPaint(), legacyTextFieldState2.getSelectionBackgroundColor());
                                            }
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue14);
                                    final Modifier drawBehind222 = DrawModifierKt.drawBehind(companion2, (Function1) rememberedValue14);
                                    changedInstance5 = startRestartGroup.changedInstance(legacyTextFieldState) | (i38 != 2048) | startRestartGroup.changed(windowInfo) | startRestartGroup.changedInstance(textFieldSelectionManager) | (i37 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                    rememberedValue15 = startRestartGroup.rememberedValue();
                                    if (!changedInstance5) {
                                    }
                                    final boolean z24222 = z8;
                                    rememberedValue15 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                            invoke2(layoutCoordinates);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                            LegacyTextFieldState.this.setLayoutCoordinates(layoutCoordinates);
                                            TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                            if (layoutResult != null) {
                                                layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
                                            }
                                            if (z24222) {
                                                if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                                                    if (LegacyTextFieldState.this.getShowFloatingToolbar() && windowInfo.isWindowFocused()) {
                                                        textFieldSelectionManager.showSelectionToolbar$foundation_release();
                                                    } else {
                                                        textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                                                    }
                                                    LegacyTextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true));
                                                    LegacyTextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, false));
                                                    LegacyTextFieldState.this.setShowCursorHandle(TextRange.m2279getCollapsedimpl(textFieldValue.getSelection()));
                                                } else if (LegacyTextFieldState.this.getHandleState() == HandleState.Cursor) {
                                                    LegacyTextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true));
                                                }
                                                CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue, offsetMapping);
                                                TextLayoutResultProxy layoutResult2 = LegacyTextFieldState.this.getLayoutResult();
                                                if (layoutResult2 != null) {
                                                    LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                                    TextFieldValue textFieldValue2 = textFieldValue;
                                                    OffsetMapping offsetMapping2 = offsetMapping;
                                                    TextInputSession inputSession = legacyTextFieldState2.getInputSession();
                                                    if (inputSession == null || !legacyTextFieldState2.getHasFocus()) {
                                                        return;
                                                    }
                                                    TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation_release(inputSession, textFieldValue2, offsetMapping2, layoutResult2);
                                                }
                                            }
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue15);
                                    final Modifier onGloballyPositioned322 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2, (Function1) rememberedValue15);
                                    final boolean z25222 = visualTransformation4 instanceof PasswordVisualTransformation;
                                    changedInstance6 = (i38 != 2048) | startRestartGroup.changedInstance(transformedText) | (i37 != 4) | startRestartGroup.changed(z25222) | (i40222 != 16384) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(textFieldSelectionManager) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32);
                                    rememberedValue16 = startRestartGroup.rememberedValue();
                                    if (!changedInstance6) {
                                    }
                                    final boolean z26222 = z8;
                                    final boolean z27222 = z10;
                                    final ImeOptions imeOptions8222 = imeOptions5;
                                    rememberedValue16 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            invoke2(semanticsPropertyReceiver);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(final SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, TransformedText.this.getText());
                                            SemanticsPropertiesKt.m2185setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, textFieldValue.getSelection());
                                            if (!z26222) {
                                                SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                                            }
                                            if (z25222) {
                                                SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                                            }
                                            boolean z282 = z26222 && !z27222;
                                            SemanticsPropertiesKt.setEditable(semanticsPropertyReceiver, z282);
                                            final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                                            SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Boolean invoke(List<TextLayoutResult> list) {
                                                    boolean z29222;
                                                    if (LegacyTextFieldState.this.getLayoutResult() != null) {
                                                        TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                        Intrinsics.checkNotNull(layoutResult);
                                                        list.add(layoutResult.getValue());
                                                        z29222 = true;
                                                    } else {
                                                        z29222 = false;
                                                    }
                                                    return Boolean.valueOf(z29222);
                                                }
                                            }, 1, null);
                                            if (z282) {
                                                final LegacyTextFieldState legacyTextFieldState3 = legacyTextFieldState;
                                                SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Boolean invoke(AnnotatedString annotatedString) {
                                                        Unit unit222;
                                                        TextInputSession inputSession = LegacyTextFieldState.this.getInputSession();
                                                        if (inputSession != null) {
                                                            LegacyTextFieldState legacyTextFieldState4 = LegacyTextFieldState.this;
                                                            TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(annotatedString, 1)}), legacyTextFieldState4.getProcessor(), legacyTextFieldState4.getOnValueChange(), inputSession);
                                                            unit222 = Unit.INSTANCE;
                                                        } else {
                                                            unit222 = null;
                                                        }
                                                        if (unit222 == null) {
                                                            LegacyTextFieldState.this.getOnValueChange().invoke(new TextFieldValue(annotatedString.getText(), TextRangeKt.TextRange(annotatedString.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                        }
                                                        return Boolean.TRUE;
                                                    }
                                                }, 1, null);
                                                final boolean z29222 = z27222;
                                                final boolean z30222 = z26222;
                                                final LegacyTextFieldState legacyTextFieldState4 = legacyTextFieldState;
                                                final TextFieldValue textFieldValue2 = textFieldValue;
                                                SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Boolean invoke(AnnotatedString annotatedString) {
                                                        Unit unit222;
                                                        if (!z29222 && z30222) {
                                                            TextInputSession inputSession = legacyTextFieldState4.getInputSession();
                                                            if (inputSession != null) {
                                                                LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                                                TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(annotatedString, 1)}), legacyTextFieldState5.getProcessor(), legacyTextFieldState5.getOnValueChange(), inputSession);
                                                                unit222 = Unit.INSTANCE;
                                                            } else {
                                                                unit222 = null;
                                                            }
                                                            if (unit222 == null) {
                                                                TextFieldValue textFieldValue3 = textFieldValue2;
                                                                legacyTextFieldState4.getOnValueChange().invoke(new TextFieldValue(StringsKt.replaceRange(textFieldValue3.getText(), TextRange.m2285getStartimpl(textFieldValue3.getSelection()), TextRange.m2280getEndimpl(textFieldValue3.getSelection()), annotatedString).toString(), TextRangeKt.TextRange(TextRange.m2285getStartimpl(textFieldValue3.getSelection()) + annotatedString.length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                            }
                                                            return Boolean.TRUE;
                                                        }
                                                        return Boolean.FALSE;
                                                    }
                                                }, 1, null);
                                            }
                                            final OffsetMapping offsetMapping2 = offsetMapping;
                                            final boolean z31222 = z26222;
                                            final TextFieldValue textFieldValue3 = textFieldValue;
                                            final TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                            final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState;
                                            SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.4
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                                                    return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                                                }

                                                public final Boolean invoke(int i41222, int i42, boolean z32) {
                                                    if (!z32) {
                                                        i41222 = OffsetMapping.this.transformedToOriginal(i41222);
                                                    }
                                                    if (!z32) {
                                                        i42 = OffsetMapping.this.transformedToOriginal(i42);
                                                    }
                                                    boolean z33 = false;
                                                    if (z31222 && (i41222 != TextRange.m2285getStartimpl(textFieldValue3.getSelection()) || i42 != TextRange.m2280getEndimpl(textFieldValue3.getSelection()))) {
                                                        if (Math.min(i41222, i42) >= 0 && Math.max(i41222, i42) <= textFieldValue3.getText().length()) {
                                                            if (!z32 && i41222 != i42) {
                                                                TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager2, false, 1, null);
                                                            } else {
                                                                textFieldSelectionManager2.exitSelectionMode$foundation_release();
                                                            }
                                                            legacyTextFieldState5.getOnValueChange().invoke(new TextFieldValue(textFieldValue3.getText(), TextRangeKt.TextRange(i41222, i42), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                            z33 = true;
                                                        } else {
                                                            textFieldSelectionManager2.exitSelectionMode$foundation_release();
                                                        }
                                                    }
                                                    return Boolean.valueOf(z33);
                                                }
                                            }, 1, null);
                                            int imeAction = imeOptions8222.getImeAction();
                                            final LegacyTextFieldState legacyTextFieldState6 = legacyTextFieldState;
                                            final ImeOptions imeOptions9222 = imeOptions8222;
                                            SemanticsPropertiesKt.m2182onImeAction9UiTYpY$default(semanticsPropertyReceiver, imeAction, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.5
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    LegacyTextFieldState.this.getOnImeActionPerformed().invoke(ImeAction.m2375boximpl(imeOptions9222.getImeAction()));
                                                    return Boolean.TRUE;
                                                }
                                            }, 2, null);
                                            final LegacyTextFieldState legacyTextFieldState7 = legacyTextFieldState;
                                            final FocusRequester focusRequester2 = focusRequester;
                                            final boolean z32 = z27222;
                                            SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.6
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester2, !z32);
                                                    return Boolean.TRUE;
                                                }
                                            }, 1, null);
                                            final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager;
                                            SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.7
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    TextFieldSelectionManager.enterSelectionMode$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                                    return Boolean.TRUE;
                                                }
                                            }, 1, null);
                                            if (!TextRange.m2279getCollapsedimpl(textFieldValue.getSelection()) && !z25222) {
                                                final TextFieldSelectionManager textFieldSelectionManager4 = textFieldSelectionManager;
                                                SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.8
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Boolean invoke() {
                                                        TextFieldSelectionManager.copy$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                                        return Boolean.TRUE;
                                                    }
                                                }, 1, null);
                                                if (z26222 && !z27222) {
                                                    final TextFieldSelectionManager textFieldSelectionManager5 = textFieldSelectionManager;
                                                    SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.9
                                                        {
                                                            super(0);
                                                        }

                                                        /* JADX WARN: Can't rename method to resolve collision */
                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Boolean invoke() {
                                                            TextFieldSelectionManager.this.cut$foundation_release();
                                                            return Boolean.TRUE;
                                                        }
                                                    }, 1, null);
                                                }
                                            }
                                            if (!z26222 || z27222) {
                                                return;
                                            }
                                            final TextFieldSelectionManager textFieldSelectionManager6 = textFieldSelectionManager;
                                            SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.10
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    TextFieldSelectionManager.this.paste$foundation_release();
                                                    return Boolean.TRUE;
                                                }
                                            }, 1, null);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue16);
                                    Modifier semantics222 = SemanticsModifierKt.semantics(companion2, true, (Function1) rememberedValue16);
                                    final Modifier cursor222 = TextFieldCursorKt.cursor(companion2, legacyTextFieldState, textFieldValue, offsetMapping, brush3, (z8 || z10 || !windowInfo.isWindowFocused() || legacyTextFieldState.hasHighlight()) ? false : true);
                                    changedInstance7 = startRestartGroup.changedInstance(textFieldSelectionManager);
                                    rememberedValue17 = startRestartGroup.rememberedValue();
                                    if (!changedInstance7) {
                                    }
                                    rememberedValue17 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                            final TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                                            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1$invoke$$inlined$onDispose$1
                                                @Override // androidx.compose.runtime.DisposableEffectResult
                                                public void dispose() {
                                                    TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                                                }
                                            };
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue17);
                                    EffectsKt.DisposableEffect(textFieldSelectionManager, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue17, startRestartGroup, 0);
                                    changedInstance8 = (i37 != 4) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32);
                                    rememberedValue18 = startRestartGroup.rememberedValue();
                                    if (!changedInstance8) {
                                    }
                                    rememberedValue18 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                            if (LegacyTextFieldState.this.getHasFocus()) {
                                                LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                                legacyTextFieldState2.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(textInputService, textFieldValue, legacyTextFieldState2.getProcessor(), imeOptions5, LegacyTextFieldState.this.getOnValueChange(), LegacyTextFieldState.this.getOnImeActionPerformed()));
                                            }
                                            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1$invoke$$inlined$onDispose$1
                                                @Override // androidx.compose.runtime.DisposableEffectResult
                                                public void dispose() {
                                                }
                                            };
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue18);
                                    EffectsKt.DisposableEffect(imeOptions5, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue18, startRestartGroup, (i29 >> 3) & 14);
                                    Modifier m539textFieldKeyInput2WJ9YEU222 = TextFieldKeyInputKt.m539textFieldKeyInput2WJ9YEU(companion2, legacyTextFieldState, textFieldSelectionManager, textFieldValue, legacyTextFieldState.getOnValueChange(), !z10, i36 != 1, offsetMapping, undoManager, imeOptions5.getImeAction());
                                    boolean CoreTextField$lambda$11222 = CoreTextField$lambda$11(rememberUpdatedState22);
                                    changedInstance9 = startRestartGroup.changedInstance(legacyTextFieldState) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32) | startRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter);
                                    rememberedValue19 = startRestartGroup.rememberedValue();
                                    if (!changedInstance9) {
                                    }
                                    rememberedValue19 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$stylusHandwritingModifier$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            if (!LegacyTextFieldState.this.getHasFocus()) {
                                                focusRequester.requestFocus();
                                            }
                                            int keyboardType = imeOptions5.getKeyboardType();
                                            KeyboardType.Companion companion3 = KeyboardType.INSTANCE;
                                            if (!KeyboardType.m2410equalsimpl0(keyboardType, companion3.m2419getPasswordPjHm6EE()) && !KeyboardType.m2410equalsimpl0(imeOptions5.getKeyboardType(), companion3.m2418getNumberPasswordPjHm6EE())) {
                                                legacyPlatformTextInputServiceAdapter.startStylusHandwriting();
                                            }
                                            return Boolean.TRUE;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue19);
                                    Modifier onGloballyPositioned2222 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier7, legacyPlatformTextInputServiceAdapter, legacyTextFieldState, textFieldSelectionManager).then(StylusHandwritingKt.stylusHandwriting(companion2, CoreTextField$lambda$11222, (Function0) rememberedValue19)).then(modifier4), legacyTextFieldState, focusManager), legacyTextFieldState, textFieldSelectionManager).then(m539textFieldKeyInput2WJ9YEU222), textFieldScrollerPosition, mutableInteractionSource722, z8).then(pointerHoverIcon$default222).then(semantics222), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                            invoke2(layoutCoordinates);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                            TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                            if (layoutResult == null) {
                                                return;
                                            }
                                            layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                                        }
                                    });
                                    if (z8) {
                                    }
                                    final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function34222 = function32;
                                    final TextStyle textStyle5222 = textStyle2;
                                    final int i41222 = i25;
                                    boolean z29222 = z8;
                                    ImeOptions imeOptions9222 = imeOptions5;
                                    final Modifier textFieldMagnifier222 = !z28 ? TextFieldSelectionManager_androidKt.textFieldMagnifier(companion2, textFieldSelectionManager) : companion2;
                                    final boolean z30222 = z28;
                                    final boolean z31222 = z10;
                                    final Function1<? super TextLayoutResult, Unit> function16222 = function13;
                                    composer2 = startRestartGroup;
                                    CoreTextFieldRootBox(onGloballyPositioned2222, textFieldSelectionManager, ComposableLambdaKt.rememberComposableLambda(-374338080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i42) {
                                            if ((i42 & 3) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-374338080, i42, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:695)");
                                            }
                                            Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function35 = function34222;
                                            final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                                            final TextStyle textStyle6 = textStyle5222;
                                            final int i43 = i41222;
                                            final int i44 = i36;
                                            final TextFieldScrollerPosition textFieldScrollerPosition2 = textFieldScrollerPosition;
                                            final TextFieldValue textFieldValue2 = textFieldValue;
                                            final VisualTransformation visualTransformation5 = visualTransformation4;
                                            final Modifier modifier8 = cursor222;
                                            final Modifier modifier9 = drawBehind222;
                                            final Modifier modifier10 = onGloballyPositioned322;
                                            final Modifier modifier11 = textFieldMagnifier222;
                                            final BringIntoViewRequester bringIntoViewRequester2 = bringIntoViewRequester;
                                            final TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                            final boolean z32 = z30222;
                                            final boolean z33 = z31222;
                                            final Function1<? super TextLayoutResult, Unit> function17 = function16222;
                                            final OffsetMapping offsetMapping2 = offsetMapping;
                                            final Density density2 = density;
                                            function35.invoke(ComposableLambdaKt.rememberComposableLambda(2032502107, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                    invoke(composer4, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer4, int i45) {
                                                    if ((i45 & 3) == 2 && composer4.getSkipping()) {
                                                        composer4.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(2032502107, i45, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:698)");
                                                    }
                                                    Modifier heightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m327heightInVpY3zN4$default(Modifier.INSTANCE, LegacyTextFieldState.this.m486getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle6, i43, i44);
                                                    TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition2;
                                                    TextFieldValue textFieldValue3 = textFieldValue2;
                                                    VisualTransformation visualTransformation6 = visualTransformation5;
                                                    boolean changedInstance11 = composer4.changedInstance(LegacyTextFieldState.this);
                                                    final LegacyTextFieldState legacyTextFieldState3 = LegacyTextFieldState.this;
                                                    Object rememberedValue21 = composer4.rememberedValue();
                                                    if (changedInstance11 || rememberedValue21 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue21 = new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1$1
                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                            {
                                                                super(0);
                                                            }

                                                            /* JADX WARN: Can't rename method to resolve collision */
                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final TextLayoutResultProxy invoke() {
                                                                return LegacyTextFieldState.this.getLayoutResult();
                                                            }
                                                        };
                                                        composer4.updateRememberedValue(rememberedValue21);
                                                    }
                                                    Modifier bringIntoViewRequester3 = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(heightInLines, textFieldScrollerPosition3, textFieldValue3, visualTransformation6, (Function0) rememberedValue21).then(modifier8).then(modifier9), textStyle6).then(modifier10).then(modifier11), bringIntoViewRequester2);
                                                    final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager2;
                                                    final LegacyTextFieldState legacyTextFieldState4 = LegacyTextFieldState.this;
                                                    final boolean z34 = z32;
                                                    final boolean z35 = z33;
                                                    final Function1<? super TextLayoutResult, Unit> function18 = function17;
                                                    final TextFieldValue textFieldValue4 = textFieldValue2;
                                                    final OffsetMapping offsetMapping3 = offsetMapping2;
                                                    final Density density3 = density2;
                                                    final int i46 = i44;
                                                    SimpleLayoutKt.SimpleLayout(bringIntoViewRequester3, ComposableLambdaKt.rememberComposableLambda(-363167407, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                            invoke(composer5, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* JADX WARN: Removed duplicated region for block: B:39:0x00ff  */
                                                        /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
                                                        /*
                                                            Code decompiled incorrectly, please refer to instructions dump.
                                                        */
                                                        public final void invoke(Composer composer5, int i47) {
                                                            boolean z36;
                                                            if ((i47 & 3) == 2 && composer5.getSkipping()) {
                                                                composer5.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-363167407, i47, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:721)");
                                                            }
                                                            final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                                            final Function1<? super TextLayoutResult, Unit> function19 = function18;
                                                            final TextFieldValue textFieldValue5 = textFieldValue4;
                                                            final OffsetMapping offsetMapping4 = offsetMapping3;
                                                            final Density density4 = density3;
                                                            final int i48 = i46;
                                                            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                                @Override // androidx.compose.ui.layout.MeasurePolicy
                                                                public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i49) {
                                                                    LegacyTextFieldState.this.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                                                    return LegacyTextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                                                }

                                                                @Override // androidx.compose.ui.layout.MeasurePolicy
                                                                /* renamed from: measure-3p2s80s */
                                                                public MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                                                                    Snapshot.Companion companion3 = Snapshot.INSTANCE;
                                                                    LegacyTextFieldState legacyTextFieldState6 = LegacyTextFieldState.this;
                                                                    Snapshot currentThreadSnapshot = companion3.getCurrentThreadSnapshot();
                                                                    Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                                                    Snapshot makeCurrentNonObservable = companion3.makeCurrentNonObservable(currentThreadSnapshot);
                                                                    try {
                                                                        TextLayoutResultProxy layoutResult = legacyTextFieldState6.getLayoutResult();
                                                                        TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                                                        Triple<Integer, Integer, TextLayoutResult> m531layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m531layout_EkL_Y$foundation_release(LegacyTextFieldState.this.getTextDelegate(), j5, measureScope.getLayoutDirection(), value);
                                                                        int intValue = m531layout_EkL_Y$foundation_release.component1().intValue();
                                                                        int intValue2 = m531layout_EkL_Y$foundation_release.component2().intValue();
                                                                        TextLayoutResult component3 = m531layout_EkL_Y$foundation_release.component3();
                                                                        if (!Intrinsics.areEqual(value, component3)) {
                                                                            LegacyTextFieldState.this.setLayoutResult(new TextLayoutResultProxy(component3, null, layoutResult != null ? layoutResult.getDecorationBoxCoordinates() : null, 2, null));
                                                                            function19.invoke(component3);
                                                                            CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue5, offsetMapping4);
                                                                        }
                                                                        LegacyTextFieldState.this.m490setMinHeightForSingleLineField0680j_4(density4.mo209toDpu2uoSUM(i48 == 1 ? TextDelegateKt.ceilToIntPx(component3.getLineBottom(0)) : 0));
                                                                        return measureScope.layout(intValue, intValue2, MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(component3.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(component3.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                            public final void invoke2(Placeable.PlacementScope placementScope) {
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                                invoke2(placementScope);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                    } finally {
                                                                        companion3.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                                                    }
                                                                }
                                                            };
                                                            Modifier.Companion companion3 = Modifier.INSTANCE;
                                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, companion3);
                                                            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                                            Function0<ComposeUiNode> constructor = companion4.getConstructor();
                                                            if (composer5.getApplier() == null) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            composer5.startReusableNode();
                                                            if (composer5.getInserting()) {
                                                                composer5.createNode(constructor);
                                                            } else {
                                                                composer5.useNode();
                                                            }
                                                            Composer m1226constructorimpl = Updater.m1226constructorimpl(composer5);
                                                            Updater.m1227setimpl(m1226constructorimpl, measurePolicy, companion4.getSetMeasurePolicy());
                                                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                                                            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                            }
                                                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
                                                            composer5.endNode();
                                                            TextFieldSelectionManager textFieldSelectionManager4 = TextFieldSelectionManager.this;
                                                            if (legacyTextFieldState4.getHandleState() != HandleState.None && legacyTextFieldState4.getLayoutCoordinates() != null) {
                                                                LayoutCoordinates layoutCoordinates = legacyTextFieldState4.getLayoutCoordinates();
                                                                Intrinsics.checkNotNull(layoutCoordinates);
                                                                if (layoutCoordinates.isAttached() && z34) {
                                                                    z36 = true;
                                                                    CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z36, composer5, 0);
                                                                    if (legacyTextFieldState4.getHandleState() != HandleState.Cursor && !z35 && z34) {
                                                                        composer5.startReplaceGroup(-2032274);
                                                                        CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer5, 0);
                                                                        composer5.endReplaceGroup();
                                                                    } else {
                                                                        composer5.startReplaceGroup(-1955394);
                                                                        composer5.endReplaceGroup();
                                                                    }
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        return;
                                                                    }
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                            }
                                                            z36 = false;
                                                            CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z36, composer5, 0);
                                                            if (legacyTextFieldState4.getHandleState() != HandleState.Cursor) {
                                                            }
                                                            composer5.startReplaceGroup(-1955394);
                                                            composer5.endReplaceGroup();
                                                            if (ComposerKt.isTraceInProgress()) {
                                                            }
                                                        }
                                                    }, composer4, 54), composer4, 48, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, composer3, 54), composer3, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer2, 54), composer2, 384);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    textStyle3 = textStyle2;
                                    function14 = function13;
                                    visualTransformation3 = visualTransformation4;
                                    modifier5 = modifier7;
                                    brush4 = brush3;
                                    z15 = z9;
                                    i30 = i25;
                                    z16 = z29222;
                                    keyboardActions3 = keyboardActions2;
                                    imeOptions6 = imeOptions9222;
                                    i31 = i36;
                                    mutableInteractionSource4 = mutableInteractionSource722;
                                    z17 = z10;
                                    function33 = function32;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$6
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i42) {
                                            CoreTextFieldKt.CoreTextField(TextFieldValue.this, function1, modifier5, textStyle3, visualTransformation3, function14, mutableInteractionSource4, brush4, z15, i31, i30, imeOptions6, keyboardActions3, z16, z17, function33, composer3, RecomposeScopeImplKt.updateChangedFlags(i7 | 1), RecomposeScopeImplKt.updateChangedFlags(i8), i9);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i24 = i9 & 32768;
                            if (i24 != 0) {
                            }
                            if ((i10 & 306783379) != 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i7 & 1) != 0) {
                            }
                            if (i33 != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i12 != 0) {
                            }
                            if (i13 != 0) {
                            }
                            if (i14 != 0) {
                            }
                            if (i15 != 0) {
                            }
                            if (i16 != 0) {
                            }
                            if (i17 != 0) {
                            }
                            if (i18 != 0) {
                            }
                            if ((i9 & 2048) != 0) {
                            }
                            if (i21 != 0) {
                            }
                            if (i22 != 0) {
                            }
                            if (i23 != 0) {
                            }
                            if (i24 != 0) {
                            }
                            visualTransformation2 = none;
                            function13 = function15;
                            i26 = i34;
                            imeOptions3 = imeOptions2;
                            MutableInteractionSource mutableInteractionSource62 = mutableInteractionSource5;
                            textStyle2 = textStyle4;
                            mutableInteractionSource2 = mutableInteractionSource62;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            rememberedValue = startRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (rememberedValue == companion.getEmpty()) {
                            }
                            final FocusRequester focusRequester2 = (FocusRequester) rememberedValue;
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (rememberedValue2 == companion.getEmpty()) {
                            }
                            final LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter2 = (LegacyPlatformTextInputServiceAdapter) rememberedValue2;
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (rememberedValue3 == companion.getEmpty()) {
                            }
                            final TextInputService textInputService2 = (TextInputService) rememberedValue3;
                            final Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                            FontFamily.Resolver resolver2 = (FontFamily.Resolver) startRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                            long selectionBackgroundColor2 = ((SelectionColors) startRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).getSelectionBackgroundColor();
                            FocusManager focusManager2 = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                            Modifier modifier72 = modifier3;
                            windowInfo = (WindowInfo) startRestartGroup.consume(CompositionLocalsKt.getLocalWindowInfo());
                            SoftwareKeyboardController softwareKeyboardController2 = (SoftwareKeyboardController) startRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                            if (i26 == 1) {
                            }
                            Object[] objArr2 = {orientation};
                            Saver<TextFieldScrollerPosition, Object> saver2 = TextFieldScrollerPosition.INSTANCE.getSaver();
                            changed = startRestartGroup.changed(orientation);
                            final int i362 = i26;
                            Object rememberedValue202 = startRestartGroup.rememberedValue();
                            if (changed) {
                            }
                            rememberedValue202 = new Function0<TextFieldScrollerPosition>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final TextFieldScrollerPosition invoke() {
                                    return new TextFieldScrollerPosition(Orientation.this, 0.0f, 2, null);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue202);
                            final TextFieldScrollerPosition textFieldScrollerPosition2 = (TextFieldScrollerPosition) RememberSaveableKt.rememberSaveable(objArr2, saver2, null, (Function0) rememberedValue202, startRestartGroup, 0, 4);
                            int i372 = i10 & 14;
                            if (i372 == 4) {
                            }
                            z11 = ((i10 & 57344) == 16384) | (i372 == 4);
                            rememberedValue4 = startRestartGroup.rememberedValue();
                            if (z11) {
                            }
                            TransformedText filterWithValidation2 = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation2, textFieldValue.getText());
                            composition = textFieldValue.getComposition();
                            if (composition != null) {
                            }
                            rememberedValue4 = filterWithValidation2;
                            startRestartGroup.updateRememberedValue(rememberedValue4);
                            final TransformedText transformedText2 = (TransformedText) rememberedValue4;
                            AnnotatedString text2 = transformedText2.getText();
                            final OffsetMapping offsetMapping2 = transformedText2.getOffsetMapping();
                            RecomposeScope currentRecomposeScope2 = ComposablesKt.getCurrentRecomposeScope(startRestartGroup, 0);
                            changed2 = startRestartGroup.changed(softwareKeyboardController2);
                            rememberedValue5 = startRestartGroup.rememberedValue();
                            if (!changed2) {
                            }
                            rememberedValue5 = new LegacyTextFieldState(new TextDelegate(text2, textStyle2, 0, 0, z9, 0, density2, resolver2, null, 300, null), currentRecomposeScope2, softwareKeyboardController2);
                            startRestartGroup.updateRememberedValue(rememberedValue5);
                            legacyTextFieldState = (LegacyTextFieldState) rememberedValue5;
                            legacyTextFieldState.m492updatefnh65Uc(textFieldValue.getText(), text2, textStyle2, z9, density2, resolver2, function1, keyboardActions2, focusManager2, selectionBackgroundColor2);
                            legacyTextFieldState.getProcessor().reset(textFieldValue, legacyTextFieldState.getInputSession());
                            rememberedValue6 = startRestartGroup.rememberedValue();
                            if (rememberedValue6 == companion.getEmpty()) {
                            }
                            UndoManager undoManager2 = (UndoManager) rememberedValue6;
                            UndoManager.snapshotIfNeeded$default(undoManager2, textFieldValue, 0L, 2, null);
                            rememberedValue7 = startRestartGroup.rememberedValue();
                            if (rememberedValue7 == companion.getEmpty()) {
                            }
                            final TextFieldSelectionManager textFieldSelectionManager2 = (TextFieldSelectionManager) rememberedValue7;
                            textFieldSelectionManager2.setOffsetMapping$foundation_release(offsetMapping2);
                            textFieldSelectionManager2.setVisualTransformation$foundation_release(visualTransformation2);
                            textFieldSelectionManager2.setOnValueChange$foundation_release(legacyTextFieldState.getOnValueChange());
                            textFieldSelectionManager2.setState$foundation_release(legacyTextFieldState);
                            textFieldSelectionManager2.setValue$foundation_release(textFieldValue);
                            textFieldSelectionManager2.setClipboardManager$foundation_release((ClipboardManager) startRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
                            textFieldSelectionManager2.setTextToolbar((TextToolbar) startRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
                            textFieldSelectionManager2.setHapticFeedBack((HapticFeedback) startRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
                            textFieldSelectionManager2.setFocusRequester(focusRequester2);
                            textFieldSelectionManager2.setEditable(!z10);
                            textFieldSelectionManager2.setEnabled(z8);
                            rememberedValue8 = startRestartGroup.rememberedValue();
                            if (rememberedValue8 == companion.getEmpty()) {
                            }
                            final CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue8).getCoroutineScope();
                            rememberedValue9 = startRestartGroup.rememberedValue();
                            if (rememberedValue9 == companion.getEmpty()) {
                            }
                            final BringIntoViewRequester bringIntoViewRequester2 = (BringIntoViewRequester) rememberedValue9;
                            Modifier.Companion companion22 = Modifier.INSTANCE;
                            int i382 = i20 & 7168;
                            final VisualTransformation visualTransformation42 = visualTransformation2;
                            int i392 = i20 & 57344;
                            boolean changedInstance102 = startRestartGroup.changedInstance(legacyTextFieldState) | (i382 == 2048) | (i392 == 16384) | startRestartGroup.changedInstance(textInputService2) | (i372 == 4);
                            i27 = (i20 & 112) ^ 48;
                            if (i27 > 32) {
                            }
                            i28 = i392;
                            i29 = i20;
                            if ((i20 & 48) != 32) {
                            }
                            z12 = true;
                            changedInstance = changedInstance102 | z12 | startRestartGroup.changedInstance(offsetMapping2) | startRestartGroup.changedInstance(coroutineScope2) | startRestartGroup.changedInstance(bringIntoViewRequester2) | startRestartGroup.changedInstance(textFieldSelectionManager2);
                            rememberedValue10 = startRestartGroup.rememberedValue();
                            if (!changedInstance) {
                            }
                            final boolean z20222 = z8;
                            final boolean z21222 = z10;
                            final ImeOptions imeOptions7222 = imeOptions5;
                            rememberedValue10 = new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                                    invoke2(focusState);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(FocusState focusState) {
                                    TextLayoutResultProxy layoutResult;
                                    if (LegacyTextFieldState.this.getHasFocus() == focusState.isFocused()) {
                                        return;
                                    }
                                    LegacyTextFieldState.this.setHasFocus(focusState.isFocused());
                                    if (LegacyTextFieldState.this.getHasFocus() && z20222 && !z21222) {
                                        CoreTextFieldKt.startInputSession(textInputService2, LegacyTextFieldState.this, textFieldValue, imeOptions7222, offsetMapping2);
                                    } else {
                                        CoreTextFieldKt.endInputSession(LegacyTextFieldState.this);
                                    }
                                    if (focusState.isFocused() && (layoutResult = LegacyTextFieldState.this.getLayoutResult()) != null) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(bringIntoViewRequester2, textFieldValue, LegacyTextFieldState.this, layoutResult, offsetMapping2, null), 3, null);
                                    }
                                    if (focusState.isFocused()) {
                                        return;
                                    }
                                    TextFieldSelectionManager.m640deselect_kEHs6E$foundation_release$default(textFieldSelectionManager2, null, 1, null);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue10);
                            MutableInteractionSource mutableInteractionSource7222 = mutableInteractionSource3;
                            textFieldFocusModifier = TextFieldGestureModifiersKt.textFieldFocusModifier(companion22, z8, focusRequester2, mutableInteractionSource7222, (Function1) rememberedValue10);
                            State rememberUpdatedState222 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf((z8 || z10) ? false : true), startRestartGroup, 0);
                            Unit unit222 = Unit.INSTANCE;
                            boolean changed3222 = startRestartGroup.changed(rememberUpdatedState222) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService2) | startRestartGroup.changedInstance(textFieldSelectionManager2);
                            if (i27 > 32) {
                            }
                            modifier4 = textFieldFocusModifier;
                            if ((i29 & 48) != 32) {
                            }
                            z13 = true;
                            z14 = changed3222 | z13;
                            rememberedValue11 = startRestartGroup.rememberedValue();
                            if (!z14) {
                            }
                            rememberedValue11 = new CoreTextFieldKt$CoreTextField$2$1(legacyTextFieldState, rememberUpdatedState222, textInputService2, textFieldSelectionManager2, imeOptions5, null);
                            startRestartGroup.updateRememberedValue(rememberedValue11);
                            EffectsKt.LaunchedEffect(unit222, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue11, startRestartGroup, 6);
                            changedInstance2 = startRestartGroup.changedInstance(legacyTextFieldState);
                            rememberedValue12 = startRestartGroup.rememberedValue();
                            if (!changedInstance2) {
                            }
                            rememberedValue12 = new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                    invoke(bool.booleanValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(boolean z222222) {
                                    LegacyTextFieldState.this.setInTouchMode(z222222);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue12);
                            Modifier updateSelectionTouchMode2222 = SelectionGesturesKt.updateSelectionTouchMode(companion22, (Function1) rememberedValue12);
                            int i402222 = i28;
                            changedInstance3 = startRestartGroup.changedInstance(legacyTextFieldState) | (i402222 != 16384) | (i382 != 2048) | startRestartGroup.changedInstance(offsetMapping2) | startRestartGroup.changedInstance(textFieldSelectionManager2);
                            rememberedValue13 = startRestartGroup.rememberedValue();
                            if (!changedInstance3) {
                            }
                            final boolean z222222 = z10;
                            final boolean z232222 = z8;
                            rememberedValue13 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                    m473invokek4lQ0M(offset.getPackedValue());
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                                public final void m473invokek4lQ0M(long j5) {
                                    CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester2, !z222222);
                                    if (LegacyTextFieldState.this.getHasFocus() && z232222) {
                                        if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                                            textFieldSelectionManager2.m643deselect_kEHs6E$foundation_release(Offset.m1328boximpl(j5));
                                            return;
                                        }
                                        TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                        if (layoutResult != null) {
                                            LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                            TextFieldDelegate.INSTANCE.m532setCursorOffsetULxng0E$foundation_release(j5, layoutResult, legacyTextFieldState2.getProcessor(), offsetMapping2, legacyTextFieldState2.getOnValueChange());
                                            if (legacyTextFieldState2.getTextDelegate().getText().length() > 0) {
                                                legacyTextFieldState2.setHandleState(HandleState.Cursor);
                                            }
                                        }
                                    }
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue13);
                            Modifier pointerHoverIcon$default2222 = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(updateSelectionTouchMode2222, mutableInteractionSource7222, z8, (Function1) rememberedValue13), textFieldSelectionManager2.getMouseSelectionObserver(), textFieldSelectionManager2.getTouchSelectionObserver()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                            changedInstance4 = startRestartGroup.changedInstance(legacyTextFieldState) | (i372 != 4) | startRestartGroup.changedInstance(offsetMapping2);
                            rememberedValue14 = startRestartGroup.rememberedValue();
                            if (!changedInstance4) {
                            }
                            rememberedValue14 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                    invoke2(drawScope);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(DrawScope drawScope) {
                                    TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                    if (layoutResult != null) {
                                        TextFieldValue textFieldValue2 = textFieldValue;
                                        LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                        OffsetMapping offsetMapping22 = offsetMapping2;
                                        TextFieldDelegate.INSTANCE.m530drawQ1vqE60$foundation_release(drawScope.getDrawContext().getCanvas(), textFieldValue2, legacyTextFieldState2.m488getSelectionPreviewHighlightRanged9O1mEE(), legacyTextFieldState2.m485getDeletionPreviewHighlightRanged9O1mEE(), offsetMapping22, layoutResult.getValue(), legacyTextFieldState2.getHighlightPaint(), legacyTextFieldState2.getSelectionBackgroundColor());
                                    }
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue14);
                            final Modifier drawBehind2222 = DrawModifierKt.drawBehind(companion22, (Function1) rememberedValue14);
                            changedInstance5 = startRestartGroup.changedInstance(legacyTextFieldState) | (i382 != 2048) | startRestartGroup.changed(windowInfo) | startRestartGroup.changedInstance(textFieldSelectionManager2) | (i372 != 4) | startRestartGroup.changedInstance(offsetMapping2);
                            rememberedValue15 = startRestartGroup.rememberedValue();
                            if (!changedInstance5) {
                            }
                            final boolean z242222 = z8;
                            rememberedValue15 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                    invoke2(layoutCoordinates);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                    LegacyTextFieldState.this.setLayoutCoordinates(layoutCoordinates);
                                    TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                    if (layoutResult != null) {
                                        layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
                                    }
                                    if (z242222) {
                                        if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                                            if (LegacyTextFieldState.this.getShowFloatingToolbar() && windowInfo.isWindowFocused()) {
                                                textFieldSelectionManager2.showSelectionToolbar$foundation_release();
                                            } else {
                                                textFieldSelectionManager2.hideSelectionToolbar$foundation_release();
                                            }
                                            LegacyTextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager2, true));
                                            LegacyTextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager2, false));
                                            LegacyTextFieldState.this.setShowCursorHandle(TextRange.m2279getCollapsedimpl(textFieldValue.getSelection()));
                                        } else if (LegacyTextFieldState.this.getHandleState() == HandleState.Cursor) {
                                            LegacyTextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager2, true));
                                        }
                                        CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue, offsetMapping2);
                                        TextLayoutResultProxy layoutResult2 = LegacyTextFieldState.this.getLayoutResult();
                                        if (layoutResult2 != null) {
                                            LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                            TextFieldValue textFieldValue2 = textFieldValue;
                                            OffsetMapping offsetMapping22 = offsetMapping2;
                                            TextInputSession inputSession = legacyTextFieldState2.getInputSession();
                                            if (inputSession == null || !legacyTextFieldState2.getHasFocus()) {
                                                return;
                                            }
                                            TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation_release(inputSession, textFieldValue2, offsetMapping22, layoutResult2);
                                        }
                                    }
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue15);
                            final Modifier onGloballyPositioned3222 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion22, (Function1) rememberedValue15);
                            final boolean z252222 = visualTransformation42 instanceof PasswordVisualTransformation;
                            changedInstance6 = (i382 != 2048) | startRestartGroup.changedInstance(transformedText2) | (i372 != 4) | startRestartGroup.changed(z252222) | (i402222 != 16384) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(offsetMapping2) | startRestartGroup.changedInstance(textFieldSelectionManager2) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32);
                            rememberedValue16 = startRestartGroup.rememberedValue();
                            if (!changedInstance6) {
                            }
                            final boolean z262222 = z8;
                            final boolean z272222 = z10;
                            final ImeOptions imeOptions82222 = imeOptions5;
                            rememberedValue16 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(final SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, TransformedText.this.getText());
                                    SemanticsPropertiesKt.m2185setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, textFieldValue.getSelection());
                                    if (!z262222) {
                                        SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                                    }
                                    if (z252222) {
                                        SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                                    }
                                    boolean z282 = z262222 && !z272222;
                                    SemanticsPropertiesKt.setEditable(semanticsPropertyReceiver, z282);
                                    final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                                    SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Boolean invoke(List<TextLayoutResult> list) {
                                            boolean z292222;
                                            if (LegacyTextFieldState.this.getLayoutResult() != null) {
                                                TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                Intrinsics.checkNotNull(layoutResult);
                                                list.add(layoutResult.getValue());
                                                z292222 = true;
                                            } else {
                                                z292222 = false;
                                            }
                                            return Boolean.valueOf(z292222);
                                        }
                                    }, 1, null);
                                    if (z282) {
                                        final LegacyTextFieldState legacyTextFieldState3 = legacyTextFieldState;
                                        SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Boolean invoke(AnnotatedString annotatedString) {
                                                Unit unit2222;
                                                TextInputSession inputSession = LegacyTextFieldState.this.getInputSession();
                                                if (inputSession != null) {
                                                    LegacyTextFieldState legacyTextFieldState4 = LegacyTextFieldState.this;
                                                    TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(annotatedString, 1)}), legacyTextFieldState4.getProcessor(), legacyTextFieldState4.getOnValueChange(), inputSession);
                                                    unit2222 = Unit.INSTANCE;
                                                } else {
                                                    unit2222 = null;
                                                }
                                                if (unit2222 == null) {
                                                    LegacyTextFieldState.this.getOnValueChange().invoke(new TextFieldValue(annotatedString.getText(), TextRangeKt.TextRange(annotatedString.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                }
                                                return Boolean.TRUE;
                                            }
                                        }, 1, null);
                                        final boolean z292222 = z272222;
                                        final boolean z302222 = z262222;
                                        final LegacyTextFieldState legacyTextFieldState4 = legacyTextFieldState;
                                        final TextFieldValue textFieldValue2 = textFieldValue;
                                        SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Boolean invoke(AnnotatedString annotatedString) {
                                                Unit unit2222;
                                                if (!z292222 && z302222) {
                                                    TextInputSession inputSession = legacyTextFieldState4.getInputSession();
                                                    if (inputSession != null) {
                                                        LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                                        TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(annotatedString, 1)}), legacyTextFieldState5.getProcessor(), legacyTextFieldState5.getOnValueChange(), inputSession);
                                                        unit2222 = Unit.INSTANCE;
                                                    } else {
                                                        unit2222 = null;
                                                    }
                                                    if (unit2222 == null) {
                                                        TextFieldValue textFieldValue3 = textFieldValue2;
                                                        legacyTextFieldState4.getOnValueChange().invoke(new TextFieldValue(StringsKt.replaceRange(textFieldValue3.getText(), TextRange.m2285getStartimpl(textFieldValue3.getSelection()), TextRange.m2280getEndimpl(textFieldValue3.getSelection()), annotatedString).toString(), TextRangeKt.TextRange(TextRange.m2285getStartimpl(textFieldValue3.getSelection()) + annotatedString.length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                    }
                                                    return Boolean.TRUE;
                                                }
                                                return Boolean.FALSE;
                                            }
                                        }, 1, null);
                                    }
                                    final OffsetMapping offsetMapping22 = offsetMapping2;
                                    final boolean z312222 = z262222;
                                    final TextFieldValue textFieldValue3 = textFieldValue;
                                    final TextFieldSelectionManager textFieldSelectionManager22 = textFieldSelectionManager2;
                                    final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState;
                                    SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.4
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                                            return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                                        }

                                        public final Boolean invoke(int i412222, int i42, boolean z32) {
                                            if (!z32) {
                                                i412222 = OffsetMapping.this.transformedToOriginal(i412222);
                                            }
                                            if (!z32) {
                                                i42 = OffsetMapping.this.transformedToOriginal(i42);
                                            }
                                            boolean z33 = false;
                                            if (z312222 && (i412222 != TextRange.m2285getStartimpl(textFieldValue3.getSelection()) || i42 != TextRange.m2280getEndimpl(textFieldValue3.getSelection()))) {
                                                if (Math.min(i412222, i42) >= 0 && Math.max(i412222, i42) <= textFieldValue3.getText().length()) {
                                                    if (!z32 && i412222 != i42) {
                                                        TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager22, false, 1, null);
                                                    } else {
                                                        textFieldSelectionManager22.exitSelectionMode$foundation_release();
                                                    }
                                                    legacyTextFieldState5.getOnValueChange().invoke(new TextFieldValue(textFieldValue3.getText(), TextRangeKt.TextRange(i412222, i42), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                    z33 = true;
                                                } else {
                                                    textFieldSelectionManager22.exitSelectionMode$foundation_release();
                                                }
                                            }
                                            return Boolean.valueOf(z33);
                                        }
                                    }, 1, null);
                                    int imeAction = imeOptions82222.getImeAction();
                                    final LegacyTextFieldState legacyTextFieldState6 = legacyTextFieldState;
                                    final ImeOptions imeOptions92222 = imeOptions82222;
                                    SemanticsPropertiesKt.m2182onImeAction9UiTYpY$default(semanticsPropertyReceiver, imeAction, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.5
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            LegacyTextFieldState.this.getOnImeActionPerformed().invoke(ImeAction.m2375boximpl(imeOptions92222.getImeAction()));
                                            return Boolean.TRUE;
                                        }
                                    }, 2, null);
                                    final LegacyTextFieldState legacyTextFieldState7 = legacyTextFieldState;
                                    final FocusRequester focusRequester22 = focusRequester2;
                                    final boolean z32 = z272222;
                                    SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.6
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester22, !z32);
                                            return Boolean.TRUE;
                                        }
                                    }, 1, null);
                                    final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager2;
                                    SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.7
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            TextFieldSelectionManager.enterSelectionMode$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                            return Boolean.TRUE;
                                        }
                                    }, 1, null);
                                    if (!TextRange.m2279getCollapsedimpl(textFieldValue.getSelection()) && !z252222) {
                                        final TextFieldSelectionManager textFieldSelectionManager4 = textFieldSelectionManager2;
                                        SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.8
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                TextFieldSelectionManager.copy$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                                return Boolean.TRUE;
                                            }
                                        }, 1, null);
                                        if (z262222 && !z272222) {
                                            final TextFieldSelectionManager textFieldSelectionManager5 = textFieldSelectionManager2;
                                            SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.9
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    TextFieldSelectionManager.this.cut$foundation_release();
                                                    return Boolean.TRUE;
                                                }
                                            }, 1, null);
                                        }
                                    }
                                    if (!z262222 || z272222) {
                                        return;
                                    }
                                    final TextFieldSelectionManager textFieldSelectionManager6 = textFieldSelectionManager2;
                                    SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.10
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            TextFieldSelectionManager.this.paste$foundation_release();
                                            return Boolean.TRUE;
                                        }
                                    }, 1, null);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue16);
                            Modifier semantics2222 = SemanticsModifierKt.semantics(companion22, true, (Function1) rememberedValue16);
                            final Modifier cursor2222 = TextFieldCursorKt.cursor(companion22, legacyTextFieldState, textFieldValue, offsetMapping2, brush3, (z8 || z10 || !windowInfo.isWindowFocused() || legacyTextFieldState.hasHighlight()) ? false : true);
                            changedInstance7 = startRestartGroup.changedInstance(textFieldSelectionManager2);
                            rememberedValue17 = startRestartGroup.rememberedValue();
                            if (!changedInstance7) {
                            }
                            rememberedValue17 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                    final TextFieldSelectionManager textFieldSelectionManager22 = TextFieldSelectionManager.this;
                                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1$invoke$$inlined$onDispose$1
                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                        public void dispose() {
                                            TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                                        }
                                    };
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue17);
                            EffectsKt.DisposableEffect(textFieldSelectionManager2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue17, startRestartGroup, 0);
                            changedInstance8 = (i372 != 4) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService2) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32);
                            rememberedValue18 = startRestartGroup.rememberedValue();
                            if (!changedInstance8) {
                            }
                            rememberedValue18 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                    if (LegacyTextFieldState.this.getHasFocus()) {
                                        LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                        legacyTextFieldState2.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(textInputService2, textFieldValue, legacyTextFieldState2.getProcessor(), imeOptions5, LegacyTextFieldState.this.getOnValueChange(), LegacyTextFieldState.this.getOnImeActionPerformed()));
                                    }
                                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1$invoke$$inlined$onDispose$1
                                        @Override // androidx.compose.runtime.DisposableEffectResult
                                        public void dispose() {
                                        }
                                    };
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue18);
                            EffectsKt.DisposableEffect(imeOptions5, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue18, startRestartGroup, (i29 >> 3) & 14);
                            Modifier m539textFieldKeyInput2WJ9YEU2222 = TextFieldKeyInputKt.m539textFieldKeyInput2WJ9YEU(companion22, legacyTextFieldState, textFieldSelectionManager2, textFieldValue, legacyTextFieldState.getOnValueChange(), !z10, i362 != 1, offsetMapping2, undoManager2, imeOptions5.getImeAction());
                            boolean CoreTextField$lambda$112222 = CoreTextField$lambda$11(rememberUpdatedState222);
                            changedInstance9 = startRestartGroup.changedInstance(legacyTextFieldState) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32) | startRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter2);
                            rememberedValue19 = startRestartGroup.rememberedValue();
                            if (!changedInstance9) {
                            }
                            rememberedValue19 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$stylusHandwritingModifier$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    if (!LegacyTextFieldState.this.getHasFocus()) {
                                        focusRequester2.requestFocus();
                                    }
                                    int keyboardType = imeOptions5.getKeyboardType();
                                    KeyboardType.Companion companion3 = KeyboardType.INSTANCE;
                                    if (!KeyboardType.m2410equalsimpl0(keyboardType, companion3.m2419getPasswordPjHm6EE()) && !KeyboardType.m2410equalsimpl0(imeOptions5.getKeyboardType(), companion3.m2418getNumberPasswordPjHm6EE())) {
                                        legacyPlatformTextInputServiceAdapter2.startStylusHandwriting();
                                    }
                                    return Boolean.TRUE;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue19);
                            Modifier onGloballyPositioned22222 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier72, legacyPlatformTextInputServiceAdapter2, legacyTextFieldState, textFieldSelectionManager2).then(StylusHandwritingKt.stylusHandwriting(companion22, CoreTextField$lambda$112222, (Function0) rememberedValue19)).then(modifier4), legacyTextFieldState, focusManager2), legacyTextFieldState, textFieldSelectionManager2).then(m539textFieldKeyInput2WJ9YEU2222), textFieldScrollerPosition2, mutableInteractionSource7222, z8).then(pointerHoverIcon$default2222).then(semantics2222), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                    invoke2(layoutCoordinates);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                    TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                    if (layoutResult == null) {
                                        return;
                                    }
                                    layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                                }
                            });
                            if (z8) {
                            }
                            final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function342222 = function32;
                            final TextStyle textStyle52222 = textStyle2;
                            final int i412222 = i25;
                            boolean z292222 = z8;
                            ImeOptions imeOptions92222 = imeOptions5;
                            final Modifier textFieldMagnifier2222 = !z28 ? TextFieldSelectionManager_androidKt.textFieldMagnifier(companion22, textFieldSelectionManager2) : companion22;
                            final boolean z302222 = z28;
                            final boolean z312222 = z10;
                            final Function1<? super TextLayoutResult, Unit> function162222 = function13;
                            composer2 = startRestartGroup;
                            CoreTextFieldRootBox(onGloballyPositioned22222, textFieldSelectionManager2, ComposableLambdaKt.rememberComposableLambda(-374338080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i42) {
                                    if ((i42 & 3) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-374338080, i42, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:695)");
                                    }
                                    Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function35 = function342222;
                                    final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                                    final TextStyle textStyle6 = textStyle52222;
                                    final int i43 = i412222;
                                    final int i44 = i362;
                                    final TextFieldScrollerPosition textFieldScrollerPosition22 = textFieldScrollerPosition2;
                                    final TextFieldValue textFieldValue2 = textFieldValue;
                                    final VisualTransformation visualTransformation5 = visualTransformation42;
                                    final Modifier modifier8 = cursor2222;
                                    final Modifier modifier9 = drawBehind2222;
                                    final Modifier modifier10 = onGloballyPositioned3222;
                                    final Modifier modifier11 = textFieldMagnifier2222;
                                    final BringIntoViewRequester bringIntoViewRequester22 = bringIntoViewRequester2;
                                    final TextFieldSelectionManager textFieldSelectionManager22 = textFieldSelectionManager2;
                                    final boolean z32 = z302222;
                                    final boolean z33 = z312222;
                                    final Function1<? super TextLayoutResult, Unit> function17 = function162222;
                                    final OffsetMapping offsetMapping22 = offsetMapping2;
                                    final Density density22 = density2;
                                    function35.invoke(ComposableLambdaKt.rememberComposableLambda(2032502107, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                            invoke(composer4, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i45) {
                                            if ((i45 & 3) == 2 && composer4.getSkipping()) {
                                                composer4.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(2032502107, i45, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:698)");
                                            }
                                            Modifier heightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m327heightInVpY3zN4$default(Modifier.INSTANCE, LegacyTextFieldState.this.m486getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle6, i43, i44);
                                            TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition22;
                                            TextFieldValue textFieldValue3 = textFieldValue2;
                                            VisualTransformation visualTransformation6 = visualTransformation5;
                                            boolean changedInstance11 = composer4.changedInstance(LegacyTextFieldState.this);
                                            final LegacyTextFieldState legacyTextFieldState3 = LegacyTextFieldState.this;
                                            Object rememberedValue21 = composer4.rememberedValue();
                                            if (changedInstance11 || rememberedValue21 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue21 = new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX WARN: Can't rename method to resolve collision */
                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final TextLayoutResultProxy invoke() {
                                                        return LegacyTextFieldState.this.getLayoutResult();
                                                    }
                                                };
                                                composer4.updateRememberedValue(rememberedValue21);
                                            }
                                            Modifier bringIntoViewRequester3 = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(heightInLines, textFieldScrollerPosition3, textFieldValue3, visualTransformation6, (Function0) rememberedValue21).then(modifier8).then(modifier9), textStyle6).then(modifier10).then(modifier11), bringIntoViewRequester22);
                                            final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager22;
                                            final LegacyTextFieldState legacyTextFieldState4 = LegacyTextFieldState.this;
                                            final boolean z34 = z32;
                                            final boolean z35 = z33;
                                            final Function1<? super TextLayoutResult, Unit> function18 = function17;
                                            final TextFieldValue textFieldValue4 = textFieldValue2;
                                            final OffsetMapping offsetMapping3 = offsetMapping22;
                                            final Density density3 = density22;
                                            final int i46 = i44;
                                            SimpleLayoutKt.SimpleLayout(bringIntoViewRequester3, ComposableLambdaKt.rememberComposableLambda(-363167407, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                    invoke(composer5, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                /* JADX WARN: Removed duplicated region for block: B:39:0x00ff  */
                                                /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
                                                /*
                                                    Code decompiled incorrectly, please refer to instructions dump.
                                                */
                                                public final void invoke(Composer composer5, int i47) {
                                                    boolean z36;
                                                    if ((i47 & 3) == 2 && composer5.getSkipping()) {
                                                        composer5.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-363167407, i47, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:721)");
                                                    }
                                                    final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                                    final Function1<? super TextLayoutResult, Unit> function19 = function18;
                                                    final TextFieldValue textFieldValue5 = textFieldValue4;
                                                    final OffsetMapping offsetMapping4 = offsetMapping3;
                                                    final Density density4 = density3;
                                                    final int i48 = i46;
                                                    MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                        @Override // androidx.compose.ui.layout.MeasurePolicy
                                                        public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i49) {
                                                            LegacyTextFieldState.this.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                                            return LegacyTextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                                        }

                                                        @Override // androidx.compose.ui.layout.MeasurePolicy
                                                        /* renamed from: measure-3p2s80s */
                                                        public MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                                                            Snapshot.Companion companion3 = Snapshot.INSTANCE;
                                                            LegacyTextFieldState legacyTextFieldState6 = LegacyTextFieldState.this;
                                                            Snapshot currentThreadSnapshot = companion3.getCurrentThreadSnapshot();
                                                            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                                            Snapshot makeCurrentNonObservable = companion3.makeCurrentNonObservable(currentThreadSnapshot);
                                                            try {
                                                                TextLayoutResultProxy layoutResult = legacyTextFieldState6.getLayoutResult();
                                                                TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                                                Triple<Integer, Integer, TextLayoutResult> m531layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m531layout_EkL_Y$foundation_release(LegacyTextFieldState.this.getTextDelegate(), j5, measureScope.getLayoutDirection(), value);
                                                                int intValue = m531layout_EkL_Y$foundation_release.component1().intValue();
                                                                int intValue2 = m531layout_EkL_Y$foundation_release.component2().intValue();
                                                                TextLayoutResult component3 = m531layout_EkL_Y$foundation_release.component3();
                                                                if (!Intrinsics.areEqual(value, component3)) {
                                                                    LegacyTextFieldState.this.setLayoutResult(new TextLayoutResultProxy(component3, null, layoutResult != null ? layoutResult.getDecorationBoxCoordinates() : null, 2, null));
                                                                    function19.invoke(component3);
                                                                    CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue5, offsetMapping4);
                                                                }
                                                                LegacyTextFieldState.this.m490setMinHeightForSingleLineField0680j_4(density4.mo209toDpu2uoSUM(i48 == 1 ? TextDelegateKt.ceilToIntPx(component3.getLineBottom(0)) : 0));
                                                                return measureScope.layout(intValue, intValue2, MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(component3.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(component3.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                    public final void invoke2(Placeable.PlacementScope placementScope) {
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                        invoke2(placementScope);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                            } finally {
                                                                companion3.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                                            }
                                                        }
                                                    };
                                                    Modifier.Companion companion3 = Modifier.INSTANCE;
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, companion3);
                                                    ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                                    Function0<ComposeUiNode> constructor = companion4.getConstructor();
                                                    if (composer5.getApplier() == null) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer5.startReusableNode();
                                                    if (composer5.getInserting()) {
                                                        composer5.createNode(constructor);
                                                    } else {
                                                        composer5.useNode();
                                                    }
                                                    Composer m1226constructorimpl = Updater.m1226constructorimpl(composer5);
                                                    Updater.m1227setimpl(m1226constructorimpl, measurePolicy, companion4.getSetMeasurePolicy());
                                                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                                                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
                                                    composer5.endNode();
                                                    TextFieldSelectionManager textFieldSelectionManager4 = TextFieldSelectionManager.this;
                                                    if (legacyTextFieldState4.getHandleState() != HandleState.None && legacyTextFieldState4.getLayoutCoordinates() != null) {
                                                        LayoutCoordinates layoutCoordinates = legacyTextFieldState4.getLayoutCoordinates();
                                                        Intrinsics.checkNotNull(layoutCoordinates);
                                                        if (layoutCoordinates.isAttached() && z34) {
                                                            z36 = true;
                                                            CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z36, composer5, 0);
                                                            if (legacyTextFieldState4.getHandleState() != HandleState.Cursor && !z35 && z34) {
                                                                composer5.startReplaceGroup(-2032274);
                                                                CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer5, 0);
                                                                composer5.endReplaceGroup();
                                                            } else {
                                                                composer5.startReplaceGroup(-1955394);
                                                                composer5.endReplaceGroup();
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                return;
                                                            }
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                    }
                                                    z36 = false;
                                                    CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z36, composer5, 0);
                                                    if (legacyTextFieldState4.getHandleState() != HandleState.Cursor) {
                                                    }
                                                    composer5.startReplaceGroup(-1955394);
                                                    composer5.endReplaceGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                    }
                                                }
                                            }, composer4, 54), composer4, 48, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, composer3, 54), composer3, 6);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer2, 54), composer2, 384);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            textStyle3 = textStyle2;
                            function14 = function13;
                            visualTransformation3 = visualTransformation42;
                            modifier5 = modifier72;
                            brush4 = brush3;
                            z15 = z9;
                            i30 = i25;
                            z16 = z292222;
                            keyboardActions3 = keyboardActions2;
                            imeOptions6 = imeOptions92222;
                            i31 = i362;
                            mutableInteractionSource4 = mutableInteractionSource7222;
                            z17 = z10;
                            function33 = function32;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i23 = i9 & 16384;
                        if (i23 == 0) {
                        }
                        i24 = i9 & 32768;
                        if (i24 != 0) {
                        }
                        if ((i10 & 306783379) != 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i7 & 1) != 0) {
                        }
                        if (i33 != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i12 != 0) {
                        }
                        if (i13 != 0) {
                        }
                        if (i14 != 0) {
                        }
                        if (i15 != 0) {
                        }
                        if (i16 != 0) {
                        }
                        if (i17 != 0) {
                        }
                        if (i18 != 0) {
                        }
                        if ((i9 & 2048) != 0) {
                        }
                        if (i21 != 0) {
                        }
                        if (i22 != 0) {
                        }
                        if (i23 != 0) {
                        }
                        if (i24 != 0) {
                        }
                        visualTransformation2 = none;
                        function13 = function15;
                        i26 = i34;
                        imeOptions3 = imeOptions2;
                        MutableInteractionSource mutableInteractionSource622 = mutableInteractionSource5;
                        textStyle2 = textStyle4;
                        mutableInteractionSource2 = mutableInteractionSource622;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        rememberedValue = startRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (rememberedValue == companion.getEmpty()) {
                        }
                        final FocusRequester focusRequester22 = (FocusRequester) rememberedValue;
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == companion.getEmpty()) {
                        }
                        final LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter22 = (LegacyPlatformTextInputServiceAdapter) rememberedValue2;
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (rememberedValue3 == companion.getEmpty()) {
                        }
                        final TextInputService textInputService22 = (TextInputService) rememberedValue3;
                        final Density density22 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                        FontFamily.Resolver resolver22 = (FontFamily.Resolver) startRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                        long selectionBackgroundColor22 = ((SelectionColors) startRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).getSelectionBackgroundColor();
                        FocusManager focusManager22 = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                        Modifier modifier722 = modifier3;
                        windowInfo = (WindowInfo) startRestartGroup.consume(CompositionLocalsKt.getLocalWindowInfo());
                        SoftwareKeyboardController softwareKeyboardController22 = (SoftwareKeyboardController) startRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                        if (i26 == 1) {
                        }
                        Object[] objArr22 = {orientation};
                        Saver<TextFieldScrollerPosition, Object> saver22 = TextFieldScrollerPosition.INSTANCE.getSaver();
                        changed = startRestartGroup.changed(orientation);
                        final int i3622 = i26;
                        Object rememberedValue2022 = startRestartGroup.rememberedValue();
                        if (changed) {
                        }
                        rememberedValue2022 = new Function0<TextFieldScrollerPosition>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final TextFieldScrollerPosition invoke() {
                                return new TextFieldScrollerPosition(Orientation.this, 0.0f, 2, null);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2022);
                        final TextFieldScrollerPosition textFieldScrollerPosition22 = (TextFieldScrollerPosition) RememberSaveableKt.rememberSaveable(objArr22, saver22, null, (Function0) rememberedValue2022, startRestartGroup, 0, 4);
                        int i3722 = i10 & 14;
                        if (i3722 == 4) {
                        }
                        z11 = ((i10 & 57344) == 16384) | (i3722 == 4);
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (z11) {
                        }
                        TransformedText filterWithValidation22 = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation2, textFieldValue.getText());
                        composition = textFieldValue.getComposition();
                        if (composition != null) {
                        }
                        rememberedValue4 = filterWithValidation22;
                        startRestartGroup.updateRememberedValue(rememberedValue4);
                        final TransformedText transformedText22 = (TransformedText) rememberedValue4;
                        AnnotatedString text22 = transformedText22.getText();
                        final OffsetMapping offsetMapping22 = transformedText22.getOffsetMapping();
                        RecomposeScope currentRecomposeScope22 = ComposablesKt.getCurrentRecomposeScope(startRestartGroup, 0);
                        changed2 = startRestartGroup.changed(softwareKeyboardController22);
                        rememberedValue5 = startRestartGroup.rememberedValue();
                        if (!changed2) {
                        }
                        rememberedValue5 = new LegacyTextFieldState(new TextDelegate(text22, textStyle2, 0, 0, z9, 0, density22, resolver22, null, 300, null), currentRecomposeScope22, softwareKeyboardController22);
                        startRestartGroup.updateRememberedValue(rememberedValue5);
                        legacyTextFieldState = (LegacyTextFieldState) rememberedValue5;
                        legacyTextFieldState.m492updatefnh65Uc(textFieldValue.getText(), text22, textStyle2, z9, density22, resolver22, function1, keyboardActions2, focusManager22, selectionBackgroundColor22);
                        legacyTextFieldState.getProcessor().reset(textFieldValue, legacyTextFieldState.getInputSession());
                        rememberedValue6 = startRestartGroup.rememberedValue();
                        if (rememberedValue6 == companion.getEmpty()) {
                        }
                        UndoManager undoManager22 = (UndoManager) rememberedValue6;
                        UndoManager.snapshotIfNeeded$default(undoManager22, textFieldValue, 0L, 2, null);
                        rememberedValue7 = startRestartGroup.rememberedValue();
                        if (rememberedValue7 == companion.getEmpty()) {
                        }
                        final TextFieldSelectionManager textFieldSelectionManager22 = (TextFieldSelectionManager) rememberedValue7;
                        textFieldSelectionManager22.setOffsetMapping$foundation_release(offsetMapping22);
                        textFieldSelectionManager22.setVisualTransformation$foundation_release(visualTransformation2);
                        textFieldSelectionManager22.setOnValueChange$foundation_release(legacyTextFieldState.getOnValueChange());
                        textFieldSelectionManager22.setState$foundation_release(legacyTextFieldState);
                        textFieldSelectionManager22.setValue$foundation_release(textFieldValue);
                        textFieldSelectionManager22.setClipboardManager$foundation_release((ClipboardManager) startRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
                        textFieldSelectionManager22.setTextToolbar((TextToolbar) startRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
                        textFieldSelectionManager22.setHapticFeedBack((HapticFeedback) startRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
                        textFieldSelectionManager22.setFocusRequester(focusRequester22);
                        textFieldSelectionManager22.setEditable(!z10);
                        textFieldSelectionManager22.setEnabled(z8);
                        rememberedValue8 = startRestartGroup.rememberedValue();
                        if (rememberedValue8 == companion.getEmpty()) {
                        }
                        final CoroutineScope coroutineScope22 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue8).getCoroutineScope();
                        rememberedValue9 = startRestartGroup.rememberedValue();
                        if (rememberedValue9 == companion.getEmpty()) {
                        }
                        final BringIntoViewRequester bringIntoViewRequester22 = (BringIntoViewRequester) rememberedValue9;
                        Modifier.Companion companion222 = Modifier.INSTANCE;
                        int i3822 = i20 & 7168;
                        final VisualTransformation visualTransformation422 = visualTransformation2;
                        int i3922 = i20 & 57344;
                        boolean changedInstance1022 = startRestartGroup.changedInstance(legacyTextFieldState) | (i3822 == 2048) | (i3922 == 16384) | startRestartGroup.changedInstance(textInputService22) | (i3722 == 4);
                        i27 = (i20 & 112) ^ 48;
                        if (i27 > 32) {
                        }
                        i28 = i3922;
                        i29 = i20;
                        if ((i20 & 48) != 32) {
                        }
                        z12 = true;
                        changedInstance = changedInstance1022 | z12 | startRestartGroup.changedInstance(offsetMapping22) | startRestartGroup.changedInstance(coroutineScope22) | startRestartGroup.changedInstance(bringIntoViewRequester22) | startRestartGroup.changedInstance(textFieldSelectionManager22);
                        rememberedValue10 = startRestartGroup.rememberedValue();
                        if (!changedInstance) {
                        }
                        final boolean z202222 = z8;
                        final boolean z212222 = z10;
                        final ImeOptions imeOptions72222 = imeOptions5;
                        rememberedValue10 = new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                                invoke2(focusState);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(FocusState focusState) {
                                TextLayoutResultProxy layoutResult;
                                if (LegacyTextFieldState.this.getHasFocus() == focusState.isFocused()) {
                                    return;
                                }
                                LegacyTextFieldState.this.setHasFocus(focusState.isFocused());
                                if (LegacyTextFieldState.this.getHasFocus() && z202222 && !z212222) {
                                    CoreTextFieldKt.startInputSession(textInputService22, LegacyTextFieldState.this, textFieldValue, imeOptions72222, offsetMapping22);
                                } else {
                                    CoreTextFieldKt.endInputSession(LegacyTextFieldState.this);
                                }
                                if (focusState.isFocused() && (layoutResult = LegacyTextFieldState.this.getLayoutResult()) != null) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope22, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(bringIntoViewRequester22, textFieldValue, LegacyTextFieldState.this, layoutResult, offsetMapping22, null), 3, null);
                                }
                                if (focusState.isFocused()) {
                                    return;
                                }
                                TextFieldSelectionManager.m640deselect_kEHs6E$foundation_release$default(textFieldSelectionManager22, null, 1, null);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue10);
                        MutableInteractionSource mutableInteractionSource72222 = mutableInteractionSource3;
                        textFieldFocusModifier = TextFieldGestureModifiersKt.textFieldFocusModifier(companion222, z8, focusRequester22, mutableInteractionSource72222, (Function1) rememberedValue10);
                        State rememberUpdatedState2222 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf((z8 || z10) ? false : true), startRestartGroup, 0);
                        Unit unit2222 = Unit.INSTANCE;
                        boolean changed32222 = startRestartGroup.changed(rememberUpdatedState2222) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService22) | startRestartGroup.changedInstance(textFieldSelectionManager22);
                        if (i27 > 32) {
                        }
                        modifier4 = textFieldFocusModifier;
                        if ((i29 & 48) != 32) {
                        }
                        z13 = true;
                        z14 = changed32222 | z13;
                        rememberedValue11 = startRestartGroup.rememberedValue();
                        if (!z14) {
                        }
                        rememberedValue11 = new CoreTextFieldKt$CoreTextField$2$1(legacyTextFieldState, rememberUpdatedState2222, textInputService22, textFieldSelectionManager22, imeOptions5, null);
                        startRestartGroup.updateRememberedValue(rememberedValue11);
                        EffectsKt.LaunchedEffect(unit2222, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue11, startRestartGroup, 6);
                        changedInstance2 = startRestartGroup.changedInstance(legacyTextFieldState);
                        rememberedValue12 = startRestartGroup.rememberedValue();
                        if (!changedInstance2) {
                        }
                        rememberedValue12 = new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                invoke(bool.booleanValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z2222222) {
                                LegacyTextFieldState.this.setInTouchMode(z2222222);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue12);
                        Modifier updateSelectionTouchMode22222 = SelectionGesturesKt.updateSelectionTouchMode(companion222, (Function1) rememberedValue12);
                        int i4022222 = i28;
                        changedInstance3 = startRestartGroup.changedInstance(legacyTextFieldState) | (i4022222 != 16384) | (i3822 != 2048) | startRestartGroup.changedInstance(offsetMapping22) | startRestartGroup.changedInstance(textFieldSelectionManager22);
                        rememberedValue13 = startRestartGroup.rememberedValue();
                        if (!changedInstance3) {
                        }
                        final boolean z2222222 = z10;
                        final boolean z2322222 = z8;
                        rememberedValue13 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                                m473invokek4lQ0M(offset.getPackedValue());
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                            public final void m473invokek4lQ0M(long j5) {
                                CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester22, !z2222222);
                                if (LegacyTextFieldState.this.getHasFocus() && z2322222) {
                                    if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                                        textFieldSelectionManager22.m643deselect_kEHs6E$foundation_release(Offset.m1328boximpl(j5));
                                        return;
                                    }
                                    TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                    if (layoutResult != null) {
                                        LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                        TextFieldDelegate.INSTANCE.m532setCursorOffsetULxng0E$foundation_release(j5, layoutResult, legacyTextFieldState2.getProcessor(), offsetMapping22, legacyTextFieldState2.getOnValueChange());
                                        if (legacyTextFieldState2.getTextDelegate().getText().length() > 0) {
                                            legacyTextFieldState2.setHandleState(HandleState.Cursor);
                                        }
                                    }
                                }
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue13);
                        Modifier pointerHoverIcon$default22222 = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(updateSelectionTouchMode22222, mutableInteractionSource72222, z8, (Function1) rememberedValue13), textFieldSelectionManager22.getMouseSelectionObserver(), textFieldSelectionManager22.getTouchSelectionObserver()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                        changedInstance4 = startRestartGroup.changedInstance(legacyTextFieldState) | (i3722 != 4) | startRestartGroup.changedInstance(offsetMapping22);
                        rememberedValue14 = startRestartGroup.rememberedValue();
                        if (!changedInstance4) {
                        }
                        rememberedValue14 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                invoke2(drawScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(DrawScope drawScope) {
                                TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                if (layoutResult != null) {
                                    TextFieldValue textFieldValue2 = textFieldValue;
                                    LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                    OffsetMapping offsetMapping222 = offsetMapping22;
                                    TextFieldDelegate.INSTANCE.m530drawQ1vqE60$foundation_release(drawScope.getDrawContext().getCanvas(), textFieldValue2, legacyTextFieldState2.m488getSelectionPreviewHighlightRanged9O1mEE(), legacyTextFieldState2.m485getDeletionPreviewHighlightRanged9O1mEE(), offsetMapping222, layoutResult.getValue(), legacyTextFieldState2.getHighlightPaint(), legacyTextFieldState2.getSelectionBackgroundColor());
                                }
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue14);
                        final Modifier drawBehind22222 = DrawModifierKt.drawBehind(companion222, (Function1) rememberedValue14);
                        changedInstance5 = startRestartGroup.changedInstance(legacyTextFieldState) | (i3822 != 2048) | startRestartGroup.changed(windowInfo) | startRestartGroup.changedInstance(textFieldSelectionManager22) | (i3722 != 4) | startRestartGroup.changedInstance(offsetMapping22);
                        rememberedValue15 = startRestartGroup.rememberedValue();
                        if (!changedInstance5) {
                        }
                        final boolean z2422222 = z8;
                        rememberedValue15 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                invoke2(layoutCoordinates);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                LegacyTextFieldState.this.setLayoutCoordinates(layoutCoordinates);
                                TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                if (layoutResult != null) {
                                    layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
                                }
                                if (z2422222) {
                                    if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                                        if (LegacyTextFieldState.this.getShowFloatingToolbar() && windowInfo.isWindowFocused()) {
                                            textFieldSelectionManager22.showSelectionToolbar$foundation_release();
                                        } else {
                                            textFieldSelectionManager22.hideSelectionToolbar$foundation_release();
                                        }
                                        LegacyTextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager22, true));
                                        LegacyTextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager22, false));
                                        LegacyTextFieldState.this.setShowCursorHandle(TextRange.m2279getCollapsedimpl(textFieldValue.getSelection()));
                                    } else if (LegacyTextFieldState.this.getHandleState() == HandleState.Cursor) {
                                        LegacyTextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager22, true));
                                    }
                                    CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue, offsetMapping22);
                                    TextLayoutResultProxy layoutResult2 = LegacyTextFieldState.this.getLayoutResult();
                                    if (layoutResult2 != null) {
                                        LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                        TextFieldValue textFieldValue2 = textFieldValue;
                                        OffsetMapping offsetMapping222 = offsetMapping22;
                                        TextInputSession inputSession = legacyTextFieldState2.getInputSession();
                                        if (inputSession == null || !legacyTextFieldState2.getHasFocus()) {
                                            return;
                                        }
                                        TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation_release(inputSession, textFieldValue2, offsetMapping222, layoutResult2);
                                    }
                                }
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue15);
                        final Modifier onGloballyPositioned32222 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion222, (Function1) rememberedValue15);
                        final boolean z2522222 = visualTransformation422 instanceof PasswordVisualTransformation;
                        changedInstance6 = (i3822 != 2048) | startRestartGroup.changedInstance(transformedText22) | (i3722 != 4) | startRestartGroup.changed(z2522222) | (i4022222 != 16384) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(offsetMapping22) | startRestartGroup.changedInstance(textFieldSelectionManager22) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32);
                        rememberedValue16 = startRestartGroup.rememberedValue();
                        if (!changedInstance6) {
                        }
                        final boolean z2622222 = z8;
                        final boolean z2722222 = z10;
                        final ImeOptions imeOptions822222 = imeOptions5;
                        rememberedValue16 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(final SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, TransformedText.this.getText());
                                SemanticsPropertiesKt.m2185setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, textFieldValue.getSelection());
                                if (!z2622222) {
                                    SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                                }
                                if (z2522222) {
                                    SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                                }
                                boolean z282 = z2622222 && !z2722222;
                                SemanticsPropertiesKt.setEditable(semanticsPropertyReceiver, z282);
                                final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                                SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(List<TextLayoutResult> list) {
                                        boolean z2922222;
                                        if (LegacyTextFieldState.this.getLayoutResult() != null) {
                                            TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                            Intrinsics.checkNotNull(layoutResult);
                                            list.add(layoutResult.getValue());
                                            z2922222 = true;
                                        } else {
                                            z2922222 = false;
                                        }
                                        return Boolean.valueOf(z2922222);
                                    }
                                }, 1, null);
                                if (z282) {
                                    final LegacyTextFieldState legacyTextFieldState3 = legacyTextFieldState;
                                    SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Boolean invoke(AnnotatedString annotatedString) {
                                            Unit unit22222;
                                            TextInputSession inputSession = LegacyTextFieldState.this.getInputSession();
                                            if (inputSession != null) {
                                                LegacyTextFieldState legacyTextFieldState4 = LegacyTextFieldState.this;
                                                TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(annotatedString, 1)}), legacyTextFieldState4.getProcessor(), legacyTextFieldState4.getOnValueChange(), inputSession);
                                                unit22222 = Unit.INSTANCE;
                                            } else {
                                                unit22222 = null;
                                            }
                                            if (unit22222 == null) {
                                                LegacyTextFieldState.this.getOnValueChange().invoke(new TextFieldValue(annotatedString.getText(), TextRangeKt.TextRange(annotatedString.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                            }
                                            return Boolean.TRUE;
                                        }
                                    }, 1, null);
                                    final boolean z2922222 = z2722222;
                                    final boolean z3022222 = z2622222;
                                    final LegacyTextFieldState legacyTextFieldState4 = legacyTextFieldState;
                                    final TextFieldValue textFieldValue2 = textFieldValue;
                                    SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Boolean invoke(AnnotatedString annotatedString) {
                                            Unit unit22222;
                                            if (!z2922222 && z3022222) {
                                                TextInputSession inputSession = legacyTextFieldState4.getInputSession();
                                                if (inputSession != null) {
                                                    LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                                    TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(annotatedString, 1)}), legacyTextFieldState5.getProcessor(), legacyTextFieldState5.getOnValueChange(), inputSession);
                                                    unit22222 = Unit.INSTANCE;
                                                } else {
                                                    unit22222 = null;
                                                }
                                                if (unit22222 == null) {
                                                    TextFieldValue textFieldValue3 = textFieldValue2;
                                                    legacyTextFieldState4.getOnValueChange().invoke(new TextFieldValue(StringsKt.replaceRange(textFieldValue3.getText(), TextRange.m2285getStartimpl(textFieldValue3.getSelection()), TextRange.m2280getEndimpl(textFieldValue3.getSelection()), annotatedString).toString(), TextRangeKt.TextRange(TextRange.m2285getStartimpl(textFieldValue3.getSelection()) + annotatedString.length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                }
                                                return Boolean.TRUE;
                                            }
                                            return Boolean.FALSE;
                                        }
                                    }, 1, null);
                                }
                                final OffsetMapping offsetMapping222 = offsetMapping22;
                                final boolean z3122222 = z2622222;
                                final TextFieldValue textFieldValue3 = textFieldValue;
                                final TextFieldSelectionManager textFieldSelectionManager222 = textFieldSelectionManager22;
                                final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState;
                                SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                                        return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                                    }

                                    public final Boolean invoke(int i4122222, int i42, boolean z32) {
                                        if (!z32) {
                                            i4122222 = OffsetMapping.this.transformedToOriginal(i4122222);
                                        }
                                        if (!z32) {
                                            i42 = OffsetMapping.this.transformedToOriginal(i42);
                                        }
                                        boolean z33 = false;
                                        if (z3122222 && (i4122222 != TextRange.m2285getStartimpl(textFieldValue3.getSelection()) || i42 != TextRange.m2280getEndimpl(textFieldValue3.getSelection()))) {
                                            if (Math.min(i4122222, i42) >= 0 && Math.max(i4122222, i42) <= textFieldValue3.getText().length()) {
                                                if (!z32 && i4122222 != i42) {
                                                    TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager222, false, 1, null);
                                                } else {
                                                    textFieldSelectionManager222.exitSelectionMode$foundation_release();
                                                }
                                                legacyTextFieldState5.getOnValueChange().invoke(new TextFieldValue(textFieldValue3.getText(), TextRangeKt.TextRange(i4122222, i42), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                                z33 = true;
                                            } else {
                                                textFieldSelectionManager222.exitSelectionMode$foundation_release();
                                            }
                                        }
                                        return Boolean.valueOf(z33);
                                    }
                                }, 1, null);
                                int imeAction = imeOptions822222.getImeAction();
                                final LegacyTextFieldState legacyTextFieldState6 = legacyTextFieldState;
                                final ImeOptions imeOptions922222 = imeOptions822222;
                                SemanticsPropertiesKt.m2182onImeAction9UiTYpY$default(semanticsPropertyReceiver, imeAction, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.5
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        LegacyTextFieldState.this.getOnImeActionPerformed().invoke(ImeAction.m2375boximpl(imeOptions922222.getImeAction()));
                                        return Boolean.TRUE;
                                    }
                                }, 2, null);
                                final LegacyTextFieldState legacyTextFieldState7 = legacyTextFieldState;
                                final FocusRequester focusRequester222 = focusRequester22;
                                final boolean z32 = z2722222;
                                SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.6
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester222, !z32);
                                        return Boolean.TRUE;
                                    }
                                }, 1, null);
                                final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager22;
                                SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.7
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        TextFieldSelectionManager.enterSelectionMode$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                        return Boolean.TRUE;
                                    }
                                }, 1, null);
                                if (!TextRange.m2279getCollapsedimpl(textFieldValue.getSelection()) && !z2522222) {
                                    final TextFieldSelectionManager textFieldSelectionManager4 = textFieldSelectionManager22;
                                    SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.8
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            TextFieldSelectionManager.copy$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                            return Boolean.TRUE;
                                        }
                                    }, 1, null);
                                    if (z2622222 && !z2722222) {
                                        final TextFieldSelectionManager textFieldSelectionManager5 = textFieldSelectionManager22;
                                        SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.9
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                TextFieldSelectionManager.this.cut$foundation_release();
                                                return Boolean.TRUE;
                                            }
                                        }, 1, null);
                                    }
                                }
                                if (!z2622222 || z2722222) {
                                    return;
                                }
                                final TextFieldSelectionManager textFieldSelectionManager6 = textFieldSelectionManager22;
                                SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.10
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        TextFieldSelectionManager.this.paste$foundation_release();
                                        return Boolean.TRUE;
                                    }
                                }, 1, null);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue16);
                        Modifier semantics22222 = SemanticsModifierKt.semantics(companion222, true, (Function1) rememberedValue16);
                        final Modifier cursor22222 = TextFieldCursorKt.cursor(companion222, legacyTextFieldState, textFieldValue, offsetMapping22, brush3, (z8 || z10 || !windowInfo.isWindowFocused() || legacyTextFieldState.hasHighlight()) ? false : true);
                        changedInstance7 = startRestartGroup.changedInstance(textFieldSelectionManager22);
                        rememberedValue17 = startRestartGroup.rememberedValue();
                        if (!changedInstance7) {
                        }
                        rememberedValue17 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                final TextFieldSelectionManager textFieldSelectionManager222 = TextFieldSelectionManager.this;
                                return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                                    }
                                };
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue17);
                        EffectsKt.DisposableEffect(textFieldSelectionManager22, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue17, startRestartGroup, 0);
                        changedInstance8 = (i3722 != 4) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService22) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32);
                        rememberedValue18 = startRestartGroup.rememberedValue();
                        if (!changedInstance8) {
                        }
                        rememberedValue18 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                if (LegacyTextFieldState.this.getHasFocus()) {
                                    LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                    legacyTextFieldState2.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(textInputService22, textFieldValue, legacyTextFieldState2.getProcessor(), imeOptions5, LegacyTextFieldState.this.getOnValueChange(), LegacyTextFieldState.this.getOnImeActionPerformed()));
                                }
                                return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                    }
                                };
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue18);
                        EffectsKt.DisposableEffect(imeOptions5, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue18, startRestartGroup, (i29 >> 3) & 14);
                        Modifier m539textFieldKeyInput2WJ9YEU22222 = TextFieldKeyInputKt.m539textFieldKeyInput2WJ9YEU(companion222, legacyTextFieldState, textFieldSelectionManager22, textFieldValue, legacyTextFieldState.getOnValueChange(), !z10, i3622 != 1, offsetMapping22, undoManager22, imeOptions5.getImeAction());
                        boolean CoreTextField$lambda$1122222 = CoreTextField$lambda$11(rememberUpdatedState2222);
                        changedInstance9 = startRestartGroup.changedInstance(legacyTextFieldState) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32) | startRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter22);
                        rememberedValue19 = startRestartGroup.rememberedValue();
                        if (!changedInstance9) {
                        }
                        rememberedValue19 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$stylusHandwritingModifier$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                if (!LegacyTextFieldState.this.getHasFocus()) {
                                    focusRequester22.requestFocus();
                                }
                                int keyboardType = imeOptions5.getKeyboardType();
                                KeyboardType.Companion companion3 = KeyboardType.INSTANCE;
                                if (!KeyboardType.m2410equalsimpl0(keyboardType, companion3.m2419getPasswordPjHm6EE()) && !KeyboardType.m2410equalsimpl0(imeOptions5.getKeyboardType(), companion3.m2418getNumberPasswordPjHm6EE())) {
                                    legacyPlatformTextInputServiceAdapter22.startStylusHandwriting();
                                }
                                return Boolean.TRUE;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue19);
                        Modifier onGloballyPositioned222222 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier722, legacyPlatformTextInputServiceAdapter22, legacyTextFieldState, textFieldSelectionManager22).then(StylusHandwritingKt.stylusHandwriting(companion222, CoreTextField$lambda$1122222, (Function0) rememberedValue19)).then(modifier4), legacyTextFieldState, focusManager22), legacyTextFieldState, textFieldSelectionManager22).then(m539textFieldKeyInput2WJ9YEU22222), textFieldScrollerPosition22, mutableInteractionSource72222, z8).then(pointerHoverIcon$default22222).then(semantics22222), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                                invoke2(layoutCoordinates);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LayoutCoordinates layoutCoordinates) {
                                TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                if (layoutResult == null) {
                                    return;
                                }
                                layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                            }
                        });
                        if (z8) {
                        }
                        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3422222 = function32;
                        final TextStyle textStyle522222 = textStyle2;
                        final int i4122222 = i25;
                        boolean z2922222 = z8;
                        ImeOptions imeOptions922222 = imeOptions5;
                        final Modifier textFieldMagnifier22222 = !z28 ? TextFieldSelectionManager_androidKt.textFieldMagnifier(companion222, textFieldSelectionManager22) : companion222;
                        final boolean z3022222 = z28;
                        final boolean z3122222 = z10;
                        final Function1<? super TextLayoutResult, Unit> function1622222 = function13;
                        composer2 = startRestartGroup;
                        CoreTextFieldRootBox(onGloballyPositioned222222, textFieldSelectionManager22, ComposableLambdaKt.rememberComposableLambda(-374338080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i42) {
                                if ((i42 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-374338080, i42, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:695)");
                                }
                                Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function35 = function3422222;
                                final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                                final TextStyle textStyle6 = textStyle522222;
                                final int i43 = i4122222;
                                final int i44 = i3622;
                                final TextFieldScrollerPosition textFieldScrollerPosition222 = textFieldScrollerPosition22;
                                final TextFieldValue textFieldValue2 = textFieldValue;
                                final VisualTransformation visualTransformation5 = visualTransformation422;
                                final Modifier modifier8 = cursor22222;
                                final Modifier modifier9 = drawBehind22222;
                                final Modifier modifier10 = onGloballyPositioned32222;
                                final Modifier modifier11 = textFieldMagnifier22222;
                                final BringIntoViewRequester bringIntoViewRequester222 = bringIntoViewRequester22;
                                final TextFieldSelectionManager textFieldSelectionManager222 = textFieldSelectionManager22;
                                final boolean z32 = z3022222;
                                final boolean z33 = z3122222;
                                final Function1<? super TextLayoutResult, Unit> function17 = function1622222;
                                final OffsetMapping offsetMapping222 = offsetMapping22;
                                final Density density222 = density22;
                                function35.invoke(ComposableLambdaKt.rememberComposableLambda(2032502107, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i45) {
                                        if ((i45 & 3) == 2 && composer4.getSkipping()) {
                                            composer4.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(2032502107, i45, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:698)");
                                        }
                                        Modifier heightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m327heightInVpY3zN4$default(Modifier.INSTANCE, LegacyTextFieldState.this.m486getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle6, i43, i44);
                                        TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition222;
                                        TextFieldValue textFieldValue3 = textFieldValue2;
                                        VisualTransformation visualTransformation6 = visualTransformation5;
                                        boolean changedInstance11 = composer4.changedInstance(LegacyTextFieldState.this);
                                        final LegacyTextFieldState legacyTextFieldState3 = LegacyTextFieldState.this;
                                        Object rememberedValue21 = composer4.rememberedValue();
                                        if (changedInstance11 || rememberedValue21 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue21 = new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1$1
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final TextLayoutResultProxy invoke() {
                                                    return LegacyTextFieldState.this.getLayoutResult();
                                                }
                                            };
                                            composer4.updateRememberedValue(rememberedValue21);
                                        }
                                        Modifier bringIntoViewRequester3 = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(heightInLines, textFieldScrollerPosition3, textFieldValue3, visualTransformation6, (Function0) rememberedValue21).then(modifier8).then(modifier9), textStyle6).then(modifier10).then(modifier11), bringIntoViewRequester222);
                                        final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager222;
                                        final LegacyTextFieldState legacyTextFieldState4 = LegacyTextFieldState.this;
                                        final boolean z34 = z32;
                                        final boolean z35 = z33;
                                        final Function1<? super TextLayoutResult, Unit> function18 = function17;
                                        final TextFieldValue textFieldValue4 = textFieldValue2;
                                        final OffsetMapping offsetMapping3 = offsetMapping222;
                                        final Density density3 = density222;
                                        final int i46 = i44;
                                        SimpleLayoutKt.SimpleLayout(bringIntoViewRequester3, ComposableLambdaKt.rememberComposableLambda(-363167407, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                invoke(composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX WARN: Removed duplicated region for block: B:39:0x00ff  */
                                            /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
                                            /*
                                                Code decompiled incorrectly, please refer to instructions dump.
                                            */
                                            public final void invoke(Composer composer5, int i47) {
                                                boolean z36;
                                                if ((i47 & 3) == 2 && composer5.getSkipping()) {
                                                    composer5.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-363167407, i47, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:721)");
                                                }
                                                final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                                final Function1<? super TextLayoutResult, Unit> function19 = function18;
                                                final TextFieldValue textFieldValue5 = textFieldValue4;
                                                final OffsetMapping offsetMapping4 = offsetMapping3;
                                                final Density density4 = density3;
                                                final int i48 = i46;
                                                MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                    @Override // androidx.compose.ui.layout.MeasurePolicy
                                                    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i49) {
                                                        LegacyTextFieldState.this.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                                        return LegacyTextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                                    }

                                                    @Override // androidx.compose.ui.layout.MeasurePolicy
                                                    /* renamed from: measure-3p2s80s */
                                                    public MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                                                        Snapshot.Companion companion3 = Snapshot.INSTANCE;
                                                        LegacyTextFieldState legacyTextFieldState6 = LegacyTextFieldState.this;
                                                        Snapshot currentThreadSnapshot = companion3.getCurrentThreadSnapshot();
                                                        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                                        Snapshot makeCurrentNonObservable = companion3.makeCurrentNonObservable(currentThreadSnapshot);
                                                        try {
                                                            TextLayoutResultProxy layoutResult = legacyTextFieldState6.getLayoutResult();
                                                            TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                                            Triple<Integer, Integer, TextLayoutResult> m531layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m531layout_EkL_Y$foundation_release(LegacyTextFieldState.this.getTextDelegate(), j5, measureScope.getLayoutDirection(), value);
                                                            int intValue = m531layout_EkL_Y$foundation_release.component1().intValue();
                                                            int intValue2 = m531layout_EkL_Y$foundation_release.component2().intValue();
                                                            TextLayoutResult component3 = m531layout_EkL_Y$foundation_release.component3();
                                                            if (!Intrinsics.areEqual(value, component3)) {
                                                                LegacyTextFieldState.this.setLayoutResult(new TextLayoutResultProxy(component3, null, layoutResult != null ? layoutResult.getDecorationBoxCoordinates() : null, 2, null));
                                                                function19.invoke(component3);
                                                                CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue5, offsetMapping4);
                                                            }
                                                            LegacyTextFieldState.this.m490setMinHeightForSingleLineField0680j_4(density4.mo209toDpu2uoSUM(i48 == 1 ? TextDelegateKt.ceilToIntPx(component3.getLineBottom(0)) : 0));
                                                            return measureScope.layout(intValue, intValue2, MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(component3.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(component3.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                    invoke2(placementScope);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                        } finally {
                                                            companion3.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                                        }
                                                    }
                                                };
                                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, companion3);
                                                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                                Function0<ComposeUiNode> constructor = companion4.getConstructor();
                                                if (composer5.getApplier() == null) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer5.startReusableNode();
                                                if (composer5.getInserting()) {
                                                    composer5.createNode(constructor);
                                                } else {
                                                    composer5.useNode();
                                                }
                                                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer5);
                                                Updater.m1227setimpl(m1226constructorimpl, measurePolicy, companion4.getSetMeasurePolicy());
                                                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                                                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
                                                composer5.endNode();
                                                TextFieldSelectionManager textFieldSelectionManager4 = TextFieldSelectionManager.this;
                                                if (legacyTextFieldState4.getHandleState() != HandleState.None && legacyTextFieldState4.getLayoutCoordinates() != null) {
                                                    LayoutCoordinates layoutCoordinates = legacyTextFieldState4.getLayoutCoordinates();
                                                    Intrinsics.checkNotNull(layoutCoordinates);
                                                    if (layoutCoordinates.isAttached() && z34) {
                                                        z36 = true;
                                                        CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z36, composer5, 0);
                                                        if (legacyTextFieldState4.getHandleState() != HandleState.Cursor && !z35 && z34) {
                                                            composer5.startReplaceGroup(-2032274);
                                                            CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer5, 0);
                                                            composer5.endReplaceGroup();
                                                        } else {
                                                            composer5.startReplaceGroup(-1955394);
                                                            composer5.endReplaceGroup();
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            return;
                                                        }
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                }
                                                z36 = false;
                                                CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z36, composer5, 0);
                                                if (legacyTextFieldState4.getHandleState() != HandleState.Cursor) {
                                                }
                                                composer5.startReplaceGroup(-1955394);
                                                composer5.endReplaceGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                }
                                            }
                                        }, composer4, 54), composer4, 48, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer3, 54), composer3, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer2, 54), composer2, 384);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        textStyle3 = textStyle2;
                        function14 = function13;
                        visualTransformation3 = visualTransformation422;
                        modifier5 = modifier722;
                        brush4 = brush3;
                        z15 = z9;
                        i30 = i25;
                        z16 = z2922222;
                        keyboardActions3 = keyboardActions2;
                        imeOptions6 = imeOptions922222;
                        i31 = i3622;
                        mutableInteractionSource4 = mutableInteractionSource72222;
                        z17 = z10;
                        function33 = function32;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i22 = i9 & 8192;
                    if (i22 != 0) {
                    }
                    i23 = i9 & 16384;
                    if (i23 == 0) {
                    }
                    i24 = i9 & 32768;
                    if (i24 != 0) {
                    }
                    if ((i10 & 306783379) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i7 & 1) != 0) {
                    }
                    if (i33 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i14 != 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (i16 != 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if ((i9 & 2048) != 0) {
                    }
                    if (i21 != 0) {
                    }
                    if (i22 != 0) {
                    }
                    if (i23 != 0) {
                    }
                    if (i24 != 0) {
                    }
                    visualTransformation2 = none;
                    function13 = function15;
                    i26 = i34;
                    imeOptions3 = imeOptions2;
                    MutableInteractionSource mutableInteractionSource6222 = mutableInteractionSource5;
                    textStyle2 = textStyle4;
                    mutableInteractionSource2 = mutableInteractionSource6222;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    rememberedValue = startRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                    }
                    final FocusRequester focusRequester222 = (FocusRequester) rememberedValue;
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (rememberedValue2 == companion.getEmpty()) {
                    }
                    final LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter222 = (LegacyPlatformTextInputServiceAdapter) rememberedValue2;
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (rememberedValue3 == companion.getEmpty()) {
                    }
                    final TextInputService textInputService222 = (TextInputService) rememberedValue3;
                    final Density density222 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                    FontFamily.Resolver resolver222 = (FontFamily.Resolver) startRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                    long selectionBackgroundColor222 = ((SelectionColors) startRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).getSelectionBackgroundColor();
                    FocusManager focusManager222 = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                    Modifier modifier7222 = modifier3;
                    windowInfo = (WindowInfo) startRestartGroup.consume(CompositionLocalsKt.getLocalWindowInfo());
                    SoftwareKeyboardController softwareKeyboardController222 = (SoftwareKeyboardController) startRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                    if (i26 == 1) {
                    }
                    Object[] objArr222 = {orientation};
                    Saver<TextFieldScrollerPosition, Object> saver222 = TextFieldScrollerPosition.INSTANCE.getSaver();
                    changed = startRestartGroup.changed(orientation);
                    final int i36222 = i26;
                    Object rememberedValue20222 = startRestartGroup.rememberedValue();
                    if (changed) {
                    }
                    rememberedValue20222 = new Function0<TextFieldScrollerPosition>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final TextFieldScrollerPosition invoke() {
                            return new TextFieldScrollerPosition(Orientation.this, 0.0f, 2, null);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue20222);
                    final TextFieldScrollerPosition textFieldScrollerPosition222 = (TextFieldScrollerPosition) RememberSaveableKt.rememberSaveable(objArr222, saver222, null, (Function0) rememberedValue20222, startRestartGroup, 0, 4);
                    int i37222 = i10 & 14;
                    if (i37222 == 4) {
                    }
                    z11 = ((i10 & 57344) == 16384) | (i37222 == 4);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (z11) {
                    }
                    TransformedText filterWithValidation222 = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation2, textFieldValue.getText());
                    composition = textFieldValue.getComposition();
                    if (composition != null) {
                    }
                    rememberedValue4 = filterWithValidation222;
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                    final TransformedText transformedText222 = (TransformedText) rememberedValue4;
                    AnnotatedString text222 = transformedText222.getText();
                    final OffsetMapping offsetMapping222 = transformedText222.getOffsetMapping();
                    RecomposeScope currentRecomposeScope222 = ComposablesKt.getCurrentRecomposeScope(startRestartGroup, 0);
                    changed2 = startRestartGroup.changed(softwareKeyboardController222);
                    rememberedValue5 = startRestartGroup.rememberedValue();
                    if (!changed2) {
                    }
                    rememberedValue5 = new LegacyTextFieldState(new TextDelegate(text222, textStyle2, 0, 0, z9, 0, density222, resolver222, null, 300, null), currentRecomposeScope222, softwareKeyboardController222);
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                    legacyTextFieldState = (LegacyTextFieldState) rememberedValue5;
                    legacyTextFieldState.m492updatefnh65Uc(textFieldValue.getText(), text222, textStyle2, z9, density222, resolver222, function1, keyboardActions2, focusManager222, selectionBackgroundColor222);
                    legacyTextFieldState.getProcessor().reset(textFieldValue, legacyTextFieldState.getInputSession());
                    rememberedValue6 = startRestartGroup.rememberedValue();
                    if (rememberedValue6 == companion.getEmpty()) {
                    }
                    UndoManager undoManager222 = (UndoManager) rememberedValue6;
                    UndoManager.snapshotIfNeeded$default(undoManager222, textFieldValue, 0L, 2, null);
                    rememberedValue7 = startRestartGroup.rememberedValue();
                    if (rememberedValue7 == companion.getEmpty()) {
                    }
                    final TextFieldSelectionManager textFieldSelectionManager222 = (TextFieldSelectionManager) rememberedValue7;
                    textFieldSelectionManager222.setOffsetMapping$foundation_release(offsetMapping222);
                    textFieldSelectionManager222.setVisualTransformation$foundation_release(visualTransformation2);
                    textFieldSelectionManager222.setOnValueChange$foundation_release(legacyTextFieldState.getOnValueChange());
                    textFieldSelectionManager222.setState$foundation_release(legacyTextFieldState);
                    textFieldSelectionManager222.setValue$foundation_release(textFieldValue);
                    textFieldSelectionManager222.setClipboardManager$foundation_release((ClipboardManager) startRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
                    textFieldSelectionManager222.setTextToolbar((TextToolbar) startRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
                    textFieldSelectionManager222.setHapticFeedBack((HapticFeedback) startRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
                    textFieldSelectionManager222.setFocusRequester(focusRequester222);
                    textFieldSelectionManager222.setEditable(!z10);
                    textFieldSelectionManager222.setEnabled(z8);
                    rememberedValue8 = startRestartGroup.rememberedValue();
                    if (rememberedValue8 == companion.getEmpty()) {
                    }
                    final CoroutineScope coroutineScope222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue8).getCoroutineScope();
                    rememberedValue9 = startRestartGroup.rememberedValue();
                    if (rememberedValue9 == companion.getEmpty()) {
                    }
                    final BringIntoViewRequester bringIntoViewRequester222 = (BringIntoViewRequester) rememberedValue9;
                    Modifier.Companion companion2222 = Modifier.INSTANCE;
                    int i38222 = i20 & 7168;
                    final VisualTransformation visualTransformation4222 = visualTransformation2;
                    int i39222 = i20 & 57344;
                    boolean changedInstance10222 = startRestartGroup.changedInstance(legacyTextFieldState) | (i38222 == 2048) | (i39222 == 16384) | startRestartGroup.changedInstance(textInputService222) | (i37222 == 4);
                    i27 = (i20 & 112) ^ 48;
                    if (i27 > 32) {
                    }
                    i28 = i39222;
                    i29 = i20;
                    if ((i20 & 48) != 32) {
                    }
                    z12 = true;
                    changedInstance = changedInstance10222 | z12 | startRestartGroup.changedInstance(offsetMapping222) | startRestartGroup.changedInstance(coroutineScope222) | startRestartGroup.changedInstance(bringIntoViewRequester222) | startRestartGroup.changedInstance(textFieldSelectionManager222);
                    rememberedValue10 = startRestartGroup.rememberedValue();
                    if (!changedInstance) {
                    }
                    final boolean z2022222 = z8;
                    final boolean z2122222 = z10;
                    final ImeOptions imeOptions722222 = imeOptions5;
                    rememberedValue10 = new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                            invoke2(focusState);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(FocusState focusState) {
                            TextLayoutResultProxy layoutResult;
                            if (LegacyTextFieldState.this.getHasFocus() == focusState.isFocused()) {
                                return;
                            }
                            LegacyTextFieldState.this.setHasFocus(focusState.isFocused());
                            if (LegacyTextFieldState.this.getHasFocus() && z2022222 && !z2122222) {
                                CoreTextFieldKt.startInputSession(textInputService222, LegacyTextFieldState.this, textFieldValue, imeOptions722222, offsetMapping222);
                            } else {
                                CoreTextFieldKt.endInputSession(LegacyTextFieldState.this);
                            }
                            if (focusState.isFocused() && (layoutResult = LegacyTextFieldState.this.getLayoutResult()) != null) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope222, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(bringIntoViewRequester222, textFieldValue, LegacyTextFieldState.this, layoutResult, offsetMapping222, null), 3, null);
                            }
                            if (focusState.isFocused()) {
                                return;
                            }
                            TextFieldSelectionManager.m640deselect_kEHs6E$foundation_release$default(textFieldSelectionManager222, null, 1, null);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue10);
                    MutableInteractionSource mutableInteractionSource722222 = mutableInteractionSource3;
                    textFieldFocusModifier = TextFieldGestureModifiersKt.textFieldFocusModifier(companion2222, z8, focusRequester222, mutableInteractionSource722222, (Function1) rememberedValue10);
                    State rememberUpdatedState22222 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf((z8 || z10) ? false : true), startRestartGroup, 0);
                    Unit unit22222 = Unit.INSTANCE;
                    boolean changed322222 = startRestartGroup.changed(rememberUpdatedState22222) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService222) | startRestartGroup.changedInstance(textFieldSelectionManager222);
                    if (i27 > 32) {
                    }
                    modifier4 = textFieldFocusModifier;
                    if ((i29 & 48) != 32) {
                    }
                    z13 = true;
                    z14 = changed322222 | z13;
                    rememberedValue11 = startRestartGroup.rememberedValue();
                    if (!z14) {
                    }
                    rememberedValue11 = new CoreTextFieldKt$CoreTextField$2$1(legacyTextFieldState, rememberUpdatedState22222, textInputService222, textFieldSelectionManager222, imeOptions5, null);
                    startRestartGroup.updateRememberedValue(rememberedValue11);
                    EffectsKt.LaunchedEffect(unit22222, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue11, startRestartGroup, 6);
                    changedInstance2 = startRestartGroup.changedInstance(legacyTextFieldState);
                    rememberedValue12 = startRestartGroup.rememberedValue();
                    if (!changedInstance2) {
                    }
                    rememberedValue12 = new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z22222222) {
                            LegacyTextFieldState.this.setInTouchMode(z22222222);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue12);
                    Modifier updateSelectionTouchMode222222 = SelectionGesturesKt.updateSelectionTouchMode(companion2222, (Function1) rememberedValue12);
                    int i40222222 = i28;
                    changedInstance3 = startRestartGroup.changedInstance(legacyTextFieldState) | (i40222222 != 16384) | (i38222 != 2048) | startRestartGroup.changedInstance(offsetMapping222) | startRestartGroup.changedInstance(textFieldSelectionManager222);
                    rememberedValue13 = startRestartGroup.rememberedValue();
                    if (!changedInstance3) {
                    }
                    final boolean z22222222 = z10;
                    final boolean z23222222 = z8;
                    rememberedValue13 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                            m473invokek4lQ0M(offset.getPackedValue());
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                        public final void m473invokek4lQ0M(long j5) {
                            CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester222, !z22222222);
                            if (LegacyTextFieldState.this.getHasFocus() && z23222222) {
                                if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                                    textFieldSelectionManager222.m643deselect_kEHs6E$foundation_release(Offset.m1328boximpl(j5));
                                    return;
                                }
                                TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                if (layoutResult != null) {
                                    LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                    TextFieldDelegate.INSTANCE.m532setCursorOffsetULxng0E$foundation_release(j5, layoutResult, legacyTextFieldState2.getProcessor(), offsetMapping222, legacyTextFieldState2.getOnValueChange());
                                    if (legacyTextFieldState2.getTextDelegate().getText().length() > 0) {
                                        legacyTextFieldState2.setHandleState(HandleState.Cursor);
                                    }
                                }
                            }
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue13);
                    Modifier pointerHoverIcon$default222222 = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(updateSelectionTouchMode222222, mutableInteractionSource722222, z8, (Function1) rememberedValue13), textFieldSelectionManager222.getMouseSelectionObserver(), textFieldSelectionManager222.getTouchSelectionObserver()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                    changedInstance4 = startRestartGroup.changedInstance(legacyTextFieldState) | (i37222 != 4) | startRestartGroup.changedInstance(offsetMapping222);
                    rememberedValue14 = startRestartGroup.rememberedValue();
                    if (!changedInstance4) {
                    }
                    rememberedValue14 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                            invoke2(drawScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DrawScope drawScope) {
                            TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                            if (layoutResult != null) {
                                TextFieldValue textFieldValue2 = textFieldValue;
                                LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                OffsetMapping offsetMapping2222 = offsetMapping222;
                                TextFieldDelegate.INSTANCE.m530drawQ1vqE60$foundation_release(drawScope.getDrawContext().getCanvas(), textFieldValue2, legacyTextFieldState2.m488getSelectionPreviewHighlightRanged9O1mEE(), legacyTextFieldState2.m485getDeletionPreviewHighlightRanged9O1mEE(), offsetMapping2222, layoutResult.getValue(), legacyTextFieldState2.getHighlightPaint(), legacyTextFieldState2.getSelectionBackgroundColor());
                            }
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue14);
                    final Modifier drawBehind222222 = DrawModifierKt.drawBehind(companion2222, (Function1) rememberedValue14);
                    changedInstance5 = startRestartGroup.changedInstance(legacyTextFieldState) | (i38222 != 2048) | startRestartGroup.changed(windowInfo) | startRestartGroup.changedInstance(textFieldSelectionManager222) | (i37222 != 4) | startRestartGroup.changedInstance(offsetMapping222);
                    rememberedValue15 = startRestartGroup.rememberedValue();
                    if (!changedInstance5) {
                    }
                    final boolean z24222222 = z8;
                    rememberedValue15 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                            invoke2(layoutCoordinates);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LayoutCoordinates layoutCoordinates) {
                            LegacyTextFieldState.this.setLayoutCoordinates(layoutCoordinates);
                            TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                            if (layoutResult != null) {
                                layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
                            }
                            if (z24222222) {
                                if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                                    if (LegacyTextFieldState.this.getShowFloatingToolbar() && windowInfo.isWindowFocused()) {
                                        textFieldSelectionManager222.showSelectionToolbar$foundation_release();
                                    } else {
                                        textFieldSelectionManager222.hideSelectionToolbar$foundation_release();
                                    }
                                    LegacyTextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager222, true));
                                    LegacyTextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager222, false));
                                    LegacyTextFieldState.this.setShowCursorHandle(TextRange.m2279getCollapsedimpl(textFieldValue.getSelection()));
                                } else if (LegacyTextFieldState.this.getHandleState() == HandleState.Cursor) {
                                    LegacyTextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager222, true));
                                }
                                CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue, offsetMapping222);
                                TextLayoutResultProxy layoutResult2 = LegacyTextFieldState.this.getLayoutResult();
                                if (layoutResult2 != null) {
                                    LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                    TextFieldValue textFieldValue2 = textFieldValue;
                                    OffsetMapping offsetMapping2222 = offsetMapping222;
                                    TextInputSession inputSession = legacyTextFieldState2.getInputSession();
                                    if (inputSession == null || !legacyTextFieldState2.getHasFocus()) {
                                        return;
                                    }
                                    TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation_release(inputSession, textFieldValue2, offsetMapping2222, layoutResult2);
                                }
                            }
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue15);
                    final Modifier onGloballyPositioned322222 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2222, (Function1) rememberedValue15);
                    final boolean z25222222 = visualTransformation4222 instanceof PasswordVisualTransformation;
                    changedInstance6 = (i38222 != 2048) | startRestartGroup.changedInstance(transformedText222) | (i37222 != 4) | startRestartGroup.changed(z25222222) | (i40222222 != 16384) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(offsetMapping222) | startRestartGroup.changedInstance(textFieldSelectionManager222) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32);
                    rememberedValue16 = startRestartGroup.rememberedValue();
                    if (!changedInstance6) {
                    }
                    final boolean z26222222 = z8;
                    final boolean z27222222 = z10;
                    final ImeOptions imeOptions8222222 = imeOptions5;
                    rememberedValue16 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(final SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, TransformedText.this.getText());
                            SemanticsPropertiesKt.m2185setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, textFieldValue.getSelection());
                            if (!z26222222) {
                                SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                            }
                            if (z25222222) {
                                SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                            }
                            boolean z282 = z26222222 && !z27222222;
                            SemanticsPropertiesKt.setEditable(semanticsPropertyReceiver, z282);
                            final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                            SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(List<TextLayoutResult> list) {
                                    boolean z29222222;
                                    if (LegacyTextFieldState.this.getLayoutResult() != null) {
                                        TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                        Intrinsics.checkNotNull(layoutResult);
                                        list.add(layoutResult.getValue());
                                        z29222222 = true;
                                    } else {
                                        z29222222 = false;
                                    }
                                    return Boolean.valueOf(z29222222);
                                }
                            }, 1, null);
                            if (z282) {
                                final LegacyTextFieldState legacyTextFieldState3 = legacyTextFieldState;
                                SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(AnnotatedString annotatedString) {
                                        Unit unit222222;
                                        TextInputSession inputSession = LegacyTextFieldState.this.getInputSession();
                                        if (inputSession != null) {
                                            LegacyTextFieldState legacyTextFieldState4 = LegacyTextFieldState.this;
                                            TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(annotatedString, 1)}), legacyTextFieldState4.getProcessor(), legacyTextFieldState4.getOnValueChange(), inputSession);
                                            unit222222 = Unit.INSTANCE;
                                        } else {
                                            unit222222 = null;
                                        }
                                        if (unit222222 == null) {
                                            LegacyTextFieldState.this.getOnValueChange().invoke(new TextFieldValue(annotatedString.getText(), TextRangeKt.TextRange(annotatedString.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                        }
                                        return Boolean.TRUE;
                                    }
                                }, 1, null);
                                final boolean z29222222 = z27222222;
                                final boolean z30222222 = z26222222;
                                final LegacyTextFieldState legacyTextFieldState4 = legacyTextFieldState;
                                final TextFieldValue textFieldValue2 = textFieldValue;
                                SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(AnnotatedString annotatedString) {
                                        Unit unit222222;
                                        if (!z29222222 && z30222222) {
                                            TextInputSession inputSession = legacyTextFieldState4.getInputSession();
                                            if (inputSession != null) {
                                                LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                                TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(annotatedString, 1)}), legacyTextFieldState5.getProcessor(), legacyTextFieldState5.getOnValueChange(), inputSession);
                                                unit222222 = Unit.INSTANCE;
                                            } else {
                                                unit222222 = null;
                                            }
                                            if (unit222222 == null) {
                                                TextFieldValue textFieldValue3 = textFieldValue2;
                                                legacyTextFieldState4.getOnValueChange().invoke(new TextFieldValue(StringsKt.replaceRange(textFieldValue3.getText(), TextRange.m2285getStartimpl(textFieldValue3.getSelection()), TextRange.m2280getEndimpl(textFieldValue3.getSelection()), annotatedString).toString(), TextRangeKt.TextRange(TextRange.m2285getStartimpl(textFieldValue3.getSelection()) + annotatedString.length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                            }
                                            return Boolean.TRUE;
                                        }
                                        return Boolean.FALSE;
                                    }
                                }, 1, null);
                            }
                            final OffsetMapping offsetMapping2222 = offsetMapping222;
                            final boolean z31222222 = z26222222;
                            final TextFieldValue textFieldValue3 = textFieldValue;
                            final TextFieldSelectionManager textFieldSelectionManager2222 = textFieldSelectionManager222;
                            final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState;
                            SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                                    return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                                }

                                public final Boolean invoke(int i41222222, int i42, boolean z32) {
                                    if (!z32) {
                                        i41222222 = OffsetMapping.this.transformedToOriginal(i41222222);
                                    }
                                    if (!z32) {
                                        i42 = OffsetMapping.this.transformedToOriginal(i42);
                                    }
                                    boolean z33 = false;
                                    if (z31222222 && (i41222222 != TextRange.m2285getStartimpl(textFieldValue3.getSelection()) || i42 != TextRange.m2280getEndimpl(textFieldValue3.getSelection()))) {
                                        if (Math.min(i41222222, i42) >= 0 && Math.max(i41222222, i42) <= textFieldValue3.getText().length()) {
                                            if (!z32 && i41222222 != i42) {
                                                TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager2222, false, 1, null);
                                            } else {
                                                textFieldSelectionManager2222.exitSelectionMode$foundation_release();
                                            }
                                            legacyTextFieldState5.getOnValueChange().invoke(new TextFieldValue(textFieldValue3.getText(), TextRangeKt.TextRange(i41222222, i42), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                            z33 = true;
                                        } else {
                                            textFieldSelectionManager2222.exitSelectionMode$foundation_release();
                                        }
                                    }
                                    return Boolean.valueOf(z33);
                                }
                            }, 1, null);
                            int imeAction = imeOptions8222222.getImeAction();
                            final LegacyTextFieldState legacyTextFieldState6 = legacyTextFieldState;
                            final ImeOptions imeOptions9222222 = imeOptions8222222;
                            SemanticsPropertiesKt.m2182onImeAction9UiTYpY$default(semanticsPropertyReceiver, imeAction, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    LegacyTextFieldState.this.getOnImeActionPerformed().invoke(ImeAction.m2375boximpl(imeOptions9222222.getImeAction()));
                                    return Boolean.TRUE;
                                }
                            }, 2, null);
                            final LegacyTextFieldState legacyTextFieldState7 = legacyTextFieldState;
                            final FocusRequester focusRequester2222 = focusRequester222;
                            final boolean z32 = z27222222;
                            SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester2222, !z32);
                                    return Boolean.TRUE;
                                }
                            }, 1, null);
                            final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager222;
                            SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.7
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    TextFieldSelectionManager.enterSelectionMode$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                    return Boolean.TRUE;
                                }
                            }, 1, null);
                            if (!TextRange.m2279getCollapsedimpl(textFieldValue.getSelection()) && !z25222222) {
                                final TextFieldSelectionManager textFieldSelectionManager4 = textFieldSelectionManager222;
                                SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.8
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        TextFieldSelectionManager.copy$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                        return Boolean.TRUE;
                                    }
                                }, 1, null);
                                if (z26222222 && !z27222222) {
                                    final TextFieldSelectionManager textFieldSelectionManager5 = textFieldSelectionManager222;
                                    SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.9
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            TextFieldSelectionManager.this.cut$foundation_release();
                                            return Boolean.TRUE;
                                        }
                                    }, 1, null);
                                }
                            }
                            if (!z26222222 || z27222222) {
                                return;
                            }
                            final TextFieldSelectionManager textFieldSelectionManager6 = textFieldSelectionManager222;
                            SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.10
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    TextFieldSelectionManager.this.paste$foundation_release();
                                    return Boolean.TRUE;
                                }
                            }, 1, null);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue16);
                    Modifier semantics222222 = SemanticsModifierKt.semantics(companion2222, true, (Function1) rememberedValue16);
                    final Modifier cursor222222 = TextFieldCursorKt.cursor(companion2222, legacyTextFieldState, textFieldValue, offsetMapping222, brush3, (z8 || z10 || !windowInfo.isWindowFocused() || legacyTextFieldState.hasHighlight()) ? false : true);
                    changedInstance7 = startRestartGroup.changedInstance(textFieldSelectionManager222);
                    rememberedValue17 = startRestartGroup.rememberedValue();
                    if (!changedInstance7) {
                    }
                    rememberedValue17 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            final TextFieldSelectionManager textFieldSelectionManager2222 = TextFieldSelectionManager.this;
                            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                                }
                            };
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue17);
                    EffectsKt.DisposableEffect(textFieldSelectionManager222, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue17, startRestartGroup, 0);
                    changedInstance8 = (i37222 != 4) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService222) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32);
                    rememberedValue18 = startRestartGroup.rememberedValue();
                    if (!changedInstance8) {
                    }
                    rememberedValue18 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                            if (LegacyTextFieldState.this.getHasFocus()) {
                                LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                legacyTextFieldState2.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(textInputService222, textFieldValue, legacyTextFieldState2.getProcessor(), imeOptions5, LegacyTextFieldState.this.getOnValueChange(), LegacyTextFieldState.this.getOnImeActionPerformed()));
                            }
                            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                }
                            };
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue18);
                    EffectsKt.DisposableEffect(imeOptions5, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue18, startRestartGroup, (i29 >> 3) & 14);
                    Modifier m539textFieldKeyInput2WJ9YEU222222 = TextFieldKeyInputKt.m539textFieldKeyInput2WJ9YEU(companion2222, legacyTextFieldState, textFieldSelectionManager222, textFieldValue, legacyTextFieldState.getOnValueChange(), !z10, i36222 != 1, offsetMapping222, undoManager222, imeOptions5.getImeAction());
                    boolean CoreTextField$lambda$11222222 = CoreTextField$lambda$11(rememberUpdatedState22222);
                    changedInstance9 = startRestartGroup.changedInstance(legacyTextFieldState) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32) | startRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter222);
                    rememberedValue19 = startRestartGroup.rememberedValue();
                    if (!changedInstance9) {
                    }
                    rememberedValue19 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$stylusHandwritingModifier$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            if (!LegacyTextFieldState.this.getHasFocus()) {
                                focusRequester222.requestFocus();
                            }
                            int keyboardType = imeOptions5.getKeyboardType();
                            KeyboardType.Companion companion3 = KeyboardType.INSTANCE;
                            if (!KeyboardType.m2410equalsimpl0(keyboardType, companion3.m2419getPasswordPjHm6EE()) && !KeyboardType.m2410equalsimpl0(imeOptions5.getKeyboardType(), companion3.m2418getNumberPasswordPjHm6EE())) {
                                legacyPlatformTextInputServiceAdapter222.startStylusHandwriting();
                            }
                            return Boolean.TRUE;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue19);
                    Modifier onGloballyPositioned2222222 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier7222, legacyPlatformTextInputServiceAdapter222, legacyTextFieldState, textFieldSelectionManager222).then(StylusHandwritingKt.stylusHandwriting(companion2222, CoreTextField$lambda$11222222, (Function0) rememberedValue19)).then(modifier4), legacyTextFieldState, focusManager222), legacyTextFieldState, textFieldSelectionManager222).then(m539textFieldKeyInput2WJ9YEU222222), textFieldScrollerPosition222, mutableInteractionSource722222, z8).then(pointerHoverIcon$default222222).then(semantics222222), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                            invoke2(layoutCoordinates);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LayoutCoordinates layoutCoordinates) {
                            TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                            if (layoutResult == null) {
                                return;
                            }
                            layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                        }
                    });
                    if (z8) {
                    }
                    final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function34222222 = function32;
                    final TextStyle textStyle5222222 = textStyle2;
                    final int i41222222 = i25;
                    boolean z29222222 = z8;
                    ImeOptions imeOptions9222222 = imeOptions5;
                    final Modifier textFieldMagnifier222222 = !z28 ? TextFieldSelectionManager_androidKt.textFieldMagnifier(companion2222, textFieldSelectionManager222) : companion2222;
                    final boolean z30222222 = z28;
                    final boolean z31222222 = z10;
                    final Function1<? super TextLayoutResult, Unit> function16222222 = function13;
                    composer2 = startRestartGroup;
                    CoreTextFieldRootBox(onGloballyPositioned2222222, textFieldSelectionManager222, ComposableLambdaKt.rememberComposableLambda(-374338080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i42) {
                            if ((i42 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-374338080, i42, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:695)");
                            }
                            Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function35 = function34222222;
                            final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                            final TextStyle textStyle6 = textStyle5222222;
                            final int i43 = i41222222;
                            final int i44 = i36222;
                            final TextFieldScrollerPosition textFieldScrollerPosition2222 = textFieldScrollerPosition222;
                            final TextFieldValue textFieldValue2 = textFieldValue;
                            final VisualTransformation visualTransformation5 = visualTransformation4222;
                            final Modifier modifier8 = cursor222222;
                            final Modifier modifier9 = drawBehind222222;
                            final Modifier modifier10 = onGloballyPositioned322222;
                            final Modifier modifier11 = textFieldMagnifier222222;
                            final BringIntoViewRequester bringIntoViewRequester2222 = bringIntoViewRequester222;
                            final TextFieldSelectionManager textFieldSelectionManager2222 = textFieldSelectionManager222;
                            final boolean z32 = z30222222;
                            final boolean z33 = z31222222;
                            final Function1<? super TextLayoutResult, Unit> function17 = function16222222;
                            final OffsetMapping offsetMapping2222 = offsetMapping222;
                            final Density density2222 = density222;
                            function35.invoke(ComposableLambdaKt.rememberComposableLambda(2032502107, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i45) {
                                    if ((i45 & 3) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2032502107, i45, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:698)");
                                    }
                                    Modifier heightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m327heightInVpY3zN4$default(Modifier.INSTANCE, LegacyTextFieldState.this.m486getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle6, i43, i44);
                                    TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition2222;
                                    TextFieldValue textFieldValue3 = textFieldValue2;
                                    VisualTransformation visualTransformation6 = visualTransformation5;
                                    boolean changedInstance11 = composer4.changedInstance(LegacyTextFieldState.this);
                                    final LegacyTextFieldState legacyTextFieldState3 = LegacyTextFieldState.this;
                                    Object rememberedValue21 = composer4.rememberedValue();
                                    if (changedInstance11 || rememberedValue21 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue21 = new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            {
                                                super(0);
                                            }

                                            /* JADX WARN: Can't rename method to resolve collision */
                                            @Override // kotlin.jvm.functions.Function0
                                            public final TextLayoutResultProxy invoke() {
                                                return LegacyTextFieldState.this.getLayoutResult();
                                            }
                                        };
                                        composer4.updateRememberedValue(rememberedValue21);
                                    }
                                    Modifier bringIntoViewRequester3 = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(heightInLines, textFieldScrollerPosition3, textFieldValue3, visualTransformation6, (Function0) rememberedValue21).then(modifier8).then(modifier9), textStyle6).then(modifier10).then(modifier11), bringIntoViewRequester2222);
                                    final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager2222;
                                    final LegacyTextFieldState legacyTextFieldState4 = LegacyTextFieldState.this;
                                    final boolean z34 = z32;
                                    final boolean z35 = z33;
                                    final Function1<? super TextLayoutResult, Unit> function18 = function17;
                                    final TextFieldValue textFieldValue4 = textFieldValue2;
                                    final OffsetMapping offsetMapping3 = offsetMapping2222;
                                    final Density density3 = density2222;
                                    final int i46 = i44;
                                    SimpleLayoutKt.SimpleLayout(bringIntoViewRequester3, ComposableLambdaKt.rememberComposableLambda(-363167407, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                            invoke(composer5, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX WARN: Removed duplicated region for block: B:39:0x00ff  */
                                        /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
                                        /*
                                            Code decompiled incorrectly, please refer to instructions dump.
                                        */
                                        public final void invoke(Composer composer5, int i47) {
                                            boolean z36;
                                            if ((i47 & 3) == 2 && composer5.getSkipping()) {
                                                composer5.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-363167407, i47, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:721)");
                                            }
                                            final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                            final Function1<? super TextLayoutResult, Unit> function19 = function18;
                                            final TextFieldValue textFieldValue5 = textFieldValue4;
                                            final OffsetMapping offsetMapping4 = offsetMapping3;
                                            final Density density4 = density3;
                                            final int i48 = i46;
                                            MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                                @Override // androidx.compose.ui.layout.MeasurePolicy
                                                public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i49) {
                                                    LegacyTextFieldState.this.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                                    return LegacyTextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                                }

                                                @Override // androidx.compose.ui.layout.MeasurePolicy
                                                /* renamed from: measure-3p2s80s */
                                                public MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                                                    Snapshot.Companion companion3 = Snapshot.INSTANCE;
                                                    LegacyTextFieldState legacyTextFieldState6 = LegacyTextFieldState.this;
                                                    Snapshot currentThreadSnapshot = companion3.getCurrentThreadSnapshot();
                                                    Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                                    Snapshot makeCurrentNonObservable = companion3.makeCurrentNonObservable(currentThreadSnapshot);
                                                    try {
                                                        TextLayoutResultProxy layoutResult = legacyTextFieldState6.getLayoutResult();
                                                        TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                                        Triple<Integer, Integer, TextLayoutResult> m531layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m531layout_EkL_Y$foundation_release(LegacyTextFieldState.this.getTextDelegate(), j5, measureScope.getLayoutDirection(), value);
                                                        int intValue = m531layout_EkL_Y$foundation_release.component1().intValue();
                                                        int intValue2 = m531layout_EkL_Y$foundation_release.component2().intValue();
                                                        TextLayoutResult component3 = m531layout_EkL_Y$foundation_release.component3();
                                                        if (!Intrinsics.areEqual(value, component3)) {
                                                            LegacyTextFieldState.this.setLayoutResult(new TextLayoutResultProxy(component3, null, layoutResult != null ? layoutResult.getDecorationBoxCoordinates() : null, 2, null));
                                                            function19.invoke(component3);
                                                            CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue5, offsetMapping4);
                                                        }
                                                        LegacyTextFieldState.this.m490setMinHeightForSingleLineField0680j_4(density4.mo209toDpu2uoSUM(i48 == 1 ? TextDelegateKt.ceilToIntPx(component3.getLineBottom(0)) : 0));
                                                        return measureScope.layout(intValue, intValue2, MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(component3.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(component3.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                            public final void invoke2(Placeable.PlacementScope placementScope) {
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                                invoke2(placementScope);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                    } finally {
                                                        companion3.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                                    }
                                                }
                                            };
                                            Modifier.Companion companion3 = Modifier.INSTANCE;
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, companion3);
                                            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                            Function0<ComposeUiNode> constructor = companion4.getConstructor();
                                            if (composer5.getApplier() == null) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer5.startReusableNode();
                                            if (composer5.getInserting()) {
                                                composer5.createNode(constructor);
                                            } else {
                                                composer5.useNode();
                                            }
                                            Composer m1226constructorimpl = Updater.m1226constructorimpl(composer5);
                                            Updater.m1227setimpl(m1226constructorimpl, measurePolicy, companion4.getSetMeasurePolicy());
                                            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                                            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
                                            composer5.endNode();
                                            TextFieldSelectionManager textFieldSelectionManager4 = TextFieldSelectionManager.this;
                                            if (legacyTextFieldState4.getHandleState() != HandleState.None && legacyTextFieldState4.getLayoutCoordinates() != null) {
                                                LayoutCoordinates layoutCoordinates = legacyTextFieldState4.getLayoutCoordinates();
                                                Intrinsics.checkNotNull(layoutCoordinates);
                                                if (layoutCoordinates.isAttached() && z34) {
                                                    z36 = true;
                                                    CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z36, composer5, 0);
                                                    if (legacyTextFieldState4.getHandleState() != HandleState.Cursor && !z35 && z34) {
                                                        composer5.startReplaceGroup(-2032274);
                                                        CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer5, 0);
                                                        composer5.endReplaceGroup();
                                                    } else {
                                                        composer5.startReplaceGroup(-1955394);
                                                        composer5.endReplaceGroup();
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        return;
                                                    }
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                            }
                                            z36 = false;
                                            CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z36, composer5, 0);
                                            if (legacyTextFieldState4.getHandleState() != HandleState.Cursor) {
                                            }
                                            composer5.startReplaceGroup(-1955394);
                                            composer5.endReplaceGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                        }
                                    }, composer4, 54), composer4, 48, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer3, 54), composer3, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, 384);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    textStyle3 = textStyle2;
                    function14 = function13;
                    visualTransformation3 = visualTransformation4222;
                    modifier5 = modifier7222;
                    brush4 = brush3;
                    z15 = z9;
                    i30 = i25;
                    z16 = z29222222;
                    keyboardActions3 = keyboardActions2;
                    imeOptions6 = imeOptions9222222;
                    i31 = i36222;
                    mutableInteractionSource4 = mutableInteractionSource722222;
                    z17 = z10;
                    function33 = function32;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i13 = i9 & 32;
                if (i13 == 0) {
                }
                i14 = i9 & 64;
                if (i14 == 0) {
                }
                i15 = i9 & 128;
                if (i15 == 0) {
                }
                i16 = i9 & 256;
                if (i16 == 0) {
                }
                i17 = i9 & 512;
                if (i17 == 0) {
                }
                i18 = i9 & 1024;
                if (i18 == 0) {
                }
                if ((i8 & 48) == 0) {
                }
                i20 = i19;
                i21 = i9 & 4096;
                if (i21 == 0) {
                }
                i22 = i9 & 8192;
                if (i22 != 0) {
                }
                i23 = i9 & 16384;
                if (i23 == 0) {
                }
                i24 = i9 & 32768;
                if (i24 != 0) {
                }
                if ((i10 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i7 & 1) != 0) {
                }
                if (i33 != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i13 != 0) {
                }
                if (i14 != 0) {
                }
                if (i15 != 0) {
                }
                if (i16 != 0) {
                }
                if (i17 != 0) {
                }
                if (i18 != 0) {
                }
                if ((i9 & 2048) != 0) {
                }
                if (i21 != 0) {
                }
                if (i22 != 0) {
                }
                if (i23 != 0) {
                }
                if (i24 != 0) {
                }
                visualTransformation2 = none;
                function13 = function15;
                i26 = i34;
                imeOptions3 = imeOptions2;
                MutableInteractionSource mutableInteractionSource62222 = mutableInteractionSource5;
                textStyle2 = textStyle4;
                mutableInteractionSource2 = mutableInteractionSource62222;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                rememberedValue = startRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                }
                final FocusRequester focusRequester2222 = (FocusRequester) rememberedValue;
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion.getEmpty()) {
                }
                final LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter2222 = (LegacyPlatformTextInputServiceAdapter) rememberedValue2;
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == companion.getEmpty()) {
                }
                final TextInputService textInputService2222 = (TextInputService) rememberedValue3;
                final Density density2222 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                FontFamily.Resolver resolver2222 = (FontFamily.Resolver) startRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                long selectionBackgroundColor2222 = ((SelectionColors) startRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).getSelectionBackgroundColor();
                FocusManager focusManager2222 = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
                Modifier modifier72222 = modifier3;
                windowInfo = (WindowInfo) startRestartGroup.consume(CompositionLocalsKt.getLocalWindowInfo());
                SoftwareKeyboardController softwareKeyboardController2222 = (SoftwareKeyboardController) startRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
                if (i26 == 1) {
                }
                Object[] objArr2222 = {orientation};
                Saver<TextFieldScrollerPosition, Object> saver2222 = TextFieldScrollerPosition.INSTANCE.getSaver();
                changed = startRestartGroup.changed(orientation);
                final int i362222 = i26;
                Object rememberedValue202222 = startRestartGroup.rememberedValue();
                if (changed) {
                }
                rememberedValue202222 = new Function0<TextFieldScrollerPosition>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final TextFieldScrollerPosition invoke() {
                        return new TextFieldScrollerPosition(Orientation.this, 0.0f, 2, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue202222);
                final TextFieldScrollerPosition textFieldScrollerPosition2222 = (TextFieldScrollerPosition) RememberSaveableKt.rememberSaveable(objArr2222, saver2222, null, (Function0) rememberedValue202222, startRestartGroup, 0, 4);
                int i372222 = i10 & 14;
                if (i372222 == 4) {
                }
                z11 = ((i10 & 57344) == 16384) | (i372222 == 4);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (z11) {
                }
                TransformedText filterWithValidation2222 = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation2, textFieldValue.getText());
                composition = textFieldValue.getComposition();
                if (composition != null) {
                }
                rememberedValue4 = filterWithValidation2222;
                startRestartGroup.updateRememberedValue(rememberedValue4);
                final TransformedText transformedText2222 = (TransformedText) rememberedValue4;
                AnnotatedString text2222 = transformedText2222.getText();
                final OffsetMapping offsetMapping2222 = transformedText2222.getOffsetMapping();
                RecomposeScope currentRecomposeScope2222 = ComposablesKt.getCurrentRecomposeScope(startRestartGroup, 0);
                changed2 = startRestartGroup.changed(softwareKeyboardController2222);
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (!changed2) {
                }
                rememberedValue5 = new LegacyTextFieldState(new TextDelegate(text2222, textStyle2, 0, 0, z9, 0, density2222, resolver2222, null, 300, null), currentRecomposeScope2222, softwareKeyboardController2222);
                startRestartGroup.updateRememberedValue(rememberedValue5);
                legacyTextFieldState = (LegacyTextFieldState) rememberedValue5;
                legacyTextFieldState.m492updatefnh65Uc(textFieldValue.getText(), text2222, textStyle2, z9, density2222, resolver2222, function1, keyboardActions2, focusManager2222, selectionBackgroundColor2222);
                legacyTextFieldState.getProcessor().reset(textFieldValue, legacyTextFieldState.getInputSession());
                rememberedValue6 = startRestartGroup.rememberedValue();
                if (rememberedValue6 == companion.getEmpty()) {
                }
                UndoManager undoManager2222 = (UndoManager) rememberedValue6;
                UndoManager.snapshotIfNeeded$default(undoManager2222, textFieldValue, 0L, 2, null);
                rememberedValue7 = startRestartGroup.rememberedValue();
                if (rememberedValue7 == companion.getEmpty()) {
                }
                final TextFieldSelectionManager textFieldSelectionManager2222 = (TextFieldSelectionManager) rememberedValue7;
                textFieldSelectionManager2222.setOffsetMapping$foundation_release(offsetMapping2222);
                textFieldSelectionManager2222.setVisualTransformation$foundation_release(visualTransformation2);
                textFieldSelectionManager2222.setOnValueChange$foundation_release(legacyTextFieldState.getOnValueChange());
                textFieldSelectionManager2222.setState$foundation_release(legacyTextFieldState);
                textFieldSelectionManager2222.setValue$foundation_release(textFieldValue);
                textFieldSelectionManager2222.setClipboardManager$foundation_release((ClipboardManager) startRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
                textFieldSelectionManager2222.setTextToolbar((TextToolbar) startRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
                textFieldSelectionManager2222.setHapticFeedBack((HapticFeedback) startRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
                textFieldSelectionManager2222.setFocusRequester(focusRequester2222);
                textFieldSelectionManager2222.setEditable(!z10);
                textFieldSelectionManager2222.setEnabled(z8);
                rememberedValue8 = startRestartGroup.rememberedValue();
                if (rememberedValue8 == companion.getEmpty()) {
                }
                final CoroutineScope coroutineScope2222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue8).getCoroutineScope();
                rememberedValue9 = startRestartGroup.rememberedValue();
                if (rememberedValue9 == companion.getEmpty()) {
                }
                final BringIntoViewRequester bringIntoViewRequester2222 = (BringIntoViewRequester) rememberedValue9;
                Modifier.Companion companion22222 = Modifier.INSTANCE;
                int i382222 = i20 & 7168;
                final VisualTransformation visualTransformation42222 = visualTransformation2;
                int i392222 = i20 & 57344;
                boolean changedInstance102222 = startRestartGroup.changedInstance(legacyTextFieldState) | (i382222 == 2048) | (i392222 == 16384) | startRestartGroup.changedInstance(textInputService2222) | (i372222 == 4);
                i27 = (i20 & 112) ^ 48;
                if (i27 > 32) {
                }
                i28 = i392222;
                i29 = i20;
                if ((i20 & 48) != 32) {
                }
                z12 = true;
                changedInstance = changedInstance102222 | z12 | startRestartGroup.changedInstance(offsetMapping2222) | startRestartGroup.changedInstance(coroutineScope2222) | startRestartGroup.changedInstance(bringIntoViewRequester2222) | startRestartGroup.changedInstance(textFieldSelectionManager2222);
                rememberedValue10 = startRestartGroup.rememberedValue();
                if (!changedInstance) {
                }
                final boolean z20222222 = z8;
                final boolean z21222222 = z10;
                final ImeOptions imeOptions7222222 = imeOptions5;
                rememberedValue10 = new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                        invoke2(focusState);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(FocusState focusState) {
                        TextLayoutResultProxy layoutResult;
                        if (LegacyTextFieldState.this.getHasFocus() == focusState.isFocused()) {
                            return;
                        }
                        LegacyTextFieldState.this.setHasFocus(focusState.isFocused());
                        if (LegacyTextFieldState.this.getHasFocus() && z20222222 && !z21222222) {
                            CoreTextFieldKt.startInputSession(textInputService2222, LegacyTextFieldState.this, textFieldValue, imeOptions7222222, offsetMapping2222);
                        } else {
                            CoreTextFieldKt.endInputSession(LegacyTextFieldState.this);
                        }
                        if (focusState.isFocused() && (layoutResult = LegacyTextFieldState.this.getLayoutResult()) != null) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope2222, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(bringIntoViewRequester2222, textFieldValue, LegacyTextFieldState.this, layoutResult, offsetMapping2222, null), 3, null);
                        }
                        if (focusState.isFocused()) {
                            return;
                        }
                        TextFieldSelectionManager.m640deselect_kEHs6E$foundation_release$default(textFieldSelectionManager2222, null, 1, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue10);
                MutableInteractionSource mutableInteractionSource7222222 = mutableInteractionSource3;
                textFieldFocusModifier = TextFieldGestureModifiersKt.textFieldFocusModifier(companion22222, z8, focusRequester2222, mutableInteractionSource7222222, (Function1) rememberedValue10);
                State rememberUpdatedState222222 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf((z8 || z10) ? false : true), startRestartGroup, 0);
                Unit unit222222 = Unit.INSTANCE;
                boolean changed3222222 = startRestartGroup.changed(rememberUpdatedState222222) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService2222) | startRestartGroup.changedInstance(textFieldSelectionManager2222);
                if (i27 > 32) {
                }
                modifier4 = textFieldFocusModifier;
                if ((i29 & 48) != 32) {
                }
                z13 = true;
                z14 = changed3222222 | z13;
                rememberedValue11 = startRestartGroup.rememberedValue();
                if (!z14) {
                }
                rememberedValue11 = new CoreTextFieldKt$CoreTextField$2$1(legacyTextFieldState, rememberUpdatedState222222, textInputService2222, textFieldSelectionManager2222, imeOptions5, null);
                startRestartGroup.updateRememberedValue(rememberedValue11);
                EffectsKt.LaunchedEffect(unit222222, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue11, startRestartGroup, 6);
                changedInstance2 = startRestartGroup.changedInstance(legacyTextFieldState);
                rememberedValue12 = startRestartGroup.rememberedValue();
                if (!changedInstance2) {
                }
                rememberedValue12 = new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z222222222) {
                        LegacyTextFieldState.this.setInTouchMode(z222222222);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue12);
                Modifier updateSelectionTouchMode2222222 = SelectionGesturesKt.updateSelectionTouchMode(companion22222, (Function1) rememberedValue12);
                int i402222222 = i28;
                changedInstance3 = startRestartGroup.changedInstance(legacyTextFieldState) | (i402222222 != 16384) | (i382222 != 2048) | startRestartGroup.changedInstance(offsetMapping2222) | startRestartGroup.changedInstance(textFieldSelectionManager2222);
                rememberedValue13 = startRestartGroup.rememberedValue();
                if (!changedInstance3) {
                }
                final boolean z222222222 = z10;
                final boolean z232222222 = z8;
                rememberedValue13 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                        m473invokek4lQ0M(offset.getPackedValue());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                    public final void m473invokek4lQ0M(long j5) {
                        CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester2222, !z222222222);
                        if (LegacyTextFieldState.this.getHasFocus() && z232222222) {
                            if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                                textFieldSelectionManager2222.m643deselect_kEHs6E$foundation_release(Offset.m1328boximpl(j5));
                                return;
                            }
                            TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                            if (layoutResult != null) {
                                LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                TextFieldDelegate.INSTANCE.m532setCursorOffsetULxng0E$foundation_release(j5, layoutResult, legacyTextFieldState2.getProcessor(), offsetMapping2222, legacyTextFieldState2.getOnValueChange());
                                if (legacyTextFieldState2.getTextDelegate().getText().length() > 0) {
                                    legacyTextFieldState2.setHandleState(HandleState.Cursor);
                                }
                            }
                        }
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue13);
                Modifier pointerHoverIcon$default2222222 = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(updateSelectionTouchMode2222222, mutableInteractionSource7222222, z8, (Function1) rememberedValue13), textFieldSelectionManager2222.getMouseSelectionObserver(), textFieldSelectionManager2222.getTouchSelectionObserver()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
                changedInstance4 = startRestartGroup.changedInstance(legacyTextFieldState) | (i372222 != 4) | startRestartGroup.changedInstance(offsetMapping2222);
                rememberedValue14 = startRestartGroup.rememberedValue();
                if (!changedInstance4) {
                }
                rememberedValue14 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope drawScope) {
                        TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                        if (layoutResult != null) {
                            TextFieldValue textFieldValue2 = textFieldValue;
                            LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                            OffsetMapping offsetMapping22222 = offsetMapping2222;
                            TextFieldDelegate.INSTANCE.m530drawQ1vqE60$foundation_release(drawScope.getDrawContext().getCanvas(), textFieldValue2, legacyTextFieldState2.m488getSelectionPreviewHighlightRanged9O1mEE(), legacyTextFieldState2.m485getDeletionPreviewHighlightRanged9O1mEE(), offsetMapping22222, layoutResult.getValue(), legacyTextFieldState2.getHighlightPaint(), legacyTextFieldState2.getSelectionBackgroundColor());
                        }
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue14);
                final Modifier drawBehind2222222 = DrawModifierKt.drawBehind(companion22222, (Function1) rememberedValue14);
                changedInstance5 = startRestartGroup.changedInstance(legacyTextFieldState) | (i382222 != 2048) | startRestartGroup.changed(windowInfo) | startRestartGroup.changedInstance(textFieldSelectionManager2222) | (i372222 != 4) | startRestartGroup.changedInstance(offsetMapping2222);
                rememberedValue15 = startRestartGroup.rememberedValue();
                if (!changedInstance5) {
                }
                final boolean z242222222 = z8;
                rememberedValue15 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                        invoke2(layoutCoordinates);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutCoordinates layoutCoordinates) {
                        LegacyTextFieldState.this.setLayoutCoordinates(layoutCoordinates);
                        TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                        if (layoutResult != null) {
                            layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
                        }
                        if (z242222222) {
                            if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                                if (LegacyTextFieldState.this.getShowFloatingToolbar() && windowInfo.isWindowFocused()) {
                                    textFieldSelectionManager2222.showSelectionToolbar$foundation_release();
                                } else {
                                    textFieldSelectionManager2222.hideSelectionToolbar$foundation_release();
                                }
                                LegacyTextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager2222, true));
                                LegacyTextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager2222, false));
                                LegacyTextFieldState.this.setShowCursorHandle(TextRange.m2279getCollapsedimpl(textFieldValue.getSelection()));
                            } else if (LegacyTextFieldState.this.getHandleState() == HandleState.Cursor) {
                                LegacyTextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager2222, true));
                            }
                            CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue, offsetMapping2222);
                            TextLayoutResultProxy layoutResult2 = LegacyTextFieldState.this.getLayoutResult();
                            if (layoutResult2 != null) {
                                LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                                TextFieldValue textFieldValue2 = textFieldValue;
                                OffsetMapping offsetMapping22222 = offsetMapping2222;
                                TextInputSession inputSession = legacyTextFieldState2.getInputSession();
                                if (inputSession == null || !legacyTextFieldState2.getHasFocus()) {
                                    return;
                                }
                                TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation_release(inputSession, textFieldValue2, offsetMapping22222, layoutResult2);
                            }
                        }
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue15);
                final Modifier onGloballyPositioned3222222 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion22222, (Function1) rememberedValue15);
                final boolean z252222222 = visualTransformation42222 instanceof PasswordVisualTransformation;
                changedInstance6 = (i382222 != 2048) | startRestartGroup.changedInstance(transformedText2222) | (i372222 != 4) | startRestartGroup.changed(z252222222) | (i402222222 != 16384) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(offsetMapping2222) | startRestartGroup.changedInstance(textFieldSelectionManager2222) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32);
                rememberedValue16 = startRestartGroup.rememberedValue();
                if (!changedInstance6) {
                }
                final boolean z262222222 = z8;
                final boolean z272222222 = z10;
                final ImeOptions imeOptions82222222 = imeOptions5;
                rememberedValue16 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(final SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, TransformedText.this.getText());
                        SemanticsPropertiesKt.m2185setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, textFieldValue.getSelection());
                        if (!z262222222) {
                            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                        }
                        if (z252222222) {
                            SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                        }
                        boolean z282 = z262222222 && !z272222222;
                        SemanticsPropertiesKt.setEditable(semanticsPropertyReceiver, z282);
                        final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                        SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(List<TextLayoutResult> list) {
                                boolean z292222222;
                                if (LegacyTextFieldState.this.getLayoutResult() != null) {
                                    TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                    Intrinsics.checkNotNull(layoutResult);
                                    list.add(layoutResult.getValue());
                                    z292222222 = true;
                                } else {
                                    z292222222 = false;
                                }
                                return Boolean.valueOf(z292222222);
                            }
                        }, 1, null);
                        if (z282) {
                            final LegacyTextFieldState legacyTextFieldState3 = legacyTextFieldState;
                            SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(AnnotatedString annotatedString) {
                                    Unit unit2222222;
                                    TextInputSession inputSession = LegacyTextFieldState.this.getInputSession();
                                    if (inputSession != null) {
                                        LegacyTextFieldState legacyTextFieldState4 = LegacyTextFieldState.this;
                                        TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(annotatedString, 1)}), legacyTextFieldState4.getProcessor(), legacyTextFieldState4.getOnValueChange(), inputSession);
                                        unit2222222 = Unit.INSTANCE;
                                    } else {
                                        unit2222222 = null;
                                    }
                                    if (unit2222222 == null) {
                                        LegacyTextFieldState.this.getOnValueChange().invoke(new TextFieldValue(annotatedString.getText(), TextRangeKt.TextRange(annotatedString.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                    }
                                    return Boolean.TRUE;
                                }
                            }, 1, null);
                            final boolean z292222222 = z272222222;
                            final boolean z302222222 = z262222222;
                            final LegacyTextFieldState legacyTextFieldState4 = legacyTextFieldState;
                            final TextFieldValue textFieldValue2 = textFieldValue;
                            SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(AnnotatedString annotatedString) {
                                    Unit unit2222222;
                                    if (!z292222222 && z302222222) {
                                        TextInputSession inputSession = legacyTextFieldState4.getInputSession();
                                        if (inputSession != null) {
                                            LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                            TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(annotatedString, 1)}), legacyTextFieldState5.getProcessor(), legacyTextFieldState5.getOnValueChange(), inputSession);
                                            unit2222222 = Unit.INSTANCE;
                                        } else {
                                            unit2222222 = null;
                                        }
                                        if (unit2222222 == null) {
                                            TextFieldValue textFieldValue3 = textFieldValue2;
                                            legacyTextFieldState4.getOnValueChange().invoke(new TextFieldValue(StringsKt.replaceRange(textFieldValue3.getText(), TextRange.m2285getStartimpl(textFieldValue3.getSelection()), TextRange.m2280getEndimpl(textFieldValue3.getSelection()), annotatedString).toString(), TextRangeKt.TextRange(TextRange.m2285getStartimpl(textFieldValue3.getSelection()) + annotatedString.length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                        }
                                        return Boolean.TRUE;
                                    }
                                    return Boolean.FALSE;
                                }
                            }, 1, null);
                        }
                        final OffsetMapping offsetMapping22222 = offsetMapping2222;
                        final boolean z312222222 = z262222222;
                        final TextFieldValue textFieldValue3 = textFieldValue;
                        final TextFieldSelectionManager textFieldSelectionManager22222 = textFieldSelectionManager2222;
                        final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState;
                        SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                                return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                            }

                            public final Boolean invoke(int i412222222, int i42, boolean z32) {
                                if (!z32) {
                                    i412222222 = OffsetMapping.this.transformedToOriginal(i412222222);
                                }
                                if (!z32) {
                                    i42 = OffsetMapping.this.transformedToOriginal(i42);
                                }
                                boolean z33 = false;
                                if (z312222222 && (i412222222 != TextRange.m2285getStartimpl(textFieldValue3.getSelection()) || i42 != TextRange.m2280getEndimpl(textFieldValue3.getSelection()))) {
                                    if (Math.min(i412222222, i42) >= 0 && Math.max(i412222222, i42) <= textFieldValue3.getText().length()) {
                                        if (!z32 && i412222222 != i42) {
                                            TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager22222, false, 1, null);
                                        } else {
                                            textFieldSelectionManager22222.exitSelectionMode$foundation_release();
                                        }
                                        legacyTextFieldState5.getOnValueChange().invoke(new TextFieldValue(textFieldValue3.getText(), TextRangeKt.TextRange(i412222222, i42), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                        z33 = true;
                                    } else {
                                        textFieldSelectionManager22222.exitSelectionMode$foundation_release();
                                    }
                                }
                                return Boolean.valueOf(z33);
                            }
                        }, 1, null);
                        int imeAction = imeOptions82222222.getImeAction();
                        final LegacyTextFieldState legacyTextFieldState6 = legacyTextFieldState;
                        final ImeOptions imeOptions92222222 = imeOptions82222222;
                        SemanticsPropertiesKt.m2182onImeAction9UiTYpY$default(semanticsPropertyReceiver, imeAction, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                LegacyTextFieldState.this.getOnImeActionPerformed().invoke(ImeAction.m2375boximpl(imeOptions92222222.getImeAction()));
                                return Boolean.TRUE;
                            }
                        }, 2, null);
                        final LegacyTextFieldState legacyTextFieldState7 = legacyTextFieldState;
                        final FocusRequester focusRequester22222 = focusRequester2222;
                        final boolean z32 = z272222222;
                        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester22222, !z32);
                                return Boolean.TRUE;
                            }
                        }, 1, null);
                        final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager2222;
                        SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.7
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                TextFieldSelectionManager.enterSelectionMode$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                return Boolean.TRUE;
                            }
                        }, 1, null);
                        if (!TextRange.m2279getCollapsedimpl(textFieldValue.getSelection()) && !z252222222) {
                            final TextFieldSelectionManager textFieldSelectionManager4 = textFieldSelectionManager2222;
                            SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.8
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    TextFieldSelectionManager.copy$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                    return Boolean.TRUE;
                                }
                            }, 1, null);
                            if (z262222222 && !z272222222) {
                                final TextFieldSelectionManager textFieldSelectionManager5 = textFieldSelectionManager2222;
                                SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.9
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        TextFieldSelectionManager.this.cut$foundation_release();
                                        return Boolean.TRUE;
                                    }
                                }, 1, null);
                            }
                        }
                        if (!z262222222 || z272222222) {
                            return;
                        }
                        final TextFieldSelectionManager textFieldSelectionManager6 = textFieldSelectionManager2222;
                        SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.10
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                TextFieldSelectionManager.this.paste$foundation_release();
                                return Boolean.TRUE;
                            }
                        }, 1, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue16);
                Modifier semantics2222222 = SemanticsModifierKt.semantics(companion22222, true, (Function1) rememberedValue16);
                final Modifier cursor2222222 = TextFieldCursorKt.cursor(companion22222, legacyTextFieldState, textFieldValue, offsetMapping2222, brush3, (z8 || z10 || !windowInfo.isWindowFocused() || legacyTextFieldState.hasHighlight()) ? false : true);
                changedInstance7 = startRestartGroup.changedInstance(textFieldSelectionManager2222);
                rememberedValue17 = startRestartGroup.rememberedValue();
                if (!changedInstance7) {
                }
                rememberedValue17 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        final TextFieldSelectionManager textFieldSelectionManager22222 = TextFieldSelectionManager.this;
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                            }
                        };
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue17);
                EffectsKt.DisposableEffect(textFieldSelectionManager2222, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue17, startRestartGroup, 0);
                changedInstance8 = (i372222 != 4) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService2222) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32);
                rememberedValue18 = startRestartGroup.rememberedValue();
                if (!changedInstance8) {
                }
                rememberedValue18 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        if (LegacyTextFieldState.this.getHasFocus()) {
                            LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                            legacyTextFieldState2.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(textInputService2222, textFieldValue, legacyTextFieldState2.getProcessor(), imeOptions5, LegacyTextFieldState.this.getOnValueChange(), LegacyTextFieldState.this.getOnImeActionPerformed()));
                        }
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                            }
                        };
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue18);
                EffectsKt.DisposableEffect(imeOptions5, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue18, startRestartGroup, (i29 >> 3) & 14);
                Modifier m539textFieldKeyInput2WJ9YEU2222222 = TextFieldKeyInputKt.m539textFieldKeyInput2WJ9YEU(companion22222, legacyTextFieldState, textFieldSelectionManager2222, textFieldValue, legacyTextFieldState.getOnValueChange(), !z10, i362222 != 1, offsetMapping2222, undoManager2222, imeOptions5.getImeAction());
                boolean CoreTextField$lambda$112222222 = CoreTextField$lambda$11(rememberUpdatedState222222);
                changedInstance9 = startRestartGroup.changedInstance(legacyTextFieldState) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32) | startRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter2222);
                rememberedValue19 = startRestartGroup.rememberedValue();
                if (!changedInstance9) {
                }
                rememberedValue19 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$stylusHandwritingModifier$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        if (!LegacyTextFieldState.this.getHasFocus()) {
                            focusRequester2222.requestFocus();
                        }
                        int keyboardType = imeOptions5.getKeyboardType();
                        KeyboardType.Companion companion3 = KeyboardType.INSTANCE;
                        if (!KeyboardType.m2410equalsimpl0(keyboardType, companion3.m2419getPasswordPjHm6EE()) && !KeyboardType.m2410equalsimpl0(imeOptions5.getKeyboardType(), companion3.m2418getNumberPasswordPjHm6EE())) {
                            legacyPlatformTextInputServiceAdapter2222.startStylusHandwriting();
                        }
                        return Boolean.TRUE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue19);
                Modifier onGloballyPositioned22222222 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier72222, legacyPlatformTextInputServiceAdapter2222, legacyTextFieldState, textFieldSelectionManager2222).then(StylusHandwritingKt.stylusHandwriting(companion22222, CoreTextField$lambda$112222222, (Function0) rememberedValue19)).then(modifier4), legacyTextFieldState, focusManager2222), legacyTextFieldState, textFieldSelectionManager2222).then(m539textFieldKeyInput2WJ9YEU2222222), textFieldScrollerPosition2222, mutableInteractionSource7222222, z8).then(pointerHoverIcon$default2222222).then(semantics2222222), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                        invoke2(layoutCoordinates);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutCoordinates layoutCoordinates) {
                        TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                        if (layoutResult == null) {
                            return;
                        }
                        layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                    }
                });
                if (z8) {
                }
                final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function342222222 = function32;
                final TextStyle textStyle52222222 = textStyle2;
                final int i412222222 = i25;
                boolean z292222222 = z8;
                ImeOptions imeOptions92222222 = imeOptions5;
                final Modifier textFieldMagnifier2222222 = !z28 ? TextFieldSelectionManager_androidKt.textFieldMagnifier(companion22222, textFieldSelectionManager2222) : companion22222;
                final boolean z302222222 = z28;
                final boolean z312222222 = z10;
                final Function1<? super TextLayoutResult, Unit> function162222222 = function13;
                composer2 = startRestartGroup;
                CoreTextFieldRootBox(onGloballyPositioned22222222, textFieldSelectionManager2222, ComposableLambdaKt.rememberComposableLambda(-374338080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i42) {
                        if ((i42 & 3) == 2 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-374338080, i42, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:695)");
                        }
                        Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function35 = function342222222;
                        final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                        final TextStyle textStyle6 = textStyle52222222;
                        final int i43 = i412222222;
                        final int i44 = i362222;
                        final TextFieldScrollerPosition textFieldScrollerPosition22222 = textFieldScrollerPosition2222;
                        final TextFieldValue textFieldValue2 = textFieldValue;
                        final VisualTransformation visualTransformation5 = visualTransformation42222;
                        final Modifier modifier8 = cursor2222222;
                        final Modifier modifier9 = drawBehind2222222;
                        final Modifier modifier10 = onGloballyPositioned3222222;
                        final Modifier modifier11 = textFieldMagnifier2222222;
                        final BringIntoViewRequester bringIntoViewRequester22222 = bringIntoViewRequester2222;
                        final TextFieldSelectionManager textFieldSelectionManager22222 = textFieldSelectionManager2222;
                        final boolean z32 = z302222222;
                        final boolean z33 = z312222222;
                        final Function1<? super TextLayoutResult, Unit> function17 = function162222222;
                        final OffsetMapping offsetMapping22222 = offsetMapping2222;
                        final Density density22222 = density2222;
                        function35.invoke(ComposableLambdaKt.rememberComposableLambda(2032502107, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i45) {
                                if ((i45 & 3) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2032502107, i45, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:698)");
                                }
                                Modifier heightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m327heightInVpY3zN4$default(Modifier.INSTANCE, LegacyTextFieldState.this.m486getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle6, i43, i44);
                                TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition22222;
                                TextFieldValue textFieldValue3 = textFieldValue2;
                                VisualTransformation visualTransformation6 = visualTransformation5;
                                boolean changedInstance11 = composer4.changedInstance(LegacyTextFieldState.this);
                                final LegacyTextFieldState legacyTextFieldState3 = LegacyTextFieldState.this;
                                Object rememberedValue21 = composer4.rememberedValue();
                                if (changedInstance11 || rememberedValue21 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue21 = new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final TextLayoutResultProxy invoke() {
                                            return LegacyTextFieldState.this.getLayoutResult();
                                        }
                                    };
                                    composer4.updateRememberedValue(rememberedValue21);
                                }
                                Modifier bringIntoViewRequester3 = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(heightInLines, textFieldScrollerPosition3, textFieldValue3, visualTransformation6, (Function0) rememberedValue21).then(modifier8).then(modifier9), textStyle6).then(modifier10).then(modifier11), bringIntoViewRequester22222);
                                final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager22222;
                                final LegacyTextFieldState legacyTextFieldState4 = LegacyTextFieldState.this;
                                final boolean z34 = z32;
                                final boolean z35 = z33;
                                final Function1<? super TextLayoutResult, Unit> function18 = function17;
                                final TextFieldValue textFieldValue4 = textFieldValue2;
                                final OffsetMapping offsetMapping3 = offsetMapping22222;
                                final Density density3 = density22222;
                                final int i46 = i44;
                                SimpleLayoutKt.SimpleLayout(bringIntoViewRequester3, ComposableLambdaKt.rememberComposableLambda(-363167407, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                        invoke(composer5, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX WARN: Removed duplicated region for block: B:39:0x00ff  */
                                    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final void invoke(Composer composer5, int i47) {
                                        boolean z36;
                                        if ((i47 & 3) == 2 && composer5.getSkipping()) {
                                            composer5.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-363167407, i47, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:721)");
                                        }
                                        final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                        final Function1<? super TextLayoutResult, Unit> function19 = function18;
                                        final TextFieldValue textFieldValue5 = textFieldValue4;
                                        final OffsetMapping offsetMapping4 = offsetMapping3;
                                        final Density density4 = density3;
                                        final int i48 = i46;
                                        MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                            @Override // androidx.compose.ui.layout.MeasurePolicy
                                            public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i49) {
                                                LegacyTextFieldState.this.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                                return LegacyTextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                            }

                                            @Override // androidx.compose.ui.layout.MeasurePolicy
                                            /* renamed from: measure-3p2s80s */
                                            public MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                                                Snapshot.Companion companion3 = Snapshot.INSTANCE;
                                                LegacyTextFieldState legacyTextFieldState6 = LegacyTextFieldState.this;
                                                Snapshot currentThreadSnapshot = companion3.getCurrentThreadSnapshot();
                                                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                                Snapshot makeCurrentNonObservable = companion3.makeCurrentNonObservable(currentThreadSnapshot);
                                                try {
                                                    TextLayoutResultProxy layoutResult = legacyTextFieldState6.getLayoutResult();
                                                    TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                                    Triple<Integer, Integer, TextLayoutResult> m531layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m531layout_EkL_Y$foundation_release(LegacyTextFieldState.this.getTextDelegate(), j5, measureScope.getLayoutDirection(), value);
                                                    int intValue = m531layout_EkL_Y$foundation_release.component1().intValue();
                                                    int intValue2 = m531layout_EkL_Y$foundation_release.component2().intValue();
                                                    TextLayoutResult component3 = m531layout_EkL_Y$foundation_release.component3();
                                                    if (!Intrinsics.areEqual(value, component3)) {
                                                        LegacyTextFieldState.this.setLayoutResult(new TextLayoutResultProxy(component3, null, layoutResult != null ? layoutResult.getDecorationBoxCoordinates() : null, 2, null));
                                                        function19.invoke(component3);
                                                        CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue5, offsetMapping4);
                                                    }
                                                    LegacyTextFieldState.this.m490setMinHeightForSingleLineField0680j_4(density4.mo209toDpu2uoSUM(i48 == 1 ? TextDelegateKt.ceilToIntPx(component3.getLineBottom(0)) : 0));
                                                    return measureScope.layout(intValue, intValue2, MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(component3.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(component3.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                        public final void invoke2(Placeable.PlacementScope placementScope) {
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                            invoke2(placementScope);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                } finally {
                                                    companion3.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                                }
                                            }
                                        };
                                        Modifier.Companion companion3 = Modifier.INSTANCE;
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, companion3);
                                        ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                        Function0<ComposeUiNode> constructor = companion4.getConstructor();
                                        if (composer5.getApplier() == null) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer5.startReusableNode();
                                        if (composer5.getInserting()) {
                                            composer5.createNode(constructor);
                                        } else {
                                            composer5.useNode();
                                        }
                                        Composer m1226constructorimpl = Updater.m1226constructorimpl(composer5);
                                        Updater.m1227setimpl(m1226constructorimpl, measurePolicy, companion4.getSetMeasurePolicy());
                                        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                                        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
                                        composer5.endNode();
                                        TextFieldSelectionManager textFieldSelectionManager4 = TextFieldSelectionManager.this;
                                        if (legacyTextFieldState4.getHandleState() != HandleState.None && legacyTextFieldState4.getLayoutCoordinates() != null) {
                                            LayoutCoordinates layoutCoordinates = legacyTextFieldState4.getLayoutCoordinates();
                                            Intrinsics.checkNotNull(layoutCoordinates);
                                            if (layoutCoordinates.isAttached() && z34) {
                                                z36 = true;
                                                CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z36, composer5, 0);
                                                if (legacyTextFieldState4.getHandleState() != HandleState.Cursor && !z35 && z34) {
                                                    composer5.startReplaceGroup(-2032274);
                                                    CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer5, 0);
                                                    composer5.endReplaceGroup();
                                                } else {
                                                    composer5.startReplaceGroup(-1955394);
                                                    composer5.endReplaceGroup();
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    return;
                                                }
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                        }
                                        z36 = false;
                                        CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z36, composer5, 0);
                                        if (legacyTextFieldState4.getHandleState() != HandleState.Cursor) {
                                        }
                                        composer5.startReplaceGroup(-1955394);
                                        composer5.endReplaceGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                    }
                                }, composer4, 54), composer4, 48, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, composer3, 54), composer3, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer2, 54), composer2, 384);
                if (ComposerKt.isTraceInProgress()) {
                }
                textStyle3 = textStyle2;
                function14 = function13;
                visualTransformation3 = visualTransformation42222;
                modifier5 = modifier72222;
                brush4 = brush3;
                z15 = z9;
                i30 = i25;
                z16 = z292222222;
                keyboardActions3 = keyboardActions2;
                imeOptions6 = imeOptions92222222;
                i31 = i362222;
                mutableInteractionSource4 = mutableInteractionSource7222222;
                z17 = z10;
                function33 = function32;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i12 = i9 & 16;
            if (i12 != 0) {
            }
            i13 = i9 & 32;
            if (i13 == 0) {
            }
            i14 = i9 & 64;
            if (i14 == 0) {
            }
            i15 = i9 & 128;
            if (i15 == 0) {
            }
            i16 = i9 & 256;
            if (i16 == 0) {
            }
            i17 = i9 & 512;
            if (i17 == 0) {
            }
            i18 = i9 & 1024;
            if (i18 == 0) {
            }
            if ((i8 & 48) == 0) {
            }
            i20 = i19;
            i21 = i9 & 4096;
            if (i21 == 0) {
            }
            i22 = i9 & 8192;
            if (i22 != 0) {
            }
            i23 = i9 & 16384;
            if (i23 == 0) {
            }
            i24 = i9 & 32768;
            if (i24 != 0) {
            }
            if ((i10 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i7 & 1) != 0) {
            }
            if (i33 != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i13 != 0) {
            }
            if (i14 != 0) {
            }
            if (i15 != 0) {
            }
            if (i16 != 0) {
            }
            if (i17 != 0) {
            }
            if (i18 != 0) {
            }
            if ((i9 & 2048) != 0) {
            }
            if (i21 != 0) {
            }
            if (i22 != 0) {
            }
            if (i23 != 0) {
            }
            if (i24 != 0) {
            }
            visualTransformation2 = none;
            function13 = function15;
            i26 = i34;
            imeOptions3 = imeOptions2;
            MutableInteractionSource mutableInteractionSource622222 = mutableInteractionSource5;
            textStyle2 = textStyle4;
            mutableInteractionSource2 = mutableInteractionSource622222;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
            }
            final FocusRequester focusRequester22222 = (FocusRequester) rememberedValue;
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
            }
            final LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter22222 = (LegacyPlatformTextInputServiceAdapter) rememberedValue2;
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
            }
            final TextInputService textInputService22222 = (TextInputService) rememberedValue3;
            final Density density22222 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            FontFamily.Resolver resolver22222 = (FontFamily.Resolver) startRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
            long selectionBackgroundColor22222 = ((SelectionColors) startRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).getSelectionBackgroundColor();
            FocusManager focusManager22222 = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
            Modifier modifier722222 = modifier3;
            windowInfo = (WindowInfo) startRestartGroup.consume(CompositionLocalsKt.getLocalWindowInfo());
            SoftwareKeyboardController softwareKeyboardController22222 = (SoftwareKeyboardController) startRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
            if (i26 == 1) {
            }
            Object[] objArr22222 = {orientation};
            Saver<TextFieldScrollerPosition, Object> saver22222 = TextFieldScrollerPosition.INSTANCE.getSaver();
            changed = startRestartGroup.changed(orientation);
            final int i3622222 = i26;
            Object rememberedValue2022222 = startRestartGroup.rememberedValue();
            if (changed) {
            }
            rememberedValue2022222 = new Function0<TextFieldScrollerPosition>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextFieldScrollerPosition invoke() {
                    return new TextFieldScrollerPosition(Orientation.this, 0.0f, 2, null);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2022222);
            final TextFieldScrollerPosition textFieldScrollerPosition22222 = (TextFieldScrollerPosition) RememberSaveableKt.rememberSaveable(objArr22222, saver22222, null, (Function0) rememberedValue2022222, startRestartGroup, 0, 4);
            int i3722222 = i10 & 14;
            if (i3722222 == 4) {
            }
            z11 = ((i10 & 57344) == 16384) | (i3722222 == 4);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (z11) {
            }
            TransformedText filterWithValidation22222 = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation2, textFieldValue.getText());
            composition = textFieldValue.getComposition();
            if (composition != null) {
            }
            rememberedValue4 = filterWithValidation22222;
            startRestartGroup.updateRememberedValue(rememberedValue4);
            final TransformedText transformedText22222 = (TransformedText) rememberedValue4;
            AnnotatedString text22222 = transformedText22222.getText();
            final OffsetMapping offsetMapping22222 = transformedText22222.getOffsetMapping();
            RecomposeScope currentRecomposeScope22222 = ComposablesKt.getCurrentRecomposeScope(startRestartGroup, 0);
            changed2 = startRestartGroup.changed(softwareKeyboardController22222);
            rememberedValue5 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            rememberedValue5 = new LegacyTextFieldState(new TextDelegate(text22222, textStyle2, 0, 0, z9, 0, density22222, resolver22222, null, 300, null), currentRecomposeScope22222, softwareKeyboardController22222);
            startRestartGroup.updateRememberedValue(rememberedValue5);
            legacyTextFieldState = (LegacyTextFieldState) rememberedValue5;
            legacyTextFieldState.m492updatefnh65Uc(textFieldValue.getText(), text22222, textStyle2, z9, density22222, resolver22222, function1, keyboardActions2, focusManager22222, selectionBackgroundColor22222);
            legacyTextFieldState.getProcessor().reset(textFieldValue, legacyTextFieldState.getInputSession());
            rememberedValue6 = startRestartGroup.rememberedValue();
            if (rememberedValue6 == companion.getEmpty()) {
            }
            UndoManager undoManager22222 = (UndoManager) rememberedValue6;
            UndoManager.snapshotIfNeeded$default(undoManager22222, textFieldValue, 0L, 2, null);
            rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == companion.getEmpty()) {
            }
            final TextFieldSelectionManager textFieldSelectionManager22222 = (TextFieldSelectionManager) rememberedValue7;
            textFieldSelectionManager22222.setOffsetMapping$foundation_release(offsetMapping22222);
            textFieldSelectionManager22222.setVisualTransformation$foundation_release(visualTransformation2);
            textFieldSelectionManager22222.setOnValueChange$foundation_release(legacyTextFieldState.getOnValueChange());
            textFieldSelectionManager22222.setState$foundation_release(legacyTextFieldState);
            textFieldSelectionManager22222.setValue$foundation_release(textFieldValue);
            textFieldSelectionManager22222.setClipboardManager$foundation_release((ClipboardManager) startRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
            textFieldSelectionManager22222.setTextToolbar((TextToolbar) startRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
            textFieldSelectionManager22222.setHapticFeedBack((HapticFeedback) startRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
            textFieldSelectionManager22222.setFocusRequester(focusRequester22222);
            textFieldSelectionManager22222.setEditable(!z10);
            textFieldSelectionManager22222.setEnabled(z8);
            rememberedValue8 = startRestartGroup.rememberedValue();
            if (rememberedValue8 == companion.getEmpty()) {
            }
            final CoroutineScope coroutineScope22222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue8).getCoroutineScope();
            rememberedValue9 = startRestartGroup.rememberedValue();
            if (rememberedValue9 == companion.getEmpty()) {
            }
            final BringIntoViewRequester bringIntoViewRequester22222 = (BringIntoViewRequester) rememberedValue9;
            Modifier.Companion companion222222 = Modifier.INSTANCE;
            int i3822222 = i20 & 7168;
            final VisualTransformation visualTransformation422222 = visualTransformation2;
            int i3922222 = i20 & 57344;
            boolean changedInstance1022222 = startRestartGroup.changedInstance(legacyTextFieldState) | (i3822222 == 2048) | (i3922222 == 16384) | startRestartGroup.changedInstance(textInputService22222) | (i3722222 == 4);
            i27 = (i20 & 112) ^ 48;
            if (i27 > 32) {
            }
            i28 = i3922222;
            i29 = i20;
            if ((i20 & 48) != 32) {
            }
            z12 = true;
            changedInstance = changedInstance1022222 | z12 | startRestartGroup.changedInstance(offsetMapping22222) | startRestartGroup.changedInstance(coroutineScope22222) | startRestartGroup.changedInstance(bringIntoViewRequester22222) | startRestartGroup.changedInstance(textFieldSelectionManager22222);
            rememberedValue10 = startRestartGroup.rememberedValue();
            if (!changedInstance) {
            }
            final boolean z202222222 = z8;
            final boolean z212222222 = z10;
            final ImeOptions imeOptions72222222 = imeOptions5;
            rememberedValue10 = new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                    invoke2(focusState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(FocusState focusState) {
                    TextLayoutResultProxy layoutResult;
                    if (LegacyTextFieldState.this.getHasFocus() == focusState.isFocused()) {
                        return;
                    }
                    LegacyTextFieldState.this.setHasFocus(focusState.isFocused());
                    if (LegacyTextFieldState.this.getHasFocus() && z202222222 && !z212222222) {
                        CoreTextFieldKt.startInputSession(textInputService22222, LegacyTextFieldState.this, textFieldValue, imeOptions72222222, offsetMapping22222);
                    } else {
                        CoreTextFieldKt.endInputSession(LegacyTextFieldState.this);
                    }
                    if (focusState.isFocused() && (layoutResult = LegacyTextFieldState.this.getLayoutResult()) != null) {
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope22222, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(bringIntoViewRequester22222, textFieldValue, LegacyTextFieldState.this, layoutResult, offsetMapping22222, null), 3, null);
                    }
                    if (focusState.isFocused()) {
                        return;
                    }
                    TextFieldSelectionManager.m640deselect_kEHs6E$foundation_release$default(textFieldSelectionManager22222, null, 1, null);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue10);
            MutableInteractionSource mutableInteractionSource72222222 = mutableInteractionSource3;
            textFieldFocusModifier = TextFieldGestureModifiersKt.textFieldFocusModifier(companion222222, z8, focusRequester22222, mutableInteractionSource72222222, (Function1) rememberedValue10);
            State rememberUpdatedState2222222 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf((z8 || z10) ? false : true), startRestartGroup, 0);
            Unit unit2222222 = Unit.INSTANCE;
            boolean changed32222222 = startRestartGroup.changed(rememberUpdatedState2222222) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService22222) | startRestartGroup.changedInstance(textFieldSelectionManager22222);
            if (i27 > 32) {
            }
            modifier4 = textFieldFocusModifier;
            if ((i29 & 48) != 32) {
            }
            z13 = true;
            z14 = changed32222222 | z13;
            rememberedValue11 = startRestartGroup.rememberedValue();
            if (!z14) {
            }
            rememberedValue11 = new CoreTextFieldKt$CoreTextField$2$1(legacyTextFieldState, rememberUpdatedState2222222, textInputService22222, textFieldSelectionManager22222, imeOptions5, null);
            startRestartGroup.updateRememberedValue(rememberedValue11);
            EffectsKt.LaunchedEffect(unit2222222, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue11, startRestartGroup, 6);
            changedInstance2 = startRestartGroup.changedInstance(legacyTextFieldState);
            rememberedValue12 = startRestartGroup.rememberedValue();
            if (!changedInstance2) {
            }
            rememberedValue12 = new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z2222222222) {
                    LegacyTextFieldState.this.setInTouchMode(z2222222222);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue12);
            Modifier updateSelectionTouchMode22222222 = SelectionGesturesKt.updateSelectionTouchMode(companion222222, (Function1) rememberedValue12);
            int i4022222222 = i28;
            changedInstance3 = startRestartGroup.changedInstance(legacyTextFieldState) | (i4022222222 != 16384) | (i3822222 != 2048) | startRestartGroup.changedInstance(offsetMapping22222) | startRestartGroup.changedInstance(textFieldSelectionManager22222);
            rememberedValue13 = startRestartGroup.rememberedValue();
            if (!changedInstance3) {
            }
            final boolean z2222222222 = z10;
            final boolean z2322222222 = z8;
            rememberedValue13 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                    m473invokek4lQ0M(offset.getPackedValue());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
                public final void m473invokek4lQ0M(long j5) {
                    CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester22222, !z2222222222);
                    if (LegacyTextFieldState.this.getHasFocus() && z2322222222) {
                        if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                            textFieldSelectionManager22222.m643deselect_kEHs6E$foundation_release(Offset.m1328boximpl(j5));
                            return;
                        }
                        TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                        if (layoutResult != null) {
                            LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                            TextFieldDelegate.INSTANCE.m532setCursorOffsetULxng0E$foundation_release(j5, layoutResult, legacyTextFieldState2.getProcessor(), offsetMapping22222, legacyTextFieldState2.getOnValueChange());
                            if (legacyTextFieldState2.getTextDelegate().getText().length() > 0) {
                                legacyTextFieldState2.setHandleState(HandleState.Cursor);
                            }
                        }
                    }
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue13);
            Modifier pointerHoverIcon$default22222222 = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(updateSelectionTouchMode22222222, mutableInteractionSource72222222, z8, (Function1) rememberedValue13), textFieldSelectionManager22222.getMouseSelectionObserver(), textFieldSelectionManager22222.getTouchSelectionObserver()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
            changedInstance4 = startRestartGroup.changedInstance(legacyTextFieldState) | (i3722222 != 4) | startRestartGroup.changedInstance(offsetMapping22222);
            rememberedValue14 = startRestartGroup.rememberedValue();
            if (!changedInstance4) {
            }
            rememberedValue14 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                    invoke2(drawScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DrawScope drawScope) {
                    TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                    if (layoutResult != null) {
                        TextFieldValue textFieldValue2 = textFieldValue;
                        LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                        OffsetMapping offsetMapping222222 = offsetMapping22222;
                        TextFieldDelegate.INSTANCE.m530drawQ1vqE60$foundation_release(drawScope.getDrawContext().getCanvas(), textFieldValue2, legacyTextFieldState2.m488getSelectionPreviewHighlightRanged9O1mEE(), legacyTextFieldState2.m485getDeletionPreviewHighlightRanged9O1mEE(), offsetMapping222222, layoutResult.getValue(), legacyTextFieldState2.getHighlightPaint(), legacyTextFieldState2.getSelectionBackgroundColor());
                    }
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue14);
            final Modifier drawBehind22222222 = DrawModifierKt.drawBehind(companion222222, (Function1) rememberedValue14);
            changedInstance5 = startRestartGroup.changedInstance(legacyTextFieldState) | (i3822222 != 2048) | startRestartGroup.changed(windowInfo) | startRestartGroup.changedInstance(textFieldSelectionManager22222) | (i3722222 != 4) | startRestartGroup.changedInstance(offsetMapping22222);
            rememberedValue15 = startRestartGroup.rememberedValue();
            if (!changedInstance5) {
            }
            final boolean z2422222222 = z8;
            rememberedValue15 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                    invoke2(layoutCoordinates);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutCoordinates layoutCoordinates) {
                    LegacyTextFieldState.this.setLayoutCoordinates(layoutCoordinates);
                    TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                    if (layoutResult != null) {
                        layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
                    }
                    if (z2422222222) {
                        if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                            if (LegacyTextFieldState.this.getShowFloatingToolbar() && windowInfo.isWindowFocused()) {
                                textFieldSelectionManager22222.showSelectionToolbar$foundation_release();
                            } else {
                                textFieldSelectionManager22222.hideSelectionToolbar$foundation_release();
                            }
                            LegacyTextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager22222, true));
                            LegacyTextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager22222, false));
                            LegacyTextFieldState.this.setShowCursorHandle(TextRange.m2279getCollapsedimpl(textFieldValue.getSelection()));
                        } else if (LegacyTextFieldState.this.getHandleState() == HandleState.Cursor) {
                            LegacyTextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager22222, true));
                        }
                        CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue, offsetMapping22222);
                        TextLayoutResultProxy layoutResult2 = LegacyTextFieldState.this.getLayoutResult();
                        if (layoutResult2 != null) {
                            LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                            TextFieldValue textFieldValue2 = textFieldValue;
                            OffsetMapping offsetMapping222222 = offsetMapping22222;
                            TextInputSession inputSession = legacyTextFieldState2.getInputSession();
                            if (inputSession == null || !legacyTextFieldState2.getHasFocus()) {
                                return;
                            }
                            TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation_release(inputSession, textFieldValue2, offsetMapping222222, layoutResult2);
                        }
                    }
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue15);
            final Modifier onGloballyPositioned32222222 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion222222, (Function1) rememberedValue15);
            final boolean z2522222222 = visualTransformation422222 instanceof PasswordVisualTransformation;
            changedInstance6 = (i3822222 != 2048) | startRestartGroup.changedInstance(transformedText22222) | (i3722222 != 4) | startRestartGroup.changed(z2522222222) | (i4022222222 != 16384) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(offsetMapping22222) | startRestartGroup.changedInstance(textFieldSelectionManager22222) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32);
            rememberedValue16 = startRestartGroup.rememberedValue();
            if (!changedInstance6) {
            }
            final boolean z2622222222 = z8;
            final boolean z2722222222 = z10;
            final ImeOptions imeOptions822222222 = imeOptions5;
            rememberedValue16 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, TransformedText.this.getText());
                    SemanticsPropertiesKt.m2185setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, textFieldValue.getSelection());
                    if (!z2622222222) {
                        SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                    }
                    if (z2522222222) {
                        SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                    }
                    boolean z282 = z2622222222 && !z2722222222;
                    SemanticsPropertiesKt.setEditable(semanticsPropertyReceiver, z282);
                    final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                    SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(List<TextLayoutResult> list) {
                            boolean z2922222222;
                            if (LegacyTextFieldState.this.getLayoutResult() != null) {
                                TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                Intrinsics.checkNotNull(layoutResult);
                                list.add(layoutResult.getValue());
                                z2922222222 = true;
                            } else {
                                z2922222222 = false;
                            }
                            return Boolean.valueOf(z2922222222);
                        }
                    }, 1, null);
                    if (z282) {
                        final LegacyTextFieldState legacyTextFieldState3 = legacyTextFieldState;
                        SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(AnnotatedString annotatedString) {
                                Unit unit22222222;
                                TextInputSession inputSession = LegacyTextFieldState.this.getInputSession();
                                if (inputSession != null) {
                                    LegacyTextFieldState legacyTextFieldState4 = LegacyTextFieldState.this;
                                    TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(annotatedString, 1)}), legacyTextFieldState4.getProcessor(), legacyTextFieldState4.getOnValueChange(), inputSession);
                                    unit22222222 = Unit.INSTANCE;
                                } else {
                                    unit22222222 = null;
                                }
                                if (unit22222222 == null) {
                                    LegacyTextFieldState.this.getOnValueChange().invoke(new TextFieldValue(annotatedString.getText(), TextRangeKt.TextRange(annotatedString.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                }
                                return Boolean.TRUE;
                            }
                        }, 1, null);
                        final boolean z2922222222 = z2722222222;
                        final boolean z3022222222 = z2622222222;
                        final LegacyTextFieldState legacyTextFieldState4 = legacyTextFieldState;
                        final TextFieldValue textFieldValue2 = textFieldValue;
                        SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(AnnotatedString annotatedString) {
                                Unit unit22222222;
                                if (!z2922222222 && z3022222222) {
                                    TextInputSession inputSession = legacyTextFieldState4.getInputSession();
                                    if (inputSession != null) {
                                        LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                        TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(annotatedString, 1)}), legacyTextFieldState5.getProcessor(), legacyTextFieldState5.getOnValueChange(), inputSession);
                                        unit22222222 = Unit.INSTANCE;
                                    } else {
                                        unit22222222 = null;
                                    }
                                    if (unit22222222 == null) {
                                        TextFieldValue textFieldValue3 = textFieldValue2;
                                        legacyTextFieldState4.getOnValueChange().invoke(new TextFieldValue(StringsKt.replaceRange(textFieldValue3.getText(), TextRange.m2285getStartimpl(textFieldValue3.getSelection()), TextRange.m2280getEndimpl(textFieldValue3.getSelection()), annotatedString).toString(), TextRangeKt.TextRange(TextRange.m2285getStartimpl(textFieldValue3.getSelection()) + annotatedString.length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                    }
                                    return Boolean.TRUE;
                                }
                                return Boolean.FALSE;
                            }
                        }, 1, null);
                    }
                    final OffsetMapping offsetMapping222222 = offsetMapping22222;
                    final boolean z3122222222 = z2622222222;
                    final TextFieldValue textFieldValue3 = textFieldValue;
                    final TextFieldSelectionManager textFieldSelectionManager222222 = textFieldSelectionManager22222;
                    final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState;
                    SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                            return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                        }

                        public final Boolean invoke(int i4122222222, int i42, boolean z32) {
                            if (!z32) {
                                i4122222222 = OffsetMapping.this.transformedToOriginal(i4122222222);
                            }
                            if (!z32) {
                                i42 = OffsetMapping.this.transformedToOriginal(i42);
                            }
                            boolean z33 = false;
                            if (z3122222222 && (i4122222222 != TextRange.m2285getStartimpl(textFieldValue3.getSelection()) || i42 != TextRange.m2280getEndimpl(textFieldValue3.getSelection()))) {
                                if (Math.min(i4122222222, i42) >= 0 && Math.max(i4122222222, i42) <= textFieldValue3.getText().length()) {
                                    if (!z32 && i4122222222 != i42) {
                                        TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager222222, false, 1, null);
                                    } else {
                                        textFieldSelectionManager222222.exitSelectionMode$foundation_release();
                                    }
                                    legacyTextFieldState5.getOnValueChange().invoke(new TextFieldValue(textFieldValue3.getText(), TextRangeKt.TextRange(i4122222222, i42), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                    z33 = true;
                                } else {
                                    textFieldSelectionManager222222.exitSelectionMode$foundation_release();
                                }
                            }
                            return Boolean.valueOf(z33);
                        }
                    }, 1, null);
                    int imeAction = imeOptions822222222.getImeAction();
                    final LegacyTextFieldState legacyTextFieldState6 = legacyTextFieldState;
                    final ImeOptions imeOptions922222222 = imeOptions822222222;
                    SemanticsPropertiesKt.m2182onImeAction9UiTYpY$default(semanticsPropertyReceiver, imeAction, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            LegacyTextFieldState.this.getOnImeActionPerformed().invoke(ImeAction.m2375boximpl(imeOptions922222222.getImeAction()));
                            return Boolean.TRUE;
                        }
                    }, 2, null);
                    final LegacyTextFieldState legacyTextFieldState7 = legacyTextFieldState;
                    final FocusRequester focusRequester222222 = focusRequester22222;
                    final boolean z32 = z2722222222;
                    SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester222222, !z32);
                            return Boolean.TRUE;
                        }
                    }, 1, null);
                    final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager22222;
                    SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.7
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            TextFieldSelectionManager.enterSelectionMode$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                            return Boolean.TRUE;
                        }
                    }, 1, null);
                    if (!TextRange.m2279getCollapsedimpl(textFieldValue.getSelection()) && !z2522222222) {
                        final TextFieldSelectionManager textFieldSelectionManager4 = textFieldSelectionManager22222;
                        SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.8
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                TextFieldSelectionManager.copy$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                                return Boolean.TRUE;
                            }
                        }, 1, null);
                        if (z2622222222 && !z2722222222) {
                            final TextFieldSelectionManager textFieldSelectionManager5 = textFieldSelectionManager22222;
                            SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.9
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    TextFieldSelectionManager.this.cut$foundation_release();
                                    return Boolean.TRUE;
                                }
                            }, 1, null);
                        }
                    }
                    if (!z2622222222 || z2722222222) {
                        return;
                    }
                    final TextFieldSelectionManager textFieldSelectionManager6 = textFieldSelectionManager22222;
                    SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.10
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            TextFieldSelectionManager.this.paste$foundation_release();
                            return Boolean.TRUE;
                        }
                    }, 1, null);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue16);
            Modifier semantics22222222 = SemanticsModifierKt.semantics(companion222222, true, (Function1) rememberedValue16);
            final Modifier cursor22222222 = TextFieldCursorKt.cursor(companion222222, legacyTextFieldState, textFieldValue, offsetMapping22222, brush3, (z8 || z10 || !windowInfo.isWindowFocused() || legacyTextFieldState.hasHighlight()) ? false : true);
            changedInstance7 = startRestartGroup.changedInstance(textFieldSelectionManager22222);
            rememberedValue17 = startRestartGroup.rememberedValue();
            if (!changedInstance7) {
            }
            rememberedValue17 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    final TextFieldSelectionManager textFieldSelectionManager222222 = TextFieldSelectionManager.this;
                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                        }
                    };
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue17);
            EffectsKt.DisposableEffect(textFieldSelectionManager22222, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue17, startRestartGroup, 0);
            changedInstance8 = (i3722222 != 4) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService22222) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32);
            rememberedValue18 = startRestartGroup.rememberedValue();
            if (!changedInstance8) {
            }
            rememberedValue18 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    if (LegacyTextFieldState.this.getHasFocus()) {
                        LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                        legacyTextFieldState2.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(textInputService22222, textFieldValue, legacyTextFieldState2.getProcessor(), imeOptions5, LegacyTextFieldState.this.getOnValueChange(), LegacyTextFieldState.this.getOnImeActionPerformed()));
                    }
                    return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                        }
                    };
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue18);
            EffectsKt.DisposableEffect(imeOptions5, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue18, startRestartGroup, (i29 >> 3) & 14);
            Modifier m539textFieldKeyInput2WJ9YEU22222222 = TextFieldKeyInputKt.m539textFieldKeyInput2WJ9YEU(companion222222, legacyTextFieldState, textFieldSelectionManager22222, textFieldValue, legacyTextFieldState.getOnValueChange(), !z10, i3622222 != 1, offsetMapping22222, undoManager22222, imeOptions5.getImeAction());
            boolean CoreTextField$lambda$1122222222 = CoreTextField$lambda$11(rememberUpdatedState2222222);
            changedInstance9 = startRestartGroup.changedInstance(legacyTextFieldState) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32) | startRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter22222);
            rememberedValue19 = startRestartGroup.rememberedValue();
            if (!changedInstance9) {
            }
            rememberedValue19 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$stylusHandwritingModifier$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    if (!LegacyTextFieldState.this.getHasFocus()) {
                        focusRequester22222.requestFocus();
                    }
                    int keyboardType = imeOptions5.getKeyboardType();
                    KeyboardType.Companion companion3 = KeyboardType.INSTANCE;
                    if (!KeyboardType.m2410equalsimpl0(keyboardType, companion3.m2419getPasswordPjHm6EE()) && !KeyboardType.m2410equalsimpl0(imeOptions5.getKeyboardType(), companion3.m2418getNumberPasswordPjHm6EE())) {
                        legacyPlatformTextInputServiceAdapter22222.startStylusHandwriting();
                    }
                    return Boolean.TRUE;
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue19);
            Modifier onGloballyPositioned222222222 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier722222, legacyPlatformTextInputServiceAdapter22222, legacyTextFieldState, textFieldSelectionManager22222).then(StylusHandwritingKt.stylusHandwriting(companion222222, CoreTextField$lambda$1122222222, (Function0) rememberedValue19)).then(modifier4), legacyTextFieldState, focusManager22222), legacyTextFieldState, textFieldSelectionManager22222).then(m539textFieldKeyInput2WJ9YEU22222222), textFieldScrollerPosition22222, mutableInteractionSource72222222, z8).then(pointerHoverIcon$default22222222).then(semantics22222222), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                    invoke2(layoutCoordinates);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutCoordinates layoutCoordinates) {
                    TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                    if (layoutResult == null) {
                        return;
                    }
                    layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                }
            });
            if (z8) {
            }
            final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3422222222 = function32;
            final TextStyle textStyle522222222 = textStyle2;
            final int i4122222222 = i25;
            boolean z2922222222 = z8;
            ImeOptions imeOptions922222222 = imeOptions5;
            final Modifier textFieldMagnifier22222222 = !z28 ? TextFieldSelectionManager_androidKt.textFieldMagnifier(companion222222, textFieldSelectionManager22222) : companion222222;
            final boolean z3022222222 = z28;
            final boolean z3122222222 = z10;
            final Function1<? super TextLayoutResult, Unit> function1622222222 = function13;
            composer2 = startRestartGroup;
            CoreTextFieldRootBox(onGloballyPositioned222222222, textFieldSelectionManager22222, ComposableLambdaKt.rememberComposableLambda(-374338080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i42) {
                    if ((i42 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-374338080, i42, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:695)");
                    }
                    Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function35 = function3422222222;
                    final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                    final TextStyle textStyle6 = textStyle522222222;
                    final int i43 = i4122222222;
                    final int i44 = i3622222;
                    final TextFieldScrollerPosition textFieldScrollerPosition222222 = textFieldScrollerPosition22222;
                    final TextFieldValue textFieldValue2 = textFieldValue;
                    final VisualTransformation visualTransformation5 = visualTransformation422222;
                    final Modifier modifier8 = cursor22222222;
                    final Modifier modifier9 = drawBehind22222222;
                    final Modifier modifier10 = onGloballyPositioned32222222;
                    final Modifier modifier11 = textFieldMagnifier22222222;
                    final BringIntoViewRequester bringIntoViewRequester222222 = bringIntoViewRequester22222;
                    final TextFieldSelectionManager textFieldSelectionManager222222 = textFieldSelectionManager22222;
                    final boolean z32 = z3022222222;
                    final boolean z33 = z3122222222;
                    final Function1<? super TextLayoutResult, Unit> function17 = function1622222222;
                    final OffsetMapping offsetMapping222222 = offsetMapping22222;
                    final Density density222222 = density22222;
                    function35.invoke(ComposableLambdaKt.rememberComposableLambda(2032502107, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                            invoke(composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i45) {
                            if ((i45 & 3) == 2 && composer4.getSkipping()) {
                                composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2032502107, i45, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:698)");
                            }
                            Modifier heightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m327heightInVpY3zN4$default(Modifier.INSTANCE, LegacyTextFieldState.this.m486getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle6, i43, i44);
                            TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition222222;
                            TextFieldValue textFieldValue3 = textFieldValue2;
                            VisualTransformation visualTransformation6 = visualTransformation5;
                            boolean changedInstance11 = composer4.changedInstance(LegacyTextFieldState.this);
                            final LegacyTextFieldState legacyTextFieldState3 = LegacyTextFieldState.this;
                            Object rememberedValue21 = composer4.rememberedValue();
                            if (changedInstance11 || rememberedValue21 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue21 = new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final TextLayoutResultProxy invoke() {
                                        return LegacyTextFieldState.this.getLayoutResult();
                                    }
                                };
                                composer4.updateRememberedValue(rememberedValue21);
                            }
                            Modifier bringIntoViewRequester3 = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(heightInLines, textFieldScrollerPosition3, textFieldValue3, visualTransformation6, (Function0) rememberedValue21).then(modifier8).then(modifier9), textStyle6).then(modifier10).then(modifier11), bringIntoViewRequester222222);
                            final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager222222;
                            final LegacyTextFieldState legacyTextFieldState4 = LegacyTextFieldState.this;
                            final boolean z34 = z32;
                            final boolean z35 = z33;
                            final Function1<? super TextLayoutResult, Unit> function18 = function17;
                            final TextFieldValue textFieldValue4 = textFieldValue2;
                            final OffsetMapping offsetMapping3 = offsetMapping222222;
                            final Density density3 = density222222;
                            final int i46 = i44;
                            SimpleLayoutKt.SimpleLayout(bringIntoViewRequester3, ComposableLambdaKt.rememberComposableLambda(-363167407, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                    invoke(composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                /* JADX WARN: Removed duplicated region for block: B:39:0x00ff  */
                                /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final void invoke(Composer composer5, int i47) {
                                    boolean z36;
                                    if ((i47 & 3) == 2 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-363167407, i47, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:721)");
                                    }
                                    final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                    final Function1<? super TextLayoutResult, Unit> function19 = function18;
                                    final TextFieldValue textFieldValue5 = textFieldValue4;
                                    final OffsetMapping offsetMapping4 = offsetMapping3;
                                    final Density density4 = density3;
                                    final int i48 = i46;
                                    MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                        @Override // androidx.compose.ui.layout.MeasurePolicy
                                        public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i49) {
                                            LegacyTextFieldState.this.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                            return LegacyTextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                        }

                                        @Override // androidx.compose.ui.layout.MeasurePolicy
                                        /* renamed from: measure-3p2s80s */
                                        public MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                                            Snapshot.Companion companion3 = Snapshot.INSTANCE;
                                            LegacyTextFieldState legacyTextFieldState6 = LegacyTextFieldState.this;
                                            Snapshot currentThreadSnapshot = companion3.getCurrentThreadSnapshot();
                                            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                            Snapshot makeCurrentNonObservable = companion3.makeCurrentNonObservable(currentThreadSnapshot);
                                            try {
                                                TextLayoutResultProxy layoutResult = legacyTextFieldState6.getLayoutResult();
                                                TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                                Triple<Integer, Integer, TextLayoutResult> m531layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m531layout_EkL_Y$foundation_release(LegacyTextFieldState.this.getTextDelegate(), j5, measureScope.getLayoutDirection(), value);
                                                int intValue = m531layout_EkL_Y$foundation_release.component1().intValue();
                                                int intValue2 = m531layout_EkL_Y$foundation_release.component2().intValue();
                                                TextLayoutResult component3 = m531layout_EkL_Y$foundation_release.component3();
                                                if (!Intrinsics.areEqual(value, component3)) {
                                                    LegacyTextFieldState.this.setLayoutResult(new TextLayoutResultProxy(component3, null, layoutResult != null ? layoutResult.getDecorationBoxCoordinates() : null, 2, null));
                                                    function19.invoke(component3);
                                                    CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue5, offsetMapping4);
                                                }
                                                LegacyTextFieldState.this.m490setMinHeightForSingleLineField0680j_4(density4.mo209toDpu2uoSUM(i48 == 1 ? TextDelegateKt.ceilToIntPx(component3.getLineBottom(0)) : 0));
                                                return measureScope.layout(intValue, intValue2, MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(component3.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(component3.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(Placeable.PlacementScope placementScope) {
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                        invoke2(placementScope);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                            } finally {
                                                companion3.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                            }
                                        }
                                    };
                                    Modifier.Companion companion3 = Modifier.INSTANCE;
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, companion3);
                                    ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                    Function0<ComposeUiNode> constructor = companion4.getConstructor();
                                    if (composer5.getApplier() == null) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer5.startReusableNode();
                                    if (composer5.getInserting()) {
                                        composer5.createNode(constructor);
                                    } else {
                                        composer5.useNode();
                                    }
                                    Composer m1226constructorimpl = Updater.m1226constructorimpl(composer5);
                                    Updater.m1227setimpl(m1226constructorimpl, measurePolicy, companion4.getSetMeasurePolicy());
                                    Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                                    if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
                                    composer5.endNode();
                                    TextFieldSelectionManager textFieldSelectionManager4 = TextFieldSelectionManager.this;
                                    if (legacyTextFieldState4.getHandleState() != HandleState.None && legacyTextFieldState4.getLayoutCoordinates() != null) {
                                        LayoutCoordinates layoutCoordinates = legacyTextFieldState4.getLayoutCoordinates();
                                        Intrinsics.checkNotNull(layoutCoordinates);
                                        if (layoutCoordinates.isAttached() && z34) {
                                            z36 = true;
                                            CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z36, composer5, 0);
                                            if (legacyTextFieldState4.getHandleState() != HandleState.Cursor && !z35 && z34) {
                                                composer5.startReplaceGroup(-2032274);
                                                CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer5, 0);
                                                composer5.endReplaceGroup();
                                            } else {
                                                composer5.startReplaceGroup(-1955394);
                                                composer5.endReplaceGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                return;
                                            }
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                    }
                                    z36 = false;
                                    CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z36, composer5, 0);
                                    if (legacyTextFieldState4.getHandleState() != HandleState.Cursor) {
                                    }
                                    composer5.startReplaceGroup(-1955394);
                                    composer5.endReplaceGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                }
                            }, composer4, 54), composer4, 48, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer3, 54), composer3, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composer2, 54), composer2, 384);
            if (ComposerKt.isTraceInProgress()) {
            }
            textStyle3 = textStyle2;
            function14 = function13;
            visualTransformation3 = visualTransformation422222;
            modifier5 = modifier722222;
            brush4 = brush3;
            z15 = z9;
            i30 = i25;
            z16 = z2922222222;
            keyboardActions3 = keyboardActions2;
            imeOptions6 = imeOptions922222222;
            i31 = i3622222;
            mutableInteractionSource4 = mutableInteractionSource72222222;
            z17 = z10;
            function33 = function32;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i11 = i9 & 8;
        if (i11 == 0) {
        }
        i12 = i9 & 16;
        if (i12 != 0) {
        }
        i13 = i9 & 32;
        if (i13 == 0) {
        }
        i14 = i9 & 64;
        if (i14 == 0) {
        }
        i15 = i9 & 128;
        if (i15 == 0) {
        }
        i16 = i9 & 256;
        if (i16 == 0) {
        }
        i17 = i9 & 512;
        if (i17 == 0) {
        }
        i18 = i9 & 1024;
        if (i18 == 0) {
        }
        if ((i8 & 48) == 0) {
        }
        i20 = i19;
        i21 = i9 & 4096;
        if (i21 == 0) {
        }
        i22 = i9 & 8192;
        if (i22 != 0) {
        }
        i23 = i9 & 16384;
        if (i23 == 0) {
        }
        i24 = i9 & 32768;
        if (i24 != 0) {
        }
        if ((i10 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i7 & 1) != 0) {
        }
        if (i33 != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i13 != 0) {
        }
        if (i14 != 0) {
        }
        if (i15 != 0) {
        }
        if (i16 != 0) {
        }
        if (i17 != 0) {
        }
        if (i18 != 0) {
        }
        if ((i9 & 2048) != 0) {
        }
        if (i21 != 0) {
        }
        if (i22 != 0) {
        }
        if (i23 != 0) {
        }
        if (i24 != 0) {
        }
        visualTransformation2 = none;
        function13 = function15;
        i26 = i34;
        imeOptions3 = imeOptions2;
        MutableInteractionSource mutableInteractionSource6222222 = mutableInteractionSource5;
        textStyle2 = textStyle4;
        mutableInteractionSource2 = mutableInteractionSource6222222;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        companion = Composer.INSTANCE;
        if (rememberedValue == companion.getEmpty()) {
        }
        final FocusRequester focusRequester222222 = (FocusRequester) rememberedValue;
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
        }
        final LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter222222 = (LegacyPlatformTextInputServiceAdapter) rememberedValue2;
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
        }
        final TextInputService textInputService222222 = (TextInputService) rememberedValue3;
        final Density density222222 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        FontFamily.Resolver resolver222222 = (FontFamily.Resolver) startRestartGroup.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
        long selectionBackgroundColor222222 = ((SelectionColors) startRestartGroup.consume(TextSelectionColorsKt.getLocalTextSelectionColors())).getSelectionBackgroundColor();
        FocusManager focusManager222222 = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.getLocalFocusManager());
        Modifier modifier7222222 = modifier3;
        windowInfo = (WindowInfo) startRestartGroup.consume(CompositionLocalsKt.getLocalWindowInfo());
        SoftwareKeyboardController softwareKeyboardController222222 = (SoftwareKeyboardController) startRestartGroup.consume(CompositionLocalsKt.getLocalSoftwareKeyboardController());
        if (i26 == 1) {
        }
        Object[] objArr222222 = {orientation};
        Saver<TextFieldScrollerPosition, Object> saver222222 = TextFieldScrollerPosition.INSTANCE.getSaver();
        changed = startRestartGroup.changed(orientation);
        final int i36222222 = i26;
        Object rememberedValue20222222 = startRestartGroup.rememberedValue();
        if (changed) {
        }
        rememberedValue20222222 = new Function0<TextFieldScrollerPosition>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$scrollerPosition$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextFieldScrollerPosition invoke() {
                return new TextFieldScrollerPosition(Orientation.this, 0.0f, 2, null);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue20222222);
        final TextFieldScrollerPosition textFieldScrollerPosition222222 = (TextFieldScrollerPosition) RememberSaveableKt.rememberSaveable(objArr222222, saver222222, null, (Function0) rememberedValue20222222, startRestartGroup, 0, 4);
        int i37222222 = i10 & 14;
        if (i37222222 == 4) {
        }
        z11 = ((i10 & 57344) == 16384) | (i37222222 == 4);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (z11) {
        }
        TransformedText filterWithValidation222222 = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation2, textFieldValue.getText());
        composition = textFieldValue.getComposition();
        if (composition != null) {
        }
        rememberedValue4 = filterWithValidation222222;
        startRestartGroup.updateRememberedValue(rememberedValue4);
        final TransformedText transformedText222222 = (TransformedText) rememberedValue4;
        AnnotatedString text222222 = transformedText222222.getText();
        final OffsetMapping offsetMapping222222 = transformedText222222.getOffsetMapping();
        RecomposeScope currentRecomposeScope222222 = ComposablesKt.getCurrentRecomposeScope(startRestartGroup, 0);
        changed2 = startRestartGroup.changed(softwareKeyboardController222222);
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue5 = new LegacyTextFieldState(new TextDelegate(text222222, textStyle2, 0, 0, z9, 0, density222222, resolver222222, null, 300, null), currentRecomposeScope222222, softwareKeyboardController222222);
        startRestartGroup.updateRememberedValue(rememberedValue5);
        legacyTextFieldState = (LegacyTextFieldState) rememberedValue5;
        legacyTextFieldState.m492updatefnh65Uc(textFieldValue.getText(), text222222, textStyle2, z9, density222222, resolver222222, function1, keyboardActions2, focusManager222222, selectionBackgroundColor222222);
        legacyTextFieldState.getProcessor().reset(textFieldValue, legacyTextFieldState.getInputSession());
        rememberedValue6 = startRestartGroup.rememberedValue();
        if (rememberedValue6 == companion.getEmpty()) {
        }
        UndoManager undoManager222222 = (UndoManager) rememberedValue6;
        UndoManager.snapshotIfNeeded$default(undoManager222222, textFieldValue, 0L, 2, null);
        rememberedValue7 = startRestartGroup.rememberedValue();
        if (rememberedValue7 == companion.getEmpty()) {
        }
        final TextFieldSelectionManager textFieldSelectionManager222222 = (TextFieldSelectionManager) rememberedValue7;
        textFieldSelectionManager222222.setOffsetMapping$foundation_release(offsetMapping222222);
        textFieldSelectionManager222222.setVisualTransformation$foundation_release(visualTransformation2);
        textFieldSelectionManager222222.setOnValueChange$foundation_release(legacyTextFieldState.getOnValueChange());
        textFieldSelectionManager222222.setState$foundation_release(legacyTextFieldState);
        textFieldSelectionManager222222.setValue$foundation_release(textFieldValue);
        textFieldSelectionManager222222.setClipboardManager$foundation_release((ClipboardManager) startRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
        textFieldSelectionManager222222.setTextToolbar((TextToolbar) startRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
        textFieldSelectionManager222222.setHapticFeedBack((HapticFeedback) startRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
        textFieldSelectionManager222222.setFocusRequester(focusRequester222222);
        textFieldSelectionManager222222.setEditable(!z10);
        textFieldSelectionManager222222.setEnabled(z8);
        rememberedValue8 = startRestartGroup.rememberedValue();
        if (rememberedValue8 == companion.getEmpty()) {
        }
        final CoroutineScope coroutineScope222222 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue8).getCoroutineScope();
        rememberedValue9 = startRestartGroup.rememberedValue();
        if (rememberedValue9 == companion.getEmpty()) {
        }
        final BringIntoViewRequester bringIntoViewRequester222222 = (BringIntoViewRequester) rememberedValue9;
        Modifier.Companion companion2222222 = Modifier.INSTANCE;
        int i38222222 = i20 & 7168;
        final VisualTransformation visualTransformation4222222 = visualTransformation2;
        int i39222222 = i20 & 57344;
        boolean changedInstance10222222 = startRestartGroup.changedInstance(legacyTextFieldState) | (i38222222 == 2048) | (i39222222 == 16384) | startRestartGroup.changedInstance(textInputService222222) | (i37222222 == 4);
        i27 = (i20 & 112) ^ 48;
        if (i27 > 32) {
        }
        i28 = i39222222;
        i29 = i20;
        if ((i20 & 48) != 32) {
        }
        z12 = true;
        changedInstance = changedInstance10222222 | z12 | startRestartGroup.changedInstance(offsetMapping222222) | startRestartGroup.changedInstance(coroutineScope222222) | startRestartGroup.changedInstance(bringIntoViewRequester222222) | startRestartGroup.changedInstance(textFieldSelectionManager222222);
        rememberedValue10 = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        final boolean z2022222222 = z8;
        final boolean z2122222222 = z10;
        final ImeOptions imeOptions722222222 = imeOptions5;
        rememberedValue10 = new Function1<FocusState, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$focusModifier$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                invoke2(focusState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FocusState focusState) {
                TextLayoutResultProxy layoutResult;
                if (LegacyTextFieldState.this.getHasFocus() == focusState.isFocused()) {
                    return;
                }
                LegacyTextFieldState.this.setHasFocus(focusState.isFocused());
                if (LegacyTextFieldState.this.getHasFocus() && z2022222222 && !z2122222222) {
                    CoreTextFieldKt.startInputSession(textInputService222222, LegacyTextFieldState.this, textFieldValue, imeOptions722222222, offsetMapping222222);
                } else {
                    CoreTextFieldKt.endInputSession(LegacyTextFieldState.this);
                }
                if (focusState.isFocused() && (layoutResult = LegacyTextFieldState.this.getLayoutResult()) != null) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope222222, null, null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(bringIntoViewRequester222222, textFieldValue, LegacyTextFieldState.this, layoutResult, offsetMapping222222, null), 3, null);
                }
                if (focusState.isFocused()) {
                    return;
                }
                TextFieldSelectionManager.m640deselect_kEHs6E$foundation_release$default(textFieldSelectionManager222222, null, 1, null);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue10);
        MutableInteractionSource mutableInteractionSource722222222 = mutableInteractionSource3;
        textFieldFocusModifier = TextFieldGestureModifiersKt.textFieldFocusModifier(companion2222222, z8, focusRequester222222, mutableInteractionSource722222222, (Function1) rememberedValue10);
        State rememberUpdatedState22222222 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf((z8 || z10) ? false : true), startRestartGroup, 0);
        Unit unit22222222 = Unit.INSTANCE;
        boolean changed322222222 = startRestartGroup.changed(rememberUpdatedState22222222) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService222222) | startRestartGroup.changedInstance(textFieldSelectionManager222222);
        if (i27 > 32) {
        }
        modifier4 = textFieldFocusModifier;
        if ((i29 & 48) != 32) {
        }
        z13 = true;
        z14 = changed322222222 | z13;
        rememberedValue11 = startRestartGroup.rememberedValue();
        if (!z14) {
        }
        rememberedValue11 = new CoreTextFieldKt$CoreTextField$2$1(legacyTextFieldState, rememberUpdatedState22222222, textInputService222222, textFieldSelectionManager222222, imeOptions5, null);
        startRestartGroup.updateRememberedValue(rememberedValue11);
        EffectsKt.LaunchedEffect(unit22222222, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue11, startRestartGroup, 6);
        changedInstance2 = startRestartGroup.changedInstance(legacyTextFieldState);
        rememberedValue12 = startRestartGroup.rememberedValue();
        if (!changedInstance2) {
        }
        rememberedValue12 = new Function1<Boolean, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z22222222222) {
                LegacyTextFieldState.this.setInTouchMode(z22222222222);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue12);
        Modifier updateSelectionTouchMode222222222 = SelectionGesturesKt.updateSelectionTouchMode(companion2222222, (Function1) rememberedValue12);
        int i40222222222 = i28;
        changedInstance3 = startRestartGroup.changedInstance(legacyTextFieldState) | (i40222222222 != 16384) | (i38222222 != 2048) | startRestartGroup.changedInstance(offsetMapping222222) | startRestartGroup.changedInstance(textFieldSelectionManager222222);
        rememberedValue13 = startRestartGroup.rememberedValue();
        if (!changedInstance3) {
        }
        final boolean z22222222222 = z10;
        final boolean z23222222222 = z8;
        rememberedValue13 = new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$pointerModifier$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Offset offset) {
                m473invokek4lQ0M(offset.getPackedValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-k-4lQ0M, reason: not valid java name */
            public final void m473invokek4lQ0M(long j5) {
                CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester222222, !z22222222222);
                if (LegacyTextFieldState.this.getHasFocus() && z23222222222) {
                    if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                        textFieldSelectionManager222222.m643deselect_kEHs6E$foundation_release(Offset.m1328boximpl(j5));
                        return;
                    }
                    TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                    if (layoutResult != null) {
                        LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                        TextFieldDelegate.INSTANCE.m532setCursorOffsetULxng0E$foundation_release(j5, layoutResult, legacyTextFieldState2.getProcessor(), offsetMapping222222, legacyTextFieldState2.getOnValueChange());
                        if (legacyTextFieldState2.getTextDelegate().getText().length() > 0) {
                            legacyTextFieldState2.setHandleState(HandleState.Cursor);
                        }
                    }
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue13);
        Modifier pointerHoverIcon$default222222222 = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(updateSelectionTouchMode222222222, mutableInteractionSource722222222, z8, (Function1) rememberedValue13), textFieldSelectionManager222222.getMouseSelectionObserver(), textFieldSelectionManager222222.getTouchSelectionObserver()), TextPointerIcon_androidKt.getTextPointerIcon(), false, 2, null);
        changedInstance4 = startRestartGroup.changedInstance(legacyTextFieldState) | (i37222222 != 4) | startRestartGroup.changedInstance(offsetMapping222222);
        rememberedValue14 = startRestartGroup.rememberedValue();
        if (!changedInstance4) {
        }
        rememberedValue14 = new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$drawModifier$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawScope) {
                TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                if (layoutResult != null) {
                    TextFieldValue textFieldValue2 = textFieldValue;
                    LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                    OffsetMapping offsetMapping2222222 = offsetMapping222222;
                    TextFieldDelegate.INSTANCE.m530drawQ1vqE60$foundation_release(drawScope.getDrawContext().getCanvas(), textFieldValue2, legacyTextFieldState2.m488getSelectionPreviewHighlightRanged9O1mEE(), legacyTextFieldState2.m485getDeletionPreviewHighlightRanged9O1mEE(), offsetMapping2222222, layoutResult.getValue(), legacyTextFieldState2.getHighlightPaint(), legacyTextFieldState2.getSelectionBackgroundColor());
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue14);
        final Modifier drawBehind222222222 = DrawModifierKt.drawBehind(companion2222222, (Function1) rememberedValue14);
        changedInstance5 = startRestartGroup.changedInstance(legacyTextFieldState) | (i38222222 != 2048) | startRestartGroup.changed(windowInfo) | startRestartGroup.changedInstance(textFieldSelectionManager222222) | (i37222222 != 4) | startRestartGroup.changedInstance(offsetMapping222222);
        rememberedValue15 = startRestartGroup.rememberedValue();
        if (!changedInstance5) {
        }
        final boolean z24222222222 = z8;
        rememberedValue15 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$onPositionedModifier$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                invoke2(layoutCoordinates);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutCoordinates layoutCoordinates) {
                LegacyTextFieldState.this.setLayoutCoordinates(layoutCoordinates);
                TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                if (layoutResult != null) {
                    layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
                }
                if (z24222222222) {
                    if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection) {
                        if (LegacyTextFieldState.this.getShowFloatingToolbar() && windowInfo.isWindowFocused()) {
                            textFieldSelectionManager222222.showSelectionToolbar$foundation_release();
                        } else {
                            textFieldSelectionManager222222.hideSelectionToolbar$foundation_release();
                        }
                        LegacyTextFieldState.this.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager222222, true));
                        LegacyTextFieldState.this.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager222222, false));
                        LegacyTextFieldState.this.setShowCursorHandle(TextRange.m2279getCollapsedimpl(textFieldValue.getSelection()));
                    } else if (LegacyTextFieldState.this.getHandleState() == HandleState.Cursor) {
                        LegacyTextFieldState.this.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager222222, true));
                    }
                    CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue, offsetMapping222222);
                    TextLayoutResultProxy layoutResult2 = LegacyTextFieldState.this.getLayoutResult();
                    if (layoutResult2 != null) {
                        LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                        TextFieldValue textFieldValue2 = textFieldValue;
                        OffsetMapping offsetMapping2222222 = offsetMapping222222;
                        TextInputSession inputSession = legacyTextFieldState2.getInputSession();
                        if (inputSession == null || !legacyTextFieldState2.getHasFocus()) {
                            return;
                        }
                        TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation_release(inputSession, textFieldValue2, offsetMapping2222222, layoutResult2);
                    }
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue15);
        final Modifier onGloballyPositioned322222222 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion2222222, (Function1) rememberedValue15);
        final boolean z25222222222 = visualTransformation4222222 instanceof PasswordVisualTransformation;
        changedInstance6 = (i38222222 != 2048) | startRestartGroup.changedInstance(transformedText222222) | (i37222222 != 4) | startRestartGroup.changed(z25222222222) | (i40222222222 != 16384) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(offsetMapping222222) | startRestartGroup.changedInstance(textFieldSelectionManager222222) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32);
        rememberedValue16 = startRestartGroup.rememberedValue();
        if (!changedInstance6) {
        }
        final boolean z26222222222 = z8;
        final boolean z27222222222 = z10;
        final ImeOptions imeOptions8222222222 = imeOptions5;
        rememberedValue16 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, TransformedText.this.getText());
                SemanticsPropertiesKt.m2185setTextSelectionRangeFDrldGo(semanticsPropertyReceiver, textFieldValue.getSelection());
                if (!z26222222222) {
                    SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
                }
                if (z25222222222) {
                    SemanticsPropertiesKt.password(semanticsPropertyReceiver);
                }
                boolean z282 = z26222222222 && !z27222222222;
                SemanticsPropertiesKt.setEditable(semanticsPropertyReceiver, z282);
                final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, null, new Function1<List<TextLayoutResult>, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(List<TextLayoutResult> list) {
                        boolean z29222222222;
                        if (LegacyTextFieldState.this.getLayoutResult() != null) {
                            TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                            Intrinsics.checkNotNull(layoutResult);
                            list.add(layoutResult.getValue());
                            z29222222222 = true;
                        } else {
                            z29222222222 = false;
                        }
                        return Boolean.valueOf(z29222222222);
                    }
                }, 1, null);
                if (z282) {
                    final LegacyTextFieldState legacyTextFieldState3 = legacyTextFieldState;
                    SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(AnnotatedString annotatedString) {
                            Unit unit222222222;
                            TextInputSession inputSession = LegacyTextFieldState.this.getInputSession();
                            if (inputSession != null) {
                                LegacyTextFieldState legacyTextFieldState4 = LegacyTextFieldState.this;
                                TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new DeleteAllCommand(), new CommitTextCommand(annotatedString, 1)}), legacyTextFieldState4.getProcessor(), legacyTextFieldState4.getOnValueChange(), inputSession);
                                unit222222222 = Unit.INSTANCE;
                            } else {
                                unit222222222 = null;
                            }
                            if (unit222222222 == null) {
                                LegacyTextFieldState.this.getOnValueChange().invoke(new TextFieldValue(annotatedString.getText(), TextRangeKt.TextRange(annotatedString.getText().length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                            }
                            return Boolean.TRUE;
                        }
                    }, 1, null);
                    final boolean z29222222222 = z27222222222;
                    final boolean z30222222222 = z26222222222;
                    final LegacyTextFieldState legacyTextFieldState4 = legacyTextFieldState;
                    final TextFieldValue textFieldValue2 = textFieldValue;
                    SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, null, new Function1<AnnotatedString, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(AnnotatedString annotatedString) {
                            Unit unit222222222;
                            if (!z29222222222 && z30222222222) {
                                TextInputSession inputSession = legacyTextFieldState4.getInputSession();
                                if (inputSession != null) {
                                    LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                    TextFieldDelegate.INSTANCE.onEditCommand$foundation_release(CollectionsKt.listOf((Object[]) new EditCommand[]{new FinishComposingTextCommand(), new CommitTextCommand(annotatedString, 1)}), legacyTextFieldState5.getProcessor(), legacyTextFieldState5.getOnValueChange(), inputSession);
                                    unit222222222 = Unit.INSTANCE;
                                } else {
                                    unit222222222 = null;
                                }
                                if (unit222222222 == null) {
                                    TextFieldValue textFieldValue3 = textFieldValue2;
                                    legacyTextFieldState4.getOnValueChange().invoke(new TextFieldValue(StringsKt.replaceRange(textFieldValue3.getText(), TextRange.m2285getStartimpl(textFieldValue3.getSelection()), TextRange.m2280getEndimpl(textFieldValue3.getSelection()), annotatedString).toString(), TextRangeKt.TextRange(TextRange.m2285getStartimpl(textFieldValue3.getSelection()) + annotatedString.length()), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                }
                                return Boolean.TRUE;
                            }
                            return Boolean.FALSE;
                        }
                    }, 1, null);
                }
                final OffsetMapping offsetMapping2222222 = offsetMapping222222;
                final boolean z31222222222 = z26222222222;
                final TextFieldValue textFieldValue3 = textFieldValue;
                final TextFieldSelectionManager textFieldSelectionManager2222222 = textFieldSelectionManager222222;
                final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState;
                SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, null, new Function3<Integer, Integer, Boolean, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Boolean invoke(Integer num, Integer num2, Boolean bool) {
                        return invoke(num.intValue(), num2.intValue(), bool.booleanValue());
                    }

                    public final Boolean invoke(int i41222222222, int i42, boolean z32) {
                        if (!z32) {
                            i41222222222 = OffsetMapping.this.transformedToOriginal(i41222222222);
                        }
                        if (!z32) {
                            i42 = OffsetMapping.this.transformedToOriginal(i42);
                        }
                        boolean z33 = false;
                        if (z31222222222 && (i41222222222 != TextRange.m2285getStartimpl(textFieldValue3.getSelection()) || i42 != TextRange.m2280getEndimpl(textFieldValue3.getSelection()))) {
                            if (Math.min(i41222222222, i42) >= 0 && Math.max(i41222222222, i42) <= textFieldValue3.getText().length()) {
                                if (!z32 && i41222222222 != i42) {
                                    TextFieldSelectionManager.enterSelectionMode$foundation_release$default(textFieldSelectionManager2222222, false, 1, null);
                                } else {
                                    textFieldSelectionManager2222222.exitSelectionMode$foundation_release();
                                }
                                legacyTextFieldState5.getOnValueChange().invoke(new TextFieldValue(textFieldValue3.getText(), TextRangeKt.TextRange(i41222222222, i42), (TextRange) null, 4, (DefaultConstructorMarker) null));
                                z33 = true;
                            } else {
                                textFieldSelectionManager2222222.exitSelectionMode$foundation_release();
                            }
                        }
                        return Boolean.valueOf(z33);
                    }
                }, 1, null);
                int imeAction = imeOptions8222222222.getImeAction();
                final LegacyTextFieldState legacyTextFieldState6 = legacyTextFieldState;
                final ImeOptions imeOptions9222222222 = imeOptions8222222222;
                SemanticsPropertiesKt.m2182onImeAction9UiTYpY$default(semanticsPropertyReceiver, imeAction, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        LegacyTextFieldState.this.getOnImeActionPerformed().invoke(ImeAction.m2375boximpl(imeOptions9222222222.getImeAction()));
                        return Boolean.TRUE;
                    }
                }, 2, null);
                final LegacyTextFieldState legacyTextFieldState7 = legacyTextFieldState;
                final FocusRequester focusRequester2222222 = focusRequester222222;
                final boolean z32 = z27222222222;
                SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        CoreTextFieldKt.tapToFocus(LegacyTextFieldState.this, focusRequester2222222, !z32);
                        return Boolean.TRUE;
                    }
                }, 1, null);
                final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager222222;
                SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.7
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        TextFieldSelectionManager.enterSelectionMode$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                        return Boolean.TRUE;
                    }
                }, 1, null);
                if (!TextRange.m2279getCollapsedimpl(textFieldValue.getSelection()) && !z25222222222) {
                    final TextFieldSelectionManager textFieldSelectionManager4 = textFieldSelectionManager222222;
                    SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.8
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            TextFieldSelectionManager.copy$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                            return Boolean.TRUE;
                        }
                    }, 1, null);
                    if (z26222222222 && !z27222222222) {
                        final TextFieldSelectionManager textFieldSelectionManager5 = textFieldSelectionManager222222;
                        SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.9
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                TextFieldSelectionManager.this.cut$foundation_release();
                                return Boolean.TRUE;
                            }
                        }, 1, null);
                    }
                }
                if (!z26222222222 || z27222222222) {
                    return;
                }
                final TextFieldSelectionManager textFieldSelectionManager6 = textFieldSelectionManager222222;
                SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$semanticsModifier$1$1.10
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        TextFieldSelectionManager.this.paste$foundation_release();
                        return Boolean.TRUE;
                    }
                }, 1, null);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue16);
        Modifier semantics222222222 = SemanticsModifierKt.semantics(companion2222222, true, (Function1) rememberedValue16);
        final Modifier cursor222222222 = TextFieldCursorKt.cursor(companion2222222, legacyTextFieldState, textFieldValue, offsetMapping222222, brush3, (z8 || z10 || !windowInfo.isWindowFocused() || legacyTextFieldState.hasHighlight()) ? false : true);
        changedInstance7 = startRestartGroup.changedInstance(textFieldSelectionManager222222);
        rememberedValue17 = startRestartGroup.rememberedValue();
        if (!changedInstance7) {
        }
        rememberedValue17 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                final TextFieldSelectionManager textFieldSelectionManager2222222 = TextFieldSelectionManager.this;
                return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$3$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                    }
                };
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue17);
        EffectsKt.DisposableEffect(textFieldSelectionManager222222, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue17, startRestartGroup, 0);
        changedInstance8 = (i37222222 != 4) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService222222) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32);
        rememberedValue18 = startRestartGroup.rememberedValue();
        if (!changedInstance8) {
        }
        rememberedValue18 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                if (LegacyTextFieldState.this.getHasFocus()) {
                    LegacyTextFieldState legacyTextFieldState2 = LegacyTextFieldState.this;
                    legacyTextFieldState2.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(textInputService222222, textFieldValue, legacyTextFieldState2.getProcessor(), imeOptions5, LegacyTextFieldState.this.getOnValueChange(), LegacyTextFieldState.this.getOnImeActionPerformed()));
                }
                return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$4$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                    }
                };
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue18);
        EffectsKt.DisposableEffect(imeOptions5, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue18, startRestartGroup, (i29 >> 3) & 14);
        Modifier m539textFieldKeyInput2WJ9YEU222222222 = TextFieldKeyInputKt.m539textFieldKeyInput2WJ9YEU(companion2222222, legacyTextFieldState, textFieldSelectionManager222222, textFieldValue, legacyTextFieldState.getOnValueChange(), !z10, i36222222 != 1, offsetMapping222222, undoManager222222, imeOptions5.getImeAction());
        boolean CoreTextField$lambda$11222222222 = CoreTextField$lambda$11(rememberUpdatedState22222222);
        changedInstance9 = startRestartGroup.changedInstance(legacyTextFieldState) | ((i27 <= 32 && startRestartGroup.changed(imeOptions5)) || (i29 & 48) == 32) | startRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter222222);
        rememberedValue19 = startRestartGroup.rememberedValue();
        if (!changedInstance9) {
        }
        rememberedValue19 = new Function0<Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$stylusHandwritingModifier$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                if (!LegacyTextFieldState.this.getHasFocus()) {
                    focusRequester222222.requestFocus();
                }
                int keyboardType = imeOptions5.getKeyboardType();
                KeyboardType.Companion companion3 = KeyboardType.INSTANCE;
                if (!KeyboardType.m2410equalsimpl0(keyboardType, companion3.m2419getPasswordPjHm6EE()) && !KeyboardType.m2410equalsimpl0(imeOptions5.getKeyboardType(), companion3.m2418getNumberPasswordPjHm6EE())) {
                    legacyPlatformTextInputServiceAdapter222222.startStylusHandwriting();
                }
                return Boolean.TRUE;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue19);
        Modifier onGloballyPositioned2222222222 = OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier7222222, legacyPlatformTextInputServiceAdapter222222, legacyTextFieldState, textFieldSelectionManager222222).then(StylusHandwritingKt.stylusHandwriting(companion2222222, CoreTextField$lambda$11222222222, (Function0) rememberedValue19)).then(modifier4), legacyTextFieldState, focusManager222222), legacyTextFieldState, textFieldSelectionManager222222).then(m539textFieldKeyInput2WJ9YEU222222222), textFieldScrollerPosition222222, mutableInteractionSource722222222, z8).then(pointerHoverIcon$default222222222).then(semantics222222222), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                invoke2(layoutCoordinates);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutCoordinates layoutCoordinates) {
                TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                if (layoutResult == null) {
                    return;
                }
                layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
            }
        });
        if (z8) {
        }
        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function34222222222 = function32;
        final TextStyle textStyle5222222222 = textStyle2;
        final int i41222222222 = i25;
        boolean z29222222222 = z8;
        ImeOptions imeOptions9222222222 = imeOptions5;
        final Modifier textFieldMagnifier222222222 = !z28 ? TextFieldSelectionManager_androidKt.textFieldMagnifier(companion2222222, textFieldSelectionManager222222) : companion2222222;
        final boolean z30222222222 = z28;
        final boolean z31222222222 = z10;
        final Function1<? super TextLayoutResult, Unit> function16222222222 = function13;
        composer2 = startRestartGroup;
        CoreTextFieldRootBox(onGloballyPositioned2222222222, textFieldSelectionManager222222, ComposableLambdaKt.rememberComposableLambda(-374338080, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i42) {
                if ((i42 & 3) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-374338080, i42, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:695)");
                }
                Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function35 = function34222222222;
                final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                final TextStyle textStyle6 = textStyle5222222222;
                final int i43 = i41222222222;
                final int i44 = i36222222;
                final TextFieldScrollerPosition textFieldScrollerPosition2222222 = textFieldScrollerPosition222222;
                final TextFieldValue textFieldValue2 = textFieldValue;
                final VisualTransformation visualTransformation5 = visualTransformation4222222;
                final Modifier modifier8 = cursor222222222;
                final Modifier modifier9 = drawBehind222222222;
                final Modifier modifier10 = onGloballyPositioned322222222;
                final Modifier modifier11 = textFieldMagnifier222222222;
                final BringIntoViewRequester bringIntoViewRequester2222222 = bringIntoViewRequester222222;
                final TextFieldSelectionManager textFieldSelectionManager2222222 = textFieldSelectionManager222222;
                final boolean z32 = z30222222222;
                final boolean z33 = z31222222222;
                final Function1<? super TextLayoutResult, Unit> function17 = function16222222222;
                final OffsetMapping offsetMapping2222222 = offsetMapping222222;
                final Density density2222222 = density222222;
                function35.invoke(ComposableLambdaKt.rememberComposableLambda(2032502107, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                        invoke(composer4, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer4, int i45) {
                        if ((i45 & 3) == 2 && composer4.getSkipping()) {
                            composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2032502107, i45, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:698)");
                        }
                        Modifier heightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m327heightInVpY3zN4$default(Modifier.INSTANCE, LegacyTextFieldState.this.m486getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle6, i43, i44);
                        TextFieldScrollerPosition textFieldScrollerPosition3 = textFieldScrollerPosition2222222;
                        TextFieldValue textFieldValue3 = textFieldValue2;
                        VisualTransformation visualTransformation6 = visualTransformation5;
                        boolean changedInstance11 = composer4.changedInstance(LegacyTextFieldState.this);
                        final LegacyTextFieldState legacyTextFieldState3 = LegacyTextFieldState.this;
                        Object rememberedValue21 = composer4.rememberedValue();
                        if (changedInstance11 || rememberedValue21 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue21 = new Function0<TextLayoutResultProxy>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$coreTextFieldModifier$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final TextLayoutResultProxy invoke() {
                                    return LegacyTextFieldState.this.getLayoutResult();
                                }
                            };
                            composer4.updateRememberedValue(rememberedValue21);
                        }
                        Modifier bringIntoViewRequester3 = BringIntoViewRequesterKt.bringIntoViewRequester(TextFieldSizeKt.textFieldMinSize(TextFieldScrollKt.textFieldScroll(heightInLines, textFieldScrollerPosition3, textFieldValue3, visualTransformation6, (Function0) rememberedValue21).then(modifier8).then(modifier9), textStyle6).then(modifier10).then(modifier11), bringIntoViewRequester2222222);
                        final TextFieldSelectionManager textFieldSelectionManager3 = textFieldSelectionManager2222222;
                        final LegacyTextFieldState legacyTextFieldState4 = LegacyTextFieldState.this;
                        final boolean z34 = z32;
                        final boolean z35 = z33;
                        final Function1<? super TextLayoutResult, Unit> function18 = function17;
                        final TextFieldValue textFieldValue4 = textFieldValue2;
                        final OffsetMapping offsetMapping3 = offsetMapping2222222;
                        final Density density3 = density2222222;
                        final int i46 = i44;
                        SimpleLayoutKt.SimpleLayout(bringIntoViewRequester3, ComposableLambdaKt.rememberComposableLambda(-363167407, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                invoke(composer5, num.intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:39:0x00ff  */
                            /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final void invoke(Composer composer5, int i47) {
                                boolean z36;
                                if ((i47 & 3) == 2 && composer5.getSkipping()) {
                                    composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-363167407, i47, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous>.<anonymous> (CoreTextField.kt:721)");
                                }
                                final LegacyTextFieldState legacyTextFieldState5 = legacyTextFieldState4;
                                final Function1<? super TextLayoutResult, Unit> function19 = function18;
                                final TextFieldValue textFieldValue5 = textFieldValue4;
                                final OffsetMapping offsetMapping4 = offsetMapping3;
                                final Density density4 = density3;
                                final int i48 = i46;
                                MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt.CoreTextField.5.1.1.2
                                    @Override // androidx.compose.ui.layout.MeasurePolicy
                                    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i49) {
                                        LegacyTextFieldState.this.getTextDelegate().layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                                        return LegacyTextFieldState.this.getTextDelegate().getMaxIntrinsicWidth();
                                    }

                                    @Override // androidx.compose.ui.layout.MeasurePolicy
                                    /* renamed from: measure-3p2s80s */
                                    public MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                                        Snapshot.Companion companion3 = Snapshot.INSTANCE;
                                        LegacyTextFieldState legacyTextFieldState6 = LegacyTextFieldState.this;
                                        Snapshot currentThreadSnapshot = companion3.getCurrentThreadSnapshot();
                                        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                        Snapshot makeCurrentNonObservable = companion3.makeCurrentNonObservable(currentThreadSnapshot);
                                        try {
                                            TextLayoutResultProxy layoutResult = legacyTextFieldState6.getLayoutResult();
                                            TextLayoutResult value = layoutResult != null ? layoutResult.getValue() : null;
                                            Triple<Integer, Integer, TextLayoutResult> m531layout_EkL_Y$foundation_release = TextFieldDelegate.INSTANCE.m531layout_EkL_Y$foundation_release(LegacyTextFieldState.this.getTextDelegate(), j5, measureScope.getLayoutDirection(), value);
                                            int intValue = m531layout_EkL_Y$foundation_release.component1().intValue();
                                            int intValue2 = m531layout_EkL_Y$foundation_release.component2().intValue();
                                            TextLayoutResult component3 = m531layout_EkL_Y$foundation_release.component3();
                                            if (!Intrinsics.areEqual(value, component3)) {
                                                LegacyTextFieldState.this.setLayoutResult(new TextLayoutResultProxy(component3, null, layoutResult != null ? layoutResult.getDecorationBoxCoordinates() : null, 2, null));
                                                function19.invoke(component3);
                                                CoreTextFieldKt.notifyFocusedRect(LegacyTextFieldState.this, textFieldValue5, offsetMapping4);
                                            }
                                            LegacyTextFieldState.this.m490setMinHeightForSingleLineField0680j_4(density4.mo209toDpu2uoSUM(i48 == 1 ? TextDelegateKt.ceilToIntPx(component3.getLineBottom(0)) : 0));
                                            return measureScope.layout(intValue, intValue2, MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(Math.round(component3.getFirstBaseline()))), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(Math.round(component3.getLastBaseline())))), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1$2$measure$2
                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                    invoke2(placementScope);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                        } finally {
                                            companion3.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                                        }
                                    }
                                };
                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer5, companion3);
                                ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
                                Function0<ComposeUiNode> constructor = companion4.getConstructor();
                                if (composer5.getApplier() == null) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer5.startReusableNode();
                                if (composer5.getInserting()) {
                                    composer5.createNode(constructor);
                                } else {
                                    composer5.useNode();
                                }
                                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer5);
                                Updater.m1227setimpl(m1226constructorimpl, measurePolicy, companion4.getSetMeasurePolicy());
                                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
                                composer5.endNode();
                                TextFieldSelectionManager textFieldSelectionManager4 = TextFieldSelectionManager.this;
                                if (legacyTextFieldState4.getHandleState() != HandleState.None && legacyTextFieldState4.getLayoutCoordinates() != null) {
                                    LayoutCoordinates layoutCoordinates = legacyTextFieldState4.getLayoutCoordinates();
                                    Intrinsics.checkNotNull(layoutCoordinates);
                                    if (layoutCoordinates.isAttached() && z34) {
                                        z36 = true;
                                        CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z36, composer5, 0);
                                        if (legacyTextFieldState4.getHandleState() != HandleState.Cursor && !z35 && z34) {
                                            composer5.startReplaceGroup(-2032274);
                                            CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer5, 0);
                                            composer5.endReplaceGroup();
                                        } else {
                                            composer5.startReplaceGroup(-1955394);
                                            composer5.endReplaceGroup();
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            return;
                                        }
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                }
                                z36 = false;
                                CoreTextFieldKt.SelectionToolbarAndHandles(textFieldSelectionManager4, z36, composer5, 0);
                                if (legacyTextFieldState4.getHandleState() != HandleState.Cursor) {
                                }
                                composer5.startReplaceGroup(-1955394);
                                composer5.endReplaceGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                            }
                        }, composer4, 54), composer4, 48, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composer3, 54), composer3, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composer2, 54), composer2, 384);
        if (ComposerKt.isTraceInProgress()) {
        }
        textStyle3 = textStyle2;
        function14 = function13;
        visualTransformation3 = visualTransformation4222222;
        modifier5 = modifier7222222;
        brush4 = brush3;
        z15 = z9;
        i30 = i25;
        z16 = z29222222222;
        keyboardActions3 = keyboardActions2;
        imeOptions6 = imeOptions9222222222;
        i31 = i36222222;
        mutableInteractionSource4 = mutableInteractionSource722222222;
        z17 = z10;
        function33 = function32;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CoreTextField$lambda$11(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CoreTextFieldRootBox(final Modifier modifier, final TextFieldSelectionManager textFieldSelectionManager, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-20551815);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(textFieldSelectionManager) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-20551815, i6, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:801)");
            }
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ContextMenu_androidKt.ContextMenuArea(textFieldSelectionManager, function2, startRestartGroup, (i6 >> 3) & 126);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextFieldRootBox$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    CoreTextFieldKt.CoreTextFieldRootBox(Modifier.this, textFieldSelectionManager, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelectionToolbarAndHandles(final TextFieldSelectionManager textFieldSelectionManager, final boolean z5, Composer composer, final int i5) {
        int i6;
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        Composer startRestartGroup = composer.startRestartGroup(626339208);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(626339208, i6, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1146)");
            }
            if (z5) {
                startRestartGroup.startReplaceGroup(-1286242594);
                LegacyTextFieldState state = textFieldSelectionManager.getState();
                TextLayoutResult textLayoutResult = null;
                if (state != null && (layoutResult = state.getLayoutResult()) != null && (value = layoutResult.getValue()) != null) {
                    LegacyTextFieldState state2 = textFieldSelectionManager.getState();
                    if (!(state2 != null ? state2.getIsLayoutResultStale() : true)) {
                        textLayoutResult = value;
                    }
                }
                if (textLayoutResult == null) {
                    startRestartGroup.startReplaceGroup(-1285984396);
                } else {
                    startRestartGroup.startReplaceGroup(-1285984395);
                    if (TextRange.m2279getCollapsedimpl(textFieldSelectionManager.getValue$foundation_release().getSelection())) {
                        startRestartGroup.startReplaceGroup(-1679637798);
                        startRestartGroup.endReplaceGroup();
                    } else {
                        startRestartGroup.startReplaceGroup(-1680616096);
                        int originalToTransformed = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.m2285getStartimpl(textFieldSelectionManager.getValue$foundation_release().getSelection()));
                        int originalToTransformed2 = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.m2280getEndimpl(textFieldSelectionManager.getValue$foundation_release().getSelection()));
                        ResolvedTextDirection bidiRunDirection = textLayoutResult.getBidiRunDirection(originalToTransformed);
                        ResolvedTextDirection bidiRunDirection2 = textLayoutResult.getBidiRunDirection(Math.max(originalToTransformed2 - 1, 0));
                        LegacyTextFieldState state3 = textFieldSelectionManager.getState();
                        if (state3 == null || !state3.getShowSelectionHandleStart()) {
                            startRestartGroup.startReplaceGroup(-1679975078);
                            startRestartGroup.endReplaceGroup();
                        } else {
                            startRestartGroup.startReplaceGroup(-1680216289);
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, bidiRunDirection, textFieldSelectionManager, startRestartGroup, ((i6 << 6) & 896) | 6);
                            startRestartGroup.endReplaceGroup();
                        }
                        LegacyTextFieldState state4 = textFieldSelectionManager.getState();
                        if (state4 == null || !state4.getShowSelectionHandleEnd()) {
                            startRestartGroup.startReplaceGroup(-1679655654);
                            startRestartGroup.endReplaceGroup();
                        } else {
                            startRestartGroup.startReplaceGroup(-1679895904);
                            TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, bidiRunDirection2, textFieldSelectionManager, startRestartGroup, ((i6 << 6) & 896) | 6);
                            startRestartGroup.endReplaceGroup();
                        }
                        startRestartGroup.endReplaceGroup();
                    }
                    LegacyTextFieldState state5 = textFieldSelectionManager.getState();
                    if (state5 != null) {
                        if (textFieldSelectionManager.isTextChanged$foundation_release()) {
                            state5.setShowFloatingToolbar(false);
                        }
                        if (state5.getHasFocus()) {
                            if (state5.getShowFloatingToolbar()) {
                                textFieldSelectionManager.showSelectionToolbar$foundation_release();
                            } else {
                                textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                startRestartGroup.endReplaceGroup();
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(651305535);
                startRestartGroup.endReplaceGroup();
                textFieldSelectionManager.hideSelectionToolbar$foundation_release();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$SelectionToolbarAndHandles$2
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

                public final void invoke(Composer composer2, int i7) {
                    CoreTextFieldKt.SelectionToolbarAndHandles(TextFieldSelectionManager.this, z5, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    public static final void TextFieldCursorHandle(final TextFieldSelectionManager textFieldSelectionManager, Composer composer, final int i5) {
        int i6;
        AnnotatedString transformedText$foundation_release;
        Composer startRestartGroup = composer.startRestartGroup(-1436003720);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1436003720, i6, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1189)");
            }
            LegacyTextFieldState state = textFieldSelectionManager.getState();
            if (state == null || !state.getShowCursorHandle() || (transformedText$foundation_release = textFieldSelectionManager.getTransformedText$foundation_release()) == null || transformedText$foundation_release.length() <= 0) {
                startRestartGroup.startReplaceGroup(-284257090);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-285446808);
                boolean changed = startRestartGroup.changed(textFieldSelectionManager);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = textFieldSelectionManager.cursorDragObserver$foundation_release();
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                TextDragObserver textDragObserver = (TextDragObserver) rememberedValue;
                final long m645getCursorPositiontuRUvjQ$foundation_release = textFieldSelectionManager.m645getCursorPositiontuRUvjQ$foundation_release((Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity()));
                boolean changed2 = startRestartGroup.changed(m645getCursorPositiontuRUvjQ$foundation_release);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new OffsetProvider() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* renamed from: provide-F1C5BW0, reason: not valid java name */
                        public final long mo474provideF1C5BW0() {
                            return m645getCursorPositiontuRUvjQ$foundation_release;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                OffsetProvider offsetProvider = (OffsetProvider) rememberedValue2;
                Modifier.Companion companion = Modifier.INSTANCE;
                boolean changedInstance = startRestartGroup.changedInstance(textDragObserver) | startRestartGroup.changedInstance(textFieldSelectionManager);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new CoreTextFieldKt$TextFieldCursorHandle$2$1(textDragObserver, textFieldSelectionManager, null);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, textDragObserver, (Function2) rememberedValue3);
                boolean changed3 = startRestartGroup.changed(m645getCursorPositiontuRUvjQ$foundation_release);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$3$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            semanticsPropertyReceiver.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(Handle.Cursor, m645getCursorPositiontuRUvjQ$foundation_release, SelectionHandleAnchor.Middle, true, null));
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                AndroidCursorHandle_androidKt.m463CursorHandleUSBMPiE(offsetProvider, SemanticsModifierKt.semantics$default(pointerInput, false, (Function1) rememberedValue4, 1, null), 0L, startRestartGroup, 0, 4);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$4
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

                public final void invoke(Composer composer2, int i7) {
                    CoreTextFieldKt.TextFieldCursorHandle(TextFieldSelectionManager.this, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    public static final Object bringSelectionEndIntoView(BringIntoViewRequester bringIntoViewRequester, TextFieldValue textFieldValue, TextDelegate textDelegate, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, Continuation<? super Unit> continuation) {
        int originalToTransformed = offsetMapping.originalToTransformed(TextRange.m2282getMaximpl(textFieldValue.getSelection()));
        Object bringIntoView = bringIntoViewRequester.bringIntoView(originalToTransformed < textLayoutResult.getLayoutInput().getText().length() ? textLayoutResult.getBoundingBox(originalToTransformed) : originalToTransformed != 0 ? textLayoutResult.getBoundingBox(originalToTransformed - 1) : new Rect(0.0f, 0.0f, 1.0f, IntSize.m2660getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), null, 0, 24, null))), continuation);
        return bringIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? bringIntoView : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void endInputSession(LegacyTextFieldState legacyTextFieldState) {
        TextInputSession inputSession = legacyTextFieldState.getInputSession();
        if (inputSession != null) {
            TextFieldDelegate.INSTANCE.onBlur$foundation_release(inputSession, legacyTextFieldState.getProcessor(), legacyTextFieldState.getOnValueChange());
        }
        legacyTextFieldState.setInputSession(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyFocusedRect(LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
            if (layoutResult == null) {
                return;
            }
            TextInputSession inputSession = legacyTextFieldState.getInputSession();
            if (inputSession == null) {
                return;
            }
            LayoutCoordinates layoutCoordinates = legacyTextFieldState.getLayoutCoordinates();
            if (layoutCoordinates == null) {
                return;
            }
            TextFieldDelegate.INSTANCE.notifyFocusedRect$foundation_release(textFieldValue, legacyTextFieldState.getTextDelegate(), layoutResult.getValue(), layoutCoordinates, inputSession, legacyTextFieldState.getHasFocus(), offsetMapping);
            Unit unit = Unit.INSTANCE;
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
        }
    }

    private static final Modifier previewKeyEventToDeselectOnBack(Modifier modifier, final LegacyTextFieldState legacyTextFieldState, final TextFieldSelectionManager textFieldSelectionManager) {
        return KeyInputModifierKt.onPreviewKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$previewKeyEventToDeselectOnBack$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m476invokeZmokQxo(keyEvent.getNativeKeyEvent());
            }

            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m476invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean z5;
                if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection && KeyEventHelpers_androidKt.m478cancelsTextSelectionZmokQxo(keyEvent)) {
                    z5 = true;
                    TextFieldSelectionManager.m640deselect_kEHs6E$foundation_release$default(textFieldSelectionManager, null, 1, null);
                } else {
                    z5 = false;
                }
                return Boolean.valueOf(z5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startInputSession(TextInputService textInputService, LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping) {
        legacyTextFieldState.setInputSession(TextFieldDelegate.INSTANCE.onFocus$foundation_release(textInputService, textFieldValue, legacyTextFieldState.getProcessor(), imeOptions, legacyTextFieldState.getOnValueChange(), legacyTextFieldState.getOnImeActionPerformed()));
        notifyFocusedRect(legacyTextFieldState, textFieldValue, offsetMapping);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tapToFocus(LegacyTextFieldState legacyTextFieldState, FocusRequester focusRequester, boolean z5) {
        SoftwareKeyboardController keyboardController;
        if (!legacyTextFieldState.getHasFocus()) {
            focusRequester.requestFocus();
        } else {
            if (!z5 || (keyboardController = legacyTextFieldState.getKeyboardController()) == null) {
                return;
            }
            keyboardController.show();
        }
    }
}
