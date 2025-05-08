package androidx.compose.ui.platform;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\r\"\u001f\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"(\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u000e8GX\u0087\u0004¢\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0016\u0010\u0013\"&\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u000e8GX\u0087\u0004¢\u0006\u0012\n\u0004\b\u001a\u0010\u0011\u0012\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001b\u0010\u0013\"\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013\"\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u000e8\u0006¢\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b\"\u0010\u0013\"\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000e8\u0006¢\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b%\u0010\u0013\"\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u000e8\u0006¢\u0006\f\n\u0004\b'\u0010\u0011\u001a\u0004\b(\u0010\u0013\"&\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u000e8GX\u0087\u0004¢\u0006\u0012\n\u0004\b*\u0010\u0011\u0012\u0004\b,\u0010\u0018\u001a\u0004\b+\u0010\u0013\"\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u000e8\u0006¢\u0006\f\n\u0004\b.\u0010\u0011\u001a\u0004\b/\u0010\u0013\"\u001d\u00101\u001a\b\u0012\u0004\u0012\u0002000\u000e8\u0006¢\u0006\f\n\u0004\b1\u0010\u0011\u001a\u0004\b2\u0010\u0013\"\u001d\u00104\u001a\b\u0012\u0004\u0012\u0002030\u000e8\u0006¢\u0006\f\n\u0004\b4\u0010\u0011\u001a\u0004\b5\u0010\u0013\"\u001d\u00107\u001a\b\u0012\u0004\u0012\u0002060\u000e8\u0006¢\u0006\f\n\u0004\b7\u0010\u0011\u001a\u0004\b8\u0010\u0013\"(\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b:\u0010\u0011\u0012\u0004\b<\u0010\u0018\u001a\u0004\b;\u0010\u0013\"\u001f\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010=0\u000e8\u0006¢\u0006\f\n\u0004\b>\u0010\u0011\u001a\u0004\b?\u0010\u0013\"\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00020@0\u000e8\u0006¢\u0006\f\n\u0004\bA\u0010\u0011\u001a\u0004\bB\u0010\u0013\"\u001d\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0006¢\u0006\f\n\u0004\bC\u0010\u0011\u001a\u0004\bD\u0010\u0013\"\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020E0\u000e8\u0006¢\u0006\f\n\u0004\bF\u0010\u0011\u001a\u0004\bG\u0010\u0013\"\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00020H0\u000e8\u0006¢\u0006\f\n\u0004\bI\u0010\u0011\u001a\u0004\bJ\u0010\u0013\"\"\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010K0\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bL\u0010\u0011\u001a\u0004\bM\u0010\u0013\" \u0010O\u001a\b\u0012\u0004\u0012\u00020N0\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bO\u0010\u0011\u001a\u0004\bP\u0010\u0013\"\u0017\u0010T\u001a\b\u0012\u0004\u0012\u00020N0Q8F¢\u0006\u0006\u001a\u0004\bR\u0010S¨\u0006U"}, d2 = {"Landroidx/compose/ui/node/Owner;", "owner", "Landroidx/compose/ui/platform/UriHandler;", "uriHandler", "Lkotlin/Function0;", BuildConfig.FLAVOR, "content", "ProvideCommonCompositionLocals", "(Landroidx/compose/ui/node/Owner;Landroidx/compose/ui/platform/UriHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "noLocalProvidedFor", "(Ljava/lang/String;)Ljava/lang/Void;", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/platform/AccessibilityManager;", "LocalAccessibilityManager", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalAccessibilityManager", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/autofill/Autofill;", "LocalAutofill", "getLocalAutofill", "getLocalAutofill$annotations", "()V", "Landroidx/compose/ui/autofill/AutofillTree;", "LocalAutofillTree", "getLocalAutofillTree", "getLocalAutofillTree$annotations", "Landroidx/compose/ui/platform/ClipboardManager;", "LocalClipboardManager", "getLocalClipboardManager", "Landroidx/compose/ui/graphics/GraphicsContext;", "LocalGraphicsContext", "getLocalGraphicsContext", "Landroidx/compose/ui/unit/Density;", "LocalDensity", "getLocalDensity", "Landroidx/compose/ui/focus/FocusManager;", "LocalFocusManager", "getLocalFocusManager", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "LocalFontLoader", "getLocalFontLoader", "getLocalFontLoader$annotations", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "LocalFontFamilyResolver", "getLocalFontFamilyResolver", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "LocalHapticFeedback", "getLocalHapticFeedback", "Landroidx/compose/ui/input/InputModeManager;", "LocalInputModeManager", "getLocalInputModeManager", "Landroidx/compose/ui/unit/LayoutDirection;", "LocalLayoutDirection", "getLocalLayoutDirection", "Landroidx/compose/ui/text/input/TextInputService;", "LocalTextInputService", "getLocalTextInputService", "getLocalTextInputService$annotations", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "LocalSoftwareKeyboardController", "getLocalSoftwareKeyboardController", "Landroidx/compose/ui/platform/TextToolbar;", "LocalTextToolbar", "getLocalTextToolbar", "LocalUriHandler", "getLocalUriHandler", "Landroidx/compose/ui/platform/ViewConfiguration;", "LocalViewConfiguration", "getLocalViewConfiguration", "Landroidx/compose/ui/platform/WindowInfo;", "LocalWindowInfo", "getLocalWindowInfo", "Landroidx/compose/ui/input/pointer/PointerIconService;", "LocalPointerIconService", "getLocalPointerIconService", BuildConfig.FLAVOR, "LocalProvidableScrollCaptureInProgress", "getLocalProvidableScrollCaptureInProgress", "Landroidx/compose/runtime/CompositionLocal;", "getLocalScrollCaptureInProgress", "()Landroidx/compose/runtime/CompositionLocal;", "LocalScrollCaptureInProgress", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class CompositionLocalsKt {
    private static final ProvidableCompositionLocal<AccessibilityManager> LocalAccessibilityManager = CompositionLocalKt.staticCompositionLocalOf(new Function0<AccessibilityManager>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalAccessibilityManager$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AccessibilityManager invoke() {
            return null;
        }
    });
    private static final ProvidableCompositionLocal<Autofill> LocalAutofill = CompositionLocalKt.staticCompositionLocalOf(new Function0<Autofill>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalAutofill$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Autofill invoke() {
            return null;
        }
    });
    private static final ProvidableCompositionLocal<AutofillTree> LocalAutofillTree = CompositionLocalKt.staticCompositionLocalOf(new Function0<AutofillTree>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalAutofillTree$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AutofillTree invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalAutofillTree");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<ClipboardManager> LocalClipboardManager = CompositionLocalKt.staticCompositionLocalOf(new Function0<ClipboardManager>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalClipboardManager$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ClipboardManager invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalClipboardManager");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<GraphicsContext> LocalGraphicsContext = CompositionLocalKt.staticCompositionLocalOf(new Function0<GraphicsContext>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalGraphicsContext$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GraphicsContext invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalGraphicsContext");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<Density> LocalDensity = CompositionLocalKt.staticCompositionLocalOf(new Function0<Density>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalDensity$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Density invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalDensity");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<FocusManager> LocalFocusManager = CompositionLocalKt.staticCompositionLocalOf(new Function0<FocusManager>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalFocusManager$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FocusManager invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalFocusManager");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<Font.ResourceLoader> LocalFontLoader = CompositionLocalKt.staticCompositionLocalOf(new Function0<Font.ResourceLoader>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalFontLoader$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Font.ResourceLoader invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalFontLoader");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<FontFamily.Resolver> LocalFontFamilyResolver = CompositionLocalKt.staticCompositionLocalOf(new Function0<FontFamily.Resolver>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalFontFamilyResolver$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FontFamily.Resolver invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalFontFamilyResolver");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<HapticFeedback> LocalHapticFeedback = CompositionLocalKt.staticCompositionLocalOf(new Function0<HapticFeedback>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalHapticFeedback$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final HapticFeedback invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalHapticFeedback");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<InputModeManager> LocalInputModeManager = CompositionLocalKt.staticCompositionLocalOf(new Function0<InputModeManager>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalInputModeManager$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final InputModeManager invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalInputManager");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<LayoutDirection> LocalLayoutDirection = CompositionLocalKt.staticCompositionLocalOf(new Function0<LayoutDirection>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalLayoutDirection$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LayoutDirection invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalLayoutDirection");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<TextInputService> LocalTextInputService = CompositionLocalKt.staticCompositionLocalOf(new Function0<TextInputService>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalTextInputService$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TextInputService invoke() {
            return null;
        }
    });
    private static final ProvidableCompositionLocal<SoftwareKeyboardController> LocalSoftwareKeyboardController = CompositionLocalKt.staticCompositionLocalOf(new Function0<SoftwareKeyboardController>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalSoftwareKeyboardController$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SoftwareKeyboardController invoke() {
            return null;
        }
    });
    private static final ProvidableCompositionLocal<TextToolbar> LocalTextToolbar = CompositionLocalKt.staticCompositionLocalOf(new Function0<TextToolbar>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalTextToolbar$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TextToolbar invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalTextToolbar");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<UriHandler> LocalUriHandler = CompositionLocalKt.staticCompositionLocalOf(new Function0<UriHandler>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalUriHandler$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UriHandler invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalUriHandler");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<ViewConfiguration> LocalViewConfiguration = CompositionLocalKt.staticCompositionLocalOf(new Function0<ViewConfiguration>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalViewConfiguration$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewConfiguration invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalViewConfiguration");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<WindowInfo> LocalWindowInfo = CompositionLocalKt.staticCompositionLocalOf(new Function0<WindowInfo>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalWindowInfo$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final WindowInfo invoke() {
            CompositionLocalsKt.noLocalProvidedFor("LocalWindowInfo");
            throw new KotlinNothingValueException();
        }
    });
    private static final ProvidableCompositionLocal<PointerIconService> LocalPointerIconService = CompositionLocalKt.staticCompositionLocalOf(new Function0<PointerIconService>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalPointerIconService$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PointerIconService invoke() {
            return null;
        }
    });
    private static final ProvidableCompositionLocal<Boolean> LocalProvidableScrollCaptureInProgress = CompositionLocalKt.compositionLocalOf$default(null, new Function0<Boolean>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalProvidableScrollCaptureInProgress$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    }, 1, null);

    public static final void ProvideCommonCompositionLocals(final Owner owner, final UriHandler uriHandler, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(874662829);
        if ((i5 & 6) == 0) {
            i6 = ((i5 & 8) == 0 ? startRestartGroup.changed(owner) : startRestartGroup.changedInstance(owner) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= (i5 & 64) == 0 ? startRestartGroup.changed(uriHandler) : startRestartGroup.changedInstance(uriHandler) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(874662829, i6, -1, "androidx.compose.ui.platform.ProvideCommonCompositionLocals (CompositionLocals.kt:214)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{LocalAccessibilityManager.provides(owner.getAccessibilityManager()), LocalAutofill.provides(owner.getAutofill()), LocalAutofillTree.provides(owner.getAutofillTree()), LocalClipboardManager.provides(owner.getClipboardManager()), LocalDensity.provides(owner.getDensity()), LocalFocusManager.provides(owner.getFocusOwner()), LocalFontLoader.providesDefault(owner.getFontLoader()), LocalFontFamilyResolver.providesDefault(owner.getFontFamilyResolver()), LocalHapticFeedback.provides(owner.getHapticFeedBack()), LocalInputModeManager.provides(owner.getInputModeManager()), LocalLayoutDirection.provides(owner.getLayoutDirection()), LocalTextInputService.provides(owner.getTextInputService()), LocalSoftwareKeyboardController.provides(owner.getSoftwareKeyboardController()), LocalTextToolbar.provides(owner.getTextToolbar()), LocalUriHandler.provides(uriHandler), LocalViewConfiguration.provides(owner.getViewConfiguration()), LocalWindowInfo.provides(owner.getWindowInfo()), LocalPointerIconService.provides(owner.getPointerIconService()), LocalGraphicsContext.provides(owner.getGraphicsContext())}, function2, startRestartGroup, ((i6 >> 3) & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$ProvideCommonCompositionLocals$1
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
                    CompositionLocalsKt.ProvideCommonCompositionLocals(Owner.this, uriHandler, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
                }
            });
        }
    }

    public static final ProvidableCompositionLocal<AccessibilityManager> getLocalAccessibilityManager() {
        return LocalAccessibilityManager;
    }

    public static final ProvidableCompositionLocal<Autofill> getLocalAutofill() {
        return LocalAutofill;
    }

    public static final ProvidableCompositionLocal<AutofillTree> getLocalAutofillTree() {
        return LocalAutofillTree;
    }

    public static final ProvidableCompositionLocal<ClipboardManager> getLocalClipboardManager() {
        return LocalClipboardManager;
    }

    public static final ProvidableCompositionLocal<Density> getLocalDensity() {
        return LocalDensity;
    }

    public static final ProvidableCompositionLocal<FocusManager> getLocalFocusManager() {
        return LocalFocusManager;
    }

    public static final ProvidableCompositionLocal<FontFamily.Resolver> getLocalFontFamilyResolver() {
        return LocalFontFamilyResolver;
    }

    public static final ProvidableCompositionLocal<GraphicsContext> getLocalGraphicsContext() {
        return LocalGraphicsContext;
    }

    public static final ProvidableCompositionLocal<HapticFeedback> getLocalHapticFeedback() {
        return LocalHapticFeedback;
    }

    public static final ProvidableCompositionLocal<InputModeManager> getLocalInputModeManager() {
        return LocalInputModeManager;
    }

    public static final ProvidableCompositionLocal<LayoutDirection> getLocalLayoutDirection() {
        return LocalLayoutDirection;
    }

    public static final ProvidableCompositionLocal<PointerIconService> getLocalPointerIconService() {
        return LocalPointerIconService;
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalProvidableScrollCaptureInProgress() {
        return LocalProvidableScrollCaptureInProgress;
    }

    public static final CompositionLocal<Boolean> getLocalScrollCaptureInProgress() {
        return LocalProvidableScrollCaptureInProgress;
    }

    public static final ProvidableCompositionLocal<SoftwareKeyboardController> getLocalSoftwareKeyboardController() {
        return LocalSoftwareKeyboardController;
    }

    public static final ProvidableCompositionLocal<TextToolbar> getLocalTextToolbar() {
        return LocalTextToolbar;
    }

    public static final ProvidableCompositionLocal<UriHandler> getLocalUriHandler() {
        return LocalUriHandler;
    }

    public static final ProvidableCompositionLocal<ViewConfiguration> getLocalViewConfiguration() {
        return LocalViewConfiguration;
    }

    public static final ProvidableCompositionLocal<WindowInfo> getLocalWindowInfo() {
        return LocalWindowInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void noLocalProvidedFor(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }
}
