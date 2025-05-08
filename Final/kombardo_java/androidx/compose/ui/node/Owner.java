package androidx.compose.ui.node;

import android.view.View;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.draganddrop.DragAndDropManager;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.input.pointer.PositionCalculator;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.platform.AccessibilityManager;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000¨\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u0000 ª\u00012\u00020\u0001:\u0004ª\u0001«\u0001J5\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u000eJ\u001a\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H&ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012H&ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0015J\u0019\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\u0004H&¢\u0006\u0004\b\u001b\u0010\u001cJ\"\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001dH&ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J!\u0010!\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b!\u0010\"JE\u0010+\u001a\u00020*2\u001a\u0010&\u001a\u0016\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010%\u0012\u0004\u0012\u00020\b0#2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010%H&¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\bH&¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b/\u0010\u000eJ\u001b\u00103\u001a\u00020\b2\n\u00102\u001a\u000600j\u0002`1H'¢\u0006\u0004\b3\u00104J\u001d\u00106\u001a\u00020\b2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\b0'H&¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\bH&¢\u0006\u0004\b8\u0010.J4\u0010=\u001a\u00020;2\"\u0010<\u001a\u001e\b\u0001\u0012\u0004\u0012\u000209\u0012\n\u0012\b\u0012\u0004\u0012\u00020;0:\u0012\u0006\u0012\u0004\u0018\u0001090#H¦@¢\u0006\u0004\b=\u0010>R\u0014\u0010A\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8&X¦\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8&X¦\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8&X¦\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8&X¦\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8&X¦\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0014\u0010Y\u001a\u00020V8&X¦\u0004¢\u0006\u0006\u001a\u0004\bW\u0010XR\u0014\u0010]\u001a\u00020Z8&X¦\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u001a\u0010b\u001a\u00020^8gX§\u0004¢\u0006\f\u0012\u0004\ba\u0010.\u001a\u0004\b_\u0010`R\u001c\u0010g\u001a\u0004\u0018\u00010c8gX§\u0004¢\u0006\f\u0012\u0004\bf\u0010.\u001a\u0004\bd\u0010eR\u0014\u0010k\u001a\u00020h8&X¦\u0004¢\u0006\u0006\u001a\u0004\bi\u0010jR\u0014\u0010o\u001a\u00020l8&X¦\u0004¢\u0006\u0006\u001a\u0004\bm\u0010nR\u0014\u0010s\u001a\u00020p8&X¦\u0004¢\u0006\u0006\u001a\u0004\bq\u0010rR\u0014\u0010w\u001a\u00020t8&X¦\u0004¢\u0006\u0006\u001a\u0004\bu\u0010vR\u0014\u0010{\u001a\u00020x8&X¦\u0004¢\u0006\u0006\u001a\u0004\by\u0010zR\u0014\u0010\u007f\u001a\u00020|8&X¦\u0004¢\u0006\u0006\u001a\u0004\b}\u0010~R\u001f\u0010\u0084\u0001\u001a\u00030\u0080\u00018&X§\u0004¢\u0006\u000f\u0012\u0005\b\u0083\u0001\u0010.\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0018\u0010\u0088\u0001\u001a\u00030\u0085\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0018\u0010\u008c\u0001\u001a\u00030\u0089\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R)\u0010\u0091\u0001\u001a\u00020\u00042\u0007\u0010\u008d\u0001\u001a\u00020\u00048&@gX¦\u000e¢\u0006\u000f\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0005\b\u0090\u0001\u0010\u001cR\u0018\u0010\u0095\u0001\u001a\u00030\u0092\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0018\u0010\u0099\u0001\u001a\u00030\u0096\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0018\u0010\u009d\u0001\u001a\u00030\u009a\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0018\u0010¡\u0001\u001a\u00030\u009e\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b\u009f\u0001\u0010 \u0001R\u0018\u0010¥\u0001\u001a\u00030¢\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b£\u0001\u0010¤\u0001R\u0018\u0010©\u0001\u001a\u00030¦\u00018&X¦\u0004¢\u0006\b\u001a\u0006\b§\u0001\u0010¨\u0001ø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006¬\u0001À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", BuildConfig.FLAVOR, "affectsLookahead", "forceRequest", "scheduleMeasureAndLayout", BuildConfig.FLAVOR, "onRequestMeasure", "(Landroidx/compose/ui/node/LayoutNode;ZZZ)V", "onRequestRelayout", "(Landroidx/compose/ui/node/LayoutNode;ZZ)V", "requestOnPositionedCallback", "(Landroidx/compose/ui/node/LayoutNode;)V", "node", "onAttach", "onDetach", "Landroidx/compose/ui/geometry/Offset;", "localPosition", "calculatePositionInWindow-MK-Hz9U", "(J)J", "calculatePositionInWindow", "positionInWindow", "calculateLocalPosition-MK-Hz9U", "calculateLocalPosition", "sendPointerUpdate", "measureAndLayout", "(Z)V", "Landroidx/compose/ui/unit/Constraints;", "constraints", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "forceMeasureTheSubtree", "(Landroidx/compose/ui/node/LayoutNode;Z)V", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "drawBlock", "Lkotlin/Function0;", "invalidateParentLayer", "explicitLayer", "Landroidx/compose/ui/node/OwnedLayer;", "createLayer", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)Landroidx/compose/ui/node/OwnedLayer;", "onSemanticsChange", "()V", "onLayoutChange", "Landroid/view/View;", "Landroidx/compose/ui/viewinterop/InteropView;", "view", "onInteropViewLayoutChange", "(Landroid/view/View;)V", "listener", "registerOnEndApplyChangesListener", "(Lkotlin/jvm/functions/Function0;)V", "onEndApplyChanges", BuildConfig.FLAVOR, "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "session", "textInputSession", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "root", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getSharedDrawScope", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "sharedDrawScope", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "hapticFeedBack", "Landroidx/compose/ui/input/InputModeManager;", "getInputModeManager", "()Landroidx/compose/ui/input/InputModeManager;", "inputModeManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/ClipboardManager;", "clipboardManager", "Landroidx/compose/ui/platform/AccessibilityManager;", "getAccessibilityManager", "()Landroidx/compose/ui/platform/AccessibilityManager;", "accessibilityManager", "Landroidx/compose/ui/graphics/GraphicsContext;", "getGraphicsContext", "()Landroidx/compose/ui/graphics/GraphicsContext;", "graphicsContext", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "textToolbar", "Landroidx/compose/ui/autofill/AutofillTree;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "getAutofillTree$annotations", "autofillTree", "Landroidx/compose/ui/autofill/Autofill;", "getAutofill", "()Landroidx/compose/ui/autofill/Autofill;", "getAutofill$annotations", "autofill", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "textInputService", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "getSoftwareKeyboardController", "()Landroidx/compose/ui/platform/SoftwareKeyboardController;", "softwareKeyboardController", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "pointerIconService", "Landroidx/compose/ui/focus/FocusOwner;", "getFocusOwner", "()Landroidx/compose/ui/focus/FocusOwner;", "focusOwner", "Landroidx/compose/ui/platform/WindowInfo;", "getWindowInfo", "()Landroidx/compose/ui/platform/WindowInfo;", "windowInfo", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader$annotations", "fontLoader", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "<set-?>", "getShowLayoutBounds", "()Z", "setShowLayoutBounds", "showLayoutBounds", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "viewConfiguration", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "snapshotObserver", "Landroidx/compose/ui/modifier/ModifierLocalManager;", "getModifierLocalManager", "()Landroidx/compose/ui/modifier/ModifierLocalManager;", "modifierLocalManager", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placementScope", "Landroidx/compose/ui/draganddrop/DragAndDropManager;", "getDragAndDropManager", "()Landroidx/compose/ui/draganddrop/DragAndDropManager;", "dragAndDropManager", "Companion", "OnLayoutCompletedListener", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Owner extends PositionCalculator {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/node/Owner$Companion;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "enableExtraAssertions", "Z", "getEnableExtraAssertions", "()Z", "setEnableExtraAssertions", "(Z)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static boolean enableExtraAssertions;

        private Companion() {
        }

        public final boolean getEnableExtraAssertions() {
            return enableExtraAssertions;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", BuildConfig.FLAVOR, "onLayoutComplete", BuildConfig.FLAVOR, "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface OnLayoutCompletedListener {
        void onLayoutComplete();
    }

    static /* synthetic */ OwnedLayer createLayer$default(Owner owner, Function2 function2, Function0 function0, GraphicsLayer graphicsLayer, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLayer");
        }
        if ((i5 & 4) != 0) {
            graphicsLayer = null;
        }
        return owner.createLayer(function2, function0, graphicsLayer);
    }

    static /* synthetic */ void forceMeasureTheSubtree$default(Owner owner, LayoutNode layoutNode, boolean z5, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: forceMeasureTheSubtree");
        }
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        owner.forceMeasureTheSubtree(layoutNode, z5);
    }

    static /* synthetic */ void measureAndLayout$default(Owner owner, boolean z5, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: measureAndLayout");
        }
        if ((i5 & 1) != 0) {
            z5 = true;
        }
        owner.measureAndLayout(z5);
    }

    static /* synthetic */ void onRequestMeasure$default(Owner owner, LayoutNode layoutNode, boolean z5, boolean z6, boolean z7, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onRequestMeasure");
        }
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        if ((i5 & 4) != 0) {
            z6 = false;
        }
        if ((i5 & 8) != 0) {
            z7 = true;
        }
        owner.onRequestMeasure(layoutNode, z5, z6, z7);
    }

    static /* synthetic */ void onRequestRelayout$default(Owner owner, LayoutNode layoutNode, boolean z5, boolean z6, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onRequestRelayout");
        }
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        if ((i5 & 4) != 0) {
            z6 = false;
        }
        owner.onRequestRelayout(layoutNode, z5, z6);
    }

    /* renamed from: calculateLocalPosition-MK-Hz9U */
    long mo2082calculateLocalPositionMKHz9U(long positionInWindow);

    /* renamed from: calculatePositionInWindow-MK-Hz9U */
    long mo2083calculatePositionInWindowMKHz9U(long localPosition);

    OwnedLayer createLayer(Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock, Function0<Unit> invalidateParentLayer, GraphicsLayer explicitLayer);

    void forceMeasureTheSubtree(LayoutNode layoutNode, boolean affectsLookahead);

    AccessibilityManager getAccessibilityManager();

    Autofill getAutofill();

    AutofillTree getAutofillTree();

    ClipboardManager getClipboardManager();

    CoroutineContext getCoroutineContext();

    Density getDensity();

    DragAndDropManager getDragAndDropManager();

    FocusOwner getFocusOwner();

    FontFamily.Resolver getFontFamilyResolver();

    Font.ResourceLoader getFontLoader();

    GraphicsContext getGraphicsContext();

    HapticFeedback getHapticFeedBack();

    InputModeManager getInputModeManager();

    LayoutDirection getLayoutDirection();

    ModifierLocalManager getModifierLocalManager();

    Placeable.PlacementScope getPlacementScope();

    PointerIconService getPointerIconService();

    LayoutNode getRoot();

    LayoutNodeDrawScope getSharedDrawScope();

    boolean getShowLayoutBounds();

    OwnerSnapshotObserver getSnapshotObserver();

    SoftwareKeyboardController getSoftwareKeyboardController();

    TextInputService getTextInputService();

    TextToolbar getTextToolbar();

    ViewConfiguration getViewConfiguration();

    WindowInfo getWindowInfo();

    void measureAndLayout(boolean sendPointerUpdate);

    /* renamed from: measureAndLayout-0kLqBqw */
    void mo2084measureAndLayout0kLqBqw(LayoutNode layoutNode, long constraints);

    void onAttach(LayoutNode node);

    void onDetach(LayoutNode node);

    void onEndApplyChanges();

    void onInteropViewLayoutChange(View view);

    void onLayoutChange(LayoutNode layoutNode);

    void onRequestMeasure(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest, boolean scheduleMeasureAndLayout);

    void onRequestRelayout(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest);

    void onSemanticsChange();

    void registerOnEndApplyChangesListener(Function0<Unit> listener);

    void requestOnPositionedCallback(LayoutNode layoutNode);

    void setShowLayoutBounds(boolean z5);

    Object textInputSession(Function2<Object, ? super Continuation<?>, ? extends Object> function2, Continuation<?> continuation);
}
