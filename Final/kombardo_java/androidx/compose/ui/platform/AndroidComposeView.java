package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.SystemClock;
import android.os.Trace;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.ScrollCaptureTarget;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.translation.ViewTranslationRequest;
import android.view.translation.ViewTranslationResponse;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.SessionMutex;
import androidx.compose.ui.autofill.AndroidAutofill;
import androidx.compose.ui.autofill.AndroidAutofill_androidKt;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillCallback;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.draganddrop.ComposeDragShadowBuilder;
import androidx.compose.ui.draganddrop.DragAndDropManager;
import androidx.compose.ui.draganddrop.DragAndDropTransferData;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.focus.FocusOwnerImplKt;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTransactionsKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidGraphicsContext_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.MotionEventAdapter;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.input.pointer.PointerInputEvent;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.input.pointer.PointerInputEventProcessor;
import androidx.compose.ui.input.pointer.PointerInputEventProcessorKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.ui.input.pointer.PositionCalculator;
import androidx.compose.ui.input.pointer.ProcessResult;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryInputModifierKt;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.RootMeasurePolicy;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import androidx.compose.ui.node.NestedVectorStack;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.ViewLayer;
import androidx.compose.ui.scrollcapture.ScrollCapture;
import androidx.compose.ui.semantics.EmptySemanticsElement;
import androidx.compose.ui.semantics.EmptySemanticsModifier;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.sun.jna.Callback;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000¶\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0002¥\u0004\b\u0000\u0018\u0000 ×\u00042\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004×\u0004Ø\u0004B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J&\u0010\u001d\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 J6\u0010*\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u001e0%H\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0001H\u0002¢\u0006\u0004\b,\u0010-J'\u00103\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u00152\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u000201H\u0002¢\u0006\u0004\b3\u00104J\u001b\u00107\u001a\u00020\u001e2\n\b\u0002\u00106\u001a\u0004\u0018\u000105H\u0002¢\u0006\u0004\b7\u00108J\u0013\u00109\u001a\u00020\u000e*\u000205H\u0002¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u001eH\u0002¢\u0006\u0004\b;\u0010 J%\u0010A\u001a\u00020>2\u0006\u0010<\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u0015H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@J\u001d\u0010E\u001a\u00020>2\u0006\u0010B\u001a\u00020\u0015H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\u000f\u0010F\u001a\u00020\u001eH\u0002¢\u0006\u0004\bF\u0010 J\u0017\u0010H\u001a\u00020\u001e2\u0006\u0010G\u001a\u000205H\u0002¢\u0006\u0004\bH\u00108J\u0017\u0010I\u001a\u00020\u001e2\u0006\u0010G\u001a\u000205H\u0002¢\u0006\u0004\bI\u00108J\u0017\u0010L\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020JH\u0002¢\u0006\u0004\bL\u0010MJ\u001d\u0010R\u001a\u00020O2\u0006\u0010N\u001a\u00020JH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ\u001f\u0010T\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020J2\u0006\u0010S\u001a\u00020JH\u0002¢\u0006\u0004\bT\u0010UJ\u0017\u0010V\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020JH\u0002¢\u0006\u0004\bV\u0010MJ\u001d\u0010X\u001a\u00020O2\u0006\u0010N\u001a\u00020JH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bW\u0010QJ1\u0010]\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020J2\u0006\u0010Y\u001a\u00020\u00152\u0006\u0010[\u001a\u00020Z2\b\b\u0002\u0010\\\u001a\u00020\u000eH\u0002¢\u0006\u0004\b]\u0010^J\u0017\u0010_\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020JH\u0002¢\u0006\u0004\b_\u0010MJ\u000f\u0010`\u001a\u00020\u001eH\u0002¢\u0006\u0004\b`\u0010 J\u0017\u0010`\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020JH\u0002¢\u0006\u0004\b`\u0010aJ\u000f\u0010b\u001a\u00020\u001eH\u0002¢\u0006\u0004\bb\u0010 J\u000f\u0010c\u001a\u00020\u000eH\u0002¢\u0006\u0004\bc\u0010dJ\u0017\u0010e\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020JH\u0002¢\u0006\u0004\be\u0010MJ\u0017\u0010f\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020JH\u0002¢\u0006\u0004\bf\u0010MJ!\u0010i\u001a\u0004\u0018\u00010\u00172\u0006\u0010g\u001a\u00020\u00152\u0006\u0010h\u001a\u00020\u0017H\u0002¢\u0006\u0004\bi\u0010jJ4\u0010p\u001a\u00020n2\"\u0010o\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020l\u0012\n\u0012\b\u0012\u0004\u0012\u00020n0m\u0012\u0006\u0012\u0004\u0018\u00010l0kH\u0096@¢\u0006\u0004\bp\u0010qJ\u0017\u0010t\u001a\u00020\u001e2\u0006\u0010s\u001a\u00020rH\u0016¢\u0006\u0004\bt\u0010uJ\u0017\u0010x\u001a\u00020\u001e2\u0006\u0010w\u001a\u00020vH\u0016¢\u0006\u0004\bx\u0010yJ0\u0010\u0080\u0001\u001a\u00020\u001e2\u0006\u0010z\u001a\u00020r2\u0006\u0010|\u001a\u00020{2\f\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020~0}H\u0016¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\u001c\u0010\u0084\u0001\u001a\u00020\u001e2\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001H\u0016¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J'\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00172\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J$\u0010\u0089\u0001\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010rH\u0016¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J-\u0010\u008c\u0001\u001a\u00020\u001e2\u0007\u0010\u008b\u0001\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010rH\u0014¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u001b\u0010\u008f\u0001\u001a\u00020\u001e2\u0007\u0010\u008e\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u001b\u0010\u0092\u0001\u001a\u00020\u000e2\u0007\u0010K\u001a\u00030\u0091\u0001H\u0016¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u001b\u0010\u0094\u0001\u001a\u00020\u000e2\u0007\u0010K\u001a\u00030\u0091\u0001H\u0016¢\u0006\u0006\b\u0094\u0001\u0010\u0093\u0001J\u001b\u0010\u0096\u0001\u001a\u00020\u001e2\u0007\u0010\u0095\u0001\u001a\u00020ZH\u0016¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u0019\u0010\u0098\u0001\u001a\u00020\u001e2\u0006\u0010G\u001a\u000205H\u0016¢\u0006\u0005\b\u0098\u0001\u00108J\u0019\u0010\u0099\u0001\u001a\u00020\u001e2\u0006\u0010G\u001a\u000205H\u0016¢\u0006\u0005\b\u0099\u0001\u00108J\u000f\u0010\u009a\u0001\u001a\u00020\u001e¢\u0006\u0005\b\u009a\u0001\u0010 J\u0011\u0010\u009b\u0001\u001a\u00020\u001eH\u0016¢\u0006\u0005\b\u009b\u0001\u0010 J\"\u0010\u009e\u0001\u001a\u00020\u001e2\u000e\u0010\u009d\u0001\u001a\t\u0012\u0004\u0012\u00020\u001e0\u009c\u0001H\u0016¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\u001d\u0010¡\u0001\u001a\u00020\u001e2\t\u0010 \u0001\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0006\b¡\u0001\u0010¢\u0001J&\u0010¡\u0001\u001a\u00020\u001e2\t\u0010 \u0001\u001a\u0004\u0018\u00010\u00172\u0007\u0010£\u0001\u001a\u00020\u0015H\u0016¢\u0006\u0006\b¡\u0001\u0010¤\u0001J/\u0010¡\u0001\u001a\u00020\u001e2\t\u0010 \u0001\u001a\u0004\u0018\u00010\u00172\u0007\u0010¥\u0001\u001a\u00020\u00152\u0007\u0010¦\u0001\u001a\u00020\u0015H\u0016¢\u0006\u0006\b¡\u0001\u0010§\u0001J)\u0010¡\u0001\u001a\u00020\u001e2\t\u0010 \u0001\u001a\u0004\u0018\u00010\u00172\n\u0010©\u0001\u001a\u0005\u0018\u00010¨\u0001H\u0016¢\u0006\u0006\b¡\u0001\u0010ª\u0001J2\u0010¡\u0001\u001a\u00020\u001e2\t\u0010 \u0001\u001a\u0004\u0018\u00010\u00172\u0007\u0010£\u0001\u001a\u00020\u00152\n\u0010©\u0001\u001a\u0005\u0018\u00010¨\u0001H\u0016¢\u0006\u0006\b¡\u0001\u0010«\u0001J#\u0010¯\u0001\u001a\u00020\u001e2\b\u0010\u00ad\u0001\u001a\u00030¬\u00012\u0007\u0010®\u0001\u001a\u000205¢\u0006\u0006\b¯\u0001\u0010°\u0001J\u001a\u0010±\u0001\u001a\u00020\u001e2\b\u0010\u00ad\u0001\u001a\u00030¬\u0001¢\u0006\u0006\b±\u0001\u0010²\u0001J$\u0010µ\u0001\u001a\u00020\u001e2\b\u0010\u00ad\u0001\u001a\u00030¬\u00012\b\u0010´\u0001\u001a\u00030³\u0001¢\u0006\u0006\bµ\u0001\u0010¶\u0001J\u001b\u0010¸\u0001\u001a\u00020\u001e2\u0007\u0010·\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0006\b¸\u0001\u0010\u0090\u0001J(\u0010¸\u0001\u001a\u00020\u001e2\u0007\u0010®\u0001\u001a\u0002052\b\u0010º\u0001\u001a\u00030¹\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\b»\u0001\u0010¼\u0001J$\u0010¾\u0001\u001a\u00020\u001e2\u0007\u0010®\u0001\u001a\u0002052\u0007\u0010½\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0006\b¾\u0001\u0010¿\u0001J5\u0010Á\u0001\u001a\u00020\u001e2\u0007\u0010®\u0001\u001a\u0002052\u0007\u0010½\u0001\u001a\u00020\u000e2\u0007\u0010À\u0001\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u000eH\u0016¢\u0006\u0006\bÁ\u0001\u0010Â\u0001J-\u0010Ã\u0001\u001a\u00020\u001e2\u0007\u0010®\u0001\u001a\u0002052\u0007\u0010½\u0001\u001a\u00020\u000e2\u0007\u0010À\u0001\u001a\u00020\u000eH\u0016¢\u0006\u0006\bÃ\u0001\u0010Ä\u0001J\u001a\u0010Å\u0001\u001a\u00020\u001e2\u0007\u0010®\u0001\u001a\u000205H\u0016¢\u0006\u0005\bÅ\u0001\u00108J$\u0010È\u0001\u001a\u00020\u001e2\u0007\u0010Æ\u0001\u001a\u00020\u00152\u0007\u0010Ç\u0001\u001a\u00020\u0015H\u0014¢\u0006\u0006\bÈ\u0001\u0010É\u0001J>\u0010Î\u0001\u001a\u00020\u001e2\u0007\u0010Ê\u0001\u001a\u00020\u000e2\u0007\u0010Ë\u0001\u001a\u00020\u00152\u0007\u0010Ì\u0001\u001a\u00020\u00152\u0007\u0010Í\u0001\u001a\u00020\u00152\u0006\u0010=\u001a\u00020\u0015H\u0014¢\u0006\u0006\bÎ\u0001\u0010Ï\u0001J\u001c\u0010Ð\u0001\u001a\u00020\u001e2\b\u0010´\u0001\u001a\u00030³\u0001H\u0014¢\u0006\u0006\bÐ\u0001\u0010Ñ\u0001JN\u0010Ø\u0001\u001a\u00030×\u00012\u001d\u0010Ô\u0001\u001a\u0018\u0012\u0005\u0012\u00030Ò\u0001\u0012\u0007\u0012\u0005\u0018\u00010Ó\u0001\u0012\u0004\u0012\u00020\u001e0k2\u000e\u0010Õ\u0001\u001a\t\u0012\u0004\u0012\u00020\u001e0\u009c\u00012\n\u0010Ö\u0001\u001a\u0005\u0018\u00010Ó\u0001H\u0016¢\u0006\u0006\bØ\u0001\u0010Ù\u0001J\u001c\u0010Ý\u0001\u001a\u00020\u000e2\b\u0010Ú\u0001\u001a\u00030×\u0001H\u0000¢\u0006\u0006\bÛ\u0001\u0010Ü\u0001J\u0011\u0010Þ\u0001\u001a\u00020\u001eH\u0016¢\u0006\u0005\bÞ\u0001\u0010 J\u001a\u0010ß\u0001\u001a\u00020\u001e2\u0007\u0010®\u0001\u001a\u000205H\u0016¢\u0006\u0005\bß\u0001\u00108J \u0010á\u0001\u001a\u00020\u001e2\f\u0010\u00ad\u0001\u001a\u00070\u0017j\u0003`à\u0001H\u0016¢\u0006\u0006\bá\u0001\u0010¢\u0001J!\u0010æ\u0001\u001a\u0004\u0018\u00010\f2\b\u0010ã\u0001\u001a\u00030â\u0001H\u0016ø\u0001\u0000¢\u0006\u0006\bä\u0001\u0010å\u0001J\u001c\u0010ç\u0001\u001a\u00020\u001e2\b\u0010´\u0001\u001a\u00030³\u0001H\u0014¢\u0006\u0006\bç\u0001\u0010Ñ\u0001J%\u0010ë\u0001\u001a\u00020\u001e2\b\u0010Ú\u0001\u001a\u00030×\u00012\u0007\u0010è\u0001\u001a\u00020\u000eH\u0000¢\u0006\u0006\bé\u0001\u0010ê\u0001J&\u0010î\u0001\u001a\u00020\u001e2\u0014\u0010í\u0001\u001a\u000f\u0012\u0005\u0012\u00030ì\u0001\u0012\u0004\u0012\u00020\u001e0%¢\u0006\u0006\bî\u0001\u0010ï\u0001J\u0013\u0010ð\u0001\u001a\u00020\u001eH\u0086@¢\u0006\u0006\bð\u0001\u0010ñ\u0001J\u0013\u0010ò\u0001\u001a\u00020\u001eH\u0086@¢\u0006\u0006\bò\u0001\u0010ñ\u0001J\u0011\u0010ó\u0001\u001a\u00020\u001eH\u0016¢\u0006\u0005\bó\u0001\u0010 J\u0011\u0010ô\u0001\u001a\u00020\u001eH\u0014¢\u0006\u0005\bô\u0001\u0010 J\u0011\u0010õ\u0001\u001a\u00020\u001eH\u0014¢\u0006\u0005\bõ\u0001\u0010 J%\u0010÷\u0001\u001a\u00020\u001e2\b\u0010w\u001a\u0004\u0018\u00010v2\u0007\u0010ö\u0001\u001a\u00020\u0015H\u0016¢\u0006\u0006\b÷\u0001\u0010ø\u0001J#\u0010ü\u0001\u001a\u00020\u001e2\u000f\u0010û\u0001\u001a\n\u0012\u0005\u0012\u00030ú\u00010ù\u0001H\u0016¢\u0006\u0006\bü\u0001\u0010ý\u0001J8\u0010\u0084\u0002\u001a\u00020\u001e2\b\u0010ÿ\u0001\u001a\u00030þ\u00012\b\u0010\u0081\u0002\u001a\u00030\u0080\u00022\u0010\u0010\u0083\u0002\u001a\u000b\u0012\u0007\u0012\u0005\u0018\u00010\u0082\u00020}H\u0017¢\u0006\u0006\b\u0084\u0002\u0010\u0085\u0002J%\u0010\u0089\u0002\u001a\u00020\u001e2\u0011\u0010\u0088\u0002\u001a\f\u0012\u0007\u0012\u0005\u0018\u00010\u0087\u00020\u0086\u0002H\u0017¢\u0006\u0006\b\u0089\u0002\u0010\u008a\u0002J\u0019\u0010\u008b\u0002\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020JH\u0016¢\u0006\u0005\b\u008b\u0002\u0010MJ\u0019\u0010\u008c\u0002\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020JH\u0016¢\u0006\u0005\b\u008c\u0002\u0010MJ\u0019\u0010\u008d\u0002\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0005\b\u008d\u0002\u0010\u0010J\u0019\u0010\u008e\u0002\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0005\b\u008e\u0002\u0010\u0010J \u0010\u0093\u0002\u001a\u00030\u008f\u00022\b\u0010\u0090\u0002\u001a\u00030\u008f\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0091\u0002\u0010\u0092\u0002J\u001f\u0010\u0093\u0002\u001a\u00020\u001e2\b\u0010\u0095\u0002\u001a\u00030\u0094\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0096\u0002\u0010\u0097\u0002J \u0010\u009a\u0002\u001a\u00030\u008f\u00022\b\u0010\u0098\u0002\u001a\u00030\u008f\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\b\u0099\u0002\u0010\u0092\u0002J\u0011\u0010\u009b\u0002\u001a\u00020\u000eH\u0016¢\u0006\u0005\b\u009b\u0002\u0010dJ\u001f\u0010\u009f\u0002\u001a\u0005\u0018\u00010\u009e\u00022\b\u0010\u009d\u0002\u001a\u00030\u009c\u0002H\u0016¢\u0006\u0006\b\u009f\u0002\u0010 \u0002J \u0010£\u0002\u001a\u00030\u008f\u00022\b\u0010¡\u0002\u001a\u00030\u008f\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\b¢\u0002\u0010\u0092\u0002J \u0010¥\u0002\u001a\u00030\u008f\u00022\b\u0010\u0090\u0002\u001a\u00030\u008f\u0002H\u0016ø\u0001\u0000¢\u0006\u0006\b¤\u0002\u0010\u0092\u0002J\u001c\u0010¨\u0002\u001a\u00020\u001e2\b\u0010§\u0002\u001a\u00030¦\u0002H\u0014¢\u0006\u0006\b¨\u0002\u0010©\u0002J\u001b\u0010«\u0002\u001a\u00020\u001e2\u0007\u0010ª\u0002\u001a\u00020\u0015H\u0016¢\u0006\u0006\b«\u0002\u0010¬\u0002J\u0019\u0010\u00ad\u0002\u001a\u00020\u000e2\u0006\u0010K\u001a\u00020JH\u0016¢\u0006\u0005\b\u00ad\u0002\u0010MJ\u0019\u0010®\u0002\u001a\u0004\u0018\u00010\u00172\u0006\u0010g\u001a\u00020\u0015¢\u0006\u0005\b®\u0002\u0010\u0019J\u0011\u0010¯\u0002\u001a\u00020\u000eH\u0016¢\u0006\u0005\b¯\u0002\u0010dR \u0010°\u0002\u001a\u00030\u008f\u00028\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\b°\u0002\u0010±\u0002R\u0019\u0010²\u0002\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0002\u0010³\u0002R \u0010µ\u0002\u001a\u00030´\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bµ\u0002\u0010¶\u0002\u001a\u0006\b·\u0002\u0010¸\u0002R5\u0010Á\u0002\u001a\u00030¹\u00022\b\u0010º\u0002\u001a\u00030¹\u00028V@RX\u0096\u008e\u0002¢\u0006\u0018\n\u0006\b»\u0002\u0010¼\u0002\u001a\u0006\b½\u0002\u0010¾\u0002\"\u0006\b¿\u0002\u0010À\u0002R\u0018\u0010Ã\u0002\u001a\u00030Â\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÃ\u0002\u0010Ä\u0002R\u0018\u0010Æ\u0002\u001a\u00030Å\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÆ\u0002\u0010Ç\u0002R \u0010É\u0002\u001a\u00030È\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bÉ\u0002\u0010Ê\u0002\u001a\u0006\bË\u0002\u0010Ì\u0002R\u0018\u0010Î\u0002\u001a\u00030Í\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÎ\u0002\u0010Ï\u0002R0\u0010\t\u001a\u00020\b2\u0007\u0010Ð\u0002\u001a\u00020\b8\u0016@VX\u0096\u000e¢\u0006\u0017\n\u0005\b\t\u0010Ñ\u0002\u001a\u0006\bÒ\u0002\u0010Ó\u0002\"\u0006\bÔ\u0002\u0010Õ\u0002R \u0010×\u0002\u001a\u00030Ö\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b×\u0002\u0010Ø\u0002\u001a\u0006\bÙ\u0002\u0010Ú\u0002R\u0018\u0010Ü\u0002\u001a\u00030Û\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÜ\u0002\u0010Ý\u0002R\u0018\u0010ß\u0002\u001a\u00030Þ\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bß\u0002\u0010à\u0002R\u0018\u0010á\u0002\u001a\u00030Þ\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bá\u0002\u0010à\u0002R\u0018\u0010ã\u0002\u001a\u00030â\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bã\u0002\u0010ä\u0002R\u001f\u0010å\u0002\u001a\u0002058\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bå\u0002\u0010æ\u0002\u001a\u0006\bç\u0002\u0010è\u0002R \u0010ê\u0002\u001a\u00030é\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bê\u0002\u0010ë\u0002\u001a\u0006\bì\u0002\u0010í\u0002R \u0010ï\u0002\u001a\u00030î\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bï\u0002\u0010ð\u0002\u001a\u0006\bñ\u0002\u0010ò\u0002R\u0018\u0010ô\u0002\u001a\u00030ó\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bô\u0002\u0010õ\u0002R*\u0010÷\u0002\u001a\u00030ö\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b÷\u0002\u0010ø\u0002\u001a\u0006\bù\u0002\u0010ú\u0002\"\u0006\bû\u0002\u0010ü\u0002R \u0010þ\u0002\u001a\u00030ý\u00028\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bþ\u0002\u0010ÿ\u0002\u001a\u0006\b\u0080\u0003\u0010\u0081\u0003R \u0010\u0083\u0003\u001a\u00030\u0082\u00038\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0083\u0003\u0010\u0084\u0003\u001a\u0006\b\u0085\u0003\u0010\u0086\u0003R \u0010\u0088\u0003\u001a\u00030\u0087\u00038\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0088\u0003\u0010\u0089\u0003\u001a\u0006\b\u008a\u0003\u0010\u008b\u0003R\u001f\u0010\u008d\u0003\u001a\n\u0012\u0005\u0012\u00030×\u00010\u008c\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008d\u0003\u0010\u008e\u0003R#\u0010\u008f\u0003\u001a\f\u0012\u0005\u0012\u00030×\u0001\u0018\u00010\u008c\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008f\u0003\u0010\u008e\u0003R\u0019\u0010\u0090\u0003\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0003\u0010³\u0002R\u0019\u0010\u0091\u0003\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0091\u0003\u0010³\u0002R\u0018\u0010\u0093\u0003\u001a\u00030\u0092\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0093\u0003\u0010\u0094\u0003R\u0018\u0010\u0096\u0003\u001a\u00030\u0095\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0096\u0003\u0010\u0097\u0003R6\u0010\u0098\u0003\u001a\u000f\u0012\u0005\u0012\u00030¦\u0002\u0012\u0004\u0012\u00020\u001e0%8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0098\u0003\u0010\u0099\u0003\u001a\u0006\b\u009a\u0003\u0010\u009b\u0003\"\u0006\b\u009c\u0003\u0010ï\u0001R\u001a\u0010\u009e\u0003\u001a\u0005\u0018\u00010\u009d\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009e\u0003\u0010\u009f\u0003R\u0019\u0010 \u0003\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0003\u0010³\u0002R \u0010¢\u0003\u001a\u00030¡\u00038\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b¢\u0003\u0010£\u0003\u001a\u0006\b¤\u0003\u0010¥\u0003R \u0010§\u0003\u001a\u00030¦\u00038\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b§\u0003\u0010¨\u0003\u001a\u0006\b©\u0003\u0010ª\u0003R/\u0010«\u0003\u001a\u00020\u000e8\u0016@\u0016X\u0096\u000e¢\u0006\u001e\n\u0006\b«\u0003\u0010³\u0002\u0012\u0005\b®\u0003\u0010 \u001a\u0005\b¬\u0003\u0010d\"\u0006\b\u00ad\u0003\u0010\u0090\u0001R\u001c\u0010°\u0003\u001a\u0005\u0018\u00010¯\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0003\u0010±\u0003R\u001c\u0010³\u0003\u001a\u0005\u0018\u00010²\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0003\u0010´\u0003R\"\u0010µ\u0003\u001a\u0005\u0018\u00010¹\u00018\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\bµ\u0003\u0010¶\u0003R\u0019\u0010·\u0003\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0003\u0010³\u0002R\u0018\u0010¹\u0003\u001a\u00030¸\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¹\u0003\u0010º\u0003R \u0010¼\u0003\u001a\u00030»\u00038\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b¼\u0003\u0010½\u0003\u001a\u0006\b¾\u0003\u0010¿\u0003R \u0010Á\u0003\u001a\u00030À\u00038\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\bÁ\u0003\u0010±\u0002R\u0018\u0010Â\u0003\u001a\u00030\u0080\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÂ\u0003\u0010Ã\u0003R\u001e\u0010Ä\u0003\u001a\u00030\u0094\u00028\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\bÄ\u0003\u0010Å\u0003R\u001e\u0010Æ\u0003\u001a\u00030\u0094\u00028\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\bÆ\u0003\u0010Å\u0003R\u001e\u0010Ç\u0003\u001a\u00030\u0094\u00028\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\bÇ\u0003\u0010Å\u0003R0\u0010È\u0003\u001a\u00020Z8\u0000@\u0000X\u0081\u000e¢\u0006\u001f\n\u0006\bÈ\u0003\u0010±\u0002\u0012\u0005\bÌ\u0003\u0010 \u001a\u0006\bÉ\u0003\u0010Ê\u0003\"\u0006\bË\u0003\u0010\u0097\u0001R\u0019\u0010Í\u0003\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0003\u0010³\u0002R \u0010Î\u0003\u001a\u00030\u008f\u00028\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\bÎ\u0003\u0010±\u0002R\u0019\u0010Ï\u0003\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0003\u0010³\u0002R9\u0010Õ\u0003\u001a\u0005\u0018\u00010ì\u00012\n\u0010º\u0002\u001a\u0005\u0018\u00010ì\u00018B@BX\u0082\u008e\u0002¢\u0006\u0018\n\u0006\bÐ\u0003\u0010¼\u0002\u001a\u0006\bÑ\u0003\u0010Ò\u0003\"\u0006\bÓ\u0003\u0010Ô\u0003R#\u0010Ù\u0003\u001a\u0005\u0018\u00010ì\u00018FX\u0086\u0084\u0002¢\u0006\u0010\n\u0006\bÖ\u0003\u0010×\u0003\u001a\u0006\bØ\u0003\u0010Ò\u0003R(\u0010Ú\u0003\u001a\u0011\u0012\u0005\u0012\u00030ì\u0001\u0012\u0004\u0012\u00020\u001e\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÚ\u0003\u0010\u0099\u0003R\u0018\u0010Ü\u0003\u001a\u00030Û\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÜ\u0003\u0010Ý\u0003R\u0018\u0010ß\u0003\u001a\u00030Þ\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bß\u0003\u0010à\u0003R\u0018\u0010â\u0003\u001a\u00030á\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bâ\u0003\u0010ã\u0003R\u0018\u0010å\u0003\u001a\u00030ä\u00038\u0002X\u0082\u0004¢\u0006\b\n\u0006\bå\u0003\u0010æ\u0003R \u0010è\u0003\u001a\u00030ç\u00038\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bè\u0003\u0010é\u0003\u001a\u0006\bê\u0003\u0010ë\u0003R%\u0010î\u0003\u001a\n\u0012\u0005\u0012\u00030í\u00030ì\u00038\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\b\n\u0006\bî\u0003\u0010ï\u0003R \u0010ñ\u0003\u001a\u00030ð\u00038\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\bñ\u0003\u0010ò\u0003\u001a\u0006\bó\u0003\u0010ô\u0003R'\u0010ö\u0003\u001a\u00030õ\u00038\u0016X\u0097\u0004¢\u0006\u0017\n\u0006\bö\u0003\u0010÷\u0003\u0012\u0005\bú\u0003\u0010 \u001a\u0006\bø\u0003\u0010ù\u0003R5\u0010\u0081\u0004\u001a\u00030û\u00032\b\u0010º\u0002\u001a\u00030û\u00038V@RX\u0096\u008e\u0002¢\u0006\u0018\n\u0006\bü\u0003\u0010¼\u0002\u001a\u0006\bý\u0003\u0010þ\u0003\"\u0006\bÿ\u0003\u0010\u0080\u0004R\u0019\u0010\u0082\u0004\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0004\u0010\u0083\u0004R5\u0010ª\u0002\u001a\u00030\u0084\u00042\b\u0010º\u0002\u001a\u00030\u0084\u00048V@RX\u0096\u008e\u0002¢\u0006\u0018\n\u0006\b\u0085\u0004\u0010¼\u0002\u001a\u0006\b\u0086\u0004\u0010\u0087\u0004\"\u0006\b\u0088\u0004\u0010\u0089\u0004R \u0010\u008b\u0004\u001a\u00030\u008a\u00048\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u008b\u0004\u0010\u008c\u0004\u001a\u0006\b\u008d\u0004\u0010\u008e\u0004R\u0018\u0010\u0090\u0004\u001a\u00030\u008f\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0090\u0004\u0010\u0091\u0004R \u0010\u0093\u0004\u001a\u00030\u0092\u00048\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0093\u0004\u0010\u0094\u0004\u001a\u0006\b\u0095\u0004\u0010\u0096\u0004R \u0010\u0098\u0004\u001a\u00030\u0097\u00048\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0098\u0004\u0010\u0099\u0004\u001a\u0006\b\u009a\u0004\u0010\u009b\u0004R\u001b\u0010\u009c\u0004\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0004\u0010\u009d\u0004R\u0019\u0010\u009e\u0004\u001a\u00020Z8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009e\u0004\u0010±\u0002R\u001f\u0010 \u0004\u001a\n\u0012\u0005\u0012\u00030×\u00010\u009f\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\b \u0004\u0010¡\u0004R'\u0010£\u0004\u001a\u0012\u0012\r\u0012\u000b\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u009c\u00010¢\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\b£\u0004\u0010¤\u0004R\u0018\u0010¦\u0004\u001a\u00030¥\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¦\u0004\u0010§\u0004R\u0018\u0010©\u0004\u001a\u00030¨\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\b©\u0004\u0010ª\u0004R\u0019\u0010«\u0004\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0004\u0010³\u0002R\u001e\u0010¬\u0004\u001a\t\u0012\u0004\u0012\u00020\u001e0\u009c\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¬\u0004\u0010\u00ad\u0004R\u0018\u0010¯\u0004\u001a\u00030®\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¯\u0004\u0010°\u0004R\u0019\u0010±\u0004\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0004\u0010³\u0002R\u001a\u0010³\u0004\u001a\u0005\u0018\u00010²\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\b³\u0004\u0010´\u0004R \u0010¶\u0004\u001a\u00030µ\u00048\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b¶\u0004\u0010·\u0004\u001a\u0006\b¸\u0004\u0010¹\u0004R\u001c\u0010¼\u0004\u001a\u00020\u0015*\u00030¦\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\bº\u0004\u0010»\u0004R\u0017\u0010\u00ad\u0001\u001a\u00020\u00178VX\u0096\u0004¢\u0006\b\u001a\u0006\b½\u0004\u0010¾\u0004R\u0018\u0010Â\u0004\u001a\u00030¿\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\bÀ\u0004\u0010Á\u0004R\u001a\u0010ü\u0001\u001a\u0005\u0018\u00010Ã\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\bÄ\u0004\u0010Å\u0004R\u0018\u0010È\u0004\u001a\u00030¯\u00038@X\u0080\u0004¢\u0006\b\u001a\u0006\bÆ\u0004\u0010Ç\u0004R\u0017\u0010Ê\u0004\u001a\u00020Z8VX\u0096\u0004¢\u0006\b\u001a\u0006\bÉ\u0004\u0010Ê\u0003R\u0016\u0010Ì\u0004\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bË\u0004\u0010dR\u0018\u0010Ð\u0004\u001a\u00030Í\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\bÎ\u0004\u0010Ï\u0004R\u0018\u0010Ô\u0004\u001a\u00030Ñ\u00048VX\u0096\u0004¢\u0006\b\u001a\u0006\bÒ\u0004\u0010Ó\u0004R\u0016\u0010Ö\u0004\u001a\u00020\u000e8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bÕ\u0004\u0010d\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Ù\u0004"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView;", "Landroid/view/ViewGroup;", "Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/platform/ViewRootForTest;", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroid/content/Context;", "context", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;)V", "Landroidx/compose/ui/focus/FocusDirection;", "focusDirection", BuildConfig.FLAVOR, "onMoveFocusInChildren-3ESFkO8", "(I)Z", "onMoveFocusInChildren", "Landroidx/compose/ui/geometry/Rect;", "onFetchFocusRect", "()Landroidx/compose/ui/geometry/Rect;", BuildConfig.FLAVOR, "direction", "Landroid/view/View;", "findNextNonChildView", "(I)Landroid/view/View;", "previouslyFocusedRect", "onRequestFocusForOwner-7o62pno", "(Landroidx/compose/ui/focus/FocusDirection;Landroidx/compose/ui/geometry/Rect;)Z", "onRequestFocusForOwner", BuildConfig.FLAVOR, "onClearFocusForOwner", "()V", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "transferData", "Landroidx/compose/ui/geometry/Size;", "decorationSize", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawDragDecoration", "startDrag-12SF9DM", "(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)Z", "startDrag", "viewGroup", "clearChildInvalidObservations", "(Landroid/view/ViewGroup;)V", "virtualViewId", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", BuildConfig.FLAVOR, "extraDataKey", "addExtraDataToAccessibilityNodeInfoHelper", "(ILandroid/view/accessibility/AccessibilityNodeInfo;Ljava/lang/String;)V", "Landroidx/compose/ui/node/LayoutNode;", "nodeToRemeasure", "scheduleMeasureAndLayout", "(Landroidx/compose/ui/node/LayoutNode;)V", "childSizeCanAffectParentSize", "(Landroidx/compose/ui/node/LayoutNode;)Z", "dispatchPendingInteropLayoutCallbacks", "a", "b", "Lkotlin/ULong;", "pack-ZIaKswc", "(II)J", "pack", "measureSpec", "convertMeasureSpec-I7RO_PI", "(I)J", "convertMeasureSpec", "updatePositionCacheAndDispatch", "node", "invalidateLayoutNodeMeasurement", "invalidateLayers", "Landroid/view/MotionEvent;", "event", "handleRotaryEvent", "(Landroid/view/MotionEvent;)Z", "motionEvent", "Landroidx/compose/ui/input/pointer/ProcessResult;", "handleMotionEvent-8iAsVTc", "(Landroid/view/MotionEvent;)I", "handleMotionEvent", "lastEvent", "hasChangedDevices", "(Landroid/view/MotionEvent;Landroid/view/MotionEvent;)Z", "isDevicePressEvent", "sendMotionEvent-8iAsVTc", "sendMotionEvent", "action", BuildConfig.FLAVOR, "eventTime", "forceHover", "sendSimulatedEvent", "(Landroid/view/MotionEvent;IJZ)V", "isInBounds", "recalculateWindowPosition", "(Landroid/view/MotionEvent;)V", "recalculateWindowViewTransforms", "autofillSupported", "()Z", "isBadMotionEvent", "isPositionChanged", "accessibilityId", "currentView", "findViewByAccessibilityIdRootedAtCurrentView", "(ILandroid/view/View;)Landroid/view/View;", "Lkotlin/Function2;", BuildConfig.FLAVOR, "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "session", "textInputSession", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/graphics/Rect;", "rect", "getFocusedRect", "(Landroid/graphics/Rect;)V", "Landroid/view/ViewStructure;", "structure", "dispatchProvideStructure", "(Landroid/view/ViewStructure;)V", "localVisibleRect", "Landroid/graphics/Point;", "windowOffset", "Ljava/util/function/Consumer;", "Landroid/view/ScrollCaptureTarget;", "targets", "onScrollCaptureSearch", "(Landroid/graphics/Rect;Landroid/graphics/Point;Ljava/util/function/Consumer;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "onResume", "(Landroidx/lifecycle/LifecycleOwner;)V", "focused", "focusSearch", "(Landroid/view/View;I)Landroid/view/View;", "requestFocus", "(ILandroid/graphics/Rect;)Z", "gainFocus", "onFocusChanged", "(ZILandroid/graphics/Rect;)V", "hasWindowFocus", "onWindowFocusChanged", "(Z)V", "Landroid/view/KeyEvent;", "dispatchKeyEvent", "(Landroid/view/KeyEvent;)Z", "dispatchKeyEventPreIme", "intervalMillis", "setAccessibilityEventBatchIntervalMillis", "(J)V", "onAttach", "onDetach", "requestClearInvalidObservations", "onEndApplyChanges", "Lkotlin/Function0;", "listener", "registerOnEndApplyChangesListener", "(Lkotlin/jvm/functions/Function0;)V", "child", "addView", "(Landroid/view/View;)V", "index", "(Landroid/view/View;I)V", "width", "height", "(Landroid/view/View;II)V", "Landroid/view/ViewGroup$LayoutParams;", "params", "(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "view", "layoutNode", "addAndroidView", "(Landroidx/compose/ui/viewinterop/AndroidViewHolder;Landroidx/compose/ui/node/LayoutNode;)V", "removeAndroidView", "(Landroidx/compose/ui/viewinterop/AndroidViewHolder;)V", "Landroid/graphics/Canvas;", "canvas", "drawAndroidView", "(Landroidx/compose/ui/viewinterop/AndroidViewHolder;Landroid/graphics/Canvas;)V", "sendPointerUpdate", "measureAndLayout", "Landroidx/compose/ui/unit/Constraints;", "constraints", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "affectsLookahead", "forceMeasureTheSubtree", "(Landroidx/compose/ui/node/LayoutNode;Z)V", "forceRequest", "onRequestMeasure", "(Landroidx/compose/ui/node/LayoutNode;ZZZ)V", "onRequestRelayout", "(Landroidx/compose/ui/node/LayoutNode;ZZ)V", "requestOnPositionedCallback", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "changed", "l", "t", "r", "onLayout", "(ZIIII)V", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroidx/compose/ui/graphics/Canvas;", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "drawBlock", "invalidateParentLayer", "explicitLayer", "Landroidx/compose/ui/node/OwnedLayer;", "createLayer", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)Landroidx/compose/ui/node/OwnedLayer;", "layer", "recycle$ui_release", "(Landroidx/compose/ui/node/OwnedLayer;)Z", "recycle", "onSemanticsChange", "onLayoutChange", "Landroidx/compose/ui/viewinterop/InteropView;", "onInteropViewLayoutChange", "Landroidx/compose/ui/input/key/KeyEvent;", "keyEvent", "getFocusDirection-P8AzH3I", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/FocusDirection;", "getFocusDirection", "dispatchDraw", "isDirty", "notifyLayerIsDirty$ui_release", "(Landroidx/compose/ui/node/OwnedLayer;Z)V", "notifyLayerIsDirty", "Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", Callback.METHOD_NAME, "setOnViewTreeOwnersAvailable", "(Lkotlin/jvm/functions/Function1;)V", "boundsUpdatesContentCaptureEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "boundsUpdatesAccessibilityEventLoop", "invalidateDescendants", "onAttachedToWindow", "onDetachedFromWindow", "flags", "onProvideAutofillVirtualStructure", "(Landroid/view/ViewStructure;I)V", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "values", "autofill", "(Landroid/util/SparseArray;)V", BuildConfig.FLAVOR, "virtualIds", BuildConfig.FLAVOR, "supportedFormats", "Landroid/view/translation/ViewTranslationRequest;", "requestsCollector", "onCreateVirtualViewTranslationRequests", "([J[ILjava/util/function/Consumer;)V", "Landroid/util/LongSparseArray;", "Landroid/view/translation/ViewTranslationResponse;", "response", "onVirtualViewTranslationResponses", "(Landroid/util/LongSparseArray;)V", "dispatchGenericMotionEvent", "dispatchTouchEvent", "canScrollHorizontally", "canScrollVertically", "Landroidx/compose/ui/geometry/Offset;", "localPosition", "localToScreen-MK-Hz9U", "(J)J", "localToScreen", "Landroidx/compose/ui/graphics/Matrix;", "localTransform", "localToScreen-58bKbWc", "([F)V", "positionOnScreen", "screenToLocal-MK-Hz9U", "screenToLocal", "onCheckIsTextEditor", "Landroid/view/inputmethod/EditorInfo;", "outAttrs", "Landroid/view/inputmethod/InputConnection;", "onCreateInputConnection", "(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;", "positionInWindow", "calculateLocalPosition-MK-Hz9U", "calculateLocalPosition", "calculatePositionInWindow-MK-Hz9U", "calculatePositionInWindow", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "layoutDirection", "onRtlPropertiesChanged", "(I)V", "dispatchHoverEvent", "findViewByAccessibilityIdTraversal", "shouldDelayChildPressedState", "lastDownPointerPosition", "J", "superclassInitComplete", "Z", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "sharedDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getSharedDrawScope", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "Landroidx/compose/ui/unit/Density;", "<set-?>", "density$delegate", "Landroidx/compose/runtime/MutableState;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "density", "Landroidx/compose/ui/semantics/EmptySemanticsModifier;", "rootSemanticsNode", "Landroidx/compose/ui/semantics/EmptySemanticsModifier;", "Landroidx/compose/ui/semantics/EmptySemanticsElement;", "semanticsModifier", "Landroidx/compose/ui/semantics/EmptySemanticsElement;", "Landroidx/compose/ui/focus/FocusOwner;", "focusOwner", "Landroidx/compose/ui/focus/FocusOwner;", "getFocusOwner", "()Landroidx/compose/ui/focus/FocusOwner;", "Landroidx/compose/ui/platform/DragAndDropModifierOnDragListener;", "dragAndDropModifierOnDragListener", "Landroidx/compose/ui/platform/DragAndDropModifierOnDragListener;", "value", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "setCoroutineContext", "(Lkotlin/coroutines/CoroutineContext;)V", "Landroidx/compose/ui/draganddrop/DragAndDropManager;", "dragAndDropManager", "Landroidx/compose/ui/draganddrop/DragAndDropManager;", "getDragAndDropManager", "()Landroidx/compose/ui/draganddrop/DragAndDropManager;", "Landroidx/compose/ui/platform/WindowInfoImpl;", "_windowInfo", "Landroidx/compose/ui/platform/WindowInfoImpl;", "Landroidx/compose/ui/Modifier;", "keyInputModifier", "Landroidx/compose/ui/Modifier;", "rotaryInputModifier", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "root", "Landroidx/compose/ui/node/LayoutNode;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/node/RootForTest;", "rootForTest", "Landroidx/compose/ui/node/RootForTest;", "getRootForTest", "()Landroidx/compose/ui/node/RootForTest;", "Landroidx/compose/ui/semantics/SemanticsOwner;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "getSemanticsOwner", "()Landroidx/compose/ui/semantics/SemanticsOwner;", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "composeAccessibilityDelegate", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "contentCaptureManager", "Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "getContentCaptureManager$ui_release", "()Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;", "setContentCaptureManager$ui_release", "(Landroidx/compose/ui/contentcapture/AndroidContentCaptureManager;)V", "Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "accessibilityManager", "Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "getAccessibilityManager", "()Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "Landroidx/compose/ui/graphics/GraphicsContext;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "getGraphicsContext", "()Landroidx/compose/ui/graphics/GraphicsContext;", "Landroidx/compose/ui/autofill/AutofillTree;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", BuildConfig.FLAVOR, "dirtyLayers", "Ljava/util/List;", "postponedDirtyLayers", "isDrawingContent", "isPendingInteropViewLayoutChangeDispatch", "Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "motionEventAdapter", "Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "pointerInputEventProcessor", "Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "configurationChangeObserver", "Lkotlin/jvm/functions/Function1;", "getConfigurationChangeObserver", "()Lkotlin/jvm/functions/Function1;", "setConfigurationChangeObserver", "Landroidx/compose/ui/autofill/AndroidAutofill;", "_autofill", "Landroidx/compose/ui/autofill/AndroidAutofill;", "observationClearRequested", "Landroidx/compose/ui/platform/AndroidClipboardManager;", "clipboardManager", "Landroidx/compose/ui/platform/AndroidClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/AndroidClipboardManager;", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "showLayoutBounds", "getShowLayoutBounds", "setShowLayoutBounds", "getShowLayoutBounds$annotations", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "_androidViewsHandler", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "Landroidx/compose/ui/platform/DrawChildContainer;", "viewLayersContainer", "Landroidx/compose/ui/platform/DrawChildContainer;", "onMeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "wasMeasuredWithMultipleConstraints", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "measureAndLayoutDelegate", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "Landroidx/compose/ui/platform/ViewConfiguration;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "Landroidx/compose/ui/unit/IntOffset;", "globalPosition", "tmpPositionArray", "[I", "tmpMatrix", "[F", "viewToWindowMatrix", "windowToViewMatrix", "lastMatrixRecalculationAnimationTime", "getLastMatrixRecalculationAnimationTime$ui_release", "()J", "setLastMatrixRecalculationAnimationTime$ui_release", "getLastMatrixRecalculationAnimationTime$ui_release$annotations", "forceUseMatrixCache", "windowPosition", "isRenderNodeCompatible", "_viewTreeOwners$delegate", "get_viewTreeOwners", "()Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "set_viewTreeOwners", "(Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;)V", "_viewTreeOwners", "viewTreeOwners$delegate", "Landroidx/compose/runtime/State;", "getViewTreeOwners", "viewTreeOwners", "onViewTreeOwnersAvailable", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "scrollChangedListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;", "touchModeChangeListener", "Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;", "Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "legacyTextInputServiceAndroid", "Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "Landroidx/compose/ui/text/input/TextInputService;", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "Landroidx/compose/ui/SessionMutex;", "Landroidx/compose/ui/platform/AndroidPlatformTextInputSession;", "textInputSessionMutex", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "softwareKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "getSoftwareKeyboardController", "()Landroidx/compose/ui/platform/SoftwareKeyboardController;", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "fontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader$annotations", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver$delegate", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "setFontFamilyResolver", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "fontFamilyResolver", "currentFontWeightAdjustment", "I", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection$delegate", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "Landroidx/compose/ui/input/InputModeManagerImpl;", "_inputModeManager", "Landroidx/compose/ui/input/InputModeManagerImpl;", "Landroidx/compose/ui/modifier/ModifierLocalManager;", "modifierLocalManager", "Landroidx/compose/ui/modifier/ModifierLocalManager;", "getModifierLocalManager", "()Landroidx/compose/ui/modifier/ModifierLocalManager;", "Landroidx/compose/ui/platform/TextToolbar;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "previousMotionEvent", "Landroid/view/MotionEvent;", "relayoutTime", "Landroidx/compose/ui/platform/WeakCache;", "layerCache", "Landroidx/compose/ui/platform/WeakCache;", "Landroidx/compose/runtime/collection/MutableVector;", "endApplyChangesListeners", "Landroidx/compose/runtime/collection/MutableVector;", "androidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1", "resendMotionEventRunnable", "Landroidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1;", "Ljava/lang/Runnable;", "sendHoverExitEvent", "Ljava/lang/Runnable;", "hoverExitReceived", "resendMotionEventOnLayout", "Lkotlin/jvm/functions/Function0;", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "matrixToWindow", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "keyboardModifiersRequireUpdate", "Landroidx/compose/ui/scrollcapture/ScrollCapture;", "scrollCapture", "Landroidx/compose/ui/scrollcapture/ScrollCapture;", "Landroidx/compose/ui/input/pointer/PointerIconService;", "pointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "getFontWeightAdjustmentCompat", "(Landroid/content/res/Configuration;)I", "fontWeightAdjustmentCompat", "getView", "()Landroid/view/View;", "Landroidx/compose/ui/platform/WindowInfo;", "getWindowInfo", "()Landroidx/compose/ui/platform/WindowInfo;", "windowInfo", "Landroidx/compose/ui/autofill/Autofill;", "getAutofill", "()Landroidx/compose/ui/autofill/Autofill;", "getAndroidViewsHandler$ui_release", "()Landroidx/compose/ui/platform/AndroidViewsHandler;", "androidViewsHandler", "getMeasureIteration", "measureIteration", "getHasPendingMeasureOrLayout", "hasPendingMeasureOrLayout", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placementScope", "Landroidx/compose/ui/input/InputModeManager;", "getInputModeManager", "()Landroidx/compose/ui/input/InputModeManager;", "inputModeManager", "getScrollCaptureInProgress$ui_release", "scrollCaptureInProgress", "Companion", "ViewTreeOwners", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidComposeView extends ViewGroup implements Owner, ViewRootForTest, PositionCalculator, DefaultLifecycleObserver {
    private static Method getBooleanMethod;
    private static Class<?> systemPropertiesClass;
    private AndroidViewsHandler _androidViewsHandler;
    private final AndroidAutofill _autofill;
    private final InputModeManagerImpl _inputModeManager;

    /* renamed from: _viewTreeOwners$delegate, reason: from kotlin metadata */
    private final MutableState _viewTreeOwners;
    private final WindowInfoImpl _windowInfo;
    private final AndroidAccessibilityManager accessibilityManager;
    private final AutofillTree autofillTree;
    private final CanvasHolder canvasHolder;
    private final AndroidClipboardManager clipboardManager;
    private final AndroidComposeViewAccessibilityDelegateCompat composeAccessibilityDelegate;
    private Function1<? super Configuration, Unit> configurationChangeObserver;
    private AndroidContentCaptureManager contentCaptureManager;
    private CoroutineContext coroutineContext;
    private int currentFontWeightAdjustment;

    /* renamed from: density$delegate, reason: from kotlin metadata */
    private final MutableState density;
    private final List<OwnedLayer> dirtyLayers;
    private final DragAndDropManager dragAndDropManager;
    private final DragAndDropModifierOnDragListener dragAndDropModifierOnDragListener;
    private final MutableVector<Function0<Unit>> endApplyChangesListeners;
    private final FocusOwner focusOwner;

    /* renamed from: fontFamilyResolver$delegate, reason: from kotlin metadata */
    private final MutableState fontFamilyResolver;
    private final Font.ResourceLoader fontLoader;
    private boolean forceUseMatrixCache;
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private long globalPosition;
    private final GraphicsContext graphicsContext;
    private final HapticFeedback hapticFeedBack;
    private boolean hoverExitReceived;
    private boolean isDrawingContent;
    private boolean isPendingInteropViewLayoutChangeDispatch;
    private boolean isRenderNodeCompatible;
    private final Modifier keyInputModifier;
    private boolean keyboardModifiersRequireUpdate;
    private long lastDownPointerPosition;
    private long lastMatrixRecalculationAnimationTime;
    private final WeakCache<OwnedLayer> layerCache;

    /* renamed from: layoutDirection$delegate, reason: from kotlin metadata */
    private final MutableState layoutDirection;
    private final TextInputServiceAndroid legacyTextInputServiceAndroid;
    private final CalculateMatrixToWindow matrixToWindow;
    private final MeasureAndLayoutDelegate measureAndLayoutDelegate;
    private final ModifierLocalManager modifierLocalManager;
    private final MotionEventAdapter motionEventAdapter;
    private boolean observationClearRequested;
    private Constraints onMeasureConstraints;
    private Function1<? super ViewTreeOwners, Unit> onViewTreeOwnersAvailable;
    private final PointerIconService pointerIconService;
    private final PointerInputEventProcessor pointerInputEventProcessor;
    private List<OwnedLayer> postponedDirtyLayers;
    private MotionEvent previousMotionEvent;
    private long relayoutTime;
    private final Function0<Unit> resendMotionEventOnLayout;
    private final AndroidComposeView$resendMotionEventRunnable$1 resendMotionEventRunnable;
    private final LayoutNode root;
    private final RootForTest rootForTest;
    private final EmptySemanticsModifier rootSemanticsNode;
    private final Modifier rotaryInputModifier;
    private final ScrollCapture scrollCapture;
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;
    private final EmptySemanticsElement semanticsModifier;
    private final SemanticsOwner semanticsOwner;
    private final Runnable sendHoverExitEvent;
    private final LayoutNodeDrawScope sharedDrawScope;
    private boolean showLayoutBounds;
    private final OwnerSnapshotObserver snapshotObserver;
    private final SoftwareKeyboardController softwareKeyboardController;
    private boolean superclassInitComplete;
    private final TextInputService textInputService;
    private final AtomicReference textInputSessionMutex;
    private final TextToolbar textToolbar;
    private final float[] tmpMatrix;
    private final int[] tmpPositionArray;
    private final ViewTreeObserver.OnTouchModeChangeListener touchModeChangeListener;
    private final ViewConfiguration viewConfiguration;
    private DrawChildContainer viewLayersContainer;
    private final float[] viewToWindowMatrix;

    /* renamed from: viewTreeOwners$delegate, reason: from kotlin metadata */
    private final State viewTreeOwners;
    private boolean wasMeasuredWithMultipleConstraints;
    private long windowPosition;
    private final float[] windowToViewMatrix;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$Companion;", BuildConfig.FLAVOR, "()V", "getBooleanMethod", "Ljava/lang/reflect/Method;", "systemPropertiesClass", "Ljava/lang/Class;", "getIsShowingLayoutBounds", BuildConfig.FLAVOR, "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean getIsShowingLayoutBounds() {
            try {
                if (AndroidComposeView.systemPropertiesClass == null) {
                    AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
                    Class cls = AndroidComposeView.systemPropertiesClass;
                    AndroidComposeView.getBooleanMethod = cls != null ? cls.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE) : null;
                }
                Method method = AndroidComposeView.getBooleanMethod;
                Object invoke = method != null ? method.invoke(null, "debug.layout", Boolean.FALSE) : null;
                Boolean bool = invoke instanceof Boolean ? (Boolean) invoke : null;
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", BuildConfig.FLAVOR, "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class ViewTreeOwners {
        private final LifecycleOwner lifecycleOwner;
        private final SavedStateRegistryOwner savedStateRegistryOwner;

        public ViewTreeOwners(LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner) {
            this.lifecycleOwner = lifecycleOwner;
            this.savedStateRegistryOwner = savedStateRegistryOwner;
        }

        public final LifecycleOwner getLifecycleOwner() {
            return this.lifecycleOwner;
        }

        public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
            return this.savedStateRegistryOwner;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v13, types: [androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1] */
    public AndroidComposeView(Context context, CoroutineContext coroutineContext) {
        super(context);
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        Offset.Companion companion = Offset.INSTANCE;
        this.lastDownPointerPosition = companion.m1348getUnspecifiedF1C5BW0();
        this.superclassInitComplete = true;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        this.sharedDrawScope = new LayoutNodeDrawScope(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0);
        this.density = SnapshotStateKt.mutableStateOf(AndroidDensity_androidKt.Density(context), SnapshotStateKt.referentialEqualityPolicy());
        EmptySemanticsModifier emptySemanticsModifier = new EmptySemanticsModifier();
        this.rootSemanticsNode = emptySemanticsModifier;
        EmptySemanticsElement emptySemanticsElement = new EmptySemanticsElement(emptySemanticsModifier);
        this.semanticsModifier = emptySemanticsElement;
        this.focusOwner = new FocusOwnerImpl(new AndroidComposeView$focusOwner$1(this), new AndroidComposeView$focusOwner$2(this), new AndroidComposeView$focusOwner$3(this), new AndroidComposeView$focusOwner$4(this), new AndroidComposeView$focusOwner$5(this), new MutablePropertyReference0Impl(this) { // from class: androidx.compose.ui.platform.AndroidComposeView$focusOwner$6
            @Override // kotlin.reflect.KProperty0
            public Object get() {
                return ((AndroidComposeView) this.receiver).getLayoutDirection();
            }
        });
        DragAndDropModifierOnDragListener dragAndDropModifierOnDragListener = new DragAndDropModifierOnDragListener(new AndroidComposeView$dragAndDropModifierOnDragListener$1(this));
        this.dragAndDropModifierOnDragListener = dragAndDropModifierOnDragListener;
        this.coroutineContext = coroutineContext;
        this.dragAndDropManager = dragAndDropModifierOnDragListener;
        this._windowInfo = new WindowInfoImpl();
        Modifier.Companion companion2 = Modifier.INSTANCE;
        Modifier onKeyEvent = KeyInputModifierKt.onKeyEvent(companion2, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m2110invokeZmokQxo(keyEvent.getNativeKeyEvent());
            }

            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m2110invokeZmokQxo(android.view.KeyEvent keyEvent) {
                Rect onFetchFocusRect;
                View findNextNonChildView;
                final FocusDirection m2105getFocusDirectionP8AzH3I = AndroidComposeView.this.m2105getFocusDirectionP8AzH3I(keyEvent);
                if (m2105getFocusDirectionP8AzH3I == null || !KeyEventType.m1822equalsimpl0(KeyEvent_androidKt.m1827getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m1823getKeyDownCS__XNY())) {
                    return Boolean.FALSE;
                }
                onFetchFocusRect = AndroidComposeView.this.onFetchFocusRect();
                Boolean mo1293focusSearchULY8qGw = AndroidComposeView.this.getFocusOwner().mo1293focusSearchULY8qGw(m2105getFocusDirectionP8AzH3I.getValue(), onFetchFocusRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1$focusWasMovedOrCancelled$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(FocusTargetNode focusTargetNode) {
                        Boolean m1306requestFocusMxy_nc0 = FocusTransactionsKt.m1306requestFocusMxy_nc0(focusTargetNode, FocusDirection.this.getValue());
                        return Boolean.valueOf(m1306requestFocusMxy_nc0 != null ? m1306requestFocusMxy_nc0.booleanValue() : true);
                    }
                });
                if (mo1293focusSearchULY8qGw != null ? mo1293focusSearchULY8qGw.booleanValue() : true) {
                    return Boolean.TRUE;
                }
                if (!FocusOwnerImplKt.m1297is1dFocusSearch3ESFkO8(m2105getFocusDirectionP8AzH3I.getValue())) {
                    return Boolean.FALSE;
                }
                Integer m1287toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m1287toAndroidFocusDirection3ESFkO8(m2105getFocusDirectionP8AzH3I.getValue());
                if (m1287toAndroidFocusDirection3ESFkO8 == null) {
                    throw new IllegalStateException("Invalid focus direction");
                }
                int intValue = m1287toAndroidFocusDirection3ESFkO8.intValue();
                android.graphics.Rect androidRect = onFetchFocusRect != null ? RectHelper_androidKt.toAndroidRect(onFetchFocusRect) : null;
                if (androidRect == null) {
                    throw new IllegalStateException("Invalid rect");
                }
                findNextNonChildView = AndroidComposeView.this.findNextNonChildView(intValue);
                if (Intrinsics.areEqual(findNextNonChildView, AndroidComposeView.this)) {
                    findNextNonChildView = null;
                }
                if ((findNextNonChildView == null || !FocusInteropUtils_androidKt.requestInteropFocus(findNextNonChildView, Integer.valueOf(intValue), androidRect)) && AndroidComposeView.this.getFocusOwner().mo1290clearFocusI7lrPNg(false, true, false, m2105getFocusDirectionP8AzH3I.getValue())) {
                    Boolean mo1293focusSearchULY8qGw2 = AndroidComposeView.this.getFocusOwner().mo1293focusSearchULY8qGw(m2105getFocusDirectionP8AzH3I.getValue(), null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(FocusTargetNode focusTargetNode) {
                            Boolean m1306requestFocusMxy_nc0 = FocusTransactionsKt.m1306requestFocusMxy_nc0(focusTargetNode, FocusDirection.this.getValue());
                            return Boolean.valueOf(m1306requestFocusMxy_nc0 != null ? m1306requestFocusMxy_nc0.booleanValue() : true);
                        }
                    });
                    return Boolean.valueOf(mo1293focusSearchULY8qGw2 != null ? mo1293focusSearchULY8qGw2.booleanValue() : true);
                }
                return Boolean.TRUE;
            }
        });
        this.keyInputModifier = onKeyEvent;
        Modifier onRotaryScrollEvent = RotaryInputModifierKt.onRotaryScrollEvent(companion2, new Function1<RotaryScrollEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$rotaryInputModifier$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(RotaryScrollEvent rotaryScrollEvent) {
                return Boolean.FALSE;
            }
        });
        this.rotaryInputModifier = onRotaryScrollEvent;
        this.canvasHolder = new CanvasHolder();
        LayoutNode layoutNode = new LayoutNode(false, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        layoutNode.setMeasurePolicy(RootMeasurePolicy.INSTANCE);
        layoutNode.setDensity(getDensity());
        layoutNode.setModifier(companion2.then(emptySemanticsElement).then(onRotaryScrollEvent).then(onKeyEvent).then(getFocusOwner().getModifier()).then(dragAndDropModifierOnDragListener.getModifier()));
        this.root = layoutNode;
        this.rootForTest = this;
        this.semanticsOwner = new SemanticsOwner(getRoot(), emptySemanticsModifier);
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = new AndroidComposeViewAccessibilityDelegateCompat(this);
        this.composeAccessibilityDelegate = androidComposeViewAccessibilityDelegateCompat;
        this.contentCaptureManager = new AndroidContentCaptureManager(this, new AndroidComposeView$contentCaptureManager$1(this));
        this.accessibilityManager = new AndroidAccessibilityManager(context);
        this.graphicsContext = AndroidGraphicsContext_androidKt.GraphicsContext(this);
        this.autofillTree = new AutofillTree();
        this.dirtyLayers = new ArrayList();
        this.motionEventAdapter = new MotionEventAdapter();
        this.pointerInputEventProcessor = new PointerInputEventProcessor(getRoot());
        this.configurationChangeObserver = new Function1<Configuration, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$configurationChangeObserver$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Configuration configuration) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Configuration configuration) {
                invoke2(configuration);
                return Unit.INSTANCE;
            }
        };
        this._autofill = autofillSupported() ? new AndroidAutofill(this, getAutofillTree()) : null;
        this.clipboardManager = new AndroidClipboardManager(context);
        this.snapshotObserver = new OwnerSnapshotObserver(new AndroidComposeView$snapshotObserver$1(this));
        this.measureAndLayoutDelegate = new MeasureAndLayoutDelegate(getRoot());
        this.viewConfiguration = new AndroidViewConfiguration(android.view.ViewConfiguration.get(context));
        this.globalPosition = IntOffsetKt.IntOffset(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.tmpPositionArray = new int[]{0, 0};
        float[] m1547constructorimpl$default = Matrix.m1547constructorimpl$default(null, 1, null);
        this.tmpMatrix = m1547constructorimpl$default;
        this.viewToWindowMatrix = Matrix.m1547constructorimpl$default(null, 1, null);
        this.windowToViewMatrix = Matrix.m1547constructorimpl$default(null, 1, null);
        this.lastMatrixRecalculationAnimationTime = -1L;
        this.windowPosition = companion.m1347getInfiniteF1C5BW0();
        this.isRenderNodeCompatible = true;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this._viewTreeOwners = mutableStateOf$default;
        this.viewTreeOwners = SnapshotStateKt.derivedStateOf(new Function0<ViewTreeOwners>() { // from class: androidx.compose.ui.platform.AndroidComposeView$viewTreeOwners$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AndroidComposeView.ViewTreeOwners invoke() {
                AndroidComposeView.ViewTreeOwners viewTreeOwners;
                viewTreeOwners = AndroidComposeView.this.get_viewTreeOwners();
                return viewTreeOwners;
            }
        });
        this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.compose.ui.platform.b
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                AndroidComposeView.this.updatePositionCacheAndDispatch();
            }
        };
        this.scrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: androidx.compose.ui.platform.c
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                AndroidComposeView.this.updatePositionCacheAndDispatch();
            }
        };
        this.touchModeChangeListener = new ViewTreeObserver.OnTouchModeChangeListener() { // from class: androidx.compose.ui.platform.d
            @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
            public final void onTouchModeChanged(boolean z5) {
                AndroidComposeView.touchModeChangeListener$lambda$6(AndroidComposeView.this, z5);
            }
        };
        TextInputServiceAndroid textInputServiceAndroid = new TextInputServiceAndroid(getView(), this);
        this.legacyTextInputServiceAndroid = textInputServiceAndroid;
        this.textInputService = new TextInputService(AndroidComposeView_androidKt.getPlatformTextInputServiceInterceptor().invoke(textInputServiceAndroid));
        this.textInputSessionMutex = SessionMutex.m1252constructorimpl();
        this.softwareKeyboardController = new DelegatingSoftwareKeyboardController(getTextInputService());
        this.fontLoader = new AndroidFontResourceLoader(context);
        this.fontFamilyResolver = SnapshotStateKt.mutableStateOf(FontFamilyResolver_androidKt.createFontFamilyResolver(context), SnapshotStateKt.referentialEqualityPolicy());
        this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(context.getResources().getConfiguration());
        LayoutDirection layoutDirection = FocusInteropUtils_androidKt.toLayoutDirection(context.getResources().getConfiguration().getLayoutDirection());
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(layoutDirection == null ? LayoutDirection.Ltr : layoutDirection, null, 2, null);
        this.layoutDirection = mutableStateOf$default2;
        this.hapticFeedBack = new PlatformHapticFeedback(this);
        this._inputModeManager = new InputModeManagerImpl(isInTouchMode() ? InputMode.INSTANCE.m1793getTouchaOaMEAU() : InputMode.INSTANCE.m1792getKeyboardaOaMEAU(), new Function1<InputMode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$_inputModeManager$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(InputMode inputMode) {
                return m2106invokeiuPiT84(inputMode.getValue());
            }

            /* renamed from: invoke-iuPiT84, reason: not valid java name */
            public final Boolean m2106invokeiuPiT84(int i5) {
                InputMode.Companion companion3 = InputMode.INSTANCE;
                return Boolean.valueOf(InputMode.m1788equalsimpl0(i5, companion3.m1793getTouchaOaMEAU()) ? AndroidComposeView.this.isInTouchMode() : InputMode.m1788equalsimpl0(i5, companion3.m1792getKeyboardaOaMEAU()) ? AndroidComposeView.this.isInTouchMode() ? AndroidComposeView.this.requestFocusFromTouch() : true : false);
            }
        }, objArr2 == true ? 1 : 0);
        this.modifierLocalManager = new ModifierLocalManager(this);
        this.textToolbar = new AndroidTextToolbar(this);
        this.layerCache = new WeakCache<>();
        this.endApplyChangesListeners = new MutableVector<>(new Function0[16], 0);
        this.resendMotionEventRunnable = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                MotionEvent motionEvent;
                long j5;
                AndroidComposeView.this.removeCallbacks(this);
                motionEvent = AndroidComposeView.this.previousMotionEvent;
                if (motionEvent != null) {
                    boolean z5 = motionEvent.getToolType(0) == 3;
                    int actionMasked = motionEvent.getActionMasked();
                    if (z5) {
                        if (actionMasked == 10 || actionMasked == 1) {
                            return;
                        }
                    } else if (actionMasked == 1) {
                        return;
                    }
                    int i5 = 7;
                    if (actionMasked != 7 && actionMasked != 9) {
                        i5 = 2;
                    }
                    AndroidComposeView androidComposeView = AndroidComposeView.this;
                    j5 = androidComposeView.relayoutTime;
                    androidComposeView.sendSimulatedEvent(motionEvent, i5, j5, false);
                }
            }
        };
        this.sendHoverExitEvent = new Runnable() { // from class: androidx.compose.ui.platform.e
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeView.sendHoverExitEvent$lambda$8(AndroidComposeView.this);
            }
        };
        this.resendMotionEventOnLayout = new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventOnLayout$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                MotionEvent motionEvent;
                AndroidComposeView$resendMotionEventRunnable$1 androidComposeView$resendMotionEventRunnable$1;
                motionEvent = AndroidComposeView.this.previousMotionEvent;
                if (motionEvent != null) {
                    int actionMasked = motionEvent.getActionMasked();
                    if (actionMasked == 7 || actionMasked == 9) {
                        AndroidComposeView.this.relayoutTime = SystemClock.uptimeMillis();
                        AndroidComposeView androidComposeView = AndroidComposeView.this;
                        androidComposeView$resendMotionEventRunnable$1 = androidComposeView.resendMotionEventRunnable;
                        androidComposeView.post(androidComposeView$resendMotionEventRunnable$1);
                    }
                }
            }
        };
        int i5 = Build.VERSION.SDK_INT;
        this.matrixToWindow = i5 < 29 ? new CalculateMatrixToWindowApi21(m1547constructorimpl$default, objArr == true ? 1 : 0) : new CalculateMatrixToWindowApi29();
        addOnAttachStateChangeListener(this.contentCaptureManager);
        setWillNotDraw(false);
        setFocusable(true);
        AndroidComposeViewVerificationHelperMethodsO.INSTANCE.focusable(this, 1, false);
        setFocusableInTouchMode(true);
        setClipChildren(false);
        ViewCompat.setAccessibilityDelegate(this, androidComposeViewAccessibilityDelegateCompat);
        Function1<ViewRootForTest, Unit> onViewCreatedCallback = ViewRootForTest.INSTANCE.getOnViewCreatedCallback();
        if (onViewCreatedCallback != null) {
            onViewCreatedCallback.invoke(this);
        }
        setOnDragListener(dragAndDropModifierOnDragListener);
        getRoot().attach$ui_release(this);
        if (i5 >= 29) {
            AndroidComposeViewForceDarkModeQ.INSTANCE.disallowForceDark(this);
        }
        this.scrollCapture = i5 >= 31 ? new ScrollCapture() : null;
        this.pointerIconService = new PointerIconService() { // from class: androidx.compose.ui.platform.AndroidComposeView$pointerIconService$1
            private PointerIcon currentIcon = PointerIcon.INSTANCE.getDefault();

            @Override // androidx.compose.ui.input.pointer.PointerIconService
            public void setIcon(PointerIcon value) {
                if (value == null) {
                    value = PointerIcon.INSTANCE.getDefault();
                }
                this.currentIcon = value;
                AndroidComposeViewVerificationHelperMethodsN.INSTANCE.setPointerIcon(AndroidComposeView.this, value);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int virtualViewId, AccessibilityNodeInfo info, String extraDataKey) {
        int orDefault;
        if (Intrinsics.areEqual(extraDataKey, this.composeAccessibilityDelegate.getExtraDataTestTraversalBeforeVal())) {
            int orDefault2 = this.composeAccessibilityDelegate.getIdToBeforeMap().getOrDefault(virtualViewId, -1);
            if (orDefault2 != -1) {
                info.getExtras().putInt(extraDataKey, orDefault2);
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(extraDataKey, this.composeAccessibilityDelegate.getExtraDataTestTraversalAfterVal()) || (orDefault = this.composeAccessibilityDelegate.getIdToAfterMap().getOrDefault(virtualViewId, -1)) == -1) {
            return;
        }
        info.getExtras().putInt(extraDataKey, orDefault);
    }

    private final boolean autofillSupported() {
        return true;
    }

    private final boolean childSizeCanAffectParentSize(LayoutNode layoutNode) {
        LayoutNode parent$ui_release;
        return this.wasMeasuredWithMultipleConstraints || !((parent$ui_release = layoutNode.getParent$ui_release()) == null || parent$ui_release.getHasFixedInnerContentConstraints$ui_release());
    }

    private final void clearChildInvalidObservations(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = viewGroup.getChildAt(i5);
            if (childAt instanceof AndroidComposeView) {
                ((AndroidComposeView) childAt).onEndApplyChanges();
            } else if (childAt instanceof ViewGroup) {
                clearChildInvalidObservations((ViewGroup) childAt);
            }
        }
    }

    /* renamed from: convertMeasureSpec-I7RO_PI, reason: not valid java name */
    private final long m2098convertMeasureSpecI7RO_PI(int measureSpec) {
        int mode = View.MeasureSpec.getMode(measureSpec);
        int size = View.MeasureSpec.getSize(measureSpec);
        if (mode == Integer.MIN_VALUE) {
            return m2102packZIaKswc(0, size);
        }
        if (mode == 0) {
            return m2102packZIaKswc(0, Integer.MAX_VALUE);
        }
        if (mode == 1073741824) {
            return m2102packZIaKswc(size, size);
        }
        throw new IllegalStateException();
    }

    private final void dispatchPendingInteropLayoutCallbacks() {
        if (this.isPendingInteropViewLayoutChangeDispatch) {
            getViewTreeObserver().dispatchOnGlobalLayout();
            this.isPendingInteropViewLayoutChangeDispatch = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View findNextNonChildView(int direction) {
        View view = this;
        while (view != null) {
            FocusFinder focusFinder = FocusFinder.getInstance();
            View rootView = getRootView();
            Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            view = focusFinder.findNextFocus((ViewGroup) rootView, view, direction);
            if (view != null && !AndroidComposeView_androidKt.access$containsDescendant(this, view)) {
                return view;
            }
        }
        return null;
    }

    private final View findViewByAccessibilityIdRootedAtCurrentView(int accessibilityId, View currentView) {
        if (Build.VERSION.SDK_INT < 29) {
            Method declaredMethod = View.class.getDeclaredMethod("getAccessibilityViewId", null);
            declaredMethod.setAccessible(true);
            if (Intrinsics.areEqual(declaredMethod.invoke(currentView, null), Integer.valueOf(accessibilityId))) {
                return currentView;
            }
            if (currentView instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) currentView;
                int childCount = viewGroup.getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    View findViewByAccessibilityIdRootedAtCurrentView = findViewByAccessibilityIdRootedAtCurrentView(accessibilityId, viewGroup.getChildAt(i5));
                    if (findViewByAccessibilityIdRootedAtCurrentView != null) {
                        return findViewByAccessibilityIdRootedAtCurrentView;
                    }
                }
            }
        }
        return null;
    }

    @Deprecated
    public static /* synthetic */ void getFontLoader$annotations() {
    }

    private final int getFontWeightAdjustmentCompat(Configuration configuration) {
        int i5;
        if (Build.VERSION.SDK_INT < 31) {
            return 0;
        }
        i5 = configuration.fontWeightAdjustment;
        return i5;
    }

    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ViewTreeOwners get_viewTreeOwners() {
        return (ViewTreeOwners) this._viewTreeOwners.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0091 A[Catch: all -> 0x002b, TryCatch #1 {all -> 0x002b, blocks: (B:5:0x0018, B:7:0x0021, B:12:0x0032, B:14:0x0038, B:16:0x003e, B:17:0x0045, B:20:0x004d, B:21:0x0061, B:29:0x0074, B:31:0x007a, B:33:0x0091, B:34:0x0094, B:36:0x0098, B:38:0x009e, B:40:0x00a2, B:41:0x00a8, B:43:0x00ae, B:46:0x00b6, B:47:0x00bc, B:49:0x00c2, B:51:0x00c8, B:53:0x00ce, B:54:0x00d4, B:56:0x00d8, B:57:0x00dc, B:62:0x00ef, B:64:0x00f3, B:65:0x00fa, B:71:0x010b, B:72:0x0110, B:78:0x0115), top: B:4:0x0018, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a2 A[Catch: all -> 0x002b, TryCatch #1 {all -> 0x002b, blocks: (B:5:0x0018, B:7:0x0021, B:12:0x0032, B:14:0x0038, B:16:0x003e, B:17:0x0045, B:20:0x004d, B:21:0x0061, B:29:0x0074, B:31:0x007a, B:33:0x0091, B:34:0x0094, B:36:0x0098, B:38:0x009e, B:40:0x00a2, B:41:0x00a8, B:43:0x00ae, B:46:0x00b6, B:47:0x00bc, B:49:0x00c2, B:51:0x00c8, B:53:0x00ce, B:54:0x00d4, B:56:0x00d8, B:57:0x00dc, B:62:0x00ef, B:64:0x00f3, B:65:0x00fa, B:71:0x010b, B:72:0x0110, B:78:0x0115), top: B:4:0x0018, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ce A[Catch: all -> 0x002b, TryCatch #1 {all -> 0x002b, blocks: (B:5:0x0018, B:7:0x0021, B:12:0x0032, B:14:0x0038, B:16:0x003e, B:17:0x0045, B:20:0x004d, B:21:0x0061, B:29:0x0074, B:31:0x007a, B:33:0x0091, B:34:0x0094, B:36:0x0098, B:38:0x009e, B:40:0x00a2, B:41:0x00a8, B:43:0x00ae, B:46:0x00b6, B:47:0x00bc, B:49:0x00c2, B:51:0x00c8, B:53:0x00ce, B:54:0x00d4, B:56:0x00d8, B:57:0x00dc, B:62:0x00ef, B:64:0x00f3, B:65:0x00fa, B:71:0x010b, B:72:0x0110, B:78:0x0115), top: B:4:0x0018, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d8 A[Catch: all -> 0x002b, TryCatch #1 {all -> 0x002b, blocks: (B:5:0x0018, B:7:0x0021, B:12:0x0032, B:14:0x0038, B:16:0x003e, B:17:0x0045, B:20:0x004d, B:21:0x0061, B:29:0x0074, B:31:0x007a, B:33:0x0091, B:34:0x0094, B:36:0x0098, B:38:0x009e, B:40:0x00a2, B:41:0x00a8, B:43:0x00ae, B:46:0x00b6, B:47:0x00bc, B:49:0x00c2, B:51:0x00c8, B:53:0x00ce, B:54:0x00d4, B:56:0x00d8, B:57:0x00dc, B:62:0x00ef, B:64:0x00f3, B:65:0x00fa, B:71:0x010b, B:72:0x0110, B:78:0x0115), top: B:4:0x0018, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f3 A[Catch: all -> 0x002b, TryCatch #1 {all -> 0x002b, blocks: (B:5:0x0018, B:7:0x0021, B:12:0x0032, B:14:0x0038, B:16:0x003e, B:17:0x0045, B:20:0x004d, B:21:0x0061, B:29:0x0074, B:31:0x007a, B:33:0x0091, B:34:0x0094, B:36:0x0098, B:38:0x009e, B:40:0x00a2, B:41:0x00a8, B:43:0x00ae, B:46:0x00b6, B:47:0x00bc, B:49:0x00c2, B:51:0x00c8, B:53:0x00ce, B:54:0x00d4, B:56:0x00d8, B:57:0x00dc, B:62:0x00ef, B:64:0x00f3, B:65:0x00fa, B:71:0x010b, B:72:0x0110, B:78:0x0115), top: B:4:0x0018, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x010b A[Catch: all -> 0x002b, TryCatch #1 {all -> 0x002b, blocks: (B:5:0x0018, B:7:0x0021, B:12:0x0032, B:14:0x0038, B:16:0x003e, B:17:0x0045, B:20:0x004d, B:21:0x0061, B:29:0x0074, B:31:0x007a, B:33:0x0091, B:34:0x0094, B:36:0x0098, B:38:0x009e, B:40:0x00a2, B:41:0x00a8, B:43:0x00ae, B:46:0x00b6, B:47:0x00bc, B:49:0x00c2, B:51:0x00c8, B:53:0x00ce, B:54:0x00d4, B:56:0x00d8, B:57:0x00dc, B:62:0x00ef, B:64:0x00f3, B:65:0x00fa, B:71:0x010b, B:72:0x0110, B:78:0x0115), top: B:4:0x0018, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0069  */
    /* renamed from: handleMotionEvent-8iAsVTc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int m2099handleMotionEvent8iAsVTc(MotionEvent motionEvent) {
        int i5;
        int i6;
        MotionEvent motionEvent2;
        int pointerId;
        boolean z5;
        removeCallbacks(this.resendMotionEventRunnable);
        try {
            recalculateWindowPosition(motionEvent);
            this.forceUseMatrixCache = true;
            measureAndLayout(false);
            Trace.beginSection("AndroidOwner:onTouch");
            try {
                int actionMasked = motionEvent.getActionMasked();
                MotionEvent motionEvent3 = this.previousMotionEvent;
                boolean z6 = motionEvent3 != null && motionEvent3.getToolType(0) == 3;
                if (motionEvent3 != null && hasChangedDevices(motionEvent, motionEvent3)) {
                    if (isDevicePressEvent(motionEvent3)) {
                        this.pointerInputEventProcessor.processCancel();
                    } else if (motionEvent3.getActionMasked() != 10 && z6) {
                        i5 = 10;
                        sendSimulatedEvent$default(this, motionEvent3, 10, motionEvent3.getEventTime(), false, 8, null);
                        boolean z7 = motionEvent.getToolType(0) != 3;
                        if (z6 && z7 && actionMasked != 3 && actionMasked != 9 && isInBounds(motionEvent)) {
                            i6 = 9;
                            sendSimulatedEvent$default(this, motionEvent, 9, motionEvent.getEventTime(), false, 8, null);
                        } else {
                            i6 = 9;
                        }
                        if (motionEvent3 != null) {
                            motionEvent3.recycle();
                        }
                        motionEvent2 = this.previousMotionEvent;
                        if (motionEvent2 != null && motionEvent2.getAction() == i5) {
                            MotionEvent motionEvent4 = this.previousMotionEvent;
                            pointerId = motionEvent4 == null ? motionEvent4.getPointerId(0) : -1;
                            if (motionEvent.getAction() == i6 || motionEvent.getHistorySize() != 0) {
                                if (motionEvent.getAction() == 0 && motionEvent.getHistorySize() == 0) {
                                    MotionEvent motionEvent5 = this.previousMotionEvent;
                                    float x5 = motionEvent5 == null ? motionEvent5.getX() : Float.NaN;
                                    MotionEvent motionEvent6 = this.previousMotionEvent;
                                    z5 = x5 == motionEvent.getX() || (motionEvent6 != null ? motionEvent6.getY() : Float.NaN) != motionEvent.getY();
                                    MotionEvent motionEvent7 = this.previousMotionEvent;
                                    boolean z8 = (motionEvent7 == null ? motionEvent7.getEventTime() : -1L) == motionEvent.getEventTime();
                                    if (!z5 || z8) {
                                        if (pointerId >= 0) {
                                            this.motionEventAdapter.endStream(pointerId);
                                        }
                                        this.pointerInputEventProcessor.clearPreviouslyHitModifierNodes();
                                    }
                                }
                            } else if (pointerId >= 0) {
                                this.motionEventAdapter.endStream(pointerId);
                            }
                        }
                        this.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                        int m2103sendMotionEvent8iAsVTc = m2103sendMotionEvent8iAsVTc(motionEvent);
                        Trace.endSection();
                        return m2103sendMotionEvent8iAsVTc;
                    }
                }
                i5 = 10;
                if (motionEvent.getToolType(0) != 3) {
                }
                if (z6) {
                }
                i6 = 9;
                if (motionEvent3 != null) {
                }
                motionEvent2 = this.previousMotionEvent;
                if (motionEvent2 != null) {
                    MotionEvent motionEvent42 = this.previousMotionEvent;
                    if (motionEvent42 == null) {
                    }
                    if (motionEvent.getAction() == i6) {
                    }
                    if (motionEvent.getAction() == 0) {
                        MotionEvent motionEvent52 = this.previousMotionEvent;
                        if (motionEvent52 == null) {
                        }
                        MotionEvent motionEvent62 = this.previousMotionEvent;
                        if (motionEvent62 != null) {
                        }
                        if (x5 == motionEvent.getX()) {
                        }
                        MotionEvent motionEvent72 = this.previousMotionEvent;
                        if ((motionEvent72 == null ? motionEvent72.getEventTime() : -1L) == motionEvent.getEventTime()) {
                        }
                        if (!z5) {
                        }
                        if (pointerId >= 0) {
                        }
                        this.pointerInputEventProcessor.clearPreviouslyHitModifierNodes();
                    }
                }
                this.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                int m2103sendMotionEvent8iAsVTc2 = m2103sendMotionEvent8iAsVTc(motionEvent);
                Trace.endSection();
                return m2103sendMotionEvent8iAsVTc2;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } finally {
            this.forceUseMatrixCache = false;
        }
    }

    private final boolean handleRotaryEvent(MotionEvent event) {
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(getContext());
        float f5 = -event.getAxisValue(26);
        return getFocusOwner().dispatchRotaryEvent(new RotaryScrollEvent(f5 * ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, getContext()), f5 * ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, getContext()), event.getEventTime(), event.getDeviceId()));
    }

    private final boolean hasChangedDevices(MotionEvent event, MotionEvent lastEvent) {
        return (lastEvent.getSource() == event.getSource() && lastEvent.getToolType(0) == event.getToolType(0)) ? false : true;
    }

    private final void invalidateLayers(LayoutNode node) {
        node.invalidateLayers$ui_release();
        MutableVector<LayoutNode> mutableVector = node.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i5 = 0;
            do {
                invalidateLayers(content[i5]);
                i5++;
            } while (i5 < size);
        }
    }

    private final void invalidateLayoutNodeMeasurement(LayoutNode node) {
        int i5 = 0;
        MeasureAndLayoutDelegate.requestRemeasure$default(this.measureAndLayoutDelegate, node, false, 2, null);
        MutableVector<LayoutNode> mutableVector = node.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            do {
                invalidateLayoutNodeMeasurement(content[i5]);
                i5++;
            } while (i5 < size);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0082 A[LOOP:0: B:20:0x004c->B:35:0x0082, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0085 A[EDGE_INSN: B:36:0x0085->B:39:0x0085 BREAK  A[LOOP:0: B:20:0x004c->B:35:0x0082], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isBadMotionEvent(MotionEvent event) {
        boolean z5;
        float x5 = event.getX();
        if (!Float.isInfinite(x5) && !Float.isNaN(x5)) {
            float y5 = event.getY();
            if (!Float.isInfinite(y5) && !Float.isNaN(y5)) {
                float rawX = event.getRawX();
                if (!Float.isInfinite(rawX) && !Float.isNaN(rawX)) {
                    float rawY = event.getRawY();
                    if (!Float.isInfinite(rawY) && !Float.isNaN(rawY)) {
                        z5 = false;
                        if (!z5) {
                            int pointerCount = event.getPointerCount();
                            for (int i5 = 1; i5 < pointerCount; i5++) {
                                float x6 = event.getX(i5);
                                if (!Float.isInfinite(x6) && !Float.isNaN(x6)) {
                                    float y6 = event.getY(i5);
                                    if (!Float.isInfinite(y6) && !Float.isNaN(y6) && (Build.VERSION.SDK_INT < 29 || MotionEventVerifierApi29.INSTANCE.isValidMotionEvent(event, i5))) {
                                        z5 = false;
                                        if (!z5) {
                                            break;
                                        }
                                    }
                                }
                                z5 = true;
                                if (!z5) {
                                }
                            }
                        }
                        return z5;
                    }
                }
            }
        }
        z5 = true;
        if (!z5) {
        }
        return z5;
    }

    private final boolean isDevicePressEvent(MotionEvent event) {
        int actionMasked;
        return event.getButtonState() != 0 || (actionMasked = event.getActionMasked()) == 0 || actionMasked == 2 || actionMasked == 6;
    }

    private final boolean isInBounds(MotionEvent motionEvent) {
        float x5 = motionEvent.getX();
        float y5 = motionEvent.getY();
        return 0.0f <= x5 && x5 <= ((float) getWidth()) && 0.0f <= y5 && y5 <= ((float) getHeight());
    }

    private final boolean isPositionChanged(MotionEvent event) {
        MotionEvent motionEvent;
        return (event.getPointerCount() == 1 && (motionEvent = this.previousMotionEvent) != null && motionEvent.getPointerCount() == event.getPointerCount() && event.getRawX() == motionEvent.getRawX() && event.getRawY() == motionEvent.getRawY()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClearFocusForOwner() {
        if (isFocused() || hasFocus()) {
            super.clearFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect onFetchFocusRect() {
        if (isFocused()) {
            return getFocusOwner().getFocusRect();
        }
        View findFocus = findFocus();
        if (findFocus != null) {
            return FocusInteropUtils_androidKt.calculateBoundingRect(findFocus);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onMoveFocusInChildren-3ESFkO8, reason: not valid java name */
    public final boolean m2100onMoveFocusInChildren3ESFkO8(int focusDirection) {
        FocusDirection.Companion companion = FocusDirection.INSTANCE;
        if (FocusDirection.m1275equalsimpl0(focusDirection, companion.m1280getEnterdhqQ8s()) || FocusDirection.m1275equalsimpl0(focusDirection, companion.m1281getExitdhqQ8s())) {
            return false;
        }
        Integer m1287toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m1287toAndroidFocusDirection3ESFkO8(focusDirection);
        if (m1287toAndroidFocusDirection3ESFkO8 == null) {
            throw new IllegalStateException("Invalid focus direction");
        }
        int intValue = m1287toAndroidFocusDirection3ESFkO8.intValue();
        Rect onFetchFocusRect = onFetchFocusRect();
        android.graphics.Rect androidRect = onFetchFocusRect != null ? RectHelper_androidKt.toAndroidRect(onFetchFocusRect) : null;
        FocusFinder focusFinder = FocusFinder.getInstance();
        View findNextFocus = androidRect == null ? focusFinder.findNextFocus(this, findFocus(), intValue) : focusFinder.findNextFocusFromRect(this, androidRect, intValue);
        if (findNextFocus != null) {
            return FocusInteropUtils_androidKt.requestInteropFocus(findNextFocus, Integer.valueOf(intValue), androidRect);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onRequestFocusForOwner-7o62pno, reason: not valid java name */
    public final boolean m2101onRequestFocusForOwner7o62pno(FocusDirection focusDirection, Rect previouslyFocusedRect) {
        Integer m1287toAndroidFocusDirection3ESFkO8;
        if (isFocused() || hasFocus()) {
            return true;
        }
        return super.requestFocus((focusDirection == null || (m1287toAndroidFocusDirection3ESFkO8 = FocusInteropUtils_androidKt.m1287toAndroidFocusDirection3ESFkO8(focusDirection.getValue())) == null) ? 130 : m1287toAndroidFocusDirection3ESFkO8.intValue(), previouslyFocusedRect != null ? RectHelper_androidKt.toAndroidRect(previouslyFocusedRect) : null);
    }

    /* renamed from: pack-ZIaKswc, reason: not valid java name */
    private final long m2102packZIaKswc(int a5, int b5) {
        return ULong.m3622constructorimpl(ULong.m3622constructorimpl(b5) | ULong.m3622constructorimpl(ULong.m3622constructorimpl(a5) << 32));
    }

    private final void recalculateWindowPosition() {
        if (this.forceUseMatrixCache) {
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (currentAnimationTimeMillis != this.lastMatrixRecalculationAnimationTime) {
            this.lastMatrixRecalculationAnimationTime = currentAnimationTimeMillis;
            recalculateWindowViewTransforms();
            ViewParent parent = getParent();
            View view = this;
            while (parent instanceof ViewGroup) {
                view = (View) parent;
                parent = ((ViewGroup) view).getParent();
            }
            view.getLocationOnScreen(this.tmpPositionArray);
            int[] iArr = this.tmpPositionArray;
            float f5 = iArr[0];
            float f6 = iArr[1];
            view.getLocationInWindow(iArr);
            int[] iArr2 = this.tmpPositionArray;
            this.windowPosition = OffsetKt.Offset(f5 - iArr2[0], f6 - iArr2[1]);
        }
    }

    private final void recalculateWindowViewTransforms() {
        this.matrixToWindow.mo2118calculateMatrixToWindowEL8BTi8(this, this.viewToWindowMatrix);
        InvertMatrixKt.m2138invertToJiSxe2E(this.viewToWindowMatrix, this.windowToViewMatrix);
    }

    private final void scheduleMeasureAndLayout(LayoutNode nodeToRemeasure) {
        if (isLayoutRequested() || !isAttachedToWindow()) {
            return;
        }
        if (nodeToRemeasure != null) {
            while (nodeToRemeasure != null && nodeToRemeasure.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock && childSizeCanAffectParentSize(nodeToRemeasure)) {
                nodeToRemeasure = nodeToRemeasure.getParent$ui_release();
            }
            if (nodeToRemeasure == getRoot()) {
                requestLayout();
                return;
            }
        }
        if (getWidth() == 0 || getHeight() == 0) {
            requestLayout();
        } else {
            invalidate();
        }
    }

    static /* synthetic */ void scheduleMeasureAndLayout$default(AndroidComposeView androidComposeView, LayoutNode layoutNode, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            layoutNode = null;
        }
        androidComposeView.scheduleMeasureAndLayout(layoutNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendHoverExitEvent$lambda$8(AndroidComposeView androidComposeView) {
        androidComposeView.hoverExitReceived = false;
        MotionEvent motionEvent = androidComposeView.previousMotionEvent;
        Intrinsics.checkNotNull(motionEvent);
        if (motionEvent.getActionMasked() != 10) {
            throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.");
        }
        androidComposeView.m2103sendMotionEvent8iAsVTc(motionEvent);
    }

    /* renamed from: sendMotionEvent-8iAsVTc, reason: not valid java name */
    private final int m2103sendMotionEvent8iAsVTc(MotionEvent motionEvent) {
        PointerInputEventData pointerInputEventData;
        if (this.keyboardModifiersRequireUpdate) {
            this.keyboardModifiersRequireUpdate = false;
            this._windowInfo.m2153setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m1898constructorimpl(motionEvent.getMetaState()));
        }
        PointerInputEvent convertToPointerInputEvent$ui_release = this.motionEventAdapter.convertToPointerInputEvent$ui_release(motionEvent, this);
        if (convertToPointerInputEvent$ui_release == null) {
            this.pointerInputEventProcessor.processCancel();
            return PointerInputEventProcessorKt.ProcessResult(false, false);
        }
        List<PointerInputEventData> pointers = convertToPointerInputEvent$ui_release.getPointers();
        int size = pointers.size() - 1;
        if (size >= 0) {
            while (true) {
                int i5 = size - 1;
                pointerInputEventData = pointers.get(size);
                if (pointerInputEventData.getDown()) {
                    break;
                }
                if (i5 < 0) {
                    break;
                }
                size = i5;
            }
        }
        pointerInputEventData = null;
        PointerInputEventData pointerInputEventData2 = pointerInputEventData;
        if (pointerInputEventData2 != null) {
            this.lastDownPointerPosition = pointerInputEventData2.getPosition();
        }
        int m1892processBIzXfog = this.pointerInputEventProcessor.m1892processBIzXfog(convertToPointerInputEvent$ui_release, this, isInBounds(motionEvent));
        int actionMasked = motionEvent.getActionMasked();
        if ((actionMasked != 0 && actionMasked != 5) || ProcessResult.m1917getDispatchedToAPointerInputModifierimpl(m1892processBIzXfog)) {
            return m1892processBIzXfog;
        }
        this.motionEventAdapter.endStream(motionEvent.getPointerId(motionEvent.getActionIndex()));
        return m1892processBIzXfog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendSimulatedEvent(MotionEvent motionEvent, int action, long eventTime, boolean forceHover) {
        int actionMasked = motionEvent.getActionMasked();
        int i5 = -1;
        if (actionMasked != 1) {
            if (actionMasked == 6) {
                i5 = motionEvent.getActionIndex();
            }
        } else if (action != 9 && action != 10) {
            i5 = 0;
        }
        int pointerCount = motionEvent.getPointerCount() - (i5 >= 0 ? 1 : 0);
        if (pointerCount == 0) {
            return;
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        for (int i6 = 0; i6 < pointerCount; i6++) {
            pointerPropertiesArr[i6] = new MotionEvent.PointerProperties();
        }
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i7 = 0; i7 < pointerCount; i7++) {
            pointerCoordsArr[i7] = new MotionEvent.PointerCoords();
        }
        int i8 = 0;
        while (i8 < pointerCount) {
            int i9 = ((i5 < 0 || i8 < i5) ? 0 : 1) + i8;
            motionEvent.getPointerProperties(i9, pointerPropertiesArr[i8]);
            MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[i8];
            motionEvent.getPointerCoords(i9, pointerCoords);
            long mo1913localToScreenMKHz9U = mo1913localToScreenMKHz9U(OffsetKt.Offset(pointerCoords.x, pointerCoords.y));
            pointerCoords.x = Offset.m1337getXimpl(mo1913localToScreenMKHz9U);
            pointerCoords.y = Offset.m1338getYimpl(mo1913localToScreenMKHz9U);
            i8++;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent.getDownTime() == motionEvent.getEventTime() ? eventTime : motionEvent.getDownTime(), eventTime, action, pointerCount, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), forceHover ? 0 : motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        PointerInputEvent convertToPointerInputEvent$ui_release = this.motionEventAdapter.convertToPointerInputEvent$ui_release(obtain, this);
        Intrinsics.checkNotNull(convertToPointerInputEvent$ui_release);
        this.pointerInputEventProcessor.m1892processBIzXfog(convertToPointerInputEvent$ui_release, this, true);
        obtain.recycle();
    }

    static /* synthetic */ void sendSimulatedEvent$default(AndroidComposeView androidComposeView, MotionEvent motionEvent, int i5, long j5, boolean z5, int i6, Object obj) {
        if ((i6 & 8) != 0) {
            z5 = true;
        }
        androidComposeView.sendSimulatedEvent(motionEvent, i5, j5, z5);
    }

    private void setDensity(Density density) {
        this.density.setValue(density);
    }

    private void setFontFamilyResolver(FontFamily.Resolver resolver) {
        this.fontFamilyResolver.setValue(resolver);
    }

    private void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection.setValue(layoutDirection);
    }

    private final void set_viewTreeOwners(ViewTreeOwners viewTreeOwners) {
        this._viewTreeOwners.setValue(viewTreeOwners);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startDrag-12SF9DM, reason: not valid java name */
    public final boolean m2104startDrag12SF9DM(DragAndDropTransferData transferData, long decorationSize, Function1<? super DrawScope, Unit> drawDragDecoration) {
        Resources resources = getContext().getResources();
        return AndroidComposeViewStartDragAndDropN.INSTANCE.startDragAndDrop(this, transferData, new ComposeDragShadowBuilder(DensityKt.Density(resources.getDisplayMetrics().density, resources.getConfiguration().fontScale), decorationSize, drawDragDecoration, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void touchModeChangeListener$lambda$6(AndroidComposeView androidComposeView, boolean z5) {
        androidComposeView._inputModeManager.m1795setInputModeiuPiT84(z5 ? InputMode.INSTANCE.m1793getTouchaOaMEAU() : InputMode.INSTANCE.m1792getKeyboardaOaMEAU());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePositionCacheAndDispatch() {
        getLocationOnScreen(this.tmpPositionArray);
        long j5 = this.globalPosition;
        int m2640getXimpl = IntOffset.m2640getXimpl(j5);
        int m2641getYimpl = IntOffset.m2641getYimpl(j5);
        int[] iArr = this.tmpPositionArray;
        boolean z5 = false;
        int i5 = iArr[0];
        if (m2640getXimpl != i5 || m2641getYimpl != iArr[1]) {
            this.globalPosition = IntOffsetKt.IntOffset(i5, iArr[1]);
            if (m2640getXimpl != Integer.MAX_VALUE && m2641getYimpl != Integer.MAX_VALUE) {
                getRoot().getLayoutDelegate().getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
                z5 = true;
            }
        }
        this.measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z5);
    }

    public final void addAndroidView(AndroidViewHolder view, final LayoutNode layoutNode) {
        getAndroidViewsHandler$ui_release().getHolderToLayoutNode().put(view, layoutNode);
        getAndroidViewsHandler$ui_release().addView(view);
        getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().put(layoutNode, view);
        view.setImportantForAccessibility(1);
        ViewCompat.setAccessibilityDelegate(view, new AccessibilityDelegateCompat() { // from class: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1
            /* JADX WARN: Code restructure failed: missing block: B:10:0x003c, code lost:
            
                if (r5.intValue() == r4.this$0.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) goto L13;
             */
            @Override // androidx.core.view.AccessibilityDelegateCompat
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat2;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat3;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat4;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat5;
                super.onInitializeAccessibilityNodeInfo(host, info);
                androidComposeViewAccessibilityDelegateCompat = AndroidComposeView.this.composeAccessibilityDelegate;
                if (androidComposeViewAccessibilityDelegateCompat.isEnabled$ui_release()) {
                    info.setVisibleToUser(false);
                }
                LayoutNode findClosestParentNode = SemanticsNodeKt.findClosestParentNode(layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(LayoutNode layoutNode2) {
                        return Boolean.valueOf(layoutNode2.getNodes().m2042hasH91voCI$ui_release(NodeKind.m2074constructorimpl(8)));
                    }
                });
                Integer valueOf = findClosestParentNode != null ? Integer.valueOf(findClosestParentNode.getSemanticsId()) : null;
                if (valueOf != null) {
                }
                valueOf = -1;
                info.setParent(this, valueOf.intValue());
                int semanticsId = layoutNode.getSemanticsId();
                androidComposeViewAccessibilityDelegateCompat2 = AndroidComposeView.this.composeAccessibilityDelegate;
                int orDefault = androidComposeViewAccessibilityDelegateCompat2.getIdToBeforeMap().getOrDefault(semanticsId, -1);
                if (orDefault != -1) {
                    View semanticsIdToView = SemanticsUtils_androidKt.semanticsIdToView(AndroidComposeView.this.getAndroidViewsHandler$ui_release(), orDefault);
                    if (semanticsIdToView != null) {
                        info.setTraversalBefore(semanticsIdToView);
                    } else {
                        info.setTraversalBefore(this, orDefault);
                    }
                    AndroidComposeView androidComposeView = AndroidComposeView.this;
                    AccessibilityNodeInfo unwrap = info.unwrap();
                    androidComposeViewAccessibilityDelegateCompat5 = AndroidComposeView.this.composeAccessibilityDelegate;
                    androidComposeView.addExtraDataToAccessibilityNodeInfoHelper(semanticsId, unwrap, androidComposeViewAccessibilityDelegateCompat5.getExtraDataTestTraversalBeforeVal());
                }
                androidComposeViewAccessibilityDelegateCompat3 = AndroidComposeView.this.composeAccessibilityDelegate;
                int orDefault2 = androidComposeViewAccessibilityDelegateCompat3.getIdToAfterMap().getOrDefault(semanticsId, -1);
                if (orDefault2 != -1) {
                    View semanticsIdToView2 = SemanticsUtils_androidKt.semanticsIdToView(AndroidComposeView.this.getAndroidViewsHandler$ui_release(), orDefault2);
                    if (semanticsIdToView2 != null) {
                        info.setTraversalAfter(semanticsIdToView2);
                    } else {
                        info.setTraversalAfter(this, orDefault2);
                    }
                    AndroidComposeView androidComposeView2 = AndroidComposeView.this;
                    AccessibilityNodeInfo unwrap2 = info.unwrap();
                    androidComposeViewAccessibilityDelegateCompat4 = AndroidComposeView.this.composeAccessibilityDelegate;
                    androidComposeView2.addExtraDataToAccessibilityNodeInfoHelper(semanticsId, unwrap2, androidComposeViewAccessibilityDelegateCompat4.getExtraDataTestTraversalAfterVal());
                }
            }
        });
    }

    @Override // android.view.ViewGroup
    public void addView(View child) {
        addView(child, -1);
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> values) {
        AndroidAutofill androidAutofill;
        if (!autofillSupported() || (androidAutofill = this._autofill) == null) {
            return;
        }
        AndroidAutofill_androidKt.performAutofill(androidAutofill, values);
    }

    public final Object boundsUpdatesAccessibilityEventLoop(Continuation<? super Unit> continuation) {
        Object boundsUpdatesEventLoop$ui_release = this.composeAccessibilityDelegate.boundsUpdatesEventLoop$ui_release(continuation);
        return boundsUpdatesEventLoop$ui_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? boundsUpdatesEventLoop$ui_release : Unit.INSTANCE;
    }

    public final Object boundsUpdatesContentCaptureEventLoop(Continuation<? super Unit> continuation) {
        Object boundsUpdatesEventLoop$ui_release = this.contentCaptureManager.boundsUpdatesEventLoop$ui_release(continuation);
        return boundsUpdatesEventLoop$ui_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? boundsUpdatesEventLoop$ui_release : Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: calculateLocalPosition-MK-Hz9U */
    public long mo2082calculateLocalPositionMKHz9U(long positionInWindow) {
        recalculateWindowPosition();
        return Matrix.m1550mapMKHz9U(this.windowToViewMatrix, positionInWindow);
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: calculatePositionInWindow-MK-Hz9U */
    public long mo2083calculatePositionInWindowMKHz9U(long localPosition) {
        recalculateWindowPosition();
        return Matrix.m1550mapMKHz9U(this.viewToWindowMatrix, localPosition);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int direction) {
        return this.composeAccessibilityDelegate.m2112canScroll0AR0LA0$ui_release(false, direction, this.lastDownPointerPosition);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int direction) {
        return this.composeAccessibilityDelegate.m2112canScroll0AR0LA0$ui_release(true, direction, this.lastDownPointerPosition);
    }

    @Override // androidx.compose.ui.node.Owner
    public OwnedLayer createLayer(Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock, Function0<Unit> invalidateParentLayer, GraphicsLayer explicitLayer) {
        if (explicitLayer != null) {
            return new GraphicsLayerOwnerLayer(explicitLayer, null, this, drawBlock, invalidateParentLayer);
        }
        OwnedLayer pop = this.layerCache.pop();
        if (pop != null) {
            pop.reuseLayer(drawBlock, invalidateParentLayer);
            return pop;
        }
        if (isHardwareAccelerated() && Build.VERSION.SDK_INT != 28) {
            return new GraphicsLayerOwnerLayer(getGraphicsContext().createGraphicsLayer(), getGraphicsContext(), this, drawBlock, invalidateParentLayer);
        }
        if (isHardwareAccelerated() && this.isRenderNodeCompatible) {
            try {
                return new RenderNodeLayer(this, drawBlock, invalidateParentLayer);
            } catch (Throwable unused) {
                this.isRenderNodeCompatible = false;
            }
        }
        if (this.viewLayersContainer == null) {
            ViewLayer.Companion companion = ViewLayer.INSTANCE;
            if (!companion.getHasRetrievedMethod()) {
                companion.updateDisplayList(new View(getContext()));
            }
            DrawChildContainer drawChildContainer = companion.getShouldUseDispatchDraw() ? new DrawChildContainer(getContext()) : new ViewLayerContainer(getContext());
            this.viewLayersContainer = drawChildContainer;
            addView(drawChildContainer);
        }
        DrawChildContainer drawChildContainer2 = this.viewLayersContainer;
        Intrinsics.checkNotNull(drawChildContainer2);
        return new ViewLayer(this, drawChildContainer2, drawBlock, invalidateParentLayer);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        if (!isAttachedToWindow()) {
            invalidateLayers(getRoot());
        }
        Owner.measureAndLayout$default(this, false, 1, null);
        Snapshot.INSTANCE.sendApplyNotifications();
        this.isDrawingContent = true;
        CanvasHolder canvasHolder = this.canvasHolder;
        android.graphics.Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(canvas);
        getRoot().draw$ui_release(canvasHolder.getAndroidCanvas(), null);
        canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
        if (!this.dirtyLayers.isEmpty()) {
            int size = this.dirtyLayers.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.dirtyLayers.get(i5).updateDisplayList();
            }
        }
        if (ViewLayer.INSTANCE.getShouldUseDispatchDraw()) {
            int save = canvas.save();
            canvas.clipRect(0.0f, 0.0f, 0.0f, 0.0f);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(save);
        }
        this.dirtyLayers.clear();
        this.isDrawingContent = false;
        List<OwnedLayer> list = this.postponedDirtyLayers;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            this.dirtyLayers.addAll(list);
            list.clear();
        }
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            if (motionEvent.getActionMasked() == 8) {
                this.hoverExitReceived = false;
            } else {
                this.sendHoverExitEvent.run();
            }
        }
        return motionEvent.getActionMasked() == 8 ? (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) ? super.dispatchGenericMotionEvent(motionEvent) : motionEvent.isFromSource(4194304) ? handleRotaryEvent(motionEvent) : ProcessResult.m1917getDispatchedToAPointerInputModifierimpl(m2099handleMotionEvent8iAsVTc(motionEvent)) : super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(MotionEvent event) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            this.sendHoverExitEvent.run();
        }
        if (isBadMotionEvent(event) || !isAttachedToWindow()) {
            return false;
        }
        this.composeAccessibilityDelegate.dispatchHoverEvent$ui_release(event);
        int actionMasked = event.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10 && isInBounds(event)) {
                if (event.getToolType(0) == 3 && event.getButtonState() != 0) {
                    return false;
                }
                MotionEvent motionEvent = this.previousMotionEvent;
                if (motionEvent != null) {
                    motionEvent.recycle();
                }
                this.previousMotionEvent = MotionEvent.obtainNoHistory(event);
                this.hoverExitReceived = true;
                postDelayed(this.sendHoverExitEvent, 8L);
                return false;
            }
        } else if (!isPositionChanged(event)) {
            return false;
        }
        return ProcessResult.m1917getDispatchedToAPointerInputModifierimpl(m2099handleMotionEvent8iAsVTc(event));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(final android.view.KeyEvent event) {
        if (!isFocused()) {
            return getFocusOwner().mo1292dispatchKeyEventYhN2O0w(KeyEvent.m1816constructorimpl(event), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$dispatchKeyEvent$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    boolean dispatchKeyEvent;
                    dispatchKeyEvent = super/*android.view.ViewGroup*/.dispatchKeyEvent(event);
                    return Boolean.valueOf(dispatchKeyEvent);
                }
            });
        }
        this._windowInfo.m2153setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m1898constructorimpl(event.getMetaState()));
        return FocusOwner.m1289dispatchKeyEventYhN2O0w$default(getFocusOwner(), KeyEvent.m1816constructorimpl(event), null, 2, null) || super.dispatchKeyEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(android.view.KeyEvent event) {
        return (isFocused() && getFocusOwner().mo1291dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent.m1816constructorimpl(event))) || super.dispatchKeyEventPreIme(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideStructure(ViewStructure structure) {
        if (Build.VERSION.SDK_INT < 28) {
            AndroidComposeViewAssistHelperMethodsO.INSTANCE.setClassName(structure, getView());
        } else {
            super.dispatchProvideStructure(structure);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            MotionEvent motionEvent2 = this.previousMotionEvent;
            Intrinsics.checkNotNull(motionEvent2);
            if (motionEvent.getActionMasked() != 0 || hasChangedDevices(motionEvent, motionEvent2)) {
                this.sendHoverExitEvent.run();
            } else {
                this.hoverExitReceived = false;
            }
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return false;
        }
        if (motionEvent.getActionMasked() == 2 && !isPositionChanged(motionEvent)) {
            return false;
        }
        int m2099handleMotionEvent8iAsVTc = m2099handleMotionEvent8iAsVTc(motionEvent);
        if (ProcessResult.m1916getAnyMovementConsumedimpl(m2099handleMotionEvent8iAsVTc)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return ProcessResult.m1917getDispatchedToAPointerInputModifierimpl(m2099handleMotionEvent8iAsVTc);
    }

    public final void drawAndroidView(AndroidViewHolder view, android.graphics.Canvas canvas) {
        getAndroidViewsHandler$ui_release().drawView(view, canvas);
    }

    public final View findViewByAccessibilityIdTraversal(int accessibilityId) {
        View view = null;
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                Method declaredMethod = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(this, Integer.valueOf(accessibilityId));
                if (invoke instanceof View) {
                    view = (View) invoke;
                }
            } else {
                view = findViewByAccessibilityIdRootedAtCurrentView(accessibilityId, this);
            }
        } catch (NoSuchMethodException unused) {
        }
        return view;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View focused, int direction) {
        if (focused != null) {
            Rect calculateBoundingRect = FocusInteropUtils_androidKt.calculateBoundingRect(focused);
            FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(direction);
            if (Intrinsics.areEqual(getFocusOwner().mo1293focusSearchULY8qGw(focusDirection != null ? focusDirection.getValue() : FocusDirection.INSTANCE.m1279getDowndhqQ8s(), calculateBoundingRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$focusSearch$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(FocusTargetNode focusTargetNode) {
                    return Boolean.TRUE;
                }
            }), Boolean.TRUE)) {
                return this;
            }
        }
        return super.focusSearch(focused, direction);
    }

    @Override // androidx.compose.ui.node.Owner
    public void forceMeasureTheSubtree(LayoutNode layoutNode, boolean affectsLookahead) {
        this.measureAndLayoutDelegate.forceMeasureTheSubtree(layoutNode, affectsLookahead);
    }

    public final AndroidViewsHandler getAndroidViewsHandler$ui_release() {
        if (this._androidViewsHandler == null) {
            AndroidViewsHandler androidViewsHandler = new AndroidViewsHandler(getContext());
            this._androidViewsHandler = androidViewsHandler;
            addView(androidViewsHandler);
            requestLayout();
        }
        AndroidViewsHandler androidViewsHandler2 = this._androidViewsHandler;
        Intrinsics.checkNotNull(androidViewsHandler2);
        return androidViewsHandler2;
    }

    @Override // androidx.compose.ui.node.Owner
    public Autofill getAutofill() {
        return this._autofill;
    }

    @Override // androidx.compose.ui.node.Owner
    public AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    public final Function1<Configuration, Unit> getConfigurationChangeObserver() {
        return this.configurationChangeObserver;
    }

    /* renamed from: getContentCaptureManager$ui_release, reason: from getter */
    public final AndroidContentCaptureManager getContentCaptureManager() {
        return this.contentCaptureManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.compose.ui.node.Owner
    public Density getDensity() {
        return (Density) this.density.getValue();
    }

    @Override // androidx.compose.ui.node.Owner
    public DragAndDropManager getDragAndDropManager() {
        return this.dragAndDropManager;
    }

    /* renamed from: getFocusDirection-P8AzH3I, reason: not valid java name */
    public FocusDirection m2105getFocusDirectionP8AzH3I(android.view.KeyEvent keyEvent) {
        long m1826getKeyZmokQxo = KeyEvent_androidKt.m1826getKeyZmokQxo(keyEvent);
        Key.Companion companion = Key.INSTANCE;
        if (Key.m1799equalsimpl0(m1826getKeyZmokQxo, companion.m1814getTabEK5gGoQ())) {
            return FocusDirection.m1272boximpl(KeyEvent_androidKt.m1831isShiftPressedZmokQxo(keyEvent) ? FocusDirection.INSTANCE.m1284getPreviousdhqQ8s() : FocusDirection.INSTANCE.m1283getNextdhqQ8s());
        }
        if (Key.m1799equalsimpl0(m1826getKeyZmokQxo, companion.m1807getDirectionRightEK5gGoQ())) {
            return FocusDirection.m1272boximpl(FocusDirection.INSTANCE.m1285getRightdhqQ8s());
        }
        if (Key.m1799equalsimpl0(m1826getKeyZmokQxo, companion.m1806getDirectionLeftEK5gGoQ())) {
            return FocusDirection.m1272boximpl(FocusDirection.INSTANCE.m1282getLeftdhqQ8s());
        }
        if (Key.m1799equalsimpl0(m1826getKeyZmokQxo, companion.m1808getDirectionUpEK5gGoQ()) ? true : Key.m1799equalsimpl0(m1826getKeyZmokQxo, companion.m1813getPageUpEK5gGoQ())) {
            return FocusDirection.m1272boximpl(FocusDirection.INSTANCE.m1286getUpdhqQ8s());
        }
        if (Key.m1799equalsimpl0(m1826getKeyZmokQxo, companion.m1805getDirectionDownEK5gGoQ()) ? true : Key.m1799equalsimpl0(m1826getKeyZmokQxo, companion.m1812getPageDownEK5gGoQ())) {
            return FocusDirection.m1272boximpl(FocusDirection.INSTANCE.m1279getDowndhqQ8s());
        }
        if (Key.m1799equalsimpl0(m1826getKeyZmokQxo, companion.m1804getDirectionCenterEK5gGoQ()) ? true : Key.m1799equalsimpl0(m1826getKeyZmokQxo, companion.m1809getEnterEK5gGoQ()) ? true : Key.m1799equalsimpl0(m1826getKeyZmokQxo, companion.m1811getNumPadEnterEK5gGoQ())) {
            return FocusDirection.m1272boximpl(FocusDirection.INSTANCE.m1280getEnterdhqQ8s());
        }
        if (Key.m1799equalsimpl0(m1826getKeyZmokQxo, companion.m1803getBackEK5gGoQ()) ? true : Key.m1799equalsimpl0(m1826getKeyZmokQxo, companion.m1810getEscapeEK5gGoQ())) {
            return FocusDirection.m1272boximpl(FocusDirection.INSTANCE.m1281getExitdhqQ8s());
        }
        return null;
    }

    @Override // androidx.compose.ui.node.Owner
    public FocusOwner getFocusOwner() {
        return this.focusOwner;
    }

    @Override // android.view.View
    public void getFocusedRect(android.graphics.Rect rect) {
        Unit unit;
        Rect onFetchFocusRect = onFetchFocusRect();
        if (onFetchFocusRect != null) {
            rect.left = Math.round(onFetchFocusRect.getLeft());
            rect.top = Math.round(onFetchFocusRect.getTop());
            rect.right = Math.round(onFetchFocusRect.getRight());
            rect.bottom = Math.round(onFetchFocusRect.getBottom());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.getFocusedRect(rect);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public FontFamily.Resolver getFontFamilyResolver() {
        return (FontFamily.Resolver) this.fontFamilyResolver.getValue();
    }

    @Override // androidx.compose.ui.node.Owner
    public Font.ResourceLoader getFontLoader() {
        return this.fontLoader;
    }

    @Override // androidx.compose.ui.node.Owner
    public GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    @Override // androidx.compose.ui.node.Owner
    public HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public boolean getHasPendingMeasureOrLayout() {
        return this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout();
    }

    @Override // androidx.compose.ui.node.Owner
    public InputModeManager getInputModeManager() {
        return this._inputModeManager;
    }

    /* renamed from: getLastMatrixRecalculationAnimationTime$ui_release, reason: from getter */
    public final long getLastMatrixRecalculationAnimationTime() {
        return this.lastMatrixRecalculationAnimationTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View, android.view.ViewParent, androidx.compose.ui.node.Owner
    public LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection.getValue();
    }

    public long getMeasureIteration() {
        return this.measureAndLayoutDelegate.getMeasureIteration();
    }

    @Override // androidx.compose.ui.node.Owner
    public ModifierLocalManager getModifierLocalManager() {
        return this.modifierLocalManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public Placeable.PlacementScope getPlacementScope() {
        return PlaceableKt.PlacementScope(this);
    }

    @Override // androidx.compose.ui.node.Owner
    public PointerIconService getPointerIconService() {
        return this.pointerIconService;
    }

    @Override // androidx.compose.ui.node.Owner
    public LayoutNode getRoot() {
        return this.root;
    }

    public RootForTest getRootForTest() {
        return this.rootForTest;
    }

    public final boolean getScrollCaptureInProgress$ui_release() {
        ScrollCapture scrollCapture;
        if (Build.VERSION.SDK_INT < 31 || (scrollCapture = this.scrollCapture) == null) {
            return false;
        }
        return scrollCapture.getScrollCaptureInProgress();
    }

    public SemanticsOwner getSemanticsOwner() {
        return this.semanticsOwner;
    }

    @Override // androidx.compose.ui.node.Owner
    public LayoutNodeDrawScope getSharedDrawScope() {
        return this.sharedDrawScope;
    }

    @Override // androidx.compose.ui.node.Owner
    public boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    @Override // androidx.compose.ui.node.Owner
    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.snapshotObserver;
    }

    @Override // androidx.compose.ui.node.Owner
    public SoftwareKeyboardController getSoftwareKeyboardController() {
        return this.softwareKeyboardController;
    }

    @Override // androidx.compose.ui.node.Owner
    public TextInputService getTextInputService() {
        return this.textInputService;
    }

    @Override // androidx.compose.ui.node.Owner
    public TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public View getView() {
        return this;
    }

    @Override // androidx.compose.ui.node.Owner
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public final ViewTreeOwners getViewTreeOwners() {
        return (ViewTreeOwners) this.viewTreeOwners.getValue();
    }

    @Override // androidx.compose.ui.node.Owner
    public WindowInfo getWindowInfo() {
        return this._windowInfo;
    }

    public void invalidateDescendants() {
        invalidateLayers(getRoot());
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    /* renamed from: localToScreen-58bKbWc */
    public void mo1912localToScreen58bKbWc(float[] localTransform) {
        recalculateWindowPosition();
        Matrix.m1558timesAssign58bKbWc(localTransform, this.viewToWindowMatrix);
        AndroidComposeView_androidKt.m2114access$preTranslatecG2Xzmc(localTransform, Offset.m1337getXimpl(this.windowPosition), Offset.m1338getYimpl(this.windowPosition), this.tmpMatrix);
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    /* renamed from: localToScreen-MK-Hz9U */
    public long mo1913localToScreenMKHz9U(long localPosition) {
        recalculateWindowPosition();
        long m1550mapMKHz9U = Matrix.m1550mapMKHz9U(this.viewToWindowMatrix, localPosition);
        return OffsetKt.Offset(Offset.m1337getXimpl(m1550mapMKHz9U) + Offset.m1337getXimpl(this.windowPosition), Offset.m1338getYimpl(m1550mapMKHz9U) + Offset.m1338getYimpl(this.windowPosition));
    }

    @Override // androidx.compose.ui.node.Owner
    public void measureAndLayout(boolean sendPointerUpdate) {
        Function0<Unit> function0;
        if (this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout() || this.measureAndLayoutDelegate.getHasPendingOnPositionedCallbacks()) {
            Trace.beginSection("AndroidOwner:measureAndLayout");
            if (sendPointerUpdate) {
                try {
                    function0 = this.resendMotionEventOnLayout;
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            } else {
                function0 = null;
            }
            if (this.measureAndLayoutDelegate.measureAndLayout(function0)) {
                requestLayout();
            }
            MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
            dispatchPendingInteropLayoutCallbacks();
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
        }
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: measureAndLayout-0kLqBqw */
    public void mo2084measureAndLayout0kLqBqw(LayoutNode layoutNode, long constraints) {
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            this.measureAndLayoutDelegate.m2037measureAndLayout0kLqBqw(layoutNode, constraints);
            if (!this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout()) {
                MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
                dispatchPendingInteropLayoutCallbacks();
            }
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final void notifyLayerIsDirty$ui_release(OwnedLayer layer, boolean isDirty) {
        if (!isDirty) {
            if (this.isDrawingContent) {
                return;
            }
            this.dirtyLayers.remove(layer);
            List<OwnedLayer> list = this.postponedDirtyLayers;
            if (list != null) {
                list.remove(layer);
                return;
            }
            return;
        }
        if (!this.isDrawingContent) {
            this.dirtyLayers.add(layer);
            return;
        }
        List list2 = this.postponedDirtyLayers;
        if (list2 == null) {
            list2 = new ArrayList();
            this.postponedDirtyLayers = list2;
        }
        list2.add(layer);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onAttach(LayoutNode node) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        LifecycleOwner lifecycleOwner2;
        AndroidAutofill androidAutofill;
        super.onAttachedToWindow();
        this._windowInfo.setWindowFocused(hasWindowFocus());
        invalidateLayoutNodeMeasurement(getRoot());
        invalidateLayers(getRoot());
        getSnapshotObserver().startObserving$ui_release();
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.register(androidAutofill);
        }
        LifecycleOwner lifecycleOwner3 = ViewTreeLifecycleOwner.get(this);
        SavedStateRegistryOwner savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get(this);
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        Lifecycle lifecycle2 = null;
        if (viewTreeOwners == null || (lifecycleOwner3 != null && savedStateRegistryOwner != null && (lifecycleOwner3 != viewTreeOwners.getLifecycleOwner() || savedStateRegistryOwner != viewTreeOwners.getLifecycleOwner()))) {
            if (lifecycleOwner3 == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
            }
            if (savedStateRegistryOwner == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
            }
            if (viewTreeOwners != null && (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                lifecycle.removeObserver(this);
            }
            lifecycleOwner3.getLifecycle().addObserver(this);
            ViewTreeOwners viewTreeOwners2 = new ViewTreeOwners(lifecycleOwner3, savedStateRegistryOwner);
            set_viewTreeOwners(viewTreeOwners2);
            Function1<? super ViewTreeOwners, Unit> function1 = this.onViewTreeOwnersAvailable;
            if (function1 != null) {
                function1.invoke(viewTreeOwners2);
            }
            this.onViewTreeOwnersAvailable = null;
        }
        this._inputModeManager.m1795setInputModeiuPiT84(isInTouchMode() ? InputMode.INSTANCE.m1793getTouchaOaMEAU() : InputMode.INSTANCE.m1792getKeyboardaOaMEAU());
        ViewTreeOwners viewTreeOwners3 = getViewTreeOwners();
        if (viewTreeOwners3 != null && (lifecycleOwner2 = viewTreeOwners3.getLifecycleOwner()) != null) {
            lifecycle2 = lifecycleOwner2.getLifecycle();
        }
        if (lifecycle2 == null) {
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("No lifecycle owner exists");
            throw new KotlinNothingValueException();
        }
        lifecycle2.addObserver(this);
        lifecycle2.addObserver(this.contentCaptureManager);
        getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().addOnTouchModeChangeListener(this.touchModeChangeListener);
        if (Build.VERSION.SDK_INT >= 31) {
            AndroidComposeViewTranslationCallbackS.INSTANCE.setViewTranslationCallback(this);
        }
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) SessionMutex.m1254getCurrentSessionimpl(this.textInputSessionMutex);
        return androidPlatformTextInputSession == null ? this.legacyTextInputServiceAndroid.getEditorHasFocus() : androidPlatformTextInputSession.isReadyForConnection();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setDensity(AndroidDensity_androidKt.Density(getContext()));
        if (getFontWeightAdjustmentCompat(newConfig) != this.currentFontWeightAdjustment) {
            this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(newConfig);
            setFontFamilyResolver(FontFamilyResolver_androidKt.createFontFamilyResolver(getContext()));
        }
        this.configurationChangeObserver.invoke(newConfig);
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        AndroidPlatformTextInputSession androidPlatformTextInputSession = (AndroidPlatformTextInputSession) SessionMutex.m1254getCurrentSessionimpl(this.textInputSessionMutex);
        return androidPlatformTextInputSession == null ? this.legacyTextInputServiceAndroid.createInputConnection(outAttrs) : androidPlatformTextInputSession.createInputConnection(outAttrs);
    }

    @Override // android.view.View
    public void onCreateVirtualViewTranslationRequests(long[] virtualIds, int[] supportedFormats, Consumer<ViewTranslationRequest> requestsCollector) {
        this.contentCaptureManager.onCreateVirtualViewTranslationRequests$ui_release(virtualIds, supportedFormats, requestsCollector);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onDetach(LayoutNode node) {
        this.measureAndLayoutDelegate.onNodeDetached(node);
        requestClearInvalidObservations();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        AndroidAutofill androidAutofill;
        LifecycleOwner lifecycleOwner;
        super.onDetachedFromWindow();
        getSnapshotObserver().stopObserving$ui_release();
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        Lifecycle lifecycle = (viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null) ? null : lifecycleOwner.getLifecycle();
        if (lifecycle == null) {
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("No lifecycle owner exists");
            throw new KotlinNothingValueException();
        }
        lifecycle.removeObserver(this.contentCaptureManager);
        lifecycle.removeObserver(this);
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.unregister(androidAutofill);
        }
        getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().removeOnTouchModeChangeListener(this.touchModeChangeListener);
        if (Build.VERSION.SDK_INT >= 31) {
            AndroidComposeViewTranslationCallbackS.INSTANCE.clearViewTranslationCallback(this);
        }
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
    }

    @Override // androidx.compose.ui.node.Owner
    public void onEndApplyChanges() {
        if (this.observationClearRequested) {
            getSnapshotObserver().clearInvalidObservations$ui_release();
            this.observationClearRequested = false;
        }
        AndroidViewsHandler androidViewsHandler = this._androidViewsHandler;
        if (androidViewsHandler != null) {
            clearChildInvalidObservations(androidViewsHandler);
        }
        while (this.endApplyChangesListeners.isNotEmpty()) {
            int size = this.endApplyChangesListeners.getSize();
            for (int i5 = 0; i5 < size; i5++) {
                Function0<Unit> function0 = this.endApplyChangesListeners.getContent()[i5];
                this.endApplyChangesListeners.set(i5, null);
                if (function0 != null) {
                    function0.invoke();
                }
            }
            this.endApplyChangesListeners.removeRange(0, size);
        }
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean gainFocus, int direction, android.graphics.Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
        if (gainFocus || hasFocus()) {
            return;
        }
        getFocusOwner().releaseFocus();
    }

    @Override // androidx.compose.ui.node.Owner
    public void onInteropViewLayoutChange(View view) {
        this.isPendingInteropViewLayoutChangeDispatch = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l5, int t5, int r5, int b5) {
        this.measureAndLayoutDelegate.measureAndLayout(this.resendMotionEventOnLayout);
        this.onMeasureConstraints = null;
        updatePositionCacheAndDispatch();
        if (this._androidViewsHandler != null) {
            getAndroidViewsHandler$ui_release().layout(0, 0, r5 - l5, b5 - t5);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void onLayoutChange(LayoutNode layoutNode) {
        this.composeAccessibilityDelegate.onLayoutChange$ui_release(layoutNode);
        this.contentCaptureManager.onLayoutChange$ui_release(layoutNode);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                invalidateLayoutNodeMeasurement(getRoot());
            }
            long m2098convertMeasureSpecI7RO_PI = m2098convertMeasureSpecI7RO_PI(widthMeasureSpec);
            int m3622constructorimpl = (int) ULong.m3622constructorimpl(m2098convertMeasureSpecI7RO_PI >>> 32);
            int m3622constructorimpl2 = (int) ULong.m3622constructorimpl(m2098convertMeasureSpecI7RO_PI & 4294967295L);
            long m2098convertMeasureSpecI7RO_PI2 = m2098convertMeasureSpecI7RO_PI(heightMeasureSpec);
            long m2585fitPrioritizingHeightZbe2FdA = Constraints.INSTANCE.m2585fitPrioritizingHeightZbe2FdA(m3622constructorimpl, m3622constructorimpl2, (int) ULong.m3622constructorimpl(m2098convertMeasureSpecI7RO_PI2 >>> 32), (int) ULong.m3622constructorimpl(4294967295L & m2098convertMeasureSpecI7RO_PI2));
            Constraints constraints = this.onMeasureConstraints;
            boolean z5 = false;
            if (constraints == null) {
                this.onMeasureConstraints = Constraints.m2567boximpl(m2585fitPrioritizingHeightZbe2FdA);
                this.wasMeasuredWithMultipleConstraints = false;
            } else {
                if (constraints != null) {
                    z5 = Constraints.m2572equalsimpl0(constraints.getValue(), m2585fitPrioritizingHeightZbe2FdA);
                }
                if (!z5) {
                    this.wasMeasuredWithMultipleConstraints = true;
                }
            }
            this.measureAndLayoutDelegate.m2038updateRootConstraintsBRTryo0(m2585fitPrioritizingHeightZbe2FdA);
            this.measureAndLayoutDelegate.measureOnly();
            setMeasuredDimension(getRoot().getWidth(), getRoot().getHeight());
            if (this._androidViewsHandler != null) {
                getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(getRoot().getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getRoot().getHeight(), 1073741824));
            }
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure structure, int flags) {
        AndroidAutofill androidAutofill;
        if (!autofillSupported() || structure == null || (androidAutofill = this._autofill) == null) {
            return;
        }
        AndroidAutofill_androidKt.populateViewStructure(androidAutofill, structure);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onRequestMeasure(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest, boolean scheduleMeasureAndLayout) {
        if (affectsLookahead) {
            if (this.measureAndLayoutDelegate.requestLookaheadRemeasure(layoutNode, forceRequest) && scheduleMeasureAndLayout) {
                scheduleMeasureAndLayout(layoutNode);
                return;
            }
            return;
        }
        if (this.measureAndLayoutDelegate.requestRemeasure(layoutNode, forceRequest) && scheduleMeasureAndLayout) {
            scheduleMeasureAndLayout(layoutNode);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void onRequestRelayout(LayoutNode layoutNode, boolean affectsLookahead, boolean forceRequest) {
        if (affectsLookahead) {
            if (this.measureAndLayoutDelegate.requestLookaheadRelayout(layoutNode, forceRequest)) {
                scheduleMeasureAndLayout$default(this, null, 1, null);
            }
        } else if (this.measureAndLayoutDelegate.requestRelayout(layoutNode, forceRequest)) {
            scheduleMeasureAndLayout$default(this, null, 1, null);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        setShowLayoutBounds(INSTANCE.getIsShowingLayoutBounds());
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        if (this.superclassInitComplete) {
            LayoutDirection layoutDirection2 = FocusInteropUtils_androidKt.toLayoutDirection(layoutDirection);
            if (layoutDirection2 == null) {
                layoutDirection2 = LayoutDirection.Ltr;
            }
            setLayoutDirection(layoutDirection2);
        }
    }

    @Override // android.view.View
    public void onScrollCaptureSearch(android.graphics.Rect localVisibleRect, Point windowOffset, Consumer<ScrollCaptureTarget> targets) {
        ScrollCapture scrollCapture;
        if (Build.VERSION.SDK_INT < 31 || (scrollCapture = this.scrollCapture) == null) {
            return;
        }
        scrollCapture.onScrollCaptureSearch(this, getSemanticsOwner(), getCoroutineContext(), targets);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onSemanticsChange() {
        this.composeAccessibilityDelegate.onSemanticsChange$ui_release();
        this.contentCaptureManager.onSemanticsChange$ui_release();
    }

    @Override // android.view.View
    public void onVirtualViewTranslationResponses(LongSparseArray<ViewTranslationResponse> response) {
        AndroidContentCaptureManager androidContentCaptureManager = this.contentCaptureManager;
        androidContentCaptureManager.onVirtualViewTranslationResponses$ui_release(androidContentCaptureManager, response);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        boolean isShowingLayoutBounds;
        this._windowInfo.setWindowFocused(hasWindowFocus);
        this.keyboardModifiersRequireUpdate = true;
        super.onWindowFocusChanged(hasWindowFocus);
        if (!hasWindowFocus || getShowLayoutBounds() == (isShowingLayoutBounds = INSTANCE.getIsShowingLayoutBounds())) {
            return;
        }
        setShowLayoutBounds(isShowingLayoutBounds);
        invalidateDescendants();
    }

    public final boolean recycle$ui_release(OwnedLayer layer) {
        if (this.viewLayersContainer != null) {
            ViewLayer.INSTANCE.getShouldUseDispatchDraw();
        }
        this.layerCache.push(layer);
        return true;
    }

    @Override // androidx.compose.ui.node.Owner
    public void registerOnEndApplyChangesListener(Function0<Unit> listener) {
        if (this.endApplyChangesListeners.contains(listener)) {
            return;
        }
        this.endApplyChangesListeners.add(listener);
    }

    public final void removeAndroidView(final AndroidViewHolder view) {
        registerOnEndApplyChangesListener(new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$removeAndroidView$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                AndroidComposeView.this.getAndroidViewsHandler$ui_release().removeViewInLayout(view);
                HashMap<LayoutNode, AndroidViewHolder> layoutNodeToHolder = AndroidComposeView.this.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder();
                TypeIntrinsics.asMutableMap(layoutNodeToHolder).remove(AndroidComposeView.this.getAndroidViewsHandler$ui_release().getHolderToLayoutNode().remove(view));
                view.setImportantForAccessibility(0);
            }
        });
    }

    public final void requestClearInvalidObservations() {
        this.observationClearRequested = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int direction, android.graphics.Rect previouslyFocusedRect) {
        if (isFocused()) {
            return true;
        }
        if (getFocusOwner().getRootState().getHasFocus()) {
            return super.requestFocus(direction, previouslyFocusedRect);
        }
        FocusDirection focusDirection = FocusInteropUtils_androidKt.toFocusDirection(direction);
        final int value = focusDirection != null ? focusDirection.getValue() : FocusDirection.INSTANCE.m1280getEnterdhqQ8s();
        Boolean mo1293focusSearchULY8qGw = getFocusOwner().mo1293focusSearchULY8qGw(value, previouslyFocusedRect != null ? RectHelper_androidKt.toComposeRect(previouslyFocusedRect) : null, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$requestFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                Boolean m1306requestFocusMxy_nc0 = FocusTransactionsKt.m1306requestFocusMxy_nc0(focusTargetNode, value);
                return Boolean.valueOf(m1306requestFocusMxy_nc0 != null ? m1306requestFocusMxy_nc0.booleanValue() : false);
            }
        });
        if (mo1293focusSearchULY8qGw != null) {
            return mo1293focusSearchULY8qGw.booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.node.Owner
    public void requestOnPositionedCallback(LayoutNode layoutNode) {
        this.measureAndLayoutDelegate.requestOnPositionedCallback(layoutNode);
        scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    /* renamed from: screenToLocal-MK-Hz9U */
    public long mo1914screenToLocalMKHz9U(long positionOnScreen) {
        recalculateWindowPosition();
        return Matrix.m1550mapMKHz9U(this.windowToViewMatrix, OffsetKt.Offset(Offset.m1337getXimpl(positionOnScreen) - Offset.m1337getXimpl(this.windowPosition), Offset.m1338getYimpl(positionOnScreen) - Offset.m1338getYimpl(this.windowPosition)));
    }

    public void setAccessibilityEventBatchIntervalMillis(long intervalMillis) {
        this.composeAccessibilityDelegate.setSendRecurringAccessibilityEventsIntervalMillis$ui_release(intervalMillis);
    }

    public final void setConfigurationChangeObserver(Function1<? super Configuration, Unit> function1) {
        this.configurationChangeObserver = function1;
    }

    public final void setContentCaptureManager$ui_release(AndroidContentCaptureManager androidContentCaptureManager) {
        this.contentCaptureManager = androidContentCaptureManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [androidx.compose.ui.Modifier$Node] */
    public void setCoroutineContext(CoroutineContext coroutineContext) {
        this.coroutineContext = coroutineContext;
        DelegatableNode head = getRoot().getNodes().getHead();
        if (head instanceof SuspendingPointerInputModifierNode) {
            ((SuspendingPointerInputModifierNode) head).resetPointerInputHandler();
        }
        int m2074constructorimpl = NodeKind.m2074constructorimpl(16);
        if (!head.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtree called on an unattached node");
        }
        Modifier.Node child = head.getNode().getChild();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(head);
        NestedVectorStack nestedVectorStack = new NestedVectorStack();
        while (requireLayoutNode != null) {
            if (child == null) {
                child = requireLayoutNode.getNodes().getHead();
            }
            if ((child.getAggregateChildKindSet() & m2074constructorimpl) != 0) {
                while (child != null) {
                    if ((child.getKindSet() & m2074constructorimpl) != 0) {
                        DelegatingNode delegatingNode = child;
                        MutableVector mutableVector = null;
                        while (delegatingNode != 0) {
                            if (delegatingNode instanceof PointerInputModifierNode) {
                                PointerInputModifierNode pointerInputModifierNode = (PointerInputModifierNode) delegatingNode;
                                if (pointerInputModifierNode instanceof SuspendingPointerInputModifierNode) {
                                    ((SuspendingPointerInputModifierNode) pointerInputModifierNode).resetPointerInputHandler();
                                }
                            } else if ((delegatingNode.getKindSet() & m2074constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                                Modifier.Node delegate = delegatingNode.getDelegate();
                                int i5 = 0;
                                delegatingNode = delegatingNode;
                                while (delegate != null) {
                                    if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                                        i5++;
                                        if (i5 == 1) {
                                            delegatingNode = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (delegatingNode != 0) {
                                                mutableVector.add(delegatingNode);
                                                delegatingNode = 0;
                                            }
                                            mutableVector.add(delegate);
                                        }
                                    }
                                    delegate = delegate.getChild();
                                    delegatingNode = delegatingNode;
                                }
                                if (i5 == 1) {
                                }
                            }
                            delegatingNode = DelegatableNodeKt.access$pop(mutableVector);
                        }
                    }
                    child = child.getChild();
                }
            }
            nestedVectorStack.push(requireLayoutNode.get_children$ui_release());
            requireLayoutNode = nestedVectorStack.isNotEmpty() ? (LayoutNode) nestedVectorStack.pop() : null;
            child = null;
        }
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long j5) {
        this.lastMatrixRecalculationAnimationTime = j5;
    }

    public final void setOnViewTreeOwnersAvailable(Function1<? super ViewTreeOwners, Unit> callback) {
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            callback.invoke(viewTreeOwners);
        }
        if (isAttachedToWindow()) {
            return;
        }
        this.onViewTreeOwnersAvailable = callback;
    }

    @Override // androidx.compose.ui.node.Owner
    public void setShowLayoutBounds(boolean z5) {
        this.showLayoutBounds = z5;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // androidx.compose.ui.node.Owner
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object textInputSession(Function2<Object, ? super Continuation<?>, ? extends Object> function2, Continuation<?> continuation) {
        AndroidComposeView$textInputSession$1 androidComposeView$textInputSession$1;
        int i5;
        if (continuation instanceof AndroidComposeView$textInputSession$1) {
            androidComposeView$textInputSession$1 = (AndroidComposeView$textInputSession$1) continuation;
            int i6 = androidComposeView$textInputSession$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                androidComposeView$textInputSession$1.label = i6 - Integer.MIN_VALUE;
                Object obj = androidComposeView$textInputSession$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = androidComposeView$textInputSession$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    AtomicReference atomicReference = this.textInputSessionMutex;
                    Function1<CoroutineScope, AndroidPlatformTextInputSession> function1 = new Function1<CoroutineScope, AndroidPlatformTextInputSession>() { // from class: androidx.compose.ui.platform.AndroidComposeView$textInputSession$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final AndroidPlatformTextInputSession invoke(CoroutineScope coroutineScope) {
                            AndroidComposeView androidComposeView = AndroidComposeView.this;
                            return new AndroidPlatformTextInputSession(androidComposeView, androidComposeView.getTextInputService(), coroutineScope);
                        }
                    };
                    androidComposeView$textInputSession$1.label = 1;
                    if (SessionMutex.m1255withSessionCancellingPreviousimpl(atomicReference, function1, function2, androidComposeView$textInputSession$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }
        androidComposeView$textInputSession$1 = new AndroidComposeView$textInputSession$1(this, continuation);
        Object obj2 = androidComposeView$textInputSession$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = androidComposeView$textInputSession$1.label;
        if (i5 != 0) {
        }
        throw new KotlinNothingValueException();
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index) {
        Intrinsics.checkNotNull(child);
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        addView(child, index, layoutParams);
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidAccessibilityManager getAccessibilityManager() {
        return this.accessibilityManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int width, int height) {
        ViewGroup.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.width = width;
        generateDefaultLayoutParams.height = height;
        Unit unit = Unit.INSTANCE;
        addView(child, -1, generateDefaultLayoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View child, ViewGroup.LayoutParams params) {
        addView(child, -1, params);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        addViewInLayout(child, index, params, true);
    }

    private final void recalculateWindowPosition(MotionEvent motionEvent) {
        this.lastMatrixRecalculationAnimationTime = AnimationUtils.currentAnimationTimeMillis();
        recalculateWindowViewTransforms();
        long m1550mapMKHz9U = Matrix.m1550mapMKHz9U(this.viewToWindowMatrix, OffsetKt.Offset(motionEvent.getX(), motionEvent.getY()));
        this.windowPosition = OffsetKt.Offset(motionEvent.getRawX() - Offset.m1337getXimpl(m1550mapMKHz9U), motionEvent.getRawY() - Offset.m1338getYimpl(m1550mapMKHz9U));
    }
}
