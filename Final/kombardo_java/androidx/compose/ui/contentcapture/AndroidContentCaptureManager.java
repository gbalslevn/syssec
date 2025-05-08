package androidx.compose.ui.contentcapture;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.LongSparseArray;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.translation.TranslationRequestValue;
import android.view.translation.TranslationResponseValue;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import androidx.collection.ArraySet;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.SemanticsNodeCopy;
import androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds;
import androidx.compose.ui.platform.SemanticsUtils_androidKt;
import androidx.compose.ui.platform.coreshims.AutofillIdCompat;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.platform.coreshims.ViewStructureCompat;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.core.util.LongSparseArrayKt;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.sdk.growthbook.utils.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.LongIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import l.AbstractC0534b;
import l.AbstractC0535c;
import l.g;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u0098\u0001\u0099\u0001B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u001d\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u0015\u0010%\u001a\u0004\u0018\u00010$*\u00020\u000bH\u0002¢\u0006\u0004\b%\u0010&J!\u0010)\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u00182\b\u0010(\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u0018H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u000fH\u0002¢\u0006\u0004\b-\u0010\u001fJ\u0017\u0010/\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000bH\u0002¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000bH\u0002¢\u0006\u0004\b1\u00100J\u0017\u00102\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u000bH\u0002¢\u0006\u0004\b2\u00100J\u000f\u00103\u001a\u00020\u000fH\u0002¢\u0006\u0004\b3\u0010\u001fJ\u000f\u00104\u001a\u00020\u000fH\u0002¢\u0006\u0004\b4\u0010\u001fJ\u000f\u00105\u001a\u00020\u000fH\u0002¢\u0006\u0004\b5\u0010\u001fJ\u0017\u00108\u001a\u00020\u000f2\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\u000f2\u0006\u00107\u001a\u000206H\u0016¢\u0006\u0004\b:\u00109J\u0017\u0010=\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b?\u0010>J\u0010\u0010B\u001a\u00020\u000fH\u0080@¢\u0006\u0004\b@\u0010AJ\u000f\u0010D\u001a\u00020\u000fH\u0000¢\u0006\u0004\bC\u0010\u001fJ\u0017\u0010F\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020 H\u0000¢\u0006\u0004\bE\u0010#J\u000f\u0010H\u001a\u00020\u000fH\u0000¢\u0006\u0004\bG\u0010\u001fJ\u000f\u0010J\u001a\u00020\u000fH\u0000¢\u0006\u0004\bI\u0010\u001fJ\u000f\u0010L\u001a\u00020\u000fH\u0000¢\u0006\u0004\bK\u0010\u001fJ/\u0010V\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020M2\u0006\u0010P\u001a\u00020O2\u000e\u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010R0QH\u0001¢\u0006\u0004\bT\u0010UJ'\u0010]\u001a\u00020\u000f2\u0006\u0010W\u001a\u00020\u00002\u000e\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010Y0XH\u0001¢\u0006\u0004\b[\u0010\\R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010^\u001a\u0004\b_\u0010`R*\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR*\u0010f\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\bf\u0010g\u0012\u0004\bl\u0010\u001f\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u001a\u0010n\u001a\b\u0012\u0004\u0012\u00020$0m8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010q\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010t\u001a\u00020s8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010w\u001a\u00020v8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010z\u001a\u00020y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u001a\u0010}\u001a\b\u0012\u0004\u0012\u00020 0|8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u001d\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\u007f8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R \u0010\u0083\u0001\u001a\u00030\u0082\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R.\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138@@\u0000X\u0080\u000e¢\u0006\u0017\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0005\b\u008b\u0001\u0010\u0017R\u0018\u0010\u008c\u0001\u001a\u00020s8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010uR\u001e\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\r0m8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010oR\u0019\u0010\u008e\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0018\u0010\u0090\u0001\u001a\u00020y8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010{R\u0018\u0010\u0092\u0001\u001a\u00030\u0091\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001e\u0010\u0097\u0001\u001a\u00020y8@X\u0080\u0004¢\u0006\u000f\u0012\u0005\b\u0096\u0001\u0010\u001f\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001¨\u0006\u009a\u0001"}, d2 = {"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "Landroidx/compose/ui/contentcapture/ContentCaptureManager;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroidx/compose/ui/platform/AndroidComposeView;", "view", "Lkotlin/Function0;", "Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "onContentCaptureSession", "<init>", "(Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function0;)V", "Landroidx/compose/ui/semantics/SemanticsNode;", "newNode", "Landroidx/compose/ui/platform/SemanticsNodeCopy;", "oldNode", BuildConfig.FLAVOR, "sendSemanticsStructureChangeEvents", "(Landroidx/compose/ui/semantics/SemanticsNode;Landroidx/compose/ui/platform/SemanticsNodeCopy;)V", "sendContentCaptureStructureChangeEvents", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "newSemanticsNodes", "checkForContentCapturePropertyChanges", "(Landroidx/collection/IntObjectMap;)V", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "newText", "sendContentCaptureTextUpdateEvent", "(ILjava/lang/String;)V", "updateSemanticsCopy", "()V", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "notifySubtreeStateChangeIfNeeded", "(Landroidx/compose/ui/node/LayoutNode;)V", "Landroidx/compose/ui/platform/coreshims/ViewStructureCompat;", "toViewStructure", "(Landroidx/compose/ui/semantics/SemanticsNode;)Landroidx/compose/ui/platform/coreshims/ViewStructureCompat;", "virtualId", "viewStructure", "bufferContentCaptureViewAppeared", "(ILandroidx/compose/ui/platform/coreshims/ViewStructureCompat;)V", "bufferContentCaptureViewDisappeared", "(I)V", "notifyContentCaptureChanges", "node", "updateBuffersOnAppeared", "(Landroidx/compose/ui/semantics/SemanticsNode;)V", "updateBuffersOnDisappeared", "updateTranslationOnAppeared", "showTranslatedText", "hideTranslatedText", "clearTranslatedText", "Landroid/view/View;", "v", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "Landroidx/lifecycle/LifecycleOwner;", "owner", "onStart", "(Landroidx/lifecycle/LifecycleOwner;)V", "onStop", "boundsUpdatesEventLoop$ui_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "boundsUpdatesEventLoop", "onSemanticsChange$ui_release", "onSemanticsChange", "onLayoutChange$ui_release", "onLayoutChange", "onShowTranslation$ui_release", "onShowTranslation", "onHideTranslation$ui_release", "onHideTranslation", "onClearTranslation$ui_release", "onClearTranslation", BuildConfig.FLAVOR, "virtualIds", BuildConfig.FLAVOR, "supportedFormats", "Ljava/util/function/Consumer;", "Landroid/view/translation/ViewTranslationRequest;", "requestsCollector", "onCreateVirtualViewTranslationRequests$ui_release", "([J[ILjava/util/function/Consumer;)V", "onCreateVirtualViewTranslationRequests", "contentCaptureManager", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "response", "onVirtualViewTranslationResponses$ui_release", "(Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;Landroid/util/LongSparseArray;)V", "onVirtualViewTranslationResponses", "Landroidx/compose/ui/platform/AndroidComposeView;", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "Lkotlin/jvm/functions/Function0;", "getOnContentCaptureSession", "()Lkotlin/jvm/functions/Function0;", "setOnContentCaptureSession", "(Lkotlin/jvm/functions/Function0;)V", "contentCaptureSession", "Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "getContentCaptureSession$ui_release", "()Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", "setContentCaptureSession$ui_release", "(Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;)V", "getContentCaptureSession$ui_release$annotations", "Landroidx/collection/MutableIntObjectMap;", "bufferedAppearedNodes", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableIntSet;", "bufferedDisappearedNodes", "Landroidx/collection/MutableIntSet;", BuildConfig.FLAVOR, "SendRecurringContentCaptureEventsIntervalMillis", "J", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$TranslateStatus;", "translateStatus", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$TranslateStatus;", BuildConfig.FLAVOR, "currentSemanticsNodesInvalidated", "Z", "Landroidx/collection/ArraySet;", "subtreeChangedLayoutNodes", "Landroidx/collection/ArraySet;", "Lkotlinx/coroutines/channels/Channel;", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "getHandler$ui_release", "()Landroid/os/Handler;", "currentSemanticsNodes", "Landroidx/collection/IntObjectMap;", "getCurrentSemanticsNodes$ui_release", "()Landroidx/collection/IntObjectMap;", "setCurrentSemanticsNodes$ui_release", "currentSemanticsNodesSnapshotTimestampMillis", "previousSemanticsNodes", "previousSemanticsRoot", "Landroidx/compose/ui/platform/SemanticsNodeCopy;", "checkingForSemanticsChanges", "Ljava/lang/Runnable;", "contentCaptureChangeChecker", "Ljava/lang/Runnable;", "isEnabled$ui_release", "()Z", "isEnabled$ui_release$annotations", "isEnabled", "TranslateStatus", "ViewTranslationHelperMethods", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidContentCaptureManager implements ContentCaptureManager, DefaultLifecycleObserver, View.OnAttachStateChangeListener {
    private final MutableIntObjectMap<ViewStructureCompat> bufferedAppearedNodes;
    private final MutableIntSet bufferedDisappearedNodes;
    private boolean checkingForSemanticsChanges;
    private ContentCaptureSessionCompat contentCaptureSession;
    private long currentSemanticsNodesSnapshotTimestampMillis;
    private Function0<? extends ContentCaptureSessionCompat> onContentCaptureSession;
    private SemanticsNodeCopy previousSemanticsRoot;
    private final ArraySet<LayoutNode> subtreeChangedLayoutNodes;
    private final AndroidComposeView view;
    private long SendRecurringContentCaptureEventsIntervalMillis = 100;
    private TranslateStatus translateStatus = TranslateStatus.SHOW_ORIGINAL;
    private boolean currentSemanticsNodesInvalidated = true;
    private final Channel<Unit> boundsUpdateChannel = ChannelKt.Channel$default(1, null, null, 6, null);
    private final Handler handler = new Handler(Looper.getMainLooper());
    private IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes = IntObjectMapKt.intObjectMapOf();
    private MutableIntObjectMap<SemanticsNodeCopy> previousSemanticsNodes = IntObjectMapKt.mutableIntObjectMapOf();
    private final Runnable contentCaptureChangeChecker = new Runnable() { // from class: l.a
        @Override // java.lang.Runnable
        public final void run() {
            AndroidContentCaptureManager.contentCaptureChangeChecker$lambda$0(AndroidContentCaptureManager.this);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$TranslateStatus;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "SHOW_ORIGINAL", "SHOW_TRANSLATED", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public enum TranslateStatus {
        SHOW_ORIGINAL,
        SHOW_TRANSLATED
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0002J0\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010H\u0007J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0007¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager$ViewTranslationHelperMethods;", BuildConfig.FLAVOR, "()V", "doTranslation", BuildConfig.FLAVOR, "contentCaptureManager", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "response", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "onCreateVirtualViewTranslationRequests", "virtualIds", BuildConfig.FLAVOR, "supportedFormats", BuildConfig.FLAVOR, "requestsCollector", "Ljava/util/function/Consumer;", "Landroid/view/translation/ViewTranslationRequest;", "onVirtualViewTranslationResponses", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    private static final class ViewTranslationHelperMethods {
        public static final ViewTranslationHelperMethods INSTANCE = new ViewTranslationHelperMethods();

        private ViewTranslationHelperMethods() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
        
            r3 = r3.getText();
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
        
            r3 = r3.getValue("android:text");
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void doTranslation(AndroidContentCaptureManager contentCaptureManager, LongSparseArray<ViewTranslationResponse> response) {
            TranslationResponseValue value;
            CharSequence text;
            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds;
            SemanticsNode semanticsNode;
            AccessibilityAction accessibilityAction;
            Function1 function1;
            LongIterator keyIterator = LongSparseArrayKt.keyIterator(response);
            while (keyIterator.hasNext()) {
                long nextLong = keyIterator.nextLong();
                ViewTranslationResponse a5 = g.a(response.get(nextLong));
                if (a5 != null && value != null && text != null && (semanticsNodeWithAdjustedBounds = contentCaptureManager.getCurrentSemanticsNodes$ui_release().get((int) nextLong)) != null && (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) != null && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetTextSubstitution())) != null && (function1 = (Function1) accessibilityAction.getAction()) != null) {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onVirtualViewTranslationResponses$lambda$1(AndroidContentCaptureManager androidContentCaptureManager, LongSparseArray longSparseArray) {
            INSTANCE.doTranslation(androidContentCaptureManager, longSparseArray);
        }

        public final void onCreateVirtualViewTranslationRequests(AndroidContentCaptureManager contentCaptureManager, long[] virtualIds, int[] supportedFormats, Consumer<ViewTranslationRequest> requestsCollector) {
            SemanticsNode semanticsNode;
            String fastJoinToString$default;
            TranslationRequestValue forText;
            ViewTranslationRequest build;
            for (long j5 : virtualIds) {
                SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = contentCaptureManager.getCurrentSemanticsNodes$ui_release().get((int) j5);
                if (semanticsNodeWithAdjustedBounds != null && (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) != null) {
                    AbstractC0535c.a();
                    ViewTranslationRequest.Builder a5 = AbstractC0534b.a(contentCaptureManager.getView().getAutofillId(), semanticsNode.getId());
                    List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getText());
                    if (list != null && (fastJoinToString$default = ListUtilsKt.fastJoinToString$default(list, "\n", null, null, 0, null, null, 62, null)) != null) {
                        forText = TranslationRequestValue.forText(new AnnotatedString(fastJoinToString$default, null, null, 6, null));
                        a5.setValue("android:text", forText);
                        build = a5.build();
                        requestsCollector.accept(build);
                    }
                }
            }
        }

        public final void onVirtualViewTranslationResponses(final AndroidContentCaptureManager contentCaptureManager, final LongSparseArray<ViewTranslationResponse> response) {
            if (Build.VERSION.SDK_INT < 31) {
                return;
            }
            if (Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
                doTranslation(contentCaptureManager, response);
            } else {
                contentCaptureManager.getView().post(new Runnable() { // from class: androidx.compose.ui.contentcapture.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        AndroidContentCaptureManager.ViewTranslationHelperMethods.onVirtualViewTranslationResponses$lambda$1(AndroidContentCaptureManager.this, response);
                    }
                });
            }
        }
    }

    public AndroidContentCaptureManager(AndroidComposeView androidComposeView, Function0<? extends ContentCaptureSessionCompat> function0) {
        this.view = androidComposeView;
        this.onContentCaptureSession = function0;
        int i5 = 0;
        int i6 = 1;
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.bufferedAppearedNodes = new MutableIntObjectMap<>(i5, i6, defaultConstructorMarker);
        this.bufferedDisappearedNodes = new MutableIntSet(i5, i6, defaultConstructorMarker);
        this.subtreeChangedLayoutNodes = new ArraySet<>(i5, i6, defaultConstructorMarker);
        this.previousSemanticsRoot = new SemanticsNodeCopy(androidComposeView.getSemanticsOwner().getUnmergedRootSemanticsNode(), IntObjectMapKt.intObjectMapOf());
    }

    private final void bufferContentCaptureViewAppeared(int virtualId, ViewStructureCompat viewStructure) {
        if (viewStructure == null) {
            return;
        }
        if (this.bufferedDisappearedNodes.contains(virtualId)) {
            this.bufferedDisappearedNodes.remove(virtualId);
        } else {
            this.bufferedAppearedNodes.set(virtualId, viewStructure);
        }
    }

    private final void bufferContentCaptureViewDisappeared(int virtualId) {
        if (this.bufferedAppearedNodes.containsKey(virtualId)) {
            this.bufferedAppearedNodes.remove(virtualId);
        } else {
            this.bufferedDisappearedNodes.add(virtualId);
        }
    }

    private final void checkForContentCapturePropertyChanges(IntObjectMap<SemanticsNodeWithAdjustedBounds> newSemanticsNodes) {
        int i5;
        int[] iArr = newSemanticsNodes.keys;
        long[] jArr = newSemanticsNodes.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            long j5 = jArr[i6];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8;
                int i8 = 8 - ((~(i6 - length)) >>> 31);
                int i9 = 0;
                while (i9 < i8) {
                    if ((255 & j5) < 128) {
                        int i10 = iArr[(i6 << 3) + i9];
                        SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(i10);
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = newSemanticsNodes.get(i10);
                        SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
                        if (semanticsNode == null) {
                            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("no value for specified key");
                            throw new KotlinNothingValueException();
                        }
                        if (semanticsNodeCopy == null) {
                            Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> it = semanticsNode.getUnmergedConfig().iterator();
                            while (it.hasNext()) {
                                SemanticsPropertyKey<?> key = it.next().getKey();
                                SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
                                if (Intrinsics.areEqual(key, semanticsProperties.getText())) {
                                    List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsProperties.getText());
                                    sendContentCaptureTextUpdateEvent(semanticsNode.getId(), String.valueOf(list != null ? (AnnotatedString) CollectionsKt.firstOrNull(list) : null));
                                }
                            }
                        } else {
                            Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> it2 = semanticsNode.getUnmergedConfig().iterator();
                            while (it2.hasNext()) {
                                SemanticsPropertyKey<?> key2 = it2.next().getKey();
                                SemanticsProperties semanticsProperties2 = SemanticsProperties.INSTANCE;
                                if (Intrinsics.areEqual(key2, semanticsProperties2.getText())) {
                                    List list2 = (List) SemanticsConfigurationKt.getOrNull(semanticsNodeCopy.getUnmergedConfig(), semanticsProperties2.getText());
                                    AnnotatedString annotatedString = list2 != null ? (AnnotatedString) CollectionsKt.firstOrNull(list2) : null;
                                    List list3 = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), semanticsProperties2.getText());
                                    AnnotatedString annotatedString2 = list3 != null ? (AnnotatedString) CollectionsKt.firstOrNull(list3) : null;
                                    if (!Intrinsics.areEqual(annotatedString, annotatedString2)) {
                                        sendContentCaptureTextUpdateEvent(semanticsNode.getId(), String.valueOf(annotatedString2));
                                    }
                                }
                            }
                        }
                        i5 = 8;
                    } else {
                        i5 = i7;
                    }
                    j5 >>= i5;
                    i9++;
                    i7 = i5;
                }
                if (i8 != i7) {
                    return;
                }
            }
            if (i6 == length) {
                return;
            } else {
                i6++;
            }
        }
    }

    private final void clearTranslatedText() {
        AccessibilityAction accessibilityAction;
        Function0 function0;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes$ui_release = getCurrentSemanticsNodes$ui_release();
        Object[] objArr = currentSemanticsNodes$ui_release.values;
        long[] jArr = currentSemanticsNodes$ui_release.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            long j5 = jArr[i5];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j5) < 128) {
                        SemanticsConfiguration unmergedConfig = ((SemanticsNodeWithAdjustedBounds) objArr[(i5 << 3) + i7]).getSemanticsNode().getUnmergedConfig();
                        if (SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()) != null && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsActions.INSTANCE.getClearTextSubstitution())) != null && (function0 = (Function0) accessibilityAction.getAction()) != null) {
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void contentCaptureChangeChecker$lambda$0(AndroidContentCaptureManager androidContentCaptureManager) {
        if (androidContentCaptureManager.isEnabled$ui_release()) {
            Owner.measureAndLayout$default(androidContentCaptureManager.view, false, 1, null);
            androidContentCaptureManager.sendSemanticsStructureChangeEvents(androidContentCaptureManager.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), androidContentCaptureManager.previousSemanticsRoot);
            androidContentCaptureManager.sendContentCaptureStructureChangeEvents(androidContentCaptureManager.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), androidContentCaptureManager.previousSemanticsRoot);
            androidContentCaptureManager.checkForContentCapturePropertyChanges(androidContentCaptureManager.getCurrentSemanticsNodes$ui_release());
            androidContentCaptureManager.updateSemanticsCopy();
            androidContentCaptureManager.checkingForSemanticsChanges = false;
        }
    }

    private final void hideTranslatedText() {
        AccessibilityAction accessibilityAction;
        Function1 function1;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes$ui_release = getCurrentSemanticsNodes$ui_release();
        Object[] objArr = currentSemanticsNodes$ui_release.values;
        long[] jArr = currentSemanticsNodes$ui_release.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            long j5 = jArr[i5];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j5) < 128) {
                        SemanticsConfiguration unmergedConfig = ((SemanticsNodeWithAdjustedBounds) objArr[(i5 << 3) + i7]).getSemanticsNode().getUnmergedConfig();
                        if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()), Boolean.TRUE) && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsActions.INSTANCE.getShowTextSubstitution())) != null && (function1 = (Function1) accessibilityAction.getAction()) != null) {
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    private final void notifyContentCaptureChanges() {
        ContentCaptureSessionCompat contentCaptureSessionCompat = this.contentCaptureSession;
        if (contentCaptureSessionCompat != null && Build.VERSION.SDK_INT >= 29) {
            long j5 = 255;
            char c5 = 7;
            if (this.bufferedAppearedNodes.isNotEmpty()) {
                ArrayList arrayList = new ArrayList();
                MutableIntObjectMap<ViewStructureCompat> mutableIntObjectMap = this.bufferedAppearedNodes;
                Object[] objArr = mutableIntObjectMap.values;
                long[] jArr = mutableIntObjectMap.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i5 = 0;
                    while (true) {
                        long j6 = jArr[i5];
                        long[] jArr2 = jArr;
                        if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i6 = 8 - ((~(i5 - length)) >>> 31);
                            int i7 = 0;
                            while (i7 < i6) {
                                if ((j6 & j5) < 128) {
                                    arrayList.add((ViewStructureCompat) objArr[(i5 << 3) + i7]);
                                }
                                j6 >>= 8;
                                i7++;
                                j5 = 255;
                            }
                            if (i6 != 8) {
                                break;
                            }
                        }
                        if (i5 == length) {
                            break;
                        }
                        i5++;
                        jArr = jArr2;
                        j5 = 255;
                    }
                }
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                int size = arrayList.size();
                for (int i8 = 0; i8 < size; i8++) {
                    arrayList2.add(((ViewStructureCompat) arrayList.get(i8)).toViewStructure());
                }
                contentCaptureSessionCompat.notifyViewsAppeared(arrayList2);
                this.bufferedAppearedNodes.clear();
            }
            if (this.bufferedDisappearedNodes.isNotEmpty()) {
                ArrayList arrayList3 = new ArrayList();
                MutableIntSet mutableIntSet = this.bufferedDisappearedNodes;
                int[] iArr = mutableIntSet.elements;
                long[] jArr3 = mutableIntSet.metadata;
                int length2 = jArr3.length - 2;
                if (length2 >= 0) {
                    int i9 = 0;
                    while (true) {
                        long j7 = jArr3[i9];
                        if ((((~j7) << c5) & j7 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i10 = 8 - ((~(i9 - length2)) >>> 31);
                            for (int i11 = 0; i11 < i10; i11++) {
                                if ((j7 & 255) < 128) {
                                    arrayList3.add(Integer.valueOf(iArr[(i9 << 3) + i11]));
                                }
                                j7 >>= 8;
                            }
                            if (i10 != 8) {
                                break;
                            }
                        }
                        if (i9 == length2) {
                            break;
                        }
                        i9++;
                        c5 = 7;
                    }
                }
                ArrayList arrayList4 = new ArrayList(arrayList3.size());
                int size2 = arrayList3.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    arrayList4.add(Long.valueOf(((Number) arrayList3.get(i12)).intValue()));
                }
                contentCaptureSessionCompat.notifyViewsDisappeared(CollectionsKt.toLongArray(arrayList4));
                this.bufferedDisappearedNodes.clear();
            }
        }
    }

    private final void notifySubtreeStateChangeIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.mo3767trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    private final void sendContentCaptureStructureChangeEvents(SemanticsNode newNode, SemanticsNodeCopy oldNode) {
        List<SemanticsNode> replacedChildren$ui_release = newNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int i5 = 0; i5 < size; i5++) {
            SemanticsNode semanticsNode = replacedChildren$ui_release.get(i5);
            if (getCurrentSemanticsNodes$ui_release().contains(semanticsNode.getId()) && !oldNode.getChildren().contains(semanticsNode.getId())) {
                updateBuffersOnAppeared(semanticsNode);
            }
        }
        MutableIntObjectMap<SemanticsNodeCopy> mutableIntObjectMap = this.previousSemanticsNodes;
        int[] iArr = mutableIntObjectMap.keys;
        long[] jArr = mutableIntObjectMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i6 = 0;
            while (true) {
                long j5 = jArr[i6];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i7 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i8 = 0; i8 < i7; i8++) {
                        if ((255 & j5) < 128) {
                            int i9 = iArr[(i6 << 3) + i8];
                            if (!getCurrentSemanticsNodes$ui_release().contains(i9)) {
                                bufferContentCaptureViewDisappeared(i9);
                            }
                        }
                        j5 >>= 8;
                    }
                    if (i7 != 8) {
                        break;
                    }
                }
                if (i6 == length) {
                    break;
                } else {
                    i6++;
                }
            }
        }
        List<SemanticsNode> replacedChildren$ui_release2 = newNode.getReplacedChildren$ui_release();
        int size2 = replacedChildren$ui_release2.size();
        for (int i10 = 0; i10 < size2; i10++) {
            SemanticsNode semanticsNode2 = replacedChildren$ui_release2.get(i10);
            if (getCurrentSemanticsNodes$ui_release().contains(semanticsNode2.getId()) && this.previousSemanticsNodes.contains(semanticsNode2.getId())) {
                SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(semanticsNode2.getId());
                if (semanticsNodeCopy == null) {
                    InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("node not present in pruned tree before this change");
                    throw new KotlinNothingValueException();
                }
                sendContentCaptureStructureChangeEvents(semanticsNode2, semanticsNodeCopy);
            }
        }
    }

    private final void sendContentCaptureTextUpdateEvent(int id, String newText) {
        ContentCaptureSessionCompat contentCaptureSessionCompat;
        if (Build.VERSION.SDK_INT >= 29 && (contentCaptureSessionCompat = this.contentCaptureSession) != null) {
            AutofillId newAutofillId = contentCaptureSessionCompat.newAutofillId(id);
            if (newAutofillId != null) {
                contentCaptureSessionCompat.notifyViewTextChanged(newAutofillId, newText);
            } else {
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Invalid content capture ID");
                throw new KotlinNothingValueException();
            }
        }
    }

    private final void sendSemanticsStructureChangeEvents(SemanticsNode newNode, SemanticsNodeCopy oldNode) {
        int i5 = 0;
        MutableIntSet mutableIntSet = new MutableIntSet(i5, 1, null);
        List<SemanticsNode> replacedChildren$ui_release = newNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int i6 = 0; i6 < size; i6++) {
            SemanticsNode semanticsNode = replacedChildren$ui_release.get(i6);
            if (getCurrentSemanticsNodes$ui_release().contains(semanticsNode.getId())) {
                if (!oldNode.getChildren().contains(semanticsNode.getId())) {
                    notifySubtreeStateChangeIfNeeded(newNode.getLayoutNode());
                    return;
                }
                mutableIntSet.add(semanticsNode.getId());
            }
        }
        MutableIntSet children = oldNode.getChildren();
        int[] iArr = children.elements;
        long[] jArr = children.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i7 = 0;
            while (true) {
                long j5 = jArr[i7];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i8 = 8 - ((~(i7 - length)) >>> 31);
                    for (int i9 = 0; i9 < i8; i9++) {
                        if ((255 & j5) < 128 && !mutableIntSet.contains(iArr[(i7 << 3) + i9])) {
                            notifySubtreeStateChangeIfNeeded(newNode.getLayoutNode());
                            return;
                        }
                        j5 >>= 8;
                    }
                    if (i8 != 8) {
                        break;
                    }
                }
                if (i7 == length) {
                    break;
                } else {
                    i7++;
                }
            }
        }
        List<SemanticsNode> replacedChildren$ui_release2 = newNode.getReplacedChildren$ui_release();
        int size2 = replacedChildren$ui_release2.size();
        while (i5 < size2) {
            SemanticsNode semanticsNode2 = replacedChildren$ui_release2.get(i5);
            if (getCurrentSemanticsNodes$ui_release().contains(semanticsNode2.getId())) {
                SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(semanticsNode2.getId());
                if (semanticsNodeCopy == null) {
                    InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("node not present in pruned tree before this change");
                    throw new KotlinNothingValueException();
                }
                sendSemanticsStructureChangeEvents(semanticsNode2, semanticsNodeCopy);
            }
            i5++;
        }
    }

    private final void showTranslatedText() {
        AccessibilityAction accessibilityAction;
        Function1 function1;
        IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes$ui_release = getCurrentSemanticsNodes$ui_release();
        Object[] objArr = currentSemanticsNodes$ui_release.values;
        long[] jArr = currentSemanticsNodes$ui_release.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            long j5 = jArr[i5];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j5) < 128) {
                        SemanticsConfiguration unmergedConfig = ((SemanticsNodeWithAdjustedBounds) objArr[(i5 << 3) + i7]).getSemanticsNode().getUnmergedConfig();
                        if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution()), Boolean.FALSE) && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsActions.INSTANCE.getShowTextSubstitution())) != null && (function1 = (Function1) accessibilityAction.getAction()) != null) {
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    private final ViewStructureCompat toViewStructure(SemanticsNode semanticsNode) {
        AutofillIdCompat autofillId;
        AutofillId autofillId2;
        String m2151toLegacyClassNameV4PA4sw;
        ContentCaptureSessionCompat contentCaptureSessionCompat = this.contentCaptureSession;
        if (contentCaptureSessionCompat == null || Build.VERSION.SDK_INT < 29 || (autofillId = ViewCompatShims.getAutofillId(this.view)) == null) {
            return null;
        }
        if (semanticsNode.getParent() != null) {
            autofillId2 = contentCaptureSessionCompat.newAutofillId(r3.getId());
            if (autofillId2 == null) {
                return null;
            }
        } else {
            autofillId2 = autofillId.toAutofillId();
        }
        ViewStructureCompat newVirtualViewStructure = contentCaptureSessionCompat.newVirtualViewStructure(autofillId2, semanticsNode.getId());
        if (newVirtualViewStructure == null) {
            return null;
        }
        SemanticsConfiguration unmergedConfig = semanticsNode.getUnmergedConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        if (unmergedConfig.contains(semanticsProperties.getPassword())) {
            return null;
        }
        Bundle extras = newVirtualViewStructure.getExtras();
        if (extras != null) {
            extras.putLong("android.view.contentcapture.EventTimestamp", this.currentSemanticsNodesSnapshotTimestampMillis);
        }
        String str = (String) SemanticsConfigurationKt.getOrNull(unmergedConfig, semanticsProperties.getTestTag());
        if (str != null) {
            newVirtualViewStructure.setId(semanticsNode.getId(), null, null, str);
        }
        List list = (List) SemanticsConfigurationKt.getOrNull(unmergedConfig, semanticsProperties.getText());
        if (list != null) {
            newVirtualViewStructure.setClassName("android.widget.TextView");
            newVirtualViewStructure.setText(ListUtilsKt.fastJoinToString$default(list, "\n", null, null, 0, null, null, 62, null));
        }
        AnnotatedString annotatedString = (AnnotatedString) SemanticsConfigurationKt.getOrNull(unmergedConfig, semanticsProperties.getEditableText());
        if (annotatedString != null) {
            newVirtualViewStructure.setClassName("android.widget.EditText");
            newVirtualViewStructure.setText(annotatedString);
        }
        List list2 = (List) SemanticsConfigurationKt.getOrNull(unmergedConfig, semanticsProperties.getContentDescription());
        if (list2 != null) {
            newVirtualViewStructure.setContentDescription(ListUtilsKt.fastJoinToString$default(list2, "\n", null, null, 0, null, null, 62, null));
        }
        Role role = (Role) SemanticsConfigurationKt.getOrNull(unmergedConfig, semanticsProperties.getRole());
        if (role != null && (m2151toLegacyClassNameV4PA4sw = SemanticsUtils_androidKt.m2151toLegacyClassNameV4PA4sw(role.getValue())) != null) {
            newVirtualViewStructure.setClassName(m2151toLegacyClassNameV4PA4sw);
        }
        TextLayoutResult textLayoutResult = SemanticsUtils_androidKt.getTextLayoutResult(unmergedConfig);
        if (textLayoutResult != null) {
            TextLayoutInput layoutInput = textLayoutResult.getLayoutInput();
            newVirtualViewStructure.setTextStyle(TextUnit.m2675getValueimpl(layoutInput.getStyle().m2299getFontSizeXSAIIZE()) * layoutInput.getDensity().getDensity() * layoutInput.getDensity().getFontScale(), 0, 0, 0);
        }
        Rect boundsInParent$ui_release = semanticsNode.getBoundsInParent$ui_release();
        newVirtualViewStructure.setDimens((int) boundsInParent$ui_release.getLeft(), (int) boundsInParent$ui_release.getTop(), 0, 0, (int) boundsInParent$ui_release.getWidth(), (int) boundsInParent$ui_release.getHeight());
        return newVirtualViewStructure;
    }

    private final void updateBuffersOnAppeared(SemanticsNode node) {
        if (isEnabled$ui_release()) {
            updateTranslationOnAppeared(node);
            bufferContentCaptureViewAppeared(node.getId(), toViewStructure(node));
            List<SemanticsNode> replacedChildren$ui_release = node.getReplacedChildren$ui_release();
            int size = replacedChildren$ui_release.size();
            for (int i5 = 0; i5 < size; i5++) {
                updateBuffersOnAppeared(replacedChildren$ui_release.get(i5));
            }
        }
    }

    private final void updateBuffersOnDisappeared(SemanticsNode node) {
        if (isEnabled$ui_release()) {
            bufferContentCaptureViewDisappeared(node.getId());
            List<SemanticsNode> replacedChildren$ui_release = node.getReplacedChildren$ui_release();
            int size = replacedChildren$ui_release.size();
            for (int i5 = 0; i5 < size; i5++) {
                updateBuffersOnDisappeared(replacedChildren$ui_release.get(i5));
            }
        }
    }

    private final void updateSemanticsCopy() {
        this.previousSemanticsNodes.clear();
        IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes$ui_release = getCurrentSemanticsNodes$ui_release();
        int[] iArr = currentSemanticsNodes$ui_release.keys;
        Object[] objArr = currentSemanticsNodes$ui_release.values;
        long[] jArr = currentSemanticsNodes$ui_release.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128) {
                            int i8 = (i5 << 3) + i7;
                            this.previousSemanticsNodes.set(iArr[i8], new SemanticsNodeCopy(((SemanticsNodeWithAdjustedBounds) objArr[i8]).getSemanticsNode(), getCurrentSemanticsNodes$ui_release()));
                        }
                        j5 >>= 8;
                    }
                    if (i6 != 8) {
                        break;
                    }
                }
                if (i5 == length) {
                    break;
                } else {
                    i5++;
                }
            }
        }
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), getCurrentSemanticsNodes$ui_release());
    }

    private final void updateTranslationOnAppeared(SemanticsNode node) {
        AccessibilityAction accessibilityAction;
        Function1 function1;
        Function1 function12;
        SemanticsConfiguration unmergedConfig = node.getUnmergedConfig();
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsProperties.INSTANCE.getIsShowingTextSubstitution());
        if (this.translateStatus == TranslateStatus.SHOW_ORIGINAL && Intrinsics.areEqual(bool, Boolean.TRUE)) {
            AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsActions.INSTANCE.getShowTextSubstitution());
            if (accessibilityAction2 == null || (function12 = (Function1) accessibilityAction2.getAction()) == null) {
                return;
            }
            return;
        }
        if (this.translateStatus != TranslateStatus.SHOW_TRANSLATED || !Intrinsics.areEqual(bool, Boolean.FALSE) || (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsActions.INSTANCE.getShowTextSubstitution())) == null || (function1 = (Function1) accessibilityAction.getAction()) == null) {
            return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006e A[Catch: all -> 0x0035, TryCatch #1 {all -> 0x0035, blocks: (B:12:0x0030, B:14:0x0056, B:19:0x0066, B:21:0x006e, B:23:0x0077, B:24:0x007a, B:26:0x007e, B:27:0x0087, B:36:0x0048), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0098 -> B:13:0x0033). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object boundsUpdatesEventLoop$ui_release(Continuation<? super Unit> continuation) {
        AndroidContentCaptureManager$boundsUpdatesEventLoop$1 androidContentCaptureManager$boundsUpdatesEventLoop$1;
        int i5;
        AndroidContentCaptureManager androidContentCaptureManager;
        ChannelIterator<Unit> it;
        ChannelIterator<Unit> channelIterator;
        Object hasNext;
        try {
            if (continuation instanceof AndroidContentCaptureManager$boundsUpdatesEventLoop$1) {
                androidContentCaptureManager$boundsUpdatesEventLoop$1 = (AndroidContentCaptureManager$boundsUpdatesEventLoop$1) continuation;
                int i6 = androidContentCaptureManager$boundsUpdatesEventLoop$1.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    androidContentCaptureManager$boundsUpdatesEventLoop$1.label = i6 - Integer.MIN_VALUE;
                    Object obj = androidContentCaptureManager$boundsUpdatesEventLoop$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = androidContentCaptureManager$boundsUpdatesEventLoop$1.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        try {
                            it = this.boundsUpdateChannel.iterator();
                            androidContentCaptureManager = this;
                            androidContentCaptureManager$boundsUpdatesEventLoop$1.L$0 = androidContentCaptureManager;
                            androidContentCaptureManager$boundsUpdatesEventLoop$1.L$1 = it;
                            androidContentCaptureManager$boundsUpdatesEventLoop$1.label = 1;
                            hasNext = it.hasNext(androidContentCaptureManager$boundsUpdatesEventLoop$1);
                            if (hasNext == coroutine_suspended) {
                            }
                        } catch (Throwable th) {
                            th = th;
                            androidContentCaptureManager = this;
                            androidContentCaptureManager.subtreeChangedLayoutNodes.clear();
                            throw th;
                        }
                    } else if (i5 == 1) {
                        channelIterator = (ChannelIterator) androidContentCaptureManager$boundsUpdatesEventLoop$1.L$1;
                        androidContentCaptureManager = (AndroidContentCaptureManager) androidContentCaptureManager$boundsUpdatesEventLoop$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (((Boolean) obj).booleanValue()) {
                        }
                    } else {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        channelIterator = (ChannelIterator) androidContentCaptureManager$boundsUpdatesEventLoop$1.L$1;
                        androidContentCaptureManager = (AndroidContentCaptureManager) androidContentCaptureManager$boundsUpdatesEventLoop$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        it = channelIterator;
                        androidContentCaptureManager$boundsUpdatesEventLoop$1.L$0 = androidContentCaptureManager;
                        androidContentCaptureManager$boundsUpdatesEventLoop$1.L$1 = it;
                        androidContentCaptureManager$boundsUpdatesEventLoop$1.label = 1;
                        hasNext = it.hasNext(androidContentCaptureManager$boundsUpdatesEventLoop$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        channelIterator = it;
                        obj = hasNext;
                        if (((Boolean) obj).booleanValue()) {
                            androidContentCaptureManager.subtreeChangedLayoutNodes.clear();
                            return Unit.INSTANCE;
                        }
                        channelIterator.next();
                        if (androidContentCaptureManager.isEnabled$ui_release()) {
                            androidContentCaptureManager.notifyContentCaptureChanges();
                        }
                        if (!androidContentCaptureManager.checkingForSemanticsChanges) {
                            androidContentCaptureManager.checkingForSemanticsChanges = true;
                            androidContentCaptureManager.handler.post(androidContentCaptureManager.contentCaptureChangeChecker);
                        }
                        androidContentCaptureManager.subtreeChangedLayoutNodes.clear();
                        long j5 = androidContentCaptureManager.SendRecurringContentCaptureEventsIntervalMillis;
                        androidContentCaptureManager$boundsUpdatesEventLoop$1.L$0 = androidContentCaptureManager;
                        androidContentCaptureManager$boundsUpdatesEventLoop$1.L$1 = channelIterator;
                        androidContentCaptureManager$boundsUpdatesEventLoop$1.label = 2;
                        if (DelayKt.delay(j5, androidContentCaptureManager$boundsUpdatesEventLoop$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        it = channelIterator;
                        androidContentCaptureManager$boundsUpdatesEventLoop$1.L$0 = androidContentCaptureManager;
                        androidContentCaptureManager$boundsUpdatesEventLoop$1.L$1 = it;
                        androidContentCaptureManager$boundsUpdatesEventLoop$1.label = 1;
                        hasNext = it.hasNext(androidContentCaptureManager$boundsUpdatesEventLoop$1);
                        if (hasNext == coroutine_suspended) {
                        }
                    }
                }
            }
            if (i5 != 0) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
        androidContentCaptureManager$boundsUpdatesEventLoop$1 = new AndroidContentCaptureManager$boundsUpdatesEventLoop$1(this, continuation);
        Object obj2 = androidContentCaptureManager$boundsUpdatesEventLoop$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = androidContentCaptureManager$boundsUpdatesEventLoop$1.label;
    }

    public final IntObjectMap<SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes$ui_release() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            this.currentSemanticsNodes = SemanticsUtils_androidKt.getAllUncoveredSemanticsNodesToIntObjectMap(this.view.getSemanticsOwner());
            this.currentSemanticsNodesSnapshotTimestampMillis = System.currentTimeMillis();
        }
        return this.currentSemanticsNodes;
    }

    public final AndroidComposeView getView() {
        return this.view;
    }

    public final boolean isEnabled$ui_release() {
        return ContentCaptureManager.INSTANCE.isEnabled() && this.contentCaptureSession != null;
    }

    public final void onClearTranslation$ui_release() {
        this.translateStatus = TranslateStatus.SHOW_ORIGINAL;
        clearTranslatedText();
    }

    public final void onCreateVirtualViewTranslationRequests$ui_release(long[] virtualIds, int[] supportedFormats, Consumer<ViewTranslationRequest> requestsCollector) {
        ViewTranslationHelperMethods.INSTANCE.onCreateVirtualViewTranslationRequests(this, virtualIds, supportedFormats, requestsCollector);
    }

    public final void onHideTranslation$ui_release() {
        this.translateStatus = TranslateStatus.SHOW_ORIGINAL;
        hideTranslatedText();
    }

    public final void onLayoutChange$ui_release(LayoutNode layoutNode) {
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui_release()) {
            notifySubtreeStateChangeIfNeeded(layoutNode);
        }
    }

    public final void onSemanticsChange$ui_release() {
        this.currentSemanticsNodesInvalidated = true;
        if (!isEnabled$ui_release() || this.checkingForSemanticsChanges) {
            return;
        }
        this.checkingForSemanticsChanges = true;
        this.handler.post(this.contentCaptureChangeChecker);
    }

    public final void onShowTranslation$ui_release() {
        this.translateStatus = TranslateStatus.SHOW_TRANSLATED;
        showTranslatedText();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner owner) {
        this.contentCaptureSession = this.onContentCaptureSession.invoke();
        updateBuffersOnAppeared(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode());
        notifyContentCaptureChanges();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner owner) {
        updateBuffersOnDisappeared(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode());
        notifyContentCaptureChanges();
        this.contentCaptureSession = null;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v5) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v5) {
        this.handler.removeCallbacks(this.contentCaptureChangeChecker);
        this.contentCaptureSession = null;
    }

    public final void onVirtualViewTranslationResponses$ui_release(AndroidContentCaptureManager contentCaptureManager, LongSparseArray<ViewTranslationResponse> response) {
        ViewTranslationHelperMethods.INSTANCE.onVirtualViewTranslationResponses(contentCaptureManager, response);
    }
}
